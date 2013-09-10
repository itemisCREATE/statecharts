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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_BOOL", "RULE_INT", "RULE_FLOAT", "RULE_HEX", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'@@statechart@@'", "'@@state@@'", "'@@transition@@'", "'namespace'", "'interface'", "':'", "'internal'", "'event'", "'var'", "'readonly'", "'external'", "'='", "'operation'", "'('", "','", "')'", "'local'", "'in'", "'out'", "'default'", "'else'", "'entry'", "'exit'", "'always'", "'oncycle'", "'raise'", "'valueof'", "'active'", "'.'", "'/'", "'#'", "'['", "']'", "';'", "'>'", "'?'", "'||'", "'&&'", "'!'", "'^'", "'|'", "'&'", "'after'", "'every'", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'<<'", "'>>'", "'+'", "'-'", "'*'", "'%'", "'~'", "'<'", "'<='", "'>='", "'=='", "'!='", "'s'", "'ms'", "'us'", "'ns'"
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
    public static final int RULE_BOOL=5;
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
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__59=59;
    public static final int RULE_INT=6;
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
    public static final int RULE_SL_COMMENT=11;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:288:1: entryRuleStatechartSpecification returns [EObject current=null] : iv_ruleStatechartSpecification= ruleStatechartSpecification EOF ;
    public final EObject entryRuleStatechartSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatechartSpecification = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:289:2: (iv_ruleStatechartSpecification= ruleStatechartSpecification EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:290:2: iv_ruleStatechartSpecification= ruleStatechartSpecification EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatechartSpecificationRule()); 
            }
            pushFollow(FOLLOW_ruleStatechartSpecification_in_entryRuleStatechartSpecification626);
            iv_ruleStatechartSpecification=ruleStatechartSpecification();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatechartSpecification; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatechartSpecification636); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:297:1: ruleStatechartSpecification returns [EObject current=null] : ( () (otherlv_1= 'namespace' ( (lv_namespace_2_0= ruleFQN ) ) )? ( (lv_scopes_3_0= ruleStatechartScope ) )* ) ;
    public final EObject ruleStatechartSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_namespace_2_0 = null;

        EObject lv_scopes_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:300:28: ( ( () (otherlv_1= 'namespace' ( (lv_namespace_2_0= ruleFQN ) ) )? ( (lv_scopes_3_0= ruleStatechartScope ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:301:1: ( () (otherlv_1= 'namespace' ( (lv_namespace_2_0= ruleFQN ) ) )? ( (lv_scopes_3_0= ruleStatechartScope ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:301:1: ( () (otherlv_1= 'namespace' ( (lv_namespace_2_0= ruleFQN ) ) )? ( (lv_scopes_3_0= ruleStatechartScope ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:301:2: () (otherlv_1= 'namespace' ( (lv_namespace_2_0= ruleFQN ) ) )? ( (lv_scopes_3_0= ruleStatechartScope ) )*
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:301:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:302:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getStatechartSpecificationAccess().getStatechartSpecificationAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:307:2: (otherlv_1= 'namespace' ( (lv_namespace_2_0= ruleFQN ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==17) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:307:4: otherlv_1= 'namespace' ( (lv_namespace_2_0= ruleFQN ) )
                    {
                    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleStatechartSpecification683); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getStatechartSpecificationAccess().getNamespaceKeyword_1_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:311:1: ( (lv_namespace_2_0= ruleFQN ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:312:1: (lv_namespace_2_0= ruleFQN )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:312:1: (lv_namespace_2_0= ruleFQN )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:313:3: lv_namespace_2_0= ruleFQN
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatechartSpecificationAccess().getNamespaceFQNParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFQN_in_ruleStatechartSpecification704);
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

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:329:4: ( (lv_scopes_3_0= ruleStatechartScope ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18||LA4_0==20) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:330:1: (lv_scopes_3_0= ruleStatechartScope )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:330:1: (lv_scopes_3_0= ruleStatechartScope )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:331:3: lv_scopes_3_0= ruleStatechartScope
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStatechartSpecificationAccess().getScopesStatechartScopeParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleStatechartScope_in_ruleStatechartSpecification727);
            	    lv_scopes_3_0=ruleStatechartScope();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getStatechartSpecificationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"scopes",
            	              		lv_scopes_3_0, 
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:355:1: entryRuleStateSpecification returns [EObject current=null] : iv_ruleStateSpecification= ruleStateSpecification EOF ;
    public final EObject entryRuleStateSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateSpecification = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:356:2: (iv_ruleStateSpecification= ruleStateSpecification EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:357:2: iv_ruleStateSpecification= ruleStateSpecification EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStateSpecificationRule()); 
            }
            pushFollow(FOLLOW_ruleStateSpecification_in_entryRuleStateSpecification764);
            iv_ruleStateSpecification=ruleStateSpecification();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStateSpecification; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateSpecification774); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:364:1: ruleStateSpecification returns [EObject current=null] : ( (lv_scope_0_0= ruleStateScope ) ) ;
    public final EObject ruleStateSpecification() throws RecognitionException {
        EObject current = null;

        EObject lv_scope_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:367:28: ( ( (lv_scope_0_0= ruleStateScope ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:368:1: ( (lv_scope_0_0= ruleStateScope ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:368:1: ( (lv_scope_0_0= ruleStateScope ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:369:1: (lv_scope_0_0= ruleStateScope )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:369:1: (lv_scope_0_0= ruleStateScope )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:370:3: lv_scope_0_0= ruleStateScope
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStateSpecificationAccess().getScopeStateScopeParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStateScope_in_ruleStateSpecification819);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:394:1: entryRuleTransitionSpecification returns [EObject current=null] : iv_ruleTransitionSpecification= ruleTransitionSpecification EOF ;
    public final EObject entryRuleTransitionSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionSpecification = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:395:2: (iv_ruleTransitionSpecification= ruleTransitionSpecification EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:396:2: iv_ruleTransitionSpecification= ruleTransitionSpecification EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransitionSpecificationRule()); 
            }
            pushFollow(FOLLOW_ruleTransitionSpecification_in_entryRuleTransitionSpecification854);
            iv_ruleTransitionSpecification=ruleTransitionSpecification();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransitionSpecification; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionSpecification864); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:403:1: ruleTransitionSpecification returns [EObject current=null] : ( (lv_reaction_0_0= ruleTransitionReaction ) ) ;
    public final EObject ruleTransitionSpecification() throws RecognitionException {
        EObject current = null;

        EObject lv_reaction_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:406:28: ( ( (lv_reaction_0_0= ruleTransitionReaction ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:407:1: ( (lv_reaction_0_0= ruleTransitionReaction ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:407:1: ( (lv_reaction_0_0= ruleTransitionReaction ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:408:1: (lv_reaction_0_0= ruleTransitionReaction )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:408:1: (lv_reaction_0_0= ruleTransitionReaction )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:409:3: lv_reaction_0_0= ruleTransitionReaction
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransitionSpecificationAccess().getReactionTransitionReactionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTransitionReaction_in_ruleTransitionSpecification909);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:435:1: entryRuleStateScope returns [EObject current=null] : iv_ruleStateScope= ruleStateScope EOF ;
    public final EObject entryRuleStateScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateScope = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:436:2: (iv_ruleStateScope= ruleStateScope EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:437:2: iv_ruleStateScope= ruleStateScope EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStateScopeRule()); 
            }
            pushFollow(FOLLOW_ruleStateScope_in_entryRuleStateScope946);
            iv_ruleStateScope=ruleStateScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStateScope; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateScope956); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:444:1: ruleStateScope returns [EObject current=null] : ( () ( (lv_declarations_1_0= ruleLocalReaction ) )* ) ;
    public final EObject ruleStateScope() throws RecognitionException {
        EObject current = null;

        EObject lv_declarations_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:447:28: ( ( () ( (lv_declarations_1_0= ruleLocalReaction ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:448:1: ( () ( (lv_declarations_1_0= ruleLocalReaction ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:448:1: ( () ( (lv_declarations_1_0= ruleLocalReaction ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:448:2: () ( (lv_declarations_1_0= ruleLocalReaction ) )*
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:448:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:449:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getStateScopeAccess().getSimpleScopeAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:454:2: ( (lv_declarations_1_0= ruleLocalReaction ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID||(LA5_0>=35 && LA5_0<=38)||LA5_0==45||(LA5_0>=56 && LA5_0<=57)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:455:1: (lv_declarations_1_0= ruleLocalReaction )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:455:1: (lv_declarations_1_0= ruleLocalReaction )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:456:3: lv_declarations_1_0= ruleLocalReaction
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStateScopeAccess().getDeclarationsLocalReactionParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLocalReaction_in_ruleStateScope1011);
            	    lv_declarations_1_0=ruleLocalReaction();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getStateScopeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"declarations",
            	              		lv_declarations_1_0, 
            	              		"LocalReaction");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:480:1: entryRuleStatechartScope returns [EObject current=null] : iv_ruleStatechartScope= ruleStatechartScope EOF ;
    public final EObject entryRuleStatechartScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatechartScope = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:481:2: (iv_ruleStatechartScope= ruleStatechartScope EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:482:2: iv_ruleStatechartScope= ruleStatechartScope EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatechartScopeRule()); 
            }
            pushFollow(FOLLOW_ruleStatechartScope_in_entryRuleStatechartScope1048);
            iv_ruleStatechartScope=ruleStatechartScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatechartScope; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatechartScope1058); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:489:1: ruleStatechartScope returns [EObject current=null] : (this_InterfaceScope_0= ruleInterfaceScope | this_InternalScope_1= ruleInternalScope ) ;
    public final EObject ruleStatechartScope() throws RecognitionException {
        EObject current = null;

        EObject this_InterfaceScope_0 = null;

        EObject this_InternalScope_1 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:492:28: ( (this_InterfaceScope_0= ruleInterfaceScope | this_InternalScope_1= ruleInternalScope ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:493:1: (this_InterfaceScope_0= ruleInterfaceScope | this_InternalScope_1= ruleInternalScope )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:493:1: (this_InterfaceScope_0= ruleInterfaceScope | this_InternalScope_1= ruleInternalScope )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            else if ( (LA6_0==20) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:494:5: this_InterfaceScope_0= ruleInterfaceScope
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatechartScopeAccess().getInterfaceScopeParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleInterfaceScope_in_ruleStatechartScope1105);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:504:5: this_InternalScope_1= ruleInternalScope
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatechartScopeAccess().getInternalScopeParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleInternalScope_in_ruleStatechartScope1132);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:522:1: entryRuleInterfaceScope returns [EObject current=null] : iv_ruleInterfaceScope= ruleInterfaceScope EOF ;
    public final EObject entryRuleInterfaceScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceScope = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:523:2: (iv_ruleInterfaceScope= ruleInterfaceScope EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:524:2: iv_ruleInterfaceScope= ruleInterfaceScope EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInterfaceScopeRule()); 
            }
            pushFollow(FOLLOW_ruleInterfaceScope_in_entryRuleInterfaceScope1169);
            iv_ruleInterfaceScope=ruleInterfaceScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInterfaceScope; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterfaceScope1179); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:531:1: ruleInterfaceScope returns [EObject current=null] : ( () otherlv_1= 'interface' ( (lv_name_2_0= ruleXID ) )? otherlv_3= ':' ( ( (lv_declarations_4_1= ruleEventDeclarartion | lv_declarations_4_2= ruleVariableDeclaration | lv_declarations_4_3= ruleOperationDeclaration ) ) )* ) ;
    public final EObject ruleInterfaceScope() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_declarations_4_1 = null;

        EObject lv_declarations_4_2 = null;

        EObject lv_declarations_4_3 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:534:28: ( ( () otherlv_1= 'interface' ( (lv_name_2_0= ruleXID ) )? otherlv_3= ':' ( ( (lv_declarations_4_1= ruleEventDeclarartion | lv_declarations_4_2= ruleVariableDeclaration | lv_declarations_4_3= ruleOperationDeclaration ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:535:1: ( () otherlv_1= 'interface' ( (lv_name_2_0= ruleXID ) )? otherlv_3= ':' ( ( (lv_declarations_4_1= ruleEventDeclarartion | lv_declarations_4_2= ruleVariableDeclaration | lv_declarations_4_3= ruleOperationDeclaration ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:535:1: ( () otherlv_1= 'interface' ( (lv_name_2_0= ruleXID ) )? otherlv_3= ':' ( ( (lv_declarations_4_1= ruleEventDeclarartion | lv_declarations_4_2= ruleVariableDeclaration | lv_declarations_4_3= ruleOperationDeclaration ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:535:2: () otherlv_1= 'interface' ( (lv_name_2_0= ruleXID ) )? otherlv_3= ':' ( ( (lv_declarations_4_1= ruleEventDeclarartion | lv_declarations_4_2= ruleVariableDeclaration | lv_declarations_4_3= ruleOperationDeclaration ) ) )*
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:535:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:536:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getInterfaceScopeAccess().getInterfaceScopeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleInterfaceScope1225); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getInterfaceScopeAccess().getInterfaceKeyword_1());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:545:1: ( (lv_name_2_0= ruleXID ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID||(LA7_0>=17 && LA7_0<=18)||(LA7_0>=20 && LA7_0<=24)||LA7_0==26||(LA7_0>=30 && LA7_0<=41)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:546:1: (lv_name_2_0= ruleXID )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:546:1: (lv_name_2_0= ruleXID )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:547:3: lv_name_2_0= ruleXID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getInterfaceScopeAccess().getNameXIDParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXID_in_ruleInterfaceScope1246);
                    lv_name_2_0=ruleXID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getInterfaceScopeRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_2_0, 
                              		"XID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleInterfaceScope1259); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getInterfaceScopeAccess().getColonKeyword_3());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:567:1: ( ( (lv_declarations_4_1= ruleEventDeclarartion | lv_declarations_4_2= ruleVariableDeclaration | lv_declarations_4_3= ruleOperationDeclaration ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=21 && LA9_0<=22)||LA9_0==26||(LA9_0>=30 && LA9_0<=32)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:568:1: ( (lv_declarations_4_1= ruleEventDeclarartion | lv_declarations_4_2= ruleVariableDeclaration | lv_declarations_4_3= ruleOperationDeclaration ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:568:1: ( (lv_declarations_4_1= ruleEventDeclarartion | lv_declarations_4_2= ruleVariableDeclaration | lv_declarations_4_3= ruleOperationDeclaration ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:569:1: (lv_declarations_4_1= ruleEventDeclarartion | lv_declarations_4_2= ruleVariableDeclaration | lv_declarations_4_3= ruleOperationDeclaration )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:569:1: (lv_declarations_4_1= ruleEventDeclarartion | lv_declarations_4_2= ruleVariableDeclaration | lv_declarations_4_3= ruleOperationDeclaration )
            	    int alt8=3;
            	    switch ( input.LA(1) ) {
            	    case 21:
            	    case 30:
            	    case 31:
            	    case 32:
            	        {
            	        alt8=1;
            	        }
            	        break;
            	    case 22:
            	        {
            	        alt8=2;
            	        }
            	        break;
            	    case 26:
            	        {
            	        alt8=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt8) {
            	        case 1 :
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:570:3: lv_declarations_4_1= ruleEventDeclarartion
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getInterfaceScopeAccess().getDeclarationsEventDeclarartionParserRuleCall_4_0_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleEventDeclarartion_in_ruleInterfaceScope1282);
            	            lv_declarations_4_1=ruleEventDeclarartion();

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
            	                      		"EventDeclarartion");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:585:8: lv_declarations_4_2= ruleVariableDeclaration
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getInterfaceScopeAccess().getDeclarationsVariableDeclarationParserRuleCall_4_0_1()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleInterfaceScope1301);
            	            lv_declarations_4_2=ruleVariableDeclaration();

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
            	                      		"VariableDeclaration");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:600:8: lv_declarations_4_3= ruleOperationDeclaration
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getInterfaceScopeAccess().getDeclarationsOperationDeclarationParserRuleCall_4_0_2()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleOperationDeclaration_in_ruleInterfaceScope1320);
            	            lv_declarations_4_3=ruleOperationDeclaration();

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
            	                      		"OperationDeclaration");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;

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
    // $ANTLR end "ruleInterfaceScope"


    // $ANTLR start "entryRuleInternalScope"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:626:1: entryRuleInternalScope returns [EObject current=null] : iv_ruleInternalScope= ruleInternalScope EOF ;
    public final EObject entryRuleInternalScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInternalScope = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:627:2: (iv_ruleInternalScope= ruleInternalScope EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:628:2: iv_ruleInternalScope= ruleInternalScope EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInternalScopeRule()); 
            }
            pushFollow(FOLLOW_ruleInternalScope_in_entryRuleInternalScope1360);
            iv_ruleInternalScope=ruleInternalScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInternalScope; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInternalScope1370); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:635:1: ruleInternalScope returns [EObject current=null] : ( () otherlv_1= 'internal' otherlv_2= ':' ( ( (lv_declarations_3_1= ruleEventDeclarartion | lv_declarations_3_2= ruleVariableDeclaration | lv_declarations_3_3= ruleOperationDeclaration | lv_declarations_3_4= ruleLocalReaction ) ) )* ) ;
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
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:638:28: ( ( () otherlv_1= 'internal' otherlv_2= ':' ( ( (lv_declarations_3_1= ruleEventDeclarartion | lv_declarations_3_2= ruleVariableDeclaration | lv_declarations_3_3= ruleOperationDeclaration | lv_declarations_3_4= ruleLocalReaction ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:639:1: ( () otherlv_1= 'internal' otherlv_2= ':' ( ( (lv_declarations_3_1= ruleEventDeclarartion | lv_declarations_3_2= ruleVariableDeclaration | lv_declarations_3_3= ruleOperationDeclaration | lv_declarations_3_4= ruleLocalReaction ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:639:1: ( () otherlv_1= 'internal' otherlv_2= ':' ( ( (lv_declarations_3_1= ruleEventDeclarartion | lv_declarations_3_2= ruleVariableDeclaration | lv_declarations_3_3= ruleOperationDeclaration | lv_declarations_3_4= ruleLocalReaction ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:639:2: () otherlv_1= 'internal' otherlv_2= ':' ( ( (lv_declarations_3_1= ruleEventDeclarartion | lv_declarations_3_2= ruleVariableDeclaration | lv_declarations_3_3= ruleOperationDeclaration | lv_declarations_3_4= ruleLocalReaction ) ) )*
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:639:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:640:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getInternalScopeAccess().getInternalScopeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleInternalScope1416); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getInternalScopeAccess().getInternalKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleInternalScope1428); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getInternalScopeAccess().getColonKeyword_2());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:653:1: ( ( (lv_declarations_3_1= ruleEventDeclarartion | lv_declarations_3_2= ruleVariableDeclaration | lv_declarations_3_3= ruleOperationDeclaration | lv_declarations_3_4= ruleLocalReaction ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID||(LA11_0>=21 && LA11_0<=22)||LA11_0==26||(LA11_0>=30 && LA11_0<=32)||(LA11_0>=35 && LA11_0<=38)||LA11_0==45||(LA11_0>=56 && LA11_0<=57)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:654:1: ( (lv_declarations_3_1= ruleEventDeclarartion | lv_declarations_3_2= ruleVariableDeclaration | lv_declarations_3_3= ruleOperationDeclaration | lv_declarations_3_4= ruleLocalReaction ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:654:1: ( (lv_declarations_3_1= ruleEventDeclarartion | lv_declarations_3_2= ruleVariableDeclaration | lv_declarations_3_3= ruleOperationDeclaration | lv_declarations_3_4= ruleLocalReaction ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:655:1: (lv_declarations_3_1= ruleEventDeclarartion | lv_declarations_3_2= ruleVariableDeclaration | lv_declarations_3_3= ruleOperationDeclaration | lv_declarations_3_4= ruleLocalReaction )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:655:1: (lv_declarations_3_1= ruleEventDeclarartion | lv_declarations_3_2= ruleVariableDeclaration | lv_declarations_3_3= ruleOperationDeclaration | lv_declarations_3_4= ruleLocalReaction )
            	    int alt10=4;
            	    switch ( input.LA(1) ) {
            	    case 21:
            	    case 30:
            	    case 31:
            	    case 32:
            	        {
            	        alt10=1;
            	        }
            	        break;
            	    case 22:
            	        {
            	        alt10=2;
            	        }
            	        break;
            	    case 26:
            	        {
            	        alt10=3;
            	        }
            	        break;
            	    case RULE_ID:
            	    case 35:
            	    case 36:
            	    case 37:
            	    case 38:
            	    case 45:
            	    case 56:
            	    case 57:
            	        {
            	        alt10=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt10) {
            	        case 1 :
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:656:3: lv_declarations_3_1= ruleEventDeclarartion
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getInternalScopeAccess().getDeclarationsEventDeclarartionParserRuleCall_3_0_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleEventDeclarartion_in_ruleInternalScope1451);
            	            lv_declarations_3_1=ruleEventDeclarartion();

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
            	                      		"EventDeclarartion");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:671:8: lv_declarations_3_2= ruleVariableDeclaration
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getInternalScopeAccess().getDeclarationsVariableDeclarationParserRuleCall_3_0_1()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleInternalScope1470);
            	            lv_declarations_3_2=ruleVariableDeclaration();

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
            	                      		"VariableDeclaration");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:686:8: lv_declarations_3_3= ruleOperationDeclaration
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getInternalScopeAccess().getDeclarationsOperationDeclarationParserRuleCall_3_0_2()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleOperationDeclaration_in_ruleInternalScope1489);
            	            lv_declarations_3_3=ruleOperationDeclaration();

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
            	                      		"OperationDeclaration");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:701:8: lv_declarations_3_4= ruleLocalReaction
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getInternalScopeAccess().getDeclarationsLocalReactionParserRuleCall_3_0_3()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleLocalReaction_in_ruleInternalScope1508);
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
    // $ANTLR end "ruleInternalScope"


    // $ANTLR start "entryRuleEventDeclarartion"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:729:1: entryRuleEventDeclarartion returns [EObject current=null] : iv_ruleEventDeclarartion= ruleEventDeclarartion EOF ;
    public final EObject entryRuleEventDeclarartion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventDeclarartion = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:730:2: (iv_ruleEventDeclarartion= ruleEventDeclarartion EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:731:2: iv_ruleEventDeclarartion= ruleEventDeclarartion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventDeclarartionRule()); 
            }
            pushFollow(FOLLOW_ruleEventDeclarartion_in_entryRuleEventDeclarartion1550);
            iv_ruleEventDeclarartion=ruleEventDeclarartion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventDeclarartion; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventDeclarartion1560); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEventDeclarartion"


    // $ANTLR start "ruleEventDeclarartion"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:738:1: ruleEventDeclarartion returns [EObject current=null] : this_EventDefinition_0= ruleEventDefinition ;
    public final EObject ruleEventDeclarartion() throws RecognitionException {
        EObject current = null;

        EObject this_EventDefinition_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:741:28: (this_EventDefinition_0= ruleEventDefinition )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:743:5: this_EventDefinition_0= ruleEventDefinition
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEventDeclarartionAccess().getEventDefinitionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleEventDefinition_in_ruleEventDeclarartion1606);
            this_EventDefinition_0=ruleEventDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_EventDefinition_0; 
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
    // $ANTLR end "ruleEventDeclarartion"


    // $ANTLR start "entryRuleEventDefinition"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:761:1: entryRuleEventDefinition returns [EObject current=null] : iv_ruleEventDefinition= ruleEventDefinition EOF ;
    public final EObject entryRuleEventDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventDefinition = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:762:2: (iv_ruleEventDefinition= ruleEventDefinition EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:763:2: iv_ruleEventDefinition= ruleEventDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleEventDefinition_in_entryRuleEventDefinition1642);
            iv_ruleEventDefinition=ruleEventDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventDefinition1652); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:770:1: ruleEventDefinition returns [EObject current=null] : ( ( (lv_direction_0_0= ruleDirection ) )? otherlv_1= 'event' ( (lv_name_2_0= ruleXID ) ) (otherlv_3= ':' ( ( ruleFQN ) ) )? ) ;
    public final EObject ruleEventDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Enumerator lv_direction_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:773:28: ( ( ( (lv_direction_0_0= ruleDirection ) )? otherlv_1= 'event' ( (lv_name_2_0= ruleXID ) ) (otherlv_3= ':' ( ( ruleFQN ) ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:774:1: ( ( (lv_direction_0_0= ruleDirection ) )? otherlv_1= 'event' ( (lv_name_2_0= ruleXID ) ) (otherlv_3= ':' ( ( ruleFQN ) ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:774:1: ( ( (lv_direction_0_0= ruleDirection ) )? otherlv_1= 'event' ( (lv_name_2_0= ruleXID ) ) (otherlv_3= ':' ( ( ruleFQN ) ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:774:2: ( (lv_direction_0_0= ruleDirection ) )? otherlv_1= 'event' ( (lv_name_2_0= ruleXID ) ) (otherlv_3= ':' ( ( ruleFQN ) ) )?
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:774:2: ( (lv_direction_0_0= ruleDirection ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=30 && LA12_0<=32)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:775:1: (lv_direction_0_0= ruleDirection )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:775:1: (lv_direction_0_0= ruleDirection )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:776:3: lv_direction_0_0= ruleDirection
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEventDefinitionAccess().getDirectionDirectionEnumRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDirection_in_ruleEventDefinition1698);
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

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleEventDefinition1711); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEventDefinitionAccess().getEventKeyword_1());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:796:1: ( (lv_name_2_0= ruleXID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:797:1: (lv_name_2_0= ruleXID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:797:1: (lv_name_2_0= ruleXID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:798:3: lv_name_2_0= ruleXID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEventDefinitionAccess().getNameXIDParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXID_in_ruleEventDefinition1732);
            lv_name_2_0=ruleXID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEventDefinitionRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"XID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:814:2: (otherlv_3= ':' ( ( ruleFQN ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==19) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:814:4: otherlv_3= ':' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleEventDefinition1745); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getEventDefinitionAccess().getColonKeyword_3_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:818:1: ( ( ruleFQN ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:819:1: ( ruleFQN )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:819:1: ( ruleFQN )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:820:3: ruleFQN
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getEventDefinitionRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEventDefinitionAccess().getTypeTypeCrossReference_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFQN_in_ruleEventDefinition1768);
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
    // $ANTLR end "ruleEventDefinition"


    // $ANTLR start "entryRuleVariableDeclaration"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:841:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:842:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:843:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration1806);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration1816); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableDeclaration"


    // $ANTLR start "ruleVariableDeclaration"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:850:1: ruleVariableDeclaration returns [EObject current=null] : this_VariableDefinition_0= ruleVariableDefinition ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_VariableDefinition_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:853:28: (this_VariableDefinition_0= ruleVariableDefinition )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:855:5: this_VariableDefinition_0= ruleVariableDefinition
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getVariableDeclarationAccess().getVariableDefinitionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleVariableDefinition_in_ruleVariableDeclaration1862);
            this_VariableDefinition_0=ruleVariableDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_VariableDefinition_0; 
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
    // $ANTLR end "ruleVariableDeclaration"


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
            pushFollow(FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition1898);
            iv_ruleVariableDefinition=ruleVariableDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDefinition1908); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:882:1: ruleVariableDefinition returns [EObject current=null] : ( () otherlv_1= 'var' ( ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) ) ) ( (lv_name_5_0= ruleXID ) ) otherlv_6= ':' ( ( ruleFQN ) ) (otherlv_8= '=' ( (lv_initialValue_9_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVariableDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_readonly_3_0=null;
        Token lv_external_4_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_5_0 = null;

        EObject lv_initialValue_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:885:28: ( ( () otherlv_1= 'var' ( ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) ) ) ( (lv_name_5_0= ruleXID ) ) otherlv_6= ':' ( ( ruleFQN ) ) (otherlv_8= '=' ( (lv_initialValue_9_0= ruleExpression ) ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:886:1: ( () otherlv_1= 'var' ( ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) ) ) ( (lv_name_5_0= ruleXID ) ) otherlv_6= ':' ( ( ruleFQN ) ) (otherlv_8= '=' ( (lv_initialValue_9_0= ruleExpression ) ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:886:1: ( () otherlv_1= 'var' ( ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) ) ) ( (lv_name_5_0= ruleXID ) ) otherlv_6= ':' ( ( ruleFQN ) ) (otherlv_8= '=' ( (lv_initialValue_9_0= ruleExpression ) ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:886:2: () otherlv_1= 'var' ( ( ( ( ({...}? => ( ({...}? => ( (lv_readonly_3_0= 'readonly' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_external_4_0= 'external' ) ) ) ) ) )* ) ) ) ( (lv_name_5_0= ruleXID ) ) otherlv_6= ':' ( ( ruleFQN ) ) (otherlv_8= '=' ( (lv_initialValue_9_0= ruleExpression ) ) )?
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

            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleVariableDefinition1954); if (state.failed) return current;
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

                if ( (LA14_0==23) ) {
                    int LA14_2 = input.LA(2);

                    if ( (LA14_2==RULE_ID|| LA14_2 >=17 && LA14_2<=18 || LA14_2 >=20 && LA14_2<=24 ||LA14_2==26|| LA14_2 >=30 && LA14_2<=41) && getUnorderedGroupHelper().canSelect(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2(), 0) ) {
                        alt14=1;
                    }


                }
                else if ( (LA14_0==24) ) {
                    int LA14_3 = input.LA(2);

                    if ( (LA14_3==RULE_ID|| LA14_3 >=17 && LA14_3<=18 || LA14_3 >=20 && LA14_3<=24 ||LA14_3==26|| LA14_3 >=30 && LA14_3<=41) && getUnorderedGroupHelper().canSelect(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_2(), 1) ) {
                        alt14=2;
                    }


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
            	    lv_readonly_3_0=(Token)match(input,23,FOLLOW_23_in_ruleVariableDefinition2017); if (state.failed) return current;
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
            	    lv_external_4_0=(Token)match(input,24,FOLLOW_24_in_ruleVariableDefinition2102); if (state.failed) return current;
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

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:966:2: ( (lv_name_5_0= ruleXID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:967:1: (lv_name_5_0= ruleXID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:967:1: (lv_name_5_0= ruleXID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:968:3: lv_name_5_0= ruleXID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNameXIDParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXID_in_ruleVariableDefinition2176);
            lv_name_5_0=ruleXID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariableDefinitionRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_5_0, 
                      		"XID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleVariableDefinition2188); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getVariableDefinitionAccess().getColonKeyword_4());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:988:1: ( ( ruleFQN ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:989:1: ( ruleFQN )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:989:1: ( ruleFQN )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:990:3: ruleFQN
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getVariableDefinitionRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getTypeTypeCrossReference_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFQN_in_ruleVariableDefinition2211);
            ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1003:2: (otherlv_8= '=' ( (lv_initialValue_9_0= ruleExpression ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1003:4: otherlv_8= '=' ( (lv_initialValue_9_0= ruleExpression ) )
                    {
                    otherlv_8=(Token)match(input,25,FOLLOW_25_in_ruleVariableDefinition2224); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getVariableDefinitionAccess().getEqualsSignKeyword_6_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1007:1: ( (lv_initialValue_9_0= ruleExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1008:1: (lv_initialValue_9_0= ruleExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1008:1: (lv_initialValue_9_0= ruleExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1009:3: lv_initialValue_9_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getInitialValueExpressionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDefinition2245);
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


    // $ANTLR start "entryRuleOperationDeclaration"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1033:1: entryRuleOperationDeclaration returns [EObject current=null] : iv_ruleOperationDeclaration= ruleOperationDeclaration EOF ;
    public final EObject entryRuleOperationDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationDeclaration = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1034:2: (iv_ruleOperationDeclaration= ruleOperationDeclaration EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1035:2: iv_ruleOperationDeclaration= ruleOperationDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleOperationDeclaration_in_entryRuleOperationDeclaration2283);
            iv_ruleOperationDeclaration=ruleOperationDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperationDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationDeclaration2293); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperationDeclaration"


    // $ANTLR start "ruleOperationDeclaration"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1042:1: ruleOperationDeclaration returns [EObject current=null] : this_OperationDefinition_0= ruleOperationDefinition ;
    public final EObject ruleOperationDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_OperationDefinition_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1045:28: (this_OperationDefinition_0= ruleOperationDefinition )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1047:5: this_OperationDefinition_0= ruleOperationDefinition
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOperationDeclarationAccess().getOperationDefinitionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleOperationDefinition_in_ruleOperationDeclaration2339);
            this_OperationDefinition_0=ruleOperationDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_OperationDefinition_0; 
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
    // $ANTLR end "ruleOperationDeclaration"


    // $ANTLR start "entryRuleOperationDefinition"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1065:1: entryRuleOperationDefinition returns [EObject current=null] : iv_ruleOperationDefinition= ruleOperationDefinition EOF ;
    public final EObject entryRuleOperationDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationDefinition = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1066:2: (iv_ruleOperationDefinition= ruleOperationDefinition EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1067:2: iv_ruleOperationDefinition= ruleOperationDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleOperationDefinition_in_entryRuleOperationDefinition2375);
            iv_ruleOperationDefinition=ruleOperationDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperationDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationDefinition2385); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperationDefinition"


    // $ANTLR start "ruleOperationDefinition"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1074:1: ruleOperationDefinition returns [EObject current=null] : ( () otherlv_1= 'operation' ( (lv_name_2_0= ruleXID ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( ( ruleFQN ) ) )? ) ;
    public final EObject ruleOperationDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_parameters_4_0 = null;

        EObject lv_parameters_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1077:28: ( ( () otherlv_1= 'operation' ( (lv_name_2_0= ruleXID ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( ( ruleFQN ) ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1078:1: ( () otherlv_1= 'operation' ( (lv_name_2_0= ruleXID ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( ( ruleFQN ) ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1078:1: ( () otherlv_1= 'operation' ( (lv_name_2_0= ruleXID ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( ( ruleFQN ) ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1078:2: () otherlv_1= 'operation' ( (lv_name_2_0= ruleXID ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( ( ruleFQN ) ) )?
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1078:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1079:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getOperationDefinitionAccess().getOperationDefinitionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,26,FOLLOW_26_in_ruleOperationDefinition2431); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOperationDefinitionAccess().getOperationKeyword_1());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1088:1: ( (lv_name_2_0= ruleXID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1089:1: (lv_name_2_0= ruleXID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1089:1: (lv_name_2_0= ruleXID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1090:3: lv_name_2_0= ruleXID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNameXIDParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXID_in_ruleOperationDefinition2452);
            lv_name_2_0=ruleXID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOperationDefinitionRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"XID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,27,FOLLOW_27_in_ruleOperationDefinition2464); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getOperationDefinitionAccess().getLeftParenthesisKeyword_3());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1110:1: ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID||(LA17_0>=17 && LA17_0<=18)||(LA17_0>=20 && LA17_0<=24)||LA17_0==26||(LA17_0>=30 && LA17_0<=41)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1110:2: ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )*
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1110:2: ( (lv_parameters_4_0= ruleParameter ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1111:1: (lv_parameters_4_0= ruleParameter )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1111:1: (lv_parameters_4_0= ruleParameter )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1112:3: lv_parameters_4_0= ruleParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOperationDefinitionAccess().getParametersParameterParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleParameter_in_ruleOperationDefinition2486);
                    lv_parameters_4_0=ruleParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOperationDefinitionRule());
                      	        }
                             		add(
                             			current, 
                             			"parameters",
                              		lv_parameters_4_0, 
                              		"Parameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1128:2: (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==28) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1128:4: otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) )
                    	    {
                    	    otherlv_5=(Token)match(input,28,FOLLOW_28_in_ruleOperationDefinition2499); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getOperationDefinitionAccess().getCommaKeyword_4_1_0());
                    	          
                    	    }
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1132:1: ( (lv_parameters_6_0= ruleParameter ) )
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1133:1: (lv_parameters_6_0= ruleParameter )
                    	    {
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1133:1: (lv_parameters_6_0= ruleParameter )
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1134:3: lv_parameters_6_0= ruleParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationDefinitionAccess().getParametersParameterParserRuleCall_4_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleParameter_in_ruleOperationDefinition2520);
                    	    lv_parameters_6_0=ruleParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getOperationDefinitionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"parameters",
                    	              		lv_parameters_6_0, 
                    	              		"Parameter");
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

            otherlv_7=(Token)match(input,29,FOLLOW_29_in_ruleOperationDefinition2536); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getOperationDefinitionAccess().getRightParenthesisKeyword_5());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1154:1: (otherlv_8= ':' ( ( ruleFQN ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==19) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1154:3: otherlv_8= ':' ( ( ruleFQN ) )
                    {
                    otherlv_8=(Token)match(input,19,FOLLOW_19_in_ruleOperationDefinition2549); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getOperationDefinitionAccess().getColonKeyword_6_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1158:1: ( ( ruleFQN ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1159:1: ( ruleFQN )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1159:1: ( ruleFQN )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1160:3: ruleFQN
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getOperationDefinitionRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOperationDefinitionAccess().getTypeTypeCrossReference_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFQN_in_ruleOperationDefinition2572);
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
    // $ANTLR end "ruleOperationDefinition"


    // $ANTLR start "entryRuleParameter"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1181:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1182:2: (iv_ruleParameter= ruleParameter EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1183:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter2610);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter2620); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1190:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleXID ) ) otherlv_1= ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1193:28: ( ( ( (lv_name_0_0= ruleXID ) ) otherlv_1= ':' ( ( ruleFQN ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1194:1: ( ( (lv_name_0_0= ruleXID ) ) otherlv_1= ':' ( ( ruleFQN ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1194:1: ( ( (lv_name_0_0= ruleXID ) ) otherlv_1= ':' ( ( ruleFQN ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1194:2: ( (lv_name_0_0= ruleXID ) ) otherlv_1= ':' ( ( ruleFQN ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1194:2: ( (lv_name_0_0= ruleXID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1195:1: (lv_name_0_0= ruleXID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1195:1: (lv_name_0_0= ruleXID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1196:3: lv_name_0_0= ruleXID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getNameXIDParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXID_in_ruleParameter2666);
            lv_name_0_0=ruleXID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getParameterRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"XID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleParameter2678); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getColonKeyword_1());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1216:1: ( ( ruleFQN ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1217:1: ( ruleFQN )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1217:1: ( ruleFQN )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1218:3: ruleFQN
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getParameterRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFQN_in_ruleParameter2701);
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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleXID"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1239:1: entryRuleXID returns [String current=null] : iv_ruleXID= ruleXID EOF ;
    public final String entryRuleXID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXID = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1240:2: (iv_ruleXID= ruleXID EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1241:2: iv_ruleXID= ruleXID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIDRule()); 
            }
            pushFollow(FOLLOW_ruleXID_in_entryRuleXID2738);
            iv_ruleXID=ruleXID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXID2749); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXID"


    // $ANTLR start "ruleXID"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1248:1: ruleXID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= 'namespace' | kw= 'interface' | kw= 'internal' | kw= 'event' | kw= 'local' | kw= 'in' | kw= 'out' | kw= 'var' | kw= 'readonly' | kw= 'external' | kw= 'operation' | kw= 'default' | kw= 'else' | kw= 'entry' | kw= 'exit' | kw= 'always' | kw= 'oncycle' | kw= 'raise' | kw= 'valueof' | kw= 'active' ) ;
    public final AntlrDatatypeRuleToken ruleXID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1251:28: ( (this_ID_0= RULE_ID | kw= 'namespace' | kw= 'interface' | kw= 'internal' | kw= 'event' | kw= 'local' | kw= 'in' | kw= 'out' | kw= 'var' | kw= 'readonly' | kw= 'external' | kw= 'operation' | kw= 'default' | kw= 'else' | kw= 'entry' | kw= 'exit' | kw= 'always' | kw= 'oncycle' | kw= 'raise' | kw= 'valueof' | kw= 'active' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1252:1: (this_ID_0= RULE_ID | kw= 'namespace' | kw= 'interface' | kw= 'internal' | kw= 'event' | kw= 'local' | kw= 'in' | kw= 'out' | kw= 'var' | kw= 'readonly' | kw= 'external' | kw= 'operation' | kw= 'default' | kw= 'else' | kw= 'entry' | kw= 'exit' | kw= 'always' | kw= 'oncycle' | kw= 'raise' | kw= 'valueof' | kw= 'active' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1252:1: (this_ID_0= RULE_ID | kw= 'namespace' | kw= 'interface' | kw= 'internal' | kw= 'event' | kw= 'local' | kw= 'in' | kw= 'out' | kw= 'var' | kw= 'readonly' | kw= 'external' | kw= 'operation' | kw= 'default' | kw= 'else' | kw= 'entry' | kw= 'exit' | kw= 'always' | kw= 'oncycle' | kw= 'raise' | kw= 'valueof' | kw= 'active' )
            int alt19=21;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt19=1;
                }
                break;
            case 17:
                {
                alt19=2;
                }
                break;
            case 18:
                {
                alt19=3;
                }
                break;
            case 20:
                {
                alt19=4;
                }
                break;
            case 21:
                {
                alt19=5;
                }
                break;
            case 30:
                {
                alt19=6;
                }
                break;
            case 31:
                {
                alt19=7;
                }
                break;
            case 32:
                {
                alt19=8;
                }
                break;
            case 22:
                {
                alt19=9;
                }
                break;
            case 23:
                {
                alt19=10;
                }
                break;
            case 24:
                {
                alt19=11;
                }
                break;
            case 26:
                {
                alt19=12;
                }
                break;
            case 33:
                {
                alt19=13;
                }
                break;
            case 34:
                {
                alt19=14;
                }
                break;
            case 35:
                {
                alt19=15;
                }
                break;
            case 36:
                {
                alt19=16;
                }
                break;
            case 37:
                {
                alt19=17;
                }
                break;
            case 38:
                {
                alt19=18;
                }
                break;
            case 39:
                {
                alt19=19;
                }
                break;
            case 40:
                {
                alt19=20;
                }
                break;
            case 41:
                {
                alt19=21;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1252:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXID2789); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getXIDAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1261:2: kw= 'namespace'
                    {
                    kw=(Token)match(input,17,FOLLOW_17_in_ruleXID2813); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getXIDAccess().getNamespaceKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1268:2: kw= 'interface'
                    {
                    kw=(Token)match(input,18,FOLLOW_18_in_ruleXID2832); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getXIDAccess().getInterfaceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1275:2: kw= 'internal'
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleXID2851); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getXIDAccess().getInternalKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1282:2: kw= 'event'
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleXID2870); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getXIDAccess().getEventKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1289:2: kw= 'local'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleXID2889); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getXIDAccess().getLocalKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1296:2: kw= 'in'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleXID2908); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getXIDAccess().getInKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1303:2: kw= 'out'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleXID2927); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getXIDAccess().getOutKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1310:2: kw= 'var'
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleXID2946); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getXIDAccess().getVarKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1317:2: kw= 'readonly'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleXID2965); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getXIDAccess().getReadonlyKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1324:2: kw= 'external'
                    {
                    kw=(Token)match(input,24,FOLLOW_24_in_ruleXID2984); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getXIDAccess().getExternalKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1331:2: kw= 'operation'
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleXID3003); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getXIDAccess().getOperationKeyword_11()); 
                          
                    }

                    }
                    break;
                case 13 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1338:2: kw= 'default'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleXID3022); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getXIDAccess().getDefaultKeyword_12()); 
                          
                    }

                    }
                    break;
                case 14 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1345:2: kw= 'else'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleXID3041); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getXIDAccess().getElseKeyword_13()); 
                          
                    }

                    }
                    break;
                case 15 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1352:2: kw= 'entry'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleXID3060); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getXIDAccess().getEntryKeyword_14()); 
                          
                    }

                    }
                    break;
                case 16 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1359:2: kw= 'exit'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleXID3079); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getXIDAccess().getExitKeyword_15()); 
                          
                    }

                    }
                    break;
                case 17 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1366:2: kw= 'always'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleXID3098); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getXIDAccess().getAlwaysKeyword_16()); 
                          
                    }

                    }
                    break;
                case 18 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1373:2: kw= 'oncycle'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleXID3117); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getXIDAccess().getOncycleKeyword_17()); 
                          
                    }

                    }
                    break;
                case 19 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1380:2: kw= 'raise'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleXID3136); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getXIDAccess().getRaiseKeyword_18()); 
                          
                    }

                    }
                    break;
                case 20 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1387:2: kw= 'valueof'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleXID3155); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getXIDAccess().getValueofKeyword_19()); 
                          
                    }

                    }
                    break;
                case 21 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1394:2: kw= 'active'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleXID3174); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getXIDAccess().getActiveKeyword_20()); 
                          
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
    // $ANTLR end "ruleXID"


    // $ANTLR start "entryRuleFQN"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1407:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1408:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1409:2: iv_ruleFQN= ruleFQN EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFQNRule()); 
            }
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN3215);
            iv_ruleFQN=ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFQN.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN3226); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1416:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_XID_0= ruleXID (kw= '.' this_XID_2= ruleXID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_XID_0 = null;

        AntlrDatatypeRuleToken this_XID_2 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1419:28: ( (this_XID_0= ruleXID (kw= '.' this_XID_2= ruleXID )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1420:1: (this_XID_0= ruleXID (kw= '.' this_XID_2= ruleXID )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1420:1: (this_XID_0= ruleXID (kw= '.' this_XID_2= ruleXID )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1421:5: this_XID_0= ruleXID (kw= '.' this_XID_2= ruleXID )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getFQNAccess().getXIDParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXID_in_ruleFQN3273);
            this_XID_0=ruleXID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_XID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1431:1: (kw= '.' this_XID_2= ruleXID )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==42) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1432:2: kw= '.' this_XID_2= ruleXID
            	    {
            	    kw=(Token)match(input,42,FOLLOW_42_in_ruleFQN3292); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getFQNAccess().getXIDParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleXID_in_ruleFQN3314);
            	    this_XID_2=ruleXID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_XID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1458:1: entryRuleLocalReaction returns [EObject current=null] : iv_ruleLocalReaction= ruleLocalReaction EOF ;
    public final EObject entryRuleLocalReaction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalReaction = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1459:2: (iv_ruleLocalReaction= ruleLocalReaction EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1460:2: iv_ruleLocalReaction= ruleLocalReaction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLocalReactionRule()); 
            }
            pushFollow(FOLLOW_ruleLocalReaction_in_entryRuleLocalReaction3363);
            iv_ruleLocalReaction=ruleLocalReaction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLocalReaction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocalReaction3373); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1467:1: ruleLocalReaction returns [EObject current=null] : ( ( (lv_trigger_0_0= ruleReactionTrigger ) ) ( ( ( '/' ( ( ruleReactionEffect ) ) ) )=> (otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) ) ) ) ) ;
    public final EObject ruleLocalReaction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_trigger_0_0 = null;

        EObject lv_effect_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1470:28: ( ( ( (lv_trigger_0_0= ruleReactionTrigger ) ) ( ( ( '/' ( ( ruleReactionEffect ) ) ) )=> (otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) ) ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1471:1: ( ( (lv_trigger_0_0= ruleReactionTrigger ) ) ( ( ( '/' ( ( ruleReactionEffect ) ) ) )=> (otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) ) ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1471:1: ( ( (lv_trigger_0_0= ruleReactionTrigger ) ) ( ( ( '/' ( ( ruleReactionEffect ) ) ) )=> (otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1471:2: ( (lv_trigger_0_0= ruleReactionTrigger ) ) ( ( ( '/' ( ( ruleReactionEffect ) ) ) )=> (otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1471:2: ( (lv_trigger_0_0= ruleReactionTrigger ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1472:1: (lv_trigger_0_0= ruleReactionTrigger )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1472:1: (lv_trigger_0_0= ruleReactionTrigger )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1473:3: lv_trigger_0_0= ruleReactionTrigger
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLocalReactionAccess().getTriggerReactionTriggerParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleReactionTrigger_in_ruleLocalReaction3419);
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

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1489:2: ( ( ( '/' ( ( ruleReactionEffect ) ) ) )=> (otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1489:3: ( ( '/' ( ( ruleReactionEffect ) ) ) )=> (otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1494:6: (otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1494:8: otherlv_1= '/' ( (lv_effect_2_0= ruleReactionEffect ) )
            {
            otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleLocalReaction3451); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLocalReactionAccess().getSolidusKeyword_1_0_0());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1498:1: ( (lv_effect_2_0= ruleReactionEffect ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1499:1: (lv_effect_2_0= ruleReactionEffect )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1499:1: (lv_effect_2_0= ruleReactionEffect )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1500:3: lv_effect_2_0= ruleReactionEffect
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLocalReactionAccess().getEffectReactionEffectParserRuleCall_1_0_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleReactionEffect_in_ruleLocalReaction3472);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1524:1: entryRuleTransitionReaction returns [EObject current=null] : iv_ruleTransitionReaction= ruleTransitionReaction EOF ;
    public final EObject entryRuleTransitionReaction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionReaction = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1525:2: (iv_ruleTransitionReaction= ruleTransitionReaction EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1526:2: iv_ruleTransitionReaction= ruleTransitionReaction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransitionReactionRule()); 
            }
            pushFollow(FOLLOW_ruleTransitionReaction_in_entryRuleTransitionReaction3510);
            iv_ruleTransitionReaction=ruleTransitionReaction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransitionReaction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionReaction3520); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1533:1: ruleTransitionReaction returns [EObject current=null] : ( () ( (lv_trigger_1_0= ruleStextTrigger ) )? (otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) ) )? (otherlv_4= '#' ( (lv_properties_5_0= ruleTransitionProperty ) )* )? ) ;
    public final EObject ruleTransitionReaction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_trigger_1_0 = null;

        EObject lv_effect_3_0 = null;

        EObject lv_properties_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1536:28: ( ( () ( (lv_trigger_1_0= ruleStextTrigger ) )? (otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) ) )? (otherlv_4= '#' ( (lv_properties_5_0= ruleTransitionProperty ) )* )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1537:1: ( () ( (lv_trigger_1_0= ruleStextTrigger ) )? (otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) ) )? (otherlv_4= '#' ( (lv_properties_5_0= ruleTransitionProperty ) )* )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1537:1: ( () ( (lv_trigger_1_0= ruleStextTrigger ) )? (otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) ) )? (otherlv_4= '#' ( (lv_properties_5_0= ruleTransitionProperty ) )* )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1537:2: () ( (lv_trigger_1_0= ruleStextTrigger ) )? (otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) ) )? (otherlv_4= '#' ( (lv_properties_5_0= ruleTransitionProperty ) )* )?
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1537:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1538:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getTransitionReactionAccess().getTransitionReactionAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1543:2: ( (lv_trigger_1_0= ruleStextTrigger ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID||(LA21_0>=33 && LA21_0<=38)||LA21_0==45||(LA21_0>=56 && LA21_0<=57)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1544:1: (lv_trigger_1_0= ruleStextTrigger )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1544:1: (lv_trigger_1_0= ruleStextTrigger )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1545:3: lv_trigger_1_0= ruleStextTrigger
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTransitionReactionAccess().getTriggerStextTriggerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStextTrigger_in_ruleTransitionReaction3575);
                    lv_trigger_1_0=ruleStextTrigger();

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
                              		"StextTrigger");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1561:3: (otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==43) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1561:5: otherlv_2= '/' ( (lv_effect_3_0= ruleReactionEffect ) )
                    {
                    otherlv_2=(Token)match(input,43,FOLLOW_43_in_ruleTransitionReaction3589); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTransitionReactionAccess().getSolidusKeyword_2_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1565:1: ( (lv_effect_3_0= ruleReactionEffect ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1566:1: (lv_effect_3_0= ruleReactionEffect )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1566:1: (lv_effect_3_0= ruleReactionEffect )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1567:3: lv_effect_3_0= ruleReactionEffect
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTransitionReactionAccess().getEffectReactionEffectParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleReactionEffect_in_ruleTransitionReaction3610);
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

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1583:4: (otherlv_4= '#' ( (lv_properties_5_0= ruleTransitionProperty ) )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==44) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1583:6: otherlv_4= '#' ( (lv_properties_5_0= ruleTransitionProperty ) )*
                    {
                    otherlv_4=(Token)match(input,44,FOLLOW_44_in_ruleTransitionReaction3625); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getTransitionReactionAccess().getNumberSignKeyword_3_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1587:1: ( (lv_properties_5_0= ruleTransitionProperty ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==RULE_ID||LA23_0==48) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1588:1: (lv_properties_5_0= ruleTransitionProperty )
                    	    {
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1588:1: (lv_properties_5_0= ruleTransitionProperty )
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1589:3: lv_properties_5_0= ruleTransitionProperty
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTransitionReactionAccess().getPropertiesTransitionPropertyParserRuleCall_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTransitionProperty_in_ruleTransitionReaction3646);
                    	    lv_properties_5_0=ruleTransitionProperty();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getTransitionReactionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"properties",
                    	              		lv_properties_5_0, 
                    	              		"TransitionProperty");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


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


    // $ANTLR start "entryRuleStextTrigger"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1613:1: entryRuleStextTrigger returns [EObject current=null] : iv_ruleStextTrigger= ruleStextTrigger EOF ;
    public final EObject entryRuleStextTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStextTrigger = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1614:2: (iv_ruleStextTrigger= ruleStextTrigger EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1615:2: iv_ruleStextTrigger= ruleStextTrigger EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStextTriggerRule()); 
            }
            pushFollow(FOLLOW_ruleStextTrigger_in_entryRuleStextTrigger3685);
            iv_ruleStextTrigger=ruleStextTrigger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStextTrigger; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStextTrigger3695); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStextTrigger"


    // $ANTLR start "ruleStextTrigger"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1622:1: ruleStextTrigger returns [EObject current=null] : (this_ReactionTrigger_0= ruleReactionTrigger | this_DefaultTrigger_1= ruleDefaultTrigger ) ;
    public final EObject ruleStextTrigger() throws RecognitionException {
        EObject current = null;

        EObject this_ReactionTrigger_0 = null;

        EObject this_DefaultTrigger_1 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1625:28: ( (this_ReactionTrigger_0= ruleReactionTrigger | this_DefaultTrigger_1= ruleDefaultTrigger ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1626:1: (this_ReactionTrigger_0= ruleReactionTrigger | this_DefaultTrigger_1= ruleDefaultTrigger )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1626:1: (this_ReactionTrigger_0= ruleReactionTrigger | this_DefaultTrigger_1= ruleDefaultTrigger )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID||(LA25_0>=35 && LA25_0<=38)||LA25_0==45||(LA25_0>=56 && LA25_0<=57)) ) {
                alt25=1;
            }
            else if ( ((LA25_0>=33 && LA25_0<=34)) ) {
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1627:5: this_ReactionTrigger_0= ruleReactionTrigger
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStextTriggerAccess().getReactionTriggerParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleReactionTrigger_in_ruleStextTrigger3742);
                    this_ReactionTrigger_0=ruleReactionTrigger();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ReactionTrigger_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1637:5: this_DefaultTrigger_1= ruleDefaultTrigger
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStextTriggerAccess().getDefaultTriggerParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDefaultTrigger_in_ruleStextTrigger3769);
                    this_DefaultTrigger_1=ruleDefaultTrigger();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_DefaultTrigger_1; 
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
    // $ANTLR end "ruleStextTrigger"


    // $ANTLR start "entryRuleReactionTrigger"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1653:1: entryRuleReactionTrigger returns [EObject current=null] : iv_ruleReactionTrigger= ruleReactionTrigger EOF ;
    public final EObject entryRuleReactionTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReactionTrigger = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1654:2: (iv_ruleReactionTrigger= ruleReactionTrigger EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1655:2: iv_ruleReactionTrigger= ruleReactionTrigger EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReactionTriggerRule()); 
            }
            pushFollow(FOLLOW_ruleReactionTrigger_in_entryRuleReactionTrigger3804);
            iv_ruleReactionTrigger=ruleReactionTrigger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReactionTrigger; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReactionTrigger3814); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1662:1: ruleReactionTrigger returns [EObject current=null] : ( () ( ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guard_5_0= ruleGuard ) ) otherlv_6= ']' )? ) | (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ) ;
    public final EObject ruleReactionTrigger() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_triggers_1_0 = null;

        EObject lv_triggers_3_0 = null;

        EObject lv_guard_5_0 = null;

        EObject lv_guardExpression_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1665:28: ( ( () ( ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guard_5_0= ruleGuard ) ) otherlv_6= ']' )? ) | (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1666:1: ( () ( ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guard_5_0= ruleGuard ) ) otherlv_6= ']' )? ) | (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1666:1: ( () ( ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guard_5_0= ruleGuard ) ) otherlv_6= ']' )? ) | (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1666:2: () ( ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guard_5_0= ruleGuard ) ) otherlv_6= ']' )? ) | (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1666:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1667:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getReactionTriggerAccess().getReactionTriggerAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1672:2: ( ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guard_5_0= ruleGuard ) ) otherlv_6= ']' )? ) | (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID||(LA28_0>=35 && LA28_0<=38)||(LA28_0>=56 && LA28_0<=57)) ) {
                alt28=1;
            }
            else if ( (LA28_0==45) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1672:3: ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guard_5_0= ruleGuard ) ) otherlv_6= ']' )? )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1672:3: ( ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guard_5_0= ruleGuard ) ) otherlv_6= ']' )? )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1672:4: ( (lv_triggers_1_0= ruleEventSpec ) ) (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )* ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guard_5_0= ruleGuard ) ) otherlv_6= ']' )?
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1672:4: ( (lv_triggers_1_0= ruleEventSpec ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1673:1: (lv_triggers_1_0= ruleEventSpec )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1673:1: (lv_triggers_1_0= ruleEventSpec )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1674:3: lv_triggers_1_0= ruleEventSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getReactionTriggerAccess().getTriggersEventSpecParserRuleCall_1_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEventSpec_in_ruleReactionTrigger3871);
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

                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1690:2: (otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==28) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1690:4: otherlv_2= ',' ( (lv_triggers_3_0= ruleEventSpec ) )
                    	    {
                    	    otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleReactionTrigger3884); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getReactionTriggerAccess().getCommaKeyword_1_0_1_0());
                    	          
                    	    }
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1694:1: ( (lv_triggers_3_0= ruleEventSpec ) )
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1695:1: (lv_triggers_3_0= ruleEventSpec )
                    	    {
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1695:1: (lv_triggers_3_0= ruleEventSpec )
                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1696:3: lv_triggers_3_0= ruleEventSpec
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getReactionTriggerAccess().getTriggersEventSpecParserRuleCall_1_0_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleEventSpec_in_ruleReactionTrigger3905);
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
                    	    break loop26;
                        }
                    } while (true);

                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1712:4: ( ( ( '[' )=>otherlv_4= '[' ) ( (lv_guard_5_0= ruleGuard ) ) otherlv_6= ']' )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==45) && (synpred2_InternalSText())) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1712:5: ( ( '[' )=>otherlv_4= '[' ) ( (lv_guard_5_0= ruleGuard ) ) otherlv_6= ']'
                            {
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1712:5: ( ( '[' )=>otherlv_4= '[' )
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1712:6: ( '[' )=>otherlv_4= '['
                            {
                            otherlv_4=(Token)match(input,45,FOLLOW_45_in_ruleReactionTrigger3928); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getReactionTriggerAccess().getLeftSquareBracketKeyword_1_0_2_0());
                                  
                            }

                            }

                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1717:2: ( (lv_guard_5_0= ruleGuard ) )
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1718:1: (lv_guard_5_0= ruleGuard )
                            {
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1718:1: (lv_guard_5_0= ruleGuard )
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1719:3: lv_guard_5_0= ruleGuard
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getReactionTriggerAccess().getGuardGuardParserRuleCall_1_0_2_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleGuard_in_ruleReactionTrigger3950);
                            lv_guard_5_0=ruleGuard();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getReactionTriggerRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"guard",
                                      		lv_guard_5_0, 
                                      		"Guard");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            otherlv_6=(Token)match(input,46,FOLLOW_46_in_ruleReactionTrigger3962); if (state.failed) return current;
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1740:6: (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1740:6: (otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1740:8: otherlv_7= '[' ( (lv_guardExpression_8_0= ruleExpression ) ) otherlv_9= ']'
                    {
                    otherlv_7=(Token)match(input,45,FOLLOW_45_in_ruleReactionTrigger3984); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getReactionTriggerAccess().getLeftSquareBracketKeyword_1_1_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1744:1: ( (lv_guardExpression_8_0= ruleExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1745:1: (lv_guardExpression_8_0= ruleExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1745:1: (lv_guardExpression_8_0= ruleExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1746:3: lv_guardExpression_8_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getReactionTriggerAccess().getGuardExpressionExpressionParserRuleCall_1_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleReactionTrigger4005);
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

                    otherlv_9=(Token)match(input,46,FOLLOW_46_in_ruleReactionTrigger4017); if (state.failed) return current;
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


    // $ANTLR start "entryRuleDefaultTrigger"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1774:1: entryRuleDefaultTrigger returns [EObject current=null] : iv_ruleDefaultTrigger= ruleDefaultTrigger EOF ;
    public final EObject entryRuleDefaultTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultTrigger = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1775:2: (iv_ruleDefaultTrigger= ruleDefaultTrigger EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1776:2: iv_ruleDefaultTrigger= ruleDefaultTrigger EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefaultTriggerRule()); 
            }
            pushFollow(FOLLOW_ruleDefaultTrigger_in_entryRuleDefaultTrigger4055);
            iv_ruleDefaultTrigger=ruleDefaultTrigger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefaultTrigger; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultTrigger4065); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefaultTrigger"


    // $ANTLR start "ruleDefaultTrigger"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1783:1: ruleDefaultTrigger returns [EObject current=null] : ( () (otherlv_1= 'default' | otherlv_2= 'else' ) ) ;
    public final EObject ruleDefaultTrigger() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1786:28: ( ( () (otherlv_1= 'default' | otherlv_2= 'else' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1787:1: ( () (otherlv_1= 'default' | otherlv_2= 'else' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1787:1: ( () (otherlv_1= 'default' | otherlv_2= 'else' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1787:2: () (otherlv_1= 'default' | otherlv_2= 'else' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1787:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1788:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getDefaultTriggerAccess().getDefaultTriggerAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1793:2: (otherlv_1= 'default' | otherlv_2= 'else' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==33) ) {
                alt29=1;
            }
            else if ( (LA29_0==34) ) {
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1793:4: otherlv_1= 'default'
                    {
                    otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleDefaultTrigger4112); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getDefaultTriggerAccess().getDefaultKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1798:7: otherlv_2= 'else'
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleDefaultTrigger4130); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDefaultTriggerAccess().getElseKeyword_1_1());
                          
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
    // $ANTLR end "ruleDefaultTrigger"


    // $ANTLR start "entryRuleGuard"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1810:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1811:2: (iv_ruleGuard= ruleGuard EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1812:2: iv_ruleGuard= ruleGuard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGuardRule()); 
            }
            pushFollow(FOLLOW_ruleGuard_in_entryRuleGuard4167);
            iv_ruleGuard=ruleGuard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGuard; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuard4177); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGuard"


    // $ANTLR start "ruleGuard"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1819:1: ruleGuard returns [EObject current=null] : ( () ( (lv_expression_1_0= ruleExpression ) ) ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1822:28: ( ( () ( (lv_expression_1_0= ruleExpression ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1823:1: ( () ( (lv_expression_1_0= ruleExpression ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1823:1: ( () ( (lv_expression_1_0= ruleExpression ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1823:2: () ( (lv_expression_1_0= ruleExpression ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1823:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1824:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getGuardAccess().getGuardAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1829:2: ( (lv_expression_1_0= ruleExpression ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1830:1: (lv_expression_1_0= ruleExpression )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1830:1: (lv_expression_1_0= ruleExpression )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1831:3: lv_expression_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGuardAccess().getExpressionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleGuard4232);
            lv_expression_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getGuardRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_1_0, 
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
    // $ANTLR end "ruleGuard"


    // $ANTLR start "entryRuleReactionEffect"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1855:1: entryRuleReactionEffect returns [EObject current=null] : iv_ruleReactionEffect= ruleReactionEffect EOF ;
    public final EObject entryRuleReactionEffect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReactionEffect = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1856:2: (iv_ruleReactionEffect= ruleReactionEffect EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1857:2: iv_ruleReactionEffect= ruleReactionEffect EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReactionEffectRule()); 
            }
            pushFollow(FOLLOW_ruleReactionEffect_in_entryRuleReactionEffect4268);
            iv_ruleReactionEffect=ruleReactionEffect();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReactionEffect; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReactionEffect4278); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1864:1: ruleReactionEffect returns [EObject current=null] : ( () ( ( (lv_actions_1_1= ruleExpression | lv_actions_1_2= ruleEventRaisingExpression ) ) ) ( ( ( ';' )=>otherlv_2= ';' ) ( ( (lv_actions_3_1= ruleExpression | lv_actions_3_2= ruleEventRaisingExpression ) ) ) )* ) ;
    public final EObject ruleReactionEffect() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_actions_1_1 = null;

        EObject lv_actions_1_2 = null;

        EObject lv_actions_3_1 = null;

        EObject lv_actions_3_2 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1867:28: ( ( () ( ( (lv_actions_1_1= ruleExpression | lv_actions_1_2= ruleEventRaisingExpression ) ) ) ( ( ( ';' )=>otherlv_2= ';' ) ( ( (lv_actions_3_1= ruleExpression | lv_actions_3_2= ruleEventRaisingExpression ) ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1868:1: ( () ( ( (lv_actions_1_1= ruleExpression | lv_actions_1_2= ruleEventRaisingExpression ) ) ) ( ( ( ';' )=>otherlv_2= ';' ) ( ( (lv_actions_3_1= ruleExpression | lv_actions_3_2= ruleEventRaisingExpression ) ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1868:1: ( () ( ( (lv_actions_1_1= ruleExpression | lv_actions_1_2= ruleEventRaisingExpression ) ) ) ( ( ( ';' )=>otherlv_2= ';' ) ( ( (lv_actions_3_1= ruleExpression | lv_actions_3_2= ruleEventRaisingExpression ) ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1868:2: () ( ( (lv_actions_1_1= ruleExpression | lv_actions_1_2= ruleEventRaisingExpression ) ) ) ( ( ( ';' )=>otherlv_2= ';' ) ( ( (lv_actions_3_1= ruleExpression | lv_actions_3_2= ruleEventRaisingExpression ) ) ) )*
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1868:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1869:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getReactionEffectAccess().getReactionEffectAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1874:2: ( ( (lv_actions_1_1= ruleExpression | lv_actions_1_2= ruleEventRaisingExpression ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1875:1: ( (lv_actions_1_1= ruleExpression | lv_actions_1_2= ruleEventRaisingExpression ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1875:1: ( (lv_actions_1_1= ruleExpression | lv_actions_1_2= ruleEventRaisingExpression ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1876:1: (lv_actions_1_1= ruleExpression | lv_actions_1_2= ruleEventRaisingExpression )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1876:1: (lv_actions_1_1= ruleExpression | lv_actions_1_2= ruleEventRaisingExpression )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=RULE_ID && LA30_0<=RULE_STRING)||LA30_0==27||(LA30_0>=40 && LA30_0<=41)||LA30_0==52||(LA30_0>=70 && LA30_0<=71)||LA30_0==74) ) {
                alt30=1;
            }
            else if ( (LA30_0==39) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1877:3: lv_actions_1_1= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getReactionEffectAccess().getActionsExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleReactionEffect4335);
                    lv_actions_1_1=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getReactionEffectRule());
                      	        }
                             		add(
                             			current, 
                             			"actions",
                              		lv_actions_1_1, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1892:8: lv_actions_1_2= ruleEventRaisingExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getReactionEffectAccess().getActionsEventRaisingExpressionParserRuleCall_1_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEventRaisingExpression_in_ruleReactionEffect4354);
                    lv_actions_1_2=ruleEventRaisingExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getReactionEffectRule());
                      	        }
                             		add(
                             			current, 
                             			"actions",
                              		lv_actions_1_2, 
                              		"EventRaisingExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;

            }


            }


            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1910:2: ( ( ( ';' )=>otherlv_2= ';' ) ( ( (lv_actions_3_1= ruleExpression | lv_actions_3_2= ruleEventRaisingExpression ) ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==47) && (synpred3_InternalSText())) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1910:3: ( ( ';' )=>otherlv_2= ';' ) ( ( (lv_actions_3_1= ruleExpression | lv_actions_3_2= ruleEventRaisingExpression ) ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1910:3: ( ( ';' )=>otherlv_2= ';' )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1910:4: ( ';' )=>otherlv_2= ';'
            	    {
            	    otherlv_2=(Token)match(input,47,FOLLOW_47_in_ruleReactionEffect4378); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getReactionEffectAccess().getSemicolonKeyword_2_0());
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1915:2: ( ( (lv_actions_3_1= ruleExpression | lv_actions_3_2= ruleEventRaisingExpression ) ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1916:1: ( (lv_actions_3_1= ruleExpression | lv_actions_3_2= ruleEventRaisingExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1916:1: ( (lv_actions_3_1= ruleExpression | lv_actions_3_2= ruleEventRaisingExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1917:1: (lv_actions_3_1= ruleExpression | lv_actions_3_2= ruleEventRaisingExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1917:1: (lv_actions_3_1= ruleExpression | lv_actions_3_2= ruleEventRaisingExpression )
            	    int alt31=2;
            	    int LA31_0 = input.LA(1);

            	    if ( ((LA31_0>=RULE_ID && LA31_0<=RULE_STRING)||LA31_0==27||(LA31_0>=40 && LA31_0<=41)||LA31_0==52||(LA31_0>=70 && LA31_0<=71)||LA31_0==74) ) {
            	        alt31=1;
            	    }
            	    else if ( (LA31_0==39) ) {
            	        alt31=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 31, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt31) {
            	        case 1 :
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1918:3: lv_actions_3_1= ruleExpression
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getReactionEffectAccess().getActionsExpressionParserRuleCall_2_1_0_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleExpression_in_ruleReactionEffect4402);
            	            lv_actions_3_1=ruleExpression();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getReactionEffectRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"actions",
            	                      		lv_actions_3_1, 
            	                      		"Expression");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1933:8: lv_actions_3_2= ruleEventRaisingExpression
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getReactionEffectAccess().getActionsEventRaisingExpressionParserRuleCall_2_1_0_1()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleEventRaisingExpression_in_ruleReactionEffect4421);
            	            lv_actions_3_2=ruleEventRaisingExpression();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getReactionEffectRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"actions",
            	                      		lv_actions_3_2, 
            	                      		"EventRaisingExpression");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;

            	    }


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
    // $ANTLR end "ruleReactionEffect"


    // $ANTLR start "entryRuleTransitionProperty"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1959:1: entryRuleTransitionProperty returns [EObject current=null] : iv_ruleTransitionProperty= ruleTransitionProperty EOF ;
    public final EObject entryRuleTransitionProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionProperty = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1960:2: (iv_ruleTransitionProperty= ruleTransitionProperty EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1961:2: iv_ruleTransitionProperty= ruleTransitionProperty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransitionPropertyRule()); 
            }
            pushFollow(FOLLOW_ruleTransitionProperty_in_entryRuleTransitionProperty4462);
            iv_ruleTransitionProperty=ruleTransitionProperty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransitionProperty; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionProperty4472); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransitionProperty"


    // $ANTLR start "ruleTransitionProperty"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1968:1: ruleTransitionProperty returns [EObject current=null] : (this_EntryPointSpec_0= ruleEntryPointSpec | this_ExitPointSpec_1= ruleExitPointSpec ) ;
    public final EObject ruleTransitionProperty() throws RecognitionException {
        EObject current = null;

        EObject this_EntryPointSpec_0 = null;

        EObject this_ExitPointSpec_1 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1971:28: ( (this_EntryPointSpec_0= ruleEntryPointSpec | this_ExitPointSpec_1= ruleExitPointSpec ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1972:1: (this_EntryPointSpec_0= ruleEntryPointSpec | this_ExitPointSpec_1= ruleExitPointSpec )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1972:1: (this_EntryPointSpec_0= ruleEntryPointSpec | this_ExitPointSpec_1= ruleExitPointSpec )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==48) ) {
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1973:5: this_EntryPointSpec_0= ruleEntryPointSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTransitionPropertyAccess().getEntryPointSpecParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEntryPointSpec_in_ruleTransitionProperty4519);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1983:5: this_ExitPointSpec_1= ruleExitPointSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTransitionPropertyAccess().getExitPointSpecParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExitPointSpec_in_ruleTransitionProperty4546);
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
    // $ANTLR end "ruleTransitionProperty"


    // $ANTLR start "entryRuleEntryPointSpec"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1999:1: entryRuleEntryPointSpec returns [EObject current=null] : iv_ruleEntryPointSpec= ruleEntryPointSpec EOF ;
    public final EObject entryRuleEntryPointSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryPointSpec = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2000:2: (iv_ruleEntryPointSpec= ruleEntryPointSpec EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2001:2: iv_ruleEntryPointSpec= ruleEntryPointSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEntryPointSpecRule()); 
            }
            pushFollow(FOLLOW_ruleEntryPointSpec_in_entryRuleEntryPointSpec4581);
            iv_ruleEntryPointSpec=ruleEntryPointSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEntryPointSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryPointSpec4591); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2008:1: ruleEntryPointSpec returns [EObject current=null] : (otherlv_0= '>' ( (lv_entrypoint_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEntryPointSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_entrypoint_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2011:28: ( (otherlv_0= '>' ( (lv_entrypoint_1_0= RULE_ID ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2012:1: (otherlv_0= '>' ( (lv_entrypoint_1_0= RULE_ID ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2012:1: (otherlv_0= '>' ( (lv_entrypoint_1_0= RULE_ID ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2012:3: otherlv_0= '>' ( (lv_entrypoint_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,48,FOLLOW_48_in_ruleEntryPointSpec4628); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEntryPointSpecAccess().getGreaterThanSignKeyword_0());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2016:1: ( (lv_entrypoint_1_0= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2017:1: (lv_entrypoint_1_0= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2017:1: (lv_entrypoint_1_0= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2018:3: lv_entrypoint_1_0= RULE_ID
            {
            lv_entrypoint_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntryPointSpec4645); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_entrypoint_1_0, grammarAccess.getEntryPointSpecAccess().getEntrypointIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEntryPointSpecRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"entrypoint",
                      		lv_entrypoint_1_0, 
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
    // $ANTLR end "ruleEntryPointSpec"


    // $ANTLR start "entryRuleExitPointSpec"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2042:1: entryRuleExitPointSpec returns [EObject current=null] : iv_ruleExitPointSpec= ruleExitPointSpec EOF ;
    public final EObject entryRuleExitPointSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitPointSpec = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2043:2: (iv_ruleExitPointSpec= ruleExitPointSpec EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2044:2: iv_ruleExitPointSpec= ruleExitPointSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExitPointSpecRule()); 
            }
            pushFollow(FOLLOW_ruleExitPointSpec_in_entryRuleExitPointSpec4686);
            iv_ruleExitPointSpec=ruleExitPointSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExitPointSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitPointSpec4696); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2051:1: ruleExitPointSpec returns [EObject current=null] : ( ( (lv_exitpoint_0_0= RULE_ID ) ) otherlv_1= '>' ) ;
    public final EObject ruleExitPointSpec() throws RecognitionException {
        EObject current = null;

        Token lv_exitpoint_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2054:28: ( ( ( (lv_exitpoint_0_0= RULE_ID ) ) otherlv_1= '>' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2055:1: ( ( (lv_exitpoint_0_0= RULE_ID ) ) otherlv_1= '>' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2055:1: ( ( (lv_exitpoint_0_0= RULE_ID ) ) otherlv_1= '>' )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2055:2: ( (lv_exitpoint_0_0= RULE_ID ) ) otherlv_1= '>'
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2055:2: ( (lv_exitpoint_0_0= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2056:1: (lv_exitpoint_0_0= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2056:1: (lv_exitpoint_0_0= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2057:3: lv_exitpoint_0_0= RULE_ID
            {
            lv_exitpoint_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExitPointSpec4738); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_exitpoint_0_0, grammarAccess.getExitPointSpecAccess().getExitpointIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getExitPointSpecRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"exitpoint",
                      		lv_exitpoint_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,48,FOLLOW_48_in_ruleExitPointSpec4755); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2085:1: entryRuleEventSpec returns [EObject current=null] : iv_ruleEventSpec= ruleEventSpec EOF ;
    public final EObject entryRuleEventSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventSpec = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2086:2: (iv_ruleEventSpec= ruleEventSpec EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2087:2: iv_ruleEventSpec= ruleEventSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventSpecRule()); 
            }
            pushFollow(FOLLOW_ruleEventSpec_in_entryRuleEventSpec4791);
            iv_ruleEventSpec=ruleEventSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventSpec4801); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2094:1: ruleEventSpec returns [EObject current=null] : (this_RegularEventSpec_0= ruleRegularEventSpec | this_TimeEventSpec_1= ruleTimeEventSpec | this_BuiltinEventSpec_2= ruleBuiltinEventSpec ) ;
    public final EObject ruleEventSpec() throws RecognitionException {
        EObject current = null;

        EObject this_RegularEventSpec_0 = null;

        EObject this_TimeEventSpec_1 = null;

        EObject this_BuiltinEventSpec_2 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2097:28: ( (this_RegularEventSpec_0= ruleRegularEventSpec | this_TimeEventSpec_1= ruleTimeEventSpec | this_BuiltinEventSpec_2= ruleBuiltinEventSpec ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2098:1: (this_RegularEventSpec_0= ruleRegularEventSpec | this_TimeEventSpec_1= ruleTimeEventSpec | this_BuiltinEventSpec_2= ruleBuiltinEventSpec )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2098:1: (this_RegularEventSpec_0= ruleRegularEventSpec | this_TimeEventSpec_1= ruleTimeEventSpec | this_BuiltinEventSpec_2= ruleBuiltinEventSpec )
            int alt34=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt34=1;
                }
                break;
            case 56:
            case 57:
                {
                alt34=2;
                }
                break;
            case 35:
            case 36:
            case 37:
            case 38:
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2099:5: this_RegularEventSpec_0= ruleRegularEventSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEventSpecAccess().getRegularEventSpecParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRegularEventSpec_in_ruleEventSpec4848);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2109:5: this_TimeEventSpec_1= ruleTimeEventSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEventSpecAccess().getTimeEventSpecParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTimeEventSpec_in_ruleEventSpec4875);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2119:5: this_BuiltinEventSpec_2= ruleBuiltinEventSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEventSpecAccess().getBuiltinEventSpecParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBuiltinEventSpec_in_ruleEventSpec4902);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2135:1: entryRuleRegularEventSpec returns [EObject current=null] : iv_ruleRegularEventSpec= ruleRegularEventSpec EOF ;
    public final EObject entryRuleRegularEventSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegularEventSpec = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2136:2: (iv_ruleRegularEventSpec= ruleRegularEventSpec EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2137:2: iv_ruleRegularEventSpec= ruleRegularEventSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRegularEventSpecRule()); 
            }
            pushFollow(FOLLOW_ruleRegularEventSpec_in_entryRuleRegularEventSpec4937);
            iv_ruleRegularEventSpec=ruleRegularEventSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRegularEventSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRegularEventSpec4947); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2144:1: ruleRegularEventSpec returns [EObject current=null] : ( (lv_event_0_0= ruleFeatureCall ) ) ;
    public final EObject ruleRegularEventSpec() throws RecognitionException {
        EObject current = null;

        EObject lv_event_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2147:28: ( ( (lv_event_0_0= ruleFeatureCall ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2148:1: ( (lv_event_0_0= ruleFeatureCall ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2148:1: ( (lv_event_0_0= ruleFeatureCall ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2149:1: (lv_event_0_0= ruleFeatureCall )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2149:1: (lv_event_0_0= ruleFeatureCall )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2150:3: lv_event_0_0= ruleFeatureCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRegularEventSpecAccess().getEventFeatureCallParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFeatureCall_in_ruleRegularEventSpec4992);
            lv_event_0_0=ruleFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRegularEventSpecRule());
              	        }
                     		set(
                     			current, 
                     			"event",
                      		lv_event_0_0, 
                      		"FeatureCall");
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2174:1: entryRuleTimeEventSpec returns [EObject current=null] : iv_ruleTimeEventSpec= ruleTimeEventSpec EOF ;
    public final EObject entryRuleTimeEventSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeEventSpec = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2175:2: (iv_ruleTimeEventSpec= ruleTimeEventSpec EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2176:2: iv_ruleTimeEventSpec= ruleTimeEventSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTimeEventSpecRule()); 
            }
            pushFollow(FOLLOW_ruleTimeEventSpec_in_entryRuleTimeEventSpec5027);
            iv_ruleTimeEventSpec=ruleTimeEventSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTimeEventSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeEventSpec5037); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2183:1: ruleTimeEventSpec returns [EObject current=null] : ( ( (lv_type_0_0= ruleTimeEventType ) ) ( (lv_value_1_0= ruleConditionalExpression ) ) ( (lv_unit_2_0= ruleTimeUnit ) ) ) ;
    public final EObject ruleTimeEventSpec() throws RecognitionException {
        EObject current = null;

        Enumerator lv_type_0_0 = null;

        EObject lv_value_1_0 = null;

        Enumerator lv_unit_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2186:28: ( ( ( (lv_type_0_0= ruleTimeEventType ) ) ( (lv_value_1_0= ruleConditionalExpression ) ) ( (lv_unit_2_0= ruleTimeUnit ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2187:1: ( ( (lv_type_0_0= ruleTimeEventType ) ) ( (lv_value_1_0= ruleConditionalExpression ) ) ( (lv_unit_2_0= ruleTimeUnit ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2187:1: ( ( (lv_type_0_0= ruleTimeEventType ) ) ( (lv_value_1_0= ruleConditionalExpression ) ) ( (lv_unit_2_0= ruleTimeUnit ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2187:2: ( (lv_type_0_0= ruleTimeEventType ) ) ( (lv_value_1_0= ruleConditionalExpression ) ) ( (lv_unit_2_0= ruleTimeUnit ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2187:2: ( (lv_type_0_0= ruleTimeEventType ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2188:1: (lv_type_0_0= ruleTimeEventType )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2188:1: (lv_type_0_0= ruleTimeEventType )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2189:3: lv_type_0_0= ruleTimeEventType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTimeEventSpecAccess().getTypeTimeEventTypeEnumRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTimeEventType_in_ruleTimeEventSpec5083);
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

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2205:2: ( (lv_value_1_0= ruleConditionalExpression ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2206:1: (lv_value_1_0= ruleConditionalExpression )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2206:1: (lv_value_1_0= ruleConditionalExpression )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2207:3: lv_value_1_0= ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTimeEventSpecAccess().getValueConditionalExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleConditionalExpression_in_ruleTimeEventSpec5104);
            lv_value_1_0=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTimeEventSpecRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"ConditionalExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2223:2: ( (lv_unit_2_0= ruleTimeUnit ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2224:1: (lv_unit_2_0= ruleTimeUnit )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2224:1: (lv_unit_2_0= ruleTimeUnit )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2225:3: lv_unit_2_0= ruleTimeUnit
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTimeEventSpecAccess().getUnitTimeUnitEnumRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTimeUnit_in_ruleTimeEventSpec5125);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2249:1: entryRuleBuiltinEventSpec returns [EObject current=null] : iv_ruleBuiltinEventSpec= ruleBuiltinEventSpec EOF ;
    public final EObject entryRuleBuiltinEventSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBuiltinEventSpec = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2250:2: (iv_ruleBuiltinEventSpec= ruleBuiltinEventSpec EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2251:2: iv_ruleBuiltinEventSpec= ruleBuiltinEventSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBuiltinEventSpecRule()); 
            }
            pushFollow(FOLLOW_ruleBuiltinEventSpec_in_entryRuleBuiltinEventSpec5161);
            iv_ruleBuiltinEventSpec=ruleBuiltinEventSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBuiltinEventSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBuiltinEventSpec5171); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2258:1: ruleBuiltinEventSpec returns [EObject current=null] : (this_EntryEvent_0= ruleEntryEvent | this_ExitEvent_1= ruleExitEvent | this_AlwaysEvent_2= ruleAlwaysEvent ) ;
    public final EObject ruleBuiltinEventSpec() throws RecognitionException {
        EObject current = null;

        EObject this_EntryEvent_0 = null;

        EObject this_ExitEvent_1 = null;

        EObject this_AlwaysEvent_2 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2261:28: ( (this_EntryEvent_0= ruleEntryEvent | this_ExitEvent_1= ruleExitEvent | this_AlwaysEvent_2= ruleAlwaysEvent ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2262:1: (this_EntryEvent_0= ruleEntryEvent | this_ExitEvent_1= ruleExitEvent | this_AlwaysEvent_2= ruleAlwaysEvent )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2262:1: (this_EntryEvent_0= ruleEntryEvent | this_ExitEvent_1= ruleExitEvent | this_AlwaysEvent_2= ruleAlwaysEvent )
            int alt35=3;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt35=1;
                }
                break;
            case 36:
                {
                alt35=2;
                }
                break;
            case 37:
            case 38:
                {
                alt35=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2263:5: this_EntryEvent_0= ruleEntryEvent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBuiltinEventSpecAccess().getEntryEventParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEntryEvent_in_ruleBuiltinEventSpec5218);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2273:5: this_ExitEvent_1= ruleExitEvent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBuiltinEventSpecAccess().getExitEventParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExitEvent_in_ruleBuiltinEventSpec5245);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2283:5: this_AlwaysEvent_2= ruleAlwaysEvent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBuiltinEventSpecAccess().getAlwaysEventParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAlwaysEvent_in_ruleBuiltinEventSpec5272);
                    this_AlwaysEvent_2=ruleAlwaysEvent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AlwaysEvent_2; 
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2299:1: entryRuleEntryEvent returns [EObject current=null] : iv_ruleEntryEvent= ruleEntryEvent EOF ;
    public final EObject entryRuleEntryEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryEvent = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2300:2: (iv_ruleEntryEvent= ruleEntryEvent EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2301:2: iv_ruleEntryEvent= ruleEntryEvent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEntryEventRule()); 
            }
            pushFollow(FOLLOW_ruleEntryEvent_in_entryRuleEntryEvent5307);
            iv_ruleEntryEvent=ruleEntryEvent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEntryEvent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryEvent5317); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2308:1: ruleEntryEvent returns [EObject current=null] : ( () otherlv_1= 'entry' ) ;
    public final EObject ruleEntryEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2311:28: ( ( () otherlv_1= 'entry' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2312:1: ( () otherlv_1= 'entry' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2312:1: ( () otherlv_1= 'entry' )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2312:2: () otherlv_1= 'entry'
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2312:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2313:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEntryEventAccess().getEntryEventAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleEntryEvent5363); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2330:1: entryRuleExitEvent returns [EObject current=null] : iv_ruleExitEvent= ruleExitEvent EOF ;
    public final EObject entryRuleExitEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitEvent = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2331:2: (iv_ruleExitEvent= ruleExitEvent EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2332:2: iv_ruleExitEvent= ruleExitEvent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExitEventRule()); 
            }
            pushFollow(FOLLOW_ruleExitEvent_in_entryRuleExitEvent5399);
            iv_ruleExitEvent=ruleExitEvent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExitEvent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitEvent5409); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2339:1: ruleExitEvent returns [EObject current=null] : ( () otherlv_1= 'exit' ) ;
    public final EObject ruleExitEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2342:28: ( ( () otherlv_1= 'exit' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2343:1: ( () otherlv_1= 'exit' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2343:1: ( () otherlv_1= 'exit' )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2343:2: () otherlv_1= 'exit'
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2343:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2344:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getExitEventAccess().getExitEventAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleExitEvent5455); if (state.failed) return current;
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


    // $ANTLR start "entryRuleAlwaysEvent"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2361:1: entryRuleAlwaysEvent returns [EObject current=null] : iv_ruleAlwaysEvent= ruleAlwaysEvent EOF ;
    public final EObject entryRuleAlwaysEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlwaysEvent = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2362:2: (iv_ruleAlwaysEvent= ruleAlwaysEvent EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2363:2: iv_ruleAlwaysEvent= ruleAlwaysEvent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAlwaysEventRule()); 
            }
            pushFollow(FOLLOW_ruleAlwaysEvent_in_entryRuleAlwaysEvent5491);
            iv_ruleAlwaysEvent=ruleAlwaysEvent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAlwaysEvent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlwaysEvent5501); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2370:1: ruleAlwaysEvent returns [EObject current=null] : ( () (otherlv_1= 'always' | otherlv_2= 'oncycle' ) ) ;
    public final EObject ruleAlwaysEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2373:28: ( ( () (otherlv_1= 'always' | otherlv_2= 'oncycle' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2374:1: ( () (otherlv_1= 'always' | otherlv_2= 'oncycle' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2374:1: ( () (otherlv_1= 'always' | otherlv_2= 'oncycle' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2374:2: () (otherlv_1= 'always' | otherlv_2= 'oncycle' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2374:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2375:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAlwaysEventAccess().getAlwaysEventAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2380:2: (otherlv_1= 'always' | otherlv_2= 'oncycle' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==37) ) {
                alt36=1;
            }
            else if ( (LA36_0==38) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2380:4: otherlv_1= 'always'
                    {
                    otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleAlwaysEvent5548); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getAlwaysEventAccess().getAlwaysKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2385:7: otherlv_2= 'oncycle'
                    {
                    otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleAlwaysEvent5566); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getAlwaysEventAccess().getOncycleKeyword_1_1());
                          
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
    // $ANTLR end "ruleAlwaysEvent"


    // $ANTLR start "entryRuleEventRaisingExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2397:1: entryRuleEventRaisingExpression returns [EObject current=null] : iv_ruleEventRaisingExpression= ruleEventRaisingExpression EOF ;
    public final EObject entryRuleEventRaisingExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventRaisingExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2398:2: (iv_ruleEventRaisingExpression= ruleEventRaisingExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2399:2: iv_ruleEventRaisingExpression= ruleEventRaisingExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventRaisingExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleEventRaisingExpression_in_entryRuleEventRaisingExpression5603);
            iv_ruleEventRaisingExpression=ruleEventRaisingExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventRaisingExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventRaisingExpression5613); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEventRaisingExpression"


    // $ANTLR start "ruleEventRaisingExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2406:1: ruleEventRaisingExpression returns [EObject current=null] : ( () otherlv_1= 'raise' ( (lv_event_2_0= ruleFeatureCall ) ) (otherlv_3= ':' ( (lv_value_4_0= ruleExpression ) ) )? ) ;
    public final EObject ruleEventRaisingExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_event_2_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2409:28: ( ( () otherlv_1= 'raise' ( (lv_event_2_0= ruleFeatureCall ) ) (otherlv_3= ':' ( (lv_value_4_0= ruleExpression ) ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2410:1: ( () otherlv_1= 'raise' ( (lv_event_2_0= ruleFeatureCall ) ) (otherlv_3= ':' ( (lv_value_4_0= ruleExpression ) ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2410:1: ( () otherlv_1= 'raise' ( (lv_event_2_0= ruleFeatureCall ) ) (otherlv_3= ':' ( (lv_value_4_0= ruleExpression ) ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2410:2: () otherlv_1= 'raise' ( (lv_event_2_0= ruleFeatureCall ) ) (otherlv_3= ':' ( (lv_value_4_0= ruleExpression ) ) )?
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2410:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2411:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEventRaisingExpressionAccess().getEventRaisingExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleEventRaisingExpression5659); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEventRaisingExpressionAccess().getRaiseKeyword_1());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2420:1: ( (lv_event_2_0= ruleFeatureCall ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2421:1: (lv_event_2_0= ruleFeatureCall )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2421:1: (lv_event_2_0= ruleFeatureCall )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2422:3: lv_event_2_0= ruleFeatureCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEventRaisingExpressionAccess().getEventFeatureCallParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFeatureCall_in_ruleEventRaisingExpression5680);
            lv_event_2_0=ruleFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEventRaisingExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"event",
                      		lv_event_2_0, 
                      		"FeatureCall");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2438:2: (otherlv_3= ':' ( (lv_value_4_0= ruleExpression ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==19) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2438:4: otherlv_3= ':' ( (lv_value_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleEventRaisingExpression5693); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getEventRaisingExpressionAccess().getColonKeyword_3_0());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2442:1: ( (lv_value_4_0= ruleExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2443:1: (lv_value_4_0= ruleExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2443:1: (lv_value_4_0= ruleExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2444:3: lv_value_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEventRaisingExpressionAccess().getValueExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleEventRaisingExpression5714);
                    lv_value_4_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEventRaisingExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_4_0, 
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
    // $ANTLR end "ruleEventRaisingExpression"


    // $ANTLR start "entryRuleExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2470:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2471:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2472:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression5754);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression5764); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2479:1: ruleExpression returns [EObject current=null] : this_AssignmentExpression_0= ruleAssignmentExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AssignmentExpression_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2482:28: (this_AssignmentExpression_0= ruleAssignmentExpression )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2484:5: this_AssignmentExpression_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleAssignmentExpression_in_ruleExpression5810);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2500:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2501:2: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2502:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAssignmentExpression_in_entryRuleAssignmentExpression5844);
            iv_ruleAssignmentExpression=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentExpression5854); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2509:1: ruleAssignmentExpression returns [EObject current=null] : (this_ConditionalExpression_0= ruleConditionalExpression ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )* ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionalExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2512:28: ( (this_ConditionalExpression_0= ruleConditionalExpression ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2513:1: (this_ConditionalExpression_0= ruleConditionalExpression ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2513:1: (this_ConditionalExpression_0= ruleConditionalExpression ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2514:5: this_ConditionalExpression_0= ruleConditionalExpression ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getConditionalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleConditionalExpression_in_ruleAssignmentExpression5901);
            this_ConditionalExpression_0=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ConditionalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2522:1: ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==25||(LA38_0>=58 && LA38_0<=67)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2522:2: () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2522:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2523:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2528:2: ( (lv_operator_2_0= ruleAssignmentOperator ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2529:1: (lv_operator_2_0= ruleAssignmentOperator )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2529:1: (lv_operator_2_0= ruleAssignmentOperator )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2530:3: lv_operator_2_0= ruleAssignmentOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getOperatorAssignmentOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAssignmentOperator_in_ruleAssignmentExpression5931);
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

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2546:2: ( (lv_expression_3_0= ruleConditionalExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2547:1: (lv_expression_3_0= ruleConditionalExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2547:1: (lv_expression_3_0= ruleConditionalExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2548:3: lv_expression_3_0= ruleConditionalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getExpressionConditionalExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleConditionalExpression_in_ruleAssignmentExpression5952);
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
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleConditionalExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2572:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2573:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2574:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression5990);
            iv_ruleConditionalExpression=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression6000); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2581:1: ruleConditionalExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_LogicalOrExpression_0 = null;

        EObject lv_trueCase_3_0 = null;

        EObject lv_falseCase_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2584:28: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2585:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2585:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2586:5: this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getConditionalExpressionAccess().getLogicalOrExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleConditionalExpression6047);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_LogicalOrExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2594:1: ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==49) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2594:2: () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2594:2: ()
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2595:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,49,FOLLOW_49_in_ruleConditionalExpression6068); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getConditionalExpressionAccess().getQuestionMarkKeyword_1_1());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2604:1: ( (lv_trueCase_3_0= ruleLogicalOrExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2605:1: (lv_trueCase_3_0= ruleLogicalOrExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2605:1: (lv_trueCase_3_0= ruleLogicalOrExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2606:3: lv_trueCase_3_0= ruleLogicalOrExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getTrueCaseLogicalOrExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleConditionalExpression6089);
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

                    otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleConditionalExpression6101); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_3());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2626:1: ( (lv_falseCase_5_0= ruleLogicalOrExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2627:1: (lv_falseCase_5_0= ruleLogicalOrExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2627:1: (lv_falseCase_5_0= ruleLogicalOrExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2628:3: lv_falseCase_5_0= ruleLogicalOrExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getFalseCaseLogicalOrExpressionParserRuleCall_1_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleConditionalExpression6122);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2652:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2653:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2654:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression6160);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOrExpression6170); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2661:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LogicalAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2664:28: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2665:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2665:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2666:5: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression6217);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_LogicalAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2674:1: ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==50) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2674:2: () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2674:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2675:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,50,FOLLOW_50_in_ruleLogicalOrExpression6238); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLogicalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_1());
            	          
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2684:1: ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2685:1: (lv_rightOperand_3_0= ruleLogicalAndExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2685:1: (lv_rightOperand_3_0= ruleLogicalAndExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2686:3: lv_rightOperand_3_0= ruleLogicalAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightOperandLogicalAndExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression6259);
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
    // $ANTLR end "ruleLogicalOrExpression"


    // $ANTLR start "entryRuleLogicalAndExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2710:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2711:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2712:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression6297);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalAndExpression6307); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2719:1: ruleLogicalAndExpression returns [EObject current=null] : (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LogicalNotExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2722:28: ( (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2723:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2723:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2724:5: this_LogicalNotExpression_0= ruleLogicalNotExpression ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getLogicalNotExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression6354);
            this_LogicalNotExpression_0=ruleLogicalNotExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_LogicalNotExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2732:1: ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==51) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2732:2: () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2732:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2733:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,51,FOLLOW_51_in_ruleLogicalAndExpression6375); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLogicalAndExpressionAccess().getAmpersandAmpersandKeyword_1_1());
            	          
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2742:1: ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2743:1: (lv_rightOperand_3_0= ruleLogicalNotExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2743:1: (lv_rightOperand_3_0= ruleLogicalNotExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2744:3: lv_rightOperand_3_0= ruleLogicalNotExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightOperandLogicalNotExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression6396);
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
    // $ANTLR end "ruleLogicalAndExpression"


    // $ANTLR start "entryRuleLogicalNotExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2768:1: entryRuleLogicalNotExpression returns [EObject current=null] : iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF ;
    public final EObject entryRuleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalNotExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2769:2: (iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2770:2: iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalNotExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression6434);
            iv_ruleLogicalNotExpression=ruleLogicalNotExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalNotExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalNotExpression6444); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2777:1: ruleLogicalNotExpression returns [EObject current=null] : (this_BitwiseXorExpression_0= ruleBitwiseXorExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) ) ) ;
    public final EObject ruleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_BitwiseXorExpression_0 = null;

        EObject lv_operand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2780:28: ( (this_BitwiseXorExpression_0= ruleBitwiseXorExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2781:1: (this_BitwiseXorExpression_0= ruleBitwiseXorExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2781:1: (this_BitwiseXorExpression_0= ruleBitwiseXorExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=RULE_ID && LA42_0<=RULE_STRING)||LA42_0==27||(LA42_0>=40 && LA42_0<=41)||(LA42_0>=70 && LA42_0<=71)||LA42_0==74) ) {
                alt42=1;
            }
            else if ( (LA42_0==52) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2782:5: this_BitwiseXorExpression_0= ruleBitwiseXorExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getBitwiseXorExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBitwiseXorExpression_in_ruleLogicalNotExpression6491);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2791:6: ( () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2791:6: ( () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2791:7: () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2791:7: ()
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2792:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLogicalNotExpressionAccess().getLogicalNotExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,52,FOLLOW_52_in_ruleLogicalNotExpression6518); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getLogicalNotExpressionAccess().getExclamationMarkKeyword_1_1());
                          
                    }
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2801:1: ( (lv_operand_3_0= ruleBitwiseXorExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2802:1: (lv_operand_3_0= ruleBitwiseXorExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2802:1: (lv_operand_3_0= ruleBitwiseXorExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2803:3: lv_operand_3_0= ruleBitwiseXorExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getOperandBitwiseXorExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBitwiseXorExpression_in_ruleLogicalNotExpression6539);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2827:1: entryRuleBitwiseXorExpression returns [EObject current=null] : iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF ;
    public final EObject entryRuleBitwiseXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseXorExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2828:2: (iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2829:2: iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseXorExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBitwiseXorExpression_in_entryRuleBitwiseXorExpression6576);
            iv_ruleBitwiseXorExpression=ruleBitwiseXorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseXorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseXorExpression6586); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2836:1: ruleBitwiseXorExpression returns [EObject current=null] : (this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )* ) ;
    public final EObject ruleBitwiseXorExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_BitwiseOrExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2839:28: ( (this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2840:1: (this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2840:1: (this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2841:5: this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBitwiseXorExpressionAccess().getBitwiseOrExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleBitwiseOrExpression_in_ruleBitwiseXorExpression6633);
            this_BitwiseOrExpression_0=ruleBitwiseOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_BitwiseOrExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2849:1: ( () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==53) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2849:2: () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2849:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2850:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXorExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,53,FOLLOW_53_in_ruleBitwiseXorExpression6654); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getBitwiseXorExpressionAccess().getCircumflexAccentKeyword_1_1());
            	          
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2859:1: ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2860:1: (lv_rightOperand_3_0= ruleBitwiseOrExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2860:1: (lv_rightOperand_3_0= ruleBitwiseOrExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2861:3: lv_rightOperand_3_0= ruleBitwiseOrExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBitwiseXorExpressionAccess().getRightOperandBitwiseOrExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleBitwiseOrExpression_in_ruleBitwiseXorExpression6675);
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
            	    break loop43;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2885:1: entryRuleBitwiseOrExpression returns [EObject current=null] : iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF ;
    public final EObject entryRuleBitwiseOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseOrExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2886:2: (iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2887:2: iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBitwiseOrExpression_in_entryRuleBitwiseOrExpression6713);
            iv_ruleBitwiseOrExpression=ruleBitwiseOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseOrExpression6723); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2894:1: ruleBitwiseOrExpression returns [EObject current=null] : (this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )* ) ;
    public final EObject ruleBitwiseOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_BitwiseAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2897:28: ( (this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2898:1: (this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2898:1: (this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2899:5: this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBitwiseOrExpressionAccess().getBitwiseAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleBitwiseAndExpression_in_ruleBitwiseOrExpression6770);
            this_BitwiseAndExpression_0=ruleBitwiseAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_BitwiseAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2907:1: ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==54) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2907:2: () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2907:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2908:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getBitwiseOrExpressionAccess().getBitwiseOrExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,54,FOLLOW_54_in_ruleBitwiseOrExpression6791); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getBitwiseOrExpressionAccess().getVerticalLineKeyword_1_1());
            	          
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2917:1: ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2918:1: (lv_rightOperand_3_0= ruleBitwiseAndExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2918:1: (lv_rightOperand_3_0= ruleBitwiseAndExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2919:3: lv_rightOperand_3_0= ruleBitwiseAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBitwiseOrExpressionAccess().getRightOperandBitwiseAndExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleBitwiseAndExpression_in_ruleBitwiseOrExpression6812);
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
    // $ANTLR end "ruleBitwiseOrExpression"


    // $ANTLR start "entryRuleBitwiseAndExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2943:1: entryRuleBitwiseAndExpression returns [EObject current=null] : iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF ;
    public final EObject entryRuleBitwiseAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseAndExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2944:2: (iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2945:2: iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBitwiseAndExpression_in_entryRuleBitwiseAndExpression6850);
            iv_ruleBitwiseAndExpression=ruleBitwiseAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseAndExpression6860); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2952:1: ruleBitwiseAndExpression returns [EObject current=null] : (this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )* ) ;
    public final EObject ruleBitwiseAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LogicalRelationExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2955:28: ( (this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2956:1: (this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2956:1: (this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2957:5: this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBitwiseAndExpressionAccess().getLogicalRelationExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleLogicalRelationExpression_in_ruleBitwiseAndExpression6907);
            this_LogicalRelationExpression_0=ruleLogicalRelationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_LogicalRelationExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2965:1: ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==55) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2965:2: () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2965:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2966:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAndExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,55,FOLLOW_55_in_ruleBitwiseAndExpression6928); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getBitwiseAndExpressionAccess().getAmpersandKeyword_1_1());
            	          
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2975:1: ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2976:1: (lv_rightOperand_3_0= ruleLogicalRelationExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2976:1: (lv_rightOperand_3_0= ruleLogicalRelationExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:2977:3: lv_rightOperand_3_0= ruleLogicalRelationExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBitwiseAndExpressionAccess().getRightOperandLogicalRelationExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalRelationExpression_in_ruleBitwiseAndExpression6949);
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
    // $ANTLR end "ruleBitwiseAndExpression"


    // $ANTLR start "entryRuleLogicalRelationExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3001:1: entryRuleLogicalRelationExpression returns [EObject current=null] : iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF ;
    public final EObject entryRuleLogicalRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalRelationExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3002:2: (iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3003:2: iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalRelationExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalRelationExpression_in_entryRuleLogicalRelationExpression6987);
            iv_ruleLogicalRelationExpression=ruleLogicalRelationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalRelationExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalRelationExpression6997); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3010:1: ruleLogicalRelationExpression returns [EObject current=null] : (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )* ) ;
    public final EObject ruleLogicalRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ShiftExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3013:28: ( (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3014:1: (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3014:1: (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3015:5: this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getShiftExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleShiftExpression_in_ruleLogicalRelationExpression7044);
            this_ShiftExpression_0=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ShiftExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3023:1: ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==48||(LA46_0>=75 && LA46_0<=79)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3023:2: () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3023:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3024:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3029:2: ( (lv_operator_2_0= ruleRelationalOperator ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3030:1: (lv_operator_2_0= ruleRelationalOperator )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3030:1: (lv_operator_2_0= ruleRelationalOperator )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3031:3: lv_operator_2_0= ruleRelationalOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRelationalOperator_in_ruleLogicalRelationExpression7074);
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

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3047:2: ( (lv_rightOperand_3_0= ruleShiftExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3048:1: (lv_rightOperand_3_0= ruleShiftExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3048:1: (lv_rightOperand_3_0= ruleShiftExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3049:3: lv_rightOperand_3_0= ruleShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getRightOperandShiftExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleShiftExpression_in_ruleLogicalRelationExpression7095);
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
    // $ANTLR end "ruleLogicalRelationExpression"


    // $ANTLR start "entryRuleShiftExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3073:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3074:2: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3075:2: iv_ruleShiftExpression= ruleShiftExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShiftExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleShiftExpression_in_entryRuleShiftExpression7133);
            iv_ruleShiftExpression=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShiftExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleShiftExpression7143); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3082:1: ruleShiftExpression returns [EObject current=null] : (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalAddSubtractExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3085:28: ( (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3086:1: (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3086:1: (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3087:5: this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getShiftExpressionAccess().getNumericalAddSubtractExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_ruleShiftExpression7190);
            this_NumericalAddSubtractExpression_0=ruleNumericalAddSubtractExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_NumericalAddSubtractExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3095:1: ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=68 && LA47_0<=69)) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3095:2: () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3095:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3096:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3101:2: ( (lv_operator_2_0= ruleShiftOperator ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3102:1: (lv_operator_2_0= ruleShiftOperator )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3102:1: (lv_operator_2_0= ruleShiftOperator )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3103:3: lv_operator_2_0= ruleShiftOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getOperatorShiftOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleShiftOperator_in_ruleShiftExpression7220);
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

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3119:2: ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3120:1: (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3120:1: (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3121:3: lv_rightOperand_3_0= ruleNumericalAddSubtractExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getRightOperandNumericalAddSubtractExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_ruleShiftExpression7241);
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
    // $ANTLR end "ruleShiftExpression"


    // $ANTLR start "entryRuleNumericalAddSubtractExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3145:1: entryRuleNumericalAddSubtractExpression returns [EObject current=null] : iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF ;
    public final EObject entryRuleNumericalAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalAddSubtractExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3146:2: (iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3147:2: iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_entryRuleNumericalAddSubtractExpression7279);
            iv_ruleNumericalAddSubtractExpression=ruleNumericalAddSubtractExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericalAddSubtractExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalAddSubtractExpression7289); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3154:1: ruleNumericalAddSubtractExpression returns [EObject current=null] : (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* ) ;
    public final EObject ruleNumericalAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalMultiplyDivideExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3157:28: ( (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3158:1: (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3158:1: (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3159:5: this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalMultiplyDivideExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression7336);
            this_NumericalMultiplyDivideExpression_0=ruleNumericalMultiplyDivideExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_NumericalMultiplyDivideExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3167:1: ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( ((LA48_0>=70 && LA48_0<=71)) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3167:2: () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3167:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3168:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalAddSubtractExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3173:2: ( (lv_operator_2_0= ruleAdditiveOperator ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3174:1: (lv_operator_2_0= ruleAdditiveOperator )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3174:1: (lv_operator_2_0= ruleAdditiveOperator )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3175:3: lv_operator_2_0= ruleAdditiveOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getOperatorAdditiveOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleNumericalAddSubtractExpression7366);
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

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3191:2: ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3192:1: (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3192:1: (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3193:3: lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getRightOperandNumericalMultiplyDivideExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression7387);
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
    // $ANTLR end "ruleNumericalAddSubtractExpression"


    // $ANTLR start "entryRuleNumericalMultiplyDivideExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3217:1: entryRuleNumericalMultiplyDivideExpression returns [EObject current=null] : iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF ;
    public final EObject entryRuleNumericalMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalMultiplyDivideExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3218:2: (iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3219:2: iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_entryRuleNumericalMultiplyDivideExpression7425);
            iv_ruleNumericalMultiplyDivideExpression=ruleNumericalMultiplyDivideExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericalMultiplyDivideExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalMultiplyDivideExpression7435); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3226:1: ruleNumericalMultiplyDivideExpression returns [EObject current=null] : (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* ) ;
    public final EObject ruleNumericalMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalUnaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3229:28: ( (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3230:1: (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3230:1: (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3231:5: this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalUnaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression7482);
            this_NumericalUnaryExpression_0=ruleNumericalUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_NumericalUnaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3239:1: ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==43||(LA49_0>=72 && LA49_0<=73)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3239:2: () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3239:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3240:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalMultiplyDivideExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3245:2: ( (lv_operator_2_0= ruleMultiplicativeOperator ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3246:1: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3246:1: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3247:3: lv_operator_2_0= ruleMultiplicativeOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getOperatorMultiplicativeOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleNumericalMultiplyDivideExpression7512);
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

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3263:2: ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3264:1: (lv_rightOperand_3_0= ruleNumericalUnaryExpression )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3264:1: (lv_rightOperand_3_0= ruleNumericalUnaryExpression )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3265:3: lv_rightOperand_3_0= ruleNumericalUnaryExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getRightOperandNumericalUnaryExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression7533);
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
    // $ANTLR end "ruleNumericalMultiplyDivideExpression"


    // $ANTLR start "entryRuleNumericalUnaryExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3289:1: entryRuleNumericalUnaryExpression returns [EObject current=null] : iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF ;
    public final EObject entryRuleNumericalUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalUnaryExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3290:2: (iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3291:2: iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_entryRuleNumericalUnaryExpression7571);
            iv_ruleNumericalUnaryExpression=ruleNumericalUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericalUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalUnaryExpression7581); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3298:1: ruleNumericalUnaryExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) ) ;
    public final EObject ruleNumericalUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_operand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3301:28: ( (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3302:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3302:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=RULE_ID && LA50_0<=RULE_STRING)||LA50_0==27||(LA50_0>=40 && LA50_0<=41)) ) {
                alt50=1;
            }
            else if ( ((LA50_0>=70 && LA50_0<=71)||LA50_0==74) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3303:5: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression7628);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3312:6: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3312:6: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3312:7: () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3312:7: ()
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3313:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getNumericalUnaryExpressionAccess().getNumericalUnaryExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3318:2: ( (lv_operator_2_0= ruleUnaryOperator ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3319:1: (lv_operator_2_0= ruleUnaryOperator )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3319:1: (lv_operator_2_0= ruleUnaryOperator )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3320:3: lv_operator_2_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getOperatorUnaryOperatorEnumRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleNumericalUnaryExpression7664);
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

                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3336:2: ( (lv_operand_3_0= rulePrimaryExpression ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3337:1: (lv_operand_3_0= rulePrimaryExpression )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3337:1: (lv_operand_3_0= rulePrimaryExpression )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3338:3: lv_operand_3_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression7685);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3362:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3363:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3364:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression7722);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression7732); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3371:1: rulePrimaryExpression returns [EObject current=null] : (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_FeatureCall_1= ruleFeatureCall | this_ActiveStateReferenceExpression_2= ruleActiveStateReferenceExpression | this_EventValueReferenceExpression_3= ruleEventValueReferenceExpression | this_ParenthesizedExpression_4= ruleParenthesizedExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveValueExpression_0 = null;

        EObject this_FeatureCall_1 = null;

        EObject this_ActiveStateReferenceExpression_2 = null;

        EObject this_EventValueReferenceExpression_3 = null;

        EObject this_ParenthesizedExpression_4 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3374:28: ( (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_FeatureCall_1= ruleFeatureCall | this_ActiveStateReferenceExpression_2= ruleActiveStateReferenceExpression | this_EventValueReferenceExpression_3= ruleEventValueReferenceExpression | this_ParenthesizedExpression_4= ruleParenthesizedExpression ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3375:1: (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_FeatureCall_1= ruleFeatureCall | this_ActiveStateReferenceExpression_2= ruleActiveStateReferenceExpression | this_EventValueReferenceExpression_3= ruleEventValueReferenceExpression | this_ParenthesizedExpression_4= ruleParenthesizedExpression )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3375:1: (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_FeatureCall_1= ruleFeatureCall | this_ActiveStateReferenceExpression_2= ruleActiveStateReferenceExpression | this_EventValueReferenceExpression_3= ruleEventValueReferenceExpression | this_ParenthesizedExpression_4= ruleParenthesizedExpression )
            int alt51=5;
            switch ( input.LA(1) ) {
            case RULE_BOOL:
            case RULE_INT:
            case RULE_FLOAT:
            case RULE_HEX:
            case RULE_STRING:
                {
                alt51=1;
                }
                break;
            case RULE_ID:
                {
                alt51=2;
                }
                break;
            case 41:
                {
                alt51=3;
                }
                break;
            case 40:
                {
                alt51=4;
                }
                break;
            case 27:
                {
                alt51=5;
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3376:5: this_PrimitiveValueExpression_0= rulePrimitiveValueExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getPrimitiveValueExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimitiveValueExpression_in_rulePrimaryExpression7779);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3386:5: this_FeatureCall_1= ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFeatureCallParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFeatureCall_in_rulePrimaryExpression7806);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3396:5: this_ActiveStateReferenceExpression_2= ruleActiveStateReferenceExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getActiveStateReferenceExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleActiveStateReferenceExpression_in_rulePrimaryExpression7833);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3406:5: this_EventValueReferenceExpression_3= ruleEventValueReferenceExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getEventValueReferenceExpressionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEventValueReferenceExpression_in_rulePrimaryExpression7860);
                    this_EventValueReferenceExpression_3=ruleEventValueReferenceExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_EventValueReferenceExpression_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3416:5: this_ParenthesizedExpression_4= ruleParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression7887);
                    this_ParenthesizedExpression_4=ruleParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ParenthesizedExpression_4; 
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3432:1: entryRulePrimitiveValueExpression returns [EObject current=null] : iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF ;
    public final EObject entryRulePrimitiveValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValueExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3433:2: (iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3434:2: iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveValueExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimitiveValueExpression_in_entryRulePrimitiveValueExpression7922);
            iv_rulePrimitiveValueExpression=rulePrimitiveValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveValueExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveValueExpression7932); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3441:1: rulePrimitiveValueExpression returns [EObject current=null] : ( () ( (lv_value_1_0= ruleLiteral ) ) ) ;
    public final EObject rulePrimitiveValueExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3444:28: ( ( () ( (lv_value_1_0= ruleLiteral ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3445:1: ( () ( (lv_value_1_0= ruleLiteral ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3445:1: ( () ( (lv_value_1_0= ruleLiteral ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3445:2: () ( (lv_value_1_0= ruleLiteral ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3445:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3446:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPrimitiveValueExpressionAccess().getPrimitiveValueExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3451:2: ( (lv_value_1_0= ruleLiteral ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3452:1: (lv_value_1_0= ruleLiteral )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3452:1: (lv_value_1_0= ruleLiteral )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3453:3: lv_value_1_0= ruleLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrimitiveValueExpressionAccess().getValueLiteralParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLiteral_in_rulePrimitiveValueExpression7987);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3477:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3478:2: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3479:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall8023);
            iv_ruleFeatureCall=ruleFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCall8033); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3486:1: ruleFeatureCall returns [EObject current=null] : (this_ElementReferenceExpression_0= ruleElementReferenceExpression ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )? )* ) ;
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
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3489:28: ( (this_ElementReferenceExpression_0= ruleElementReferenceExpression ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )? )* ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3490:1: (this_ElementReferenceExpression_0= ruleElementReferenceExpression ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )? )* )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3490:1: (this_ElementReferenceExpression_0= ruleElementReferenceExpression ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )? )* )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3491:5: this_ElementReferenceExpression_0= ruleElementReferenceExpression ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )? )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getFeatureCallAccess().getElementReferenceExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleElementReferenceExpression_in_ruleFeatureCall8080);
            this_ElementReferenceExpression_0=ruleElementReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ElementReferenceExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3499:1: ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )? )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==42) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3499:2: () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )?
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3499:2: ()
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3500:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getFeatureCallAccess().getFeatureCallOwnerAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,42,FOLLOW_42_in_ruleFeatureCall8101); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getFeatureCallAccess().getFullStopKeyword_1_1());
            	          
            	    }
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3509:1: ( (otherlv_3= RULE_ID ) )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3510:1: (otherlv_3= RULE_ID )
            	    {
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3510:1: (otherlv_3= RULE_ID )
            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3511:3: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getFeatureCallRule());
            	      	        }
            	              
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureCall8121); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_3, grammarAccess.getFeatureCallAccess().getFeatureEObjectCrossReference_1_2_0()); 
            	      	
            	    }

            	    }


            	    }

            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3522:2: ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )?
            	    int alt54=2;
            	    int LA54_0 = input.LA(1);

            	    if ( (LA54_0==27) && (synpred4_InternalSText())) {
            	        alt54=1;
            	    }
            	    switch (alt54) {
            	        case 1 :
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3522:3: ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')'
            	            {
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3522:3: ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) )
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3522:4: ( ( '(' ) )=> (lv_operationCall_4_0= '(' )
            	            {
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3529:1: (lv_operationCall_4_0= '(' )
            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3530:3: lv_operationCall_4_0= '('
            	            {
            	            lv_operationCall_4_0=(Token)match(input,27,FOLLOW_27_in_ruleFeatureCall8155); if (state.failed) return current;
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

            	            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3543:2: ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )?
            	            int alt53=2;
            	            int LA53_0 = input.LA(1);

            	            if ( ((LA53_0>=RULE_ID && LA53_0<=RULE_STRING)||LA53_0==27||(LA53_0>=40 && LA53_0<=41)||LA53_0==52||(LA53_0>=70 && LA53_0<=71)||LA53_0==74) ) {
            	                alt53=1;
            	            }
            	            switch (alt53) {
            	                case 1 :
            	                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3543:3: ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )*
            	                    {
            	                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3543:3: ( (lv_args_5_0= ruleExpression ) )
            	                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3544:1: (lv_args_5_0= ruleExpression )
            	                    {
            	                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3544:1: (lv_args_5_0= ruleExpression )
            	                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3545:3: lv_args_5_0= ruleExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getFeatureCallAccess().getArgsExpressionParserRuleCall_1_3_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleExpression_in_ruleFeatureCall8190);
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

            	                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3561:2: (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )*
            	                    loop52:
            	                    do {
            	                        int alt52=2;
            	                        int LA52_0 = input.LA(1);

            	                        if ( (LA52_0==28) ) {
            	                            alt52=1;
            	                        }


            	                        switch (alt52) {
            	                    	case 1 :
            	                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3561:4: otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) )
            	                    	    {
            	                    	    otherlv_6=(Token)match(input,28,FOLLOW_28_in_ruleFeatureCall8203); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	newLeafNode(otherlv_6, grammarAccess.getFeatureCallAccess().getCommaKeyword_1_3_1_1_0());
            	                    	          
            	                    	    }
            	                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3565:1: ( (lv_args_7_0= ruleExpression ) )
            	                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3566:1: (lv_args_7_0= ruleExpression )
            	                    	    {
            	                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3566:1: (lv_args_7_0= ruleExpression )
            	                    	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3567:3: lv_args_7_0= ruleExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        newCompositeNode(grammarAccess.getFeatureCallAccess().getArgsExpressionParserRuleCall_1_3_1_1_1_0()); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleExpression_in_ruleFeatureCall8224);
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
            	                    	    break loop52;
            	                        }
            	                    } while (true);


            	                    }
            	                    break;

            	            }

            	            otherlv_8=(Token)match(input,29,FOLLOW_29_in_ruleFeatureCall8240); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_8, grammarAccess.getFeatureCallAccess().getRightParenthesisKeyword_1_3_2());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop55;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3595:1: entryRuleElementReferenceExpression returns [EObject current=null] : iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF ;
    public final EObject entryRuleElementReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementReferenceExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3596:2: (iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3597:2: iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElementReferenceExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleElementReferenceExpression_in_entryRuleElementReferenceExpression8280);
            iv_ruleElementReferenceExpression=ruleElementReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElementReferenceExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleElementReferenceExpression8290); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3604:1: ruleElementReferenceExpression returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )? ) ;
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
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3607:28: ( ( () ( (otherlv_1= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )? ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3608:1: ( () ( (otherlv_1= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )? )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3608:1: ( () ( (otherlv_1= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )? )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3608:2: () ( (otherlv_1= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )?
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3608:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3609:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getElementReferenceExpressionAccess().getElementReferenceExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3614:2: ( (otherlv_1= RULE_ID ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3615:1: (otherlv_1= RULE_ID )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3615:1: (otherlv_1= RULE_ID )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3616:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getElementReferenceExpressionRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleElementReferenceExpression8344); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getElementReferenceExpressionAccess().getReferenceEObjectCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3627:2: ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==27) && (synpred5_InternalSText())) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3627:3: ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3627:3: ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3627:4: ( ( '(' ) )=> (lv_operationCall_2_0= '(' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3634:1: (lv_operationCall_2_0= '(' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3635:3: lv_operationCall_2_0= '('
                    {
                    lv_operationCall_2_0=(Token)match(input,27,FOLLOW_27_in_ruleElementReferenceExpression8378); if (state.failed) return current;
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

                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3648:2: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( ((LA57_0>=RULE_ID && LA57_0<=RULE_STRING)||LA57_0==27||(LA57_0>=40 && LA57_0<=41)||LA57_0==52||(LA57_0>=70 && LA57_0<=71)||LA57_0==74) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3648:3: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                            {
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3648:3: ( (lv_args_3_0= ruleExpression ) )
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3649:1: (lv_args_3_0= ruleExpression )
                            {
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3649:1: (lv_args_3_0= ruleExpression )
                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3650:3: lv_args_3_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getElementReferenceExpressionAccess().getArgsExpressionParserRuleCall_2_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExpression_in_ruleElementReferenceExpression8413);
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

                            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3666:2: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                            loop56:
                            do {
                                int alt56=2;
                                int LA56_0 = input.LA(1);

                                if ( (LA56_0==28) ) {
                                    alt56=1;
                                }


                                switch (alt56) {
                            	case 1 :
                            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3666:4: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                            	    {
                            	    otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleElementReferenceExpression8426); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_4, grammarAccess.getElementReferenceExpressionAccess().getCommaKeyword_2_1_1_0());
                            	          
                            	    }
                            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3670:1: ( (lv_args_5_0= ruleExpression ) )
                            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3671:1: (lv_args_5_0= ruleExpression )
                            	    {
                            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3671:1: (lv_args_5_0= ruleExpression )
                            	    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3672:3: lv_args_5_0= ruleExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getElementReferenceExpressionAccess().getArgsExpressionParserRuleCall_2_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExpression_in_ruleElementReferenceExpression8447);
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
                            	    break loop56;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleElementReferenceExpression8463); if (state.failed) return current;
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


    // $ANTLR start "entryRuleEventValueReferenceExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3700:1: entryRuleEventValueReferenceExpression returns [EObject current=null] : iv_ruleEventValueReferenceExpression= ruleEventValueReferenceExpression EOF ;
    public final EObject entryRuleEventValueReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventValueReferenceExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3701:2: (iv_ruleEventValueReferenceExpression= ruleEventValueReferenceExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3702:2: iv_ruleEventValueReferenceExpression= ruleEventValueReferenceExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventValueReferenceExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleEventValueReferenceExpression_in_entryRuleEventValueReferenceExpression8501);
            iv_ruleEventValueReferenceExpression=ruleEventValueReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventValueReferenceExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventValueReferenceExpression8511); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3709:1: ruleEventValueReferenceExpression returns [EObject current=null] : ( () otherlv_1= 'valueof' otherlv_2= '(' ( (lv_value_3_0= ruleFeatureCall ) ) otherlv_4= ')' ) ;
    public final EObject ruleEventValueReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3712:28: ( ( () otherlv_1= 'valueof' otherlv_2= '(' ( (lv_value_3_0= ruleFeatureCall ) ) otherlv_4= ')' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3713:1: ( () otherlv_1= 'valueof' otherlv_2= '(' ( (lv_value_3_0= ruleFeatureCall ) ) otherlv_4= ')' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3713:1: ( () otherlv_1= 'valueof' otherlv_2= '(' ( (lv_value_3_0= ruleFeatureCall ) ) otherlv_4= ')' )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3713:2: () otherlv_1= 'valueof' otherlv_2= '(' ( (lv_value_3_0= ruleFeatureCall ) ) otherlv_4= ')'
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3713:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3714:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEventValueReferenceExpressionAccess().getEventValueReferenceExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,40,FOLLOW_40_in_ruleEventValueReferenceExpression8557); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEventValueReferenceExpressionAccess().getValueofKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleEventValueReferenceExpression8569); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getEventValueReferenceExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3727:1: ( (lv_value_3_0= ruleFeatureCall ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3728:1: (lv_value_3_0= ruleFeatureCall )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3728:1: (lv_value_3_0= ruleFeatureCall )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3729:3: lv_value_3_0= ruleFeatureCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEventValueReferenceExpressionAccess().getValueFeatureCallParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFeatureCall_in_ruleEventValueReferenceExpression8590);
            lv_value_3_0=ruleFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEventValueReferenceExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_3_0, 
                      		"FeatureCall");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleEventValueReferenceExpression8602); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3757:1: entryRuleActiveStateReferenceExpression returns [EObject current=null] : iv_ruleActiveStateReferenceExpression= ruleActiveStateReferenceExpression EOF ;
    public final EObject entryRuleActiveStateReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActiveStateReferenceExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3758:2: (iv_ruleActiveStateReferenceExpression= ruleActiveStateReferenceExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3759:2: iv_ruleActiveStateReferenceExpression= ruleActiveStateReferenceExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActiveStateReferenceExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleActiveStateReferenceExpression_in_entryRuleActiveStateReferenceExpression8638);
            iv_ruleActiveStateReferenceExpression=ruleActiveStateReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActiveStateReferenceExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleActiveStateReferenceExpression8648); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3766:1: ruleActiveStateReferenceExpression returns [EObject current=null] : ( () otherlv_1= 'active' otherlv_2= '(' ( ( ruleFQN ) ) otherlv_4= ')' ) ;
    public final EObject ruleActiveStateReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3769:28: ( ( () otherlv_1= 'active' otherlv_2= '(' ( ( ruleFQN ) ) otherlv_4= ')' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3770:1: ( () otherlv_1= 'active' otherlv_2= '(' ( ( ruleFQN ) ) otherlv_4= ')' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3770:1: ( () otherlv_1= 'active' otherlv_2= '(' ( ( ruleFQN ) ) otherlv_4= ')' )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3770:2: () otherlv_1= 'active' otherlv_2= '(' ( ( ruleFQN ) ) otherlv_4= ')'
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3770:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3771:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getActiveStateReferenceExpressionAccess().getActiveStateReferenceExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleActiveStateReferenceExpression8694); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getActiveStateReferenceExpressionAccess().getActiveKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleActiveStateReferenceExpression8706); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getActiveStateReferenceExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3784:1: ( ( ruleFQN ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3785:1: ( ruleFQN )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3785:1: ( ruleFQN )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3786:3: ruleFQN
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getActiveStateReferenceExpressionRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getActiveStateReferenceExpressionAccess().getValueStateCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFQN_in_ruleActiveStateReferenceExpression8729);
            ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleActiveStateReferenceExpression8741); if (state.failed) return current;
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


    // $ANTLR start "entryRuleParenthesizedExpression"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3811:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3812:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3813:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression8777);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression8787); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3820:1: ruleParenthesizedExpression returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3823:28: ( ( () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3824:1: ( () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3824:1: ( () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3824:2: () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')'
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3824:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3825:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getParenthesizedExpressionAccess().getParenthesizedExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleParenthesizedExpression8833); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3834:1: ( (lv_expression_2_0= ruleExpression ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3835:1: (lv_expression_2_0= ruleExpression )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3835:1: (lv_expression_2_0= ruleExpression )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3836:3: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression8854);
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

            otherlv_3=(Token)match(input,29,FOLLOW_29_in_ruleParenthesizedExpression8866); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3864:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3865:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3866:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral8902);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral8912); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3873:1: ruleLiteral returns [EObject current=null] : (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_HexLiteral_2= ruleHexLiteral | this_RealLiteral_3= ruleRealLiteral | this_StringLiteral_4= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BoolLiteral_0 = null;

        EObject this_IntLiteral_1 = null;

        EObject this_HexLiteral_2 = null;

        EObject this_RealLiteral_3 = null;

        EObject this_StringLiteral_4 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3876:28: ( (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_HexLiteral_2= ruleHexLiteral | this_RealLiteral_3= ruleRealLiteral | this_StringLiteral_4= ruleStringLiteral ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3877:1: (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_HexLiteral_2= ruleHexLiteral | this_RealLiteral_3= ruleRealLiteral | this_StringLiteral_4= ruleStringLiteral )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3877:1: (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_HexLiteral_2= ruleHexLiteral | this_RealLiteral_3= ruleRealLiteral | this_StringLiteral_4= ruleStringLiteral )
            int alt59=5;
            switch ( input.LA(1) ) {
            case RULE_BOOL:
                {
                alt59=1;
                }
                break;
            case RULE_INT:
                {
                alt59=2;
                }
                break;
            case RULE_HEX:
                {
                alt59=3;
                }
                break;
            case RULE_FLOAT:
                {
                alt59=4;
                }
                break;
            case RULE_STRING:
                {
                alt59=5;
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3878:5: this_BoolLiteral_0= ruleBoolLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getBoolLiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBoolLiteral_in_ruleLiteral8959);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3888:5: this_IntLiteral_1= ruleIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getIntLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIntLiteral_in_ruleLiteral8986);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3898:5: this_HexLiteral_2= ruleHexLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getHexLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleHexLiteral_in_ruleLiteral9013);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3908:5: this_RealLiteral_3= ruleRealLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getRealLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleLiteral9040);
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3918:5: this_StringLiteral_4= ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleLiteral9067);
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3934:1: entryRuleBoolLiteral returns [EObject current=null] : iv_ruleBoolLiteral= ruleBoolLiteral EOF ;
    public final EObject entryRuleBoolLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolLiteral = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3935:2: (iv_ruleBoolLiteral= ruleBoolLiteral EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3936:2: iv_ruleBoolLiteral= ruleBoolLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBoolLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleBoolLiteral_in_entryRuleBoolLiteral9102);
            iv_ruleBoolLiteral=ruleBoolLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBoolLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoolLiteral9112); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3943:1: ruleBoolLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_BOOL ) ) ) ;
    public final EObject ruleBoolLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3946:28: ( ( () ( (lv_value_1_0= RULE_BOOL ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3947:1: ( () ( (lv_value_1_0= RULE_BOOL ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3947:1: ( () ( (lv_value_1_0= RULE_BOOL ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3947:2: () ( (lv_value_1_0= RULE_BOOL ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3947:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3948:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBoolLiteralAccess().getBoolLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3953:2: ( (lv_value_1_0= RULE_BOOL ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3954:1: (lv_value_1_0= RULE_BOOL )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3954:1: (lv_value_1_0= RULE_BOOL )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3955:3: lv_value_1_0= RULE_BOOL
            {
            lv_value_1_0=(Token)match(input,RULE_BOOL,FOLLOW_RULE_BOOL_in_ruleBoolLiteral9163); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3979:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3980:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3981:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral9204);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral9214); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3988:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3991:28: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3992:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3992:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3992:2: () ( (lv_value_1_0= RULE_INT ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3992:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3993:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3998:2: ( (lv_value_1_0= RULE_INT ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3999:1: (lv_value_1_0= RULE_INT )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3999:1: (lv_value_1_0= RULE_INT )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4000:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIntLiteral9265); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4024:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4025:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4026:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral9306);
            iv_ruleRealLiteral=ruleRealLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral9316); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4033:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_FLOAT ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4036:28: ( ( () ( (lv_value_1_0= RULE_FLOAT ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4037:1: ( () ( (lv_value_1_0= RULE_FLOAT ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4037:1: ( () ( (lv_value_1_0= RULE_FLOAT ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4037:2: () ( (lv_value_1_0= RULE_FLOAT ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4037:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4038:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4043:2: ( (lv_value_1_0= RULE_FLOAT ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4044:1: (lv_value_1_0= RULE_FLOAT )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4044:1: (lv_value_1_0= RULE_FLOAT )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4045:3: lv_value_1_0= RULE_FLOAT
            {
            lv_value_1_0=(Token)match(input,RULE_FLOAT,FOLLOW_RULE_FLOAT_in_ruleRealLiteral9367); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4069:1: entryRuleHexLiteral returns [EObject current=null] : iv_ruleHexLiteral= ruleHexLiteral EOF ;
    public final EObject entryRuleHexLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHexLiteral = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4070:2: (iv_ruleHexLiteral= ruleHexLiteral EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4071:2: iv_ruleHexLiteral= ruleHexLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHexLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleHexLiteral_in_entryRuleHexLiteral9408);
            iv_ruleHexLiteral=ruleHexLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHexLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexLiteral9418); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4078:1: ruleHexLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_HEX ) ) ) ;
    public final EObject ruleHexLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4081:28: ( ( () ( (lv_value_1_0= RULE_HEX ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4082:1: ( () ( (lv_value_1_0= RULE_HEX ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4082:1: ( () ( (lv_value_1_0= RULE_HEX ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4082:2: () ( (lv_value_1_0= RULE_HEX ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4082:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4083:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getHexLiteralAccess().getHexLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4088:2: ( (lv_value_1_0= RULE_HEX ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4089:1: (lv_value_1_0= RULE_HEX )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4089:1: (lv_value_1_0= RULE_HEX )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4090:3: lv_value_1_0= RULE_HEX
            {
            lv_value_1_0=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexLiteral9469); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4114:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4115:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4116:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral9510);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral9520); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4123:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4126:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4127:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4127:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4127:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4127:2: ()
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4128:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4133:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4134:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4134:1: (lv_value_1_0= RULE_STRING )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4135:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral9571); if (state.failed) return current;
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


    // $ANTLR start "ruleDirection"
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4159:1: ruleDirection returns [Enumerator current=null] : ( (enumLiteral_0= 'local' ) | (enumLiteral_1= 'in' ) | (enumLiteral_2= 'out' ) ) ;
    public final Enumerator ruleDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4161:28: ( ( (enumLiteral_0= 'local' ) | (enumLiteral_1= 'in' ) | (enumLiteral_2= 'out' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4162:1: ( (enumLiteral_0= 'local' ) | (enumLiteral_1= 'in' ) | (enumLiteral_2= 'out' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4162:1: ( (enumLiteral_0= 'local' ) | (enumLiteral_1= 'in' ) | (enumLiteral_2= 'out' ) )
            int alt60=3;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt60=1;
                }
                break;
            case 31:
                {
                alt60=2;
                }
                break;
            case 32:
                {
                alt60=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4162:2: (enumLiteral_0= 'local' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4162:2: (enumLiteral_0= 'local' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4162:4: enumLiteral_0= 'local'
                    {
                    enumLiteral_0=(Token)match(input,30,FOLLOW_30_in_ruleDirection9626); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getDirectionAccess().getLOCALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getDirectionAccess().getLOCALEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4168:6: (enumLiteral_1= 'in' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4168:6: (enumLiteral_1= 'in' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4168:8: enumLiteral_1= 'in'
                    {
                    enumLiteral_1=(Token)match(input,31,FOLLOW_31_in_ruleDirection9643); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getDirectionAccess().getINEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getDirectionAccess().getINEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4174:6: (enumLiteral_2= 'out' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4174:6: (enumLiteral_2= 'out' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4174:8: enumLiteral_2= 'out'
                    {
                    enumLiteral_2=(Token)match(input,32,FOLLOW_32_in_ruleDirection9660); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4184:1: ruleTimeEventType returns [Enumerator current=null] : ( (enumLiteral_0= 'after' ) | (enumLiteral_1= 'every' ) ) ;
    public final Enumerator ruleTimeEventType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4186:28: ( ( (enumLiteral_0= 'after' ) | (enumLiteral_1= 'every' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4187:1: ( (enumLiteral_0= 'after' ) | (enumLiteral_1= 'every' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4187:1: ( (enumLiteral_0= 'after' ) | (enumLiteral_1= 'every' ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==56) ) {
                alt61=1;
            }
            else if ( (LA61_0==57) ) {
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4187:2: (enumLiteral_0= 'after' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4187:2: (enumLiteral_0= 'after' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4187:4: enumLiteral_0= 'after'
                    {
                    enumLiteral_0=(Token)match(input,56,FOLLOW_56_in_ruleTimeEventType9705); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getTimeEventTypeAccess().getAfterEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getTimeEventTypeAccess().getAfterEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4193:6: (enumLiteral_1= 'every' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4193:6: (enumLiteral_1= 'every' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4193:8: enumLiteral_1= 'every'
                    {
                    enumLiteral_1=(Token)match(input,57,FOLLOW_57_in_ruleTimeEventType9722); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4203:1: ruleAssignmentOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '%=' ) | (enumLiteral_4= '+=' ) | (enumLiteral_5= '-=' ) | (enumLiteral_6= '<<=' ) | (enumLiteral_7= '>>=' ) | (enumLiteral_8= '&=' ) | (enumLiteral_9= '^=' ) | (enumLiteral_10= '|=' ) ) ;
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
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4205:28: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '%=' ) | (enumLiteral_4= '+=' ) | (enumLiteral_5= '-=' ) | (enumLiteral_6= '<<=' ) | (enumLiteral_7= '>>=' ) | (enumLiteral_8= '&=' ) | (enumLiteral_9= '^=' ) | (enumLiteral_10= '|=' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4206:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '%=' ) | (enumLiteral_4= '+=' ) | (enumLiteral_5= '-=' ) | (enumLiteral_6= '<<=' ) | (enumLiteral_7= '>>=' ) | (enumLiteral_8= '&=' ) | (enumLiteral_9= '^=' ) | (enumLiteral_10= '|=' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4206:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '%=' ) | (enumLiteral_4= '+=' ) | (enumLiteral_5= '-=' ) | (enumLiteral_6= '<<=' ) | (enumLiteral_7= '>>=' ) | (enumLiteral_8= '&=' ) | (enumLiteral_9= '^=' ) | (enumLiteral_10= '|=' ) )
            int alt62=11;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt62=1;
                }
                break;
            case 58:
                {
                alt62=2;
                }
                break;
            case 59:
                {
                alt62=3;
                }
                break;
            case 60:
                {
                alt62=4;
                }
                break;
            case 61:
                {
                alt62=5;
                }
                break;
            case 62:
                {
                alt62=6;
                }
                break;
            case 63:
                {
                alt62=7;
                }
                break;
            case 64:
                {
                alt62=8;
                }
                break;
            case 65:
                {
                alt62=9;
                }
                break;
            case 66:
                {
                alt62=10;
                }
                break;
            case 67:
                {
                alt62=11;
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4206:2: (enumLiteral_0= '=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4206:2: (enumLiteral_0= '=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4206:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,25,FOLLOW_25_in_ruleAssignmentOperator9767); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getAssignEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAssignmentOperatorAccess().getAssignEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4212:6: (enumLiteral_1= '*=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4212:6: (enumLiteral_1= '*=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4212:8: enumLiteral_1= '*='
                    {
                    enumLiteral_1=(Token)match(input,58,FOLLOW_58_in_ruleAssignmentOperator9784); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getMultAssignEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getAssignmentOperatorAccess().getMultAssignEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4218:6: (enumLiteral_2= '/=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4218:6: (enumLiteral_2= '/=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4218:8: enumLiteral_2= '/='
                    {
                    enumLiteral_2=(Token)match(input,59,FOLLOW_59_in_ruleAssignmentOperator9801); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getDivAssignEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getAssignmentOperatorAccess().getDivAssignEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4224:6: (enumLiteral_3= '%=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4224:6: (enumLiteral_3= '%=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4224:8: enumLiteral_3= '%='
                    {
                    enumLiteral_3=(Token)match(input,60,FOLLOW_60_in_ruleAssignmentOperator9818); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getModAssignEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getAssignmentOperatorAccess().getModAssignEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4230:6: (enumLiteral_4= '+=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4230:6: (enumLiteral_4= '+=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4230:8: enumLiteral_4= '+='
                    {
                    enumLiteral_4=(Token)match(input,61,FOLLOW_61_in_ruleAssignmentOperator9835); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getAddAssignEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getAssignmentOperatorAccess().getAddAssignEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4236:6: (enumLiteral_5= '-=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4236:6: (enumLiteral_5= '-=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4236:8: enumLiteral_5= '-='
                    {
                    enumLiteral_5=(Token)match(input,62,FOLLOW_62_in_ruleAssignmentOperator9852); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getSubAssignEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getAssignmentOperatorAccess().getSubAssignEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4242:6: (enumLiteral_6= '<<=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4242:6: (enumLiteral_6= '<<=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4242:8: enumLiteral_6= '<<='
                    {
                    enumLiteral_6=(Token)match(input,63,FOLLOW_63_in_ruleAssignmentOperator9869); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getLeftShiftAssignEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getAssignmentOperatorAccess().getLeftShiftAssignEnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4248:6: (enumLiteral_7= '>>=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4248:6: (enumLiteral_7= '>>=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4248:8: enumLiteral_7= '>>='
                    {
                    enumLiteral_7=(Token)match(input,64,FOLLOW_64_in_ruleAssignmentOperator9886); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getRightShiftAssignEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_7, grammarAccess.getAssignmentOperatorAccess().getRightShiftAssignEnumLiteralDeclaration_7()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4254:6: (enumLiteral_8= '&=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4254:6: (enumLiteral_8= '&=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4254:8: enumLiteral_8= '&='
                    {
                    enumLiteral_8=(Token)match(input,65,FOLLOW_65_in_ruleAssignmentOperator9903); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getAndAssignEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_8, grammarAccess.getAssignmentOperatorAccess().getAndAssignEnumLiteralDeclaration_8()); 
                          
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4260:6: (enumLiteral_9= '^=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4260:6: (enumLiteral_9= '^=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4260:8: enumLiteral_9= '^='
                    {
                    enumLiteral_9=(Token)match(input,66,FOLLOW_66_in_ruleAssignmentOperator9920); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getXorAssignEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_9, grammarAccess.getAssignmentOperatorAccess().getXorAssignEnumLiteralDeclaration_9()); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4266:6: (enumLiteral_10= '|=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4266:6: (enumLiteral_10= '|=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4266:8: enumLiteral_10= '|='
                    {
                    enumLiteral_10=(Token)match(input,67,FOLLOW_67_in_ruleAssignmentOperator9937); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4276:1: ruleShiftOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) ) ;
    public final Enumerator ruleShiftOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4278:28: ( ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4279:1: ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4279:1: ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==68) ) {
                alt63=1;
            }
            else if ( (LA63_0==69) ) {
                alt63=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4279:2: (enumLiteral_0= '<<' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4279:2: (enumLiteral_0= '<<' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4279:4: enumLiteral_0= '<<'
                    {
                    enumLiteral_0=(Token)match(input,68,FOLLOW_68_in_ruleShiftOperator9982); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getShiftOperatorAccess().getLeftEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getShiftOperatorAccess().getLeftEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4285:6: (enumLiteral_1= '>>' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4285:6: (enumLiteral_1= '>>' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4285:8: enumLiteral_1= '>>'
                    {
                    enumLiteral_1=(Token)match(input,69,FOLLOW_69_in_ruleShiftOperator9999); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4295:1: ruleAdditiveOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAdditiveOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4297:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4298:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4298:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==70) ) {
                alt64=1;
            }
            else if ( (LA64_0==71) ) {
                alt64=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4298:2: (enumLiteral_0= '+' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4298:2: (enumLiteral_0= '+' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4298:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,70,FOLLOW_70_in_ruleAdditiveOperator10044); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4304:6: (enumLiteral_1= '-' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4304:6: (enumLiteral_1= '-' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4304:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,71,FOLLOW_71_in_ruleAdditiveOperator10061); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4314:1: ruleMultiplicativeOperator returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplicativeOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4316:28: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4317:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4317:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt65=3;
            switch ( input.LA(1) ) {
            case 72:
                {
                alt65=1;
                }
                break;
            case 43:
                {
                alt65=2;
                }
                break;
            case 73:
                {
                alt65=3;
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
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4317:2: (enumLiteral_0= '*' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4317:2: (enumLiteral_0= '*' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4317:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,72,FOLLOW_72_in_ruleMultiplicativeOperator10106); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4323:6: (enumLiteral_1= '/' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4323:6: (enumLiteral_1= '/' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4323:8: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,43,FOLLOW_43_in_ruleMultiplicativeOperator10123); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4329:6: (enumLiteral_2= '%' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4329:6: (enumLiteral_2= '%' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4329:8: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,73,FOLLOW_73_in_ruleMultiplicativeOperator10140); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4339:1: ruleUnaryOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4341:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4342:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4342:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) )
            int alt66=3;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt66=1;
                }
                break;
            case 71:
                {
                alt66=2;
                }
                break;
            case 74:
                {
                alt66=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4342:2: (enumLiteral_0= '+' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4342:2: (enumLiteral_0= '+' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4342:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,70,FOLLOW_70_in_ruleUnaryOperator10185); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4348:6: (enumLiteral_1= '-' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4348:6: (enumLiteral_1= '-' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4348:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,71,FOLLOW_71_in_ruleUnaryOperator10202); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4354:6: (enumLiteral_2= '~' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4354:6: (enumLiteral_2= '~' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4354:8: enumLiteral_2= '~'
                    {
                    enumLiteral_2=(Token)match(input,74,FOLLOW_74_in_ruleUnaryOperator10219); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4364:1: ruleRelationalOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) ) ;
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
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4366:28: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4367:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4367:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) )
            int alt67=6;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt67=1;
                }
                break;
            case 76:
                {
                alt67=2;
                }
                break;
            case 48:
                {
                alt67=3;
                }
                break;
            case 77:
                {
                alt67=4;
                }
                break;
            case 78:
                {
                alt67=5;
                }
                break;
            case 79:
                {
                alt67=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }

            switch (alt67) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4367:2: (enumLiteral_0= '<' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4367:2: (enumLiteral_0= '<' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4367:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,75,FOLLOW_75_in_ruleRelationalOperator10264); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4373:6: (enumLiteral_1= '<=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4373:6: (enumLiteral_1= '<=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4373:8: enumLiteral_1= '<='
                    {
                    enumLiteral_1=(Token)match(input,76,FOLLOW_76_in_ruleRelationalOperator10281); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4379:6: (enumLiteral_2= '>' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4379:6: (enumLiteral_2= '>' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4379:8: enumLiteral_2= '>'
                    {
                    enumLiteral_2=(Token)match(input,48,FOLLOW_48_in_ruleRelationalOperator10298); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4385:6: (enumLiteral_3= '>=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4385:6: (enumLiteral_3= '>=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4385:8: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,77,FOLLOW_77_in_ruleRelationalOperator10315); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4391:6: (enumLiteral_4= '==' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4391:6: (enumLiteral_4= '==' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4391:8: enumLiteral_4= '=='
                    {
                    enumLiteral_4=(Token)match(input,78,FOLLOW_78_in_ruleRelationalOperator10332); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4397:6: (enumLiteral_5= '!=' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4397:6: (enumLiteral_5= '!=' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4397:8: enumLiteral_5= '!='
                    {
                    enumLiteral_5=(Token)match(input,79,FOLLOW_79_in_ruleRelationalOperator10349); if (state.failed) return current;
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
    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4407:1: ruleTimeUnit returns [Enumerator current=null] : ( (enumLiteral_0= 's' ) | (enumLiteral_1= 'ms' ) | (enumLiteral_2= 'us' ) | (enumLiteral_3= 'ns' ) ) ;
    public final Enumerator ruleTimeUnit() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4409:28: ( ( (enumLiteral_0= 's' ) | (enumLiteral_1= 'ms' ) | (enumLiteral_2= 'us' ) | (enumLiteral_3= 'ns' ) ) )
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4410:1: ( (enumLiteral_0= 's' ) | (enumLiteral_1= 'ms' ) | (enumLiteral_2= 'us' ) | (enumLiteral_3= 'ns' ) )
            {
            // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4410:1: ( (enumLiteral_0= 's' ) | (enumLiteral_1= 'ms' ) | (enumLiteral_2= 'us' ) | (enumLiteral_3= 'ns' ) )
            int alt68=4;
            switch ( input.LA(1) ) {
            case 80:
                {
                alt68=1;
                }
                break;
            case 81:
                {
                alt68=2;
                }
                break;
            case 82:
                {
                alt68=3;
                }
                break;
            case 83:
                {
                alt68=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4410:2: (enumLiteral_0= 's' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4410:2: (enumLiteral_0= 's' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4410:4: enumLiteral_0= 's'
                    {
                    enumLiteral_0=(Token)match(input,80,FOLLOW_80_in_ruleTimeUnit10394); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getTimeUnitAccess().getSecondEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getTimeUnitAccess().getSecondEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4416:6: (enumLiteral_1= 'ms' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4416:6: (enumLiteral_1= 'ms' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4416:8: enumLiteral_1= 'ms'
                    {
                    enumLiteral_1=(Token)match(input,81,FOLLOW_81_in_ruleTimeUnit10411); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getTimeUnitAccess().getMillisecondEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getTimeUnitAccess().getMillisecondEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4422:6: (enumLiteral_2= 'us' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4422:6: (enumLiteral_2= 'us' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4422:8: enumLiteral_2= 'us'
                    {
                    enumLiteral_2=(Token)match(input,82,FOLLOW_82_in_ruleTimeUnit10428); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getTimeUnitAccess().getMicrosecondEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getTimeUnitAccess().getMicrosecondEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4428:6: (enumLiteral_3= 'ns' )
                    {
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4428:6: (enumLiteral_3= 'ns' )
                    // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:4428:8: enumLiteral_3= 'ns'
                    {
                    enumLiteral_3=(Token)match(input,83,FOLLOW_83_in_ruleTimeUnit10445); if (state.failed) return current;
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

    // $ANTLR start synpred2_InternalSText
    public final void synpred2_InternalSText_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1712:6: ( '[' )
        // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1712:8: '['
        {
        match(input,45,FOLLOW_45_in_synpred2_InternalSText3920); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalSText

    // $ANTLR start synpred3_InternalSText
    public final void synpred3_InternalSText_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1910:4: ( ';' )
        // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:1910:6: ';'
        {
        match(input,47,FOLLOW_47_in_synpred3_InternalSText4370); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_InternalSText

    // $ANTLR start synpred4_InternalSText
    public final void synpred4_InternalSText_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3522:4: ( ( '(' ) )
        // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3523:1: ( '(' )
        {
        // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3523:1: ( '(' )
        // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3524:2: '('
        {
        match(input,27,FOLLOW_27_in_synpred4_InternalSText8137); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalSText

    // $ANTLR start synpred5_InternalSText
    public final void synpred5_InternalSText_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3627:4: ( ( '(' ) )
        // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3628:1: ( '(' )
        {
        // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3628:1: ( '(' )
        // ../org.yakindu.sct.model.stext/src-gen/org/yakindu/sct/model/stext/parser/antlr/internal/InternalSText.g:3629:2: '('
        {
        match(input,27,FOLLOW_27_in_synpred5_InternalSText8360); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalSText

    // Delegated rules

    public final boolean synpred4_InternalSText() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalSText_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalSText() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalSText_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalSText() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalSText_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalSText() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalSText_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
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
    public static final BitSet FOLLOW_15_in_ruleStateRoot463 = new BitSet(new long[]{0x0300207800000010L});
    public static final BitSet FOLLOW_ruleStateSpecification_in_ruleStateRoot484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionRoot_in_entryRuleTransitionRoot520 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionRoot530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleTransitionRoot567 = new BitSet(new long[]{0x0300387E00000010L});
    public static final BitSet FOLLOW_ruleTransitionSpecification_in_ruleTransitionRoot588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatechartSpecification_in_entryRuleStatechartSpecification626 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatechartSpecification636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleStatechartSpecification683 = new BitSet(new long[]{0x000003FFC5F60010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleStatechartSpecification704 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_ruleStatechartScope_in_ruleStatechartSpecification727 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_ruleStateSpecification_in_entryRuleStateSpecification764 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateSpecification774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateScope_in_ruleStateSpecification819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionSpecification_in_entryRuleTransitionSpecification854 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionSpecification864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionReaction_in_ruleTransitionSpecification909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateScope_in_entryRuleStateScope946 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateScope956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocalReaction_in_ruleStateScope1011 = new BitSet(new long[]{0x0300207800000012L});
    public static final BitSet FOLLOW_ruleStatechartScope_in_entryRuleStatechartScope1048 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatechartScope1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterfaceScope_in_ruleStatechartScope1105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInternalScope_in_ruleStatechartScope1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterfaceScope_in_entryRuleInterfaceScope1169 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterfaceScope1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleInterfaceScope1225 = new BitSet(new long[]{0x000003FFC5FE0010L});
    public static final BitSet FOLLOW_ruleXID_in_ruleInterfaceScope1246 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleInterfaceScope1259 = new BitSet(new long[]{0x00000001C4600002L});
    public static final BitSet FOLLOW_ruleEventDeclarartion_in_ruleInterfaceScope1282 = new BitSet(new long[]{0x00000001C4600002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleInterfaceScope1301 = new BitSet(new long[]{0x00000001C4600002L});
    public static final BitSet FOLLOW_ruleOperationDeclaration_in_ruleInterfaceScope1320 = new BitSet(new long[]{0x00000001C4600002L});
    public static final BitSet FOLLOW_ruleInternalScope_in_entryRuleInternalScope1360 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInternalScope1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleInternalScope1416 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleInternalScope1428 = new BitSet(new long[]{0x03002079C4600012L});
    public static final BitSet FOLLOW_ruleEventDeclarartion_in_ruleInternalScope1451 = new BitSet(new long[]{0x03002079C4600012L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleInternalScope1470 = new BitSet(new long[]{0x03002079C4600012L});
    public static final BitSet FOLLOW_ruleOperationDeclaration_in_ruleInternalScope1489 = new BitSet(new long[]{0x03002079C4600012L});
    public static final BitSet FOLLOW_ruleLocalReaction_in_ruleInternalScope1508 = new BitSet(new long[]{0x03002079C4600012L});
    public static final BitSet FOLLOW_ruleEventDeclarartion_in_entryRuleEventDeclarartion1550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventDeclarartion1560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDefinition_in_ruleEventDeclarartion1606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDefinition_in_entryRuleEventDefinition1642 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventDefinition1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirection_in_ruleEventDefinition1698 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleEventDefinition1711 = new BitSet(new long[]{0x000003FFC5F60010L});
    public static final BitSet FOLLOW_ruleXID_in_ruleEventDefinition1732 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleEventDefinition1745 = new BitSet(new long[]{0x000003FFC5F60010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleEventDefinition1768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration1806 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration1816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_ruleVariableDeclaration1862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition1898 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDefinition1908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleVariableDefinition1954 = new BitSet(new long[]{0x000003FFC5F60010L});
    public static final BitSet FOLLOW_23_in_ruleVariableDefinition2017 = new BitSet(new long[]{0x000003FFC5F60010L});
    public static final BitSet FOLLOW_24_in_ruleVariableDefinition2102 = new BitSet(new long[]{0x000003FFC5F60010L});
    public static final BitSet FOLLOW_ruleXID_in_ruleVariableDefinition2176 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleVariableDefinition2188 = new BitSet(new long[]{0x000003FFC5F60010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleVariableDefinition2211 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleVariableDefinition2224 = new BitSet(new long[]{0x00100300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDefinition2245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationDeclaration_in_entryRuleOperationDeclaration2283 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationDeclaration2293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationDefinition_in_ruleOperationDeclaration2339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationDefinition_in_entryRuleOperationDefinition2375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationDefinition2385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOperationDefinition2431 = new BitSet(new long[]{0x000003FFC5F60010L});
    public static final BitSet FOLLOW_ruleXID_in_ruleOperationDefinition2452 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleOperationDefinition2464 = new BitSet(new long[]{0x000003FFE5F60010L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleOperationDefinition2486 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_28_in_ruleOperationDefinition2499 = new BitSet(new long[]{0x000003FFC5F60010L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleOperationDefinition2520 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_ruleOperationDefinition2536 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleOperationDefinition2549 = new BitSet(new long[]{0x000003FFC5F60010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleOperationDefinition2572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter2610 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter2620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXID_in_ruleParameter2666 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleParameter2678 = new BitSet(new long[]{0x000003FFC5F60010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleParameter2701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXID_in_entryRuleXID2738 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXID2749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXID2789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleXID2813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleXID2832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleXID2851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleXID2870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleXID2889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleXID2908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleXID2927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleXID2946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleXID2965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleXID2984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleXID3003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleXID3022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleXID3041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleXID3060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleXID3079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleXID3098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleXID3117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleXID3136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleXID3155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleXID3174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN3215 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN3226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXID_in_ruleFQN3273 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleFQN3292 = new BitSet(new long[]{0x000003FFC5F60010L});
    public static final BitSet FOLLOW_ruleXID_in_ruleFQN3314 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ruleLocalReaction_in_entryRuleLocalReaction3363 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocalReaction3373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionTrigger_in_ruleLocalReaction3419 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleLocalReaction3451 = new BitSet(new long[]{0x00100380080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleReactionEffect_in_ruleLocalReaction3472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionReaction_in_entryRuleTransitionReaction3510 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionReaction3520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStextTrigger_in_ruleTransitionReaction3575 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_43_in_ruleTransitionReaction3589 = new BitSet(new long[]{0x00100380080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleReactionEffect_in_ruleTransitionReaction3610 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_ruleTransitionReaction3625 = new BitSet(new long[]{0x0001000000000012L});
    public static final BitSet FOLLOW_ruleTransitionProperty_in_ruleTransitionReaction3646 = new BitSet(new long[]{0x0001000000000012L});
    public static final BitSet FOLLOW_ruleStextTrigger_in_entryRuleStextTrigger3685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStextTrigger3695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionTrigger_in_ruleStextTrigger3742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultTrigger_in_ruleStextTrigger3769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionTrigger_in_entryRuleReactionTrigger3804 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReactionTrigger3814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventSpec_in_ruleReactionTrigger3871 = new BitSet(new long[]{0x0000200010000002L});
    public static final BitSet FOLLOW_28_in_ruleReactionTrigger3884 = new BitSet(new long[]{0x0300007800000010L});
    public static final BitSet FOLLOW_ruleEventSpec_in_ruleReactionTrigger3905 = new BitSet(new long[]{0x0000200010000002L});
    public static final BitSet FOLLOW_45_in_ruleReactionTrigger3928 = new BitSet(new long[]{0x00100300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleGuard_in_ruleReactionTrigger3950 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleReactionTrigger3962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleReactionTrigger3984 = new BitSet(new long[]{0x00100300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleReactionTrigger4005 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleReactionTrigger4017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultTrigger_in_entryRuleDefaultTrigger4055 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultTrigger4065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleDefaultTrigger4112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleDefaultTrigger4130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuard_in_entryRuleGuard4167 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuard4177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleGuard4232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionEffect_in_entryRuleReactionEffect4268 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReactionEffect4278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleReactionEffect4335 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_ruleEventRaisingExpression_in_ruleReactionEffect4354 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_ruleReactionEffect4378 = new BitSet(new long[]{0x00100380080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleReactionEffect4402 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_ruleEventRaisingExpression_in_ruleReactionEffect4421 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_ruleTransitionProperty_in_entryRuleTransitionProperty4462 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionProperty4472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPointSpec_in_ruleTransitionProperty4519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPointSpec_in_ruleTransitionProperty4546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPointSpec_in_entryRuleEntryPointSpec4581 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryPointSpec4591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleEntryPointSpec4628 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntryPointSpec4645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPointSpec_in_entryRuleExitPointSpec4686 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitPointSpec4696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExitPointSpec4738 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleExitPointSpec4755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventSpec_in_entryRuleEventSpec4791 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventSpec4801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRegularEventSpec_in_ruleEventSpec4848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeEventSpec_in_ruleEventSpec4875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuiltinEventSpec_in_ruleEventSpec4902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRegularEventSpec_in_entryRuleRegularEventSpec4937 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRegularEventSpec4947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_ruleRegularEventSpec4992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeEventSpec_in_entryRuleTimeEventSpec5027 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeEventSpec5037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeEventType_in_ruleTimeEventSpec5083 = new BitSet(new long[]{0x00100300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleTimeEventSpec5104 = new BitSet(new long[]{0x0000000000000000L,0x00000000000F0000L});
    public static final BitSet FOLLOW_ruleTimeUnit_in_ruleTimeEventSpec5125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuiltinEventSpec_in_entryRuleBuiltinEventSpec5161 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBuiltinEventSpec5171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryEvent_in_ruleBuiltinEventSpec5218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitEvent_in_ruleBuiltinEventSpec5245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlwaysEvent_in_ruleBuiltinEventSpec5272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryEvent_in_entryRuleEntryEvent5307 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryEvent5317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleEntryEvent5363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitEvent_in_entryRuleExitEvent5399 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitEvent5409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleExitEvent5455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlwaysEvent_in_entryRuleAlwaysEvent5491 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlwaysEvent5501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleAlwaysEvent5548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleAlwaysEvent5566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventRaisingExpression_in_entryRuleEventRaisingExpression5603 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventRaisingExpression5613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleEventRaisingExpression5659 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_ruleEventRaisingExpression5680 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleEventRaisingExpression5693 = new BitSet(new long[]{0x00100300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleEventRaisingExpression5714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression5754 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression5764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentExpression_in_ruleExpression5810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentExpression_in_entryRuleAssignmentExpression5844 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentExpression5854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleAssignmentExpression5901 = new BitSet(new long[]{0xFC00000002000002L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleAssignmentOperator_in_ruleAssignmentExpression5931 = new BitSet(new long[]{0x00100300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleAssignmentExpression5952 = new BitSet(new long[]{0xFC00000002000002L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression5990 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression6000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleConditionalExpression6047 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_ruleConditionalExpression6068 = new BitSet(new long[]{0x00100300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleConditionalExpression6089 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleConditionalExpression6101 = new BitSet(new long[]{0x00100300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleConditionalExpression6122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression6160 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOrExpression6170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression6217 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_ruleLogicalOrExpression6238 = new BitSet(new long[]{0x00100300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression6259 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression6297 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalAndExpression6307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression6354 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_ruleLogicalAndExpression6375 = new BitSet(new long[]{0x00100300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression6396 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression6434 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalNotExpression6444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseXorExpression_in_ruleLogicalNotExpression6491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleLogicalNotExpression6518 = new BitSet(new long[]{0x00000300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleBitwiseXorExpression_in_ruleLogicalNotExpression6539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseXorExpression_in_entryRuleBitwiseXorExpression6576 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseXorExpression6586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpression_in_ruleBitwiseXorExpression6633 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_ruleBitwiseXorExpression6654 = new BitSet(new long[]{0x00000300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpression_in_ruleBitwiseXorExpression6675 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpression_in_entryRuleBitwiseOrExpression6713 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseOrExpression6723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpression_in_ruleBitwiseOrExpression6770 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_54_in_ruleBitwiseOrExpression6791 = new BitSet(new long[]{0x00000300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpression_in_ruleBitwiseOrExpression6812 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpression_in_entryRuleBitwiseAndExpression6850 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseAndExpression6860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_ruleBitwiseAndExpression6907 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_ruleBitwiseAndExpression6928 = new BitSet(new long[]{0x00000300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_ruleBitwiseAndExpression6949 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_entryRuleLogicalRelationExpression6987 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalRelationExpression6997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_ruleLogicalRelationExpression7044 = new BitSet(new long[]{0x0001000000000002L,0x000000000000F800L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleLogicalRelationExpression7074 = new BitSet(new long[]{0x00000300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_ruleLogicalRelationExpression7095 = new BitSet(new long[]{0x0001000000000002L,0x000000000000F800L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_entryRuleShiftExpression7133 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShiftExpression7143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_ruleShiftExpression7190 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_ruleShiftOperator_in_ruleShiftExpression7220 = new BitSet(new long[]{0x00000300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_ruleShiftExpression7241 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_entryRuleNumericalAddSubtractExpression7279 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalAddSubtractExpression7289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression7336 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleNumericalAddSubtractExpression7366 = new BitSet(new long[]{0x00000300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression7387 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_entryRuleNumericalMultiplyDivideExpression7425 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalMultiplyDivideExpression7435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression7482 = new BitSet(new long[]{0x0000080000000002L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleNumericalMultiplyDivideExpression7512 = new BitSet(new long[]{0x00000300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression7533 = new BitSet(new long[]{0x0000080000000002L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_entryRuleNumericalUnaryExpression7571 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalUnaryExpression7581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression7628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleNumericalUnaryExpression7664 = new BitSet(new long[]{0x00000300080003F0L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression7685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression7722 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression7732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveValueExpression_in_rulePrimaryExpression7779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_rulePrimaryExpression7806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActiveStateReferenceExpression_in_rulePrimaryExpression7833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventValueReferenceExpression_in_rulePrimaryExpression7860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression7887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveValueExpression_in_entryRulePrimitiveValueExpression7922 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveValueExpression7932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimitiveValueExpression7987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall8023 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCall8033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementReferenceExpression_in_ruleFeatureCall8080 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleFeatureCall8101 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureCall8121 = new BitSet(new long[]{0x0000040008000002L});
    public static final BitSet FOLLOW_27_in_ruleFeatureCall8155 = new BitSet(new long[]{0x00100300280003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFeatureCall8190 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_28_in_ruleFeatureCall8203 = new BitSet(new long[]{0x00100300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFeatureCall8224 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_ruleFeatureCall8240 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ruleElementReferenceExpression_in_entryRuleElementReferenceExpression8280 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElementReferenceExpression8290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleElementReferenceExpression8344 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleElementReferenceExpression8378 = new BitSet(new long[]{0x00100300280003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleElementReferenceExpression8413 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_28_in_ruleElementReferenceExpression8426 = new BitSet(new long[]{0x00100300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleElementReferenceExpression8447 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_ruleElementReferenceExpression8463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventValueReferenceExpression_in_entryRuleEventValueReferenceExpression8501 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventValueReferenceExpression8511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleEventValueReferenceExpression8557 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleEventValueReferenceExpression8569 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_ruleEventValueReferenceExpression8590 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleEventValueReferenceExpression8602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActiveStateReferenceExpression_in_entryRuleActiveStateReferenceExpression8638 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActiveStateReferenceExpression8648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleActiveStateReferenceExpression8694 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleActiveStateReferenceExpression8706 = new BitSet(new long[]{0x000003FFC5F60010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleActiveStateReferenceExpression8729 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleActiveStateReferenceExpression8741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression8777 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression8787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleParenthesizedExpression8833 = new BitSet(new long[]{0x00100300080003F0L,0x00000000000004C0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression8854 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleParenthesizedExpression8866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral8902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral8912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolLiteral_in_ruleLiteral8959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_ruleLiteral8986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexLiteral_in_ruleLiteral9013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleLiteral9040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleLiteral9067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolLiteral_in_entryRuleBoolLiteral9102 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoolLiteral9112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOL_in_ruleBoolLiteral9163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral9204 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral9214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIntLiteral9265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral9306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral9316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_FLOAT_in_ruleRealLiteral9367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexLiteral_in_entryRuleHexLiteral9408 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexLiteral9418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleHexLiteral9469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral9510 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral9520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral9571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleDirection9626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleDirection9643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleDirection9660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleTimeEventType9705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleTimeEventType9722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleAssignmentOperator9767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleAssignmentOperator9784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleAssignmentOperator9801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleAssignmentOperator9818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleAssignmentOperator9835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleAssignmentOperator9852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleAssignmentOperator9869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleAssignmentOperator9886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleAssignmentOperator9903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleAssignmentOperator9920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleAssignmentOperator9937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleShiftOperator9982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleShiftOperator9999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleAdditiveOperator10044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleAdditiveOperator10061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleMultiplicativeOperator10106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleMultiplicativeOperator10123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleMultiplicativeOperator10140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleUnaryOperator10185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleUnaryOperator10202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleUnaryOperator10219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleRelationalOperator10264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleRelationalOperator10281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleRelationalOperator10298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleRelationalOperator10315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleRelationalOperator10332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleRelationalOperator10349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleTimeUnit10394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleTimeUnit10411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleTimeUnit10428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleTimeUnit10445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred2_InternalSText3920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_synpred3_InternalSText4370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_synpred4_InternalSText8137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_synpred5_InternalSText8360 = new BitSet(new long[]{0x0000000000000002L});

}
