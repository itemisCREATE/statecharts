package org.yakindu.base.expressions.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.yakindu.base.expressions.services.ExpressionsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalExpressionsParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_FLOAT", "RULE_HEX", "RULE_STRING", "RULE_BOOL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'='", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'<<'", "'>>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'~'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'?'", "':'", "'||'", "'&&'", "'!'", "'^'", "'|'", "'&'", "'.'", "')'", "','", "'('"
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
    public static final int RULE_BOOL=9;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int RULE_HEX=7;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int RULE_INT=5;
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
    public static final int RULE_FLOAT=6;
    public static final int RULE_SL_COMMENT=11;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=8;
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
    public String getGrammarFileName() { return "../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g"; }


     
     	private ExpressionsGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ExpressionsGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:61:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:62:1: ( ruleExpression EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:63:1: ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression67);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression74); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:70:1: ruleExpression : ( ruleAssignmentExpression ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:74:2: ( ( ruleAssignmentExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:75:1: ( ruleAssignmentExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:75:1: ( ruleAssignmentExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:76:1: ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall()); 
            }
            pushFollow(FOLLOW_ruleAssignmentExpression_in_ruleExpression100);
            ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAssignmentExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:89:1: entryRuleAssignmentExpression : ruleAssignmentExpression EOF ;
    public final void entryRuleAssignmentExpression() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:90:1: ( ruleAssignmentExpression EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:91:1: ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAssignmentExpression_in_entryRuleAssignmentExpression126);
            ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentExpression133); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAssignmentExpression"


    // $ANTLR start "ruleAssignmentExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:98:1: ruleAssignmentExpression : ( ( rule__AssignmentExpression__Group__0 ) ) ;
    public final void ruleAssignmentExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:102:2: ( ( ( rule__AssignmentExpression__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:103:1: ( ( rule__AssignmentExpression__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:103:1: ( ( rule__AssignmentExpression__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:104:1: ( rule__AssignmentExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentExpressionAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:105:1: ( rule__AssignmentExpression__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:105:2: rule__AssignmentExpression__Group__0
            {
            pushFollow(FOLLOW_rule__AssignmentExpression__Group__0_in_ruleAssignmentExpression159);
            rule__AssignmentExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleConditionalExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:117:1: entryRuleConditionalExpression : ruleConditionalExpression EOF ;
    public final void entryRuleConditionalExpression() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:118:1: ( ruleConditionalExpression EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:119:1: ruleConditionalExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConditionalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression186);
            ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConditionalExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression193); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConditionalExpression"


    // $ANTLR start "ruleConditionalExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:126:1: ruleConditionalExpression : ( ( rule__ConditionalExpression__Group__0 ) ) ;
    public final void ruleConditionalExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:130:2: ( ( ( rule__ConditionalExpression__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:131:1: ( ( rule__ConditionalExpression__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:131:1: ( ( rule__ConditionalExpression__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:132:1: ( rule__ConditionalExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConditionalExpressionAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:133:1: ( rule__ConditionalExpression__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:133:2: rule__ConditionalExpression__Group__0
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group__0_in_ruleConditionalExpression219);
            rule__ConditionalExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConditionalExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConditionalExpression"


    // $ANTLR start "entryRuleLogicalOrExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:145:1: entryRuleLogicalOrExpression : ruleLogicalOrExpression EOF ;
    public final void entryRuleLogicalOrExpression() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:146:1: ( ruleLogicalOrExpression EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:147:1: ruleLogicalOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression246);
            ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalOrExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOrExpression253); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLogicalOrExpression"


    // $ANTLR start "ruleLogicalOrExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:154:1: ruleLogicalOrExpression : ( ( rule__LogicalOrExpression__Group__0 ) ) ;
    public final void ruleLogicalOrExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:158:2: ( ( ( rule__LogicalOrExpression__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:159:1: ( ( rule__LogicalOrExpression__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:159:1: ( ( rule__LogicalOrExpression__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:160:1: ( rule__LogicalOrExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalOrExpressionAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:161:1: ( rule__LogicalOrExpression__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:161:2: rule__LogicalOrExpression__Group__0
            {
            pushFollow(FOLLOW_rule__LogicalOrExpression__Group__0_in_ruleLogicalOrExpression279);
            rule__LogicalOrExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalOrExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLogicalOrExpression"


    // $ANTLR start "entryRuleLogicalAndExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:173:1: entryRuleLogicalAndExpression : ruleLogicalAndExpression EOF ;
    public final void entryRuleLogicalAndExpression() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:174:1: ( ruleLogicalAndExpression EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:175:1: ruleLogicalAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression306);
            ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalAndExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalAndExpression313); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLogicalAndExpression"


    // $ANTLR start "ruleLogicalAndExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:182:1: ruleLogicalAndExpression : ( ( rule__LogicalAndExpression__Group__0 ) ) ;
    public final void ruleLogicalAndExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:186:2: ( ( ( rule__LogicalAndExpression__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:187:1: ( ( rule__LogicalAndExpression__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:187:1: ( ( rule__LogicalAndExpression__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:188:1: ( rule__LogicalAndExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalAndExpressionAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:189:1: ( rule__LogicalAndExpression__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:189:2: rule__LogicalAndExpression__Group__0
            {
            pushFollow(FOLLOW_rule__LogicalAndExpression__Group__0_in_ruleLogicalAndExpression339);
            rule__LogicalAndExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalAndExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLogicalAndExpression"


    // $ANTLR start "entryRuleLogicalNotExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:201:1: entryRuleLogicalNotExpression : ruleLogicalNotExpression EOF ;
    public final void entryRuleLogicalNotExpression() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:202:1: ( ruleLogicalNotExpression EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:203:1: ruleLogicalNotExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalNotExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression366);
            ruleLogicalNotExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalNotExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalNotExpression373); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLogicalNotExpression"


    // $ANTLR start "ruleLogicalNotExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:210:1: ruleLogicalNotExpression : ( ( rule__LogicalNotExpression__Alternatives ) ) ;
    public final void ruleLogicalNotExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:214:2: ( ( ( rule__LogicalNotExpression__Alternatives ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:215:1: ( ( rule__LogicalNotExpression__Alternatives ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:215:1: ( ( rule__LogicalNotExpression__Alternatives ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:216:1: ( rule__LogicalNotExpression__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalNotExpressionAccess().getAlternatives()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:217:1: ( rule__LogicalNotExpression__Alternatives )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:217:2: rule__LogicalNotExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__LogicalNotExpression__Alternatives_in_ruleLogicalNotExpression399);
            rule__LogicalNotExpression__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalNotExpressionAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLogicalNotExpression"


    // $ANTLR start "entryRuleBitwiseXorExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:229:1: entryRuleBitwiseXorExpression : ruleBitwiseXorExpression EOF ;
    public final void entryRuleBitwiseXorExpression() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:230:1: ( ruleBitwiseXorExpression EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:231:1: ruleBitwiseXorExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseXorExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBitwiseXorExpression_in_entryRuleBitwiseXorExpression426);
            ruleBitwiseXorExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseXorExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseXorExpression433); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBitwiseXorExpression"


    // $ANTLR start "ruleBitwiseXorExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:238:1: ruleBitwiseXorExpression : ( ( rule__BitwiseXorExpression__Group__0 ) ) ;
    public final void ruleBitwiseXorExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:242:2: ( ( ( rule__BitwiseXorExpression__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:243:1: ( ( rule__BitwiseXorExpression__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:243:1: ( ( rule__BitwiseXorExpression__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:244:1: ( rule__BitwiseXorExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseXorExpressionAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:245:1: ( rule__BitwiseXorExpression__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:245:2: rule__BitwiseXorExpression__Group__0
            {
            pushFollow(FOLLOW_rule__BitwiseXorExpression__Group__0_in_ruleBitwiseXorExpression459);
            rule__BitwiseXorExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseXorExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBitwiseXorExpression"


    // $ANTLR start "entryRuleBitwiseOrExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:257:1: entryRuleBitwiseOrExpression : ruleBitwiseOrExpression EOF ;
    public final void entryRuleBitwiseOrExpression() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:258:1: ( ruleBitwiseOrExpression EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:259:1: ruleBitwiseOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBitwiseOrExpression_in_entryRuleBitwiseOrExpression486);
            ruleBitwiseOrExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseOrExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseOrExpression493); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBitwiseOrExpression"


    // $ANTLR start "ruleBitwiseOrExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:266:1: ruleBitwiseOrExpression : ( ( rule__BitwiseOrExpression__Group__0 ) ) ;
    public final void ruleBitwiseOrExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:270:2: ( ( ( rule__BitwiseOrExpression__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:271:1: ( ( rule__BitwiseOrExpression__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:271:1: ( ( rule__BitwiseOrExpression__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:272:1: ( rule__BitwiseOrExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseOrExpressionAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:273:1: ( rule__BitwiseOrExpression__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:273:2: rule__BitwiseOrExpression__Group__0
            {
            pushFollow(FOLLOW_rule__BitwiseOrExpression__Group__0_in_ruleBitwiseOrExpression519);
            rule__BitwiseOrExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseOrExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBitwiseOrExpression"


    // $ANTLR start "entryRuleBitwiseAndExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:285:1: entryRuleBitwiseAndExpression : ruleBitwiseAndExpression EOF ;
    public final void entryRuleBitwiseAndExpression() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:286:1: ( ruleBitwiseAndExpression EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:287:1: ruleBitwiseAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBitwiseAndExpression_in_entryRuleBitwiseAndExpression546);
            ruleBitwiseAndExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseAndExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseAndExpression553); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBitwiseAndExpression"


    // $ANTLR start "ruleBitwiseAndExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:294:1: ruleBitwiseAndExpression : ( ( rule__BitwiseAndExpression__Group__0 ) ) ;
    public final void ruleBitwiseAndExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:298:2: ( ( ( rule__BitwiseAndExpression__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:299:1: ( ( rule__BitwiseAndExpression__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:299:1: ( ( rule__BitwiseAndExpression__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:300:1: ( rule__BitwiseAndExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseAndExpressionAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:301:1: ( rule__BitwiseAndExpression__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:301:2: rule__BitwiseAndExpression__Group__0
            {
            pushFollow(FOLLOW_rule__BitwiseAndExpression__Group__0_in_ruleBitwiseAndExpression579);
            rule__BitwiseAndExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseAndExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBitwiseAndExpression"


    // $ANTLR start "entryRuleLogicalRelationExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:313:1: entryRuleLogicalRelationExpression : ruleLogicalRelationExpression EOF ;
    public final void entryRuleLogicalRelationExpression() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:314:1: ( ruleLogicalRelationExpression EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:315:1: ruleLogicalRelationExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalRelationExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalRelationExpression_in_entryRuleLogicalRelationExpression606);
            ruleLogicalRelationExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalRelationExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalRelationExpression613); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLogicalRelationExpression"


    // $ANTLR start "ruleLogicalRelationExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:322:1: ruleLogicalRelationExpression : ( ( rule__LogicalRelationExpression__Group__0 ) ) ;
    public final void ruleLogicalRelationExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:326:2: ( ( ( rule__LogicalRelationExpression__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:327:1: ( ( rule__LogicalRelationExpression__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:327:1: ( ( rule__LogicalRelationExpression__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:328:1: ( rule__LogicalRelationExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalRelationExpressionAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:329:1: ( rule__LogicalRelationExpression__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:329:2: rule__LogicalRelationExpression__Group__0
            {
            pushFollow(FOLLOW_rule__LogicalRelationExpression__Group__0_in_ruleLogicalRelationExpression639);
            rule__LogicalRelationExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalRelationExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLogicalRelationExpression"


    // $ANTLR start "entryRuleShiftExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:341:1: entryRuleShiftExpression : ruleShiftExpression EOF ;
    public final void entryRuleShiftExpression() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:342:1: ( ruleShiftExpression EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:343:1: ruleShiftExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleShiftExpression_in_entryRuleShiftExpression666);
            ruleShiftExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleShiftExpression673); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleShiftExpression"


    // $ANTLR start "ruleShiftExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:350:1: ruleShiftExpression : ( ( rule__ShiftExpression__Group__0 ) ) ;
    public final void ruleShiftExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:354:2: ( ( ( rule__ShiftExpression__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:355:1: ( ( rule__ShiftExpression__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:355:1: ( ( rule__ShiftExpression__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:356:1: ( rule__ShiftExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExpressionAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:357:1: ( rule__ShiftExpression__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:357:2: rule__ShiftExpression__Group__0
            {
            pushFollow(FOLLOW_rule__ShiftExpression__Group__0_in_ruleShiftExpression699);
            rule__ShiftExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleShiftExpression"


    // $ANTLR start "entryRuleNumericalAddSubtractExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:369:1: entryRuleNumericalAddSubtractExpression : ruleNumericalAddSubtractExpression EOF ;
    public final void entryRuleNumericalAddSubtractExpression() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:370:1: ( ruleNumericalAddSubtractExpression EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:371:1: ruleNumericalAddSubtractExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalAddSubtractExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_entryRuleNumericalAddSubtractExpression726);
            ruleNumericalAddSubtractExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalAddSubtractExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalAddSubtractExpression733); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNumericalAddSubtractExpression"


    // $ANTLR start "ruleNumericalAddSubtractExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:378:1: ruleNumericalAddSubtractExpression : ( ( rule__NumericalAddSubtractExpression__Group__0 ) ) ;
    public final void ruleNumericalAddSubtractExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:382:2: ( ( ( rule__NumericalAddSubtractExpression__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:383:1: ( ( rule__NumericalAddSubtractExpression__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:383:1: ( ( rule__NumericalAddSubtractExpression__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:384:1: ( rule__NumericalAddSubtractExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalAddSubtractExpressionAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:385:1: ( rule__NumericalAddSubtractExpression__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:385:2: rule__NumericalAddSubtractExpression__Group__0
            {
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__Group__0_in_ruleNumericalAddSubtractExpression759);
            rule__NumericalAddSubtractExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalAddSubtractExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNumericalAddSubtractExpression"


    // $ANTLR start "entryRuleNumericalMultiplyDivideExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:397:1: entryRuleNumericalMultiplyDivideExpression : ruleNumericalMultiplyDivideExpression EOF ;
    public final void entryRuleNumericalMultiplyDivideExpression() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:398:1: ( ruleNumericalMultiplyDivideExpression EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:399:1: ruleNumericalMultiplyDivideExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalMultiplyDivideExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_entryRuleNumericalMultiplyDivideExpression786);
            ruleNumericalMultiplyDivideExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalMultiplyDivideExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalMultiplyDivideExpression793); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNumericalMultiplyDivideExpression"


    // $ANTLR start "ruleNumericalMultiplyDivideExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:406:1: ruleNumericalMultiplyDivideExpression : ( ( rule__NumericalMultiplyDivideExpression__Group__0 ) ) ;
    public final void ruleNumericalMultiplyDivideExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:410:2: ( ( ( rule__NumericalMultiplyDivideExpression__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:411:1: ( ( rule__NumericalMultiplyDivideExpression__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:411:1: ( ( rule__NumericalMultiplyDivideExpression__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:412:1: ( rule__NumericalMultiplyDivideExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:413:1: ( rule__NumericalMultiplyDivideExpression__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:413:2: rule__NumericalMultiplyDivideExpression__Group__0
            {
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__Group__0_in_ruleNumericalMultiplyDivideExpression819);
            rule__NumericalMultiplyDivideExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNumericalMultiplyDivideExpression"


    // $ANTLR start "entryRuleNumericalUnaryExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:425:1: entryRuleNumericalUnaryExpression : ruleNumericalUnaryExpression EOF ;
    public final void entryRuleNumericalUnaryExpression() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:426:1: ( ruleNumericalUnaryExpression EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:427:1: ruleNumericalUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_entryRuleNumericalUnaryExpression846);
            ruleNumericalUnaryExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalUnaryExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalUnaryExpression853); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNumericalUnaryExpression"


    // $ANTLR start "ruleNumericalUnaryExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:434:1: ruleNumericalUnaryExpression : ( ( rule__NumericalUnaryExpression__Alternatives ) ) ;
    public final void ruleNumericalUnaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:438:2: ( ( ( rule__NumericalUnaryExpression__Alternatives ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:439:1: ( ( rule__NumericalUnaryExpression__Alternatives ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:439:1: ( ( rule__NumericalUnaryExpression__Alternatives ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:440:1: ( rule__NumericalUnaryExpression__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalUnaryExpressionAccess().getAlternatives()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:441:1: ( rule__NumericalUnaryExpression__Alternatives )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:441:2: rule__NumericalUnaryExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__NumericalUnaryExpression__Alternatives_in_ruleNumericalUnaryExpression879);
            rule__NumericalUnaryExpression__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalUnaryExpressionAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNumericalUnaryExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:453:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:454:1: ( rulePrimaryExpression EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:455:1: rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression906);
            rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression913); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:462:1: rulePrimaryExpression : ( ( rule__PrimaryExpression__Alternatives ) ) ;
    public final void rulePrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:466:2: ( ( ( rule__PrimaryExpression__Alternatives ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:467:1: ( ( rule__PrimaryExpression__Alternatives ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:467:1: ( ( rule__PrimaryExpression__Alternatives ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:468:1: ( rule__PrimaryExpression__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:469:1: ( rule__PrimaryExpression__Alternatives )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:469:2: rule__PrimaryExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Alternatives_in_rulePrimaryExpression939);
            rule__PrimaryExpression__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRulePrimitiveValueExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:481:1: entryRulePrimitiveValueExpression : rulePrimitiveValueExpression EOF ;
    public final void entryRulePrimitiveValueExpression() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:482:1: ( rulePrimitiveValueExpression EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:483:1: rulePrimitiveValueExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveValueExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimitiveValueExpression_in_entryRulePrimitiveValueExpression966);
            rulePrimitiveValueExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimitiveValueExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveValueExpression973); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimitiveValueExpression"


    // $ANTLR start "rulePrimitiveValueExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:490:1: rulePrimitiveValueExpression : ( ( rule__PrimitiveValueExpression__Group__0 ) ) ;
    public final void rulePrimitiveValueExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:494:2: ( ( ( rule__PrimitiveValueExpression__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:495:1: ( ( rule__PrimitiveValueExpression__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:495:1: ( ( rule__PrimitiveValueExpression__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:496:1: ( rule__PrimitiveValueExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveValueExpressionAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:497:1: ( rule__PrimitiveValueExpression__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:497:2: rule__PrimitiveValueExpression__Group__0
            {
            pushFollow(FOLLOW_rule__PrimitiveValueExpression__Group__0_in_rulePrimitiveValueExpression999);
            rule__PrimitiveValueExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimitiveValueExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimitiveValueExpression"


    // $ANTLR start "entryRuleFeatureCall"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:509:1: entryRuleFeatureCall : ruleFeatureCall EOF ;
    public final void entryRuleFeatureCall() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:510:1: ( ruleFeatureCall EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:511:1: ruleFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall1026);
            ruleFeatureCall();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCall1033); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFeatureCall"


    // $ANTLR start "ruleFeatureCall"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:518:1: ruleFeatureCall : ( ( rule__FeatureCall__Group__0 ) ) ;
    public final void ruleFeatureCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:522:2: ( ( ( rule__FeatureCall__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:523:1: ( ( rule__FeatureCall__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:523:1: ( ( rule__FeatureCall__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:524:1: ( rule__FeatureCall__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:525:1: ( rule__FeatureCall__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:525:2: rule__FeatureCall__Group__0
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group__0_in_ruleFeatureCall1059);
            rule__FeatureCall__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFeatureCall"


    // $ANTLR start "entryRuleElementReferenceExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:537:1: entryRuleElementReferenceExpression : ruleElementReferenceExpression EOF ;
    public final void entryRuleElementReferenceExpression() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:538:1: ( ruleElementReferenceExpression EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:539:1: ruleElementReferenceExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleElementReferenceExpression_in_entryRuleElementReferenceExpression1086);
            ruleElementReferenceExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getElementReferenceExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleElementReferenceExpression1093); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleElementReferenceExpression"


    // $ANTLR start "ruleElementReferenceExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:546:1: ruleElementReferenceExpression : ( ( rule__ElementReferenceExpression__Group__0 ) ) ;
    public final void ruleElementReferenceExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:550:2: ( ( ( rule__ElementReferenceExpression__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:551:1: ( ( rule__ElementReferenceExpression__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:551:1: ( ( rule__ElementReferenceExpression__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:552:1: ( rule__ElementReferenceExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:553:1: ( rule__ElementReferenceExpression__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:553:2: rule__ElementReferenceExpression__Group__0
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group__0_in_ruleElementReferenceExpression1119);
            rule__ElementReferenceExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getElementReferenceExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleElementReferenceExpression"


    // $ANTLR start "entryRuleParenthesizedExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:565:1: entryRuleParenthesizedExpression : ruleParenthesizedExpression EOF ;
    public final void entryRuleParenthesizedExpression() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:566:1: ( ruleParenthesizedExpression EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:567:1: ruleParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression1146);
            ruleParenthesizedExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParenthesizedExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression1153); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParenthesizedExpression"


    // $ANTLR start "ruleParenthesizedExpression"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:574:1: ruleParenthesizedExpression : ( ( rule__ParenthesizedExpression__Group__0 ) ) ;
    public final void ruleParenthesizedExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:578:2: ( ( ( rule__ParenthesizedExpression__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:579:1: ( ( rule__ParenthesizedExpression__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:579:1: ( ( rule__ParenthesizedExpression__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:580:1: ( rule__ParenthesizedExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParenthesizedExpressionAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:581:1: ( rule__ParenthesizedExpression__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:581:2: rule__ParenthesizedExpression__Group__0
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__0_in_ruleParenthesizedExpression1179);
            rule__ParenthesizedExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParenthesizedExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParenthesizedExpression"


    // $ANTLR start "entryRuleLiteral"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:593:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:594:1: ( ruleLiteral EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:595:1: ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral1206);
            ruleLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral1213); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:602:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:606:2: ( ( ( rule__Literal__Alternatives ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:607:1: ( ( rule__Literal__Alternatives ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:607:1: ( ( rule__Literal__Alternatives ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:608:1: ( rule__Literal__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getAlternatives()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:609:1: ( rule__Literal__Alternatives )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:609:2: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_rule__Literal__Alternatives_in_ruleLiteral1239);
            rule__Literal__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleIntLiteral"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:623:1: entryRuleIntLiteral : ruleIntLiteral EOF ;
    public final void entryRuleIntLiteral() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:624:1: ( ruleIntLiteral EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:625:1: ruleIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral1268);
            ruleIntLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntLiteralRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral1275); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntLiteral"


    // $ANTLR start "ruleIntLiteral"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:632:1: ruleIntLiteral : ( ( rule__IntLiteral__Group__0 ) ) ;
    public final void ruleIntLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:636:2: ( ( ( rule__IntLiteral__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:637:1: ( ( rule__IntLiteral__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:637:1: ( ( rule__IntLiteral__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:638:1: ( rule__IntLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:639:1: ( rule__IntLiteral__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:639:2: rule__IntLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral1301);
            rule__IntLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntLiteralAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntLiteral"


    // $ANTLR start "entryRuleRealLiteral"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:651:1: entryRuleRealLiteral : ruleRealLiteral EOF ;
    public final void entryRuleRealLiteral() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:652:1: ( ruleRealLiteral EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:653:1: ruleRealLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral1328);
            ruleRealLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral1335); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRealLiteral"


    // $ANTLR start "ruleRealLiteral"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:660:1: ruleRealLiteral : ( ( rule__RealLiteral__Group__0 ) ) ;
    public final void ruleRealLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:664:2: ( ( ( rule__RealLiteral__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:665:1: ( ( rule__RealLiteral__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:665:1: ( ( rule__RealLiteral__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:666:1: ( rule__RealLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:667:1: ( rule__RealLiteral__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:667:2: rule__RealLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral1361);
            rule__RealLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRealLiteral"


    // $ANTLR start "entryRuleHexLiteral"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:679:1: entryRuleHexLiteral : ruleHexLiteral EOF ;
    public final void entryRuleHexLiteral() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:680:1: ( ruleHexLiteral EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:681:1: ruleHexLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHexLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleHexLiteral_in_entryRuleHexLiteral1388);
            ruleHexLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHexLiteralRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexLiteral1395); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHexLiteral"


    // $ANTLR start "ruleHexLiteral"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:688:1: ruleHexLiteral : ( ( rule__HexLiteral__Group__0 ) ) ;
    public final void ruleHexLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:692:2: ( ( ( rule__HexLiteral__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:693:1: ( ( rule__HexLiteral__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:693:1: ( ( rule__HexLiteral__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:694:1: ( rule__HexLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHexLiteralAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:695:1: ( rule__HexLiteral__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:695:2: rule__HexLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__HexLiteral__Group__0_in_ruleHexLiteral1421);
            rule__HexLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getHexLiteralAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHexLiteral"


    // $ANTLR start "entryRuleStringLiteral"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:707:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:708:1: ( ruleStringLiteral EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:709:1: ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral1448);
            ruleStringLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral1455); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:716:1: ruleStringLiteral : ( ( rule__StringLiteral__Group__0 ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:720:2: ( ( ( rule__StringLiteral__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:721:1: ( ( rule__StringLiteral__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:721:1: ( ( rule__StringLiteral__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:722:1: ( rule__StringLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:723:1: ( rule__StringLiteral__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:723:2: rule__StringLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral1481);
            rule__StringLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "ruleAssignmentOperator"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:736:1: ruleAssignmentOperator : ( ( rule__AssignmentOperator__Alternatives ) ) ;
    public final void ruleAssignmentOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:740:1: ( ( ( rule__AssignmentOperator__Alternatives ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:741:1: ( ( rule__AssignmentOperator__Alternatives ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:741:1: ( ( rule__AssignmentOperator__Alternatives ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:742:1: ( rule__AssignmentOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentOperatorAccess().getAlternatives()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:743:1: ( rule__AssignmentOperator__Alternatives )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:743:2: rule__AssignmentOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__AssignmentOperator__Alternatives_in_ruleAssignmentOperator1518);
            rule__AssignmentOperator__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentOperatorAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssignmentOperator"


    // $ANTLR start "ruleShiftOperator"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:755:1: ruleShiftOperator : ( ( rule__ShiftOperator__Alternatives ) ) ;
    public final void ruleShiftOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:759:1: ( ( ( rule__ShiftOperator__Alternatives ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:760:1: ( ( rule__ShiftOperator__Alternatives ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:760:1: ( ( rule__ShiftOperator__Alternatives ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:761:1: ( rule__ShiftOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftOperatorAccess().getAlternatives()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:762:1: ( rule__ShiftOperator__Alternatives )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:762:2: rule__ShiftOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__ShiftOperator__Alternatives_in_ruleShiftOperator1554);
            rule__ShiftOperator__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftOperatorAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleShiftOperator"


    // $ANTLR start "ruleAdditiveOperator"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:774:1: ruleAdditiveOperator : ( ( rule__AdditiveOperator__Alternatives ) ) ;
    public final void ruleAdditiveOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:778:1: ( ( ( rule__AdditiveOperator__Alternatives ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:779:1: ( ( rule__AdditiveOperator__Alternatives ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:779:1: ( ( rule__AdditiveOperator__Alternatives ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:780:1: ( rule__AdditiveOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveOperatorAccess().getAlternatives()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:781:1: ( rule__AdditiveOperator__Alternatives )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:781:2: rule__AdditiveOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__AdditiveOperator__Alternatives_in_ruleAdditiveOperator1590);
            rule__AdditiveOperator__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveOperatorAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAdditiveOperator"


    // $ANTLR start "ruleMultiplicativeOperator"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:793:1: ruleMultiplicativeOperator : ( ( rule__MultiplicativeOperator__Alternatives ) ) ;
    public final void ruleMultiplicativeOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:797:1: ( ( ( rule__MultiplicativeOperator__Alternatives ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:798:1: ( ( rule__MultiplicativeOperator__Alternatives ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:798:1: ( ( rule__MultiplicativeOperator__Alternatives ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:799:1: ( rule__MultiplicativeOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeOperatorAccess().getAlternatives()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:800:1: ( rule__MultiplicativeOperator__Alternatives )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:800:2: rule__MultiplicativeOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__MultiplicativeOperator__Alternatives_in_ruleMultiplicativeOperator1626);
            rule__MultiplicativeOperator__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeOperatorAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiplicativeOperator"


    // $ANTLR start "ruleUnaryOperator"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:812:1: ruleUnaryOperator : ( ( rule__UnaryOperator__Alternatives ) ) ;
    public final void ruleUnaryOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:816:1: ( ( ( rule__UnaryOperator__Alternatives ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:817:1: ( ( rule__UnaryOperator__Alternatives ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:817:1: ( ( rule__UnaryOperator__Alternatives ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:818:1: ( rule__UnaryOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryOperatorAccess().getAlternatives()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:819:1: ( rule__UnaryOperator__Alternatives )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:819:2: rule__UnaryOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__UnaryOperator__Alternatives_in_ruleUnaryOperator1662);
            rule__UnaryOperator__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnaryOperatorAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "ruleRelationalOperator"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:831:1: ruleRelationalOperator : ( ( rule__RelationalOperator__Alternatives ) ) ;
    public final void ruleRelationalOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:835:1: ( ( ( rule__RelationalOperator__Alternatives ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:836:1: ( ( rule__RelationalOperator__Alternatives ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:836:1: ( ( rule__RelationalOperator__Alternatives ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:837:1: ( rule__RelationalOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRelationalOperatorAccess().getAlternatives()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:838:1: ( rule__RelationalOperator__Alternatives )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:838:2: rule__RelationalOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__RelationalOperator__Alternatives_in_ruleRelationalOperator1698);
            rule__RelationalOperator__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRelationalOperatorAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRelationalOperator"


    // $ANTLR start "rule__LogicalNotExpression__Alternatives"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:849:1: rule__LogicalNotExpression__Alternatives : ( ( ruleBitwiseXorExpression ) | ( ( rule__LogicalNotExpression__Group_1__0 ) ) );
    public final void rule__LogicalNotExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:853:1: ( ( ruleBitwiseXorExpression ) | ( ( rule__LogicalNotExpression__Group_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_STRING)||(LA1_0>=27 && LA1_0<=28)||LA1_0==32||LA1_0==50) ) {
                alt1=1;
            }
            else if ( (LA1_0==43) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:854:1: ( ruleBitwiseXorExpression )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:854:1: ( ruleBitwiseXorExpression )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:855:1: ruleBitwiseXorExpression
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLogicalNotExpressionAccess().getBitwiseXorExpressionParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleBitwiseXorExpression_in_rule__LogicalNotExpression__Alternatives1733);
                    ruleBitwiseXorExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLogicalNotExpressionAccess().getBitwiseXorExpressionParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:860:6: ( ( rule__LogicalNotExpression__Group_1__0 ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:860:6: ( ( rule__LogicalNotExpression__Group_1__0 ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:861:1: ( rule__LogicalNotExpression__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLogicalNotExpressionAccess().getGroup_1()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:862:1: ( rule__LogicalNotExpression__Group_1__0 )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:862:2: rule__LogicalNotExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__LogicalNotExpression__Group_1__0_in_rule__LogicalNotExpression__Alternatives1750);
                    rule__LogicalNotExpression__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLogicalNotExpressionAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalNotExpression__Alternatives"


    // $ANTLR start "rule__NumericalUnaryExpression__Alternatives"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:871:1: rule__NumericalUnaryExpression__Alternatives : ( ( rulePrimaryExpression ) | ( ( rule__NumericalUnaryExpression__Group_1__0 ) ) );
    public final void rule__NumericalUnaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:875:1: ( ( rulePrimaryExpression ) | ( ( rule__NumericalUnaryExpression__Group_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=RULE_ID && LA2_0<=RULE_STRING)||LA2_0==50) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=27 && LA2_0<=28)||LA2_0==32) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:876:1: ( rulePrimaryExpression )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:876:1: ( rulePrimaryExpression )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:877:1: rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumericalUnaryExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_rule__NumericalUnaryExpression__Alternatives1783);
                    rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNumericalUnaryExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:882:6: ( ( rule__NumericalUnaryExpression__Group_1__0 ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:882:6: ( ( rule__NumericalUnaryExpression__Group_1__0 ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:883:1: ( rule__NumericalUnaryExpression__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumericalUnaryExpressionAccess().getGroup_1()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:884:1: ( rule__NumericalUnaryExpression__Group_1__0 )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:884:2: rule__NumericalUnaryExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__NumericalUnaryExpression__Group_1__0_in_rule__NumericalUnaryExpression__Alternatives1800);
                    rule__NumericalUnaryExpression__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNumericalUnaryExpressionAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalUnaryExpression__Alternatives"


    // $ANTLR start "rule__PrimaryExpression__Alternatives"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:893:1: rule__PrimaryExpression__Alternatives : ( ( rulePrimitiveValueExpression ) | ( ruleFeatureCall ) | ( ruleParenthesizedExpression ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:897:1: ( ( rulePrimitiveValueExpression ) | ( ruleFeatureCall ) | ( ruleParenthesizedExpression ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case RULE_FLOAT:
            case RULE_HEX:
            case RULE_STRING:
                {
                alt3=1;
                }
                break;
            case RULE_ID:
                {
                alt3=2;
                }
                break;
            case 50:
                {
                alt3=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:898:1: ( rulePrimitiveValueExpression )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:898:1: ( rulePrimitiveValueExpression )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:899:1: rulePrimitiveValueExpression
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpressionAccess().getPrimitiveValueExpressionParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_rulePrimitiveValueExpression_in_rule__PrimaryExpression__Alternatives1833);
                    rulePrimitiveValueExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryExpressionAccess().getPrimitiveValueExpressionParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:904:6: ( ruleFeatureCall )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:904:6: ( ruleFeatureCall )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:905:1: ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpressionAccess().getFeatureCallParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleFeatureCall_in_rule__PrimaryExpression__Alternatives1850);
                    ruleFeatureCall();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryExpressionAccess().getFeatureCallParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:910:6: ( ruleParenthesizedExpression )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:910:6: ( ruleParenthesizedExpression )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:911:1: ruleParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_rule__PrimaryExpression__Alternatives1867);
                    ruleParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Alternatives"


    // $ANTLR start "rule__Literal__Alternatives"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:921:1: rule__Literal__Alternatives : ( ( ruleIntLiteral ) | ( ruleHexLiteral ) | ( ruleRealLiteral ) | ( ruleStringLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:925:1: ( ( ruleIntLiteral ) | ( ruleHexLiteral ) | ( ruleRealLiteral ) | ( ruleStringLiteral ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt4=1;
                }
                break;
            case RULE_HEX:
                {
                alt4=2;
                }
                break;
            case RULE_FLOAT:
                {
                alt4=3;
                }
                break;
            case RULE_STRING:
                {
                alt4=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:926:1: ( ruleIntLiteral )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:926:1: ( ruleIntLiteral )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:927:1: ruleIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getIntLiteralParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleIntLiteral_in_rule__Literal__Alternatives1899);
                    ruleIntLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getIntLiteralParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:932:6: ( ruleHexLiteral )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:932:6: ( ruleHexLiteral )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:933:1: ruleHexLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getHexLiteralParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleHexLiteral_in_rule__Literal__Alternatives1916);
                    ruleHexLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getHexLiteralParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:938:6: ( ruleRealLiteral )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:938:6: ( ruleRealLiteral )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:939:1: ruleRealLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getRealLiteralParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleRealLiteral_in_rule__Literal__Alternatives1933);
                    ruleRealLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getRealLiteralParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:944:6: ( ruleStringLiteral )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:944:6: ( ruleStringLiteral )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:945:1: ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives1950);
                    ruleStringLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_3()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Alternatives"


    // $ANTLR start "rule__AssignmentOperator__Alternatives"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:955:1: rule__AssignmentOperator__Alternatives : ( ( ( '=' ) ) | ( ( '*=' ) ) | ( ( '/=' ) ) | ( ( '%=' ) ) | ( ( '+=' ) ) | ( ( '-=' ) ) | ( ( '<<=' ) ) | ( ( '>>=' ) ) | ( ( '&=' ) ) | ( ( '^=' ) ) | ( ( '|=' ) ) );
    public final void rule__AssignmentOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:959:1: ( ( ( '=' ) ) | ( ( '*=' ) ) | ( ( '/=' ) ) | ( ( '%=' ) ) | ( ( '+=' ) ) | ( ( '-=' ) ) | ( ( '<<=' ) ) | ( ( '>>=' ) ) | ( ( '&=' ) ) | ( ( '^=' ) ) | ( ( '|=' ) ) )
            int alt5=11;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt5=1;
                }
                break;
            case 15:
                {
                alt5=2;
                }
                break;
            case 16:
                {
                alt5=3;
                }
                break;
            case 17:
                {
                alt5=4;
                }
                break;
            case 18:
                {
                alt5=5;
                }
                break;
            case 19:
                {
                alt5=6;
                }
                break;
            case 20:
                {
                alt5=7;
                }
                break;
            case 21:
                {
                alt5=8;
                }
                break;
            case 22:
                {
                alt5=9;
                }
                break;
            case 23:
                {
                alt5=10;
                }
                break;
            case 24:
                {
                alt5=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:960:1: ( ( '=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:960:1: ( ( '=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:961:1: ( '=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getAssignEnumLiteralDeclaration_0()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:962:1: ( '=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:962:3: '='
                    {
                    match(input,14,FOLLOW_14_in_rule__AssignmentOperator__Alternatives1983); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getAssignEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:967:6: ( ( '*=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:967:6: ( ( '*=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:968:1: ( '*=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getMultAssignEnumLiteralDeclaration_1()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:969:1: ( '*=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:969:3: '*='
                    {
                    match(input,15,FOLLOW_15_in_rule__AssignmentOperator__Alternatives2004); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getMultAssignEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:974:6: ( ( '/=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:974:6: ( ( '/=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:975:1: ( '/=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getDivAssignEnumLiteralDeclaration_2()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:976:1: ( '/=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:976:3: '/='
                    {
                    match(input,16,FOLLOW_16_in_rule__AssignmentOperator__Alternatives2025); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getDivAssignEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:981:6: ( ( '%=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:981:6: ( ( '%=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:982:1: ( '%=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getModAssignEnumLiteralDeclaration_3()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:983:1: ( '%=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:983:3: '%='
                    {
                    match(input,17,FOLLOW_17_in_rule__AssignmentOperator__Alternatives2046); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getModAssignEnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:988:6: ( ( '+=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:988:6: ( ( '+=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:989:1: ( '+=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getAddAssignEnumLiteralDeclaration_4()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:990:1: ( '+=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:990:3: '+='
                    {
                    match(input,18,FOLLOW_18_in_rule__AssignmentOperator__Alternatives2067); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getAddAssignEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:995:6: ( ( '-=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:995:6: ( ( '-=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:996:1: ( '-=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getSubAssignEnumLiteralDeclaration_5()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:997:1: ( '-=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:997:3: '-='
                    {
                    match(input,19,FOLLOW_19_in_rule__AssignmentOperator__Alternatives2088); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getSubAssignEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1002:6: ( ( '<<=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1002:6: ( ( '<<=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1003:1: ( '<<=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getLeftShiftAssignEnumLiteralDeclaration_6()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1004:1: ( '<<=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1004:3: '<<='
                    {
                    match(input,20,FOLLOW_20_in_rule__AssignmentOperator__Alternatives2109); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getLeftShiftAssignEnumLiteralDeclaration_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1009:6: ( ( '>>=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1009:6: ( ( '>>=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1010:1: ( '>>=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getRightShiftAssignEnumLiteralDeclaration_7()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1011:1: ( '>>=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1011:3: '>>='
                    {
                    match(input,21,FOLLOW_21_in_rule__AssignmentOperator__Alternatives2130); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getRightShiftAssignEnumLiteralDeclaration_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1016:6: ( ( '&=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1016:6: ( ( '&=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1017:1: ( '&=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getAndAssignEnumLiteralDeclaration_8()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1018:1: ( '&=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1018:3: '&='
                    {
                    match(input,22,FOLLOW_22_in_rule__AssignmentOperator__Alternatives2151); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getAndAssignEnumLiteralDeclaration_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1023:6: ( ( '^=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1023:6: ( ( '^=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1024:1: ( '^=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getXorAssignEnumLiteralDeclaration_9()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1025:1: ( '^=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1025:3: '^='
                    {
                    match(input,23,FOLLOW_23_in_rule__AssignmentOperator__Alternatives2172); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getXorAssignEnumLiteralDeclaration_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1030:6: ( ( '|=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1030:6: ( ( '|=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1031:1: ( '|=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getOrAssignEnumLiteralDeclaration_10()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1032:1: ( '|=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1032:3: '|='
                    {
                    match(input,24,FOLLOW_24_in_rule__AssignmentOperator__Alternatives2193); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getOrAssignEnumLiteralDeclaration_10()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignmentOperator__Alternatives"


    // $ANTLR start "rule__ShiftOperator__Alternatives"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1042:1: rule__ShiftOperator__Alternatives : ( ( ( '<<' ) ) | ( ( '>>' ) ) );
    public final void rule__ShiftOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1046:1: ( ( ( '<<' ) ) | ( ( '>>' ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==25) ) {
                alt6=1;
            }
            else if ( (LA6_0==26) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1047:1: ( ( '<<' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1047:1: ( ( '<<' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1048:1: ( '<<' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getShiftOperatorAccess().getLeftEnumLiteralDeclaration_0()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1049:1: ( '<<' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1049:3: '<<'
                    {
                    match(input,25,FOLLOW_25_in_rule__ShiftOperator__Alternatives2229); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getShiftOperatorAccess().getLeftEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1054:6: ( ( '>>' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1054:6: ( ( '>>' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1055:1: ( '>>' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getShiftOperatorAccess().getRightEnumLiteralDeclaration_1()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1056:1: ( '>>' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1056:3: '>>'
                    {
                    match(input,26,FOLLOW_26_in_rule__ShiftOperator__Alternatives2250); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getShiftOperatorAccess().getRightEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShiftOperator__Alternatives"


    // $ANTLR start "rule__AdditiveOperator__Alternatives"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1066:1: rule__AdditiveOperator__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AdditiveOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1070:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==27) ) {
                alt7=1;
            }
            else if ( (LA7_0==28) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1071:1: ( ( '+' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1071:1: ( ( '+' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1072:1: ( '+' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1073:1: ( '+' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1073:3: '+'
                    {
                    match(input,27,FOLLOW_27_in_rule__AdditiveOperator__Alternatives2286); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1078:6: ( ( '-' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1078:6: ( ( '-' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1079:1: ( '-' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAdditiveOperatorAccess().getMinusEnumLiteralDeclaration_1()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1080:1: ( '-' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1080:3: '-'
                    {
                    match(input,28,FOLLOW_28_in_rule__AdditiveOperator__Alternatives2307); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAdditiveOperatorAccess().getMinusEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveOperator__Alternatives"


    // $ANTLR start "rule__MultiplicativeOperator__Alternatives"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1090:1: rule__MultiplicativeOperator__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplicativeOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1094:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt8=1;
                }
                break;
            case 30:
                {
                alt8=2;
                }
                break;
            case 31:
                {
                alt8=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1095:1: ( ( '*' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1095:1: ( ( '*' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1096:1: ( '*' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1097:1: ( '*' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1097:3: '*'
                    {
                    match(input,29,FOLLOW_29_in_rule__MultiplicativeOperator__Alternatives2343); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1102:6: ( ( '/' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1102:6: ( ( '/' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1103:1: ( '/' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1104:1: ( '/' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1104:3: '/'
                    {
                    match(input,30,FOLLOW_30_in_rule__MultiplicativeOperator__Alternatives2364); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1109:6: ( ( '%' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1109:6: ( ( '%' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1110:1: ( '%' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicativeOperatorAccess().getModEnumLiteralDeclaration_2()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1111:1: ( '%' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1111:3: '%'
                    {
                    match(input,31,FOLLOW_31_in_rule__MultiplicativeOperator__Alternatives2385); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicativeOperatorAccess().getModEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeOperator__Alternatives"


    // $ANTLR start "rule__UnaryOperator__Alternatives"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1121:1: rule__UnaryOperator__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '~' ) ) );
    public final void rule__UnaryOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1125:1: ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '~' ) ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt9=1;
                }
                break;
            case 28:
                {
                alt9=2;
                }
                break;
            case 32:
                {
                alt9=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1126:1: ( ( '+' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1126:1: ( ( '+' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1127:1: ( '+' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1128:1: ( '+' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1128:3: '+'
                    {
                    match(input,27,FOLLOW_27_in_rule__UnaryOperator__Alternatives2421); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1133:6: ( ( '-' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1133:6: ( ( '-' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1134:1: ( '-' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1135:1: ( '-' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1135:3: '-'
                    {
                    match(input,28,FOLLOW_28_in_rule__UnaryOperator__Alternatives2442); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1140:6: ( ( '~' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1140:6: ( ( '~' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1141:1: ( '~' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnaryOperatorAccess().getComplementEnumLiteralDeclaration_2()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1142:1: ( '~' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1142:3: '~'
                    {
                    match(input,32,FOLLOW_32_in_rule__UnaryOperator__Alternatives2463); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUnaryOperatorAccess().getComplementEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOperator__Alternatives"


    // $ANTLR start "rule__RelationalOperator__Alternatives"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1152:1: rule__RelationalOperator__Alternatives : ( ( ( '<' ) ) | ( ( '<=' ) ) | ( ( '>' ) ) | ( ( '>=' ) ) | ( ( '==' ) ) | ( ( '!=' ) ) );
    public final void rule__RelationalOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1156:1: ( ( ( '<' ) ) | ( ( '<=' ) ) | ( ( '>' ) ) | ( ( '>=' ) ) | ( ( '==' ) ) | ( ( '!=' ) ) )
            int alt10=6;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt10=1;
                }
                break;
            case 34:
                {
                alt10=2;
                }
                break;
            case 35:
                {
                alt10=3;
                }
                break;
            case 36:
                {
                alt10=4;
                }
                break;
            case 37:
                {
                alt10=5;
                }
                break;
            case 38:
                {
                alt10=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1157:1: ( ( '<' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1157:1: ( ( '<' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1158:1: ( '<' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1159:1: ( '<' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1159:3: '<'
                    {
                    match(input,33,FOLLOW_33_in_rule__RelationalOperator__Alternatives2499); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1164:6: ( ( '<=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1164:6: ( ( '<=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1165:1: ( '<=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1166:1: ( '<=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1166:3: '<='
                    {
                    match(input,34,FOLLOW_34_in_rule__RelationalOperator__Alternatives2520); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1171:6: ( ( '>' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1171:6: ( ( '>' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1172:1: ( '>' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1173:1: ( '>' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1173:3: '>'
                    {
                    match(input,35,FOLLOW_35_in_rule__RelationalOperator__Alternatives2541); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1178:6: ( ( '>=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1178:6: ( ( '>=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1179:1: ( '>=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1180:1: ( '>=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1180:3: '>='
                    {
                    match(input,36,FOLLOW_36_in_rule__RelationalOperator__Alternatives2562); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1185:6: ( ( '==' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1185:6: ( ( '==' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1186:1: ( '==' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1187:1: ( '==' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1187:3: '=='
                    {
                    match(input,37,FOLLOW_37_in_rule__RelationalOperator__Alternatives2583); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1192:6: ( ( '!=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1192:6: ( ( '!=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1193:1: ( '!=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRelationalOperatorAccess().getNotEqualsEnumLiteralDeclaration_5()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1194:1: ( '!=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1194:3: '!='
                    {
                    match(input,38,FOLLOW_38_in_rule__RelationalOperator__Alternatives2604); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRelationalOperatorAccess().getNotEqualsEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalOperator__Alternatives"


    // $ANTLR start "rule__AssignmentExpression__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1206:1: rule__AssignmentExpression__Group__0 : rule__AssignmentExpression__Group__0__Impl rule__AssignmentExpression__Group__1 ;
    public final void rule__AssignmentExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1210:1: ( rule__AssignmentExpression__Group__0__Impl rule__AssignmentExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1211:2: rule__AssignmentExpression__Group__0__Impl rule__AssignmentExpression__Group__1
            {
            pushFollow(FOLLOW_rule__AssignmentExpression__Group__0__Impl_in_rule__AssignmentExpression__Group__02637);
            rule__AssignmentExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AssignmentExpression__Group__1_in_rule__AssignmentExpression__Group__02640);
            rule__AssignmentExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignmentExpression__Group__0"


    // $ANTLR start "rule__AssignmentExpression__Group__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1218:1: rule__AssignmentExpression__Group__0__Impl : ( ruleConditionalExpression ) ;
    public final void rule__AssignmentExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1222:1: ( ( ruleConditionalExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1223:1: ( ruleConditionalExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1223:1: ( ruleConditionalExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1224:1: ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentExpressionAccess().getConditionalExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleConditionalExpression_in_rule__AssignmentExpression__Group__0__Impl2667);
            ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentExpressionAccess().getConditionalExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignmentExpression__Group__0__Impl"


    // $ANTLR start "rule__AssignmentExpression__Group__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1235:1: rule__AssignmentExpression__Group__1 : rule__AssignmentExpression__Group__1__Impl ;
    public final void rule__AssignmentExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1239:1: ( rule__AssignmentExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1240:2: rule__AssignmentExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AssignmentExpression__Group__1__Impl_in_rule__AssignmentExpression__Group__12696);
            rule__AssignmentExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignmentExpression__Group__1"


    // $ANTLR start "rule__AssignmentExpression__Group__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1246:1: rule__AssignmentExpression__Group__1__Impl : ( ( rule__AssignmentExpression__Group_1__0 )* ) ;
    public final void rule__AssignmentExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1250:1: ( ( ( rule__AssignmentExpression__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1251:1: ( ( rule__AssignmentExpression__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1251:1: ( ( rule__AssignmentExpression__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1252:1: ( rule__AssignmentExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1253:1: ( rule__AssignmentExpression__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=14 && LA11_0<=24)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1253:2: rule__AssignmentExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AssignmentExpression__Group_1__0_in_rule__AssignmentExpression__Group__1__Impl2723);
            	    rule__AssignmentExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignmentExpression__Group__1__Impl"


    // $ANTLR start "rule__AssignmentExpression__Group_1__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1267:1: rule__AssignmentExpression__Group_1__0 : rule__AssignmentExpression__Group_1__0__Impl rule__AssignmentExpression__Group_1__1 ;
    public final void rule__AssignmentExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1271:1: ( rule__AssignmentExpression__Group_1__0__Impl rule__AssignmentExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1272:2: rule__AssignmentExpression__Group_1__0__Impl rule__AssignmentExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__AssignmentExpression__Group_1__0__Impl_in_rule__AssignmentExpression__Group_1__02758);
            rule__AssignmentExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AssignmentExpression__Group_1__1_in_rule__AssignmentExpression__Group_1__02761);
            rule__AssignmentExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignmentExpression__Group_1__0"


    // $ANTLR start "rule__AssignmentExpression__Group_1__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1279:1: rule__AssignmentExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__AssignmentExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1283:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1284:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1284:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1285:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1286:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1288:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignmentExpression__Group_1__0__Impl"


    // $ANTLR start "rule__AssignmentExpression__Group_1__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1298:1: rule__AssignmentExpression__Group_1__1 : rule__AssignmentExpression__Group_1__1__Impl rule__AssignmentExpression__Group_1__2 ;
    public final void rule__AssignmentExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1302:1: ( rule__AssignmentExpression__Group_1__1__Impl rule__AssignmentExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1303:2: rule__AssignmentExpression__Group_1__1__Impl rule__AssignmentExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__AssignmentExpression__Group_1__1__Impl_in_rule__AssignmentExpression__Group_1__12819);
            rule__AssignmentExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AssignmentExpression__Group_1__2_in_rule__AssignmentExpression__Group_1__12822);
            rule__AssignmentExpression__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignmentExpression__Group_1__1"


    // $ANTLR start "rule__AssignmentExpression__Group_1__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1310:1: rule__AssignmentExpression__Group_1__1__Impl : ( ( rule__AssignmentExpression__OperatorAssignment_1_1 ) ) ;
    public final void rule__AssignmentExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1314:1: ( ( ( rule__AssignmentExpression__OperatorAssignment_1_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1315:1: ( ( rule__AssignmentExpression__OperatorAssignment_1_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1315:1: ( ( rule__AssignmentExpression__OperatorAssignment_1_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1316:1: ( rule__AssignmentExpression__OperatorAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentExpressionAccess().getOperatorAssignment_1_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1317:1: ( rule__AssignmentExpression__OperatorAssignment_1_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1317:2: rule__AssignmentExpression__OperatorAssignment_1_1
            {
            pushFollow(FOLLOW_rule__AssignmentExpression__OperatorAssignment_1_1_in_rule__AssignmentExpression__Group_1__1__Impl2849);
            rule__AssignmentExpression__OperatorAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentExpressionAccess().getOperatorAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignmentExpression__Group_1__1__Impl"


    // $ANTLR start "rule__AssignmentExpression__Group_1__2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1327:1: rule__AssignmentExpression__Group_1__2 : rule__AssignmentExpression__Group_1__2__Impl ;
    public final void rule__AssignmentExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1331:1: ( rule__AssignmentExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1332:2: rule__AssignmentExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__AssignmentExpression__Group_1__2__Impl_in_rule__AssignmentExpression__Group_1__22879);
            rule__AssignmentExpression__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignmentExpression__Group_1__2"


    // $ANTLR start "rule__AssignmentExpression__Group_1__2__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1338:1: rule__AssignmentExpression__Group_1__2__Impl : ( ( rule__AssignmentExpression__ExpressionAssignment_1_2 ) ) ;
    public final void rule__AssignmentExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1342:1: ( ( ( rule__AssignmentExpression__ExpressionAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1343:1: ( ( rule__AssignmentExpression__ExpressionAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1343:1: ( ( rule__AssignmentExpression__ExpressionAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1344:1: ( rule__AssignmentExpression__ExpressionAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentExpressionAccess().getExpressionAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1345:1: ( rule__AssignmentExpression__ExpressionAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1345:2: rule__AssignmentExpression__ExpressionAssignment_1_2
            {
            pushFollow(FOLLOW_rule__AssignmentExpression__ExpressionAssignment_1_2_in_rule__AssignmentExpression__Group_1__2__Impl2906);
            rule__AssignmentExpression__ExpressionAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentExpressionAccess().getExpressionAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignmentExpression__Group_1__2__Impl"


    // $ANTLR start "rule__ConditionalExpression__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1361:1: rule__ConditionalExpression__Group__0 : rule__ConditionalExpression__Group__0__Impl rule__ConditionalExpression__Group__1 ;
    public final void rule__ConditionalExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1365:1: ( rule__ConditionalExpression__Group__0__Impl rule__ConditionalExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1366:2: rule__ConditionalExpression__Group__0__Impl rule__ConditionalExpression__Group__1
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group__0__Impl_in_rule__ConditionalExpression__Group__02942);
            rule__ConditionalExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConditionalExpression__Group__1_in_rule__ConditionalExpression__Group__02945);
            rule__ConditionalExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__Group__0"


    // $ANTLR start "rule__ConditionalExpression__Group__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1373:1: rule__ConditionalExpression__Group__0__Impl : ( ruleLogicalOrExpression ) ;
    public final void rule__ConditionalExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1377:1: ( ( ruleLogicalOrExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1378:1: ( ruleLogicalOrExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1378:1: ( ruleLogicalOrExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1379:1: ruleLogicalOrExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConditionalExpressionAccess().getLogicalOrExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_rule__ConditionalExpression__Group__0__Impl2972);
            ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConditionalExpressionAccess().getLogicalOrExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__Group__0__Impl"


    // $ANTLR start "rule__ConditionalExpression__Group__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1390:1: rule__ConditionalExpression__Group__1 : rule__ConditionalExpression__Group__1__Impl ;
    public final void rule__ConditionalExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1394:1: ( rule__ConditionalExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1395:2: rule__ConditionalExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group__1__Impl_in_rule__ConditionalExpression__Group__13001);
            rule__ConditionalExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__Group__1"


    // $ANTLR start "rule__ConditionalExpression__Group__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1401:1: rule__ConditionalExpression__Group__1__Impl : ( ( rule__ConditionalExpression__Group_1__0 )? ) ;
    public final void rule__ConditionalExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1405:1: ( ( ( rule__ConditionalExpression__Group_1__0 )? ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1406:1: ( ( rule__ConditionalExpression__Group_1__0 )? )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1406:1: ( ( rule__ConditionalExpression__Group_1__0 )? )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1407:1: ( rule__ConditionalExpression__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConditionalExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1408:1: ( rule__ConditionalExpression__Group_1__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==39) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1408:2: rule__ConditionalExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__0_in_rule__ConditionalExpression__Group__1__Impl3028);
                    rule__ConditionalExpression__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConditionalExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__Group__1__Impl"


    // $ANTLR start "rule__ConditionalExpression__Group_1__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1422:1: rule__ConditionalExpression__Group_1__0 : rule__ConditionalExpression__Group_1__0__Impl rule__ConditionalExpression__Group_1__1 ;
    public final void rule__ConditionalExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1426:1: ( rule__ConditionalExpression__Group_1__0__Impl rule__ConditionalExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1427:2: rule__ConditionalExpression__Group_1__0__Impl rule__ConditionalExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__0__Impl_in_rule__ConditionalExpression__Group_1__03063);
            rule__ConditionalExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__1_in_rule__ConditionalExpression__Group_1__03066);
            rule__ConditionalExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__Group_1__0"


    // $ANTLR start "rule__ConditionalExpression__Group_1__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1434:1: rule__ConditionalExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__ConditionalExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1438:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1439:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1439:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1440:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1441:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1443:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__Group_1__0__Impl"


    // $ANTLR start "rule__ConditionalExpression__Group_1__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1453:1: rule__ConditionalExpression__Group_1__1 : rule__ConditionalExpression__Group_1__1__Impl rule__ConditionalExpression__Group_1__2 ;
    public final void rule__ConditionalExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1457:1: ( rule__ConditionalExpression__Group_1__1__Impl rule__ConditionalExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1458:2: rule__ConditionalExpression__Group_1__1__Impl rule__ConditionalExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__1__Impl_in_rule__ConditionalExpression__Group_1__13124);
            rule__ConditionalExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__2_in_rule__ConditionalExpression__Group_1__13127);
            rule__ConditionalExpression__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__Group_1__1"


    // $ANTLR start "rule__ConditionalExpression__Group_1__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1465:1: rule__ConditionalExpression__Group_1__1__Impl : ( '?' ) ;
    public final void rule__ConditionalExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1469:1: ( ( '?' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1470:1: ( '?' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1470:1: ( '?' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1471:1: '?'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConditionalExpressionAccess().getQuestionMarkKeyword_1_1()); 
            }
            match(input,39,FOLLOW_39_in_rule__ConditionalExpression__Group_1__1__Impl3155); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConditionalExpressionAccess().getQuestionMarkKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__Group_1__1__Impl"


    // $ANTLR start "rule__ConditionalExpression__Group_1__2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1484:1: rule__ConditionalExpression__Group_1__2 : rule__ConditionalExpression__Group_1__2__Impl rule__ConditionalExpression__Group_1__3 ;
    public final void rule__ConditionalExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1488:1: ( rule__ConditionalExpression__Group_1__2__Impl rule__ConditionalExpression__Group_1__3 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1489:2: rule__ConditionalExpression__Group_1__2__Impl rule__ConditionalExpression__Group_1__3
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__2__Impl_in_rule__ConditionalExpression__Group_1__23186);
            rule__ConditionalExpression__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__3_in_rule__ConditionalExpression__Group_1__23189);
            rule__ConditionalExpression__Group_1__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__Group_1__2"


    // $ANTLR start "rule__ConditionalExpression__Group_1__2__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1496:1: rule__ConditionalExpression__Group_1__2__Impl : ( ( rule__ConditionalExpression__TrueCaseAssignment_1_2 ) ) ;
    public final void rule__ConditionalExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1500:1: ( ( ( rule__ConditionalExpression__TrueCaseAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1501:1: ( ( rule__ConditionalExpression__TrueCaseAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1501:1: ( ( rule__ConditionalExpression__TrueCaseAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1502:1: ( rule__ConditionalExpression__TrueCaseAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConditionalExpressionAccess().getTrueCaseAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1503:1: ( rule__ConditionalExpression__TrueCaseAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1503:2: rule__ConditionalExpression__TrueCaseAssignment_1_2
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__TrueCaseAssignment_1_2_in_rule__ConditionalExpression__Group_1__2__Impl3216);
            rule__ConditionalExpression__TrueCaseAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConditionalExpressionAccess().getTrueCaseAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__Group_1__2__Impl"


    // $ANTLR start "rule__ConditionalExpression__Group_1__3"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1513:1: rule__ConditionalExpression__Group_1__3 : rule__ConditionalExpression__Group_1__3__Impl rule__ConditionalExpression__Group_1__4 ;
    public final void rule__ConditionalExpression__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1517:1: ( rule__ConditionalExpression__Group_1__3__Impl rule__ConditionalExpression__Group_1__4 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1518:2: rule__ConditionalExpression__Group_1__3__Impl rule__ConditionalExpression__Group_1__4
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__3__Impl_in_rule__ConditionalExpression__Group_1__33246);
            rule__ConditionalExpression__Group_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__4_in_rule__ConditionalExpression__Group_1__33249);
            rule__ConditionalExpression__Group_1__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__Group_1__3"


    // $ANTLR start "rule__ConditionalExpression__Group_1__3__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1525:1: rule__ConditionalExpression__Group_1__3__Impl : ( ':' ) ;
    public final void rule__ConditionalExpression__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1529:1: ( ( ':' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1530:1: ( ':' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1530:1: ( ':' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1531:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_3()); 
            }
            match(input,40,FOLLOW_40_in_rule__ConditionalExpression__Group_1__3__Impl3277); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__Group_1__3__Impl"


    // $ANTLR start "rule__ConditionalExpression__Group_1__4"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1544:1: rule__ConditionalExpression__Group_1__4 : rule__ConditionalExpression__Group_1__4__Impl ;
    public final void rule__ConditionalExpression__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1548:1: ( rule__ConditionalExpression__Group_1__4__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1549:2: rule__ConditionalExpression__Group_1__4__Impl
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__4__Impl_in_rule__ConditionalExpression__Group_1__43308);
            rule__ConditionalExpression__Group_1__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__Group_1__4"


    // $ANTLR start "rule__ConditionalExpression__Group_1__4__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1555:1: rule__ConditionalExpression__Group_1__4__Impl : ( ( rule__ConditionalExpression__FalseCaseAssignment_1_4 ) ) ;
    public final void rule__ConditionalExpression__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1559:1: ( ( ( rule__ConditionalExpression__FalseCaseAssignment_1_4 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1560:1: ( ( rule__ConditionalExpression__FalseCaseAssignment_1_4 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1560:1: ( ( rule__ConditionalExpression__FalseCaseAssignment_1_4 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1561:1: ( rule__ConditionalExpression__FalseCaseAssignment_1_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConditionalExpressionAccess().getFalseCaseAssignment_1_4()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1562:1: ( rule__ConditionalExpression__FalseCaseAssignment_1_4 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1562:2: rule__ConditionalExpression__FalseCaseAssignment_1_4
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__FalseCaseAssignment_1_4_in_rule__ConditionalExpression__Group_1__4__Impl3335);
            rule__ConditionalExpression__FalseCaseAssignment_1_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConditionalExpressionAccess().getFalseCaseAssignment_1_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__Group_1__4__Impl"


    // $ANTLR start "rule__LogicalOrExpression__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1582:1: rule__LogicalOrExpression__Group__0 : rule__LogicalOrExpression__Group__0__Impl rule__LogicalOrExpression__Group__1 ;
    public final void rule__LogicalOrExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1586:1: ( rule__LogicalOrExpression__Group__0__Impl rule__LogicalOrExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1587:2: rule__LogicalOrExpression__Group__0__Impl rule__LogicalOrExpression__Group__1
            {
            pushFollow(FOLLOW_rule__LogicalOrExpression__Group__0__Impl_in_rule__LogicalOrExpression__Group__03375);
            rule__LogicalOrExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalOrExpression__Group__1_in_rule__LogicalOrExpression__Group__03378);
            rule__LogicalOrExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalOrExpression__Group__0"


    // $ANTLR start "rule__LogicalOrExpression__Group__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1594:1: rule__LogicalOrExpression__Group__0__Impl : ( ruleLogicalAndExpression ) ;
    public final void rule__LogicalOrExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1598:1: ( ( ruleLogicalAndExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1599:1: ( ruleLogicalAndExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1599:1: ( ruleLogicalAndExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1600:1: ruleLogicalAndExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_rule__LogicalOrExpression__Group__0__Impl3405);
            ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalOrExpression__Group__0__Impl"


    // $ANTLR start "rule__LogicalOrExpression__Group__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1611:1: rule__LogicalOrExpression__Group__1 : rule__LogicalOrExpression__Group__1__Impl ;
    public final void rule__LogicalOrExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1615:1: ( rule__LogicalOrExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1616:2: rule__LogicalOrExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__LogicalOrExpression__Group__1__Impl_in_rule__LogicalOrExpression__Group__13434);
            rule__LogicalOrExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalOrExpression__Group__1"


    // $ANTLR start "rule__LogicalOrExpression__Group__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1622:1: rule__LogicalOrExpression__Group__1__Impl : ( ( rule__LogicalOrExpression__Group_1__0 )* ) ;
    public final void rule__LogicalOrExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1626:1: ( ( ( rule__LogicalOrExpression__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1627:1: ( ( rule__LogicalOrExpression__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1627:1: ( ( rule__LogicalOrExpression__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1628:1: ( rule__LogicalOrExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalOrExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1629:1: ( rule__LogicalOrExpression__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==41) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1629:2: rule__LogicalOrExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__LogicalOrExpression__Group_1__0_in_rule__LogicalOrExpression__Group__1__Impl3461);
            	    rule__LogicalOrExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalOrExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalOrExpression__Group__1__Impl"


    // $ANTLR start "rule__LogicalOrExpression__Group_1__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1643:1: rule__LogicalOrExpression__Group_1__0 : rule__LogicalOrExpression__Group_1__0__Impl rule__LogicalOrExpression__Group_1__1 ;
    public final void rule__LogicalOrExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1647:1: ( rule__LogicalOrExpression__Group_1__0__Impl rule__LogicalOrExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1648:2: rule__LogicalOrExpression__Group_1__0__Impl rule__LogicalOrExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__LogicalOrExpression__Group_1__0__Impl_in_rule__LogicalOrExpression__Group_1__03496);
            rule__LogicalOrExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalOrExpression__Group_1__1_in_rule__LogicalOrExpression__Group_1__03499);
            rule__LogicalOrExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalOrExpression__Group_1__0"


    // $ANTLR start "rule__LogicalOrExpression__Group_1__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1655:1: rule__LogicalOrExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__LogicalOrExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1659:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1660:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1660:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1661:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1662:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1664:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalOrExpression__Group_1__0__Impl"


    // $ANTLR start "rule__LogicalOrExpression__Group_1__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1674:1: rule__LogicalOrExpression__Group_1__1 : rule__LogicalOrExpression__Group_1__1__Impl rule__LogicalOrExpression__Group_1__2 ;
    public final void rule__LogicalOrExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1678:1: ( rule__LogicalOrExpression__Group_1__1__Impl rule__LogicalOrExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1679:2: rule__LogicalOrExpression__Group_1__1__Impl rule__LogicalOrExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__LogicalOrExpression__Group_1__1__Impl_in_rule__LogicalOrExpression__Group_1__13557);
            rule__LogicalOrExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalOrExpression__Group_1__2_in_rule__LogicalOrExpression__Group_1__13560);
            rule__LogicalOrExpression__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalOrExpression__Group_1__1"


    // $ANTLR start "rule__LogicalOrExpression__Group_1__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1686:1: rule__LogicalOrExpression__Group_1__1__Impl : ( '||' ) ;
    public final void rule__LogicalOrExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1690:1: ( ( '||' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1691:1: ( '||' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1691:1: ( '||' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1692:1: '||'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_1()); 
            }
            match(input,41,FOLLOW_41_in_rule__LogicalOrExpression__Group_1__1__Impl3588); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalOrExpression__Group_1__1__Impl"


    // $ANTLR start "rule__LogicalOrExpression__Group_1__2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1705:1: rule__LogicalOrExpression__Group_1__2 : rule__LogicalOrExpression__Group_1__2__Impl ;
    public final void rule__LogicalOrExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1709:1: ( rule__LogicalOrExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1710:2: rule__LogicalOrExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__LogicalOrExpression__Group_1__2__Impl_in_rule__LogicalOrExpression__Group_1__23619);
            rule__LogicalOrExpression__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalOrExpression__Group_1__2"


    // $ANTLR start "rule__LogicalOrExpression__Group_1__2__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1716:1: rule__LogicalOrExpression__Group_1__2__Impl : ( ( rule__LogicalOrExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__LogicalOrExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1720:1: ( ( ( rule__LogicalOrExpression__RightOperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1721:1: ( ( rule__LogicalOrExpression__RightOperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1721:1: ( ( rule__LogicalOrExpression__RightOperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1722:1: ( rule__LogicalOrExpression__RightOperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalOrExpressionAccess().getRightOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1723:1: ( rule__LogicalOrExpression__RightOperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1723:2: rule__LogicalOrExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__LogicalOrExpression__RightOperandAssignment_1_2_in_rule__LogicalOrExpression__Group_1__2__Impl3646);
            rule__LogicalOrExpression__RightOperandAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalOrExpressionAccess().getRightOperandAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalOrExpression__Group_1__2__Impl"


    // $ANTLR start "rule__LogicalAndExpression__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1739:1: rule__LogicalAndExpression__Group__0 : rule__LogicalAndExpression__Group__0__Impl rule__LogicalAndExpression__Group__1 ;
    public final void rule__LogicalAndExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1743:1: ( rule__LogicalAndExpression__Group__0__Impl rule__LogicalAndExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1744:2: rule__LogicalAndExpression__Group__0__Impl rule__LogicalAndExpression__Group__1
            {
            pushFollow(FOLLOW_rule__LogicalAndExpression__Group__0__Impl_in_rule__LogicalAndExpression__Group__03682);
            rule__LogicalAndExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalAndExpression__Group__1_in_rule__LogicalAndExpression__Group__03685);
            rule__LogicalAndExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalAndExpression__Group__0"


    // $ANTLR start "rule__LogicalAndExpression__Group__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1751:1: rule__LogicalAndExpression__Group__0__Impl : ( ruleLogicalNotExpression ) ;
    public final void rule__LogicalAndExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1755:1: ( ( ruleLogicalNotExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1756:1: ( ruleLogicalNotExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1756:1: ( ruleLogicalNotExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1757:1: ruleLogicalNotExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalAndExpressionAccess().getLogicalNotExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_rule__LogicalAndExpression__Group__0__Impl3712);
            ruleLogicalNotExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalAndExpressionAccess().getLogicalNotExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalAndExpression__Group__0__Impl"


    // $ANTLR start "rule__LogicalAndExpression__Group__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1768:1: rule__LogicalAndExpression__Group__1 : rule__LogicalAndExpression__Group__1__Impl ;
    public final void rule__LogicalAndExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1772:1: ( rule__LogicalAndExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1773:2: rule__LogicalAndExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__LogicalAndExpression__Group__1__Impl_in_rule__LogicalAndExpression__Group__13741);
            rule__LogicalAndExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalAndExpression__Group__1"


    // $ANTLR start "rule__LogicalAndExpression__Group__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1779:1: rule__LogicalAndExpression__Group__1__Impl : ( ( rule__LogicalAndExpression__Group_1__0 )* ) ;
    public final void rule__LogicalAndExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1783:1: ( ( ( rule__LogicalAndExpression__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1784:1: ( ( rule__LogicalAndExpression__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1784:1: ( ( rule__LogicalAndExpression__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1785:1: ( rule__LogicalAndExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalAndExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1786:1: ( rule__LogicalAndExpression__Group_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==42) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1786:2: rule__LogicalAndExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__LogicalAndExpression__Group_1__0_in_rule__LogicalAndExpression__Group__1__Impl3768);
            	    rule__LogicalAndExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalAndExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalAndExpression__Group__1__Impl"


    // $ANTLR start "rule__LogicalAndExpression__Group_1__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1800:1: rule__LogicalAndExpression__Group_1__0 : rule__LogicalAndExpression__Group_1__0__Impl rule__LogicalAndExpression__Group_1__1 ;
    public final void rule__LogicalAndExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1804:1: ( rule__LogicalAndExpression__Group_1__0__Impl rule__LogicalAndExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1805:2: rule__LogicalAndExpression__Group_1__0__Impl rule__LogicalAndExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__LogicalAndExpression__Group_1__0__Impl_in_rule__LogicalAndExpression__Group_1__03803);
            rule__LogicalAndExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalAndExpression__Group_1__1_in_rule__LogicalAndExpression__Group_1__03806);
            rule__LogicalAndExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalAndExpression__Group_1__0"


    // $ANTLR start "rule__LogicalAndExpression__Group_1__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1812:1: rule__LogicalAndExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__LogicalAndExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1816:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1817:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1817:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1818:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1819:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1821:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalAndExpression__Group_1__0__Impl"


    // $ANTLR start "rule__LogicalAndExpression__Group_1__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1831:1: rule__LogicalAndExpression__Group_1__1 : rule__LogicalAndExpression__Group_1__1__Impl rule__LogicalAndExpression__Group_1__2 ;
    public final void rule__LogicalAndExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1835:1: ( rule__LogicalAndExpression__Group_1__1__Impl rule__LogicalAndExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1836:2: rule__LogicalAndExpression__Group_1__1__Impl rule__LogicalAndExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__LogicalAndExpression__Group_1__1__Impl_in_rule__LogicalAndExpression__Group_1__13864);
            rule__LogicalAndExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalAndExpression__Group_1__2_in_rule__LogicalAndExpression__Group_1__13867);
            rule__LogicalAndExpression__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalAndExpression__Group_1__1"


    // $ANTLR start "rule__LogicalAndExpression__Group_1__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1843:1: rule__LogicalAndExpression__Group_1__1__Impl : ( '&&' ) ;
    public final void rule__LogicalAndExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1847:1: ( ( '&&' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1848:1: ( '&&' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1848:1: ( '&&' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1849:1: '&&'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalAndExpressionAccess().getAmpersandAmpersandKeyword_1_1()); 
            }
            match(input,42,FOLLOW_42_in_rule__LogicalAndExpression__Group_1__1__Impl3895); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalAndExpressionAccess().getAmpersandAmpersandKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalAndExpression__Group_1__1__Impl"


    // $ANTLR start "rule__LogicalAndExpression__Group_1__2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1862:1: rule__LogicalAndExpression__Group_1__2 : rule__LogicalAndExpression__Group_1__2__Impl ;
    public final void rule__LogicalAndExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1866:1: ( rule__LogicalAndExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1867:2: rule__LogicalAndExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__LogicalAndExpression__Group_1__2__Impl_in_rule__LogicalAndExpression__Group_1__23926);
            rule__LogicalAndExpression__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalAndExpression__Group_1__2"


    // $ANTLR start "rule__LogicalAndExpression__Group_1__2__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1873:1: rule__LogicalAndExpression__Group_1__2__Impl : ( ( rule__LogicalAndExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__LogicalAndExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1877:1: ( ( ( rule__LogicalAndExpression__RightOperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1878:1: ( ( rule__LogicalAndExpression__RightOperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1878:1: ( ( rule__LogicalAndExpression__RightOperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1879:1: ( rule__LogicalAndExpression__RightOperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalAndExpressionAccess().getRightOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1880:1: ( rule__LogicalAndExpression__RightOperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1880:2: rule__LogicalAndExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__LogicalAndExpression__RightOperandAssignment_1_2_in_rule__LogicalAndExpression__Group_1__2__Impl3953);
            rule__LogicalAndExpression__RightOperandAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalAndExpressionAccess().getRightOperandAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalAndExpression__Group_1__2__Impl"


    // $ANTLR start "rule__LogicalNotExpression__Group_1__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1896:1: rule__LogicalNotExpression__Group_1__0 : rule__LogicalNotExpression__Group_1__0__Impl rule__LogicalNotExpression__Group_1__1 ;
    public final void rule__LogicalNotExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1900:1: ( rule__LogicalNotExpression__Group_1__0__Impl rule__LogicalNotExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1901:2: rule__LogicalNotExpression__Group_1__0__Impl rule__LogicalNotExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__LogicalNotExpression__Group_1__0__Impl_in_rule__LogicalNotExpression__Group_1__03989);
            rule__LogicalNotExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalNotExpression__Group_1__1_in_rule__LogicalNotExpression__Group_1__03992);
            rule__LogicalNotExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalNotExpression__Group_1__0"


    // $ANTLR start "rule__LogicalNotExpression__Group_1__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1908:1: rule__LogicalNotExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__LogicalNotExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1912:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1913:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1913:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1914:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalNotExpressionAccess().getLogicalNotExpressionAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1915:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1917:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalNotExpressionAccess().getLogicalNotExpressionAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalNotExpression__Group_1__0__Impl"


    // $ANTLR start "rule__LogicalNotExpression__Group_1__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1927:1: rule__LogicalNotExpression__Group_1__1 : rule__LogicalNotExpression__Group_1__1__Impl rule__LogicalNotExpression__Group_1__2 ;
    public final void rule__LogicalNotExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1931:1: ( rule__LogicalNotExpression__Group_1__1__Impl rule__LogicalNotExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1932:2: rule__LogicalNotExpression__Group_1__1__Impl rule__LogicalNotExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__LogicalNotExpression__Group_1__1__Impl_in_rule__LogicalNotExpression__Group_1__14050);
            rule__LogicalNotExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalNotExpression__Group_1__2_in_rule__LogicalNotExpression__Group_1__14053);
            rule__LogicalNotExpression__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalNotExpression__Group_1__1"


    // $ANTLR start "rule__LogicalNotExpression__Group_1__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1939:1: rule__LogicalNotExpression__Group_1__1__Impl : ( '!' ) ;
    public final void rule__LogicalNotExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1943:1: ( ( '!' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1944:1: ( '!' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1944:1: ( '!' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1945:1: '!'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalNotExpressionAccess().getExclamationMarkKeyword_1_1()); 
            }
            match(input,43,FOLLOW_43_in_rule__LogicalNotExpression__Group_1__1__Impl4081); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalNotExpressionAccess().getExclamationMarkKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalNotExpression__Group_1__1__Impl"


    // $ANTLR start "rule__LogicalNotExpression__Group_1__2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1958:1: rule__LogicalNotExpression__Group_1__2 : rule__LogicalNotExpression__Group_1__2__Impl ;
    public final void rule__LogicalNotExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1962:1: ( rule__LogicalNotExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1963:2: rule__LogicalNotExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__LogicalNotExpression__Group_1__2__Impl_in_rule__LogicalNotExpression__Group_1__24112);
            rule__LogicalNotExpression__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalNotExpression__Group_1__2"


    // $ANTLR start "rule__LogicalNotExpression__Group_1__2__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1969:1: rule__LogicalNotExpression__Group_1__2__Impl : ( ( rule__LogicalNotExpression__OperandAssignment_1_2 ) ) ;
    public final void rule__LogicalNotExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1973:1: ( ( ( rule__LogicalNotExpression__OperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1974:1: ( ( rule__LogicalNotExpression__OperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1974:1: ( ( rule__LogicalNotExpression__OperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1975:1: ( rule__LogicalNotExpression__OperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalNotExpressionAccess().getOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1976:1: ( rule__LogicalNotExpression__OperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1976:2: rule__LogicalNotExpression__OperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__LogicalNotExpression__OperandAssignment_1_2_in_rule__LogicalNotExpression__Group_1__2__Impl4139);
            rule__LogicalNotExpression__OperandAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalNotExpressionAccess().getOperandAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalNotExpression__Group_1__2__Impl"


    // $ANTLR start "rule__BitwiseXorExpression__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1992:1: rule__BitwiseXorExpression__Group__0 : rule__BitwiseXorExpression__Group__0__Impl rule__BitwiseXorExpression__Group__1 ;
    public final void rule__BitwiseXorExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1996:1: ( rule__BitwiseXorExpression__Group__0__Impl rule__BitwiseXorExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1997:2: rule__BitwiseXorExpression__Group__0__Impl rule__BitwiseXorExpression__Group__1
            {
            pushFollow(FOLLOW_rule__BitwiseXorExpression__Group__0__Impl_in_rule__BitwiseXorExpression__Group__04175);
            rule__BitwiseXorExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitwiseXorExpression__Group__1_in_rule__BitwiseXorExpression__Group__04178);
            rule__BitwiseXorExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseXorExpression__Group__0"


    // $ANTLR start "rule__BitwiseXorExpression__Group__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2004:1: rule__BitwiseXorExpression__Group__0__Impl : ( ruleBitwiseOrExpression ) ;
    public final void rule__BitwiseXorExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2008:1: ( ( ruleBitwiseOrExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2009:1: ( ruleBitwiseOrExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2009:1: ( ruleBitwiseOrExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2010:1: ruleBitwiseOrExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseXorExpressionAccess().getBitwiseOrExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleBitwiseOrExpression_in_rule__BitwiseXorExpression__Group__0__Impl4205);
            ruleBitwiseOrExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseXorExpressionAccess().getBitwiseOrExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseXorExpression__Group__0__Impl"


    // $ANTLR start "rule__BitwiseXorExpression__Group__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2021:1: rule__BitwiseXorExpression__Group__1 : rule__BitwiseXorExpression__Group__1__Impl ;
    public final void rule__BitwiseXorExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2025:1: ( rule__BitwiseXorExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2026:2: rule__BitwiseXorExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BitwiseXorExpression__Group__1__Impl_in_rule__BitwiseXorExpression__Group__14234);
            rule__BitwiseXorExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseXorExpression__Group__1"


    // $ANTLR start "rule__BitwiseXorExpression__Group__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2032:1: rule__BitwiseXorExpression__Group__1__Impl : ( ( rule__BitwiseXorExpression__Group_1__0 )* ) ;
    public final void rule__BitwiseXorExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2036:1: ( ( ( rule__BitwiseXorExpression__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2037:1: ( ( rule__BitwiseXorExpression__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2037:1: ( ( rule__BitwiseXorExpression__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2038:1: ( rule__BitwiseXorExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseXorExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2039:1: ( rule__BitwiseXorExpression__Group_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==44) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2039:2: rule__BitwiseXorExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__BitwiseXorExpression__Group_1__0_in_rule__BitwiseXorExpression__Group__1__Impl4261);
            	    rule__BitwiseXorExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseXorExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseXorExpression__Group__1__Impl"


    // $ANTLR start "rule__BitwiseXorExpression__Group_1__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2053:1: rule__BitwiseXorExpression__Group_1__0 : rule__BitwiseXorExpression__Group_1__0__Impl rule__BitwiseXorExpression__Group_1__1 ;
    public final void rule__BitwiseXorExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2057:1: ( rule__BitwiseXorExpression__Group_1__0__Impl rule__BitwiseXorExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2058:2: rule__BitwiseXorExpression__Group_1__0__Impl rule__BitwiseXorExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__BitwiseXorExpression__Group_1__0__Impl_in_rule__BitwiseXorExpression__Group_1__04296);
            rule__BitwiseXorExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitwiseXorExpression__Group_1__1_in_rule__BitwiseXorExpression__Group_1__04299);
            rule__BitwiseXorExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseXorExpression__Group_1__0"


    // $ANTLR start "rule__BitwiseXorExpression__Group_1__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2065:1: rule__BitwiseXorExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__BitwiseXorExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2069:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2070:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2070:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2071:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXorExpressionLeftOperandAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2072:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2074:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXorExpressionLeftOperandAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseXorExpression__Group_1__0__Impl"


    // $ANTLR start "rule__BitwiseXorExpression__Group_1__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2084:1: rule__BitwiseXorExpression__Group_1__1 : rule__BitwiseXorExpression__Group_1__1__Impl rule__BitwiseXorExpression__Group_1__2 ;
    public final void rule__BitwiseXorExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2088:1: ( rule__BitwiseXorExpression__Group_1__1__Impl rule__BitwiseXorExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2089:2: rule__BitwiseXorExpression__Group_1__1__Impl rule__BitwiseXorExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__BitwiseXorExpression__Group_1__1__Impl_in_rule__BitwiseXorExpression__Group_1__14357);
            rule__BitwiseXorExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitwiseXorExpression__Group_1__2_in_rule__BitwiseXorExpression__Group_1__14360);
            rule__BitwiseXorExpression__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseXorExpression__Group_1__1"


    // $ANTLR start "rule__BitwiseXorExpression__Group_1__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2096:1: rule__BitwiseXorExpression__Group_1__1__Impl : ( '^' ) ;
    public final void rule__BitwiseXorExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2100:1: ( ( '^' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2101:1: ( '^' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2101:1: ( '^' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2102:1: '^'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseXorExpressionAccess().getCircumflexAccentKeyword_1_1()); 
            }
            match(input,44,FOLLOW_44_in_rule__BitwiseXorExpression__Group_1__1__Impl4388); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseXorExpressionAccess().getCircumflexAccentKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseXorExpression__Group_1__1__Impl"


    // $ANTLR start "rule__BitwiseXorExpression__Group_1__2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2115:1: rule__BitwiseXorExpression__Group_1__2 : rule__BitwiseXorExpression__Group_1__2__Impl ;
    public final void rule__BitwiseXorExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2119:1: ( rule__BitwiseXorExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2120:2: rule__BitwiseXorExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__BitwiseXorExpression__Group_1__2__Impl_in_rule__BitwiseXorExpression__Group_1__24419);
            rule__BitwiseXorExpression__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseXorExpression__Group_1__2"


    // $ANTLR start "rule__BitwiseXorExpression__Group_1__2__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2126:1: rule__BitwiseXorExpression__Group_1__2__Impl : ( ( rule__BitwiseXorExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__BitwiseXorExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2130:1: ( ( ( rule__BitwiseXorExpression__RightOperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2131:1: ( ( rule__BitwiseXorExpression__RightOperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2131:1: ( ( rule__BitwiseXorExpression__RightOperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2132:1: ( rule__BitwiseXorExpression__RightOperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseXorExpressionAccess().getRightOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2133:1: ( rule__BitwiseXorExpression__RightOperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2133:2: rule__BitwiseXorExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__BitwiseXorExpression__RightOperandAssignment_1_2_in_rule__BitwiseXorExpression__Group_1__2__Impl4446);
            rule__BitwiseXorExpression__RightOperandAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseXorExpressionAccess().getRightOperandAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseXorExpression__Group_1__2__Impl"


    // $ANTLR start "rule__BitwiseOrExpression__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2149:1: rule__BitwiseOrExpression__Group__0 : rule__BitwiseOrExpression__Group__0__Impl rule__BitwiseOrExpression__Group__1 ;
    public final void rule__BitwiseOrExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2153:1: ( rule__BitwiseOrExpression__Group__0__Impl rule__BitwiseOrExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2154:2: rule__BitwiseOrExpression__Group__0__Impl rule__BitwiseOrExpression__Group__1
            {
            pushFollow(FOLLOW_rule__BitwiseOrExpression__Group__0__Impl_in_rule__BitwiseOrExpression__Group__04482);
            rule__BitwiseOrExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitwiseOrExpression__Group__1_in_rule__BitwiseOrExpression__Group__04485);
            rule__BitwiseOrExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseOrExpression__Group__0"


    // $ANTLR start "rule__BitwiseOrExpression__Group__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2161:1: rule__BitwiseOrExpression__Group__0__Impl : ( ruleBitwiseAndExpression ) ;
    public final void rule__BitwiseOrExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2165:1: ( ( ruleBitwiseAndExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2166:1: ( ruleBitwiseAndExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2166:1: ( ruleBitwiseAndExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2167:1: ruleBitwiseAndExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseOrExpressionAccess().getBitwiseAndExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleBitwiseAndExpression_in_rule__BitwiseOrExpression__Group__0__Impl4512);
            ruleBitwiseAndExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseOrExpressionAccess().getBitwiseAndExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseOrExpression__Group__0__Impl"


    // $ANTLR start "rule__BitwiseOrExpression__Group__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2178:1: rule__BitwiseOrExpression__Group__1 : rule__BitwiseOrExpression__Group__1__Impl ;
    public final void rule__BitwiseOrExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2182:1: ( rule__BitwiseOrExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2183:2: rule__BitwiseOrExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BitwiseOrExpression__Group__1__Impl_in_rule__BitwiseOrExpression__Group__14541);
            rule__BitwiseOrExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseOrExpression__Group__1"


    // $ANTLR start "rule__BitwiseOrExpression__Group__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2189:1: rule__BitwiseOrExpression__Group__1__Impl : ( ( rule__BitwiseOrExpression__Group_1__0 )* ) ;
    public final void rule__BitwiseOrExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2193:1: ( ( ( rule__BitwiseOrExpression__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2194:1: ( ( rule__BitwiseOrExpression__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2194:1: ( ( rule__BitwiseOrExpression__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2195:1: ( rule__BitwiseOrExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseOrExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2196:1: ( rule__BitwiseOrExpression__Group_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==45) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2196:2: rule__BitwiseOrExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__BitwiseOrExpression__Group_1__0_in_rule__BitwiseOrExpression__Group__1__Impl4568);
            	    rule__BitwiseOrExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseOrExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseOrExpression__Group__1__Impl"


    // $ANTLR start "rule__BitwiseOrExpression__Group_1__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2210:1: rule__BitwiseOrExpression__Group_1__0 : rule__BitwiseOrExpression__Group_1__0__Impl rule__BitwiseOrExpression__Group_1__1 ;
    public final void rule__BitwiseOrExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2214:1: ( rule__BitwiseOrExpression__Group_1__0__Impl rule__BitwiseOrExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2215:2: rule__BitwiseOrExpression__Group_1__0__Impl rule__BitwiseOrExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__BitwiseOrExpression__Group_1__0__Impl_in_rule__BitwiseOrExpression__Group_1__04603);
            rule__BitwiseOrExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitwiseOrExpression__Group_1__1_in_rule__BitwiseOrExpression__Group_1__04606);
            rule__BitwiseOrExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseOrExpression__Group_1__0"


    // $ANTLR start "rule__BitwiseOrExpression__Group_1__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2222:1: rule__BitwiseOrExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__BitwiseOrExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2226:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2227:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2227:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2228:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseOrExpressionAccess().getBitwiseOrExpressionLeftOperandAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2229:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2231:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseOrExpressionAccess().getBitwiseOrExpressionLeftOperandAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseOrExpression__Group_1__0__Impl"


    // $ANTLR start "rule__BitwiseOrExpression__Group_1__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2241:1: rule__BitwiseOrExpression__Group_1__1 : rule__BitwiseOrExpression__Group_1__1__Impl rule__BitwiseOrExpression__Group_1__2 ;
    public final void rule__BitwiseOrExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2245:1: ( rule__BitwiseOrExpression__Group_1__1__Impl rule__BitwiseOrExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2246:2: rule__BitwiseOrExpression__Group_1__1__Impl rule__BitwiseOrExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__BitwiseOrExpression__Group_1__1__Impl_in_rule__BitwiseOrExpression__Group_1__14664);
            rule__BitwiseOrExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitwiseOrExpression__Group_1__2_in_rule__BitwiseOrExpression__Group_1__14667);
            rule__BitwiseOrExpression__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseOrExpression__Group_1__1"


    // $ANTLR start "rule__BitwiseOrExpression__Group_1__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2253:1: rule__BitwiseOrExpression__Group_1__1__Impl : ( '|' ) ;
    public final void rule__BitwiseOrExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2257:1: ( ( '|' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2258:1: ( '|' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2258:1: ( '|' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2259:1: '|'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseOrExpressionAccess().getVerticalLineKeyword_1_1()); 
            }
            match(input,45,FOLLOW_45_in_rule__BitwiseOrExpression__Group_1__1__Impl4695); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseOrExpressionAccess().getVerticalLineKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseOrExpression__Group_1__1__Impl"


    // $ANTLR start "rule__BitwiseOrExpression__Group_1__2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2272:1: rule__BitwiseOrExpression__Group_1__2 : rule__BitwiseOrExpression__Group_1__2__Impl ;
    public final void rule__BitwiseOrExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2276:1: ( rule__BitwiseOrExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2277:2: rule__BitwiseOrExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__BitwiseOrExpression__Group_1__2__Impl_in_rule__BitwiseOrExpression__Group_1__24726);
            rule__BitwiseOrExpression__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseOrExpression__Group_1__2"


    // $ANTLR start "rule__BitwiseOrExpression__Group_1__2__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2283:1: rule__BitwiseOrExpression__Group_1__2__Impl : ( ( rule__BitwiseOrExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__BitwiseOrExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2287:1: ( ( ( rule__BitwiseOrExpression__RightOperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2288:1: ( ( rule__BitwiseOrExpression__RightOperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2288:1: ( ( rule__BitwiseOrExpression__RightOperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2289:1: ( rule__BitwiseOrExpression__RightOperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseOrExpressionAccess().getRightOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2290:1: ( rule__BitwiseOrExpression__RightOperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2290:2: rule__BitwiseOrExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__BitwiseOrExpression__RightOperandAssignment_1_2_in_rule__BitwiseOrExpression__Group_1__2__Impl4753);
            rule__BitwiseOrExpression__RightOperandAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseOrExpressionAccess().getRightOperandAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseOrExpression__Group_1__2__Impl"


    // $ANTLR start "rule__BitwiseAndExpression__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2306:1: rule__BitwiseAndExpression__Group__0 : rule__BitwiseAndExpression__Group__0__Impl rule__BitwiseAndExpression__Group__1 ;
    public final void rule__BitwiseAndExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2310:1: ( rule__BitwiseAndExpression__Group__0__Impl rule__BitwiseAndExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2311:2: rule__BitwiseAndExpression__Group__0__Impl rule__BitwiseAndExpression__Group__1
            {
            pushFollow(FOLLOW_rule__BitwiseAndExpression__Group__0__Impl_in_rule__BitwiseAndExpression__Group__04789);
            rule__BitwiseAndExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitwiseAndExpression__Group__1_in_rule__BitwiseAndExpression__Group__04792);
            rule__BitwiseAndExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseAndExpression__Group__0"


    // $ANTLR start "rule__BitwiseAndExpression__Group__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2318:1: rule__BitwiseAndExpression__Group__0__Impl : ( ruleLogicalRelationExpression ) ;
    public final void rule__BitwiseAndExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2322:1: ( ( ruleLogicalRelationExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2323:1: ( ruleLogicalRelationExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2323:1: ( ruleLogicalRelationExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2324:1: ruleLogicalRelationExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseAndExpressionAccess().getLogicalRelationExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleLogicalRelationExpression_in_rule__BitwiseAndExpression__Group__0__Impl4819);
            ruleLogicalRelationExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseAndExpressionAccess().getLogicalRelationExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseAndExpression__Group__0__Impl"


    // $ANTLR start "rule__BitwiseAndExpression__Group__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2335:1: rule__BitwiseAndExpression__Group__1 : rule__BitwiseAndExpression__Group__1__Impl ;
    public final void rule__BitwiseAndExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2339:1: ( rule__BitwiseAndExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2340:2: rule__BitwiseAndExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BitwiseAndExpression__Group__1__Impl_in_rule__BitwiseAndExpression__Group__14848);
            rule__BitwiseAndExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseAndExpression__Group__1"


    // $ANTLR start "rule__BitwiseAndExpression__Group__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2346:1: rule__BitwiseAndExpression__Group__1__Impl : ( ( rule__BitwiseAndExpression__Group_1__0 )* ) ;
    public final void rule__BitwiseAndExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2350:1: ( ( ( rule__BitwiseAndExpression__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2351:1: ( ( rule__BitwiseAndExpression__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2351:1: ( ( rule__BitwiseAndExpression__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2352:1: ( rule__BitwiseAndExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseAndExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2353:1: ( rule__BitwiseAndExpression__Group_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==46) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2353:2: rule__BitwiseAndExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__BitwiseAndExpression__Group_1__0_in_rule__BitwiseAndExpression__Group__1__Impl4875);
            	    rule__BitwiseAndExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseAndExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseAndExpression__Group__1__Impl"


    // $ANTLR start "rule__BitwiseAndExpression__Group_1__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2367:1: rule__BitwiseAndExpression__Group_1__0 : rule__BitwiseAndExpression__Group_1__0__Impl rule__BitwiseAndExpression__Group_1__1 ;
    public final void rule__BitwiseAndExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2371:1: ( rule__BitwiseAndExpression__Group_1__0__Impl rule__BitwiseAndExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2372:2: rule__BitwiseAndExpression__Group_1__0__Impl rule__BitwiseAndExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__BitwiseAndExpression__Group_1__0__Impl_in_rule__BitwiseAndExpression__Group_1__04910);
            rule__BitwiseAndExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitwiseAndExpression__Group_1__1_in_rule__BitwiseAndExpression__Group_1__04913);
            rule__BitwiseAndExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseAndExpression__Group_1__0"


    // $ANTLR start "rule__BitwiseAndExpression__Group_1__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2379:1: rule__BitwiseAndExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__BitwiseAndExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2383:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2384:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2384:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2385:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAndExpressionLeftOperandAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2386:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2388:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAndExpressionLeftOperandAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseAndExpression__Group_1__0__Impl"


    // $ANTLR start "rule__BitwiseAndExpression__Group_1__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2398:1: rule__BitwiseAndExpression__Group_1__1 : rule__BitwiseAndExpression__Group_1__1__Impl rule__BitwiseAndExpression__Group_1__2 ;
    public final void rule__BitwiseAndExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2402:1: ( rule__BitwiseAndExpression__Group_1__1__Impl rule__BitwiseAndExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2403:2: rule__BitwiseAndExpression__Group_1__1__Impl rule__BitwiseAndExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__BitwiseAndExpression__Group_1__1__Impl_in_rule__BitwiseAndExpression__Group_1__14971);
            rule__BitwiseAndExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitwiseAndExpression__Group_1__2_in_rule__BitwiseAndExpression__Group_1__14974);
            rule__BitwiseAndExpression__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseAndExpression__Group_1__1"


    // $ANTLR start "rule__BitwiseAndExpression__Group_1__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2410:1: rule__BitwiseAndExpression__Group_1__1__Impl : ( '&' ) ;
    public final void rule__BitwiseAndExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2414:1: ( ( '&' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2415:1: ( '&' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2415:1: ( '&' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2416:1: '&'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseAndExpressionAccess().getAmpersandKeyword_1_1()); 
            }
            match(input,46,FOLLOW_46_in_rule__BitwiseAndExpression__Group_1__1__Impl5002); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseAndExpressionAccess().getAmpersandKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseAndExpression__Group_1__1__Impl"


    // $ANTLR start "rule__BitwiseAndExpression__Group_1__2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2429:1: rule__BitwiseAndExpression__Group_1__2 : rule__BitwiseAndExpression__Group_1__2__Impl ;
    public final void rule__BitwiseAndExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2433:1: ( rule__BitwiseAndExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2434:2: rule__BitwiseAndExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__BitwiseAndExpression__Group_1__2__Impl_in_rule__BitwiseAndExpression__Group_1__25033);
            rule__BitwiseAndExpression__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseAndExpression__Group_1__2"


    // $ANTLR start "rule__BitwiseAndExpression__Group_1__2__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2440:1: rule__BitwiseAndExpression__Group_1__2__Impl : ( ( rule__BitwiseAndExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__BitwiseAndExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2444:1: ( ( ( rule__BitwiseAndExpression__RightOperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2445:1: ( ( rule__BitwiseAndExpression__RightOperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2445:1: ( ( rule__BitwiseAndExpression__RightOperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2446:1: ( rule__BitwiseAndExpression__RightOperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseAndExpressionAccess().getRightOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2447:1: ( rule__BitwiseAndExpression__RightOperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2447:2: rule__BitwiseAndExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__BitwiseAndExpression__RightOperandAssignment_1_2_in_rule__BitwiseAndExpression__Group_1__2__Impl5060);
            rule__BitwiseAndExpression__RightOperandAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseAndExpressionAccess().getRightOperandAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseAndExpression__Group_1__2__Impl"


    // $ANTLR start "rule__LogicalRelationExpression__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2463:1: rule__LogicalRelationExpression__Group__0 : rule__LogicalRelationExpression__Group__0__Impl rule__LogicalRelationExpression__Group__1 ;
    public final void rule__LogicalRelationExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2467:1: ( rule__LogicalRelationExpression__Group__0__Impl rule__LogicalRelationExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2468:2: rule__LogicalRelationExpression__Group__0__Impl rule__LogicalRelationExpression__Group__1
            {
            pushFollow(FOLLOW_rule__LogicalRelationExpression__Group__0__Impl_in_rule__LogicalRelationExpression__Group__05096);
            rule__LogicalRelationExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalRelationExpression__Group__1_in_rule__LogicalRelationExpression__Group__05099);
            rule__LogicalRelationExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalRelationExpression__Group__0"


    // $ANTLR start "rule__LogicalRelationExpression__Group__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2475:1: rule__LogicalRelationExpression__Group__0__Impl : ( ruleShiftExpression ) ;
    public final void rule__LogicalRelationExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2479:1: ( ( ruleShiftExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2480:1: ( ruleShiftExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2480:1: ( ruleShiftExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2481:1: ruleShiftExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalRelationExpressionAccess().getShiftExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleShiftExpression_in_rule__LogicalRelationExpression__Group__0__Impl5126);
            ruleShiftExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalRelationExpressionAccess().getShiftExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalRelationExpression__Group__0__Impl"


    // $ANTLR start "rule__LogicalRelationExpression__Group__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2492:1: rule__LogicalRelationExpression__Group__1 : rule__LogicalRelationExpression__Group__1__Impl ;
    public final void rule__LogicalRelationExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2496:1: ( rule__LogicalRelationExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2497:2: rule__LogicalRelationExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__LogicalRelationExpression__Group__1__Impl_in_rule__LogicalRelationExpression__Group__15155);
            rule__LogicalRelationExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalRelationExpression__Group__1"


    // $ANTLR start "rule__LogicalRelationExpression__Group__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2503:1: rule__LogicalRelationExpression__Group__1__Impl : ( ( rule__LogicalRelationExpression__Group_1__0 )* ) ;
    public final void rule__LogicalRelationExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2507:1: ( ( ( rule__LogicalRelationExpression__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2508:1: ( ( rule__LogicalRelationExpression__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2508:1: ( ( rule__LogicalRelationExpression__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2509:1: ( rule__LogicalRelationExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalRelationExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2510:1: ( rule__LogicalRelationExpression__Group_1__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=33 && LA18_0<=38)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2510:2: rule__LogicalRelationExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__LogicalRelationExpression__Group_1__0_in_rule__LogicalRelationExpression__Group__1__Impl5182);
            	    rule__LogicalRelationExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalRelationExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalRelationExpression__Group__1__Impl"


    // $ANTLR start "rule__LogicalRelationExpression__Group_1__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2524:1: rule__LogicalRelationExpression__Group_1__0 : rule__LogicalRelationExpression__Group_1__0__Impl rule__LogicalRelationExpression__Group_1__1 ;
    public final void rule__LogicalRelationExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2528:1: ( rule__LogicalRelationExpression__Group_1__0__Impl rule__LogicalRelationExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2529:2: rule__LogicalRelationExpression__Group_1__0__Impl rule__LogicalRelationExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__LogicalRelationExpression__Group_1__0__Impl_in_rule__LogicalRelationExpression__Group_1__05217);
            rule__LogicalRelationExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalRelationExpression__Group_1__1_in_rule__LogicalRelationExpression__Group_1__05220);
            rule__LogicalRelationExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalRelationExpression__Group_1__0"


    // $ANTLR start "rule__LogicalRelationExpression__Group_1__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2536:1: rule__LogicalRelationExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__LogicalRelationExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2540:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2541:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2541:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2542:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2543:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2545:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalRelationExpression__Group_1__0__Impl"


    // $ANTLR start "rule__LogicalRelationExpression__Group_1__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2555:1: rule__LogicalRelationExpression__Group_1__1 : rule__LogicalRelationExpression__Group_1__1__Impl rule__LogicalRelationExpression__Group_1__2 ;
    public final void rule__LogicalRelationExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2559:1: ( rule__LogicalRelationExpression__Group_1__1__Impl rule__LogicalRelationExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2560:2: rule__LogicalRelationExpression__Group_1__1__Impl rule__LogicalRelationExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__LogicalRelationExpression__Group_1__1__Impl_in_rule__LogicalRelationExpression__Group_1__15278);
            rule__LogicalRelationExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalRelationExpression__Group_1__2_in_rule__LogicalRelationExpression__Group_1__15281);
            rule__LogicalRelationExpression__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalRelationExpression__Group_1__1"


    // $ANTLR start "rule__LogicalRelationExpression__Group_1__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2567:1: rule__LogicalRelationExpression__Group_1__1__Impl : ( ( rule__LogicalRelationExpression__OperatorAssignment_1_1 ) ) ;
    public final void rule__LogicalRelationExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2571:1: ( ( ( rule__LogicalRelationExpression__OperatorAssignment_1_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2572:1: ( ( rule__LogicalRelationExpression__OperatorAssignment_1_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2572:1: ( ( rule__LogicalRelationExpression__OperatorAssignment_1_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2573:1: ( rule__LogicalRelationExpression__OperatorAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalRelationExpressionAccess().getOperatorAssignment_1_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2574:1: ( rule__LogicalRelationExpression__OperatorAssignment_1_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2574:2: rule__LogicalRelationExpression__OperatorAssignment_1_1
            {
            pushFollow(FOLLOW_rule__LogicalRelationExpression__OperatorAssignment_1_1_in_rule__LogicalRelationExpression__Group_1__1__Impl5308);
            rule__LogicalRelationExpression__OperatorAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalRelationExpressionAccess().getOperatorAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalRelationExpression__Group_1__1__Impl"


    // $ANTLR start "rule__LogicalRelationExpression__Group_1__2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2584:1: rule__LogicalRelationExpression__Group_1__2 : rule__LogicalRelationExpression__Group_1__2__Impl ;
    public final void rule__LogicalRelationExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2588:1: ( rule__LogicalRelationExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2589:2: rule__LogicalRelationExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__LogicalRelationExpression__Group_1__2__Impl_in_rule__LogicalRelationExpression__Group_1__25338);
            rule__LogicalRelationExpression__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalRelationExpression__Group_1__2"


    // $ANTLR start "rule__LogicalRelationExpression__Group_1__2__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2595:1: rule__LogicalRelationExpression__Group_1__2__Impl : ( ( rule__LogicalRelationExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__LogicalRelationExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2599:1: ( ( ( rule__LogicalRelationExpression__RightOperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2600:1: ( ( rule__LogicalRelationExpression__RightOperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2600:1: ( ( rule__LogicalRelationExpression__RightOperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2601:1: ( rule__LogicalRelationExpression__RightOperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalRelationExpressionAccess().getRightOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2602:1: ( rule__LogicalRelationExpression__RightOperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2602:2: rule__LogicalRelationExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__LogicalRelationExpression__RightOperandAssignment_1_2_in_rule__LogicalRelationExpression__Group_1__2__Impl5365);
            rule__LogicalRelationExpression__RightOperandAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalRelationExpressionAccess().getRightOperandAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalRelationExpression__Group_1__2__Impl"


    // $ANTLR start "rule__ShiftExpression__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2618:1: rule__ShiftExpression__Group__0 : rule__ShiftExpression__Group__0__Impl rule__ShiftExpression__Group__1 ;
    public final void rule__ShiftExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2622:1: ( rule__ShiftExpression__Group__0__Impl rule__ShiftExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2623:2: rule__ShiftExpression__Group__0__Impl rule__ShiftExpression__Group__1
            {
            pushFollow(FOLLOW_rule__ShiftExpression__Group__0__Impl_in_rule__ShiftExpression__Group__05401);
            rule__ShiftExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ShiftExpression__Group__1_in_rule__ShiftExpression__Group__05404);
            rule__ShiftExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShiftExpression__Group__0"


    // $ANTLR start "rule__ShiftExpression__Group__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2630:1: rule__ShiftExpression__Group__0__Impl : ( ruleNumericalAddSubtractExpression ) ;
    public final void rule__ShiftExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2634:1: ( ( ruleNumericalAddSubtractExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2635:1: ( ruleNumericalAddSubtractExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2635:1: ( ruleNumericalAddSubtractExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2636:1: ruleNumericalAddSubtractExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExpressionAccess().getNumericalAddSubtractExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_rule__ShiftExpression__Group__0__Impl5431);
            ruleNumericalAddSubtractExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExpressionAccess().getNumericalAddSubtractExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShiftExpression__Group__0__Impl"


    // $ANTLR start "rule__ShiftExpression__Group__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2647:1: rule__ShiftExpression__Group__1 : rule__ShiftExpression__Group__1__Impl ;
    public final void rule__ShiftExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2651:1: ( rule__ShiftExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2652:2: rule__ShiftExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ShiftExpression__Group__1__Impl_in_rule__ShiftExpression__Group__15460);
            rule__ShiftExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShiftExpression__Group__1"


    // $ANTLR start "rule__ShiftExpression__Group__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2658:1: rule__ShiftExpression__Group__1__Impl : ( ( rule__ShiftExpression__Group_1__0 )* ) ;
    public final void rule__ShiftExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2662:1: ( ( ( rule__ShiftExpression__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2663:1: ( ( rule__ShiftExpression__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2663:1: ( ( rule__ShiftExpression__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2664:1: ( rule__ShiftExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2665:1: ( rule__ShiftExpression__Group_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=25 && LA19_0<=26)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2665:2: rule__ShiftExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ShiftExpression__Group_1__0_in_rule__ShiftExpression__Group__1__Impl5487);
            	    rule__ShiftExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShiftExpression__Group__1__Impl"


    // $ANTLR start "rule__ShiftExpression__Group_1__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2679:1: rule__ShiftExpression__Group_1__0 : rule__ShiftExpression__Group_1__0__Impl rule__ShiftExpression__Group_1__1 ;
    public final void rule__ShiftExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2683:1: ( rule__ShiftExpression__Group_1__0__Impl rule__ShiftExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2684:2: rule__ShiftExpression__Group_1__0__Impl rule__ShiftExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__ShiftExpression__Group_1__0__Impl_in_rule__ShiftExpression__Group_1__05522);
            rule__ShiftExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ShiftExpression__Group_1__1_in_rule__ShiftExpression__Group_1__05525);
            rule__ShiftExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShiftExpression__Group_1__0"


    // $ANTLR start "rule__ShiftExpression__Group_1__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2691:1: rule__ShiftExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__ShiftExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2695:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2696:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2696:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2697:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftOperandAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2698:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2700:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftOperandAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShiftExpression__Group_1__0__Impl"


    // $ANTLR start "rule__ShiftExpression__Group_1__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2710:1: rule__ShiftExpression__Group_1__1 : rule__ShiftExpression__Group_1__1__Impl rule__ShiftExpression__Group_1__2 ;
    public final void rule__ShiftExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2714:1: ( rule__ShiftExpression__Group_1__1__Impl rule__ShiftExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2715:2: rule__ShiftExpression__Group_1__1__Impl rule__ShiftExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__ShiftExpression__Group_1__1__Impl_in_rule__ShiftExpression__Group_1__15583);
            rule__ShiftExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ShiftExpression__Group_1__2_in_rule__ShiftExpression__Group_1__15586);
            rule__ShiftExpression__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShiftExpression__Group_1__1"


    // $ANTLR start "rule__ShiftExpression__Group_1__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2722:1: rule__ShiftExpression__Group_1__1__Impl : ( ( rule__ShiftExpression__OperatorAssignment_1_1 ) ) ;
    public final void rule__ShiftExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2726:1: ( ( ( rule__ShiftExpression__OperatorAssignment_1_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2727:1: ( ( rule__ShiftExpression__OperatorAssignment_1_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2727:1: ( ( rule__ShiftExpression__OperatorAssignment_1_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2728:1: ( rule__ShiftExpression__OperatorAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExpressionAccess().getOperatorAssignment_1_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2729:1: ( rule__ShiftExpression__OperatorAssignment_1_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2729:2: rule__ShiftExpression__OperatorAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ShiftExpression__OperatorAssignment_1_1_in_rule__ShiftExpression__Group_1__1__Impl5613);
            rule__ShiftExpression__OperatorAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExpressionAccess().getOperatorAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShiftExpression__Group_1__1__Impl"


    // $ANTLR start "rule__ShiftExpression__Group_1__2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2739:1: rule__ShiftExpression__Group_1__2 : rule__ShiftExpression__Group_1__2__Impl ;
    public final void rule__ShiftExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2743:1: ( rule__ShiftExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2744:2: rule__ShiftExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ShiftExpression__Group_1__2__Impl_in_rule__ShiftExpression__Group_1__25643);
            rule__ShiftExpression__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShiftExpression__Group_1__2"


    // $ANTLR start "rule__ShiftExpression__Group_1__2__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2750:1: rule__ShiftExpression__Group_1__2__Impl : ( ( rule__ShiftExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__ShiftExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2754:1: ( ( ( rule__ShiftExpression__RightOperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2755:1: ( ( rule__ShiftExpression__RightOperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2755:1: ( ( rule__ShiftExpression__RightOperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2756:1: ( rule__ShiftExpression__RightOperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExpressionAccess().getRightOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2757:1: ( rule__ShiftExpression__RightOperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2757:2: rule__ShiftExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__ShiftExpression__RightOperandAssignment_1_2_in_rule__ShiftExpression__Group_1__2__Impl5670);
            rule__ShiftExpression__RightOperandAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExpressionAccess().getRightOperandAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShiftExpression__Group_1__2__Impl"


    // $ANTLR start "rule__NumericalAddSubtractExpression__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2773:1: rule__NumericalAddSubtractExpression__Group__0 : rule__NumericalAddSubtractExpression__Group__0__Impl rule__NumericalAddSubtractExpression__Group__1 ;
    public final void rule__NumericalAddSubtractExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2777:1: ( rule__NumericalAddSubtractExpression__Group__0__Impl rule__NumericalAddSubtractExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2778:2: rule__NumericalAddSubtractExpression__Group__0__Impl rule__NumericalAddSubtractExpression__Group__1
            {
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__Group__0__Impl_in_rule__NumericalAddSubtractExpression__Group__05706);
            rule__NumericalAddSubtractExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__Group__1_in_rule__NumericalAddSubtractExpression__Group__05709);
            rule__NumericalAddSubtractExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalAddSubtractExpression__Group__0"


    // $ANTLR start "rule__NumericalAddSubtractExpression__Group__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2785:1: rule__NumericalAddSubtractExpression__Group__0__Impl : ( ruleNumericalMultiplyDivideExpression ) ;
    public final void rule__NumericalAddSubtractExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2789:1: ( ( ruleNumericalMultiplyDivideExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2790:1: ( ruleNumericalMultiplyDivideExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2790:1: ( ruleNumericalMultiplyDivideExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2791:1: ruleNumericalMultiplyDivideExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalMultiplyDivideExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_rule__NumericalAddSubtractExpression__Group__0__Impl5736);
            ruleNumericalMultiplyDivideExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalMultiplyDivideExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalAddSubtractExpression__Group__0__Impl"


    // $ANTLR start "rule__NumericalAddSubtractExpression__Group__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2802:1: rule__NumericalAddSubtractExpression__Group__1 : rule__NumericalAddSubtractExpression__Group__1__Impl ;
    public final void rule__NumericalAddSubtractExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2806:1: ( rule__NumericalAddSubtractExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2807:2: rule__NumericalAddSubtractExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__Group__1__Impl_in_rule__NumericalAddSubtractExpression__Group__15765);
            rule__NumericalAddSubtractExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalAddSubtractExpression__Group__1"


    // $ANTLR start "rule__NumericalAddSubtractExpression__Group__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2813:1: rule__NumericalAddSubtractExpression__Group__1__Impl : ( ( rule__NumericalAddSubtractExpression__Group_1__0 )* ) ;
    public final void rule__NumericalAddSubtractExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2817:1: ( ( ( rule__NumericalAddSubtractExpression__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2818:1: ( ( rule__NumericalAddSubtractExpression__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2818:1: ( ( rule__NumericalAddSubtractExpression__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2819:1: ( rule__NumericalAddSubtractExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalAddSubtractExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2820:1: ( rule__NumericalAddSubtractExpression__Group_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=27 && LA20_0<=28)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2820:2: rule__NumericalAddSubtractExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__Group_1__0_in_rule__NumericalAddSubtractExpression__Group__1__Impl5792);
            	    rule__NumericalAddSubtractExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalAddSubtractExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalAddSubtractExpression__Group__1__Impl"


    // $ANTLR start "rule__NumericalAddSubtractExpression__Group_1__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2834:1: rule__NumericalAddSubtractExpression__Group_1__0 : rule__NumericalAddSubtractExpression__Group_1__0__Impl rule__NumericalAddSubtractExpression__Group_1__1 ;
    public final void rule__NumericalAddSubtractExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2838:1: ( rule__NumericalAddSubtractExpression__Group_1__0__Impl rule__NumericalAddSubtractExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2839:2: rule__NumericalAddSubtractExpression__Group_1__0__Impl rule__NumericalAddSubtractExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__Group_1__0__Impl_in_rule__NumericalAddSubtractExpression__Group_1__05827);
            rule__NumericalAddSubtractExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__Group_1__1_in_rule__NumericalAddSubtractExpression__Group_1__05830);
            rule__NumericalAddSubtractExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalAddSubtractExpression__Group_1__0"


    // $ANTLR start "rule__NumericalAddSubtractExpression__Group_1__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2846:1: rule__NumericalAddSubtractExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__NumericalAddSubtractExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2850:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2851:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2851:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2852:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalAddSubtractExpressionLeftOperandAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2853:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2855:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalAddSubtractExpressionLeftOperandAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalAddSubtractExpression__Group_1__0__Impl"


    // $ANTLR start "rule__NumericalAddSubtractExpression__Group_1__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2865:1: rule__NumericalAddSubtractExpression__Group_1__1 : rule__NumericalAddSubtractExpression__Group_1__1__Impl rule__NumericalAddSubtractExpression__Group_1__2 ;
    public final void rule__NumericalAddSubtractExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2869:1: ( rule__NumericalAddSubtractExpression__Group_1__1__Impl rule__NumericalAddSubtractExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2870:2: rule__NumericalAddSubtractExpression__Group_1__1__Impl rule__NumericalAddSubtractExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__Group_1__1__Impl_in_rule__NumericalAddSubtractExpression__Group_1__15888);
            rule__NumericalAddSubtractExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__Group_1__2_in_rule__NumericalAddSubtractExpression__Group_1__15891);
            rule__NumericalAddSubtractExpression__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalAddSubtractExpression__Group_1__1"


    // $ANTLR start "rule__NumericalAddSubtractExpression__Group_1__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2877:1: rule__NumericalAddSubtractExpression__Group_1__1__Impl : ( ( rule__NumericalAddSubtractExpression__OperatorAssignment_1_1 ) ) ;
    public final void rule__NumericalAddSubtractExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2881:1: ( ( ( rule__NumericalAddSubtractExpression__OperatorAssignment_1_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2882:1: ( ( rule__NumericalAddSubtractExpression__OperatorAssignment_1_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2882:1: ( ( rule__NumericalAddSubtractExpression__OperatorAssignment_1_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2883:1: ( rule__NumericalAddSubtractExpression__OperatorAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalAddSubtractExpressionAccess().getOperatorAssignment_1_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2884:1: ( rule__NumericalAddSubtractExpression__OperatorAssignment_1_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2884:2: rule__NumericalAddSubtractExpression__OperatorAssignment_1_1
            {
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__OperatorAssignment_1_1_in_rule__NumericalAddSubtractExpression__Group_1__1__Impl5918);
            rule__NumericalAddSubtractExpression__OperatorAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalAddSubtractExpressionAccess().getOperatorAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalAddSubtractExpression__Group_1__1__Impl"


    // $ANTLR start "rule__NumericalAddSubtractExpression__Group_1__2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2894:1: rule__NumericalAddSubtractExpression__Group_1__2 : rule__NumericalAddSubtractExpression__Group_1__2__Impl ;
    public final void rule__NumericalAddSubtractExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2898:1: ( rule__NumericalAddSubtractExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2899:2: rule__NumericalAddSubtractExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__Group_1__2__Impl_in_rule__NumericalAddSubtractExpression__Group_1__25948);
            rule__NumericalAddSubtractExpression__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalAddSubtractExpression__Group_1__2"


    // $ANTLR start "rule__NumericalAddSubtractExpression__Group_1__2__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2905:1: rule__NumericalAddSubtractExpression__Group_1__2__Impl : ( ( rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__NumericalAddSubtractExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2909:1: ( ( ( rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2910:1: ( ( rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2910:1: ( ( rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2911:1: ( rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalAddSubtractExpressionAccess().getRightOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2912:1: ( rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2912:2: rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2_in_rule__NumericalAddSubtractExpression__Group_1__2__Impl5975);
            rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalAddSubtractExpressionAccess().getRightOperandAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalAddSubtractExpression__Group_1__2__Impl"


    // $ANTLR start "rule__NumericalMultiplyDivideExpression__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2928:1: rule__NumericalMultiplyDivideExpression__Group__0 : rule__NumericalMultiplyDivideExpression__Group__0__Impl rule__NumericalMultiplyDivideExpression__Group__1 ;
    public final void rule__NumericalMultiplyDivideExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2932:1: ( rule__NumericalMultiplyDivideExpression__Group__0__Impl rule__NumericalMultiplyDivideExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2933:2: rule__NumericalMultiplyDivideExpression__Group__0__Impl rule__NumericalMultiplyDivideExpression__Group__1
            {
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__Group__0__Impl_in_rule__NumericalMultiplyDivideExpression__Group__06011);
            rule__NumericalMultiplyDivideExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__Group__1_in_rule__NumericalMultiplyDivideExpression__Group__06014);
            rule__NumericalMultiplyDivideExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalMultiplyDivideExpression__Group__0"


    // $ANTLR start "rule__NumericalMultiplyDivideExpression__Group__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2940:1: rule__NumericalMultiplyDivideExpression__Group__0__Impl : ( ruleNumericalUnaryExpression ) ;
    public final void rule__NumericalMultiplyDivideExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2944:1: ( ( ruleNumericalUnaryExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2945:1: ( ruleNumericalUnaryExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2945:1: ( ruleNumericalUnaryExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2946:1: ruleNumericalUnaryExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalUnaryExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_rule__NumericalMultiplyDivideExpression__Group__0__Impl6041);
            ruleNumericalUnaryExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalUnaryExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalMultiplyDivideExpression__Group__0__Impl"


    // $ANTLR start "rule__NumericalMultiplyDivideExpression__Group__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2957:1: rule__NumericalMultiplyDivideExpression__Group__1 : rule__NumericalMultiplyDivideExpression__Group__1__Impl ;
    public final void rule__NumericalMultiplyDivideExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2961:1: ( rule__NumericalMultiplyDivideExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2962:2: rule__NumericalMultiplyDivideExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__Group__1__Impl_in_rule__NumericalMultiplyDivideExpression__Group__16070);
            rule__NumericalMultiplyDivideExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalMultiplyDivideExpression__Group__1"


    // $ANTLR start "rule__NumericalMultiplyDivideExpression__Group__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2968:1: rule__NumericalMultiplyDivideExpression__Group__1__Impl : ( ( rule__NumericalMultiplyDivideExpression__Group_1__0 )* ) ;
    public final void rule__NumericalMultiplyDivideExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2972:1: ( ( ( rule__NumericalMultiplyDivideExpression__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2973:1: ( ( rule__NumericalMultiplyDivideExpression__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2973:1: ( ( rule__NumericalMultiplyDivideExpression__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2974:1: ( rule__NumericalMultiplyDivideExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2975:1: ( rule__NumericalMultiplyDivideExpression__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=29 && LA21_0<=31)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2975:2: rule__NumericalMultiplyDivideExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__0_in_rule__NumericalMultiplyDivideExpression__Group__1__Impl6097);
            	    rule__NumericalMultiplyDivideExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalMultiplyDivideExpression__Group__1__Impl"


    // $ANTLR start "rule__NumericalMultiplyDivideExpression__Group_1__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2989:1: rule__NumericalMultiplyDivideExpression__Group_1__0 : rule__NumericalMultiplyDivideExpression__Group_1__0__Impl rule__NumericalMultiplyDivideExpression__Group_1__1 ;
    public final void rule__NumericalMultiplyDivideExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2993:1: ( rule__NumericalMultiplyDivideExpression__Group_1__0__Impl rule__NumericalMultiplyDivideExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2994:2: rule__NumericalMultiplyDivideExpression__Group_1__0__Impl rule__NumericalMultiplyDivideExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__0__Impl_in_rule__NumericalMultiplyDivideExpression__Group_1__06132);
            rule__NumericalMultiplyDivideExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__1_in_rule__NumericalMultiplyDivideExpression__Group_1__06135);
            rule__NumericalMultiplyDivideExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalMultiplyDivideExpression__Group_1__0"


    // $ANTLR start "rule__NumericalMultiplyDivideExpression__Group_1__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3001:1: rule__NumericalMultiplyDivideExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__NumericalMultiplyDivideExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3005:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3006:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3006:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3007:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalMultiplyDivideExpressionLeftOperandAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3008:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3010:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalMultiplyDivideExpressionLeftOperandAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalMultiplyDivideExpression__Group_1__0__Impl"


    // $ANTLR start "rule__NumericalMultiplyDivideExpression__Group_1__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3020:1: rule__NumericalMultiplyDivideExpression__Group_1__1 : rule__NumericalMultiplyDivideExpression__Group_1__1__Impl rule__NumericalMultiplyDivideExpression__Group_1__2 ;
    public final void rule__NumericalMultiplyDivideExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3024:1: ( rule__NumericalMultiplyDivideExpression__Group_1__1__Impl rule__NumericalMultiplyDivideExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3025:2: rule__NumericalMultiplyDivideExpression__Group_1__1__Impl rule__NumericalMultiplyDivideExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__1__Impl_in_rule__NumericalMultiplyDivideExpression__Group_1__16193);
            rule__NumericalMultiplyDivideExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__2_in_rule__NumericalMultiplyDivideExpression__Group_1__16196);
            rule__NumericalMultiplyDivideExpression__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalMultiplyDivideExpression__Group_1__1"


    // $ANTLR start "rule__NumericalMultiplyDivideExpression__Group_1__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3032:1: rule__NumericalMultiplyDivideExpression__Group_1__1__Impl : ( ( rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1 ) ) ;
    public final void rule__NumericalMultiplyDivideExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3036:1: ( ( ( rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3037:1: ( ( rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3037:1: ( ( rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3038:1: ( rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getOperatorAssignment_1_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3039:1: ( rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3039:2: rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1
            {
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1_in_rule__NumericalMultiplyDivideExpression__Group_1__1__Impl6223);
            rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getOperatorAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalMultiplyDivideExpression__Group_1__1__Impl"


    // $ANTLR start "rule__NumericalMultiplyDivideExpression__Group_1__2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3049:1: rule__NumericalMultiplyDivideExpression__Group_1__2 : rule__NumericalMultiplyDivideExpression__Group_1__2__Impl ;
    public final void rule__NumericalMultiplyDivideExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3053:1: ( rule__NumericalMultiplyDivideExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3054:2: rule__NumericalMultiplyDivideExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__2__Impl_in_rule__NumericalMultiplyDivideExpression__Group_1__26253);
            rule__NumericalMultiplyDivideExpression__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalMultiplyDivideExpression__Group_1__2"


    // $ANTLR start "rule__NumericalMultiplyDivideExpression__Group_1__2__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3060:1: rule__NumericalMultiplyDivideExpression__Group_1__2__Impl : ( ( rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__NumericalMultiplyDivideExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3064:1: ( ( ( rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3065:1: ( ( rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3065:1: ( ( rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3066:1: ( rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getRightOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3067:1: ( rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3067:2: rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2_in_rule__NumericalMultiplyDivideExpression__Group_1__2__Impl6280);
            rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getRightOperandAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalMultiplyDivideExpression__Group_1__2__Impl"


    // $ANTLR start "rule__NumericalUnaryExpression__Group_1__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3083:1: rule__NumericalUnaryExpression__Group_1__0 : rule__NumericalUnaryExpression__Group_1__0__Impl rule__NumericalUnaryExpression__Group_1__1 ;
    public final void rule__NumericalUnaryExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3087:1: ( rule__NumericalUnaryExpression__Group_1__0__Impl rule__NumericalUnaryExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3088:2: rule__NumericalUnaryExpression__Group_1__0__Impl rule__NumericalUnaryExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__NumericalUnaryExpression__Group_1__0__Impl_in_rule__NumericalUnaryExpression__Group_1__06316);
            rule__NumericalUnaryExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__NumericalUnaryExpression__Group_1__1_in_rule__NumericalUnaryExpression__Group_1__06319);
            rule__NumericalUnaryExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalUnaryExpression__Group_1__0"


    // $ANTLR start "rule__NumericalUnaryExpression__Group_1__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3095:1: rule__NumericalUnaryExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__NumericalUnaryExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3099:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3100:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3100:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3101:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalUnaryExpressionAccess().getNumericalUnaryExpressionAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3102:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3104:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalUnaryExpressionAccess().getNumericalUnaryExpressionAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalUnaryExpression__Group_1__0__Impl"


    // $ANTLR start "rule__NumericalUnaryExpression__Group_1__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3114:1: rule__NumericalUnaryExpression__Group_1__1 : rule__NumericalUnaryExpression__Group_1__1__Impl rule__NumericalUnaryExpression__Group_1__2 ;
    public final void rule__NumericalUnaryExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3118:1: ( rule__NumericalUnaryExpression__Group_1__1__Impl rule__NumericalUnaryExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3119:2: rule__NumericalUnaryExpression__Group_1__1__Impl rule__NumericalUnaryExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__NumericalUnaryExpression__Group_1__1__Impl_in_rule__NumericalUnaryExpression__Group_1__16377);
            rule__NumericalUnaryExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__NumericalUnaryExpression__Group_1__2_in_rule__NumericalUnaryExpression__Group_1__16380);
            rule__NumericalUnaryExpression__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalUnaryExpression__Group_1__1"


    // $ANTLR start "rule__NumericalUnaryExpression__Group_1__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3126:1: rule__NumericalUnaryExpression__Group_1__1__Impl : ( ( rule__NumericalUnaryExpression__OperatorAssignment_1_1 ) ) ;
    public final void rule__NumericalUnaryExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3130:1: ( ( ( rule__NumericalUnaryExpression__OperatorAssignment_1_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3131:1: ( ( rule__NumericalUnaryExpression__OperatorAssignment_1_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3131:1: ( ( rule__NumericalUnaryExpression__OperatorAssignment_1_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3132:1: ( rule__NumericalUnaryExpression__OperatorAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalUnaryExpressionAccess().getOperatorAssignment_1_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3133:1: ( rule__NumericalUnaryExpression__OperatorAssignment_1_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3133:2: rule__NumericalUnaryExpression__OperatorAssignment_1_1
            {
            pushFollow(FOLLOW_rule__NumericalUnaryExpression__OperatorAssignment_1_1_in_rule__NumericalUnaryExpression__Group_1__1__Impl6407);
            rule__NumericalUnaryExpression__OperatorAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalUnaryExpressionAccess().getOperatorAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalUnaryExpression__Group_1__1__Impl"


    // $ANTLR start "rule__NumericalUnaryExpression__Group_1__2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3143:1: rule__NumericalUnaryExpression__Group_1__2 : rule__NumericalUnaryExpression__Group_1__2__Impl ;
    public final void rule__NumericalUnaryExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3147:1: ( rule__NumericalUnaryExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3148:2: rule__NumericalUnaryExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__NumericalUnaryExpression__Group_1__2__Impl_in_rule__NumericalUnaryExpression__Group_1__26437);
            rule__NumericalUnaryExpression__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalUnaryExpression__Group_1__2"


    // $ANTLR start "rule__NumericalUnaryExpression__Group_1__2__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3154:1: rule__NumericalUnaryExpression__Group_1__2__Impl : ( ( rule__NumericalUnaryExpression__OperandAssignment_1_2 ) ) ;
    public final void rule__NumericalUnaryExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3158:1: ( ( ( rule__NumericalUnaryExpression__OperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3159:1: ( ( rule__NumericalUnaryExpression__OperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3159:1: ( ( rule__NumericalUnaryExpression__OperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3160:1: ( rule__NumericalUnaryExpression__OperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalUnaryExpressionAccess().getOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3161:1: ( rule__NumericalUnaryExpression__OperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3161:2: rule__NumericalUnaryExpression__OperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__NumericalUnaryExpression__OperandAssignment_1_2_in_rule__NumericalUnaryExpression__Group_1__2__Impl6464);
            rule__NumericalUnaryExpression__OperandAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalUnaryExpressionAccess().getOperandAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalUnaryExpression__Group_1__2__Impl"


    // $ANTLR start "rule__PrimitiveValueExpression__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3177:1: rule__PrimitiveValueExpression__Group__0 : rule__PrimitiveValueExpression__Group__0__Impl rule__PrimitiveValueExpression__Group__1 ;
    public final void rule__PrimitiveValueExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3181:1: ( rule__PrimitiveValueExpression__Group__0__Impl rule__PrimitiveValueExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3182:2: rule__PrimitiveValueExpression__Group__0__Impl rule__PrimitiveValueExpression__Group__1
            {
            pushFollow(FOLLOW_rule__PrimitiveValueExpression__Group__0__Impl_in_rule__PrimitiveValueExpression__Group__06500);
            rule__PrimitiveValueExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__PrimitiveValueExpression__Group__1_in_rule__PrimitiveValueExpression__Group__06503);
            rule__PrimitiveValueExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveValueExpression__Group__0"


    // $ANTLR start "rule__PrimitiveValueExpression__Group__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3189:1: rule__PrimitiveValueExpression__Group__0__Impl : ( () ) ;
    public final void rule__PrimitiveValueExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3193:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3194:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3194:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3195:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveValueExpressionAccess().getPrimitiveValueExpressionAction_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3196:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3198:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimitiveValueExpressionAccess().getPrimitiveValueExpressionAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveValueExpression__Group__0__Impl"


    // $ANTLR start "rule__PrimitiveValueExpression__Group__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3208:1: rule__PrimitiveValueExpression__Group__1 : rule__PrimitiveValueExpression__Group__1__Impl ;
    public final void rule__PrimitiveValueExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3212:1: ( rule__PrimitiveValueExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3213:2: rule__PrimitiveValueExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__PrimitiveValueExpression__Group__1__Impl_in_rule__PrimitiveValueExpression__Group__16561);
            rule__PrimitiveValueExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveValueExpression__Group__1"


    // $ANTLR start "rule__PrimitiveValueExpression__Group__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3219:1: rule__PrimitiveValueExpression__Group__1__Impl : ( ( rule__PrimitiveValueExpression__ValueAssignment_1 ) ) ;
    public final void rule__PrimitiveValueExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3223:1: ( ( ( rule__PrimitiveValueExpression__ValueAssignment_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3224:1: ( ( rule__PrimitiveValueExpression__ValueAssignment_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3224:1: ( ( rule__PrimitiveValueExpression__ValueAssignment_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3225:1: ( rule__PrimitiveValueExpression__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveValueExpressionAccess().getValueAssignment_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3226:1: ( rule__PrimitiveValueExpression__ValueAssignment_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3226:2: rule__PrimitiveValueExpression__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__PrimitiveValueExpression__ValueAssignment_1_in_rule__PrimitiveValueExpression__Group__1__Impl6588);
            rule__PrimitiveValueExpression__ValueAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimitiveValueExpressionAccess().getValueAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveValueExpression__Group__1__Impl"


    // $ANTLR start "rule__FeatureCall__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3240:1: rule__FeatureCall__Group__0 : rule__FeatureCall__Group__0__Impl rule__FeatureCall__Group__1 ;
    public final void rule__FeatureCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3244:1: ( rule__FeatureCall__Group__0__Impl rule__FeatureCall__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3245:2: rule__FeatureCall__Group__0__Impl rule__FeatureCall__Group__1
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group__0__Impl_in_rule__FeatureCall__Group__06622);
            rule__FeatureCall__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FeatureCall__Group__1_in_rule__FeatureCall__Group__06625);
            rule__FeatureCall__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group__0"


    // $ANTLR start "rule__FeatureCall__Group__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3252:1: rule__FeatureCall__Group__0__Impl : ( ruleElementReferenceExpression ) ;
    public final void rule__FeatureCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3256:1: ( ( ruleElementReferenceExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3257:1: ( ruleElementReferenceExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3257:1: ( ruleElementReferenceExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3258:1: ruleElementReferenceExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getElementReferenceExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleElementReferenceExpression_in_rule__FeatureCall__Group__0__Impl6652);
            ruleElementReferenceExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallAccess().getElementReferenceExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group__0__Impl"


    // $ANTLR start "rule__FeatureCall__Group__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3269:1: rule__FeatureCall__Group__1 : rule__FeatureCall__Group__1__Impl ;
    public final void rule__FeatureCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3273:1: ( rule__FeatureCall__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3274:2: rule__FeatureCall__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group__1__Impl_in_rule__FeatureCall__Group__16681);
            rule__FeatureCall__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group__1"


    // $ANTLR start "rule__FeatureCall__Group__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3280:1: rule__FeatureCall__Group__1__Impl : ( ( rule__FeatureCall__Group_1__0 )* ) ;
    public final void rule__FeatureCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3284:1: ( ( ( rule__FeatureCall__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3285:1: ( ( rule__FeatureCall__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3285:1: ( ( rule__FeatureCall__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3286:1: ( rule__FeatureCall__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3287:1: ( rule__FeatureCall__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==47) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3287:2: rule__FeatureCall__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FeatureCall__Group_1__0_in_rule__FeatureCall__Group__1__Impl6708);
            	    rule__FeatureCall__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group__1__Impl"


    // $ANTLR start "rule__FeatureCall__Group_1__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3301:1: rule__FeatureCall__Group_1__0 : rule__FeatureCall__Group_1__0__Impl rule__FeatureCall__Group_1__1 ;
    public final void rule__FeatureCall__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3305:1: ( rule__FeatureCall__Group_1__0__Impl rule__FeatureCall__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3306:2: rule__FeatureCall__Group_1__0__Impl rule__FeatureCall__Group_1__1
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1__0__Impl_in_rule__FeatureCall__Group_1__06743);
            rule__FeatureCall__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FeatureCall__Group_1__1_in_rule__FeatureCall__Group_1__06746);
            rule__FeatureCall__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1__0"


    // $ANTLR start "rule__FeatureCall__Group_1__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3313:1: rule__FeatureCall__Group_1__0__Impl : ( () ) ;
    public final void rule__FeatureCall__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3317:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3318:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3318:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3319:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getFeatureCallOwnerAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3320:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3322:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallAccess().getFeatureCallOwnerAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1__0__Impl"


    // $ANTLR start "rule__FeatureCall__Group_1__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3332:1: rule__FeatureCall__Group_1__1 : rule__FeatureCall__Group_1__1__Impl rule__FeatureCall__Group_1__2 ;
    public final void rule__FeatureCall__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3336:1: ( rule__FeatureCall__Group_1__1__Impl rule__FeatureCall__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3337:2: rule__FeatureCall__Group_1__1__Impl rule__FeatureCall__Group_1__2
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1__1__Impl_in_rule__FeatureCall__Group_1__16804);
            rule__FeatureCall__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FeatureCall__Group_1__2_in_rule__FeatureCall__Group_1__16807);
            rule__FeatureCall__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1__1"


    // $ANTLR start "rule__FeatureCall__Group_1__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3344:1: rule__FeatureCall__Group_1__1__Impl : ( '.' ) ;
    public final void rule__FeatureCall__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3348:1: ( ( '.' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3349:1: ( '.' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3349:1: ( '.' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3350:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getFullStopKeyword_1_1()); 
            }
            match(input,47,FOLLOW_47_in_rule__FeatureCall__Group_1__1__Impl6835); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallAccess().getFullStopKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1__1__Impl"


    // $ANTLR start "rule__FeatureCall__Group_1__2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3363:1: rule__FeatureCall__Group_1__2 : rule__FeatureCall__Group_1__2__Impl rule__FeatureCall__Group_1__3 ;
    public final void rule__FeatureCall__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3367:1: ( rule__FeatureCall__Group_1__2__Impl rule__FeatureCall__Group_1__3 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3368:2: rule__FeatureCall__Group_1__2__Impl rule__FeatureCall__Group_1__3
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1__2__Impl_in_rule__FeatureCall__Group_1__26866);
            rule__FeatureCall__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FeatureCall__Group_1__3_in_rule__FeatureCall__Group_1__26869);
            rule__FeatureCall__Group_1__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1__2"


    // $ANTLR start "rule__FeatureCall__Group_1__2__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3375:1: rule__FeatureCall__Group_1__2__Impl : ( ( rule__FeatureCall__FeatureAssignment_1_2 ) ) ;
    public final void rule__FeatureCall__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3379:1: ( ( ( rule__FeatureCall__FeatureAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3380:1: ( ( rule__FeatureCall__FeatureAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3380:1: ( ( rule__FeatureCall__FeatureAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3381:1: ( rule__FeatureCall__FeatureAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getFeatureAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3382:1: ( rule__FeatureCall__FeatureAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3382:2: rule__FeatureCall__FeatureAssignment_1_2
            {
            pushFollow(FOLLOW_rule__FeatureCall__FeatureAssignment_1_2_in_rule__FeatureCall__Group_1__2__Impl6896);
            rule__FeatureCall__FeatureAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallAccess().getFeatureAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1__2__Impl"


    // $ANTLR start "rule__FeatureCall__Group_1__3"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3392:1: rule__FeatureCall__Group_1__3 : rule__FeatureCall__Group_1__3__Impl ;
    public final void rule__FeatureCall__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3396:1: ( rule__FeatureCall__Group_1__3__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3397:2: rule__FeatureCall__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1__3__Impl_in_rule__FeatureCall__Group_1__36926);
            rule__FeatureCall__Group_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1__3"


    // $ANTLR start "rule__FeatureCall__Group_1__3__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3403:1: rule__FeatureCall__Group_1__3__Impl : ( ( rule__FeatureCall__Group_1_3__0 )? ) ;
    public final void rule__FeatureCall__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3407:1: ( ( ( rule__FeatureCall__Group_1_3__0 )? ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3408:1: ( ( rule__FeatureCall__Group_1_3__0 )? )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3408:1: ( ( rule__FeatureCall__Group_1_3__0 )? )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3409:1: ( rule__FeatureCall__Group_1_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getGroup_1_3()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3410:1: ( rule__FeatureCall__Group_1_3__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==50) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3410:2: rule__FeatureCall__Group_1_3__0
                    {
                    pushFollow(FOLLOW_rule__FeatureCall__Group_1_3__0_in_rule__FeatureCall__Group_1__3__Impl6953);
                    rule__FeatureCall__Group_1_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallAccess().getGroup_1_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1__3__Impl"


    // $ANTLR start "rule__FeatureCall__Group_1_3__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3428:1: rule__FeatureCall__Group_1_3__0 : rule__FeatureCall__Group_1_3__0__Impl rule__FeatureCall__Group_1_3__1 ;
    public final void rule__FeatureCall__Group_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3432:1: ( rule__FeatureCall__Group_1_3__0__Impl rule__FeatureCall__Group_1_3__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3433:2: rule__FeatureCall__Group_1_3__0__Impl rule__FeatureCall__Group_1_3__1
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3__0__Impl_in_rule__FeatureCall__Group_1_3__06992);
            rule__FeatureCall__Group_1_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3__1_in_rule__FeatureCall__Group_1_3__06995);
            rule__FeatureCall__Group_1_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1_3__0"


    // $ANTLR start "rule__FeatureCall__Group_1_3__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3440:1: rule__FeatureCall__Group_1_3__0__Impl : ( ( rule__FeatureCall__OperationCallAssignment_1_3_0 ) ) ;
    public final void rule__FeatureCall__Group_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3444:1: ( ( ( rule__FeatureCall__OperationCallAssignment_1_3_0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3445:1: ( ( rule__FeatureCall__OperationCallAssignment_1_3_0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3445:1: ( ( rule__FeatureCall__OperationCallAssignment_1_3_0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3446:1: ( rule__FeatureCall__OperationCallAssignment_1_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getOperationCallAssignment_1_3_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3447:1: ( rule__FeatureCall__OperationCallAssignment_1_3_0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3447:2: rule__FeatureCall__OperationCallAssignment_1_3_0
            {
            pushFollow(FOLLOW_rule__FeatureCall__OperationCallAssignment_1_3_0_in_rule__FeatureCall__Group_1_3__0__Impl7022);
            rule__FeatureCall__OperationCallAssignment_1_3_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallAccess().getOperationCallAssignment_1_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1_3__0__Impl"


    // $ANTLR start "rule__FeatureCall__Group_1_3__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3457:1: rule__FeatureCall__Group_1_3__1 : rule__FeatureCall__Group_1_3__1__Impl rule__FeatureCall__Group_1_3__2 ;
    public final void rule__FeatureCall__Group_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3461:1: ( rule__FeatureCall__Group_1_3__1__Impl rule__FeatureCall__Group_1_3__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3462:2: rule__FeatureCall__Group_1_3__1__Impl rule__FeatureCall__Group_1_3__2
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3__1__Impl_in_rule__FeatureCall__Group_1_3__17052);
            rule__FeatureCall__Group_1_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3__2_in_rule__FeatureCall__Group_1_3__17055);
            rule__FeatureCall__Group_1_3__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1_3__1"


    // $ANTLR start "rule__FeatureCall__Group_1_3__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3469:1: rule__FeatureCall__Group_1_3__1__Impl : ( ( rule__FeatureCall__Group_1_3_1__0 )? ) ;
    public final void rule__FeatureCall__Group_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3473:1: ( ( ( rule__FeatureCall__Group_1_3_1__0 )? ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3474:1: ( ( rule__FeatureCall__Group_1_3_1__0 )? )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3474:1: ( ( rule__FeatureCall__Group_1_3_1__0 )? )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3475:1: ( rule__FeatureCall__Group_1_3_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getGroup_1_3_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3476:1: ( rule__FeatureCall__Group_1_3_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=RULE_ID && LA24_0<=RULE_STRING)||(LA24_0>=27 && LA24_0<=28)||LA24_0==32||LA24_0==43||LA24_0==50) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3476:2: rule__FeatureCall__Group_1_3_1__0
                    {
                    pushFollow(FOLLOW_rule__FeatureCall__Group_1_3_1__0_in_rule__FeatureCall__Group_1_3__1__Impl7082);
                    rule__FeatureCall__Group_1_3_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallAccess().getGroup_1_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1_3__1__Impl"


    // $ANTLR start "rule__FeatureCall__Group_1_3__2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3486:1: rule__FeatureCall__Group_1_3__2 : rule__FeatureCall__Group_1_3__2__Impl ;
    public final void rule__FeatureCall__Group_1_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3490:1: ( rule__FeatureCall__Group_1_3__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3491:2: rule__FeatureCall__Group_1_3__2__Impl
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3__2__Impl_in_rule__FeatureCall__Group_1_3__27113);
            rule__FeatureCall__Group_1_3__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1_3__2"


    // $ANTLR start "rule__FeatureCall__Group_1_3__2__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3497:1: rule__FeatureCall__Group_1_3__2__Impl : ( ')' ) ;
    public final void rule__FeatureCall__Group_1_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3501:1: ( ( ')' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3502:1: ( ')' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3502:1: ( ')' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3503:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getRightParenthesisKeyword_1_3_2()); 
            }
            match(input,48,FOLLOW_48_in_rule__FeatureCall__Group_1_3__2__Impl7141); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallAccess().getRightParenthesisKeyword_1_3_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1_3__2__Impl"


    // $ANTLR start "rule__FeatureCall__Group_1_3_1__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3522:1: rule__FeatureCall__Group_1_3_1__0 : rule__FeatureCall__Group_1_3_1__0__Impl rule__FeatureCall__Group_1_3_1__1 ;
    public final void rule__FeatureCall__Group_1_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3526:1: ( rule__FeatureCall__Group_1_3_1__0__Impl rule__FeatureCall__Group_1_3_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3527:2: rule__FeatureCall__Group_1_3_1__0__Impl rule__FeatureCall__Group_1_3_1__1
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3_1__0__Impl_in_rule__FeatureCall__Group_1_3_1__07178);
            rule__FeatureCall__Group_1_3_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3_1__1_in_rule__FeatureCall__Group_1_3_1__07181);
            rule__FeatureCall__Group_1_3_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1_3_1__0"


    // $ANTLR start "rule__FeatureCall__Group_1_3_1__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3534:1: rule__FeatureCall__Group_1_3_1__0__Impl : ( ( rule__FeatureCall__ArgsAssignment_1_3_1_0 ) ) ;
    public final void rule__FeatureCall__Group_1_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3538:1: ( ( ( rule__FeatureCall__ArgsAssignment_1_3_1_0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3539:1: ( ( rule__FeatureCall__ArgsAssignment_1_3_1_0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3539:1: ( ( rule__FeatureCall__ArgsAssignment_1_3_1_0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3540:1: ( rule__FeatureCall__ArgsAssignment_1_3_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getArgsAssignment_1_3_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3541:1: ( rule__FeatureCall__ArgsAssignment_1_3_1_0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3541:2: rule__FeatureCall__ArgsAssignment_1_3_1_0
            {
            pushFollow(FOLLOW_rule__FeatureCall__ArgsAssignment_1_3_1_0_in_rule__FeatureCall__Group_1_3_1__0__Impl7208);
            rule__FeatureCall__ArgsAssignment_1_3_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallAccess().getArgsAssignment_1_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1_3_1__0__Impl"


    // $ANTLR start "rule__FeatureCall__Group_1_3_1__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3551:1: rule__FeatureCall__Group_1_3_1__1 : rule__FeatureCall__Group_1_3_1__1__Impl ;
    public final void rule__FeatureCall__Group_1_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3555:1: ( rule__FeatureCall__Group_1_3_1__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3556:2: rule__FeatureCall__Group_1_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3_1__1__Impl_in_rule__FeatureCall__Group_1_3_1__17238);
            rule__FeatureCall__Group_1_3_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1_3_1__1"


    // $ANTLR start "rule__FeatureCall__Group_1_3_1__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3562:1: rule__FeatureCall__Group_1_3_1__1__Impl : ( ( rule__FeatureCall__Group_1_3_1_1__0 )* ) ;
    public final void rule__FeatureCall__Group_1_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3566:1: ( ( ( rule__FeatureCall__Group_1_3_1_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3567:1: ( ( rule__FeatureCall__Group_1_3_1_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3567:1: ( ( rule__FeatureCall__Group_1_3_1_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3568:1: ( rule__FeatureCall__Group_1_3_1_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getGroup_1_3_1_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3569:1: ( rule__FeatureCall__Group_1_3_1_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==49) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3569:2: rule__FeatureCall__Group_1_3_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FeatureCall__Group_1_3_1_1__0_in_rule__FeatureCall__Group_1_3_1__1__Impl7265);
            	    rule__FeatureCall__Group_1_3_1_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallAccess().getGroup_1_3_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1_3_1__1__Impl"


    // $ANTLR start "rule__FeatureCall__Group_1_3_1_1__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3583:1: rule__FeatureCall__Group_1_3_1_1__0 : rule__FeatureCall__Group_1_3_1_1__0__Impl rule__FeatureCall__Group_1_3_1_1__1 ;
    public final void rule__FeatureCall__Group_1_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3587:1: ( rule__FeatureCall__Group_1_3_1_1__0__Impl rule__FeatureCall__Group_1_3_1_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3588:2: rule__FeatureCall__Group_1_3_1_1__0__Impl rule__FeatureCall__Group_1_3_1_1__1
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3_1_1__0__Impl_in_rule__FeatureCall__Group_1_3_1_1__07300);
            rule__FeatureCall__Group_1_3_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3_1_1__1_in_rule__FeatureCall__Group_1_3_1_1__07303);
            rule__FeatureCall__Group_1_3_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1_3_1_1__0"


    // $ANTLR start "rule__FeatureCall__Group_1_3_1_1__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3595:1: rule__FeatureCall__Group_1_3_1_1__0__Impl : ( ',' ) ;
    public final void rule__FeatureCall__Group_1_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3599:1: ( ( ',' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3600:1: ( ',' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3600:1: ( ',' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3601:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getCommaKeyword_1_3_1_1_0()); 
            }
            match(input,49,FOLLOW_49_in_rule__FeatureCall__Group_1_3_1_1__0__Impl7331); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallAccess().getCommaKeyword_1_3_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1_3_1_1__0__Impl"


    // $ANTLR start "rule__FeatureCall__Group_1_3_1_1__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3614:1: rule__FeatureCall__Group_1_3_1_1__1 : rule__FeatureCall__Group_1_3_1_1__1__Impl ;
    public final void rule__FeatureCall__Group_1_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3618:1: ( rule__FeatureCall__Group_1_3_1_1__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3619:2: rule__FeatureCall__Group_1_3_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3_1_1__1__Impl_in_rule__FeatureCall__Group_1_3_1_1__17362);
            rule__FeatureCall__Group_1_3_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1_3_1_1__1"


    // $ANTLR start "rule__FeatureCall__Group_1_3_1_1__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3625:1: rule__FeatureCall__Group_1_3_1_1__1__Impl : ( ( rule__FeatureCall__ArgsAssignment_1_3_1_1_1 ) ) ;
    public final void rule__FeatureCall__Group_1_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3629:1: ( ( ( rule__FeatureCall__ArgsAssignment_1_3_1_1_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3630:1: ( ( rule__FeatureCall__ArgsAssignment_1_3_1_1_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3630:1: ( ( rule__FeatureCall__ArgsAssignment_1_3_1_1_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3631:1: ( rule__FeatureCall__ArgsAssignment_1_3_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getArgsAssignment_1_3_1_1_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3632:1: ( rule__FeatureCall__ArgsAssignment_1_3_1_1_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3632:2: rule__FeatureCall__ArgsAssignment_1_3_1_1_1
            {
            pushFollow(FOLLOW_rule__FeatureCall__ArgsAssignment_1_3_1_1_1_in_rule__FeatureCall__Group_1_3_1_1__1__Impl7389);
            rule__FeatureCall__ArgsAssignment_1_3_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallAccess().getArgsAssignment_1_3_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group_1_3_1_1__1__Impl"


    // $ANTLR start "rule__ElementReferenceExpression__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3646:1: rule__ElementReferenceExpression__Group__0 : rule__ElementReferenceExpression__Group__0__Impl rule__ElementReferenceExpression__Group__1 ;
    public final void rule__ElementReferenceExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3650:1: ( rule__ElementReferenceExpression__Group__0__Impl rule__ElementReferenceExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3651:2: rule__ElementReferenceExpression__Group__0__Impl rule__ElementReferenceExpression__Group__1
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group__0__Impl_in_rule__ElementReferenceExpression__Group__07423);
            rule__ElementReferenceExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group__1_in_rule__ElementReferenceExpression__Group__07426);
            rule__ElementReferenceExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__Group__0"


    // $ANTLR start "rule__ElementReferenceExpression__Group__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3658:1: rule__ElementReferenceExpression__Group__0__Impl : ( () ) ;
    public final void rule__ElementReferenceExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3662:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3663:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3663:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3664:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getElementReferenceExpressionAction_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3665:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3667:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getElementReferenceExpressionAccess().getElementReferenceExpressionAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__Group__0__Impl"


    // $ANTLR start "rule__ElementReferenceExpression__Group__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3677:1: rule__ElementReferenceExpression__Group__1 : rule__ElementReferenceExpression__Group__1__Impl rule__ElementReferenceExpression__Group__2 ;
    public final void rule__ElementReferenceExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3681:1: ( rule__ElementReferenceExpression__Group__1__Impl rule__ElementReferenceExpression__Group__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3682:2: rule__ElementReferenceExpression__Group__1__Impl rule__ElementReferenceExpression__Group__2
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group__1__Impl_in_rule__ElementReferenceExpression__Group__17484);
            rule__ElementReferenceExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group__2_in_rule__ElementReferenceExpression__Group__17487);
            rule__ElementReferenceExpression__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__Group__1"


    // $ANTLR start "rule__ElementReferenceExpression__Group__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3689:1: rule__ElementReferenceExpression__Group__1__Impl : ( ( rule__ElementReferenceExpression__ReferenceAssignment_1 ) ) ;
    public final void rule__ElementReferenceExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3693:1: ( ( ( rule__ElementReferenceExpression__ReferenceAssignment_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3694:1: ( ( rule__ElementReferenceExpression__ReferenceAssignment_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3694:1: ( ( rule__ElementReferenceExpression__ReferenceAssignment_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3695:1: ( rule__ElementReferenceExpression__ReferenceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getReferenceAssignment_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3696:1: ( rule__ElementReferenceExpression__ReferenceAssignment_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3696:2: rule__ElementReferenceExpression__ReferenceAssignment_1
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__ReferenceAssignment_1_in_rule__ElementReferenceExpression__Group__1__Impl7514);
            rule__ElementReferenceExpression__ReferenceAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getElementReferenceExpressionAccess().getReferenceAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__Group__1__Impl"


    // $ANTLR start "rule__ElementReferenceExpression__Group__2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3706:1: rule__ElementReferenceExpression__Group__2 : rule__ElementReferenceExpression__Group__2__Impl ;
    public final void rule__ElementReferenceExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3710:1: ( rule__ElementReferenceExpression__Group__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3711:2: rule__ElementReferenceExpression__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group__2__Impl_in_rule__ElementReferenceExpression__Group__27544);
            rule__ElementReferenceExpression__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__Group__2"


    // $ANTLR start "rule__ElementReferenceExpression__Group__2__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3717:1: rule__ElementReferenceExpression__Group__2__Impl : ( ( rule__ElementReferenceExpression__Group_2__0 )? ) ;
    public final void rule__ElementReferenceExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3721:1: ( ( ( rule__ElementReferenceExpression__Group_2__0 )? ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3722:1: ( ( rule__ElementReferenceExpression__Group_2__0 )? )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3722:1: ( ( rule__ElementReferenceExpression__Group_2__0 )? )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3723:1: ( rule__ElementReferenceExpression__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getGroup_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3724:1: ( rule__ElementReferenceExpression__Group_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==50) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3724:2: rule__ElementReferenceExpression__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2__0_in_rule__ElementReferenceExpression__Group__2__Impl7571);
                    rule__ElementReferenceExpression__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getElementReferenceExpressionAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__Group__2__Impl"


    // $ANTLR start "rule__ElementReferenceExpression__Group_2__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3740:1: rule__ElementReferenceExpression__Group_2__0 : rule__ElementReferenceExpression__Group_2__0__Impl rule__ElementReferenceExpression__Group_2__1 ;
    public final void rule__ElementReferenceExpression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3744:1: ( rule__ElementReferenceExpression__Group_2__0__Impl rule__ElementReferenceExpression__Group_2__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3745:2: rule__ElementReferenceExpression__Group_2__0__Impl rule__ElementReferenceExpression__Group_2__1
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2__0__Impl_in_rule__ElementReferenceExpression__Group_2__07608);
            rule__ElementReferenceExpression__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2__1_in_rule__ElementReferenceExpression__Group_2__07611);
            rule__ElementReferenceExpression__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__Group_2__0"


    // $ANTLR start "rule__ElementReferenceExpression__Group_2__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3752:1: rule__ElementReferenceExpression__Group_2__0__Impl : ( ( rule__ElementReferenceExpression__OperationCallAssignment_2_0 ) ) ;
    public final void rule__ElementReferenceExpression__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3756:1: ( ( ( rule__ElementReferenceExpression__OperationCallAssignment_2_0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3757:1: ( ( rule__ElementReferenceExpression__OperationCallAssignment_2_0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3757:1: ( ( rule__ElementReferenceExpression__OperationCallAssignment_2_0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3758:1: ( rule__ElementReferenceExpression__OperationCallAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getOperationCallAssignment_2_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3759:1: ( rule__ElementReferenceExpression__OperationCallAssignment_2_0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3759:2: rule__ElementReferenceExpression__OperationCallAssignment_2_0
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__OperationCallAssignment_2_0_in_rule__ElementReferenceExpression__Group_2__0__Impl7638);
            rule__ElementReferenceExpression__OperationCallAssignment_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getElementReferenceExpressionAccess().getOperationCallAssignment_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__Group_2__0__Impl"


    // $ANTLR start "rule__ElementReferenceExpression__Group_2__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3769:1: rule__ElementReferenceExpression__Group_2__1 : rule__ElementReferenceExpression__Group_2__1__Impl rule__ElementReferenceExpression__Group_2__2 ;
    public final void rule__ElementReferenceExpression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3773:1: ( rule__ElementReferenceExpression__Group_2__1__Impl rule__ElementReferenceExpression__Group_2__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3774:2: rule__ElementReferenceExpression__Group_2__1__Impl rule__ElementReferenceExpression__Group_2__2
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2__1__Impl_in_rule__ElementReferenceExpression__Group_2__17668);
            rule__ElementReferenceExpression__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2__2_in_rule__ElementReferenceExpression__Group_2__17671);
            rule__ElementReferenceExpression__Group_2__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__Group_2__1"


    // $ANTLR start "rule__ElementReferenceExpression__Group_2__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3781:1: rule__ElementReferenceExpression__Group_2__1__Impl : ( ( rule__ElementReferenceExpression__Group_2_1__0 )? ) ;
    public final void rule__ElementReferenceExpression__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3785:1: ( ( ( rule__ElementReferenceExpression__Group_2_1__0 )? ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3786:1: ( ( rule__ElementReferenceExpression__Group_2_1__0 )? )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3786:1: ( ( rule__ElementReferenceExpression__Group_2_1__0 )? )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3787:1: ( rule__ElementReferenceExpression__Group_2_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getGroup_2_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3788:1: ( rule__ElementReferenceExpression__Group_2_1__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=RULE_ID && LA27_0<=RULE_STRING)||(LA27_0>=27 && LA27_0<=28)||LA27_0==32||LA27_0==43||LA27_0==50) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3788:2: rule__ElementReferenceExpression__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2_1__0_in_rule__ElementReferenceExpression__Group_2__1__Impl7698);
                    rule__ElementReferenceExpression__Group_2_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getElementReferenceExpressionAccess().getGroup_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__Group_2__1__Impl"


    // $ANTLR start "rule__ElementReferenceExpression__Group_2__2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3798:1: rule__ElementReferenceExpression__Group_2__2 : rule__ElementReferenceExpression__Group_2__2__Impl ;
    public final void rule__ElementReferenceExpression__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3802:1: ( rule__ElementReferenceExpression__Group_2__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3803:2: rule__ElementReferenceExpression__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2__2__Impl_in_rule__ElementReferenceExpression__Group_2__27729);
            rule__ElementReferenceExpression__Group_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__Group_2__2"


    // $ANTLR start "rule__ElementReferenceExpression__Group_2__2__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3809:1: rule__ElementReferenceExpression__Group_2__2__Impl : ( ')' ) ;
    public final void rule__ElementReferenceExpression__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3813:1: ( ( ')' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3814:1: ( ')' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3814:1: ( ')' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3815:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getRightParenthesisKeyword_2_2()); 
            }
            match(input,48,FOLLOW_48_in_rule__ElementReferenceExpression__Group_2__2__Impl7757); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getElementReferenceExpressionAccess().getRightParenthesisKeyword_2_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__Group_2__2__Impl"


    // $ANTLR start "rule__ElementReferenceExpression__Group_2_1__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3834:1: rule__ElementReferenceExpression__Group_2_1__0 : rule__ElementReferenceExpression__Group_2_1__0__Impl rule__ElementReferenceExpression__Group_2_1__1 ;
    public final void rule__ElementReferenceExpression__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3838:1: ( rule__ElementReferenceExpression__Group_2_1__0__Impl rule__ElementReferenceExpression__Group_2_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3839:2: rule__ElementReferenceExpression__Group_2_1__0__Impl rule__ElementReferenceExpression__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2_1__0__Impl_in_rule__ElementReferenceExpression__Group_2_1__07794);
            rule__ElementReferenceExpression__Group_2_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2_1__1_in_rule__ElementReferenceExpression__Group_2_1__07797);
            rule__ElementReferenceExpression__Group_2_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__Group_2_1__0"


    // $ANTLR start "rule__ElementReferenceExpression__Group_2_1__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3846:1: rule__ElementReferenceExpression__Group_2_1__0__Impl : ( ( rule__ElementReferenceExpression__ArgsAssignment_2_1_0 ) ) ;
    public final void rule__ElementReferenceExpression__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3850:1: ( ( ( rule__ElementReferenceExpression__ArgsAssignment_2_1_0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3851:1: ( ( rule__ElementReferenceExpression__ArgsAssignment_2_1_0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3851:1: ( ( rule__ElementReferenceExpression__ArgsAssignment_2_1_0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3852:1: ( rule__ElementReferenceExpression__ArgsAssignment_2_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getArgsAssignment_2_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3853:1: ( rule__ElementReferenceExpression__ArgsAssignment_2_1_0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3853:2: rule__ElementReferenceExpression__ArgsAssignment_2_1_0
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__ArgsAssignment_2_1_0_in_rule__ElementReferenceExpression__Group_2_1__0__Impl7824);
            rule__ElementReferenceExpression__ArgsAssignment_2_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getElementReferenceExpressionAccess().getArgsAssignment_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__Group_2_1__0__Impl"


    // $ANTLR start "rule__ElementReferenceExpression__Group_2_1__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3863:1: rule__ElementReferenceExpression__Group_2_1__1 : rule__ElementReferenceExpression__Group_2_1__1__Impl ;
    public final void rule__ElementReferenceExpression__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3867:1: ( rule__ElementReferenceExpression__Group_2_1__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3868:2: rule__ElementReferenceExpression__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2_1__1__Impl_in_rule__ElementReferenceExpression__Group_2_1__17854);
            rule__ElementReferenceExpression__Group_2_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__Group_2_1__1"


    // $ANTLR start "rule__ElementReferenceExpression__Group_2_1__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3874:1: rule__ElementReferenceExpression__Group_2_1__1__Impl : ( ( rule__ElementReferenceExpression__Group_2_1_1__0 )* ) ;
    public final void rule__ElementReferenceExpression__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3878:1: ( ( ( rule__ElementReferenceExpression__Group_2_1_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3879:1: ( ( rule__ElementReferenceExpression__Group_2_1_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3879:1: ( ( rule__ElementReferenceExpression__Group_2_1_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3880:1: ( rule__ElementReferenceExpression__Group_2_1_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getGroup_2_1_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3881:1: ( rule__ElementReferenceExpression__Group_2_1_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==49) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3881:2: rule__ElementReferenceExpression__Group_2_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2_1_1__0_in_rule__ElementReferenceExpression__Group_2_1__1__Impl7881);
            	    rule__ElementReferenceExpression__Group_2_1_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getElementReferenceExpressionAccess().getGroup_2_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__Group_2_1__1__Impl"


    // $ANTLR start "rule__ElementReferenceExpression__Group_2_1_1__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3895:1: rule__ElementReferenceExpression__Group_2_1_1__0 : rule__ElementReferenceExpression__Group_2_1_1__0__Impl rule__ElementReferenceExpression__Group_2_1_1__1 ;
    public final void rule__ElementReferenceExpression__Group_2_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3899:1: ( rule__ElementReferenceExpression__Group_2_1_1__0__Impl rule__ElementReferenceExpression__Group_2_1_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3900:2: rule__ElementReferenceExpression__Group_2_1_1__0__Impl rule__ElementReferenceExpression__Group_2_1_1__1
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2_1_1__0__Impl_in_rule__ElementReferenceExpression__Group_2_1_1__07916);
            rule__ElementReferenceExpression__Group_2_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2_1_1__1_in_rule__ElementReferenceExpression__Group_2_1_1__07919);
            rule__ElementReferenceExpression__Group_2_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__Group_2_1_1__0"


    // $ANTLR start "rule__ElementReferenceExpression__Group_2_1_1__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3907:1: rule__ElementReferenceExpression__Group_2_1_1__0__Impl : ( ',' ) ;
    public final void rule__ElementReferenceExpression__Group_2_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3911:1: ( ( ',' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3912:1: ( ',' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3912:1: ( ',' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3913:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getCommaKeyword_2_1_1_0()); 
            }
            match(input,49,FOLLOW_49_in_rule__ElementReferenceExpression__Group_2_1_1__0__Impl7947); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getElementReferenceExpressionAccess().getCommaKeyword_2_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__Group_2_1_1__0__Impl"


    // $ANTLR start "rule__ElementReferenceExpression__Group_2_1_1__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3926:1: rule__ElementReferenceExpression__Group_2_1_1__1 : rule__ElementReferenceExpression__Group_2_1_1__1__Impl ;
    public final void rule__ElementReferenceExpression__Group_2_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3930:1: ( rule__ElementReferenceExpression__Group_2_1_1__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3931:2: rule__ElementReferenceExpression__Group_2_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2_1_1__1__Impl_in_rule__ElementReferenceExpression__Group_2_1_1__17978);
            rule__ElementReferenceExpression__Group_2_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__Group_2_1_1__1"


    // $ANTLR start "rule__ElementReferenceExpression__Group_2_1_1__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3937:1: rule__ElementReferenceExpression__Group_2_1_1__1__Impl : ( ( rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1 ) ) ;
    public final void rule__ElementReferenceExpression__Group_2_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3941:1: ( ( ( rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3942:1: ( ( rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3942:1: ( ( rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3943:1: ( rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getArgsAssignment_2_1_1_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3944:1: ( rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3944:2: rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1_in_rule__ElementReferenceExpression__Group_2_1_1__1__Impl8005);
            rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getElementReferenceExpressionAccess().getArgsAssignment_2_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__Group_2_1_1__1__Impl"


    // $ANTLR start "rule__ParenthesizedExpression__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3958:1: rule__ParenthesizedExpression__Group__0 : rule__ParenthesizedExpression__Group__0__Impl rule__ParenthesizedExpression__Group__1 ;
    public final void rule__ParenthesizedExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3962:1: ( rule__ParenthesizedExpression__Group__0__Impl rule__ParenthesizedExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3963:2: rule__ParenthesizedExpression__Group__0__Impl rule__ParenthesizedExpression__Group__1
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__0__Impl_in_rule__ParenthesizedExpression__Group__08039);
            rule__ParenthesizedExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__1_in_rule__ParenthesizedExpression__Group__08042);
            rule__ParenthesizedExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedExpression__Group__0"


    // $ANTLR start "rule__ParenthesizedExpression__Group__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3970:1: rule__ParenthesizedExpression__Group__0__Impl : ( () ) ;
    public final void rule__ParenthesizedExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3974:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3975:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3975:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3976:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParenthesizedExpressionAccess().getParenthesizedExpressionAction_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3977:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3979:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParenthesizedExpressionAccess().getParenthesizedExpressionAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedExpression__Group__0__Impl"


    // $ANTLR start "rule__ParenthesizedExpression__Group__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3989:1: rule__ParenthesizedExpression__Group__1 : rule__ParenthesizedExpression__Group__1__Impl rule__ParenthesizedExpression__Group__2 ;
    public final void rule__ParenthesizedExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3993:1: ( rule__ParenthesizedExpression__Group__1__Impl rule__ParenthesizedExpression__Group__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3994:2: rule__ParenthesizedExpression__Group__1__Impl rule__ParenthesizedExpression__Group__2
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__1__Impl_in_rule__ParenthesizedExpression__Group__18100);
            rule__ParenthesizedExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__2_in_rule__ParenthesizedExpression__Group__18103);
            rule__ParenthesizedExpression__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedExpression__Group__1"


    // $ANTLR start "rule__ParenthesizedExpression__Group__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4001:1: rule__ParenthesizedExpression__Group__1__Impl : ( '(' ) ;
    public final void rule__ParenthesizedExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4005:1: ( ( '(' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4006:1: ( '(' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4006:1: ( '(' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4007:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,50,FOLLOW_50_in_rule__ParenthesizedExpression__Group__1__Impl8131); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedExpression__Group__1__Impl"


    // $ANTLR start "rule__ParenthesizedExpression__Group__2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4020:1: rule__ParenthesizedExpression__Group__2 : rule__ParenthesizedExpression__Group__2__Impl rule__ParenthesizedExpression__Group__3 ;
    public final void rule__ParenthesizedExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4024:1: ( rule__ParenthesizedExpression__Group__2__Impl rule__ParenthesizedExpression__Group__3 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4025:2: rule__ParenthesizedExpression__Group__2__Impl rule__ParenthesizedExpression__Group__3
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__2__Impl_in_rule__ParenthesizedExpression__Group__28162);
            rule__ParenthesizedExpression__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__3_in_rule__ParenthesizedExpression__Group__28165);
            rule__ParenthesizedExpression__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedExpression__Group__2"


    // $ANTLR start "rule__ParenthesizedExpression__Group__2__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4032:1: rule__ParenthesizedExpression__Group__2__Impl : ( ( rule__ParenthesizedExpression__ExpressionAssignment_2 ) ) ;
    public final void rule__ParenthesizedExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4036:1: ( ( ( rule__ParenthesizedExpression__ExpressionAssignment_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4037:1: ( ( rule__ParenthesizedExpression__ExpressionAssignment_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4037:1: ( ( rule__ParenthesizedExpression__ExpressionAssignment_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4038:1: ( rule__ParenthesizedExpression__ExpressionAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParenthesizedExpressionAccess().getExpressionAssignment_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4039:1: ( rule__ParenthesizedExpression__ExpressionAssignment_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4039:2: rule__ParenthesizedExpression__ExpressionAssignment_2
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__ExpressionAssignment_2_in_rule__ParenthesizedExpression__Group__2__Impl8192);
            rule__ParenthesizedExpression__ExpressionAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParenthesizedExpressionAccess().getExpressionAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedExpression__Group__2__Impl"


    // $ANTLR start "rule__ParenthesizedExpression__Group__3"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4049:1: rule__ParenthesizedExpression__Group__3 : rule__ParenthesizedExpression__Group__3__Impl ;
    public final void rule__ParenthesizedExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4053:1: ( rule__ParenthesizedExpression__Group__3__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4054:2: rule__ParenthesizedExpression__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__3__Impl_in_rule__ParenthesizedExpression__Group__38222);
            rule__ParenthesizedExpression__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedExpression__Group__3"


    // $ANTLR start "rule__ParenthesizedExpression__Group__3__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4060:1: rule__ParenthesizedExpression__Group__3__Impl : ( ')' ) ;
    public final void rule__ParenthesizedExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4064:1: ( ( ')' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4065:1: ( ')' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4065:1: ( ')' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4066:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,48,FOLLOW_48_in_rule__ParenthesizedExpression__Group__3__Impl8250); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedExpression__Group__3__Impl"


    // $ANTLR start "rule__IntLiteral__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4088:1: rule__IntLiteral__Group__0 : rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 ;
    public final void rule__IntLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4092:1: ( rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4093:2: rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__08290);
            rule__IntLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__08293);
            rule__IntLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntLiteral__Group__0"


    // $ANTLR start "rule__IntLiteral__Group__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4100:1: rule__IntLiteral__Group__0__Impl : ( () ) ;
    public final void rule__IntLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4104:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4105:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4105:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4106:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4107:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4109:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntLiteral__Group__0__Impl"


    // $ANTLR start "rule__IntLiteral__Group__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4119:1: rule__IntLiteral__Group__1 : rule__IntLiteral__Group__1__Impl ;
    public final void rule__IntLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4123:1: ( rule__IntLiteral__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4124:2: rule__IntLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__18351);
            rule__IntLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntLiteral__Group__1"


    // $ANTLR start "rule__IntLiteral__Group__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4130:1: rule__IntLiteral__Group__1__Impl : ( ( rule__IntLiteral__ValueAssignment_1 ) ) ;
    public final void rule__IntLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4134:1: ( ( ( rule__IntLiteral__ValueAssignment_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4135:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4135:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4136:1: ( rule__IntLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4137:1: ( rule__IntLiteral__ValueAssignment_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4137:2: rule__IntLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl8378);
            rule__IntLiteral__ValueAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntLiteral__Group__1__Impl"


    // $ANTLR start "rule__RealLiteral__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4151:1: rule__RealLiteral__Group__0 : rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 ;
    public final void rule__RealLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4155:1: ( rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4156:2: rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__08412);
            rule__RealLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__08415);
            rule__RealLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteral__Group__0"


    // $ANTLR start "rule__RealLiteral__Group__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4163:1: rule__RealLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RealLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4167:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4168:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4168:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4169:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4170:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4172:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteral__Group__0__Impl"


    // $ANTLR start "rule__RealLiteral__Group__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4182:1: rule__RealLiteral__Group__1 : rule__RealLiteral__Group__1__Impl ;
    public final void rule__RealLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4186:1: ( rule__RealLiteral__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4187:2: rule__RealLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__18473);
            rule__RealLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteral__Group__1"


    // $ANTLR start "rule__RealLiteral__Group__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4193:1: rule__RealLiteral__Group__1__Impl : ( ( rule__RealLiteral__ValueAssignment_1 ) ) ;
    public final void rule__RealLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4197:1: ( ( ( rule__RealLiteral__ValueAssignment_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4198:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4198:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4199:1: ( rule__RealLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4200:1: ( rule__RealLiteral__ValueAssignment_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4200:2: rule__RealLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl8500);
            rule__RealLiteral__ValueAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteral__Group__1__Impl"


    // $ANTLR start "rule__HexLiteral__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4214:1: rule__HexLiteral__Group__0 : rule__HexLiteral__Group__0__Impl rule__HexLiteral__Group__1 ;
    public final void rule__HexLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4218:1: ( rule__HexLiteral__Group__0__Impl rule__HexLiteral__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4219:2: rule__HexLiteral__Group__0__Impl rule__HexLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__HexLiteral__Group__0__Impl_in_rule__HexLiteral__Group__08534);
            rule__HexLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__HexLiteral__Group__1_in_rule__HexLiteral__Group__08537);
            rule__HexLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HexLiteral__Group__0"


    // $ANTLR start "rule__HexLiteral__Group__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4226:1: rule__HexLiteral__Group__0__Impl : ( () ) ;
    public final void rule__HexLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4230:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4231:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4231:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4232:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHexLiteralAccess().getHexLiteralAction_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4233:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4235:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getHexLiteralAccess().getHexLiteralAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HexLiteral__Group__0__Impl"


    // $ANTLR start "rule__HexLiteral__Group__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4245:1: rule__HexLiteral__Group__1 : rule__HexLiteral__Group__1__Impl ;
    public final void rule__HexLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4249:1: ( rule__HexLiteral__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4250:2: rule__HexLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__HexLiteral__Group__1__Impl_in_rule__HexLiteral__Group__18595);
            rule__HexLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HexLiteral__Group__1"


    // $ANTLR start "rule__HexLiteral__Group__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4256:1: rule__HexLiteral__Group__1__Impl : ( ( rule__HexLiteral__ValueAssignment_1 ) ) ;
    public final void rule__HexLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4260:1: ( ( ( rule__HexLiteral__ValueAssignment_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4261:1: ( ( rule__HexLiteral__ValueAssignment_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4261:1: ( ( rule__HexLiteral__ValueAssignment_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4262:1: ( rule__HexLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHexLiteralAccess().getValueAssignment_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4263:1: ( rule__HexLiteral__ValueAssignment_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4263:2: rule__HexLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__HexLiteral__ValueAssignment_1_in_rule__HexLiteral__Group__1__Impl8622);
            rule__HexLiteral__ValueAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getHexLiteralAccess().getValueAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HexLiteral__Group__1__Impl"


    // $ANTLR start "rule__StringLiteral__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4277:1: rule__StringLiteral__Group__0 : rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 ;
    public final void rule__StringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4281:1: ( rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4282:2: rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__08656);
            rule__StringLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__08659);
            rule__StringLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__Group__0"


    // $ANTLR start "rule__StringLiteral__Group__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4289:1: rule__StringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__StringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4293:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4294:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4294:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4295:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4296:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4298:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__Group__0__Impl"


    // $ANTLR start "rule__StringLiteral__Group__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4308:1: rule__StringLiteral__Group__1 : rule__StringLiteral__Group__1__Impl ;
    public final void rule__StringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4312:1: ( rule__StringLiteral__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4313:2: rule__StringLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__18717);
            rule__StringLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__Group__1"


    // $ANTLR start "rule__StringLiteral__Group__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4319:1: rule__StringLiteral__Group__1__Impl : ( ( rule__StringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__StringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4323:1: ( ( ( rule__StringLiteral__ValueAssignment_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4324:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4324:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4325:1: ( rule__StringLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4326:1: ( rule__StringLiteral__ValueAssignment_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4326:2: rule__StringLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl8744);
            rule__StringLiteral__ValueAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__Group__1__Impl"


    // $ANTLR start "rule__AssignmentExpression__OperatorAssignment_1_1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4341:1: rule__AssignmentExpression__OperatorAssignment_1_1 : ( ruleAssignmentOperator ) ;
    public final void rule__AssignmentExpression__OperatorAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4345:1: ( ( ruleAssignmentOperator ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4346:1: ( ruleAssignmentOperator )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4346:1: ( ruleAssignmentOperator )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4347:1: ruleAssignmentOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentExpressionAccess().getOperatorAssignmentOperatorEnumRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleAssignmentOperator_in_rule__AssignmentExpression__OperatorAssignment_1_18783);
            ruleAssignmentOperator();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentExpressionAccess().getOperatorAssignmentOperatorEnumRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignmentExpression__OperatorAssignment_1_1"


    // $ANTLR start "rule__AssignmentExpression__ExpressionAssignment_1_2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4356:1: rule__AssignmentExpression__ExpressionAssignment_1_2 : ( ruleConditionalExpression ) ;
    public final void rule__AssignmentExpression__ExpressionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4360:1: ( ( ruleConditionalExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4361:1: ( ruleConditionalExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4361:1: ( ruleConditionalExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4362:1: ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentExpressionAccess().getExpressionConditionalExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleConditionalExpression_in_rule__AssignmentExpression__ExpressionAssignment_1_28814);
            ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentExpressionAccess().getExpressionConditionalExpressionParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignmentExpression__ExpressionAssignment_1_2"


    // $ANTLR start "rule__ConditionalExpression__TrueCaseAssignment_1_2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4371:1: rule__ConditionalExpression__TrueCaseAssignment_1_2 : ( ruleLogicalOrExpression ) ;
    public final void rule__ConditionalExpression__TrueCaseAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4375:1: ( ( ruleLogicalOrExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4376:1: ( ruleLogicalOrExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4376:1: ( ruleLogicalOrExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4377:1: ruleLogicalOrExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConditionalExpressionAccess().getTrueCaseLogicalOrExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_rule__ConditionalExpression__TrueCaseAssignment_1_28845);
            ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConditionalExpressionAccess().getTrueCaseLogicalOrExpressionParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__TrueCaseAssignment_1_2"


    // $ANTLR start "rule__ConditionalExpression__FalseCaseAssignment_1_4"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4386:1: rule__ConditionalExpression__FalseCaseAssignment_1_4 : ( ruleLogicalOrExpression ) ;
    public final void rule__ConditionalExpression__FalseCaseAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4390:1: ( ( ruleLogicalOrExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4391:1: ( ruleLogicalOrExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4391:1: ( ruleLogicalOrExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4392:1: ruleLogicalOrExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConditionalExpressionAccess().getFalseCaseLogicalOrExpressionParserRuleCall_1_4_0()); 
            }
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_rule__ConditionalExpression__FalseCaseAssignment_1_48876);
            ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConditionalExpressionAccess().getFalseCaseLogicalOrExpressionParserRuleCall_1_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__FalseCaseAssignment_1_4"


    // $ANTLR start "rule__LogicalOrExpression__RightOperandAssignment_1_2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4401:1: rule__LogicalOrExpression__RightOperandAssignment_1_2 : ( ruleLogicalAndExpression ) ;
    public final void rule__LogicalOrExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4405:1: ( ( ruleLogicalAndExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4406:1: ( ruleLogicalAndExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4406:1: ( ruleLogicalAndExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4407:1: ruleLogicalAndExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalOrExpressionAccess().getRightOperandLogicalAndExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_rule__LogicalOrExpression__RightOperandAssignment_1_28907);
            ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalOrExpressionAccess().getRightOperandLogicalAndExpressionParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalOrExpression__RightOperandAssignment_1_2"


    // $ANTLR start "rule__LogicalAndExpression__RightOperandAssignment_1_2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4416:1: rule__LogicalAndExpression__RightOperandAssignment_1_2 : ( ruleLogicalNotExpression ) ;
    public final void rule__LogicalAndExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4420:1: ( ( ruleLogicalNotExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4421:1: ( ruleLogicalNotExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4421:1: ( ruleLogicalNotExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4422:1: ruleLogicalNotExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalAndExpressionAccess().getRightOperandLogicalNotExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_rule__LogicalAndExpression__RightOperandAssignment_1_28938);
            ruleLogicalNotExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalAndExpressionAccess().getRightOperandLogicalNotExpressionParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalAndExpression__RightOperandAssignment_1_2"


    // $ANTLR start "rule__LogicalNotExpression__OperandAssignment_1_2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4431:1: rule__LogicalNotExpression__OperandAssignment_1_2 : ( ruleBitwiseXorExpression ) ;
    public final void rule__LogicalNotExpression__OperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4435:1: ( ( ruleBitwiseXorExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4436:1: ( ruleBitwiseXorExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4436:1: ( ruleBitwiseXorExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4437:1: ruleBitwiseXorExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalNotExpressionAccess().getOperandBitwiseXorExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleBitwiseXorExpression_in_rule__LogicalNotExpression__OperandAssignment_1_28969);
            ruleBitwiseXorExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalNotExpressionAccess().getOperandBitwiseXorExpressionParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalNotExpression__OperandAssignment_1_2"


    // $ANTLR start "rule__BitwiseXorExpression__RightOperandAssignment_1_2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4446:1: rule__BitwiseXorExpression__RightOperandAssignment_1_2 : ( ruleBitwiseOrExpression ) ;
    public final void rule__BitwiseXorExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4450:1: ( ( ruleBitwiseOrExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4451:1: ( ruleBitwiseOrExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4451:1: ( ruleBitwiseOrExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4452:1: ruleBitwiseOrExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseXorExpressionAccess().getRightOperandBitwiseOrExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleBitwiseOrExpression_in_rule__BitwiseXorExpression__RightOperandAssignment_1_29000);
            ruleBitwiseOrExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseXorExpressionAccess().getRightOperandBitwiseOrExpressionParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseXorExpression__RightOperandAssignment_1_2"


    // $ANTLR start "rule__BitwiseOrExpression__RightOperandAssignment_1_2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4461:1: rule__BitwiseOrExpression__RightOperandAssignment_1_2 : ( ruleBitwiseAndExpression ) ;
    public final void rule__BitwiseOrExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4465:1: ( ( ruleBitwiseAndExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4466:1: ( ruleBitwiseAndExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4466:1: ( ruleBitwiseAndExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4467:1: ruleBitwiseAndExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseOrExpressionAccess().getRightOperandBitwiseAndExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleBitwiseAndExpression_in_rule__BitwiseOrExpression__RightOperandAssignment_1_29031);
            ruleBitwiseAndExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseOrExpressionAccess().getRightOperandBitwiseAndExpressionParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseOrExpression__RightOperandAssignment_1_2"


    // $ANTLR start "rule__BitwiseAndExpression__RightOperandAssignment_1_2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4476:1: rule__BitwiseAndExpression__RightOperandAssignment_1_2 : ( ruleLogicalRelationExpression ) ;
    public final void rule__BitwiseAndExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4480:1: ( ( ruleLogicalRelationExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4481:1: ( ruleLogicalRelationExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4481:1: ( ruleLogicalRelationExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4482:1: ruleLogicalRelationExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseAndExpressionAccess().getRightOperandLogicalRelationExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleLogicalRelationExpression_in_rule__BitwiseAndExpression__RightOperandAssignment_1_29062);
            ruleLogicalRelationExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitwiseAndExpressionAccess().getRightOperandLogicalRelationExpressionParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BitwiseAndExpression__RightOperandAssignment_1_2"


    // $ANTLR start "rule__LogicalRelationExpression__OperatorAssignment_1_1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4491:1: rule__LogicalRelationExpression__OperatorAssignment_1_1 : ( ruleRelationalOperator ) ;
    public final void rule__LogicalRelationExpression__OperatorAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4495:1: ( ( ruleRelationalOperator ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4496:1: ( ruleRelationalOperator )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4496:1: ( ruleRelationalOperator )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4497:1: ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalRelationExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_rule__LogicalRelationExpression__OperatorAssignment_1_19093);
            ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalRelationExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalRelationExpression__OperatorAssignment_1_1"


    // $ANTLR start "rule__LogicalRelationExpression__RightOperandAssignment_1_2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4506:1: rule__LogicalRelationExpression__RightOperandAssignment_1_2 : ( ruleShiftExpression ) ;
    public final void rule__LogicalRelationExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4510:1: ( ( ruleShiftExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4511:1: ( ruleShiftExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4511:1: ( ruleShiftExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4512:1: ruleShiftExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalRelationExpressionAccess().getRightOperandShiftExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleShiftExpression_in_rule__LogicalRelationExpression__RightOperandAssignment_1_29124);
            ruleShiftExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicalRelationExpressionAccess().getRightOperandShiftExpressionParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalRelationExpression__RightOperandAssignment_1_2"


    // $ANTLR start "rule__ShiftExpression__OperatorAssignment_1_1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4521:1: rule__ShiftExpression__OperatorAssignment_1_1 : ( ruleShiftOperator ) ;
    public final void rule__ShiftExpression__OperatorAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4525:1: ( ( ruleShiftOperator ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4526:1: ( ruleShiftOperator )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4526:1: ( ruleShiftOperator )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4527:1: ruleShiftOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExpressionAccess().getOperatorShiftOperatorEnumRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleShiftOperator_in_rule__ShiftExpression__OperatorAssignment_1_19155);
            ruleShiftOperator();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExpressionAccess().getOperatorShiftOperatorEnumRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShiftExpression__OperatorAssignment_1_1"


    // $ANTLR start "rule__ShiftExpression__RightOperandAssignment_1_2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4536:1: rule__ShiftExpression__RightOperandAssignment_1_2 : ( ruleNumericalAddSubtractExpression ) ;
    public final void rule__ShiftExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4540:1: ( ( ruleNumericalAddSubtractExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4541:1: ( ruleNumericalAddSubtractExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4541:1: ( ruleNumericalAddSubtractExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4542:1: ruleNumericalAddSubtractExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExpressionAccess().getRightOperandNumericalAddSubtractExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_rule__ShiftExpression__RightOperandAssignment_1_29186);
            ruleNumericalAddSubtractExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExpressionAccess().getRightOperandNumericalAddSubtractExpressionParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShiftExpression__RightOperandAssignment_1_2"


    // $ANTLR start "rule__NumericalAddSubtractExpression__OperatorAssignment_1_1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4551:1: rule__NumericalAddSubtractExpression__OperatorAssignment_1_1 : ( ruleAdditiveOperator ) ;
    public final void rule__NumericalAddSubtractExpression__OperatorAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4555:1: ( ( ruleAdditiveOperator ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4556:1: ( ruleAdditiveOperator )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4556:1: ( ruleAdditiveOperator )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4557:1: ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalAddSubtractExpressionAccess().getOperatorAdditiveOperatorEnumRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_rule__NumericalAddSubtractExpression__OperatorAssignment_1_19217);
            ruleAdditiveOperator();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalAddSubtractExpressionAccess().getOperatorAdditiveOperatorEnumRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalAddSubtractExpression__OperatorAssignment_1_1"


    // $ANTLR start "rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4566:1: rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2 : ( ruleNumericalMultiplyDivideExpression ) ;
    public final void rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4570:1: ( ( ruleNumericalMultiplyDivideExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4571:1: ( ruleNumericalMultiplyDivideExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4571:1: ( ruleNumericalMultiplyDivideExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4572:1: ruleNumericalMultiplyDivideExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalAddSubtractExpressionAccess().getRightOperandNumericalMultiplyDivideExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_rule__NumericalAddSubtractExpression__RightOperandAssignment_1_29248);
            ruleNumericalMultiplyDivideExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalAddSubtractExpressionAccess().getRightOperandNumericalMultiplyDivideExpressionParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2"


    // $ANTLR start "rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4581:1: rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1 : ( ruleMultiplicativeOperator ) ;
    public final void rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4585:1: ( ( ruleMultiplicativeOperator ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4586:1: ( ruleMultiplicativeOperator )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4586:1: ( ruleMultiplicativeOperator )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4587:1: ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getOperatorMultiplicativeOperatorEnumRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_19279);
            ruleMultiplicativeOperator();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getOperatorMultiplicativeOperatorEnumRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1"


    // $ANTLR start "rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4596:1: rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2 : ( ruleNumericalUnaryExpression ) ;
    public final void rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4600:1: ( ( ruleNumericalUnaryExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4601:1: ( ruleNumericalUnaryExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4601:1: ( ruleNumericalUnaryExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4602:1: ruleNumericalUnaryExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getRightOperandNumericalUnaryExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_29310);
            ruleNumericalUnaryExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getRightOperandNumericalUnaryExpressionParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2"


    // $ANTLR start "rule__NumericalUnaryExpression__OperatorAssignment_1_1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4611:1: rule__NumericalUnaryExpression__OperatorAssignment_1_1 : ( ruleUnaryOperator ) ;
    public final void rule__NumericalUnaryExpression__OperatorAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4615:1: ( ( ruleUnaryOperator ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4616:1: ( ruleUnaryOperator )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4616:1: ( ruleUnaryOperator )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4617:1: ruleUnaryOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalUnaryExpressionAccess().getOperatorUnaryOperatorEnumRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleUnaryOperator_in_rule__NumericalUnaryExpression__OperatorAssignment_1_19341);
            ruleUnaryOperator();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalUnaryExpressionAccess().getOperatorUnaryOperatorEnumRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalUnaryExpression__OperatorAssignment_1_1"


    // $ANTLR start "rule__NumericalUnaryExpression__OperandAssignment_1_2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4626:1: rule__NumericalUnaryExpression__OperandAssignment_1_2 : ( rulePrimaryExpression ) ;
    public final void rule__NumericalUnaryExpression__OperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4630:1: ( ( rulePrimaryExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4631:1: ( rulePrimaryExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4631:1: ( rulePrimaryExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4632:1: rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalUnaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_rule__NumericalUnaryExpression__OperandAssignment_1_29372);
            rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumericalUnaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericalUnaryExpression__OperandAssignment_1_2"


    // $ANTLR start "rule__PrimitiveValueExpression__ValueAssignment_1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4641:1: rule__PrimitiveValueExpression__ValueAssignment_1 : ( ruleLiteral ) ;
    public final void rule__PrimitiveValueExpression__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4645:1: ( ( ruleLiteral ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4646:1: ( ruleLiteral )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4646:1: ( ruleLiteral )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4647:1: ruleLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveValueExpressionAccess().getValueLiteralParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleLiteral_in_rule__PrimitiveValueExpression__ValueAssignment_19403);
            ruleLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimitiveValueExpressionAccess().getValueLiteralParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveValueExpression__ValueAssignment_1"


    // $ANTLR start "rule__FeatureCall__FeatureAssignment_1_2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4656:1: rule__FeatureCall__FeatureAssignment_1_2 : ( ( RULE_ID ) ) ;
    public final void rule__FeatureCall__FeatureAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4660:1: ( ( ( RULE_ID ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4661:1: ( ( RULE_ID ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4661:1: ( ( RULE_ID ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4662:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getFeatureEObjectCrossReference_1_2_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4663:1: ( RULE_ID )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4664:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getFeatureEObjectIDTerminalRuleCall_1_2_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FeatureCall__FeatureAssignment_1_29438); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallAccess().getFeatureEObjectIDTerminalRuleCall_1_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallAccess().getFeatureEObjectCrossReference_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__FeatureAssignment_1_2"


    // $ANTLR start "rule__FeatureCall__OperationCallAssignment_1_3_0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4675:1: rule__FeatureCall__OperationCallAssignment_1_3_0 : ( ( '(' ) ) ;
    public final void rule__FeatureCall__OperationCallAssignment_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4679:1: ( ( ( '(' ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4680:1: ( ( '(' ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4680:1: ( ( '(' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4681:1: ( '(' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getOperationCallLeftParenthesisKeyword_1_3_0_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4682:1: ( '(' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4683:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getOperationCallLeftParenthesisKeyword_1_3_0_0()); 
            }
            match(input,50,FOLLOW_50_in_rule__FeatureCall__OperationCallAssignment_1_3_09478); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallAccess().getOperationCallLeftParenthesisKeyword_1_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallAccess().getOperationCallLeftParenthesisKeyword_1_3_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__OperationCallAssignment_1_3_0"


    // $ANTLR start "rule__FeatureCall__ArgsAssignment_1_3_1_0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4698:1: rule__FeatureCall__ArgsAssignment_1_3_1_0 : ( ruleExpression ) ;
    public final void rule__FeatureCall__ArgsAssignment_1_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4702:1: ( ( ruleExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4703:1: ( ruleExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4703:1: ( ruleExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4704:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getArgsExpressionParserRuleCall_1_3_1_0_0()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__FeatureCall__ArgsAssignment_1_3_1_09517);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallAccess().getArgsExpressionParserRuleCall_1_3_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__ArgsAssignment_1_3_1_0"


    // $ANTLR start "rule__FeatureCall__ArgsAssignment_1_3_1_1_1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4713:1: rule__FeatureCall__ArgsAssignment_1_3_1_1_1 : ( ruleExpression ) ;
    public final void rule__FeatureCall__ArgsAssignment_1_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4717:1: ( ( ruleExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4718:1: ( ruleExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4718:1: ( ruleExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4719:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getArgsExpressionParserRuleCall_1_3_1_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__FeatureCall__ArgsAssignment_1_3_1_1_19548);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallAccess().getArgsExpressionParserRuleCall_1_3_1_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__ArgsAssignment_1_3_1_1_1"


    // $ANTLR start "rule__ElementReferenceExpression__ReferenceAssignment_1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4728:1: rule__ElementReferenceExpression__ReferenceAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ElementReferenceExpression__ReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4732:1: ( ( ( RULE_ID ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4733:1: ( ( RULE_ID ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4733:1: ( ( RULE_ID ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4734:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getReferenceEObjectCrossReference_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4735:1: ( RULE_ID )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4736:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getReferenceEObjectIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ElementReferenceExpression__ReferenceAssignment_19583); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getElementReferenceExpressionAccess().getReferenceEObjectIDTerminalRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getElementReferenceExpressionAccess().getReferenceEObjectCrossReference_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__ReferenceAssignment_1"


    // $ANTLR start "rule__ElementReferenceExpression__OperationCallAssignment_2_0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4747:1: rule__ElementReferenceExpression__OperationCallAssignment_2_0 : ( ( '(' ) ) ;
    public final void rule__ElementReferenceExpression__OperationCallAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4751:1: ( ( ( '(' ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4752:1: ( ( '(' ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4752:1: ( ( '(' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4753:1: ( '(' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getOperationCallLeftParenthesisKeyword_2_0_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4754:1: ( '(' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4755:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getOperationCallLeftParenthesisKeyword_2_0_0()); 
            }
            match(input,50,FOLLOW_50_in_rule__ElementReferenceExpression__OperationCallAssignment_2_09623); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getElementReferenceExpressionAccess().getOperationCallLeftParenthesisKeyword_2_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getElementReferenceExpressionAccess().getOperationCallLeftParenthesisKeyword_2_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__OperationCallAssignment_2_0"


    // $ANTLR start "rule__ElementReferenceExpression__ArgsAssignment_2_1_0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4770:1: rule__ElementReferenceExpression__ArgsAssignment_2_1_0 : ( ruleExpression ) ;
    public final void rule__ElementReferenceExpression__ArgsAssignment_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4774:1: ( ( ruleExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4775:1: ( ruleExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4775:1: ( ruleExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4776:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getArgsExpressionParserRuleCall_2_1_0_0()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__ElementReferenceExpression__ArgsAssignment_2_1_09662);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getElementReferenceExpressionAccess().getArgsExpressionParserRuleCall_2_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__ArgsAssignment_2_1_0"


    // $ANTLR start "rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4785:1: rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1 : ( ruleExpression ) ;
    public final void rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4789:1: ( ( ruleExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4790:1: ( ruleExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4790:1: ( ruleExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4791:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getArgsExpressionParserRuleCall_2_1_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__ElementReferenceExpression__ArgsAssignment_2_1_1_19693);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getElementReferenceExpressionAccess().getArgsExpressionParserRuleCall_2_1_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1"


    // $ANTLR start "rule__ParenthesizedExpression__ExpressionAssignment_2"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4800:1: rule__ParenthesizedExpression__ExpressionAssignment_2 : ( ruleExpression ) ;
    public final void rule__ParenthesizedExpression__ExpressionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4804:1: ( ( ruleExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4805:1: ( ruleExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4805:1: ( ruleExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4806:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParenthesizedExpressionAccess().getExpressionExpressionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__ParenthesizedExpression__ExpressionAssignment_29724);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParenthesizedExpressionAccess().getExpressionExpressionParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedExpression__ExpressionAssignment_2"


    // $ANTLR start "rule__IntLiteral__ValueAssignment_1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4816:1: rule__IntLiteral__ValueAssignment_1 : ( RULE_INT ) ;
    public final void rule__IntLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4820:1: ( ( RULE_INT ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4821:1: ( RULE_INT )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4821:1: ( RULE_INT )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4822:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getValueINTTerminalRuleCall_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__IntLiteral__ValueAssignment_19756); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntLiteralAccess().getValueINTTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntLiteral__ValueAssignment_1"


    // $ANTLR start "rule__RealLiteral__ValueAssignment_1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4831:1: rule__RealLiteral__ValueAssignment_1 : ( RULE_FLOAT ) ;
    public final void rule__RealLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4835:1: ( ( RULE_FLOAT ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4836:1: ( RULE_FLOAT )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4836:1: ( RULE_FLOAT )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4837:1: RULE_FLOAT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getValueFLOATTerminalRuleCall_1_0()); 
            }
            match(input,RULE_FLOAT,FOLLOW_RULE_FLOAT_in_rule__RealLiteral__ValueAssignment_19787); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralAccess().getValueFLOATTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteral__ValueAssignment_1"


    // $ANTLR start "rule__HexLiteral__ValueAssignment_1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4846:1: rule__HexLiteral__ValueAssignment_1 : ( RULE_HEX ) ;
    public final void rule__HexLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4850:1: ( ( RULE_HEX ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4851:1: ( RULE_HEX )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4851:1: ( RULE_HEX )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4852:1: RULE_HEX
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHexLiteralAccess().getValueHEXTerminalRuleCall_1_0()); 
            }
            match(input,RULE_HEX,FOLLOW_RULE_HEX_in_rule__HexLiteral__ValueAssignment_19818); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHexLiteralAccess().getValueHEXTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HexLiteral__ValueAssignment_1"


    // $ANTLR start "rule__StringLiteral__ValueAssignment_1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4861:1: rule__StringLiteral__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4865:1: ( ( RULE_STRING ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4866:1: ( RULE_STRING )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4866:1: ( RULE_STRING )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4867:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_19849); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__ValueAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentExpression_in_ruleExpression100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentExpression_in_entryRuleAssignmentExpression126 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentExpression133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__Group__0_in_ruleAssignmentExpression159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression186 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group__0_in_ruleConditionalExpression219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOrExpression253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__Group__0_in_ruleLogicalOrExpression279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalAndExpression313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__Group__0_in_ruleLogicalAndExpression339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression366 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalNotExpression373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalNotExpression__Alternatives_in_ruleLogicalNotExpression399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseXorExpression_in_entryRuleBitwiseXorExpression426 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseXorExpression433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__Group__0_in_ruleBitwiseXorExpression459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpression_in_entryRuleBitwiseOrExpression486 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseOrExpression493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__Group__0_in_ruleBitwiseOrExpression519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpression_in_entryRuleBitwiseAndExpression546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseAndExpression553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__Group__0_in_ruleBitwiseAndExpression579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_entryRuleLogicalRelationExpression606 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalRelationExpression613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__Group__0_in_ruleLogicalRelationExpression639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_entryRuleShiftExpression666 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShiftExpression673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpression__Group__0_in_ruleShiftExpression699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_entryRuleNumericalAddSubtractExpression726 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalAddSubtractExpression733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__Group__0_in_ruleNumericalAddSubtractExpression759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_entryRuleNumericalMultiplyDivideExpression786 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalMultiplyDivideExpression793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__Group__0_in_ruleNumericalMultiplyDivideExpression819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_entryRuleNumericalUnaryExpression846 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalUnaryExpression853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalUnaryExpression__Alternatives_in_ruleNumericalUnaryExpression879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression906 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Alternatives_in_rulePrimaryExpression939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveValueExpression_in_entryRulePrimitiveValueExpression966 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveValueExpression973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimitiveValueExpression__Group__0_in_rulePrimitiveValueExpression999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall1026 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCall1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group__0_in_ruleFeatureCall1059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementReferenceExpression_in_entryRuleElementReferenceExpression1086 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElementReferenceExpression1093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group__0_in_ruleElementReferenceExpression1119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression1146 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression1153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__0_in_ruleParenthesizedExpression1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral1206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral1213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Alternatives_in_ruleLiteral1239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral1268 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral1275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral1301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral1328 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral1335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral1361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexLiteral_in_entryRuleHexLiteral1388 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexLiteral1395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HexLiteral__Group__0_in_ruleHexLiteral1421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral1448 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral1481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentOperator__Alternatives_in_ruleAssignmentOperator1518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftOperator__Alternatives_in_ruleShiftOperator1554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveOperator__Alternatives_in_ruleAdditiveOperator1590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeOperator__Alternatives_in_ruleMultiplicativeOperator1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryOperator__Alternatives_in_ruleUnaryOperator1662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalOperator__Alternatives_in_ruleRelationalOperator1698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseXorExpression_in_rule__LogicalNotExpression__Alternatives1733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalNotExpression__Group_1__0_in_rule__LogicalNotExpression__Alternatives1750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__NumericalUnaryExpression__Alternatives1783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalUnaryExpression__Group_1__0_in_rule__NumericalUnaryExpression__Alternatives1800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveValueExpression_in_rule__PrimaryExpression__Alternatives1833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_rule__PrimaryExpression__Alternatives1850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_rule__PrimaryExpression__Alternatives1867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_rule__Literal__Alternatives1899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexLiteral_in_rule__Literal__Alternatives1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_rule__Literal__Alternatives1933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives1950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__AssignmentOperator__Alternatives1983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__AssignmentOperator__Alternatives2004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__AssignmentOperator__Alternatives2025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__AssignmentOperator__Alternatives2046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__AssignmentOperator__Alternatives2067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__AssignmentOperator__Alternatives2088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__AssignmentOperator__Alternatives2109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__AssignmentOperator__Alternatives2130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__AssignmentOperator__Alternatives2151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__AssignmentOperator__Alternatives2172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__AssignmentOperator__Alternatives2193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ShiftOperator__Alternatives2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ShiftOperator__Alternatives2250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__AdditiveOperator__Alternatives2286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__AdditiveOperator__Alternatives2307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__MultiplicativeOperator__Alternatives2343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__MultiplicativeOperator__Alternatives2364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__MultiplicativeOperator__Alternatives2385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__UnaryOperator__Alternatives2421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__UnaryOperator__Alternatives2442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__UnaryOperator__Alternatives2463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__RelationalOperator__Alternatives2499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__RelationalOperator__Alternatives2520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__RelationalOperator__Alternatives2541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__RelationalOperator__Alternatives2562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__RelationalOperator__Alternatives2583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__RelationalOperator__Alternatives2604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__Group__0__Impl_in_rule__AssignmentExpression__Group__02637 = new BitSet(new long[]{0x0000000001FFC000L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__Group__1_in_rule__AssignmentExpression__Group__02640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_rule__AssignmentExpression__Group__0__Impl2667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__Group__1__Impl_in_rule__AssignmentExpression__Group__12696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__Group_1__0_in_rule__AssignmentExpression__Group__1__Impl2723 = new BitSet(new long[]{0x0000000001FFC002L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__Group_1__0__Impl_in_rule__AssignmentExpression__Group_1__02758 = new BitSet(new long[]{0x0000000001FFC000L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__Group_1__1_in_rule__AssignmentExpression__Group_1__02761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__Group_1__1__Impl_in_rule__AssignmentExpression__Group_1__12819 = new BitSet(new long[]{0x00040801180001F0L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__Group_1__2_in_rule__AssignmentExpression__Group_1__12822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__OperatorAssignment_1_1_in_rule__AssignmentExpression__Group_1__1__Impl2849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__Group_1__2__Impl_in_rule__AssignmentExpression__Group_1__22879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__ExpressionAssignment_1_2_in_rule__AssignmentExpression__Group_1__2__Impl2906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group__0__Impl_in_rule__ConditionalExpression__Group__02942 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group__1_in_rule__ConditionalExpression__Group__02945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_rule__ConditionalExpression__Group__0__Impl2972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group__1__Impl_in_rule__ConditionalExpression__Group__13001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__0_in_rule__ConditionalExpression__Group__1__Impl3028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__0__Impl_in_rule__ConditionalExpression__Group_1__03063 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__1_in_rule__ConditionalExpression__Group_1__03066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__1__Impl_in_rule__ConditionalExpression__Group_1__13124 = new BitSet(new long[]{0x00040801180001F0L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__2_in_rule__ConditionalExpression__Group_1__13127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ConditionalExpression__Group_1__1__Impl3155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__2__Impl_in_rule__ConditionalExpression__Group_1__23186 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__3_in_rule__ConditionalExpression__Group_1__23189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__TrueCaseAssignment_1_2_in_rule__ConditionalExpression__Group_1__2__Impl3216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__3__Impl_in_rule__ConditionalExpression__Group_1__33246 = new BitSet(new long[]{0x00040801180001F0L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__4_in_rule__ConditionalExpression__Group_1__33249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ConditionalExpression__Group_1__3__Impl3277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__4__Impl_in_rule__ConditionalExpression__Group_1__43308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__FalseCaseAssignment_1_4_in_rule__ConditionalExpression__Group_1__4__Impl3335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__Group__0__Impl_in_rule__LogicalOrExpression__Group__03375 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__Group__1_in_rule__LogicalOrExpression__Group__03378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_rule__LogicalOrExpression__Group__0__Impl3405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__Group__1__Impl_in_rule__LogicalOrExpression__Group__13434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__Group_1__0_in_rule__LogicalOrExpression__Group__1__Impl3461 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__Group_1__0__Impl_in_rule__LogicalOrExpression__Group_1__03496 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__Group_1__1_in_rule__LogicalOrExpression__Group_1__03499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__Group_1__1__Impl_in_rule__LogicalOrExpression__Group_1__13557 = new BitSet(new long[]{0x00040801180001F0L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__Group_1__2_in_rule__LogicalOrExpression__Group_1__13560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__LogicalOrExpression__Group_1__1__Impl3588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__Group_1__2__Impl_in_rule__LogicalOrExpression__Group_1__23619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__RightOperandAssignment_1_2_in_rule__LogicalOrExpression__Group_1__2__Impl3646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__Group__0__Impl_in_rule__LogicalAndExpression__Group__03682 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__Group__1_in_rule__LogicalAndExpression__Group__03685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_rule__LogicalAndExpression__Group__0__Impl3712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__Group__1__Impl_in_rule__LogicalAndExpression__Group__13741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__Group_1__0_in_rule__LogicalAndExpression__Group__1__Impl3768 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__Group_1__0__Impl_in_rule__LogicalAndExpression__Group_1__03803 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__Group_1__1_in_rule__LogicalAndExpression__Group_1__03806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__Group_1__1__Impl_in_rule__LogicalAndExpression__Group_1__13864 = new BitSet(new long[]{0x00040801180001F0L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__Group_1__2_in_rule__LogicalAndExpression__Group_1__13867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__LogicalAndExpression__Group_1__1__Impl3895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__Group_1__2__Impl_in_rule__LogicalAndExpression__Group_1__23926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__RightOperandAssignment_1_2_in_rule__LogicalAndExpression__Group_1__2__Impl3953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalNotExpression__Group_1__0__Impl_in_rule__LogicalNotExpression__Group_1__03989 = new BitSet(new long[]{0x00040801180001F0L});
    public static final BitSet FOLLOW_rule__LogicalNotExpression__Group_1__1_in_rule__LogicalNotExpression__Group_1__03992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalNotExpression__Group_1__1__Impl_in_rule__LogicalNotExpression__Group_1__14050 = new BitSet(new long[]{0x00040001180001F0L});
    public static final BitSet FOLLOW_rule__LogicalNotExpression__Group_1__2_in_rule__LogicalNotExpression__Group_1__14053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__LogicalNotExpression__Group_1__1__Impl4081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalNotExpression__Group_1__2__Impl_in_rule__LogicalNotExpression__Group_1__24112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalNotExpression__OperandAssignment_1_2_in_rule__LogicalNotExpression__Group_1__2__Impl4139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__Group__0__Impl_in_rule__BitwiseXorExpression__Group__04175 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__Group__1_in_rule__BitwiseXorExpression__Group__04178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpression_in_rule__BitwiseXorExpression__Group__0__Impl4205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__Group__1__Impl_in_rule__BitwiseXorExpression__Group__14234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__Group_1__0_in_rule__BitwiseXorExpression__Group__1__Impl4261 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__Group_1__0__Impl_in_rule__BitwiseXorExpression__Group_1__04296 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__Group_1__1_in_rule__BitwiseXorExpression__Group_1__04299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__Group_1__1__Impl_in_rule__BitwiseXorExpression__Group_1__14357 = new BitSet(new long[]{0x00040001180001F0L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__Group_1__2_in_rule__BitwiseXorExpression__Group_1__14360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__BitwiseXorExpression__Group_1__1__Impl4388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__Group_1__2__Impl_in_rule__BitwiseXorExpression__Group_1__24419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__RightOperandAssignment_1_2_in_rule__BitwiseXorExpression__Group_1__2__Impl4446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__Group__0__Impl_in_rule__BitwiseOrExpression__Group__04482 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__Group__1_in_rule__BitwiseOrExpression__Group__04485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpression_in_rule__BitwiseOrExpression__Group__0__Impl4512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__Group__1__Impl_in_rule__BitwiseOrExpression__Group__14541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__Group_1__0_in_rule__BitwiseOrExpression__Group__1__Impl4568 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__Group_1__0__Impl_in_rule__BitwiseOrExpression__Group_1__04603 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__Group_1__1_in_rule__BitwiseOrExpression__Group_1__04606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__Group_1__1__Impl_in_rule__BitwiseOrExpression__Group_1__14664 = new BitSet(new long[]{0x00040001180001F0L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__Group_1__2_in_rule__BitwiseOrExpression__Group_1__14667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__BitwiseOrExpression__Group_1__1__Impl4695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__Group_1__2__Impl_in_rule__BitwiseOrExpression__Group_1__24726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__RightOperandAssignment_1_2_in_rule__BitwiseOrExpression__Group_1__2__Impl4753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__Group__0__Impl_in_rule__BitwiseAndExpression__Group__04789 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__Group__1_in_rule__BitwiseAndExpression__Group__04792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_rule__BitwiseAndExpression__Group__0__Impl4819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__Group__1__Impl_in_rule__BitwiseAndExpression__Group__14848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__Group_1__0_in_rule__BitwiseAndExpression__Group__1__Impl4875 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__Group_1__0__Impl_in_rule__BitwiseAndExpression__Group_1__04910 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__Group_1__1_in_rule__BitwiseAndExpression__Group_1__04913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__Group_1__1__Impl_in_rule__BitwiseAndExpression__Group_1__14971 = new BitSet(new long[]{0x00040001180001F0L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__Group_1__2_in_rule__BitwiseAndExpression__Group_1__14974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__BitwiseAndExpression__Group_1__1__Impl5002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__Group_1__2__Impl_in_rule__BitwiseAndExpression__Group_1__25033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__RightOperandAssignment_1_2_in_rule__BitwiseAndExpression__Group_1__2__Impl5060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__Group__0__Impl_in_rule__LogicalRelationExpression__Group__05096 = new BitSet(new long[]{0x0000007E00000000L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__Group__1_in_rule__LogicalRelationExpression__Group__05099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_rule__LogicalRelationExpression__Group__0__Impl5126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__Group__1__Impl_in_rule__LogicalRelationExpression__Group__15155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__Group_1__0_in_rule__LogicalRelationExpression__Group__1__Impl5182 = new BitSet(new long[]{0x0000007E00000002L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__Group_1__0__Impl_in_rule__LogicalRelationExpression__Group_1__05217 = new BitSet(new long[]{0x0000007E00000000L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__Group_1__1_in_rule__LogicalRelationExpression__Group_1__05220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__Group_1__1__Impl_in_rule__LogicalRelationExpression__Group_1__15278 = new BitSet(new long[]{0x00040001180001F0L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__Group_1__2_in_rule__LogicalRelationExpression__Group_1__15281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__OperatorAssignment_1_1_in_rule__LogicalRelationExpression__Group_1__1__Impl5308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__Group_1__2__Impl_in_rule__LogicalRelationExpression__Group_1__25338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__RightOperandAssignment_1_2_in_rule__LogicalRelationExpression__Group_1__2__Impl5365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpression__Group__0__Impl_in_rule__ShiftExpression__Group__05401 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_rule__ShiftExpression__Group__1_in_rule__ShiftExpression__Group__05404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_rule__ShiftExpression__Group__0__Impl5431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpression__Group__1__Impl_in_rule__ShiftExpression__Group__15460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpression__Group_1__0_in_rule__ShiftExpression__Group__1__Impl5487 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_rule__ShiftExpression__Group_1__0__Impl_in_rule__ShiftExpression__Group_1__05522 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_rule__ShiftExpression__Group_1__1_in_rule__ShiftExpression__Group_1__05525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpression__Group_1__1__Impl_in_rule__ShiftExpression__Group_1__15583 = new BitSet(new long[]{0x00040001180001F0L});
    public static final BitSet FOLLOW_rule__ShiftExpression__Group_1__2_in_rule__ShiftExpression__Group_1__15586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpression__OperatorAssignment_1_1_in_rule__ShiftExpression__Group_1__1__Impl5613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpression__Group_1__2__Impl_in_rule__ShiftExpression__Group_1__25643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpression__RightOperandAssignment_1_2_in_rule__ShiftExpression__Group_1__2__Impl5670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__Group__0__Impl_in_rule__NumericalAddSubtractExpression__Group__05706 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__Group__1_in_rule__NumericalAddSubtractExpression__Group__05709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_rule__NumericalAddSubtractExpression__Group__0__Impl5736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__Group__1__Impl_in_rule__NumericalAddSubtractExpression__Group__15765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__Group_1__0_in_rule__NumericalAddSubtractExpression__Group__1__Impl5792 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__Group_1__0__Impl_in_rule__NumericalAddSubtractExpression__Group_1__05827 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__Group_1__1_in_rule__NumericalAddSubtractExpression__Group_1__05830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__Group_1__1__Impl_in_rule__NumericalAddSubtractExpression__Group_1__15888 = new BitSet(new long[]{0x00040001180001F0L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__Group_1__2_in_rule__NumericalAddSubtractExpression__Group_1__15891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__OperatorAssignment_1_1_in_rule__NumericalAddSubtractExpression__Group_1__1__Impl5918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__Group_1__2__Impl_in_rule__NumericalAddSubtractExpression__Group_1__25948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2_in_rule__NumericalAddSubtractExpression__Group_1__2__Impl5975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__Group__0__Impl_in_rule__NumericalMultiplyDivideExpression__Group__06011 = new BitSet(new long[]{0x00000000E0000000L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__Group__1_in_rule__NumericalMultiplyDivideExpression__Group__06014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_rule__NumericalMultiplyDivideExpression__Group__0__Impl6041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__Group__1__Impl_in_rule__NumericalMultiplyDivideExpression__Group__16070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__0_in_rule__NumericalMultiplyDivideExpression__Group__1__Impl6097 = new BitSet(new long[]{0x00000000E0000002L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__0__Impl_in_rule__NumericalMultiplyDivideExpression__Group_1__06132 = new BitSet(new long[]{0x00000000E0000000L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__1_in_rule__NumericalMultiplyDivideExpression__Group_1__06135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__1__Impl_in_rule__NumericalMultiplyDivideExpression__Group_1__16193 = new BitSet(new long[]{0x00040001180001F0L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__2_in_rule__NumericalMultiplyDivideExpression__Group_1__16196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1_in_rule__NumericalMultiplyDivideExpression__Group_1__1__Impl6223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__2__Impl_in_rule__NumericalMultiplyDivideExpression__Group_1__26253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2_in_rule__NumericalMultiplyDivideExpression__Group_1__2__Impl6280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalUnaryExpression__Group_1__0__Impl_in_rule__NumericalUnaryExpression__Group_1__06316 = new BitSet(new long[]{0x00040001180001F0L});
    public static final BitSet FOLLOW_rule__NumericalUnaryExpression__Group_1__1_in_rule__NumericalUnaryExpression__Group_1__06319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalUnaryExpression__Group_1__1__Impl_in_rule__NumericalUnaryExpression__Group_1__16377 = new BitSet(new long[]{0x00040000000001F0L});
    public static final BitSet FOLLOW_rule__NumericalUnaryExpression__Group_1__2_in_rule__NumericalUnaryExpression__Group_1__16380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalUnaryExpression__OperatorAssignment_1_1_in_rule__NumericalUnaryExpression__Group_1__1__Impl6407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalUnaryExpression__Group_1__2__Impl_in_rule__NumericalUnaryExpression__Group_1__26437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalUnaryExpression__OperandAssignment_1_2_in_rule__NumericalUnaryExpression__Group_1__2__Impl6464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimitiveValueExpression__Group__0__Impl_in_rule__PrimitiveValueExpression__Group__06500 = new BitSet(new long[]{0x00000000000001E0L});
    public static final BitSet FOLLOW_rule__PrimitiveValueExpression__Group__1_in_rule__PrimitiveValueExpression__Group__06503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimitiveValueExpression__Group__1__Impl_in_rule__PrimitiveValueExpression__Group__16561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimitiveValueExpression__ValueAssignment_1_in_rule__PrimitiveValueExpression__Group__1__Impl6588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group__0__Impl_in_rule__FeatureCall__Group__06622 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group__1_in_rule__FeatureCall__Group__06625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementReferenceExpression_in_rule__FeatureCall__Group__0__Impl6652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group__1__Impl_in_rule__FeatureCall__Group__16681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1__0_in_rule__FeatureCall__Group__1__Impl6708 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1__0__Impl_in_rule__FeatureCall__Group_1__06743 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1__1_in_rule__FeatureCall__Group_1__06746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1__1__Impl_in_rule__FeatureCall__Group_1__16804 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1__2_in_rule__FeatureCall__Group_1__16807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__FeatureCall__Group_1__1__Impl6835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1__2__Impl_in_rule__FeatureCall__Group_1__26866 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1__3_in_rule__FeatureCall__Group_1__26869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__FeatureAssignment_1_2_in_rule__FeatureCall__Group_1__2__Impl6896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1__3__Impl_in_rule__FeatureCall__Group_1__36926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3__0_in_rule__FeatureCall__Group_1__3__Impl6953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3__0__Impl_in_rule__FeatureCall__Group_1_3__06992 = new BitSet(new long[]{0x00050801180001F0L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3__1_in_rule__FeatureCall__Group_1_3__06995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__OperationCallAssignment_1_3_0_in_rule__FeatureCall__Group_1_3__0__Impl7022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3__1__Impl_in_rule__FeatureCall__Group_1_3__17052 = new BitSet(new long[]{0x00050801180001F0L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3__2_in_rule__FeatureCall__Group_1_3__17055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3_1__0_in_rule__FeatureCall__Group_1_3__1__Impl7082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3__2__Impl_in_rule__FeatureCall__Group_1_3__27113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__FeatureCall__Group_1_3__2__Impl7141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3_1__0__Impl_in_rule__FeatureCall__Group_1_3_1__07178 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3_1__1_in_rule__FeatureCall__Group_1_3_1__07181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__ArgsAssignment_1_3_1_0_in_rule__FeatureCall__Group_1_3_1__0__Impl7208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3_1__1__Impl_in_rule__FeatureCall__Group_1_3_1__17238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3_1_1__0_in_rule__FeatureCall__Group_1_3_1__1__Impl7265 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3_1_1__0__Impl_in_rule__FeatureCall__Group_1_3_1_1__07300 = new BitSet(new long[]{0x00040801180001F0L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3_1_1__1_in_rule__FeatureCall__Group_1_3_1_1__07303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__FeatureCall__Group_1_3_1_1__0__Impl7331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3_1_1__1__Impl_in_rule__FeatureCall__Group_1_3_1_1__17362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__ArgsAssignment_1_3_1_1_1_in_rule__FeatureCall__Group_1_3_1_1__1__Impl7389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group__0__Impl_in_rule__ElementReferenceExpression__Group__07423 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group__1_in_rule__ElementReferenceExpression__Group__07426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group__1__Impl_in_rule__ElementReferenceExpression__Group__17484 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group__2_in_rule__ElementReferenceExpression__Group__17487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__ReferenceAssignment_1_in_rule__ElementReferenceExpression__Group__1__Impl7514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group__2__Impl_in_rule__ElementReferenceExpression__Group__27544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2__0_in_rule__ElementReferenceExpression__Group__2__Impl7571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2__0__Impl_in_rule__ElementReferenceExpression__Group_2__07608 = new BitSet(new long[]{0x00050801180001F0L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2__1_in_rule__ElementReferenceExpression__Group_2__07611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__OperationCallAssignment_2_0_in_rule__ElementReferenceExpression__Group_2__0__Impl7638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2__1__Impl_in_rule__ElementReferenceExpression__Group_2__17668 = new BitSet(new long[]{0x00050801180001F0L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2__2_in_rule__ElementReferenceExpression__Group_2__17671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2_1__0_in_rule__ElementReferenceExpression__Group_2__1__Impl7698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2__2__Impl_in_rule__ElementReferenceExpression__Group_2__27729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__ElementReferenceExpression__Group_2__2__Impl7757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2_1__0__Impl_in_rule__ElementReferenceExpression__Group_2_1__07794 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2_1__1_in_rule__ElementReferenceExpression__Group_2_1__07797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__ArgsAssignment_2_1_0_in_rule__ElementReferenceExpression__Group_2_1__0__Impl7824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2_1__1__Impl_in_rule__ElementReferenceExpression__Group_2_1__17854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2_1_1__0_in_rule__ElementReferenceExpression__Group_2_1__1__Impl7881 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2_1_1__0__Impl_in_rule__ElementReferenceExpression__Group_2_1_1__07916 = new BitSet(new long[]{0x00040801180001F0L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2_1_1__1_in_rule__ElementReferenceExpression__Group_2_1_1__07919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__ElementReferenceExpression__Group_2_1_1__0__Impl7947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2_1_1__1__Impl_in_rule__ElementReferenceExpression__Group_2_1_1__17978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1_in_rule__ElementReferenceExpression__Group_2_1_1__1__Impl8005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__0__Impl_in_rule__ParenthesizedExpression__Group__08039 = new BitSet(new long[]{0x00040000000001F0L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__1_in_rule__ParenthesizedExpression__Group__08042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__1__Impl_in_rule__ParenthesizedExpression__Group__18100 = new BitSet(new long[]{0x00040801180001F0L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__2_in_rule__ParenthesizedExpression__Group__18103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ParenthesizedExpression__Group__1__Impl8131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__2__Impl_in_rule__ParenthesizedExpression__Group__28162 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__3_in_rule__ParenthesizedExpression__Group__28165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__ExpressionAssignment_2_in_rule__ParenthesizedExpression__Group__2__Impl8192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__3__Impl_in_rule__ParenthesizedExpression__Group__38222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__ParenthesizedExpression__Group__3__Impl8250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__08290 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__08293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__18351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl8378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__08412 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__08415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__18473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl8500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HexLiteral__Group__0__Impl_in_rule__HexLiteral__Group__08534 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__HexLiteral__Group__1_in_rule__HexLiteral__Group__08537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HexLiteral__Group__1__Impl_in_rule__HexLiteral__Group__18595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HexLiteral__ValueAssignment_1_in_rule__HexLiteral__Group__1__Impl8622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__08656 = new BitSet(new long[]{0x00000000000001E0L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__08659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__18717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl8744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentOperator_in_rule__AssignmentExpression__OperatorAssignment_1_18783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_rule__AssignmentExpression__ExpressionAssignment_1_28814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_rule__ConditionalExpression__TrueCaseAssignment_1_28845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_rule__ConditionalExpression__FalseCaseAssignment_1_48876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_rule__LogicalOrExpression__RightOperandAssignment_1_28907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_rule__LogicalAndExpression__RightOperandAssignment_1_28938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseXorExpression_in_rule__LogicalNotExpression__OperandAssignment_1_28969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpression_in_rule__BitwiseXorExpression__RightOperandAssignment_1_29000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpression_in_rule__BitwiseOrExpression__RightOperandAssignment_1_29031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_rule__BitwiseAndExpression__RightOperandAssignment_1_29062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_rule__LogicalRelationExpression__OperatorAssignment_1_19093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_rule__LogicalRelationExpression__RightOperandAssignment_1_29124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftOperator_in_rule__ShiftExpression__OperatorAssignment_1_19155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_rule__ShiftExpression__RightOperandAssignment_1_29186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_rule__NumericalAddSubtractExpression__OperatorAssignment_1_19217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_rule__NumericalAddSubtractExpression__RightOperandAssignment_1_29248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_19279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_29310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_rule__NumericalUnaryExpression__OperatorAssignment_1_19341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__NumericalUnaryExpression__OperandAssignment_1_29372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__PrimitiveValueExpression__ValueAssignment_19403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FeatureCall__FeatureAssignment_1_29438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__FeatureCall__OperationCallAssignment_1_3_09478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__FeatureCall__ArgsAssignment_1_3_1_09517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__FeatureCall__ArgsAssignment_1_3_1_1_19548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ElementReferenceExpression__ReferenceAssignment_19583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ElementReferenceExpression__OperationCallAssignment_2_09623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ElementReferenceExpression__ArgsAssignment_2_1_09662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ElementReferenceExpression__ArgsAssignment_2_1_1_19693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ParenthesizedExpression__ExpressionAssignment_29724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__IntLiteral__ValueAssignment_19756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_FLOAT_in_rule__RealLiteral__ValueAssignment_19787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_rule__HexLiteral__ValueAssignment_19818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_19849 = new BitSet(new long[]{0x0000000000000002L});

}