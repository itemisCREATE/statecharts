package org.yakindu.sct.generator.model.java.parser.antlr.internal; 

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
import org.yakindu.sct.generator.model.java.services.JavaGenGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalJavaGenParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'JavaGenerator'", "'{'", "'}'", "'naming'", "'interfacePackage'", "'='", "'implementationPackage'", "'copyrightHeader'", "'executionType'", "'type'", "'statecharts '", "','", "'outlet'", "'projectName'", "'folder'", "'cycleBased'", "'eventDriven'"
    };
    public static final int RULE_ID=5;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=4;
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


        public InternalJavaGenParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalJavaGenParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalJavaGenParser.tokenNames; }
    public String getGrammarFileName() { return "../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g"; }



     	private JavaGenGrammarAccess grammarAccess;
     	
        public InternalJavaGenParser(TokenStream input, JavaGenGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "BaseGeneratorModel";	
       	}
       	
       	@Override
       	protected JavaGenGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleBaseGeneratorModel"
    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:68:1: entryRuleBaseGeneratorModel returns [EObject current=null] : iv_ruleBaseGeneratorModel= ruleBaseGeneratorModel EOF ;
    public final EObject entryRuleBaseGeneratorModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseGeneratorModel = null;


        try {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:69:2: (iv_ruleBaseGeneratorModel= ruleBaseGeneratorModel EOF )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:70:2: iv_ruleBaseGeneratorModel= ruleBaseGeneratorModel EOF
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
    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:77:1: ruleBaseGeneratorModel returns [EObject current=null] : (otherlv_0= 'JavaGenerator' otherlv_1= '{' ( (lv_statechartReferences_2_0= ruleStatechartReferences ) ) ( (lv_configuration_3_0= ruleGeneratorConfiguration ) ) otherlv_4= '}' ) ;
    public final EObject ruleBaseGeneratorModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_statechartReferences_2_0 = null;

        EObject lv_configuration_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:80:28: ( (otherlv_0= 'JavaGenerator' otherlv_1= '{' ( (lv_statechartReferences_2_0= ruleStatechartReferences ) ) ( (lv_configuration_3_0= ruleGeneratorConfiguration ) ) otherlv_4= '}' ) )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:81:1: (otherlv_0= 'JavaGenerator' otherlv_1= '{' ( (lv_statechartReferences_2_0= ruleStatechartReferences ) ) ( (lv_configuration_3_0= ruleGeneratorConfiguration ) ) otherlv_4= '}' )
            {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:81:1: (otherlv_0= 'JavaGenerator' otherlv_1= '{' ( (lv_statechartReferences_2_0= ruleStatechartReferences ) ) ( (lv_configuration_3_0= ruleGeneratorConfiguration ) ) otherlv_4= '}' )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:81:3: otherlv_0= 'JavaGenerator' otherlv_1= '{' ( (lv_statechartReferences_2_0= ruleStatechartReferences ) ) ( (lv_configuration_3_0= ruleGeneratorConfiguration ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleBaseGeneratorModel122); 

                	newLeafNode(otherlv_0, grammarAccess.getBaseGeneratorModelAccess().getJavaGeneratorKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleBaseGeneratorModel134); 

                	newLeafNode(otherlv_1, grammarAccess.getBaseGeneratorModelAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:89:1: ( (lv_statechartReferences_2_0= ruleStatechartReferences ) )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:90:1: (lv_statechartReferences_2_0= ruleStatechartReferences )
            {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:90:1: (lv_statechartReferences_2_0= ruleStatechartReferences )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:91:3: lv_statechartReferences_2_0= ruleStatechartReferences
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

            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:107:2: ( (lv_configuration_3_0= ruleGeneratorConfiguration ) )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:108:1: (lv_configuration_3_0= ruleGeneratorConfiguration )
            {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:108:1: (lv_configuration_3_0= ruleGeneratorConfiguration )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:109:3: lv_configuration_3_0= ruleGeneratorConfiguration
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


    // $ANTLR start "entryRuleConfigurations"
    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:137:1: entryRuleConfigurations returns [EObject current=null] : iv_ruleConfigurations= ruleConfigurations EOF ;
    public final EObject entryRuleConfigurations() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfigurations = null;


        try {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:138:2: (iv_ruleConfigurations= ruleConfigurations EOF )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:139:2: iv_ruleConfigurations= ruleConfigurations EOF
            {
             newCompositeNode(grammarAccess.getConfigurationsRule()); 
            pushFollow(FOLLOW_ruleConfigurations_in_entryRuleConfigurations224);
            iv_ruleConfigurations=ruleConfigurations();

            state._fsp--;

             current =iv_ruleConfigurations; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConfigurations234); 

            }

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
    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:146:1: ruleConfigurations returns [EObject current=null] : (this_OutletConfiguration_0= ruleOutletConfiguration | this_NamingConfiguration_1= ruleNamingConfiguration | this_ExecutionTypeConfiguration_2= ruleExecutionTypeConfiguration ) ;
    public final EObject ruleConfigurations() throws RecognitionException {
        EObject current = null;

        EObject this_OutletConfiguration_0 = null;

        EObject this_NamingConfiguration_1 = null;

        EObject this_ExecutionTypeConfiguration_2 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:149:28: ( (this_OutletConfiguration_0= ruleOutletConfiguration | this_NamingConfiguration_1= ruleNamingConfiguration | this_ExecutionTypeConfiguration_2= ruleExecutionTypeConfiguration ) )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:150:1: (this_OutletConfiguration_0= ruleOutletConfiguration | this_NamingConfiguration_1= ruleNamingConfiguration | this_ExecutionTypeConfiguration_2= ruleExecutionTypeConfiguration )
            {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:150:1: (this_OutletConfiguration_0= ruleOutletConfiguration | this_NamingConfiguration_1= ruleNamingConfiguration | this_ExecutionTypeConfiguration_2= ruleExecutionTypeConfiguration )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt1=1;
                }
                break;
            case 14:
                {
                alt1=2;
                }
                break;
            case 19:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:151:5: this_OutletConfiguration_0= ruleOutletConfiguration
                    {
                     
                            newCompositeNode(grammarAccess.getConfigurationsAccess().getOutletConfigurationParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleOutletConfiguration_in_ruleConfigurations281);
                    this_OutletConfiguration_0=ruleOutletConfiguration();

                    state._fsp--;

                     
                            current = this_OutletConfiguration_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:161:5: this_NamingConfiguration_1= ruleNamingConfiguration
                    {
                     
                            newCompositeNode(grammarAccess.getConfigurationsAccess().getNamingConfigurationParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNamingConfiguration_in_ruleConfigurations308);
                    this_NamingConfiguration_1=ruleNamingConfiguration();

                    state._fsp--;

                     
                            current = this_NamingConfiguration_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:171:5: this_ExecutionTypeConfiguration_2= ruleExecutionTypeConfiguration
                    {
                     
                            newCompositeNode(grammarAccess.getConfigurationsAccess().getExecutionTypeConfigurationParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleExecutionTypeConfiguration_in_ruleConfigurations335);
                    this_ExecutionTypeConfiguration_2=ruleExecutionTypeConfiguration();

                    state._fsp--;

                     
                            current = this_ExecutionTypeConfiguration_2; 
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
    // $ANTLR end "ruleConfigurations"


    // $ANTLR start "entryRuleNamingConfiguration"
    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:187:1: entryRuleNamingConfiguration returns [EObject current=null] : iv_ruleNamingConfiguration= ruleNamingConfiguration EOF ;
    public final EObject entryRuleNamingConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamingConfiguration = null;


        try {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:188:2: (iv_ruleNamingConfiguration= ruleNamingConfiguration EOF )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:189:2: iv_ruleNamingConfiguration= ruleNamingConfiguration EOF
            {
             newCompositeNode(grammarAccess.getNamingConfigurationRule()); 
            pushFollow(FOLLOW_ruleNamingConfiguration_in_entryRuleNamingConfiguration370);
            iv_ruleNamingConfiguration=ruleNamingConfiguration();

            state._fsp--;

             current =iv_ruleNamingConfiguration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamingConfiguration380); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamingConfiguration"


    // $ANTLR start "ruleNamingConfiguration"
    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:196:1: ruleNamingConfiguration returns [EObject current=null] : ( () otherlv_1= 'naming' otherlv_2= '{' otherlv_3= 'interfacePackage' otherlv_4= '=' ( (lv_interfacePackageName_5_0= RULE_STRING ) ) otherlv_6= 'implementationPackage' otherlv_7= '=' ( (lv_implementationPackageName_8_0= RULE_STRING ) ) otherlv_9= 'copyrightHeader' otherlv_10= '=' ( (lv_copyright_11_0= RULE_STRING ) ) otherlv_12= '}' ) ;
    public final EObject ruleNamingConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_interfacePackageName_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_implementationPackageName_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_copyright_11_0=null;
        Token otherlv_12=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:199:28: ( ( () otherlv_1= 'naming' otherlv_2= '{' otherlv_3= 'interfacePackage' otherlv_4= '=' ( (lv_interfacePackageName_5_0= RULE_STRING ) ) otherlv_6= 'implementationPackage' otherlv_7= '=' ( (lv_implementationPackageName_8_0= RULE_STRING ) ) otherlv_9= 'copyrightHeader' otherlv_10= '=' ( (lv_copyright_11_0= RULE_STRING ) ) otherlv_12= '}' ) )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:200:1: ( () otherlv_1= 'naming' otherlv_2= '{' otherlv_3= 'interfacePackage' otherlv_4= '=' ( (lv_interfacePackageName_5_0= RULE_STRING ) ) otherlv_6= 'implementationPackage' otherlv_7= '=' ( (lv_implementationPackageName_8_0= RULE_STRING ) ) otherlv_9= 'copyrightHeader' otherlv_10= '=' ( (lv_copyright_11_0= RULE_STRING ) ) otherlv_12= '}' )
            {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:200:1: ( () otherlv_1= 'naming' otherlv_2= '{' otherlv_3= 'interfacePackage' otherlv_4= '=' ( (lv_interfacePackageName_5_0= RULE_STRING ) ) otherlv_6= 'implementationPackage' otherlv_7= '=' ( (lv_implementationPackageName_8_0= RULE_STRING ) ) otherlv_9= 'copyrightHeader' otherlv_10= '=' ( (lv_copyright_11_0= RULE_STRING ) ) otherlv_12= '}' )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:200:2: () otherlv_1= 'naming' otherlv_2= '{' otherlv_3= 'interfacePackage' otherlv_4= '=' ( (lv_interfacePackageName_5_0= RULE_STRING ) ) otherlv_6= 'implementationPackage' otherlv_7= '=' ( (lv_implementationPackageName_8_0= RULE_STRING ) ) otherlv_9= 'copyrightHeader' otherlv_10= '=' ( (lv_copyright_11_0= RULE_STRING ) ) otherlv_12= '}'
            {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:200:2: ()
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:201:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNamingConfigurationAccess().getNamingConfigurationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleNamingConfiguration426); 

                	newLeafNode(otherlv_1, grammarAccess.getNamingConfigurationAccess().getNamingKeyword_1());
                
            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleNamingConfiguration438); 

                	newLeafNode(otherlv_2, grammarAccess.getNamingConfigurationAccess().getLeftCurlyBracketKeyword_2());
                
            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleNamingConfiguration450); 

                	newLeafNode(otherlv_3, grammarAccess.getNamingConfigurationAccess().getInterfacePackageKeyword_3());
                
            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleNamingConfiguration462); 

                	newLeafNode(otherlv_4, grammarAccess.getNamingConfigurationAccess().getEqualsSignKeyword_4());
                
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:222:1: ( (lv_interfacePackageName_5_0= RULE_STRING ) )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:223:1: (lv_interfacePackageName_5_0= RULE_STRING )
            {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:223:1: (lv_interfacePackageName_5_0= RULE_STRING )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:224:3: lv_interfacePackageName_5_0= RULE_STRING
            {
            lv_interfacePackageName_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNamingConfiguration479); 

            			newLeafNode(lv_interfacePackageName_5_0, grammarAccess.getNamingConfigurationAccess().getInterfacePackageNameSTRINGTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNamingConfigurationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"interfacePackageName",
                    		lv_interfacePackageName_5_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleNamingConfiguration496); 

                	newLeafNode(otherlv_6, grammarAccess.getNamingConfigurationAccess().getImplementationPackageKeyword_6());
                
            otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleNamingConfiguration508); 

                	newLeafNode(otherlv_7, grammarAccess.getNamingConfigurationAccess().getEqualsSignKeyword_7());
                
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:248:1: ( (lv_implementationPackageName_8_0= RULE_STRING ) )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:249:1: (lv_implementationPackageName_8_0= RULE_STRING )
            {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:249:1: (lv_implementationPackageName_8_0= RULE_STRING )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:250:3: lv_implementationPackageName_8_0= RULE_STRING
            {
            lv_implementationPackageName_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNamingConfiguration525); 

            			newLeafNode(lv_implementationPackageName_8_0, grammarAccess.getNamingConfigurationAccess().getImplementationPackageNameSTRINGTerminalRuleCall_8_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNamingConfigurationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"implementationPackageName",
                    		lv_implementationPackageName_8_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_9=(Token)match(input,18,FOLLOW_18_in_ruleNamingConfiguration542); 

                	newLeafNode(otherlv_9, grammarAccess.getNamingConfigurationAccess().getCopyrightHeaderKeyword_9());
                
            otherlv_10=(Token)match(input,16,FOLLOW_16_in_ruleNamingConfiguration554); 

                	newLeafNode(otherlv_10, grammarAccess.getNamingConfigurationAccess().getEqualsSignKeyword_10());
                
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:274:1: ( (lv_copyright_11_0= RULE_STRING ) )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:275:1: (lv_copyright_11_0= RULE_STRING )
            {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:275:1: (lv_copyright_11_0= RULE_STRING )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:276:3: lv_copyright_11_0= RULE_STRING
            {
            lv_copyright_11_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNamingConfiguration571); 

            			newLeafNode(lv_copyright_11_0, grammarAccess.getNamingConfigurationAccess().getCopyrightSTRINGTerminalRuleCall_11_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNamingConfigurationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"copyright",
                    		lv_copyright_11_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_12=(Token)match(input,13,FOLLOW_13_in_ruleNamingConfiguration588); 

                	newLeafNode(otherlv_12, grammarAccess.getNamingConfigurationAccess().getRightCurlyBracketKeyword_12());
                

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
    // $ANTLR end "ruleNamingConfiguration"


    // $ANTLR start "entryRuleExecutionTypeConfiguration"
    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:304:1: entryRuleExecutionTypeConfiguration returns [EObject current=null] : iv_ruleExecutionTypeConfiguration= ruleExecutionTypeConfiguration EOF ;
    public final EObject entryRuleExecutionTypeConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecutionTypeConfiguration = null;


        try {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:305:2: (iv_ruleExecutionTypeConfiguration= ruleExecutionTypeConfiguration EOF )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:306:2: iv_ruleExecutionTypeConfiguration= ruleExecutionTypeConfiguration EOF
            {
             newCompositeNode(grammarAccess.getExecutionTypeConfigurationRule()); 
            pushFollow(FOLLOW_ruleExecutionTypeConfiguration_in_entryRuleExecutionTypeConfiguration624);
            iv_ruleExecutionTypeConfiguration=ruleExecutionTypeConfiguration();

            state._fsp--;

             current =iv_ruleExecutionTypeConfiguration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExecutionTypeConfiguration634); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExecutionTypeConfiguration"


    // $ANTLR start "ruleExecutionTypeConfiguration"
    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:313:1: ruleExecutionTypeConfiguration returns [EObject current=null] : ( () otherlv_1= 'executionType' otherlv_2= '{' otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= ruleExecutionType ) ) otherlv_6= '}' ) ;
    public final EObject ruleExecutionTypeConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_type_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:316:28: ( ( () otherlv_1= 'executionType' otherlv_2= '{' otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= ruleExecutionType ) ) otherlv_6= '}' ) )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:317:1: ( () otherlv_1= 'executionType' otherlv_2= '{' otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= ruleExecutionType ) ) otherlv_6= '}' )
            {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:317:1: ( () otherlv_1= 'executionType' otherlv_2= '{' otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= ruleExecutionType ) ) otherlv_6= '}' )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:317:2: () otherlv_1= 'executionType' otherlv_2= '{' otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= ruleExecutionType ) ) otherlv_6= '}'
            {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:317:2: ()
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:318:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getExecutionTypeConfigurationAccess().getExecutionTypeConfigurationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleExecutionTypeConfiguration680); 

                	newLeafNode(otherlv_1, grammarAccess.getExecutionTypeConfigurationAccess().getExecutionTypeKeyword_1());
                
            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleExecutionTypeConfiguration692); 

                	newLeafNode(otherlv_2, grammarAccess.getExecutionTypeConfigurationAccess().getLeftCurlyBracketKeyword_2());
                
            otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleExecutionTypeConfiguration704); 

                	newLeafNode(otherlv_3, grammarAccess.getExecutionTypeConfigurationAccess().getTypeKeyword_3());
                
            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleExecutionTypeConfiguration716); 

                	newLeafNode(otherlv_4, grammarAccess.getExecutionTypeConfigurationAccess().getEqualsSignKeyword_4());
                
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:339:1: ( (lv_type_5_0= ruleExecutionType ) )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:340:1: (lv_type_5_0= ruleExecutionType )
            {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:340:1: (lv_type_5_0= ruleExecutionType )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:341:3: lv_type_5_0= ruleExecutionType
            {
             
            	        newCompositeNode(grammarAccess.getExecutionTypeConfigurationAccess().getTypeExecutionTypeEnumRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleExecutionType_in_ruleExecutionTypeConfiguration737);
            lv_type_5_0=ruleExecutionType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExecutionTypeConfigurationRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_5_0, 
                    		"ExecutionType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleExecutionTypeConfiguration749); 

                	newLeafNode(otherlv_6, grammarAccess.getExecutionTypeConfigurationAccess().getRightCurlyBracketKeyword_6());
                

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
    // $ANTLR end "ruleExecutionTypeConfiguration"


    // $ANTLR start "entryRuleStatechartReferences"
    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:369:1: entryRuleStatechartReferences returns [EObject current=null] : iv_ruleStatechartReferences= ruleStatechartReferences EOF ;
    public final EObject entryRuleStatechartReferences() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatechartReferences = null;


        try {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:370:2: (iv_ruleStatechartReferences= ruleStatechartReferences EOF )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:371:2: iv_ruleStatechartReferences= ruleStatechartReferences EOF
            {
             newCompositeNode(grammarAccess.getStatechartReferencesRule()); 
            pushFollow(FOLLOW_ruleStatechartReferences_in_entryRuleStatechartReferences785);
            iv_ruleStatechartReferences=ruleStatechartReferences();

            state._fsp--;

             current =iv_ruleStatechartReferences; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatechartReferences795); 

            }

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
    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:378:1: ruleStatechartReferences returns [EObject current=null] : (otherlv_0= 'statecharts ' otherlv_1= '{' ( (otherlv_2= RULE_ID ) )+ (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '}' ) ;
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
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:381:28: ( (otherlv_0= 'statecharts ' otherlv_1= '{' ( (otherlv_2= RULE_ID ) )+ (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '}' ) )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:382:1: (otherlv_0= 'statecharts ' otherlv_1= '{' ( (otherlv_2= RULE_ID ) )+ (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '}' )
            {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:382:1: (otherlv_0= 'statecharts ' otherlv_1= '{' ( (otherlv_2= RULE_ID ) )+ (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '}' )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:382:3: otherlv_0= 'statecharts ' otherlv_1= '{' ( (otherlv_2= RULE_ID ) )+ (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleStatechartReferences832); 

                	newLeafNode(otherlv_0, grammarAccess.getStatechartReferencesAccess().getStatechartsKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleStatechartReferences844); 

                	newLeafNode(otherlv_1, grammarAccess.getStatechartReferencesAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:390:1: ( (otherlv_2= RULE_ID ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:391:1: (otherlv_2= RULE_ID )
            	    {
            	    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:391:1: (otherlv_2= RULE_ID )
            	    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:392:3: otherlv_2= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getStatechartReferencesRule());
            	    	        }
            	            
            	    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStatechartReferences864); 

            	    		newLeafNode(otherlv_2, grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartCrossReference_2_0()); 
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:403:3: (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==22) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:403:5: otherlv_3= ',' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleStatechartReferences878); 

            	        	newLeafNode(otherlv_3, grammarAccess.getStatechartReferencesAccess().getCommaKeyword_3_0());
            	        
            	    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:407:1: ( (otherlv_4= RULE_ID ) )
            	    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:408:1: (otherlv_4= RULE_ID )
            	    {
            	    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:408:1: (otherlv_4= RULE_ID )
            	    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:409:3: otherlv_4= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getStatechartReferencesRule());
            	    	        }
            	            
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStatechartReferences898); 

            	    		newLeafNode(otherlv_4, grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartCrossReference_3_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleStatechartReferences912); 

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
    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:432:1: entryRuleGeneratorConfiguration returns [EObject current=null] : iv_ruleGeneratorConfiguration= ruleGeneratorConfiguration EOF ;
    public final EObject entryRuleGeneratorConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratorConfiguration = null;


        try {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:433:2: (iv_ruleGeneratorConfiguration= ruleGeneratorConfiguration EOF )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:434:2: iv_ruleGeneratorConfiguration= ruleGeneratorConfiguration EOF
            {
             newCompositeNode(grammarAccess.getGeneratorConfigurationRule()); 
            pushFollow(FOLLOW_ruleGeneratorConfiguration_in_entryRuleGeneratorConfiguration948);
            iv_ruleGeneratorConfiguration=ruleGeneratorConfiguration();

            state._fsp--;

             current =iv_ruleGeneratorConfiguration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneratorConfiguration958); 

            }

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
    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:441:1: ruleGeneratorConfiguration returns [EObject current=null] : ( (lv_configurations_0_0= ruleConfigurations ) )+ ;
    public final EObject ruleGeneratorConfiguration() throws RecognitionException {
        EObject current = null;

        EObject lv_configurations_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:444:28: ( ( (lv_configurations_0_0= ruleConfigurations ) )+ )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:445:1: ( (lv_configurations_0_0= ruleConfigurations ) )+
            {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:445:1: ( (lv_configurations_0_0= ruleConfigurations ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14||LA4_0==19||LA4_0==23) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:446:1: (lv_configurations_0_0= ruleConfigurations )
            	    {
            	    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:446:1: (lv_configurations_0_0= ruleConfigurations )
            	    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:447:3: lv_configurations_0_0= ruleConfigurations
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGeneratorConfigurationAccess().getConfigurationsConfigurationsParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConfigurations_in_ruleGeneratorConfiguration1003);
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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


    // $ANTLR start "entryRuleOutletConfiguration"
    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:471:1: entryRuleOutletConfiguration returns [EObject current=null] : iv_ruleOutletConfiguration= ruleOutletConfiguration EOF ;
    public final EObject entryRuleOutletConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutletConfiguration = null;


        try {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:472:2: (iv_ruleOutletConfiguration= ruleOutletConfiguration EOF )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:473:2: iv_ruleOutletConfiguration= ruleOutletConfiguration EOF
            {
             newCompositeNode(grammarAccess.getOutletConfigurationRule()); 
            pushFollow(FOLLOW_ruleOutletConfiguration_in_entryRuleOutletConfiguration1039);
            iv_ruleOutletConfiguration=ruleOutletConfiguration();

            state._fsp--;

             current =iv_ruleOutletConfiguration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOutletConfiguration1049); 

            }

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
    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:480:1: ruleOutletConfiguration returns [EObject current=null] : ( () otherlv_1= 'outlet' otherlv_2= '{' otherlv_3= 'projectName' otherlv_4= '=' ( (lv_projectName_5_0= RULE_STRING ) ) otherlv_6= 'folder' otherlv_7= '=' ( (lv_targetFolder_8_0= RULE_STRING ) ) otherlv_9= '}' ) ;
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
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:483:28: ( ( () otherlv_1= 'outlet' otherlv_2= '{' otherlv_3= 'projectName' otherlv_4= '=' ( (lv_projectName_5_0= RULE_STRING ) ) otherlv_6= 'folder' otherlv_7= '=' ( (lv_targetFolder_8_0= RULE_STRING ) ) otherlv_9= '}' ) )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:484:1: ( () otherlv_1= 'outlet' otherlv_2= '{' otherlv_3= 'projectName' otherlv_4= '=' ( (lv_projectName_5_0= RULE_STRING ) ) otherlv_6= 'folder' otherlv_7= '=' ( (lv_targetFolder_8_0= RULE_STRING ) ) otherlv_9= '}' )
            {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:484:1: ( () otherlv_1= 'outlet' otherlv_2= '{' otherlv_3= 'projectName' otherlv_4= '=' ( (lv_projectName_5_0= RULE_STRING ) ) otherlv_6= 'folder' otherlv_7= '=' ( (lv_targetFolder_8_0= RULE_STRING ) ) otherlv_9= '}' )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:484:2: () otherlv_1= 'outlet' otherlv_2= '{' otherlv_3= 'projectName' otherlv_4= '=' ( (lv_projectName_5_0= RULE_STRING ) ) otherlv_6= 'folder' otherlv_7= '=' ( (lv_targetFolder_8_0= RULE_STRING ) ) otherlv_9= '}'
            {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:484:2: ()
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:485:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOutletConfigurationAccess().getOutletConfigurationCustomAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleOutletConfiguration1095); 

                	newLeafNode(otherlv_1, grammarAccess.getOutletConfigurationAccess().getOutletKeyword_1());
                
            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleOutletConfiguration1107); 

                	newLeafNode(otherlv_2, grammarAccess.getOutletConfigurationAccess().getLeftCurlyBracketKeyword_2());
                
            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleOutletConfiguration1119); 

                	newLeafNode(otherlv_3, grammarAccess.getOutletConfigurationAccess().getProjectNameKeyword_3());
                
            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleOutletConfiguration1131); 

                	newLeafNode(otherlv_4, grammarAccess.getOutletConfigurationAccess().getEqualsSignKeyword_4());
                
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:506:1: ( (lv_projectName_5_0= RULE_STRING ) )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:507:1: (lv_projectName_5_0= RULE_STRING )
            {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:507:1: (lv_projectName_5_0= RULE_STRING )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:508:3: lv_projectName_5_0= RULE_STRING
            {
            lv_projectName_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleOutletConfiguration1148); 

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

            otherlv_6=(Token)match(input,25,FOLLOW_25_in_ruleOutletConfiguration1165); 

                	newLeafNode(otherlv_6, grammarAccess.getOutletConfigurationAccess().getFolderKeyword_6());
                
            otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleOutletConfiguration1177); 

                	newLeafNode(otherlv_7, grammarAccess.getOutletConfigurationAccess().getEqualsSignKeyword_7());
                
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:532:1: ( (lv_targetFolder_8_0= RULE_STRING ) )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:533:1: (lv_targetFolder_8_0= RULE_STRING )
            {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:533:1: (lv_targetFolder_8_0= RULE_STRING )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:534:3: lv_targetFolder_8_0= RULE_STRING
            {
            lv_targetFolder_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleOutletConfiguration1194); 

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

            otherlv_9=(Token)match(input,13,FOLLOW_13_in_ruleOutletConfiguration1211); 

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


    // $ANTLR start "ruleExecutionType"
    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:562:1: ruleExecutionType returns [Enumerator current=null] : ( (enumLiteral_0= 'cycleBased' ) | (enumLiteral_1= 'eventDriven' ) ) ;
    public final Enumerator ruleExecutionType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:564:28: ( ( (enumLiteral_0= 'cycleBased' ) | (enumLiteral_1= 'eventDriven' ) ) )
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:565:1: ( (enumLiteral_0= 'cycleBased' ) | (enumLiteral_1= 'eventDriven' ) )
            {
            // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:565:1: ( (enumLiteral_0= 'cycleBased' ) | (enumLiteral_1= 'eventDriven' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==26) ) {
                alt5=1;
            }
            else if ( (LA5_0==27) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:565:2: (enumLiteral_0= 'cycleBased' )
                    {
                    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:565:2: (enumLiteral_0= 'cycleBased' )
                    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:565:4: enumLiteral_0= 'cycleBased'
                    {
                    enumLiteral_0=(Token)match(input,26,FOLLOW_26_in_ruleExecutionType1261); 

                            current = grammarAccess.getExecutionTypeAccess().getCYCLE_BASEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getExecutionTypeAccess().getCYCLE_BASEDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:571:6: (enumLiteral_1= 'eventDriven' )
                    {
                    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:571:6: (enumLiteral_1= 'eventDriven' )
                    // ../org.yakindu.sct.generator.model.java/src-gen/org/yakindu/sct/generator/model/java/parser/antlr/internal/InternalJavaGen.g:571:8: enumLiteral_1= 'eventDriven'
                    {
                    enumLiteral_1=(Token)match(input,27,FOLLOW_27_in_ruleExecutionType1278); 

                            current = grammarAccess.getExecutionTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getExecutionTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_1()); 
                        

                    }


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
    // $ANTLR end "ruleExecutionType"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleBaseGeneratorModel_in_entryRuleBaseGeneratorModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBaseGeneratorModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleBaseGeneratorModel122 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleBaseGeneratorModel134 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ruleStatechartReferences_in_ruleBaseGeneratorModel155 = new BitSet(new long[]{0x0000000000884000L});
    public static final BitSet FOLLOW_ruleGeneratorConfiguration_in_ruleBaseGeneratorModel176 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleBaseGeneratorModel188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConfigurations_in_entryRuleConfigurations224 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConfigurations234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutletConfiguration_in_ruleConfigurations281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamingConfiguration_in_ruleConfigurations308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutionTypeConfiguration_in_ruleConfigurations335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamingConfiguration_in_entryRuleNamingConfiguration370 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamingConfiguration380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleNamingConfiguration426 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleNamingConfiguration438 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleNamingConfiguration450 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleNamingConfiguration462 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNamingConfiguration479 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleNamingConfiguration496 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleNamingConfiguration508 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNamingConfiguration525 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleNamingConfiguration542 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleNamingConfiguration554 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNamingConfiguration571 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleNamingConfiguration588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutionTypeConfiguration_in_entryRuleExecutionTypeConfiguration624 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExecutionTypeConfiguration634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleExecutionTypeConfiguration680 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleExecutionTypeConfiguration692 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleExecutionTypeConfiguration704 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleExecutionTypeConfiguration716 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_ruleExecutionType_in_ruleExecutionTypeConfiguration737 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleExecutionTypeConfiguration749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatechartReferences_in_entryRuleStatechartReferences785 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatechartReferences795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleStatechartReferences832 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleStatechartReferences844 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStatechartReferences864 = new BitSet(new long[]{0x0000000000402020L});
    public static final BitSet FOLLOW_22_in_ruleStatechartReferences878 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStatechartReferences898 = new BitSet(new long[]{0x0000000000402000L});
    public static final BitSet FOLLOW_13_in_ruleStatechartReferences912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratorConfiguration_in_entryRuleGeneratorConfiguration948 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneratorConfiguration958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConfigurations_in_ruleGeneratorConfiguration1003 = new BitSet(new long[]{0x0000000000884002L});
    public static final BitSet FOLLOW_ruleOutletConfiguration_in_entryRuleOutletConfiguration1039 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOutletConfiguration1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOutletConfiguration1095 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleOutletConfiguration1107 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleOutletConfiguration1119 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleOutletConfiguration1131 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleOutletConfiguration1148 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleOutletConfiguration1165 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleOutletConfiguration1177 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleOutletConfiguration1194 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleOutletConfiguration1211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleExecutionType1261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleExecutionType1278 = new BitSet(new long[]{0x0000000000000002L});

}