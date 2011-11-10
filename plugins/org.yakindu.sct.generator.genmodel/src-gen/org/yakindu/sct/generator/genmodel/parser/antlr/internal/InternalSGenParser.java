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

@SuppressWarnings("all")
public class InternalSGenParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'GeneratorModel'", "'for'", "'{'", "'}'", "'statechart'", "'feature'", "'='", "'::'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
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
             newCompositeNode(grammarAccess.getGeneratorModelRule()); 
            pushFollow(FOLLOW_ruleGeneratorModel_in_entryRuleGeneratorModel75);
            iv_ruleGeneratorModel=ruleGeneratorModel();

            state._fsp--;

             current =iv_ruleGeneratorModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneratorModel85); 

            }

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
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleGeneratorModel122); 

                	newLeafNode(otherlv_0, grammarAccess.getGeneratorModelAccess().getGeneratorModelKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleGeneratorModel134); 

                	newLeafNode(otherlv_1, grammarAccess.getGeneratorModelAccess().getForKeyword_1());
                
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:88:1: ( (lv_generatorId_2_0= ruleQID ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:89:1: (lv_generatorId_2_0= ruleQID )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:89:1: (lv_generatorId_2_0= ruleQID )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:90:3: lv_generatorId_2_0= ruleQID
            {
             
            	        newCompositeNode(grammarAccess.getGeneratorModelAccess().getGeneratorIdQIDParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQID_in_ruleGeneratorModel155);
            lv_generatorId_2_0=ruleQID();

            state._fsp--;


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

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleGeneratorModel167); 

                	newLeafNode(otherlv_3, grammarAccess.getGeneratorModelAccess().getLeftCurlyBracketKeyword_3());
                
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
            	     
            	    	        newCompositeNode(grammarAccess.getGeneratorModelAccess().getEntriesGeneratorEntryParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleGeneratorEntry_in_ruleGeneratorModel188);
            	    lv_entries_4_0=ruleGeneratorEntry();

            	    state._fsp--;


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
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleGeneratorModel201); 

                	newLeafNode(otherlv_5, grammarAccess.getGeneratorModelAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
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
             newCompositeNode(grammarAccess.getGeneratorEntryRule()); 
            pushFollow(FOLLOW_ruleGeneratorEntry_in_entryRuleGeneratorEntry237);
            iv_ruleGeneratorEntry=ruleGeneratorEntry();

            state._fsp--;

             current =iv_ruleGeneratorEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneratorEntry247); 

            }

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
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleGeneratorEntry284); 

                	newLeafNode(otherlv_0, grammarAccess.getGeneratorEntryAccess().getStatechartKeyword_0());
                
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:157:1: ( (otherlv_1= RULE_ID ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:158:1: (otherlv_1= RULE_ID )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:158:1: (otherlv_1= RULE_ID )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:159:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getGeneratorEntryRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratorEntry304); 

            		newLeafNode(otherlv_1, grammarAccess.getGeneratorEntryAccess().getStatechartStatechartCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleGeneratorEntry316); 

                	newLeafNode(otherlv_2, grammarAccess.getGeneratorEntryAccess().getLeftCurlyBracketKeyword_2());
                
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
            	     
            	    	        newCompositeNode(grammarAccess.getGeneratorEntryAccess().getFeaturesFeatureConfigurationParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFeatureConfiguration_in_ruleGeneratorEntry337);
            	    lv_features_3_0=ruleFeatureConfiguration();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleGeneratorEntry350); 

                	newLeafNode(otherlv_4, grammarAccess.getGeneratorEntryAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
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
             newCompositeNode(grammarAccess.getFeatureConfigurationRule()); 
            pushFollow(FOLLOW_ruleFeatureConfiguration_in_entryRuleFeatureConfiguration386);
            iv_ruleFeatureConfiguration=ruleFeatureConfiguration();

            state._fsp--;

             current =iv_ruleFeatureConfiguration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureConfiguration396); 

            }

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

                    current = forceCreateModelElement(
                        grammarAccess.getFeatureConfigurationAccess().getFeatureConfigurationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleFeatureConfiguration442); 

                	newLeafNode(otherlv_1, grammarAccess.getFeatureConfigurationAccess().getFeatureKeyword_1());
                
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:227:1: ( (otherlv_2= RULE_ID ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:228:1: (otherlv_2= RULE_ID )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:228:1: (otherlv_2= RULE_ID )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:229:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFeatureConfigurationRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureConfiguration462); 

            		newLeafNode(otherlv_2, grammarAccess.getFeatureConfigurationAccess().getTypeFeatureTypeCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleFeatureConfiguration474); 

                	newLeafNode(otherlv_3, grammarAccess.getFeatureConfigurationAccess().getLeftCurlyBracketKeyword_3());
                
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
            	     
            	    	        newCompositeNode(grammarAccess.getFeatureConfigurationAccess().getParameterValuesFeatureParameterValueParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFeatureParameterValue_in_ruleFeatureConfiguration495);
            	    lv_parameterValues_4_0=ruleFeatureParameterValue();

            	    state._fsp--;


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
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleFeatureConfiguration508); 

                	newLeafNode(otherlv_5, grammarAccess.getFeatureConfigurationAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
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
             newCompositeNode(grammarAccess.getFeatureParameterValueRule()); 
            pushFollow(FOLLOW_ruleFeatureParameterValue_in_entryRuleFeatureParameterValue544);
            iv_ruleFeatureParameterValue=ruleFeatureParameterValue();

            state._fsp--;

             current =iv_ruleFeatureParameterValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureParameterValue554); 

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:283:1: ruleFeatureParameterValue returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleFeatureParameterValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:286:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:287:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:287:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:287:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:287:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:288:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFeatureParameterValueAccess().getFeatureParameterValueAction_0(),
                        current);
                

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:293:2: ( (otherlv_1= RULE_ID ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:294:1: (otherlv_1= RULE_ID )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:294:1: (otherlv_1= RULE_ID )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:295:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFeatureParameterValueRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureParameterValue608); 

            		newLeafNode(otherlv_1, grammarAccess.getFeatureParameterValueAccess().getParameterFeatureParameterCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleFeatureParameterValue620); 

                	newLeafNode(otherlv_2, grammarAccess.getFeatureParameterValueAccess().getEqualsSignKeyword_2());
                
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:310:1: ( (lv_value_3_0= RULE_STRING ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:311:1: (lv_value_3_0= RULE_STRING )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:311:1: (lv_value_3_0= RULE_STRING )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:312:3: lv_value_3_0= RULE_STRING
            {
            lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleFeatureParameterValue637); 

            			newLeafNode(lv_value_3_0, grammarAccess.getFeatureParameterValueAccess().getValueSTRINGTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFeatureParameterValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
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
             newCompositeNode(grammarAccess.getQIDRule()); 
            pushFollow(FOLLOW_ruleQID_in_entryRuleQID679);
            iv_ruleQID=ruleQID();

            state._fsp--;

             current =iv_ruleQID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQID690); 

            }

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
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID730); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQIDAccess().getIDTerminalRuleCall_0()); 
                
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
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:357:2: kw= '::'
            	            {
            	            kw=(Token)match(input,18,FOLLOW_18_in_ruleQID750); 

            	                    current.merge(kw);
            	                    newLeafNode(kw, grammarAccess.getQIDAccess().getColonColonKeyword_1_0_0()); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:364:2: kw= '.'
            	            {
            	            kw=(Token)match(input,19,FOLLOW_19_in_ruleQID769); 

            	                    current.merge(kw);
            	                    newLeafNode(kw, grammarAccess.getQIDAccess().getFullStopKeyword_1_0_1()); 
            	                

            	            }
            	            break;

            	    }

            	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID785); 

            	    		current.merge(this_ID_3);
            	        
            	     
            	        newLeafNode(this_ID_3, grammarAccess.getQIDAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

             leaveRule(); 
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

    // Delegated rules


 

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
    public static final BitSet FOLLOW_17_in_ruleFeatureParameterValue620 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleFeatureParameterValue637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_entryRuleQID679 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQID690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID730 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_18_in_ruleQID750 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_19_in_ruleQID769 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID785 = new BitSet(new long[]{0x00000000000C0002L});

}