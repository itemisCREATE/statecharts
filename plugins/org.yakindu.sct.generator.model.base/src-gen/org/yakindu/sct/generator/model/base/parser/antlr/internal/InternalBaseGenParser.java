package org.yakindu.sct.generator.model.base.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.yakindu.sct.generator.model.base.services.BaseGenGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBaseGenParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'BaseGenerator'", "'{'", "'}'", "'statecharts '", "','", "'outlet'", "'projectName'", "'='", "'folder'"
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


        public InternalBaseGenParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBaseGenParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBaseGenParser.tokenNames; }
    public String getGrammarFileName() { return "../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g"; }



     	private BaseGenGrammarAccess grammarAccess;
     	
        public InternalBaseGenParser(TokenStream input, BaseGenGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "BaseGeneratorModel";	
       	}
       	
       	@Override
       	protected BaseGenGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleBaseGeneratorModel"
    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:67:1: entryRuleBaseGeneratorModel returns [EObject current=null] : iv_ruleBaseGeneratorModel= ruleBaseGeneratorModel EOF ;
    public final EObject entryRuleBaseGeneratorModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseGeneratorModel = null;


        try {
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:68:2: (iv_ruleBaseGeneratorModel= ruleBaseGeneratorModel EOF )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:69:2: iv_ruleBaseGeneratorModel= ruleBaseGeneratorModel EOF
            {
             newCompositeNode(grammarAccess.getBaseGeneratorModelRule()); 
            pushFollow(FOLLOW_ruleBaseGeneratorModel_in_entryRuleBaseGeneratorModel75);
            iv_ruleBaseGeneratorModel=ruleBaseGeneratorModel();

            state._fsp--;

             current =iv_ruleBaseGeneratorModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBaseGeneratorModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBaseGeneratorModel"


    // $ANTLR start "ruleBaseGeneratorModel"
    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:76:1: ruleBaseGeneratorModel returns [EObject current=null] : (otherlv_0= 'BaseGenerator' otherlv_1= '{' ( (lv_statechartReferences_2_0= ruleStatechartReferences ) ) ( (lv_configuration_3_0= ruleGeneratorConfiguration ) ) otherlv_4= '}' ) ;
    public final EObject ruleBaseGeneratorModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_statechartReferences_2_0 = null;

        EObject lv_configuration_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:79:28: ( (otherlv_0= 'BaseGenerator' otherlv_1= '{' ( (lv_statechartReferences_2_0= ruleStatechartReferences ) ) ( (lv_configuration_3_0= ruleGeneratorConfiguration ) ) otherlv_4= '}' ) )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:80:1: (otherlv_0= 'BaseGenerator' otherlv_1= '{' ( (lv_statechartReferences_2_0= ruleStatechartReferences ) ) ( (lv_configuration_3_0= ruleGeneratorConfiguration ) ) otherlv_4= '}' )
            {
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:80:1: (otherlv_0= 'BaseGenerator' otherlv_1= '{' ( (lv_statechartReferences_2_0= ruleStatechartReferences ) ) ( (lv_configuration_3_0= ruleGeneratorConfiguration ) ) otherlv_4= '}' )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:80:3: otherlv_0= 'BaseGenerator' otherlv_1= '{' ( (lv_statechartReferences_2_0= ruleStatechartReferences ) ) ( (lv_configuration_3_0= ruleGeneratorConfiguration ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleBaseGeneratorModel122); 

                	newLeafNode(otherlv_0, grammarAccess.getBaseGeneratorModelAccess().getBaseGeneratorKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleBaseGeneratorModel134); 

                	newLeafNode(otherlv_1, grammarAccess.getBaseGeneratorModelAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:88:1: ( (lv_statechartReferences_2_0= ruleStatechartReferences ) )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:89:1: (lv_statechartReferences_2_0= ruleStatechartReferences )
            {
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:89:1: (lv_statechartReferences_2_0= ruleStatechartReferences )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:90:3: lv_statechartReferences_2_0= ruleStatechartReferences
            {
             
            	        newCompositeNode(grammarAccess.getBaseGeneratorModelAccess().getStatechartReferencesStatechartReferencesParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleStatechartReferences_in_ruleBaseGeneratorModel155);
            lv_statechartReferences_2_0=ruleStatechartReferences();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBaseGeneratorModelRule());
            	        }
                   		set(
                   			current, 
                   			"statechartReferences",
                    		lv_statechartReferences_2_0, 
                    		"StatechartReferences");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:106:2: ( (lv_configuration_3_0= ruleGeneratorConfiguration ) )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:107:1: (lv_configuration_3_0= ruleGeneratorConfiguration )
            {
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:107:1: (lv_configuration_3_0= ruleGeneratorConfiguration )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:108:3: lv_configuration_3_0= ruleGeneratorConfiguration
            {
             
            	        newCompositeNode(grammarAccess.getBaseGeneratorModelAccess().getConfigurationGeneratorConfigurationParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleGeneratorConfiguration_in_ruleBaseGeneratorModel176);
            lv_configuration_3_0=ruleGeneratorConfiguration();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBaseGeneratorModelRule());
            	        }
                   		set(
                   			current, 
                   			"configuration",
                    		lv_configuration_3_0, 
                    		"GeneratorConfiguration");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleBaseGeneratorModel188); 

                	newLeafNode(otherlv_4, grammarAccess.getBaseGeneratorModelAccess().getRightCurlyBracketKeyword_4());
                

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
    // $ANTLR end "ruleBaseGeneratorModel"


    // $ANTLR start "entryRuleStatechartReferences"
    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:136:1: entryRuleStatechartReferences returns [EObject current=null] : iv_ruleStatechartReferences= ruleStatechartReferences EOF ;
    public final EObject entryRuleStatechartReferences() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatechartReferences = null;


        try {
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:137:2: (iv_ruleStatechartReferences= ruleStatechartReferences EOF )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:138:2: iv_ruleStatechartReferences= ruleStatechartReferences EOF
            {
             newCompositeNode(grammarAccess.getStatechartReferencesRule()); 
            pushFollow(FOLLOW_ruleStatechartReferences_in_entryRuleStatechartReferences224);
            iv_ruleStatechartReferences=ruleStatechartReferences();

            state._fsp--;

             current =iv_ruleStatechartReferences; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatechartReferences234); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatechartReferences"


    // $ANTLR start "ruleStatechartReferences"
    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:145:1: ruleStatechartReferences returns [EObject current=null] : (otherlv_0= 'statecharts ' otherlv_1= '{' ( (otherlv_2= RULE_ID ) )+ (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleStatechartReferences() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:148:28: ( (otherlv_0= 'statecharts ' otherlv_1= '{' ( (otherlv_2= RULE_ID ) )+ (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '}' ) )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:149:1: (otherlv_0= 'statecharts ' otherlv_1= '{' ( (otherlv_2= RULE_ID ) )+ (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '}' )
            {
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:149:1: (otherlv_0= 'statecharts ' otherlv_1= '{' ( (otherlv_2= RULE_ID ) )+ (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '}' )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:149:3: otherlv_0= 'statecharts ' otherlv_1= '{' ( (otherlv_2= RULE_ID ) )+ (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleStatechartReferences271); 

                	newLeafNode(otherlv_0, grammarAccess.getStatechartReferencesAccess().getStatechartsKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleStatechartReferences283); 

                	newLeafNode(otherlv_1, grammarAccess.getStatechartReferencesAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:157:1: ( (otherlv_2= RULE_ID ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:158:1: (otherlv_2= RULE_ID )
            	    {
            	    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:158:1: (otherlv_2= RULE_ID )
            	    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:159:3: otherlv_2= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getStatechartReferencesRule());
            	    	        }
            	            
            	    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStatechartReferences303); 

            	    		newLeafNode(otherlv_2, grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartCrossReference_2_0()); 
            	    	

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

            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:170:3: (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:170:5: otherlv_3= ',' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleStatechartReferences317); 

            	        	newLeafNode(otherlv_3, grammarAccess.getStatechartReferencesAccess().getCommaKeyword_3_0());
            	        
            	    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:174:1: ( (otherlv_4= RULE_ID ) )
            	    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:175:1: (otherlv_4= RULE_ID )
            	    {
            	    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:175:1: (otherlv_4= RULE_ID )
            	    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:176:3: otherlv_4= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getStatechartReferencesRule());
            	    	        }
            	            
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStatechartReferences337); 

            	    		newLeafNode(otherlv_4, grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartCrossReference_3_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleStatechartReferences351); 

                	newLeafNode(otherlv_5, grammarAccess.getStatechartReferencesAccess().getRightCurlyBracketKeyword_4());
                

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
    // $ANTLR end "ruleStatechartReferences"


    // $ANTLR start "entryRuleGeneratorConfiguration"
    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:199:1: entryRuleGeneratorConfiguration returns [EObject current=null] : iv_ruleGeneratorConfiguration= ruleGeneratorConfiguration EOF ;
    public final EObject entryRuleGeneratorConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratorConfiguration = null;


        try {
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:200:2: (iv_ruleGeneratorConfiguration= ruleGeneratorConfiguration EOF )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:201:2: iv_ruleGeneratorConfiguration= ruleGeneratorConfiguration EOF
            {
             newCompositeNode(grammarAccess.getGeneratorConfigurationRule()); 
            pushFollow(FOLLOW_ruleGeneratorConfiguration_in_entryRuleGeneratorConfiguration387);
            iv_ruleGeneratorConfiguration=ruleGeneratorConfiguration();

            state._fsp--;

             current =iv_ruleGeneratorConfiguration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneratorConfiguration397); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGeneratorConfiguration"


    // $ANTLR start "ruleGeneratorConfiguration"
    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:208:1: ruleGeneratorConfiguration returns [EObject current=null] : ( (lv_configurations_0_0= ruleConfigurations ) )+ ;
    public final EObject ruleGeneratorConfiguration() throws RecognitionException {
        EObject current = null;

        EObject lv_configurations_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:211:28: ( ( (lv_configurations_0_0= ruleConfigurations ) )+ )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:212:1: ( (lv_configurations_0_0= ruleConfigurations ) )+
            {
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:212:1: ( (lv_configurations_0_0= ruleConfigurations ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:213:1: (lv_configurations_0_0= ruleConfigurations )
            	    {
            	    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:213:1: (lv_configurations_0_0= ruleConfigurations )
            	    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:214:3: lv_configurations_0_0= ruleConfigurations
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGeneratorConfigurationAccess().getConfigurationsConfigurationsParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConfigurations_in_ruleGeneratorConfiguration442);
            	    lv_configurations_0_0=ruleConfigurations();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGeneratorConfigurationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"configurations",
            	            		lv_configurations_0_0, 
            	            		"Configurations");
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
    // $ANTLR end "ruleGeneratorConfiguration"


    // $ANTLR start "entryRuleConfigurations"
    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:238:1: entryRuleConfigurations returns [EObject current=null] : iv_ruleConfigurations= ruleConfigurations EOF ;
    public final EObject entryRuleConfigurations() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfigurations = null;


        try {
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:239:2: (iv_ruleConfigurations= ruleConfigurations EOF )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:240:2: iv_ruleConfigurations= ruleConfigurations EOF
            {
             newCompositeNode(grammarAccess.getConfigurationsRule()); 
            pushFollow(FOLLOW_ruleConfigurations_in_entryRuleConfigurations478);
            iv_ruleConfigurations=ruleConfigurations();

            state._fsp--;

             current =iv_ruleConfigurations; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConfigurations488); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConfigurations"


    // $ANTLR start "ruleConfigurations"
    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:247:1: ruleConfigurations returns [EObject current=null] : this_OutletConfiguration_0= ruleOutletConfiguration ;
    public final EObject ruleConfigurations() throws RecognitionException {
        EObject current = null;

        EObject this_OutletConfiguration_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:250:28: (this_OutletConfiguration_0= ruleOutletConfiguration )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:252:5: this_OutletConfiguration_0= ruleOutletConfiguration
            {
             
                    newCompositeNode(grammarAccess.getConfigurationsAccess().getOutletConfigurationParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleOutletConfiguration_in_ruleConfigurations534);
            this_OutletConfiguration_0=ruleOutletConfiguration();

            state._fsp--;

             
                    current = this_OutletConfiguration_0; 
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleConfigurations"


    // $ANTLR start "entryRuleOutletConfiguration"
    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:268:1: entryRuleOutletConfiguration returns [EObject current=null] : iv_ruleOutletConfiguration= ruleOutletConfiguration EOF ;
    public final EObject entryRuleOutletConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutletConfiguration = null;


        try {
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:269:2: (iv_ruleOutletConfiguration= ruleOutletConfiguration EOF )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:270:2: iv_ruleOutletConfiguration= ruleOutletConfiguration EOF
            {
             newCompositeNode(grammarAccess.getOutletConfigurationRule()); 
            pushFollow(FOLLOW_ruleOutletConfiguration_in_entryRuleOutletConfiguration568);
            iv_ruleOutletConfiguration=ruleOutletConfiguration();

            state._fsp--;

             current =iv_ruleOutletConfiguration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOutletConfiguration578); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutletConfiguration"


    // $ANTLR start "ruleOutletConfiguration"
    // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:277:1: ruleOutletConfiguration returns [EObject current=null] : ( () otherlv_1= 'outlet' otherlv_2= '{' otherlv_3= 'projectName' otherlv_4= '=' ( (lv_projectName_5_0= RULE_STRING ) ) otherlv_6= 'folder' otherlv_7= '=' ( (lv_targetFolder_8_0= RULE_STRING ) ) otherlv_9= '}' ) ;
    public final EObject ruleOutletConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_projectName_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_targetFolder_8_0=null;
        Token otherlv_9=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:280:28: ( ( () otherlv_1= 'outlet' otherlv_2= '{' otherlv_3= 'projectName' otherlv_4= '=' ( (lv_projectName_5_0= RULE_STRING ) ) otherlv_6= 'folder' otherlv_7= '=' ( (lv_targetFolder_8_0= RULE_STRING ) ) otherlv_9= '}' ) )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:281:1: ( () otherlv_1= 'outlet' otherlv_2= '{' otherlv_3= 'projectName' otherlv_4= '=' ( (lv_projectName_5_0= RULE_STRING ) ) otherlv_6= 'folder' otherlv_7= '=' ( (lv_targetFolder_8_0= RULE_STRING ) ) otherlv_9= '}' )
            {
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:281:1: ( () otherlv_1= 'outlet' otherlv_2= '{' otherlv_3= 'projectName' otherlv_4= '=' ( (lv_projectName_5_0= RULE_STRING ) ) otherlv_6= 'folder' otherlv_7= '=' ( (lv_targetFolder_8_0= RULE_STRING ) ) otherlv_9= '}' )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:281:2: () otherlv_1= 'outlet' otherlv_2= '{' otherlv_3= 'projectName' otherlv_4= '=' ( (lv_projectName_5_0= RULE_STRING ) ) otherlv_6= 'folder' otherlv_7= '=' ( (lv_targetFolder_8_0= RULE_STRING ) ) otherlv_9= '}'
            {
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:281:2: ()
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:282:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOutletConfigurationAccess().getOutletConfigurationCustomAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleOutletConfiguration624); 

                	newLeafNode(otherlv_1, grammarAccess.getOutletConfigurationAccess().getOutletKeyword_1());
                
            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleOutletConfiguration636); 

                	newLeafNode(otherlv_2, grammarAccess.getOutletConfigurationAccess().getLeftCurlyBracketKeyword_2());
                
            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleOutletConfiguration648); 

                	newLeafNode(otherlv_3, grammarAccess.getOutletConfigurationAccess().getProjectNameKeyword_3());
                
            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleOutletConfiguration660); 

                	newLeafNode(otherlv_4, grammarAccess.getOutletConfigurationAccess().getEqualsSignKeyword_4());
                
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:303:1: ( (lv_projectName_5_0= RULE_STRING ) )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:304:1: (lv_projectName_5_0= RULE_STRING )
            {
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:304:1: (lv_projectName_5_0= RULE_STRING )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:305:3: lv_projectName_5_0= RULE_STRING
            {
            lv_projectName_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleOutletConfiguration677); 

            			newLeafNode(lv_projectName_5_0, grammarAccess.getOutletConfigurationAccess().getProjectNameSTRINGTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOutletConfigurationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"projectName",
                    		lv_projectName_5_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleOutletConfiguration694); 

                	newLeafNode(otherlv_6, grammarAccess.getOutletConfigurationAccess().getFolderKeyword_6());
                
            otherlv_7=(Token)match(input,18,FOLLOW_18_in_ruleOutletConfiguration706); 

                	newLeafNode(otherlv_7, grammarAccess.getOutletConfigurationAccess().getEqualsSignKeyword_7());
                
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:329:1: ( (lv_targetFolder_8_0= RULE_STRING ) )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:330:1: (lv_targetFolder_8_0= RULE_STRING )
            {
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:330:1: (lv_targetFolder_8_0= RULE_STRING )
            // ../org.yakindu.sct.generator.model.base/src-gen/org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.g:331:3: lv_targetFolder_8_0= RULE_STRING
            {
            lv_targetFolder_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleOutletConfiguration723); 

            			newLeafNode(lv_targetFolder_8_0, grammarAccess.getOutletConfigurationAccess().getTargetFolderSTRINGTerminalRuleCall_8_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOutletConfigurationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"targetFolder",
                    		lv_targetFolder_8_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_9=(Token)match(input,13,FOLLOW_13_in_ruleOutletConfiguration740); 

                	newLeafNode(otherlv_9, grammarAccess.getOutletConfigurationAccess().getRightCurlyBracketKeyword_9());
                

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
    // $ANTLR end "ruleOutletConfiguration"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleBaseGeneratorModel_in_entryRuleBaseGeneratorModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBaseGeneratorModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleBaseGeneratorModel122 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleBaseGeneratorModel134 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleStatechartReferences_in_ruleBaseGeneratorModel155 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleGeneratorConfiguration_in_ruleBaseGeneratorModel176 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleBaseGeneratorModel188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatechartReferences_in_entryRuleStatechartReferences224 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatechartReferences234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleStatechartReferences271 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleStatechartReferences283 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStatechartReferences303 = new BitSet(new long[]{0x000000000000A010L});
    public static final BitSet FOLLOW_15_in_ruleStatechartReferences317 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStatechartReferences337 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_13_in_ruleStatechartReferences351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratorConfiguration_in_entryRuleGeneratorConfiguration387 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneratorConfiguration397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConfigurations_in_ruleGeneratorConfiguration442 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleConfigurations_in_entryRuleConfigurations478 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConfigurations488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutletConfiguration_in_ruleConfigurations534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutletConfiguration_in_entryRuleOutletConfiguration568 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOutletConfiguration578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleOutletConfiguration624 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleOutletConfiguration636 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleOutletConfiguration648 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleOutletConfiguration660 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleOutletConfiguration677 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleOutletConfiguration694 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleOutletConfiguration706 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleOutletConfiguration723 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleOutletConfiguration740 = new BitSet(new long[]{0x0000000000000002L});

}