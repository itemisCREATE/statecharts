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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_BOOL", "RULE_FLOAT", "RULE_HEX", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'@@statechart@@'", "'@@state@@'", "'@@transition@@'", "'namespace'", "'interface'", "':'", "'internal'", "'event'", "'='", "'var'", "'readonly'", "'external'", "'operation'", "'('", "','", "')'", "'entrypoint'", "'exitpoint'", "'.'", "'/'", "'#'", "'['", "']'", "';'", "'>'", "'entry'", "'exit'", "'oncycle'", "'always'", "'default'", "'else'", "'raise'", "'?'", "'||'", "'&&'", "'!'", "'^'", "'|'", "'&'", "'valueof'", "'active'", "'local'", "'in'", "'out'", "'after'", "'every'", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'<<'", "'>>'", "'+'", "'-'", "'*'", "'%'", "'~'", "'<'", "'<='", "'>='", "'=='", "'!='", "'s'", "'ms'", "'\\u00D4\\u00F8\\u03A9s'", "'ns'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=4;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=13;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_BOOL=6;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int RULE_HEX=8;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__15=15;
    public static final int T__52=52;
    public static final int T__18=18;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__59=59;
    public static final int RULE_INT=5;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__80=80;
    public static final int T__46=46;
    public static final int T__81=81;
    public static final int T__47=47;
    public static final int T__82=82;
    public static final int T__44=44;
    public static final int T__83=83;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_FLOAT=7;
    public static final int T__85=85;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__84=84;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=9;
    public static final int T__32=32;
    public static final int T__71=71;
    public static final int T__33=33;
    public static final int T__72=72;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=12;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;

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

                if ( ((LA1_0>=14 && LA1_0<=16)) ) {
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
            case 14:
                {
                alt2=1;
                }
                break;
            case 15:
                {
                alt2=2;
                }
                break;
            case 16:
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:166:1: ruleStatechartRoot returns [EObject current=null] : (otherlv_0= '@@statechart@@' ( (lv_def_1_0= ruleStatechartSpecification ) ) ) ;
    public final EObject ruleStatechartRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_def_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:169:28: ( (otherlv_0= '@@statechart@@' ( (lv_def_1_0= ruleStatechartSpecification ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:170:1: (otherlv_0= '@@statechart@@' ( (lv_def_1_0= ruleStatechartSpecification ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:170:1: (otherlv_0= '@@statechart@@' ( (lv_def_1_0= ruleStatechartSpecification ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:170:3: otherlv_0= '@@statechart@@' ( (lv_def_1_0= ruleStatechartSpecification ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleStatechartRoot359); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getStatechartRootAccess().getStatechartKeyword_0());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:174:1: ( (lv_def_1_0= ruleStatechartSpecification ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:175:1: (lv_def_1_0= ruleStatechartSpecification )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:175:1: (lv_def_1_0= ruleStatechartSpecification )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:176:3: lv_def_1_0= ruleStatechartSpecification
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStatechartRootAccess().getDefStatechartSpecificationParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStatechartSpecification_in_ruleStatechartRoot380);
            lv_def_1_0=ruleStatechartSpecification();

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
                      		"StatechartSpecification");
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:209:1: ruleStateRoot returns [EObject current=null] : (otherlv_0= '@@state@@' ( (lv_def_1_0= ruleStateSpecification ) ) ) ;
    public final EObject ruleStateRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_def_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:212:28: ( (otherlv_0= '@@state@@' ( (lv_def_1_0= ruleStateSpecification ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:213:1: (otherlv_0= '@@state@@' ( (lv_def_1_0= ruleStateSpecification ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:213:1: (otherlv_0= '@@state@@' ( (lv_def_1_0= ruleStateSpecification ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:213:3: otherlv_0= '@@state@@' ( (lv_def_1_0= ruleStateSpecification ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleStateRoot463); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getStateRootAccess().getStateKeyword_0());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:217:1: ( (lv_def_1_0= ruleStateSpecification ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:218:1: (lv_def_1_0= ruleStateSpecification )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:218:1: (lv_def_1_0= ruleStateSpecification )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:219:3: lv_def_1_0= ruleStateSpecification
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStateRootAccess().getDefStateSpecificationParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStateSpecification_in_ruleStateRoot484);
            lv_def_1_0=ruleStateSpecification();

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
                      		"StateSpecification");
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:252:1: ruleTransitionRoot returns [EObject current=null] : (otherlv_0= '@@transition@@' ( (lv_def_1_0= ruleTransitionSpecification ) ) ) ;
    public final EObject ruleTransitionRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_def_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:255:28: ( (otherlv_0= '@@transition@@' ( (lv_def_1_0= ruleTransitionSpecification ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:256:1: (otherlv_0= '@@transition@@' ( (lv_def_1_0= ruleTransitionSpecification ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:256:1: (otherlv_0= '@@transition@@' ( (lv_def_1_0= ruleTransitionSpecification ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:256:3: otherlv_0= '@@transition@@' ( (lv_def_1_0= ruleTransitionSpecification ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleTransitionRoot567); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTransitionRootAccess().getTransitionKeyword_0());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:260:1: ( (lv_def_1_0= ruleTransitionSpecification ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:261:1: (lv_def_1_0= ruleTransitionSpecification )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:261:1: (lv_def_1_0= ruleTransitionSpecification )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:262:3: lv_def_1_0= ruleTransitionSpecification
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransitionRootAccess().getDefTransitionSpecificationParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTransitionSpecification_in_ruleTransitionRoot588);
            lv_def_1_0=ruleTransitionSpecification();

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
                      		"TransitionSpecification");
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


    // $ANTLR start "entryRuleStatechartSpecification"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:286:1: entryRuleStatechartSpecification returns [EObject current=null] : iv_ruleStatechartSpecification= ruleStatechartSpecification EOF ;
    public final EObject entryRuleStatechartSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatechartSpecification = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:287:2: (iv_ruleStatechartSpecification= ruleStatechartSpecification EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:288:2: iv_ruleStatechartSpecification= ruleStatechartSpecification EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatechartSpecificationRule()); 
            }
            pushFollow(FOLLOW_ruleStatechartSpecification_in_entryRuleStatechartSpecification624);
            iv_ruleStatechartSpecification=ruleStatechartSpecification();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatechartSpecification; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatechartSpecification634); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatechartSpecification"


    // $ANTLR start "ruleStatechartSpecification"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:295:1: ruleStatechartSpecification returns [EObject current=null] : ( () (otherlv_1= 'namespace' ( (lv_namespace_2_0= ruleFQN ) ) )? ( (lv_definitionScopes_3_0= ruleStatechartScope ) )* ) ;
    public final EObject ruleStatechartSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_namespace_2_0 = null;

        EObject lv_definitionScopes_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:298:28: ( ( () (otherlv_1= 'namespace' ( (lv_namespace_2_0= ruleFQN ) ) )? ( (lv_definitionScopes_3_0= ruleStatechartScope ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:299:1: ( () (otherlv_1= 'namespace' ( (lv_namespace_2_0= ruleFQN ) ) )? ( (lv_definitionScopes_3_0= ruleStatechartScope ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:299:1: ( () (otherlv_1= 'namespace' ( (lv_namespace_2_0= ruleFQN ) ) )? ( (lv_definitionScopes_3_0= ruleStatechartScope ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:299:2: () (otherlv_1= 'namespace' ( (lv_namespace_2_0= ruleFQN ) ) )? ( (lv_definitionScopes_3_0= ruleStatechartScope ) )*
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:299:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:300:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getStatechartSpecificationAccess().getStatechartSpecificationAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:305:2: (otherlv_1= 'namespace' ( (lv_namespace_2_0= ruleFQN ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==17) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:305:4: otherlv_1= 'namespace' ( (lv_namespace_2_0= ruleFQN ) )
                    {
                    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleStatechartSpecification681); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getStatechartSpecificationAccess().getNamespaceKeyword_1_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:309:1: ( (lv_namespace_2_0= ruleFQN ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:310:1: (lv_namespace_2_0= ruleFQN )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:310:1: (lv_namespace_2_0= ruleFQN )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:311:3: lv_namespace_2_0= ruleFQN
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatechartSpecificationAccess().getNamespaceFQNParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFQN_in_ruleStatechartSpecification702);
                    lv_namespace_2_0=ruleFQN();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatechartSpecificationRule());
                      	        }
                             		set(
                             			current, 
                             			"namespace",
                              		lv_namespace_2_0, 
                              		"FQN");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:327:4: ( (lv_definitionScopes_3_0= ruleStatechartScope ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18||LA4_0==20) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:328:1: (lv_definitionScopes_3_0= ruleStatechartScope )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:328:1: (lv_definitionScopes_3_0= ruleStatechartScope )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:329:3: lv_definitionScopes_3_0= ruleStatechartScope
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStatechartSpecificationAccess().getDefinitionScopesStatechartScopeParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleStatechartScope_in_ruleStatechartSpecification725);
            	    lv_definitionScopes_3_0=ruleStatechartScope();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getStatechartSpecificationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"definitionScopes",
            	              		lv_definitionScopes_3_0, 
            	              		"StatechartScope");
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
    // $ANTLR end "ruleStatechartSpecification"


    // $ANTLR start "entryRuleStateSpecification"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:353:1: entryRuleStateSpecification returns [EObject current=null] : iv_ruleStateSpecification= ruleStateSpecification EOF ;
    public final EObject entryRuleStateSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateSpecification = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:354:2: (iv_ruleStateSpecification= ruleStateSpecification EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:355:2: iv_ruleStateSpecification= ruleStateSpecification EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStateSpecificationRule()); 
            }
            pushFollow(FOLLOW_ruleStateSpecification_in_entryRuleStateSpecification762);
            iv_ruleStateSpecification=ruleStateSpecification();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStateSpecification; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateSpecification772); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStateSpecification"


    // $ANTLR start "ruleStateSpecification"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:362:1: ruleStateSpecification returns [EObject current=null] : ( (lv_scope_0_0= ruleStateScope ) ) ;
    public final EObject ruleStateSpecification() throws RecognitionException {
        EObject current = null;

        EObject lv_scope_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:365:28: ( ( (lv_scope_0_0= ruleStateScope ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:366:1: ( (lv_scope_0_0= ruleStateScope ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:366:1: ( (lv_scope_0_0= ruleStateScope ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:367:1: (lv_scope_0_0= ruleStateScope )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:367:1: (lv_scope_0_0= ruleStateScope )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:368:3: lv_scope_0_0= ruleStateScope
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStateSpecificationAccess().getScopeStateScopeParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStateScope_in_ruleStateSpecification817);
            lv_scope_0_0=ruleStateScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getStateSpecificationRule());
              	        }
                     		set(
                     			current, 
                     			"scope",
                      		lv_scope_0_0, 
                      		"StateScope");
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
    // $ANTLR end "ruleStateSpecification"


    // $ANTLR start "entryRuleTransitionSpecification"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:392:1: entryRuleTransitionSpecification returns [EObject current=null] : iv_ruleTransitionSpecification= ruleTransitionSpecification EOF ;
    public final EObject entryRuleTransitionSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionSpecification = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:393:2: (iv_ruleTransitionSpecification= ruleTransitionSpecification EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:394:2: iv_ruleTransitionSpecification= ruleTransitionSpecification EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransitionSpecificationRule()); 
            }
            pushFollow(FOLLOW_ruleTransitionSpecification_in_entryRuleTransitionSpecification852);
            iv_ruleTransitionSpecification=ruleTransitionSpecification();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransitionSpecification; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionSpecification862); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransitionSpecification"


    // $ANTLR start "ruleTransitionSpecification"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:401:1: ruleTransitionSpecification returns [EObject current=null] : ( (lv_reaction_0_0= ruleTransitionReaction ) ) ;
    public final EObject ruleTransitionSpecification() throws RecognitionException {
        EObject current = null;

        EObject lv_reaction_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:404:28: ( ( (lv_reaction_0_0= ruleTransitionReaction ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:405:1: ( (lv_reaction_0_0= ruleTransitionReaction ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:405:1: ( (lv_reaction_0_0= ruleTransitionReaction ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:406:1: (lv_reaction_0_0= ruleTransitionReaction )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:406:1: (lv_reaction_0_0= ruleTransitionReaction )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:407:3: lv_reaction_0_0= ruleTransitionReaction
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransitionSpecificationAccess().getReactionTransitionReactionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTransitionReaction_in_ruleTransitionSpecification907);
            lv_reaction_0_0=ruleTransitionReaction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTransitionSpecificationRule());
              	        }
                     		set(
                     			current, 
                     			"reaction",
                      		lv_reaction_0_0, 
                      		"TransitionReaction");
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
    // $ANTLR end "ruleTransitionSpecification"


    // $ANTLR start "entryRuleStateScope"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:433:1: entryRuleStateScope returns [EObject current=null] : iv_ruleStateScope= ruleStateScope EOF ;
    public final EObject entryRuleStateScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateScope = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:434:2: (iv_ruleStateScope= ruleStateScope EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:435:2: iv_ruleStateScope= ruleStateScope EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStateScopeRule()); 
            }
            pushFollow(FOLLOW_ruleStateScope_in_entryRuleStateScope944);
            iv_ruleStateScope=ruleStateScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStateScope; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateScope954); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStateScope"


    // $ANTLR start "ruleStateScope"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:442:1: ruleStateScope returns [EObject current=null] : ( () ( ( (lv_declarations_1_1= ruleLocalReaction | lv_declarations_1_2= ruleEntrypoint | lv_declarations_1_3= ruleExitpoint ) ) )* ) ;
    public final EObject ruleStateScope() throws RecognitionException {
        EObject current = null;

        EObject lv_declarations_1_1 = null;

        EObject lv_declarations_1_2 = null;

        EObject lv_declarations_1_3 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:445:28: ( ( () ( ( (lv_declarations_1_1= ruleLocalReaction | lv_declarations_1_2= ruleEntrypoint | lv_declarations_1_3= ruleExitpoint ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:446:1: ( () ( ( (lv_declarations_1_1= ruleLocalReaction | lv_declarations_1_2= ruleEntrypoint | lv_declarations_1_3= ruleExitpoint ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:446:1: ( () ( ( (lv_declarations_1_1= ruleLocalReaction | lv_declarations_1_2= ruleEntrypoint | lv_declarations_1_3= ruleExitpoint ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:446:2: () ( ( (lv_declarations_1_1= ruleLocalReaction | lv_declarations_1_2= ruleEntrypoint | lv_declarations_1_3= ruleExitpoint ) ) )*
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:446:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:447:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getStateScopeAccess().getSimpleScopeAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:452:2: ( ( (lv_declarations_1_1= ruleLocalReaction | lv_declarations_1_2= ruleEntrypoint | lv_declarations_1_3= ruleExitpoint ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID||(LA6_0>=30 && LA6_0<=31)||LA6_0==35||(LA6_0>=39 && LA6_0<=44)||(LA6_0>=58 && LA6_0<=59)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:453:1: ( (lv_declarations_1_1= ruleLocalReaction | lv_declarations_1_2= ruleEntrypoint | lv_declarations_1_3= ruleExitpoint ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:453:1: ( (lv_declarations_1_1= ruleLocalReaction | lv_declarations_1_2= ruleEntrypoint | lv_declarations_1_3= ruleExitpoint ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:454:1: (lv_declarations_1_1= ruleLocalReaction | lv_declarations_1_2= ruleEntrypoint | lv_declarations_1_3= ruleExitpoint )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:454:1: (lv_declarations_1_1= ruleLocalReaction | lv_declarations_1_2= ruleEntrypoint | lv_declarations_1_3= ruleExitpoint )
            	    int alt5=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_ID:
            	    case 35:
            	    case 39:
            	    case 40:
            	    case 41:
            	    case 42:
            	    case 43:
            	    case 44:
            	    case 58:
            	    case 59:
            	        {
            	        alt5=1;
            	        }
            	        break;
            	    case 30:
            	        {
            	        alt5=2;
            	        }
            	        break;
            	    case 31:
            	        {
            	        alt5=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 5, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt5) {
            	        case 1 :
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:455:3: lv_declarations_1_1= ruleLocalReaction
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getStateScopeAccess().getDeclarationsLocalReactionParserRuleCall_1_0_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleLocalReaction_in_ruleStateScope1011);
            	            lv_declarations_1_1=ruleLocalReaction();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getStateScopeRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"declarations",
            	                      		lv_declarations_1_1, 
            	                      		"LocalReaction");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:470:8: lv_declarations_1_2= ruleEntrypoint
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getStateScopeAccess().getDeclarationsEntrypointParserRuleCall_1_0_1()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleEntrypoint_in_ruleStateScope1030);
            	            lv_declarations_1_2=ruleEntrypoint();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getStateScopeRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"declarations",
            	                      		lv_declarations_1_2, 
            	                      		"Entrypoint");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:485:8: lv_declarations_1_3= ruleExitpoint
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getStateScopeAccess().getDeclarationsExitpointParserRuleCall_1_0_2()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleExitpoint_in_ruleStateScope1049);
            	            lv_declarations_1_3=ruleExitpoint();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getStateScopeRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"declarations",
            	                      		lv_declarations_1_3, 
            	                      		"Exitpoint");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;

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
    // $ANTLR end "ruleStateScope"


    // $ANTLR start "entryRuleStatechartScope"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:513:1: entryRuleStatechartScope returns [EObject current=null] : iv_ruleStatechartScope= ruleStatechartScope EOF ;
    public final EObject entryRuleStatechartScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatechartScope = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:514:2: (iv_ruleStatechartScope= ruleStatechartScope EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:515:2: iv_ruleStatechartScope= ruleStatechartScope EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatechartScopeRule()); 
            }
            pushFollow(FOLLOW_ruleStatechartScope_in_entryRuleStatechartScope1091);
            iv_ruleStatechartScope=ruleStatechartScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatechartScope; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatechartScope1101); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:522:1: ruleStatechartScope returns [EObject current=null] : (this_InterfaceScope_0= ruleInterfaceScope | this_InternalScope_1= ruleInternalScope ) ;
    public final EObject ruleStatechartScope() throws RecognitionException {
        EObject current = null;

        EObject this_InterfaceScope_0 = null;

        EObject this_InternalScope_1 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:525:28: ( (this_InterfaceScope_0= ruleInterfaceScope | this_InternalScope_1= ruleInternalScope ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:526:1: (this_InterfaceScope_0= ruleInterfaceScope | this_InternalScope_1= ruleInternalScope )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:526:1: (this_InterfaceScope_0= ruleInterfaceScope | this_InternalScope_1= ruleInternalScope )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            else if ( (LA7_0==20) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:527:5: this_InterfaceScope_0= ruleInterfaceScope
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatechartScopeAccess().getInterfaceScopeParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleInterfaceScope_in_ruleStatechartScope1148);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:537:5: this_InternalScope_1= ruleInternalScope
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatechartScopeAccess().getInternalScopeParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleInternalScope_in_ruleStatechartScope1175);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:553:1: entryRuleInterfaceScope returns [EObject current=null] : iv_ruleInterfaceScope= ruleInterfaceScope EOF ;
    public final EObject entryRuleInterfaceScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceScope = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:554:2: (iv_ruleInterfaceScope= ruleInterfaceScope EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:555:2: iv_ruleInterfaceScope= ruleInterfaceScope EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInterfaceScopeRule()); 
            }
            pushFollow(FOLLOW_ruleInterfaceScope_in_entryRuleInterfaceScope1210);
            iv_ruleInterfaceScope=ruleInterfaceScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInterfaceScope; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterfaceScope1220); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:562:1: ruleInterfaceScope returns [EObject current=null] : ( () otherlv_1= 'interface' ( (lv_name_2_0= RULE_ID ) )? otherlv_3= ':' ( ( (lv_declarations_4_1= ruleEventDefinition | lv_declarations_4_2= ruleVariableDefinition | lv_declarations_4_3= ruleEntrypoint | lv_declarations_4_4= ruleExitpoint ) ) )* ) ;
    public final EObject ruleInterfaceScope() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        EObject lv_declarations_4_1 = null;

        EObject lv_declarations_4_2 = null;

        EObject lv_declarations_4_3 = null;

        EObject lv_declarations_4_4 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:565:28: ( ( () otherlv_1= 'interface' ( (lv_name_2_0= RULE_ID ) )? otherlv_3= ':' ( ( (lv_declarations_4_1= ruleEventDefinition | lv_declarations_4_2= ruleVariableDefinition | lv_declarations_4_3= ruleEntrypoint | lv_declarations_4_4= ruleExitpoint ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:566:1: ( () otherlv_1= 'interface' ( (lv_name_2_0= RULE_ID ) )? otherlv_3= ':' ( ( (lv_declarations_4_1= ruleEventDefinition | lv_declarations_4_2= ruleVariableDefinition | lv_declarations_4_3= ruleEntrypoint | lv_declarations_4_4= ruleExitpoint ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:566:1: ( () otherlv_1= 'interface' ( (lv_name_2_0= RULE_ID ) )? otherlv_3= ':' ( ( (lv_declarations_4_1= ruleEventDefinition | lv_declarations_4_2= ruleVariableDefinition | lv_declarations_4_3= ruleEntrypoint | lv_declarations_4_4= ruleExitpoint ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:566:2: () otherlv_1= 'interface' ( (lv_name_2_0= RULE_ID ) )? otherlv_3= ':' ( ( (lv_declarations_4_1= ruleEventDefinition | lv_declarations_4_2= ruleVariableDefinition | lv_declarations_4_3= ruleEntrypoint | lv_declarations_4_4= ruleExitpoint ) ) )*
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:566:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:567:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getInterfaceScopeAccess().getInterfaceScopeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleInterfaceScope1266); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getInterfaceScopeAccess().getInterfaceKeyword_1());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:576:1: ( (lv_name_2_0= RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:577:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:577:1: (lv_name_2_0= RULE_ID )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:578:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInterfaceScope1283); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleInterfaceScope1301); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getInterfaceScopeAccess().getColonKeyword_3());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:598:1: ( ( (lv_declarations_4_1= ruleEventDefinition | lv_declarations_4_2= ruleVariableDefinition | lv_declarations_4_3= ruleEntrypoint | lv_declarations_4_4= ruleExitpoint ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==21||LA10_0==23||(LA10_0>=30 && LA10_0<=31)||(LA10_0>=55 && LA10_0<=57)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:599:1: ( (lv_declarations_4_1= ruleEventDefinition | lv_declarations_4_2= ruleVariableDefinition | lv_declarations_4_3= ruleEntrypoint | lv_declarations_4_4= ruleExitpoint ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:599:1: ( (lv_declarations_4_1= ruleEventDefinition | lv_declarations_4_2= ruleVariableDefinition | lv_declarations_4_3= ruleEntrypoint | lv_declarations_4_4= ruleExitpoint ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:600:1: (lv_declarations_4_1= ruleEventDefinition | lv_declarations_4_2= ruleVariableDefinition | lv_declarations_4_3= ruleEntrypoint | lv_declarations_4_4= ruleExitpoint )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:600:1: (lv_declarations_4_1= ruleEventDefinition | lv_declarations_4_2= ruleVariableDefinition | lv_declarations_4_3= ruleEntrypoint | lv_declarations_4_4= ruleExitpoint )
            	    int alt9=4;
            	    switch ( input.LA(1) ) {
            	    case 21:
            	    case 55:
            	    case 56:
            	    case 57:
            	        {
            	        alt9=1;
            	        }
            	        break;
            	    case 23:
            	        {
            	        alt9=2;
            	        }
            	        break;
            	    case 30:
            	        {
            	        alt9=3;
            	        }
            	        break;
            	    case 31:
            	        {
            	        alt9=4;
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
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:601:3: lv_declarations_4_1= ruleEventDefinition
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getInterfaceScopeAccess().getDeclarationsEventDefinitionParserRuleCall_4_0_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleEventDefinition_in_ruleInterfaceScope1324);
            	            lv_declarations_4_1=ruleEventDefinition();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getInterfaceScopeRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"declarations",
            	                      		lv_declarations_4_1, 
            	                      		"EventDefinition");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:616:8: lv_declarations_4_2= ruleVariableDefinition
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getInterfaceScopeAccess().getDeclarationsVariableDefinitionParserRuleCall_4_0_1()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleVariableDefinition_in_ruleInterfaceScope1343);
            	            lv_declarations_4_2=ruleVariableDefinition();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getInterfaceScopeRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"declarations",
            	                      		lv_declarations_4_2, 
            	                      		"VariableDefinition");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:631:8: lv_declarations_4_3= ruleEntrypoint
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getInterfaceScopeAccess().getDeclarationsEntrypointParserRuleCall_4_0_2()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleEntrypoint_in_ruleInterfaceScope1362);
            	            lv_declarations_4_3=ruleEntrypoint();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getInterfaceScopeRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"declarations",
            	                      		lv_declarations_4_3, 
            	                      		"Entrypoint");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:646:8: lv_declarations_4_4= ruleExitpoint
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getInterfaceScopeAccess().getDeclarationsExitpointParserRuleCall_4_0_3()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleExitpoint_in_ruleInterfaceScope1381);
            	            lv_declarations_4_4=ruleExitpoint();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getInterfaceScopeRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"declarations",
            	                      		lv_declarations_4_4, 
            	                      		"Exitpoint");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;

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
    // $ANTLR end "ruleInterfaceScope"


    // $ANTLR start "entryRuleInternalScope"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:672:1: entryRuleInternalScope returns [EObject current=null] : iv_ruleInternalScope= ruleInternalScope EOF ;
    public final EObject entryRuleInternalScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInternalScope = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:673:2: (iv_ruleInternalScope= ruleInternalScope EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:674:2: iv_ruleInternalScope= ruleInternalScope EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInternalScopeRule()); 
            }
            pushFollow(FOLLOW_ruleInternalScope_in_entryRuleInternalScope1421);
            iv_ruleInternalScope=ruleInternalScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInternalScope; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInternalScope1431); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:681:1: ruleInternalScope returns [EObject current=null] : ( () otherlv_1= 'internal' otherlv_2= ':' ( ( (lv_declarations_3_1= ruleEventDefinition | lv_declarations_3_2= ruleVariableDefinition | lv_declarations_3_3= ruleOperation | lv_declarations_3_4= ruleLocalReaction ) ) )* ) ;
    public final EObject ruleInternalScope() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_declarations_3_1 = null;

        EObject lv_declarations_3_2 = null;

        EObject lv_declarations_3_3 = null;

        EObject lv_declarations_3_4 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:684:28: ( ( () otherlv_1= 'internal' otherlv_2= ':' ( ( (lv_declarations_3_1= ruleEventDefinition | lv_declarations_3_2= ruleVariableDefinition | lv_declarations_3_3= ruleOperation | lv_declarations_3_4= ruleLocalReaction ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:685:1: ( () otherlv_1= 'internal' otherlv_2= ':' ( ( (lv_declarations_3_1= ruleEventDefinition | lv_declarations_3_2= ruleVariableDefinition | lv_declarations_3_3= ruleOperation | lv_declarations_3_4= ruleLocalReaction ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:685:1: ( () otherlv_1= 'internal' otherlv_2= ':' ( ( (lv_declarations_3_1= ruleEventDefinition | lv_declarations_3_2= ruleVariableDefinition | lv_declarations_3_3= ruleOperation | lv_declarations_3_4= ruleLocalReaction ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:685:2: () otherlv_1= 'internal' otherlv_2= ':' ( ( (lv_declarations_3_1= ruleEventDefinition | lv_declarations_3_2= ruleVariableDefinition | lv_declarations_3_3= ruleOperation | lv_declarations_3_4= ruleLocalReaction ) ) )*
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:685:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:686:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getInternalScopeAccess().getInternalScopeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleInternalScope1477); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getInternalScopeAccess().getInternalKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleInternalScope1489); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getInternalScopeAccess().getColonKeyword_2());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:699:1: ( ( (lv_declarations_3_1= ruleEventDefinition | lv_declarations_3_2= ruleVariableDefinition | lv_declarations_3_3= ruleOperation | lv_declarations_3_4= ruleLocalReaction ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID||LA12_0==21||LA12_0==23||LA12_0==26||LA12_0==35||(LA12_0>=39 && LA12_0<=44)||(LA12_0>=55 && LA12_0<=59)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:700:1: ( (lv_declarations_3_1= ruleEventDefinition | lv_declarations_3_2= ruleVariableDefinition | lv_declarations_3_3= ruleOperation | lv_declarations_3_4= ruleLocalReaction ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:700:1: ( (lv_declarations_3_1= ruleEventDefinition | lv_declarations_3_2= ruleVariableDefinition | lv_declarations_3_3= ruleOperation | lv_declarations_3_4= ruleLocalReaction ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:701:1: (lv_declarations_3_1= ruleEventDefinition | lv_declarations_3_2= ruleVariableDefinition | lv_declarations_3_3= ruleOperation | lv_declarations_3_4= ruleLocalReaction )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:701:1: (lv_declarations_3_1= ruleEventDefinition | lv_declarations_3_2= ruleVariableDefinition | lv_declarations_3_3= ruleOperation | lv_declarations_3_4= ruleLocalReaction )
            	    int alt11=4;
            	    switch ( input.LA(1) ) {
            	    case 21:
            	    case 55:
            	    case 56:
            	    case 57:
            	        {
            	        alt11=1;
            	        }
            	        break;
            	    case 23:
            	        {
            	        alt11=2;
            	        }
            	        break;
            	    case 26:
            	        {
            	        alt11=3;
            	        }
            	        break;
            	    case RULE_ID:
            	    case 35:
            	    case 39:
            	    case 40:
            	    case 41:
            	    case 42:
            	    case 43:
            	    case 44:
            	    case 58:
            	    case 59:
            	        {
            	        alt11=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 11, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt11) {
            	        case 1 :
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:702:3: lv_declarations_3_1= ruleEventDefinition
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getInternalScopeAccess().getDeclarationsEventDefinitionParserRuleCall_3_0_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleEventDefinition_in_ruleInternalScope1512);
            	            lv_declarations_3_1=ruleEventDefinition();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getInternalScopeRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"declarations",
            	                      		lv_declarations_3_1, 
            	                      		"EventDefinition");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:717:8: lv_declarations_3_2= ruleVariableDefinition
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getInternalScopeAccess().getDeclarationsVariableDefinitionParserRuleCall_3_0_1()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleVariableDefinition_in_ruleInternalScope1531);
            	            lv_declarations_3_2=ruleVariableDefinition();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getInternalScopeRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"declarations",
            	                      		lv_declarations_3_2, 
            	                      		"VariableDefinition");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:732:8: lv_declarations_3_3= ruleOperation
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getInternalScopeAccess().getDeclarationsOperationParserRuleCall_3_0_2()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleOperation_in_ruleInternalScope1550);
            	            lv_declarations_3_3=ruleOperation();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getInternalScopeRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"declarations",
            	                      		lv_declarations_3_3, 
            	                      		"Operation");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:747:8: lv_declarations_3_4= ruleLocalReaction
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getInternalScopeAccess().getDeclarationsLocalReactionParserRuleCall_3_0_3()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleLocalReaction_in_ruleInternalScope1569);
            	            lv_declarations_3_4=ruleLocalReaction();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getInternalScopeRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"declarations",
            	                      		lv_declarations_3_4, 
            	                      		"LocalReaction");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;

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
    // $ANTLR end "ruleInternalScope"


    // $ANTLR start "entryRuleEventDefinition"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:779:1: entryRuleEventDefinition returns [EObject current=null] : iv_ruleEventDefinition= ruleEventDefinition EOF ;
    public final EObject entryRuleEventDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventDefinition = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:780:2: (iv_ruleEventDefinition= ruleEventDefinition EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:781:2: iv_ruleEventDefinition= ruleEventDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleEventDefinition_in_entryRuleEventDefinition1615);
            iv_ruleEventDefinition=ruleEventDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventDefinition1625); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:788:1: ruleEventDefinition returns [EObject current=null] : ( ( (lv_direction_0_0= ruleDirection ) )? otherlv_1= 'event' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( ( ruleFQN ) ) )? ( (lv_derivation_5_0= ruleEventDerivation ) )? ) ;
    public final EObject ruleEventDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Enumerator lv_direction_0_0 = null;

        EObject lv_derivation_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:791:28: ( ( ( (lv_direction_0_0= ruleDirection ) )? otherlv_1= 'event' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( ( ruleFQN ) ) )? ( (lv_derivation_5_0= ruleEventDerivation ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:792:1: ( ( (lv_direction_0_0= ruleDirection ) )? otherlv_1= 'event' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( ( ruleFQN ) ) )? ( (lv_derivation_5_0= ruleEventDerivation ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:792:1: ( ( (lv_direction_0_0= ruleDirection ) )? otherlv_1= 'event' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( ( ruleFQN ) ) )? ( (lv_derivation_5_0= ruleEventDerivation ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:792:2: ( (lv_direction_0_0= ruleDirection ) )? otherlv_1= 'event' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( ( ruleFQN ) ) )? ( (lv_derivation_5_0= ruleEventDerivation ) )?
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:792:2: ( (lv_direction_0_0= ruleDirection ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=55 && LA13_0<=57)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:793:1: (lv_direction_0_0= ruleDirection )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:793:1: (lv_direction_0_0= ruleDirection )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:794:3: lv_direction_0_0= ruleDirection
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEventDefinitionAccess().getDirectionDirectionEnumRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDirection_in_ruleEventDefinition1671);
                    lv_direction_0_0=ruleDirection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEventDefinitionRule());
                      	        }
                             		set(
                             			current, 
                             			"direction",
                              		lv_direction_0_0, 
                              		"Direction");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleEventDefinition1684); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEventDefinitionAccess().getEventKeyword_1());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:814:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:815:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:815:1: (lv_name_2_0= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:816:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEventDefinition1701); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getEventDefinitionAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEventDefinitionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:832:2: (otherlv_3= ':' ( ( ruleFQN ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==19) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:832:4: otherlv_3= ':' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleEventDefinition1719); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getEventDefinitionAccess().getColonKeyword_3_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:836:1: ( ( ruleFQN ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:837:1: ( ruleFQN )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:837:1: ( ruleFQN )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:838:3: ruleFQN
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getEventDefinitionRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEventDefinitionAccess().getTypeTypeCrossReference_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFQN_in_ruleEventDefinition1742);
                    ruleFQN();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:851:4: ( (lv_derivation_5_0= ruleEventDerivation ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:852:1: (lv_derivation_5_0= ruleEventDerivation )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:852:1: (lv_derivation_5_0= ruleEventDerivation )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:853:3: lv_derivation_5_0= ruleEventDerivation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEventDefinitionAccess().getDerivationEventDerivationParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEventDerivation_in_ruleEventDefinition1765);
                    lv_derivation_5_0=ruleEventDerivation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEventDefinitionRule());
                      	        }
                             		set(
                             			current, 
                             			"derivation",
                              		lv_derivation_5_0, 
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:877:1: entryRuleEventDerivation returns [EObject current=null] : iv_ruleEventDerivation= ruleEventDerivation EOF ;
    public final EObject entryRuleEventDerivation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventDerivation = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:878:2: (iv_ruleEventDerivation= ruleEventDerivation EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:879:2: iv_ruleEventDerivation= ruleEventDerivation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventDerivationRule()); 
            }
            pushFollow(FOLLOW_ruleEventDerivation_in_entryRuleEventDerivation1802);
            iv_ruleEventDerivation=ruleEventDerivation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventDerivation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventDerivation1812); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:886:1: ruleEventDerivation returns [EObject current=null] : (otherlv_0= '=' ( (lv_condition_1_0= ruleExpression ) ) (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )? ) ;
    public final EObject ruleEventDerivation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_condition_1_0 = null;

        EObject lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:889:28: ( (otherlv_0= '=' ( (lv_condition_1_0= ruleExpression ) ) (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:890:1: (otherlv_0= '=' ( (lv_condition_1_0= ruleExpression ) ) (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:890:1: (otherlv_0= '=' ( (lv_condition_1_0= ruleExpression ) ) (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:890:3: otherlv_0= '=' ( (lv_condition_1_0= ruleExpression ) ) (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )?
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleEventDerivation1849); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEventDerivationAccess().getEqualsSignKeyword_0());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:894:1: ( (lv_condition_1_0= ruleExpression ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:895:1: (lv_condition_1_0= ruleExpression )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:895:1: (lv_condition_1_0= ruleExpression )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:896:3: lv_condition_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEventDerivationAccess().getConditionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleEventDerivation1870);
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

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:912:2: (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==19) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:912:4: otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleEventDerivation1883); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getEventDerivationAccess().getColonKeyword_2_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:916:1: ( (lv_value_3_0= ruleExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:917:1: (lv_value_3_0= ruleExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:917:1: (lv_value_3_0= ruleExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:918:3: lv_value_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEventDerivationAccess().getValueExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleEventDerivation1904);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:942:1: entryRuleVariableDefinition returns [EObject current=null] : iv_ruleVariableDefinition= ruleVariableDefinition EOF ;
    public final EObject entryRuleVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDefinition = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:943:2: (iv_ruleVariableDefinition= ruleVariableDefinition EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:944:2: iv_ruleVariableDefinition= ruleVariableDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition1942);
            iv_ruleVariableDefinition=ruleVariableDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDefinition1952); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:951:1: ruleVariableDefinition returns [EObject current=null] : ( () otherlv_1= 'var' ( ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( ( ruleFQN ) ) (otherlv_8= '=' ( (lv_initialValue_9_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVariableDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_readonly_3_0=null;
        Token lv_external_4_0=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_initialValue_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:954:28: ( ( () otherlv_1= 'var' ( ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( ( ruleFQN ) ) (otherlv_8= '=' ( (lv_initialValue_9_0= ruleExpression ) ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:955:1: ( () otherlv_1= 'var' ( ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( ( ruleFQN ) ) (otherlv_8= '=' ( (lv_initialValue_9_0= ruleExpression ) ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:955:1: ( () otherlv_1= 'var' ( ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( ( ruleFQN ) ) (otherlv_8= '=' ( (lv_initialValue_9_0= ruleExpression ) ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:955:2: () otherlv_1= 'var' ( ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( ( ruleFQN ) ) (otherlv_8= '=' ( (lv_initialValue_9_0= ruleExpression ) ) )?
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:955:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:956:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getVariableDefinitionAccess().getVariableDefinitionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleVariableDefinition1998); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getVariableDefinitionAccess().getVarKeyword_1());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:965:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:967:1: ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:967:1: ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:968:2: ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2());
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:971:2: ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:972:3: ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )*
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:972:3: ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )*
            loop17:
            do {
                int alt17=3;
                int LA17_0 = input.LA(1);

                if ( LA17_0 ==24 && getUnorderedGroupHelper().canSelect(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2(), 0) ) {
                    alt17=1;
                }
                else if ( LA17_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2(), 1) ) {
                    alt17=2;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:974:4: ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:974:4: ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:975:5: {...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleVariableDefinition", "getUnorderedGroupHelper().canSelect(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:975:115: ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:976:6: ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2(), 0);
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:979:6: ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:979:7: {...}? => ( (lv_readonly_3_0= 'readonly' ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleVariableDefinition", "true");
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:979:16: ( (lv_readonly_3_0= 'readonly' ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:980:1: (lv_readonly_3_0= 'readonly' )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:980:1: (lv_readonly_3_0= 'readonly' )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:981:3: lv_readonly_3_0= 'readonly'
            	    {
            	    lv_readonly_3_0=(Token)match(input,24,FOLLOW_24_in_ruleVariableDefinition2061); if (state.failed) return current;
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
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1001:4: ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1001:4: ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1002:5: {...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleVariableDefinition", "getUnorderedGroupHelper().canSelect(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1002:115: ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1003:6: ({...}? => ( (lv_external_4_0= 'external' ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2(), 1);
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1006:6: ({...}? => ( (lv_external_4_0= 'external' ) ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1006:7: {...}? => ( (lv_external_4_0= 'external' ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleVariableDefinition", "true");
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1006:16: ( (lv_external_4_0= 'external' ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1007:1: (lv_external_4_0= 'external' )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1007:1: (lv_external_4_0= 'external' )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1008:3: lv_external_4_0= 'external'
            	    {
            	    lv_external_4_0=(Token)match(input,25,FOLLOW_25_in_ruleVariableDefinition2146); if (state.failed) return current;
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
            	    break loop17;
                }
            } while (true);


            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2());

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1035:2: ( (lv_name_5_0= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1036:1: (lv_name_5_0= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1036:1: (lv_name_5_0= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1037:3: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableDefinition2216); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleVariableDefinition2233); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getVariableDefinitionAccess().getColonKeyword_4());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1057:1: ( ( ruleFQN ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1058:1: ( ruleFQN )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1058:1: ( ruleFQN )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1059:3: ruleFQN
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getVariableDefinitionRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getTypeTypeCrossReference_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFQN_in_ruleVariableDefinition2256);
            ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1072:2: (otherlv_8= '=' ( (lv_initialValue_9_0= ruleExpression ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==22) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1072:4: otherlv_8= '=' ( (lv_initialValue_9_0= ruleExpression ) )
                    {
                    otherlv_8=(Token)match(input,22,FOLLOW_22_in_ruleVariableDefinition2269); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getVariableDefinitionAccess().getEqualsSignKeyword_6_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1076:1: ( (lv_initialValue_9_0= ruleExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1077:1: (lv_initialValue_9_0= ruleExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1077:1: (lv_initialValue_9_0= ruleExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1078:3: lv_initialValue_9_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getInitialValueExpressionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDefinition2290);
                    lv_initialValue_9_0=ruleExpression();

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
    // $ANTLR end "ruleVariableDefinition"


    // $ANTLR start "entryRuleOperation"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1102:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1103:2: (iv_ruleOperation= ruleOperation EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1104:2: iv_ruleOperation= ruleOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationRule()); 
            }
            pushFollow(FOLLOW_ruleOperation_in_entryRuleOperation2328);
            iv_ruleOperation=ruleOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperation2338); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1111:1: ruleOperation returns [EObject current=null] : ( () otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( ( ruleFQN ) ) (otherlv_5= ',' ( ( ruleFQN ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( ( ruleFQN ) ) )? ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1114:28: ( ( () otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( ( ruleFQN ) ) (otherlv_5= ',' ( ( ruleFQN ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( ( ruleFQN ) ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1115:1: ( () otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( ( ruleFQN ) ) (otherlv_5= ',' ( ( ruleFQN ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( ( ruleFQN ) ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1115:1: ( () otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( ( ruleFQN ) ) (otherlv_5= ',' ( ( ruleFQN ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( ( ruleFQN ) ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1115:2: () otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( ( ruleFQN ) ) (otherlv_5= ',' ( ( ruleFQN ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( ( ruleFQN ) ) )?
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1115:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1116:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getOperationAccess().getOperationAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,26,FOLLOW_26_in_ruleOperation2384); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOperationAccess().getOperationKeyword_1());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1125:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1126:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1126:1: (lv_name_2_0= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1127:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOperation2401); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,27,FOLLOW_27_in_ruleOperation2418); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_3());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1147:1: ( ( ( ruleFQN ) ) (otherlv_5= ',' ( ( ruleFQN ) ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1147:2: ( ( ruleFQN ) ) (otherlv_5= ',' ( ( ruleFQN ) ) )*
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1147:2: ( ( ruleFQN ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1148:1: ( ruleFQN )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1148:1: ( ruleFQN )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1149:3: ruleFQN
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getOperationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOperationAccess().getParamTypesTypeCrossReference_4_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFQN_in_ruleOperation2442);
                    ruleFQN();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1162:2: (otherlv_5= ',' ( ( ruleFQN ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==28) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1162:4: otherlv_5= ',' ( ( ruleFQN ) )
                    	    {
                    	    otherlv_5=(Token)match(input,28,FOLLOW_28_in_ruleOperation2455); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getOperationAccess().getCommaKeyword_4_1_0());
                    	          
                    	    }
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1166:1: ( ( ruleFQN ) )
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1167:1: ( ruleFQN )
                    	    {
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1167:1: ( ruleFQN )
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1168:3: ruleFQN
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getOperationRule());
                    	      	        }
                    	              
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationAccess().getParamTypesTypeCrossReference_4_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleFQN_in_ruleOperation2478);
                    	    ruleFQN();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
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

            otherlv_7=(Token)match(input,29,FOLLOW_29_in_ruleOperation2494); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getOperationAccess().getRightParenthesisKeyword_5());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1185:1: (otherlv_8= ':' ( ( ruleFQN ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==19) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1185:3: otherlv_8= ':' ( ( ruleFQN ) )
                    {
                    otherlv_8=(Token)match(input,19,FOLLOW_19_in_ruleOperation2507); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getOperationAccess().getColonKeyword_6_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1189:1: ( ( ruleFQN ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1190:1: ( ruleFQN )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1190:1: ( ruleFQN )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1191:3: ruleFQN
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getOperationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOperationAccess().getTypeTypeCrossReference_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFQN_in_ruleOperation2530);
                    ruleFQN();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1212:1: entryRuleEntrypoint returns [EObject current=null] : iv_ruleEntrypoint= ruleEntrypoint EOF ;
    public final EObject entryRuleEntrypoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntrypoint = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1213:2: (iv_ruleEntrypoint= ruleEntrypoint EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1214:2: iv_ruleEntrypoint= ruleEntrypoint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEntrypointRule()); 
            }
            pushFollow(FOLLOW_ruleEntrypoint_in_entryRuleEntrypoint2568);
            iv_ruleEntrypoint=ruleEntrypoint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEntrypoint; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntrypoint2578); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1221:1: ruleEntrypoint returns [EObject current=null] : ( () otherlv_1= 'entrypoint' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleEntrypoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1224:28: ( ( () otherlv_1= 'entrypoint' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1225:1: ( () otherlv_1= 'entrypoint' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1225:1: ( () otherlv_1= 'entrypoint' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1225:2: () otherlv_1= 'entrypoint' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1225:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1226:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEntrypointAccess().getEntrypointAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleEntrypoint2624); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEntrypointAccess().getEntrypointKeyword_1());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1235:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1236:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1236:1: (lv_name_2_0= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1237:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntrypoint2641); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1261:1: entryRuleExitpoint returns [EObject current=null] : iv_ruleExitpoint= ruleExitpoint EOF ;
    public final EObject entryRuleExitpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitpoint = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1262:2: (iv_ruleExitpoint= ruleExitpoint EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1263:2: iv_ruleExitpoint= ruleExitpoint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExitpointRule()); 
            }
            pushFollow(FOLLOW_ruleExitpoint_in_entryRuleExitpoint2682);
            iv_ruleExitpoint=ruleExitpoint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExitpoint; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitpoint2692); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1270:1: ruleExitpoint returns [EObject current=null] : ( () otherlv_1= 'exitpoint' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleExitpoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1273:28: ( ( () otherlv_1= 'exitpoint' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1274:1: ( () otherlv_1= 'exitpoint' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1274:1: ( () otherlv_1= 'exitpoint' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1274:2: () otherlv_1= 'exitpoint' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1274:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1275:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getExitpointAccess().getExitpointAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleExitpoint2738); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getExitpointAccess().getExitpointKeyword_1());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1284:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1285:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1285:1: (lv_name_2_0= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1286:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExitpoint2755); if (state.failed) return current;
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


    // $ANTLR start "entryRuleFQN"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1310:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1311:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1312:2: iv_ruleFQN= ruleFQN EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFQNRule()); 
            }
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN2797);
            iv_ruleFQN=ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFQN.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN2808); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1319:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1322:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1323:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1323:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1323:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN2848); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1330:1: (kw= '.' this_ID_2= RULE_ID )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==32) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1331:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,32,FOLLOW_32_in_ruleFQN2867); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN2882); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop22;
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
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleLocalReaction"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1353:1: entryRuleLocalReaction returns [EObject current=null] : iv_ruleLocalReaction= ruleLocalReaction EOF ;
    public final EObject entryRuleLocalReaction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalReaction = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1354:2: (iv_ruleLocalReaction= ruleLocalReaction EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1355:2: iv_ruleLocalReaction= ruleLocalReaction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLocalReactionRule()); 
            }
            pushFollow(FOLLOW_ruleLocalReaction_in_entryRuleLocalReaction2931);
            iv_ruleLocalReaction=ruleLocalReaction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLocalReaction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocalReaction2941); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1362:1: ruleLocalReaction returns [EObject current=null] : ( ( (lv_trigger_0_0= ruleReactionTrigger ) ) (otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) ) ) (otherlv_3= '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )? ) ;
    public final EObject ruleLocalReaction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_trigger_0_0 = null;

        EObject lv_effect_2_0 = null;

        EObject lv_properties_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1365:28: ( ( ( (lv_trigger_0_0= ruleReactionTrigger ) ) (otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) ) ) (otherlv_3= '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1366:1: ( ( (lv_trigger_0_0= ruleReactionTrigger ) ) (otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) ) ) (otherlv_3= '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1366:1: ( ( (lv_trigger_0_0= ruleReactionTrigger ) ) (otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) ) ) (otherlv_3= '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1366:2: ( (lv_trigger_0_0= ruleReactionTrigger ) ) (otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) ) ) (otherlv_3= '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )?
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1366:2: ( (lv_trigger_0_0= ruleReactionTrigger ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1367:1: (lv_trigger_0_0= ruleReactionTrigger )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1367:1: (lv_trigger_0_0= ruleReactionTrigger )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1368:3: lv_trigger_0_0= ruleReactionTrigger
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLocalReactionAccess().getTriggerReactionTriggerParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleReactionTrigger_in_ruleLocalReaction2987);
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

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1384:2: (otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1384:4: otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) )
            {
            otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleLocalReaction3000); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLocalReactionAccess().getSolidusKeyword_1_0());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1388:1: ( (lv_effect_2_0= ruleReactionEffect ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1389:1: (lv_effect_2_0= ruleReactionEffect )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1389:1: (lv_effect_2_0= ruleReactionEffect )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1390:3: lv_effect_2_0= ruleReactionEffect
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLocalReactionAccess().getEffectReactionEffectParserRuleCall_1_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleReactionEffect_in_ruleLocalReaction3021);
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

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1406:3: (otherlv_3= '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==34) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1406:5: otherlv_3= '#' ( (lv_properties_4_0= ruleReactionProperties ) )
                    {
                    otherlv_3=(Token)match(input,34,FOLLOW_34_in_ruleLocalReaction3035); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getLocalReactionAccess().getNumberSignKeyword_2_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1410:1: ( (lv_properties_4_0= ruleReactionProperties ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1411:1: (lv_properties_4_0= ruleReactionProperties )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1411:1: (lv_properties_4_0= ruleReactionProperties )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1412:3: lv_properties_4_0= ruleReactionProperties
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLocalReactionAccess().getPropertiesReactionPropertiesParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleReactionProperties_in_ruleLocalReaction3056);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1436:1: entryRuleTransitionReaction returns [EObject current=null] : iv_ruleTransitionReaction= ruleTransitionReaction EOF ;
    public final EObject entryRuleTransitionReaction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionReaction = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1437:2: (iv_ruleTransitionReaction= ruleTransitionReaction EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1438:2: iv_ruleTransitionReaction= ruleTransitionReaction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransitionReactionRule()); 
            }
            pushFollow(FOLLOW_ruleTransitionReaction_in_entryRuleTransitionReaction3094);
            iv_ruleTransitionReaction=ruleTransitionReaction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransitionReaction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionReaction3104); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1445:1: ruleTransitionReaction returns [EObject current=null] : ( () ( (lv_trigger_1_0= ruleReactionTrigger ) )? (otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) ) )? (otherlv_4= '#' ( (lv_properties_5_0= ruleReactionProperties ) ) )? ) ;
    public final EObject ruleTransitionReaction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_trigger_1_0 = null;

        EObject lv_effect_3_0 = null;

        EObject lv_properties_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1448:28: ( ( () ( (lv_trigger_1_0= ruleReactionTrigger ) )? (otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) ) )? (otherlv_4= '#' ( (lv_properties_5_0= ruleReactionProperties ) ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1449:1: ( () ( (lv_trigger_1_0= ruleReactionTrigger ) )? (otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) ) )? (otherlv_4= '#' ( (lv_properties_5_0= ruleReactionProperties ) ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1449:1: ( () ( (lv_trigger_1_0= ruleReactionTrigger ) )? (otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) ) )? (otherlv_4= '#' ( (lv_properties_5_0= ruleReactionProperties ) ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1449:2: () ( (lv_trigger_1_0= ruleReactionTrigger ) )? (otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) ) )? (otherlv_4= '#' ( (lv_properties_5_0= ruleReactionProperties ) ) )?
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1449:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1450:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getTransitionReactionAccess().getTransitionReactionAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1455:2: ( (lv_trigger_1_0= ruleReactionTrigger ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID||LA24_0==35||(LA24_0>=39 && LA24_0<=44)||(LA24_0>=58 && LA24_0<=59)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1456:1: (lv_trigger_1_0= ruleReactionTrigger )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1456:1: (lv_trigger_1_0= ruleReactionTrigger )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1457:3: lv_trigger_1_0= ruleReactionTrigger
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTransitionReactionAccess().getTriggerReactionTriggerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleReactionTrigger_in_ruleTransitionReaction3159);
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

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1473:3: (otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==33) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1473:5: otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) )
                    {
                    otherlv_2=(Token)match(input,33,FOLLOW_33_in_ruleTransitionReaction3173); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTransitionReactionAccess().getSolidusKeyword_2_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1477:1: ( (lv_effect_3_0= ruleReactionEffect ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1478:1: (lv_effect_3_0= ruleReactionEffect )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1478:1: (lv_effect_3_0= ruleReactionEffect )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1479:3: lv_effect_3_0= ruleReactionEffect
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTransitionReactionAccess().getEffectReactionEffectParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleReactionEffect_in_ruleTransitionReaction3194);
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

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1495:4: (otherlv_4= '#' ( (lv_properties_5_0= ruleReactionProperties ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==34) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1495:6: otherlv_4= '#' ( (lv_properties_5_0= ruleReactionProperties ) )
                    {
                    otherlv_4=(Token)match(input,34,FOLLOW_34_in_ruleTransitionReaction3209); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getTransitionReactionAccess().getNumberSignKeyword_3_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1499:1: ( (lv_properties_5_0= ruleReactionProperties ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1500:1: (lv_properties_5_0= ruleReactionProperties )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1500:1: (lv_properties_5_0= ruleReactionProperties )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1501:3: lv_properties_5_0= ruleReactionProperties
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTransitionReactionAccess().getPropertiesReactionPropertiesParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleReactionProperties_in_ruleTransitionReaction3230);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1525:1: entryRuleReactionTrigger returns [EObject current=null] : iv_ruleReactionTrigger= ruleReactionTrigger EOF ;
    public final EObject entryRuleReactionTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReactionTrigger = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1526:2: (iv_ruleReactionTrigger= ruleReactionTrigger EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1527:2: iv_ruleReactionTrigger= ruleReactionTrigger EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReactionTriggerRule()); 
            }
            pushFollow(FOLLOW_ruleReactionTrigger_in_entryRuleReactionTrigger3268);
            iv_ruleReactionTrigger=ruleReactionTrigger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReactionTrigger; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReactionTrigger3278); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1534:1: ruleReactionTrigger returns [EObject current=null] : ( () ( ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )? ) | (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ) ;
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
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1537:28: ( ( () ( ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )? ) | (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1538:1: ( () ( ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )? ) | (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1538:1: ( () ( ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )? ) | (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1538:2: () ( ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )? ) | (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1538:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1539:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getReactionTriggerAccess().getReactionTriggerAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1544:2: ( ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )? ) | (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID||(LA29_0>=39 && LA29_0<=44)||(LA29_0>=58 && LA29_0<=59)) ) {
                alt29=1;
            }
            else if ( (LA29_0==35) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1544:3: ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )? )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1544:3: ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )? )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1544:4: ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )?
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1544:4: ( (lv_triggers_1_0= ruleEventSpec ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1545:1: (lv_triggers_1_0= ruleEventSpec )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1545:1: (lv_triggers_1_0= ruleEventSpec )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1546:3: lv_triggers_1_0= ruleEventSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getReactionTriggerAccess().getTriggersEventSpecParserRuleCall_1_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEventSpec_in_ruleReactionTrigger3335);
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

                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1562:2: (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==28) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1562:4: otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) )
                    	    {
                    	    otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleReactionTrigger3348); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getReactionTriggerAccess().getCommaKeyword_1_0_1_0());
                    	          
                    	    }
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1566:1: ( (lv_triggers_3_0= ruleEventSpec ) )
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1567:1: (lv_triggers_3_0= ruleEventSpec )
                    	    {
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1567:1: (lv_triggers_3_0= ruleEventSpec )
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1568:3: lv_triggers_3_0= ruleEventSpec
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getReactionTriggerAccess().getTriggersEventSpecParserRuleCall_1_0_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleEventSpec_in_ruleReactionTrigger3369);
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
                    	    break loop27;
                        }
                    } while (true);

                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1584:4: ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']' )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==35) && (synpred1_InternalSText())) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1584:5: ( ( '[' )=>otherlv_4= '[' ) ( (lv_guardExpression_5_0= ruleExpression ) ) otherlv_6= ']'
                            {
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1584:5: ( ( '[' )=>otherlv_4= '[' )
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1584:6: ( '[' )=>otherlv_4= '['
                            {
                            otherlv_4=(Token)match(input,35,FOLLOW_35_in_ruleReactionTrigger3392); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getReactionTriggerAccess().getLeftSquareBracketKeyword_1_0_2_0());
                                  
                            }

                            }

                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1589:2: ( (lv_guardExpression_5_0= ruleExpression ) )
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1590:1: (lv_guardExpression_5_0= ruleExpression )
                            {
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1590:1: (lv_guardExpression_5_0= ruleExpression )
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1591:3: lv_guardExpression_5_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getReactionTriggerAccess().getGuardExpressionExpressionParserRuleCall_1_0_2_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExpression_in_ruleReactionTrigger3414);
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

                            otherlv_6=(Token)match(input,36,FOLLOW_36_in_ruleReactionTrigger3426); if (state.failed) return current;
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1612:6: (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1612:6: (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1612:8: otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']'
                    {
                    otherlv_7=(Token)match(input,35,FOLLOW_35_in_ruleReactionTrigger3448); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getReactionTriggerAccess().getLeftSquareBracketKeyword_1_1_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1616:1: ( (lv_guardExpression_8_0= ruleExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1617:1: (lv_guardExpression_8_0= ruleExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1617:1: (lv_guardExpression_8_0= ruleExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1618:3: lv_guardExpression_8_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getReactionTriggerAccess().getGuardExpressionExpressionParserRuleCall_1_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleReactionTrigger3469);
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

                    otherlv_9=(Token)match(input,36,FOLLOW_36_in_ruleReactionTrigger3481); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1646:1: entryRuleReactionEffect returns [EObject current=null] : iv_ruleReactionEffect= ruleReactionEffect EOF ;
    public final EObject entryRuleReactionEffect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReactionEffect = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1647:2: (iv_ruleReactionEffect= ruleReactionEffect EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1648:2: iv_ruleReactionEffect= ruleReactionEffect EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReactionEffectRule()); 
            }
            pushFollow(FOLLOW_ruleReactionEffect_in_entryRuleReactionEffect3519);
            iv_ruleReactionEffect=ruleReactionEffect();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReactionEffect; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReactionEffect3529); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1655:1: ruleReactionEffect returns [EObject current=null] : ( () ( (lv_actions_1_0= ruleStatement ) ) (otherlv_2= ';' ( (lv_actions_3_0= ruleStatement ) ) )* (otherlv_4= ';' )? ) ;
    public final EObject ruleReactionEffect() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_actions_1_0 = null;

        EObject lv_actions_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1658:28: ( ( () ( (lv_actions_1_0= ruleStatement ) ) (otherlv_2= ';' ( (lv_actions_3_0= ruleStatement ) ) )* (otherlv_4= ';' )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1659:1: ( () ( (lv_actions_1_0= ruleStatement ) ) (otherlv_2= ';' ( (lv_actions_3_0= ruleStatement ) ) )* (otherlv_4= ';' )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1659:1: ( () ( (lv_actions_1_0= ruleStatement ) ) (otherlv_2= ';' ( (lv_actions_3_0= ruleStatement ) ) )* (otherlv_4= ';' )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1659:2: () ( (lv_actions_1_0= ruleStatement ) ) (otherlv_2= ';' ( (lv_actions_3_0= ruleStatement ) ) )* (otherlv_4= ';' )?
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1659:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1660:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getReactionEffectAccess().getReactionEffectAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1665:2: ( (lv_actions_1_0= ruleStatement ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1666:1: (lv_actions_1_0= ruleStatement )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1666:1: (lv_actions_1_0= ruleStatement )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1667:3: lv_actions_1_0= ruleStatement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReactionEffectAccess().getActionsStatementParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStatement_in_ruleReactionEffect3584);
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

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1683:2: (otherlv_2= ';' ( (lv_actions_3_0= ruleStatement ) ) )*
            loop30:
            do {
                int alt30=2;
                alt30 = dfa30.predict(input);
                switch (alt30) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1683:4: otherlv_2= ';' ( (lv_actions_3_0= ruleStatement ) )
            	    {
            	    otherlv_2=(Token)match(input,37,FOLLOW_37_in_ruleReactionEffect3597); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getReactionEffectAccess().getSemicolonKeyword_2_0());
            	          
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1687:1: ( (lv_actions_3_0= ruleStatement ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1688:1: (lv_actions_3_0= ruleStatement )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1688:1: (lv_actions_3_0= ruleStatement )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1689:3: lv_actions_3_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getReactionEffectAccess().getActionsStatementParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleStatement_in_ruleReactionEffect3618);
            	    lv_actions_3_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getReactionEffectRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"actions",
            	              		lv_actions_3_0, 
            	              		"Statement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1705:4: (otherlv_4= ';' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==37) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1705:6: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,37,FOLLOW_37_in_ruleReactionEffect3633); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getReactionEffectAccess().getSemicolonKeyword_3());
                          
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
    // $ANTLR end "ruleReactionEffect"


    // $ANTLR start "entryRuleReactionProperties"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1717:1: entryRuleReactionProperties returns [EObject current=null] : iv_ruleReactionProperties= ruleReactionProperties EOF ;
    public final EObject entryRuleReactionProperties() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReactionProperties = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1718:2: (iv_ruleReactionProperties= ruleReactionProperties EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1719:2: iv_ruleReactionProperties= ruleReactionProperties EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReactionPropertiesRule()); 
            }
            pushFollow(FOLLOW_ruleReactionProperties_in_entryRuleReactionProperties3671);
            iv_ruleReactionProperties=ruleReactionProperties();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReactionProperties; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReactionProperties3681); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1726:1: ruleReactionProperties returns [EObject current=null] : ( () ( (lv_properties_1_0= ruleReactionProperty ) )* ) ;
    public final EObject ruleReactionProperties() throws RecognitionException {
        EObject current = null;

        EObject lv_properties_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1729:28: ( ( () ( (lv_properties_1_0= ruleReactionProperty ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1730:1: ( () ( (lv_properties_1_0= ruleReactionProperty ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1730:1: ( () ( (lv_properties_1_0= ruleReactionProperty ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1730:2: () ( (lv_properties_1_0= ruleReactionProperty ) )*
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1730:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1731:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getReactionPropertiesAccess().getReactionPropertiesAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1736:2: ( (lv_properties_1_0= ruleReactionProperty ) )*
            loop32:
            do {
                int alt32=2;
                alt32 = dfa32.predict(input);
                switch (alt32) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1737:1: (lv_properties_1_0= ruleReactionProperty )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1737:1: (lv_properties_1_0= ruleReactionProperty )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1738:3: lv_properties_1_0= ruleReactionProperty
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getReactionPropertiesAccess().getPropertiesReactionPropertyParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleReactionProperty_in_ruleReactionProperties3736);
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
            	    break loop32;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1762:1: entryRuleReactionProperty returns [EObject current=null] : iv_ruleReactionProperty= ruleReactionProperty EOF ;
    public final EObject entryRuleReactionProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReactionProperty = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1763:2: (iv_ruleReactionProperty= ruleReactionProperty EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1764:2: iv_ruleReactionProperty= ruleReactionProperty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReactionPropertyRule()); 
            }
            pushFollow(FOLLOW_ruleReactionProperty_in_entryRuleReactionProperty3773);
            iv_ruleReactionProperty=ruleReactionProperty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReactionProperty; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReactionProperty3783); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1771:1: ruleReactionProperty returns [EObject current=null] : (this_EntryPointSpec_0= ruleEntryPointSpec | this_ExitPointSpec_1= ruleExitPointSpec ) ;
    public final EObject ruleReactionProperty() throws RecognitionException {
        EObject current = null;

        EObject this_EntryPointSpec_0 = null;

        EObject this_ExitPointSpec_1 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1774:28: ( (this_EntryPointSpec_0= ruleEntryPointSpec | this_ExitPointSpec_1= ruleExitPointSpec ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1775:1: (this_EntryPointSpec_0= ruleEntryPointSpec | this_ExitPointSpec_1= ruleExitPointSpec )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1775:1: (this_EntryPointSpec_0= ruleEntryPointSpec | this_ExitPointSpec_1= ruleExitPointSpec )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==38) ) {
                alt33=1;
            }
            else if ( (LA33_0==RULE_ID) ) {
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1776:5: this_EntryPointSpec_0= ruleEntryPointSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getReactionPropertyAccess().getEntryPointSpecParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEntryPointSpec_in_ruleReactionProperty3830);
                    this_EntryPointSpec_0=ruleEntryPointSpec();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_EntryPointSpec_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1786:5: this_ExitPointSpec_1= ruleExitPointSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getReactionPropertyAccess().getExitPointSpecParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExitPointSpec_in_ruleReactionProperty3857);
                    this_ExitPointSpec_1=ruleExitPointSpec();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ExitPointSpec_1; 
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


    // $ANTLR start "entryRuleEntryPointSpec"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1802:1: entryRuleEntryPointSpec returns [EObject current=null] : iv_ruleEntryPointSpec= ruleEntryPointSpec EOF ;
    public final EObject entryRuleEntryPointSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryPointSpec = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1803:2: (iv_ruleEntryPointSpec= ruleEntryPointSpec EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1804:2: iv_ruleEntryPointSpec= ruleEntryPointSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEntryPointSpecRule()); 
            }
            pushFollow(FOLLOW_ruleEntryPointSpec_in_entryRuleEntryPointSpec3892);
            iv_ruleEntryPointSpec=ruleEntryPointSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEntryPointSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryPointSpec3902); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1811:1: ruleEntryPointSpec returns [EObject current=null] : (otherlv_0= '>' ( ( ruleFQN ) ) ) ;
    public final EObject ruleEntryPointSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1814:28: ( (otherlv_0= '>' ( ( ruleFQN ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1815:1: (otherlv_0= '>' ( ( ruleFQN ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1815:1: (otherlv_0= '>' ( ( ruleFQN ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1815:3: otherlv_0= '>' ( ( ruleFQN ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleEntryPointSpec3939); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEntryPointSpecAccess().getGreaterThanSignKeyword_0());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1819:1: ( ( ruleFQN ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1820:1: ( ruleFQN )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1820:1: ( ruleFQN )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1821:3: ruleFQN
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getEntryPointSpecRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEntryPointSpecAccess().getEntrypointEntrypointCrossReference_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFQN_in_ruleEntryPointSpec3962);
            ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
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
    // $ANTLR end "ruleEntryPointSpec"


    // $ANTLR start "entryRuleExitPointSpec"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1842:1: entryRuleExitPointSpec returns [EObject current=null] : iv_ruleExitPointSpec= ruleExitPointSpec EOF ;
    public final EObject entryRuleExitPointSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitPointSpec = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1843:2: (iv_ruleExitPointSpec= ruleExitPointSpec EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1844:2: iv_ruleExitPointSpec= ruleExitPointSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExitPointSpecRule()); 
            }
            pushFollow(FOLLOW_ruleExitPointSpec_in_entryRuleExitPointSpec3998);
            iv_ruleExitPointSpec=ruleExitPointSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExitPointSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitPointSpec4008); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1851:1: ruleExitPointSpec returns [EObject current=null] : ( ( ( ruleFQN ) ) otherlv_1= '>' ) ;
    public final EObject ruleExitPointSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1854:28: ( ( ( ( ruleFQN ) ) otherlv_1= '>' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1855:1: ( ( ( ruleFQN ) ) otherlv_1= '>' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1855:1: ( ( ( ruleFQN ) ) otherlv_1= '>' )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1855:2: ( ( ruleFQN ) ) otherlv_1= '>'
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1855:2: ( ( ruleFQN ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1856:1: ( ruleFQN )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1856:1: ( ruleFQN )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1857:3: ruleFQN
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getExitPointSpecRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExitPointSpecAccess().getExitpointExitpointCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFQN_in_ruleExitPointSpec4056);
            ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleExitPointSpec4068); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1882:1: entryRuleEventSpec returns [EObject current=null] : iv_ruleEventSpec= ruleEventSpec EOF ;
    public final EObject entryRuleEventSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventSpec = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1883:2: (iv_ruleEventSpec= ruleEventSpec EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1884:2: iv_ruleEventSpec= ruleEventSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventSpecRule()); 
            }
            pushFollow(FOLLOW_ruleEventSpec_in_entryRuleEventSpec4104);
            iv_ruleEventSpec=ruleEventSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventSpec4114); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1891:1: ruleEventSpec returns [EObject current=null] : (this_RegularEventSpec_0= ruleRegularEventSpec | this_TimeEventSpec_1= ruleTimeEventSpec | this_BuiltinEventSpec_2= ruleBuiltinEventSpec ) ;
    public final EObject ruleEventSpec() throws RecognitionException {
        EObject current = null;

        EObject this_RegularEventSpec_0 = null;

        EObject this_TimeEventSpec_1 = null;

        EObject this_BuiltinEventSpec_2 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1894:28: ( (this_RegularEventSpec_0= ruleRegularEventSpec | this_TimeEventSpec_1= ruleTimeEventSpec | this_BuiltinEventSpec_2= ruleBuiltinEventSpec ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1895:1: (this_RegularEventSpec_0= ruleRegularEventSpec | this_TimeEventSpec_1= ruleTimeEventSpec | this_BuiltinEventSpec_2= ruleBuiltinEventSpec )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1895:1: (this_RegularEventSpec_0= ruleRegularEventSpec | this_TimeEventSpec_1= ruleTimeEventSpec | this_BuiltinEventSpec_2= ruleBuiltinEventSpec )
            int alt34=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt34=1;
                }
                break;
            case 58:
            case 59:
                {
                alt34=2;
                }
                break;
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
                {
                alt34=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1896:5: this_RegularEventSpec_0= ruleRegularEventSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEventSpecAccess().getRegularEventSpecParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRegularEventSpec_in_ruleEventSpec4161);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1906:5: this_TimeEventSpec_1= ruleTimeEventSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEventSpecAccess().getTimeEventSpecParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTimeEventSpec_in_ruleEventSpec4188);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1916:5: this_BuiltinEventSpec_2= ruleBuiltinEventSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEventSpecAccess().getBuiltinEventSpecParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBuiltinEventSpec_in_ruleEventSpec4215);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1932:1: entryRuleRegularEventSpec returns [EObject current=null] : iv_ruleRegularEventSpec= ruleRegularEventSpec EOF ;
    public final EObject entryRuleRegularEventSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegularEventSpec = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1933:2: (iv_ruleRegularEventSpec= ruleRegularEventSpec EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1934:2: iv_ruleRegularEventSpec= ruleRegularEventSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRegularEventSpecRule()); 
            }
            pushFollow(FOLLOW_ruleRegularEventSpec_in_entryRuleRegularEventSpec4250);
            iv_ruleRegularEventSpec=ruleRegularEventSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRegularEventSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRegularEventSpec4260); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1941:1: ruleRegularEventSpec returns [EObject current=null] : ( ( ruleFQN ) ) ;
    public final EObject ruleRegularEventSpec() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1944:28: ( ( ( ruleFQN ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1945:1: ( ( ruleFQN ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1945:1: ( ( ruleFQN ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1946:1: ( ruleFQN )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1946:1: ( ruleFQN )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1947:3: ruleFQN
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getRegularEventSpecRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRegularEventSpecAccess().getEventEventCrossReference_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFQN_in_ruleRegularEventSpec4307);
            ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
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
    // $ANTLR end "ruleRegularEventSpec"


    // $ANTLR start "entryRuleTimeEventSpec"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1968:1: entryRuleTimeEventSpec returns [EObject current=null] : iv_ruleTimeEventSpec= ruleTimeEventSpec EOF ;
    public final EObject entryRuleTimeEventSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeEventSpec = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1969:2: (iv_ruleTimeEventSpec= ruleTimeEventSpec EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1970:2: iv_ruleTimeEventSpec= ruleTimeEventSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTimeEventSpecRule()); 
            }
            pushFollow(FOLLOW_ruleTimeEventSpec_in_entryRuleTimeEventSpec4342);
            iv_ruleTimeEventSpec=ruleTimeEventSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTimeEventSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeEventSpec4352); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1977:1: ruleTimeEventSpec returns [EObject current=null] : ( ( (lv_type_0_0= ruleTimeEventType ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleTimeUnit ) )? ) ;
    public final EObject ruleTimeEventSpec() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Enumerator lv_type_0_0 = null;

        Enumerator lv_unit_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1980:28: ( ( ( (lv_type_0_0= ruleTimeEventType ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleTimeUnit ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1981:1: ( ( (lv_type_0_0= ruleTimeEventType ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleTimeUnit ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1981:1: ( ( (lv_type_0_0= ruleTimeEventType ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleTimeUnit ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1981:2: ( (lv_type_0_0= ruleTimeEventType ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleTimeUnit ) )?
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1981:2: ( (lv_type_0_0= ruleTimeEventType ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1982:1: (lv_type_0_0= ruleTimeEventType )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1982:1: (lv_type_0_0= ruleTimeEventType )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1983:3: lv_type_0_0= ruleTimeEventType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTimeEventSpecAccess().getTypeTimeEventTypeEnumRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTimeEventType_in_ruleTimeEventSpec4398);
            lv_type_0_0=ruleTimeEventType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTimeEventSpecRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_0_0, 
                      		"TimeEventType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1999:2: ( (lv_value_1_0= RULE_INT ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2000:1: (lv_value_1_0= RULE_INT )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2000:1: (lv_value_1_0= RULE_INT )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2001:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTimeEventSpec4415); if (state.failed) return current;
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

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2017:2: ( (lv_unit_2_0= ruleTimeUnit ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=82 && LA35_0<=85)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2018:1: (lv_unit_2_0= ruleTimeUnit )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2018:1: (lv_unit_2_0= ruleTimeUnit )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2019:3: lv_unit_2_0= ruleTimeUnit
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTimeEventSpecAccess().getUnitTimeUnitEnumRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTimeUnit_in_ruleTimeEventSpec4441);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2043:1: entryRuleBuiltinEventSpec returns [EObject current=null] : iv_ruleBuiltinEventSpec= ruleBuiltinEventSpec EOF ;
    public final EObject entryRuleBuiltinEventSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBuiltinEventSpec = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2044:2: (iv_ruleBuiltinEventSpec= ruleBuiltinEventSpec EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2045:2: iv_ruleBuiltinEventSpec= ruleBuiltinEventSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBuiltinEventSpecRule()); 
            }
            pushFollow(FOLLOW_ruleBuiltinEventSpec_in_entryRuleBuiltinEventSpec4478);
            iv_ruleBuiltinEventSpec=ruleBuiltinEventSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBuiltinEventSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBuiltinEventSpec4488); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2052:1: ruleBuiltinEventSpec returns [EObject current=null] : (this_EntryEvent_0= ruleEntryEvent | this_ExitEvent_1= ruleExitEvent | this_OnCycleEvent_2= ruleOnCycleEvent | this_AlwaysEvent_3= ruleAlwaysEvent | this_DefaultEvent_4= ruleDefaultEvent ) ;
    public final EObject ruleBuiltinEventSpec() throws RecognitionException {
        EObject current = null;

        EObject this_EntryEvent_0 = null;

        EObject this_ExitEvent_1 = null;

        EObject this_OnCycleEvent_2 = null;

        EObject this_AlwaysEvent_3 = null;

        EObject this_DefaultEvent_4 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2055:28: ( (this_EntryEvent_0= ruleEntryEvent | this_ExitEvent_1= ruleExitEvent | this_OnCycleEvent_2= ruleOnCycleEvent | this_AlwaysEvent_3= ruleAlwaysEvent | this_DefaultEvent_4= ruleDefaultEvent ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2056:1: (this_EntryEvent_0= ruleEntryEvent | this_ExitEvent_1= ruleExitEvent | this_OnCycleEvent_2= ruleOnCycleEvent | this_AlwaysEvent_3= ruleAlwaysEvent | this_DefaultEvent_4= ruleDefaultEvent )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2056:1: (this_EntryEvent_0= ruleEntryEvent | this_ExitEvent_1= ruleExitEvent | this_OnCycleEvent_2= ruleOnCycleEvent | this_AlwaysEvent_3= ruleAlwaysEvent | this_DefaultEvent_4= ruleDefaultEvent )
            int alt36=5;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt36=1;
                }
                break;
            case 40:
                {
                alt36=2;
                }
                break;
            case 41:
                {
                alt36=3;
                }
                break;
            case 42:
                {
                alt36=4;
                }
                break;
            case 43:
            case 44:
                {
                alt36=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2057:5: this_EntryEvent_0= ruleEntryEvent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBuiltinEventSpecAccess().getEntryEventParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEntryEvent_in_ruleBuiltinEventSpec4535);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2067:5: this_ExitEvent_1= ruleExitEvent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBuiltinEventSpecAccess().getExitEventParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExitEvent_in_ruleBuiltinEventSpec4562);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2077:5: this_OnCycleEvent_2= ruleOnCycleEvent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBuiltinEventSpecAccess().getOnCycleEventParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOnCycleEvent_in_ruleBuiltinEventSpec4589);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2087:5: this_AlwaysEvent_3= ruleAlwaysEvent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBuiltinEventSpecAccess().getAlwaysEventParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAlwaysEvent_in_ruleBuiltinEventSpec4616);
                    this_AlwaysEvent_3=ruleAlwaysEvent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AlwaysEvent_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2097:5: this_DefaultEvent_4= ruleDefaultEvent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBuiltinEventSpecAccess().getDefaultEventParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDefaultEvent_in_ruleBuiltinEventSpec4643);
                    this_DefaultEvent_4=ruleDefaultEvent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_DefaultEvent_4; 
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2113:1: entryRuleEntryEvent returns [EObject current=null] : iv_ruleEntryEvent= ruleEntryEvent EOF ;
    public final EObject entryRuleEntryEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryEvent = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2114:2: (iv_ruleEntryEvent= ruleEntryEvent EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2115:2: iv_ruleEntryEvent= ruleEntryEvent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEntryEventRule()); 
            }
            pushFollow(FOLLOW_ruleEntryEvent_in_entryRuleEntryEvent4678);
            iv_ruleEntryEvent=ruleEntryEvent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEntryEvent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryEvent4688); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2122:1: ruleEntryEvent returns [EObject current=null] : ( () otherlv_1= 'entry' ) ;
    public final EObject ruleEntryEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2125:28: ( ( () otherlv_1= 'entry' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2126:1: ( () otherlv_1= 'entry' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2126:1: ( () otherlv_1= 'entry' )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2126:2: () otherlv_1= 'entry'
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2126:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2127:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEntryEventAccess().getEntryEventAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleEntryEvent4734); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2144:1: entryRuleExitEvent returns [EObject current=null] : iv_ruleExitEvent= ruleExitEvent EOF ;
    public final EObject entryRuleExitEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitEvent = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2145:2: (iv_ruleExitEvent= ruleExitEvent EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2146:2: iv_ruleExitEvent= ruleExitEvent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExitEventRule()); 
            }
            pushFollow(FOLLOW_ruleExitEvent_in_entryRuleExitEvent4770);
            iv_ruleExitEvent=ruleExitEvent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExitEvent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitEvent4780); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2153:1: ruleExitEvent returns [EObject current=null] : ( () otherlv_1= 'exit' ) ;
    public final EObject ruleExitEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2156:28: ( ( () otherlv_1= 'exit' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2157:1: ( () otherlv_1= 'exit' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2157:1: ( () otherlv_1= 'exit' )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2157:2: () otherlv_1= 'exit'
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2157:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2158:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getExitEventAccess().getExitEventAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,40,FOLLOW_40_in_ruleExitEvent4826); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2175:1: entryRuleOnCycleEvent returns [EObject current=null] : iv_ruleOnCycleEvent= ruleOnCycleEvent EOF ;
    public final EObject entryRuleOnCycleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOnCycleEvent = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2176:2: (iv_ruleOnCycleEvent= ruleOnCycleEvent EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2177:2: iv_ruleOnCycleEvent= ruleOnCycleEvent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOnCycleEventRule()); 
            }
            pushFollow(FOLLOW_ruleOnCycleEvent_in_entryRuleOnCycleEvent4862);
            iv_ruleOnCycleEvent=ruleOnCycleEvent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOnCycleEvent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOnCycleEvent4872); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2184:1: ruleOnCycleEvent returns [EObject current=null] : ( () otherlv_1= 'oncycle' ) ;
    public final EObject ruleOnCycleEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2187:28: ( ( () otherlv_1= 'oncycle' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2188:1: ( () otherlv_1= 'oncycle' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2188:1: ( () otherlv_1= 'oncycle' )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2188:2: () otherlv_1= 'oncycle'
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2188:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2189:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getOnCycleEventAccess().getOnCycleEventAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleOnCycleEvent4918); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2206:1: entryRuleAlwaysEvent returns [EObject current=null] : iv_ruleAlwaysEvent= ruleAlwaysEvent EOF ;
    public final EObject entryRuleAlwaysEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlwaysEvent = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2207:2: (iv_ruleAlwaysEvent= ruleAlwaysEvent EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2208:2: iv_ruleAlwaysEvent= ruleAlwaysEvent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAlwaysEventRule()); 
            }
            pushFollow(FOLLOW_ruleAlwaysEvent_in_entryRuleAlwaysEvent4954);
            iv_ruleAlwaysEvent=ruleAlwaysEvent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAlwaysEvent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlwaysEvent4964); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2215:1: ruleAlwaysEvent returns [EObject current=null] : ( () otherlv_1= 'always' ) ;
    public final EObject ruleAlwaysEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2218:28: ( ( () otherlv_1= 'always' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2219:1: ( () otherlv_1= 'always' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2219:1: ( () otherlv_1= 'always' )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2219:2: () otherlv_1= 'always'
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2219:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2220:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAlwaysEventAccess().getAlwaysEventAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,42,FOLLOW_42_in_ruleAlwaysEvent5010); if (state.failed) return current;
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


    // $ANTLR start "entryRuleDefaultEvent"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2237:1: entryRuleDefaultEvent returns [EObject current=null] : iv_ruleDefaultEvent= ruleDefaultEvent EOF ;
    public final EObject entryRuleDefaultEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultEvent = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2238:2: (iv_ruleDefaultEvent= ruleDefaultEvent EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2239:2: iv_ruleDefaultEvent= ruleDefaultEvent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefaultEventRule()); 
            }
            pushFollow(FOLLOW_ruleDefaultEvent_in_entryRuleDefaultEvent5046);
            iv_ruleDefaultEvent=ruleDefaultEvent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefaultEvent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultEvent5056); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefaultEvent"


    // $ANTLR start "ruleDefaultEvent"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2246:1: ruleDefaultEvent returns [EObject current=null] : ( () (otherlv_1= 'default' | otherlv_2= 'else' ) ) ;
    public final EObject ruleDefaultEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2249:28: ( ( () (otherlv_1= 'default' | otherlv_2= 'else' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2250:1: ( () (otherlv_1= 'default' | otherlv_2= 'else' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2250:1: ( () (otherlv_1= 'default' | otherlv_2= 'else' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2250:2: () (otherlv_1= 'default' | otherlv_2= 'else' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2250:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2251:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getDefaultEventAccess().getDefaultEventAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2256:2: (otherlv_1= 'default' | otherlv_2= 'else' )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==43) ) {
                alt37=1;
            }
            else if ( (LA37_0==44) ) {
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2256:4: otherlv_1= 'default'
                    {
                    otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleDefaultEvent5103); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getDefaultEventAccess().getDefaultKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2261:7: otherlv_2= 'else'
                    {
                    otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleDefaultEvent5121); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDefaultEventAccess().getElseKeyword_1_1());
                          
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
    // $ANTLR end "ruleDefaultEvent"


    // $ANTLR start "entryRuleStatement"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2273:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2274:2: (iv_ruleStatement= ruleStatement EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2275:2: iv_ruleStatement= ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRule()); 
            }
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement5158);
            iv_ruleStatement=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement5168); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2282:1: ruleStatement returns [EObject current=null] : (this_Assignment_0= ruleAssignment | this_EventRaising_1= ruleEventRaising | this_OperationCall_2= ruleOperationCall ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Assignment_0 = null;

        EObject this_EventRaising_1 = null;

        EObject this_OperationCall_2 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2285:28: ( (this_Assignment_0= ruleAssignment | this_EventRaising_1= ruleEventRaising | this_OperationCall_2= ruleOperationCall ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2286:1: (this_Assignment_0= ruleAssignment | this_EventRaising_1= ruleEventRaising | this_OperationCall_2= ruleOperationCall )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2286:1: (this_Assignment_0= ruleAssignment | this_EventRaising_1= ruleEventRaising | this_OperationCall_2= ruleOperationCall )
            int alt38=3;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2287:5: this_Assignment_0= ruleAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getAssignmentParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAssignment_in_ruleStatement5215);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2297:5: this_EventRaising_1= ruleEventRaising
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getEventRaisingParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEventRaising_in_ruleStatement5242);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2307:5: this_OperationCall_2= ruleOperationCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getOperationCallParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOperationCall_in_ruleStatement5269);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2323:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2324:2: (iv_ruleAssignment= ruleAssignment EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2325:2: iv_ruleAssignment= ruleAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment5304);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment5314); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2332:1: ruleAssignment returns [EObject current=null] : ( ( ( ruleFQN ) ) ( (lv_operator_1_0= ruleAssignmentOperator ) ) ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_1_0 = null;

        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2335:28: ( ( ( ( ruleFQN ) ) ( (lv_operator_1_0= ruleAssignmentOperator ) ) ( (lv_expression_2_0= ruleExpression ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2336:1: ( ( ( ruleFQN ) ) ( (lv_operator_1_0= ruleAssignmentOperator ) ) ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2336:1: ( ( ( ruleFQN ) ) ( (lv_operator_1_0= ruleAssignmentOperator ) ) ( (lv_expression_2_0= ruleExpression ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2336:2: ( ( ruleFQN ) ) ( (lv_operator_1_0= ruleAssignmentOperator ) ) ( (lv_expression_2_0= ruleExpression ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2336:2: ( ( ruleFQN ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2337:1: ( ruleFQN )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2337:1: ( ruleFQN )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2338:3: ruleFQN
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAssignmentRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentAccess().getVarRefVariableCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFQN_in_ruleAssignment5362);
            ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2351:2: ( (lv_operator_1_0= ruleAssignmentOperator ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2352:1: (lv_operator_1_0= ruleAssignmentOperator )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2352:1: (lv_operator_1_0= ruleAssignmentOperator )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2353:3: lv_operator_1_0= ruleAssignmentOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentAccess().getOperatorAssignmentOperatorEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAssignmentOperator_in_ruleAssignment5383);
            lv_operator_1_0=ruleAssignmentOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAssignmentRule());
              	        }
                     		set(
                     			current, 
                     			"operator",
                      		lv_operator_1_0, 
                      		"AssignmentOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2369:2: ( (lv_expression_2_0= ruleExpression ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2370:1: (lv_expression_2_0= ruleExpression )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2370:1: (lv_expression_2_0= ruleExpression )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2371:3: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentAccess().getExpressionExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleAssignment5404);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2395:1: entryRuleEventRaising returns [EObject current=null] : iv_ruleEventRaising= ruleEventRaising EOF ;
    public final EObject entryRuleEventRaising() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventRaising = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2396:2: (iv_ruleEventRaising= ruleEventRaising EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2397:2: iv_ruleEventRaising= ruleEventRaising EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventRaisingRule()); 
            }
            pushFollow(FOLLOW_ruleEventRaising_in_entryRuleEventRaising5440);
            iv_ruleEventRaising=ruleEventRaising();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventRaising; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventRaising5450); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2404:1: ruleEventRaising returns [EObject current=null] : (otherlv_0= 'raise' ( ( ruleFQN ) ) (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )? ) ;
    public final EObject ruleEventRaising() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2407:28: ( (otherlv_0= 'raise' ( ( ruleFQN ) ) (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2408:1: (otherlv_0= 'raise' ( ( ruleFQN ) ) (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2408:1: (otherlv_0= 'raise' ( ( ruleFQN ) ) (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2408:3: otherlv_0= 'raise' ( ( ruleFQN ) ) (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )?
            {
            otherlv_0=(Token)match(input,45,FOLLOW_45_in_ruleEventRaising5487); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEventRaisingAccess().getRaiseKeyword_0());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2412:1: ( ( ruleFQN ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2413:1: ( ruleFQN )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2413:1: ( ruleFQN )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2414:3: ruleFQN
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getEventRaisingRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEventRaisingAccess().getEventEventCrossReference_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFQN_in_ruleEventRaising5510);
            ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2427:2: (otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==19) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2427:4: otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleEventRaising5523); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getEventRaisingAccess().getColonKeyword_2_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2431:1: ( (lv_value_3_0= ruleExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2432:1: (lv_value_3_0= ruleExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2432:1: (lv_value_3_0= ruleExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2433:3: lv_value_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEventRaisingAccess().getValueExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleEventRaising5544);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2457:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2458:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2459:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression5582);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression5592); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2466:1: ruleExpression returns [EObject current=null] : this_ConditionalExpression_0= ruleConditionalExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionalExpression_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2469:28: (this_ConditionalExpression_0= ruleConditionalExpression )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2471:5: this_ConditionalExpression_0= ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExpressionAccess().getConditionalExpressionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleConditionalExpression_in_ruleExpression5638);
            this_ConditionalExpression_0=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ConditionalExpression_0; 
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


    // $ANTLR start "entryRuleConditionalExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2487:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2488:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2489:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression5672);
            iv_ruleConditionalExpression=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression5682); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2496:1: ruleConditionalExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_LogicalOrExpression_0 = null;

        EObject lv_trueCase_3_0 = null;

        EObject lv_falseCase_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2499:28: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2500:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2500:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2501:5: this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getConditionalExpressionAccess().getLogicalOrExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleConditionalExpression5729);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_LogicalOrExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2509:1: ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==46) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2509:2: () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2509:2: ()
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2510:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,46,FOLLOW_46_in_ruleConditionalExpression5750); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getConditionalExpressionAccess().getQuestionMarkKeyword_1_1());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2519:1: ( (lv_trueCase_3_0= ruleLogicalOrExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2520:1: (lv_trueCase_3_0= ruleLogicalOrExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2520:1: (lv_trueCase_3_0= ruleLogicalOrExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2521:3: lv_trueCase_3_0= ruleLogicalOrExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getTrueCaseLogicalOrExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleConditionalExpression5771);
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

                    otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleConditionalExpression5783); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_3());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2541:1: ( (lv_falseCase_5_0= ruleLogicalOrExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2542:1: (lv_falseCase_5_0= ruleLogicalOrExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2542:1: (lv_falseCase_5_0= ruleLogicalOrExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2543:3: lv_falseCase_5_0= ruleLogicalOrExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getFalseCaseLogicalOrExpressionParserRuleCall_1_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleConditionalExpression5804);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2567:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2568:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2569:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression5842);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOrExpression5852); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2576:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LogicalAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2579:28: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2580:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2580:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2581:5: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5899);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_LogicalAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2589:1: ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==47) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2589:2: () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2589:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2590:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,47,FOLLOW_47_in_ruleLogicalOrExpression5920); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLogicalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_1());
            	          
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2599:1: ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2600:1: (lv_rightOperand_3_0= ruleLogicalAndExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2600:1: (lv_rightOperand_3_0= ruleLogicalAndExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2601:3: lv_rightOperand_3_0= ruleLogicalAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightOperandLogicalAndExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5941);
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
            	    break loop41;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2625:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2626:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2627:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression5979);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalAndExpression5989); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2634:1: ruleLogicalAndExpression returns [EObject current=null] : (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LogicalNotExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2637:28: ( (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2638:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2638:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2639:5: this_LogicalNotExpression_0= ruleLogicalNotExpression ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getLogicalNotExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression6036);
            this_LogicalNotExpression_0=ruleLogicalNotExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_LogicalNotExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2647:1: ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==48) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2647:2: () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2647:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2648:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,48,FOLLOW_48_in_ruleLogicalAndExpression6057); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLogicalAndExpressionAccess().getAmpersandAmpersandKeyword_1_1());
            	          
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2657:1: ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2658:1: (lv_rightOperand_3_0= ruleLogicalNotExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2658:1: (lv_rightOperand_3_0= ruleLogicalNotExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2659:3: lv_rightOperand_3_0= ruleLogicalNotExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightOperandLogicalNotExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression6078);
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
            	    break loop42;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2683:1: entryRuleLogicalNotExpression returns [EObject current=null] : iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF ;
    public final EObject entryRuleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalNotExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2684:2: (iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2685:2: iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalNotExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression6116);
            iv_ruleLogicalNotExpression=ruleLogicalNotExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalNotExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalNotExpression6126); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2692:1: ruleLogicalNotExpression returns [EObject current=null] : (this_BitwiseXorExpression_0= ruleBitwiseXorExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) ) ) ;
    public final EObject ruleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_BitwiseXorExpression_0 = null;

        EObject lv_operand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2695:28: ( (this_BitwiseXorExpression_0= ruleBitwiseXorExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2696:1: (this_BitwiseXorExpression_0= ruleBitwiseXorExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2696:1: (this_BitwiseXorExpression_0= ruleBitwiseXorExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=RULE_ID && LA43_0<=RULE_HEX)||LA43_0==27||(LA43_0>=53 && LA43_0<=54)||(LA43_0>=72 && LA43_0<=73)||LA43_0==76) ) {
                alt43=1;
            }
            else if ( (LA43_0==49) ) {
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2697:5: this_BitwiseXorExpression_0= ruleBitwiseXorExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getBitwiseXorExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBitwiseXorExpression_in_ruleLogicalNotExpression6173);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2706:6: ( () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2706:6: ( () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2706:7: () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2706:7: ()
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2707:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLogicalNotExpressionAccess().getLogicalNotExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,49,FOLLOW_49_in_ruleLogicalNotExpression6200); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getLogicalNotExpressionAccess().getExclamationMarkKeyword_1_1());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2716:1: ( (lv_operand_3_0= ruleBitwiseXorExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2717:1: (lv_operand_3_0= ruleBitwiseXorExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2717:1: (lv_operand_3_0= ruleBitwiseXorExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2718:3: lv_operand_3_0= ruleBitwiseXorExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getOperandBitwiseXorExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBitwiseXorExpression_in_ruleLogicalNotExpression6221);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2742:1: entryRuleBitwiseXorExpression returns [EObject current=null] : iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF ;
    public final EObject entryRuleBitwiseXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseXorExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2743:2: (iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2744:2: iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseXorExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBitwiseXorExpression_in_entryRuleBitwiseXorExpression6258);
            iv_ruleBitwiseXorExpression=ruleBitwiseXorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseXorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseXorExpression6268); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2751:1: ruleBitwiseXorExpression returns [EObject current=null] : (this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )* ) ;
    public final EObject ruleBitwiseXorExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_BitwiseOrExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2754:28: ( (this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2755:1: (this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2755:1: (this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2756:5: this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBitwiseXorExpressionAccess().getBitwiseOrExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleBitwiseOrExpression_in_ruleBitwiseXorExpression6315);
            this_BitwiseOrExpression_0=ruleBitwiseOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_BitwiseOrExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2764:1: ( () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==50) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2764:2: () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2764:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2765:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXorExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,50,FOLLOW_50_in_ruleBitwiseXorExpression6336); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getBitwiseXorExpressionAccess().getCircumflexAccentKeyword_1_1());
            	          
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2774:1: ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2775:1: (lv_rightOperand_3_0= ruleBitwiseOrExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2775:1: (lv_rightOperand_3_0= ruleBitwiseOrExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2776:3: lv_rightOperand_3_0= ruleBitwiseOrExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBitwiseXorExpressionAccess().getRightOperandBitwiseOrExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleBitwiseOrExpression_in_ruleBitwiseXorExpression6357);
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
            	    break loop44;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2800:1: entryRuleBitwiseOrExpression returns [EObject current=null] : iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF ;
    public final EObject entryRuleBitwiseOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseOrExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2801:2: (iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2802:2: iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBitwiseOrExpression_in_entryRuleBitwiseOrExpression6395);
            iv_ruleBitwiseOrExpression=ruleBitwiseOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseOrExpression6405); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2809:1: ruleBitwiseOrExpression returns [EObject current=null] : (this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )* ) ;
    public final EObject ruleBitwiseOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_BitwiseAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2812:28: ( (this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2813:1: (this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2813:1: (this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2814:5: this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBitwiseOrExpressionAccess().getBitwiseAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleBitwiseAndExpression_in_ruleBitwiseOrExpression6452);
            this_BitwiseAndExpression_0=ruleBitwiseAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_BitwiseAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2822:1: ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==51) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2822:2: () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2822:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2823:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getBitwiseOrExpressionAccess().getBitwiseOrExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,51,FOLLOW_51_in_ruleBitwiseOrExpression6473); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getBitwiseOrExpressionAccess().getVerticalLineKeyword_1_1());
            	          
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2832:1: ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2833:1: (lv_rightOperand_3_0= ruleBitwiseAndExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2833:1: (lv_rightOperand_3_0= ruleBitwiseAndExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2834:3: lv_rightOperand_3_0= ruleBitwiseAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBitwiseOrExpressionAccess().getRightOperandBitwiseAndExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleBitwiseAndExpression_in_ruleBitwiseOrExpression6494);
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
            	    break loop45;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2858:1: entryRuleBitwiseAndExpression returns [EObject current=null] : iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF ;
    public final EObject entryRuleBitwiseAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseAndExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2859:2: (iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2860:2: iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBitwiseAndExpression_in_entryRuleBitwiseAndExpression6532);
            iv_ruleBitwiseAndExpression=ruleBitwiseAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseAndExpression6542); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2867:1: ruleBitwiseAndExpression returns [EObject current=null] : (this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )* ) ;
    public final EObject ruleBitwiseAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LogicalRelationExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2870:28: ( (this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2871:1: (this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2871:1: (this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2872:5: this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBitwiseAndExpressionAccess().getLogicalRelationExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleLogicalRelationExpression_in_ruleBitwiseAndExpression6589);
            this_LogicalRelationExpression_0=ruleLogicalRelationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_LogicalRelationExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2880:1: ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==52) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2880:2: () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2880:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2881:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAndExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,52,FOLLOW_52_in_ruleBitwiseAndExpression6610); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getBitwiseAndExpressionAccess().getAmpersandKeyword_1_1());
            	          
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2890:1: ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2891:1: (lv_rightOperand_3_0= ruleLogicalRelationExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2891:1: (lv_rightOperand_3_0= ruleLogicalRelationExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2892:3: lv_rightOperand_3_0= ruleLogicalRelationExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBitwiseAndExpressionAccess().getRightOperandLogicalRelationExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalRelationExpression_in_ruleBitwiseAndExpression6631);
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
            	    break loop46;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2916:1: entryRuleLogicalRelationExpression returns [EObject current=null] : iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF ;
    public final EObject entryRuleLogicalRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalRelationExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2917:2: (iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2918:2: iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalRelationExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalRelationExpression_in_entryRuleLogicalRelationExpression6669);
            iv_ruleLogicalRelationExpression=ruleLogicalRelationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalRelationExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalRelationExpression6679); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2925:1: ruleLogicalRelationExpression returns [EObject current=null] : (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )* ) ;
    public final EObject ruleLogicalRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ShiftExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2928:28: ( (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2929:1: (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2929:1: (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2930:5: this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getShiftExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleShiftExpression_in_ruleLogicalRelationExpression6726);
            this_ShiftExpression_0=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ShiftExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2938:1: ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==38||(LA47_0>=77 && LA47_0<=81)) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2938:2: () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2938:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2939:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2944:2: ( (lv_operator_2_0= ruleRelationalOperator ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2945:1: (lv_operator_2_0= ruleRelationalOperator )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2945:1: (lv_operator_2_0= ruleRelationalOperator )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2946:3: lv_operator_2_0= ruleRelationalOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRelationalOperator_in_ruleLogicalRelationExpression6756);
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

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2962:2: ( (lv_rightOperand_3_0= ruleShiftExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2963:1: (lv_rightOperand_3_0= ruleShiftExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2963:1: (lv_rightOperand_3_0= ruleShiftExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2964:3: lv_rightOperand_3_0= ruleShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getRightOperandShiftExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleShiftExpression_in_ruleLogicalRelationExpression6777);
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
            	    break loop47;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2988:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2989:2: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2990:2: iv_ruleShiftExpression= ruleShiftExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShiftExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleShiftExpression_in_entryRuleShiftExpression6815);
            iv_ruleShiftExpression=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShiftExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleShiftExpression6825); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2997:1: ruleShiftExpression returns [EObject current=null] : (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalAddSubtractExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3000:28: ( (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3001:1: (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3001:1: (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3002:5: this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getShiftExpressionAccess().getNumericalAddSubtractExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_ruleShiftExpression6872);
            this_NumericalAddSubtractExpression_0=ruleNumericalAddSubtractExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_NumericalAddSubtractExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3010:1: ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( ((LA48_0>=70 && LA48_0<=71)) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3010:2: () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3010:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3011:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3016:2: ( (lv_operator_2_0= ruleShiftOperator ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3017:1: (lv_operator_2_0= ruleShiftOperator )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3017:1: (lv_operator_2_0= ruleShiftOperator )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3018:3: lv_operator_2_0= ruleShiftOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getOperatorShiftOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleShiftOperator_in_ruleShiftExpression6902);
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

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3034:2: ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3035:1: (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3035:1: (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3036:3: lv_rightOperand_3_0= ruleNumericalAddSubtractExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getRightOperandNumericalAddSubtractExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_ruleShiftExpression6923);
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
            	    break loop48;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3060:1: entryRuleNumericalAddSubtractExpression returns [EObject current=null] : iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF ;
    public final EObject entryRuleNumericalAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalAddSubtractExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3061:2: (iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3062:2: iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_entryRuleNumericalAddSubtractExpression6961);
            iv_ruleNumericalAddSubtractExpression=ruleNumericalAddSubtractExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericalAddSubtractExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalAddSubtractExpression6971); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3069:1: ruleNumericalAddSubtractExpression returns [EObject current=null] : (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* ) ;
    public final EObject ruleNumericalAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalMultiplyDivideExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3072:28: ( (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3073:1: (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3073:1: (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3074:5: this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalMultiplyDivideExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression7018);
            this_NumericalMultiplyDivideExpression_0=ruleNumericalMultiplyDivideExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_NumericalMultiplyDivideExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3082:1: ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( ((LA49_0>=72 && LA49_0<=73)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3082:2: () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3082:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3083:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalAddSubtractExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3088:2: ( (lv_operator_2_0= ruleAdditiveOperator ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3089:1: (lv_operator_2_0= ruleAdditiveOperator )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3089:1: (lv_operator_2_0= ruleAdditiveOperator )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3090:3: lv_operator_2_0= ruleAdditiveOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getOperatorAdditiveOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleNumericalAddSubtractExpression7048);
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

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3106:2: ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3107:1: (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3107:1: (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3108:3: lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getRightOperandNumericalMultiplyDivideExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression7069);
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
            	    break loop49;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3132:1: entryRuleNumericalMultiplyDivideExpression returns [EObject current=null] : iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF ;
    public final EObject entryRuleNumericalMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalMultiplyDivideExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3133:2: (iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3134:2: iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_entryRuleNumericalMultiplyDivideExpression7107);
            iv_ruleNumericalMultiplyDivideExpression=ruleNumericalMultiplyDivideExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericalMultiplyDivideExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalMultiplyDivideExpression7117); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3141:1: ruleNumericalMultiplyDivideExpression returns [EObject current=null] : (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* ) ;
    public final EObject ruleNumericalMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalUnaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3144:28: ( (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3145:1: (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3145:1: (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3146:5: this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalUnaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression7164);
            this_NumericalUnaryExpression_0=ruleNumericalUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_NumericalUnaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3154:1: ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==33||(LA50_0>=74 && LA50_0<=75)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3154:2: () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3154:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3155:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalMultiplyDivideExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3160:2: ( (lv_operator_2_0= ruleMultiplicativeOperator ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3161:1: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3161:1: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3162:3: lv_operator_2_0= ruleMultiplicativeOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getOperatorMultiplicativeOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleNumericalMultiplyDivideExpression7194);
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

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3178:2: ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3179:1: (lv_rightOperand_3_0= ruleNumericalUnaryExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3179:1: (lv_rightOperand_3_0= ruleNumericalUnaryExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3180:3: lv_rightOperand_3_0= ruleNumericalUnaryExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getRightOperandNumericalUnaryExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression7215);
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
            	    break loop50;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3204:1: entryRuleNumericalUnaryExpression returns [EObject current=null] : iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF ;
    public final EObject entryRuleNumericalUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalUnaryExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3205:2: (iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3206:2: iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_entryRuleNumericalUnaryExpression7253);
            iv_ruleNumericalUnaryExpression=ruleNumericalUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericalUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalUnaryExpression7263); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3213:1: ruleNumericalUnaryExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) ) ;
    public final EObject ruleNumericalUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_operand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3216:28: ( (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3217:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3217:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=RULE_ID && LA51_0<=RULE_HEX)||LA51_0==27||(LA51_0>=53 && LA51_0<=54)) ) {
                alt51=1;
            }
            else if ( ((LA51_0>=72 && LA51_0<=73)||LA51_0==76) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3218:5: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression7310);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3227:6: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3227:6: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3227:7: () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3227:7: ()
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3228:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getNumericalUnaryExpressionAccess().getNumericalUnaryExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3233:2: ( (lv_operator_2_0= ruleUnaryOperator ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3234:1: (lv_operator_2_0= ruleUnaryOperator )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3234:1: (lv_operator_2_0= ruleUnaryOperator )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3235:3: lv_operator_2_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getOperatorUnaryOperatorEnumRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleNumericalUnaryExpression7346);
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

                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3251:2: ( (lv_operand_3_0= rulePrimaryExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3252:1: (lv_operand_3_0= rulePrimaryExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3252:1: (lv_operand_3_0= rulePrimaryExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3253:3: lv_operand_3_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression7367);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3277:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3278:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3279:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression7404);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression7414); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3286:1: rulePrimaryExpression returns [EObject current=null] : (this_ValueExpression_0= ruleValueExpression | (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' ) | this_OperationCall_4= ruleOperationCall ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_ValueExpression_0 = null;

        EObject this_Expression_2 = null;

        EObject this_OperationCall_4 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3289:28: ( (this_ValueExpression_0= ruleValueExpression | (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' ) | this_OperationCall_4= ruleOperationCall ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3290:1: (this_ValueExpression_0= ruleValueExpression | (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' ) | this_OperationCall_4= ruleOperationCall )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3290:1: (this_ValueExpression_0= ruleValueExpression | (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' ) | this_OperationCall_4= ruleOperationCall )
            int alt52=3;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3291:5: this_ValueExpression_0= ruleValueExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getValueExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleValueExpression_in_rulePrimaryExpression7461);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3300:6: (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3300:6: (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3300:8: otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,27,FOLLOW_27_in_rulePrimaryExpression7479); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExpression_in_rulePrimaryExpression7501);
                    this_Expression_2=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Expression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_3=(Token)match(input,29,FOLLOW_29_in_rulePrimaryExpression7512); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_1_2());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3319:5: this_OperationCall_4= ruleOperationCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getOperationCallParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOperationCall_in_rulePrimaryExpression7541);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3335:1: entryRuleValueExpression returns [EObject current=null] : iv_ruleValueExpression= ruleValueExpression EOF ;
    public final EObject entryRuleValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3336:2: (iv_ruleValueExpression= ruleValueExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3337:2: iv_ruleValueExpression= ruleValueExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleValueExpression_in_entryRuleValueExpression7576);
            iv_ruleValueExpression=ruleValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueExpression7586); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3344:1: ruleValueExpression returns [EObject current=null] : (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_ElementReferenceExpression_1= ruleElementReferenceExpression | this_ActiveStateReferenceExpression_2= ruleActiveStateReferenceExpression | this_EventValueReferenceExpression_3= ruleEventValueReferenceExpression ) ;
    public final EObject ruleValueExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveValueExpression_0 = null;

        EObject this_ElementReferenceExpression_1 = null;

        EObject this_ActiveStateReferenceExpression_2 = null;

        EObject this_EventValueReferenceExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3347:28: ( (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_ElementReferenceExpression_1= ruleElementReferenceExpression | this_ActiveStateReferenceExpression_2= ruleActiveStateReferenceExpression | this_EventValueReferenceExpression_3= ruleEventValueReferenceExpression ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3348:1: (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_ElementReferenceExpression_1= ruleElementReferenceExpression | this_ActiveStateReferenceExpression_2= ruleActiveStateReferenceExpression | this_EventValueReferenceExpression_3= ruleEventValueReferenceExpression )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3348:1: (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_ElementReferenceExpression_1= ruleElementReferenceExpression | this_ActiveStateReferenceExpression_2= ruleActiveStateReferenceExpression | this_EventValueReferenceExpression_3= ruleEventValueReferenceExpression )
            int alt53=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case RULE_BOOL:
            case RULE_FLOAT:
            case RULE_HEX:
                {
                alt53=1;
                }
                break;
            case RULE_ID:
                {
                alt53=2;
                }
                break;
            case 54:
                {
                alt53=3;
                }
                break;
            case 53:
                {
                alt53=4;
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3349:5: this_PrimitiveValueExpression_0= rulePrimitiveValueExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getValueExpressionAccess().getPrimitiveValueExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimitiveValueExpression_in_ruleValueExpression7633);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3359:5: this_ElementReferenceExpression_1= ruleElementReferenceExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getValueExpressionAccess().getElementReferenceExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleElementReferenceExpression_in_ruleValueExpression7660);
                    this_ElementReferenceExpression_1=ruleElementReferenceExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ElementReferenceExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3369:5: this_ActiveStateReferenceExpression_2= ruleActiveStateReferenceExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getValueExpressionAccess().getActiveStateReferenceExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleActiveStateReferenceExpression_in_ruleValueExpression7687);
                    this_ActiveStateReferenceExpression_2=ruleActiveStateReferenceExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ActiveStateReferenceExpression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3379:5: this_EventValueReferenceExpression_3= ruleEventValueReferenceExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getValueExpressionAccess().getEventValueReferenceExpressionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEventValueReferenceExpression_in_ruleValueExpression7714);
                    this_EventValueReferenceExpression_3=ruleEventValueReferenceExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_EventValueReferenceExpression_3; 
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3395:1: entryRulePrimitiveValueExpression returns [EObject current=null] : iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF ;
    public final EObject entryRulePrimitiveValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValueExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3396:2: (iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3397:2: iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveValueExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimitiveValueExpression_in_entryRulePrimitiveValueExpression7749);
            iv_rulePrimitiveValueExpression=rulePrimitiveValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveValueExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveValueExpression7759); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3404:1: rulePrimitiveValueExpression returns [EObject current=null] : ( () ( (lv_value_1_0= ruleLiteral ) ) ) ;
    public final EObject rulePrimitiveValueExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3407:28: ( ( () ( (lv_value_1_0= ruleLiteral ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3408:1: ( () ( (lv_value_1_0= ruleLiteral ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3408:1: ( () ( (lv_value_1_0= ruleLiteral ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3408:2: () ( (lv_value_1_0= ruleLiteral ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3408:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3409:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPrimitiveValueExpressionAccess().getPrimitiveValueExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3414:2: ( (lv_value_1_0= ruleLiteral ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3415:1: (lv_value_1_0= ruleLiteral )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3415:1: (lv_value_1_0= ruleLiteral )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3416:3: lv_value_1_0= ruleLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrimitiveValueExpressionAccess().getValueLiteralParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLiteral_in_rulePrimitiveValueExpression7814);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3440:1: entryRuleElementReferenceExpression returns [EObject current=null] : iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF ;
    public final EObject entryRuleElementReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementReferenceExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3441:2: (iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3442:2: iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElementReferenceExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleElementReferenceExpression_in_entryRuleElementReferenceExpression7850);
            iv_ruleElementReferenceExpression=ruleElementReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElementReferenceExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleElementReferenceExpression7860); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3449:1: ruleElementReferenceExpression returns [EObject current=null] : ( () ( ( ruleFQN ) ) ) ;
    public final EObject ruleElementReferenceExpression() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3452:28: ( ( () ( ( ruleFQN ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3453:1: ( () ( ( ruleFQN ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3453:1: ( () ( ( ruleFQN ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3453:2: () ( ( ruleFQN ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3453:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3454:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getElementReferenceExpressionAccess().getElementReferenceExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3459:2: ( ( ruleFQN ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3460:1: ( ruleFQN )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3460:1: ( ruleFQN )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3461:3: ruleFQN
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getElementReferenceExpressionRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElementReferenceExpressionAccess().getValueDeclarationCrossReference_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFQN_in_ruleElementReferenceExpression7917);
            ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
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
    // $ANTLR end "ruleElementReferenceExpression"


    // $ANTLR start "entryRuleEventValueReferenceExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3482:1: entryRuleEventValueReferenceExpression returns [EObject current=null] : iv_ruleEventValueReferenceExpression= ruleEventValueReferenceExpression EOF ;
    public final EObject entryRuleEventValueReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventValueReferenceExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3483:2: (iv_ruleEventValueReferenceExpression= ruleEventValueReferenceExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3484:2: iv_ruleEventValueReferenceExpression= ruleEventValueReferenceExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventValueReferenceExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleEventValueReferenceExpression_in_entryRuleEventValueReferenceExpression7953);
            iv_ruleEventValueReferenceExpression=ruleEventValueReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventValueReferenceExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventValueReferenceExpression7963); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEventValueReferenceExpression"


    // $ANTLR start "ruleEventValueReferenceExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3491:1: ruleEventValueReferenceExpression returns [EObject current=null] : ( () otherlv_1= 'valueof' otherlv_2= '(' ( ( ruleFQN ) ) otherlv_4= ')' ) ;
    public final EObject ruleEventValueReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3494:28: ( ( () otherlv_1= 'valueof' otherlv_2= '(' ( ( ruleFQN ) ) otherlv_4= ')' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3495:1: ( () otherlv_1= 'valueof' otherlv_2= '(' ( ( ruleFQN ) ) otherlv_4= ')' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3495:1: ( () otherlv_1= 'valueof' otherlv_2= '(' ( ( ruleFQN ) ) otherlv_4= ')' )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3495:2: () otherlv_1= 'valueof' otherlv_2= '(' ( ( ruleFQN ) ) otherlv_4= ')'
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3495:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3496:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEventValueReferenceExpressionAccess().getEventValueReferenceExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleEventValueReferenceExpression8009); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEventValueReferenceExpressionAccess().getValueofKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleEventValueReferenceExpression8021); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getEventValueReferenceExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3509:1: ( ( ruleFQN ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3510:1: ( ruleFQN )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3510:1: ( ruleFQN )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3511:3: ruleFQN
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getEventValueReferenceExpressionRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEventValueReferenceExpressionAccess().getValueEventCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFQN_in_ruleEventValueReferenceExpression8044);
            ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleEventValueReferenceExpression8056); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEventValueReferenceExpressionAccess().getRightParenthesisKeyword_4());
                  
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
    // $ANTLR end "ruleEventValueReferenceExpression"


    // $ANTLR start "entryRuleActiveStateReferenceExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3536:1: entryRuleActiveStateReferenceExpression returns [EObject current=null] : iv_ruleActiveStateReferenceExpression= ruleActiveStateReferenceExpression EOF ;
    public final EObject entryRuleActiveStateReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActiveStateReferenceExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3537:2: (iv_ruleActiveStateReferenceExpression= ruleActiveStateReferenceExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3538:2: iv_ruleActiveStateReferenceExpression= ruleActiveStateReferenceExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActiveStateReferenceExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleActiveStateReferenceExpression_in_entryRuleActiveStateReferenceExpression8092);
            iv_ruleActiveStateReferenceExpression=ruleActiveStateReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActiveStateReferenceExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleActiveStateReferenceExpression8102); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActiveStateReferenceExpression"


    // $ANTLR start "ruleActiveStateReferenceExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3545:1: ruleActiveStateReferenceExpression returns [EObject current=null] : ( () otherlv_1= 'active' otherlv_2= '(' ( ( ruleFQN ) ) otherlv_4= ')' ) ;
    public final EObject ruleActiveStateReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3548:28: ( ( () otherlv_1= 'active' otherlv_2= '(' ( ( ruleFQN ) ) otherlv_4= ')' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3549:1: ( () otherlv_1= 'active' otherlv_2= '(' ( ( ruleFQN ) ) otherlv_4= ')' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3549:1: ( () otherlv_1= 'active' otherlv_2= '(' ( ( ruleFQN ) ) otherlv_4= ')' )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3549:2: () otherlv_1= 'active' otherlv_2= '(' ( ( ruleFQN ) ) otherlv_4= ')'
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3549:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3550:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getActiveStateReferenceExpressionAccess().getActiveStateReferenceExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,54,FOLLOW_54_in_ruleActiveStateReferenceExpression8148); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getActiveStateReferenceExpressionAccess().getActiveKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleActiveStateReferenceExpression8160); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getActiveStateReferenceExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3563:1: ( ( ruleFQN ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3564:1: ( ruleFQN )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3564:1: ( ruleFQN )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3565:3: ruleFQN
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getActiveStateReferenceExpressionRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getActiveStateReferenceExpressionAccess().getValueRegularStateCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFQN_in_ruleActiveStateReferenceExpression8183);
            ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleActiveStateReferenceExpression8195); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getActiveStateReferenceExpressionAccess().getRightParenthesisKeyword_4());
                  
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
    // $ANTLR end "ruleActiveStateReferenceExpression"


    // $ANTLR start "entryRuleOperationCall"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3590:1: entryRuleOperationCall returns [EObject current=null] : iv_ruleOperationCall= ruleOperationCall EOF ;
    public final EObject entryRuleOperationCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCall = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3591:2: (iv_ruleOperationCall= ruleOperationCall EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3592:2: iv_ruleOperationCall= ruleOperationCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationCallRule()); 
            }
            pushFollow(FOLLOW_ruleOperationCall_in_entryRuleOperationCall8231);
            iv_ruleOperationCall=ruleOperationCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperationCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationCall8241); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3599:1: ruleOperationCall returns [EObject current=null] : ( () ( ( ruleFQN ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) ;
    public final EObject ruleOperationCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_args_3_0 = null;

        EObject lv_args_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3602:28: ( ( () ( ( ruleFQN ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3603:1: ( () ( ( ruleFQN ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3603:1: ( () ( ( ruleFQN ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3603:2: () ( ( ruleFQN ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3603:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3604:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getOperationCallAccess().getOperationCallAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3609:2: ( ( ruleFQN ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3610:1: ( ruleFQN )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3610:1: ( ruleFQN )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3611:3: ruleFQN
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getOperationCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOperationCallAccess().getOperationOperationCrossReference_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFQN_in_ruleOperationCall8298);
            ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleOperationCall8310); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOperationCallAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3628:1: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0>=RULE_ID && LA55_0<=RULE_HEX)||LA55_0==27||LA55_0==49||(LA55_0>=53 && LA55_0<=54)||(LA55_0>=72 && LA55_0<=73)||LA55_0==76) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3628:2: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3628:2: ( (lv_args_3_0= ruleExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3629:1: (lv_args_3_0= ruleExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3629:1: (lv_args_3_0= ruleExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3630:3: lv_args_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOperationCallAccess().getArgsExpressionParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleOperationCall8332);
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

                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3646:2: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==28) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3646:4: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleOperationCall8345); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getOperationCallAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3650:1: ( (lv_args_5_0= ruleExpression ) )
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3651:1: (lv_args_5_0= ruleExpression )
                    	    {
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3651:1: (lv_args_5_0= ruleExpression )
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3652:3: lv_args_5_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationCallAccess().getArgsExpressionParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleExpression_in_ruleOperationCall8366);
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
                    	    break loop54;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleOperationCall8382); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3680:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3681:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3682:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral8418);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral8428); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3689:1: ruleLiteral returns [EObject current=null] : (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_HexLiteral_2= ruleHexLiteral | this_RealLiteral_3= ruleRealLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BoolLiteral_0 = null;

        EObject this_IntLiteral_1 = null;

        EObject this_HexLiteral_2 = null;

        EObject this_RealLiteral_3 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3692:28: ( (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_HexLiteral_2= ruleHexLiteral | this_RealLiteral_3= ruleRealLiteral ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3693:1: (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_HexLiteral_2= ruleHexLiteral | this_RealLiteral_3= ruleRealLiteral )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3693:1: (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_HexLiteral_2= ruleHexLiteral | this_RealLiteral_3= ruleRealLiteral )
            int alt56=4;
            switch ( input.LA(1) ) {
            case RULE_BOOL:
                {
                alt56=1;
                }
                break;
            case RULE_INT:
                {
                alt56=2;
                }
                break;
            case RULE_HEX:
                {
                alt56=3;
                }
                break;
            case RULE_FLOAT:
                {
                alt56=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3694:5: this_BoolLiteral_0= ruleBoolLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getBoolLiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBoolLiteral_in_ruleLiteral8475);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3704:5: this_IntLiteral_1= ruleIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getIntLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIntLiteral_in_ruleLiteral8502);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3714:5: this_HexLiteral_2= ruleHexLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getHexLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleHexLiteral_in_ruleLiteral8529);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3724:5: this_RealLiteral_3= ruleRealLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getRealLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleLiteral8556);
                    this_RealLiteral_3=ruleRealLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RealLiteral_3; 
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3740:1: entryRuleBoolLiteral returns [EObject current=null] : iv_ruleBoolLiteral= ruleBoolLiteral EOF ;
    public final EObject entryRuleBoolLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolLiteral = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3741:2: (iv_ruleBoolLiteral= ruleBoolLiteral EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3742:2: iv_ruleBoolLiteral= ruleBoolLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBoolLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleBoolLiteral_in_entryRuleBoolLiteral8591);
            iv_ruleBoolLiteral=ruleBoolLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBoolLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoolLiteral8601); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3749:1: ruleBoolLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_BOOL ) ) ) ;
    public final EObject ruleBoolLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3752:28: ( ( () ( (lv_value_1_0= RULE_BOOL ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3753:1: ( () ( (lv_value_1_0= RULE_BOOL ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3753:1: ( () ( (lv_value_1_0= RULE_BOOL ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3753:2: () ( (lv_value_1_0= RULE_BOOL ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3753:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3754:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBoolLiteralAccess().getBoolLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3759:2: ( (lv_value_1_0= RULE_BOOL ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3760:1: (lv_value_1_0= RULE_BOOL )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3760:1: (lv_value_1_0= RULE_BOOL )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3761:3: lv_value_1_0= RULE_BOOL
            {
            lv_value_1_0=(Token)match(input,RULE_BOOL,FOLLOW_RULE_BOOL_in_ruleBoolLiteral8652); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3785:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3786:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3787:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral8693);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral8703); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3794:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3797:28: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3798:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3798:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3798:2: () ( (lv_value_1_0= RULE_INT ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3798:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3799:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3804:2: ( (lv_value_1_0= RULE_INT ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3805:1: (lv_value_1_0= RULE_INT )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3805:1: (lv_value_1_0= RULE_INT )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3806:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIntLiteral8754); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3830:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3831:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3832:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral8795);
            iv_ruleRealLiteral=ruleRealLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral8805); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3839:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_FLOAT ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3842:28: ( ( () ( (lv_value_1_0= RULE_FLOAT ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3843:1: ( () ( (lv_value_1_0= RULE_FLOAT ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3843:1: ( () ( (lv_value_1_0= RULE_FLOAT ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3843:2: () ( (lv_value_1_0= RULE_FLOAT ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3843:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3844:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3849:2: ( (lv_value_1_0= RULE_FLOAT ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3850:1: (lv_value_1_0= RULE_FLOAT )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3850:1: (lv_value_1_0= RULE_FLOAT )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3851:3: lv_value_1_0= RULE_FLOAT
            {
            lv_value_1_0=(Token)match(input,RULE_FLOAT,FOLLOW_RULE_FLOAT_in_ruleRealLiteral8856); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3875:1: entryRuleHexLiteral returns [EObject current=null] : iv_ruleHexLiteral= ruleHexLiteral EOF ;
    public final EObject entryRuleHexLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHexLiteral = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3876:2: (iv_ruleHexLiteral= ruleHexLiteral EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3877:2: iv_ruleHexLiteral= ruleHexLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHexLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleHexLiteral_in_entryRuleHexLiteral8897);
            iv_ruleHexLiteral=ruleHexLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHexLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexLiteral8907); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3884:1: ruleHexLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_HEX ) ) ) ;
    public final EObject ruleHexLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3887:28: ( ( () ( (lv_value_1_0= RULE_HEX ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3888:1: ( () ( (lv_value_1_0= RULE_HEX ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3888:1: ( () ( (lv_value_1_0= RULE_HEX ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3888:2: () ( (lv_value_1_0= RULE_HEX ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3888:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3889:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getHexLiteralAccess().getHexLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3894:2: ( (lv_value_1_0= RULE_HEX ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3895:1: (lv_value_1_0= RULE_HEX )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3895:1: (lv_value_1_0= RULE_HEX )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3896:3: lv_value_1_0= RULE_HEX
            {
            lv_value_1_0=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexLiteral8958); if (state.failed) return current;
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


    // $ANTLR start "ruleDirection"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3920:1: ruleDirection returns [Enumerator current=null] : ( (enumLiteral_0= 'local' ) | (enumLiteral_1= 'in' ) | (enumLiteral_2= 'out' ) ) ;
    public final Enumerator ruleDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3922:28: ( ( (enumLiteral_0= 'local' ) | (enumLiteral_1= 'in' ) | (enumLiteral_2= 'out' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3923:1: ( (enumLiteral_0= 'local' ) | (enumLiteral_1= 'in' ) | (enumLiteral_2= 'out' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3923:1: ( (enumLiteral_0= 'local' ) | (enumLiteral_1= 'in' ) | (enumLiteral_2= 'out' ) )
            int alt57=3;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt57=1;
                }
                break;
            case 56:
                {
                alt57=2;
                }
                break;
            case 57:
                {
                alt57=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3923:2: (enumLiteral_0= 'local' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3923:2: (enumLiteral_0= 'local' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3923:4: enumLiteral_0= 'local'
                    {
                    enumLiteral_0=(Token)match(input,55,FOLLOW_55_in_ruleDirection9013); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getDirectionAccess().getLOCALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getDirectionAccess().getLOCALEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3929:6: (enumLiteral_1= 'in' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3929:6: (enumLiteral_1= 'in' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3929:8: enumLiteral_1= 'in'
                    {
                    enumLiteral_1=(Token)match(input,56,FOLLOW_56_in_ruleDirection9030); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getDirectionAccess().getINEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getDirectionAccess().getINEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3935:6: (enumLiteral_2= 'out' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3935:6: (enumLiteral_2= 'out' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3935:8: enumLiteral_2= 'out'
                    {
                    enumLiteral_2=(Token)match(input,57,FOLLOW_57_in_ruleDirection9047); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getDirectionAccess().getOUTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getDirectionAccess().getOUTEnumLiteralDeclaration_2()); 
                          
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


    // $ANTLR start "ruleTimeEventType"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3945:1: ruleTimeEventType returns [Enumerator current=null] : ( (enumLiteral_0= 'after' ) | (enumLiteral_1= 'every' ) ) ;
    public final Enumerator ruleTimeEventType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3947:28: ( ( (enumLiteral_0= 'after' ) | (enumLiteral_1= 'every' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3948:1: ( (enumLiteral_0= 'after' ) | (enumLiteral_1= 'every' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3948:1: ( (enumLiteral_0= 'after' ) | (enumLiteral_1= 'every' ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==58) ) {
                alt58=1;
            }
            else if ( (LA58_0==59) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3948:2: (enumLiteral_0= 'after' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3948:2: (enumLiteral_0= 'after' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3948:4: enumLiteral_0= 'after'
                    {
                    enumLiteral_0=(Token)match(input,58,FOLLOW_58_in_ruleTimeEventType9092); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getTimeEventTypeAccess().getAfterEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getTimeEventTypeAccess().getAfterEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3954:6: (enumLiteral_1= 'every' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3954:6: (enumLiteral_1= 'every' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3954:8: enumLiteral_1= 'every'
                    {
                    enumLiteral_1=(Token)match(input,59,FOLLOW_59_in_ruleTimeEventType9109); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getTimeEventTypeAccess().getEveryEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getTimeEventTypeAccess().getEveryEnumLiteralDeclaration_1()); 
                          
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
    // $ANTLR end "ruleTimeEventType"


    // $ANTLR start "ruleAssignmentOperator"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3964:1: ruleAssignmentOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '%=' ) | (enumLiteral_4= '+=' ) | (enumLiteral_5= '-=' ) | (enumLiteral_6= '<<=' ) | (enumLiteral_7= '>>=' ) | (enumLiteral_8= '&=' ) | (enumLiteral_9= '^=' ) | (enumLiteral_10= '|=' ) ) ;
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
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3966:28: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '%=' ) | (enumLiteral_4= '+=' ) | (enumLiteral_5= '-=' ) | (enumLiteral_6= '<<=' ) | (enumLiteral_7= '>>=' ) | (enumLiteral_8= '&=' ) | (enumLiteral_9= '^=' ) | (enumLiteral_10= '|=' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3967:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '%=' ) | (enumLiteral_4= '+=' ) | (enumLiteral_5= '-=' ) | (enumLiteral_6= '<<=' ) | (enumLiteral_7= '>>=' ) | (enumLiteral_8= '&=' ) | (enumLiteral_9= '^=' ) | (enumLiteral_10= '|=' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3967:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '%=' ) | (enumLiteral_4= '+=' ) | (enumLiteral_5= '-=' ) | (enumLiteral_6= '<<=' ) | (enumLiteral_7= '>>=' ) | (enumLiteral_8= '&=' ) | (enumLiteral_9= '^=' ) | (enumLiteral_10= '|=' ) )
            int alt59=11;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt59=1;
                }
                break;
            case 60:
                {
                alt59=2;
                }
                break;
            case 61:
                {
                alt59=3;
                }
                break;
            case 62:
                {
                alt59=4;
                }
                break;
            case 63:
                {
                alt59=5;
                }
                break;
            case 64:
                {
                alt59=6;
                }
                break;
            case 65:
                {
                alt59=7;
                }
                break;
            case 66:
                {
                alt59=8;
                }
                break;
            case 67:
                {
                alt59=9;
                }
                break;
            case 68:
                {
                alt59=10;
                }
                break;
            case 69:
                {
                alt59=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3967:2: (enumLiteral_0= '=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3967:2: (enumLiteral_0= '=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3967:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,22,FOLLOW_22_in_ruleAssignmentOperator9154); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getAssignEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAssignmentOperatorAccess().getAssignEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3973:6: (enumLiteral_1= '*=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3973:6: (enumLiteral_1= '*=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3973:8: enumLiteral_1= '*='
                    {
                    enumLiteral_1=(Token)match(input,60,FOLLOW_60_in_ruleAssignmentOperator9171); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getMultAssignEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getAssignmentOperatorAccess().getMultAssignEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3979:6: (enumLiteral_2= '/=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3979:6: (enumLiteral_2= '/=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3979:8: enumLiteral_2= '/='
                    {
                    enumLiteral_2=(Token)match(input,61,FOLLOW_61_in_ruleAssignmentOperator9188); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getDivAssignEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getAssignmentOperatorAccess().getDivAssignEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3985:6: (enumLiteral_3= '%=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3985:6: (enumLiteral_3= '%=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3985:8: enumLiteral_3= '%='
                    {
                    enumLiteral_3=(Token)match(input,62,FOLLOW_62_in_ruleAssignmentOperator9205); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getModAssignEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getAssignmentOperatorAccess().getModAssignEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3991:6: (enumLiteral_4= '+=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3991:6: (enumLiteral_4= '+=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3991:8: enumLiteral_4= '+='
                    {
                    enumLiteral_4=(Token)match(input,63,FOLLOW_63_in_ruleAssignmentOperator9222); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getAddAssignEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getAssignmentOperatorAccess().getAddAssignEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3997:6: (enumLiteral_5= '-=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3997:6: (enumLiteral_5= '-=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3997:8: enumLiteral_5= '-='
                    {
                    enumLiteral_5=(Token)match(input,64,FOLLOW_64_in_ruleAssignmentOperator9239); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getSubAssignEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getAssignmentOperatorAccess().getSubAssignEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4003:6: (enumLiteral_6= '<<=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4003:6: (enumLiteral_6= '<<=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4003:8: enumLiteral_6= '<<='
                    {
                    enumLiteral_6=(Token)match(input,65,FOLLOW_65_in_ruleAssignmentOperator9256); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getLeftShiftAssignEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getAssignmentOperatorAccess().getLeftShiftAssignEnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4009:6: (enumLiteral_7= '>>=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4009:6: (enumLiteral_7= '>>=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4009:8: enumLiteral_7= '>>='
                    {
                    enumLiteral_7=(Token)match(input,66,FOLLOW_66_in_ruleAssignmentOperator9273); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getRightShiftAssignEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_7, grammarAccess.getAssignmentOperatorAccess().getRightShiftAssignEnumLiteralDeclaration_7()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4015:6: (enumLiteral_8= '&=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4015:6: (enumLiteral_8= '&=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4015:8: enumLiteral_8= '&='
                    {
                    enumLiteral_8=(Token)match(input,67,FOLLOW_67_in_ruleAssignmentOperator9290); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getAndAssignEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_8, grammarAccess.getAssignmentOperatorAccess().getAndAssignEnumLiteralDeclaration_8()); 
                          
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4021:6: (enumLiteral_9= '^=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4021:6: (enumLiteral_9= '^=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4021:8: enumLiteral_9= '^='
                    {
                    enumLiteral_9=(Token)match(input,68,FOLLOW_68_in_ruleAssignmentOperator9307); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getXorAssignEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_9, grammarAccess.getAssignmentOperatorAccess().getXorAssignEnumLiteralDeclaration_9()); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4027:6: (enumLiteral_10= '|=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4027:6: (enumLiteral_10= '|=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4027:8: enumLiteral_10= '|='
                    {
                    enumLiteral_10=(Token)match(input,69,FOLLOW_69_in_ruleAssignmentOperator9324); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4037:1: ruleShiftOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) ) ;
    public final Enumerator ruleShiftOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4039:28: ( ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4040:1: ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4040:1: ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==70) ) {
                alt60=1;
            }
            else if ( (LA60_0==71) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4040:2: (enumLiteral_0= '<<' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4040:2: (enumLiteral_0= '<<' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4040:4: enumLiteral_0= '<<'
                    {
                    enumLiteral_0=(Token)match(input,70,FOLLOW_70_in_ruleShiftOperator9369); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getShiftOperatorAccess().getLeftEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getShiftOperatorAccess().getLeftEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4046:6: (enumLiteral_1= '>>' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4046:6: (enumLiteral_1= '>>' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4046:8: enumLiteral_1= '>>'
                    {
                    enumLiteral_1=(Token)match(input,71,FOLLOW_71_in_ruleShiftOperator9386); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4056:1: ruleAdditiveOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAdditiveOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4058:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4059:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4059:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==72) ) {
                alt61=1;
            }
            else if ( (LA61_0==73) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4059:2: (enumLiteral_0= '+' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4059:2: (enumLiteral_0= '+' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4059:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,72,FOLLOW_72_in_ruleAdditiveOperator9431); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4065:6: (enumLiteral_1= '-' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4065:6: (enumLiteral_1= '-' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4065:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,73,FOLLOW_73_in_ruleAdditiveOperator9448); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4075:1: ruleMultiplicativeOperator returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplicativeOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4077:28: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4078:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4078:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt62=3;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt62=1;
                }
                break;
            case 33:
                {
                alt62=2;
                }
                break;
            case 75:
                {
                alt62=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4078:2: (enumLiteral_0= '*' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4078:2: (enumLiteral_0= '*' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4078:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,74,FOLLOW_74_in_ruleMultiplicativeOperator9493); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4084:6: (enumLiteral_1= '/' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4084:6: (enumLiteral_1= '/' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4084:8: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,33,FOLLOW_33_in_ruleMultiplicativeOperator9510); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4090:6: (enumLiteral_2= '%' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4090:6: (enumLiteral_2= '%' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4090:8: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,75,FOLLOW_75_in_ruleMultiplicativeOperator9527); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4100:1: ruleUnaryOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4102:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4103:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4103:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) )
            int alt63=3;
            switch ( input.LA(1) ) {
            case 72:
                {
                alt63=1;
                }
                break;
            case 73:
                {
                alt63=2;
                }
                break;
            case 76:
                {
                alt63=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4103:2: (enumLiteral_0= '+' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4103:2: (enumLiteral_0= '+' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4103:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,72,FOLLOW_72_in_ruleUnaryOperator9572); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4109:6: (enumLiteral_1= '-' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4109:6: (enumLiteral_1= '-' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4109:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,73,FOLLOW_73_in_ruleUnaryOperator9589); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4115:6: (enumLiteral_2= '~' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4115:6: (enumLiteral_2= '~' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4115:8: enumLiteral_2= '~'
                    {
                    enumLiteral_2=(Token)match(input,76,FOLLOW_76_in_ruleUnaryOperator9606); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4125:1: ruleRelationalOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) ) ;
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
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4127:28: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4128:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4128:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) )
            int alt64=6;
            switch ( input.LA(1) ) {
            case 77:
                {
                alt64=1;
                }
                break;
            case 78:
                {
                alt64=2;
                }
                break;
            case 38:
                {
                alt64=3;
                }
                break;
            case 79:
                {
                alt64=4;
                }
                break;
            case 80:
                {
                alt64=5;
                }
                break;
            case 81:
                {
                alt64=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4128:2: (enumLiteral_0= '<' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4128:2: (enumLiteral_0= '<' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4128:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,77,FOLLOW_77_in_ruleRelationalOperator9651); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4134:6: (enumLiteral_1= '<=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4134:6: (enumLiteral_1= '<=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4134:8: enumLiteral_1= '<='
                    {
                    enumLiteral_1=(Token)match(input,78,FOLLOW_78_in_ruleRelationalOperator9668); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4140:6: (enumLiteral_2= '>' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4140:6: (enumLiteral_2= '>' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4140:8: enumLiteral_2= '>'
                    {
                    enumLiteral_2=(Token)match(input,38,FOLLOW_38_in_ruleRelationalOperator9685); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4146:6: (enumLiteral_3= '>=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4146:6: (enumLiteral_3= '>=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4146:8: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,79,FOLLOW_79_in_ruleRelationalOperator9702); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4152:6: (enumLiteral_4= '==' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4152:6: (enumLiteral_4= '==' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4152:8: enumLiteral_4= '=='
                    {
                    enumLiteral_4=(Token)match(input,80,FOLLOW_80_in_ruleRelationalOperator9719); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4158:6: (enumLiteral_5= '!=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4158:6: (enumLiteral_5= '!=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4158:8: enumLiteral_5= '!='
                    {
                    enumLiteral_5=(Token)match(input,81,FOLLOW_81_in_ruleRelationalOperator9736); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4168:1: ruleTimeUnit returns [Enumerator current=null] : ( (enumLiteral_0= 's' ) | (enumLiteral_1= 'ms' ) | (enumLiteral_2= '\\u00D4\\u00F8\\u03A9s' ) | (enumLiteral_3= 'ns' ) ) ;
    public final Enumerator ruleTimeUnit() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4170:28: ( ( (enumLiteral_0= 's' ) | (enumLiteral_1= 'ms' ) | (enumLiteral_2= '\\u00D4\\u00F8\\u03A9s' ) | (enumLiteral_3= 'ns' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4171:1: ( (enumLiteral_0= 's' ) | (enumLiteral_1= 'ms' ) | (enumLiteral_2= '\\u00D4\\u00F8\\u03A9s' ) | (enumLiteral_3= 'ns' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4171:1: ( (enumLiteral_0= 's' ) | (enumLiteral_1= 'ms' ) | (enumLiteral_2= '\\u00D4\\u00F8\\u03A9s' ) | (enumLiteral_3= 'ns' ) )
            int alt65=4;
            switch ( input.LA(1) ) {
            case 82:
                {
                alt65=1;
                }
                break;
            case 83:
                {
                alt65=2;
                }
                break;
            case 84:
                {
                alt65=3;
                }
                break;
            case 85:
                {
                alt65=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4171:2: (enumLiteral_0= 's' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4171:2: (enumLiteral_0= 's' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4171:4: enumLiteral_0= 's'
                    {
                    enumLiteral_0=(Token)match(input,82,FOLLOW_82_in_ruleTimeUnit9781); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getTimeUnitAccess().getSecondEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getTimeUnitAccess().getSecondEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4177:6: (enumLiteral_1= 'ms' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4177:6: (enumLiteral_1= 'ms' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4177:8: enumLiteral_1= 'ms'
                    {
                    enumLiteral_1=(Token)match(input,83,FOLLOW_83_in_ruleTimeUnit9798); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getTimeUnitAccess().getMillisecondEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getTimeUnitAccess().getMillisecondEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4183:6: (enumLiteral_2= '\\u00D4\\u00F8\\u03A9s' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4183:6: (enumLiteral_2= '\\u00D4\\u00F8\\u03A9s' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4183:8: enumLiteral_2= '\\u00D4\\u00F8\\u03A9s'
                    {
                    enumLiteral_2=(Token)match(input,84,FOLLOW_84_in_ruleTimeUnit9815); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getTimeUnitAccess().getMicrosendEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getTimeUnitAccess().getMicrosendEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4189:6: (enumLiteral_3= 'ns' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4189:6: (enumLiteral_3= 'ns' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4189:8: enumLiteral_3= 'ns'
                    {
                    enumLiteral_3=(Token)match(input,85,FOLLOW_85_in_ruleTimeUnit9832); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getTimeUnitAccess().getNanosecondEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getTimeUnitAccess().getNanosecondEnumLiteralDeclaration_3()); 
                          
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

    // $ANTLR start synpred1_InternalSText
    public final void synpred1_InternalSText_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1584:6: ( '[' )
        // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1584:8: '['
        {
        match(input,35,FOLLOW_35_in_synpred1_InternalSText3384); if (state.failed) return ;

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


    protected DFA30 dfa30 = new DFA30(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA52 dfa52 = new DFA52(this);
    static final String DFA30_eotS =
        "\7\uffff";
    static final String DFA30_eofS =
        "\2\2\5\uffff";
    static final String DFA30_minS =
        "\2\4\1\uffff\1\26\1\uffff\1\4\1\26";
    static final String DFA30_maxS =
        "\2\73\1\uffff\1\105\1\uffff\1\4\1\105";
    static final String DFA30_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\2\uffff";
    static final String DFA30_specialS =
        "\7\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\2\11\uffff\3\2\1\uffff\1\2\1\uffff\2\2\1\uffff\1\2\2\uffff"+
            "\1\2\3\uffff\2\2\2\uffff\2\2\1\uffff\1\1\1\uffff\6\2\12\uffff"+
            "\5\2",
            "\1\3\11\uffff\3\2\1\uffff\1\2\1\uffff\2\2\1\uffff\1\2\2\uffff"+
            "\1\2\3\uffff\2\2\2\uffff\2\2\3\uffff\6\2\1\4\11\uffff\5\2",
            "",
            "\1\4\4\uffff\1\4\1\2\3\uffff\1\5\1\2\1\uffff\1\2\30\uffff\12"+
            "\4",
            "",
            "\1\6",
            "\1\4\4\uffff\1\4\1\2\3\uffff\1\5\1\2\1\uffff\1\2\30\uffff\12"+
            "\4"
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "()* loopback of 1683:2: (otherlv_2= ';' ( (lv_actions_3_0= ruleStatement ) ) )*";
        }
    }
    static final String DFA32_eotS =
        "\6\uffff";
    static final String DFA32_eofS =
        "\1\1\5\uffff";
    static final String DFA32_minS =
        "\1\4\1\uffff\1\34\1\uffff\1\4\1\34";
    static final String DFA32_maxS =
        "\1\73\1\uffff\1\46\1\uffff\1\4\1\46";
    static final String DFA32_acceptS =
        "\1\uffff\1\2\1\uffff\1\1\2\uffff";
    static final String DFA32_specialS =
        "\6\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\2\11\uffff\3\1\1\uffff\1\1\1\uffff\2\1\1\uffff\1\1\2\uffff"+
            "\1\1\3\uffff\2\1\3\uffff\1\1\2\uffff\1\3\6\1\12\uffff\5\1",
            "",
            "\1\1\3\uffff\1\4\1\1\1\uffff\1\1\2\uffff\1\3",
            "",
            "\1\5",
            "\1\1\3\uffff\1\4\1\1\1\uffff\1\1\2\uffff\1\3"
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "()* loopback of 1736:2: ( (lv_properties_1_0= ruleReactionProperty ) )*";
        }
    }
    static final String DFA38_eotS =
        "\7\uffff";
    static final String DFA38_eofS =
        "\7\uffff";
    static final String DFA38_minS =
        "\1\4\1\26\1\uffff\1\4\2\uffff\1\26";
    static final String DFA38_maxS =
        "\1\55\1\105\1\uffff\1\4\2\uffff\1\105";
    static final String DFA38_acceptS =
        "\2\uffff\1\2\1\uffff\1\3\1\1\1\uffff";
    static final String DFA38_specialS =
        "\7\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\1\50\uffff\1\2",
            "\1\5\4\uffff\1\4\4\uffff\1\3\33\uffff\12\5",
            "",
            "\1\6",
            "",
            "",
            "\1\5\4\uffff\1\4\4\uffff\1\3\33\uffff\12\5"
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "2286:1: (this_Assignment_0= ruleAssignment | this_EventRaising_1= ruleEventRaising | this_OperationCall_2= ruleOperationCall )";
        }
    }
    static final String DFA52_eotS =
        "\7\uffff";
    static final String DFA52_eofS =
        "\2\uffff\1\1\3\uffff\1\1";
    static final String DFA52_minS =
        "\1\4\1\uffff\1\4\1\uffff\1\4\1\uffff\1\4";
    static final String DFA52_maxS =
        "\1\66\1\uffff\1\121\1\uffff\1\4\1\uffff\1\121";
    static final String DFA52_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\uffff\1\3\1\uffff";
    static final String DFA52_specialS =
        "\7\uffff}>";
    static final String[] DFA52_transitionS = {
            "\1\2\4\1\22\uffff\1\3\31\uffff\2\1",
            "",
            "\1\1\11\uffff\3\1\1\uffff\4\1\1\uffff\1\1\2\uffff\1\1\1\5\4"+
            "\1\1\4\14\1\1\uffff\3\1\1\uffff\3\1\2\uffff\5\1\12\uffff\6\1"+
            "\1\uffff\5\1",
            "",
            "\1\6",
            "",
            "\1\1\11\uffff\3\1\1\uffff\4\1\1\uffff\1\1\2\uffff\1\1\1\5\4"+
            "\1\1\4\14\1\1\uffff\3\1\1\uffff\3\1\2\uffff\5\1\12\uffff\6\1"+
            "\1\uffff\5\1"
    };

    static final short[] DFA52_eot = DFA.unpackEncodedString(DFA52_eotS);
    static final short[] DFA52_eof = DFA.unpackEncodedString(DFA52_eofS);
    static final char[] DFA52_min = DFA.unpackEncodedStringToUnsignedChars(DFA52_minS);
    static final char[] DFA52_max = DFA.unpackEncodedStringToUnsignedChars(DFA52_maxS);
    static final short[] DFA52_accept = DFA.unpackEncodedString(DFA52_acceptS);
    static final short[] DFA52_special = DFA.unpackEncodedString(DFA52_specialS);
    static final short[][] DFA52_transition;

    static {
        int numStates = DFA52_transitionS.length;
        DFA52_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA52_transition[i] = DFA.unpackEncodedString(DFA52_transitionS[i]);
        }
    }

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = DFA52_eot;
            this.eof = DFA52_eof;
            this.min = DFA52_min;
            this.max = DFA52_max;
            this.accept = DFA52_accept;
            this.special = DFA52_special;
            this.transition = DFA52_transition;
        }
        public String getDescription() {
            return "3290:1: (this_ValueExpression_0= ruleValueExpression | (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' ) | this_OperationCall_4= ruleOperationCall )";
        }
    }
 

    public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRoot85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefRoot_in_ruleRoot130 = new BitSet(new long[]{0x000000000001C002L});
    public static final BitSet FOLLOW_ruleDefRoot_in_entryRuleDefRoot166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefRoot176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatechartRoot_in_ruleDefRoot223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateRoot_in_ruleDefRoot250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionRoot_in_ruleDefRoot277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatechartRoot_in_entryRuleStatechartRoot312 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatechartRoot322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleStatechartRoot359 = new BitSet(new long[]{0x0000000000160000L});
    public static final BitSet FOLLOW_ruleStatechartSpecification_in_ruleStatechartRoot380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateRoot_in_entryRuleStateRoot416 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateRoot426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleStateRoot463 = new BitSet(new long[]{0x0C001F88C0000010L});
    public static final BitSet FOLLOW_ruleStateSpecification_in_ruleStateRoot484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionRoot_in_entryRuleTransitionRoot520 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionRoot530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleTransitionRoot567 = new BitSet(new long[]{0x0C001F8E00000010L});
    public static final BitSet FOLLOW_ruleTransitionSpecification_in_ruleTransitionRoot588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatechartSpecification_in_entryRuleStatechartSpecification624 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatechartSpecification634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleStatechartSpecification681 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleStatechartSpecification702 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_ruleStatechartScope_in_ruleStatechartSpecification725 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_ruleStateSpecification_in_entryRuleStateSpecification762 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateSpecification772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateScope_in_ruleStateSpecification817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionSpecification_in_entryRuleTransitionSpecification852 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionSpecification862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionReaction_in_ruleTransitionSpecification907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateScope_in_entryRuleStateScope944 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateScope954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocalReaction_in_ruleStateScope1011 = new BitSet(new long[]{0x0C001F88C0000012L});
    public static final BitSet FOLLOW_ruleEntrypoint_in_ruleStateScope1030 = new BitSet(new long[]{0x0C001F88C0000012L});
    public static final BitSet FOLLOW_ruleExitpoint_in_ruleStateScope1049 = new BitSet(new long[]{0x0C001F88C0000012L});
    public static final BitSet FOLLOW_ruleStatechartScope_in_entryRuleStatechartScope1091 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatechartScope1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterfaceScope_in_ruleStatechartScope1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInternalScope_in_ruleStatechartScope1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterfaceScope_in_entryRuleInterfaceScope1210 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterfaceScope1220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleInterfaceScope1266 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInterfaceScope1283 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleInterfaceScope1301 = new BitSet(new long[]{0x0F801F88C0A00012L});
    public static final BitSet FOLLOW_ruleEventDefinition_in_ruleInterfaceScope1324 = new BitSet(new long[]{0x0F801F88C0A00012L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_ruleInterfaceScope1343 = new BitSet(new long[]{0x0F801F88C0A00012L});
    public static final BitSet FOLLOW_ruleEntrypoint_in_ruleInterfaceScope1362 = new BitSet(new long[]{0x0F801F88C0A00012L});
    public static final BitSet FOLLOW_ruleExitpoint_in_ruleInterfaceScope1381 = new BitSet(new long[]{0x0F801F88C0A00012L});
    public static final BitSet FOLLOW_ruleInternalScope_in_entryRuleInternalScope1421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInternalScope1431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleInternalScope1477 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleInternalScope1489 = new BitSet(new long[]{0x0F801F8804A00012L});
    public static final BitSet FOLLOW_ruleEventDefinition_in_ruleInternalScope1512 = new BitSet(new long[]{0x0F801F8804A00012L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_ruleInternalScope1531 = new BitSet(new long[]{0x0F801F8804A00012L});
    public static final BitSet FOLLOW_ruleOperation_in_ruleInternalScope1550 = new BitSet(new long[]{0x0F801F8804A00012L});
    public static final BitSet FOLLOW_ruleLocalReaction_in_ruleInternalScope1569 = new BitSet(new long[]{0x0F801F8804A00012L});
    public static final BitSet FOLLOW_ruleEventDefinition_in_entryRuleEventDefinition1615 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventDefinition1625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirection_in_ruleEventDefinition1671 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleEventDefinition1684 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEventDefinition1701 = new BitSet(new long[]{0x0000000000480002L});
    public static final BitSet FOLLOW_19_in_ruleEventDefinition1719 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleEventDefinition1742 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleEventDerivation_in_ruleEventDefinition1765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDerivation_in_entryRuleEventDerivation1802 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventDerivation1812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleEventDerivation1849 = new BitSet(new long[]{0x00620000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleEventDerivation1870 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleEventDerivation1883 = new BitSet(new long[]{0x00620000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleEventDerivation1904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition1942 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDefinition1952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleVariableDefinition1998 = new BitSet(new long[]{0x0000000003000010L});
    public static final BitSet FOLLOW_24_in_ruleVariableDefinition2061 = new BitSet(new long[]{0x0000000003000010L});
    public static final BitSet FOLLOW_25_in_ruleVariableDefinition2146 = new BitSet(new long[]{0x0000000003000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableDefinition2216 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleVariableDefinition2233 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleVariableDefinition2256 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleVariableDefinition2269 = new BitSet(new long[]{0x00620000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDefinition2290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_entryRuleOperation2328 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperation2338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOperation2384 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOperation2401 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleOperation2418 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleOperation2442 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_28_in_ruleOperation2455 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleOperation2478 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_ruleOperation2494 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleOperation2507 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleOperation2530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntrypoint_in_entryRuleEntrypoint2568 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntrypoint2578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleEntrypoint2624 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntrypoint2641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitpoint_in_entryRuleExitpoint2682 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitpoint2692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleExitpoint2738 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExitpoint2755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN2797 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN2808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN2848 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleFQN2867 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN2882 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_ruleLocalReaction_in_entryRuleLocalReaction2931 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocalReaction2941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionTrigger_in_ruleLocalReaction2987 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleLocalReaction3000 = new BitSet(new long[]{0x00602000080001F0L});
    public static final BitSet FOLLOW_ruleReactionEffect_in_ruleLocalReaction3021 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleLocalReaction3035 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_ruleReactionProperties_in_ruleLocalReaction3056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionReaction_in_entryRuleTransitionReaction3094 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionReaction3104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionTrigger_in_ruleTransitionReaction3159 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_33_in_ruleTransitionReaction3173 = new BitSet(new long[]{0x00602000080001F0L});
    public static final BitSet FOLLOW_ruleReactionEffect_in_ruleTransitionReaction3194 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleTransitionReaction3209 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_ruleReactionProperties_in_ruleTransitionReaction3230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionTrigger_in_entryRuleReactionTrigger3268 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReactionTrigger3278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventSpec_in_ruleReactionTrigger3335 = new BitSet(new long[]{0x0000000810000002L});
    public static final BitSet FOLLOW_28_in_ruleReactionTrigger3348 = new BitSet(new long[]{0x0C001F8000000010L});
    public static final BitSet FOLLOW_ruleEventSpec_in_ruleReactionTrigger3369 = new BitSet(new long[]{0x0000000810000002L});
    public static final BitSet FOLLOW_35_in_ruleReactionTrigger3392 = new BitSet(new long[]{0x00620000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleReactionTrigger3414 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleReactionTrigger3426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleReactionTrigger3448 = new BitSet(new long[]{0x00620000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleReactionTrigger3469 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleReactionTrigger3481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionEffect_in_entryRuleReactionEffect3519 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReactionEffect3529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleReactionEffect3584 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleReactionEffect3597 = new BitSet(new long[]{0x00602000080001F0L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleReactionEffect3618 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleReactionEffect3633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionProperties_in_entryRuleReactionProperties3671 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReactionProperties3681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionProperty_in_ruleReactionProperties3736 = new BitSet(new long[]{0x0000004000000012L});
    public static final BitSet FOLLOW_ruleReactionProperty_in_entryRuleReactionProperty3773 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReactionProperty3783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPointSpec_in_ruleReactionProperty3830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPointSpec_in_ruleReactionProperty3857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPointSpec_in_entryRuleEntryPointSpec3892 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryPointSpec3902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleEntryPointSpec3939 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleEntryPointSpec3962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPointSpec_in_entryRuleExitPointSpec3998 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitPointSpec4008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleExitPointSpec4056 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleExitPointSpec4068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventSpec_in_entryRuleEventSpec4104 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventSpec4114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRegularEventSpec_in_ruleEventSpec4161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeEventSpec_in_ruleEventSpec4188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuiltinEventSpec_in_ruleEventSpec4215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRegularEventSpec_in_entryRuleRegularEventSpec4250 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRegularEventSpec4260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleRegularEventSpec4307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeEventSpec_in_entryRuleTimeEventSpec4342 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeEventSpec4352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeEventType_in_ruleTimeEventSpec4398 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTimeEventSpec4415 = new BitSet(new long[]{0x0000000000000002L,0x00000000003C0000L});
    public static final BitSet FOLLOW_ruleTimeUnit_in_ruleTimeEventSpec4441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuiltinEventSpec_in_entryRuleBuiltinEventSpec4478 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBuiltinEventSpec4488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryEvent_in_ruleBuiltinEventSpec4535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitEvent_in_ruleBuiltinEventSpec4562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOnCycleEvent_in_ruleBuiltinEventSpec4589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlwaysEvent_in_ruleBuiltinEventSpec4616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultEvent_in_ruleBuiltinEventSpec4643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryEvent_in_entryRuleEntryEvent4678 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryEvent4688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleEntryEvent4734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitEvent_in_entryRuleExitEvent4770 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitEvent4780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleExitEvent4826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOnCycleEvent_in_entryRuleOnCycleEvent4862 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOnCycleEvent4872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleOnCycleEvent4918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlwaysEvent_in_entryRuleAlwaysEvent4954 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlwaysEvent4964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleAlwaysEvent5010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultEvent_in_entryRuleDefaultEvent5046 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultEvent5056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleDefaultEvent5103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleDefaultEvent5121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement5158 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement5168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleStatement5215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventRaising_in_ruleStatement5242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCall_in_ruleStatement5269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment5304 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment5314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleAssignment5362 = new BitSet(new long[]{0xF000000000400000L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleAssignmentOperator_in_ruleAssignment5383 = new BitSet(new long[]{0x00620000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAssignment5404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventRaising_in_entryRuleEventRaising5440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventRaising5450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleEventRaising5487 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleEventRaising5510 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleEventRaising5523 = new BitSet(new long[]{0x00620000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleEventRaising5544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression5582 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression5592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleExpression5638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression5672 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression5682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleConditionalExpression5729 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_ruleConditionalExpression5750 = new BitSet(new long[]{0x00620000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleConditionalExpression5771 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleConditionalExpression5783 = new BitSet(new long[]{0x00620000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleConditionalExpression5804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression5842 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOrExpression5852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5899 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_ruleLogicalOrExpression5920 = new BitSet(new long[]{0x00620000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5941 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression5979 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalAndExpression5989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression6036 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_ruleLogicalAndExpression6057 = new BitSet(new long[]{0x00620000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression6078 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression6116 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalNotExpression6126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseXorExpression_in_ruleLogicalNotExpression6173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleLogicalNotExpression6200 = new BitSet(new long[]{0x00600000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleBitwiseXorExpression_in_ruleLogicalNotExpression6221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseXorExpression_in_entryRuleBitwiseXorExpression6258 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseXorExpression6268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpression_in_ruleBitwiseXorExpression6315 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_ruleBitwiseXorExpression6336 = new BitSet(new long[]{0x00600000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpression_in_ruleBitwiseXorExpression6357 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpression_in_entryRuleBitwiseOrExpression6395 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseOrExpression6405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpression_in_ruleBitwiseOrExpression6452 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_ruleBitwiseOrExpression6473 = new BitSet(new long[]{0x00600000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpression_in_ruleBitwiseOrExpression6494 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpression_in_entryRuleBitwiseAndExpression6532 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseAndExpression6542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_ruleBitwiseAndExpression6589 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_52_in_ruleBitwiseAndExpression6610 = new BitSet(new long[]{0x00600000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_ruleBitwiseAndExpression6631 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_entryRuleLogicalRelationExpression6669 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalRelationExpression6679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_ruleLogicalRelationExpression6726 = new BitSet(new long[]{0x0000004000000002L,0x000000000003E000L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleLogicalRelationExpression6756 = new BitSet(new long[]{0x00600000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_ruleLogicalRelationExpression6777 = new BitSet(new long[]{0x0000004000000002L,0x000000000003E000L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_entryRuleShiftExpression6815 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShiftExpression6825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_ruleShiftExpression6872 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleShiftOperator_in_ruleShiftExpression6902 = new BitSet(new long[]{0x00600000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_ruleShiftExpression6923 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_entryRuleNumericalAddSubtractExpression6961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalAddSubtractExpression6971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression7018 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleNumericalAddSubtractExpression7048 = new BitSet(new long[]{0x00600000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression7069 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_entryRuleNumericalMultiplyDivideExpression7107 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalMultiplyDivideExpression7117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression7164 = new BitSet(new long[]{0x0000000200000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleNumericalMultiplyDivideExpression7194 = new BitSet(new long[]{0x00600000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression7215 = new BitSet(new long[]{0x0000000200000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_entryRuleNumericalUnaryExpression7253 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalUnaryExpression7263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression7310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleNumericalUnaryExpression7346 = new BitSet(new long[]{0x00600000080001F0L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression7367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression7404 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression7414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueExpression_in_rulePrimaryExpression7461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rulePrimaryExpression7479 = new BitSet(new long[]{0x00620000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleExpression_in_rulePrimaryExpression7501 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_rulePrimaryExpression7512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCall_in_rulePrimaryExpression7541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueExpression_in_entryRuleValueExpression7576 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueExpression7586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveValueExpression_in_ruleValueExpression7633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementReferenceExpression_in_ruleValueExpression7660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActiveStateReferenceExpression_in_ruleValueExpression7687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventValueReferenceExpression_in_ruleValueExpression7714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveValueExpression_in_entryRulePrimitiveValueExpression7749 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveValueExpression7759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimitiveValueExpression7814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementReferenceExpression_in_entryRuleElementReferenceExpression7850 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElementReferenceExpression7860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleElementReferenceExpression7917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventValueReferenceExpression_in_entryRuleEventValueReferenceExpression7953 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventValueReferenceExpression7963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleEventValueReferenceExpression8009 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleEventValueReferenceExpression8021 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleEventValueReferenceExpression8044 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleEventValueReferenceExpression8056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActiveStateReferenceExpression_in_entryRuleActiveStateReferenceExpression8092 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActiveStateReferenceExpression8102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleActiveStateReferenceExpression8148 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleActiveStateReferenceExpression8160 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleActiveStateReferenceExpression8183 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleActiveStateReferenceExpression8195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCall_in_entryRuleOperationCall8231 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationCall8241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleOperationCall8298 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleOperationCall8310 = new BitSet(new long[]{0x00620000280001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleOperationCall8332 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_28_in_ruleOperationCall8345 = new BitSet(new long[]{0x00620000080001F0L,0x0000000000001300L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleOperationCall8366 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_ruleOperationCall8382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral8418 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral8428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolLiteral_in_ruleLiteral8475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_ruleLiteral8502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexLiteral_in_ruleLiteral8529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleLiteral8556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolLiteral_in_entryRuleBoolLiteral8591 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoolLiteral8601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOL_in_ruleBoolLiteral8652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral8693 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral8703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIntLiteral8754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral8795 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral8805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_FLOAT_in_ruleRealLiteral8856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexLiteral_in_entryRuleHexLiteral8897 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexLiteral8907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleHexLiteral8958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleDirection9013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleDirection9030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleDirection9047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleTimeEventType9092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleTimeEventType9109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleAssignmentOperator9154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleAssignmentOperator9171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleAssignmentOperator9188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleAssignmentOperator9205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleAssignmentOperator9222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleAssignmentOperator9239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleAssignmentOperator9256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleAssignmentOperator9273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleAssignmentOperator9290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleAssignmentOperator9307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleAssignmentOperator9324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleShiftOperator9369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleShiftOperator9386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleAdditiveOperator9431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleAdditiveOperator9448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleMultiplicativeOperator9493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleMultiplicativeOperator9510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleMultiplicativeOperator9527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleUnaryOperator9572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleUnaryOperator9589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleUnaryOperator9606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleRelationalOperator9651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleRelationalOperator9668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleRelationalOperator9685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleRelationalOperator9702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleRelationalOperator9719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleRelationalOperator9736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleTimeUnit9781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleTimeUnit9798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleTimeUnit9815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_ruleTimeUnit9832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred1_InternalSText3384 = new BitSet(new long[]{0x0000000000000002L});

}
