package org.yakindu.sct.model.stext.parser.antlr.internal; 

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
import org.yakindu.sct.model.stext.services.STextGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalSTextParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_BOOL", "RULE_STRING", "RULE_FLOAT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'@@statechart@@'", "'@@state@@'", "'@@transition@@'", "'interface'", "':'", "'internal'", "'event'", "'='", "'var'", "'readonly'", "'external'", "'clock'", "'operation'", "'('", "','", "')'", "'entrypoint'", "'exitpoint'", "'/'", "'#'", "'['", "']'", "';'", "'>'", "'after'", "'entry'", "'exit'", "'oncycle'", "'always'", "'raise'", "'||'", "'&&'", "'!'", "'in'", "'out'", "'+'", "'-'", "'*'", "'%'", "'~'", "'<'", "'<='", "'>='", "'=='", "'!='", "'s'", "'ms'", "'ns'", "'void'", "'integer'", "'real'", "'boolean'", "'string'"
    };
    public static final int T__42=42;
    public static final int T__28=28;
    public static final int T__57=57;
    public static final int T__23=23;
    public static final int T__51=51;
    public static final int T__13=13;
    public static final int RULE_STRING=7;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int T__21=21;
    public static final int RULE_FLOAT=8;
    public static final int T__65=65;
    public static final int T__19=19;
    public static final int T__39=39;
    public static final int T__30=30;
    public static final int T__46=46;
    public static final int T__52=52;
    public static final int T__17=17;
    public static final int T__62=62;
    public static final int RULE_INT=5;
    public static final int T__27=27;
    public static final int T__24=24;
    public static final int T__49=49;
    public static final int T__61=61;
    public static final int T__59=59;
    public static final int T__54=54;
    public static final int T__48=48;
    public static final int T__34=34;
    public static final int T__56=56;
    public static final int T__15=15;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__35=35;
    public static final int RULE_ID=4;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int T__58=58;
    public static final int T__64=64;
    public static final int T__44=44;
    public static final int T__14=14;
    public static final int T__33=33;
    public static final int T__22=22;
    public static final int T__55=55;
    public static final int T__29=29;
    public static final int T__45=45;
    public static final int RULE_WS=11;
    public static final int T__63=63;
    public static final int T__43=43;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int T__16=16;
    public static final int T__32=32;
    public static final int T__38=38;
    public static final int RULE_BOOL=6;
    public static final int T__37=37;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int T__18=18;

    // delegates
    // delegators


        public InternalSTextParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSTextParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSTextParser.tokenNames; }
    public String getGrammarFileName() { return "../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g"; }



     	private STextGrammarAccess grammarAccess;
     	
        public InternalSTextParser(TokenStream input, STextGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Root";	
       	}
       	
       	@Override
       	protected STextGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleRoot"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:68:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:69:2: (iv_ruleRoot= ruleRoot EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:70:2: iv_ruleRoot= ruleRoot EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRootRule()); 
            }
            pushFollow(FOLLOW_ruleRoot_in_entryRuleRoot75);
            iv_ruleRoot=ruleRoot();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRoot; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRoot85); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:77:1: ruleRoot returns [EObject current=null] : ( (lv_roots_0_0= ruleDefRoot ) )* ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        EObject lv_roots_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:80:28: ( ( (lv_roots_0_0= ruleDefRoot ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:81:1: ( (lv_roots_0_0= ruleDefRoot ) )*
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:81:1: ( (lv_roots_0_0= ruleDefRoot ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=13 && LA1_0<=15)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:82:1: (lv_roots_0_0= ruleDefRoot )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:82:1: (lv_roots_0_0= ruleDefRoot )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:83:3: lv_roots_0_0= ruleDefRoot
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRootAccess().getRootsDefRootParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDefRoot_in_ruleRoot130);
            	    lv_roots_0_0=ruleDefRoot();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRootRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"roots",
            	              		lv_roots_0_0, 
            	              		"DefRoot");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleDefRoot"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:107:1: entryRuleDefRoot returns [EObject current=null] : iv_ruleDefRoot= ruleDefRoot EOF ;
    public final EObject entryRuleDefRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefRoot = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:108:2: (iv_ruleDefRoot= ruleDefRoot EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:109:2: iv_ruleDefRoot= ruleDefRoot EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefRootRule()); 
            }
            pushFollow(FOLLOW_ruleDefRoot_in_entryRuleDefRoot166);
            iv_ruleDefRoot=ruleDefRoot();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefRoot; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefRoot176); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefRoot"


    // $ANTLR start "ruleDefRoot"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:116:1: ruleDefRoot returns [EObject current=null] : (this_StatechartRoot_0= ruleStatechartRoot | this_StateRoot_1= ruleStateRoot | this_TransitionRoot_2= ruleTransitionRoot ) ;
    public final EObject ruleDefRoot() throws RecognitionException {
        EObject current = null;

        EObject this_StatechartRoot_0 = null;

        EObject this_StateRoot_1 = null;

        EObject this_TransitionRoot_2 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:119:28: ( (this_StatechartRoot_0= ruleStatechartRoot | this_StateRoot_1= ruleStateRoot | this_TransitionRoot_2= ruleTransitionRoot ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:120:1: (this_StatechartRoot_0= ruleStatechartRoot | this_StateRoot_1= ruleStateRoot | this_TransitionRoot_2= ruleTransitionRoot )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:120:1: (this_StatechartRoot_0= ruleStatechartRoot | this_StateRoot_1= ruleStateRoot | this_TransitionRoot_2= ruleTransitionRoot )
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
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:121:5: this_StatechartRoot_0= ruleStatechartRoot
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDefRootAccess().getStatechartRootParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleStatechartRoot_in_ruleDefRoot223);
                    this_StatechartRoot_0=ruleStatechartRoot();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_StatechartRoot_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:131:5: this_StateRoot_1= ruleStateRoot
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDefRootAccess().getStateRootParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleStateRoot_in_ruleDefRoot250);
                    this_StateRoot_1=ruleStateRoot();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_StateRoot_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:141:5: this_TransitionRoot_2= ruleTransitionRoot
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDefRootAccess().getTransitionRootParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTransitionRoot_in_ruleDefRoot277);
                    this_TransitionRoot_2=ruleTransitionRoot();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TransitionRoot_2; 
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
    // $ANTLR end "ruleDefRoot"


    // $ANTLR start "entryRuleStatechartRoot"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:157:1: entryRuleStatechartRoot returns [EObject current=null] : iv_ruleStatechartRoot= ruleStatechartRoot EOF ;
    public final EObject entryRuleStatechartRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatechartRoot = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:158:2: (iv_ruleStatechartRoot= ruleStatechartRoot EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:159:2: iv_ruleStatechartRoot= ruleStatechartRoot EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatechartRootRule()); 
            }
            pushFollow(FOLLOW_ruleStatechartRoot_in_entryRuleStatechartRoot312);
            iv_ruleStatechartRoot=ruleStatechartRoot();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatechartRoot; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatechartRoot322); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatechartRoot"


    // $ANTLR start "ruleStatechartRoot"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:166:1: ruleStatechartRoot returns [EObject current=null] : (otherlv_0= '@@statechart@@' ( (lv_def_1_0= ruleStatechartDefinition ) ) ) ;
    public final EObject ruleStatechartRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_def_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:169:28: ( (otherlv_0= '@@statechart@@' ( (lv_def_1_0= ruleStatechartDefinition ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:170:1: (otherlv_0= '@@statechart@@' ( (lv_def_1_0= ruleStatechartDefinition ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:170:1: (otherlv_0= '@@statechart@@' ( (lv_def_1_0= ruleStatechartDefinition ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:170:3: otherlv_0= '@@statechart@@' ( (lv_def_1_0= ruleStatechartDefinition ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleStatechartRoot359); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getStatechartRootAccess().getStatechartKeyword_0());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:174:1: ( (lv_def_1_0= ruleStatechartDefinition ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:175:1: (lv_def_1_0= ruleStatechartDefinition )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:175:1: (lv_def_1_0= ruleStatechartDefinition )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:176:3: lv_def_1_0= ruleStatechartDefinition
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStatechartRootAccess().getDefStatechartDefinitionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStatechartDefinition_in_ruleStatechartRoot380);
            lv_def_1_0=ruleStatechartDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getStatechartRootRule());
              	        }
                     		set(
                     			current, 
                     			"def",
                      		lv_def_1_0, 
                      		"StatechartDefinition");
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
    // $ANTLR end "ruleStatechartRoot"


    // $ANTLR start "entryRuleStateRoot"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:200:1: entryRuleStateRoot returns [EObject current=null] : iv_ruleStateRoot= ruleStateRoot EOF ;
    public final EObject entryRuleStateRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateRoot = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:201:2: (iv_ruleStateRoot= ruleStateRoot EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:202:2: iv_ruleStateRoot= ruleStateRoot EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStateRootRule()); 
            }
            pushFollow(FOLLOW_ruleStateRoot_in_entryRuleStateRoot416);
            iv_ruleStateRoot=ruleStateRoot();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStateRoot; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateRoot426); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStateRoot"


    // $ANTLR start "ruleStateRoot"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:209:1: ruleStateRoot returns [EObject current=null] : (otherlv_0= '@@state@@' ( (lv_def_1_0= ruleStateDeclaration ) ) ) ;
    public final EObject ruleStateRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_def_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:212:28: ( (otherlv_0= '@@state@@' ( (lv_def_1_0= ruleStateDeclaration ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:213:1: (otherlv_0= '@@state@@' ( (lv_def_1_0= ruleStateDeclaration ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:213:1: (otherlv_0= '@@state@@' ( (lv_def_1_0= ruleStateDeclaration ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:213:3: otherlv_0= '@@state@@' ( (lv_def_1_0= ruleStateDeclaration ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleStateRoot463); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getStateRootAccess().getStateKeyword_0());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:217:1: ( (lv_def_1_0= ruleStateDeclaration ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:218:1: (lv_def_1_0= ruleStateDeclaration )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:218:1: (lv_def_1_0= ruleStateDeclaration )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:219:3: lv_def_1_0= ruleStateDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStateRootAccess().getDefStateDeclarationParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStateDeclaration_in_ruleStateRoot484);
            lv_def_1_0=ruleStateDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getStateRootRule());
              	        }
                     		set(
                     			current, 
                     			"def",
                      		lv_def_1_0, 
                      		"StateDeclaration");
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
    // $ANTLR end "ruleStateRoot"


    // $ANTLR start "entryRuleTransitionRoot"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:243:1: entryRuleTransitionRoot returns [EObject current=null] : iv_ruleTransitionRoot= ruleTransitionRoot EOF ;
    public final EObject entryRuleTransitionRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionRoot = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:244:2: (iv_ruleTransitionRoot= ruleTransitionRoot EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:245:2: iv_ruleTransitionRoot= ruleTransitionRoot EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransitionRootRule()); 
            }
            pushFollow(FOLLOW_ruleTransitionRoot_in_entryRuleTransitionRoot520);
            iv_ruleTransitionRoot=ruleTransitionRoot();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransitionRoot; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionRoot530); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransitionRoot"


    // $ANTLR start "ruleTransitionRoot"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:252:1: ruleTransitionRoot returns [EObject current=null] : (otherlv_0= '@@transition@@' ( (lv_def_1_0= ruleTransitionStatement ) ) ) ;
    public final EObject ruleTransitionRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_def_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:255:28: ( (otherlv_0= '@@transition@@' ( (lv_def_1_0= ruleTransitionStatement ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:256:1: (otherlv_0= '@@transition@@' ( (lv_def_1_0= ruleTransitionStatement ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:256:1: (otherlv_0= '@@transition@@' ( (lv_def_1_0= ruleTransitionStatement ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:256:3: otherlv_0= '@@transition@@' ( (lv_def_1_0= ruleTransitionStatement ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleTransitionRoot567); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTransitionRootAccess().getTransitionKeyword_0());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:260:1: ( (lv_def_1_0= ruleTransitionStatement ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:261:1: (lv_def_1_0= ruleTransitionStatement )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:261:1: (lv_def_1_0= ruleTransitionStatement )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:262:3: lv_def_1_0= ruleTransitionStatement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransitionRootAccess().getDefTransitionStatementParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTransitionStatement_in_ruleTransitionRoot588);
            lv_def_1_0=ruleTransitionStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTransitionRootRule());
              	        }
                     		set(
                     			current, 
                     			"def",
                      		lv_def_1_0, 
                      		"TransitionStatement");
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
    // $ANTLR end "ruleTransitionRoot"


    // $ANTLR start "entryRuleStatechartDefinition"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:286:1: entryRuleStatechartDefinition returns [EObject current=null] : iv_ruleStatechartDefinition= ruleStatechartDefinition EOF ;
    public final EObject entryRuleStatechartDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatechartDefinition = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:287:2: (iv_ruleStatechartDefinition= ruleStatechartDefinition EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:288:2: iv_ruleStatechartDefinition= ruleStatechartDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatechartDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleStatechartDefinition_in_entryRuleStatechartDefinition624);
            iv_ruleStatechartDefinition=ruleStatechartDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatechartDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatechartDefinition634); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatechartDefinition"


    // $ANTLR start "ruleStatechartDefinition"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:295:1: ruleStatechartDefinition returns [EObject current=null] : ( () ( (lv_definitionScopes_1_0= ruleStatechartScope ) )* ) ;
    public final EObject ruleStatechartDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_definitionScopes_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:298:28: ( ( () ( (lv_definitionScopes_1_0= ruleStatechartScope ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:299:1: ( () ( (lv_definitionScopes_1_0= ruleStatechartScope ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:299:1: ( () ( (lv_definitionScopes_1_0= ruleStatechartScope ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:299:2: () ( (lv_definitionScopes_1_0= ruleStatechartScope ) )*
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:299:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:300:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getStatechartDefinitionAccess().getStatechartDefinitionAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:305:2: ( (lv_definitionScopes_1_0= ruleStatechartScope ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16||LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:306:1: (lv_definitionScopes_1_0= ruleStatechartScope )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:306:1: (lv_definitionScopes_1_0= ruleStatechartScope )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:307:3: lv_definitionScopes_1_0= ruleStatechartScope
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStatechartDefinitionAccess().getDefinitionScopesStatechartScopeParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleStatechartScope_in_ruleStatechartDefinition689);
            	    lv_definitionScopes_1_0=ruleStatechartScope();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getStatechartDefinitionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"definitionScopes",
            	              		lv_definitionScopes_1_0, 
            	              		"StatechartScope");
            	      	        afterParserOrEnumRuleCall();
            	      	    
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
    // $ANTLR end "ruleStatechartDefinition"


    // $ANTLR start "entryRuleStateDeclaration"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:331:1: entryRuleStateDeclaration returns [EObject current=null] : iv_ruleStateDeclaration= ruleStateDeclaration EOF ;
    public final EObject entryRuleStateDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateDeclaration = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:332:2: (iv_ruleStateDeclaration= ruleStateDeclaration EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:333:2: iv_ruleStateDeclaration= ruleStateDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStateDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleStateDeclaration_in_entryRuleStateDeclaration726);
            iv_ruleStateDeclaration=ruleStateDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStateDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateDeclaration736); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStateDeclaration"


    // $ANTLR start "ruleStateDeclaration"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:340:1: ruleStateDeclaration returns [EObject current=null] : ( (lv_scope_0_0= ruleSimpleScope ) ) ;
    public final EObject ruleStateDeclaration() throws RecognitionException {
        EObject current = null;

        EObject lv_scope_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:343:28: ( ( (lv_scope_0_0= ruleSimpleScope ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:344:1: ( (lv_scope_0_0= ruleSimpleScope ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:344:1: ( (lv_scope_0_0= ruleSimpleScope ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:345:1: (lv_scope_0_0= ruleSimpleScope )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:345:1: (lv_scope_0_0= ruleSimpleScope )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:346:3: lv_scope_0_0= ruleSimpleScope
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStateDeclarationAccess().getScopeSimpleScopeParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleSimpleScope_in_ruleStateDeclaration781);
            lv_scope_0_0=ruleSimpleScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getStateDeclarationRule());
              	        }
                     		set(
                     			current, 
                     			"scope",
                      		lv_scope_0_0, 
                      		"SimpleScope");
              	        afterParserOrEnumRuleCall();
              	    
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
    // $ANTLR end "ruleStateDeclaration"


    // $ANTLR start "entryRuleTransitionStatement"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:370:1: entryRuleTransitionStatement returns [EObject current=null] : iv_ruleTransitionStatement= ruleTransitionStatement EOF ;
    public final EObject entryRuleTransitionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionStatement = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:371:2: (iv_ruleTransitionStatement= ruleTransitionStatement EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:372:2: iv_ruleTransitionStatement= ruleTransitionStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransitionStatementRule()); 
            }
            pushFollow(FOLLOW_ruleTransitionStatement_in_entryRuleTransitionStatement816);
            iv_ruleTransitionStatement=ruleTransitionStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransitionStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionStatement826); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransitionStatement"


    // $ANTLR start "ruleTransitionStatement"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:379:1: ruleTransitionStatement returns [EObject current=null] : this_TransitionReaction_0= ruleTransitionReaction ;
    public final EObject ruleTransitionStatement() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionReaction_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:382:28: (this_TransitionReaction_0= ruleTransitionReaction )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:384:5: this_TransitionReaction_0= ruleTransitionReaction
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTransitionStatementAccess().getTransitionReactionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleTransitionReaction_in_ruleTransitionStatement872);
            this_TransitionReaction_0=ruleTransitionReaction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TransitionReaction_0; 
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
    // $ANTLR end "ruleTransitionStatement"


    // $ANTLR start "entryRuleSimpleScope"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:402:1: entryRuleSimpleScope returns [EObject current=null] : iv_ruleSimpleScope= ruleSimpleScope EOF ;
    public final EObject entryRuleSimpleScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleScope = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:403:2: (iv_ruleSimpleScope= ruleSimpleScope EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:404:2: iv_ruleSimpleScope= ruleSimpleScope EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleScopeRule()); 
            }
            pushFollow(FOLLOW_ruleSimpleScope_in_entryRuleSimpleScope908);
            iv_ruleSimpleScope=ruleSimpleScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleScope; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleScope918); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleScope"


    // $ANTLR start "ruleSimpleScope"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:411:1: ruleSimpleScope returns [EObject current=null] : ( () ( (lv_declarations_1_0= ruleDeclaration ) )* ) ;
    public final EObject ruleSimpleScope() throws RecognitionException {
        EObject current = null;

        EObject lv_declarations_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:414:28: ( ( () ( (lv_declarations_1_0= ruleDeclaration ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:415:1: ( () ( (lv_declarations_1_0= ruleDeclaration ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:415:1: ( () ( (lv_declarations_1_0= ruleDeclaration ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:415:2: () ( (lv_declarations_1_0= ruleDeclaration ) )*
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:415:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:416:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getSimpleScopeAccess().getSimpleScopeAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:421:2: ( (lv_declarations_1_0= ruleDeclaration ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID||LA4_0==19||LA4_0==21||(LA4_0>=24 && LA4_0<=25)||(LA4_0>=29 && LA4_0<=30)||LA4_0==33||(LA4_0>=37 && LA4_0<=41)||(LA4_0>=46 && LA4_0<=47)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:422:1: (lv_declarations_1_0= ruleDeclaration )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:422:1: (lv_declarations_1_0= ruleDeclaration )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:423:3: lv_declarations_1_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSimpleScopeAccess().getDeclarationsDeclarationParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDeclaration_in_ruleSimpleScope973);
            	    lv_declarations_1_0=ruleDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSimpleScopeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"declarations",
            	              		lv_declarations_1_0, 
            	              		"Declaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
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
    // $ANTLR end "ruleSimpleScope"


    // $ANTLR start "entryRuleStatechartScope"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:447:1: entryRuleStatechartScope returns [EObject current=null] : iv_ruleStatechartScope= ruleStatechartScope EOF ;
    public final EObject entryRuleStatechartScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatechartScope = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:448:2: (iv_ruleStatechartScope= ruleStatechartScope EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:449:2: iv_ruleStatechartScope= ruleStatechartScope EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatechartScopeRule()); 
            }
            pushFollow(FOLLOW_ruleStatechartScope_in_entryRuleStatechartScope1010);
            iv_ruleStatechartScope=ruleStatechartScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatechartScope; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatechartScope1020); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatechartScope"


    // $ANTLR start "ruleStatechartScope"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:456:1: ruleStatechartScope returns [EObject current=null] : (this_InterfaceScope_0= ruleInterfaceScope | this_InternalScope_1= ruleInternalScope ) ;
    public final EObject ruleStatechartScope() throws RecognitionException {
        EObject current = null;

        EObject this_InterfaceScope_0 = null;

        EObject this_InternalScope_1 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:459:28: ( (this_InterfaceScope_0= ruleInterfaceScope | this_InternalScope_1= ruleInternalScope ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:460:1: (this_InterfaceScope_0= ruleInterfaceScope | this_InternalScope_1= ruleInternalScope )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:460:1: (this_InterfaceScope_0= ruleInterfaceScope | this_InternalScope_1= ruleInternalScope )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:461:5: this_InterfaceScope_0= ruleInterfaceScope
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatechartScopeAccess().getInterfaceScopeParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleInterfaceScope_in_ruleStatechartScope1067);
                    this_InterfaceScope_0=ruleInterfaceScope();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_InterfaceScope_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:471:5: this_InternalScope_1= ruleInternalScope
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatechartScopeAccess().getInternalScopeParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleInternalScope_in_ruleStatechartScope1094);
                    this_InternalScope_1=ruleInternalScope();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_InternalScope_1; 
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
    // $ANTLR end "ruleStatechartScope"


    // $ANTLR start "entryRuleInterfaceScope"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:487:1: entryRuleInterfaceScope returns [EObject current=null] : iv_ruleInterfaceScope= ruleInterfaceScope EOF ;
    public final EObject entryRuleInterfaceScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceScope = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:488:2: (iv_ruleInterfaceScope= ruleInterfaceScope EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:489:2: iv_ruleInterfaceScope= ruleInterfaceScope EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInterfaceScopeRule()); 
            }
            pushFollow(FOLLOW_ruleInterfaceScope_in_entryRuleInterfaceScope1129);
            iv_ruleInterfaceScope=ruleInterfaceScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInterfaceScope; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterfaceScope1139); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInterfaceScope"


    // $ANTLR start "ruleInterfaceScope"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:496:1: ruleInterfaceScope returns [EObject current=null] : ( () otherlv_1= 'interface' ( (lv_name_2_0= RULE_ID ) )? otherlv_3= ':' ( (lv_declarations_4_0= ruleDeclaration ) )* ) ;
    public final EObject ruleInterfaceScope() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        EObject lv_declarations_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:499:28: ( ( () otherlv_1= 'interface' ( (lv_name_2_0= RULE_ID ) )? otherlv_3= ':' ( (lv_declarations_4_0= ruleDeclaration ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:500:1: ( () otherlv_1= 'interface' ( (lv_name_2_0= RULE_ID ) )? otherlv_3= ':' ( (lv_declarations_4_0= ruleDeclaration ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:500:1: ( () otherlv_1= 'interface' ( (lv_name_2_0= RULE_ID ) )? otherlv_3= ':' ( (lv_declarations_4_0= ruleDeclaration ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:500:2: () otherlv_1= 'interface' ( (lv_name_2_0= RULE_ID ) )? otherlv_3= ':' ( (lv_declarations_4_0= ruleDeclaration ) )*
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:500:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:501:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getInterfaceScopeAccess().getInterfaceScopeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleInterfaceScope1185); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getInterfaceScopeAccess().getInterfaceKeyword_1());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:510:1: ( (lv_name_2_0= RULE_ID ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:511:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:511:1: (lv_name_2_0= RULE_ID )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:512:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInterfaceScope1202); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_2_0, grammarAccess.getInterfaceScopeAccess().getNameIDTerminalRuleCall_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getInterfaceScopeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_2_0, 
                              		"ID");
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleInterfaceScope1220); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getInterfaceScopeAccess().getColonKeyword_3());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:532:1: ( (lv_declarations_4_0= ruleDeclaration ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==19||LA7_0==21||(LA7_0>=24 && LA7_0<=25)||(LA7_0>=29 && LA7_0<=30)||LA7_0==33||(LA7_0>=37 && LA7_0<=41)||(LA7_0>=46 && LA7_0<=47)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:533:1: (lv_declarations_4_0= ruleDeclaration )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:533:1: (lv_declarations_4_0= ruleDeclaration )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:534:3: lv_declarations_4_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getInterfaceScopeAccess().getDeclarationsDeclarationParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDeclaration_in_ruleInterfaceScope1241);
            	    lv_declarations_4_0=ruleDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getInterfaceScopeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"declarations",
            	              		lv_declarations_4_0, 
            	              		"Declaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
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
    // $ANTLR end "ruleInterfaceScope"


    // $ANTLR start "entryRuleInternalScope"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:558:1: entryRuleInternalScope returns [EObject current=null] : iv_ruleInternalScope= ruleInternalScope EOF ;
    public final EObject entryRuleInternalScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInternalScope = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:559:2: (iv_ruleInternalScope= ruleInternalScope EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:560:2: iv_ruleInternalScope= ruleInternalScope EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInternalScopeRule()); 
            }
            pushFollow(FOLLOW_ruleInternalScope_in_entryRuleInternalScope1278);
            iv_ruleInternalScope=ruleInternalScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInternalScope; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInternalScope1288); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInternalScope"


    // $ANTLR start "ruleInternalScope"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:567:1: ruleInternalScope returns [EObject current=null] : ( () otherlv_1= 'internal' otherlv_2= ':' ( (lv_declarations_3_0= ruleDeclaration ) )* ) ;
    public final EObject ruleInternalScope() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_declarations_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:570:28: ( ( () otherlv_1= 'internal' otherlv_2= ':' ( (lv_declarations_3_0= ruleDeclaration ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:571:1: ( () otherlv_1= 'internal' otherlv_2= ':' ( (lv_declarations_3_0= ruleDeclaration ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:571:1: ( () otherlv_1= 'internal' otherlv_2= ':' ( (lv_declarations_3_0= ruleDeclaration ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:571:2: () otherlv_1= 'internal' otherlv_2= ':' ( (lv_declarations_3_0= ruleDeclaration ) )*
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:571:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:572:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getInternalScopeAccess().getInternalScopeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleInternalScope1334); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getInternalScopeAccess().getInternalKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleInternalScope1346); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getInternalScopeAccess().getColonKeyword_2());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:585:1: ( (lv_declarations_3_0= ruleDeclaration ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID||LA8_0==19||LA8_0==21||(LA8_0>=24 && LA8_0<=25)||(LA8_0>=29 && LA8_0<=30)||LA8_0==33||(LA8_0>=37 && LA8_0<=41)||(LA8_0>=46 && LA8_0<=47)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:586:1: (lv_declarations_3_0= ruleDeclaration )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:586:1: (lv_declarations_3_0= ruleDeclaration )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:587:3: lv_declarations_3_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getInternalScopeAccess().getDeclarationsDeclarationParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDeclaration_in_ruleInternalScope1367);
            	    lv_declarations_3_0=ruleDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getInternalScopeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"declarations",
            	              		lv_declarations_3_0, 
            	              		"Declaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
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
    // $ANTLR end "ruleInternalScope"


    // $ANTLR start "entryRuleDeclaration"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:611:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:612:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:613:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleDeclaration_in_entryRuleDeclaration1404);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclaration1414); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclaration"


    // $ANTLR start "ruleDeclaration"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:620:1: ruleDeclaration returns [EObject current=null] : (this_EventDefinition_0= ruleEventDefinition | this_VariableDefinition_1= ruleVariableDefinition | this_Clock_2= ruleClock | this_Operation_3= ruleOperation | this_LocalReaction_4= ruleLocalReaction | this_Entrypoint_5= ruleEntrypoint | this_Exitpoint_6= ruleExitpoint ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_EventDefinition_0 = null;

        EObject this_VariableDefinition_1 = null;

        EObject this_Clock_2 = null;

        EObject this_Operation_3 = null;

        EObject this_LocalReaction_4 = null;

        EObject this_Entrypoint_5 = null;

        EObject this_Exitpoint_6 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:623:28: ( (this_EventDefinition_0= ruleEventDefinition | this_VariableDefinition_1= ruleVariableDefinition | this_Clock_2= ruleClock | this_Operation_3= ruleOperation | this_LocalReaction_4= ruleLocalReaction | this_Entrypoint_5= ruleEntrypoint | this_Exitpoint_6= ruleExitpoint ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:624:1: (this_EventDefinition_0= ruleEventDefinition | this_VariableDefinition_1= ruleVariableDefinition | this_Clock_2= ruleClock | this_Operation_3= ruleOperation | this_LocalReaction_4= ruleLocalReaction | this_Entrypoint_5= ruleEntrypoint | this_Exitpoint_6= ruleExitpoint )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:624:1: (this_EventDefinition_0= ruleEventDefinition | this_VariableDefinition_1= ruleVariableDefinition | this_Clock_2= ruleClock | this_Operation_3= ruleOperation | this_LocalReaction_4= ruleLocalReaction | this_Entrypoint_5= ruleEntrypoint | this_Exitpoint_6= ruleExitpoint )
            int alt9=7;
            switch ( input.LA(1) ) {
            case 19:
            case 46:
            case 47:
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
            case 33:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
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
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:625:5: this_EventDefinition_0= ruleEventDefinition
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDeclarationAccess().getEventDefinitionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEventDefinition_in_ruleDeclaration1461);
                    this_EventDefinition_0=ruleEventDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_EventDefinition_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:635:5: this_VariableDefinition_1= ruleVariableDefinition
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDeclarationAccess().getVariableDefinitionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleVariableDefinition_in_ruleDeclaration1488);
                    this_VariableDefinition_1=ruleVariableDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_VariableDefinition_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:645:5: this_Clock_2= ruleClock
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDeclarationAccess().getClockParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleClock_in_ruleDeclaration1515);
                    this_Clock_2=ruleClock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Clock_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:655:5: this_Operation_3= ruleOperation
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDeclarationAccess().getOperationParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOperation_in_ruleDeclaration1542);
                    this_Operation_3=ruleOperation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Operation_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:665:5: this_LocalReaction_4= ruleLocalReaction
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDeclarationAccess().getLocalReactionParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLocalReaction_in_ruleDeclaration1569);
                    this_LocalReaction_4=ruleLocalReaction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LocalReaction_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:675:5: this_Entrypoint_5= ruleEntrypoint
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDeclarationAccess().getEntrypointParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEntrypoint_in_ruleDeclaration1596);
                    this_Entrypoint_5=ruleEntrypoint();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Entrypoint_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:685:5: this_Exitpoint_6= ruleExitpoint
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDeclarationAccess().getExitpointParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExitpoint_in_ruleDeclaration1623);
                    this_Exitpoint_6=ruleExitpoint();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Exitpoint_6; 
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
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleEventDefinition"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:701:1: entryRuleEventDefinition returns [EObject current=null] : iv_ruleEventDefinition= ruleEventDefinition EOF ;
    public final EObject entryRuleEventDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventDefinition = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:702:2: (iv_ruleEventDefinition= ruleEventDefinition EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:703:2: iv_ruleEventDefinition= ruleEventDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleEventDefinition_in_entryRuleEventDefinition1658);
            iv_ruleEventDefinition=ruleEventDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventDefinition1668); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEventDefinition"


    // $ANTLR start "ruleEventDefinition"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:710:1: ruleEventDefinition returns [EObject current=null] : ( () ( (lv_direction_1_0= ruleDirection ) )? otherlv_2= 'event' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= ':' ( (lv_type_5_0= ruleType ) ) )? ( (lv_derivation_6_0= ruleEventDerivation ) )? ) ;
    public final EObject ruleEventDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Enumerator lv_direction_1_0 = null;

        Enumerator lv_type_5_0 = null;

        EObject lv_derivation_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:713:28: ( ( () ( (lv_direction_1_0= ruleDirection ) )? otherlv_2= 'event' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= ':' ( (lv_type_5_0= ruleType ) ) )? ( (lv_derivation_6_0= ruleEventDerivation ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:714:1: ( () ( (lv_direction_1_0= ruleDirection ) )? otherlv_2= 'event' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= ':' ( (lv_type_5_0= ruleType ) ) )? ( (lv_derivation_6_0= ruleEventDerivation ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:714:1: ( () ( (lv_direction_1_0= ruleDirection ) )? otherlv_2= 'event' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= ':' ( (lv_type_5_0= ruleType ) ) )? ( (lv_derivation_6_0= ruleEventDerivation ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:714:2: () ( (lv_direction_1_0= ruleDirection ) )? otherlv_2= 'event' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= ':' ( (lv_type_5_0= ruleType ) ) )? ( (lv_derivation_6_0= ruleEventDerivation ) )?
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:714:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:715:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEventDefinitionAccess().getEventDefinitionAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:720:2: ( (lv_direction_1_0= ruleDirection ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=46 && LA10_0<=47)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:721:1: (lv_direction_1_0= ruleDirection )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:721:1: (lv_direction_1_0= ruleDirection )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:722:3: lv_direction_1_0= ruleDirection
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEventDefinitionAccess().getDirectionDirectionEnumRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDirection_in_ruleEventDefinition1723);
                    lv_direction_1_0=ruleDirection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEventDefinitionRule());
                      	        }
                             		set(
                             			current, 
                             			"direction",
                              		lv_direction_1_0, 
                              		"Direction");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleEventDefinition1736); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getEventDefinitionAccess().getEventKeyword_2());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:742:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:743:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:743:1: (lv_name_3_0= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:744:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEventDefinition1753); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_3_0, grammarAccess.getEventDefinitionAccess().getNameIDTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEventDefinitionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_3_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:760:2: (otherlv_4= ':' ( (lv_type_5_0= ruleType ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==17) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:760:4: otherlv_4= ':' ( (lv_type_5_0= ruleType ) )
                    {
                    otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleEventDefinition1771); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getEventDefinitionAccess().getColonKeyword_4_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:764:1: ( (lv_type_5_0= ruleType ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:765:1: (lv_type_5_0= ruleType )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:765:1: (lv_type_5_0= ruleType )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:766:3: lv_type_5_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEventDefinitionAccess().getTypeTypeEnumRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleEventDefinition1792);
                    lv_type_5_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEventDefinitionRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_5_0, 
                              		"Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:782:4: ( (lv_derivation_6_0= ruleEventDerivation ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:783:1: (lv_derivation_6_0= ruleEventDerivation )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:783:1: (lv_derivation_6_0= ruleEventDerivation )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:784:3: lv_derivation_6_0= ruleEventDerivation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEventDefinitionAccess().getDerivationEventDerivationParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEventDerivation_in_ruleEventDefinition1815);
                    lv_derivation_6_0=ruleEventDerivation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEventDefinitionRule());
                      	        }
                             		set(
                             			current, 
                             			"derivation",
                              		lv_derivation_6_0, 
                              		"EventDerivation");
                      	        afterParserOrEnumRuleCall();
                      	    
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
    // $ANTLR end "ruleEventDefinition"


    // $ANTLR start "entryRuleEventDerivation"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:808:1: entryRuleEventDerivation returns [EObject current=null] : iv_ruleEventDerivation= ruleEventDerivation EOF ;
    public final EObject entryRuleEventDerivation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventDerivation = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:809:2: (iv_ruleEventDerivation= ruleEventDerivation EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:810:2: iv_ruleEventDerivation= ruleEventDerivation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventDerivationRule()); 
            }
            pushFollow(FOLLOW_ruleEventDerivation_in_entryRuleEventDerivation1852);
            iv_ruleEventDerivation=ruleEventDerivation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventDerivation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventDerivation1862); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEventDerivation"


    // $ANTLR start "ruleEventDerivation"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:817:1: ruleEventDerivation returns [EObject current=null] : (otherlv_0= '=' ( (lv_condition_1_0= ruleExpression ) ) (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )? ) ;
    public final EObject ruleEventDerivation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_condition_1_0 = null;

        EObject lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:820:28: ( (otherlv_0= '=' ( (lv_condition_1_0= ruleExpression ) ) (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:821:1: (otherlv_0= '=' ( (lv_condition_1_0= ruleExpression ) ) (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:821:1: (otherlv_0= '=' ( (lv_condition_1_0= ruleExpression ) ) (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:821:3: otherlv_0= '=' ( (lv_condition_1_0= ruleExpression ) ) (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )?
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleEventDerivation1899); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEventDerivationAccess().getEqualsSignKeyword_0());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:825:1: ( (lv_condition_1_0= ruleExpression ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:826:1: (lv_condition_1_0= ruleExpression )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:826:1: (lv_condition_1_0= ruleExpression )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:827:3: lv_condition_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEventDerivationAccess().getConditionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleEventDerivation1920);
            lv_condition_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEventDerivationRule());
              	        }
                     		set(
                     			current, 
                     			"condition",
                      		lv_condition_1_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:843:2: (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==17) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:843:4: otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleEventDerivation1933); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getEventDerivationAccess().getColonKeyword_2_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:847:1: ( (lv_value_3_0= ruleExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:848:1: (lv_value_3_0= ruleExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:848:1: (lv_value_3_0= ruleExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:849:3: lv_value_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEventDerivationAccess().getValueExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleEventDerivation1954);
                    lv_value_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEventDerivationRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_3_0, 
                              		"Expression");
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
    // $ANTLR end "ruleEventDerivation"


    // $ANTLR start "entryRuleVariableDefinition"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:873:1: entryRuleVariableDefinition returns [EObject current=null] : iv_ruleVariableDefinition= ruleVariableDefinition EOF ;
    public final EObject entryRuleVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDefinition = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:874:2: (iv_ruleVariableDefinition= ruleVariableDefinition EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:875:2: iv_ruleVariableDefinition= ruleVariableDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition1992);
            iv_ruleVariableDefinition=ruleVariableDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDefinition2002); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableDefinition"


    // $ANTLR start "ruleVariableDefinition"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:882:1: ruleVariableDefinition returns [EObject current=null] : ( () otherlv_1= 'var' ( ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( (lv_type_7_0= ruleType ) ) (otherlv_8= '=' ( (lv_initialValue_9_0= ruleLiteral ) ) )? ) ;
    public final EObject ruleVariableDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_readonly_3_0=null;
        Token lv_external_4_0=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Enumerator lv_type_7_0 = null;

        AntlrDatatypeRuleToken lv_initialValue_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:885:28: ( ( () otherlv_1= 'var' ( ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( (lv_type_7_0= ruleType ) ) (otherlv_8= '=' ( (lv_initialValue_9_0= ruleLiteral ) ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:886:1: ( () otherlv_1= 'var' ( ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( (lv_type_7_0= ruleType ) ) (otherlv_8= '=' ( (lv_initialValue_9_0= ruleLiteral ) ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:886:1: ( () otherlv_1= 'var' ( ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( (lv_type_7_0= ruleType ) ) (otherlv_8= '=' ( (lv_initialValue_9_0= ruleLiteral ) ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:886:2: () otherlv_1= 'var' ( ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( (lv_type_7_0= ruleType ) ) (otherlv_8= '=' ( (lv_initialValue_9_0= ruleLiteral ) ) )?
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:886:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:887:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getVariableDefinitionAccess().getVariableDefinitionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleVariableDefinition2048); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getVariableDefinitionAccess().getVarKeyword_1());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:896:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:898:1: ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:898:1: ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:899:2: ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2());
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:902:2: ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:903:3: ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )*
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:903:3: ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )*
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( LA14_0 ==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2(), 0) ) {
                    alt14=1;
                }
                else if ( LA14_0 ==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2(), 1) ) {
                    alt14=2;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:905:4: ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:905:4: ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:906:5: {...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleVariableDefinition", "getUnorderedGroupHelper().canSelect(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:906:115: ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:907:6: ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2(), 0);
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:910:6: ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:910:7: {...}? => ( (lv_readonly_3_0= 'readonly' ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleVariableDefinition", "true");
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:910:16: ( (lv_readonly_3_0= 'readonly' ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:911:1: (lv_readonly_3_0= 'readonly' )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:911:1: (lv_readonly_3_0= 'readonly' )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:912:3: lv_readonly_3_0= 'readonly'
            	    {
            	    lv_readonly_3_0=(Token)match(input,22,FOLLOW_22_in_ruleVariableDefinition2111); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_readonly_3_0, grammarAccess.getVariableDefinitionAccess().getReadonlyReadonlyKeyword_2_0_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getVariableDefinitionRule());
            	      	        }
            	             		setWithLastConsumed(current, "readonly", true, "readonly");
            	      	    
            	    }

            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:932:4: ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:932:4: ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:933:5: {...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleVariableDefinition", "getUnorderedGroupHelper().canSelect(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:933:115: ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:934:6: ({...}? => ( (lv_external_4_0= 'external' ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2(), 1);
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:937:6: ({...}? => ( (lv_external_4_0= 'external' ) ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:937:7: {...}? => ( (lv_external_4_0= 'external' ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleVariableDefinition", "true");
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:937:16: ( (lv_external_4_0= 'external' ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:938:1: (lv_external_4_0= 'external' )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:938:1: (lv_external_4_0= 'external' )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:939:3: lv_external_4_0= 'external'
            	    {
            	    lv_external_4_0=(Token)match(input,23,FOLLOW_23_in_ruleVariableDefinition2196); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_external_4_0, grammarAccess.getVariableDefinitionAccess().getExternalExternalKeyword_2_1_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getVariableDefinitionRule());
            	      	        }
            	             		setWithLastConsumed(current, "external", true, "external");
            	      	    
            	    }

            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2());

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

            getUnorderedGroupHelper().leave(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2());

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:966:2: ( (lv_name_5_0= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:967:1: (lv_name_5_0= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:967:1: (lv_name_5_0= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:968:3: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableDefinition2266); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_5_0, grammarAccess.getVariableDefinitionAccess().getNameIDTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getVariableDefinitionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_5_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleVariableDefinition2283); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getVariableDefinitionAccess().getColonKeyword_4());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:988:1: ( (lv_type_7_0= ruleType ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:989:1: (lv_type_7_0= ruleType )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:989:1: (lv_type_7_0= ruleType )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:990:3: lv_type_7_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getTypeTypeEnumRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleVariableDefinition2304);
            lv_type_7_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariableDefinitionRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_7_0, 
                      		"Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1006:2: (otherlv_8= '=' ( (lv_initialValue_9_0= ruleLiteral ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==20) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1006:4: otherlv_8= '=' ( (lv_initialValue_9_0= ruleLiteral ) )
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleVariableDefinition2317); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getVariableDefinitionAccess().getEqualsSignKeyword_6_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1010:1: ( (lv_initialValue_9_0= ruleLiteral ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1011:1: (lv_initialValue_9_0= ruleLiteral )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1011:1: (lv_initialValue_9_0= ruleLiteral )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1012:3: lv_initialValue_9_0= ruleLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getInitialValueLiteralParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLiteral_in_ruleVariableDefinition2338);
                    lv_initialValue_9_0=ruleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVariableDefinitionRule());
                      	        }
                             		set(
                             			current, 
                             			"initialValue",
                              		lv_initialValue_9_0, 
                              		"Literal");
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
    // $ANTLR end "ruleVariableDefinition"


    // $ANTLR start "entryRuleClock"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1036:1: entryRuleClock returns [EObject current=null] : iv_ruleClock= ruleClock EOF ;
    public final EObject entryRuleClock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClock = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1037:2: (iv_ruleClock= ruleClock EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1038:2: iv_ruleClock= ruleClock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClockRule()); 
            }
            pushFollow(FOLLOW_ruleClock_in_entryRuleClock2376);
            iv_ruleClock=ruleClock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClock2386); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClock"


    // $ANTLR start "ruleClock"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1045:1: ruleClock returns [EObject current=null] : ( () otherlv_1= 'clock' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleClock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1048:28: ( ( () otherlv_1= 'clock' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1049:1: ( () otherlv_1= 'clock' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1049:1: ( () otherlv_1= 'clock' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1049:2: () otherlv_1= 'clock' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1049:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1050:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getClockAccess().getClockAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleClock2432); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getClockAccess().getClockKeyword_1());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1059:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1060:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1060:1: (lv_name_2_0= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1061:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClock2449); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getClockAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getClockRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"ID");
              	    
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
    // $ANTLR end "ruleClock"


    // $ANTLR start "entryRuleOperation"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1085:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1086:2: (iv_ruleOperation= ruleOperation EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1087:2: iv_ruleOperation= ruleOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationRule()); 
            }
            pushFollow(FOLLOW_ruleOperation_in_entryRuleOperation2490);
            iv_ruleOperation=ruleOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperation2500); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperation"


    // $ANTLR start "ruleOperation"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1094:1: ruleOperation returns [EObject current=null] : ( () otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_paramTypes_4_0= ruleType ) ) (otherlv_5= ',' ( (lv_paramTypes_6_0= ruleType ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( (lv_type_9_0= ruleType ) ) )? ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Enumerator lv_paramTypes_4_0 = null;

        Enumerator lv_paramTypes_6_0 = null;

        Enumerator lv_type_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1097:28: ( ( () otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_paramTypes_4_0= ruleType ) ) (otherlv_5= ',' ( (lv_paramTypes_6_0= ruleType ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( (lv_type_9_0= ruleType ) ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1098:1: ( () otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_paramTypes_4_0= ruleType ) ) (otherlv_5= ',' ( (lv_paramTypes_6_0= ruleType ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( (lv_type_9_0= ruleType ) ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1098:1: ( () otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_paramTypes_4_0= ruleType ) ) (otherlv_5= ',' ( (lv_paramTypes_6_0= ruleType ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( (lv_type_9_0= ruleType ) ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1098:2: () otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_paramTypes_4_0= ruleType ) ) (otherlv_5= ',' ( (lv_paramTypes_6_0= ruleType ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( (lv_type_9_0= ruleType ) ) )?
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1098:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1099:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getOperationAccess().getOperationAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleOperation2546); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOperationAccess().getOperationKeyword_1());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1108:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1109:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1109:1: (lv_name_2_0= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1110:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOperation2563); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getOperationRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleOperation2580); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_3());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1130:1: ( ( (lv_paramTypes_4_0= ruleType ) ) (otherlv_5= ',' ( (lv_paramTypes_6_0= ruleType ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=61 && LA17_0<=65)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1130:2: ( (lv_paramTypes_4_0= ruleType ) ) (otherlv_5= ',' ( (lv_paramTypes_6_0= ruleType ) ) )*
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1130:2: ( (lv_paramTypes_4_0= ruleType ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1131:1: (lv_paramTypes_4_0= ruleType )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1131:1: (lv_paramTypes_4_0= ruleType )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1132:3: lv_paramTypes_4_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOperationAccess().getParamTypesTypeEnumRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleOperation2602);
                    lv_paramTypes_4_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOperationRule());
                      	        }
                             		add(
                             			current, 
                             			"paramTypes",
                              		lv_paramTypes_4_0, 
                              		"Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1148:2: (otherlv_5= ',' ( (lv_paramTypes_6_0= ruleType ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==27) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1148:4: otherlv_5= ',' ( (lv_paramTypes_6_0= ruleType ) )
                    	    {
                    	    otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleOperation2615); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getOperationAccess().getCommaKeyword_4_1_0());
                    	          
                    	    }
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1152:1: ( (lv_paramTypes_6_0= ruleType ) )
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1153:1: (lv_paramTypes_6_0= ruleType )
                    	    {
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1153:1: (lv_paramTypes_6_0= ruleType )
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1154:3: lv_paramTypes_6_0= ruleType
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationAccess().getParamTypesTypeEnumRuleCall_4_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleType_in_ruleOperation2636);
                    	    lv_paramTypes_6_0=ruleType();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getOperationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"paramTypes",
                    	              		lv_paramTypes_6_0, 
                    	              		"Type");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

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

            otherlv_7=(Token)match(input,28,FOLLOW_28_in_ruleOperation2652); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getOperationAccess().getRightParenthesisKeyword_5());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1174:1: (otherlv_8= ':' ( (lv_type_9_0= ruleType ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==17) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1174:3: otherlv_8= ':' ( (lv_type_9_0= ruleType ) )
                    {
                    otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleOperation2665); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getOperationAccess().getColonKeyword_6_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1178:1: ( (lv_type_9_0= ruleType ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1179:1: (lv_type_9_0= ruleType )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1179:1: (lv_type_9_0= ruleType )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1180:3: lv_type_9_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOperationAccess().getTypeTypeEnumRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleOperation2686);
                    lv_type_9_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOperationRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_9_0, 
                              		"Type");
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
    // $ANTLR end "ruleOperation"


    // $ANTLR start "entryRuleEntrypoint"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1204:1: entryRuleEntrypoint returns [EObject current=null] : iv_ruleEntrypoint= ruleEntrypoint EOF ;
    public final EObject entryRuleEntrypoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntrypoint = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1205:2: (iv_ruleEntrypoint= ruleEntrypoint EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1206:2: iv_ruleEntrypoint= ruleEntrypoint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEntrypointRule()); 
            }
            pushFollow(FOLLOW_ruleEntrypoint_in_entryRuleEntrypoint2724);
            iv_ruleEntrypoint=ruleEntrypoint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEntrypoint; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntrypoint2734); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntrypoint"


    // $ANTLR start "ruleEntrypoint"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1213:1: ruleEntrypoint returns [EObject current=null] : ( () otherlv_1= 'entrypoint' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleEntrypoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1216:28: ( ( () otherlv_1= 'entrypoint' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1217:1: ( () otherlv_1= 'entrypoint' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1217:1: ( () otherlv_1= 'entrypoint' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1217:2: () otherlv_1= 'entrypoint' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1217:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1218:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEntrypointAccess().getEntrypointAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleEntrypoint2780); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEntrypointAccess().getEntrypointKeyword_1());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1227:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1228:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1228:1: (lv_name_2_0= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1229:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntrypoint2797); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getEntrypointAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEntrypointRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"ID");
              	    
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
    // $ANTLR end "ruleEntrypoint"


    // $ANTLR start "entryRuleExitpoint"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1253:1: entryRuleExitpoint returns [EObject current=null] : iv_ruleExitpoint= ruleExitpoint EOF ;
    public final EObject entryRuleExitpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitpoint = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1254:2: (iv_ruleExitpoint= ruleExitpoint EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1255:2: iv_ruleExitpoint= ruleExitpoint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExitpointRule()); 
            }
            pushFollow(FOLLOW_ruleExitpoint_in_entryRuleExitpoint2838);
            iv_ruleExitpoint=ruleExitpoint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExitpoint; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitpoint2848); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExitpoint"


    // $ANTLR start "ruleExitpoint"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1262:1: ruleExitpoint returns [EObject current=null] : ( () otherlv_1= 'exitpoint' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleExitpoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1265:28: ( ( () otherlv_1= 'exitpoint' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1266:1: ( () otherlv_1= 'exitpoint' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1266:1: ( () otherlv_1= 'exitpoint' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1266:2: () otherlv_1= 'exitpoint' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1266:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1267:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getExitpointAccess().getExitpointAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleExitpoint2894); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getExitpointAccess().getExitpointKeyword_1());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1276:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1277:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1277:1: (lv_name_2_0= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1278:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExitpoint2911); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getExitpointAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getExitpointRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"ID");
              	    
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
    // $ANTLR end "ruleExitpoint"


    // $ANTLR start "entryRuleLocalReaction"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1304:1: entryRuleLocalReaction returns [EObject current=null] : iv_ruleLocalReaction= ruleLocalReaction EOF ;
    public final EObject entryRuleLocalReaction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalReaction = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1305:2: (iv_ruleLocalReaction= ruleLocalReaction EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1306:2: iv_ruleLocalReaction= ruleLocalReaction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLocalReactionRule()); 
            }
            pushFollow(FOLLOW_ruleLocalReaction_in_entryRuleLocalReaction2954);
            iv_ruleLocalReaction=ruleLocalReaction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLocalReaction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocalReaction2964); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocalReaction"


    // $ANTLR start "ruleLocalReaction"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1313:1: ruleLocalReaction returns [EObject current=null] : ( ( (lv_trigger_0_0= ruleReactionTrigger ) ) (otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) ) )? (otherlv_3= '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )? ) ;
    public final EObject ruleLocalReaction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_trigger_0_0 = null;

        EObject lv_effect_2_0 = null;

        EObject lv_properties_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1316:28: ( ( ( (lv_trigger_0_0= ruleReactionTrigger ) ) (otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) ) )? (otherlv_3= '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1317:1: ( ( (lv_trigger_0_0= ruleReactionTrigger ) ) (otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) ) )? (otherlv_3= '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1317:1: ( ( (lv_trigger_0_0= ruleReactionTrigger ) ) (otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) ) )? (otherlv_3= '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1317:2: ( (lv_trigger_0_0= ruleReactionTrigger ) ) (otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) ) )? (otherlv_3= '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )?
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1317:2: ( (lv_trigger_0_0= ruleReactionTrigger ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1318:1: (lv_trigger_0_0= ruleReactionTrigger )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1318:1: (lv_trigger_0_0= ruleReactionTrigger )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1319:3: lv_trigger_0_0= ruleReactionTrigger
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLocalReactionAccess().getTriggerReactionTriggerParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleReactionTrigger_in_ruleLocalReaction3010);
            lv_trigger_0_0=ruleReactionTrigger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLocalReactionRule());
              	        }
                     		set(
                     			current, 
                     			"trigger",
                      		lv_trigger_0_0, 
                      		"ReactionTrigger");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1335:2: (otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==31) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1335:4: otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) )
                    {
                    otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleLocalReaction3023); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getLocalReactionAccess().getSolidusKeyword_1_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1339:1: ( (lv_effect_2_0= ruleReactionEffect ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1340:1: (lv_effect_2_0= ruleReactionEffect )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1340:1: (lv_effect_2_0= ruleReactionEffect )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1341:3: lv_effect_2_0= ruleReactionEffect
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLocalReactionAccess().getEffectReactionEffectParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleReactionEffect_in_ruleLocalReaction3044);
                    lv_effect_2_0=ruleReactionEffect();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLocalReactionRule());
                      	        }
                             		set(
                             			current, 
                             			"effect",
                              		lv_effect_2_0, 
                              		"ReactionEffect");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1357:4: (otherlv_3= '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==32) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1357:6: otherlv_3= '#' ( (lv_properties_4_0= ruleReactionProperties ) )
                    {
                    otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleLocalReaction3059); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getLocalReactionAccess().getNumberSignKeyword_2_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1361:1: ( (lv_properties_4_0= ruleReactionProperties ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1362:1: (lv_properties_4_0= ruleReactionProperties )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1362:1: (lv_properties_4_0= ruleReactionProperties )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1363:3: lv_properties_4_0= ruleReactionProperties
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLocalReactionAccess().getPropertiesReactionPropertiesParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleReactionProperties_in_ruleLocalReaction3080);
                    lv_properties_4_0=ruleReactionProperties();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLocalReactionRule());
                      	        }
                             		set(
                             			current, 
                             			"properties",
                              		lv_properties_4_0, 
                              		"ReactionProperties");
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
    // $ANTLR end "ruleLocalReaction"


    // $ANTLR start "entryRuleTransitionReaction"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1387:1: entryRuleTransitionReaction returns [EObject current=null] : iv_ruleTransitionReaction= ruleTransitionReaction EOF ;
    public final EObject entryRuleTransitionReaction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionReaction = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1388:2: (iv_ruleTransitionReaction= ruleTransitionReaction EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1389:2: iv_ruleTransitionReaction= ruleTransitionReaction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransitionReactionRule()); 
            }
            pushFollow(FOLLOW_ruleTransitionReaction_in_entryRuleTransitionReaction3118);
            iv_ruleTransitionReaction=ruleTransitionReaction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransitionReaction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionReaction3128); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransitionReaction"


    // $ANTLR start "ruleTransitionReaction"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1396:1: ruleTransitionReaction returns [EObject current=null] : ( () ( (lv_trigger_1_0= ruleReactionTrigger ) )? (otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) ) )? (otherlv_4= '#' ( (lv_properties_5_0= ruleReactionProperties ) ) )? ) ;
    public final EObject ruleTransitionReaction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_trigger_1_0 = null;

        EObject lv_effect_3_0 = null;

        EObject lv_properties_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1399:28: ( ( () ( (lv_trigger_1_0= ruleReactionTrigger ) )? (otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) ) )? (otherlv_4= '#' ( (lv_properties_5_0= ruleReactionProperties ) ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1400:1: ( () ( (lv_trigger_1_0= ruleReactionTrigger ) )? (otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) ) )? (otherlv_4= '#' ( (lv_properties_5_0= ruleReactionProperties ) ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1400:1: ( () ( (lv_trigger_1_0= ruleReactionTrigger ) )? (otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) ) )? (otherlv_4= '#' ( (lv_properties_5_0= ruleReactionProperties ) ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1400:2: () ( (lv_trigger_1_0= ruleReactionTrigger ) )? (otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) ) )? (otherlv_4= '#' ( (lv_properties_5_0= ruleReactionProperties ) ) )?
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1400:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1401:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getTransitionReactionAccess().getTransitionReactionAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1406:2: ( (lv_trigger_1_0= ruleReactionTrigger ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID||LA21_0==33||(LA21_0>=37 && LA21_0<=41)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1407:1: (lv_trigger_1_0= ruleReactionTrigger )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1407:1: (lv_trigger_1_0= ruleReactionTrigger )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1408:3: lv_trigger_1_0= ruleReactionTrigger
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTransitionReactionAccess().getTriggerReactionTriggerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleReactionTrigger_in_ruleTransitionReaction3183);
                    lv_trigger_1_0=ruleReactionTrigger();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTransitionReactionRule());
                      	        }
                             		set(
                             			current, 
                             			"trigger",
                              		lv_trigger_1_0, 
                              		"ReactionTrigger");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1424:3: (otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==31) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1424:5: otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) )
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleTransitionReaction3197); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTransitionReactionAccess().getSolidusKeyword_2_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1428:1: ( (lv_effect_3_0= ruleReactionEffect ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1429:1: (lv_effect_3_0= ruleReactionEffect )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1429:1: (lv_effect_3_0= ruleReactionEffect )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1430:3: lv_effect_3_0= ruleReactionEffect
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTransitionReactionAccess().getEffectReactionEffectParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleReactionEffect_in_ruleTransitionReaction3218);
                    lv_effect_3_0=ruleReactionEffect();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTransitionReactionRule());
                      	        }
                             		set(
                             			current, 
                             			"effect",
                              		lv_effect_3_0, 
                              		"ReactionEffect");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1446:4: (otherlv_4= '#' ( (lv_properties_5_0= ruleReactionProperties ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==32) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1446:6: otherlv_4= '#' ( (lv_properties_5_0= ruleReactionProperties ) )
                    {
                    otherlv_4=(Token)match(input,32,FOLLOW_32_in_ruleTransitionReaction3233); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getTransitionReactionAccess().getNumberSignKeyword_3_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1450:1: ( (lv_properties_5_0= ruleReactionProperties ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1451:1: (lv_properties_5_0= ruleReactionProperties )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1451:1: (lv_properties_5_0= ruleReactionProperties )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1452:3: lv_properties_5_0= ruleReactionProperties
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTransitionReactionAccess().getPropertiesReactionPropertiesParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleReactionProperties_in_ruleTransitionReaction3254);
                    lv_properties_5_0=ruleReactionProperties();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTransitionReactionRule());
                      	        }
                             		set(
                             			current, 
                             			"properties",
                              		lv_properties_5_0, 
                              		"ReactionProperties");
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
    // $ANTLR end "ruleTransitionReaction"


    // $ANTLR start "entryRuleReactionTrigger"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1476:1: entryRuleReactionTrigger returns [EObject current=null] : iv_ruleReactionTrigger= ruleReactionTrigger EOF ;
    public final EObject entryRuleReactionTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReactionTrigger = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1477:2: (iv_ruleReactionTrigger= ruleReactionTrigger EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1478:2: iv_ruleReactionTrigger= ruleReactionTrigger EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReactionTriggerRule()); 
            }
            pushFollow(FOLLOW_ruleReactionTrigger_in_entryRuleReactionTrigger3292);
            iv_ruleReactionTrigger=ruleReactionTrigger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReactionTrigger; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReactionTrigger3302); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReactionTrigger"


    // $ANTLR start "ruleReactionTrigger"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1485:1: ruleReactionTrigger returns [EObject current=null] : ( () ( ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )? ) | (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ) ;
    public final EObject ruleReactionTrigger() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_triggers_1_0 = null;

        EObject lv_triggers_3_0 = null;

        EObject lv_guardExpression_5_0 = null;

        EObject lv_guardExpression_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1488:28: ( ( () ( ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )? ) | (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1489:1: ( () ( ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )? ) | (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1489:1: ( () ( ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )? ) | (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1489:2: () ( ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )? ) | (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1489:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1490:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getReactionTriggerAccess().getReactionTriggerAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1495:2: ( ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )? ) | (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID||(LA26_0>=37 && LA26_0<=41)) ) {
                alt26=1;
            }
            else if ( (LA26_0==33) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1495:3: ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )? )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1495:3: ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )? )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1495:4: ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )?
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1495:4: ( (lv_triggers_1_0= ruleEventSpec ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1496:1: (lv_triggers_1_0= ruleEventSpec )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1496:1: (lv_triggers_1_0= ruleEventSpec )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1497:3: lv_triggers_1_0= ruleEventSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getReactionTriggerAccess().getTriggersEventSpecParserRuleCall_1_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEventSpec_in_ruleReactionTrigger3359);
                    lv_triggers_1_0=ruleEventSpec();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getReactionTriggerRule());
                      	        }
                             		add(
                             			current, 
                             			"triggers",
                              		lv_triggers_1_0, 
                              		"EventSpec");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1513:2: (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==27) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1513:4: otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) )
                    	    {
                    	    otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleReactionTrigger3372); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getReactionTriggerAccess().getCommaKeyword_1_0_1_0());
                    	          
                    	    }
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1517:1: ( (lv_triggers_3_0= ruleEventSpec ) )
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1518:1: (lv_triggers_3_0= ruleEventSpec )
                    	    {
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1518:1: (lv_triggers_3_0= ruleEventSpec )
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1519:3: lv_triggers_3_0= ruleEventSpec
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getReactionTriggerAccess().getTriggersEventSpecParserRuleCall_1_0_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleEventSpec_in_ruleReactionTrigger3393);
                    	    lv_triggers_3_0=ruleEventSpec();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getReactionTriggerRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"triggers",
                    	              		lv_triggers_3_0, 
                    	              		"EventSpec");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1535:4: ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )?
                    int alt25=2;
                    alt25 = dfa25.predict(input);
                    switch (alt25) {
                        case 1 :
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1535:5: ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']'
                            {
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1535:5: ( ( '[' )=>otherlv_4= '[' )
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1535:6: ( '[' )=>otherlv_4= '['
                            {
                            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleReactionTrigger3416); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getReactionTriggerAccess().getLeftSquareBracketKeyword_1_0_2_0());
                                  
                            }

                            }

                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1540:2: ( (lv_guardExpression_5_0= ruleExpression ) )
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1541:1: (lv_guardExpression_5_0= ruleExpression )
                            {
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1541:1: (lv_guardExpression_5_0= ruleExpression )
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1542:3: lv_guardExpression_5_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getReactionTriggerAccess().getGuardExpressionExpressionParserRuleCall_1_0_2_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExpression_in_ruleReactionTrigger3438);
                            lv_guardExpression_5_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getReactionTriggerRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"guardExpression",
                                      		lv_guardExpression_5_0, 
                                      		"Expression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            otherlv_6=(Token)match(input,34,FOLLOW_34_in_ruleReactionTrigger3450); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getReactionTriggerAccess().getRightSquareBracketKeyword_1_0_2_2());
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1563:6: (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1563:6: (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1563:8: otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']'
                    {
                    otherlv_7=(Token)match(input,33,FOLLOW_33_in_ruleReactionTrigger3472); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getReactionTriggerAccess().getLeftSquareBracketKeyword_1_1_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1567:1: ( (lv_guardExpression_8_0= ruleExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1568:1: (lv_guardExpression_8_0= ruleExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1568:1: (lv_guardExpression_8_0= ruleExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1569:3: lv_guardExpression_8_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getReactionTriggerAccess().getGuardExpressionExpressionParserRuleCall_1_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleReactionTrigger3493);
                    lv_guardExpression_8_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getReactionTriggerRule());
                      	        }
                             		set(
                             			current, 
                             			"guardExpression",
                              		lv_guardExpression_8_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_9=(Token)match(input,34,FOLLOW_34_in_ruleReactionTrigger3505); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getReactionTriggerAccess().getRightSquareBracketKeyword_1_1_2());
                          
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
    // $ANTLR end "ruleReactionTrigger"


    // $ANTLR start "entryRuleReactionEffect"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1597:1: entryRuleReactionEffect returns [EObject current=null] : iv_ruleReactionEffect= ruleReactionEffect EOF ;
    public final EObject entryRuleReactionEffect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReactionEffect = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1598:2: (iv_ruleReactionEffect= ruleReactionEffect EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1599:2: iv_ruleReactionEffect= ruleReactionEffect EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReactionEffectRule()); 
            }
            pushFollow(FOLLOW_ruleReactionEffect_in_entryRuleReactionEffect3543);
            iv_ruleReactionEffect=ruleReactionEffect();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReactionEffect; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReactionEffect3553); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReactionEffect"


    // $ANTLR start "ruleReactionEffect"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1606:1: ruleReactionEffect returns [EObject current=null] : ( () ( ( (lv_actions_1_0= ruleStatement ) ) otherlv_2= ';' )+ ) ;
    public final EObject ruleReactionEffect() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_actions_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1609:28: ( ( () ( ( (lv_actions_1_0= ruleStatement ) ) otherlv_2= ';' )+ ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1610:1: ( () ( ( (lv_actions_1_0= ruleStatement ) ) otherlv_2= ';' )+ )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1610:1: ( () ( ( (lv_actions_1_0= ruleStatement ) ) otherlv_2= ';' )+ )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1610:2: () ( ( (lv_actions_1_0= ruleStatement ) ) otherlv_2= ';' )+
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1610:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1611:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getReactionEffectAccess().getReactionEffectAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1616:2: ( ( (lv_actions_1_0= ruleStatement ) ) otherlv_2= ';' )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID) ) {
                    int LA27_2 = input.LA(2);

                    if ( (LA27_2==20||LA27_2==26) ) {
                        alt27=1;
                    }


                }
                else if ( (LA27_0==42) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1616:3: ( (lv_actions_1_0= ruleStatement ) ) otherlv_2= ';'
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1616:3: ( (lv_actions_1_0= ruleStatement ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1617:1: (lv_actions_1_0= ruleStatement )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1617:1: (lv_actions_1_0= ruleStatement )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1618:3: lv_actions_1_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getReactionEffectAccess().getActionsStatementParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleStatement_in_ruleReactionEffect3609);
            	    lv_actions_1_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getReactionEffectRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"actions",
            	              		lv_actions_1_0, 
            	              		"Statement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleReactionEffect3621); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getReactionEffectAccess().getSemicolonKeyword_1_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
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
    // $ANTLR end "ruleReactionEffect"


    // $ANTLR start "entryRuleReactionProperties"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1646:1: entryRuleReactionProperties returns [EObject current=null] : iv_ruleReactionProperties= ruleReactionProperties EOF ;
    public final EObject entryRuleReactionProperties() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReactionProperties = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1647:2: (iv_ruleReactionProperties= ruleReactionProperties EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1648:2: iv_ruleReactionProperties= ruleReactionProperties EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReactionPropertiesRule()); 
            }
            pushFollow(FOLLOW_ruleReactionProperties_in_entryRuleReactionProperties3659);
            iv_ruleReactionProperties=ruleReactionProperties();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReactionProperties; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReactionProperties3669); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReactionProperties"


    // $ANTLR start "ruleReactionProperties"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1655:1: ruleReactionProperties returns [EObject current=null] : ( () ( (lv_properties_1_0= ruleReactionProperty ) )* ) ;
    public final EObject ruleReactionProperties() throws RecognitionException {
        EObject current = null;

        EObject lv_properties_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1658:28: ( ( () ( (lv_properties_1_0= ruleReactionProperty ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1659:1: ( () ( (lv_properties_1_0= ruleReactionProperty ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1659:1: ( () ( (lv_properties_1_0= ruleReactionProperty ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1659:2: () ( (lv_properties_1_0= ruleReactionProperty ) )*
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1659:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1660:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getReactionPropertiesAccess().getReactionPropertiesAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1665:2: ( (lv_properties_1_0= ruleReactionProperty ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID) ) {
                    int LA28_2 = input.LA(2);

                    if ( (LA28_2==36) ) {
                        alt28=1;
                    }


                }
                else if ( (LA28_0==RULE_INT||LA28_0==36) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1666:1: (lv_properties_1_0= ruleReactionProperty )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1666:1: (lv_properties_1_0= ruleReactionProperty )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1667:3: lv_properties_1_0= ruleReactionProperty
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getReactionPropertiesAccess().getPropertiesReactionPropertyParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleReactionProperty_in_ruleReactionProperties3724);
            	    lv_properties_1_0=ruleReactionProperty();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getReactionPropertiesRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"properties",
            	              		lv_properties_1_0, 
            	              		"ReactionProperty");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // $ANTLR end "ruleReactionProperties"


    // $ANTLR start "entryRuleReactionProperty"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1691:1: entryRuleReactionProperty returns [EObject current=null] : iv_ruleReactionProperty= ruleReactionProperty EOF ;
    public final EObject entryRuleReactionProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReactionProperty = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1692:2: (iv_ruleReactionProperty= ruleReactionProperty EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1693:2: iv_ruleReactionProperty= ruleReactionProperty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReactionPropertyRule()); 
            }
            pushFollow(FOLLOW_ruleReactionProperty_in_entryRuleReactionProperty3761);
            iv_ruleReactionProperty=ruleReactionProperty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReactionProperty; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReactionProperty3771); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReactionProperty"


    // $ANTLR start "ruleReactionProperty"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1700:1: ruleReactionProperty returns [EObject current=null] : (this_ReactionPriority_0= ruleReactionPriority | this_EntryPointSpec_1= ruleEntryPointSpec | this_ExitPointSpec_2= ruleExitPointSpec ) ;
    public final EObject ruleReactionProperty() throws RecognitionException {
        EObject current = null;

        EObject this_ReactionPriority_0 = null;

        EObject this_EntryPointSpec_1 = null;

        EObject this_ExitPointSpec_2 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1703:28: ( (this_ReactionPriority_0= ruleReactionPriority | this_EntryPointSpec_1= ruleEntryPointSpec | this_ExitPointSpec_2= ruleExitPointSpec ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1704:1: (this_ReactionPriority_0= ruleReactionPriority | this_EntryPointSpec_1= ruleEntryPointSpec | this_ExitPointSpec_2= ruleExitPointSpec )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1704:1: (this_ReactionPriority_0= ruleReactionPriority | this_EntryPointSpec_1= ruleEntryPointSpec | this_ExitPointSpec_2= ruleExitPointSpec )
            int alt29=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt29=1;
                }
                break;
            case 36:
                {
                alt29=2;
                }
                break;
            case RULE_ID:
                {
                alt29=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1705:5: this_ReactionPriority_0= ruleReactionPriority
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getReactionPropertyAccess().getReactionPriorityParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleReactionPriority_in_ruleReactionProperty3818);
                    this_ReactionPriority_0=ruleReactionPriority();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ReactionPriority_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1715:5: this_EntryPointSpec_1= ruleEntryPointSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getReactionPropertyAccess().getEntryPointSpecParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEntryPointSpec_in_ruleReactionProperty3845);
                    this_EntryPointSpec_1=ruleEntryPointSpec();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_EntryPointSpec_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1725:5: this_ExitPointSpec_2= ruleExitPointSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getReactionPropertyAccess().getExitPointSpecParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExitPointSpec_in_ruleReactionProperty3872);
                    this_ExitPointSpec_2=ruleExitPointSpec();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ExitPointSpec_2; 
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
    // $ANTLR end "ruleReactionProperty"


    // $ANTLR start "entryRuleReactionPriority"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1741:1: entryRuleReactionPriority returns [EObject current=null] : iv_ruleReactionPriority= ruleReactionPriority EOF ;
    public final EObject entryRuleReactionPriority() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReactionPriority = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1742:2: (iv_ruleReactionPriority= ruleReactionPriority EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1743:2: iv_ruleReactionPriority= ruleReactionPriority EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReactionPriorityRule()); 
            }
            pushFollow(FOLLOW_ruleReactionPriority_in_entryRuleReactionPriority3907);
            iv_ruleReactionPriority=ruleReactionPriority();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReactionPriority; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReactionPriority3917); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReactionPriority"


    // $ANTLR start "ruleReactionPriority"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1750:1: ruleReactionPriority returns [EObject current=null] : ( (lv_priority_0_0= RULE_INT ) ) ;
    public final EObject ruleReactionPriority() throws RecognitionException {
        EObject current = null;

        Token lv_priority_0_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1753:28: ( ( (lv_priority_0_0= RULE_INT ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1754:1: ( (lv_priority_0_0= RULE_INT ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1754:1: ( (lv_priority_0_0= RULE_INT ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1755:1: (lv_priority_0_0= RULE_INT )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1755:1: (lv_priority_0_0= RULE_INT )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1756:3: lv_priority_0_0= RULE_INT
            {
            lv_priority_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleReactionPriority3958); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_priority_0_0, grammarAccess.getReactionPriorityAccess().getPriorityINTTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getReactionPriorityRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"priority",
                      		lv_priority_0_0, 
                      		"INT");
              	    
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
    // $ANTLR end "ruleReactionPriority"


    // $ANTLR start "entryRuleEntryPointSpec"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1780:1: entryRuleEntryPointSpec returns [EObject current=null] : iv_ruleEntryPointSpec= ruleEntryPointSpec EOF ;
    public final EObject entryRuleEntryPointSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryPointSpec = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1781:2: (iv_ruleEntryPointSpec= ruleEntryPointSpec EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1782:2: iv_ruleEntryPointSpec= ruleEntryPointSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEntryPointSpecRule()); 
            }
            pushFollow(FOLLOW_ruleEntryPointSpec_in_entryRuleEntryPointSpec3998);
            iv_ruleEntryPointSpec=ruleEntryPointSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEntryPointSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryPointSpec4008); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntryPointSpec"


    // $ANTLR start "ruleEntryPointSpec"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1789:1: ruleEntryPointSpec returns [EObject current=null] : (otherlv_0= '>' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleEntryPointSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1792:28: ( (otherlv_0= '>' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1793:1: (otherlv_0= '>' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1793:1: (otherlv_0= '>' ( (otherlv_1= RULE_ID ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1793:3: otherlv_0= '>' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleEntryPointSpec4045); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEntryPointSpecAccess().getGreaterThanSignKeyword_0());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1797:1: ( (otherlv_1= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1798:1: (otherlv_1= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1798:1: (otherlv_1= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1799:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getEntryPointSpecRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntryPointSpec4065); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getEntryPointSpecAccess().getEntrypointEntrypointCrossReference_1_0()); 
              	
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
    // $ANTLR end "ruleEntryPointSpec"


    // $ANTLR start "entryRuleExitPointSpec"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1818:1: entryRuleExitPointSpec returns [EObject current=null] : iv_ruleExitPointSpec= ruleExitPointSpec EOF ;
    public final EObject entryRuleExitPointSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitPointSpec = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1819:2: (iv_ruleExitPointSpec= ruleExitPointSpec EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1820:2: iv_ruleExitPointSpec= ruleExitPointSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExitPointSpecRule()); 
            }
            pushFollow(FOLLOW_ruleExitPointSpec_in_entryRuleExitPointSpec4101);
            iv_ruleExitPointSpec=ruleExitPointSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExitPointSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitPointSpec4111); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExitPointSpec"


    // $ANTLR start "ruleExitPointSpec"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1827:1: ruleExitPointSpec returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '>' ) ;
    public final EObject ruleExitPointSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1830:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '>' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1831:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '>' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1831:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '>' )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1831:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '>'
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1831:2: ( (otherlv_0= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1832:1: (otherlv_0= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1832:1: (otherlv_0= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1833:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getExitPointSpecRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExitPointSpec4156); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getExitPointSpecAccess().getExitpointExitpointCrossReference_0_0()); 
              	
            }

            }


            }

            otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleExitPointSpec4168); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getExitPointSpecAccess().getGreaterThanSignKeyword_1());
                  
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
    // $ANTLR end "ruleExitPointSpec"


    // $ANTLR start "entryRuleEventSpec"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1856:1: entryRuleEventSpec returns [EObject current=null] : iv_ruleEventSpec= ruleEventSpec EOF ;
    public final EObject entryRuleEventSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventSpec = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1857:2: (iv_ruleEventSpec= ruleEventSpec EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1858:2: iv_ruleEventSpec= ruleEventSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventSpecRule()); 
            }
            pushFollow(FOLLOW_ruleEventSpec_in_entryRuleEventSpec4204);
            iv_ruleEventSpec=ruleEventSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventSpec4214); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEventSpec"


    // $ANTLR start "ruleEventSpec"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1865:1: ruleEventSpec returns [EObject current=null] : (this_RegularEventSpec_0= ruleRegularEventSpec | this_TimeEventSpec_1= ruleTimeEventSpec | this_BuiltinEventSpec_2= ruleBuiltinEventSpec ) ;
    public final EObject ruleEventSpec() throws RecognitionException {
        EObject current = null;

        EObject this_RegularEventSpec_0 = null;

        EObject this_TimeEventSpec_1 = null;

        EObject this_BuiltinEventSpec_2 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1868:28: ( (this_RegularEventSpec_0= ruleRegularEventSpec | this_TimeEventSpec_1= ruleTimeEventSpec | this_BuiltinEventSpec_2= ruleBuiltinEventSpec ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1869:1: (this_RegularEventSpec_0= ruleRegularEventSpec | this_TimeEventSpec_1= ruleTimeEventSpec | this_BuiltinEventSpec_2= ruleBuiltinEventSpec )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1869:1: (this_RegularEventSpec_0= ruleRegularEventSpec | this_TimeEventSpec_1= ruleTimeEventSpec | this_BuiltinEventSpec_2= ruleBuiltinEventSpec )
            int alt30=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt30=1;
                }
                break;
            case 37:
                {
                alt30=2;
                }
                break;
            case 38:
            case 39:
            case 40:
            case 41:
                {
                alt30=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1870:5: this_RegularEventSpec_0= ruleRegularEventSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEventSpecAccess().getRegularEventSpecParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRegularEventSpec_in_ruleEventSpec4261);
                    this_RegularEventSpec_0=ruleRegularEventSpec();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RegularEventSpec_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1880:5: this_TimeEventSpec_1= ruleTimeEventSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEventSpecAccess().getTimeEventSpecParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTimeEventSpec_in_ruleEventSpec4288);
                    this_TimeEventSpec_1=ruleTimeEventSpec();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TimeEventSpec_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1890:5: this_BuiltinEventSpec_2= ruleBuiltinEventSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEventSpecAccess().getBuiltinEventSpecParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBuiltinEventSpec_in_ruleEventSpec4315);
                    this_BuiltinEventSpec_2=ruleBuiltinEventSpec();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BuiltinEventSpec_2; 
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
    // $ANTLR end "ruleEventSpec"


    // $ANTLR start "entryRuleRegularEventSpec"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1906:1: entryRuleRegularEventSpec returns [EObject current=null] : iv_ruleRegularEventSpec= ruleRegularEventSpec EOF ;
    public final EObject entryRuleRegularEventSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegularEventSpec = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1907:2: (iv_ruleRegularEventSpec= ruleRegularEventSpec EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1908:2: iv_ruleRegularEventSpec= ruleRegularEventSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRegularEventSpecRule()); 
            }
            pushFollow(FOLLOW_ruleRegularEventSpec_in_entryRuleRegularEventSpec4350);
            iv_ruleRegularEventSpec=ruleRegularEventSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRegularEventSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRegularEventSpec4360); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegularEventSpec"


    // $ANTLR start "ruleRegularEventSpec"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1915:1: ruleRegularEventSpec returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleRegularEventSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1918:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1919:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1919:1: ( (otherlv_0= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1920:1: (otherlv_0= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1920:1: (otherlv_0= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1921:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getRegularEventSpecRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRegularEventSpec4404); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getRegularEventSpecAccess().getEventEventCrossReference_0()); 
              	
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
    // $ANTLR end "ruleRegularEventSpec"


    // $ANTLR start "entryRuleTimeEventSpec"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1940:1: entryRuleTimeEventSpec returns [EObject current=null] : iv_ruleTimeEventSpec= ruleTimeEventSpec EOF ;
    public final EObject entryRuleTimeEventSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeEventSpec = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1941:2: (iv_ruleTimeEventSpec= ruleTimeEventSpec EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1942:2: iv_ruleTimeEventSpec= ruleTimeEventSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTimeEventSpecRule()); 
            }
            pushFollow(FOLLOW_ruleTimeEventSpec_in_entryRuleTimeEventSpec4439);
            iv_ruleTimeEventSpec=ruleTimeEventSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTimeEventSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeEventSpec4449); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeEventSpec"


    // $ANTLR start "ruleTimeEventSpec"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1949:1: ruleTimeEventSpec returns [EObject current=null] : (otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleTimeUnit ) )? ) ;
    public final EObject ruleTimeEventSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Enumerator lv_unit_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1952:28: ( (otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleTimeUnit ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1953:1: (otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleTimeUnit ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1953:1: (otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleTimeUnit ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1953:3: otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleTimeUnit ) )?
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleTimeEventSpec4486); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTimeEventSpecAccess().getAfterKeyword_0());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1957:1: ( (lv_value_1_0= RULE_INT ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1958:1: (lv_value_1_0= RULE_INT )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1958:1: (lv_value_1_0= RULE_INT )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1959:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTimeEventSpec4503); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getTimeEventSpecAccess().getValueINTTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTimeEventSpecRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"INT");
              	    
            }

            }


            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1975:2: ( (lv_unit_2_0= ruleTimeUnit ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=58 && LA31_0<=60)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1976:1: (lv_unit_2_0= ruleTimeUnit )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1976:1: (lv_unit_2_0= ruleTimeUnit )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1977:3: lv_unit_2_0= ruleTimeUnit
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTimeEventSpecAccess().getUnitTimeUnitEnumRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTimeUnit_in_ruleTimeEventSpec4529);
                    lv_unit_2_0=ruleTimeUnit();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTimeEventSpecRule());
                      	        }
                             		set(
                             			current, 
                             			"unit",
                              		lv_unit_2_0, 
                              		"TimeUnit");
                      	        afterParserOrEnumRuleCall();
                      	    
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
    // $ANTLR end "ruleTimeEventSpec"


    // $ANTLR start "entryRuleBuiltinEventSpec"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2001:1: entryRuleBuiltinEventSpec returns [EObject current=null] : iv_ruleBuiltinEventSpec= ruleBuiltinEventSpec EOF ;
    public final EObject entryRuleBuiltinEventSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBuiltinEventSpec = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2002:2: (iv_ruleBuiltinEventSpec= ruleBuiltinEventSpec EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2003:2: iv_ruleBuiltinEventSpec= ruleBuiltinEventSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBuiltinEventSpecRule()); 
            }
            pushFollow(FOLLOW_ruleBuiltinEventSpec_in_entryRuleBuiltinEventSpec4566);
            iv_ruleBuiltinEventSpec=ruleBuiltinEventSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBuiltinEventSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBuiltinEventSpec4576); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBuiltinEventSpec"


    // $ANTLR start "ruleBuiltinEventSpec"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2010:1: ruleBuiltinEventSpec returns [EObject current=null] : (this_EntryEvent_0= ruleEntryEvent | this_ExitEvent_1= ruleExitEvent | this_OnCycleEvent_2= ruleOnCycleEvent | this_AlwaysEvent_3= ruleAlwaysEvent ) ;
    public final EObject ruleBuiltinEventSpec() throws RecognitionException {
        EObject current = null;

        EObject this_EntryEvent_0 = null;

        EObject this_ExitEvent_1 = null;

        EObject this_OnCycleEvent_2 = null;

        EObject this_AlwaysEvent_3 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2013:28: ( (this_EntryEvent_0= ruleEntryEvent | this_ExitEvent_1= ruleExitEvent | this_OnCycleEvent_2= ruleOnCycleEvent | this_AlwaysEvent_3= ruleAlwaysEvent ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2014:1: (this_EntryEvent_0= ruleEntryEvent | this_ExitEvent_1= ruleExitEvent | this_OnCycleEvent_2= ruleOnCycleEvent | this_AlwaysEvent_3= ruleAlwaysEvent )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2014:1: (this_EntryEvent_0= ruleEntryEvent | this_ExitEvent_1= ruleExitEvent | this_OnCycleEvent_2= ruleOnCycleEvent | this_AlwaysEvent_3= ruleAlwaysEvent )
            int alt32=4;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt32=1;
                }
                break;
            case 39:
                {
                alt32=2;
                }
                break;
            case 40:
                {
                alt32=3;
                }
                break;
            case 41:
                {
                alt32=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2015:5: this_EntryEvent_0= ruleEntryEvent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBuiltinEventSpecAccess().getEntryEventParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEntryEvent_in_ruleBuiltinEventSpec4623);
                    this_EntryEvent_0=ruleEntryEvent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_EntryEvent_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2025:5: this_ExitEvent_1= ruleExitEvent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBuiltinEventSpecAccess().getExitEventParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExitEvent_in_ruleBuiltinEventSpec4650);
                    this_ExitEvent_1=ruleExitEvent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ExitEvent_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2035:5: this_OnCycleEvent_2= ruleOnCycleEvent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBuiltinEventSpecAccess().getOnCycleEventParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOnCycleEvent_in_ruleBuiltinEventSpec4677);
                    this_OnCycleEvent_2=ruleOnCycleEvent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_OnCycleEvent_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2045:5: this_AlwaysEvent_3= ruleAlwaysEvent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBuiltinEventSpecAccess().getAlwaysEventParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAlwaysEvent_in_ruleBuiltinEventSpec4704);
                    this_AlwaysEvent_3=ruleAlwaysEvent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AlwaysEvent_3; 
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
    // $ANTLR end "ruleBuiltinEventSpec"


    // $ANTLR start "entryRuleEntryEvent"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2061:1: entryRuleEntryEvent returns [EObject current=null] : iv_ruleEntryEvent= ruleEntryEvent EOF ;
    public final EObject entryRuleEntryEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryEvent = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2062:2: (iv_ruleEntryEvent= ruleEntryEvent EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2063:2: iv_ruleEntryEvent= ruleEntryEvent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEntryEventRule()); 
            }
            pushFollow(FOLLOW_ruleEntryEvent_in_entryRuleEntryEvent4739);
            iv_ruleEntryEvent=ruleEntryEvent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEntryEvent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryEvent4749); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntryEvent"


    // $ANTLR start "ruleEntryEvent"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2070:1: ruleEntryEvent returns [EObject current=null] : ( () otherlv_1= 'entry' ) ;
    public final EObject ruleEntryEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2073:28: ( ( () otherlv_1= 'entry' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2074:1: ( () otherlv_1= 'entry' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2074:1: ( () otherlv_1= 'entry' )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2074:2: () otherlv_1= 'entry'
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2074:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2075:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEntryEventAccess().getEntryEventAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleEntryEvent4795); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEntryEventAccess().getEntryKeyword_1());
                  
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
    // $ANTLR end "ruleEntryEvent"


    // $ANTLR start "entryRuleExitEvent"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2092:1: entryRuleExitEvent returns [EObject current=null] : iv_ruleExitEvent= ruleExitEvent EOF ;
    public final EObject entryRuleExitEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitEvent = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2093:2: (iv_ruleExitEvent= ruleExitEvent EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2094:2: iv_ruleExitEvent= ruleExitEvent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExitEventRule()); 
            }
            pushFollow(FOLLOW_ruleExitEvent_in_entryRuleExitEvent4831);
            iv_ruleExitEvent=ruleExitEvent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExitEvent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitEvent4841); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExitEvent"


    // $ANTLR start "ruleExitEvent"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2101:1: ruleExitEvent returns [EObject current=null] : ( () otherlv_1= 'exit' ) ;
    public final EObject ruleExitEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2104:28: ( ( () otherlv_1= 'exit' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2105:1: ( () otherlv_1= 'exit' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2105:1: ( () otherlv_1= 'exit' )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2105:2: () otherlv_1= 'exit'
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2105:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2106:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getExitEventAccess().getExitEventAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleExitEvent4887); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getExitEventAccess().getExitKeyword_1());
                  
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
    // $ANTLR end "ruleExitEvent"


    // $ANTLR start "entryRuleOnCycleEvent"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2123:1: entryRuleOnCycleEvent returns [EObject current=null] : iv_ruleOnCycleEvent= ruleOnCycleEvent EOF ;
    public final EObject entryRuleOnCycleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOnCycleEvent = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2124:2: (iv_ruleOnCycleEvent= ruleOnCycleEvent EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2125:2: iv_ruleOnCycleEvent= ruleOnCycleEvent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOnCycleEventRule()); 
            }
            pushFollow(FOLLOW_ruleOnCycleEvent_in_entryRuleOnCycleEvent4923);
            iv_ruleOnCycleEvent=ruleOnCycleEvent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOnCycleEvent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOnCycleEvent4933); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOnCycleEvent"


    // $ANTLR start "ruleOnCycleEvent"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2132:1: ruleOnCycleEvent returns [EObject current=null] : ( () otherlv_1= 'oncycle' ) ;
    public final EObject ruleOnCycleEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2135:28: ( ( () otherlv_1= 'oncycle' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2136:1: ( () otherlv_1= 'oncycle' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2136:1: ( () otherlv_1= 'oncycle' )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2136:2: () otherlv_1= 'oncycle'
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2136:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2137:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getOnCycleEventAccess().getOnCycleEventAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,40,FOLLOW_40_in_ruleOnCycleEvent4979); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOnCycleEventAccess().getOncycleKeyword_1());
                  
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
    // $ANTLR end "ruleOnCycleEvent"


    // $ANTLR start "entryRuleAlwaysEvent"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2154:1: entryRuleAlwaysEvent returns [EObject current=null] : iv_ruleAlwaysEvent= ruleAlwaysEvent EOF ;
    public final EObject entryRuleAlwaysEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlwaysEvent = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2155:2: (iv_ruleAlwaysEvent= ruleAlwaysEvent EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2156:2: iv_ruleAlwaysEvent= ruleAlwaysEvent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAlwaysEventRule()); 
            }
            pushFollow(FOLLOW_ruleAlwaysEvent_in_entryRuleAlwaysEvent5015);
            iv_ruleAlwaysEvent=ruleAlwaysEvent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAlwaysEvent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlwaysEvent5025); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlwaysEvent"


    // $ANTLR start "ruleAlwaysEvent"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2163:1: ruleAlwaysEvent returns [EObject current=null] : ( () otherlv_1= 'always' ) ;
    public final EObject ruleAlwaysEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2166:28: ( ( () otherlv_1= 'always' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2167:1: ( () otherlv_1= 'always' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2167:1: ( () otherlv_1= 'always' )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2167:2: () otherlv_1= 'always'
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2167:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2168:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAlwaysEventAccess().getAlwaysEventAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleAlwaysEvent5071); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAlwaysEventAccess().getAlwaysKeyword_1());
                  
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
    // $ANTLR end "ruleAlwaysEvent"


    // $ANTLR start "entryRuleStatement"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2185:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2186:2: (iv_ruleStatement= ruleStatement EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2187:2: iv_ruleStatement= ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRule()); 
            }
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement5107);
            iv_ruleStatement=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement5117); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2194:1: ruleStatement returns [EObject current=null] : (this_Assignment_0= ruleAssignment | this_EventRaising_1= ruleEventRaising | this_OperationCall_2= ruleOperationCall ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Assignment_0 = null;

        EObject this_EventRaising_1 = null;

        EObject this_OperationCall_2 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2197:28: ( (this_Assignment_0= ruleAssignment | this_EventRaising_1= ruleEventRaising | this_OperationCall_2= ruleOperationCall ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2198:1: (this_Assignment_0= ruleAssignment | this_EventRaising_1= ruleEventRaising | this_OperationCall_2= ruleOperationCall )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2198:1: (this_Assignment_0= ruleAssignment | this_EventRaising_1= ruleEventRaising | this_OperationCall_2= ruleOperationCall )
            int alt33=3;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                int LA33_1 = input.LA(2);

                if ( (LA33_1==26) ) {
                    alt33=3;
                }
                else if ( (LA33_1==20) ) {
                    alt33=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA33_0==42) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2199:5: this_Assignment_0= ruleAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getAssignmentParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAssignment_in_ruleStatement5164);
                    this_Assignment_0=ruleAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Assignment_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2209:5: this_EventRaising_1= ruleEventRaising
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getEventRaisingParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEventRaising_in_ruleStatement5191);
                    this_EventRaising_1=ruleEventRaising();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_EventRaising_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2219:5: this_OperationCall_2= ruleOperationCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getOperationCallParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOperationCall_in_ruleStatement5218);
                    this_OperationCall_2=ruleOperationCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_OperationCall_2; 
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
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleAssignment"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2235:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2236:2: (iv_ruleAssignment= ruleAssignment EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2237:2: iv_ruleAssignment= ruleAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment5253);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment5263); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2244:1: ruleAssignment returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2247:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleExpression ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2248:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2248:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleExpression ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2248:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleExpression ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2248:2: ( (otherlv_0= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2249:1: (otherlv_0= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2249:1: (otherlv_0= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2250:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAssignmentRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment5308); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getAssignmentAccess().getVarRefVariableCrossReference_0_0()); 
              	
            }

            }


            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleAssignment5320); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2265:1: ( (lv_expression_2_0= ruleExpression ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2266:1: (lv_expression_2_0= ruleExpression )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2266:1: (lv_expression_2_0= ruleExpression )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2267:3: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentAccess().getExpressionExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleAssignment5341);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAssignmentRule());
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
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleEventRaising"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2291:1: entryRuleEventRaising returns [EObject current=null] : iv_ruleEventRaising= ruleEventRaising EOF ;
    public final EObject entryRuleEventRaising() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventRaising = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2292:2: (iv_ruleEventRaising= ruleEventRaising EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2293:2: iv_ruleEventRaising= ruleEventRaising EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventRaisingRule()); 
            }
            pushFollow(FOLLOW_ruleEventRaising_in_entryRuleEventRaising5377);
            iv_ruleEventRaising=ruleEventRaising();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventRaising; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventRaising5387); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEventRaising"


    // $ANTLR start "ruleEventRaising"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2300:1: ruleEventRaising returns [EObject current=null] : (otherlv_0= 'raise' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )? ) ;
    public final EObject ruleEventRaising() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2303:28: ( (otherlv_0= 'raise' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2304:1: (otherlv_0= 'raise' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2304:1: (otherlv_0= 'raise' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2304:3: otherlv_0= 'raise' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )?
            {
            otherlv_0=(Token)match(input,42,FOLLOW_42_in_ruleEventRaising5424); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEventRaisingAccess().getRaiseKeyword_0());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2308:1: ( (otherlv_1= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2309:1: (otherlv_1= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2309:1: (otherlv_1= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2310:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getEventRaisingRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEventRaising5444); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getEventRaisingAccess().getEventEventCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2321:2: (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==17) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2321:4: otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleEventRaising5457); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getEventRaisingAccess().getColonKeyword_2_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2325:1: ( (lv_value_3_0= ruleExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2326:1: (lv_value_3_0= ruleExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2326:1: (lv_value_3_0= ruleExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2327:3: lv_value_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEventRaisingAccess().getValueExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleEventRaising5478);
                    lv_value_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEventRaisingRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_3_0, 
                              		"Expression");
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
    // $ANTLR end "ruleEventRaising"


    // $ANTLR start "entryRuleExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2351:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2352:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2353:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression5516);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression5526); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2360:1: ruleExpression returns [EObject current=null] : this_LogicalOrExpression_0= ruleLogicalOrExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalOrExpression_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2363:28: (this_LogicalOrExpression_0= ruleLogicalOrExpression )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2365:5: this_LogicalOrExpression_0= ruleLogicalOrExpression
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExpressionAccess().getLogicalOrExpressionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleExpression5572);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_LogicalOrExpression_0; 
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


    // $ANTLR start "entryRuleLogicalOrExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2381:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2382:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2383:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression5606);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOrExpression5616); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2390:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LogicalAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2393:28: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2394:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2394:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2395:5: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5663);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_LogicalAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2403:1: ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==43) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2403:2: () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2403:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2404:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,43,FOLLOW_43_in_ruleLogicalOrExpression5684); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLogicalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_1());
            	          
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2413:1: ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2414:1: (lv_rightOperand_3_0= ruleLogicalAndExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2414:1: (lv_rightOperand_3_0= ruleLogicalAndExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2415:3: lv_rightOperand_3_0= ruleLogicalAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightOperandLogicalAndExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5705);
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
            	    break loop35;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2439:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2440:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2441:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression5743);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalAndExpression5753); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2448:1: ruleLogicalAndExpression returns [EObject current=null] : (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LogicalNotExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2451:28: ( (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2452:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2452:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2453:5: this_LogicalNotExpression_0= ruleLogicalNotExpression ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getLogicalNotExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression5800);
            this_LogicalNotExpression_0=ruleLogicalNotExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_LogicalNotExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2461:1: ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==44) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2461:2: () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2461:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2462:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleLogicalAndExpression5821); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLogicalAndExpressionAccess().getAmpersandAmpersandKeyword_1_1());
            	          
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2471:1: ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2472:1: (lv_rightOperand_3_0= ruleLogicalNotExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2472:1: (lv_rightOperand_3_0= ruleLogicalNotExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2473:3: lv_rightOperand_3_0= ruleLogicalNotExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightOperandLogicalNotExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression5842);
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
            	    break loop36;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2497:1: entryRuleLogicalNotExpression returns [EObject current=null] : iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF ;
    public final EObject entryRuleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalNotExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2498:2: (iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2499:2: iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalNotExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression5880);
            iv_ruleLogicalNotExpression=ruleLogicalNotExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalNotExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalNotExpression5890); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2506:1: ruleLogicalNotExpression returns [EObject current=null] : (this_LogicalRelationExpression_0= ruleLogicalRelationExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) ) ) ) ;
    public final EObject ruleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LogicalRelationExpression_0 = null;

        EObject lv_operand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2509:28: ( (this_LogicalRelationExpression_0= ruleLogicalRelationExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2510:1: (this_LogicalRelationExpression_0= ruleLogicalRelationExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2510:1: (this_LogicalRelationExpression_0= ruleLogicalRelationExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) ) ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=RULE_ID && LA37_0<=RULE_FLOAT)||LA37_0==26||(LA37_0>=48 && LA37_0<=49)||LA37_0==52) ) {
                alt37=1;
            }
            else if ( (LA37_0==45) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2511:5: this_LogicalRelationExpression_0= ruleLogicalRelationExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getLogicalRelationExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLogicalRelationExpression_in_ruleLogicalNotExpression5937);
                    this_LogicalRelationExpression_0=ruleLogicalRelationExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LogicalRelationExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2520:6: ( () otherlv_2= '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) ) )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2520:6: ( () otherlv_2= '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2520:7: () otherlv_2= '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2520:7: ()
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2521:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLogicalNotExpressionAccess().getLogicalNotExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,45,FOLLOW_45_in_ruleLogicalNotExpression5964); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getLogicalNotExpressionAccess().getExclamationMarkKeyword_1_1());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2530:1: ( (lv_operand_3_0= ruleLogicalRelationExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2531:1: (lv_operand_3_0= ruleLogicalRelationExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2531:1: (lv_operand_3_0= ruleLogicalRelationExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2532:3: lv_operand_3_0= ruleLogicalRelationExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getOperandLogicalRelationExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalRelationExpression_in_ruleLogicalNotExpression5985);
                    lv_operand_3_0=ruleLogicalRelationExpression();

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
                              		"LogicalRelationExpression");
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


    // $ANTLR start "entryRuleLogicalRelationExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2556:1: entryRuleLogicalRelationExpression returns [EObject current=null] : iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF ;
    public final EObject entryRuleLogicalRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalRelationExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2557:2: (iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2558:2: iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalRelationExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalRelationExpression_in_entryRuleLogicalRelationExpression6022);
            iv_ruleLogicalRelationExpression=ruleLogicalRelationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalRelationExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalRelationExpression6032); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2565:1: ruleLogicalRelationExpression returns [EObject current=null] : (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* ) ;
    public final EObject ruleLogicalRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalAddSubtractExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2568:28: ( (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2569:1: (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2569:1: (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2570:5: this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getNumericalAddSubtractExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_ruleLogicalRelationExpression6079);
            this_NumericalAddSubtractExpression_0=ruleNumericalAddSubtractExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_NumericalAddSubtractExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2578:1: ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==36||(LA38_0>=53 && LA38_0<=57)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2578:2: () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2578:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2579:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2584:2: ( (lv_operator_2_0= ruleRelationalOperator ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2585:1: (lv_operator_2_0= ruleRelationalOperator )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2585:1: (lv_operator_2_0= ruleRelationalOperator )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2586:3: lv_operator_2_0= ruleRelationalOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRelationalOperator_in_ruleLogicalRelationExpression6109);
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

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2602:2: ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2603:1: (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2603:1: (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2604:3: lv_rightOperand_3_0= ruleNumericalAddSubtractExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getRightOperandNumericalAddSubtractExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_ruleLogicalRelationExpression6130);
            	    lv_rightOperand_3_0=ruleNumericalAddSubtractExpression();

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
            	              		"NumericalAddSubtractExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

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


    // $ANTLR start "entryRuleNumericalAddSubtractExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2628:1: entryRuleNumericalAddSubtractExpression returns [EObject current=null] : iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF ;
    public final EObject entryRuleNumericalAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalAddSubtractExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2629:2: (iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2630:2: iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_entryRuleNumericalAddSubtractExpression6168);
            iv_ruleNumericalAddSubtractExpression=ruleNumericalAddSubtractExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericalAddSubtractExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalAddSubtractExpression6178); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2637:1: ruleNumericalAddSubtractExpression returns [EObject current=null] : (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* ) ;
    public final EObject ruleNumericalAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalMultiplyDivideExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2640:28: ( (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2641:1: (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2641:1: (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2642:5: this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalMultiplyDivideExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression6225);
            this_NumericalMultiplyDivideExpression_0=ruleNumericalMultiplyDivideExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_NumericalMultiplyDivideExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2650:1: ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=48 && LA39_0<=49)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2650:2: () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2650:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2651:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalAddSubtractExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2656:2: ( (lv_operator_2_0= ruleAdditiveOperator ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2657:1: (lv_operator_2_0= ruleAdditiveOperator )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2657:1: (lv_operator_2_0= ruleAdditiveOperator )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2658:3: lv_operator_2_0= ruleAdditiveOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getOperatorAdditiveOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleNumericalAddSubtractExpression6255);
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

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2674:2: ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2675:1: (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2675:1: (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2676:3: lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getRightOperandNumericalMultiplyDivideExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression6276);
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
            	    break loop39;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2700:1: entryRuleNumericalMultiplyDivideExpression returns [EObject current=null] : iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF ;
    public final EObject entryRuleNumericalMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalMultiplyDivideExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2701:2: (iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2702:2: iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_entryRuleNumericalMultiplyDivideExpression6314);
            iv_ruleNumericalMultiplyDivideExpression=ruleNumericalMultiplyDivideExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericalMultiplyDivideExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalMultiplyDivideExpression6324); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2709:1: ruleNumericalMultiplyDivideExpression returns [EObject current=null] : (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* ) ;
    public final EObject ruleNumericalMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalUnaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2712:28: ( (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2713:1: (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2713:1: (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2714:5: this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalUnaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression6371);
            this_NumericalUnaryExpression_0=ruleNumericalUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_NumericalUnaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2722:1: ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==31||(LA40_0>=50 && LA40_0<=51)) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2722:2: () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2722:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2723:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalMultiplyDivideExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2728:2: ( (lv_operator_2_0= ruleMultiplicativeOperator ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2729:1: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2729:1: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2730:3: lv_operator_2_0= ruleMultiplicativeOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getOperatorMultiplicativeOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleNumericalMultiplyDivideExpression6401);
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

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2746:2: ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2747:1: (lv_rightOperand_3_0= ruleNumericalUnaryExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2747:1: (lv_rightOperand_3_0= ruleNumericalUnaryExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2748:3: lv_rightOperand_3_0= ruleNumericalUnaryExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getRightOperandNumericalUnaryExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression6422);
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
            	    break loop40;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2772:1: entryRuleNumericalUnaryExpression returns [EObject current=null] : iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF ;
    public final EObject entryRuleNumericalUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalUnaryExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2773:2: (iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2774:2: iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_entryRuleNumericalUnaryExpression6460);
            iv_ruleNumericalUnaryExpression=ruleNumericalUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericalUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalUnaryExpression6470); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2781:1: ruleNumericalUnaryExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) ) ;
    public final EObject ruleNumericalUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_operand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2784:28: ( (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2785:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2785:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_ID && LA41_0<=RULE_FLOAT)||LA41_0==26) ) {
                alt41=1;
            }
            else if ( ((LA41_0>=48 && LA41_0<=49)||LA41_0==52) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2786:5: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression6517);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2795:6: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2795:6: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2795:7: () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2795:7: ()
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2796:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getNumericalUnaryExpressionAccess().getNumericalUnaryExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2801:2: ( (lv_operator_2_0= ruleUnaryOperator ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2802:1: (lv_operator_2_0= ruleUnaryOperator )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2802:1: (lv_operator_2_0= ruleUnaryOperator )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2803:3: lv_operator_2_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getOperatorUnaryOperatorEnumRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleNumericalUnaryExpression6553);
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

                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2819:2: ( (lv_operand_3_0= rulePrimaryExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2820:1: (lv_operand_3_0= rulePrimaryExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2820:1: (lv_operand_3_0= rulePrimaryExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2821:3: lv_operand_3_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression6574);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2845:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2846:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2847:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression6611);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression6621); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2854:1: rulePrimaryExpression returns [EObject current=null] : (this_ValueExpression_0= ruleValueExpression | (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' ) | this_OperationCall_4= ruleOperationCall ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_ValueExpression_0 = null;

        EObject this_Expression_2 = null;

        EObject this_OperationCall_4 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2857:28: ( (this_ValueExpression_0= ruleValueExpression | (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' ) | this_OperationCall_4= ruleOperationCall ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2858:1: (this_ValueExpression_0= ruleValueExpression | (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' ) | this_OperationCall_4= ruleOperationCall )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2858:1: (this_ValueExpression_0= ruleValueExpression | (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' ) | this_OperationCall_4= ruleOperationCall )
            int alt42=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case RULE_BOOL:
            case RULE_STRING:
            case RULE_FLOAT:
                {
                alt42=1;
                }
                break;
            case RULE_ID:
                {
                int LA42_2 = input.LA(2);

                if ( (LA42_2==EOF||LA42_2==RULE_ID||(LA42_2>=13 && LA42_2<=19)||LA42_2==21||(LA42_2>=24 && LA42_2<=25)||(LA42_2>=27 && LA42_2<=31)||(LA42_2>=33 && LA42_2<=41)||(LA42_2>=43 && LA42_2<=44)||(LA42_2>=46 && LA42_2<=51)||(LA42_2>=53 && LA42_2<=57)) ) {
                    alt42=1;
                }
                else if ( (LA42_2==26) ) {
                    alt42=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 2, input);

                    throw nvae;
                }
                }
                break;
            case 26:
                {
                alt42=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2859:5: this_ValueExpression_0= ruleValueExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getValueExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleValueExpression_in_rulePrimaryExpression6668);
                    this_ValueExpression_0=ruleValueExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ValueExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2868:6: (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2868:6: (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2868:8: otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,26,FOLLOW_26_in_rulePrimaryExpression6686); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExpression_in_rulePrimaryExpression6708);
                    this_Expression_2=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Expression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_3=(Token)match(input,28,FOLLOW_28_in_rulePrimaryExpression6719); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_1_2());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2887:5: this_OperationCall_4= ruleOperationCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getOperationCallParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOperationCall_in_rulePrimaryExpression6748);
                    this_OperationCall_4=ruleOperationCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_OperationCall_4; 
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


    // $ANTLR start "entryRuleValueExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2903:1: entryRuleValueExpression returns [EObject current=null] : iv_ruleValueExpression= ruleValueExpression EOF ;
    public final EObject entryRuleValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2904:2: (iv_ruleValueExpression= ruleValueExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2905:2: iv_ruleValueExpression= ruleValueExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleValueExpression_in_entryRuleValueExpression6783);
            iv_ruleValueExpression=ruleValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueExpression6793); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueExpression"


    // $ANTLR start "ruleValueExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2912:1: ruleValueExpression returns [EObject current=null] : (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_ElementReferenceExpression_1= ruleElementReferenceExpression ) ;
    public final EObject ruleValueExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveValueExpression_0 = null;

        EObject this_ElementReferenceExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2915:28: ( (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_ElementReferenceExpression_1= ruleElementReferenceExpression ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2916:1: (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_ElementReferenceExpression_1= ruleElementReferenceExpression )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2916:1: (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_ElementReferenceExpression_1= ruleElementReferenceExpression )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=RULE_INT && LA43_0<=RULE_FLOAT)) ) {
                alt43=1;
            }
            else if ( (LA43_0==RULE_ID) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2917:5: this_PrimitiveValueExpression_0= rulePrimitiveValueExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getValueExpressionAccess().getPrimitiveValueExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimitiveValueExpression_in_ruleValueExpression6840);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2927:5: this_ElementReferenceExpression_1= ruleElementReferenceExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getValueExpressionAccess().getElementReferenceExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleElementReferenceExpression_in_ruleValueExpression6867);
                    this_ElementReferenceExpression_1=ruleElementReferenceExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ElementReferenceExpression_1; 
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
    // $ANTLR end "ruleValueExpression"


    // $ANTLR start "entryRulePrimitiveValueExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2943:1: entryRulePrimitiveValueExpression returns [EObject current=null] : iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF ;
    public final EObject entryRulePrimitiveValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValueExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2944:2: (iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2945:2: iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveValueExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimitiveValueExpression_in_entryRulePrimitiveValueExpression6902);
            iv_rulePrimitiveValueExpression=rulePrimitiveValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveValueExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveValueExpression6912); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2952:1: rulePrimitiveValueExpression returns [EObject current=null] : ( () ( (lv_value_1_0= ruleLiteral ) ) ) ;
    public final EObject rulePrimitiveValueExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2955:28: ( ( () ( (lv_value_1_0= ruleLiteral ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2956:1: ( () ( (lv_value_1_0= ruleLiteral ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2956:1: ( () ( (lv_value_1_0= ruleLiteral ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2956:2: () ( (lv_value_1_0= ruleLiteral ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2956:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2957:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPrimitiveValueExpressionAccess().getPrimitiveValueExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2962:2: ( (lv_value_1_0= ruleLiteral ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2963:1: (lv_value_1_0= ruleLiteral )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2963:1: (lv_value_1_0= ruleLiteral )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2964:3: lv_value_1_0= ruleLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrimitiveValueExpressionAccess().getValueLiteralParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLiteral_in_rulePrimitiveValueExpression6967);
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


    // $ANTLR start "entryRuleElementReferenceExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2988:1: entryRuleElementReferenceExpression returns [EObject current=null] : iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF ;
    public final EObject entryRuleElementReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementReferenceExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2989:2: (iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2990:2: iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElementReferenceExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleElementReferenceExpression_in_entryRuleElementReferenceExpression7003);
            iv_ruleElementReferenceExpression=ruleElementReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElementReferenceExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleElementReferenceExpression7013); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2997:1: ruleElementReferenceExpression returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleElementReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3000:28: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3001:1: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3001:1: ( () ( (otherlv_1= RULE_ID ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3001:2: () ( (otherlv_1= RULE_ID ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3001:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3002:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getElementReferenceExpressionAccess().getElementReferenceExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3007:2: ( (otherlv_1= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3008:1: (otherlv_1= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3008:1: (otherlv_1= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3009:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getElementReferenceExpressionRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleElementReferenceExpression7067); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getElementReferenceExpressionAccess().getValueDeclarationCrossReference_1_0()); 
              	
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
    // $ANTLR end "ruleElementReferenceExpression"


    // $ANTLR start "entryRuleOperationCall"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3028:1: entryRuleOperationCall returns [EObject current=null] : iv_ruleOperationCall= ruleOperationCall EOF ;
    public final EObject entryRuleOperationCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCall = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3029:2: (iv_ruleOperationCall= ruleOperationCall EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3030:2: iv_ruleOperationCall= ruleOperationCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationCallRule()); 
            }
            pushFollow(FOLLOW_ruleOperationCall_in_entryRuleOperationCall7103);
            iv_ruleOperationCall=ruleOperationCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperationCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationCall7113); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperationCall"


    // $ANTLR start "ruleOperationCall"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3037:1: ruleOperationCall returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) ;
    public final EObject ruleOperationCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_args_3_0 = null;

        EObject lv_args_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3040:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3041:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3041:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3041:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3041:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3042:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getOperationCallAccess().getOperationCallAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3047:2: ( (otherlv_1= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3048:1: (otherlv_1= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3048:1: (otherlv_1= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3049:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getOperationCallRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOperationCall7167); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getOperationCallAccess().getOperationOperationCrossReference_1_0()); 
              	
            }

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleOperationCall7179); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOperationCallAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3064:1: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=RULE_ID && LA45_0<=RULE_FLOAT)||LA45_0==26||LA45_0==45||(LA45_0>=48 && LA45_0<=49)||LA45_0==52) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3064:2: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3064:2: ( (lv_args_3_0= ruleExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3065:1: (lv_args_3_0= ruleExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3065:1: (lv_args_3_0= ruleExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3066:3: lv_args_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOperationCallAccess().getArgsExpressionParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleOperationCall7201);
                    lv_args_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOperationCallRule());
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

                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3082:2: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==27) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3082:4: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,27,FOLLOW_27_in_ruleOperationCall7214); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getOperationCallAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3086:1: ( (lv_args_5_0= ruleExpression ) )
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3087:1: (lv_args_5_0= ruleExpression )
                    	    {
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3087:1: (lv_args_5_0= ruleExpression )
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3088:3: lv_args_5_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationCallAccess().getArgsExpressionParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleExpression_in_ruleOperationCall7235);
                    	    lv_args_5_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getOperationCallRule());
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
                    	    break loop44;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,28,FOLLOW_28_in_ruleOperationCall7251); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getOperationCallAccess().getRightParenthesisKeyword_4());
                  
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
    // $ANTLR end "ruleOperationCall"


    // $ANTLR start "entryRuleLiteral"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3116:1: entryRuleLiteral returns [String current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final String entryRuleLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteral = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3117:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3118:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral7288);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral7299); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3125:1: ruleLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BOOL_0= RULE_BOOL | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_FLOAT_3= RULE_FLOAT ) ;
    public final AntlrDatatypeRuleToken ruleLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOL_0=null;
        Token this_INT_1=null;
        Token this_STRING_2=null;
        Token this_FLOAT_3=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3128:28: ( (this_BOOL_0= RULE_BOOL | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_FLOAT_3= RULE_FLOAT ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3129:1: (this_BOOL_0= RULE_BOOL | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_FLOAT_3= RULE_FLOAT )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3129:1: (this_BOOL_0= RULE_BOOL | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_FLOAT_3= RULE_FLOAT )
            int alt46=4;
            switch ( input.LA(1) ) {
            case RULE_BOOL:
                {
                alt46=1;
                }
                break;
            case RULE_INT:
                {
                alt46=2;
                }
                break;
            case RULE_STRING:
                {
                alt46=3;
                }
                break;
            case RULE_FLOAT:
                {
                alt46=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3129:6: this_BOOL_0= RULE_BOOL
                    {
                    this_BOOL_0=(Token)match(input,RULE_BOOL,FOLLOW_RULE_BOOL_in_ruleLiteral7339); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BOOL_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BOOL_0, grammarAccess.getLiteralAccess().getBOOLTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3137:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLiteral7365); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_1, grammarAccess.getLiteralAccess().getINTTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3145:10: this_STRING_2= RULE_STRING
                    {
                    this_STRING_2=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLiteral7391); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_STRING_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_STRING_2, grammarAccess.getLiteralAccess().getSTRINGTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3153:10: this_FLOAT_3= RULE_FLOAT
                    {
                    this_FLOAT_3=(Token)match(input,RULE_FLOAT,FOLLOW_RULE_FLOAT_in_ruleLiteral7417); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_FLOAT_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_FLOAT_3, grammarAccess.getLiteralAccess().getFLOATTerminalRuleCall_3()); 
                          
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


    // $ANTLR start "ruleDirection"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3168:1: ruleDirection returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) ) ;
    public final Enumerator ruleDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3170:28: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3171:1: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3171:1: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==46) ) {
                alt47=1;
            }
            else if ( (LA47_0==47) ) {
                alt47=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3171:2: (enumLiteral_0= 'in' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3171:2: (enumLiteral_0= 'in' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3171:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,46,FOLLOW_46_in_ruleDirection7476); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getDirectionAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getDirectionAccess().getINEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3177:6: (enumLiteral_1= 'out' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3177:6: (enumLiteral_1= 'out' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3177:8: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,47,FOLLOW_47_in_ruleDirection7493); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getDirectionAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getDirectionAccess().getOUTEnumLiteralDeclaration_1()); 
                          
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
    // $ANTLR end "ruleDirection"


    // $ANTLR start "ruleAdditiveOperator"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3187:1: ruleAdditiveOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAdditiveOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3189:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3190:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3190:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==48) ) {
                alt48=1;
            }
            else if ( (LA48_0==49) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3190:2: (enumLiteral_0= '+' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3190:2: (enumLiteral_0= '+' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3190:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,48,FOLLOW_48_in_ruleAdditiveOperator7538); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3196:6: (enumLiteral_1= '-' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3196:6: (enumLiteral_1= '-' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3196:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,49,FOLLOW_49_in_ruleAdditiveOperator7555); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3206:1: ruleMultiplicativeOperator returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplicativeOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3208:28: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3209:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3209:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt49=3;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt49=1;
                }
                break;
            case 31:
                {
                alt49=2;
                }
                break;
            case 51:
                {
                alt49=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3209:2: (enumLiteral_0= '*' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3209:2: (enumLiteral_0= '*' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3209:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,50,FOLLOW_50_in_ruleMultiplicativeOperator7600); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3215:6: (enumLiteral_1= '/' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3215:6: (enumLiteral_1= '/' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3215:8: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,31,FOLLOW_31_in_ruleMultiplicativeOperator7617); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3221:6: (enumLiteral_2= '%' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3221:6: (enumLiteral_2= '%' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3221:8: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,51,FOLLOW_51_in_ruleMultiplicativeOperator7634); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3231:1: ruleUnaryOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3233:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3234:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3234:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) )
            int alt50=3;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt50=1;
                }
                break;
            case 49:
                {
                alt50=2;
                }
                break;
            case 52:
                {
                alt50=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3234:2: (enumLiteral_0= '+' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3234:2: (enumLiteral_0= '+' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3234:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,48,FOLLOW_48_in_ruleUnaryOperator7679); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3240:6: (enumLiteral_1= '-' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3240:6: (enumLiteral_1= '-' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3240:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,49,FOLLOW_49_in_ruleUnaryOperator7696); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3246:6: (enumLiteral_2= '~' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3246:6: (enumLiteral_2= '~' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3246:8: enumLiteral_2= '~'
                    {
                    enumLiteral_2=(Token)match(input,52,FOLLOW_52_in_ruleUnaryOperator7713); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3256:1: ruleRelationalOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) ) ;
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
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3258:28: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3259:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3259:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) )
            int alt51=6;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt51=1;
                }
                break;
            case 54:
                {
                alt51=2;
                }
                break;
            case 36:
                {
                alt51=3;
                }
                break;
            case 55:
                {
                alt51=4;
                }
                break;
            case 56:
                {
                alt51=5;
                }
                break;
            case 57:
                {
                alt51=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3259:2: (enumLiteral_0= '<' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3259:2: (enumLiteral_0= '<' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3259:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,53,FOLLOW_53_in_ruleRelationalOperator7758); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3265:6: (enumLiteral_1= '<=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3265:6: (enumLiteral_1= '<=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3265:8: enumLiteral_1= '<='
                    {
                    enumLiteral_1=(Token)match(input,54,FOLLOW_54_in_ruleRelationalOperator7775); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3271:6: (enumLiteral_2= '>' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3271:6: (enumLiteral_2= '>' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3271:8: enumLiteral_2= '>'
                    {
                    enumLiteral_2=(Token)match(input,36,FOLLOW_36_in_ruleRelationalOperator7792); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3277:6: (enumLiteral_3= '>=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3277:6: (enumLiteral_3= '>=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3277:8: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,55,FOLLOW_55_in_ruleRelationalOperator7809); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3283:6: (enumLiteral_4= '==' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3283:6: (enumLiteral_4= '==' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3283:8: enumLiteral_4= '=='
                    {
                    enumLiteral_4=(Token)match(input,56,FOLLOW_56_in_ruleRelationalOperator7826); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3289:6: (enumLiteral_5= '!=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3289:6: (enumLiteral_5= '!=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3289:8: enumLiteral_5= '!='
                    {
                    enumLiteral_5=(Token)match(input,57,FOLLOW_57_in_ruleRelationalOperator7843); if (state.failed) return current;
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


    // $ANTLR start "ruleTimeUnit"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3299:1: ruleTimeUnit returns [Enumerator current=null] : ( (enumLiteral_0= 's' ) | (enumLiteral_1= 'ms' ) | (enumLiteral_2= 'ns' ) ) ;
    public final Enumerator ruleTimeUnit() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3301:28: ( ( (enumLiteral_0= 's' ) | (enumLiteral_1= 'ms' ) | (enumLiteral_2= 'ns' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3302:1: ( (enumLiteral_0= 's' ) | (enumLiteral_1= 'ms' ) | (enumLiteral_2= 'ns' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3302:1: ( (enumLiteral_0= 's' ) | (enumLiteral_1= 'ms' ) | (enumLiteral_2= 'ns' ) )
            int alt52=3;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt52=1;
                }
                break;
            case 59:
                {
                alt52=2;
                }
                break;
            case 60:
                {
                alt52=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3302:2: (enumLiteral_0= 's' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3302:2: (enumLiteral_0= 's' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3302:4: enumLiteral_0= 's'
                    {
                    enumLiteral_0=(Token)match(input,58,FOLLOW_58_in_ruleTimeUnit7888); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getTimeUnitAccess().getSecondEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getTimeUnitAccess().getSecondEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3308:6: (enumLiteral_1= 'ms' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3308:6: (enumLiteral_1= 'ms' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3308:8: enumLiteral_1= 'ms'
                    {
                    enumLiteral_1=(Token)match(input,59,FOLLOW_59_in_ruleTimeUnit7905); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getTimeUnitAccess().getMillisecondEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getTimeUnitAccess().getMillisecondEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3314:6: (enumLiteral_2= 'ns' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3314:6: (enumLiteral_2= 'ns' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3314:8: enumLiteral_2= 'ns'
                    {
                    enumLiteral_2=(Token)match(input,60,FOLLOW_60_in_ruleTimeUnit7922); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getTimeUnitAccess().getNanosecondEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getTimeUnitAccess().getNanosecondEnumLiteralDeclaration_2()); 
                          
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
    // $ANTLR end "ruleTimeUnit"


    // $ANTLR start "ruleType"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3324:1: ruleType returns [Enumerator current=null] : ( (enumLiteral_0= 'void' ) | (enumLiteral_1= 'integer' ) | (enumLiteral_2= 'real' ) | (enumLiteral_3= 'boolean' ) | (enumLiteral_4= 'string' ) ) ;
    public final Enumerator ruleType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3326:28: ( ( (enumLiteral_0= 'void' ) | (enumLiteral_1= 'integer' ) | (enumLiteral_2= 'real' ) | (enumLiteral_3= 'boolean' ) | (enumLiteral_4= 'string' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3327:1: ( (enumLiteral_0= 'void' ) | (enumLiteral_1= 'integer' ) | (enumLiteral_2= 'real' ) | (enumLiteral_3= 'boolean' ) | (enumLiteral_4= 'string' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3327:1: ( (enumLiteral_0= 'void' ) | (enumLiteral_1= 'integer' ) | (enumLiteral_2= 'real' ) | (enumLiteral_3= 'boolean' ) | (enumLiteral_4= 'string' ) )
            int alt53=5;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt53=1;
                }
                break;
            case 62:
                {
                alt53=2;
                }
                break;
            case 63:
                {
                alt53=3;
                }
                break;
            case 64:
                {
                alt53=4;
                }
                break;
            case 65:
                {
                alt53=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3327:2: (enumLiteral_0= 'void' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3327:2: (enumLiteral_0= 'void' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3327:4: enumLiteral_0= 'void'
                    {
                    enumLiteral_0=(Token)match(input,61,FOLLOW_61_in_ruleType7967); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getTypeAccess().getVoidEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getTypeAccess().getVoidEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3333:6: (enumLiteral_1= 'integer' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3333:6: (enumLiteral_1= 'integer' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3333:8: enumLiteral_1= 'integer'
                    {
                    enumLiteral_1=(Token)match(input,62,FOLLOW_62_in_ruleType7984); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getTypeAccess().getIntegerEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getTypeAccess().getIntegerEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3339:6: (enumLiteral_2= 'real' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3339:6: (enumLiteral_2= 'real' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3339:8: enumLiteral_2= 'real'
                    {
                    enumLiteral_2=(Token)match(input,63,FOLLOW_63_in_ruleType8001); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getTypeAccess().getRealEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getTypeAccess().getRealEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3345:6: (enumLiteral_3= 'boolean' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3345:6: (enumLiteral_3= 'boolean' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3345:8: enumLiteral_3= 'boolean'
                    {
                    enumLiteral_3=(Token)match(input,64,FOLLOW_64_in_ruleType8018); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getTypeAccess().getBooleanEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getTypeAccess().getBooleanEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3351:6: (enumLiteral_4= 'string' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3351:6: (enumLiteral_4= 'string' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3351:8: enumLiteral_4= 'string'
                    {
                    enumLiteral_4=(Token)match(input,65,FOLLOW_65_in_ruleType8035); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getTypeAccess().getStringEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getTypeAccess().getStringEnumLiteralDeclaration_4()); 
                          
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
    // $ANTLR end "ruleType"

    // $ANTLR start synpred1_InternalSText
    public final void synpred1_InternalSText_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1535:6: ( '[' )
        // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1535:8: '['
        {
        match(input,33,FOLLOW_33_in_synpred1_InternalSText3408); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalSText

    // Delegated rules

    public final boolean synpred1_InternalSText() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalSText_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA25 dfa25 = new DFA25(this);
    static final String DFA25_eotS =
        "\31\uffff";
    static final String DFA25_eofS =
        "\1\2\30\uffff";
    static final String DFA25_minS =
        "\1\4\1\0\27\uffff";
    static final String DFA25_maxS =
        "\1\57\1\0\27\uffff";
    static final String DFA25_acceptS =
        "\2\uffff\1\2\25\uffff\1\1";
    static final String DFA25_specialS =
        "\1\uffff\1\0\27\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\2\10\uffff\4\2\1\uffff\2\2\1\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\4\2\1\1\3\uffff\5\2\4\uffff\2\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "1535:4: ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_1 = input.LA(1);

                         
                        int index25_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalSText()) ) {s = 24;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index25_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

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
    public static final BitSet FOLLOW_13_in_ruleStatechartRoot359 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_ruleStatechartDefinition_in_ruleStatechartRoot380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateRoot_in_entryRuleStateRoot416 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateRoot426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleStateRoot463 = new BitSet(new long[]{0x0000C3E263280010L});
    public static final BitSet FOLLOW_ruleStateDeclaration_in_ruleStateRoot484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionRoot_in_entryRuleTransitionRoot520 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionRoot530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleTransitionRoot567 = new BitSet(new long[]{0x000003E380000010L});
    public static final BitSet FOLLOW_ruleTransitionStatement_in_ruleTransitionRoot588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatechartDefinition_in_entryRuleStatechartDefinition624 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatechartDefinition634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatechartScope_in_ruleStatechartDefinition689 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleStateDeclaration_in_entryRuleStateDeclaration726 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateDeclaration736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleScope_in_ruleStateDeclaration781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionStatement_in_entryRuleTransitionStatement816 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionStatement826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionReaction_in_ruleTransitionStatement872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleScope_in_entryRuleSimpleScope908 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleScope918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleSimpleScope973 = new BitSet(new long[]{0x0000C3E263280012L});
    public static final BitSet FOLLOW_ruleStatechartScope_in_entryRuleStatechartScope1010 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatechartScope1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterfaceScope_in_ruleStatechartScope1067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInternalScope_in_ruleStatechartScope1094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterfaceScope_in_entryRuleInterfaceScope1129 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterfaceScope1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleInterfaceScope1185 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInterfaceScope1202 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleInterfaceScope1220 = new BitSet(new long[]{0x0000C3E263280012L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleInterfaceScope1241 = new BitSet(new long[]{0x0000C3E263280012L});
    public static final BitSet FOLLOW_ruleInternalScope_in_entryRuleInternalScope1278 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInternalScope1288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleInternalScope1334 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleInternalScope1346 = new BitSet(new long[]{0x0000C3E263280012L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleInternalScope1367 = new BitSet(new long[]{0x0000C3E263280012L});
    public static final BitSet FOLLOW_ruleDeclaration_in_entryRuleDeclaration1404 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclaration1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDefinition_in_ruleDeclaration1461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_ruleDeclaration1488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClock_in_ruleDeclaration1515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_ruleDeclaration1542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocalReaction_in_ruleDeclaration1569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntrypoint_in_ruleDeclaration1596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitpoint_in_ruleDeclaration1623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDefinition_in_entryRuleEventDefinition1658 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventDefinition1668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirection_in_ruleEventDefinition1723 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleEventDefinition1736 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEventDefinition1753 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_17_in_ruleEventDefinition1771 = new BitSet(new long[]{0xE000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleType_in_ruleEventDefinition1792 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleEventDerivation_in_ruleEventDefinition1815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDerivation_in_entryRuleEventDerivation1852 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventDerivation1862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleEventDerivation1899 = new BitSet(new long[]{0x00132000040001F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleEventDerivation1920 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleEventDerivation1933 = new BitSet(new long[]{0x00132000040001F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleEventDerivation1954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition1992 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDefinition2002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleVariableDefinition2048 = new BitSet(new long[]{0x0000000000C00010L});
    public static final BitSet FOLLOW_22_in_ruleVariableDefinition2111 = new BitSet(new long[]{0x0000000000C00010L});
    public static final BitSet FOLLOW_23_in_ruleVariableDefinition2196 = new BitSet(new long[]{0x0000000000C00010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableDefinition2266 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVariableDefinition2283 = new BitSet(new long[]{0xE000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleType_in_ruleVariableDefinition2304 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleVariableDefinition2317 = new BitSet(new long[]{0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleVariableDefinition2338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClock_in_entryRuleClock2376 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClock2386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleClock2432 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClock2449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_entryRuleOperation2490 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperation2500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOperation2546 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOperation2563 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleOperation2580 = new BitSet(new long[]{0xE000000010000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleType_in_ruleOperation2602 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_ruleOperation2615 = new BitSet(new long[]{0xE000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleType_in_ruleOperation2636 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_28_in_ruleOperation2652 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleOperation2665 = new BitSet(new long[]{0xE000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleType_in_ruleOperation2686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntrypoint_in_entryRuleEntrypoint2724 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntrypoint2734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleEntrypoint2780 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntrypoint2797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitpoint_in_entryRuleExitpoint2838 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitpoint2848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleExitpoint2894 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExitpoint2911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocalReaction_in_entryRuleLocalReaction2954 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocalReaction2964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionTrigger_in_ruleLocalReaction3010 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_31_in_ruleLocalReaction3023 = new BitSet(new long[]{0x00000400040001F0L});
    public static final BitSet FOLLOW_ruleReactionEffect_in_ruleLocalReaction3044 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleLocalReaction3059 = new BitSet(new long[]{0x0000001000000030L});
    public static final BitSet FOLLOW_ruleReactionProperties_in_ruleLocalReaction3080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionReaction_in_entryRuleTransitionReaction3118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionReaction3128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionTrigger_in_ruleTransitionReaction3183 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_31_in_ruleTransitionReaction3197 = new BitSet(new long[]{0x00000400040001F0L});
    public static final BitSet FOLLOW_ruleReactionEffect_in_ruleTransitionReaction3218 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleTransitionReaction3233 = new BitSet(new long[]{0x0000001000000030L});
    public static final BitSet FOLLOW_ruleReactionProperties_in_ruleTransitionReaction3254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionTrigger_in_entryRuleReactionTrigger3292 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReactionTrigger3302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventSpec_in_ruleReactionTrigger3359 = new BitSet(new long[]{0x0000000208000002L});
    public static final BitSet FOLLOW_27_in_ruleReactionTrigger3372 = new BitSet(new long[]{0x000003E000000010L});
    public static final BitSet FOLLOW_ruleEventSpec_in_ruleReactionTrigger3393 = new BitSet(new long[]{0x0000000208000002L});
    public static final BitSet FOLLOW_33_in_ruleReactionTrigger3416 = new BitSet(new long[]{0x00132000040001F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleReactionTrigger3438 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleReactionTrigger3450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleReactionTrigger3472 = new BitSet(new long[]{0x00132000040001F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleReactionTrigger3493 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleReactionTrigger3505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionEffect_in_entryRuleReactionEffect3543 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReactionEffect3553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleReactionEffect3609 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleReactionEffect3621 = new BitSet(new long[]{0x00000400040001F2L});
    public static final BitSet FOLLOW_ruleReactionProperties_in_entryRuleReactionProperties3659 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReactionProperties3669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionProperty_in_ruleReactionProperties3724 = new BitSet(new long[]{0x0000001000000032L});
    public static final BitSet FOLLOW_ruleReactionProperty_in_entryRuleReactionProperty3761 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReactionProperty3771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionPriority_in_ruleReactionProperty3818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPointSpec_in_ruleReactionProperty3845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPointSpec_in_ruleReactionProperty3872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionPriority_in_entryRuleReactionPriority3907 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReactionPriority3917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleReactionPriority3958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPointSpec_in_entryRuleEntryPointSpec3998 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryPointSpec4008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleEntryPointSpec4045 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntryPointSpec4065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPointSpec_in_entryRuleExitPointSpec4101 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitPointSpec4111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExitPointSpec4156 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleExitPointSpec4168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventSpec_in_entryRuleEventSpec4204 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventSpec4214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRegularEventSpec_in_ruleEventSpec4261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeEventSpec_in_ruleEventSpec4288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuiltinEventSpec_in_ruleEventSpec4315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRegularEventSpec_in_entryRuleRegularEventSpec4350 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRegularEventSpec4360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRegularEventSpec4404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeEventSpec_in_entryRuleTimeEventSpec4439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeEventSpec4449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleTimeEventSpec4486 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTimeEventSpec4503 = new BitSet(new long[]{0x1C00000000000002L});
    public static final BitSet FOLLOW_ruleTimeUnit_in_ruleTimeEventSpec4529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuiltinEventSpec_in_entryRuleBuiltinEventSpec4566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBuiltinEventSpec4576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryEvent_in_ruleBuiltinEventSpec4623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitEvent_in_ruleBuiltinEventSpec4650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOnCycleEvent_in_ruleBuiltinEventSpec4677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlwaysEvent_in_ruleBuiltinEventSpec4704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryEvent_in_entryRuleEntryEvent4739 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryEvent4749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleEntryEvent4795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitEvent_in_entryRuleExitEvent4831 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitEvent4841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleExitEvent4887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOnCycleEvent_in_entryRuleOnCycleEvent4923 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOnCycleEvent4933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleOnCycleEvent4979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlwaysEvent_in_entryRuleAlwaysEvent5015 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlwaysEvent5025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleAlwaysEvent5071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement5107 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement5117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleStatement5164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventRaising_in_ruleStatement5191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCall_in_ruleStatement5218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment5253 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment5263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment5308 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleAssignment5320 = new BitSet(new long[]{0x00132000040001F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAssignment5341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventRaising_in_entryRuleEventRaising5377 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventRaising5387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleEventRaising5424 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEventRaising5444 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleEventRaising5457 = new BitSet(new long[]{0x00132000040001F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleEventRaising5478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression5516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression5526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleExpression5572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression5606 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOrExpression5616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5663 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleLogicalOrExpression5684 = new BitSet(new long[]{0x00132000040001F0L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5705 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression5743 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalAndExpression5753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression5800 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_ruleLogicalAndExpression5821 = new BitSet(new long[]{0x00132000040001F0L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression5842 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression5880 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalNotExpression5890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_ruleLogicalNotExpression5937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleLogicalNotExpression5964 = new BitSet(new long[]{0x00130000040001F0L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_ruleLogicalNotExpression5985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_entryRuleLogicalRelationExpression6022 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalRelationExpression6032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_ruleLogicalRelationExpression6079 = new BitSet(new long[]{0x03E0001000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleLogicalRelationExpression6109 = new BitSet(new long[]{0x00130000040001F0L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_ruleLogicalRelationExpression6130 = new BitSet(new long[]{0x03E0001000000002L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_entryRuleNumericalAddSubtractExpression6168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalAddSubtractExpression6178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression6225 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleNumericalAddSubtractExpression6255 = new BitSet(new long[]{0x00130000040001F0L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression6276 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_entryRuleNumericalMultiplyDivideExpression6314 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalMultiplyDivideExpression6324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression6371 = new BitSet(new long[]{0x000C000080000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleNumericalMultiplyDivideExpression6401 = new BitSet(new long[]{0x00130000040001F0L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression6422 = new BitSet(new long[]{0x000C000080000002L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_entryRuleNumericalUnaryExpression6460 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalUnaryExpression6470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression6517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleNumericalUnaryExpression6553 = new BitSet(new long[]{0x00000000040001F0L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression6574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression6611 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression6621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueExpression_in_rulePrimaryExpression6668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rulePrimaryExpression6686 = new BitSet(new long[]{0x00132000040001F0L});
    public static final BitSet FOLLOW_ruleExpression_in_rulePrimaryExpression6708 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_rulePrimaryExpression6719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCall_in_rulePrimaryExpression6748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueExpression_in_entryRuleValueExpression6783 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueExpression6793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveValueExpression_in_ruleValueExpression6840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementReferenceExpression_in_ruleValueExpression6867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveValueExpression_in_entryRulePrimitiveValueExpression6902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveValueExpression6912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimitiveValueExpression6967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementReferenceExpression_in_entryRuleElementReferenceExpression7003 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElementReferenceExpression7013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleElementReferenceExpression7067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCall_in_entryRuleOperationCall7103 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationCall7113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOperationCall7167 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleOperationCall7179 = new BitSet(new long[]{0x00132000140001F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleOperationCall7201 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_ruleOperationCall7214 = new BitSet(new long[]{0x00132000040001F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleOperationCall7235 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_28_in_ruleOperationCall7251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral7288 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral7299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOL_in_ruleLiteral7339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLiteral7365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLiteral7391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_FLOAT_in_ruleLiteral7417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleDirection7476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleDirection7493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleAdditiveOperator7538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleAdditiveOperator7555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleMultiplicativeOperator7600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleMultiplicativeOperator7617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleMultiplicativeOperator7634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleUnaryOperator7679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleUnaryOperator7696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleUnaryOperator7713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleRelationalOperator7758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleRelationalOperator7775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleRelationalOperator7792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleRelationalOperator7809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleRelationalOperator7826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleRelationalOperator7843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleTimeUnit7888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleTimeUnit7905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleTimeUnit7922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleType7967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleType7984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleType8001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleType8018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleType8035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_synpred1_InternalSText3408 = new BitSet(new long[]{0x0000000000000002L});

}
