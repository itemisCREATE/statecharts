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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_BOOL", "RULE_INT", "RULE_FLOAT", "RULE_HEX", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'='", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'<<'", "'>>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'~'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'?'", "':'", "'||'", "'&&'", "'!'", "'^'", "'|'", "'&'", "'.'", "')'", "','", "'('"
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


    // $ANTLR start "entryRuleBoolLiteral"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:621:1: entryRuleBoolLiteral : ruleBoolLiteral EOF ;
    public final void entryRuleBoolLiteral() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:622:1: ( ruleBoolLiteral EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:623:1: ruleBoolLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBoolLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleBoolLiteral_in_entryRuleBoolLiteral1266);
            ruleBoolLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBoolLiteralRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoolLiteral1273); if (state.failed) return ;

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
    // $ANTLR end "entryRuleBoolLiteral"


    // $ANTLR start "ruleBoolLiteral"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:630:1: ruleBoolLiteral : ( ( rule__BoolLiteral__Group__0 ) ) ;
    public final void ruleBoolLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:634:2: ( ( ( rule__BoolLiteral__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:635:1: ( ( rule__BoolLiteral__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:635:1: ( ( rule__BoolLiteral__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:636:1: ( rule__BoolLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBoolLiteralAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:637:1: ( rule__BoolLiteral__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:637:2: rule__BoolLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__BoolLiteral__Group__0_in_ruleBoolLiteral1299);
            rule__BoolLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBoolLiteralAccess().getGroup()); 
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
    // $ANTLR end "ruleBoolLiteral"


    // $ANTLR start "entryRuleIntLiteral"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:649:1: entryRuleIntLiteral : ruleIntLiteral EOF ;
    public final void entryRuleIntLiteral() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:650:1: ( ruleIntLiteral EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:651:1: ruleIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral1326);
            ruleIntLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntLiteralRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral1333); if (state.failed) return ;

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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:658:1: ruleIntLiteral : ( ( rule__IntLiteral__Group__0 ) ) ;
    public final void ruleIntLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:662:2: ( ( ( rule__IntLiteral__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:663:1: ( ( rule__IntLiteral__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:663:1: ( ( rule__IntLiteral__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:664:1: ( rule__IntLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:665:1: ( rule__IntLiteral__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:665:2: rule__IntLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral1359);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:677:1: entryRuleRealLiteral : ruleRealLiteral EOF ;
    public final void entryRuleRealLiteral() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:678:1: ( ruleRealLiteral EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:679:1: ruleRealLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral1386);
            ruleRealLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral1393); if (state.failed) return ;

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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:686:1: ruleRealLiteral : ( ( rule__RealLiteral__Group__0 ) ) ;
    public final void ruleRealLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:690:2: ( ( ( rule__RealLiteral__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:691:1: ( ( rule__RealLiteral__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:691:1: ( ( rule__RealLiteral__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:692:1: ( rule__RealLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:693:1: ( rule__RealLiteral__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:693:2: rule__RealLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral1419);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:705:1: entryRuleHexLiteral : ruleHexLiteral EOF ;
    public final void entryRuleHexLiteral() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:706:1: ( ruleHexLiteral EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:707:1: ruleHexLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHexLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleHexLiteral_in_entryRuleHexLiteral1446);
            ruleHexLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHexLiteralRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexLiteral1453); if (state.failed) return ;

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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:714:1: ruleHexLiteral : ( ( rule__HexLiteral__Group__0 ) ) ;
    public final void ruleHexLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:718:2: ( ( ( rule__HexLiteral__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:719:1: ( ( rule__HexLiteral__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:719:1: ( ( rule__HexLiteral__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:720:1: ( rule__HexLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHexLiteralAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:721:1: ( rule__HexLiteral__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:721:2: rule__HexLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__HexLiteral__Group__0_in_ruleHexLiteral1479);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:733:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:734:1: ( ruleStringLiteral EOF )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:735:1: ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral1506);
            ruleStringLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral1513); if (state.failed) return ;

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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:742:1: ruleStringLiteral : ( ( rule__StringLiteral__Group__0 ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:746:2: ( ( ( rule__StringLiteral__Group__0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:747:1: ( ( rule__StringLiteral__Group__0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:747:1: ( ( rule__StringLiteral__Group__0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:748:1: ( rule__StringLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getGroup()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:749:1: ( rule__StringLiteral__Group__0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:749:2: rule__StringLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral1539);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:762:1: ruleAssignmentOperator : ( ( rule__AssignmentOperator__Alternatives ) ) ;
    public final void ruleAssignmentOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:766:1: ( ( ( rule__AssignmentOperator__Alternatives ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:767:1: ( ( rule__AssignmentOperator__Alternatives ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:767:1: ( ( rule__AssignmentOperator__Alternatives ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:768:1: ( rule__AssignmentOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentOperatorAccess().getAlternatives()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:769:1: ( rule__AssignmentOperator__Alternatives )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:769:2: rule__AssignmentOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__AssignmentOperator__Alternatives_in_ruleAssignmentOperator1576);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:781:1: ruleShiftOperator : ( ( rule__ShiftOperator__Alternatives ) ) ;
    public final void ruleShiftOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:785:1: ( ( ( rule__ShiftOperator__Alternatives ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:786:1: ( ( rule__ShiftOperator__Alternatives ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:786:1: ( ( rule__ShiftOperator__Alternatives ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:787:1: ( rule__ShiftOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftOperatorAccess().getAlternatives()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:788:1: ( rule__ShiftOperator__Alternatives )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:788:2: rule__ShiftOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__ShiftOperator__Alternatives_in_ruleShiftOperator1612);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:800:1: ruleAdditiveOperator : ( ( rule__AdditiveOperator__Alternatives ) ) ;
    public final void ruleAdditiveOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:804:1: ( ( ( rule__AdditiveOperator__Alternatives ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:805:1: ( ( rule__AdditiveOperator__Alternatives ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:805:1: ( ( rule__AdditiveOperator__Alternatives ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:806:1: ( rule__AdditiveOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveOperatorAccess().getAlternatives()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:807:1: ( rule__AdditiveOperator__Alternatives )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:807:2: rule__AdditiveOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__AdditiveOperator__Alternatives_in_ruleAdditiveOperator1648);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:819:1: ruleMultiplicativeOperator : ( ( rule__MultiplicativeOperator__Alternatives ) ) ;
    public final void ruleMultiplicativeOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:823:1: ( ( ( rule__MultiplicativeOperator__Alternatives ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:824:1: ( ( rule__MultiplicativeOperator__Alternatives ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:824:1: ( ( rule__MultiplicativeOperator__Alternatives ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:825:1: ( rule__MultiplicativeOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeOperatorAccess().getAlternatives()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:826:1: ( rule__MultiplicativeOperator__Alternatives )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:826:2: rule__MultiplicativeOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__MultiplicativeOperator__Alternatives_in_ruleMultiplicativeOperator1684);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:838:1: ruleUnaryOperator : ( ( rule__UnaryOperator__Alternatives ) ) ;
    public final void ruleUnaryOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:842:1: ( ( ( rule__UnaryOperator__Alternatives ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:843:1: ( ( rule__UnaryOperator__Alternatives ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:843:1: ( ( rule__UnaryOperator__Alternatives ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:844:1: ( rule__UnaryOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryOperatorAccess().getAlternatives()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:845:1: ( rule__UnaryOperator__Alternatives )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:845:2: rule__UnaryOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__UnaryOperator__Alternatives_in_ruleUnaryOperator1720);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:857:1: ruleRelationalOperator : ( ( rule__RelationalOperator__Alternatives ) ) ;
    public final void ruleRelationalOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:861:1: ( ( ( rule__RelationalOperator__Alternatives ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:862:1: ( ( rule__RelationalOperator__Alternatives ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:862:1: ( ( rule__RelationalOperator__Alternatives ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:863:1: ( rule__RelationalOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRelationalOperatorAccess().getAlternatives()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:864:1: ( rule__RelationalOperator__Alternatives )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:864:2: rule__RelationalOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__RelationalOperator__Alternatives_in_ruleRelationalOperator1756);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:875:1: rule__LogicalNotExpression__Alternatives : ( ( ruleBitwiseXorExpression ) | ( ( rule__LogicalNotExpression__Group_1__0 ) ) );
    public final void rule__LogicalNotExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:879:1: ( ( ruleBitwiseXorExpression ) | ( ( rule__LogicalNotExpression__Group_1__0 ) ) )
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
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:880:1: ( ruleBitwiseXorExpression )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:880:1: ( ruleBitwiseXorExpression )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:881:1: ruleBitwiseXorExpression
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLogicalNotExpressionAccess().getBitwiseXorExpressionParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleBitwiseXorExpression_in_rule__LogicalNotExpression__Alternatives1791);
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
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:886:6: ( ( rule__LogicalNotExpression__Group_1__0 ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:886:6: ( ( rule__LogicalNotExpression__Group_1__0 ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:887:1: ( rule__LogicalNotExpression__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLogicalNotExpressionAccess().getGroup_1()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:888:1: ( rule__LogicalNotExpression__Group_1__0 )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:888:2: rule__LogicalNotExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__LogicalNotExpression__Group_1__0_in_rule__LogicalNotExpression__Alternatives1808);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:897:1: rule__NumericalUnaryExpression__Alternatives : ( ( rulePrimaryExpression ) | ( ( rule__NumericalUnaryExpression__Group_1__0 ) ) );
    public final void rule__NumericalUnaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:901:1: ( ( rulePrimaryExpression ) | ( ( rule__NumericalUnaryExpression__Group_1__0 ) ) )
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
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:902:1: ( rulePrimaryExpression )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:902:1: ( rulePrimaryExpression )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:903:1: rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumericalUnaryExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_rule__NumericalUnaryExpression__Alternatives1841);
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
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:908:6: ( ( rule__NumericalUnaryExpression__Group_1__0 ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:908:6: ( ( rule__NumericalUnaryExpression__Group_1__0 ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:909:1: ( rule__NumericalUnaryExpression__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumericalUnaryExpressionAccess().getGroup_1()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:910:1: ( rule__NumericalUnaryExpression__Group_1__0 )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:910:2: rule__NumericalUnaryExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__NumericalUnaryExpression__Group_1__0_in_rule__NumericalUnaryExpression__Alternatives1858);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:919:1: rule__PrimaryExpression__Alternatives : ( ( rulePrimitiveValueExpression ) | ( ruleFeatureCall ) | ( ruleParenthesizedExpression ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:923:1: ( ( rulePrimitiveValueExpression ) | ( ruleFeatureCall ) | ( ruleParenthesizedExpression ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case RULE_BOOL:
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
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:924:1: ( rulePrimitiveValueExpression )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:924:1: ( rulePrimitiveValueExpression )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:925:1: rulePrimitiveValueExpression
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpressionAccess().getPrimitiveValueExpressionParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_rulePrimitiveValueExpression_in_rule__PrimaryExpression__Alternatives1891);
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
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:930:6: ( ruleFeatureCall )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:930:6: ( ruleFeatureCall )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:931:1: ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpressionAccess().getFeatureCallParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleFeatureCall_in_rule__PrimaryExpression__Alternatives1908);
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
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:936:6: ( ruleParenthesizedExpression )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:936:6: ( ruleParenthesizedExpression )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:937:1: ruleParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_rule__PrimaryExpression__Alternatives1925);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:947:1: rule__Literal__Alternatives : ( ( ruleBoolLiteral ) | ( ruleIntLiteral ) | ( ruleHexLiteral ) | ( ruleRealLiteral ) | ( ruleStringLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:951:1: ( ( ruleBoolLiteral ) | ( ruleIntLiteral ) | ( ruleHexLiteral ) | ( ruleRealLiteral ) | ( ruleStringLiteral ) )
            int alt4=5;
            switch ( input.LA(1) ) {
            case RULE_BOOL:
                {
                alt4=1;
                }
                break;
            case RULE_INT:
                {
                alt4=2;
                }
                break;
            case RULE_HEX:
                {
                alt4=3;
                }
                break;
            case RULE_FLOAT:
                {
                alt4=4;
                }
                break;
            case RULE_STRING:
                {
                alt4=5;
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
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:952:1: ( ruleBoolLiteral )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:952:1: ( ruleBoolLiteral )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:953:1: ruleBoolLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getBoolLiteralParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleBoolLiteral_in_rule__Literal__Alternatives1957);
                    ruleBoolLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getBoolLiteralParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:958:6: ( ruleIntLiteral )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:958:6: ( ruleIntLiteral )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:959:1: ruleIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getIntLiteralParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleIntLiteral_in_rule__Literal__Alternatives1974);
                    ruleIntLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getIntLiteralParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:964:6: ( ruleHexLiteral )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:964:6: ( ruleHexLiteral )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:965:1: ruleHexLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getHexLiteralParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleHexLiteral_in_rule__Literal__Alternatives1991);
                    ruleHexLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getHexLiteralParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:970:6: ( ruleRealLiteral )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:970:6: ( ruleRealLiteral )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:971:1: ruleRealLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getRealLiteralParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_ruleRealLiteral_in_rule__Literal__Alternatives2008);
                    ruleRealLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getRealLiteralParserRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:976:6: ( ruleStringLiteral )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:976:6: ( ruleStringLiteral )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:977:1: ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives2025);
                    ruleStringLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_4()); 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:987:1: rule__AssignmentOperator__Alternatives : ( ( ( '=' ) ) | ( ( '*=' ) ) | ( ( '/=' ) ) | ( ( '%=' ) ) | ( ( '+=' ) ) | ( ( '-=' ) ) | ( ( '<<=' ) ) | ( ( '>>=' ) ) | ( ( '&=' ) ) | ( ( '^=' ) ) | ( ( '|=' ) ) );
    public final void rule__AssignmentOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:991:1: ( ( ( '=' ) ) | ( ( '*=' ) ) | ( ( '/=' ) ) | ( ( '%=' ) ) | ( ( '+=' ) ) | ( ( '-=' ) ) | ( ( '<<=' ) ) | ( ( '>>=' ) ) | ( ( '&=' ) ) | ( ( '^=' ) ) | ( ( '|=' ) ) )
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
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:992:1: ( ( '=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:992:1: ( ( '=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:993:1: ( '=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getAssignEnumLiteralDeclaration_0()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:994:1: ( '=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:994:3: '='
                    {
                    match(input,14,FOLLOW_14_in_rule__AssignmentOperator__Alternatives2058); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getAssignEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:999:6: ( ( '*=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:999:6: ( ( '*=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1000:1: ( '*=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getMultAssignEnumLiteralDeclaration_1()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1001:1: ( '*=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1001:3: '*='
                    {
                    match(input,15,FOLLOW_15_in_rule__AssignmentOperator__Alternatives2079); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getMultAssignEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1006:6: ( ( '/=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1006:6: ( ( '/=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1007:1: ( '/=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getDivAssignEnumLiteralDeclaration_2()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1008:1: ( '/=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1008:3: '/='
                    {
                    match(input,16,FOLLOW_16_in_rule__AssignmentOperator__Alternatives2100); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getDivAssignEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1013:6: ( ( '%=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1013:6: ( ( '%=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1014:1: ( '%=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getModAssignEnumLiteralDeclaration_3()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1015:1: ( '%=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1015:3: '%='
                    {
                    match(input,17,FOLLOW_17_in_rule__AssignmentOperator__Alternatives2121); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getModAssignEnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1020:6: ( ( '+=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1020:6: ( ( '+=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1021:1: ( '+=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getAddAssignEnumLiteralDeclaration_4()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1022:1: ( '+=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1022:3: '+='
                    {
                    match(input,18,FOLLOW_18_in_rule__AssignmentOperator__Alternatives2142); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getAddAssignEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1027:6: ( ( '-=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1027:6: ( ( '-=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1028:1: ( '-=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getSubAssignEnumLiteralDeclaration_5()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1029:1: ( '-=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1029:3: '-='
                    {
                    match(input,19,FOLLOW_19_in_rule__AssignmentOperator__Alternatives2163); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getSubAssignEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1034:6: ( ( '<<=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1034:6: ( ( '<<=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1035:1: ( '<<=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getLeftShiftAssignEnumLiteralDeclaration_6()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1036:1: ( '<<=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1036:3: '<<='
                    {
                    match(input,20,FOLLOW_20_in_rule__AssignmentOperator__Alternatives2184); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getLeftShiftAssignEnumLiteralDeclaration_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1041:6: ( ( '>>=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1041:6: ( ( '>>=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1042:1: ( '>>=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getRightShiftAssignEnumLiteralDeclaration_7()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1043:1: ( '>>=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1043:3: '>>='
                    {
                    match(input,21,FOLLOW_21_in_rule__AssignmentOperator__Alternatives2205); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getRightShiftAssignEnumLiteralDeclaration_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1048:6: ( ( '&=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1048:6: ( ( '&=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1049:1: ( '&=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getAndAssignEnumLiteralDeclaration_8()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1050:1: ( '&=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1050:3: '&='
                    {
                    match(input,22,FOLLOW_22_in_rule__AssignmentOperator__Alternatives2226); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getAndAssignEnumLiteralDeclaration_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1055:6: ( ( '^=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1055:6: ( ( '^=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1056:1: ( '^=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getXorAssignEnumLiteralDeclaration_9()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1057:1: ( '^=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1057:3: '^='
                    {
                    match(input,23,FOLLOW_23_in_rule__AssignmentOperator__Alternatives2247); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentOperatorAccess().getXorAssignEnumLiteralDeclaration_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1062:6: ( ( '|=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1062:6: ( ( '|=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1063:1: ( '|=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentOperatorAccess().getOrAssignEnumLiteralDeclaration_10()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1064:1: ( '|=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1064:3: '|='
                    {
                    match(input,24,FOLLOW_24_in_rule__AssignmentOperator__Alternatives2268); if (state.failed) return ;

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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1074:1: rule__ShiftOperator__Alternatives : ( ( ( '<<' ) ) | ( ( '>>' ) ) );
    public final void rule__ShiftOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1078:1: ( ( ( '<<' ) ) | ( ( '>>' ) ) )
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
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1079:1: ( ( '<<' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1079:1: ( ( '<<' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1080:1: ( '<<' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getShiftOperatorAccess().getLeftEnumLiteralDeclaration_0()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1081:1: ( '<<' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1081:3: '<<'
                    {
                    match(input,25,FOLLOW_25_in_rule__ShiftOperator__Alternatives2304); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getShiftOperatorAccess().getLeftEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1086:6: ( ( '>>' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1086:6: ( ( '>>' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1087:1: ( '>>' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getShiftOperatorAccess().getRightEnumLiteralDeclaration_1()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1088:1: ( '>>' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1088:3: '>>'
                    {
                    match(input,26,FOLLOW_26_in_rule__ShiftOperator__Alternatives2325); if (state.failed) return ;

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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1098:1: rule__AdditiveOperator__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AdditiveOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1102:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
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
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1103:1: ( ( '+' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1103:1: ( ( '+' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1104:1: ( '+' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1105:1: ( '+' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1105:3: '+'
                    {
                    match(input,27,FOLLOW_27_in_rule__AdditiveOperator__Alternatives2361); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1110:6: ( ( '-' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1110:6: ( ( '-' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1111:1: ( '-' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAdditiveOperatorAccess().getMinusEnumLiteralDeclaration_1()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1112:1: ( '-' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1112:3: '-'
                    {
                    match(input,28,FOLLOW_28_in_rule__AdditiveOperator__Alternatives2382); if (state.failed) return ;

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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1122:1: rule__MultiplicativeOperator__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplicativeOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1126:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
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
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1127:1: ( ( '*' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1127:1: ( ( '*' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1128:1: ( '*' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1129:1: ( '*' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1129:3: '*'
                    {
                    match(input,29,FOLLOW_29_in_rule__MultiplicativeOperator__Alternatives2418); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1134:6: ( ( '/' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1134:6: ( ( '/' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1135:1: ( '/' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1136:1: ( '/' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1136:3: '/'
                    {
                    match(input,30,FOLLOW_30_in_rule__MultiplicativeOperator__Alternatives2439); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1141:6: ( ( '%' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1141:6: ( ( '%' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1142:1: ( '%' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicativeOperatorAccess().getModEnumLiteralDeclaration_2()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1143:1: ( '%' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1143:3: '%'
                    {
                    match(input,31,FOLLOW_31_in_rule__MultiplicativeOperator__Alternatives2460); if (state.failed) return ;

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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1153:1: rule__UnaryOperator__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '~' ) ) );
    public final void rule__UnaryOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1157:1: ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '~' ) ) )
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
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1158:1: ( ( '+' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1158:1: ( ( '+' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1159:1: ( '+' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1160:1: ( '+' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1160:3: '+'
                    {
                    match(input,27,FOLLOW_27_in_rule__UnaryOperator__Alternatives2496); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1165:6: ( ( '-' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1165:6: ( ( '-' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1166:1: ( '-' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1167:1: ( '-' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1167:3: '-'
                    {
                    match(input,28,FOLLOW_28_in_rule__UnaryOperator__Alternatives2517); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1172:6: ( ( '~' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1172:6: ( ( '~' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1173:1: ( '~' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnaryOperatorAccess().getComplementEnumLiteralDeclaration_2()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1174:1: ( '~' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1174:3: '~'
                    {
                    match(input,32,FOLLOW_32_in_rule__UnaryOperator__Alternatives2538); if (state.failed) return ;

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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1184:1: rule__RelationalOperator__Alternatives : ( ( ( '<' ) ) | ( ( '<=' ) ) | ( ( '>' ) ) | ( ( '>=' ) ) | ( ( '==' ) ) | ( ( '!=' ) ) );
    public final void rule__RelationalOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1188:1: ( ( ( '<' ) ) | ( ( '<=' ) ) | ( ( '>' ) ) | ( ( '>=' ) ) | ( ( '==' ) ) | ( ( '!=' ) ) )
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
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1189:1: ( ( '<' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1189:1: ( ( '<' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1190:1: ( '<' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1191:1: ( '<' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1191:3: '<'
                    {
                    match(input,33,FOLLOW_33_in_rule__RelationalOperator__Alternatives2574); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1196:6: ( ( '<=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1196:6: ( ( '<=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1197:1: ( '<=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1198:1: ( '<=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1198:3: '<='
                    {
                    match(input,34,FOLLOW_34_in_rule__RelationalOperator__Alternatives2595); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1203:6: ( ( '>' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1203:6: ( ( '>' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1204:1: ( '>' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1205:1: ( '>' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1205:3: '>'
                    {
                    match(input,35,FOLLOW_35_in_rule__RelationalOperator__Alternatives2616); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1210:6: ( ( '>=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1210:6: ( ( '>=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1211:1: ( '>=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1212:1: ( '>=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1212:3: '>='
                    {
                    match(input,36,FOLLOW_36_in_rule__RelationalOperator__Alternatives2637); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1217:6: ( ( '==' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1217:6: ( ( '==' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1218:1: ( '==' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1219:1: ( '==' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1219:3: '=='
                    {
                    match(input,37,FOLLOW_37_in_rule__RelationalOperator__Alternatives2658); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1224:6: ( ( '!=' ) )
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1224:6: ( ( '!=' ) )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1225:1: ( '!=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRelationalOperatorAccess().getNotEqualsEnumLiteralDeclaration_5()); 
                    }
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1226:1: ( '!=' )
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1226:3: '!='
                    {
                    match(input,38,FOLLOW_38_in_rule__RelationalOperator__Alternatives2679); if (state.failed) return ;

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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1238:1: rule__AssignmentExpression__Group__0 : rule__AssignmentExpression__Group__0__Impl rule__AssignmentExpression__Group__1 ;
    public final void rule__AssignmentExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1242:1: ( rule__AssignmentExpression__Group__0__Impl rule__AssignmentExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1243:2: rule__AssignmentExpression__Group__0__Impl rule__AssignmentExpression__Group__1
            {
            pushFollow(FOLLOW_rule__AssignmentExpression__Group__0__Impl_in_rule__AssignmentExpression__Group__02712);
            rule__AssignmentExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AssignmentExpression__Group__1_in_rule__AssignmentExpression__Group__02715);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1250:1: rule__AssignmentExpression__Group__0__Impl : ( ruleConditionalExpression ) ;
    public final void rule__AssignmentExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1254:1: ( ( ruleConditionalExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1255:1: ( ruleConditionalExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1255:1: ( ruleConditionalExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1256:1: ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentExpressionAccess().getConditionalExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleConditionalExpression_in_rule__AssignmentExpression__Group__0__Impl2742);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1267:1: rule__AssignmentExpression__Group__1 : rule__AssignmentExpression__Group__1__Impl ;
    public final void rule__AssignmentExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1271:1: ( rule__AssignmentExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1272:2: rule__AssignmentExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AssignmentExpression__Group__1__Impl_in_rule__AssignmentExpression__Group__12771);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1278:1: rule__AssignmentExpression__Group__1__Impl : ( ( rule__AssignmentExpression__Group_1__0 )* ) ;
    public final void rule__AssignmentExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1282:1: ( ( ( rule__AssignmentExpression__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1283:1: ( ( rule__AssignmentExpression__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1283:1: ( ( rule__AssignmentExpression__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1284:1: ( rule__AssignmentExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1285:1: ( rule__AssignmentExpression__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=14 && LA11_0<=24)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1285:2: rule__AssignmentExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AssignmentExpression__Group_1__0_in_rule__AssignmentExpression__Group__1__Impl2798);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1299:1: rule__AssignmentExpression__Group_1__0 : rule__AssignmentExpression__Group_1__0__Impl rule__AssignmentExpression__Group_1__1 ;
    public final void rule__AssignmentExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1303:1: ( rule__AssignmentExpression__Group_1__0__Impl rule__AssignmentExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1304:2: rule__AssignmentExpression__Group_1__0__Impl rule__AssignmentExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__AssignmentExpression__Group_1__0__Impl_in_rule__AssignmentExpression__Group_1__02833);
            rule__AssignmentExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AssignmentExpression__Group_1__1_in_rule__AssignmentExpression__Group_1__02836);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1311:1: rule__AssignmentExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__AssignmentExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1315:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1316:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1316:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1317:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1318:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1320:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1330:1: rule__AssignmentExpression__Group_1__1 : rule__AssignmentExpression__Group_1__1__Impl rule__AssignmentExpression__Group_1__2 ;
    public final void rule__AssignmentExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1334:1: ( rule__AssignmentExpression__Group_1__1__Impl rule__AssignmentExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1335:2: rule__AssignmentExpression__Group_1__1__Impl rule__AssignmentExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__AssignmentExpression__Group_1__1__Impl_in_rule__AssignmentExpression__Group_1__12894);
            rule__AssignmentExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AssignmentExpression__Group_1__2_in_rule__AssignmentExpression__Group_1__12897);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1342:1: rule__AssignmentExpression__Group_1__1__Impl : ( ( rule__AssignmentExpression__OperatorAssignment_1_1 ) ) ;
    public final void rule__AssignmentExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1346:1: ( ( ( rule__AssignmentExpression__OperatorAssignment_1_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1347:1: ( ( rule__AssignmentExpression__OperatorAssignment_1_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1347:1: ( ( rule__AssignmentExpression__OperatorAssignment_1_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1348:1: ( rule__AssignmentExpression__OperatorAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentExpressionAccess().getOperatorAssignment_1_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1349:1: ( rule__AssignmentExpression__OperatorAssignment_1_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1349:2: rule__AssignmentExpression__OperatorAssignment_1_1
            {
            pushFollow(FOLLOW_rule__AssignmentExpression__OperatorAssignment_1_1_in_rule__AssignmentExpression__Group_1__1__Impl2924);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1359:1: rule__AssignmentExpression__Group_1__2 : rule__AssignmentExpression__Group_1__2__Impl ;
    public final void rule__AssignmentExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1363:1: ( rule__AssignmentExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1364:2: rule__AssignmentExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__AssignmentExpression__Group_1__2__Impl_in_rule__AssignmentExpression__Group_1__22954);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1370:1: rule__AssignmentExpression__Group_1__2__Impl : ( ( rule__AssignmentExpression__ExpressionAssignment_1_2 ) ) ;
    public final void rule__AssignmentExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1374:1: ( ( ( rule__AssignmentExpression__ExpressionAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1375:1: ( ( rule__AssignmentExpression__ExpressionAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1375:1: ( ( rule__AssignmentExpression__ExpressionAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1376:1: ( rule__AssignmentExpression__ExpressionAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentExpressionAccess().getExpressionAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1377:1: ( rule__AssignmentExpression__ExpressionAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1377:2: rule__AssignmentExpression__ExpressionAssignment_1_2
            {
            pushFollow(FOLLOW_rule__AssignmentExpression__ExpressionAssignment_1_2_in_rule__AssignmentExpression__Group_1__2__Impl2981);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1393:1: rule__ConditionalExpression__Group__0 : rule__ConditionalExpression__Group__0__Impl rule__ConditionalExpression__Group__1 ;
    public final void rule__ConditionalExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1397:1: ( rule__ConditionalExpression__Group__0__Impl rule__ConditionalExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1398:2: rule__ConditionalExpression__Group__0__Impl rule__ConditionalExpression__Group__1
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group__0__Impl_in_rule__ConditionalExpression__Group__03017);
            rule__ConditionalExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConditionalExpression__Group__1_in_rule__ConditionalExpression__Group__03020);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1405:1: rule__ConditionalExpression__Group__0__Impl : ( ruleLogicalOrExpression ) ;
    public final void rule__ConditionalExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1409:1: ( ( ruleLogicalOrExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1410:1: ( ruleLogicalOrExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1410:1: ( ruleLogicalOrExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1411:1: ruleLogicalOrExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConditionalExpressionAccess().getLogicalOrExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_rule__ConditionalExpression__Group__0__Impl3047);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1422:1: rule__ConditionalExpression__Group__1 : rule__ConditionalExpression__Group__1__Impl ;
    public final void rule__ConditionalExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1426:1: ( rule__ConditionalExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1427:2: rule__ConditionalExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group__1__Impl_in_rule__ConditionalExpression__Group__13076);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1433:1: rule__ConditionalExpression__Group__1__Impl : ( ( rule__ConditionalExpression__Group_1__0 )? ) ;
    public final void rule__ConditionalExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1437:1: ( ( ( rule__ConditionalExpression__Group_1__0 )? ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1438:1: ( ( rule__ConditionalExpression__Group_1__0 )? )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1438:1: ( ( rule__ConditionalExpression__Group_1__0 )? )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1439:1: ( rule__ConditionalExpression__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConditionalExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1440:1: ( rule__ConditionalExpression__Group_1__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==39) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1440:2: rule__ConditionalExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__0_in_rule__ConditionalExpression__Group__1__Impl3103);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1454:1: rule__ConditionalExpression__Group_1__0 : rule__ConditionalExpression__Group_1__0__Impl rule__ConditionalExpression__Group_1__1 ;
    public final void rule__ConditionalExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1458:1: ( rule__ConditionalExpression__Group_1__0__Impl rule__ConditionalExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1459:2: rule__ConditionalExpression__Group_1__0__Impl rule__ConditionalExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__0__Impl_in_rule__ConditionalExpression__Group_1__03138);
            rule__ConditionalExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__1_in_rule__ConditionalExpression__Group_1__03141);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1466:1: rule__ConditionalExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__ConditionalExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1470:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1471:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1471:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1472:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1473:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1475:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1485:1: rule__ConditionalExpression__Group_1__1 : rule__ConditionalExpression__Group_1__1__Impl rule__ConditionalExpression__Group_1__2 ;
    public final void rule__ConditionalExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1489:1: ( rule__ConditionalExpression__Group_1__1__Impl rule__ConditionalExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1490:2: rule__ConditionalExpression__Group_1__1__Impl rule__ConditionalExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__1__Impl_in_rule__ConditionalExpression__Group_1__13199);
            rule__ConditionalExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__2_in_rule__ConditionalExpression__Group_1__13202);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1497:1: rule__ConditionalExpression__Group_1__1__Impl : ( '?' ) ;
    public final void rule__ConditionalExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1501:1: ( ( '?' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1502:1: ( '?' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1502:1: ( '?' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1503:1: '?'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConditionalExpressionAccess().getQuestionMarkKeyword_1_1()); 
            }
            match(input,39,FOLLOW_39_in_rule__ConditionalExpression__Group_1__1__Impl3230); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1516:1: rule__ConditionalExpression__Group_1__2 : rule__ConditionalExpression__Group_1__2__Impl rule__ConditionalExpression__Group_1__3 ;
    public final void rule__ConditionalExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1520:1: ( rule__ConditionalExpression__Group_1__2__Impl rule__ConditionalExpression__Group_1__3 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1521:2: rule__ConditionalExpression__Group_1__2__Impl rule__ConditionalExpression__Group_1__3
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__2__Impl_in_rule__ConditionalExpression__Group_1__23261);
            rule__ConditionalExpression__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__3_in_rule__ConditionalExpression__Group_1__23264);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1528:1: rule__ConditionalExpression__Group_1__2__Impl : ( ( rule__ConditionalExpression__TrueCaseAssignment_1_2 ) ) ;
    public final void rule__ConditionalExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1532:1: ( ( ( rule__ConditionalExpression__TrueCaseAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1533:1: ( ( rule__ConditionalExpression__TrueCaseAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1533:1: ( ( rule__ConditionalExpression__TrueCaseAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1534:1: ( rule__ConditionalExpression__TrueCaseAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConditionalExpressionAccess().getTrueCaseAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1535:1: ( rule__ConditionalExpression__TrueCaseAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1535:2: rule__ConditionalExpression__TrueCaseAssignment_1_2
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__TrueCaseAssignment_1_2_in_rule__ConditionalExpression__Group_1__2__Impl3291);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1545:1: rule__ConditionalExpression__Group_1__3 : rule__ConditionalExpression__Group_1__3__Impl rule__ConditionalExpression__Group_1__4 ;
    public final void rule__ConditionalExpression__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1549:1: ( rule__ConditionalExpression__Group_1__3__Impl rule__ConditionalExpression__Group_1__4 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1550:2: rule__ConditionalExpression__Group_1__3__Impl rule__ConditionalExpression__Group_1__4
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__3__Impl_in_rule__ConditionalExpression__Group_1__33321);
            rule__ConditionalExpression__Group_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__4_in_rule__ConditionalExpression__Group_1__33324);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1557:1: rule__ConditionalExpression__Group_1__3__Impl : ( ':' ) ;
    public final void rule__ConditionalExpression__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1561:1: ( ( ':' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1562:1: ( ':' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1562:1: ( ':' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1563:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_3()); 
            }
            match(input,40,FOLLOW_40_in_rule__ConditionalExpression__Group_1__3__Impl3352); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1576:1: rule__ConditionalExpression__Group_1__4 : rule__ConditionalExpression__Group_1__4__Impl ;
    public final void rule__ConditionalExpression__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1580:1: ( rule__ConditionalExpression__Group_1__4__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1581:2: rule__ConditionalExpression__Group_1__4__Impl
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__4__Impl_in_rule__ConditionalExpression__Group_1__43383);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1587:1: rule__ConditionalExpression__Group_1__4__Impl : ( ( rule__ConditionalExpression__FalseCaseAssignment_1_4 ) ) ;
    public final void rule__ConditionalExpression__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1591:1: ( ( ( rule__ConditionalExpression__FalseCaseAssignment_1_4 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1592:1: ( ( rule__ConditionalExpression__FalseCaseAssignment_1_4 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1592:1: ( ( rule__ConditionalExpression__FalseCaseAssignment_1_4 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1593:1: ( rule__ConditionalExpression__FalseCaseAssignment_1_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConditionalExpressionAccess().getFalseCaseAssignment_1_4()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1594:1: ( rule__ConditionalExpression__FalseCaseAssignment_1_4 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1594:2: rule__ConditionalExpression__FalseCaseAssignment_1_4
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__FalseCaseAssignment_1_4_in_rule__ConditionalExpression__Group_1__4__Impl3410);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1614:1: rule__LogicalOrExpression__Group__0 : rule__LogicalOrExpression__Group__0__Impl rule__LogicalOrExpression__Group__1 ;
    public final void rule__LogicalOrExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1618:1: ( rule__LogicalOrExpression__Group__0__Impl rule__LogicalOrExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1619:2: rule__LogicalOrExpression__Group__0__Impl rule__LogicalOrExpression__Group__1
            {
            pushFollow(FOLLOW_rule__LogicalOrExpression__Group__0__Impl_in_rule__LogicalOrExpression__Group__03450);
            rule__LogicalOrExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalOrExpression__Group__1_in_rule__LogicalOrExpression__Group__03453);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1626:1: rule__LogicalOrExpression__Group__0__Impl : ( ruleLogicalAndExpression ) ;
    public final void rule__LogicalOrExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1630:1: ( ( ruleLogicalAndExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1631:1: ( ruleLogicalAndExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1631:1: ( ruleLogicalAndExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1632:1: ruleLogicalAndExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_rule__LogicalOrExpression__Group__0__Impl3480);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1643:1: rule__LogicalOrExpression__Group__1 : rule__LogicalOrExpression__Group__1__Impl ;
    public final void rule__LogicalOrExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1647:1: ( rule__LogicalOrExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1648:2: rule__LogicalOrExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__LogicalOrExpression__Group__1__Impl_in_rule__LogicalOrExpression__Group__13509);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1654:1: rule__LogicalOrExpression__Group__1__Impl : ( ( rule__LogicalOrExpression__Group_1__0 )* ) ;
    public final void rule__LogicalOrExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1658:1: ( ( ( rule__LogicalOrExpression__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1659:1: ( ( rule__LogicalOrExpression__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1659:1: ( ( rule__LogicalOrExpression__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1660:1: ( rule__LogicalOrExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalOrExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1661:1: ( rule__LogicalOrExpression__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==41) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1661:2: rule__LogicalOrExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__LogicalOrExpression__Group_1__0_in_rule__LogicalOrExpression__Group__1__Impl3536);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1675:1: rule__LogicalOrExpression__Group_1__0 : rule__LogicalOrExpression__Group_1__0__Impl rule__LogicalOrExpression__Group_1__1 ;
    public final void rule__LogicalOrExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1679:1: ( rule__LogicalOrExpression__Group_1__0__Impl rule__LogicalOrExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1680:2: rule__LogicalOrExpression__Group_1__0__Impl rule__LogicalOrExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__LogicalOrExpression__Group_1__0__Impl_in_rule__LogicalOrExpression__Group_1__03571);
            rule__LogicalOrExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalOrExpression__Group_1__1_in_rule__LogicalOrExpression__Group_1__03574);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1687:1: rule__LogicalOrExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__LogicalOrExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1691:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1692:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1692:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1693:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1694:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1696:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1706:1: rule__LogicalOrExpression__Group_1__1 : rule__LogicalOrExpression__Group_1__1__Impl rule__LogicalOrExpression__Group_1__2 ;
    public final void rule__LogicalOrExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1710:1: ( rule__LogicalOrExpression__Group_1__1__Impl rule__LogicalOrExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1711:2: rule__LogicalOrExpression__Group_1__1__Impl rule__LogicalOrExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__LogicalOrExpression__Group_1__1__Impl_in_rule__LogicalOrExpression__Group_1__13632);
            rule__LogicalOrExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalOrExpression__Group_1__2_in_rule__LogicalOrExpression__Group_1__13635);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1718:1: rule__LogicalOrExpression__Group_1__1__Impl : ( '||' ) ;
    public final void rule__LogicalOrExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1722:1: ( ( '||' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1723:1: ( '||' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1723:1: ( '||' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1724:1: '||'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_1()); 
            }
            match(input,41,FOLLOW_41_in_rule__LogicalOrExpression__Group_1__1__Impl3663); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1737:1: rule__LogicalOrExpression__Group_1__2 : rule__LogicalOrExpression__Group_1__2__Impl ;
    public final void rule__LogicalOrExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1741:1: ( rule__LogicalOrExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1742:2: rule__LogicalOrExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__LogicalOrExpression__Group_1__2__Impl_in_rule__LogicalOrExpression__Group_1__23694);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1748:1: rule__LogicalOrExpression__Group_1__2__Impl : ( ( rule__LogicalOrExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__LogicalOrExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1752:1: ( ( ( rule__LogicalOrExpression__RightOperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1753:1: ( ( rule__LogicalOrExpression__RightOperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1753:1: ( ( rule__LogicalOrExpression__RightOperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1754:1: ( rule__LogicalOrExpression__RightOperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalOrExpressionAccess().getRightOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1755:1: ( rule__LogicalOrExpression__RightOperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1755:2: rule__LogicalOrExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__LogicalOrExpression__RightOperandAssignment_1_2_in_rule__LogicalOrExpression__Group_1__2__Impl3721);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1771:1: rule__LogicalAndExpression__Group__0 : rule__LogicalAndExpression__Group__0__Impl rule__LogicalAndExpression__Group__1 ;
    public final void rule__LogicalAndExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1775:1: ( rule__LogicalAndExpression__Group__0__Impl rule__LogicalAndExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1776:2: rule__LogicalAndExpression__Group__0__Impl rule__LogicalAndExpression__Group__1
            {
            pushFollow(FOLLOW_rule__LogicalAndExpression__Group__0__Impl_in_rule__LogicalAndExpression__Group__03757);
            rule__LogicalAndExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalAndExpression__Group__1_in_rule__LogicalAndExpression__Group__03760);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1783:1: rule__LogicalAndExpression__Group__0__Impl : ( ruleLogicalNotExpression ) ;
    public final void rule__LogicalAndExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1787:1: ( ( ruleLogicalNotExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1788:1: ( ruleLogicalNotExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1788:1: ( ruleLogicalNotExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1789:1: ruleLogicalNotExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalAndExpressionAccess().getLogicalNotExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_rule__LogicalAndExpression__Group__0__Impl3787);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1800:1: rule__LogicalAndExpression__Group__1 : rule__LogicalAndExpression__Group__1__Impl ;
    public final void rule__LogicalAndExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1804:1: ( rule__LogicalAndExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1805:2: rule__LogicalAndExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__LogicalAndExpression__Group__1__Impl_in_rule__LogicalAndExpression__Group__13816);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1811:1: rule__LogicalAndExpression__Group__1__Impl : ( ( rule__LogicalAndExpression__Group_1__0 )* ) ;
    public final void rule__LogicalAndExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1815:1: ( ( ( rule__LogicalAndExpression__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1816:1: ( ( rule__LogicalAndExpression__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1816:1: ( ( rule__LogicalAndExpression__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1817:1: ( rule__LogicalAndExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalAndExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1818:1: ( rule__LogicalAndExpression__Group_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==42) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1818:2: rule__LogicalAndExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__LogicalAndExpression__Group_1__0_in_rule__LogicalAndExpression__Group__1__Impl3843);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1832:1: rule__LogicalAndExpression__Group_1__0 : rule__LogicalAndExpression__Group_1__0__Impl rule__LogicalAndExpression__Group_1__1 ;
    public final void rule__LogicalAndExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1836:1: ( rule__LogicalAndExpression__Group_1__0__Impl rule__LogicalAndExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1837:2: rule__LogicalAndExpression__Group_1__0__Impl rule__LogicalAndExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__LogicalAndExpression__Group_1__0__Impl_in_rule__LogicalAndExpression__Group_1__03878);
            rule__LogicalAndExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalAndExpression__Group_1__1_in_rule__LogicalAndExpression__Group_1__03881);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1844:1: rule__LogicalAndExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__LogicalAndExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1848:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1849:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1849:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1850:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1851:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1853:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1863:1: rule__LogicalAndExpression__Group_1__1 : rule__LogicalAndExpression__Group_1__1__Impl rule__LogicalAndExpression__Group_1__2 ;
    public final void rule__LogicalAndExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1867:1: ( rule__LogicalAndExpression__Group_1__1__Impl rule__LogicalAndExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1868:2: rule__LogicalAndExpression__Group_1__1__Impl rule__LogicalAndExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__LogicalAndExpression__Group_1__1__Impl_in_rule__LogicalAndExpression__Group_1__13939);
            rule__LogicalAndExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalAndExpression__Group_1__2_in_rule__LogicalAndExpression__Group_1__13942);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1875:1: rule__LogicalAndExpression__Group_1__1__Impl : ( '&&' ) ;
    public final void rule__LogicalAndExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1879:1: ( ( '&&' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1880:1: ( '&&' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1880:1: ( '&&' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1881:1: '&&'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalAndExpressionAccess().getAmpersandAmpersandKeyword_1_1()); 
            }
            match(input,42,FOLLOW_42_in_rule__LogicalAndExpression__Group_1__1__Impl3970); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1894:1: rule__LogicalAndExpression__Group_1__2 : rule__LogicalAndExpression__Group_1__2__Impl ;
    public final void rule__LogicalAndExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1898:1: ( rule__LogicalAndExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1899:2: rule__LogicalAndExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__LogicalAndExpression__Group_1__2__Impl_in_rule__LogicalAndExpression__Group_1__24001);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1905:1: rule__LogicalAndExpression__Group_1__2__Impl : ( ( rule__LogicalAndExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__LogicalAndExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1909:1: ( ( ( rule__LogicalAndExpression__RightOperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1910:1: ( ( rule__LogicalAndExpression__RightOperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1910:1: ( ( rule__LogicalAndExpression__RightOperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1911:1: ( rule__LogicalAndExpression__RightOperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalAndExpressionAccess().getRightOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1912:1: ( rule__LogicalAndExpression__RightOperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1912:2: rule__LogicalAndExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__LogicalAndExpression__RightOperandAssignment_1_2_in_rule__LogicalAndExpression__Group_1__2__Impl4028);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1928:1: rule__LogicalNotExpression__Group_1__0 : rule__LogicalNotExpression__Group_1__0__Impl rule__LogicalNotExpression__Group_1__1 ;
    public final void rule__LogicalNotExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1932:1: ( rule__LogicalNotExpression__Group_1__0__Impl rule__LogicalNotExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1933:2: rule__LogicalNotExpression__Group_1__0__Impl rule__LogicalNotExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__LogicalNotExpression__Group_1__0__Impl_in_rule__LogicalNotExpression__Group_1__04064);
            rule__LogicalNotExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalNotExpression__Group_1__1_in_rule__LogicalNotExpression__Group_1__04067);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1940:1: rule__LogicalNotExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__LogicalNotExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1944:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1945:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1945:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1946:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalNotExpressionAccess().getLogicalNotExpressionAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1947:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1949:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1959:1: rule__LogicalNotExpression__Group_1__1 : rule__LogicalNotExpression__Group_1__1__Impl rule__LogicalNotExpression__Group_1__2 ;
    public final void rule__LogicalNotExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1963:1: ( rule__LogicalNotExpression__Group_1__1__Impl rule__LogicalNotExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1964:2: rule__LogicalNotExpression__Group_1__1__Impl rule__LogicalNotExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__LogicalNotExpression__Group_1__1__Impl_in_rule__LogicalNotExpression__Group_1__14125);
            rule__LogicalNotExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalNotExpression__Group_1__2_in_rule__LogicalNotExpression__Group_1__14128);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1971:1: rule__LogicalNotExpression__Group_1__1__Impl : ( '!' ) ;
    public final void rule__LogicalNotExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1975:1: ( ( '!' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1976:1: ( '!' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1976:1: ( '!' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1977:1: '!'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalNotExpressionAccess().getExclamationMarkKeyword_1_1()); 
            }
            match(input,43,FOLLOW_43_in_rule__LogicalNotExpression__Group_1__1__Impl4156); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1990:1: rule__LogicalNotExpression__Group_1__2 : rule__LogicalNotExpression__Group_1__2__Impl ;
    public final void rule__LogicalNotExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1994:1: ( rule__LogicalNotExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1995:2: rule__LogicalNotExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__LogicalNotExpression__Group_1__2__Impl_in_rule__LogicalNotExpression__Group_1__24187);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2001:1: rule__LogicalNotExpression__Group_1__2__Impl : ( ( rule__LogicalNotExpression__OperandAssignment_1_2 ) ) ;
    public final void rule__LogicalNotExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2005:1: ( ( ( rule__LogicalNotExpression__OperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2006:1: ( ( rule__LogicalNotExpression__OperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2006:1: ( ( rule__LogicalNotExpression__OperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2007:1: ( rule__LogicalNotExpression__OperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalNotExpressionAccess().getOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2008:1: ( rule__LogicalNotExpression__OperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2008:2: rule__LogicalNotExpression__OperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__LogicalNotExpression__OperandAssignment_1_2_in_rule__LogicalNotExpression__Group_1__2__Impl4214);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2024:1: rule__BitwiseXorExpression__Group__0 : rule__BitwiseXorExpression__Group__0__Impl rule__BitwiseXorExpression__Group__1 ;
    public final void rule__BitwiseXorExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2028:1: ( rule__BitwiseXorExpression__Group__0__Impl rule__BitwiseXorExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2029:2: rule__BitwiseXorExpression__Group__0__Impl rule__BitwiseXorExpression__Group__1
            {
            pushFollow(FOLLOW_rule__BitwiseXorExpression__Group__0__Impl_in_rule__BitwiseXorExpression__Group__04250);
            rule__BitwiseXorExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitwiseXorExpression__Group__1_in_rule__BitwiseXorExpression__Group__04253);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2036:1: rule__BitwiseXorExpression__Group__0__Impl : ( ruleBitwiseOrExpression ) ;
    public final void rule__BitwiseXorExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2040:1: ( ( ruleBitwiseOrExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2041:1: ( ruleBitwiseOrExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2041:1: ( ruleBitwiseOrExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2042:1: ruleBitwiseOrExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseXorExpressionAccess().getBitwiseOrExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleBitwiseOrExpression_in_rule__BitwiseXorExpression__Group__0__Impl4280);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2053:1: rule__BitwiseXorExpression__Group__1 : rule__BitwiseXorExpression__Group__1__Impl ;
    public final void rule__BitwiseXorExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2057:1: ( rule__BitwiseXorExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2058:2: rule__BitwiseXorExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BitwiseXorExpression__Group__1__Impl_in_rule__BitwiseXorExpression__Group__14309);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2064:1: rule__BitwiseXorExpression__Group__1__Impl : ( ( rule__BitwiseXorExpression__Group_1__0 )* ) ;
    public final void rule__BitwiseXorExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2068:1: ( ( ( rule__BitwiseXorExpression__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2069:1: ( ( rule__BitwiseXorExpression__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2069:1: ( ( rule__BitwiseXorExpression__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2070:1: ( rule__BitwiseXorExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseXorExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2071:1: ( rule__BitwiseXorExpression__Group_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==44) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2071:2: rule__BitwiseXorExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__BitwiseXorExpression__Group_1__0_in_rule__BitwiseXorExpression__Group__1__Impl4336);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2085:1: rule__BitwiseXorExpression__Group_1__0 : rule__BitwiseXorExpression__Group_1__0__Impl rule__BitwiseXorExpression__Group_1__1 ;
    public final void rule__BitwiseXorExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2089:1: ( rule__BitwiseXorExpression__Group_1__0__Impl rule__BitwiseXorExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2090:2: rule__BitwiseXorExpression__Group_1__0__Impl rule__BitwiseXorExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__BitwiseXorExpression__Group_1__0__Impl_in_rule__BitwiseXorExpression__Group_1__04371);
            rule__BitwiseXorExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitwiseXorExpression__Group_1__1_in_rule__BitwiseXorExpression__Group_1__04374);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2097:1: rule__BitwiseXorExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__BitwiseXorExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2101:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2102:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2102:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2103:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXorExpressionLeftOperandAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2104:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2106:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2116:1: rule__BitwiseXorExpression__Group_1__1 : rule__BitwiseXorExpression__Group_1__1__Impl rule__BitwiseXorExpression__Group_1__2 ;
    public final void rule__BitwiseXorExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2120:1: ( rule__BitwiseXorExpression__Group_1__1__Impl rule__BitwiseXorExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2121:2: rule__BitwiseXorExpression__Group_1__1__Impl rule__BitwiseXorExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__BitwiseXorExpression__Group_1__1__Impl_in_rule__BitwiseXorExpression__Group_1__14432);
            rule__BitwiseXorExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitwiseXorExpression__Group_1__2_in_rule__BitwiseXorExpression__Group_1__14435);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2128:1: rule__BitwiseXorExpression__Group_1__1__Impl : ( '^' ) ;
    public final void rule__BitwiseXorExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2132:1: ( ( '^' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2133:1: ( '^' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2133:1: ( '^' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2134:1: '^'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseXorExpressionAccess().getCircumflexAccentKeyword_1_1()); 
            }
            match(input,44,FOLLOW_44_in_rule__BitwiseXorExpression__Group_1__1__Impl4463); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2147:1: rule__BitwiseXorExpression__Group_1__2 : rule__BitwiseXorExpression__Group_1__2__Impl ;
    public final void rule__BitwiseXorExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2151:1: ( rule__BitwiseXorExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2152:2: rule__BitwiseXorExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__BitwiseXorExpression__Group_1__2__Impl_in_rule__BitwiseXorExpression__Group_1__24494);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2158:1: rule__BitwiseXorExpression__Group_1__2__Impl : ( ( rule__BitwiseXorExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__BitwiseXorExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2162:1: ( ( ( rule__BitwiseXorExpression__RightOperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2163:1: ( ( rule__BitwiseXorExpression__RightOperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2163:1: ( ( rule__BitwiseXorExpression__RightOperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2164:1: ( rule__BitwiseXorExpression__RightOperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseXorExpressionAccess().getRightOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2165:1: ( rule__BitwiseXorExpression__RightOperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2165:2: rule__BitwiseXorExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__BitwiseXorExpression__RightOperandAssignment_1_2_in_rule__BitwiseXorExpression__Group_1__2__Impl4521);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2181:1: rule__BitwiseOrExpression__Group__0 : rule__BitwiseOrExpression__Group__0__Impl rule__BitwiseOrExpression__Group__1 ;
    public final void rule__BitwiseOrExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2185:1: ( rule__BitwiseOrExpression__Group__0__Impl rule__BitwiseOrExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2186:2: rule__BitwiseOrExpression__Group__0__Impl rule__BitwiseOrExpression__Group__1
            {
            pushFollow(FOLLOW_rule__BitwiseOrExpression__Group__0__Impl_in_rule__BitwiseOrExpression__Group__04557);
            rule__BitwiseOrExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitwiseOrExpression__Group__1_in_rule__BitwiseOrExpression__Group__04560);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2193:1: rule__BitwiseOrExpression__Group__0__Impl : ( ruleBitwiseAndExpression ) ;
    public final void rule__BitwiseOrExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2197:1: ( ( ruleBitwiseAndExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2198:1: ( ruleBitwiseAndExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2198:1: ( ruleBitwiseAndExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2199:1: ruleBitwiseAndExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseOrExpressionAccess().getBitwiseAndExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleBitwiseAndExpression_in_rule__BitwiseOrExpression__Group__0__Impl4587);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2210:1: rule__BitwiseOrExpression__Group__1 : rule__BitwiseOrExpression__Group__1__Impl ;
    public final void rule__BitwiseOrExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2214:1: ( rule__BitwiseOrExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2215:2: rule__BitwiseOrExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BitwiseOrExpression__Group__1__Impl_in_rule__BitwiseOrExpression__Group__14616);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2221:1: rule__BitwiseOrExpression__Group__1__Impl : ( ( rule__BitwiseOrExpression__Group_1__0 )* ) ;
    public final void rule__BitwiseOrExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2225:1: ( ( ( rule__BitwiseOrExpression__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2226:1: ( ( rule__BitwiseOrExpression__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2226:1: ( ( rule__BitwiseOrExpression__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2227:1: ( rule__BitwiseOrExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseOrExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2228:1: ( rule__BitwiseOrExpression__Group_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==45) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2228:2: rule__BitwiseOrExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__BitwiseOrExpression__Group_1__0_in_rule__BitwiseOrExpression__Group__1__Impl4643);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2242:1: rule__BitwiseOrExpression__Group_1__0 : rule__BitwiseOrExpression__Group_1__0__Impl rule__BitwiseOrExpression__Group_1__1 ;
    public final void rule__BitwiseOrExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2246:1: ( rule__BitwiseOrExpression__Group_1__0__Impl rule__BitwiseOrExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2247:2: rule__BitwiseOrExpression__Group_1__0__Impl rule__BitwiseOrExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__BitwiseOrExpression__Group_1__0__Impl_in_rule__BitwiseOrExpression__Group_1__04678);
            rule__BitwiseOrExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitwiseOrExpression__Group_1__1_in_rule__BitwiseOrExpression__Group_1__04681);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2254:1: rule__BitwiseOrExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__BitwiseOrExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2258:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2259:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2259:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2260:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseOrExpressionAccess().getBitwiseOrExpressionLeftOperandAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2261:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2263:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2273:1: rule__BitwiseOrExpression__Group_1__1 : rule__BitwiseOrExpression__Group_1__1__Impl rule__BitwiseOrExpression__Group_1__2 ;
    public final void rule__BitwiseOrExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2277:1: ( rule__BitwiseOrExpression__Group_1__1__Impl rule__BitwiseOrExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2278:2: rule__BitwiseOrExpression__Group_1__1__Impl rule__BitwiseOrExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__BitwiseOrExpression__Group_1__1__Impl_in_rule__BitwiseOrExpression__Group_1__14739);
            rule__BitwiseOrExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitwiseOrExpression__Group_1__2_in_rule__BitwiseOrExpression__Group_1__14742);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2285:1: rule__BitwiseOrExpression__Group_1__1__Impl : ( '|' ) ;
    public final void rule__BitwiseOrExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2289:1: ( ( '|' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2290:1: ( '|' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2290:1: ( '|' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2291:1: '|'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseOrExpressionAccess().getVerticalLineKeyword_1_1()); 
            }
            match(input,45,FOLLOW_45_in_rule__BitwiseOrExpression__Group_1__1__Impl4770); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2304:1: rule__BitwiseOrExpression__Group_1__2 : rule__BitwiseOrExpression__Group_1__2__Impl ;
    public final void rule__BitwiseOrExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2308:1: ( rule__BitwiseOrExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2309:2: rule__BitwiseOrExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__BitwiseOrExpression__Group_1__2__Impl_in_rule__BitwiseOrExpression__Group_1__24801);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2315:1: rule__BitwiseOrExpression__Group_1__2__Impl : ( ( rule__BitwiseOrExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__BitwiseOrExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2319:1: ( ( ( rule__BitwiseOrExpression__RightOperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2320:1: ( ( rule__BitwiseOrExpression__RightOperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2320:1: ( ( rule__BitwiseOrExpression__RightOperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2321:1: ( rule__BitwiseOrExpression__RightOperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseOrExpressionAccess().getRightOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2322:1: ( rule__BitwiseOrExpression__RightOperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2322:2: rule__BitwiseOrExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__BitwiseOrExpression__RightOperandAssignment_1_2_in_rule__BitwiseOrExpression__Group_1__2__Impl4828);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2338:1: rule__BitwiseAndExpression__Group__0 : rule__BitwiseAndExpression__Group__0__Impl rule__BitwiseAndExpression__Group__1 ;
    public final void rule__BitwiseAndExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2342:1: ( rule__BitwiseAndExpression__Group__0__Impl rule__BitwiseAndExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2343:2: rule__BitwiseAndExpression__Group__0__Impl rule__BitwiseAndExpression__Group__1
            {
            pushFollow(FOLLOW_rule__BitwiseAndExpression__Group__0__Impl_in_rule__BitwiseAndExpression__Group__04864);
            rule__BitwiseAndExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitwiseAndExpression__Group__1_in_rule__BitwiseAndExpression__Group__04867);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2350:1: rule__BitwiseAndExpression__Group__0__Impl : ( ruleLogicalRelationExpression ) ;
    public final void rule__BitwiseAndExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2354:1: ( ( ruleLogicalRelationExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2355:1: ( ruleLogicalRelationExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2355:1: ( ruleLogicalRelationExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2356:1: ruleLogicalRelationExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseAndExpressionAccess().getLogicalRelationExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleLogicalRelationExpression_in_rule__BitwiseAndExpression__Group__0__Impl4894);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2367:1: rule__BitwiseAndExpression__Group__1 : rule__BitwiseAndExpression__Group__1__Impl ;
    public final void rule__BitwiseAndExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2371:1: ( rule__BitwiseAndExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2372:2: rule__BitwiseAndExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BitwiseAndExpression__Group__1__Impl_in_rule__BitwiseAndExpression__Group__14923);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2378:1: rule__BitwiseAndExpression__Group__1__Impl : ( ( rule__BitwiseAndExpression__Group_1__0 )* ) ;
    public final void rule__BitwiseAndExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2382:1: ( ( ( rule__BitwiseAndExpression__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2383:1: ( ( rule__BitwiseAndExpression__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2383:1: ( ( rule__BitwiseAndExpression__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2384:1: ( rule__BitwiseAndExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseAndExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2385:1: ( rule__BitwiseAndExpression__Group_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==46) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2385:2: rule__BitwiseAndExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__BitwiseAndExpression__Group_1__0_in_rule__BitwiseAndExpression__Group__1__Impl4950);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2399:1: rule__BitwiseAndExpression__Group_1__0 : rule__BitwiseAndExpression__Group_1__0__Impl rule__BitwiseAndExpression__Group_1__1 ;
    public final void rule__BitwiseAndExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2403:1: ( rule__BitwiseAndExpression__Group_1__0__Impl rule__BitwiseAndExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2404:2: rule__BitwiseAndExpression__Group_1__0__Impl rule__BitwiseAndExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__BitwiseAndExpression__Group_1__0__Impl_in_rule__BitwiseAndExpression__Group_1__04985);
            rule__BitwiseAndExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitwiseAndExpression__Group_1__1_in_rule__BitwiseAndExpression__Group_1__04988);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2411:1: rule__BitwiseAndExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__BitwiseAndExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2415:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2416:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2416:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2417:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAndExpressionLeftOperandAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2418:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2420:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2430:1: rule__BitwiseAndExpression__Group_1__1 : rule__BitwiseAndExpression__Group_1__1__Impl rule__BitwiseAndExpression__Group_1__2 ;
    public final void rule__BitwiseAndExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2434:1: ( rule__BitwiseAndExpression__Group_1__1__Impl rule__BitwiseAndExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2435:2: rule__BitwiseAndExpression__Group_1__1__Impl rule__BitwiseAndExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__BitwiseAndExpression__Group_1__1__Impl_in_rule__BitwiseAndExpression__Group_1__15046);
            rule__BitwiseAndExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitwiseAndExpression__Group_1__2_in_rule__BitwiseAndExpression__Group_1__15049);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2442:1: rule__BitwiseAndExpression__Group_1__1__Impl : ( '&' ) ;
    public final void rule__BitwiseAndExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2446:1: ( ( '&' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2447:1: ( '&' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2447:1: ( '&' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2448:1: '&'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseAndExpressionAccess().getAmpersandKeyword_1_1()); 
            }
            match(input,46,FOLLOW_46_in_rule__BitwiseAndExpression__Group_1__1__Impl5077); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2461:1: rule__BitwiseAndExpression__Group_1__2 : rule__BitwiseAndExpression__Group_1__2__Impl ;
    public final void rule__BitwiseAndExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2465:1: ( rule__BitwiseAndExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2466:2: rule__BitwiseAndExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__BitwiseAndExpression__Group_1__2__Impl_in_rule__BitwiseAndExpression__Group_1__25108);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2472:1: rule__BitwiseAndExpression__Group_1__2__Impl : ( ( rule__BitwiseAndExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__BitwiseAndExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2476:1: ( ( ( rule__BitwiseAndExpression__RightOperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2477:1: ( ( rule__BitwiseAndExpression__RightOperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2477:1: ( ( rule__BitwiseAndExpression__RightOperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2478:1: ( rule__BitwiseAndExpression__RightOperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseAndExpressionAccess().getRightOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2479:1: ( rule__BitwiseAndExpression__RightOperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2479:2: rule__BitwiseAndExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__BitwiseAndExpression__RightOperandAssignment_1_2_in_rule__BitwiseAndExpression__Group_1__2__Impl5135);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2495:1: rule__LogicalRelationExpression__Group__0 : rule__LogicalRelationExpression__Group__0__Impl rule__LogicalRelationExpression__Group__1 ;
    public final void rule__LogicalRelationExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2499:1: ( rule__LogicalRelationExpression__Group__0__Impl rule__LogicalRelationExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2500:2: rule__LogicalRelationExpression__Group__0__Impl rule__LogicalRelationExpression__Group__1
            {
            pushFollow(FOLLOW_rule__LogicalRelationExpression__Group__0__Impl_in_rule__LogicalRelationExpression__Group__05171);
            rule__LogicalRelationExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalRelationExpression__Group__1_in_rule__LogicalRelationExpression__Group__05174);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2507:1: rule__LogicalRelationExpression__Group__0__Impl : ( ruleShiftExpression ) ;
    public final void rule__LogicalRelationExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2511:1: ( ( ruleShiftExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2512:1: ( ruleShiftExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2512:1: ( ruleShiftExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2513:1: ruleShiftExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalRelationExpressionAccess().getShiftExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleShiftExpression_in_rule__LogicalRelationExpression__Group__0__Impl5201);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2524:1: rule__LogicalRelationExpression__Group__1 : rule__LogicalRelationExpression__Group__1__Impl ;
    public final void rule__LogicalRelationExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2528:1: ( rule__LogicalRelationExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2529:2: rule__LogicalRelationExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__LogicalRelationExpression__Group__1__Impl_in_rule__LogicalRelationExpression__Group__15230);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2535:1: rule__LogicalRelationExpression__Group__1__Impl : ( ( rule__LogicalRelationExpression__Group_1__0 )* ) ;
    public final void rule__LogicalRelationExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2539:1: ( ( ( rule__LogicalRelationExpression__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2540:1: ( ( rule__LogicalRelationExpression__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2540:1: ( ( rule__LogicalRelationExpression__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2541:1: ( rule__LogicalRelationExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalRelationExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2542:1: ( rule__LogicalRelationExpression__Group_1__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=33 && LA18_0<=38)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2542:2: rule__LogicalRelationExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__LogicalRelationExpression__Group_1__0_in_rule__LogicalRelationExpression__Group__1__Impl5257);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2556:1: rule__LogicalRelationExpression__Group_1__0 : rule__LogicalRelationExpression__Group_1__0__Impl rule__LogicalRelationExpression__Group_1__1 ;
    public final void rule__LogicalRelationExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2560:1: ( rule__LogicalRelationExpression__Group_1__0__Impl rule__LogicalRelationExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2561:2: rule__LogicalRelationExpression__Group_1__0__Impl rule__LogicalRelationExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__LogicalRelationExpression__Group_1__0__Impl_in_rule__LogicalRelationExpression__Group_1__05292);
            rule__LogicalRelationExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalRelationExpression__Group_1__1_in_rule__LogicalRelationExpression__Group_1__05295);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2568:1: rule__LogicalRelationExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__LogicalRelationExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2572:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2573:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2573:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2574:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2575:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2577:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2587:1: rule__LogicalRelationExpression__Group_1__1 : rule__LogicalRelationExpression__Group_1__1__Impl rule__LogicalRelationExpression__Group_1__2 ;
    public final void rule__LogicalRelationExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2591:1: ( rule__LogicalRelationExpression__Group_1__1__Impl rule__LogicalRelationExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2592:2: rule__LogicalRelationExpression__Group_1__1__Impl rule__LogicalRelationExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__LogicalRelationExpression__Group_1__1__Impl_in_rule__LogicalRelationExpression__Group_1__15353);
            rule__LogicalRelationExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LogicalRelationExpression__Group_1__2_in_rule__LogicalRelationExpression__Group_1__15356);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2599:1: rule__LogicalRelationExpression__Group_1__1__Impl : ( ( rule__LogicalRelationExpression__OperatorAssignment_1_1 ) ) ;
    public final void rule__LogicalRelationExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2603:1: ( ( ( rule__LogicalRelationExpression__OperatorAssignment_1_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2604:1: ( ( rule__LogicalRelationExpression__OperatorAssignment_1_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2604:1: ( ( rule__LogicalRelationExpression__OperatorAssignment_1_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2605:1: ( rule__LogicalRelationExpression__OperatorAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalRelationExpressionAccess().getOperatorAssignment_1_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2606:1: ( rule__LogicalRelationExpression__OperatorAssignment_1_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2606:2: rule__LogicalRelationExpression__OperatorAssignment_1_1
            {
            pushFollow(FOLLOW_rule__LogicalRelationExpression__OperatorAssignment_1_1_in_rule__LogicalRelationExpression__Group_1__1__Impl5383);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2616:1: rule__LogicalRelationExpression__Group_1__2 : rule__LogicalRelationExpression__Group_1__2__Impl ;
    public final void rule__LogicalRelationExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2620:1: ( rule__LogicalRelationExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2621:2: rule__LogicalRelationExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__LogicalRelationExpression__Group_1__2__Impl_in_rule__LogicalRelationExpression__Group_1__25413);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2627:1: rule__LogicalRelationExpression__Group_1__2__Impl : ( ( rule__LogicalRelationExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__LogicalRelationExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2631:1: ( ( ( rule__LogicalRelationExpression__RightOperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2632:1: ( ( rule__LogicalRelationExpression__RightOperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2632:1: ( ( rule__LogicalRelationExpression__RightOperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2633:1: ( rule__LogicalRelationExpression__RightOperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalRelationExpressionAccess().getRightOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2634:1: ( rule__LogicalRelationExpression__RightOperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2634:2: rule__LogicalRelationExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__LogicalRelationExpression__RightOperandAssignment_1_2_in_rule__LogicalRelationExpression__Group_1__2__Impl5440);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2650:1: rule__ShiftExpression__Group__0 : rule__ShiftExpression__Group__0__Impl rule__ShiftExpression__Group__1 ;
    public final void rule__ShiftExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2654:1: ( rule__ShiftExpression__Group__0__Impl rule__ShiftExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2655:2: rule__ShiftExpression__Group__0__Impl rule__ShiftExpression__Group__1
            {
            pushFollow(FOLLOW_rule__ShiftExpression__Group__0__Impl_in_rule__ShiftExpression__Group__05476);
            rule__ShiftExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ShiftExpression__Group__1_in_rule__ShiftExpression__Group__05479);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2662:1: rule__ShiftExpression__Group__0__Impl : ( ruleNumericalAddSubtractExpression ) ;
    public final void rule__ShiftExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2666:1: ( ( ruleNumericalAddSubtractExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2667:1: ( ruleNumericalAddSubtractExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2667:1: ( ruleNumericalAddSubtractExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2668:1: ruleNumericalAddSubtractExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExpressionAccess().getNumericalAddSubtractExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_rule__ShiftExpression__Group__0__Impl5506);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2679:1: rule__ShiftExpression__Group__1 : rule__ShiftExpression__Group__1__Impl ;
    public final void rule__ShiftExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2683:1: ( rule__ShiftExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2684:2: rule__ShiftExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ShiftExpression__Group__1__Impl_in_rule__ShiftExpression__Group__15535);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2690:1: rule__ShiftExpression__Group__1__Impl : ( ( rule__ShiftExpression__Group_1__0 )* ) ;
    public final void rule__ShiftExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2694:1: ( ( ( rule__ShiftExpression__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2695:1: ( ( rule__ShiftExpression__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2695:1: ( ( rule__ShiftExpression__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2696:1: ( rule__ShiftExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2697:1: ( rule__ShiftExpression__Group_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=25 && LA19_0<=26)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2697:2: rule__ShiftExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ShiftExpression__Group_1__0_in_rule__ShiftExpression__Group__1__Impl5562);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2711:1: rule__ShiftExpression__Group_1__0 : rule__ShiftExpression__Group_1__0__Impl rule__ShiftExpression__Group_1__1 ;
    public final void rule__ShiftExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2715:1: ( rule__ShiftExpression__Group_1__0__Impl rule__ShiftExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2716:2: rule__ShiftExpression__Group_1__0__Impl rule__ShiftExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__ShiftExpression__Group_1__0__Impl_in_rule__ShiftExpression__Group_1__05597);
            rule__ShiftExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ShiftExpression__Group_1__1_in_rule__ShiftExpression__Group_1__05600);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2723:1: rule__ShiftExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__ShiftExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2727:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2728:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2728:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2729:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftOperandAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2730:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2732:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2742:1: rule__ShiftExpression__Group_1__1 : rule__ShiftExpression__Group_1__1__Impl rule__ShiftExpression__Group_1__2 ;
    public final void rule__ShiftExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2746:1: ( rule__ShiftExpression__Group_1__1__Impl rule__ShiftExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2747:2: rule__ShiftExpression__Group_1__1__Impl rule__ShiftExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__ShiftExpression__Group_1__1__Impl_in_rule__ShiftExpression__Group_1__15658);
            rule__ShiftExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ShiftExpression__Group_1__2_in_rule__ShiftExpression__Group_1__15661);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2754:1: rule__ShiftExpression__Group_1__1__Impl : ( ( rule__ShiftExpression__OperatorAssignment_1_1 ) ) ;
    public final void rule__ShiftExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2758:1: ( ( ( rule__ShiftExpression__OperatorAssignment_1_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2759:1: ( ( rule__ShiftExpression__OperatorAssignment_1_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2759:1: ( ( rule__ShiftExpression__OperatorAssignment_1_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2760:1: ( rule__ShiftExpression__OperatorAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExpressionAccess().getOperatorAssignment_1_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2761:1: ( rule__ShiftExpression__OperatorAssignment_1_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2761:2: rule__ShiftExpression__OperatorAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ShiftExpression__OperatorAssignment_1_1_in_rule__ShiftExpression__Group_1__1__Impl5688);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2771:1: rule__ShiftExpression__Group_1__2 : rule__ShiftExpression__Group_1__2__Impl ;
    public final void rule__ShiftExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2775:1: ( rule__ShiftExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2776:2: rule__ShiftExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ShiftExpression__Group_1__2__Impl_in_rule__ShiftExpression__Group_1__25718);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2782:1: rule__ShiftExpression__Group_1__2__Impl : ( ( rule__ShiftExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__ShiftExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2786:1: ( ( ( rule__ShiftExpression__RightOperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2787:1: ( ( rule__ShiftExpression__RightOperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2787:1: ( ( rule__ShiftExpression__RightOperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2788:1: ( rule__ShiftExpression__RightOperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExpressionAccess().getRightOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2789:1: ( rule__ShiftExpression__RightOperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2789:2: rule__ShiftExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__ShiftExpression__RightOperandAssignment_1_2_in_rule__ShiftExpression__Group_1__2__Impl5745);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2805:1: rule__NumericalAddSubtractExpression__Group__0 : rule__NumericalAddSubtractExpression__Group__0__Impl rule__NumericalAddSubtractExpression__Group__1 ;
    public final void rule__NumericalAddSubtractExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2809:1: ( rule__NumericalAddSubtractExpression__Group__0__Impl rule__NumericalAddSubtractExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2810:2: rule__NumericalAddSubtractExpression__Group__0__Impl rule__NumericalAddSubtractExpression__Group__1
            {
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__Group__0__Impl_in_rule__NumericalAddSubtractExpression__Group__05781);
            rule__NumericalAddSubtractExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__Group__1_in_rule__NumericalAddSubtractExpression__Group__05784);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2817:1: rule__NumericalAddSubtractExpression__Group__0__Impl : ( ruleNumericalMultiplyDivideExpression ) ;
    public final void rule__NumericalAddSubtractExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2821:1: ( ( ruleNumericalMultiplyDivideExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2822:1: ( ruleNumericalMultiplyDivideExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2822:1: ( ruleNumericalMultiplyDivideExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2823:1: ruleNumericalMultiplyDivideExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalMultiplyDivideExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_rule__NumericalAddSubtractExpression__Group__0__Impl5811);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2834:1: rule__NumericalAddSubtractExpression__Group__1 : rule__NumericalAddSubtractExpression__Group__1__Impl ;
    public final void rule__NumericalAddSubtractExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2838:1: ( rule__NumericalAddSubtractExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2839:2: rule__NumericalAddSubtractExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__Group__1__Impl_in_rule__NumericalAddSubtractExpression__Group__15840);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2845:1: rule__NumericalAddSubtractExpression__Group__1__Impl : ( ( rule__NumericalAddSubtractExpression__Group_1__0 )* ) ;
    public final void rule__NumericalAddSubtractExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2849:1: ( ( ( rule__NumericalAddSubtractExpression__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2850:1: ( ( rule__NumericalAddSubtractExpression__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2850:1: ( ( rule__NumericalAddSubtractExpression__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2851:1: ( rule__NumericalAddSubtractExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalAddSubtractExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2852:1: ( rule__NumericalAddSubtractExpression__Group_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=27 && LA20_0<=28)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2852:2: rule__NumericalAddSubtractExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__Group_1__0_in_rule__NumericalAddSubtractExpression__Group__1__Impl5867);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2866:1: rule__NumericalAddSubtractExpression__Group_1__0 : rule__NumericalAddSubtractExpression__Group_1__0__Impl rule__NumericalAddSubtractExpression__Group_1__1 ;
    public final void rule__NumericalAddSubtractExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2870:1: ( rule__NumericalAddSubtractExpression__Group_1__0__Impl rule__NumericalAddSubtractExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2871:2: rule__NumericalAddSubtractExpression__Group_1__0__Impl rule__NumericalAddSubtractExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__Group_1__0__Impl_in_rule__NumericalAddSubtractExpression__Group_1__05902);
            rule__NumericalAddSubtractExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__Group_1__1_in_rule__NumericalAddSubtractExpression__Group_1__05905);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2878:1: rule__NumericalAddSubtractExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__NumericalAddSubtractExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2882:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2883:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2883:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2884:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalAddSubtractExpressionLeftOperandAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2885:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2887:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2897:1: rule__NumericalAddSubtractExpression__Group_1__1 : rule__NumericalAddSubtractExpression__Group_1__1__Impl rule__NumericalAddSubtractExpression__Group_1__2 ;
    public final void rule__NumericalAddSubtractExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2901:1: ( rule__NumericalAddSubtractExpression__Group_1__1__Impl rule__NumericalAddSubtractExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2902:2: rule__NumericalAddSubtractExpression__Group_1__1__Impl rule__NumericalAddSubtractExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__Group_1__1__Impl_in_rule__NumericalAddSubtractExpression__Group_1__15963);
            rule__NumericalAddSubtractExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__Group_1__2_in_rule__NumericalAddSubtractExpression__Group_1__15966);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2909:1: rule__NumericalAddSubtractExpression__Group_1__1__Impl : ( ( rule__NumericalAddSubtractExpression__OperatorAssignment_1_1 ) ) ;
    public final void rule__NumericalAddSubtractExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2913:1: ( ( ( rule__NumericalAddSubtractExpression__OperatorAssignment_1_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2914:1: ( ( rule__NumericalAddSubtractExpression__OperatorAssignment_1_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2914:1: ( ( rule__NumericalAddSubtractExpression__OperatorAssignment_1_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2915:1: ( rule__NumericalAddSubtractExpression__OperatorAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalAddSubtractExpressionAccess().getOperatorAssignment_1_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2916:1: ( rule__NumericalAddSubtractExpression__OperatorAssignment_1_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2916:2: rule__NumericalAddSubtractExpression__OperatorAssignment_1_1
            {
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__OperatorAssignment_1_1_in_rule__NumericalAddSubtractExpression__Group_1__1__Impl5993);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2926:1: rule__NumericalAddSubtractExpression__Group_1__2 : rule__NumericalAddSubtractExpression__Group_1__2__Impl ;
    public final void rule__NumericalAddSubtractExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2930:1: ( rule__NumericalAddSubtractExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2931:2: rule__NumericalAddSubtractExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__Group_1__2__Impl_in_rule__NumericalAddSubtractExpression__Group_1__26023);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2937:1: rule__NumericalAddSubtractExpression__Group_1__2__Impl : ( ( rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__NumericalAddSubtractExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2941:1: ( ( ( rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2942:1: ( ( rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2942:1: ( ( rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2943:1: ( rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalAddSubtractExpressionAccess().getRightOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2944:1: ( rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2944:2: rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2_in_rule__NumericalAddSubtractExpression__Group_1__2__Impl6050);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2960:1: rule__NumericalMultiplyDivideExpression__Group__0 : rule__NumericalMultiplyDivideExpression__Group__0__Impl rule__NumericalMultiplyDivideExpression__Group__1 ;
    public final void rule__NumericalMultiplyDivideExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2964:1: ( rule__NumericalMultiplyDivideExpression__Group__0__Impl rule__NumericalMultiplyDivideExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2965:2: rule__NumericalMultiplyDivideExpression__Group__0__Impl rule__NumericalMultiplyDivideExpression__Group__1
            {
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__Group__0__Impl_in_rule__NumericalMultiplyDivideExpression__Group__06086);
            rule__NumericalMultiplyDivideExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__Group__1_in_rule__NumericalMultiplyDivideExpression__Group__06089);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2972:1: rule__NumericalMultiplyDivideExpression__Group__0__Impl : ( ruleNumericalUnaryExpression ) ;
    public final void rule__NumericalMultiplyDivideExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2976:1: ( ( ruleNumericalUnaryExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2977:1: ( ruleNumericalUnaryExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2977:1: ( ruleNumericalUnaryExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2978:1: ruleNumericalUnaryExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalUnaryExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_rule__NumericalMultiplyDivideExpression__Group__0__Impl6116);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2989:1: rule__NumericalMultiplyDivideExpression__Group__1 : rule__NumericalMultiplyDivideExpression__Group__1__Impl ;
    public final void rule__NumericalMultiplyDivideExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2993:1: ( rule__NumericalMultiplyDivideExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2994:2: rule__NumericalMultiplyDivideExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__Group__1__Impl_in_rule__NumericalMultiplyDivideExpression__Group__16145);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3000:1: rule__NumericalMultiplyDivideExpression__Group__1__Impl : ( ( rule__NumericalMultiplyDivideExpression__Group_1__0 )* ) ;
    public final void rule__NumericalMultiplyDivideExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3004:1: ( ( ( rule__NumericalMultiplyDivideExpression__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3005:1: ( ( rule__NumericalMultiplyDivideExpression__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3005:1: ( ( rule__NumericalMultiplyDivideExpression__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3006:1: ( rule__NumericalMultiplyDivideExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3007:1: ( rule__NumericalMultiplyDivideExpression__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=29 && LA21_0<=31)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3007:2: rule__NumericalMultiplyDivideExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__0_in_rule__NumericalMultiplyDivideExpression__Group__1__Impl6172);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3021:1: rule__NumericalMultiplyDivideExpression__Group_1__0 : rule__NumericalMultiplyDivideExpression__Group_1__0__Impl rule__NumericalMultiplyDivideExpression__Group_1__1 ;
    public final void rule__NumericalMultiplyDivideExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3025:1: ( rule__NumericalMultiplyDivideExpression__Group_1__0__Impl rule__NumericalMultiplyDivideExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3026:2: rule__NumericalMultiplyDivideExpression__Group_1__0__Impl rule__NumericalMultiplyDivideExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__0__Impl_in_rule__NumericalMultiplyDivideExpression__Group_1__06207);
            rule__NumericalMultiplyDivideExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__1_in_rule__NumericalMultiplyDivideExpression__Group_1__06210);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3033:1: rule__NumericalMultiplyDivideExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__NumericalMultiplyDivideExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3037:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3038:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3038:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3039:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalMultiplyDivideExpressionLeftOperandAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3040:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3042:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3052:1: rule__NumericalMultiplyDivideExpression__Group_1__1 : rule__NumericalMultiplyDivideExpression__Group_1__1__Impl rule__NumericalMultiplyDivideExpression__Group_1__2 ;
    public final void rule__NumericalMultiplyDivideExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3056:1: ( rule__NumericalMultiplyDivideExpression__Group_1__1__Impl rule__NumericalMultiplyDivideExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3057:2: rule__NumericalMultiplyDivideExpression__Group_1__1__Impl rule__NumericalMultiplyDivideExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__1__Impl_in_rule__NumericalMultiplyDivideExpression__Group_1__16268);
            rule__NumericalMultiplyDivideExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__2_in_rule__NumericalMultiplyDivideExpression__Group_1__16271);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3064:1: rule__NumericalMultiplyDivideExpression__Group_1__1__Impl : ( ( rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1 ) ) ;
    public final void rule__NumericalMultiplyDivideExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3068:1: ( ( ( rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3069:1: ( ( rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3069:1: ( ( rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3070:1: ( rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getOperatorAssignment_1_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3071:1: ( rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3071:2: rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1
            {
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1_in_rule__NumericalMultiplyDivideExpression__Group_1__1__Impl6298);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3081:1: rule__NumericalMultiplyDivideExpression__Group_1__2 : rule__NumericalMultiplyDivideExpression__Group_1__2__Impl ;
    public final void rule__NumericalMultiplyDivideExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3085:1: ( rule__NumericalMultiplyDivideExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3086:2: rule__NumericalMultiplyDivideExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__2__Impl_in_rule__NumericalMultiplyDivideExpression__Group_1__26328);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3092:1: rule__NumericalMultiplyDivideExpression__Group_1__2__Impl : ( ( rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__NumericalMultiplyDivideExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3096:1: ( ( ( rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3097:1: ( ( rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3097:1: ( ( rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3098:1: ( rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getRightOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3099:1: ( rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3099:2: rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2_in_rule__NumericalMultiplyDivideExpression__Group_1__2__Impl6355);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3115:1: rule__NumericalUnaryExpression__Group_1__0 : rule__NumericalUnaryExpression__Group_1__0__Impl rule__NumericalUnaryExpression__Group_1__1 ;
    public final void rule__NumericalUnaryExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3119:1: ( rule__NumericalUnaryExpression__Group_1__0__Impl rule__NumericalUnaryExpression__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3120:2: rule__NumericalUnaryExpression__Group_1__0__Impl rule__NumericalUnaryExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__NumericalUnaryExpression__Group_1__0__Impl_in_rule__NumericalUnaryExpression__Group_1__06391);
            rule__NumericalUnaryExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__NumericalUnaryExpression__Group_1__1_in_rule__NumericalUnaryExpression__Group_1__06394);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3127:1: rule__NumericalUnaryExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__NumericalUnaryExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3131:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3132:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3132:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3133:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalUnaryExpressionAccess().getNumericalUnaryExpressionAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3134:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3136:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3146:1: rule__NumericalUnaryExpression__Group_1__1 : rule__NumericalUnaryExpression__Group_1__1__Impl rule__NumericalUnaryExpression__Group_1__2 ;
    public final void rule__NumericalUnaryExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3150:1: ( rule__NumericalUnaryExpression__Group_1__1__Impl rule__NumericalUnaryExpression__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3151:2: rule__NumericalUnaryExpression__Group_1__1__Impl rule__NumericalUnaryExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__NumericalUnaryExpression__Group_1__1__Impl_in_rule__NumericalUnaryExpression__Group_1__16452);
            rule__NumericalUnaryExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__NumericalUnaryExpression__Group_1__2_in_rule__NumericalUnaryExpression__Group_1__16455);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3158:1: rule__NumericalUnaryExpression__Group_1__1__Impl : ( ( rule__NumericalUnaryExpression__OperatorAssignment_1_1 ) ) ;
    public final void rule__NumericalUnaryExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3162:1: ( ( ( rule__NumericalUnaryExpression__OperatorAssignment_1_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3163:1: ( ( rule__NumericalUnaryExpression__OperatorAssignment_1_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3163:1: ( ( rule__NumericalUnaryExpression__OperatorAssignment_1_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3164:1: ( rule__NumericalUnaryExpression__OperatorAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalUnaryExpressionAccess().getOperatorAssignment_1_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3165:1: ( rule__NumericalUnaryExpression__OperatorAssignment_1_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3165:2: rule__NumericalUnaryExpression__OperatorAssignment_1_1
            {
            pushFollow(FOLLOW_rule__NumericalUnaryExpression__OperatorAssignment_1_1_in_rule__NumericalUnaryExpression__Group_1__1__Impl6482);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3175:1: rule__NumericalUnaryExpression__Group_1__2 : rule__NumericalUnaryExpression__Group_1__2__Impl ;
    public final void rule__NumericalUnaryExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3179:1: ( rule__NumericalUnaryExpression__Group_1__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3180:2: rule__NumericalUnaryExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__NumericalUnaryExpression__Group_1__2__Impl_in_rule__NumericalUnaryExpression__Group_1__26512);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3186:1: rule__NumericalUnaryExpression__Group_1__2__Impl : ( ( rule__NumericalUnaryExpression__OperandAssignment_1_2 ) ) ;
    public final void rule__NumericalUnaryExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3190:1: ( ( ( rule__NumericalUnaryExpression__OperandAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3191:1: ( ( rule__NumericalUnaryExpression__OperandAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3191:1: ( ( rule__NumericalUnaryExpression__OperandAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3192:1: ( rule__NumericalUnaryExpression__OperandAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalUnaryExpressionAccess().getOperandAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3193:1: ( rule__NumericalUnaryExpression__OperandAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3193:2: rule__NumericalUnaryExpression__OperandAssignment_1_2
            {
            pushFollow(FOLLOW_rule__NumericalUnaryExpression__OperandAssignment_1_2_in_rule__NumericalUnaryExpression__Group_1__2__Impl6539);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3209:1: rule__PrimitiveValueExpression__Group__0 : rule__PrimitiveValueExpression__Group__0__Impl rule__PrimitiveValueExpression__Group__1 ;
    public final void rule__PrimitiveValueExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3213:1: ( rule__PrimitiveValueExpression__Group__0__Impl rule__PrimitiveValueExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3214:2: rule__PrimitiveValueExpression__Group__0__Impl rule__PrimitiveValueExpression__Group__1
            {
            pushFollow(FOLLOW_rule__PrimitiveValueExpression__Group__0__Impl_in_rule__PrimitiveValueExpression__Group__06575);
            rule__PrimitiveValueExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__PrimitiveValueExpression__Group__1_in_rule__PrimitiveValueExpression__Group__06578);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3221:1: rule__PrimitiveValueExpression__Group__0__Impl : ( () ) ;
    public final void rule__PrimitiveValueExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3225:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3226:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3226:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3227:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveValueExpressionAccess().getPrimitiveValueExpressionAction_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3228:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3230:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3240:1: rule__PrimitiveValueExpression__Group__1 : rule__PrimitiveValueExpression__Group__1__Impl ;
    public final void rule__PrimitiveValueExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3244:1: ( rule__PrimitiveValueExpression__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3245:2: rule__PrimitiveValueExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__PrimitiveValueExpression__Group__1__Impl_in_rule__PrimitiveValueExpression__Group__16636);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3251:1: rule__PrimitiveValueExpression__Group__1__Impl : ( ( rule__PrimitiveValueExpression__ValueAssignment_1 ) ) ;
    public final void rule__PrimitiveValueExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3255:1: ( ( ( rule__PrimitiveValueExpression__ValueAssignment_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3256:1: ( ( rule__PrimitiveValueExpression__ValueAssignment_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3256:1: ( ( rule__PrimitiveValueExpression__ValueAssignment_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3257:1: ( rule__PrimitiveValueExpression__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveValueExpressionAccess().getValueAssignment_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3258:1: ( rule__PrimitiveValueExpression__ValueAssignment_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3258:2: rule__PrimitiveValueExpression__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__PrimitiveValueExpression__ValueAssignment_1_in_rule__PrimitiveValueExpression__Group__1__Impl6663);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3272:1: rule__FeatureCall__Group__0 : rule__FeatureCall__Group__0__Impl rule__FeatureCall__Group__1 ;
    public final void rule__FeatureCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3276:1: ( rule__FeatureCall__Group__0__Impl rule__FeatureCall__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3277:2: rule__FeatureCall__Group__0__Impl rule__FeatureCall__Group__1
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group__0__Impl_in_rule__FeatureCall__Group__06697);
            rule__FeatureCall__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FeatureCall__Group__1_in_rule__FeatureCall__Group__06700);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3284:1: rule__FeatureCall__Group__0__Impl : ( ruleElementReferenceExpression ) ;
    public final void rule__FeatureCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3288:1: ( ( ruleElementReferenceExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3289:1: ( ruleElementReferenceExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3289:1: ( ruleElementReferenceExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3290:1: ruleElementReferenceExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getElementReferenceExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleElementReferenceExpression_in_rule__FeatureCall__Group__0__Impl6727);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3301:1: rule__FeatureCall__Group__1 : rule__FeatureCall__Group__1__Impl ;
    public final void rule__FeatureCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3305:1: ( rule__FeatureCall__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3306:2: rule__FeatureCall__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group__1__Impl_in_rule__FeatureCall__Group__16756);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3312:1: rule__FeatureCall__Group__1__Impl : ( ( rule__FeatureCall__Group_1__0 )* ) ;
    public final void rule__FeatureCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3316:1: ( ( ( rule__FeatureCall__Group_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3317:1: ( ( rule__FeatureCall__Group_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3317:1: ( ( rule__FeatureCall__Group_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3318:1: ( rule__FeatureCall__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getGroup_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3319:1: ( rule__FeatureCall__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==47) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3319:2: rule__FeatureCall__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FeatureCall__Group_1__0_in_rule__FeatureCall__Group__1__Impl6783);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3333:1: rule__FeatureCall__Group_1__0 : rule__FeatureCall__Group_1__0__Impl rule__FeatureCall__Group_1__1 ;
    public final void rule__FeatureCall__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3337:1: ( rule__FeatureCall__Group_1__0__Impl rule__FeatureCall__Group_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3338:2: rule__FeatureCall__Group_1__0__Impl rule__FeatureCall__Group_1__1
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1__0__Impl_in_rule__FeatureCall__Group_1__06818);
            rule__FeatureCall__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FeatureCall__Group_1__1_in_rule__FeatureCall__Group_1__06821);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3345:1: rule__FeatureCall__Group_1__0__Impl : ( () ) ;
    public final void rule__FeatureCall__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3349:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3350:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3350:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3351:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getFeatureCallOwnerAction_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3352:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3354:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3364:1: rule__FeatureCall__Group_1__1 : rule__FeatureCall__Group_1__1__Impl rule__FeatureCall__Group_1__2 ;
    public final void rule__FeatureCall__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3368:1: ( rule__FeatureCall__Group_1__1__Impl rule__FeatureCall__Group_1__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3369:2: rule__FeatureCall__Group_1__1__Impl rule__FeatureCall__Group_1__2
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1__1__Impl_in_rule__FeatureCall__Group_1__16879);
            rule__FeatureCall__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FeatureCall__Group_1__2_in_rule__FeatureCall__Group_1__16882);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3376:1: rule__FeatureCall__Group_1__1__Impl : ( '.' ) ;
    public final void rule__FeatureCall__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3380:1: ( ( '.' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3381:1: ( '.' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3381:1: ( '.' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3382:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getFullStopKeyword_1_1()); 
            }
            match(input,47,FOLLOW_47_in_rule__FeatureCall__Group_1__1__Impl6910); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3395:1: rule__FeatureCall__Group_1__2 : rule__FeatureCall__Group_1__2__Impl rule__FeatureCall__Group_1__3 ;
    public final void rule__FeatureCall__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3399:1: ( rule__FeatureCall__Group_1__2__Impl rule__FeatureCall__Group_1__3 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3400:2: rule__FeatureCall__Group_1__2__Impl rule__FeatureCall__Group_1__3
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1__2__Impl_in_rule__FeatureCall__Group_1__26941);
            rule__FeatureCall__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FeatureCall__Group_1__3_in_rule__FeatureCall__Group_1__26944);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3407:1: rule__FeatureCall__Group_1__2__Impl : ( ( rule__FeatureCall__FeatureAssignment_1_2 ) ) ;
    public final void rule__FeatureCall__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3411:1: ( ( ( rule__FeatureCall__FeatureAssignment_1_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3412:1: ( ( rule__FeatureCall__FeatureAssignment_1_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3412:1: ( ( rule__FeatureCall__FeatureAssignment_1_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3413:1: ( rule__FeatureCall__FeatureAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getFeatureAssignment_1_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3414:1: ( rule__FeatureCall__FeatureAssignment_1_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3414:2: rule__FeatureCall__FeatureAssignment_1_2
            {
            pushFollow(FOLLOW_rule__FeatureCall__FeatureAssignment_1_2_in_rule__FeatureCall__Group_1__2__Impl6971);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3424:1: rule__FeatureCall__Group_1__3 : rule__FeatureCall__Group_1__3__Impl ;
    public final void rule__FeatureCall__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3428:1: ( rule__FeatureCall__Group_1__3__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3429:2: rule__FeatureCall__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1__3__Impl_in_rule__FeatureCall__Group_1__37001);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3435:1: rule__FeatureCall__Group_1__3__Impl : ( ( rule__FeatureCall__Group_1_3__0 )? ) ;
    public final void rule__FeatureCall__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3439:1: ( ( ( rule__FeatureCall__Group_1_3__0 )? ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3440:1: ( ( rule__FeatureCall__Group_1_3__0 )? )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3440:1: ( ( rule__FeatureCall__Group_1_3__0 )? )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3441:1: ( rule__FeatureCall__Group_1_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getGroup_1_3()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3442:1: ( rule__FeatureCall__Group_1_3__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==50) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3442:2: rule__FeatureCall__Group_1_3__0
                    {
                    pushFollow(FOLLOW_rule__FeatureCall__Group_1_3__0_in_rule__FeatureCall__Group_1__3__Impl7028);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3460:1: rule__FeatureCall__Group_1_3__0 : rule__FeatureCall__Group_1_3__0__Impl rule__FeatureCall__Group_1_3__1 ;
    public final void rule__FeatureCall__Group_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3464:1: ( rule__FeatureCall__Group_1_3__0__Impl rule__FeatureCall__Group_1_3__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3465:2: rule__FeatureCall__Group_1_3__0__Impl rule__FeatureCall__Group_1_3__1
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3__0__Impl_in_rule__FeatureCall__Group_1_3__07067);
            rule__FeatureCall__Group_1_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3__1_in_rule__FeatureCall__Group_1_3__07070);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3472:1: rule__FeatureCall__Group_1_3__0__Impl : ( ( rule__FeatureCall__OperationCallAssignment_1_3_0 ) ) ;
    public final void rule__FeatureCall__Group_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3476:1: ( ( ( rule__FeatureCall__OperationCallAssignment_1_3_0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3477:1: ( ( rule__FeatureCall__OperationCallAssignment_1_3_0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3477:1: ( ( rule__FeatureCall__OperationCallAssignment_1_3_0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3478:1: ( rule__FeatureCall__OperationCallAssignment_1_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getOperationCallAssignment_1_3_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3479:1: ( rule__FeatureCall__OperationCallAssignment_1_3_0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3479:2: rule__FeatureCall__OperationCallAssignment_1_3_0
            {
            pushFollow(FOLLOW_rule__FeatureCall__OperationCallAssignment_1_3_0_in_rule__FeatureCall__Group_1_3__0__Impl7097);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3489:1: rule__FeatureCall__Group_1_3__1 : rule__FeatureCall__Group_1_3__1__Impl rule__FeatureCall__Group_1_3__2 ;
    public final void rule__FeatureCall__Group_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3493:1: ( rule__FeatureCall__Group_1_3__1__Impl rule__FeatureCall__Group_1_3__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3494:2: rule__FeatureCall__Group_1_3__1__Impl rule__FeatureCall__Group_1_3__2
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3__1__Impl_in_rule__FeatureCall__Group_1_3__17127);
            rule__FeatureCall__Group_1_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3__2_in_rule__FeatureCall__Group_1_3__17130);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3501:1: rule__FeatureCall__Group_1_3__1__Impl : ( ( rule__FeatureCall__Group_1_3_1__0 )? ) ;
    public final void rule__FeatureCall__Group_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3505:1: ( ( ( rule__FeatureCall__Group_1_3_1__0 )? ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3506:1: ( ( rule__FeatureCall__Group_1_3_1__0 )? )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3506:1: ( ( rule__FeatureCall__Group_1_3_1__0 )? )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3507:1: ( rule__FeatureCall__Group_1_3_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getGroup_1_3_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3508:1: ( rule__FeatureCall__Group_1_3_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=RULE_ID && LA24_0<=RULE_STRING)||(LA24_0>=27 && LA24_0<=28)||LA24_0==32||LA24_0==43||LA24_0==50) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3508:2: rule__FeatureCall__Group_1_3_1__0
                    {
                    pushFollow(FOLLOW_rule__FeatureCall__Group_1_3_1__0_in_rule__FeatureCall__Group_1_3__1__Impl7157);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3518:1: rule__FeatureCall__Group_1_3__2 : rule__FeatureCall__Group_1_3__2__Impl ;
    public final void rule__FeatureCall__Group_1_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3522:1: ( rule__FeatureCall__Group_1_3__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3523:2: rule__FeatureCall__Group_1_3__2__Impl
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3__2__Impl_in_rule__FeatureCall__Group_1_3__27188);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3529:1: rule__FeatureCall__Group_1_3__2__Impl : ( ')' ) ;
    public final void rule__FeatureCall__Group_1_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3533:1: ( ( ')' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3534:1: ( ')' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3534:1: ( ')' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3535:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getRightParenthesisKeyword_1_3_2()); 
            }
            match(input,48,FOLLOW_48_in_rule__FeatureCall__Group_1_3__2__Impl7216); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3554:1: rule__FeatureCall__Group_1_3_1__0 : rule__FeatureCall__Group_1_3_1__0__Impl rule__FeatureCall__Group_1_3_1__1 ;
    public final void rule__FeatureCall__Group_1_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3558:1: ( rule__FeatureCall__Group_1_3_1__0__Impl rule__FeatureCall__Group_1_3_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3559:2: rule__FeatureCall__Group_1_3_1__0__Impl rule__FeatureCall__Group_1_3_1__1
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3_1__0__Impl_in_rule__FeatureCall__Group_1_3_1__07253);
            rule__FeatureCall__Group_1_3_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3_1__1_in_rule__FeatureCall__Group_1_3_1__07256);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3566:1: rule__FeatureCall__Group_1_3_1__0__Impl : ( ( rule__FeatureCall__ArgsAssignment_1_3_1_0 ) ) ;
    public final void rule__FeatureCall__Group_1_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3570:1: ( ( ( rule__FeatureCall__ArgsAssignment_1_3_1_0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3571:1: ( ( rule__FeatureCall__ArgsAssignment_1_3_1_0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3571:1: ( ( rule__FeatureCall__ArgsAssignment_1_3_1_0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3572:1: ( rule__FeatureCall__ArgsAssignment_1_3_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getArgsAssignment_1_3_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3573:1: ( rule__FeatureCall__ArgsAssignment_1_3_1_0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3573:2: rule__FeatureCall__ArgsAssignment_1_3_1_0
            {
            pushFollow(FOLLOW_rule__FeatureCall__ArgsAssignment_1_3_1_0_in_rule__FeatureCall__Group_1_3_1__0__Impl7283);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3583:1: rule__FeatureCall__Group_1_3_1__1 : rule__FeatureCall__Group_1_3_1__1__Impl ;
    public final void rule__FeatureCall__Group_1_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3587:1: ( rule__FeatureCall__Group_1_3_1__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3588:2: rule__FeatureCall__Group_1_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3_1__1__Impl_in_rule__FeatureCall__Group_1_3_1__17313);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3594:1: rule__FeatureCall__Group_1_3_1__1__Impl : ( ( rule__FeatureCall__Group_1_3_1_1__0 )* ) ;
    public final void rule__FeatureCall__Group_1_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3598:1: ( ( ( rule__FeatureCall__Group_1_3_1_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3599:1: ( ( rule__FeatureCall__Group_1_3_1_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3599:1: ( ( rule__FeatureCall__Group_1_3_1_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3600:1: ( rule__FeatureCall__Group_1_3_1_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getGroup_1_3_1_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3601:1: ( rule__FeatureCall__Group_1_3_1_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==49) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3601:2: rule__FeatureCall__Group_1_3_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FeatureCall__Group_1_3_1_1__0_in_rule__FeatureCall__Group_1_3_1__1__Impl7340);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3615:1: rule__FeatureCall__Group_1_3_1_1__0 : rule__FeatureCall__Group_1_3_1_1__0__Impl rule__FeatureCall__Group_1_3_1_1__1 ;
    public final void rule__FeatureCall__Group_1_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3619:1: ( rule__FeatureCall__Group_1_3_1_1__0__Impl rule__FeatureCall__Group_1_3_1_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3620:2: rule__FeatureCall__Group_1_3_1_1__0__Impl rule__FeatureCall__Group_1_3_1_1__1
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3_1_1__0__Impl_in_rule__FeatureCall__Group_1_3_1_1__07375);
            rule__FeatureCall__Group_1_3_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3_1_1__1_in_rule__FeatureCall__Group_1_3_1_1__07378);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3627:1: rule__FeatureCall__Group_1_3_1_1__0__Impl : ( ',' ) ;
    public final void rule__FeatureCall__Group_1_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3631:1: ( ( ',' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3632:1: ( ',' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3632:1: ( ',' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3633:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getCommaKeyword_1_3_1_1_0()); 
            }
            match(input,49,FOLLOW_49_in_rule__FeatureCall__Group_1_3_1_1__0__Impl7406); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3646:1: rule__FeatureCall__Group_1_3_1_1__1 : rule__FeatureCall__Group_1_3_1_1__1__Impl ;
    public final void rule__FeatureCall__Group_1_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3650:1: ( rule__FeatureCall__Group_1_3_1_1__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3651:2: rule__FeatureCall__Group_1_3_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FeatureCall__Group_1_3_1_1__1__Impl_in_rule__FeatureCall__Group_1_3_1_1__17437);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3657:1: rule__FeatureCall__Group_1_3_1_1__1__Impl : ( ( rule__FeatureCall__ArgsAssignment_1_3_1_1_1 ) ) ;
    public final void rule__FeatureCall__Group_1_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3661:1: ( ( ( rule__FeatureCall__ArgsAssignment_1_3_1_1_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3662:1: ( ( rule__FeatureCall__ArgsAssignment_1_3_1_1_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3662:1: ( ( rule__FeatureCall__ArgsAssignment_1_3_1_1_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3663:1: ( rule__FeatureCall__ArgsAssignment_1_3_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getArgsAssignment_1_3_1_1_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3664:1: ( rule__FeatureCall__ArgsAssignment_1_3_1_1_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3664:2: rule__FeatureCall__ArgsAssignment_1_3_1_1_1
            {
            pushFollow(FOLLOW_rule__FeatureCall__ArgsAssignment_1_3_1_1_1_in_rule__FeatureCall__Group_1_3_1_1__1__Impl7464);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3678:1: rule__ElementReferenceExpression__Group__0 : rule__ElementReferenceExpression__Group__0__Impl rule__ElementReferenceExpression__Group__1 ;
    public final void rule__ElementReferenceExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3682:1: ( rule__ElementReferenceExpression__Group__0__Impl rule__ElementReferenceExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3683:2: rule__ElementReferenceExpression__Group__0__Impl rule__ElementReferenceExpression__Group__1
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group__0__Impl_in_rule__ElementReferenceExpression__Group__07498);
            rule__ElementReferenceExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group__1_in_rule__ElementReferenceExpression__Group__07501);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3690:1: rule__ElementReferenceExpression__Group__0__Impl : ( () ) ;
    public final void rule__ElementReferenceExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3694:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3695:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3695:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3696:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getElementReferenceExpressionAction_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3697:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3699:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3709:1: rule__ElementReferenceExpression__Group__1 : rule__ElementReferenceExpression__Group__1__Impl rule__ElementReferenceExpression__Group__2 ;
    public final void rule__ElementReferenceExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3713:1: ( rule__ElementReferenceExpression__Group__1__Impl rule__ElementReferenceExpression__Group__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3714:2: rule__ElementReferenceExpression__Group__1__Impl rule__ElementReferenceExpression__Group__2
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group__1__Impl_in_rule__ElementReferenceExpression__Group__17559);
            rule__ElementReferenceExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group__2_in_rule__ElementReferenceExpression__Group__17562);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3721:1: rule__ElementReferenceExpression__Group__1__Impl : ( ( rule__ElementReferenceExpression__ReferenceAssignment_1 ) ) ;
    public final void rule__ElementReferenceExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3725:1: ( ( ( rule__ElementReferenceExpression__ReferenceAssignment_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3726:1: ( ( rule__ElementReferenceExpression__ReferenceAssignment_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3726:1: ( ( rule__ElementReferenceExpression__ReferenceAssignment_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3727:1: ( rule__ElementReferenceExpression__ReferenceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getReferenceAssignment_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3728:1: ( rule__ElementReferenceExpression__ReferenceAssignment_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3728:2: rule__ElementReferenceExpression__ReferenceAssignment_1
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__ReferenceAssignment_1_in_rule__ElementReferenceExpression__Group__1__Impl7589);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3738:1: rule__ElementReferenceExpression__Group__2 : rule__ElementReferenceExpression__Group__2__Impl ;
    public final void rule__ElementReferenceExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3742:1: ( rule__ElementReferenceExpression__Group__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3743:2: rule__ElementReferenceExpression__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group__2__Impl_in_rule__ElementReferenceExpression__Group__27619);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3749:1: rule__ElementReferenceExpression__Group__2__Impl : ( ( rule__ElementReferenceExpression__Group_2__0 )? ) ;
    public final void rule__ElementReferenceExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3753:1: ( ( ( rule__ElementReferenceExpression__Group_2__0 )? ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3754:1: ( ( rule__ElementReferenceExpression__Group_2__0 )? )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3754:1: ( ( rule__ElementReferenceExpression__Group_2__0 )? )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3755:1: ( rule__ElementReferenceExpression__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getGroup_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3756:1: ( rule__ElementReferenceExpression__Group_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==50) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3756:2: rule__ElementReferenceExpression__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2__0_in_rule__ElementReferenceExpression__Group__2__Impl7646);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3772:1: rule__ElementReferenceExpression__Group_2__0 : rule__ElementReferenceExpression__Group_2__0__Impl rule__ElementReferenceExpression__Group_2__1 ;
    public final void rule__ElementReferenceExpression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3776:1: ( rule__ElementReferenceExpression__Group_2__0__Impl rule__ElementReferenceExpression__Group_2__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3777:2: rule__ElementReferenceExpression__Group_2__0__Impl rule__ElementReferenceExpression__Group_2__1
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2__0__Impl_in_rule__ElementReferenceExpression__Group_2__07683);
            rule__ElementReferenceExpression__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2__1_in_rule__ElementReferenceExpression__Group_2__07686);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3784:1: rule__ElementReferenceExpression__Group_2__0__Impl : ( ( rule__ElementReferenceExpression__OperationCallAssignment_2_0 ) ) ;
    public final void rule__ElementReferenceExpression__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3788:1: ( ( ( rule__ElementReferenceExpression__OperationCallAssignment_2_0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3789:1: ( ( rule__ElementReferenceExpression__OperationCallAssignment_2_0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3789:1: ( ( rule__ElementReferenceExpression__OperationCallAssignment_2_0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3790:1: ( rule__ElementReferenceExpression__OperationCallAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getOperationCallAssignment_2_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3791:1: ( rule__ElementReferenceExpression__OperationCallAssignment_2_0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3791:2: rule__ElementReferenceExpression__OperationCallAssignment_2_0
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__OperationCallAssignment_2_0_in_rule__ElementReferenceExpression__Group_2__0__Impl7713);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3801:1: rule__ElementReferenceExpression__Group_2__1 : rule__ElementReferenceExpression__Group_2__1__Impl rule__ElementReferenceExpression__Group_2__2 ;
    public final void rule__ElementReferenceExpression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3805:1: ( rule__ElementReferenceExpression__Group_2__1__Impl rule__ElementReferenceExpression__Group_2__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3806:2: rule__ElementReferenceExpression__Group_2__1__Impl rule__ElementReferenceExpression__Group_2__2
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2__1__Impl_in_rule__ElementReferenceExpression__Group_2__17743);
            rule__ElementReferenceExpression__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2__2_in_rule__ElementReferenceExpression__Group_2__17746);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3813:1: rule__ElementReferenceExpression__Group_2__1__Impl : ( ( rule__ElementReferenceExpression__Group_2_1__0 )? ) ;
    public final void rule__ElementReferenceExpression__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3817:1: ( ( ( rule__ElementReferenceExpression__Group_2_1__0 )? ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3818:1: ( ( rule__ElementReferenceExpression__Group_2_1__0 )? )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3818:1: ( ( rule__ElementReferenceExpression__Group_2_1__0 )? )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3819:1: ( rule__ElementReferenceExpression__Group_2_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getGroup_2_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3820:1: ( rule__ElementReferenceExpression__Group_2_1__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=RULE_ID && LA27_0<=RULE_STRING)||(LA27_0>=27 && LA27_0<=28)||LA27_0==32||LA27_0==43||LA27_0==50) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3820:2: rule__ElementReferenceExpression__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2_1__0_in_rule__ElementReferenceExpression__Group_2__1__Impl7773);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3830:1: rule__ElementReferenceExpression__Group_2__2 : rule__ElementReferenceExpression__Group_2__2__Impl ;
    public final void rule__ElementReferenceExpression__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3834:1: ( rule__ElementReferenceExpression__Group_2__2__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3835:2: rule__ElementReferenceExpression__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2__2__Impl_in_rule__ElementReferenceExpression__Group_2__27804);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3841:1: rule__ElementReferenceExpression__Group_2__2__Impl : ( ')' ) ;
    public final void rule__ElementReferenceExpression__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3845:1: ( ( ')' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3846:1: ( ')' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3846:1: ( ')' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3847:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getRightParenthesisKeyword_2_2()); 
            }
            match(input,48,FOLLOW_48_in_rule__ElementReferenceExpression__Group_2__2__Impl7832); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3866:1: rule__ElementReferenceExpression__Group_2_1__0 : rule__ElementReferenceExpression__Group_2_1__0__Impl rule__ElementReferenceExpression__Group_2_1__1 ;
    public final void rule__ElementReferenceExpression__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3870:1: ( rule__ElementReferenceExpression__Group_2_1__0__Impl rule__ElementReferenceExpression__Group_2_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3871:2: rule__ElementReferenceExpression__Group_2_1__0__Impl rule__ElementReferenceExpression__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2_1__0__Impl_in_rule__ElementReferenceExpression__Group_2_1__07869);
            rule__ElementReferenceExpression__Group_2_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2_1__1_in_rule__ElementReferenceExpression__Group_2_1__07872);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3878:1: rule__ElementReferenceExpression__Group_2_1__0__Impl : ( ( rule__ElementReferenceExpression__ArgsAssignment_2_1_0 ) ) ;
    public final void rule__ElementReferenceExpression__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3882:1: ( ( ( rule__ElementReferenceExpression__ArgsAssignment_2_1_0 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3883:1: ( ( rule__ElementReferenceExpression__ArgsAssignment_2_1_0 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3883:1: ( ( rule__ElementReferenceExpression__ArgsAssignment_2_1_0 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3884:1: ( rule__ElementReferenceExpression__ArgsAssignment_2_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getArgsAssignment_2_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3885:1: ( rule__ElementReferenceExpression__ArgsAssignment_2_1_0 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3885:2: rule__ElementReferenceExpression__ArgsAssignment_2_1_0
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__ArgsAssignment_2_1_0_in_rule__ElementReferenceExpression__Group_2_1__0__Impl7899);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3895:1: rule__ElementReferenceExpression__Group_2_1__1 : rule__ElementReferenceExpression__Group_2_1__1__Impl ;
    public final void rule__ElementReferenceExpression__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3899:1: ( rule__ElementReferenceExpression__Group_2_1__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3900:2: rule__ElementReferenceExpression__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2_1__1__Impl_in_rule__ElementReferenceExpression__Group_2_1__17929);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3906:1: rule__ElementReferenceExpression__Group_2_1__1__Impl : ( ( rule__ElementReferenceExpression__Group_2_1_1__0 )* ) ;
    public final void rule__ElementReferenceExpression__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3910:1: ( ( ( rule__ElementReferenceExpression__Group_2_1_1__0 )* ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3911:1: ( ( rule__ElementReferenceExpression__Group_2_1_1__0 )* )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3911:1: ( ( rule__ElementReferenceExpression__Group_2_1_1__0 )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3912:1: ( rule__ElementReferenceExpression__Group_2_1_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getGroup_2_1_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3913:1: ( rule__ElementReferenceExpression__Group_2_1_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==49) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3913:2: rule__ElementReferenceExpression__Group_2_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2_1_1__0_in_rule__ElementReferenceExpression__Group_2_1__1__Impl7956);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3927:1: rule__ElementReferenceExpression__Group_2_1_1__0 : rule__ElementReferenceExpression__Group_2_1_1__0__Impl rule__ElementReferenceExpression__Group_2_1_1__1 ;
    public final void rule__ElementReferenceExpression__Group_2_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3931:1: ( rule__ElementReferenceExpression__Group_2_1_1__0__Impl rule__ElementReferenceExpression__Group_2_1_1__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3932:2: rule__ElementReferenceExpression__Group_2_1_1__0__Impl rule__ElementReferenceExpression__Group_2_1_1__1
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2_1_1__0__Impl_in_rule__ElementReferenceExpression__Group_2_1_1__07991);
            rule__ElementReferenceExpression__Group_2_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2_1_1__1_in_rule__ElementReferenceExpression__Group_2_1_1__07994);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3939:1: rule__ElementReferenceExpression__Group_2_1_1__0__Impl : ( ',' ) ;
    public final void rule__ElementReferenceExpression__Group_2_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3943:1: ( ( ',' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3944:1: ( ',' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3944:1: ( ',' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3945:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getCommaKeyword_2_1_1_0()); 
            }
            match(input,49,FOLLOW_49_in_rule__ElementReferenceExpression__Group_2_1_1__0__Impl8022); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3958:1: rule__ElementReferenceExpression__Group_2_1_1__1 : rule__ElementReferenceExpression__Group_2_1_1__1__Impl ;
    public final void rule__ElementReferenceExpression__Group_2_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3962:1: ( rule__ElementReferenceExpression__Group_2_1_1__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3963:2: rule__ElementReferenceExpression__Group_2_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__Group_2_1_1__1__Impl_in_rule__ElementReferenceExpression__Group_2_1_1__18053);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3969:1: rule__ElementReferenceExpression__Group_2_1_1__1__Impl : ( ( rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1 ) ) ;
    public final void rule__ElementReferenceExpression__Group_2_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3973:1: ( ( ( rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3974:1: ( ( rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3974:1: ( ( rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3975:1: ( rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getArgsAssignment_2_1_1_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3976:1: ( rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3976:2: rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1
            {
            pushFollow(FOLLOW_rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1_in_rule__ElementReferenceExpression__Group_2_1_1__1__Impl8080);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3990:1: rule__ParenthesizedExpression__Group__0 : rule__ParenthesizedExpression__Group__0__Impl rule__ParenthesizedExpression__Group__1 ;
    public final void rule__ParenthesizedExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3994:1: ( rule__ParenthesizedExpression__Group__0__Impl rule__ParenthesizedExpression__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:3995:2: rule__ParenthesizedExpression__Group__0__Impl rule__ParenthesizedExpression__Group__1
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__0__Impl_in_rule__ParenthesizedExpression__Group__08114);
            rule__ParenthesizedExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__1_in_rule__ParenthesizedExpression__Group__08117);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4002:1: rule__ParenthesizedExpression__Group__0__Impl : ( () ) ;
    public final void rule__ParenthesizedExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4006:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4007:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4007:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4008:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParenthesizedExpressionAccess().getParenthesizedExpressionAction_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4009:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4011:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4021:1: rule__ParenthesizedExpression__Group__1 : rule__ParenthesizedExpression__Group__1__Impl rule__ParenthesizedExpression__Group__2 ;
    public final void rule__ParenthesizedExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4025:1: ( rule__ParenthesizedExpression__Group__1__Impl rule__ParenthesizedExpression__Group__2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4026:2: rule__ParenthesizedExpression__Group__1__Impl rule__ParenthesizedExpression__Group__2
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__1__Impl_in_rule__ParenthesizedExpression__Group__18175);
            rule__ParenthesizedExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__2_in_rule__ParenthesizedExpression__Group__18178);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4033:1: rule__ParenthesizedExpression__Group__1__Impl : ( '(' ) ;
    public final void rule__ParenthesizedExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4037:1: ( ( '(' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4038:1: ( '(' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4038:1: ( '(' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4039:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,50,FOLLOW_50_in_rule__ParenthesizedExpression__Group__1__Impl8206); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4052:1: rule__ParenthesizedExpression__Group__2 : rule__ParenthesizedExpression__Group__2__Impl rule__ParenthesizedExpression__Group__3 ;
    public final void rule__ParenthesizedExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4056:1: ( rule__ParenthesizedExpression__Group__2__Impl rule__ParenthesizedExpression__Group__3 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4057:2: rule__ParenthesizedExpression__Group__2__Impl rule__ParenthesizedExpression__Group__3
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__2__Impl_in_rule__ParenthesizedExpression__Group__28237);
            rule__ParenthesizedExpression__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__3_in_rule__ParenthesizedExpression__Group__28240);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4064:1: rule__ParenthesizedExpression__Group__2__Impl : ( ( rule__ParenthesizedExpression__ExpressionAssignment_2 ) ) ;
    public final void rule__ParenthesizedExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4068:1: ( ( ( rule__ParenthesizedExpression__ExpressionAssignment_2 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4069:1: ( ( rule__ParenthesizedExpression__ExpressionAssignment_2 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4069:1: ( ( rule__ParenthesizedExpression__ExpressionAssignment_2 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4070:1: ( rule__ParenthesizedExpression__ExpressionAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParenthesizedExpressionAccess().getExpressionAssignment_2()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4071:1: ( rule__ParenthesizedExpression__ExpressionAssignment_2 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4071:2: rule__ParenthesizedExpression__ExpressionAssignment_2
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__ExpressionAssignment_2_in_rule__ParenthesizedExpression__Group__2__Impl8267);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4081:1: rule__ParenthesizedExpression__Group__3 : rule__ParenthesizedExpression__Group__3__Impl ;
    public final void rule__ParenthesizedExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4085:1: ( rule__ParenthesizedExpression__Group__3__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4086:2: rule__ParenthesizedExpression__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__3__Impl_in_rule__ParenthesizedExpression__Group__38297);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4092:1: rule__ParenthesizedExpression__Group__3__Impl : ( ')' ) ;
    public final void rule__ParenthesizedExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4096:1: ( ( ')' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4097:1: ( ')' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4097:1: ( ')' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4098:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,48,FOLLOW_48_in_rule__ParenthesizedExpression__Group__3__Impl8325); if (state.failed) return ;
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


    // $ANTLR start "rule__BoolLiteral__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4119:1: rule__BoolLiteral__Group__0 : rule__BoolLiteral__Group__0__Impl rule__BoolLiteral__Group__1 ;
    public final void rule__BoolLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4123:1: ( rule__BoolLiteral__Group__0__Impl rule__BoolLiteral__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4124:2: rule__BoolLiteral__Group__0__Impl rule__BoolLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__BoolLiteral__Group__0__Impl_in_rule__BoolLiteral__Group__08364);
            rule__BoolLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BoolLiteral__Group__1_in_rule__BoolLiteral__Group__08367);
            rule__BoolLiteral__Group__1();

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
    // $ANTLR end "rule__BoolLiteral__Group__0"


    // $ANTLR start "rule__BoolLiteral__Group__0__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4131:1: rule__BoolLiteral__Group__0__Impl : ( () ) ;
    public final void rule__BoolLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4135:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4136:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4136:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4137:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBoolLiteralAccess().getBoolLiteralAction_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4138:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4140:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBoolLiteralAccess().getBoolLiteralAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolLiteral__Group__0__Impl"


    // $ANTLR start "rule__BoolLiteral__Group__1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4150:1: rule__BoolLiteral__Group__1 : rule__BoolLiteral__Group__1__Impl ;
    public final void rule__BoolLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4154:1: ( rule__BoolLiteral__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4155:2: rule__BoolLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BoolLiteral__Group__1__Impl_in_rule__BoolLiteral__Group__18425);
            rule__BoolLiteral__Group__1__Impl();

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
    // $ANTLR end "rule__BoolLiteral__Group__1"


    // $ANTLR start "rule__BoolLiteral__Group__1__Impl"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4161:1: rule__BoolLiteral__Group__1__Impl : ( ( rule__BoolLiteral__ValueAssignment_1 ) ) ;
    public final void rule__BoolLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4165:1: ( ( ( rule__BoolLiteral__ValueAssignment_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4166:1: ( ( rule__BoolLiteral__ValueAssignment_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4166:1: ( ( rule__BoolLiteral__ValueAssignment_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4167:1: ( rule__BoolLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBoolLiteralAccess().getValueAssignment_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4168:1: ( rule__BoolLiteral__ValueAssignment_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4168:2: rule__BoolLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__BoolLiteral__ValueAssignment_1_in_rule__BoolLiteral__Group__1__Impl8452);
            rule__BoolLiteral__ValueAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBoolLiteralAccess().getValueAssignment_1()); 
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
    // $ANTLR end "rule__BoolLiteral__Group__1__Impl"


    // $ANTLR start "rule__IntLiteral__Group__0"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4182:1: rule__IntLiteral__Group__0 : rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 ;
    public final void rule__IntLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4186:1: ( rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4187:2: rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__08486);
            rule__IntLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__08489);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4194:1: rule__IntLiteral__Group__0__Impl : ( () ) ;
    public final void rule__IntLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4198:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4199:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4199:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4200:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4201:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4203:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4213:1: rule__IntLiteral__Group__1 : rule__IntLiteral__Group__1__Impl ;
    public final void rule__IntLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4217:1: ( rule__IntLiteral__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4218:2: rule__IntLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__18547);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4224:1: rule__IntLiteral__Group__1__Impl : ( ( rule__IntLiteral__ValueAssignment_1 ) ) ;
    public final void rule__IntLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4228:1: ( ( ( rule__IntLiteral__ValueAssignment_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4229:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4229:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4230:1: ( rule__IntLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4231:1: ( rule__IntLiteral__ValueAssignment_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4231:2: rule__IntLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl8574);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4245:1: rule__RealLiteral__Group__0 : rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 ;
    public final void rule__RealLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4249:1: ( rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4250:2: rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__08608);
            rule__RealLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__08611);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4257:1: rule__RealLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RealLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4261:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4262:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4262:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4263:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4264:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4266:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4276:1: rule__RealLiteral__Group__1 : rule__RealLiteral__Group__1__Impl ;
    public final void rule__RealLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4280:1: ( rule__RealLiteral__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4281:2: rule__RealLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__18669);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4287:1: rule__RealLiteral__Group__1__Impl : ( ( rule__RealLiteral__ValueAssignment_1 ) ) ;
    public final void rule__RealLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4291:1: ( ( ( rule__RealLiteral__ValueAssignment_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4292:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4292:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4293:1: ( rule__RealLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4294:1: ( rule__RealLiteral__ValueAssignment_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4294:2: rule__RealLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl8696);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4308:1: rule__HexLiteral__Group__0 : rule__HexLiteral__Group__0__Impl rule__HexLiteral__Group__1 ;
    public final void rule__HexLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4312:1: ( rule__HexLiteral__Group__0__Impl rule__HexLiteral__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4313:2: rule__HexLiteral__Group__0__Impl rule__HexLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__HexLiteral__Group__0__Impl_in_rule__HexLiteral__Group__08730);
            rule__HexLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__HexLiteral__Group__1_in_rule__HexLiteral__Group__08733);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4320:1: rule__HexLiteral__Group__0__Impl : ( () ) ;
    public final void rule__HexLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4324:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4325:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4325:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4326:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHexLiteralAccess().getHexLiteralAction_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4327:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4329:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4339:1: rule__HexLiteral__Group__1 : rule__HexLiteral__Group__1__Impl ;
    public final void rule__HexLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4343:1: ( rule__HexLiteral__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4344:2: rule__HexLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__HexLiteral__Group__1__Impl_in_rule__HexLiteral__Group__18791);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4350:1: rule__HexLiteral__Group__1__Impl : ( ( rule__HexLiteral__ValueAssignment_1 ) ) ;
    public final void rule__HexLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4354:1: ( ( ( rule__HexLiteral__ValueAssignment_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4355:1: ( ( rule__HexLiteral__ValueAssignment_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4355:1: ( ( rule__HexLiteral__ValueAssignment_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4356:1: ( rule__HexLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHexLiteralAccess().getValueAssignment_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4357:1: ( rule__HexLiteral__ValueAssignment_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4357:2: rule__HexLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__HexLiteral__ValueAssignment_1_in_rule__HexLiteral__Group__1__Impl8818);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4371:1: rule__StringLiteral__Group__0 : rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 ;
    public final void rule__StringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4375:1: ( rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4376:2: rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__08852);
            rule__StringLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__08855);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4383:1: rule__StringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__StringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4387:1: ( ( () ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4388:1: ( () )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4388:1: ( () )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4389:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4390:1: ()
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4392:1: 
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4402:1: rule__StringLiteral__Group__1 : rule__StringLiteral__Group__1__Impl ;
    public final void rule__StringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4406:1: ( rule__StringLiteral__Group__1__Impl )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4407:2: rule__StringLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__18913);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4413:1: rule__StringLiteral__Group__1__Impl : ( ( rule__StringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__StringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4417:1: ( ( ( rule__StringLiteral__ValueAssignment_1 ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4418:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4418:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4419:1: ( rule__StringLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4420:1: ( rule__StringLiteral__ValueAssignment_1 )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4420:2: rule__StringLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl8940);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4435:1: rule__AssignmentExpression__OperatorAssignment_1_1 : ( ruleAssignmentOperator ) ;
    public final void rule__AssignmentExpression__OperatorAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4439:1: ( ( ruleAssignmentOperator ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4440:1: ( ruleAssignmentOperator )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4440:1: ( ruleAssignmentOperator )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4441:1: ruleAssignmentOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentExpressionAccess().getOperatorAssignmentOperatorEnumRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleAssignmentOperator_in_rule__AssignmentExpression__OperatorAssignment_1_18979);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4450:1: rule__AssignmentExpression__ExpressionAssignment_1_2 : ( ruleConditionalExpression ) ;
    public final void rule__AssignmentExpression__ExpressionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4454:1: ( ( ruleConditionalExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4455:1: ( ruleConditionalExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4455:1: ( ruleConditionalExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4456:1: ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentExpressionAccess().getExpressionConditionalExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleConditionalExpression_in_rule__AssignmentExpression__ExpressionAssignment_1_29010);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4465:1: rule__ConditionalExpression__TrueCaseAssignment_1_2 : ( ruleLogicalOrExpression ) ;
    public final void rule__ConditionalExpression__TrueCaseAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4469:1: ( ( ruleLogicalOrExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4470:1: ( ruleLogicalOrExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4470:1: ( ruleLogicalOrExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4471:1: ruleLogicalOrExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConditionalExpressionAccess().getTrueCaseLogicalOrExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_rule__ConditionalExpression__TrueCaseAssignment_1_29041);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4480:1: rule__ConditionalExpression__FalseCaseAssignment_1_4 : ( ruleLogicalOrExpression ) ;
    public final void rule__ConditionalExpression__FalseCaseAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4484:1: ( ( ruleLogicalOrExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4485:1: ( ruleLogicalOrExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4485:1: ( ruleLogicalOrExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4486:1: ruleLogicalOrExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConditionalExpressionAccess().getFalseCaseLogicalOrExpressionParserRuleCall_1_4_0()); 
            }
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_rule__ConditionalExpression__FalseCaseAssignment_1_49072);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4495:1: rule__LogicalOrExpression__RightOperandAssignment_1_2 : ( ruleLogicalAndExpression ) ;
    public final void rule__LogicalOrExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4499:1: ( ( ruleLogicalAndExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4500:1: ( ruleLogicalAndExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4500:1: ( ruleLogicalAndExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4501:1: ruleLogicalAndExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalOrExpressionAccess().getRightOperandLogicalAndExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_rule__LogicalOrExpression__RightOperandAssignment_1_29103);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4510:1: rule__LogicalAndExpression__RightOperandAssignment_1_2 : ( ruleLogicalNotExpression ) ;
    public final void rule__LogicalAndExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4514:1: ( ( ruleLogicalNotExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4515:1: ( ruleLogicalNotExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4515:1: ( ruleLogicalNotExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4516:1: ruleLogicalNotExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalAndExpressionAccess().getRightOperandLogicalNotExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_rule__LogicalAndExpression__RightOperandAssignment_1_29134);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4525:1: rule__LogicalNotExpression__OperandAssignment_1_2 : ( ruleBitwiseXorExpression ) ;
    public final void rule__LogicalNotExpression__OperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4529:1: ( ( ruleBitwiseXorExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4530:1: ( ruleBitwiseXorExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4530:1: ( ruleBitwiseXorExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4531:1: ruleBitwiseXorExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalNotExpressionAccess().getOperandBitwiseXorExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleBitwiseXorExpression_in_rule__LogicalNotExpression__OperandAssignment_1_29165);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4540:1: rule__BitwiseXorExpression__RightOperandAssignment_1_2 : ( ruleBitwiseOrExpression ) ;
    public final void rule__BitwiseXorExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4544:1: ( ( ruleBitwiseOrExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4545:1: ( ruleBitwiseOrExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4545:1: ( ruleBitwiseOrExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4546:1: ruleBitwiseOrExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseXorExpressionAccess().getRightOperandBitwiseOrExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleBitwiseOrExpression_in_rule__BitwiseXorExpression__RightOperandAssignment_1_29196);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4555:1: rule__BitwiseOrExpression__RightOperandAssignment_1_2 : ( ruleBitwiseAndExpression ) ;
    public final void rule__BitwiseOrExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4559:1: ( ( ruleBitwiseAndExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4560:1: ( ruleBitwiseAndExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4560:1: ( ruleBitwiseAndExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4561:1: ruleBitwiseAndExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseOrExpressionAccess().getRightOperandBitwiseAndExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleBitwiseAndExpression_in_rule__BitwiseOrExpression__RightOperandAssignment_1_29227);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4570:1: rule__BitwiseAndExpression__RightOperandAssignment_1_2 : ( ruleLogicalRelationExpression ) ;
    public final void rule__BitwiseAndExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4574:1: ( ( ruleLogicalRelationExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4575:1: ( ruleLogicalRelationExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4575:1: ( ruleLogicalRelationExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4576:1: ruleLogicalRelationExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitwiseAndExpressionAccess().getRightOperandLogicalRelationExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleLogicalRelationExpression_in_rule__BitwiseAndExpression__RightOperandAssignment_1_29258);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4585:1: rule__LogicalRelationExpression__OperatorAssignment_1_1 : ( ruleRelationalOperator ) ;
    public final void rule__LogicalRelationExpression__OperatorAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4589:1: ( ( ruleRelationalOperator ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4590:1: ( ruleRelationalOperator )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4590:1: ( ruleRelationalOperator )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4591:1: ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalRelationExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_rule__LogicalRelationExpression__OperatorAssignment_1_19289);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4600:1: rule__LogicalRelationExpression__RightOperandAssignment_1_2 : ( ruleShiftExpression ) ;
    public final void rule__LogicalRelationExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4604:1: ( ( ruleShiftExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4605:1: ( ruleShiftExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4605:1: ( ruleShiftExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4606:1: ruleShiftExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicalRelationExpressionAccess().getRightOperandShiftExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleShiftExpression_in_rule__LogicalRelationExpression__RightOperandAssignment_1_29320);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4615:1: rule__ShiftExpression__OperatorAssignment_1_1 : ( ruleShiftOperator ) ;
    public final void rule__ShiftExpression__OperatorAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4619:1: ( ( ruleShiftOperator ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4620:1: ( ruleShiftOperator )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4620:1: ( ruleShiftOperator )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4621:1: ruleShiftOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExpressionAccess().getOperatorShiftOperatorEnumRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleShiftOperator_in_rule__ShiftExpression__OperatorAssignment_1_19351);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4630:1: rule__ShiftExpression__RightOperandAssignment_1_2 : ( ruleNumericalAddSubtractExpression ) ;
    public final void rule__ShiftExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4634:1: ( ( ruleNumericalAddSubtractExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4635:1: ( ruleNumericalAddSubtractExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4635:1: ( ruleNumericalAddSubtractExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4636:1: ruleNumericalAddSubtractExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExpressionAccess().getRightOperandNumericalAddSubtractExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_rule__ShiftExpression__RightOperandAssignment_1_29382);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4645:1: rule__NumericalAddSubtractExpression__OperatorAssignment_1_1 : ( ruleAdditiveOperator ) ;
    public final void rule__NumericalAddSubtractExpression__OperatorAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4649:1: ( ( ruleAdditiveOperator ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4650:1: ( ruleAdditiveOperator )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4650:1: ( ruleAdditiveOperator )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4651:1: ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalAddSubtractExpressionAccess().getOperatorAdditiveOperatorEnumRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_rule__NumericalAddSubtractExpression__OperatorAssignment_1_19413);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4660:1: rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2 : ( ruleNumericalMultiplyDivideExpression ) ;
    public final void rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4664:1: ( ( ruleNumericalMultiplyDivideExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4665:1: ( ruleNumericalMultiplyDivideExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4665:1: ( ruleNumericalMultiplyDivideExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4666:1: ruleNumericalMultiplyDivideExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalAddSubtractExpressionAccess().getRightOperandNumericalMultiplyDivideExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_rule__NumericalAddSubtractExpression__RightOperandAssignment_1_29444);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4675:1: rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1 : ( ruleMultiplicativeOperator ) ;
    public final void rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4679:1: ( ( ruleMultiplicativeOperator ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4680:1: ( ruleMultiplicativeOperator )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4680:1: ( ruleMultiplicativeOperator )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4681:1: ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getOperatorMultiplicativeOperatorEnumRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_19475);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4690:1: rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2 : ( ruleNumericalUnaryExpression ) ;
    public final void rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4694:1: ( ( ruleNumericalUnaryExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4695:1: ( ruleNumericalUnaryExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4695:1: ( ruleNumericalUnaryExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4696:1: ruleNumericalUnaryExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getRightOperandNumericalUnaryExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_29506);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4705:1: rule__NumericalUnaryExpression__OperatorAssignment_1_1 : ( ruleUnaryOperator ) ;
    public final void rule__NumericalUnaryExpression__OperatorAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4709:1: ( ( ruleUnaryOperator ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4710:1: ( ruleUnaryOperator )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4710:1: ( ruleUnaryOperator )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4711:1: ruleUnaryOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalUnaryExpressionAccess().getOperatorUnaryOperatorEnumRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleUnaryOperator_in_rule__NumericalUnaryExpression__OperatorAssignment_1_19537);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4720:1: rule__NumericalUnaryExpression__OperandAssignment_1_2 : ( rulePrimaryExpression ) ;
    public final void rule__NumericalUnaryExpression__OperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4724:1: ( ( rulePrimaryExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4725:1: ( rulePrimaryExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4725:1: ( rulePrimaryExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4726:1: rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumericalUnaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_rule__NumericalUnaryExpression__OperandAssignment_1_29568);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4735:1: rule__PrimitiveValueExpression__ValueAssignment_1 : ( ruleLiteral ) ;
    public final void rule__PrimitiveValueExpression__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4739:1: ( ( ruleLiteral ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4740:1: ( ruleLiteral )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4740:1: ( ruleLiteral )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4741:1: ruleLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveValueExpressionAccess().getValueLiteralParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleLiteral_in_rule__PrimitiveValueExpression__ValueAssignment_19599);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4750:1: rule__FeatureCall__FeatureAssignment_1_2 : ( ( RULE_ID ) ) ;
    public final void rule__FeatureCall__FeatureAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4754:1: ( ( ( RULE_ID ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4755:1: ( ( RULE_ID ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4755:1: ( ( RULE_ID ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4756:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getFeatureEObjectCrossReference_1_2_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4757:1: ( RULE_ID )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4758:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getFeatureEObjectIDTerminalRuleCall_1_2_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FeatureCall__FeatureAssignment_1_29634); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4769:1: rule__FeatureCall__OperationCallAssignment_1_3_0 : ( ( '(' ) ) ;
    public final void rule__FeatureCall__OperationCallAssignment_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4773:1: ( ( ( '(' ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4774:1: ( ( '(' ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4774:1: ( ( '(' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4775:1: ( '(' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getOperationCallLeftParenthesisKeyword_1_3_0_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4776:1: ( '(' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4777:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getOperationCallLeftParenthesisKeyword_1_3_0_0()); 
            }
            match(input,50,FOLLOW_50_in_rule__FeatureCall__OperationCallAssignment_1_3_09674); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4792:1: rule__FeatureCall__ArgsAssignment_1_3_1_0 : ( ruleExpression ) ;
    public final void rule__FeatureCall__ArgsAssignment_1_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4796:1: ( ( ruleExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4797:1: ( ruleExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4797:1: ( ruleExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4798:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getArgsExpressionParserRuleCall_1_3_1_0_0()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__FeatureCall__ArgsAssignment_1_3_1_09713);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4807:1: rule__FeatureCall__ArgsAssignment_1_3_1_1_1 : ( ruleExpression ) ;
    public final void rule__FeatureCall__ArgsAssignment_1_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4811:1: ( ( ruleExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4812:1: ( ruleExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4812:1: ( ruleExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4813:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallAccess().getArgsExpressionParserRuleCall_1_3_1_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__FeatureCall__ArgsAssignment_1_3_1_1_19744);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4822:1: rule__ElementReferenceExpression__ReferenceAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ElementReferenceExpression__ReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4826:1: ( ( ( RULE_ID ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4827:1: ( ( RULE_ID ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4827:1: ( ( RULE_ID ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4828:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getReferenceEObjectCrossReference_1_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4829:1: ( RULE_ID )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4830:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getReferenceEObjectIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ElementReferenceExpression__ReferenceAssignment_19779); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4841:1: rule__ElementReferenceExpression__OperationCallAssignment_2_0 : ( ( '(' ) ) ;
    public final void rule__ElementReferenceExpression__OperationCallAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4845:1: ( ( ( '(' ) ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4846:1: ( ( '(' ) )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4846:1: ( ( '(' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4847:1: ( '(' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getOperationCallLeftParenthesisKeyword_2_0_0()); 
            }
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4848:1: ( '(' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4849:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getOperationCallLeftParenthesisKeyword_2_0_0()); 
            }
            match(input,50,FOLLOW_50_in_rule__ElementReferenceExpression__OperationCallAssignment_2_09819); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4864:1: rule__ElementReferenceExpression__ArgsAssignment_2_1_0 : ( ruleExpression ) ;
    public final void rule__ElementReferenceExpression__ArgsAssignment_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4868:1: ( ( ruleExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4869:1: ( ruleExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4869:1: ( ruleExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4870:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getArgsExpressionParserRuleCall_2_1_0_0()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__ElementReferenceExpression__ArgsAssignment_2_1_09858);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4879:1: rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1 : ( ruleExpression ) ;
    public final void rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4883:1: ( ( ruleExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4884:1: ( ruleExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4884:1: ( ruleExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4885:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementReferenceExpressionAccess().getArgsExpressionParserRuleCall_2_1_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__ElementReferenceExpression__ArgsAssignment_2_1_1_19889);
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4894:1: rule__ParenthesizedExpression__ExpressionAssignment_2 : ( ruleExpression ) ;
    public final void rule__ParenthesizedExpression__ExpressionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4898:1: ( ( ruleExpression ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4899:1: ( ruleExpression )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4899:1: ( ruleExpression )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4900:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParenthesizedExpressionAccess().getExpressionExpressionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__ParenthesizedExpression__ExpressionAssignment_29920);
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


    // $ANTLR start "rule__BoolLiteral__ValueAssignment_1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4909:1: rule__BoolLiteral__ValueAssignment_1 : ( RULE_BOOL ) ;
    public final void rule__BoolLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4913:1: ( ( RULE_BOOL ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4914:1: ( RULE_BOOL )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4914:1: ( RULE_BOOL )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4915:1: RULE_BOOL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBoolLiteralAccess().getValueBOOLTerminalRuleCall_1_0()); 
            }
            match(input,RULE_BOOL,FOLLOW_RULE_BOOL_in_rule__BoolLiteral__ValueAssignment_19951); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBoolLiteralAccess().getValueBOOLTerminalRuleCall_1_0()); 
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
    // $ANTLR end "rule__BoolLiteral__ValueAssignment_1"


    // $ANTLR start "rule__IntLiteral__ValueAssignment_1"
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4924:1: rule__IntLiteral__ValueAssignment_1 : ( RULE_INT ) ;
    public final void rule__IntLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4928:1: ( ( RULE_INT ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4929:1: ( RULE_INT )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4929:1: ( RULE_INT )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4930:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getValueINTTerminalRuleCall_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__IntLiteral__ValueAssignment_19982); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4939:1: rule__RealLiteral__ValueAssignment_1 : ( RULE_FLOAT ) ;
    public final void rule__RealLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4943:1: ( ( RULE_FLOAT ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4944:1: ( RULE_FLOAT )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4944:1: ( RULE_FLOAT )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4945:1: RULE_FLOAT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getValueFLOATTerminalRuleCall_1_0()); 
            }
            match(input,RULE_FLOAT,FOLLOW_RULE_FLOAT_in_rule__RealLiteral__ValueAssignment_110013); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4954:1: rule__HexLiteral__ValueAssignment_1 : ( RULE_HEX ) ;
    public final void rule__HexLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4958:1: ( ( RULE_HEX ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4959:1: ( RULE_HEX )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4959:1: ( RULE_HEX )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4960:1: RULE_HEX
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHexLiteralAccess().getValueHEXTerminalRuleCall_1_0()); 
            }
            match(input,RULE_HEX,FOLLOW_RULE_HEX_in_rule__HexLiteral__ValueAssignment_110044); if (state.failed) return ;
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
    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4969:1: rule__StringLiteral__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4973:1: ( ( RULE_STRING ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4974:1: ( RULE_STRING )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4974:1: ( RULE_STRING )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4975:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_110075); if (state.failed) return ;
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
    public static final BitSet FOLLOW_ruleBoolLiteral_in_entryRuleBoolLiteral1266 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoolLiteral1273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BoolLiteral__Group__0_in_ruleBoolLiteral1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral1326 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral1333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral1359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral1386 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral1393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral1419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexLiteral_in_entryRuleHexLiteral1446 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexLiteral1453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HexLiteral__Group__0_in_ruleHexLiteral1479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral1506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral1513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral1539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentOperator__Alternatives_in_ruleAssignmentOperator1576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftOperator__Alternatives_in_ruleShiftOperator1612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveOperator__Alternatives_in_ruleAdditiveOperator1648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeOperator__Alternatives_in_ruleMultiplicativeOperator1684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryOperator__Alternatives_in_ruleUnaryOperator1720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalOperator__Alternatives_in_ruleRelationalOperator1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseXorExpression_in_rule__LogicalNotExpression__Alternatives1791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalNotExpression__Group_1__0_in_rule__LogicalNotExpression__Alternatives1808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__NumericalUnaryExpression__Alternatives1841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalUnaryExpression__Group_1__0_in_rule__NumericalUnaryExpression__Alternatives1858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveValueExpression_in_rule__PrimaryExpression__Alternatives1891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_rule__PrimaryExpression__Alternatives1908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_rule__PrimaryExpression__Alternatives1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolLiteral_in_rule__Literal__Alternatives1957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_rule__Literal__Alternatives1974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexLiteral_in_rule__Literal__Alternatives1991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_rule__Literal__Alternatives2008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives2025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__AssignmentOperator__Alternatives2058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__AssignmentOperator__Alternatives2079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__AssignmentOperator__Alternatives2100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__AssignmentOperator__Alternatives2121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__AssignmentOperator__Alternatives2142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__AssignmentOperator__Alternatives2163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__AssignmentOperator__Alternatives2184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__AssignmentOperator__Alternatives2205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__AssignmentOperator__Alternatives2226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__AssignmentOperator__Alternatives2247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__AssignmentOperator__Alternatives2268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ShiftOperator__Alternatives2304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ShiftOperator__Alternatives2325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__AdditiveOperator__Alternatives2361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__AdditiveOperator__Alternatives2382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__MultiplicativeOperator__Alternatives2418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__MultiplicativeOperator__Alternatives2439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__MultiplicativeOperator__Alternatives2460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__UnaryOperator__Alternatives2496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__UnaryOperator__Alternatives2517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__UnaryOperator__Alternatives2538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__RelationalOperator__Alternatives2574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__RelationalOperator__Alternatives2595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__RelationalOperator__Alternatives2616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__RelationalOperator__Alternatives2637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__RelationalOperator__Alternatives2658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__RelationalOperator__Alternatives2679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__Group__0__Impl_in_rule__AssignmentExpression__Group__02712 = new BitSet(new long[]{0x0000000001FFC000L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__Group__1_in_rule__AssignmentExpression__Group__02715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_rule__AssignmentExpression__Group__0__Impl2742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__Group__1__Impl_in_rule__AssignmentExpression__Group__12771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__Group_1__0_in_rule__AssignmentExpression__Group__1__Impl2798 = new BitSet(new long[]{0x0000000001FFC002L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__Group_1__0__Impl_in_rule__AssignmentExpression__Group_1__02833 = new BitSet(new long[]{0x0000000001FFC000L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__Group_1__1_in_rule__AssignmentExpression__Group_1__02836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__Group_1__1__Impl_in_rule__AssignmentExpression__Group_1__12894 = new BitSet(new long[]{0x00040801180003F0L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__Group_1__2_in_rule__AssignmentExpression__Group_1__12897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__OperatorAssignment_1_1_in_rule__AssignmentExpression__Group_1__1__Impl2924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__Group_1__2__Impl_in_rule__AssignmentExpression__Group_1__22954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentExpression__ExpressionAssignment_1_2_in_rule__AssignmentExpression__Group_1__2__Impl2981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group__0__Impl_in_rule__ConditionalExpression__Group__03017 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group__1_in_rule__ConditionalExpression__Group__03020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_rule__ConditionalExpression__Group__0__Impl3047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group__1__Impl_in_rule__ConditionalExpression__Group__13076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__0_in_rule__ConditionalExpression__Group__1__Impl3103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__0__Impl_in_rule__ConditionalExpression__Group_1__03138 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__1_in_rule__ConditionalExpression__Group_1__03141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__1__Impl_in_rule__ConditionalExpression__Group_1__13199 = new BitSet(new long[]{0x00040801180003F0L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__2_in_rule__ConditionalExpression__Group_1__13202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ConditionalExpression__Group_1__1__Impl3230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__2__Impl_in_rule__ConditionalExpression__Group_1__23261 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__3_in_rule__ConditionalExpression__Group_1__23264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__TrueCaseAssignment_1_2_in_rule__ConditionalExpression__Group_1__2__Impl3291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__3__Impl_in_rule__ConditionalExpression__Group_1__33321 = new BitSet(new long[]{0x00040801180003F0L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__4_in_rule__ConditionalExpression__Group_1__33324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ConditionalExpression__Group_1__3__Impl3352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__4__Impl_in_rule__ConditionalExpression__Group_1__43383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__FalseCaseAssignment_1_4_in_rule__ConditionalExpression__Group_1__4__Impl3410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__Group__0__Impl_in_rule__LogicalOrExpression__Group__03450 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__Group__1_in_rule__LogicalOrExpression__Group__03453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_rule__LogicalOrExpression__Group__0__Impl3480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__Group__1__Impl_in_rule__LogicalOrExpression__Group__13509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__Group_1__0_in_rule__LogicalOrExpression__Group__1__Impl3536 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__Group_1__0__Impl_in_rule__LogicalOrExpression__Group_1__03571 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__Group_1__1_in_rule__LogicalOrExpression__Group_1__03574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__Group_1__1__Impl_in_rule__LogicalOrExpression__Group_1__13632 = new BitSet(new long[]{0x00040801180003F0L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__Group_1__2_in_rule__LogicalOrExpression__Group_1__13635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__LogicalOrExpression__Group_1__1__Impl3663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__Group_1__2__Impl_in_rule__LogicalOrExpression__Group_1__23694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalOrExpression__RightOperandAssignment_1_2_in_rule__LogicalOrExpression__Group_1__2__Impl3721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__Group__0__Impl_in_rule__LogicalAndExpression__Group__03757 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__Group__1_in_rule__LogicalAndExpression__Group__03760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_rule__LogicalAndExpression__Group__0__Impl3787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__Group__1__Impl_in_rule__LogicalAndExpression__Group__13816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__Group_1__0_in_rule__LogicalAndExpression__Group__1__Impl3843 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__Group_1__0__Impl_in_rule__LogicalAndExpression__Group_1__03878 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__Group_1__1_in_rule__LogicalAndExpression__Group_1__03881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__Group_1__1__Impl_in_rule__LogicalAndExpression__Group_1__13939 = new BitSet(new long[]{0x00040801180003F0L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__Group_1__2_in_rule__LogicalAndExpression__Group_1__13942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__LogicalAndExpression__Group_1__1__Impl3970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__Group_1__2__Impl_in_rule__LogicalAndExpression__Group_1__24001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalAndExpression__RightOperandAssignment_1_2_in_rule__LogicalAndExpression__Group_1__2__Impl4028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalNotExpression__Group_1__0__Impl_in_rule__LogicalNotExpression__Group_1__04064 = new BitSet(new long[]{0x00040801180003F0L});
    public static final BitSet FOLLOW_rule__LogicalNotExpression__Group_1__1_in_rule__LogicalNotExpression__Group_1__04067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalNotExpression__Group_1__1__Impl_in_rule__LogicalNotExpression__Group_1__14125 = new BitSet(new long[]{0x00040001180003F0L});
    public static final BitSet FOLLOW_rule__LogicalNotExpression__Group_1__2_in_rule__LogicalNotExpression__Group_1__14128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__LogicalNotExpression__Group_1__1__Impl4156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalNotExpression__Group_1__2__Impl_in_rule__LogicalNotExpression__Group_1__24187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalNotExpression__OperandAssignment_1_2_in_rule__LogicalNotExpression__Group_1__2__Impl4214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__Group__0__Impl_in_rule__BitwiseXorExpression__Group__04250 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__Group__1_in_rule__BitwiseXorExpression__Group__04253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpression_in_rule__BitwiseXorExpression__Group__0__Impl4280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__Group__1__Impl_in_rule__BitwiseXorExpression__Group__14309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__Group_1__0_in_rule__BitwiseXorExpression__Group__1__Impl4336 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__Group_1__0__Impl_in_rule__BitwiseXorExpression__Group_1__04371 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__Group_1__1_in_rule__BitwiseXorExpression__Group_1__04374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__Group_1__1__Impl_in_rule__BitwiseXorExpression__Group_1__14432 = new BitSet(new long[]{0x00040001180003F0L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__Group_1__2_in_rule__BitwiseXorExpression__Group_1__14435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__BitwiseXorExpression__Group_1__1__Impl4463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__Group_1__2__Impl_in_rule__BitwiseXorExpression__Group_1__24494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseXorExpression__RightOperandAssignment_1_2_in_rule__BitwiseXorExpression__Group_1__2__Impl4521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__Group__0__Impl_in_rule__BitwiseOrExpression__Group__04557 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__Group__1_in_rule__BitwiseOrExpression__Group__04560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpression_in_rule__BitwiseOrExpression__Group__0__Impl4587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__Group__1__Impl_in_rule__BitwiseOrExpression__Group__14616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__Group_1__0_in_rule__BitwiseOrExpression__Group__1__Impl4643 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__Group_1__0__Impl_in_rule__BitwiseOrExpression__Group_1__04678 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__Group_1__1_in_rule__BitwiseOrExpression__Group_1__04681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__Group_1__1__Impl_in_rule__BitwiseOrExpression__Group_1__14739 = new BitSet(new long[]{0x00040001180003F0L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__Group_1__2_in_rule__BitwiseOrExpression__Group_1__14742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__BitwiseOrExpression__Group_1__1__Impl4770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__Group_1__2__Impl_in_rule__BitwiseOrExpression__Group_1__24801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseOrExpression__RightOperandAssignment_1_2_in_rule__BitwiseOrExpression__Group_1__2__Impl4828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__Group__0__Impl_in_rule__BitwiseAndExpression__Group__04864 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__Group__1_in_rule__BitwiseAndExpression__Group__04867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_rule__BitwiseAndExpression__Group__0__Impl4894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__Group__1__Impl_in_rule__BitwiseAndExpression__Group__14923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__Group_1__0_in_rule__BitwiseAndExpression__Group__1__Impl4950 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__Group_1__0__Impl_in_rule__BitwiseAndExpression__Group_1__04985 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__Group_1__1_in_rule__BitwiseAndExpression__Group_1__04988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__Group_1__1__Impl_in_rule__BitwiseAndExpression__Group_1__15046 = new BitSet(new long[]{0x00040001180003F0L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__Group_1__2_in_rule__BitwiseAndExpression__Group_1__15049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__BitwiseAndExpression__Group_1__1__Impl5077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__Group_1__2__Impl_in_rule__BitwiseAndExpression__Group_1__25108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitwiseAndExpression__RightOperandAssignment_1_2_in_rule__BitwiseAndExpression__Group_1__2__Impl5135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__Group__0__Impl_in_rule__LogicalRelationExpression__Group__05171 = new BitSet(new long[]{0x0000007E00000000L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__Group__1_in_rule__LogicalRelationExpression__Group__05174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_rule__LogicalRelationExpression__Group__0__Impl5201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__Group__1__Impl_in_rule__LogicalRelationExpression__Group__15230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__Group_1__0_in_rule__LogicalRelationExpression__Group__1__Impl5257 = new BitSet(new long[]{0x0000007E00000002L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__Group_1__0__Impl_in_rule__LogicalRelationExpression__Group_1__05292 = new BitSet(new long[]{0x0000007E00000000L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__Group_1__1_in_rule__LogicalRelationExpression__Group_1__05295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__Group_1__1__Impl_in_rule__LogicalRelationExpression__Group_1__15353 = new BitSet(new long[]{0x00040001180003F0L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__Group_1__2_in_rule__LogicalRelationExpression__Group_1__15356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__OperatorAssignment_1_1_in_rule__LogicalRelationExpression__Group_1__1__Impl5383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__Group_1__2__Impl_in_rule__LogicalRelationExpression__Group_1__25413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalRelationExpression__RightOperandAssignment_1_2_in_rule__LogicalRelationExpression__Group_1__2__Impl5440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpression__Group__0__Impl_in_rule__ShiftExpression__Group__05476 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_rule__ShiftExpression__Group__1_in_rule__ShiftExpression__Group__05479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_rule__ShiftExpression__Group__0__Impl5506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpression__Group__1__Impl_in_rule__ShiftExpression__Group__15535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpression__Group_1__0_in_rule__ShiftExpression__Group__1__Impl5562 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_rule__ShiftExpression__Group_1__0__Impl_in_rule__ShiftExpression__Group_1__05597 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_rule__ShiftExpression__Group_1__1_in_rule__ShiftExpression__Group_1__05600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpression__Group_1__1__Impl_in_rule__ShiftExpression__Group_1__15658 = new BitSet(new long[]{0x00040001180003F0L});
    public static final BitSet FOLLOW_rule__ShiftExpression__Group_1__2_in_rule__ShiftExpression__Group_1__15661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpression__OperatorAssignment_1_1_in_rule__ShiftExpression__Group_1__1__Impl5688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpression__Group_1__2__Impl_in_rule__ShiftExpression__Group_1__25718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpression__RightOperandAssignment_1_2_in_rule__ShiftExpression__Group_1__2__Impl5745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__Group__0__Impl_in_rule__NumericalAddSubtractExpression__Group__05781 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__Group__1_in_rule__NumericalAddSubtractExpression__Group__05784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_rule__NumericalAddSubtractExpression__Group__0__Impl5811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__Group__1__Impl_in_rule__NumericalAddSubtractExpression__Group__15840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__Group_1__0_in_rule__NumericalAddSubtractExpression__Group__1__Impl5867 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__Group_1__0__Impl_in_rule__NumericalAddSubtractExpression__Group_1__05902 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__Group_1__1_in_rule__NumericalAddSubtractExpression__Group_1__05905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__Group_1__1__Impl_in_rule__NumericalAddSubtractExpression__Group_1__15963 = new BitSet(new long[]{0x00040001180003F0L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__Group_1__2_in_rule__NumericalAddSubtractExpression__Group_1__15966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__OperatorAssignment_1_1_in_rule__NumericalAddSubtractExpression__Group_1__1__Impl5993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__Group_1__2__Impl_in_rule__NumericalAddSubtractExpression__Group_1__26023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalAddSubtractExpression__RightOperandAssignment_1_2_in_rule__NumericalAddSubtractExpression__Group_1__2__Impl6050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__Group__0__Impl_in_rule__NumericalMultiplyDivideExpression__Group__06086 = new BitSet(new long[]{0x00000000E0000000L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__Group__1_in_rule__NumericalMultiplyDivideExpression__Group__06089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_rule__NumericalMultiplyDivideExpression__Group__0__Impl6116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__Group__1__Impl_in_rule__NumericalMultiplyDivideExpression__Group__16145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__0_in_rule__NumericalMultiplyDivideExpression__Group__1__Impl6172 = new BitSet(new long[]{0x00000000E0000002L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__0__Impl_in_rule__NumericalMultiplyDivideExpression__Group_1__06207 = new BitSet(new long[]{0x00000000E0000000L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__1_in_rule__NumericalMultiplyDivideExpression__Group_1__06210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__1__Impl_in_rule__NumericalMultiplyDivideExpression__Group_1__16268 = new BitSet(new long[]{0x00040001180003F0L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__2_in_rule__NumericalMultiplyDivideExpression__Group_1__16271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_1_in_rule__NumericalMultiplyDivideExpression__Group_1__1__Impl6298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__Group_1__2__Impl_in_rule__NumericalMultiplyDivideExpression__Group_1__26328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_2_in_rule__NumericalMultiplyDivideExpression__Group_1__2__Impl6355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalUnaryExpression__Group_1__0__Impl_in_rule__NumericalUnaryExpression__Group_1__06391 = new BitSet(new long[]{0x00040001180003F0L});
    public static final BitSet FOLLOW_rule__NumericalUnaryExpression__Group_1__1_in_rule__NumericalUnaryExpression__Group_1__06394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalUnaryExpression__Group_1__1__Impl_in_rule__NumericalUnaryExpression__Group_1__16452 = new BitSet(new long[]{0x00040000000003F0L});
    public static final BitSet FOLLOW_rule__NumericalUnaryExpression__Group_1__2_in_rule__NumericalUnaryExpression__Group_1__16455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalUnaryExpression__OperatorAssignment_1_1_in_rule__NumericalUnaryExpression__Group_1__1__Impl6482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalUnaryExpression__Group_1__2__Impl_in_rule__NumericalUnaryExpression__Group_1__26512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericalUnaryExpression__OperandAssignment_1_2_in_rule__NumericalUnaryExpression__Group_1__2__Impl6539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimitiveValueExpression__Group__0__Impl_in_rule__PrimitiveValueExpression__Group__06575 = new BitSet(new long[]{0x00000000000003E0L});
    public static final BitSet FOLLOW_rule__PrimitiveValueExpression__Group__1_in_rule__PrimitiveValueExpression__Group__06578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimitiveValueExpression__Group__1__Impl_in_rule__PrimitiveValueExpression__Group__16636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimitiveValueExpression__ValueAssignment_1_in_rule__PrimitiveValueExpression__Group__1__Impl6663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group__0__Impl_in_rule__FeatureCall__Group__06697 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group__1_in_rule__FeatureCall__Group__06700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementReferenceExpression_in_rule__FeatureCall__Group__0__Impl6727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group__1__Impl_in_rule__FeatureCall__Group__16756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1__0_in_rule__FeatureCall__Group__1__Impl6783 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1__0__Impl_in_rule__FeatureCall__Group_1__06818 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1__1_in_rule__FeatureCall__Group_1__06821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1__1__Impl_in_rule__FeatureCall__Group_1__16879 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1__2_in_rule__FeatureCall__Group_1__16882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__FeatureCall__Group_1__1__Impl6910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1__2__Impl_in_rule__FeatureCall__Group_1__26941 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1__3_in_rule__FeatureCall__Group_1__26944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__FeatureAssignment_1_2_in_rule__FeatureCall__Group_1__2__Impl6971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1__3__Impl_in_rule__FeatureCall__Group_1__37001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3__0_in_rule__FeatureCall__Group_1__3__Impl7028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3__0__Impl_in_rule__FeatureCall__Group_1_3__07067 = new BitSet(new long[]{0x00050801180003F0L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3__1_in_rule__FeatureCall__Group_1_3__07070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__OperationCallAssignment_1_3_0_in_rule__FeatureCall__Group_1_3__0__Impl7097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3__1__Impl_in_rule__FeatureCall__Group_1_3__17127 = new BitSet(new long[]{0x00050801180003F0L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3__2_in_rule__FeatureCall__Group_1_3__17130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3_1__0_in_rule__FeatureCall__Group_1_3__1__Impl7157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3__2__Impl_in_rule__FeatureCall__Group_1_3__27188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__FeatureCall__Group_1_3__2__Impl7216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3_1__0__Impl_in_rule__FeatureCall__Group_1_3_1__07253 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3_1__1_in_rule__FeatureCall__Group_1_3_1__07256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__ArgsAssignment_1_3_1_0_in_rule__FeatureCall__Group_1_3_1__0__Impl7283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3_1__1__Impl_in_rule__FeatureCall__Group_1_3_1__17313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3_1_1__0_in_rule__FeatureCall__Group_1_3_1__1__Impl7340 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3_1_1__0__Impl_in_rule__FeatureCall__Group_1_3_1_1__07375 = new BitSet(new long[]{0x00040801180003F0L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3_1_1__1_in_rule__FeatureCall__Group_1_3_1_1__07378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__FeatureCall__Group_1_3_1_1__0__Impl7406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__Group_1_3_1_1__1__Impl_in_rule__FeatureCall__Group_1_3_1_1__17437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCall__ArgsAssignment_1_3_1_1_1_in_rule__FeatureCall__Group_1_3_1_1__1__Impl7464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group__0__Impl_in_rule__ElementReferenceExpression__Group__07498 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group__1_in_rule__ElementReferenceExpression__Group__07501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group__1__Impl_in_rule__ElementReferenceExpression__Group__17559 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group__2_in_rule__ElementReferenceExpression__Group__17562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__ReferenceAssignment_1_in_rule__ElementReferenceExpression__Group__1__Impl7589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group__2__Impl_in_rule__ElementReferenceExpression__Group__27619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2__0_in_rule__ElementReferenceExpression__Group__2__Impl7646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2__0__Impl_in_rule__ElementReferenceExpression__Group_2__07683 = new BitSet(new long[]{0x00050801180003F0L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2__1_in_rule__ElementReferenceExpression__Group_2__07686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__OperationCallAssignment_2_0_in_rule__ElementReferenceExpression__Group_2__0__Impl7713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2__1__Impl_in_rule__ElementReferenceExpression__Group_2__17743 = new BitSet(new long[]{0x00050801180003F0L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2__2_in_rule__ElementReferenceExpression__Group_2__17746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2_1__0_in_rule__ElementReferenceExpression__Group_2__1__Impl7773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2__2__Impl_in_rule__ElementReferenceExpression__Group_2__27804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__ElementReferenceExpression__Group_2__2__Impl7832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2_1__0__Impl_in_rule__ElementReferenceExpression__Group_2_1__07869 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2_1__1_in_rule__ElementReferenceExpression__Group_2_1__07872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__ArgsAssignment_2_1_0_in_rule__ElementReferenceExpression__Group_2_1__0__Impl7899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2_1__1__Impl_in_rule__ElementReferenceExpression__Group_2_1__17929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2_1_1__0_in_rule__ElementReferenceExpression__Group_2_1__1__Impl7956 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2_1_1__0__Impl_in_rule__ElementReferenceExpression__Group_2_1_1__07991 = new BitSet(new long[]{0x00040801180003F0L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2_1_1__1_in_rule__ElementReferenceExpression__Group_2_1_1__07994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__ElementReferenceExpression__Group_2_1_1__0__Impl8022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__Group_2_1_1__1__Impl_in_rule__ElementReferenceExpression__Group_2_1_1__18053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementReferenceExpression__ArgsAssignment_2_1_1_1_in_rule__ElementReferenceExpression__Group_2_1_1__1__Impl8080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__0__Impl_in_rule__ParenthesizedExpression__Group__08114 = new BitSet(new long[]{0x00040000000003F0L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__1_in_rule__ParenthesizedExpression__Group__08117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__1__Impl_in_rule__ParenthesizedExpression__Group__18175 = new BitSet(new long[]{0x00040801180003F0L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__2_in_rule__ParenthesizedExpression__Group__18178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ParenthesizedExpression__Group__1__Impl8206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__2__Impl_in_rule__ParenthesizedExpression__Group__28237 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__3_in_rule__ParenthesizedExpression__Group__28240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__ExpressionAssignment_2_in_rule__ParenthesizedExpression__Group__2__Impl8267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__3__Impl_in_rule__ParenthesizedExpression__Group__38297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__ParenthesizedExpression__Group__3__Impl8325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BoolLiteral__Group__0__Impl_in_rule__BoolLiteral__Group__08364 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__BoolLiteral__Group__1_in_rule__BoolLiteral__Group__08367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BoolLiteral__Group__1__Impl_in_rule__BoolLiteral__Group__18425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BoolLiteral__ValueAssignment_1_in_rule__BoolLiteral__Group__1__Impl8452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__08486 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__08489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__18547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl8574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__08608 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__08611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__18669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl8696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HexLiteral__Group__0__Impl_in_rule__HexLiteral__Group__08730 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__HexLiteral__Group__1_in_rule__HexLiteral__Group__08733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HexLiteral__Group__1__Impl_in_rule__HexLiteral__Group__18791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HexLiteral__ValueAssignment_1_in_rule__HexLiteral__Group__1__Impl8818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__08852 = new BitSet(new long[]{0x00000000000003E0L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__08855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__18913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl8940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentOperator_in_rule__AssignmentExpression__OperatorAssignment_1_18979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_rule__AssignmentExpression__ExpressionAssignment_1_29010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_rule__ConditionalExpression__TrueCaseAssignment_1_29041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_rule__ConditionalExpression__FalseCaseAssignment_1_49072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_rule__LogicalOrExpression__RightOperandAssignment_1_29103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_rule__LogicalAndExpression__RightOperandAssignment_1_29134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseXorExpression_in_rule__LogicalNotExpression__OperandAssignment_1_29165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpression_in_rule__BitwiseXorExpression__RightOperandAssignment_1_29196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpression_in_rule__BitwiseOrExpression__RightOperandAssignment_1_29227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_rule__BitwiseAndExpression__RightOperandAssignment_1_29258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_rule__LogicalRelationExpression__OperatorAssignment_1_19289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_rule__LogicalRelationExpression__RightOperandAssignment_1_29320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftOperator_in_rule__ShiftExpression__OperatorAssignment_1_19351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_rule__ShiftExpression__RightOperandAssignment_1_29382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_rule__NumericalAddSubtractExpression__OperatorAssignment_1_19413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_rule__NumericalAddSubtractExpression__RightOperandAssignment_1_29444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_rule__NumericalMultiplyDivideExpression__OperatorAssignment_1_19475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_rule__NumericalMultiplyDivideExpression__RightOperandAssignment_1_29506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_rule__NumericalUnaryExpression__OperatorAssignment_1_19537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__NumericalUnaryExpression__OperandAssignment_1_29568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__PrimitiveValueExpression__ValueAssignment_19599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FeatureCall__FeatureAssignment_1_29634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__FeatureCall__OperationCallAssignment_1_3_09674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__FeatureCall__ArgsAssignment_1_3_1_09713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__FeatureCall__ArgsAssignment_1_3_1_1_19744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ElementReferenceExpression__ReferenceAssignment_19779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ElementReferenceExpression__OperationCallAssignment_2_09819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ElementReferenceExpression__ArgsAssignment_2_1_09858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ElementReferenceExpression__ArgsAssignment_2_1_1_19889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ParenthesizedExpression__ExpressionAssignment_29920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOL_in_rule__BoolLiteral__ValueAssignment_19951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__IntLiteral__ValueAssignment_19982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_FLOAT_in_rule__RealLiteral__ValueAssignment_110013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_rule__HexLiteral__ValueAssignment_110044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_110075 = new BitSet(new long[]{0x0000000000000002L});

}