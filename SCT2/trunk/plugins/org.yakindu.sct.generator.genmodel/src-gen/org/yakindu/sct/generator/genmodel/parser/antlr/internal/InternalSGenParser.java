package org.yakindu.sct.generator.genmodel.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.yakindu.sct.generator.genmodel.services.SGenGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalSGenParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'GeneratorModel'", "'for'", "'{'", "'}'", "'statechart'", "'feature'", "'='", "'::'", "'.'", "'+='", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'>'", "'<'", "'->'", "'..'", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'as'", "'?.'", "'*.'", "','", "'('", "')'", "'['", "'|'", "']'", "'case'", "':'", "'var'", "'val'", "'super'", "'false'", "'true'", "'null'", "'typeof'", "'catch'", "'=>'", "'?'", "'extends'", "'&'"
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
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__16=16;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
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
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=6;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalSGenParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSGenParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSGenParser.tokenNames; }
    public String getGrammarFileName() { return "../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g"; }



     	private SGenGrammarAccess grammarAccess;
     	
        public InternalSGenParser(TokenStream input, SGenGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "GeneratorModel";	
       	}
       	
       	@Override
       	protected SGenGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleGeneratorModel"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:67:1: entryRuleGeneratorModel returns [EObject current=null] : iv_ruleGeneratorModel= ruleGeneratorModel EOF ;
    public final EObject entryRuleGeneratorModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratorModel = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:68:2: (iv_ruleGeneratorModel= ruleGeneratorModel EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:69:2: iv_ruleGeneratorModel= ruleGeneratorModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGeneratorModelRule()); 
            }
            pushFollow(FOLLOW_ruleGeneratorModel_in_entryRuleGeneratorModel75);
            iv_ruleGeneratorModel=ruleGeneratorModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGeneratorModel; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneratorModel85); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGeneratorModel"


    // $ANTLR start "ruleGeneratorModel"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:76:1: ruleGeneratorModel returns [EObject current=null] : (otherlv_0= 'GeneratorModel' otherlv_1= 'for' ( (lv_generatorId_2_0= ruleQID ) ) otherlv_3= '{' ( (lv_entries_4_0= ruleGeneratorEntry ) )+ otherlv_5= '}' ) ;
    public final EObject ruleGeneratorModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_generatorId_2_0 = null;

        EObject lv_entries_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:79:28: ( (otherlv_0= 'GeneratorModel' otherlv_1= 'for' ( (lv_generatorId_2_0= ruleQID ) ) otherlv_3= '{' ( (lv_entries_4_0= ruleGeneratorEntry ) )+ otherlv_5= '}' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:80:1: (otherlv_0= 'GeneratorModel' otherlv_1= 'for' ( (lv_generatorId_2_0= ruleQID ) ) otherlv_3= '{' ( (lv_entries_4_0= ruleGeneratorEntry ) )+ otherlv_5= '}' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:80:1: (otherlv_0= 'GeneratorModel' otherlv_1= 'for' ( (lv_generatorId_2_0= ruleQID ) ) otherlv_3= '{' ( (lv_entries_4_0= ruleGeneratorEntry ) )+ otherlv_5= '}' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:80:3: otherlv_0= 'GeneratorModel' otherlv_1= 'for' ( (lv_generatorId_2_0= ruleQID ) ) otherlv_3= '{' ( (lv_entries_4_0= ruleGeneratorEntry ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleGeneratorModel122); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getGeneratorModelAccess().getGeneratorModelKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleGeneratorModel134); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getGeneratorModelAccess().getForKeyword_1());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:88:1: ( (lv_generatorId_2_0= ruleQID ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:89:1: (lv_generatorId_2_0= ruleQID )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:89:1: (lv_generatorId_2_0= ruleQID )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:90:3: lv_generatorId_2_0= ruleQID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGeneratorModelAccess().getGeneratorIdQIDParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQID_in_ruleGeneratorModel155);
            lv_generatorId_2_0=ruleQID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getGeneratorModelRule());
              	        }
                     		set(
                     			current, 
                     			"generatorId",
                      		lv_generatorId_2_0, 
                      		"QID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleGeneratorModel167); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getGeneratorModelAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:110:1: ( (lv_entries_4_0= ruleGeneratorEntry ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:111:1: (lv_entries_4_0= ruleGeneratorEntry )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:111:1: (lv_entries_4_0= ruleGeneratorEntry )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:112:3: lv_entries_4_0= ruleGeneratorEntry
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGeneratorModelAccess().getEntriesGeneratorEntryParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleGeneratorEntry_in_ruleGeneratorModel188);
            	    lv_entries_4_0=ruleGeneratorEntry();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGeneratorModelRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"entries",
            	              		lv_entries_4_0, 
            	              		"GeneratorEntry");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleGeneratorModel201); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getGeneratorModelAccess().getRightCurlyBracketKeyword_5());
                  
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
    // $ANTLR end "ruleGeneratorModel"


    // $ANTLR start "entryRuleGeneratorEntry"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:140:1: entryRuleGeneratorEntry returns [EObject current=null] : iv_ruleGeneratorEntry= ruleGeneratorEntry EOF ;
    public final EObject entryRuleGeneratorEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratorEntry = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:141:2: (iv_ruleGeneratorEntry= ruleGeneratorEntry EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:142:2: iv_ruleGeneratorEntry= ruleGeneratorEntry EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGeneratorEntryRule()); 
            }
            pushFollow(FOLLOW_ruleGeneratorEntry_in_entryRuleGeneratorEntry237);
            iv_ruleGeneratorEntry=ruleGeneratorEntry();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGeneratorEntry; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneratorEntry247); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGeneratorEntry"


    // $ANTLR start "ruleGeneratorEntry"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:149:1: ruleGeneratorEntry returns [EObject current=null] : (otherlv_0= 'statechart' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_features_3_0= ruleFeatureConfiguration ) )* otherlv_4= '}' ) ;
    public final EObject ruleGeneratorEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_features_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:152:28: ( (otherlv_0= 'statechart' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_features_3_0= ruleFeatureConfiguration ) )* otherlv_4= '}' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:153:1: (otherlv_0= 'statechart' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_features_3_0= ruleFeatureConfiguration ) )* otherlv_4= '}' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:153:1: (otherlv_0= 'statechart' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_features_3_0= ruleFeatureConfiguration ) )* otherlv_4= '}' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:153:3: otherlv_0= 'statechart' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_features_3_0= ruleFeatureConfiguration ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleGeneratorEntry284); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getGeneratorEntryAccess().getStatechartKeyword_0());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:157:1: ( (otherlv_1= RULE_ID ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:158:1: (otherlv_1= RULE_ID )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:158:1: (otherlv_1= RULE_ID )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:159:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getGeneratorEntryRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratorEntry304); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getGeneratorEntryAccess().getStatechartStatechartCrossReference_1_0()); 
              	
            }

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleGeneratorEntry316); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getGeneratorEntryAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:174:1: ( (lv_features_3_0= ruleFeatureConfiguration ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:175:1: (lv_features_3_0= ruleFeatureConfiguration )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:175:1: (lv_features_3_0= ruleFeatureConfiguration )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:176:3: lv_features_3_0= ruleFeatureConfiguration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGeneratorEntryAccess().getFeaturesFeatureConfigurationParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleFeatureConfiguration_in_ruleGeneratorEntry337);
            	    lv_features_3_0=ruleFeatureConfiguration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGeneratorEntryRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"features",
            	              		lv_features_3_0, 
            	              		"FeatureConfiguration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleGeneratorEntry350); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getGeneratorEntryAccess().getRightCurlyBracketKeyword_4());
                  
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
    // $ANTLR end "ruleGeneratorEntry"


    // $ANTLR start "entryRuleFeatureConfiguration"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:204:1: entryRuleFeatureConfiguration returns [EObject current=null] : iv_ruleFeatureConfiguration= ruleFeatureConfiguration EOF ;
    public final EObject entryRuleFeatureConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureConfiguration = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:205:2: (iv_ruleFeatureConfiguration= ruleFeatureConfiguration EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:206:2: iv_ruleFeatureConfiguration= ruleFeatureConfiguration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureConfigurationRule()); 
            }
            pushFollow(FOLLOW_ruleFeatureConfiguration_in_entryRuleFeatureConfiguration386);
            iv_ruleFeatureConfiguration=ruleFeatureConfiguration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureConfiguration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureConfiguration396); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureConfiguration"


    // $ANTLR start "ruleFeatureConfiguration"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:213:1: ruleFeatureConfiguration returns [EObject current=null] : ( () otherlv_1= 'feature' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_parameterValues_4_0= ruleFeatureParameterValue ) )+ otherlv_5= '}' ) ;
    public final EObject ruleFeatureConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_parameterValues_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:216:28: ( ( () otherlv_1= 'feature' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_parameterValues_4_0= ruleFeatureParameterValue ) )+ otherlv_5= '}' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:217:1: ( () otherlv_1= 'feature' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_parameterValues_4_0= ruleFeatureParameterValue ) )+ otherlv_5= '}' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:217:1: ( () otherlv_1= 'feature' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_parameterValues_4_0= ruleFeatureParameterValue ) )+ otherlv_5= '}' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:217:2: () otherlv_1= 'feature' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_parameterValues_4_0= ruleFeatureParameterValue ) )+ otherlv_5= '}'
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:217:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:218:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getFeatureConfigurationAccess().getFeatureConfigurationAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleFeatureConfiguration442); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFeatureConfigurationAccess().getFeatureKeyword_1());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:227:1: ( (otherlv_2= RULE_ID ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:228:1: (otherlv_2= RULE_ID )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:228:1: (otherlv_2= RULE_ID )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:229:3: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFeatureConfigurationRule());
              	        }
                      
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureConfiguration462); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_2, grammarAccess.getFeatureConfigurationAccess().getTypeFeatureTypeCrossReference_2_0()); 
              	
            }

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleFeatureConfiguration474); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFeatureConfigurationAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:244:1: ( (lv_parameterValues_4_0= ruleFeatureParameterValue ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:245:1: (lv_parameterValues_4_0= ruleFeatureParameterValue )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:245:1: (lv_parameterValues_4_0= ruleFeatureParameterValue )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:246:3: lv_parameterValues_4_0= ruleFeatureParameterValue
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFeatureConfigurationAccess().getParameterValuesFeatureParameterValueParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleFeatureParameterValue_in_ruleFeatureConfiguration495);
            	    lv_parameterValues_4_0=ruleFeatureParameterValue();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getFeatureConfigurationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"parameterValues",
            	              		lv_parameterValues_4_0, 
            	              		"FeatureParameterValue");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleFeatureConfiguration508); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getFeatureConfigurationAccess().getRightCurlyBracketKeyword_5());
                  
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
    // $ANTLR end "ruleFeatureConfiguration"


    // $ANTLR start "entryRuleFeatureParameterValue"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:274:1: entryRuleFeatureParameterValue returns [EObject current=null] : iv_ruleFeatureParameterValue= ruleFeatureParameterValue EOF ;
    public final EObject entryRuleFeatureParameterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureParameterValue = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:275:2: (iv_ruleFeatureParameterValue= ruleFeatureParameterValue EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:276:2: iv_ruleFeatureParameterValue= ruleFeatureParameterValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureParameterValueRule()); 
            }
            pushFollow(FOLLOW_ruleFeatureParameterValue_in_entryRuleFeatureParameterValue544);
            iv_ruleFeatureParameterValue=ruleFeatureParameterValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureParameterValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureParameterValue554); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureParameterValue"


    // $ANTLR start "ruleFeatureParameterValue"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:283:1: ruleFeatureParameterValue returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleXExpression ) ) ) ;
    public final EObject ruleFeatureParameterValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:286:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleXExpression ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:287:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleXExpression ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:287:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleXExpression ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:287:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleXExpression ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:287:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:288:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getFeatureParameterValueAccess().getFeatureParameterValueAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:293:2: ( (otherlv_1= RULE_ID ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:294:1: (otherlv_1= RULE_ID )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:294:1: (otherlv_1= RULE_ID )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:295:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFeatureParameterValueRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureParameterValue608); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getFeatureParameterValueAccess().getParameterFeatureParameterCrossReference_1_0()); 
              	
            }

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleFeatureParameterValue620); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFeatureParameterValueAccess().getEqualsSignKeyword_2());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:310:1: ( (lv_expression_3_0= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:311:1: (lv_expression_3_0= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:311:1: (lv_expression_3_0= ruleXExpression )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:312:3: lv_expression_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFeatureParameterValueAccess().getExpressionXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleFeatureParameterValue641);
            lv_expression_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFeatureParameterValueRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_3_0, 
                      		"XExpression");
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
    // $ANTLR end "ruleFeatureParameterValue"


    // $ANTLR start "entryRuleXPrimaryExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:336:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:337:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:338:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression677);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression687); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXPrimaryExpression"


    // $ANTLR start "ruleXPrimaryExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:345:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XFeatureCall_0= ruleXFeatureCall | this_XLiteral_1= ruleXLiteral | this_XParenthesizedExpression_2= ruleXParenthesizedExpression ) ;
    public final EObject ruleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XFeatureCall_0 = null;

        EObject this_XLiteral_1 = null;

        EObject this_XParenthesizedExpression_2 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:348:28: ( (this_XFeatureCall_0= ruleXFeatureCall | this_XLiteral_1= ruleXLiteral | this_XParenthesizedExpression_2= ruleXParenthesizedExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:349:1: (this_XFeatureCall_0= ruleXFeatureCall | this_XLiteral_1= ruleXLiteral | this_XParenthesizedExpression_2= ruleXParenthesizedExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:349:1: (this_XFeatureCall_0= ruleXFeatureCall | this_XLiteral_1= ruleXLiteral | this_XParenthesizedExpression_2= ruleXParenthesizedExpression )
            int alt4=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case 29:
            case 52:
                {
                alt4=1;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case 45:
            case 53:
            case 54:
            case 55:
            case 56:
                {
                alt4=2;
                }
                break;
            case 43:
                {
                alt4=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:350:5: this_XFeatureCall_0= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression734);
                    this_XFeatureCall_0=ruleXFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFeatureCall_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:360:5: this_XLiteral_1= ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression761);
                    this_XLiteral_1=ruleXLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XLiteral_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:370:5: this_XParenthesizedExpression_2= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression788);
                    this_XParenthesizedExpression_2=ruleXParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XParenthesizedExpression_2; 
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
    // $ANTLR end "ruleXPrimaryExpression"


    // $ANTLR start "entryRuleQID"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:386:1: entryRuleQID returns [String current=null] : iv_ruleQID= ruleQID EOF ;
    public final String entryRuleQID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQID = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:387:2: (iv_ruleQID= ruleQID EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:388:2: iv_ruleQID= ruleQID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQIDRule()); 
            }
            pushFollow(FOLLOW_ruleQID_in_entryRuleQID824);
            iv_ruleQID=ruleQID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQID835); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQID"


    // $ANTLR start "ruleQID"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:395:1: ruleQID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( (kw= '::' | kw= '.' ) this_ID_3= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_3=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:398:28: ( (this_ID_0= RULE_ID ( (kw= '::' | kw= '.' ) this_ID_3= RULE_ID )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:399:1: (this_ID_0= RULE_ID ( (kw= '::' | kw= '.' ) this_ID_3= RULE_ID )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:399:1: (this_ID_0= RULE_ID ( (kw= '::' | kw= '.' ) this_ID_3= RULE_ID )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:399:6: this_ID_0= RULE_ID ( (kw= '::' | kw= '.' ) this_ID_3= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID875); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQIDAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:406:1: ( (kw= '::' | kw= '.' ) this_ID_3= RULE_ID )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=18 && LA6_0<=19)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:406:2: (kw= '::' | kw= '.' ) this_ID_3= RULE_ID
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:406:2: (kw= '::' | kw= '.' )
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==18) ) {
            	        alt5=1;
            	    }
            	    else if ( (LA5_0==19) ) {
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
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:407:2: kw= '::'
            	            {
            	            kw=(Token)match(input,18,FOLLOW_18_in_ruleQID895); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getQIDAccess().getColonColonKeyword_1_0_0()); 
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:414:2: kw= '.'
            	            {
            	            kw=(Token)match(input,19,FOLLOW_19_in_ruleQID914); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getQIDAccess().getFullStopKeyword_1_0_1()); 
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID930); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_3);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_3, grammarAccess.getQIDAccess().getIDTerminalRuleCall_1_1()); 
            	          
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
    // $ANTLR end "ruleQID"


    // $ANTLR start "entryRuleXExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:434:1: entryRuleXExpression returns [EObject current=null] : iv_ruleXExpression= ruleXExpression EOF ;
    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:435:2: (iv_ruleXExpression= ruleXExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:436:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXExpression_in_entryRuleXExpression977);
            iv_ruleXExpression=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpression987); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXExpression"


    // $ANTLR start "ruleXExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:443:1: ruleXExpression returns [EObject current=null] : this_XAssignment_0= ruleXAssignment ;
    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAssignment_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:446:28: (this_XAssignment_0= ruleXAssignment )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:448:5: this_XAssignment_0= ruleXAssignment
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleXAssignment_in_ruleXExpression1033);
            this_XAssignment_0=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAssignment_0; 
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
    // $ANTLR end "ruleXExpression"


    // $ANTLR start "entryRuleXAssignment"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:464:1: entryRuleXAssignment returns [EObject current=null] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAssignment = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:465:2: (iv_ruleXAssignment= ruleXAssignment EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:466:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleXAssignment_in_entryRuleXAssignment1067);
            iv_ruleXAssignment=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAssignment1077); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXAssignment"


    // $ANTLR start "ruleXAssignment"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:473:1: ruleXAssignment returns [EObject current=null] : ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) ;
    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject lv_value_3_0 = null;

        EObject this_XOrExpression_4 = null;

        EObject lv_rightOperand_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:476:28: ( ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:477:1: ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:477:1: ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==17) ) {
                    alt8=1;
                }
                else if ( (LA8_1==EOF||LA8_1==RULE_ID||LA8_1==14||(LA8_1>=18 && LA8_1<=37)||(LA8_1>=39 && LA8_1<=44)||LA8_1==47||LA8_1==49) ) {
                    alt8=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA8_0>=RULE_INT && LA8_0<=RULE_STRING)||LA8_0==29||(LA8_0>=32 && LA8_0<=33)||LA8_0==38||LA8_0==43||LA8_0==45||(LA8_0>=52 && LA8_0<=56)) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:477:2: ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:477:2: ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:477:3: () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:477:3: ()
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:478:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXAssignmentAccess().getXAssignmentAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:483:2: ( ( ruleValidID ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:484:1: ( ruleValidID )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:484:1: ( ruleValidID )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:485:3: ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXAssignmentRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXAssignment1135);
                    ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAssignmentAccess().getOpSingleAssignParserRuleCall_0_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXAssignment1151);
                    ruleOpSingleAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:506:1: ( (lv_value_3_0= ruleXAssignment ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:507:1: (lv_value_3_0= ruleXAssignment )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:507:1: (lv_value_3_0= ruleXAssignment )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:508:3: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment1171);
                    lv_value_3_0=ruleXAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXAssignmentRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_3_0, 
                              		"XAssignment");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:525:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:525:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:526:5: this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXOrExpression_in_ruleXAssignment1201);
                    this_XOrExpression_4=ruleXOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XOrExpression_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:534:1: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==20) ) {
                        int LA7_1 = input.LA(2);

                        if ( (synpred1_InternalSGen()) ) {
                            alt7=1;
                        }
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:534:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:534:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:534:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:539:6: ( () ( ( ruleOpMultiAssign ) ) )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:539:7: () ( ( ruleOpMultiAssign ) )
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:539:7: ()
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:540:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
                                          current);
                                  
                            }

                            }

                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:545:2: ( ( ruleOpMultiAssign ) )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:546:1: ( ruleOpMultiAssign )
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:546:1: ( ruleOpMultiAssign )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:547:3: ruleOpMultiAssign
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getXAssignmentRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleOpMultiAssign_in_ruleXAssignment1254);
                            ruleOpMultiAssign();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }


                            }

                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:560:4: ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:561:1: (lv_rightOperand_7_0= ruleXAssignment )
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:561:1: (lv_rightOperand_7_0= ruleXAssignment )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:562:3: lv_rightOperand_7_0= ruleXAssignment
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment1277);
                            lv_rightOperand_7_0=ruleXAssignment();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXAssignmentRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"rightOperand",
                                      		lv_rightOperand_7_0, 
                                      		"XAssignment");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

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
    // $ANTLR end "ruleXAssignment"


    // $ANTLR start "entryRuleOpSingleAssign"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:586:1: entryRuleOpSingleAssign returns [String current=null] : iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
    public final String entryRuleOpSingleAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpSingleAssign = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:587:2: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:588:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpSingleAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign1317);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSingleAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpSingleAssign1328); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpSingleAssign"


    // $ANTLR start "ruleOpSingleAssign"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:595:1: ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:598:28: (kw= '=' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:600:2: kw= '='
            {
            kw=(Token)match(input,17,FOLLOW_17_in_ruleOpSingleAssign1365); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpSingleAssignAccess().getEqualsSignKeyword()); 
                  
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
    // $ANTLR end "ruleOpSingleAssign"


    // $ANTLR start "entryRuleOpMultiAssign"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:613:1: entryRuleOpMultiAssign returns [String current=null] : iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
    public final String entryRuleOpMultiAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMultiAssign = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:614:2: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:615:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign1405);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMultiAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMultiAssign1416); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpMultiAssign"


    // $ANTLR start "ruleOpMultiAssign"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:622:1: ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '+=' ;
    public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:625:28: (kw= '+=' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:627:2: kw= '+='
            {
            kw=(Token)match(input,20,FOLLOW_20_in_ruleOpMultiAssign1453); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword()); 
                  
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
    // $ANTLR end "ruleOpMultiAssign"


    // $ANTLR start "entryRuleXOrExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:640:1: entryRuleXOrExpression returns [EObject current=null] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOrExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:641:2: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:642:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1492);
            iv_ruleXOrExpression=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOrExpression1502); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXOrExpression"


    // $ANTLR start "ruleXOrExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:649:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:652:28: ( (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:653:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:653:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:654:5: this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression1549);
            this_XAndExpression_0=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:662:1: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==21) ) {
                    int LA9_2 = input.LA(2);

                    if ( (synpred2_InternalSGen()) ) {
                        alt9=1;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:662:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:662:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:662:3: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:667:6: ( () ( ( ruleOpOr ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:667:7: () ( ( ruleOpOr ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:667:7: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:668:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:673:2: ( ( ruleOpOr ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:674:1: ( ruleOpOr )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:674:1: ( ruleOpOr )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:675:3: ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOrExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleXOrExpression1602);
            	    ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:688:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:689:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:689:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:690:3: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression1625);
            	    lv_rightOperand_3_0=ruleXAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XAndExpression");
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
    // $ANTLR end "ruleXOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:714:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:715:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:716:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr1664);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr1675); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:723:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:726:28: (kw= '||' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:728:2: kw= '||'
            {
            kw=(Token)match(input,21,FOLLOW_21_in_ruleOpOr1712); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword()); 
                  
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
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleXAndExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:741:1: entryRuleXAndExpression returns [EObject current=null] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAndExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:742:2: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:743:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression1751);
            iv_ruleXAndExpression=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAndExpression1761); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXAndExpression"


    // $ANTLR start "ruleXAndExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:750:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XEqualityExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:753:28: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:754:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:754:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:755:5: this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1808);
            this_XEqualityExpression_0=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XEqualityExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:763:1: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==22) ) {
                    int LA10_2 = input.LA(2);

                    if ( (synpred3_InternalSGen()) ) {
                        alt10=1;
                    }


                }


                switch (alt10) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:763:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:763:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:763:3: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:768:6: ( () ( ( ruleOpAnd ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:768:7: () ( ( ruleOpAnd ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:768:7: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:769:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:774:2: ( ( ruleOpAnd ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:775:1: ( ruleOpAnd )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:775:1: ( ruleOpAnd )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:776:3: ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAndExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleXAndExpression1861);
            	    ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:789:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:790:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:790:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:791:3: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1884);
            	    lv_rightOperand_3_0=ruleXEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XEqualityExpression");
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
    // $ANTLR end "ruleXAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:815:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:816:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:817:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd1923);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd1934); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:824:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:827:28: (kw= '&&' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:829:2: kw= '&&'
            {
            kw=(Token)match(input,22,FOLLOW_22_in_ruleOpAnd1971); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword()); 
                  
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
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleXEqualityExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:842:1: entryRuleXEqualityExpression returns [EObject current=null] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEqualityExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:843:2: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:844:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression2010);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXEqualityExpression2020); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXEqualityExpression"


    // $ANTLR start "ruleXEqualityExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:851:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XRelationalExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:854:28: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:855:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:855:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:856:5: this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2067);
            this_XRelationalExpression_0=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XRelationalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:864:1: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==23) ) {
                    int LA11_2 = input.LA(2);

                    if ( (synpred4_InternalSGen()) ) {
                        alt11=1;
                    }


                }
                else if ( (LA11_0==24) ) {
                    int LA11_3 = input.LA(2);

                    if ( (synpred4_InternalSGen()) ) {
                        alt11=1;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:864:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:864:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:864:3: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:869:6: ( () ( ( ruleOpEquality ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:869:7: () ( ( ruleOpEquality ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:869:7: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:870:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:875:2: ( ( ruleOpEquality ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:876:1: ( ruleOpEquality )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:876:1: ( ruleOpEquality )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:877:3: ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXEqualityExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleXEqualityExpression2120);
            	    ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:890:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:891:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:891:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:892:3: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2143);
            	    lv_rightOperand_3_0=ruleXRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXEqualityExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XRelationalExpression");
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
    // $ANTLR end "ruleXEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:916:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:917:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:918:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality2182);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality2193); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:925:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:928:28: ( (kw= '==' | kw= '!=' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:929:1: (kw= '==' | kw= '!=' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:929:1: (kw= '==' | kw= '!=' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            else if ( (LA12_0==24) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:930:2: kw= '=='
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleOpEquality2231); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:937:2: kw= '!='
                    {
                    kw=(Token)match(input,24,FOLLOW_24_in_ruleOpEquality2250); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); 
                          
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
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleXRelationalExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:950:1: entryRuleXRelationalExpression returns [EObject current=null] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRelationalExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:951:2: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:952:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression2290);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRelationalExpression2300); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXRelationalExpression"


    // $ANTLR start "ruleXRelationalExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:959:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XOtherOperatorExpression_0 = null;

        EObject lv_rightOperand_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:962:28: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:963:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:963:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:964:5: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2347);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOtherOperatorExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:972:1: ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop13:
            do {
                int alt13=3;
                switch ( input.LA(1) ) {
                case 25:
                    {
                    int LA13_2 = input.LA(2);

                    if ( (synpred5_InternalSGen()) ) {
                        alt13=1;
                    }


                    }
                    break;
                case 26:
                    {
                    int LA13_3 = input.LA(2);

                    if ( (synpred6_InternalSGen()) ) {
                        alt13=2;
                    }


                    }
                    break;
                case 27:
                    {
                    int LA13_4 = input.LA(2);

                    if ( (synpred6_InternalSGen()) ) {
                        alt13=2;
                    }


                    }
                    break;
                case 28:
                    {
                    int LA13_5 = input.LA(2);

                    if ( (synpred6_InternalSGen()) ) {
                        alt13=2;
                    }


                    }
                    break;
                case 29:
                    {
                    int LA13_6 = input.LA(2);

                    if ( (synpred6_InternalSGen()) ) {
                        alt13=2;
                    }


                    }
                    break;

                }

                switch (alt13) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:972:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:972:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:972:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:972:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:972:4: ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:974:5: ( () otherlv_2= 'instanceof' )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:974:6: () otherlv_2= 'instanceof'
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:974:6: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:975:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleXRelationalExpression2383); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:984:3: ( ( ruleQualifiedName ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:985:1: ( ruleQualifiedName )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:985:1: ( ruleQualifiedName )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:986:3: ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeCrossReference_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression2408);
            	    ruleQualifiedName();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1000:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1000:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1000:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1000:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1000:8: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1005:6: ( () ( ( ruleOpCompare ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1005:7: () ( ( ruleOpCompare ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1005:7: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1006:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1011:2: ( ( ruleOpCompare ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1012:1: ( ruleOpCompare )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1012:1: ( ruleOpCompare )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1013:3: ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2469);
            	    ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1026:4: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1027:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1027:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1028:3: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2492);
            	    lv_rightOperand_6_0=ruleXOtherOperatorExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_6_0, 
            	              		"XOtherOperatorExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


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
    // $ANTLR end "ruleXRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1052:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1053:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1054:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare2532);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare2543); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1061:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1064:28: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1065:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1065:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt14=1;
                }
                break;
            case 27:
                {
                alt14=2;
                }
                break;
            case 28:
                {
                alt14=3;
                }
                break;
            case 29:
                {
                alt14=4;
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1066:2: kw= '>='
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleOpCompare2581); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1073:2: kw= '<='
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleOpCompare2600); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1080:2: kw= '>'
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleOpCompare2619); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1087:2: kw= '<'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleOpCompare2638); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); 
                          
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
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRuleXOtherOperatorExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1100:1: entryRuleXOtherOperatorExpression returns [EObject current=null] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOtherOperatorExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1101:2: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1102:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOtherOperatorExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression2678);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOtherOperatorExpression2688); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXOtherOperatorExpression"


    // $ANTLR start "ruleXOtherOperatorExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1109:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAdditiveExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1112:28: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1113:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1113:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1114:5: this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2735);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAdditiveExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1122:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==30) ) {
                    int LA15_2 = input.LA(2);

                    if ( (synpred7_InternalSGen()) ) {
                        alt15=1;
                    }


                }
                else if ( (LA15_0==31) ) {
                    int LA15_3 = input.LA(2);

                    if ( (synpred7_InternalSGen()) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1122:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1122:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1122:3: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1127:6: ( () ( ( ruleOpOther ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1127:7: () ( ( ruleOpOther ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1127:7: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1128:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1133:2: ( ( ruleOpOther ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1134:1: ( ruleOpOther )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1134:1: ( ruleOpOther )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1135:3: ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOtherOperatorExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression2788);
            	    ruleOpOther();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1148:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1149:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1149:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1150:3: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2811);
            	    lv_rightOperand_3_0=ruleXAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXOtherOperatorExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XAdditiveExpression");
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
    // $ANTLR end "ruleXOtherOperatorExpression"


    // $ANTLR start "entryRuleOpOther"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1174:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1175:2: (iv_ruleOpOther= ruleOpOther EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1176:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOtherRule()); 
            }
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther2850);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther2861); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpOther"


    // $ANTLR start "ruleOpOther"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1183:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1186:28: ( (kw= '->' | kw= '..' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1187:1: (kw= '->' | kw= '..' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1187:1: (kw= '->' | kw= '..' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==30) ) {
                alt16=1;
            }
            else if ( (LA16_0==31) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1188:2: kw= '->'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleOpOther2899); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1195:2: kw= '..'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleOpOther2918); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_1()); 
                          
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
    // $ANTLR end "ruleOpOther"


    // $ANTLR start "entryRuleXAdditiveExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1208:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1209:2: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1210:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression2958);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression2968); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXAdditiveExpression"


    // $ANTLR start "ruleXAdditiveExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1217:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1220:28: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1221:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1221:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1222:5: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3015);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1230:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==32) ) {
                    int LA17_2 = input.LA(2);

                    if ( (synpred8_InternalSGen()) ) {
                        alt17=1;
                    }


                }
                else if ( (LA17_0==33) ) {
                    int LA17_3 = input.LA(2);

                    if ( (synpred8_InternalSGen()) ) {
                        alt17=1;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1230:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1230:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1230:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1235:6: ( () ( ( ruleOpAdd ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1235:7: () ( ( ruleOpAdd ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1235:7: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1236:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1241:2: ( ( ruleOpAdd ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1242:1: ( ruleOpAdd )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1242:1: ( ruleOpAdd )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1243:3: ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAdditiveExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression3068);
            	    ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1256:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1257:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1257:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1258:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3091);
            	    lv_rightOperand_3_0=ruleXMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXAdditiveExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XMultiplicativeExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

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
    // $ANTLR end "ruleXAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1282:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1283:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1284:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd3130);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd3141); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1291:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1294:28: ( (kw= '+' | kw= '-' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1295:1: (kw= '+' | kw= '-' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1295:1: (kw= '+' | kw= '-' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==32) ) {
                alt18=1;
            }
            else if ( (LA18_0==33) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1296:2: kw= '+'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleOpAdd3179); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1303:2: kw= '-'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleOpAdd3198); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); 
                          
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
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRuleXMultiplicativeExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1316:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1317:2: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1318:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression3238);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression3248); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXMultiplicativeExpression"


    // $ANTLR start "ruleXMultiplicativeExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1325:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1328:28: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1329:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1329:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1330:5: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3295);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XUnaryOperation_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1338:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop19:
            do {
                int alt19=2;
                switch ( input.LA(1) ) {
                case 34:
                    {
                    int LA19_2 = input.LA(2);

                    if ( (synpred9_InternalSGen()) ) {
                        alt19=1;
                    }


                    }
                    break;
                case 35:
                    {
                    int LA19_3 = input.LA(2);

                    if ( (synpred9_InternalSGen()) ) {
                        alt19=1;
                    }


                    }
                    break;
                case 36:
                    {
                    int LA19_4 = input.LA(2);

                    if ( (synpred9_InternalSGen()) ) {
                        alt19=1;
                    }


                    }
                    break;
                case 37:
                    {
                    int LA19_5 = input.LA(2);

                    if ( (synpred9_InternalSGen()) ) {
                        alt19=1;
                    }


                    }
                    break;

                }

                switch (alt19) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1338:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1338:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1338:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1343:6: ( () ( ( ruleOpMulti ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1343:7: () ( ( ruleOpMulti ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1343:7: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1344:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1349:2: ( ( ruleOpMulti ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1350:1: ( ruleOpMulti )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1350:1: ( ruleOpMulti )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1351:3: ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMultiplicativeExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3348);
            	    ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1364:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1365:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1365:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1366:3: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3371);
            	    lv_rightOperand_3_0=ruleXUnaryOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXMultiplicativeExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XUnaryOperation");
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
    // $ANTLR end "ruleXMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1390:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1391:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1392:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti3410);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti3421); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1399:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1402:28: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1403:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1403:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt20=4;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt20=1;
                }
                break;
            case 35:
                {
                alt20=2;
                }
                break;
            case 36:
                {
                alt20=3;
                }
                break;
            case 37:
                {
                alt20=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1404:2: kw= '*'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleOpMulti3459); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1411:2: kw= '**'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleOpMulti3478); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1418:2: kw= '/'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleOpMulti3497); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1425:2: kw= '%'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleOpMulti3516); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getPercentSignKeyword_3()); 
                          
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
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRuleXUnaryOperation"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1438:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1439:2: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1440:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3556);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation3566); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXUnaryOperation"


    // $ANTLR start "ruleXUnaryOperation"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1447:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_2_0 = null;

        EObject this_XCastedExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1450:28: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1451:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1451:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=32 && LA21_0<=33)||LA21_0==38) ) {
                alt21=1;
            }
            else if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)||LA21_0==29||LA21_0==43||LA21_0==45||(LA21_0>=52 && LA21_0<=56)) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1451:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1451:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1451:3: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1451:3: ()
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1452:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1457:2: ( ( ruleOpUnary ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1458:1: ( ruleOpUnary )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1458:1: ( ruleOpUnary )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1459:3: ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXUnaryOperationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3624);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1472:2: ( (lv_operand_2_0= ruleXCastedExpression ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1473:1: (lv_operand_2_0= ruleXCastedExpression )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1473:1: (lv_operand_2_0= ruleXCastedExpression )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1474:3: lv_operand_2_0= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXCastedExpressionParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3645);
                    lv_operand_2_0=ruleXCastedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXUnaryOperationRule());
                      	        }
                             		set(
                             			current, 
                             			"operand",
                              		lv_operand_2_0, 
                              		"XCastedExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1492:5: this_XCastedExpression_3= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3674);
                    this_XCastedExpression_3=ruleXCastedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XCastedExpression_3; 
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
    // $ANTLR end "ruleXUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1508:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1509:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1510:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary3710);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary3721); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1517:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1520:28: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1521:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1521:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt22=1;
                }
                break;
            case 33:
                {
                alt22=2;
                }
                break;
            case 32:
                {
                alt22=3;
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1522:2: kw= '!'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleOpUnary3759); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1529:2: kw= '-'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleOpUnary3778); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1536:2: kw= '+'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleOpUnary3797); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); 
                          
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
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleXCastedExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1549:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCastedExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1550:2: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1551:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCastedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression3837);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression3847); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXCastedExpression"


    // $ANTLR start "ruleXCastedExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1558:1: ruleXCastedExpression returns [EObject current=null] : (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XMemberFeatureCall_0 = null;

        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1561:28: ( (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1562:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1562:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1563:5: this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXCastedExpressionAccess().getXMemberFeatureCallParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression3894);
            this_XMemberFeatureCall_0=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMemberFeatureCall_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1571:1: ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==39) ) {
                    int LA23_2 = input.LA(2);

                    if ( (synpred10_InternalSGen()) ) {
                        alt23=1;
                    }


                }


                switch (alt23) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1571:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1571:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1571:3: ( ( () 'as' ) )=> ( () otherlv_2= 'as' )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1573:5: ( () otherlv_2= 'as' )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1573:6: () otherlv_2= 'as'
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1573:6: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1574:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleXCastedExpression3929); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1583:3: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1584:1: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1584:1: (lv_type_3_0= ruleJvmTypeReference )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1585:3: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression3952);
            	    lv_type_3_0=ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXCastedExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"type",
            	              		lv_type_3_0, 
            	              		"JvmTypeReference");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // $ANTLR end "ruleXCastedExpression"


    // $ANTLR start "entryRuleXMemberFeatureCall"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1609:1: entryRuleXMemberFeatureCall returns [EObject current=null] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMemberFeatureCall = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1610:2: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1611:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMemberFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall3990);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMemberFeatureCall4000); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXMemberFeatureCall"


    // $ANTLR start "ruleXMemberFeatureCall"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1618:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* ) ;
    public final EObject ruleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_7=null;
        Token lv_nullSafe_8_0=null;
        Token lv_spreading_9_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token lv_explicitOperationCall_16_0=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        EObject this_XPrimaryExpression_0 = null;

        EObject lv_value_5_0 = null;

        EObject lv_typeArguments_11_0 = null;

        EObject lv_typeArguments_13_0 = null;

        EObject lv_memberCallArguments_17_0 = null;

        EObject lv_memberCallArguments_18_0 = null;

        EObject lv_memberCallArguments_20_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1621:28: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1622:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1622:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1623:5: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall4047);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XPrimaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1631:1: ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )*
            loop30:
            do {
                int alt30=3;
                switch ( input.LA(1) ) {
                case 19:
                    {
                    int LA30_2 = input.LA(2);

                    if ( (synpred11_InternalSGen()) ) {
                        alt30=1;
                    }
                    else if ( (synpred12_InternalSGen()) ) {
                        alt30=2;
                    }


                    }
                    break;
                case 40:
                    {
                    int LA30_3 = input.LA(2);

                    if ( (synpred12_InternalSGen()) ) {
                        alt30=2;
                    }


                    }
                    break;
                case 41:
                    {
                    int LA30_4 = input.LA(2);

                    if ( (synpred12_InternalSGen()) ) {
                        alt30=2;
                    }


                    }
                    break;

                }

                switch (alt30) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1631:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1631:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1631:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1631:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1631:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1637:25: ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1637:26: () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1637:26: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1638:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleXMemberFeatureCall4096); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1());
            	          
            	    }
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1647:1: ( ( ruleValidID ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1648:1: ( ruleValidID )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1648:1: ( ruleValidID )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1649:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4119);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getOpSingleAssignParserRuleCall_1_0_0_0_3()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall4135);
            	    ruleOpSingleAssign();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }


            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1670:3: ( (lv_value_5_0= ruleXAssignment ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1671:1: (lv_value_5_0= ruleXAssignment )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1671:1: (lv_value_5_0= ruleXAssignment )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1672:3: lv_value_5_0= ruleXAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall4157);
            	    lv_value_5_0=ruleXAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"value",
            	              		lv_value_5_0, 
            	              		"XAssignment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1689:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1689:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1689:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1689:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1689:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1705:7: ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1705:8: () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1705:8: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1706:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1711:2: (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    int alt24=3;
            	    switch ( input.LA(1) ) {
            	    case 19:
            	        {
            	        alt24=1;
            	        }
            	        break;
            	    case 40:
            	        {
            	        alt24=2;
            	        }
            	        break;
            	    case 41:
            	        {
            	        alt24=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 24, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt24) {
            	        case 1 :
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1711:4: otherlv_7= '.'
            	            {
            	            otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleXMemberFeatureCall4243); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_7, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0());
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1716:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            {
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1716:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1717:1: (lv_nullSafe_8_0= '?.' )
            	            {
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1717:1: (lv_nullSafe_8_0= '?.' )
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1718:3: lv_nullSafe_8_0= '?.'
            	            {
            	            lv_nullSafe_8_0=(Token)match(input,40,FOLLOW_40_in_ruleXMemberFeatureCall4267); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_nullSafe_8_0, grammarAccess.getXMemberFeatureCallAccess().getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		setWithLastConsumed(current, "nullSafe", true, "?.");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1732:6: ( (lv_spreading_9_0= '*.' ) )
            	            {
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1732:6: ( (lv_spreading_9_0= '*.' ) )
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1733:1: (lv_spreading_9_0= '*.' )
            	            {
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1733:1: (lv_spreading_9_0= '*.' )
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1734:3: lv_spreading_9_0= '*.'
            	            {
            	            lv_spreading_9_0=(Token)match(input,41,FOLLOW_41_in_ruleXMemberFeatureCall4304); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_spreading_9_0, grammarAccess.getXMemberFeatureCallAccess().getSpreadingAsteriskFullStopKeyword_1_1_0_0_1_2_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		setWithLastConsumed(current, "spreading", true, "*.");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1747:5: (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )?
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==29) ) {
            	        alt26=1;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1747:7: otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>'
            	            {
            	            otherlv_10=(Token)match(input,29,FOLLOW_29_in_ruleXMemberFeatureCall4333); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_10, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0());
            	                  
            	            }
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1751:1: ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) )
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1752:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            {
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1752:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1753:3: lv_typeArguments_11_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4354);
            	            lv_typeArguments_11_0=ruleJvmArgumentTypeReference();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"typeArguments",
            	                      		lv_typeArguments_11_0, 
            	                      		"JvmArgumentTypeReference");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }


            	            }

            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1769:2: (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop25:
            	            do {
            	                int alt25=2;
            	                int LA25_0 = input.LA(1);

            	                if ( (LA25_0==42) ) {
            	                    alt25=1;
            	                }


            	                switch (alt25) {
            	            	case 1 :
            	            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1769:4: otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    otherlv_12=(Token)match(input,42,FOLLOW_42_in_ruleXMemberFeatureCall4367); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	          	newLeafNode(otherlv_12, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0());
            	            	          
            	            	    }
            	            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1773:1: ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1774:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1774:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1775:3: lv_typeArguments_13_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {
            	            	       
            	            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0()); 
            	            	      	    
            	            	    }
            	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4388);
            	            	    lv_typeArguments_13_0=ruleJvmArgumentTypeReference();

            	            	    state._fsp--;
            	            	    if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      	        if (current==null) {
            	            	      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	            	      	        }
            	            	             		add(
            	            	             			current, 
            	            	             			"typeArguments",
            	            	              		lv_typeArguments_13_0, 
            	            	              		"JvmArgumentTypeReference");
            	            	      	        afterParserOrEnumRuleCall();
            	            	      	    
            	            	    }

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop25;
            	                }
            	            } while (true);

            	            otherlv_14=(Token)match(input,28,FOLLOW_28_in_ruleXMemberFeatureCall4402); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_14, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1795:3: ( ( ruleValidID ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1796:1: ( ruleValidID )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1796:1: ( ruleValidID )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1797:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4427);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1810:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?
            	    int alt29=2;
            	    int LA29_0 = input.LA(1);

            	    if ( (LA29_0==43) && (synpred13_InternalSGen())) {
            	        alt29=1;
            	    }
            	    switch (alt29) {
            	        case 1 :
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1810:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')'
            	            {
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1810:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) )
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1810:4: ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' )
            	            {
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1817:1: (lv_explicitOperationCall_16_0= '(' )
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1818:3: lv_explicitOperationCall_16_0= '('
            	            {
            	            lv_explicitOperationCall_16_0=(Token)match(input,43,FOLLOW_43_in_ruleXMemberFeatureCall4461); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_explicitOperationCall_16_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		setWithLastConsumed(current, "explicitOperationCall", true, "(");
            	              	    
            	            }

            	            }


            	            }

            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1831:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?
            	            int alt28=3;
            	            alt28 = dfa28.predict(input);
            	            switch (alt28) {
            	                case 1 :
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1831:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    {
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1831:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1831:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    {
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1843:1: (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1844:3: lv_memberCallArguments_17_0= ruleXShortClosure
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4536);
            	                    lv_memberCallArguments_17_0=ruleXShortClosure();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      	        if (current==null) {
            	                      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                      	        }
            	                             		add(
            	                             			current, 
            	                             			"memberCallArguments",
            	                              		lv_memberCallArguments_17_0, 
            	                              		"XShortClosure");
            	                      	        afterParserOrEnumRuleCall();
            	                      	    
            	                    }

            	                    }


            	                    }


            	                    }
            	                    break;
            	                case 2 :
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1861:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    {
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1861:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1861:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    {
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1861:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) )
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1862:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    {
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1862:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1863:3: lv_memberCallArguments_18_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4564);
            	                    lv_memberCallArguments_18_0=ruleXExpression();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      	        if (current==null) {
            	                      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                      	        }
            	                             		add(
            	                             			current, 
            	                             			"memberCallArguments",
            	                              		lv_memberCallArguments_18_0, 
            	                              		"XExpression");
            	                      	        afterParserOrEnumRuleCall();
            	                      	    
            	                    }

            	                    }


            	                    }

            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1879:2: (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    loop27:
            	                    do {
            	                        int alt27=2;
            	                        int LA27_0 = input.LA(1);

            	                        if ( (LA27_0==42) ) {
            	                            alt27=1;
            	                        }


            	                        switch (alt27) {
            	                    	case 1 :
            	                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1879:4: otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_19=(Token)match(input,42,FOLLOW_42_in_ruleXMemberFeatureCall4577); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	newLeafNode(otherlv_19, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
            	                    	          
            	                    	    }
            	                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1883:1: ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1884:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    {
            	                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1884:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1885:3: lv_memberCallArguments_20_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0()); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4598);
            	                    	    lv_memberCallArguments_20_0=ruleXExpression();

            	                    	    state._fsp--;
            	                    	    if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      	        if (current==null) {
            	                    	      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                    	      	        }
            	                    	             		add(
            	                    	             			current, 
            	                    	             			"memberCallArguments",
            	                    	              		lv_memberCallArguments_20_0, 
            	                    	              		"XExpression");
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


            	                    }


            	                    }
            	                    break;

            	            }

            	            otherlv_21=(Token)match(input,44,FOLLOW_44_in_ruleXMemberFeatureCall4615); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_21, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2());
            	                  
            	            }

            	            }
            	            break;

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
    // $ANTLR end "ruleXMemberFeatureCall"


    // $ANTLR start "entryRuleXLiteral"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1913:1: entryRuleXLiteral returns [EObject current=null] : iv_ruleXLiteral= ruleXLiteral EOF ;
    public final EObject entryRuleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXLiteral = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1914:2: (iv_ruleXLiteral= ruleXLiteral EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1915:2: iv_ruleXLiteral= ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXLiteral_in_entryRuleXLiteral4656);
            iv_ruleXLiteral=ruleXLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXLiteral4666); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXLiteral"


    // $ANTLR start "ruleXLiteral"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1922:1: ruleXLiteral returns [EObject current=null] : (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) ;
    public final EObject ruleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_XClosure_0 = null;

        EObject this_XBooleanLiteral_1 = null;

        EObject this_XIntLiteral_2 = null;

        EObject this_XNullLiteral_3 = null;

        EObject this_XStringLiteral_4 = null;

        EObject this_XTypeLiteral_5 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1925:28: ( (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1926:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1926:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            int alt31=6;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt31=1;
                }
                break;
            case 53:
            case 54:
                {
                alt31=2;
                }
                break;
            case RULE_INT:
                {
                alt31=3;
                }
                break;
            case 55:
                {
                alt31=4;
                }
                break;
            case RULE_STRING:
                {
                alt31=5;
                }
                break;
            case 56:
                {
                alt31=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1927:5: this_XClosure_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXLiteral4713);
                    this_XClosure_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XClosure_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1937:5: this_XBooleanLiteral_1= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral4740);
                    this_XBooleanLiteral_1=ruleXBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XBooleanLiteral_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1947:5: this_XIntLiteral_2= ruleXIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXIntLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIntLiteral_in_ruleXLiteral4767);
                    this_XIntLiteral_2=ruleXIntLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XIntLiteral_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1957:5: this_XNullLiteral_3= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNullLiteral_in_ruleXLiteral4794);
                    this_XNullLiteral_3=ruleXNullLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XNullLiteral_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1967:5: this_XStringLiteral_4= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXLiteral4821);
                    this_XStringLiteral_4=ruleXStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XStringLiteral_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1977:5: this_XTypeLiteral_5= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXLiteral4848);
                    this_XTypeLiteral_5=ruleXTypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTypeLiteral_5; 
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
    // $ANTLR end "ruleXLiteral"


    // $ANTLR start "entryRuleXClosure"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1993:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1994:2: (iv_ruleXClosure= ruleXClosure EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1995:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure4883);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure4893); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXClosure"


    // $ANTLR start "ruleXClosure"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2002:1: ruleXClosure returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' ) ;
    public final EObject ruleXClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_formalParameters_2_0 = null;

        EObject lv_formalParameters_4_0 = null;

        EObject lv_expression_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2005:28: ( ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2006:1: ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2006:1: ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2006:2: () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']'
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2006:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2007:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXClosureAccess().getXClosureAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,45,FOLLOW_45_in_ruleXClosure4939); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2016:1: ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID||LA33_0==43||LA33_0==58) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2016:2: ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2016:2: ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2017:1: (lv_formalParameters_2_0= ruleJvmFormalParameter )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2017:1: (lv_formalParameters_2_0= ruleJvmFormalParameter )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2018:3: lv_formalParameters_2_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure4961);
                    lv_formalParameters_2_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXClosureRule());
                      	        }
                             		add(
                             			current, 
                             			"formalParameters",
                              		lv_formalParameters_2_0, 
                              		"JvmFormalParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2034:2: (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==42) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2034:4: otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_3=(Token)match(input,42,FOLLOW_42_in_ruleXClosure4974); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getXClosureAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2038:1: ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2039:1: (lv_formalParameters_4_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2039:1: (lv_formalParameters_4_0= ruleJvmFormalParameter )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2040:3: lv_formalParameters_4_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure4995);
                    	    lv_formalParameters_4_0=ruleJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXClosureRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"formalParameters",
                    	              		lv_formalParameters_4_0, 
                    	              		"JvmFormalParameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
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
                    break;

            }

            otherlv_5=(Token)match(input,46,FOLLOW_46_in_ruleXClosure5011); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXClosureAccess().getVerticalLineKeyword_3());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2060:1: ( (lv_expression_6_0= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2061:1: (lv_expression_6_0= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2061:1: (lv_expression_6_0= ruleXExpression )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2062:3: lv_expression_6_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXClosure5032);
            lv_expression_6_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXClosureRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_6_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,47,FOLLOW_47_in_ruleXClosure5044); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getXClosureAccess().getRightSquareBracketKeyword_5());
                  
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
    // $ANTLR end "ruleXClosure"


    // $ANTLR start "entryRuleXShortClosure"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2090:1: entryRuleXShortClosure returns [EObject current=null] : iv_ruleXShortClosure= ruleXShortClosure EOF ;
    public final EObject entryRuleXShortClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXShortClosure = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2091:2: (iv_ruleXShortClosure= ruleXShortClosure EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2092:2: iv_ruleXShortClosure= ruleXShortClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXShortClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5080);
            iv_ruleXShortClosure=ruleXShortClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXShortClosure5090); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXShortClosure"


    // $ANTLR start "ruleXShortClosure"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2099:1: ruleXShortClosure returns [EObject current=null] : ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXShortClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_formalParameters_1_0 = null;

        EObject lv_formalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2102:28: ( ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2103:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2103:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2103:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) ) ( (lv_expression_5_0= ruleXExpression ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2103:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2103:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2114:5: ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2114:6: () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|'
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2114:6: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2115:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXShortClosureAccess().getXClosureAction_0_0_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2120:2: ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID||LA35_0==43||LA35_0==58) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2120:3: ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2120:3: ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2121:1: (lv_formalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2121:1: (lv_formalParameters_1_0= ruleJvmFormalParameter )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2122:3: lv_formalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5188);
                    lv_formalParameters_1_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
                      	        }
                             		add(
                             			current, 
                             			"formalParameters",
                              		lv_formalParameters_1_0, 
                              		"JvmFormalParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2138:2: (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==42) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2138:4: otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,42,FOLLOW_42_in_ruleXShortClosure5201); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0());
                    	          
                    	    }
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2142:1: ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2143:1: (lv_formalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2143:1: (lv_formalParameters_3_0= ruleJvmFormalParameter )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2144:3: lv_formalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5222);
                    	    lv_formalParameters_3_0=ruleJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"formalParameters",
                    	              		lv_formalParameters_3_0, 
                    	              		"JvmFormalParameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,46,FOLLOW_46_in_ruleXShortClosure5238); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXShortClosureAccess().getVerticalLineKeyword_0_0_2());
                  
            }

            }


            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2164:3: ( (lv_expression_5_0= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2165:1: (lv_expression_5_0= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2165:1: (lv_expression_5_0= ruleXExpression )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2166:3: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXShortClosure5261);
            lv_expression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_5_0, 
                      		"XExpression");
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
    // $ANTLR end "ruleXShortClosure"


    // $ANTLR start "entryRuleXParenthesizedExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2190:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2191:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2192:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression5297);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression5307); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXParenthesizedExpression"


    // $ANTLR start "ruleXParenthesizedExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2199:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2202:28: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2203:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2203:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2203:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_43_in_ruleXParenthesizedExpression5344); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression5366);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleXParenthesizedExpression5377); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
                  
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
    // $ANTLR end "ruleXParenthesizedExpression"


    // $ANTLR start "entryRuleXCasePart"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2232:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2233:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2234:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCasePartRule()); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart5417);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart5427); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXCasePart"


    // $ANTLR start "ruleXCasePart"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2241:1: ruleXCasePart returns [EObject current=null] : ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_typeGuard_0_0 = null;

        EObject lv_case_2_0 = null;

        EObject lv_then_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2244:28: ( ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2245:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2245:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2245:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2245:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID||LA36_0==43||LA36_0==58) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2246:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2246:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2247:3: lv_typeGuard_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart5473);
                    lv_typeGuard_0_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXCasePartRule());
                      	        }
                             		set(
                             			current, 
                             			"typeGuard",
                              		lv_typeGuard_0_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2263:3: (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==48) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2263:5: otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) )
                    {
                    otherlv_1=(Token)match(input,48,FOLLOW_48_in_ruleXCasePart5487); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXCasePartAccess().getCaseKeyword_1_0());
                          
                    }
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2267:1: ( (lv_case_2_0= ruleXExpression ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2268:1: (lv_case_2_0= ruleXExpression )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2268:1: (lv_case_2_0= ruleXExpression )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2269:3: lv_case_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart5508);
                    lv_case_2_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXCasePartRule());
                      	        }
                             		set(
                             			current, 
                             			"case",
                              		lv_case_2_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,49,FOLLOW_49_in_ruleXCasePart5522); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCasePartAccess().getColonKeyword_2());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2289:1: ( (lv_then_4_0= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2290:1: (lv_then_4_0= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2290:1: (lv_then_4_0= ruleXExpression )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2291:3: lv_then_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart5543);
            lv_then_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXCasePartRule());
              	        }
                     		set(
                     			current, 
                     			"then",
                      		lv_then_4_0, 
                      		"XExpression");
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
    // $ANTLR end "ruleXCasePart"


    // $ANTLR start "entryRuleXExpressionInsideBlock"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2323:1: entryRuleXExpressionInsideBlock returns [EObject current=null] : iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF ;
    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInsideBlock = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2324:2: (iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2325:2: iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInsideBlockRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock5587);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock5597); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXExpressionInsideBlock"


    // $ANTLR start "ruleXExpressionInsideBlock"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2332:1: ruleXExpressionInsideBlock returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2335:28: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2336:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2336:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=50 && LA38_0<=51)) ) {
                alt38=1;
            }
            else if ( ((LA38_0>=RULE_ID && LA38_0<=RULE_STRING)||LA38_0==29||(LA38_0>=32 && LA38_0<=33)||LA38_0==38||LA38_0==43||LA38_0==45||(LA38_0>=52 && LA38_0<=56)) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2337:5: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXVariableDeclarationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock5644);
                    this_XVariableDeclaration_0=ruleXVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XVariableDeclaration_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2347:5: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock5671);
                    this_XExpression_1=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XExpression_1; 
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
    // $ANTLR end "ruleXExpressionInsideBlock"


    // $ANTLR start "entryRuleXVariableDeclaration"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2363:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2364:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2365:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration5706);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration5716); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXVariableDeclaration"


    // $ANTLR start "ruleXVariableDeclaration"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2372:1: ruleXVariableDeclaration returns [EObject current=null] : ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_writeable_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_type_3_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        AntlrDatatypeRuleToken lv_name_5_0 = null;

        EObject lv_right_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2375:28: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2376:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2376:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2376:2: () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2376:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2377:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXVariableDeclarationAccess().getXVariableDeclarationAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2382:2: ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==50) ) {
                alt39=1;
            }
            else if ( (LA39_0==51) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2382:3: ( (lv_writeable_1_0= 'var' ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2382:3: ( (lv_writeable_1_0= 'var' ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2383:1: (lv_writeable_1_0= 'var' )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2383:1: (lv_writeable_1_0= 'var' )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2384:3: lv_writeable_1_0= 'var'
                    {
                    lv_writeable_1_0=(Token)match(input,50,FOLLOW_50_in_ruleXVariableDeclaration5769); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_writeable_1_0, grammarAccess.getXVariableDeclarationAccess().getWriteableVarKeyword_1_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		setWithLastConsumed(current, "writeable", true, "var");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2398:7: otherlv_2= 'val'
                    {
                    otherlv_2=(Token)match(input,51,FOLLOW_51_in_ruleXVariableDeclaration5800); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXVariableDeclarationAccess().getValKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2402:2: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ID) ) {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==19) && (synpred16_InternalSGen())) {
                    alt40=1;
                }
                else if ( (LA40_1==29) && (synpred16_InternalSGen())) {
                    alt40=1;
                }
                else if ( (LA40_1==RULE_ID) && (synpred16_InternalSGen())) {
                    alt40=1;
                }
                else if ( (LA40_1==EOF||LA40_1==17) ) {
                    alt40=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA40_0==43) && (synpred16_InternalSGen())) {
                alt40=1;
            }
            else if ( (LA40_0==58) && (synpred16_InternalSGen())) {
                alt40=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2402:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2402:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2402:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2410:6: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2410:7: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2410:7: ( (lv_type_3_0= ruleJvmTypeReference ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2411:1: (lv_type_3_0= ruleJvmTypeReference )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2411:1: (lv_type_3_0= ruleJvmTypeReference )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2412:3: lv_type_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration5848);
                    lv_type_3_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_3_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2428:2: ( (lv_name_4_0= ruleValidID ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2429:1: (lv_name_4_0= ruleValidID )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2429:1: (lv_name_4_0= ruleValidID )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2430:3: lv_name_4_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration5869);
                    lv_name_4_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_4_0, 
                              		"ValidID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2447:6: ( (lv_name_5_0= ruleValidID ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2447:6: ( (lv_name_5_0= ruleValidID ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2448:1: (lv_name_5_0= ruleValidID )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2448:1: (lv_name_5_0= ruleValidID )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2449:3: lv_name_5_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration5898);
                    lv_name_5_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_5_0, 
                              		"ValidID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2465:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==17) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2465:5: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleXVariableDeclaration5912); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2469:1: ( (lv_right_7_0= ruleXExpression ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2470:1: (lv_right_7_0= ruleXExpression )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2470:1: (lv_right_7_0= ruleXExpression )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2471:3: lv_right_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration5933);
                    lv_right_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_7_0, 
                              		"XExpression");
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
    // $ANTLR end "ruleXVariableDeclaration"


    // $ANTLR start "entryRuleJvmFormalParameter"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2495:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2496:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2497:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter5971);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter5981); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmFormalParameter"


    // $ANTLR start "ruleJvmFormalParameter"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2504:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2507:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2508:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2508:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2508:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2508:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==RULE_ID||LA42_1==19||LA42_1==29) ) {
                    alt42=1;
                }
            }
            else if ( (LA42_0==43||LA42_0==58) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2509:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2509:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2510:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter6027);
                    lv_parameterType_0_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
                      	        }
                             		set(
                             			current, 
                             			"parameterType",
                              		lv_parameterType_0_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2526:3: ( (lv_name_1_0= ruleValidID ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2527:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2527:1: (lv_name_1_0= ruleValidID )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2528:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleJvmFormalParameter6049);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ValidID");
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
    // $ANTLR end "ruleJvmFormalParameter"


    // $ANTLR start "entryRuleXFeatureCall"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2552:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2553:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2554:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall6085);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall6095); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXFeatureCall"


    // $ANTLR start "ruleXFeatureCall"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2561:1: ruleXFeatureCall returns [EObject current=null] : ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ) ;
    public final EObject ruleXFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_explicitOperationCall_8_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_typeArguments_3_0 = null;

        EObject lv_typeArguments_5_0 = null;

        EObject lv_featureCallArguments_9_0 = null;

        EObject lv_featureCallArguments_10_0 = null;

        EObject lv_featureCallArguments_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2564:28: ( ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2565:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2565:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2565:2: () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2565:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2566:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2571:2: ( ( ruleStaticQualifier ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID) ) {
                int LA43_1 = input.LA(2);

                if ( (LA43_1==18) ) {
                    alt43=1;
                }
            }
            switch (alt43) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2572:1: ( ruleStaticQualifier )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2572:1: ( ruleStaticQualifier )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2573:3: ruleStaticQualifier
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXFeatureCallRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getDeclaringTypeJvmDeclaredTypeCrossReference_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall6152);
                    ruleStaticQualifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2586:3: (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==29) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2586:5: otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,29,FOLLOW_29_in_ruleXFeatureCall6166); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_2_0());
                          
                    }
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2590:1: ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2591:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2591:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2592:3: lv_typeArguments_3_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall6187);
                    lv_typeArguments_3_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                      	        }
                             		add(
                             			current, 
                             			"typeArguments",
                              		lv_typeArguments_3_0, 
                              		"JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2608:2: (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==42) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2608:4: otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_4=(Token)match(input,42,FOLLOW_42_in_ruleXFeatureCall6200); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getXFeatureCallAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2612:1: ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2613:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2613:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2614:3: lv_typeArguments_5_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall6221);
                    	    lv_typeArguments_5_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typeArguments",
                    	              		lv_typeArguments_5_0, 
                    	              		"JvmArgumentTypeReference");
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

                    otherlv_6=(Token)match(input,28,FOLLOW_28_in_ruleXFeatureCall6235); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_2_3());
                          
                    }

                    }
                    break;

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2634:3: ( ( ruleIdOrSuper ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2635:1: ( ruleIdOrSuper )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2635:1: ( ruleIdOrSuper )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2636:3: ruleIdOrSuper
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXFeatureCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall6260);
            ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2649:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==43) && (synpred17_InternalSGen())) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2649:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2649:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2649:4: ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2656:1: (lv_explicitOperationCall_8_0= '(' )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2657:3: lv_explicitOperationCall_8_0= '('
                    {
                    lv_explicitOperationCall_8_0=(Token)match(input,43,FOLLOW_43_in_ruleXFeatureCall6294); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_explicitOperationCall_8_0, grammarAccess.getXFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_4_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXFeatureCallRule());
                      	        }
                             		setWithLastConsumed(current, "explicitOperationCall", true, "(");
                      	    
                    }

                    }


                    }

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2670:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt47=3;
                    alt47 = dfa47.predict(input);
                    switch (alt47) {
                        case 1 :
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2670:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2670:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2670:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure )
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2682:1: (lv_featureCallArguments_9_0= ruleXShortClosure )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2683:3: lv_featureCallArguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_4_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXShortClosure_in_ruleXFeatureCall6369);
                            lv_featureCallArguments_9_0=ruleXShortClosure();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"featureCallArguments",
                                      		lv_featureCallArguments_9_0, 
                                      		"XShortClosure");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2700:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2700:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2700:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2700:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2701:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2701:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2702:3: lv_featureCallArguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall6397);
                            lv_featureCallArguments_10_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"featureCallArguments",
                                      		lv_featureCallArguments_10_0, 
                                      		"XExpression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2718:2: (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            loop46:
                            do {
                                int alt46=2;
                                int LA46_0 = input.LA(1);

                                if ( (LA46_0==42) ) {
                                    alt46=1;
                                }


                                switch (alt46) {
                            	case 1 :
                            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2718:4: otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    {
                            	    otherlv_11=(Token)match(input,42,FOLLOW_42_in_ruleXFeatureCall6410); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getXFeatureCallAccess().getCommaKeyword_4_1_1_1_0());
                            	          
                            	    }
                            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2722:1: ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2723:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    {
                            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2723:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2724:3: lv_featureCallArguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall6431);
                            	    lv_featureCallArguments_12_0=ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"featureCallArguments",
                            	              		lv_featureCallArguments_12_0, 
                            	              		"XExpression");
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
                            break;

                    }

                    otherlv_13=(Token)match(input,44,FOLLOW_44_in_ruleXFeatureCall6448); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_4_2());
                          
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
    // $ANTLR end "ruleXFeatureCall"


    // $ANTLR start "entryRuleIdOrSuper"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2752:1: entryRuleIdOrSuper returns [String current=null] : iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
    public final String entryRuleIdOrSuper() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrSuper = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2753:2: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2754:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrSuperRule()); 
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper6487);
            iv_ruleIdOrSuper=ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrSuper.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdOrSuper6498); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdOrSuper"


    // $ANTLR start "ruleIdOrSuper"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2761:1: ruleIdOrSuper returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID | kw= 'super' ) ;
    public final AntlrDatatypeRuleToken ruleIdOrSuper() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2764:28: ( (this_ValidID_0= ruleValidID | kw= 'super' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2765:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2765:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID) ) {
                alt49=1;
            }
            else if ( (LA49_0==52) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2766:5: this_ValidID_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIdOrSuperAccess().getValidIDParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleIdOrSuper6545);
                    this_ValidID_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ValidID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2778:2: kw= 'super'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleIdOrSuper6569); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIdOrSuperAccess().getSuperKeyword_1()); 
                          
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
    // $ANTLR end "ruleIdOrSuper"


    // $ANTLR start "entryRuleStaticQualifier"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2791:1: entryRuleStaticQualifier returns [String current=null] : iv_ruleStaticQualifier= ruleStaticQualifier EOF ;
    public final String entryRuleStaticQualifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStaticQualifier = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2792:2: (iv_ruleStaticQualifier= ruleStaticQualifier EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2793:2: iv_ruleStaticQualifier= ruleStaticQualifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStaticQualifierRule()); 
            }
            pushFollow(FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier6610);
            iv_ruleStaticQualifier=ruleStaticQualifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStaticQualifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStaticQualifier6621); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStaticQualifier"


    // $ANTLR start "ruleStaticQualifier"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2800:1: ruleStaticQualifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= '::' )+ ;
    public final AntlrDatatypeRuleToken ruleStaticQualifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2803:28: ( (this_ValidID_0= ruleValidID kw= '::' )+ )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2804:1: (this_ValidID_0= ruleValidID kw= '::' )+
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2804:1: (this_ValidID_0= ruleValidID kw= '::' )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_ID) ) {
                    int LA50_2 = input.LA(2);

                    if ( (LA50_2==18) ) {
                        alt50=1;
                    }


                }


                switch (alt50) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2805:5: this_ValidID_0= ruleValidID kw= '::'
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getStaticQualifierAccess().getValidIDParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleStaticQualifier6668);
            	    this_ValidID_0=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }
            	    kw=(Token)match(input,18,FOLLOW_18_in_ruleStaticQualifier6686); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getStaticQualifierAccess().getColonColonKeyword_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt50 >= 1 ) break loop50;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(50, input);
                        throw eee;
                }
                cnt50++;
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
    // $ANTLR end "ruleStaticQualifier"


    // $ANTLR start "entryRuleXBooleanLiteral"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2831:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2832:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2833:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral6729);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral6739); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXBooleanLiteral"


    // $ANTLR start "ruleXBooleanLiteral"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2840:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2843:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2844:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2844:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2844:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2844:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2845:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2850:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==53) ) {
                alt51=1;
            }
            else if ( (LA51_0==54) ) {
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2850:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleXBooleanLiteral6786); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2855:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2855:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2856:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2856:1: (lv_isTrue_2_0= 'true' )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2857:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,54,FOLLOW_54_in_ruleXBooleanLiteral6810); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isTrue_2_0, grammarAccess.getXBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXBooleanLiteralRule());
                      	        }
                             		setWithLastConsumed(current, "isTrue", true, "true");
                      	    
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
    // $ANTLR end "ruleXBooleanLiteral"


    // $ANTLR start "entryRuleXNullLiteral"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2878:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2879:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2880:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNullLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral6860);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral6870); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXNullLiteral"


    // $ANTLR start "ruleXNullLiteral"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2887:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2890:28: ( ( () otherlv_1= 'null' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2891:1: ( () otherlv_1= 'null' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2891:1: ( () otherlv_1= 'null' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2891:2: () otherlv_1= 'null'
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2891:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2892:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,55,FOLLOW_55_in_ruleXNullLiteral6916); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXNullLiteralAccess().getNullKeyword_1());
                  
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
    // $ANTLR end "ruleXNullLiteral"


    // $ANTLR start "entryRuleXIntLiteral"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2909:1: entryRuleXIntLiteral returns [EObject current=null] : iv_ruleXIntLiteral= ruleXIntLiteral EOF ;
    public final EObject entryRuleXIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIntLiteral = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2910:2: (iv_ruleXIntLiteral= ruleXIntLiteral EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2911:2: iv_ruleXIntLiteral= ruleXIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIntLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral6952);
            iv_ruleXIntLiteral=ruleXIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIntLiteral6962); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXIntLiteral"


    // $ANTLR start "ruleXIntLiteral"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2918:1: ruleXIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleXIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2921:28: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2922:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2922:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2922:2: () ( (lv_value_1_0= RULE_INT ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2922:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2923:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIntLiteralAccess().getXIntLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2928:2: ( (lv_value_1_0= RULE_INT ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2929:1: (lv_value_1_0= RULE_INT )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2929:1: (lv_value_1_0= RULE_INT )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2930:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleXIntLiteral7013); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getXIntLiteralAccess().getValueINTTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getXIntLiteralRule());
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
    // $ANTLR end "ruleXIntLiteral"


    // $ANTLR start "entryRuleXStringLiteral"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2954:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2955:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2956:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral7054);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral7064); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXStringLiteral"


    // $ANTLR start "ruleXStringLiteral"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2963:1: ruleXStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2966:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2967:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2967:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2967:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2967:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2968:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2973:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2974:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2974:1: (lv_value_1_0= RULE_STRING )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2975:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXStringLiteral7115); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getXStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getXStringLiteralRule());
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
    // $ANTLR end "ruleXStringLiteral"


    // $ANTLR start "entryRuleXTypeLiteral"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2999:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3000:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3001:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTypeLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral7156);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral7166); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXTypeLiteral"


    // $ANTLR start "ruleXTypeLiteral"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3008:1: ruleXTypeLiteral returns [EObject current=null] : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3011:28: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3012:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3012:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3012:2: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')'
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3012:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3013:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,56,FOLLOW_56_in_ruleXTypeLiteral7212); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,43,FOLLOW_43_in_ruleXTypeLiteral7224); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3026:1: ( ( ruleQualifiedName ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3027:1: ( ruleQualifiedName )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3027:1: ( ruleQualifiedName )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3028:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXTypeLiteralRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral7247);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,44,FOLLOW_44_in_ruleXTypeLiteral7259); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXTypeLiteralAccess().getRightParenthesisKeyword_4());
                  
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
    // $ANTLR end "ruleXTypeLiteral"


    // $ANTLR start "entryRuleXCatchClause"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3059:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3060:2: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3061:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCatchClauseRule()); 
            }
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause7301);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause7311); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXCatchClause"


    // $ANTLR start "ruleXCatchClause"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3068:1: ruleXCatchClause returns [EObject current=null] : ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3071:28: ( ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3072:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3072:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3072:2: ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3072:2: ( ( 'catch' )=>otherlv_0= 'catch' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3072:3: ( 'catch' )=>otherlv_0= 'catch'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_57_in_ruleXCatchClause7356); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0());
                  
            }

            }

            otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleXCatchClause7369); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3081:1: ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3082:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3082:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3083:3: lv_declaredParam_2_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause7390);
            lv_declaredParam_2_0=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
              	        }
                     		set(
                     			current, 
                     			"declaredParam",
                      		lv_declaredParam_2_0, 
                      		"JvmFormalParameter");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,44,FOLLOW_44_in_ruleXCatchClause7402); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3103:1: ( (lv_expression_4_0= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3104:1: (lv_expression_4_0= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3104:1: (lv_expression_4_0= ruleXExpression )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3105:3: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCatchClause7423);
            lv_expression_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_4_0, 
                      		"XExpression");
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
    // $ANTLR end "ruleXCatchClause"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3129:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3130:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3131:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName7460);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName7471); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3138:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3141:28: ( (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3142:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3142:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3143:5: this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName7518);
            this_ValidID_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ValidID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3153:1: ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==19) ) {
                    int LA52_2 = input.LA(2);

                    if ( (LA52_2==RULE_ID) ) {
                        int LA52_3 = input.LA(3);

                        if ( (synpred20_InternalSGen()) ) {
                            alt52=1;
                        }


                    }


                }


                switch (alt52) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3153:2: ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3153:2: ( ( '.' )=>kw= '.' )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3153:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,19,FOLLOW_19_in_ruleQualifiedName7546); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName7569);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop52;
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleJvmTypeReference"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3180:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3181:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3182:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference7616);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference7626); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmTypeReference"


    // $ANTLR start "ruleJvmTypeReference"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3189:1: ruleJvmTypeReference returns [EObject current=null] : (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_1 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3192:28: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3193:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3193:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID) ) {
                alt53=1;
            }
            else if ( (LA53_0==43||LA53_0==58) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3194:5: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference7673);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmParameterizedTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3204:5: this_XFunctionTypeRef_1= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference7700);
                    this_XFunctionTypeRef_1=ruleXFunctionTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFunctionTypeRef_1; 
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
    // $ANTLR end "ruleJvmTypeReference"


    // $ANTLR start "entryRuleXFunctionTypeRef"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3220:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3221:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3222:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef7735);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef7745); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXFunctionTypeRef"


    // $ANTLR start "ruleXFunctionTypeRef"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3229:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_paramTypes_1_0 = null;

        EObject lv_paramTypes_3_0 = null;

        EObject lv_returnType_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3232:28: ( ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3233:1: ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3233:1: ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3233:2: (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3233:2: (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==43) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3233:4: otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,43,FOLLOW_43_in_ruleXFunctionTypeRef7783); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3237:1: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3238:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3238:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3239:3: lv_paramTypes_1_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef7804);
                    lv_paramTypes_1_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
                      	        }
                             		add(
                             			current, 
                             			"paramTypes",
                              		lv_paramTypes_1_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3255:2: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==42) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3255:4: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                    	    {
                    	    otherlv_2=(Token)match(input,42,FOLLOW_42_in_ruleXFunctionTypeRef7817); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_2_0());
                    	          
                    	    }
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3259:1: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3260:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                    	    {
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3260:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3261:3: lv_paramTypes_3_0= ruleJvmTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef7838);
                    	    lv_paramTypes_3_0=ruleJvmTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"paramTypes",
                    	              		lv_paramTypes_3_0, 
                    	              		"JvmTypeReference");
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

                    otherlv_4=(Token)match(input,44,FOLLOW_44_in_ruleXFunctionTypeRef7852); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_3());
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,58,FOLLOW_58_in_ruleXFunctionTypeRef7866); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3285:1: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3286:1: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3286:1: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3287:3: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef7887);
            lv_returnType_6_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
              	        }
                     		set(
                     			current, 
                     			"returnType",
                      		lv_returnType_6_0, 
                      		"JvmTypeReference");
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
    // $ANTLR end "ruleXFunctionTypeRef"


    // $ANTLR start "entryRuleJvmParameterizedTypeReference"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3311:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3312:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3313:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference7923);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference7933); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmParameterizedTypeReference"


    // $ANTLR start "ruleJvmParameterizedTypeReference"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3320:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3323:28: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3324:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3324:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3324:2: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3324:2: ( ( ruleQualifiedName ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3325:1: ( ruleQualifiedName )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3325:1: ( ruleQualifiedName )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3326:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference7981);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3339:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt57=2;
            alt57 = dfa57.predict(input);
            switch (alt57) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3339:3: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3339:3: ( ( '<' )=>otherlv_1= '<' )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3339:4: ( '<' )=>otherlv_1= '<'
                    {
                    otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleJvmParameterizedTypeReference8002); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
                          
                    }

                    }

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3344:2: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3345:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3345:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3346:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference8024);
                    lv_arguments_2_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_2_0, 
                              		"JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3362:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==42) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3362:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,42,FOLLOW_42_in_ruleJvmParameterizedTypeReference8037); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3366:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3367:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3367:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3368:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference8058);
                    	    lv_arguments_4_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"arguments",
                    	              		lv_arguments_4_0, 
                    	              		"JvmArgumentTypeReference");
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

                    otherlv_5=(Token)match(input,28,FOLLOW_28_in_ruleJvmParameterizedTypeReference8072); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3());
                          
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
    // $ANTLR end "ruleJvmParameterizedTypeReference"


    // $ANTLR start "entryRuleJvmArgumentTypeReference"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3396:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3397:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3398:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference8110);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference8120); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmArgumentTypeReference"


    // $ANTLR start "ruleJvmArgumentTypeReference"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3405:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3408:28: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3409:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3409:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_ID||LA58_0==43||LA58_0==58) ) {
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3410:5: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference8167);
                    this_JvmTypeReference_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3420:5: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference8194);
                    this_JvmWildcardTypeReference_1=ruleJvmWildcardTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmWildcardTypeReference_1; 
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
    // $ANTLR end "ruleJvmArgumentTypeReference"


    // $ANTLR start "entryRuleJvmWildcardTypeReference"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3436:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3437:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3438:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference8229);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference8239); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmWildcardTypeReference"


    // $ANTLR start "ruleJvmWildcardTypeReference"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3445:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3448:28: ( ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3449:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3449:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3449:2: () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3449:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3450:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,59,FOLLOW_59_in_ruleJvmWildcardTypeReference8285); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3459:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt59=3;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==60) ) {
                alt59=1;
            }
            else if ( (LA59_0==52) ) {
                alt59=2;
            }
            switch (alt59) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3459:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3459:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3460:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3460:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3461:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference8307);
                    lv_constraints_2_0=ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"constraints",
                              		lv_constraints_2_0, 
                              		"JvmUpperBound");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3478:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3478:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3479:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3479:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3480:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference8334);
                    lv_constraints_3_0=ruleJvmLowerBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"constraints",
                              		lv_constraints_3_0, 
                              		"JvmLowerBound");
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
    // $ANTLR end "ruleJvmWildcardTypeReference"


    // $ANTLR start "entryRuleJvmUpperBound"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3504:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3505:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3506:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound8372);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound8382); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmUpperBound"


    // $ANTLR start "ruleJvmUpperBound"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3513:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3516:28: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3517:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3517:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3517:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleJvmUpperBound8419); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3521:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3522:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3522:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3523:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound8440);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmUpperBoundRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
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
    // $ANTLR end "ruleJvmUpperBound"


    // $ANTLR start "entryRuleJvmUpperBoundAnded"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3547:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3548:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3549:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded8476);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded8486); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmUpperBoundAnded"


    // $ANTLR start "ruleJvmUpperBoundAnded"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3556:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3559:28: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3560:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3560:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3560:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,61,FOLLOW_61_in_ruleJvmUpperBoundAnded8523); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3564:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3565:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3565:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3566:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded8544);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmUpperBoundAndedRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
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
    // $ANTLR end "ruleJvmUpperBoundAnded"


    // $ANTLR start "entryRuleJvmLowerBound"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3590:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3591:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3592:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound8580);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound8590); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmLowerBound"


    // $ANTLR start "ruleJvmLowerBound"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3599:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3602:28: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3603:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3603:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3603:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleJvmLowerBound8627); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3607:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3608:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3608:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3609:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound8648);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmLowerBoundRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
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
    // $ANTLR end "ruleJvmLowerBound"


    // $ANTLR start "entryRuleValidID"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3635:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3636:2: (iv_ruleValidID= ruleValidID EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3637:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID8687);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID8698); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3644:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3647:28: (this_ID_0= RULE_ID )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3648:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID8737); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleValidID"

    // $ANTLR start synpred1_InternalSGen
    public final void synpred1_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:534:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:534:4: ( () ( ( ruleOpMultiAssign ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:534:4: ( () ( ( ruleOpMultiAssign ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:534:5: () ( ( ruleOpMultiAssign ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:534:5: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:535:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:535:2: ( ( ruleOpMultiAssign ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:536:1: ( ruleOpMultiAssign )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:536:1: ( ruleOpMultiAssign )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:537:3: ruleOpMultiAssign
        {
        pushFollow(FOLLOW_ruleOpMultiAssign_in_synpred1_InternalSGen1222);
        ruleOpMultiAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalSGen

    // $ANTLR start synpred2_InternalSGen
    public final void synpred2_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:662:3: ( ( () ( ( ruleOpOr ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:662:4: ( () ( ( ruleOpOr ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:662:4: ( () ( ( ruleOpOr ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:662:5: () ( ( ruleOpOr ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:662:5: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:663:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:663:2: ( ( ruleOpOr ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:664:1: ( ruleOpOr )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:664:1: ( ruleOpOr )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:665:3: ruleOpOr
        {
        pushFollow(FOLLOW_ruleOpOr_in_synpred2_InternalSGen1570);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalSGen

    // $ANTLR start synpred3_InternalSGen
    public final void synpred3_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:763:3: ( ( () ( ( ruleOpAnd ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:763:4: ( () ( ( ruleOpAnd ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:763:4: ( () ( ( ruleOpAnd ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:763:5: () ( ( ruleOpAnd ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:763:5: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:764:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:764:2: ( ( ruleOpAnd ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:765:1: ( ruleOpAnd )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:765:1: ( ruleOpAnd )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:766:3: ruleOpAnd
        {
        pushFollow(FOLLOW_ruleOpAnd_in_synpred3_InternalSGen1829);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalSGen

    // $ANTLR start synpred4_InternalSGen
    public final void synpred4_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:864:3: ( ( () ( ( ruleOpEquality ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:864:4: ( () ( ( ruleOpEquality ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:864:4: ( () ( ( ruleOpEquality ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:864:5: () ( ( ruleOpEquality ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:864:5: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:865:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:865:2: ( ( ruleOpEquality ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:866:1: ( ruleOpEquality )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:866:1: ( ruleOpEquality )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:867:3: ruleOpEquality
        {
        pushFollow(FOLLOW_ruleOpEquality_in_synpred4_InternalSGen2088);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalSGen

    // $ANTLR start synpred5_InternalSGen
    public final void synpred5_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:972:4: ( ( () 'instanceof' ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:972:5: ( () 'instanceof' )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:972:5: ( () 'instanceof' )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:972:6: () 'instanceof'
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:972:6: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:973:1: 
        {
        }

        match(input,25,FOLLOW_25_in_synpred5_InternalSGen2364); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalSGen

    // $ANTLR start synpred6_InternalSGen
    public final void synpred6_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1000:8: ( ( () ( ( ruleOpCompare ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1000:9: ( () ( ( ruleOpCompare ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1000:9: ( () ( ( ruleOpCompare ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1000:10: () ( ( ruleOpCompare ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1000:10: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1001:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1001:2: ( ( ruleOpCompare ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1002:1: ( ruleOpCompare )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1002:1: ( ruleOpCompare )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1003:3: ruleOpCompare
        {
        pushFollow(FOLLOW_ruleOpCompare_in_synpred6_InternalSGen2437);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred6_InternalSGen

    // $ANTLR start synpred7_InternalSGen
    public final void synpred7_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1122:3: ( ( () ( ( ruleOpOther ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1122:4: ( () ( ( ruleOpOther ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1122:4: ( () ( ( ruleOpOther ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1122:5: () ( ( ruleOpOther ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1122:5: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1123:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1123:2: ( ( ruleOpOther ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1124:1: ( ruleOpOther )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1124:1: ( ruleOpOther )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1125:3: ruleOpOther
        {
        pushFollow(FOLLOW_ruleOpOther_in_synpred7_InternalSGen2756);
        ruleOpOther();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalSGen

    // $ANTLR start synpred8_InternalSGen
    public final void synpred8_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1230:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1230:4: ( () ( ( ruleOpAdd ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1230:4: ( () ( ( ruleOpAdd ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1230:5: () ( ( ruleOpAdd ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1230:5: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1231:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1231:2: ( ( ruleOpAdd ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1232:1: ( ruleOpAdd )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1232:1: ( ruleOpAdd )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1233:3: ruleOpAdd
        {
        pushFollow(FOLLOW_ruleOpAdd_in_synpred8_InternalSGen3036);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalSGen

    // $ANTLR start synpred9_InternalSGen
    public final void synpred9_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1338:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1338:4: ( () ( ( ruleOpMulti ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1338:4: ( () ( ( ruleOpMulti ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1338:5: () ( ( ruleOpMulti ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1338:5: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1339:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1339:2: ( ( ruleOpMulti ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1340:1: ( ruleOpMulti )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1340:1: ( ruleOpMulti )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1341:3: ruleOpMulti
        {
        pushFollow(FOLLOW_ruleOpMulti_in_synpred9_InternalSGen3316);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalSGen

    // $ANTLR start synpred10_InternalSGen
    public final void synpred10_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1571:3: ( ( () 'as' ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1571:4: ( () 'as' )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1571:4: ( () 'as' )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1571:5: () 'as'
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1571:5: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1572:1: 
        {
        }

        match(input,39,FOLLOW_39_in_synpred10_InternalSGen3910); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred10_InternalSGen

    // $ANTLR start synpred11_InternalSGen
    public final void synpred11_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1631:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1631:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1631:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1631:6: () '.' ( ( ruleValidID ) ) ruleOpSingleAssign
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1631:6: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1632:1: 
        {
        }

        match(input,19,FOLLOW_19_in_synpred11_InternalSGen4064); if (state.failed) return ;
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1633:1: ( ( ruleValidID ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1634:1: ( ruleValidID )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1634:1: ( ruleValidID )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1635:3: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred11_InternalSGen4073);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        pushFollow(FOLLOW_ruleOpSingleAssign_in_synpred11_InternalSGen4079);
        ruleOpSingleAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_InternalSGen

    // $ANTLR start synpred12_InternalSGen
    public final void synpred12_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1689:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1689:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1689:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1689:10: () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1689:10: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1690:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1690:2: ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        int alt60=3;
        switch ( input.LA(1) ) {
        case 19:
            {
            alt60=1;
            }
            break;
        case 40:
            {
            alt60=2;
            }
            break;
        case 41:
            {
            alt60=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 60, 0, input);

            throw nvae;
        }

        switch (alt60) {
            case 1 :
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1690:4: '.'
                {
                match(input,19,FOLLOW_19_in_synpred12_InternalSGen4182); if (state.failed) return ;

                }
                break;
            case 2 :
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1692:6: ( ( '?.' ) )
                {
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1692:6: ( ( '?.' ) )
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1693:1: ( '?.' )
                {
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1693:1: ( '?.' )
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1694:2: '?.'
                {
                match(input,40,FOLLOW_40_in_synpred12_InternalSGen4196); if (state.failed) return ;

                }


                }


                }
                break;
            case 3 :
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1699:6: ( ( '*.' ) )
                {
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1699:6: ( ( '*.' ) )
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1700:1: ( '*.' )
                {
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1700:1: ( '*.' )
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1701:2: '*.'
                {
                match(input,41,FOLLOW_41_in_synpred12_InternalSGen4216); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred12_InternalSGen

    // $ANTLR start synpred13_InternalSGen
    public final void synpred13_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1810:4: ( ( '(' ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1811:1: ( '(' )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1811:1: ( '(' )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1812:2: '('
        {
        match(input,43,FOLLOW_43_in_synpred13_InternalSGen4443); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalSGen

    // $ANTLR start synpred14_InternalSGen
    public final void synpred14_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1831:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1831:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1831:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1831:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|'
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1831:6: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1832:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1832:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt62=2;
        int LA62_0 = input.LA(1);

        if ( (LA62_0==RULE_ID||LA62_0==43||LA62_0==58) ) {
            alt62=1;
        }
        switch (alt62) {
            case 1 :
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1832:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1832:3: ( ( ruleJvmFormalParameter ) )
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1833:1: ( ruleJvmFormalParameter )
                {
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1833:1: ( ruleJvmFormalParameter )
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1834:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalSGen4495);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1836:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop61:
                do {
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==42) ) {
                        alt61=1;
                    }


                    switch (alt61) {
                	case 1 :
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1836:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,42,FOLLOW_42_in_synpred14_InternalSGen4502); if (state.failed) return ;
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1837:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1838:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1838:1: ( ruleJvmFormalParameter )
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1839:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalSGen4509);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop61;
                    }
                } while (true);


                }
                break;

        }

        match(input,46,FOLLOW_46_in_synpred14_InternalSGen4519); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_InternalSGen

    // $ANTLR start synpred16_InternalSGen
    public final void synpred16_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2402:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2402:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2402:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2402:6: ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2402:6: ( ( ruleJvmTypeReference ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2403:1: ( ruleJvmTypeReference )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2403:1: ( ruleJvmTypeReference )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2404:1: ruleJvmTypeReference
        {
        pushFollow(FOLLOW_ruleJvmTypeReference_in_synpred16_InternalSGen5818);
        ruleJvmTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2406:2: ( ( ruleValidID ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2407:1: ( ruleValidID )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2407:1: ( ruleValidID )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2408:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred16_InternalSGen5827);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred16_InternalSGen

    // $ANTLR start synpred17_InternalSGen
    public final void synpred17_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2649:4: ( ( '(' ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2650:1: ( '(' )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2650:1: ( '(' )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2651:2: '('
        {
        match(input,43,FOLLOW_43_in_synpred17_InternalSGen6276); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred17_InternalSGen

    // $ANTLR start synpred18_InternalSGen
    public final void synpred18_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2670:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2670:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2670:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2670:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|'
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2670:6: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2671:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2671:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt66=2;
        int LA66_0 = input.LA(1);

        if ( (LA66_0==RULE_ID||LA66_0==43||LA66_0==58) ) {
            alt66=1;
        }
        switch (alt66) {
            case 1 :
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2671:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2671:3: ( ( ruleJvmFormalParameter ) )
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2672:1: ( ruleJvmFormalParameter )
                {
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2672:1: ( ruleJvmFormalParameter )
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2673:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred18_InternalSGen6328);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2675:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop65:
                do {
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==42) ) {
                        alt65=1;
                    }


                    switch (alt65) {
                	case 1 :
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2675:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,42,FOLLOW_42_in_synpred18_InternalSGen6335); if (state.failed) return ;
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2676:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2677:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2677:1: ( ruleJvmFormalParameter )
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2678:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred18_InternalSGen6342);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop65;
                    }
                } while (true);


                }
                break;

        }

        match(input,46,FOLLOW_46_in_synpred18_InternalSGen6352); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred18_InternalSGen

    // $ANTLR start synpred20_InternalSGen
    public final void synpred20_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3153:3: ( '.' )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3154:2: '.'
        {
        match(input,19,FOLLOW_19_in_synpred20_InternalSGen7537); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_InternalSGen

    // $ANTLR start synpred21_InternalSGen
    public final void synpred21_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3339:4: ( '<' )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3339:6: '<'
        {
        match(input,29,FOLLOW_29_in_synpred21_InternalSGen7994); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_InternalSGen

    // Delegated rules

    public final boolean synpred18_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalSGen_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalSGen_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalSGen_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalSGen_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalSGen_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalSGen_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalSGen_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalSGen_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalSGen_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalSGen_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalSGen_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalSGen_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalSGen_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalSGen_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalSGen_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalSGen_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalSGen_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalSGen_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalSGen_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA28 dfa28 = new DFA28(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA57 dfa57 = new DFA57(this);
    static final String DFA28_eotS =
        "\22\uffff";
    static final String DFA28_eofS =
        "\22\uffff";
    static final String DFA28_minS =
        "\1\4\2\0\17\uffff";
    static final String DFA28_maxS =
        "\1\72\2\0\17\uffff";
    static final String DFA28_acceptS =
        "\3\uffff\2\1\1\2\13\uffff\1\3";
    static final String DFA28_specialS =
        "\1\0\1\1\1\2\17\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\1\2\5\26\uffff\1\5\2\uffff\2\5\4\uffff\1\5\4\uffff\1\2\1"+
            "\21\1\5\1\4\5\uffff\5\5\1\uffff\1\3",
            "\1\uffff",
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
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "1831:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_0 = input.LA(1);

                         
                        int index28_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA28_0==RULE_ID) ) {s = 1;}

                        else if ( (LA28_0==43) ) {s = 2;}

                        else if ( (LA28_0==58) && (synpred14_InternalSGen())) {s = 3;}

                        else if ( (LA28_0==46) && (synpred14_InternalSGen())) {s = 4;}

                        else if ( ((LA28_0>=RULE_INT && LA28_0<=RULE_STRING)||LA28_0==29||(LA28_0>=32 && LA28_0<=33)||LA28_0==38||LA28_0==45||(LA28_0>=52 && LA28_0<=56)) ) {s = 5;}

                        else if ( (LA28_0==44) ) {s = 17;}

                         
                        input.seek(index28_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA28_1 = input.LA(1);

                         
                        int index28_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalSGen()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index28_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA28_2 = input.LA(1);

                         
                        int index28_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalSGen()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index28_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 28, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA47_eotS =
        "\22\uffff";
    static final String DFA47_eofS =
        "\22\uffff";
    static final String DFA47_minS =
        "\1\4\2\0\17\uffff";
    static final String DFA47_maxS =
        "\1\72\2\0\17\uffff";
    static final String DFA47_acceptS =
        "\3\uffff\2\1\1\2\13\uffff\1\3";
    static final String DFA47_specialS =
        "\1\0\1\1\1\2\17\uffff}>";
    static final String[] DFA47_transitionS = {
            "\1\1\2\5\26\uffff\1\5\2\uffff\2\5\4\uffff\1\5\4\uffff\1\2\1"+
            "\21\1\5\1\4\5\uffff\5\5\1\uffff\1\3",
            "\1\uffff",
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
            ""
    };

    static final short[] DFA47_eot = DFA.unpackEncodedString(DFA47_eotS);
    static final short[] DFA47_eof = DFA.unpackEncodedString(DFA47_eofS);
    static final char[] DFA47_min = DFA.unpackEncodedStringToUnsignedChars(DFA47_minS);
    static final char[] DFA47_max = DFA.unpackEncodedStringToUnsignedChars(DFA47_maxS);
    static final short[] DFA47_accept = DFA.unpackEncodedString(DFA47_acceptS);
    static final short[] DFA47_special = DFA.unpackEncodedString(DFA47_specialS);
    static final short[][] DFA47_transition;

    static {
        int numStates = DFA47_transitionS.length;
        DFA47_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA47_transition[i] = DFA.unpackEncodedString(DFA47_transitionS[i]);
        }
    }

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = DFA47_eot;
            this.eof = DFA47_eof;
            this.min = DFA47_min;
            this.max = DFA47_max;
            this.accept = DFA47_accept;
            this.special = DFA47_special;
            this.transition = DFA47_transition;
        }
        public String getDescription() {
            return "2670:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA47_0 = input.LA(1);

                         
                        int index47_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA47_0==RULE_ID) ) {s = 1;}

                        else if ( (LA47_0==43) ) {s = 2;}

                        else if ( (LA47_0==58) && (synpred18_InternalSGen())) {s = 3;}

                        else if ( (LA47_0==46) && (synpred18_InternalSGen())) {s = 4;}

                        else if ( ((LA47_0>=RULE_INT && LA47_0<=RULE_STRING)||LA47_0==29||(LA47_0>=32 && LA47_0<=33)||LA47_0==38||LA47_0==45||(LA47_0>=52 && LA47_0<=56)) ) {s = 5;}

                        else if ( (LA47_0==44) ) {s = 17;}

                         
                        input.seek(index47_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA47_1 = input.LA(1);

                         
                        int index47_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalSGen()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index47_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA47_2 = input.LA(1);

                         
                        int index47_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalSGen()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index47_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 47, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA57_eotS =
        "\40\uffff";
    static final String DFA57_eofS =
        "\1\2\37\uffff";
    static final String DFA57_minS =
        "\1\4\1\0\36\uffff";
    static final String DFA57_maxS =
        "\1\61\1\0\36\uffff";
    static final String DFA57_acceptS =
        "\2\uffff\1\2\34\uffff\1\1";
    static final String DFA57_specialS =
        "\1\uffff\1\0\36\uffff}>";
    static final String[] DFA57_transitionS = {
            "\1\2\11\uffff\1\2\4\uffff\12\2\1\1\10\2\1\uffff\4\2\1\uffff"+
            "\1\2\2\uffff\3\2",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA57_eot = DFA.unpackEncodedString(DFA57_eotS);
    static final short[] DFA57_eof = DFA.unpackEncodedString(DFA57_eofS);
    static final char[] DFA57_min = DFA.unpackEncodedStringToUnsignedChars(DFA57_minS);
    static final char[] DFA57_max = DFA.unpackEncodedStringToUnsignedChars(DFA57_maxS);
    static final short[] DFA57_accept = DFA.unpackEncodedString(DFA57_acceptS);
    static final short[] DFA57_special = DFA.unpackEncodedString(DFA57_specialS);
    static final short[][] DFA57_transition;

    static {
        int numStates = DFA57_transitionS.length;
        DFA57_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA57_transition[i] = DFA.unpackEncodedString(DFA57_transitionS[i]);
        }
    }

    class DFA57 extends DFA {

        public DFA57(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 57;
            this.eot = DFA57_eot;
            this.eof = DFA57_eof;
            this.min = DFA57_min;
            this.max = DFA57_max;
            this.accept = DFA57_accept;
            this.special = DFA57_special;
            this.transition = DFA57_transition;
        }
        public String getDescription() {
            return "3339:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA57_1 = input.LA(1);

                         
                        int index57_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 31;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index57_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 57, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleGeneratorModel_in_entryRuleGeneratorModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneratorModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleGeneratorModel122 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleGeneratorModel134 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQID_in_ruleGeneratorModel155 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleGeneratorModel167 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ruleGeneratorEntry_in_ruleGeneratorModel188 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleGeneratorModel201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratorEntry_in_entryRuleGeneratorEntry237 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneratorEntry247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleGeneratorEntry284 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratorEntry304 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleGeneratorEntry316 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_ruleFeatureConfiguration_in_ruleGeneratorEntry337 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_14_in_ruleGeneratorEntry350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureConfiguration_in_entryRuleFeatureConfiguration386 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureConfiguration396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleFeatureConfiguration442 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureConfiguration462 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleFeatureConfiguration474 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFeatureParameterValue_in_ruleFeatureConfiguration495 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleFeatureConfiguration508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureParameterValue_in_entryRuleFeatureParameterValue544 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureParameterValue554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureParameterValue608 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleFeatureParameterValue620 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleFeatureParameterValue641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression677 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_entryRuleQID824 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQID835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID875 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_18_in_ruleQID895 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_19_in_ruleQID914 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID930 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression977 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment1067 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment1077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXAssignment1135 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXAssignment1151 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment1171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment1201 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_ruleXAssignment1254 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign1317 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpSingleAssign1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleOpSingleAssign1365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign1405 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMultiAssign1416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleOpMultiAssign1453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1492 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression1502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1549 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression1602 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1625 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr1664 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr1675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleOpOr1712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression1751 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression1761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1808 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression1861 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1884 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd1923 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd1934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOpAnd1971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression2010 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression2020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2067 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression2120 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2143 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality2182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality2193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOpEquality2231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleOpEquality2250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression2290 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression2300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2347 = new BitSet(new long[]{0x000000003E000002L});
    public static final BitSet FOLLOW_25_in_ruleXRelationalExpression2383 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression2408 = new BitSet(new long[]{0x000000003E000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2469 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2492 = new BitSet(new long[]{0x000000003E000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare2532 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare2543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOpCompare2581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOpCompare2600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpCompare2619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpCompare2638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression2678 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression2688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2735 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression2788 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2811 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther2850 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther2861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpOther2899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOpOther2918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression2958 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression2968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3015 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression3068 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3091 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd3130 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd3141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOpAdd3179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpAdd3198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression3238 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression3248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3295 = new BitSet(new long[]{0x0000003C00000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3348 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3371 = new BitSet(new long[]{0x0000003C00000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti3410 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti3421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOpMulti3459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOpMulti3478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOpMulti3497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleOpMulti3516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3556 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation3566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3624 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary3710 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary3721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpUnary3759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpUnary3778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOpUnary3797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression3837 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression3847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression3894 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ruleXCastedExpression3929 = new BitSet(new long[]{0x0400080000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression3952 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall3990 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall4000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall4047 = new BitSet(new long[]{0x0000030000080002L});
    public static final BitSet FOLLOW_19_in_ruleXMemberFeatureCall4096 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4119 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall4135 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall4157 = new BitSet(new long[]{0x0000030000080002L});
    public static final BitSet FOLLOW_19_in_ruleXMemberFeatureCall4243 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_40_in_ruleXMemberFeatureCall4267 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_41_in_ruleXMemberFeatureCall4304 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_29_in_ruleXMemberFeatureCall4333 = new BitSet(new long[]{0x0C00080000000010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4354 = new BitSet(new long[]{0x0000040010000000L});
    public static final BitSet FOLLOW_42_in_ruleXMemberFeatureCall4367 = new BitSet(new long[]{0x0C00080000000010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4388 = new BitSet(new long[]{0x0000040010000000L});
    public static final BitSet FOLLOW_28_in_ruleXMemberFeatureCall4402 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4427 = new BitSet(new long[]{0x00000B0000080002L});
    public static final BitSet FOLLOW_43_in_ruleXMemberFeatureCall4461 = new BitSet(new long[]{0x05F0784320000070L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4536 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4564 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_42_in_ruleXMemberFeatureCall4577 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4598 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_44_in_ruleXMemberFeatureCall4615 = new BitSet(new long[]{0x0000030000080002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_entryRuleXLiteral4656 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXLiteral4666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXLiteral4713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral4740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_ruleXLiteral4767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXLiteral4794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXLiteral4821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXLiteral4848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure4883 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure4893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleXClosure4939 = new BitSet(new long[]{0x0400480000000010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure4961 = new BitSet(new long[]{0x0000440000000000L});
    public static final BitSet FOLLOW_42_in_ruleXClosure4974 = new BitSet(new long[]{0x0400080000000010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure4995 = new BitSet(new long[]{0x0000440000000000L});
    public static final BitSet FOLLOW_46_in_ruleXClosure5011 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXClosure5032 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXClosure5044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5080 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXShortClosure5090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5188 = new BitSet(new long[]{0x0000440000000000L});
    public static final BitSet FOLLOW_42_in_ruleXShortClosure5201 = new BitSet(new long[]{0x0400080000000010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5222 = new BitSet(new long[]{0x0000440000000000L});
    public static final BitSet FOLLOW_46_in_ruleXShortClosure5238 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXShortClosure5261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression5297 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression5307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleXParenthesizedExpression5344 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression5366 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXParenthesizedExpression5377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart5417 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart5427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart5473 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXCasePart5487 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart5508 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleXCasePart5522 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart5543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock5587 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock5597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock5644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock5671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration5706 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration5716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleXVariableDeclaration5769 = new BitSet(new long[]{0x0400080000000010L});
    public static final BitSet FOLLOW_51_in_ruleXVariableDeclaration5800 = new BitSet(new long[]{0x0400080000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration5848 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration5869 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration5898 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleXVariableDeclaration5912 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration5933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter5971 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter5981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter6027 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmFormalParameter6049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall6085 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall6095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall6152 = new BitSet(new long[]{0x0010000020000010L});
    public static final BitSet FOLLOW_29_in_ruleXFeatureCall6166 = new BitSet(new long[]{0x0C00080000000010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall6187 = new BitSet(new long[]{0x0000040010000000L});
    public static final BitSet FOLLOW_42_in_ruleXFeatureCall6200 = new BitSet(new long[]{0x0C00080000000010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall6221 = new BitSet(new long[]{0x0000040010000000L});
    public static final BitSet FOLLOW_28_in_ruleXFeatureCall6235 = new BitSet(new long[]{0x0010000020000010L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall6260 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleXFeatureCall6294 = new BitSet(new long[]{0x05F0784320000070L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXFeatureCall6369 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall6397 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_42_in_ruleXFeatureCall6410 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall6431 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_44_in_ruleXFeatureCall6448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper6487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdOrSuper6498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleIdOrSuper6545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleIdOrSuper6569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier6610 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStaticQualifier6621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleStaticQualifier6668 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleStaticQualifier6686 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral6729 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral6739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleXBooleanLiteral6786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleXBooleanLiteral6810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral6860 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral6870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleXNullLiteral6916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral6952 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIntLiteral6962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleXIntLiteral7013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral7054 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral7064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXStringLiteral7115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral7156 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral7166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleXTypeLiteral7212 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXTypeLiteral7224 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral7247 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXTypeLiteral7259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause7301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause7311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleXCatchClause7356 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXCatchClause7369 = new BitSet(new long[]{0x0400080000000010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause7390 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXCatchClause7402 = new BitSet(new long[]{0x01F0284320000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause7423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName7460 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName7471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName7518 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleQualifiedName7546 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName7569 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference7616 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference7626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference7673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference7700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef7735 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef7745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleXFunctionTypeRef7783 = new BitSet(new long[]{0x0400080000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef7804 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_42_in_ruleXFunctionTypeRef7817 = new BitSet(new long[]{0x0400080000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef7838 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_44_in_ruleXFunctionTypeRef7852 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleXFunctionTypeRef7866 = new BitSet(new long[]{0x0400080000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef7887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference7923 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference7933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference7981 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleJvmParameterizedTypeReference8002 = new BitSet(new long[]{0x0C00080000000010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference8024 = new BitSet(new long[]{0x0000040010000000L});
    public static final BitSet FOLLOW_42_in_ruleJvmParameterizedTypeReference8037 = new BitSet(new long[]{0x0C00080000000010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference8058 = new BitSet(new long[]{0x0000040010000000L});
    public static final BitSet FOLLOW_28_in_ruleJvmParameterizedTypeReference8072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference8110 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference8120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference8167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference8194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference8229 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference8239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleJvmWildcardTypeReference8285 = new BitSet(new long[]{0x1010000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference8307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference8334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound8372 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound8382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleJvmUpperBound8419 = new BitSet(new long[]{0x0400080000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound8440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded8476 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded8486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleJvmUpperBoundAnded8523 = new BitSet(new long[]{0x0400080000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded8544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound8580 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound8590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleJvmLowerBound8627 = new BitSet(new long[]{0x0400080000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound8648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID8687 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID8698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID8737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_synpred1_InternalSGen1222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred2_InternalSGen1570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred3_InternalSGen1829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred4_InternalSGen2088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_synpred5_InternalSGen2364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred6_InternalSGen2437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred7_InternalSGen2756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred8_InternalSGen3036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred9_InternalSGen3316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred10_InternalSGen3910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_synpred11_InternalSGen4064 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred11_InternalSGen4073 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_synpred11_InternalSGen4079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_synpred12_InternalSGen4182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_synpred12_InternalSGen4196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred12_InternalSGen4216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_synpred13_InternalSGen4443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalSGen4495 = new BitSet(new long[]{0x0000440000000000L});
    public static final BitSet FOLLOW_42_in_synpred14_InternalSGen4502 = new BitSet(new long[]{0x0400080000000010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalSGen4509 = new BitSet(new long[]{0x0000440000000000L});
    public static final BitSet FOLLOW_46_in_synpred14_InternalSGen4519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred16_InternalSGen5818 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred16_InternalSGen5827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_synpred17_InternalSGen6276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred18_InternalSGen6328 = new BitSet(new long[]{0x0000440000000000L});
    public static final BitSet FOLLOW_42_in_synpred18_InternalSGen6335 = new BitSet(new long[]{0x0400080000000010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred18_InternalSGen6342 = new BitSet(new long[]{0x0000440000000000L});
    public static final BitSet FOLLOW_46_in_synpred18_InternalSGen6352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_synpred20_InternalSGen7537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred21_InternalSGen7994 = new BitSet(new long[]{0x0000000000000002L});

}