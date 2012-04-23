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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_BOOL", "RULE_INT", "RULE_FLOAT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'GeneratorModel'", "'for'", "'{'", "'}'", "'feature'", "'='", "'::'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__20=20;
    public static final int RULE_BOOL=5;
    public static final int RULE_FLOAT=7;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__19=19;
    public static final int RULE_STRING=8;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=11;

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:76:1: ruleGeneratorModel returns [EObject current=null] : (otherlv_0= 'GeneratorModel' otherlv_1= 'for' ( (lv_generatorId_2_0= ruleQID ) ) otherlv_3= '{' ( (lv_entries_4_0= ruleGeneratorEntry ) )* otherlv_5= '}' ) ;
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
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:79:28: ( (otherlv_0= 'GeneratorModel' otherlv_1= 'for' ( (lv_generatorId_2_0= ruleQID ) ) otherlv_3= '{' ( (lv_entries_4_0= ruleGeneratorEntry ) )* otherlv_5= '}' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:80:1: (otherlv_0= 'GeneratorModel' otherlv_1= 'for' ( (lv_generatorId_2_0= ruleQID ) ) otherlv_3= '{' ( (lv_entries_4_0= ruleGeneratorEntry ) )* otherlv_5= '}' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:80:1: (otherlv_0= 'GeneratorModel' otherlv_1= 'for' ( (lv_generatorId_2_0= ruleQID ) ) otherlv_3= '{' ( (lv_entries_4_0= ruleGeneratorEntry ) )* otherlv_5= '}' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:80:3: otherlv_0= 'GeneratorModel' otherlv_1= 'for' ( (lv_generatorId_2_0= ruleQID ) ) otherlv_3= '{' ( (lv_entries_4_0= ruleGeneratorEntry ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleGeneratorModel122); 

                	newLeafNode(otherlv_0, grammarAccess.getGeneratorModelAccess().getGeneratorModelKeyword_0());
                
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleGeneratorModel134); 

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

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleGeneratorModel167); 

                	newLeafNode(otherlv_3, grammarAccess.getGeneratorModelAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:110:1: ( (lv_entries_4_0= ruleGeneratorEntry ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
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
            	    break loop1;
                }
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleGeneratorModel201); 

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:149:1: ruleGeneratorEntry returns [EObject current=null] : ( ( (lv_contentType_0_0= RULE_ID ) ) ( ( ruleQID ) ) otherlv_2= '{' ( (lv_features_3_0= ruleFeatureConfiguration ) )* otherlv_4= '}' ) ;
    public final EObject ruleGeneratorEntry() throws RecognitionException {
        EObject current = null;

        Token lv_contentType_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_features_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:152:28: ( ( ( (lv_contentType_0_0= RULE_ID ) ) ( ( ruleQID ) ) otherlv_2= '{' ( (lv_features_3_0= ruleFeatureConfiguration ) )* otherlv_4= '}' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:153:1: ( ( (lv_contentType_0_0= RULE_ID ) ) ( ( ruleQID ) ) otherlv_2= '{' ( (lv_features_3_0= ruleFeatureConfiguration ) )* otherlv_4= '}' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:153:1: ( ( (lv_contentType_0_0= RULE_ID ) ) ( ( ruleQID ) ) otherlv_2= '{' ( (lv_features_3_0= ruleFeatureConfiguration ) )* otherlv_4= '}' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:153:2: ( (lv_contentType_0_0= RULE_ID ) ) ( ( ruleQID ) ) otherlv_2= '{' ( (lv_features_3_0= ruleFeatureConfiguration ) )* otherlv_4= '}'
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:153:2: ( (lv_contentType_0_0= RULE_ID ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:154:1: (lv_contentType_0_0= RULE_ID )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:154:1: (lv_contentType_0_0= RULE_ID )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:155:3: lv_contentType_0_0= RULE_ID
            {
            lv_contentType_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratorEntry289); 

            			newLeafNode(lv_contentType_0_0, grammarAccess.getGeneratorEntryAccess().getContentTypeIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getGeneratorEntryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"contentType",
                    		lv_contentType_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:171:2: ( ( ruleQID ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:172:1: ( ruleQID )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:172:1: ( ruleQID )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:173:3: ruleQID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getGeneratorEntryRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getGeneratorEntryAccess().getElementRefEObjectCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQID_in_ruleGeneratorEntry317);
            ruleQID();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleGeneratorEntry329); 

                	newLeafNode(otherlv_2, grammarAccess.getGeneratorEntryAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:190:1: ( (lv_features_3_0= ruleFeatureConfiguration ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==17) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:191:1: (lv_features_3_0= ruleFeatureConfiguration )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:191:1: (lv_features_3_0= ruleFeatureConfiguration )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:192:3: lv_features_3_0= ruleFeatureConfiguration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGeneratorEntryAccess().getFeaturesFeatureConfigurationParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFeatureConfiguration_in_ruleGeneratorEntry350);
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

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleGeneratorEntry363); 

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:220:1: entryRuleFeatureConfiguration returns [EObject current=null] : iv_ruleFeatureConfiguration= ruleFeatureConfiguration EOF ;
    public final EObject entryRuleFeatureConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureConfiguration = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:221:2: (iv_ruleFeatureConfiguration= ruleFeatureConfiguration EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:222:2: iv_ruleFeatureConfiguration= ruleFeatureConfiguration EOF
            {
             newCompositeNode(grammarAccess.getFeatureConfigurationRule()); 
            pushFollow(FOLLOW_ruleFeatureConfiguration_in_entryRuleFeatureConfiguration399);
            iv_ruleFeatureConfiguration=ruleFeatureConfiguration();

            state._fsp--;

             current =iv_ruleFeatureConfiguration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureConfiguration409); 

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:229:1: ruleFeatureConfiguration returns [EObject current=null] : ( () otherlv_1= 'feature' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_parameterValues_4_0= ruleFeatureParameterValue ) )* otherlv_5= '}' ) ;
    public final EObject ruleFeatureConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_parameterValues_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:232:28: ( ( () otherlv_1= 'feature' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_parameterValues_4_0= ruleFeatureParameterValue ) )* otherlv_5= '}' ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:233:1: ( () otherlv_1= 'feature' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_parameterValues_4_0= ruleFeatureParameterValue ) )* otherlv_5= '}' )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:233:1: ( () otherlv_1= 'feature' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_parameterValues_4_0= ruleFeatureParameterValue ) )* otherlv_5= '}' )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:233:2: () otherlv_1= 'feature' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_parameterValues_4_0= ruleFeatureParameterValue ) )* otherlv_5= '}'
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:233:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:234:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFeatureConfigurationAccess().getFeatureConfigurationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleFeatureConfiguration455); 

                	newLeafNode(otherlv_1, grammarAccess.getFeatureConfigurationAccess().getFeatureKeyword_1());
                
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:243:1: ( (otherlv_2= RULE_ID ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:244:1: (otherlv_2= RULE_ID )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:244:1: (otherlv_2= RULE_ID )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:245:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFeatureConfigurationRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureConfiguration475); 

            		newLeafNode(otherlv_2, grammarAccess.getFeatureConfigurationAccess().getTypeFeatureTypeCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleFeatureConfiguration487); 

                	newLeafNode(otherlv_3, grammarAccess.getFeatureConfigurationAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:260:1: ( (lv_parameterValues_4_0= ruleFeatureParameterValue ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:261:1: (lv_parameterValues_4_0= ruleFeatureParameterValue )
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:261:1: (lv_parameterValues_4_0= ruleFeatureParameterValue )
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:262:3: lv_parameterValues_4_0= ruleFeatureParameterValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFeatureConfigurationAccess().getParameterValuesFeatureParameterValueParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFeatureParameterValue_in_ruleFeatureConfiguration508);
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
            	    break loop3;
                }
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleFeatureConfiguration521); 

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:290:1: entryRuleFeatureParameterValue returns [EObject current=null] : iv_ruleFeatureParameterValue= ruleFeatureParameterValue EOF ;
    public final EObject entryRuleFeatureParameterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureParameterValue = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:291:2: (iv_ruleFeatureParameterValue= ruleFeatureParameterValue EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:292:2: iv_ruleFeatureParameterValue= ruleFeatureParameterValue EOF
            {
             newCompositeNode(grammarAccess.getFeatureParameterValueRule()); 
            pushFollow(FOLLOW_ruleFeatureParameterValue_in_entryRuleFeatureParameterValue557);
            iv_ruleFeatureParameterValue=ruleFeatureParameterValue();

            state._fsp--;

             current =iv_ruleFeatureParameterValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureParameterValue567); 

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:299:1: ruleFeatureParameterValue returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleLiteral ) ) ) ;
    public final EObject ruleFeatureParameterValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:302:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleLiteral ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:303:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleLiteral ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:303:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleLiteral ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:303:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleLiteral ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:303:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:304:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFeatureParameterValueAccess().getFeatureParameterValueAction_0(),
                        current);
                

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:309:2: ( (otherlv_1= RULE_ID ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:310:1: (otherlv_1= RULE_ID )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:310:1: (otherlv_1= RULE_ID )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:311:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFeatureParameterValueRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureParameterValue621); 

            		newLeafNode(otherlv_1, grammarAccess.getFeatureParameterValueAccess().getParameterFeatureParameterCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleFeatureParameterValue633); 

                	newLeafNode(otherlv_2, grammarAccess.getFeatureParameterValueAccess().getEqualsSignKeyword_2());
                
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:326:1: ( (lv_expression_3_0= ruleLiteral ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:327:1: (lv_expression_3_0= ruleLiteral )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:327:1: (lv_expression_3_0= ruleLiteral )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:328:3: lv_expression_3_0= ruleLiteral
            {
             
            	        newCompositeNode(grammarAccess.getFeatureParameterValueAccess().getExpressionLiteralParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleLiteral_in_ruleFeatureParameterValue654);
            lv_expression_3_0=ruleLiteral();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFeatureParameterValueRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_3_0, 
                    		"Literal");
            	        afterParserOrEnumRuleCall();
            	    

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


    // $ANTLR start "entryRuleLiteral"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:352:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:353:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:354:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral690);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral700); 

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:361:1: ruleLiteral returns [EObject current=null] : (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_RealLiteral_2= ruleRealLiteral | this_StringLiteral_3= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BoolLiteral_0 = null;

        EObject this_IntLiteral_1 = null;

        EObject this_RealLiteral_2 = null;

        EObject this_StringLiteral_3 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:364:28: ( (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_RealLiteral_2= ruleRealLiteral | this_StringLiteral_3= ruleStringLiteral ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:365:1: (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_RealLiteral_2= ruleRealLiteral | this_StringLiteral_3= ruleStringLiteral )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:365:1: (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_RealLiteral_2= ruleRealLiteral | this_StringLiteral_3= ruleStringLiteral )
            int alt4=4;
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
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:366:5: this_BoolLiteral_0= ruleBoolLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getBoolLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleBoolLiteral_in_ruleLiteral747);
                    this_BoolLiteral_0=ruleBoolLiteral();

                    state._fsp--;

                     
                            current = this_BoolLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:376:5: this_IntLiteral_1= ruleIntLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getIntLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIntLiteral_in_ruleLiteral774);
                    this_IntLiteral_1=ruleIntLiteral();

                    state._fsp--;

                     
                            current = this_IntLiteral_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:386:5: this_RealLiteral_2= ruleRealLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getRealLiteralParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleLiteral801);
                    this_RealLiteral_2=ruleRealLiteral();

                    state._fsp--;

                     
                            current = this_RealLiteral_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:396:5: this_StringLiteral_3= ruleStringLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleLiteral828);
                    this_StringLiteral_3=ruleStringLiteral();

                    state._fsp--;

                     
                            current = this_StringLiteral_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

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
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleBoolLiteral"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:412:1: entryRuleBoolLiteral returns [EObject current=null] : iv_ruleBoolLiteral= ruleBoolLiteral EOF ;
    public final EObject entryRuleBoolLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolLiteral = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:413:2: (iv_ruleBoolLiteral= ruleBoolLiteral EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:414:2: iv_ruleBoolLiteral= ruleBoolLiteral EOF
            {
             newCompositeNode(grammarAccess.getBoolLiteralRule()); 
            pushFollow(FOLLOW_ruleBoolLiteral_in_entryRuleBoolLiteral863);
            iv_ruleBoolLiteral=ruleBoolLiteral();

            state._fsp--;

             current =iv_ruleBoolLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoolLiteral873); 

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:421:1: ruleBoolLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_BOOL ) ) ) ;
    public final EObject ruleBoolLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:424:28: ( ( () ( (lv_value_1_0= RULE_BOOL ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:425:1: ( () ( (lv_value_1_0= RULE_BOOL ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:425:1: ( () ( (lv_value_1_0= RULE_BOOL ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:425:2: () ( (lv_value_1_0= RULE_BOOL ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:425:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:426:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBoolLiteralAccess().getBoolLiteralAction_0(),
                        current);
                

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:431:2: ( (lv_value_1_0= RULE_BOOL ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:432:1: (lv_value_1_0= RULE_BOOL )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:432:1: (lv_value_1_0= RULE_BOOL )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:433:3: lv_value_1_0= RULE_BOOL
            {
            lv_value_1_0=(Token)match(input,RULE_BOOL,FOLLOW_RULE_BOOL_in_ruleBoolLiteral924); 

            			newLeafNode(lv_value_1_0, grammarAccess.getBoolLiteralAccess().getValueBOOLTerminalRuleCall_1_0()); 
            		

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
    // $ANTLR end "ruleBoolLiteral"


    // $ANTLR start "entryRuleIntLiteral"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:457:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:458:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:459:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
             newCompositeNode(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral965);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;

             current =iv_ruleIntLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral975); 

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:466:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:469:28: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:470:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:470:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:470:2: () ( (lv_value_1_0= RULE_INT ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:470:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:471:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
                        current);
                

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:476:2: ( (lv_value_1_0= RULE_INT ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:477:1: (lv_value_1_0= RULE_INT )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:477:1: (lv_value_1_0= RULE_INT )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:478:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIntLiteral1026); 

            			newLeafNode(lv_value_1_0, grammarAccess.getIntLiteralAccess().getValueINTTerminalRuleCall_1_0()); 
            		

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
    // $ANTLR end "ruleIntLiteral"


    // $ANTLR start "entryRuleRealLiteral"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:502:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:503:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:504:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             newCompositeNode(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral1067);
            iv_ruleRealLiteral=ruleRealLiteral();

            state._fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral1077); 

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:511:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_FLOAT ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:514:28: ( ( () ( (lv_value_1_0= RULE_FLOAT ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:515:1: ( () ( (lv_value_1_0= RULE_FLOAT ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:515:1: ( () ( (lv_value_1_0= RULE_FLOAT ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:515:2: () ( (lv_value_1_0= RULE_FLOAT ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:515:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:516:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                        current);
                

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:521:2: ( (lv_value_1_0= RULE_FLOAT ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:522:1: (lv_value_1_0= RULE_FLOAT )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:522:1: (lv_value_1_0= RULE_FLOAT )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:523:3: lv_value_1_0= RULE_FLOAT
            {
            lv_value_1_0=(Token)match(input,RULE_FLOAT,FOLLOW_RULE_FLOAT_in_ruleRealLiteral1128); 

            			newLeafNode(lv_value_1_0, grammarAccess.getRealLiteralAccess().getValueFLOATTerminalRuleCall_1_0()); 
            		

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
    // $ANTLR end "ruleRealLiteral"


    // $ANTLR start "entryRuleStringLiteral"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:547:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:548:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:549:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral1169);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral1179); 

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:556:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:559:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:560:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:560:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:560:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:560:2: ()
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:561:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
                        current);
                

            }

            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:566:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:567:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:567:1: (lv_value_1_0= RULE_STRING )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:568:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral1230); 

            			newLeafNode(lv_value_1_0, grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            		

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
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleQID"
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:592:1: entryRuleQID returns [String current=null] : iv_ruleQID= ruleQID EOF ;
    public final String entryRuleQID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQID = null;


        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:593:2: (iv_ruleQID= ruleQID EOF )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:594:2: iv_ruleQID= ruleQID EOF
            {
             newCompositeNode(grammarAccess.getQIDRule()); 
            pushFollow(FOLLOW_ruleQID_in_entryRuleQID1272);
            iv_ruleQID=ruleQID();

            state._fsp--;

             current =iv_ruleQID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQID1283); 

            }

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
    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:601:1: ruleQID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( (kw= '::' | kw= '.' ) this_ID_3= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_3=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:604:28: ( (this_ID_0= RULE_ID ( (kw= '::' | kw= '.' ) this_ID_3= RULE_ID )* ) )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:605:1: (this_ID_0= RULE_ID ( (kw= '::' | kw= '.' ) this_ID_3= RULE_ID )* )
            {
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:605:1: (this_ID_0= RULE_ID ( (kw= '::' | kw= '.' ) this_ID_3= RULE_ID )* )
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:605:6: this_ID_0= RULE_ID ( (kw= '::' | kw= '.' ) this_ID_3= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID1323); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQIDAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:612:1: ( (kw= '::' | kw= '.' ) this_ID_3= RULE_ID )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=19 && LA6_0<=20)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:612:2: (kw= '::' | kw= '.' ) this_ID_3= RULE_ID
            	    {
            	    // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:612:2: (kw= '::' | kw= '.' )
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==19) ) {
            	        alt5=1;
            	    }
            	    else if ( (LA5_0==20) ) {
            	        alt5=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 5, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:613:2: kw= '::'
            	            {
            	            kw=(Token)match(input,19,FOLLOW_19_in_ruleQID1343); 

            	                    current.merge(kw);
            	                    newLeafNode(kw, grammarAccess.getQIDAccess().getColonColonKeyword_1_0_0()); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../org.yakindu.sct.generator.genmodel/src-gen/org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.g:620:2: kw= '.'
            	            {
            	            kw=(Token)match(input,20,FOLLOW_20_in_ruleQID1362); 

            	                    current.merge(kw);
            	                    newLeafNode(kw, grammarAccess.getQIDAccess().getFullStopKeyword_1_0_1()); 
            	                

            	            }
            	            break;

            	    }

            	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID1378); 

            	    		current.merge(this_ID_3);
            	        
            	     
            	        newLeafNode(this_ID_3, grammarAccess.getQIDAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop6;
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
    public static final BitSet FOLLOW_13_in_ruleGeneratorModel122 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleGeneratorModel134 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQID_in_ruleGeneratorModel155 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleGeneratorModel167 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_ruleGeneratorEntry_in_ruleGeneratorModel188 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_16_in_ruleGeneratorModel201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratorEntry_in_entryRuleGeneratorEntry237 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneratorEntry247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratorEntry289 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQID_in_ruleGeneratorEntry317 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleGeneratorEntry329 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_ruleFeatureConfiguration_in_ruleGeneratorEntry350 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleGeneratorEntry363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureConfiguration_in_entryRuleFeatureConfiguration399 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureConfiguration409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleFeatureConfiguration455 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureConfiguration475 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFeatureConfiguration487 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_ruleFeatureParameterValue_in_ruleFeatureConfiguration508 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_16_in_ruleFeatureConfiguration521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureParameterValue_in_entryRuleFeatureParameterValue557 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureParameterValue567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureParameterValue621 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleFeatureParameterValue633 = new BitSet(new long[]{0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleFeatureParameterValue654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolLiteral_in_ruleLiteral747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_ruleLiteral774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleLiteral801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleLiteral828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolLiteral_in_entryRuleBoolLiteral863 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoolLiteral873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOL_in_ruleBoolLiteral924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIntLiteral1026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral1067 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral1077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_FLOAT_in_ruleRealLiteral1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral1169 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_entryRuleQID1272 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQID1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID1323 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_19_in_ruleQID1343 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_20_in_ruleQID1362 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID1378 = new BitSet(new long[]{0x0000000000180002L});

}