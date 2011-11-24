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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'GeneratorModel'", "'for'", "'{'", "'}'", "'statechart'", "'feature'", "'='", "'::'", "'.'", "'+='", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'>'", "'<'", "'->'", "'..'", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'as'", "'?.'", "'*.'", "','", "'('", "')'", "'['", "'|'", "']'", "'if'", "'else'", "'switch'", "':'", "'default'", "'case'", "'while'", "'do'", "';'", "'var'", "'val'", "'super'", "'new'", "'false'", "'true'", "'null'", "'typeof'", "'throw'", "'return'", "'try'", "'finally'", "'catch'", "'=>'", "'?'", "'extends'", "'&'"
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
    public static final int RULE_WS=9;
    public static final int T__73=73;

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:283:1: ruleFeatureParameterValue returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleXLiteral ) ) ) ;
    public final EObject ruleFeatureParameterValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:286:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleXLiteral ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:287:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleXLiteral ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:287:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleXLiteral ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:287:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleXLiteral ) )
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
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:310:1: ( (lv_expression_3_0= ruleXLiteral ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:311:1: (lv_expression_3_0= ruleXLiteral )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:311:1: (lv_expression_3_0= ruleXLiteral )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:312:3: lv_expression_3_0= ruleXLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFeatureParameterValueAccess().getExpressionXLiteralParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXLiteral_in_ruleFeatureParameterValue641);
            lv_expression_3_0=ruleXLiteral();

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
                      		"XLiteral");
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


    // $ANTLR start "entryRuleQID"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:336:1: entryRuleQID returns [String current=null] : iv_ruleQID= ruleQID EOF ;
    public final String entryRuleQID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQID = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:337:2: (iv_ruleQID= ruleQID EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:338:2: iv_ruleQID= ruleQID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQIDRule()); 
            }
            pushFollow(FOLLOW_ruleQID_in_entryRuleQID678);
            iv_ruleQID=ruleQID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQID689); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:345:1: ruleQID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( (kw= '::' | kw= '.' ) this_ID_3= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_3=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:348:28: ( (this_ID_0= RULE_ID ( (kw= '::' | kw= '.' ) this_ID_3= RULE_ID )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:349:1: (this_ID_0= RULE_ID ( (kw= '::' | kw= '.' ) this_ID_3= RULE_ID )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:349:1: (this_ID_0= RULE_ID ( (kw= '::' | kw= '.' ) this_ID_3= RULE_ID )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:349:6: this_ID_0= RULE_ID ( (kw= '::' | kw= '.' ) this_ID_3= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID729); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQIDAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:356:1: ( (kw= '::' | kw= '.' ) this_ID_3= RULE_ID )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=18 && LA5_0<=19)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:356:2: (kw= '::' | kw= '.' ) this_ID_3= RULE_ID
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:356:2: (kw= '::' | kw= '.' )
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==18) ) {
            	        alt4=1;
            	    }
            	    else if ( (LA4_0==19) ) {
            	        alt4=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:357:2: kw= '::'
            	            {
            	            kw=(Token)match(input,18,FOLLOW_18_in_ruleQID749); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getQIDAccess().getColonColonKeyword_1_0_0()); 
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:364:2: kw= '.'
            	            {
            	            kw=(Token)match(input,19,FOLLOW_19_in_ruleQID768); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getQIDAccess().getFullStopKeyword_1_0_1()); 
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID784); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_3);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_3, grammarAccess.getQIDAccess().getIDTerminalRuleCall_1_1()); 
            	          
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
    // $ANTLR end "ruleQID"


    // $ANTLR start "entryRuleXExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:384:1: entryRuleXExpression returns [EObject current=null] : iv_ruleXExpression= ruleXExpression EOF ;
    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:385:2: (iv_ruleXExpression= ruleXExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:386:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXExpression_in_entryRuleXExpression831);
            iv_ruleXExpression=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpression841); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:393:1: ruleXExpression returns [EObject current=null] : this_XAssignment_0= ruleXAssignment ;
    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAssignment_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:396:28: (this_XAssignment_0= ruleXAssignment )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:398:5: this_XAssignment_0= ruleXAssignment
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleXAssignment_in_ruleXExpression887);
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:414:1: entryRuleXAssignment returns [EObject current=null] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAssignment = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:415:2: (iv_ruleXAssignment= ruleXAssignment EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:416:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleXAssignment_in_entryRuleXAssignment921);
            iv_ruleXAssignment=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAssignment931); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:423:1: ruleXAssignment returns [EObject current=null] : ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) ;
    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject lv_value_3_0 = null;

        EObject this_XOrExpression_4 = null;

        EObject lv_rightOperand_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:426:28: ( ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:427:1: ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:427:1: ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==EOF||(LA7_1>=RULE_ID && LA7_1<=RULE_STRING)||(LA7_1>=12 && LA7_1<=14)||(LA7_1>=18 && LA7_1<=45)||(LA7_1>=47 && LA7_1<=70)) ) {
                    alt7=2;
                }
                else if ( (LA7_1==17) ) {
                    alt7=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA7_0>=RULE_INT && LA7_0<=RULE_STRING)||(LA7_0>=12 && LA7_0<=13)||LA7_0==29||(LA7_0>=32 && LA7_0<=33)||LA7_0==38||LA7_0==43||LA7_0==45||LA7_0==48||LA7_0==50||(LA7_0>=54 && LA7_0<=55)||(LA7_0>=59 && LA7_0<=67)) ) {
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:427:2: ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:427:2: ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:427:3: () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:427:3: ()
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:428:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXAssignmentAccess().getXAssignmentAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:433:2: ( ( ruleValidID ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:434:1: ( ruleValidID )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:434:1: ( ruleValidID )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:435:3: ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXAssignmentRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXAssignment989);
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
                    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXAssignment1005);
                    ruleOpSingleAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:456:1: ( (lv_value_3_0= ruleXAssignment ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:457:1: (lv_value_3_0= ruleXAssignment )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:457:1: (lv_value_3_0= ruleXAssignment )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:458:3: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment1025);
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:475:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:475:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:476:5: this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXOrExpression_in_ruleXAssignment1055);
                    this_XOrExpression_4=ruleXOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XOrExpression_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:484:1: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==20) ) {
                        int LA6_1 = input.LA(2);

                        if ( (synpred1_InternalSGen()) ) {
                            alt6=1;
                        }
                    }
                    switch (alt6) {
                        case 1 :
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:484:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:484:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:484:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:489:6: ( () ( ( ruleOpMultiAssign ) ) )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:489:7: () ( ( ruleOpMultiAssign ) )
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:489:7: ()
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:490:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
                                          current);
                                  
                            }

                            }

                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:495:2: ( ( ruleOpMultiAssign ) )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:496:1: ( ruleOpMultiAssign )
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:496:1: ( ruleOpMultiAssign )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:497:3: ruleOpMultiAssign
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getXAssignmentRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleOpMultiAssign_in_ruleXAssignment1108);
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

                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:510:4: ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:511:1: (lv_rightOperand_7_0= ruleXAssignment )
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:511:1: (lv_rightOperand_7_0= ruleXAssignment )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:512:3: lv_rightOperand_7_0= ruleXAssignment
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment1131);
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:536:1: entryRuleOpSingleAssign returns [String current=null] : iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
    public final String entryRuleOpSingleAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpSingleAssign = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:537:2: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:538:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpSingleAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign1171);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSingleAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpSingleAssign1182); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:545:1: ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:548:28: (kw= '=' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:550:2: kw= '='
            {
            kw=(Token)match(input,17,FOLLOW_17_in_ruleOpSingleAssign1219); if (state.failed) return current;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:563:1: entryRuleOpMultiAssign returns [String current=null] : iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
    public final String entryRuleOpMultiAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMultiAssign = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:564:2: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:565:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign1259);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMultiAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMultiAssign1270); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:572:1: ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '+=' ;
    public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:575:28: (kw= '+=' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:577:2: kw= '+='
            {
            kw=(Token)match(input,20,FOLLOW_20_in_ruleOpMultiAssign1307); if (state.failed) return current;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:590:1: entryRuleXOrExpression returns [EObject current=null] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOrExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:591:2: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:592:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1346);
            iv_ruleXOrExpression=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOrExpression1356); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:599:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:602:28: ( (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:603:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:603:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:604:5: this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression1403);
            this_XAndExpression_0=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:612:1: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==21) ) {
                    int LA8_2 = input.LA(2);

                    if ( (synpred2_InternalSGen()) ) {
                        alt8=1;
                    }


                }


                switch (alt8) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:612:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:612:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:612:3: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:617:6: ( () ( ( ruleOpOr ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:617:7: () ( ( ruleOpOr ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:617:7: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:618:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:623:2: ( ( ruleOpOr ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:624:1: ( ruleOpOr )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:624:1: ( ruleOpOr )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:625:3: ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOrExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleXOrExpression1456);
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

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:638:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:639:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:639:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:640:3: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression1479);
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
    // $ANTLR end "ruleXOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:664:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:665:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:666:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr1518);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr1529); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:673:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:676:28: (kw= '||' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:678:2: kw= '||'
            {
            kw=(Token)match(input,21,FOLLOW_21_in_ruleOpOr1566); if (state.failed) return current;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:691:1: entryRuleXAndExpression returns [EObject current=null] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAndExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:692:2: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:693:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression1605);
            iv_ruleXAndExpression=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAndExpression1615); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:700:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XEqualityExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:703:28: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:704:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:704:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:705:5: this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1662);
            this_XEqualityExpression_0=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XEqualityExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:713:1: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==22) ) {
                    int LA9_2 = input.LA(2);

                    if ( (synpred3_InternalSGen()) ) {
                        alt9=1;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:713:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:713:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:713:3: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:718:6: ( () ( ( ruleOpAnd ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:718:7: () ( ( ruleOpAnd ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:718:7: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:719:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:724:2: ( ( ruleOpAnd ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:725:1: ( ruleOpAnd )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:725:1: ( ruleOpAnd )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:726:3: ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAndExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleXAndExpression1715);
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

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:739:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:740:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:740:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:741:3: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1738);
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
    // $ANTLR end "ruleXAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:765:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:766:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:767:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd1777);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd1788); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:774:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:777:28: (kw= '&&' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:779:2: kw= '&&'
            {
            kw=(Token)match(input,22,FOLLOW_22_in_ruleOpAnd1825); if (state.failed) return current;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:792:1: entryRuleXEqualityExpression returns [EObject current=null] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEqualityExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:793:2: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:794:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression1864);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXEqualityExpression1874); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:801:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XRelationalExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:804:28: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:805:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:805:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:806:5: this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1921);
            this_XRelationalExpression_0=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XRelationalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:814:1: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==23) ) {
                    int LA10_2 = input.LA(2);

                    if ( (synpred4_InternalSGen()) ) {
                        alt10=1;
                    }


                }
                else if ( (LA10_0==24) ) {
                    int LA10_3 = input.LA(2);

                    if ( (synpred4_InternalSGen()) ) {
                        alt10=1;
                    }


                }


                switch (alt10) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:814:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:814:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:814:3: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:819:6: ( () ( ( ruleOpEquality ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:819:7: () ( ( ruleOpEquality ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:819:7: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:820:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:825:2: ( ( ruleOpEquality ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:826:1: ( ruleOpEquality )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:826:1: ( ruleOpEquality )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:827:3: ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXEqualityExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleXEqualityExpression1974);
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

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:840:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:841:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:841:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:842:3: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1997);
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
    // $ANTLR end "ruleXEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:866:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:867:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:868:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality2036);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality2047); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:875:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:878:28: ( (kw= '==' | kw= '!=' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:879:1: (kw= '==' | kw= '!=' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:879:1: (kw= '==' | kw= '!=' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            else if ( (LA11_0==24) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:880:2: kw= '=='
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleOpEquality2085); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:887:2: kw= '!='
                    {
                    kw=(Token)match(input,24,FOLLOW_24_in_ruleOpEquality2104); if (state.failed) return current;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:900:1: entryRuleXRelationalExpression returns [EObject current=null] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRelationalExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:901:2: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:902:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression2144);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRelationalExpression2154); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:909:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XOtherOperatorExpression_0 = null;

        EObject lv_rightOperand_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:912:28: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:913:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:913:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:914:5: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2201);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOtherOperatorExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:922:1: ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop12:
            do {
                int alt12=3;
                switch ( input.LA(1) ) {
                case 25:
                    {
                    int LA12_2 = input.LA(2);

                    if ( (synpred5_InternalSGen()) ) {
                        alt12=1;
                    }


                    }
                    break;
                case 26:
                    {
                    int LA12_3 = input.LA(2);

                    if ( (synpred6_InternalSGen()) ) {
                        alt12=2;
                    }


                    }
                    break;
                case 27:
                    {
                    int LA12_4 = input.LA(2);

                    if ( (synpred6_InternalSGen()) ) {
                        alt12=2;
                    }


                    }
                    break;
                case 28:
                    {
                    int LA12_5 = input.LA(2);

                    if ( (synpred6_InternalSGen()) ) {
                        alt12=2;
                    }


                    }
                    break;
                case 29:
                    {
                    int LA12_6 = input.LA(2);

                    if ( (synpred6_InternalSGen()) ) {
                        alt12=2;
                    }


                    }
                    break;

                }

                switch (alt12) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:922:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:922:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:922:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:922:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:922:4: ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:924:5: ( () otherlv_2= 'instanceof' )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:924:6: () otherlv_2= 'instanceof'
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:924:6: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:925:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleXRelationalExpression2237); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:934:3: ( ( ruleQualifiedName ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:935:1: ( ruleQualifiedName )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:935:1: ( ruleQualifiedName )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:936:3: ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeCrossReference_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression2262);
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
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:950:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:950:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:950:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:950:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:950:8: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:955:6: ( () ( ( ruleOpCompare ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:955:7: () ( ( ruleOpCompare ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:955:7: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:956:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:961:2: ( ( ruleOpCompare ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:962:1: ( ruleOpCompare )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:962:1: ( ruleOpCompare )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:963:3: ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2323);
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

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:976:4: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:977:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:977:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:978:3: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2346);
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
    // $ANTLR end "ruleXRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1002:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1003:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1004:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare2386);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare2397); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1011:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1014:28: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1015:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1015:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            int alt13=4;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt13=1;
                }
                break;
            case 27:
                {
                alt13=2;
                }
                break;
            case 28:
                {
                alt13=3;
                }
                break;
            case 29:
                {
                alt13=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1016:2: kw= '>='
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleOpCompare2435); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1023:2: kw= '<='
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleOpCompare2454); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1030:2: kw= '>'
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleOpCompare2473); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1037:2: kw= '<'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleOpCompare2492); if (state.failed) return current;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1050:1: entryRuleXOtherOperatorExpression returns [EObject current=null] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOtherOperatorExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1051:2: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1052:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOtherOperatorExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression2532);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOtherOperatorExpression2542); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1059:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAdditiveExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1062:28: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1063:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1063:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1064:5: this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2589);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAdditiveExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1072:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==30) ) {
                    int LA14_2 = input.LA(2);

                    if ( (synpred7_InternalSGen()) ) {
                        alt14=1;
                    }


                }
                else if ( (LA14_0==31) ) {
                    int LA14_3 = input.LA(2);

                    if ( (synpred7_InternalSGen()) ) {
                        alt14=1;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1072:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1072:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1072:3: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1077:6: ( () ( ( ruleOpOther ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1077:7: () ( ( ruleOpOther ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1077:7: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1078:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1083:2: ( ( ruleOpOther ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1084:1: ( ruleOpOther )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1084:1: ( ruleOpOther )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1085:3: ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOtherOperatorExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression2642);
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

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1098:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1099:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1099:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1100:3: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2665);
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
            	    break loop14;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1124:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1125:2: (iv_ruleOpOther= ruleOpOther EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1126:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOtherRule()); 
            }
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther2704);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther2715); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1133:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1136:28: ( (kw= '->' | kw= '..' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1137:1: (kw= '->' | kw= '..' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1137:1: (kw= '->' | kw= '..' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==30) ) {
                alt15=1;
            }
            else if ( (LA15_0==31) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1138:2: kw= '->'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleOpOther2753); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1145:2: kw= '..'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleOpOther2772); if (state.failed) return current;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1158:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1159:2: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1160:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression2812);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression2822); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1167:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1170:28: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1171:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1171:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1172:5: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2869);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1180:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==32) ) {
                    int LA16_2 = input.LA(2);

                    if ( (synpred8_InternalSGen()) ) {
                        alt16=1;
                    }


                }
                else if ( (LA16_0==33) ) {
                    int LA16_3 = input.LA(2);

                    if ( (synpred8_InternalSGen()) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1180:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1180:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1180:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1185:6: ( () ( ( ruleOpAdd ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1185:7: () ( ( ruleOpAdd ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1185:7: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1186:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1191:2: ( ( ruleOpAdd ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1192:1: ( ruleOpAdd )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1192:1: ( ruleOpAdd )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1193:3: ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAdditiveExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression2922);
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

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1206:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1207:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1207:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1208:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2945);
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
            	    break loop16;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1232:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1233:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1234:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd2984);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd2995); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1241:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1244:28: ( (kw= '+' | kw= '-' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1245:1: (kw= '+' | kw= '-' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1245:1: (kw= '+' | kw= '-' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==32) ) {
                alt17=1;
            }
            else if ( (LA17_0==33) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1246:2: kw= '+'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleOpAdd3033); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1253:2: kw= '-'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleOpAdd3052); if (state.failed) return current;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1266:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1267:2: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1268:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression3092);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression3102); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1275:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1278:28: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1279:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1279:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1280:5: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3149);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XUnaryOperation_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1288:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop18:
            do {
                int alt18=2;
                switch ( input.LA(1) ) {
                case 34:
                    {
                    int LA18_2 = input.LA(2);

                    if ( (synpred9_InternalSGen()) ) {
                        alt18=1;
                    }


                    }
                    break;
                case 35:
                    {
                    int LA18_3 = input.LA(2);

                    if ( (synpred9_InternalSGen()) ) {
                        alt18=1;
                    }


                    }
                    break;
                case 36:
                    {
                    int LA18_4 = input.LA(2);

                    if ( (synpred9_InternalSGen()) ) {
                        alt18=1;
                    }


                    }
                    break;
                case 37:
                    {
                    int LA18_5 = input.LA(2);

                    if ( (synpred9_InternalSGen()) ) {
                        alt18=1;
                    }


                    }
                    break;

                }

                switch (alt18) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1288:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1288:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1288:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1293:6: ( () ( ( ruleOpMulti ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1293:7: () ( ( ruleOpMulti ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1293:7: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1294:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1299:2: ( ( ruleOpMulti ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1300:1: ( ruleOpMulti )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1300:1: ( ruleOpMulti )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1301:3: ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMultiplicativeExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3202);
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

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1314:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1315:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1315:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1316:3: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3225);
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
    // $ANTLR end "ruleXMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1340:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1341:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1342:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti3264);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti3275); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1349:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1352:28: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1353:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1353:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt19=4;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt19=1;
                }
                break;
            case 35:
                {
                alt19=2;
                }
                break;
            case 36:
                {
                alt19=3;
                }
                break;
            case 37:
                {
                alt19=4;
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1354:2: kw= '*'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleOpMulti3313); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1361:2: kw= '**'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleOpMulti3332); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1368:2: kw= '/'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleOpMulti3351); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1375:2: kw= '%'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleOpMulti3370); if (state.failed) return current;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1388:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1389:2: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1390:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3410);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation3420); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1397:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_2_0 = null;

        EObject this_XCastedExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1400:28: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1401:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1401:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=32 && LA20_0<=33)||LA20_0==38) ) {
                alt20=1;
            }
            else if ( ((LA20_0>=RULE_ID && LA20_0<=RULE_STRING)||(LA20_0>=12 && LA20_0<=13)||LA20_0==29||LA20_0==43||LA20_0==45||LA20_0==48||LA20_0==50||(LA20_0>=54 && LA20_0<=55)||(LA20_0>=59 && LA20_0<=67)) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1401:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1401:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1401:3: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1401:3: ()
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1402:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1407:2: ( ( ruleOpUnary ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1408:1: ( ruleOpUnary )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1408:1: ( ruleOpUnary )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1409:3: ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXUnaryOperationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3478);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1422:2: ( (lv_operand_2_0= ruleXCastedExpression ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1423:1: (lv_operand_2_0= ruleXCastedExpression )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1423:1: (lv_operand_2_0= ruleXCastedExpression )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1424:3: lv_operand_2_0= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXCastedExpressionParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3499);
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1442:5: this_XCastedExpression_3= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3528);
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1458:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1459:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1460:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary3564);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary3575); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1467:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1470:28: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1471:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1471:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt21=3;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt21=1;
                }
                break;
            case 33:
                {
                alt21=2;
                }
                break;
            case 32:
                {
                alt21=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1472:2: kw= '!'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleOpUnary3613); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1479:2: kw= '-'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleOpUnary3632); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1486:2: kw= '+'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleOpUnary3651); if (state.failed) return current;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1499:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCastedExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1500:2: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1501:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCastedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression3691);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression3701); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1508:1: ruleXCastedExpression returns [EObject current=null] : (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XMemberFeatureCall_0 = null;

        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1511:28: ( (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1512:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1512:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1513:5: this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXCastedExpressionAccess().getXMemberFeatureCallParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression3748);
            this_XMemberFeatureCall_0=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMemberFeatureCall_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1521:1: ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==39) ) {
                    int LA22_2 = input.LA(2);

                    if ( (synpred10_InternalSGen()) ) {
                        alt22=1;
                    }


                }


                switch (alt22) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1521:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1521:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1521:3: ( ( () 'as' ) )=> ( () otherlv_2= 'as' )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1523:5: ( () otherlv_2= 'as' )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1523:6: () otherlv_2= 'as'
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1523:6: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1524:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleXCastedExpression3783); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1533:3: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1534:1: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1534:1: (lv_type_3_0= ruleJvmTypeReference )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1535:3: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression3806);
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
    // $ANTLR end "ruleXCastedExpression"


    // $ANTLR start "entryRuleXMemberFeatureCall"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1559:1: entryRuleXMemberFeatureCall returns [EObject current=null] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMemberFeatureCall = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1560:2: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1561:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMemberFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall3844);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMemberFeatureCall3854); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1568:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* ) ;
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
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1571:28: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1572:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1572:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1573:5: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall3901);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XPrimaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1581:1: ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )*
            loop29:
            do {
                int alt29=3;
                switch ( input.LA(1) ) {
                case 19:
                    {
                    int LA29_2 = input.LA(2);

                    if ( (synpred11_InternalSGen()) ) {
                        alt29=1;
                    }
                    else if ( (synpred12_InternalSGen()) ) {
                        alt29=2;
                    }


                    }
                    break;
                case 40:
                    {
                    int LA29_3 = input.LA(2);

                    if ( (synpred12_InternalSGen()) ) {
                        alt29=2;
                    }


                    }
                    break;
                case 41:
                    {
                    int LA29_4 = input.LA(2);

                    if ( (synpred12_InternalSGen()) ) {
                        alt29=2;
                    }


                    }
                    break;

                }

                switch (alt29) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1581:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1581:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1581:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1581:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1581:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1587:25: ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1587:26: () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1587:26: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1588:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleXMemberFeatureCall3950); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1());
            	          
            	    }
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1597:1: ( ( ruleValidID ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1598:1: ( ruleValidID )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1598:1: ( ruleValidID )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1599:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall3973);
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
            	    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall3989);
            	    ruleOpSingleAssign();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }


            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1620:3: ( (lv_value_5_0= ruleXAssignment ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1621:1: (lv_value_5_0= ruleXAssignment )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1621:1: (lv_value_5_0= ruleXAssignment )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1622:3: lv_value_5_0= ruleXAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall4011);
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
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1639:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1639:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1639:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1639:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1639:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1655:7: ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1655:8: () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1655:8: ()
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1656:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1661:2: (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    int alt23=3;
            	    switch ( input.LA(1) ) {
            	    case 19:
            	        {
            	        alt23=1;
            	        }
            	        break;
            	    case 40:
            	        {
            	        alt23=2;
            	        }
            	        break;
            	    case 41:
            	        {
            	        alt23=3;
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
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1661:4: otherlv_7= '.'
            	            {
            	            otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleXMemberFeatureCall4097); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_7, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0());
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1666:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            {
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1666:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1667:1: (lv_nullSafe_8_0= '?.' )
            	            {
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1667:1: (lv_nullSafe_8_0= '?.' )
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1668:3: lv_nullSafe_8_0= '?.'
            	            {
            	            lv_nullSafe_8_0=(Token)match(input,40,FOLLOW_40_in_ruleXMemberFeatureCall4121); if (state.failed) return current;
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
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1682:6: ( (lv_spreading_9_0= '*.' ) )
            	            {
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1682:6: ( (lv_spreading_9_0= '*.' ) )
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1683:1: (lv_spreading_9_0= '*.' )
            	            {
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1683:1: (lv_spreading_9_0= '*.' )
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1684:3: lv_spreading_9_0= '*.'
            	            {
            	            lv_spreading_9_0=(Token)match(input,41,FOLLOW_41_in_ruleXMemberFeatureCall4158); if (state.failed) return current;
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

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1697:5: (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )?
            	    int alt25=2;
            	    int LA25_0 = input.LA(1);

            	    if ( (LA25_0==29) ) {
            	        alt25=1;
            	    }
            	    switch (alt25) {
            	        case 1 :
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1697:7: otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>'
            	            {
            	            otherlv_10=(Token)match(input,29,FOLLOW_29_in_ruleXMemberFeatureCall4187); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_10, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0());
            	                  
            	            }
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1701:1: ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) )
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1702:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            {
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1702:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1703:3: lv_typeArguments_11_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4208);
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

            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1719:2: (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop24:
            	            do {
            	                int alt24=2;
            	                int LA24_0 = input.LA(1);

            	                if ( (LA24_0==42) ) {
            	                    alt24=1;
            	                }


            	                switch (alt24) {
            	            	case 1 :
            	            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1719:4: otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    otherlv_12=(Token)match(input,42,FOLLOW_42_in_ruleXMemberFeatureCall4221); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	          	newLeafNode(otherlv_12, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0());
            	            	          
            	            	    }
            	            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1723:1: ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1724:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1724:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1725:3: lv_typeArguments_13_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {
            	            	       
            	            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0()); 
            	            	      	    
            	            	    }
            	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4242);
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
            	            	    break loop24;
            	                }
            	            } while (true);

            	            otherlv_14=(Token)match(input,28,FOLLOW_28_in_ruleXMemberFeatureCall4256); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_14, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1745:3: ( ( ruleValidID ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1746:1: ( ruleValidID )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1746:1: ( ruleValidID )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1747:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4281);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1760:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?
            	    int alt28=2;
            	    alt28 = dfa28.predict(input);
            	    switch (alt28) {
            	        case 1 :
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1760:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')'
            	            {
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1760:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) )
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1760:4: ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' )
            	            {
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1767:1: (lv_explicitOperationCall_16_0= '(' )
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1768:3: lv_explicitOperationCall_16_0= '('
            	            {
            	            lv_explicitOperationCall_16_0=(Token)match(input,43,FOLLOW_43_in_ruleXMemberFeatureCall4315); if (state.failed) return current;
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

            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1781:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?
            	            int alt27=3;
            	            alt27 = dfa27.predict(input);
            	            switch (alt27) {
            	                case 1 :
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1781:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    {
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1781:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1781:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    {
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1793:1: (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1794:3: lv_memberCallArguments_17_0= ruleXShortClosure
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4390);
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
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1811:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    {
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1811:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1811:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    {
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1811:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) )
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1812:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    {
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1812:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1813:3: lv_memberCallArguments_18_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4418);
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

            	                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1829:2: (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    loop26:
            	                    do {
            	                        int alt26=2;
            	                        int LA26_0 = input.LA(1);

            	                        if ( (LA26_0==42) ) {
            	                            alt26=1;
            	                        }


            	                        switch (alt26) {
            	                    	case 1 :
            	                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1829:4: otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_19=(Token)match(input,42,FOLLOW_42_in_ruleXMemberFeatureCall4431); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	newLeafNode(otherlv_19, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
            	                    	          
            	                    	    }
            	                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1833:1: ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1834:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    {
            	                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1834:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1835:3: lv_memberCallArguments_20_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0()); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4452);
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
            	                    	    break loop26;
            	                        }
            	                    } while (true);


            	                    }


            	                    }
            	                    break;

            	            }

            	            otherlv_21=(Token)match(input,44,FOLLOW_44_in_ruleXMemberFeatureCall4469); if (state.failed) return current;
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
            	    break loop29;
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


    // $ANTLR start "entryRuleXPrimaryExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1863:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1864:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1865:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression4510);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression4520); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1872:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression ) ;
    public final EObject ruleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XConstructorCall_0 = null;

        EObject this_XBlockExpression_1 = null;

        EObject this_XSwitchExpression_2 = null;

        EObject this_XFeatureCall_3 = null;

        EObject this_XLiteral_4 = null;

        EObject this_XIfExpression_5 = null;

        EObject this_XForLoopExpression_6 = null;

        EObject this_XWhileExpression_7 = null;

        EObject this_XDoWhileExpression_8 = null;

        EObject this_XThrowExpression_9 = null;

        EObject this_XReturnExpression_10 = null;

        EObject this_XTryCatchFinallyExpression_11 = null;

        EObject this_XParenthesizedExpression_12 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1875:28: ( (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1876:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1876:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )
            int alt30=13;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt30=1;
                }
                break;
            case 13:
                {
                alt30=2;
                }
                break;
            case 50:
                {
                alt30=3;
                }
                break;
            case RULE_ID:
            case 29:
            case 59:
                {
                alt30=4;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case 45:
            case 61:
            case 62:
            case 63:
            case 64:
                {
                alt30=5;
                }
                break;
            case 48:
                {
                alt30=6;
                }
                break;
            case 12:
                {
                alt30=7;
                }
                break;
            case 54:
                {
                alt30=8;
                }
                break;
            case 55:
                {
                alt30=9;
                }
                break;
            case 65:
                {
                alt30=10;
                }
                break;
            case 66:
                {
                alt30=11;
                }
                break;
            case 67:
                {
                alt30=12;
                }
                break;
            case 43:
                {
                alt30=13;
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1877:5: this_XConstructorCall_0= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression4567);
                    this_XConstructorCall_0=ruleXConstructorCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XConstructorCall_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1887:5: this_XBlockExpression_1= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression4594);
                    this_XBlockExpression_1=ruleXBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XBlockExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1897:5: this_XSwitchExpression_2= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression4621);
                    this_XSwitchExpression_2=ruleXSwitchExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XSwitchExpression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1907:5: this_XFeatureCall_3= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression4648);
                    this_XFeatureCall_3=ruleXFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFeatureCall_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1917:5: this_XLiteral_4= ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression4675);
                    this_XLiteral_4=ruleXLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XLiteral_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1927:5: this_XIfExpression_5= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression4702);
                    this_XIfExpression_5=ruleXIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XIfExpression_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1937:5: this_XForLoopExpression_6= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression4729);
                    this_XForLoopExpression_6=ruleXForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XForLoopExpression_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1947:5: this_XWhileExpression_7= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression4756);
                    this_XWhileExpression_7=ruleXWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XWhileExpression_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1957:5: this_XDoWhileExpression_8= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression4783);
                    this_XDoWhileExpression_8=ruleXDoWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XDoWhileExpression_8; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1967:5: this_XThrowExpression_9= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression4810);
                    this_XThrowExpression_9=ruleXThrowExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XThrowExpression_9; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 11 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1977:5: this_XReturnExpression_10= ruleXReturnExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXReturnExpressionParserRuleCall_10()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression4837);
                    this_XReturnExpression_10=ruleXReturnExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XReturnExpression_10; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1987:5: this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_11()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression4864);
                    this_XTryCatchFinallyExpression_11=ruleXTryCatchFinallyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTryCatchFinallyExpression_11; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 13 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1997:5: this_XParenthesizedExpression_12= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_12()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression4891);
                    this_XParenthesizedExpression_12=ruleXParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XParenthesizedExpression_12; 
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


    // $ANTLR start "entryRuleXLiteral"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2013:1: entryRuleXLiteral returns [EObject current=null] : iv_ruleXLiteral= ruleXLiteral EOF ;
    public final EObject entryRuleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXLiteral = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2014:2: (iv_ruleXLiteral= ruleXLiteral EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2015:2: iv_ruleXLiteral= ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXLiteral_in_entryRuleXLiteral4926);
            iv_ruleXLiteral=ruleXLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXLiteral4936); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2022:1: ruleXLiteral returns [EObject current=null] : (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) ;
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
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2025:28: ( (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2026:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2026:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            int alt31=6;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt31=1;
                }
                break;
            case 61:
            case 62:
                {
                alt31=2;
                }
                break;
            case RULE_INT:
                {
                alt31=3;
                }
                break;
            case 63:
                {
                alt31=4;
                }
                break;
            case RULE_STRING:
                {
                alt31=5;
                }
                break;
            case 64:
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2027:5: this_XClosure_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXLiteral4983);
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2037:5: this_XBooleanLiteral_1= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral5010);
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2047:5: this_XIntLiteral_2= ruleXIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXIntLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIntLiteral_in_ruleXLiteral5037);
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2057:5: this_XNullLiteral_3= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNullLiteral_in_ruleXLiteral5064);
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2067:5: this_XStringLiteral_4= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXLiteral5091);
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2077:5: this_XTypeLiteral_5= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXLiteral5118);
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2093:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2094:2: (iv_ruleXClosure= ruleXClosure EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2095:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure5153);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure5163); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2102:1: ruleXClosure returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' ) ;
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
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2105:28: ( ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2106:1: ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2106:1: ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2106:2: () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']'
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2106:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2107:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXClosureAccess().getXClosureAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,45,FOLLOW_45_in_ruleXClosure5209); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2116:1: ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID||LA33_0==43||LA33_0==70) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2116:2: ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2116:2: ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2117:1: (lv_formalParameters_2_0= ruleJvmFormalParameter )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2117:1: (lv_formalParameters_2_0= ruleJvmFormalParameter )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2118:3: lv_formalParameters_2_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5231);
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

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2134:2: (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==42) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2134:4: otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_3=(Token)match(input,42,FOLLOW_42_in_ruleXClosure5244); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getXClosureAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2138:1: ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2139:1: (lv_formalParameters_4_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2139:1: (lv_formalParameters_4_0= ruleJvmFormalParameter )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2140:3: lv_formalParameters_4_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5265);
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

            otherlv_5=(Token)match(input,46,FOLLOW_46_in_ruleXClosure5281); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXClosureAccess().getVerticalLineKeyword_3());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2160:1: ( (lv_expression_6_0= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2161:1: (lv_expression_6_0= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2161:1: (lv_expression_6_0= ruleXExpression )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2162:3: lv_expression_6_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXClosure5302);
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

            otherlv_7=(Token)match(input,47,FOLLOW_47_in_ruleXClosure5314); if (state.failed) return current;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2190:1: entryRuleXShortClosure returns [EObject current=null] : iv_ruleXShortClosure= ruleXShortClosure EOF ;
    public final EObject entryRuleXShortClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXShortClosure = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2191:2: (iv_ruleXShortClosure= ruleXShortClosure EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2192:2: iv_ruleXShortClosure= ruleXShortClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXShortClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5350);
            iv_ruleXShortClosure=ruleXShortClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXShortClosure5360); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2199:1: ruleXShortClosure returns [EObject current=null] : ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXShortClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_formalParameters_1_0 = null;

        EObject lv_formalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2202:28: ( ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2203:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2203:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2203:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) ) ( (lv_expression_5_0= ruleXExpression ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2203:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2203:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2214:5: ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2214:6: () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|'
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2214:6: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2215:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXShortClosureAccess().getXClosureAction_0_0_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2220:2: ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID||LA35_0==43||LA35_0==70) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2220:3: ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2220:3: ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2221:1: (lv_formalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2221:1: (lv_formalParameters_1_0= ruleJvmFormalParameter )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2222:3: lv_formalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5458);
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

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2238:2: (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==42) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2238:4: otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,42,FOLLOW_42_in_ruleXShortClosure5471); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0());
                    	          
                    	    }
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2242:1: ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2243:1: (lv_formalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2243:1: (lv_formalParameters_3_0= ruleJvmFormalParameter )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2244:3: lv_formalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5492);
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

            otherlv_4=(Token)match(input,46,FOLLOW_46_in_ruleXShortClosure5508); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXShortClosureAccess().getVerticalLineKeyword_0_0_2());
                  
            }

            }


            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2264:3: ( (lv_expression_5_0= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2265:1: (lv_expression_5_0= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2265:1: (lv_expression_5_0= ruleXExpression )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2266:3: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXShortClosure5531);
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2290:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2291:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2292:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression5567);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression5577); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2299:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2302:28: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2303:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2303:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2303:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_43_in_ruleXParenthesizedExpression5614); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression5636);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleXParenthesizedExpression5647); if (state.failed) return current;
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


    // $ANTLR start "entryRuleXIfExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2328:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2329:2: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2330:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIfExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression5683);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression5693); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXIfExpression"


    // $ANTLR start "ruleXIfExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2337:1: ruleXIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_if_3_0 = null;

        EObject lv_then_5_0 = null;

        EObject lv_else_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2340:28: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2341:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2341:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2341:2: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2341:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2342:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,48,FOLLOW_48_in_ruleXIfExpression5739); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,43,FOLLOW_43_in_ruleXIfExpression5751); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2355:1: ( (lv_if_3_0= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2356:1: (lv_if_3_0= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2356:1: (lv_if_3_0= ruleXExpression )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2357:3: lv_if_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression5772);
            lv_if_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"if",
                      		lv_if_3_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,44,FOLLOW_44_in_ruleXIfExpression5784); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2377:1: ( (lv_then_5_0= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2378:1: (lv_then_5_0= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2378:1: (lv_then_5_0= ruleXExpression )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2379:3: lv_then_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression5805);
            lv_then_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"then",
                      		lv_then_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2395:2: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==49) ) {
                int LA36_1 = input.LA(2);

                if ( (synpred16_InternalSGen()) ) {
                    alt36=1;
                }
            }
            switch (alt36) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2395:3: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2395:3: ( ( 'else' )=>otherlv_6= 'else' )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2395:4: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,49,FOLLOW_49_in_ruleXIfExpression5826); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
                          
                    }

                    }

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2400:2: ( (lv_else_7_0= ruleXExpression ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2401:1: (lv_else_7_0= ruleXExpression )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2401:1: (lv_else_7_0= ruleXExpression )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2402:3: lv_else_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression5848);
                    lv_else_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"else",
                              		lv_else_7_0, 
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
    // $ANTLR end "ruleXIfExpression"


    // $ANTLR start "entryRuleXSwitchExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2426:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2427:2: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2428:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSwitchExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression5886);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression5896); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXSwitchExpression"


    // $ANTLR start "ruleXSwitchExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2435:1: ruleXSwitchExpression returns [EObject current=null] : ( () otherlv_1= 'switch' ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' ) ;
    public final EObject ruleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_localVarName_2_0 = null;

        EObject lv_switch_4_0 = null;

        EObject lv_cases_6_0 = null;

        EObject lv_default_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2438:28: ( ( () otherlv_1= 'switch' ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2439:1: ( () otherlv_1= 'switch' ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2439:1: ( () otherlv_1= 'switch' ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2439:2: () otherlv_1= 'switch' ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}'
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2439:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2440:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,50,FOLLOW_50_in_ruleXSwitchExpression5942); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2449:1: ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==51) ) {
                    alt37=1;
                }
            }
            switch (alt37) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2449:2: ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':'
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2449:2: ( (lv_localVarName_2_0= ruleValidID ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2450:1: (lv_localVarName_2_0= ruleValidID )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2450:1: (lv_localVarName_2_0= ruleValidID )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2451:3: lv_localVarName_2_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getLocalVarNameValidIDParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXSwitchExpression5964);
                    lv_localVarName_2_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"localVarName",
                              		lv_localVarName_2_0, 
                              		"ValidID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,51,FOLLOW_51_in_ruleXSwitchExpression5976); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_1());
                          
                    }

                    }
                    break;

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2471:3: ( (lv_switch_4_0= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2472:1: (lv_switch_4_0= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2472:1: (lv_switch_4_0= ruleXExpression )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2473:3: lv_switch_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression5999);
            lv_switch_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"switch",
                      		lv_switch_4_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleXSwitchExpression6011); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2493:1: ( (lv_cases_6_0= ruleXCasePart ) )+
            int cnt38=0;
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_ID||LA38_0==43||LA38_0==51||LA38_0==53||LA38_0==70) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2494:1: (lv_cases_6_0= ruleXCasePart )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2494:1: (lv_cases_6_0= ruleXCasePart )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2495:3: lv_cases_6_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6032);
            	    lv_cases_6_0=ruleXCasePart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"cases",
            	              		lv_cases_6_0, 
            	              		"XCasePart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt38 >= 1 ) break loop38;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(38, input);
                        throw eee;
                }
                cnt38++;
            } while (true);

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2511:3: (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==52) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2511:5: otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) )
                    {
                    otherlv_7=(Token)match(input,52,FOLLOW_52_in_ruleXSwitchExpression6046); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_6_0());
                          
                    }
                    otherlv_8=(Token)match(input,51,FOLLOW_51_in_ruleXSwitchExpression6058); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_6_1());
                          
                    }
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2519:1: ( (lv_default_9_0= ruleXExpression ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2520:1: (lv_default_9_0= ruleXExpression )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2520:1: (lv_default_9_0= ruleXExpression )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2521:3: lv_default_9_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_6_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6079);
                    lv_default_9_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"default",
                              		lv_default_9_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,14,FOLLOW_14_in_ruleXSwitchExpression6093); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_7());
                  
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
    // $ANTLR end "ruleXSwitchExpression"


    // $ANTLR start "entryRuleXCasePart"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2549:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2550:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2551:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCasePartRule()); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart6129);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart6139); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2558:1: ruleXCasePart returns [EObject current=null] : ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_typeGuard_0_0 = null;

        EObject lv_case_2_0 = null;

        EObject lv_then_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2561:28: ( ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2562:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2562:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2562:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2562:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ID||LA40_0==43||LA40_0==70) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2563:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2563:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2564:3: lv_typeGuard_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6185);
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

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2580:3: (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==53) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2580:5: otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) )
                    {
                    otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleXCasePart6199); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXCasePartAccess().getCaseKeyword_1_0());
                          
                    }
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2584:1: ( (lv_case_2_0= ruleXExpression ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2585:1: (lv_case_2_0= ruleXExpression )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2585:1: (lv_case_2_0= ruleXExpression )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2586:3: lv_case_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6220);
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

            otherlv_3=(Token)match(input,51,FOLLOW_51_in_ruleXCasePart6234); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCasePartAccess().getColonKeyword_2());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2606:1: ( (lv_then_4_0= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2607:1: (lv_then_4_0= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2607:1: (lv_then_4_0= ruleXExpression )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2608:3: lv_then_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6255);
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


    // $ANTLR start "entryRuleXForLoopExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2632:1: entryRuleXForLoopExpression returns [EObject current=null] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXForLoopExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2633:2: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2634:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXForLoopExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6291);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXForLoopExpression6301); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXForLoopExpression"


    // $ANTLR start "ruleXForLoopExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2641:1: ruleXForLoopExpression returns [EObject current=null] : ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
    public final EObject ruleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_declaredParam_3_0 = null;

        EObject lv_forExpression_5_0 = null;

        EObject lv_eachExpression_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2644:28: ( ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2645:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2645:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2645:2: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2645:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2646:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleXForLoopExpression6347); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,43,FOLLOW_43_in_ruleXForLoopExpression6359); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2659:1: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2660:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2660:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2661:3: lv_declaredParam_3_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6380);
            lv_declaredParam_3_0=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"declaredParam",
                      		lv_declaredParam_3_0, 
                      		"JvmFormalParameter");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,51,FOLLOW_51_in_ruleXForLoopExpression6392); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_4());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2681:1: ( (lv_forExpression_5_0= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2682:1: (lv_forExpression_5_0= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2682:1: (lv_forExpression_5_0= ruleXExpression )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2683:3: lv_forExpression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression6413);
            lv_forExpression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"forExpression",
                      		lv_forExpression_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,44,FOLLOW_44_in_ruleXForLoopExpression6425); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2703:1: ( (lv_eachExpression_7_0= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2704:1: (lv_eachExpression_7_0= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2704:1: (lv_eachExpression_7_0= ruleXExpression )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2705:3: lv_eachExpression_7_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression6446);
            lv_eachExpression_7_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"eachExpression",
                      		lv_eachExpression_7_0, 
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
    // $ANTLR end "ruleXForLoopExpression"


    // $ANTLR start "entryRuleXWhileExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2729:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2730:2: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2731:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression6482);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression6492); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXWhileExpression"


    // $ANTLR start "ruleXWhileExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2738:1: ruleXWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_body_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2741:28: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2742:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2742:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2742:2: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2742:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2743:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,54,FOLLOW_54_in_ruleXWhileExpression6538); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,43,FOLLOW_43_in_ruleXWhileExpression6550); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2756:1: ( (lv_predicate_3_0= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2757:1: (lv_predicate_3_0= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2757:1: (lv_predicate_3_0= ruleXExpression )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2758:3: lv_predicate_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression6571);
            lv_predicate_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"predicate",
                      		lv_predicate_3_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,44,FOLLOW_44_in_ruleXWhileExpression6583); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2778:1: ( (lv_body_5_0= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2779:1: (lv_body_5_0= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2779:1: (lv_body_5_0= ruleXExpression )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2780:3: lv_body_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression6604);
            lv_body_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_5_0, 
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
    // $ANTLR end "ruleXWhileExpression"


    // $ANTLR start "entryRuleXDoWhileExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2804:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDoWhileExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2805:2: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2806:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXDoWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression6640);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression6650); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXDoWhileExpression"


    // $ANTLR start "ruleXDoWhileExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2813:1: ruleXDoWhileExpression returns [EObject current=null] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
    public final EObject ruleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_body_2_0 = null;

        EObject lv_predicate_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2816:28: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2817:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2817:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2817:2: () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2817:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2818:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,55,FOLLOW_55_in_ruleXDoWhileExpression6696); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2827:1: ( (lv_body_2_0= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2828:1: (lv_body_2_0= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2828:1: (lv_body_2_0= ruleXExpression )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2829:3: lv_body_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression6717);
            lv_body_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_2_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,54,FOLLOW_54_in_ruleXDoWhileExpression6729); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,43,FOLLOW_43_in_ruleXDoWhileExpression6741); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2853:1: ( (lv_predicate_5_0= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2854:1: (lv_predicate_5_0= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2854:1: (lv_predicate_5_0= ruleXExpression )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2855:3: lv_predicate_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression6762);
            lv_predicate_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"predicate",
                      		lv_predicate_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,44,FOLLOW_44_in_ruleXDoWhileExpression6774); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXDoWhileExpressionAccess().getRightParenthesisKeyword_6());
                  
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
    // $ANTLR end "ruleXDoWhileExpression"


    // $ANTLR start "entryRuleXBlockExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2883:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2884:2: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2885:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression6810);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression6820); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXBlockExpression"


    // $ANTLR start "ruleXBlockExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2892:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2895:28: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2896:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2896:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2896:2: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2896:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2897:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleXBlockExpression6866); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2906:1: ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>=RULE_ID && LA43_0<=RULE_STRING)||(LA43_0>=12 && LA43_0<=13)||LA43_0==29||(LA43_0>=32 && LA43_0<=33)||LA43_0==38||LA43_0==43||LA43_0==45||LA43_0==48||LA43_0==50||(LA43_0>=54 && LA43_0<=55)||(LA43_0>=57 && LA43_0<=67)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2906:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )?
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2906:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2907:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2907:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2908:3: lv_expressions_2_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression6888);
            	    lv_expressions_2_0=ruleXExpressionInsideBlock();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXBlockExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expressions",
            	              		lv_expressions_2_0, 
            	              		"XExpressionInsideBlock");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2924:2: (otherlv_3= ';' )?
            	    int alt42=2;
            	    int LA42_0 = input.LA(1);

            	    if ( (LA42_0==56) ) {
            	        alt42=1;
            	    }
            	    switch (alt42) {
            	        case 1 :
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2924:4: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,56,FOLLOW_56_in_ruleXBlockExpression6901); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleXBlockExpression6917); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_3());
                  
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
    // $ANTLR end "ruleXBlockExpression"


    // $ANTLR start "entryRuleXExpressionInsideBlock"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2940:1: entryRuleXExpressionInsideBlock returns [EObject current=null] : iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF ;
    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInsideBlock = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2941:2: (iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2942:2: iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInsideBlockRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock6953);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock6963); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2949:1: ruleXExpressionInsideBlock returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2952:28: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2953:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2953:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=57 && LA44_0<=58)) ) {
                alt44=1;
            }
            else if ( ((LA44_0>=RULE_ID && LA44_0<=RULE_STRING)||(LA44_0>=12 && LA44_0<=13)||LA44_0==29||(LA44_0>=32 && LA44_0<=33)||LA44_0==38||LA44_0==43||LA44_0==45||LA44_0==48||LA44_0==50||(LA44_0>=54 && LA44_0<=55)||(LA44_0>=59 && LA44_0<=67)) ) {
                alt44=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2954:5: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXVariableDeclarationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7010);
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2964:5: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7037);
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2980:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2981:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2982:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7072);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration7082); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2989:1: ruleXVariableDeclaration returns [EObject current=null] : ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
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
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2992:28: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2993:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2993:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2993:2: () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2993:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2994:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXVariableDeclarationAccess().getXVariableDeclarationAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2999:2: ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==57) ) {
                alt45=1;
            }
            else if ( (LA45_0==58) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2999:3: ( (lv_writeable_1_0= 'var' ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2999:3: ( (lv_writeable_1_0= 'var' ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3000:1: (lv_writeable_1_0= 'var' )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3000:1: (lv_writeable_1_0= 'var' )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3001:3: lv_writeable_1_0= 'var'
                    {
                    lv_writeable_1_0=(Token)match(input,57,FOLLOW_57_in_ruleXVariableDeclaration7135); if (state.failed) return current;
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3015:7: otherlv_2= 'val'
                    {
                    otherlv_2=(Token)match(input,58,FOLLOW_58_in_ruleXVariableDeclaration7166); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXVariableDeclarationAccess().getValKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3019:2: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID) ) {
                int LA46_1 = input.LA(2);

                if ( (synpred17_InternalSGen()) ) {
                    alt46=1;
                }
                else if ( (true) ) {
                    alt46=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA46_0==43) && (synpred17_InternalSGen())) {
                alt46=1;
            }
            else if ( (LA46_0==70) && (synpred17_InternalSGen())) {
                alt46=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3019:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3019:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3019:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3027:6: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3027:7: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3027:7: ( (lv_type_3_0= ruleJvmTypeReference ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3028:1: (lv_type_3_0= ruleJvmTypeReference )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3028:1: (lv_type_3_0= ruleJvmTypeReference )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3029:3: lv_type_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7214);
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

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3045:2: ( (lv_name_4_0= ruleValidID ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3046:1: (lv_name_4_0= ruleValidID )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3046:1: (lv_name_4_0= ruleValidID )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3047:3: lv_name_4_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration7235);
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3064:6: ( (lv_name_5_0= ruleValidID ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3064:6: ( (lv_name_5_0= ruleValidID ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3065:1: (lv_name_5_0= ruleValidID )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3065:1: (lv_name_5_0= ruleValidID )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3066:3: lv_name_5_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration7264);
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

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3082:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==17) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3082:5: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleXVariableDeclaration7278); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3086:1: ( (lv_right_7_0= ruleXExpression ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3087:1: (lv_right_7_0= ruleXExpression )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3087:1: (lv_right_7_0= ruleXExpression )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3088:3: lv_right_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7299);
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3112:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3113:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3114:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7337);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter7347); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3121:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3124:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3125:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3125:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3125:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3125:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID) ) {
                int LA48_1 = input.LA(2);

                if ( (LA48_1==RULE_ID||LA48_1==19||LA48_1==29) ) {
                    alt48=1;
                }
            }
            else if ( (LA48_0==43||LA48_0==70) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3126:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3126:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3127:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter7393);
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

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3143:3: ( (lv_name_1_0= ruleValidID ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3144:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3144:1: (lv_name_1_0= ruleValidID )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3145:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleJvmFormalParameter7415);
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3169:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3170:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3171:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall7451);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall7461); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3178:1: ruleXFeatureCall returns [EObject current=null] : ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ) ;
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
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3181:28: ( ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3182:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3182:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3182:2: () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3182:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3183:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3188:2: ( ( ruleStaticQualifier ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID) ) {
                int LA49_1 = input.LA(2);

                if ( (LA49_1==18) ) {
                    alt49=1;
                }
            }
            switch (alt49) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3189:1: ( ruleStaticQualifier )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3189:1: ( ruleStaticQualifier )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3190:3: ruleStaticQualifier
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXFeatureCallRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getDeclaringTypeJvmDeclaredTypeCrossReference_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall7518);
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

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3203:3: (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==29) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3203:5: otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,29,FOLLOW_29_in_ruleXFeatureCall7532); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_2_0());
                          
                    }
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3207:1: ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3208:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3208:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3209:3: lv_typeArguments_3_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall7553);
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

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3225:2: (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==42) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3225:4: otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_4=(Token)match(input,42,FOLLOW_42_in_ruleXFeatureCall7566); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getXFeatureCallAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3229:1: ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3230:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3230:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3231:3: lv_typeArguments_5_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall7587);
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
                    	    break loop50;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,28,FOLLOW_28_in_ruleXFeatureCall7601); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_2_3());
                          
                    }

                    }
                    break;

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3251:3: ( ( ruleIdOrSuper ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3252:1: ( ruleIdOrSuper )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3252:1: ( ruleIdOrSuper )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3253:3: ruleIdOrSuper
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXFeatureCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall7626);
            ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3266:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt54=2;
            alt54 = dfa54.predict(input);
            switch (alt54) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3266:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3266:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3266:4: ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3273:1: (lv_explicitOperationCall_8_0= '(' )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3274:3: lv_explicitOperationCall_8_0= '('
                    {
                    lv_explicitOperationCall_8_0=(Token)match(input,43,FOLLOW_43_in_ruleXFeatureCall7660); if (state.failed) return current;
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

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3287:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt53=3;
                    alt53 = dfa53.predict(input);
                    switch (alt53) {
                        case 1 :
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3287:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3287:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3287:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure )
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3299:1: (lv_featureCallArguments_9_0= ruleXShortClosure )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3300:3: lv_featureCallArguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_4_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXShortClosure_in_ruleXFeatureCall7735);
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
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3317:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3317:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3317:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3317:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3318:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3318:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3319:3: lv_featureCallArguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall7763);
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

                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3335:2: (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            loop52:
                            do {
                                int alt52=2;
                                int LA52_0 = input.LA(1);

                                if ( (LA52_0==42) ) {
                                    alt52=1;
                                }


                                switch (alt52) {
                            	case 1 :
                            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3335:4: otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    {
                            	    otherlv_11=(Token)match(input,42,FOLLOW_42_in_ruleXFeatureCall7776); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getXFeatureCallAccess().getCommaKeyword_4_1_1_1_0());
                            	          
                            	    }
                            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3339:1: ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3340:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    {
                            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3340:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3341:3: lv_featureCallArguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall7797);
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
                            	    break loop52;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,44,FOLLOW_44_in_ruleXFeatureCall7814); if (state.failed) return current;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3369:1: entryRuleIdOrSuper returns [String current=null] : iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
    public final String entryRuleIdOrSuper() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrSuper = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3370:2: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3371:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrSuperRule()); 
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper7853);
            iv_ruleIdOrSuper=ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrSuper.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdOrSuper7864); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3378:1: ruleIdOrSuper returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID | kw= 'super' ) ;
    public final AntlrDatatypeRuleToken ruleIdOrSuper() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3381:28: ( (this_ValidID_0= ruleValidID | kw= 'super' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3382:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3382:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_ID) ) {
                alt55=1;
            }
            else if ( (LA55_0==59) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3383:5: this_ValidID_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIdOrSuperAccess().getValidIDParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleIdOrSuper7911);
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3395:2: kw= 'super'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleIdOrSuper7935); if (state.failed) return current;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3408:1: entryRuleStaticQualifier returns [String current=null] : iv_ruleStaticQualifier= ruleStaticQualifier EOF ;
    public final String entryRuleStaticQualifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStaticQualifier = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3409:2: (iv_ruleStaticQualifier= ruleStaticQualifier EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3410:2: iv_ruleStaticQualifier= ruleStaticQualifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStaticQualifierRule()); 
            }
            pushFollow(FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier7976);
            iv_ruleStaticQualifier=ruleStaticQualifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStaticQualifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStaticQualifier7987); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3417:1: ruleStaticQualifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= '::' )+ ;
    public final AntlrDatatypeRuleToken ruleStaticQualifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3420:28: ( (this_ValidID_0= ruleValidID kw= '::' )+ )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3421:1: (this_ValidID_0= ruleValidID kw= '::' )+
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3421:1: (this_ValidID_0= ruleValidID kw= '::' )+
            int cnt56=0;
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==RULE_ID) ) {
                    int LA56_2 = input.LA(2);

                    if ( (LA56_2==18) ) {
                        alt56=1;
                    }


                }


                switch (alt56) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3422:5: this_ValidID_0= ruleValidID kw= '::'
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getStaticQualifierAccess().getValidIDParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleStaticQualifier8034);
            	    this_ValidID_0=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }
            	    kw=(Token)match(input,18,FOLLOW_18_in_ruleStaticQualifier8052); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getStaticQualifierAccess().getColonColonKeyword_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt56 >= 1 ) break loop56;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(56, input);
                        throw eee;
                }
                cnt56++;
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


    // $ANTLR start "entryRuleXConstructorCall"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3446:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3447:2: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3448:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXConstructorCallRule()); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8093);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall8103); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXConstructorCall"


    // $ANTLR start "ruleXConstructorCall"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3455:1: ruleXConstructorCall returns [EObject current=null] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ) ;
    public final EObject ruleXConstructorCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_typeArguments_4_0 = null;

        EObject lv_typeArguments_6_0 = null;

        EObject lv_arguments_9_0 = null;

        EObject lv_arguments_10_0 = null;

        EObject lv_arguments_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3458:28: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3459:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3459:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3459:2: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3459:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3460:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXConstructorCallAccess().getXConstructorCallAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,60,FOLLOW_60_in_ruleXConstructorCall8149); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXConstructorCallAccess().getNewKeyword_1());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3469:1: ( ( ruleQualifiedName ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3470:1: ( ruleQualifiedName )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3470:1: ( ruleQualifiedName )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3471:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXConstructorCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8172);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3484:2: (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==29) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3484:4: otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                    {
                    otherlv_3=(Token)match(input,29,FOLLOW_29_in_ruleXConstructorCall8185); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_3_0());
                          
                    }
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3488:1: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3489:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3489:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3490:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8206);
                    lv_typeArguments_4_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      	        }
                             		add(
                             			current, 
                             			"typeArguments",
                              		lv_typeArguments_4_0, 
                              		"JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3506:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==42) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3506:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_5=(Token)match(input,42,FOLLOW_42_in_ruleXConstructorCall8219); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3510:1: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3511:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3511:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3512:3: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8240);
                    	    lv_typeArguments_6_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typeArguments",
                    	              		lv_typeArguments_6_0, 
                    	              		"JvmArgumentTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop57;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,28,FOLLOW_28_in_ruleXConstructorCall8254); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_3_3());
                          
                    }

                    }
                    break;

            }

            otherlv_8=(Token)match(input,43,FOLLOW_43_in_ruleXConstructorCall8268); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3536:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
            int alt60=3;
            alt60 = dfa60.predict(input);
            switch (alt60) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3536:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3536:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3536:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3548:1: (lv_arguments_9_0= ruleXShortClosure )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3549:3: lv_arguments_9_0= ruleXShortClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_5_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXConstructorCall8330);
                    lv_arguments_9_0=ruleXShortClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_9_0, 
                              		"XShortClosure");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3566:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3566:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3566:7: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3566:7: ( (lv_arguments_10_0= ruleXExpression ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3567:1: (lv_arguments_10_0= ruleXExpression )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3567:1: (lv_arguments_10_0= ruleXExpression )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3568:3: lv_arguments_10_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_5_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall8358);
                    lv_arguments_10_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_10_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3584:2: (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==42) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3584:4: otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) )
                    	    {
                    	    otherlv_11=(Token)match(input,42,FOLLOW_42_in_ruleXConstructorCall8371); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_11, grammarAccess.getXConstructorCallAccess().getCommaKeyword_5_1_1_0());
                    	          
                    	    }
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3588:1: ( (lv_arguments_12_0= ruleXExpression ) )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3589:1: (lv_arguments_12_0= ruleXExpression )
                    	    {
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3589:1: (lv_arguments_12_0= ruleXExpression )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3590:3: lv_arguments_12_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_5_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall8392);
                    	    lv_arguments_12_0=ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"arguments",
                    	              		lv_arguments_12_0, 
                    	              		"XExpression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop59;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,44,FOLLOW_44_in_ruleXConstructorCall8409); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_6());
                  
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
    // $ANTLR end "ruleXConstructorCall"


    // $ANTLR start "entryRuleXBooleanLiteral"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3618:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3619:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3620:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral8445);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral8455); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3627:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3630:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3631:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3631:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3631:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3631:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3632:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3637:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==61) ) {
                alt61=1;
            }
            else if ( (LA61_0==62) ) {
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3637:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,61,FOLLOW_61_in_ruleXBooleanLiteral8502); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3642:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3642:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3643:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3643:1: (lv_isTrue_2_0= 'true' )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3644:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,62,FOLLOW_62_in_ruleXBooleanLiteral8526); if (state.failed) return current;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3665:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3666:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3667:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNullLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral8576);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral8586); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3674:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3677:28: ( ( () otherlv_1= 'null' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3678:1: ( () otherlv_1= 'null' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3678:1: ( () otherlv_1= 'null' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3678:2: () otherlv_1= 'null'
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3678:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3679:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,63,FOLLOW_63_in_ruleXNullLiteral8632); if (state.failed) return current;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3696:1: entryRuleXIntLiteral returns [EObject current=null] : iv_ruleXIntLiteral= ruleXIntLiteral EOF ;
    public final EObject entryRuleXIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIntLiteral = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3697:2: (iv_ruleXIntLiteral= ruleXIntLiteral EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3698:2: iv_ruleXIntLiteral= ruleXIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIntLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral8668);
            iv_ruleXIntLiteral=ruleXIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIntLiteral8678); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3705:1: ruleXIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleXIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3708:28: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3709:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3709:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3709:2: () ( (lv_value_1_0= RULE_INT ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3709:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3710:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIntLiteralAccess().getXIntLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3715:2: ( (lv_value_1_0= RULE_INT ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3716:1: (lv_value_1_0= RULE_INT )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3716:1: (lv_value_1_0= RULE_INT )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3717:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleXIntLiteral8729); if (state.failed) return current;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3741:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3742:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3743:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral8770);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral8780); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3750:1: ruleXStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3753:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3754:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3754:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3754:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3754:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3755:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3760:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3761:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3761:1: (lv_value_1_0= RULE_STRING )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3762:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXStringLiteral8831); if (state.failed) return current;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3786:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3787:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3788:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTypeLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral8872);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral8882); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3795:1: ruleXTypeLiteral returns [EObject current=null] : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3798:28: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3799:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3799:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3799:2: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')'
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3799:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3800:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,64,FOLLOW_64_in_ruleXTypeLiteral8928); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,43,FOLLOW_43_in_ruleXTypeLiteral8940); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3813:1: ( ( ruleQualifiedName ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3814:1: ( ruleQualifiedName )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3814:1: ( ruleQualifiedName )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3815:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXTypeLiteralRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral8963);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,44,FOLLOW_44_in_ruleXTypeLiteral8975); if (state.failed) return current;
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


    // $ANTLR start "entryRuleXThrowExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3840:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXThrowExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3841:2: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3842:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXThrowExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9011);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression9021); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXThrowExpression"


    // $ANTLR start "ruleXThrowExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3849:1: ruleXThrowExpression returns [EObject current=null] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3852:28: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3853:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3853:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3853:2: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3853:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3854:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,65,FOLLOW_65_in_ruleXThrowExpression9067); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3863:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3864:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3864:1: (lv_expression_2_0= ruleXExpression )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3865:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXThrowExpression9088);
            lv_expression_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXThrowExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
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
    // $ANTLR end "ruleXThrowExpression"


    // $ANTLR start "entryRuleXReturnExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3889:1: entryRuleXReturnExpression returns [EObject current=null] : iv_ruleXReturnExpression= ruleXReturnExpression EOF ;
    public final EObject entryRuleXReturnExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXReturnExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3890:2: (iv_ruleXReturnExpression= ruleXReturnExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3891:2: iv_ruleXReturnExpression= ruleXReturnExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXReturnExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression9124);
            iv_ruleXReturnExpression=ruleXReturnExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXReturnExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXReturnExpression9134); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXReturnExpression"


    // $ANTLR start "ruleXReturnExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3898:1: ruleXReturnExpression returns [EObject current=null] : ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
    public final EObject ruleXReturnExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3901:28: ( ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3902:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3902:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3902:2: () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3902:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3903:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,66,FOLLOW_66_in_ruleXReturnExpression9180); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3912:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            int alt62=2;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3912:2: ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3917:1: (lv_expression_2_0= ruleXExpression )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3918:3: lv_expression_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXReturnExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXReturnExpression9211);
                    lv_expression_2_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXReturnExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_2_0, 
                              		"XExpression");
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
    // $ANTLR end "ruleXReturnExpression"


    // $ANTLR start "entryRuleXTryCatchFinallyExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3942:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3943:2: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3944:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9248);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9258); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXTryCatchFinallyExpression"


    // $ANTLR start "ruleXTryCatchFinallyExpression"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3951:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
    public final EObject ruleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression_2_0 = null;

        EObject lv_catchClauses_3_0 = null;

        EObject lv_finallyExpression_5_0 = null;

        EObject lv_finallyExpression_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3954:28: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3955:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3955:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3955:2: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3955:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3956:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,67,FOLLOW_67_in_ruleXTryCatchFinallyExpression9304); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3965:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3966:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3966:1: (lv_expression_2_0= ruleXExpression )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3967:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9325);
            lv_expression_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3983:2: ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==69) ) {
                alt65=1;
            }
            else if ( (LA65_0==68) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3983:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3983:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3983:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3983:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
                    int cnt63=0;
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==69) ) {
                            int LA63_2 = input.LA(2);

                            if ( (synpred22_InternalSGen()) ) {
                                alt63=1;
                            }


                        }


                        switch (alt63) {
                    	case 1 :
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3983:5: ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause )
                    	    {
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3985:1: (lv_catchClauses_3_0= ruleXCatchClause )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3986:3: lv_catchClauses_3_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_3_0_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression9355);
                    	    lv_catchClauses_3_0=ruleXCatchClause();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"catchClauses",
                    	              		lv_catchClauses_3_0, 
                    	              		"XCatchClause");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt63 >= 1 ) break loop63;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(63, input);
                                throw eee;
                        }
                        cnt63++;
                    } while (true);

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4002:3: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==68) ) {
                        int LA64_1 = input.LA(2);

                        if ( (synpred23_InternalSGen()) ) {
                            alt64=1;
                        }
                    }
                    switch (alt64) {
                        case 1 :
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4002:4: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4002:4: ( ( 'finally' )=>otherlv_4= 'finally' )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4002:5: ( 'finally' )=>otherlv_4= 'finally'
                            {
                            otherlv_4=(Token)match(input,68,FOLLOW_68_in_ruleXTryCatchFinallyExpression9377); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
                                  
                            }

                            }

                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4007:2: ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4008:1: (lv_finallyExpression_5_0= ruleXExpression )
                            {
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4008:1: (lv_finallyExpression_5_0= ruleXExpression )
                            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4009:3: lv_finallyExpression_5_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9399);
                            lv_finallyExpression_5_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"finallyExpression",
                                      		lv_finallyExpression_5_0, 
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
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4026:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4026:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4026:8: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,68,FOLLOW_68_in_ruleXTryCatchFinallyExpression9421); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
                          
                    }
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4030:1: ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4031:1: (lv_finallyExpression_7_0= ruleXExpression )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4031:1: (lv_finallyExpression_7_0= ruleXExpression )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4032:3: lv_finallyExpression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9442);
                    lv_finallyExpression_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"finallyExpression",
                              		lv_finallyExpression_7_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

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
    // $ANTLR end "ruleXTryCatchFinallyExpression"


    // $ANTLR start "entryRuleXCatchClause"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4056:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4057:2: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4058:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCatchClauseRule()); 
            }
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause9480);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause9490); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4065:1: ruleXCatchClause returns [EObject current=null] : ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4068:28: ( ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4069:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4069:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4069:2: ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4069:2: ( ( 'catch' )=>otherlv_0= 'catch' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4069:3: ( 'catch' )=>otherlv_0= 'catch'
            {
            otherlv_0=(Token)match(input,69,FOLLOW_69_in_ruleXCatchClause9535); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0());
                  
            }

            }

            otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleXCatchClause9548); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4078:1: ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4079:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4079:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4080:3: lv_declaredParam_2_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause9569);
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

            otherlv_3=(Token)match(input,44,FOLLOW_44_in_ruleXCatchClause9581); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4100:1: ( (lv_expression_4_0= ruleXExpression ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4101:1: (lv_expression_4_0= ruleXExpression )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4101:1: (lv_expression_4_0= ruleXExpression )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4102:3: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCatchClause9602);
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4126:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4127:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4128:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName9639);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName9650); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4135:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4138:28: ( (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4139:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4139:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4140:5: this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName9697);
            this_ValidID_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ValidID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4150:1: ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==19) ) {
                    int LA66_2 = input.LA(2);

                    if ( (LA66_2==RULE_ID) ) {
                        int LA66_3 = input.LA(3);

                        if ( (synpred25_InternalSGen()) ) {
                            alt66=1;
                        }


                    }


                }


                switch (alt66) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4150:2: ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4150:2: ( ( '.' )=>kw= '.' )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4150:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,19,FOLLOW_19_in_ruleQualifiedName9725); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName9748);
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
            	    break loop66;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4177:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4178:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4179:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference9795);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference9805); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4186:1: ruleJvmTypeReference returns [EObject current=null] : (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_1 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4189:28: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4190:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4190:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==RULE_ID) ) {
                alt67=1;
            }
            else if ( (LA67_0==43||LA67_0==70) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4191:5: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference9852);
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4201:5: this_XFunctionTypeRef_1= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference9879);
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4217:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4218:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4219:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef9914);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef9924); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4226:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
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
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4229:28: ( ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4230:1: ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4230:1: ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4230:2: (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4230:2: (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==43) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4230:4: otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,43,FOLLOW_43_in_ruleXFunctionTypeRef9962); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4234:1: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4235:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4235:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4236:3: lv_paramTypes_1_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef9983);
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

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4252:2: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==42) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4252:4: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                    	    {
                    	    otherlv_2=(Token)match(input,42,FOLLOW_42_in_ruleXFunctionTypeRef9996); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_2_0());
                    	          
                    	    }
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4256:1: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4257:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                    	    {
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4257:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4258:3: lv_paramTypes_3_0= ruleJvmTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10017);
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
                    	    break loop68;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,44,FOLLOW_44_in_ruleXFunctionTypeRef10031); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_3());
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,70,FOLLOW_70_in_ruleXFunctionTypeRef10045); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4282:1: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4283:1: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4283:1: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4284:3: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10066);
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4308:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4309:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4310:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference10102);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference10112); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4317:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4320:28: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4321:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4321:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4321:2: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4321:2: ( ( ruleQualifiedName ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4322:1: ( ruleQualifiedName )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4322:1: ( ruleQualifiedName )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4323:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference10160);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4336:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt71=2;
            alt71 = dfa71.predict(input);
            switch (alt71) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4336:3: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4336:3: ( ( '<' )=>otherlv_1= '<' )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4336:4: ( '<' )=>otherlv_1= '<'
                    {
                    otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleJvmParameterizedTypeReference10181); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
                          
                    }

                    }

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4341:2: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4342:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4342:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4343:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference10203);
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

                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4359:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==42) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4359:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,42,FOLLOW_42_in_ruleJvmParameterizedTypeReference10216); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4363:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4364:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4364:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4365:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference10237);
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
                    	    break loop70;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,28,FOLLOW_28_in_ruleJvmParameterizedTypeReference10251); if (state.failed) return current;
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4393:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4394:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4395:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference10289);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference10299); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4402:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4405:28: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4406:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4406:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_ID||LA72_0==43||LA72_0==70) ) {
                alt72=1;
            }
            else if ( (LA72_0==71) ) {
                alt72=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4407:5: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference10346);
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4417:5: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference10373);
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4433:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4434:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4435:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference10408);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference10418); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4442:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4445:28: ( ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4446:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4446:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4446:2: () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4446:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4447:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,71,FOLLOW_71_in_ruleJvmWildcardTypeReference10464); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4456:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt73=3;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==72) ) {
                alt73=1;
            }
            else if ( (LA73_0==59) ) {
                alt73=2;
            }
            switch (alt73) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4456:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4456:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4457:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4457:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4458:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference10486);
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
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4475:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4475:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4476:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4476:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4477:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference10513);
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4501:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4502:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4503:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound10551);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound10561); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4510:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4513:28: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4514:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4514:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4514:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,72,FOLLOW_72_in_ruleJvmUpperBound10598); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4518:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4519:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4519:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4520:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound10619);
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4544:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4545:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4546:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded10655);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded10665); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4553:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4556:28: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4557:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4557:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4557:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,73,FOLLOW_73_in_ruleJvmUpperBoundAnded10702); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4561:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4562:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4562:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4563:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded10723);
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4587:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4588:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4589:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound10759);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound10769); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4596:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4599:28: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4600:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4600:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4600:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,59,FOLLOW_59_in_ruleJvmLowerBound10806); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
                  
            }
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4604:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4605:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4605:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4606:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound10827);
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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4632:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4633:2: (iv_ruleValidID= ruleValidID EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4634:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID10866);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID10877); if (state.failed) return current;

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4641:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4644:28: (this_ID_0= RULE_ID )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4645:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID10916); if (state.failed) return current;
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
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:484:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:484:4: ( () ( ( ruleOpMultiAssign ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:484:4: ( () ( ( ruleOpMultiAssign ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:484:5: () ( ( ruleOpMultiAssign ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:484:5: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:485:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:485:2: ( ( ruleOpMultiAssign ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:486:1: ( ruleOpMultiAssign )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:486:1: ( ruleOpMultiAssign )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:487:3: ruleOpMultiAssign
        {
        pushFollow(FOLLOW_ruleOpMultiAssign_in_synpred1_InternalSGen1076);
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
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:612:3: ( ( () ( ( ruleOpOr ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:612:4: ( () ( ( ruleOpOr ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:612:4: ( () ( ( ruleOpOr ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:612:5: () ( ( ruleOpOr ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:612:5: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:613:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:613:2: ( ( ruleOpOr ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:614:1: ( ruleOpOr )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:614:1: ( ruleOpOr )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:615:3: ruleOpOr
        {
        pushFollow(FOLLOW_ruleOpOr_in_synpred2_InternalSGen1424);
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
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:713:3: ( ( () ( ( ruleOpAnd ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:713:4: ( () ( ( ruleOpAnd ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:713:4: ( () ( ( ruleOpAnd ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:713:5: () ( ( ruleOpAnd ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:713:5: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:714:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:714:2: ( ( ruleOpAnd ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:715:1: ( ruleOpAnd )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:715:1: ( ruleOpAnd )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:716:3: ruleOpAnd
        {
        pushFollow(FOLLOW_ruleOpAnd_in_synpred3_InternalSGen1683);
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
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:814:3: ( ( () ( ( ruleOpEquality ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:814:4: ( () ( ( ruleOpEquality ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:814:4: ( () ( ( ruleOpEquality ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:814:5: () ( ( ruleOpEquality ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:814:5: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:815:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:815:2: ( ( ruleOpEquality ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:816:1: ( ruleOpEquality )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:816:1: ( ruleOpEquality )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:817:3: ruleOpEquality
        {
        pushFollow(FOLLOW_ruleOpEquality_in_synpred4_InternalSGen1942);
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
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:922:4: ( ( () 'instanceof' ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:922:5: ( () 'instanceof' )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:922:5: ( () 'instanceof' )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:922:6: () 'instanceof'
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:922:6: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:923:1: 
        {
        }

        match(input,25,FOLLOW_25_in_synpred5_InternalSGen2218); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalSGen

    // $ANTLR start synpred6_InternalSGen
    public final void synpred6_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:950:8: ( ( () ( ( ruleOpCompare ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:950:9: ( () ( ( ruleOpCompare ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:950:9: ( () ( ( ruleOpCompare ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:950:10: () ( ( ruleOpCompare ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:950:10: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:951:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:951:2: ( ( ruleOpCompare ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:952:1: ( ruleOpCompare )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:952:1: ( ruleOpCompare )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:953:3: ruleOpCompare
        {
        pushFollow(FOLLOW_ruleOpCompare_in_synpred6_InternalSGen2291);
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
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1072:3: ( ( () ( ( ruleOpOther ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1072:4: ( () ( ( ruleOpOther ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1072:4: ( () ( ( ruleOpOther ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1072:5: () ( ( ruleOpOther ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1072:5: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1073:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1073:2: ( ( ruleOpOther ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1074:1: ( ruleOpOther )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1074:1: ( ruleOpOther )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1075:3: ruleOpOther
        {
        pushFollow(FOLLOW_ruleOpOther_in_synpred7_InternalSGen2610);
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
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1180:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1180:4: ( () ( ( ruleOpAdd ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1180:4: ( () ( ( ruleOpAdd ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1180:5: () ( ( ruleOpAdd ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1180:5: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1181:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1181:2: ( ( ruleOpAdd ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1182:1: ( ruleOpAdd )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1182:1: ( ruleOpAdd )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1183:3: ruleOpAdd
        {
        pushFollow(FOLLOW_ruleOpAdd_in_synpred8_InternalSGen2890);
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
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1288:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1288:4: ( () ( ( ruleOpMulti ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1288:4: ( () ( ( ruleOpMulti ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1288:5: () ( ( ruleOpMulti ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1288:5: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1289:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1289:2: ( ( ruleOpMulti ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1290:1: ( ruleOpMulti )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1290:1: ( ruleOpMulti )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1291:3: ruleOpMulti
        {
        pushFollow(FOLLOW_ruleOpMulti_in_synpred9_InternalSGen3170);
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
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1521:3: ( ( () 'as' ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1521:4: ( () 'as' )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1521:4: ( () 'as' )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1521:5: () 'as'
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1521:5: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1522:1: 
        {
        }

        match(input,39,FOLLOW_39_in_synpred10_InternalSGen3764); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred10_InternalSGen

    // $ANTLR start synpred11_InternalSGen
    public final void synpred11_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1581:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1581:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1581:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1581:6: () '.' ( ( ruleValidID ) ) ruleOpSingleAssign
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1581:6: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1582:1: 
        {
        }

        match(input,19,FOLLOW_19_in_synpred11_InternalSGen3918); if (state.failed) return ;
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1583:1: ( ( ruleValidID ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1584:1: ( ruleValidID )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1584:1: ( ruleValidID )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1585:3: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred11_InternalSGen3927);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        pushFollow(FOLLOW_ruleOpSingleAssign_in_synpred11_InternalSGen3933);
        ruleOpSingleAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_InternalSGen

    // $ANTLR start synpred12_InternalSGen
    public final void synpred12_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1639:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1639:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1639:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1639:10: () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1639:10: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1640:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1640:2: ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        int alt74=3;
        switch ( input.LA(1) ) {
        case 19:
            {
            alt74=1;
            }
            break;
        case 40:
            {
            alt74=2;
            }
            break;
        case 41:
            {
            alt74=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 74, 0, input);

            throw nvae;
        }

        switch (alt74) {
            case 1 :
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1640:4: '.'
                {
                match(input,19,FOLLOW_19_in_synpred12_InternalSGen4036); if (state.failed) return ;

                }
                break;
            case 2 :
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1642:6: ( ( '?.' ) )
                {
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1642:6: ( ( '?.' ) )
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1643:1: ( '?.' )
                {
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1643:1: ( '?.' )
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1644:2: '?.'
                {
                match(input,40,FOLLOW_40_in_synpred12_InternalSGen4050); if (state.failed) return ;

                }


                }


                }
                break;
            case 3 :
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1649:6: ( ( '*.' ) )
                {
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1649:6: ( ( '*.' ) )
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1650:1: ( '*.' )
                {
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1650:1: ( '*.' )
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1651:2: '*.'
                {
                match(input,41,FOLLOW_41_in_synpred12_InternalSGen4070); if (state.failed) return ;

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
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1760:4: ( ( '(' ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1761:1: ( '(' )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1761:1: ( '(' )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1762:2: '('
        {
        match(input,43,FOLLOW_43_in_synpred13_InternalSGen4297); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalSGen

    // $ANTLR start synpred14_InternalSGen
    public final void synpred14_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1781:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1781:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1781:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1781:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|'
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1781:6: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1782:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1782:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt76=2;
        int LA76_0 = input.LA(1);

        if ( (LA76_0==RULE_ID||LA76_0==43||LA76_0==70) ) {
            alt76=1;
        }
        switch (alt76) {
            case 1 :
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1782:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1782:3: ( ( ruleJvmFormalParameter ) )
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1783:1: ( ruleJvmFormalParameter )
                {
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1783:1: ( ruleJvmFormalParameter )
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1784:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalSGen4349);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1786:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop75:
                do {
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==42) ) {
                        alt75=1;
                    }


                    switch (alt75) {
                	case 1 :
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1786:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,42,FOLLOW_42_in_synpred14_InternalSGen4356); if (state.failed) return ;
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1787:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1788:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1788:1: ( ruleJvmFormalParameter )
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:1789:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalSGen4363);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop75;
                    }
                } while (true);


                }
                break;

        }

        match(input,46,FOLLOW_46_in_synpred14_InternalSGen4373); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_InternalSGen

    // $ANTLR start synpred16_InternalSGen
    public final void synpred16_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2395:4: ( 'else' )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:2395:6: 'else'
        {
        match(input,49,FOLLOW_49_in_synpred16_InternalSGen5818); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalSGen

    // $ANTLR start synpred17_InternalSGen
    public final void synpred17_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3019:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3019:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3019:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3019:6: ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3019:6: ( ( ruleJvmTypeReference ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3020:1: ( ruleJvmTypeReference )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3020:1: ( ruleJvmTypeReference )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3021:1: ruleJvmTypeReference
        {
        pushFollow(FOLLOW_ruleJvmTypeReference_in_synpred17_InternalSGen7184);
        ruleJvmTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3023:2: ( ( ruleValidID ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3024:1: ( ruleValidID )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3024:1: ( ruleValidID )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3025:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred17_InternalSGen7193);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred17_InternalSGen

    // $ANTLR start synpred18_InternalSGen
    public final void synpred18_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3266:4: ( ( '(' ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3267:1: ( '(' )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3267:1: ( '(' )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3268:2: '('
        {
        match(input,43,FOLLOW_43_in_synpred18_InternalSGen7642); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred18_InternalSGen

    // $ANTLR start synpred19_InternalSGen
    public final void synpred19_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3287:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3287:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3287:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3287:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|'
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3287:6: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3288:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3288:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt80=2;
        int LA80_0 = input.LA(1);

        if ( (LA80_0==RULE_ID||LA80_0==43||LA80_0==70) ) {
            alt80=1;
        }
        switch (alt80) {
            case 1 :
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3288:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3288:3: ( ( ruleJvmFormalParameter ) )
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3289:1: ( ruleJvmFormalParameter )
                {
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3289:1: ( ruleJvmFormalParameter )
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3290:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred19_InternalSGen7694);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3292:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop79:
                do {
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==42) ) {
                        alt79=1;
                    }


                    switch (alt79) {
                	case 1 :
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3292:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,42,FOLLOW_42_in_synpred19_InternalSGen7701); if (state.failed) return ;
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3293:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3294:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3294:1: ( ruleJvmFormalParameter )
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3295:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred19_InternalSGen7708);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop79;
                    }
                } while (true);


                }
                break;

        }

        match(input,46,FOLLOW_46_in_synpred19_InternalSGen7718); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred19_InternalSGen

    // $ANTLR start synpred20_InternalSGen
    public final void synpred20_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3536:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3536:4: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3536:4: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3536:5: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|'
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3536:5: ()
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3537:1: 
        {
        }

        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3537:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt82=2;
        int LA82_0 = input.LA(1);

        if ( (LA82_0==RULE_ID||LA82_0==43||LA82_0==70) ) {
            alt82=1;
        }
        switch (alt82) {
            case 1 :
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3537:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3537:3: ( ( ruleJvmFormalParameter ) )
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3538:1: ( ruleJvmFormalParameter )
                {
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3538:1: ( ruleJvmFormalParameter )
                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3539:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred20_InternalSGen8289);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3541:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop81:
                do {
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==42) ) {
                        alt81=1;
                    }


                    switch (alt81) {
                	case 1 :
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3541:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,42,FOLLOW_42_in_synpred20_InternalSGen8296); if (state.failed) return ;
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3542:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3543:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3543:1: ( ruleJvmFormalParameter )
                	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3544:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred20_InternalSGen8303);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop81;
                    }
                } while (true);


                }
                break;

        }

        match(input,46,FOLLOW_46_in_synpred20_InternalSGen8313); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred20_InternalSGen

    // $ANTLR start synpred21_InternalSGen
    public final void synpred21_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3912:2: ( ( ruleXExpression ) )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3913:1: ( ruleXExpression )
        {
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3913:1: ( ruleXExpression )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3914:1: ruleXExpression
        {
        pushFollow(FOLLOW_ruleXExpression_in_synpred21_InternalSGen9194);
        ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred21_InternalSGen

    // $ANTLR start synpred22_InternalSGen
    public final void synpred22_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3983:5: ( 'catch' )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:3983:7: 'catch'
        {
        match(input,69,FOLLOW_69_in_synpred22_InternalSGen9339); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_InternalSGen

    // $ANTLR start synpred23_InternalSGen
    public final void synpred23_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4002:5: ( 'finally' )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4002:7: 'finally'
        {
        match(input,68,FOLLOW_68_in_synpred23_InternalSGen9369); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_InternalSGen

    // $ANTLR start synpred25_InternalSGen
    public final void synpred25_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4150:3: ( '.' )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4151:2: '.'
        {
        match(input,19,FOLLOW_19_in_synpred25_InternalSGen9716); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_InternalSGen

    // $ANTLR start synpred26_InternalSGen
    public final void synpred26_InternalSGen_fragment() throws RecognitionException {   
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4336:4: ( '<' )
        // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:4336:6: '<'
        {
        match(input,29,FOLLOW_29_in_synpred26_InternalSGen10173); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_InternalSGen

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
    public final boolean synpred26_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalSGen_fragment(); // can never throw exception
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
    public final boolean synpred23_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalSGen_fragment(); // can never throw exception
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
    public final boolean synpred22_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalSGen_fragment(); // can never throw exception
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
    public final boolean synpred19_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalSGen_fragment(); // can never throw exception
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
    public final boolean synpred25_InternalSGen() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalSGen_fragment(); // can never throw exception
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
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA54 dfa54 = new DFA54(this);
    protected DFA53 dfa53 = new DFA53(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA62 dfa62 = new DFA62(this);
    protected DFA71 dfa71 = new DFA71(this);
    static final String DFA28_eotS =
        "\74\uffff";
    static final String DFA28_eofS =
        "\1\2\73\uffff";
    static final String DFA28_minS =
        "\1\4\1\0\72\uffff";
    static final String DFA28_maxS =
        "\1\106\1\0\72\uffff";
    static final String DFA28_acceptS =
        "\2\uffff\1\2\70\uffff\1\1";
    static final String DFA28_specialS =
        "\1\uffff\1\0\72\uffff}>";
    static final String[] DFA28_transitionS = {
            "\3\2\5\uffff\3\2\4\uffff\30\2\1\1\2\2\1\uffff\30\2",
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
            return "1760:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_1 = input.LA(1);

                         
                        int index28_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index28_1);
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
    static final String DFA27_eotS =
        "\34\uffff";
    static final String DFA27_eofS =
        "\34\uffff";
    static final String DFA27_minS =
        "\1\4\2\0\31\uffff";
    static final String DFA27_maxS =
        "\1\106\2\0\31\uffff";
    static final String DFA27_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA27_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\1\2\5\5\uffff\2\5\17\uffff\1\5\2\uffff\2\5\4\uffff\1\5\4"+
            "\uffff\1\2\1\33\1\5\1\4\1\uffff\1\5\1\uffff\1\5\3\uffff\2\5"+
            "\3\uffff\11\5\2\uffff\1\3",
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

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "1781:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_0 = input.LA(1);

                         
                        int index27_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA27_0==RULE_ID) ) {s = 1;}

                        else if ( (LA27_0==43) ) {s = 2;}

                        else if ( (LA27_0==70) && (synpred14_InternalSGen())) {s = 3;}

                        else if ( (LA27_0==46) && (synpred14_InternalSGen())) {s = 4;}

                        else if ( ((LA27_0>=RULE_INT && LA27_0<=RULE_STRING)||(LA27_0>=12 && LA27_0<=13)||LA27_0==29||(LA27_0>=32 && LA27_0<=33)||LA27_0==38||LA27_0==45||LA27_0==48||LA27_0==50||(LA27_0>=54 && LA27_0<=55)||(LA27_0>=59 && LA27_0<=67)) ) {s = 5;}

                        else if ( (LA27_0==44) ) {s = 27;}

                         
                        input.seek(index27_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_1 = input.LA(1);

                         
                        int index27_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalSGen()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index27_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_2 = input.LA(1);

                         
                        int index27_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalSGen()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index27_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA54_eotS =
        "\74\uffff";
    static final String DFA54_eofS =
        "\1\2\73\uffff";
    static final String DFA54_minS =
        "\1\4\1\0\72\uffff";
    static final String DFA54_maxS =
        "\1\106\1\0\72\uffff";
    static final String DFA54_acceptS =
        "\2\uffff\1\2\70\uffff\1\1";
    static final String DFA54_specialS =
        "\1\uffff\1\0\72\uffff}>";
    static final String[] DFA54_transitionS = {
            "\3\2\5\uffff\3\2\4\uffff\30\2\1\1\2\2\1\uffff\30\2",
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

    static final short[] DFA54_eot = DFA.unpackEncodedString(DFA54_eotS);
    static final short[] DFA54_eof = DFA.unpackEncodedString(DFA54_eofS);
    static final char[] DFA54_min = DFA.unpackEncodedStringToUnsignedChars(DFA54_minS);
    static final char[] DFA54_max = DFA.unpackEncodedStringToUnsignedChars(DFA54_maxS);
    static final short[] DFA54_accept = DFA.unpackEncodedString(DFA54_acceptS);
    static final short[] DFA54_special = DFA.unpackEncodedString(DFA54_specialS);
    static final short[][] DFA54_transition;

    static {
        int numStates = DFA54_transitionS.length;
        DFA54_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA54_transition[i] = DFA.unpackEncodedString(DFA54_transitionS[i]);
        }
    }

    class DFA54 extends DFA {

        public DFA54(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 54;
            this.eot = DFA54_eot;
            this.eof = DFA54_eof;
            this.min = DFA54_min;
            this.max = DFA54_max;
            this.accept = DFA54_accept;
            this.special = DFA54_special;
            this.transition = DFA54_transition;
        }
        public String getDescription() {
            return "3266:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA54_1 = input.LA(1);

                         
                        int index54_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index54_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 54, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA53_eotS =
        "\34\uffff";
    static final String DFA53_eofS =
        "\34\uffff";
    static final String DFA53_minS =
        "\1\4\2\0\31\uffff";
    static final String DFA53_maxS =
        "\1\106\2\0\31\uffff";
    static final String DFA53_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA53_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA53_transitionS = {
            "\1\1\2\5\5\uffff\2\5\17\uffff\1\5\2\uffff\2\5\4\uffff\1\5\4"+
            "\uffff\1\2\1\33\1\5\1\4\1\uffff\1\5\1\uffff\1\5\3\uffff\2\5"+
            "\3\uffff\11\5\2\uffff\1\3",
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

    static final short[] DFA53_eot = DFA.unpackEncodedString(DFA53_eotS);
    static final short[] DFA53_eof = DFA.unpackEncodedString(DFA53_eofS);
    static final char[] DFA53_min = DFA.unpackEncodedStringToUnsignedChars(DFA53_minS);
    static final char[] DFA53_max = DFA.unpackEncodedStringToUnsignedChars(DFA53_maxS);
    static final short[] DFA53_accept = DFA.unpackEncodedString(DFA53_acceptS);
    static final short[] DFA53_special = DFA.unpackEncodedString(DFA53_specialS);
    static final short[][] DFA53_transition;

    static {
        int numStates = DFA53_transitionS.length;
        DFA53_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA53_transition[i] = DFA.unpackEncodedString(DFA53_transitionS[i]);
        }
    }

    class DFA53 extends DFA {

        public DFA53(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 53;
            this.eot = DFA53_eot;
            this.eof = DFA53_eof;
            this.min = DFA53_min;
            this.max = DFA53_max;
            this.accept = DFA53_accept;
            this.special = DFA53_special;
            this.transition = DFA53_transition;
        }
        public String getDescription() {
            return "3287:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA53_0 = input.LA(1);

                         
                        int index53_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA53_0==RULE_ID) ) {s = 1;}

                        else if ( (LA53_0==43) ) {s = 2;}

                        else if ( (LA53_0==70) && (synpred19_InternalSGen())) {s = 3;}

                        else if ( (LA53_0==46) && (synpred19_InternalSGen())) {s = 4;}

                        else if ( ((LA53_0>=RULE_INT && LA53_0<=RULE_STRING)||(LA53_0>=12 && LA53_0<=13)||LA53_0==29||(LA53_0>=32 && LA53_0<=33)||LA53_0==38||LA53_0==45||LA53_0==48||LA53_0==50||(LA53_0>=54 && LA53_0<=55)||(LA53_0>=59 && LA53_0<=67)) ) {s = 5;}

                        else if ( (LA53_0==44) ) {s = 27;}

                         
                        input.seek(index53_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA53_1 = input.LA(1);

                         
                        int index53_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalSGen()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index53_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA53_2 = input.LA(1);

                         
                        int index53_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalSGen()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index53_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 53, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA60_eotS =
        "\34\uffff";
    static final String DFA60_eofS =
        "\34\uffff";
    static final String DFA60_minS =
        "\1\4\2\0\31\uffff";
    static final String DFA60_maxS =
        "\1\106\2\0\31\uffff";
    static final String DFA60_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA60_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA60_transitionS = {
            "\1\1\2\5\5\uffff\2\5\17\uffff\1\5\2\uffff\2\5\4\uffff\1\5\4"+
            "\uffff\1\2\1\33\1\5\1\4\1\uffff\1\5\1\uffff\1\5\3\uffff\2\5"+
            "\3\uffff\11\5\2\uffff\1\3",
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

    static final short[] DFA60_eot = DFA.unpackEncodedString(DFA60_eotS);
    static final short[] DFA60_eof = DFA.unpackEncodedString(DFA60_eofS);
    static final char[] DFA60_min = DFA.unpackEncodedStringToUnsignedChars(DFA60_minS);
    static final char[] DFA60_max = DFA.unpackEncodedStringToUnsignedChars(DFA60_maxS);
    static final short[] DFA60_accept = DFA.unpackEncodedString(DFA60_acceptS);
    static final short[] DFA60_special = DFA.unpackEncodedString(DFA60_specialS);
    static final short[][] DFA60_transition;

    static {
        int numStates = DFA60_transitionS.length;
        DFA60_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA60_transition[i] = DFA.unpackEncodedString(DFA60_transitionS[i]);
        }
    }

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = DFA60_eot;
            this.eof = DFA60_eof;
            this.min = DFA60_min;
            this.max = DFA60_max;
            this.accept = DFA60_accept;
            this.special = DFA60_special;
            this.transition = DFA60_transition;
        }
        public String getDescription() {
            return "3536:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA60_0 = input.LA(1);

                         
                        int index60_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA60_0==RULE_ID) ) {s = 1;}

                        else if ( (LA60_0==43) ) {s = 2;}

                        else if ( (LA60_0==70) && (synpred20_InternalSGen())) {s = 3;}

                        else if ( (LA60_0==46) && (synpred20_InternalSGen())) {s = 4;}

                        else if ( ((LA60_0>=RULE_INT && LA60_0<=RULE_STRING)||(LA60_0>=12 && LA60_0<=13)||LA60_0==29||(LA60_0>=32 && LA60_0<=33)||LA60_0==38||LA60_0==45||LA60_0==48||LA60_0==50||(LA60_0>=54 && LA60_0<=55)||(LA60_0>=59 && LA60_0<=67)) ) {s = 5;}

                        else if ( (LA60_0==44) ) {s = 27;}

                         
                        input.seek(index60_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA60_1 = input.LA(1);

                         
                        int index60_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalSGen()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index60_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA60_2 = input.LA(1);

                         
                        int index60_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalSGen()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index60_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 60, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA62_eotS =
        "\74\uffff";
    static final String DFA62_eofS =
        "\1\31\73\uffff";
    static final String DFA62_minS =
        "\1\4\30\0\43\uffff";
    static final String DFA62_maxS =
        "\1\106\30\0\43\uffff";
    static final String DFA62_acceptS =
        "\31\uffff\1\2\41\uffff\1\1";
    static final String DFA62_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\43\uffff}>";
    static final String[] DFA62_transitionS = {
            "\1\1\1\15\1\17\5\uffff\1\22\1\6\1\31\4\uffff\12\31\1\10\2\31"+
            "\1\4\1\3\4\31\1\2\4\31\1\30\1\31\1\12\1\uffff\1\31\1\21\1\31"+
            "\1\7\3\31\1\23\1\24\3\31\1\11\1\5\1\13\1\14\1\16\1\20\1\25\1"+
            "\26\1\27\3\31",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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

    static final short[] DFA62_eot = DFA.unpackEncodedString(DFA62_eotS);
    static final short[] DFA62_eof = DFA.unpackEncodedString(DFA62_eofS);
    static final char[] DFA62_min = DFA.unpackEncodedStringToUnsignedChars(DFA62_minS);
    static final char[] DFA62_max = DFA.unpackEncodedStringToUnsignedChars(DFA62_maxS);
    static final short[] DFA62_accept = DFA.unpackEncodedString(DFA62_acceptS);
    static final short[] DFA62_special = DFA.unpackEncodedString(DFA62_specialS);
    static final short[][] DFA62_transition;

    static {
        int numStates = DFA62_transitionS.length;
        DFA62_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA62_transition[i] = DFA.unpackEncodedString(DFA62_transitionS[i]);
        }
    }

    class DFA62 extends DFA {

        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = DFA62_eot;
            this.eof = DFA62_eof;
            this.min = DFA62_min;
            this.max = DFA62_max;
            this.accept = DFA62_accept;
            this.special = DFA62_special;
            this.transition = DFA62_transition;
        }
        public String getDescription() {
            return "3912:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA62_1 = input.LA(1);

                         
                        int index62_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA62_2 = input.LA(1);

                         
                        int index62_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA62_3 = input.LA(1);

                         
                        int index62_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA62_4 = input.LA(1);

                         
                        int index62_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA62_5 = input.LA(1);

                         
                        int index62_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA62_6 = input.LA(1);

                         
                        int index62_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA62_7 = input.LA(1);

                         
                        int index62_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA62_8 = input.LA(1);

                         
                        int index62_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA62_9 = input.LA(1);

                         
                        int index62_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA62_10 = input.LA(1);

                         
                        int index62_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA62_11 = input.LA(1);

                         
                        int index62_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA62_12 = input.LA(1);

                         
                        int index62_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA62_13 = input.LA(1);

                         
                        int index62_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA62_14 = input.LA(1);

                         
                        int index62_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA62_15 = input.LA(1);

                         
                        int index62_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA62_16 = input.LA(1);

                         
                        int index62_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA62_17 = input.LA(1);

                         
                        int index62_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA62_18 = input.LA(1);

                         
                        int index62_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA62_19 = input.LA(1);

                         
                        int index62_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA62_20 = input.LA(1);

                         
                        int index62_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA62_21 = input.LA(1);

                         
                        int index62_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA62_22 = input.LA(1);

                         
                        int index62_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA62_23 = input.LA(1);

                         
                        int index62_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA62_24 = input.LA(1);

                         
                        int index62_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index62_24);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 62, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA71_eotS =
        "\74\uffff";
    static final String DFA71_eofS =
        "\1\2\73\uffff";
    static final String DFA71_minS =
        "\1\4\1\0\72\uffff";
    static final String DFA71_maxS =
        "\1\106\1\0\72\uffff";
    static final String DFA71_acceptS =
        "\2\uffff\1\2\70\uffff\1\1";
    static final String DFA71_specialS =
        "\1\uffff\1\0\72\uffff}>";
    static final String[] DFA71_transitionS = {
            "\3\2\5\uffff\3\2\4\uffff\12\2\1\1\20\2\1\uffff\30\2",
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

    static final short[] DFA71_eot = DFA.unpackEncodedString(DFA71_eotS);
    static final short[] DFA71_eof = DFA.unpackEncodedString(DFA71_eofS);
    static final char[] DFA71_min = DFA.unpackEncodedStringToUnsignedChars(DFA71_minS);
    static final char[] DFA71_max = DFA.unpackEncodedStringToUnsignedChars(DFA71_maxS);
    static final short[] DFA71_accept = DFA.unpackEncodedString(DFA71_acceptS);
    static final short[] DFA71_special = DFA.unpackEncodedString(DFA71_specialS);
    static final short[][] DFA71_transition;

    static {
        int numStates = DFA71_transitionS.length;
        DFA71_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA71_transition[i] = DFA.unpackEncodedString(DFA71_transitionS[i]);
        }
    }

    class DFA71 extends DFA {

        public DFA71(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 71;
            this.eot = DFA71_eot;
            this.eof = DFA71_eof;
            this.min = DFA71_min;
            this.max = DFA71_max;
            this.accept = DFA71_accept;
            this.special = DFA71_special;
            this.transition = DFA71_transition;
        }
        public String getDescription() {
            return "4336:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA71_1 = input.LA(1);

                         
                        int index71_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalSGen()) ) {s = 59;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index71_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 71, _s, input);
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
    public static final BitSet FOLLOW_17_in_ruleFeatureParameterValue620 = new BitSet(new long[]{0xE000200000000060L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXLiteral_in_ruleFeatureParameterValue641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_entryRuleQID678 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQID689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID729 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_18_in_ruleQID749 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_19_in_ruleQID768 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID784 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression831 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment921 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXAssignment989 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXAssignment1005 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment1055 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_ruleXAssignment1108 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign1171 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpSingleAssign1182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleOpSingleAssign1219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign1259 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMultiAssign1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleOpMultiAssign1307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1346 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression1356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1403 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression1456 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1479 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr1518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr1529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleOpOr1566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression1605 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression1615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1662 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression1715 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1738 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd1777 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd1788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOpAnd1825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression1864 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression1874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1921 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression1974 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1997 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality2036 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality2047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOpEquality2085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleOpEquality2104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression2144 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression2154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2201 = new BitSet(new long[]{0x000000003E000002L});
    public static final BitSet FOLLOW_25_in_ruleXRelationalExpression2237 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression2262 = new BitSet(new long[]{0x000000003E000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2323 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2346 = new BitSet(new long[]{0x000000003E000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare2386 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare2397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOpCompare2435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOpCompare2454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpCompare2473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpCompare2492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression2532 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression2542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2589 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression2642 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2665 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther2704 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther2715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpOther2753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOpOther2772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression2812 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression2822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2869 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression2922 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2945 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd2984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd2995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOpAdd3033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpAdd3052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression3092 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression3102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3149 = new BitSet(new long[]{0x0000003C00000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3202 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3225 = new BitSet(new long[]{0x0000003C00000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti3264 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti3275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOpMulti3313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOpMulti3332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOpMulti3351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleOpMulti3370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3410 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation3420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3478 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary3564 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary3575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpUnary3613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpUnary3632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOpUnary3651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression3691 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression3701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression3748 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ruleXCastedExpression3783 = new BitSet(new long[]{0x0000080000000010L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression3806 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall3844 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall3854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall3901 = new BitSet(new long[]{0x0000030000080002L});
    public static final BitSet FOLLOW_19_in_ruleXMemberFeatureCall3950 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall3973 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall3989 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall4011 = new BitSet(new long[]{0x0000030000080002L});
    public static final BitSet FOLLOW_19_in_ruleXMemberFeatureCall4097 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_40_in_ruleXMemberFeatureCall4121 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_41_in_ruleXMemberFeatureCall4158 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_29_in_ruleXMemberFeatureCall4187 = new BitSet(new long[]{0x0000080000000010L,0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4208 = new BitSet(new long[]{0x0000040010000000L});
    public static final BitSet FOLLOW_42_in_ruleXMemberFeatureCall4221 = new BitSet(new long[]{0x0000080000000010L,0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4242 = new BitSet(new long[]{0x0000040010000000L});
    public static final BitSet FOLLOW_28_in_ruleXMemberFeatureCall4256 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4281 = new BitSet(new long[]{0x00000B0000080002L});
    public static final BitSet FOLLOW_43_in_ruleXMemberFeatureCall4315 = new BitSet(new long[]{0xF8C5784320003070L,0x000000000000004FL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4390 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4418 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_42_in_ruleXMemberFeatureCall4431 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4452 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_44_in_ruleXMemberFeatureCall4469 = new BitSet(new long[]{0x0000030000080002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression4510 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression4520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression4567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression4594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression4621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression4648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression4675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression4702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression4729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression4756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression4783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression4810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression4837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression4864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression4891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_entryRuleXLiteral4926 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXLiteral4936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXLiteral4983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral5010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_ruleXLiteral5037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXLiteral5064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXLiteral5091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXLiteral5118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure5153 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure5163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleXClosure5209 = new BitSet(new long[]{0x0000480000000010L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5231 = new BitSet(new long[]{0x0000440000000000L});
    public static final BitSet FOLLOW_42_in_ruleXClosure5244 = new BitSet(new long[]{0x0000080000000010L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5265 = new BitSet(new long[]{0x0000440000000000L});
    public static final BitSet FOLLOW_46_in_ruleXClosure5281 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXClosure5302 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXClosure5314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5350 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXShortClosure5360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5458 = new BitSet(new long[]{0x0000440000000000L});
    public static final BitSet FOLLOW_42_in_ruleXShortClosure5471 = new BitSet(new long[]{0x0000080000000010L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5492 = new BitSet(new long[]{0x0000440000000000L});
    public static final BitSet FOLLOW_46_in_ruleXShortClosure5508 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXShortClosure5531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression5567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression5577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleXParenthesizedExpression5614 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression5636 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXParenthesizedExpression5647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression5683 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression5693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleXIfExpression5739 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXIfExpression5751 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression5772 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXIfExpression5784 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression5805 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_ruleXIfExpression5826 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression5848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression5886 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression5896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleXSwitchExpression5942 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression5964 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleXSwitchExpression5976 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression5999 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleXSwitchExpression6011 = new BitSet(new long[]{0x0028080000000010L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6032 = new BitSet(new long[]{0x0038080000004010L,0x0000000000000040L});
    public static final BitSet FOLLOW_52_in_ruleXSwitchExpression6046 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleXSwitchExpression6058 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6079 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleXSwitchExpression6093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart6129 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart6139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6185 = new BitSet(new long[]{0x0028000000000000L});
    public static final BitSet FOLLOW_53_in_ruleXCasePart6199 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6220 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleXCasePart6234 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6291 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXForLoopExpression6301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleXForLoopExpression6347 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXForLoopExpression6359 = new BitSet(new long[]{0x0000080000000010L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6380 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleXForLoopExpression6392 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression6413 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXForLoopExpression6425 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression6446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression6482 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression6492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleXWhileExpression6538 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXWhileExpression6550 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression6571 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXWhileExpression6583 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression6604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression6640 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression6650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleXDoWhileExpression6696 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression6717 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleXDoWhileExpression6729 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXDoWhileExpression6741 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression6762 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXDoWhileExpression6774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression6810 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression6820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleXBlockExpression6866 = new BitSet(new long[]{0xFEC5284320007070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression6888 = new BitSet(new long[]{0xFFC5284320007070L,0x000000000000000FL});
    public static final BitSet FOLLOW_56_in_ruleXBlockExpression6901 = new BitSet(new long[]{0xFEC5284320007070L,0x000000000000000FL});
    public static final BitSet FOLLOW_14_in_ruleXBlockExpression6917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock6953 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock6963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7072 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration7082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleXVariableDeclaration7135 = new BitSet(new long[]{0x0000080000000010L,0x0000000000000040L});
    public static final BitSet FOLLOW_58_in_ruleXVariableDeclaration7166 = new BitSet(new long[]{0x0000080000000010L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7214 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration7235 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration7264 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleXVariableDeclaration7278 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7337 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter7347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter7393 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmFormalParameter7415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall7451 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall7461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall7518 = new BitSet(new long[]{0x0800000020000010L});
    public static final BitSet FOLLOW_29_in_ruleXFeatureCall7532 = new BitSet(new long[]{0x0000080000000010L,0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall7553 = new BitSet(new long[]{0x0000040010000000L});
    public static final BitSet FOLLOW_42_in_ruleXFeatureCall7566 = new BitSet(new long[]{0x0000080000000010L,0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall7587 = new BitSet(new long[]{0x0000040010000000L});
    public static final BitSet FOLLOW_28_in_ruleXFeatureCall7601 = new BitSet(new long[]{0x0800000020000010L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall7626 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleXFeatureCall7660 = new BitSet(new long[]{0xF8C5784320003070L,0x000000000000004FL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXFeatureCall7735 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall7763 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_42_in_ruleXFeatureCall7776 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall7797 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_44_in_ruleXFeatureCall7814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper7853 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdOrSuper7864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleIdOrSuper7911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleIdOrSuper7935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier7976 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStaticQualifier7987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleStaticQualifier8034 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleStaticQualifier8052 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8093 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall8103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleXConstructorCall8149 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8172 = new BitSet(new long[]{0x0000080020000000L});
    public static final BitSet FOLLOW_29_in_ruleXConstructorCall8185 = new BitSet(new long[]{0x0000080000000010L,0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8206 = new BitSet(new long[]{0x0000040010000000L});
    public static final BitSet FOLLOW_42_in_ruleXConstructorCall8219 = new BitSet(new long[]{0x0000080000000010L,0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8240 = new BitSet(new long[]{0x0000040010000000L});
    public static final BitSet FOLLOW_28_in_ruleXConstructorCall8254 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXConstructorCall8268 = new BitSet(new long[]{0xF8C5784320003070L,0x000000000000004FL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXConstructorCall8330 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall8358 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_42_in_ruleXConstructorCall8371 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall8392 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_44_in_ruleXConstructorCall8409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral8445 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral8455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleXBooleanLiteral8502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleXBooleanLiteral8526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral8576 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral8586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleXNullLiteral8632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral8668 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIntLiteral8678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleXIntLiteral8729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral8770 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral8780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXStringLiteral8831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral8872 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral8882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleXTypeLiteral8928 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXTypeLiteral8940 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral8963 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXTypeLiteral8975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9011 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression9021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleXThrowExpression9067 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression9088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression9124 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXReturnExpression9134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleXReturnExpression9180 = new BitSet(new long[]{0xF8C5284320003072L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXReturnExpression9211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9248 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleXTryCatchFinallyExpression9304 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9325 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000030L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression9355 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_68_in_ruleXTryCatchFinallyExpression9377 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleXTryCatchFinallyExpression9421 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause9480 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause9490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleXCatchClause9535 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXCatchClause9548 = new BitSet(new long[]{0x0000080000000010L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause9569 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXCatchClause9581 = new BitSet(new long[]{0xF8C5284320003070L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause9602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName9639 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName9650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName9697 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleQualifiedName9725 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName9748 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference9795 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference9805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference9852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference9879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef9914 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef9924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleXFunctionTypeRef9962 = new BitSet(new long[]{0x0000080000000010L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef9983 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_42_in_ruleXFunctionTypeRef9996 = new BitSet(new long[]{0x0000080000000010L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10017 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_44_in_ruleXFunctionTypeRef10031 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleXFunctionTypeRef10045 = new BitSet(new long[]{0x0000080000000010L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference10102 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference10112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference10160 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleJvmParameterizedTypeReference10181 = new BitSet(new long[]{0x0000080000000010L,0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference10203 = new BitSet(new long[]{0x0000040010000000L});
    public static final BitSet FOLLOW_42_in_ruleJvmParameterizedTypeReference10216 = new BitSet(new long[]{0x0000080000000010L,0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference10237 = new BitSet(new long[]{0x0000040010000000L});
    public static final BitSet FOLLOW_28_in_ruleJvmParameterizedTypeReference10251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference10289 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference10299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference10346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference10373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference10408 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference10418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleJvmWildcardTypeReference10464 = new BitSet(new long[]{0x0800000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference10486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference10513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound10551 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound10561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleJvmUpperBound10598 = new BitSet(new long[]{0x0000080000000010L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound10619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded10655 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded10665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleJvmUpperBoundAnded10702 = new BitSet(new long[]{0x0000080000000010L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded10723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound10759 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound10769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleJvmLowerBound10806 = new BitSet(new long[]{0x0000080000000010L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound10827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID10866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID10877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID10916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_synpred1_InternalSGen1076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred2_InternalSGen1424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred3_InternalSGen1683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred4_InternalSGen1942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_synpred5_InternalSGen2218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred6_InternalSGen2291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred7_InternalSGen2610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred8_InternalSGen2890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred9_InternalSGen3170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred10_InternalSGen3764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_synpred11_InternalSGen3918 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred11_InternalSGen3927 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_synpred11_InternalSGen3933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_synpred12_InternalSGen4036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_synpred12_InternalSGen4050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred12_InternalSGen4070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_synpred13_InternalSGen4297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalSGen4349 = new BitSet(new long[]{0x0000440000000000L});
    public static final BitSet FOLLOW_42_in_synpred14_InternalSGen4356 = new BitSet(new long[]{0x0000080000000010L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalSGen4363 = new BitSet(new long[]{0x0000440000000000L});
    public static final BitSet FOLLOW_46_in_synpred14_InternalSGen4373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_synpred16_InternalSGen5818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred17_InternalSGen7184 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred17_InternalSGen7193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_synpred18_InternalSGen7642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred19_InternalSGen7694 = new BitSet(new long[]{0x0000440000000000L});
    public static final BitSet FOLLOW_42_in_synpred19_InternalSGen7701 = new BitSet(new long[]{0x0000080000000010L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred19_InternalSGen7708 = new BitSet(new long[]{0x0000440000000000L});
    public static final BitSet FOLLOW_46_in_synpred19_InternalSGen7718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred20_InternalSGen8289 = new BitSet(new long[]{0x0000440000000000L});
    public static final BitSet FOLLOW_42_in_synpred20_InternalSGen8296 = new BitSet(new long[]{0x0000080000000010L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred20_InternalSGen8303 = new BitSet(new long[]{0x0000440000000000L});
    public static final BitSet FOLLOW_46_in_synpred20_InternalSGen8313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred21_InternalSGen9194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_synpred22_InternalSGen9339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_synpred23_InternalSGen9369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_synpred25_InternalSGen9716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred26_InternalSGen10173 = new BitSet(new long[]{0x0000000000000002L});

}