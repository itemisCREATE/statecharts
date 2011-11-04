package org.yakindu.sct.generator.model.base.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.yakindu.sct.generator.model.base.services.BaseGenGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBaseGenParser extends AbstractInternalContentAssistParser {
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
    public String getGrammarFileName() { return "../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g"; }


     
     	private BaseGenGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(BaseGenGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleBaseGeneratorModel"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:61:1: entryRuleBaseGeneratorModel : ruleBaseGeneratorModel EOF ;
    public final void entryRuleBaseGeneratorModel() throws RecognitionException {
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:62:1: ( ruleBaseGeneratorModel EOF )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:63:1: ruleBaseGeneratorModel EOF
            {
             before(grammarAccess.getBaseGeneratorModelRule()); 
            pushFollow(FOLLOW_ruleBaseGeneratorModel_in_entryRuleBaseGeneratorModel61);
            ruleBaseGeneratorModel();

            state._fsp--;

             after(grammarAccess.getBaseGeneratorModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBaseGeneratorModel68); 

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
    // $ANTLR end "entryRuleBaseGeneratorModel"


    // $ANTLR start "ruleBaseGeneratorModel"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:70:1: ruleBaseGeneratorModel : ( ( rule__BaseGeneratorModel__Group__0 ) ) ;
    public final void ruleBaseGeneratorModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:74:2: ( ( ( rule__BaseGeneratorModel__Group__0 ) ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:75:1: ( ( rule__BaseGeneratorModel__Group__0 ) )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:75:1: ( ( rule__BaseGeneratorModel__Group__0 ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:76:1: ( rule__BaseGeneratorModel__Group__0 )
            {
             before(grammarAccess.getBaseGeneratorModelAccess().getGroup()); 
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:77:1: ( rule__BaseGeneratorModel__Group__0 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:77:2: rule__BaseGeneratorModel__Group__0
            {
            pushFollow(FOLLOW_rule__BaseGeneratorModel__Group__0_in_ruleBaseGeneratorModel94);
            rule__BaseGeneratorModel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBaseGeneratorModelAccess().getGroup()); 

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
    // $ANTLR end "ruleBaseGeneratorModel"


    // $ANTLR start "entryRuleStatechartReferences"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:89:1: entryRuleStatechartReferences : ruleStatechartReferences EOF ;
    public final void entryRuleStatechartReferences() throws RecognitionException {
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:90:1: ( ruleStatechartReferences EOF )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:91:1: ruleStatechartReferences EOF
            {
             before(grammarAccess.getStatechartReferencesRule()); 
            pushFollow(FOLLOW_ruleStatechartReferences_in_entryRuleStatechartReferences121);
            ruleStatechartReferences();

            state._fsp--;

             after(grammarAccess.getStatechartReferencesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatechartReferences128); 

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
    // $ANTLR end "entryRuleStatechartReferences"


    // $ANTLR start "ruleStatechartReferences"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:98:1: ruleStatechartReferences : ( ( rule__StatechartReferences__Group__0 ) ) ;
    public final void ruleStatechartReferences() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:102:2: ( ( ( rule__StatechartReferences__Group__0 ) ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:103:1: ( ( rule__StatechartReferences__Group__0 ) )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:103:1: ( ( rule__StatechartReferences__Group__0 ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:104:1: ( rule__StatechartReferences__Group__0 )
            {
             before(grammarAccess.getStatechartReferencesAccess().getGroup()); 
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:105:1: ( rule__StatechartReferences__Group__0 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:105:2: rule__StatechartReferences__Group__0
            {
            pushFollow(FOLLOW_rule__StatechartReferences__Group__0_in_ruleStatechartReferences154);
            rule__StatechartReferences__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStatechartReferencesAccess().getGroup()); 

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
    // $ANTLR end "ruleStatechartReferences"


    // $ANTLR start "entryRuleGeneratorConfiguration"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:117:1: entryRuleGeneratorConfiguration : ruleGeneratorConfiguration EOF ;
    public final void entryRuleGeneratorConfiguration() throws RecognitionException {
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:118:1: ( ruleGeneratorConfiguration EOF )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:119:1: ruleGeneratorConfiguration EOF
            {
             before(grammarAccess.getGeneratorConfigurationRule()); 
            pushFollow(FOLLOW_ruleGeneratorConfiguration_in_entryRuleGeneratorConfiguration181);
            ruleGeneratorConfiguration();

            state._fsp--;

             after(grammarAccess.getGeneratorConfigurationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneratorConfiguration188); 

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
    // $ANTLR end "entryRuleGeneratorConfiguration"


    // $ANTLR start "ruleGeneratorConfiguration"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:126:1: ruleGeneratorConfiguration : ( ( ( rule__GeneratorConfiguration__ConfigurationsAssignment ) ) ( ( rule__GeneratorConfiguration__ConfigurationsAssignment )* ) ) ;
    public final void ruleGeneratorConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:130:2: ( ( ( ( rule__GeneratorConfiguration__ConfigurationsAssignment ) ) ( ( rule__GeneratorConfiguration__ConfigurationsAssignment )* ) ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:131:1: ( ( ( rule__GeneratorConfiguration__ConfigurationsAssignment ) ) ( ( rule__GeneratorConfiguration__ConfigurationsAssignment )* ) )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:131:1: ( ( ( rule__GeneratorConfiguration__ConfigurationsAssignment ) ) ( ( rule__GeneratorConfiguration__ConfigurationsAssignment )* ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:132:1: ( ( rule__GeneratorConfiguration__ConfigurationsAssignment ) ) ( ( rule__GeneratorConfiguration__ConfigurationsAssignment )* )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:132:1: ( ( rule__GeneratorConfiguration__ConfigurationsAssignment ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:133:1: ( rule__GeneratorConfiguration__ConfigurationsAssignment )
            {
             before(grammarAccess.getGeneratorConfigurationAccess().getConfigurationsAssignment()); 
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:134:1: ( rule__GeneratorConfiguration__ConfigurationsAssignment )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:134:2: rule__GeneratorConfiguration__ConfigurationsAssignment
            {
            pushFollow(FOLLOW_rule__GeneratorConfiguration__ConfigurationsAssignment_in_ruleGeneratorConfiguration216);
            rule__GeneratorConfiguration__ConfigurationsAssignment();

            state._fsp--;


            }

             after(grammarAccess.getGeneratorConfigurationAccess().getConfigurationsAssignment()); 

            }

            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:137:1: ( ( rule__GeneratorConfiguration__ConfigurationsAssignment )* )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:138:1: ( rule__GeneratorConfiguration__ConfigurationsAssignment )*
            {
             before(grammarAccess.getGeneratorConfigurationAccess().getConfigurationsAssignment()); 
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:139:1: ( rule__GeneratorConfiguration__ConfigurationsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:139:2: rule__GeneratorConfiguration__ConfigurationsAssignment
            	    {
            	    pushFollow(FOLLOW_rule__GeneratorConfiguration__ConfigurationsAssignment_in_ruleGeneratorConfiguration228);
            	    rule__GeneratorConfiguration__ConfigurationsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getGeneratorConfigurationAccess().getConfigurationsAssignment()); 

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
    // $ANTLR end "ruleGeneratorConfiguration"


    // $ANTLR start "entryRuleConfigurations"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:152:1: entryRuleConfigurations : ruleConfigurations EOF ;
    public final void entryRuleConfigurations() throws RecognitionException {
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:153:1: ( ruleConfigurations EOF )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:154:1: ruleConfigurations EOF
            {
             before(grammarAccess.getConfigurationsRule()); 
            pushFollow(FOLLOW_ruleConfigurations_in_entryRuleConfigurations258);
            ruleConfigurations();

            state._fsp--;

             after(grammarAccess.getConfigurationsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConfigurations265); 

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
    // $ANTLR end "entryRuleConfigurations"


    // $ANTLR start "ruleConfigurations"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:161:1: ruleConfigurations : ( ruleOutletConfiguration ) ;
    public final void ruleConfigurations() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:165:2: ( ( ruleOutletConfiguration ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:166:1: ( ruleOutletConfiguration )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:166:1: ( ruleOutletConfiguration )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:167:1: ruleOutletConfiguration
            {
             before(grammarAccess.getConfigurationsAccess().getOutletConfigurationParserRuleCall()); 
            pushFollow(FOLLOW_ruleOutletConfiguration_in_ruleConfigurations291);
            ruleOutletConfiguration();

            state._fsp--;

             after(grammarAccess.getConfigurationsAccess().getOutletConfigurationParserRuleCall()); 

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
    // $ANTLR end "ruleConfigurations"


    // $ANTLR start "entryRuleOutletConfiguration"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:180:1: entryRuleOutletConfiguration : ruleOutletConfiguration EOF ;
    public final void entryRuleOutletConfiguration() throws RecognitionException {
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:181:1: ( ruleOutletConfiguration EOF )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:182:1: ruleOutletConfiguration EOF
            {
             before(grammarAccess.getOutletConfigurationRule()); 
            pushFollow(FOLLOW_ruleOutletConfiguration_in_entryRuleOutletConfiguration317);
            ruleOutletConfiguration();

            state._fsp--;

             after(grammarAccess.getOutletConfigurationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOutletConfiguration324); 

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
    // $ANTLR end "entryRuleOutletConfiguration"


    // $ANTLR start "ruleOutletConfiguration"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:189:1: ruleOutletConfiguration : ( ( rule__OutletConfiguration__Group__0 ) ) ;
    public final void ruleOutletConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:193:2: ( ( ( rule__OutletConfiguration__Group__0 ) ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:194:1: ( ( rule__OutletConfiguration__Group__0 ) )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:194:1: ( ( rule__OutletConfiguration__Group__0 ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:195:1: ( rule__OutletConfiguration__Group__0 )
            {
             before(grammarAccess.getOutletConfigurationAccess().getGroup()); 
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:196:1: ( rule__OutletConfiguration__Group__0 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:196:2: rule__OutletConfiguration__Group__0
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__0_in_ruleOutletConfiguration350);
            rule__OutletConfiguration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOutletConfigurationAccess().getGroup()); 

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
    // $ANTLR end "ruleOutletConfiguration"


    // $ANTLR start "rule__BaseGeneratorModel__Group__0"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:210:1: rule__BaseGeneratorModel__Group__0 : rule__BaseGeneratorModel__Group__0__Impl rule__BaseGeneratorModel__Group__1 ;
    public final void rule__BaseGeneratorModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:214:1: ( rule__BaseGeneratorModel__Group__0__Impl rule__BaseGeneratorModel__Group__1 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:215:2: rule__BaseGeneratorModel__Group__0__Impl rule__BaseGeneratorModel__Group__1
            {
            pushFollow(FOLLOW_rule__BaseGeneratorModel__Group__0__Impl_in_rule__BaseGeneratorModel__Group__0384);
            rule__BaseGeneratorModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BaseGeneratorModel__Group__1_in_rule__BaseGeneratorModel__Group__0387);
            rule__BaseGeneratorModel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseGeneratorModel__Group__0"


    // $ANTLR start "rule__BaseGeneratorModel__Group__0__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:222:1: rule__BaseGeneratorModel__Group__0__Impl : ( 'BaseGenerator' ) ;
    public final void rule__BaseGeneratorModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:226:1: ( ( 'BaseGenerator' ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:227:1: ( 'BaseGenerator' )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:227:1: ( 'BaseGenerator' )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:228:1: 'BaseGenerator'
            {
             before(grammarAccess.getBaseGeneratorModelAccess().getBaseGeneratorKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__BaseGeneratorModel__Group__0__Impl415); 
             after(grammarAccess.getBaseGeneratorModelAccess().getBaseGeneratorKeyword_0()); 

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
    // $ANTLR end "rule__BaseGeneratorModel__Group__0__Impl"


    // $ANTLR start "rule__BaseGeneratorModel__Group__1"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:241:1: rule__BaseGeneratorModel__Group__1 : rule__BaseGeneratorModel__Group__1__Impl rule__BaseGeneratorModel__Group__2 ;
    public final void rule__BaseGeneratorModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:245:1: ( rule__BaseGeneratorModel__Group__1__Impl rule__BaseGeneratorModel__Group__2 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:246:2: rule__BaseGeneratorModel__Group__1__Impl rule__BaseGeneratorModel__Group__2
            {
            pushFollow(FOLLOW_rule__BaseGeneratorModel__Group__1__Impl_in_rule__BaseGeneratorModel__Group__1446);
            rule__BaseGeneratorModel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BaseGeneratorModel__Group__2_in_rule__BaseGeneratorModel__Group__1449);
            rule__BaseGeneratorModel__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseGeneratorModel__Group__1"


    // $ANTLR start "rule__BaseGeneratorModel__Group__1__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:253:1: rule__BaseGeneratorModel__Group__1__Impl : ( '{' ) ;
    public final void rule__BaseGeneratorModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:257:1: ( ( '{' ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:258:1: ( '{' )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:258:1: ( '{' )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:259:1: '{'
            {
             before(grammarAccess.getBaseGeneratorModelAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__BaseGeneratorModel__Group__1__Impl477); 
             after(grammarAccess.getBaseGeneratorModelAccess().getLeftCurlyBracketKeyword_1()); 

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
    // $ANTLR end "rule__BaseGeneratorModel__Group__1__Impl"


    // $ANTLR start "rule__BaseGeneratorModel__Group__2"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:272:1: rule__BaseGeneratorModel__Group__2 : rule__BaseGeneratorModel__Group__2__Impl rule__BaseGeneratorModel__Group__3 ;
    public final void rule__BaseGeneratorModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:276:1: ( rule__BaseGeneratorModel__Group__2__Impl rule__BaseGeneratorModel__Group__3 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:277:2: rule__BaseGeneratorModel__Group__2__Impl rule__BaseGeneratorModel__Group__3
            {
            pushFollow(FOLLOW_rule__BaseGeneratorModel__Group__2__Impl_in_rule__BaseGeneratorModel__Group__2508);
            rule__BaseGeneratorModel__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BaseGeneratorModel__Group__3_in_rule__BaseGeneratorModel__Group__2511);
            rule__BaseGeneratorModel__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseGeneratorModel__Group__2"


    // $ANTLR start "rule__BaseGeneratorModel__Group__2__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:284:1: rule__BaseGeneratorModel__Group__2__Impl : ( ( rule__BaseGeneratorModel__StatechartReferencesAssignment_2 ) ) ;
    public final void rule__BaseGeneratorModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:288:1: ( ( ( rule__BaseGeneratorModel__StatechartReferencesAssignment_2 ) ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:289:1: ( ( rule__BaseGeneratorModel__StatechartReferencesAssignment_2 ) )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:289:1: ( ( rule__BaseGeneratorModel__StatechartReferencesAssignment_2 ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:290:1: ( rule__BaseGeneratorModel__StatechartReferencesAssignment_2 )
            {
             before(grammarAccess.getBaseGeneratorModelAccess().getStatechartReferencesAssignment_2()); 
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:291:1: ( rule__BaseGeneratorModel__StatechartReferencesAssignment_2 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:291:2: rule__BaseGeneratorModel__StatechartReferencesAssignment_2
            {
            pushFollow(FOLLOW_rule__BaseGeneratorModel__StatechartReferencesAssignment_2_in_rule__BaseGeneratorModel__Group__2__Impl538);
            rule__BaseGeneratorModel__StatechartReferencesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getBaseGeneratorModelAccess().getStatechartReferencesAssignment_2()); 

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
    // $ANTLR end "rule__BaseGeneratorModel__Group__2__Impl"


    // $ANTLR start "rule__BaseGeneratorModel__Group__3"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:301:1: rule__BaseGeneratorModel__Group__3 : rule__BaseGeneratorModel__Group__3__Impl rule__BaseGeneratorModel__Group__4 ;
    public final void rule__BaseGeneratorModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:305:1: ( rule__BaseGeneratorModel__Group__3__Impl rule__BaseGeneratorModel__Group__4 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:306:2: rule__BaseGeneratorModel__Group__3__Impl rule__BaseGeneratorModel__Group__4
            {
            pushFollow(FOLLOW_rule__BaseGeneratorModel__Group__3__Impl_in_rule__BaseGeneratorModel__Group__3568);
            rule__BaseGeneratorModel__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BaseGeneratorModel__Group__4_in_rule__BaseGeneratorModel__Group__3571);
            rule__BaseGeneratorModel__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseGeneratorModel__Group__3"


    // $ANTLR start "rule__BaseGeneratorModel__Group__3__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:313:1: rule__BaseGeneratorModel__Group__3__Impl : ( ( rule__BaseGeneratorModel__ConfigurationAssignment_3 ) ) ;
    public final void rule__BaseGeneratorModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:317:1: ( ( ( rule__BaseGeneratorModel__ConfigurationAssignment_3 ) ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:318:1: ( ( rule__BaseGeneratorModel__ConfigurationAssignment_3 ) )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:318:1: ( ( rule__BaseGeneratorModel__ConfigurationAssignment_3 ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:319:1: ( rule__BaseGeneratorModel__ConfigurationAssignment_3 )
            {
             before(grammarAccess.getBaseGeneratorModelAccess().getConfigurationAssignment_3()); 
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:320:1: ( rule__BaseGeneratorModel__ConfigurationAssignment_3 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:320:2: rule__BaseGeneratorModel__ConfigurationAssignment_3
            {
            pushFollow(FOLLOW_rule__BaseGeneratorModel__ConfigurationAssignment_3_in_rule__BaseGeneratorModel__Group__3__Impl598);
            rule__BaseGeneratorModel__ConfigurationAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getBaseGeneratorModelAccess().getConfigurationAssignment_3()); 

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
    // $ANTLR end "rule__BaseGeneratorModel__Group__3__Impl"


    // $ANTLR start "rule__BaseGeneratorModel__Group__4"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:330:1: rule__BaseGeneratorModel__Group__4 : rule__BaseGeneratorModel__Group__4__Impl ;
    public final void rule__BaseGeneratorModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:334:1: ( rule__BaseGeneratorModel__Group__4__Impl )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:335:2: rule__BaseGeneratorModel__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__BaseGeneratorModel__Group__4__Impl_in_rule__BaseGeneratorModel__Group__4628);
            rule__BaseGeneratorModel__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseGeneratorModel__Group__4"


    // $ANTLR start "rule__BaseGeneratorModel__Group__4__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:341:1: rule__BaseGeneratorModel__Group__4__Impl : ( '}' ) ;
    public final void rule__BaseGeneratorModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:345:1: ( ( '}' ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:346:1: ( '}' )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:346:1: ( '}' )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:347:1: '}'
            {
             before(grammarAccess.getBaseGeneratorModelAccess().getRightCurlyBracketKeyword_4()); 
            match(input,13,FOLLOW_13_in_rule__BaseGeneratorModel__Group__4__Impl656); 
             after(grammarAccess.getBaseGeneratorModelAccess().getRightCurlyBracketKeyword_4()); 

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
    // $ANTLR end "rule__BaseGeneratorModel__Group__4__Impl"


    // $ANTLR start "rule__StatechartReferences__Group__0"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:370:1: rule__StatechartReferences__Group__0 : rule__StatechartReferences__Group__0__Impl rule__StatechartReferences__Group__1 ;
    public final void rule__StatechartReferences__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:374:1: ( rule__StatechartReferences__Group__0__Impl rule__StatechartReferences__Group__1 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:375:2: rule__StatechartReferences__Group__0__Impl rule__StatechartReferences__Group__1
            {
            pushFollow(FOLLOW_rule__StatechartReferences__Group__0__Impl_in_rule__StatechartReferences__Group__0697);
            rule__StatechartReferences__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__StatechartReferences__Group__1_in_rule__StatechartReferences__Group__0700);
            rule__StatechartReferences__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StatechartReferences__Group__0"


    // $ANTLR start "rule__StatechartReferences__Group__0__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:382:1: rule__StatechartReferences__Group__0__Impl : ( 'statecharts ' ) ;
    public final void rule__StatechartReferences__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:386:1: ( ( 'statecharts ' ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:387:1: ( 'statecharts ' )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:387:1: ( 'statecharts ' )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:388:1: 'statecharts '
            {
             before(grammarAccess.getStatechartReferencesAccess().getStatechartsKeyword_0()); 
            match(input,14,FOLLOW_14_in_rule__StatechartReferences__Group__0__Impl728); 
             after(grammarAccess.getStatechartReferencesAccess().getStatechartsKeyword_0()); 

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
    // $ANTLR end "rule__StatechartReferences__Group__0__Impl"


    // $ANTLR start "rule__StatechartReferences__Group__1"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:401:1: rule__StatechartReferences__Group__1 : rule__StatechartReferences__Group__1__Impl rule__StatechartReferences__Group__2 ;
    public final void rule__StatechartReferences__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:405:1: ( rule__StatechartReferences__Group__1__Impl rule__StatechartReferences__Group__2 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:406:2: rule__StatechartReferences__Group__1__Impl rule__StatechartReferences__Group__2
            {
            pushFollow(FOLLOW_rule__StatechartReferences__Group__1__Impl_in_rule__StatechartReferences__Group__1759);
            rule__StatechartReferences__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__StatechartReferences__Group__2_in_rule__StatechartReferences__Group__1762);
            rule__StatechartReferences__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StatechartReferences__Group__1"


    // $ANTLR start "rule__StatechartReferences__Group__1__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:413:1: rule__StatechartReferences__Group__1__Impl : ( '{' ) ;
    public final void rule__StatechartReferences__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:417:1: ( ( '{' ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:418:1: ( '{' )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:418:1: ( '{' )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:419:1: '{'
            {
             before(grammarAccess.getStatechartReferencesAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__StatechartReferences__Group__1__Impl790); 
             after(grammarAccess.getStatechartReferencesAccess().getLeftCurlyBracketKeyword_1()); 

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
    // $ANTLR end "rule__StatechartReferences__Group__1__Impl"


    // $ANTLR start "rule__StatechartReferences__Group__2"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:432:1: rule__StatechartReferences__Group__2 : rule__StatechartReferences__Group__2__Impl rule__StatechartReferences__Group__3 ;
    public final void rule__StatechartReferences__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:436:1: ( rule__StatechartReferences__Group__2__Impl rule__StatechartReferences__Group__3 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:437:2: rule__StatechartReferences__Group__2__Impl rule__StatechartReferences__Group__3
            {
            pushFollow(FOLLOW_rule__StatechartReferences__Group__2__Impl_in_rule__StatechartReferences__Group__2821);
            rule__StatechartReferences__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__StatechartReferences__Group__3_in_rule__StatechartReferences__Group__2824);
            rule__StatechartReferences__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StatechartReferences__Group__2"


    // $ANTLR start "rule__StatechartReferences__Group__2__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:444:1: rule__StatechartReferences__Group__2__Impl : ( ( ( rule__StatechartReferences__StatechartsAssignment_2 ) ) ( ( rule__StatechartReferences__StatechartsAssignment_2 )* ) ) ;
    public final void rule__StatechartReferences__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:448:1: ( ( ( ( rule__StatechartReferences__StatechartsAssignment_2 ) ) ( ( rule__StatechartReferences__StatechartsAssignment_2 )* ) ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:449:1: ( ( ( rule__StatechartReferences__StatechartsAssignment_2 ) ) ( ( rule__StatechartReferences__StatechartsAssignment_2 )* ) )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:449:1: ( ( ( rule__StatechartReferences__StatechartsAssignment_2 ) ) ( ( rule__StatechartReferences__StatechartsAssignment_2 )* ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:450:1: ( ( rule__StatechartReferences__StatechartsAssignment_2 ) ) ( ( rule__StatechartReferences__StatechartsAssignment_2 )* )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:450:1: ( ( rule__StatechartReferences__StatechartsAssignment_2 ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:451:1: ( rule__StatechartReferences__StatechartsAssignment_2 )
            {
             before(grammarAccess.getStatechartReferencesAccess().getStatechartsAssignment_2()); 
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:452:1: ( rule__StatechartReferences__StatechartsAssignment_2 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:452:2: rule__StatechartReferences__StatechartsAssignment_2
            {
            pushFollow(FOLLOW_rule__StatechartReferences__StatechartsAssignment_2_in_rule__StatechartReferences__Group__2__Impl853);
            rule__StatechartReferences__StatechartsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getStatechartReferencesAccess().getStatechartsAssignment_2()); 

            }

            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:455:1: ( ( rule__StatechartReferences__StatechartsAssignment_2 )* )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:456:1: ( rule__StatechartReferences__StatechartsAssignment_2 )*
            {
             before(grammarAccess.getStatechartReferencesAccess().getStatechartsAssignment_2()); 
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:457:1: ( rule__StatechartReferences__StatechartsAssignment_2 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:457:2: rule__StatechartReferences__StatechartsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__StatechartReferences__StatechartsAssignment_2_in_rule__StatechartReferences__Group__2__Impl865);
            	    rule__StatechartReferences__StatechartsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getStatechartReferencesAccess().getStatechartsAssignment_2()); 

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
    // $ANTLR end "rule__StatechartReferences__Group__2__Impl"


    // $ANTLR start "rule__StatechartReferences__Group__3"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:468:1: rule__StatechartReferences__Group__3 : rule__StatechartReferences__Group__3__Impl rule__StatechartReferences__Group__4 ;
    public final void rule__StatechartReferences__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:472:1: ( rule__StatechartReferences__Group__3__Impl rule__StatechartReferences__Group__4 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:473:2: rule__StatechartReferences__Group__3__Impl rule__StatechartReferences__Group__4
            {
            pushFollow(FOLLOW_rule__StatechartReferences__Group__3__Impl_in_rule__StatechartReferences__Group__3898);
            rule__StatechartReferences__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__StatechartReferences__Group__4_in_rule__StatechartReferences__Group__3901);
            rule__StatechartReferences__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StatechartReferences__Group__3"


    // $ANTLR start "rule__StatechartReferences__Group__3__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:480:1: rule__StatechartReferences__Group__3__Impl : ( ( rule__StatechartReferences__Group_3__0 )* ) ;
    public final void rule__StatechartReferences__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:484:1: ( ( ( rule__StatechartReferences__Group_3__0 )* ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:485:1: ( ( rule__StatechartReferences__Group_3__0 )* )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:485:1: ( ( rule__StatechartReferences__Group_3__0 )* )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:486:1: ( rule__StatechartReferences__Group_3__0 )*
            {
             before(grammarAccess.getStatechartReferencesAccess().getGroup_3()); 
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:487:1: ( rule__StatechartReferences__Group_3__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:487:2: rule__StatechartReferences__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__StatechartReferences__Group_3__0_in_rule__StatechartReferences__Group__3__Impl928);
            	    rule__StatechartReferences__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getStatechartReferencesAccess().getGroup_3()); 

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
    // $ANTLR end "rule__StatechartReferences__Group__3__Impl"


    // $ANTLR start "rule__StatechartReferences__Group__4"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:497:1: rule__StatechartReferences__Group__4 : rule__StatechartReferences__Group__4__Impl ;
    public final void rule__StatechartReferences__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:501:1: ( rule__StatechartReferences__Group__4__Impl )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:502:2: rule__StatechartReferences__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__StatechartReferences__Group__4__Impl_in_rule__StatechartReferences__Group__4959);
            rule__StatechartReferences__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StatechartReferences__Group__4"


    // $ANTLR start "rule__StatechartReferences__Group__4__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:508:1: rule__StatechartReferences__Group__4__Impl : ( '}' ) ;
    public final void rule__StatechartReferences__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:512:1: ( ( '}' ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:513:1: ( '}' )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:513:1: ( '}' )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:514:1: '}'
            {
             before(grammarAccess.getStatechartReferencesAccess().getRightCurlyBracketKeyword_4()); 
            match(input,13,FOLLOW_13_in_rule__StatechartReferences__Group__4__Impl987); 
             after(grammarAccess.getStatechartReferencesAccess().getRightCurlyBracketKeyword_4()); 

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
    // $ANTLR end "rule__StatechartReferences__Group__4__Impl"


    // $ANTLR start "rule__StatechartReferences__Group_3__0"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:537:1: rule__StatechartReferences__Group_3__0 : rule__StatechartReferences__Group_3__0__Impl rule__StatechartReferences__Group_3__1 ;
    public final void rule__StatechartReferences__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:541:1: ( rule__StatechartReferences__Group_3__0__Impl rule__StatechartReferences__Group_3__1 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:542:2: rule__StatechartReferences__Group_3__0__Impl rule__StatechartReferences__Group_3__1
            {
            pushFollow(FOLLOW_rule__StatechartReferences__Group_3__0__Impl_in_rule__StatechartReferences__Group_3__01028);
            rule__StatechartReferences__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__StatechartReferences__Group_3__1_in_rule__StatechartReferences__Group_3__01031);
            rule__StatechartReferences__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StatechartReferences__Group_3__0"


    // $ANTLR start "rule__StatechartReferences__Group_3__0__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:549:1: rule__StatechartReferences__Group_3__0__Impl : ( ',' ) ;
    public final void rule__StatechartReferences__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:553:1: ( ( ',' ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:554:1: ( ',' )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:554:1: ( ',' )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:555:1: ','
            {
             before(grammarAccess.getStatechartReferencesAccess().getCommaKeyword_3_0()); 
            match(input,15,FOLLOW_15_in_rule__StatechartReferences__Group_3__0__Impl1059); 
             after(grammarAccess.getStatechartReferencesAccess().getCommaKeyword_3_0()); 

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
    // $ANTLR end "rule__StatechartReferences__Group_3__0__Impl"


    // $ANTLR start "rule__StatechartReferences__Group_3__1"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:568:1: rule__StatechartReferences__Group_3__1 : rule__StatechartReferences__Group_3__1__Impl ;
    public final void rule__StatechartReferences__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:572:1: ( rule__StatechartReferences__Group_3__1__Impl )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:573:2: rule__StatechartReferences__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__StatechartReferences__Group_3__1__Impl_in_rule__StatechartReferences__Group_3__11090);
            rule__StatechartReferences__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StatechartReferences__Group_3__1"


    // $ANTLR start "rule__StatechartReferences__Group_3__1__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:579:1: rule__StatechartReferences__Group_3__1__Impl : ( ( rule__StatechartReferences__StatechartsAssignment_3_1 ) ) ;
    public final void rule__StatechartReferences__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:583:1: ( ( ( rule__StatechartReferences__StatechartsAssignment_3_1 ) ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:584:1: ( ( rule__StatechartReferences__StatechartsAssignment_3_1 ) )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:584:1: ( ( rule__StatechartReferences__StatechartsAssignment_3_1 ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:585:1: ( rule__StatechartReferences__StatechartsAssignment_3_1 )
            {
             before(grammarAccess.getStatechartReferencesAccess().getStatechartsAssignment_3_1()); 
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:586:1: ( rule__StatechartReferences__StatechartsAssignment_3_1 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:586:2: rule__StatechartReferences__StatechartsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__StatechartReferences__StatechartsAssignment_3_1_in_rule__StatechartReferences__Group_3__1__Impl1117);
            rule__StatechartReferences__StatechartsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getStatechartReferencesAccess().getStatechartsAssignment_3_1()); 

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
    // $ANTLR end "rule__StatechartReferences__Group_3__1__Impl"


    // $ANTLR start "rule__OutletConfiguration__Group__0"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:600:1: rule__OutletConfiguration__Group__0 : rule__OutletConfiguration__Group__0__Impl rule__OutletConfiguration__Group__1 ;
    public final void rule__OutletConfiguration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:604:1: ( rule__OutletConfiguration__Group__0__Impl rule__OutletConfiguration__Group__1 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:605:2: rule__OutletConfiguration__Group__0__Impl rule__OutletConfiguration__Group__1
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__0__Impl_in_rule__OutletConfiguration__Group__01151);
            rule__OutletConfiguration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OutletConfiguration__Group__1_in_rule__OutletConfiguration__Group__01154);
            rule__OutletConfiguration__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OutletConfiguration__Group__0"


    // $ANTLR start "rule__OutletConfiguration__Group__0__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:612:1: rule__OutletConfiguration__Group__0__Impl : ( () ) ;
    public final void rule__OutletConfiguration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:616:1: ( ( () ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:617:1: ( () )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:617:1: ( () )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:618:1: ()
            {
             before(grammarAccess.getOutletConfigurationAccess().getOutletConfigurationCustomAction_0()); 
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:619:1: ()
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:621:1: 
            {
            }

             after(grammarAccess.getOutletConfigurationAccess().getOutletConfigurationCustomAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OutletConfiguration__Group__0__Impl"


    // $ANTLR start "rule__OutletConfiguration__Group__1"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:631:1: rule__OutletConfiguration__Group__1 : rule__OutletConfiguration__Group__1__Impl rule__OutletConfiguration__Group__2 ;
    public final void rule__OutletConfiguration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:635:1: ( rule__OutletConfiguration__Group__1__Impl rule__OutletConfiguration__Group__2 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:636:2: rule__OutletConfiguration__Group__1__Impl rule__OutletConfiguration__Group__2
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__1__Impl_in_rule__OutletConfiguration__Group__11212);
            rule__OutletConfiguration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OutletConfiguration__Group__2_in_rule__OutletConfiguration__Group__11215);
            rule__OutletConfiguration__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OutletConfiguration__Group__1"


    // $ANTLR start "rule__OutletConfiguration__Group__1__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:643:1: rule__OutletConfiguration__Group__1__Impl : ( 'outlet' ) ;
    public final void rule__OutletConfiguration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:647:1: ( ( 'outlet' ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:648:1: ( 'outlet' )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:648:1: ( 'outlet' )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:649:1: 'outlet'
            {
             before(grammarAccess.getOutletConfigurationAccess().getOutletKeyword_1()); 
            match(input,16,FOLLOW_16_in_rule__OutletConfiguration__Group__1__Impl1243); 
             after(grammarAccess.getOutletConfigurationAccess().getOutletKeyword_1()); 

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
    // $ANTLR end "rule__OutletConfiguration__Group__1__Impl"


    // $ANTLR start "rule__OutletConfiguration__Group__2"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:662:1: rule__OutletConfiguration__Group__2 : rule__OutletConfiguration__Group__2__Impl rule__OutletConfiguration__Group__3 ;
    public final void rule__OutletConfiguration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:666:1: ( rule__OutletConfiguration__Group__2__Impl rule__OutletConfiguration__Group__3 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:667:2: rule__OutletConfiguration__Group__2__Impl rule__OutletConfiguration__Group__3
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__2__Impl_in_rule__OutletConfiguration__Group__21274);
            rule__OutletConfiguration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OutletConfiguration__Group__3_in_rule__OutletConfiguration__Group__21277);
            rule__OutletConfiguration__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OutletConfiguration__Group__2"


    // $ANTLR start "rule__OutletConfiguration__Group__2__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:674:1: rule__OutletConfiguration__Group__2__Impl : ( '{' ) ;
    public final void rule__OutletConfiguration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:678:1: ( ( '{' ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:679:1: ( '{' )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:679:1: ( '{' )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:680:1: '{'
            {
             before(grammarAccess.getOutletConfigurationAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FOLLOW_12_in_rule__OutletConfiguration__Group__2__Impl1305); 
             after(grammarAccess.getOutletConfigurationAccess().getLeftCurlyBracketKeyword_2()); 

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
    // $ANTLR end "rule__OutletConfiguration__Group__2__Impl"


    // $ANTLR start "rule__OutletConfiguration__Group__3"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:693:1: rule__OutletConfiguration__Group__3 : rule__OutletConfiguration__Group__3__Impl rule__OutletConfiguration__Group__4 ;
    public final void rule__OutletConfiguration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:697:1: ( rule__OutletConfiguration__Group__3__Impl rule__OutletConfiguration__Group__4 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:698:2: rule__OutletConfiguration__Group__3__Impl rule__OutletConfiguration__Group__4
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__3__Impl_in_rule__OutletConfiguration__Group__31336);
            rule__OutletConfiguration__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OutletConfiguration__Group__4_in_rule__OutletConfiguration__Group__31339);
            rule__OutletConfiguration__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OutletConfiguration__Group__3"


    // $ANTLR start "rule__OutletConfiguration__Group__3__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:705:1: rule__OutletConfiguration__Group__3__Impl : ( 'projectName' ) ;
    public final void rule__OutletConfiguration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:709:1: ( ( 'projectName' ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:710:1: ( 'projectName' )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:710:1: ( 'projectName' )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:711:1: 'projectName'
            {
             before(grammarAccess.getOutletConfigurationAccess().getProjectNameKeyword_3()); 
            match(input,17,FOLLOW_17_in_rule__OutletConfiguration__Group__3__Impl1367); 
             after(grammarAccess.getOutletConfigurationAccess().getProjectNameKeyword_3()); 

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
    // $ANTLR end "rule__OutletConfiguration__Group__3__Impl"


    // $ANTLR start "rule__OutletConfiguration__Group__4"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:724:1: rule__OutletConfiguration__Group__4 : rule__OutletConfiguration__Group__4__Impl rule__OutletConfiguration__Group__5 ;
    public final void rule__OutletConfiguration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:728:1: ( rule__OutletConfiguration__Group__4__Impl rule__OutletConfiguration__Group__5 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:729:2: rule__OutletConfiguration__Group__4__Impl rule__OutletConfiguration__Group__5
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__4__Impl_in_rule__OutletConfiguration__Group__41398);
            rule__OutletConfiguration__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OutletConfiguration__Group__5_in_rule__OutletConfiguration__Group__41401);
            rule__OutletConfiguration__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OutletConfiguration__Group__4"


    // $ANTLR start "rule__OutletConfiguration__Group__4__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:736:1: rule__OutletConfiguration__Group__4__Impl : ( '=' ) ;
    public final void rule__OutletConfiguration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:740:1: ( ( '=' ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:741:1: ( '=' )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:741:1: ( '=' )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:742:1: '='
            {
             before(grammarAccess.getOutletConfigurationAccess().getEqualsSignKeyword_4()); 
            match(input,18,FOLLOW_18_in_rule__OutletConfiguration__Group__4__Impl1429); 
             after(grammarAccess.getOutletConfigurationAccess().getEqualsSignKeyword_4()); 

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
    // $ANTLR end "rule__OutletConfiguration__Group__4__Impl"


    // $ANTLR start "rule__OutletConfiguration__Group__5"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:755:1: rule__OutletConfiguration__Group__5 : rule__OutletConfiguration__Group__5__Impl rule__OutletConfiguration__Group__6 ;
    public final void rule__OutletConfiguration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:759:1: ( rule__OutletConfiguration__Group__5__Impl rule__OutletConfiguration__Group__6 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:760:2: rule__OutletConfiguration__Group__5__Impl rule__OutletConfiguration__Group__6
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__5__Impl_in_rule__OutletConfiguration__Group__51460);
            rule__OutletConfiguration__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OutletConfiguration__Group__6_in_rule__OutletConfiguration__Group__51463);
            rule__OutletConfiguration__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OutletConfiguration__Group__5"


    // $ANTLR start "rule__OutletConfiguration__Group__5__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:767:1: rule__OutletConfiguration__Group__5__Impl : ( ( rule__OutletConfiguration__ProjectNameAssignment_5 ) ) ;
    public final void rule__OutletConfiguration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:771:1: ( ( ( rule__OutletConfiguration__ProjectNameAssignment_5 ) ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:772:1: ( ( rule__OutletConfiguration__ProjectNameAssignment_5 ) )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:772:1: ( ( rule__OutletConfiguration__ProjectNameAssignment_5 ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:773:1: ( rule__OutletConfiguration__ProjectNameAssignment_5 )
            {
             before(grammarAccess.getOutletConfigurationAccess().getProjectNameAssignment_5()); 
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:774:1: ( rule__OutletConfiguration__ProjectNameAssignment_5 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:774:2: rule__OutletConfiguration__ProjectNameAssignment_5
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__ProjectNameAssignment_5_in_rule__OutletConfiguration__Group__5__Impl1490);
            rule__OutletConfiguration__ProjectNameAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getOutletConfigurationAccess().getProjectNameAssignment_5()); 

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
    // $ANTLR end "rule__OutletConfiguration__Group__5__Impl"


    // $ANTLR start "rule__OutletConfiguration__Group__6"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:784:1: rule__OutletConfiguration__Group__6 : rule__OutletConfiguration__Group__6__Impl rule__OutletConfiguration__Group__7 ;
    public final void rule__OutletConfiguration__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:788:1: ( rule__OutletConfiguration__Group__6__Impl rule__OutletConfiguration__Group__7 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:789:2: rule__OutletConfiguration__Group__6__Impl rule__OutletConfiguration__Group__7
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__6__Impl_in_rule__OutletConfiguration__Group__61520);
            rule__OutletConfiguration__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OutletConfiguration__Group__7_in_rule__OutletConfiguration__Group__61523);
            rule__OutletConfiguration__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OutletConfiguration__Group__6"


    // $ANTLR start "rule__OutletConfiguration__Group__6__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:796:1: rule__OutletConfiguration__Group__6__Impl : ( 'folder' ) ;
    public final void rule__OutletConfiguration__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:800:1: ( ( 'folder' ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:801:1: ( 'folder' )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:801:1: ( 'folder' )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:802:1: 'folder'
            {
             before(grammarAccess.getOutletConfigurationAccess().getFolderKeyword_6()); 
            match(input,19,FOLLOW_19_in_rule__OutletConfiguration__Group__6__Impl1551); 
             after(grammarAccess.getOutletConfigurationAccess().getFolderKeyword_6()); 

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
    // $ANTLR end "rule__OutletConfiguration__Group__6__Impl"


    // $ANTLR start "rule__OutletConfiguration__Group__7"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:815:1: rule__OutletConfiguration__Group__7 : rule__OutletConfiguration__Group__7__Impl rule__OutletConfiguration__Group__8 ;
    public final void rule__OutletConfiguration__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:819:1: ( rule__OutletConfiguration__Group__7__Impl rule__OutletConfiguration__Group__8 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:820:2: rule__OutletConfiguration__Group__7__Impl rule__OutletConfiguration__Group__8
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__7__Impl_in_rule__OutletConfiguration__Group__71582);
            rule__OutletConfiguration__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OutletConfiguration__Group__8_in_rule__OutletConfiguration__Group__71585);
            rule__OutletConfiguration__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OutletConfiguration__Group__7"


    // $ANTLR start "rule__OutletConfiguration__Group__7__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:827:1: rule__OutletConfiguration__Group__7__Impl : ( '=' ) ;
    public final void rule__OutletConfiguration__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:831:1: ( ( '=' ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:832:1: ( '=' )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:832:1: ( '=' )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:833:1: '='
            {
             before(grammarAccess.getOutletConfigurationAccess().getEqualsSignKeyword_7()); 
            match(input,18,FOLLOW_18_in_rule__OutletConfiguration__Group__7__Impl1613); 
             after(grammarAccess.getOutletConfigurationAccess().getEqualsSignKeyword_7()); 

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
    // $ANTLR end "rule__OutletConfiguration__Group__7__Impl"


    // $ANTLR start "rule__OutletConfiguration__Group__8"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:846:1: rule__OutletConfiguration__Group__8 : rule__OutletConfiguration__Group__8__Impl rule__OutletConfiguration__Group__9 ;
    public final void rule__OutletConfiguration__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:850:1: ( rule__OutletConfiguration__Group__8__Impl rule__OutletConfiguration__Group__9 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:851:2: rule__OutletConfiguration__Group__8__Impl rule__OutletConfiguration__Group__9
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__8__Impl_in_rule__OutletConfiguration__Group__81644);
            rule__OutletConfiguration__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OutletConfiguration__Group__9_in_rule__OutletConfiguration__Group__81647);
            rule__OutletConfiguration__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OutletConfiguration__Group__8"


    // $ANTLR start "rule__OutletConfiguration__Group__8__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:858:1: rule__OutletConfiguration__Group__8__Impl : ( ( rule__OutletConfiguration__TargetFolderAssignment_8 ) ) ;
    public final void rule__OutletConfiguration__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:862:1: ( ( ( rule__OutletConfiguration__TargetFolderAssignment_8 ) ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:863:1: ( ( rule__OutletConfiguration__TargetFolderAssignment_8 ) )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:863:1: ( ( rule__OutletConfiguration__TargetFolderAssignment_8 ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:864:1: ( rule__OutletConfiguration__TargetFolderAssignment_8 )
            {
             before(grammarAccess.getOutletConfigurationAccess().getTargetFolderAssignment_8()); 
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:865:1: ( rule__OutletConfiguration__TargetFolderAssignment_8 )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:865:2: rule__OutletConfiguration__TargetFolderAssignment_8
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__TargetFolderAssignment_8_in_rule__OutletConfiguration__Group__8__Impl1674);
            rule__OutletConfiguration__TargetFolderAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getOutletConfigurationAccess().getTargetFolderAssignment_8()); 

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
    // $ANTLR end "rule__OutletConfiguration__Group__8__Impl"


    // $ANTLR start "rule__OutletConfiguration__Group__9"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:875:1: rule__OutletConfiguration__Group__9 : rule__OutletConfiguration__Group__9__Impl ;
    public final void rule__OutletConfiguration__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:879:1: ( rule__OutletConfiguration__Group__9__Impl )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:880:2: rule__OutletConfiguration__Group__9__Impl
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__9__Impl_in_rule__OutletConfiguration__Group__91704);
            rule__OutletConfiguration__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OutletConfiguration__Group__9"


    // $ANTLR start "rule__OutletConfiguration__Group__9__Impl"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:886:1: rule__OutletConfiguration__Group__9__Impl : ( '}' ) ;
    public final void rule__OutletConfiguration__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:890:1: ( ( '}' ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:891:1: ( '}' )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:891:1: ( '}' )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:892:1: '}'
            {
             before(grammarAccess.getOutletConfigurationAccess().getRightCurlyBracketKeyword_9()); 
            match(input,13,FOLLOW_13_in_rule__OutletConfiguration__Group__9__Impl1732); 
             after(grammarAccess.getOutletConfigurationAccess().getRightCurlyBracketKeyword_9()); 

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
    // $ANTLR end "rule__OutletConfiguration__Group__9__Impl"


    // $ANTLR start "rule__BaseGeneratorModel__StatechartReferencesAssignment_2"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:926:1: rule__BaseGeneratorModel__StatechartReferencesAssignment_2 : ( ruleStatechartReferences ) ;
    public final void rule__BaseGeneratorModel__StatechartReferencesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:930:1: ( ( ruleStatechartReferences ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:931:1: ( ruleStatechartReferences )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:931:1: ( ruleStatechartReferences )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:932:1: ruleStatechartReferences
            {
             before(grammarAccess.getBaseGeneratorModelAccess().getStatechartReferencesStatechartReferencesParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleStatechartReferences_in_rule__BaseGeneratorModel__StatechartReferencesAssignment_21788);
            ruleStatechartReferences();

            state._fsp--;

             after(grammarAccess.getBaseGeneratorModelAccess().getStatechartReferencesStatechartReferencesParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__BaseGeneratorModel__StatechartReferencesAssignment_2"


    // $ANTLR start "rule__BaseGeneratorModel__ConfigurationAssignment_3"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:941:1: rule__BaseGeneratorModel__ConfigurationAssignment_3 : ( ruleGeneratorConfiguration ) ;
    public final void rule__BaseGeneratorModel__ConfigurationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:945:1: ( ( ruleGeneratorConfiguration ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:946:1: ( ruleGeneratorConfiguration )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:946:1: ( ruleGeneratorConfiguration )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:947:1: ruleGeneratorConfiguration
            {
             before(grammarAccess.getBaseGeneratorModelAccess().getConfigurationGeneratorConfigurationParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleGeneratorConfiguration_in_rule__BaseGeneratorModel__ConfigurationAssignment_31819);
            ruleGeneratorConfiguration();

            state._fsp--;

             after(grammarAccess.getBaseGeneratorModelAccess().getConfigurationGeneratorConfigurationParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__BaseGeneratorModel__ConfigurationAssignment_3"


    // $ANTLR start "rule__StatechartReferences__StatechartsAssignment_2"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:956:1: rule__StatechartReferences__StatechartsAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__StatechartReferences__StatechartsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:960:1: ( ( ( RULE_ID ) ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:961:1: ( ( RULE_ID ) )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:961:1: ( ( RULE_ID ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:962:1: ( RULE_ID )
            {
             before(grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartCrossReference_2_0()); 
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:963:1: ( RULE_ID )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:964:1: RULE_ID
            {
             before(grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__StatechartReferences__StatechartsAssignment_21854); 
             after(grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartCrossReference_2_0()); 

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
    // $ANTLR end "rule__StatechartReferences__StatechartsAssignment_2"


    // $ANTLR start "rule__StatechartReferences__StatechartsAssignment_3_1"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:975:1: rule__StatechartReferences__StatechartsAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__StatechartReferences__StatechartsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:979:1: ( ( ( RULE_ID ) ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:980:1: ( ( RULE_ID ) )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:980:1: ( ( RULE_ID ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:981:1: ( RULE_ID )
            {
             before(grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartCrossReference_3_1_0()); 
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:982:1: ( RULE_ID )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:983:1: RULE_ID
            {
             before(grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__StatechartReferences__StatechartsAssignment_3_11893); 
             after(grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartIDTerminalRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartCrossReference_3_1_0()); 

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
    // $ANTLR end "rule__StatechartReferences__StatechartsAssignment_3_1"


    // $ANTLR start "rule__GeneratorConfiguration__ConfigurationsAssignment"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:994:1: rule__GeneratorConfiguration__ConfigurationsAssignment : ( ruleConfigurations ) ;
    public final void rule__GeneratorConfiguration__ConfigurationsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:998:1: ( ( ruleConfigurations ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:999:1: ( ruleConfigurations )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:999:1: ( ruleConfigurations )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:1000:1: ruleConfigurations
            {
             before(grammarAccess.getGeneratorConfigurationAccess().getConfigurationsConfigurationsParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleConfigurations_in_rule__GeneratorConfiguration__ConfigurationsAssignment1928);
            ruleConfigurations();

            state._fsp--;

             after(grammarAccess.getGeneratorConfigurationAccess().getConfigurationsConfigurationsParserRuleCall_0()); 

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
    // $ANTLR end "rule__GeneratorConfiguration__ConfigurationsAssignment"


    // $ANTLR start "rule__OutletConfiguration__ProjectNameAssignment_5"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:1009:1: rule__OutletConfiguration__ProjectNameAssignment_5 : ( RULE_STRING ) ;
    public final void rule__OutletConfiguration__ProjectNameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:1013:1: ( ( RULE_STRING ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:1014:1: ( RULE_STRING )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:1014:1: ( RULE_STRING )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:1015:1: RULE_STRING
            {
             before(grammarAccess.getOutletConfigurationAccess().getProjectNameSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__OutletConfiguration__ProjectNameAssignment_51959); 
             after(grammarAccess.getOutletConfigurationAccess().getProjectNameSTRINGTerminalRuleCall_5_0()); 

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
    // $ANTLR end "rule__OutletConfiguration__ProjectNameAssignment_5"


    // $ANTLR start "rule__OutletConfiguration__TargetFolderAssignment_8"
    // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:1024:1: rule__OutletConfiguration__TargetFolderAssignment_8 : ( RULE_STRING ) ;
    public final void rule__OutletConfiguration__TargetFolderAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:1028:1: ( ( RULE_STRING ) )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:1029:1: ( RULE_STRING )
            {
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:1029:1: ( RULE_STRING )
            // ../org.yakindu.sct.generator.model.base.ui/src-gen/org/yakindu/sct/generator/model/base/ui/contentassist/antlr/internal/InternalBaseGen.g:1030:1: RULE_STRING
            {
             before(grammarAccess.getOutletConfigurationAccess().getTargetFolderSTRINGTerminalRuleCall_8_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__OutletConfiguration__TargetFolderAssignment_81990); 
             after(grammarAccess.getOutletConfigurationAccess().getTargetFolderSTRINGTerminalRuleCall_8_0()); 

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
    // $ANTLR end "rule__OutletConfiguration__TargetFolderAssignment_8"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleBaseGeneratorModel_in_entryRuleBaseGeneratorModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBaseGeneratorModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__Group__0_in_ruleBaseGeneratorModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatechartReferences_in_entryRuleStatechartReferences121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatechartReferences128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group__0_in_ruleStatechartReferences154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratorConfiguration_in_entryRuleGeneratorConfiguration181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneratorConfiguration188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GeneratorConfiguration__ConfigurationsAssignment_in_ruleGeneratorConfiguration216 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__GeneratorConfiguration__ConfigurationsAssignment_in_ruleGeneratorConfiguration228 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleConfigurations_in_entryRuleConfigurations258 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConfigurations265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutletConfiguration_in_ruleConfigurations291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutletConfiguration_in_entryRuleOutletConfiguration317 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOutletConfiguration324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__0_in_ruleOutletConfiguration350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__Group__0__Impl_in_rule__BaseGeneratorModel__Group__0384 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__Group__1_in_rule__BaseGeneratorModel__Group__0387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__BaseGeneratorModel__Group__0__Impl415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__Group__1__Impl_in_rule__BaseGeneratorModel__Group__1446 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__Group__2_in_rule__BaseGeneratorModel__Group__1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__BaseGeneratorModel__Group__1__Impl477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__Group__2__Impl_in_rule__BaseGeneratorModel__Group__2508 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__Group__3_in_rule__BaseGeneratorModel__Group__2511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__StatechartReferencesAssignment_2_in_rule__BaseGeneratorModel__Group__2__Impl538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__Group__3__Impl_in_rule__BaseGeneratorModel__Group__3568 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__Group__4_in_rule__BaseGeneratorModel__Group__3571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__ConfigurationAssignment_3_in_rule__BaseGeneratorModel__Group__3__Impl598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__Group__4__Impl_in_rule__BaseGeneratorModel__Group__4628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__BaseGeneratorModel__Group__4__Impl656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group__0__Impl_in_rule__StatechartReferences__Group__0697 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group__1_in_rule__StatechartReferences__Group__0700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__StatechartReferences__Group__0__Impl728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group__1__Impl_in_rule__StatechartReferences__Group__1759 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group__2_in_rule__StatechartReferences__Group__1762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__StatechartReferences__Group__1__Impl790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group__2__Impl_in_rule__StatechartReferences__Group__2821 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group__3_in_rule__StatechartReferences__Group__2824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StatechartReferences__StatechartsAssignment_2_in_rule__StatechartReferences__Group__2__Impl853 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__StatechartReferences__StatechartsAssignment_2_in_rule__StatechartReferences__Group__2__Impl865 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group__3__Impl_in_rule__StatechartReferences__Group__3898 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group__4_in_rule__StatechartReferences__Group__3901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group_3__0_in_rule__StatechartReferences__Group__3__Impl928 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group__4__Impl_in_rule__StatechartReferences__Group__4959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__StatechartReferences__Group__4__Impl987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group_3__0__Impl_in_rule__StatechartReferences__Group_3__01028 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group_3__1_in_rule__StatechartReferences__Group_3__01031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__StatechartReferences__Group_3__0__Impl1059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group_3__1__Impl_in_rule__StatechartReferences__Group_3__11090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StatechartReferences__StatechartsAssignment_3_1_in_rule__StatechartReferences__Group_3__1__Impl1117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__0__Impl_in_rule__OutletConfiguration__Group__01151 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__1_in_rule__OutletConfiguration__Group__01154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__1__Impl_in_rule__OutletConfiguration__Group__11212 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__2_in_rule__OutletConfiguration__Group__11215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__OutletConfiguration__Group__1__Impl1243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__2__Impl_in_rule__OutletConfiguration__Group__21274 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__3_in_rule__OutletConfiguration__Group__21277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__OutletConfiguration__Group__2__Impl1305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__3__Impl_in_rule__OutletConfiguration__Group__31336 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__4_in_rule__OutletConfiguration__Group__31339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__OutletConfiguration__Group__3__Impl1367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__4__Impl_in_rule__OutletConfiguration__Group__41398 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__5_in_rule__OutletConfiguration__Group__41401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__OutletConfiguration__Group__4__Impl1429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__5__Impl_in_rule__OutletConfiguration__Group__51460 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__6_in_rule__OutletConfiguration__Group__51463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__ProjectNameAssignment_5_in_rule__OutletConfiguration__Group__5__Impl1490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__6__Impl_in_rule__OutletConfiguration__Group__61520 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__7_in_rule__OutletConfiguration__Group__61523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__OutletConfiguration__Group__6__Impl1551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__7__Impl_in_rule__OutletConfiguration__Group__71582 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__8_in_rule__OutletConfiguration__Group__71585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__OutletConfiguration__Group__7__Impl1613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__8__Impl_in_rule__OutletConfiguration__Group__81644 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__9_in_rule__OutletConfiguration__Group__81647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__TargetFolderAssignment_8_in_rule__OutletConfiguration__Group__8__Impl1674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__9__Impl_in_rule__OutletConfiguration__Group__91704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__OutletConfiguration__Group__9__Impl1732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatechartReferences_in_rule__BaseGeneratorModel__StatechartReferencesAssignment_21788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratorConfiguration_in_rule__BaseGeneratorModel__ConfigurationAssignment_31819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__StatechartReferences__StatechartsAssignment_21854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__StatechartReferences__StatechartsAssignment_3_11893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConfigurations_in_rule__GeneratorConfiguration__ConfigurationsAssignment1928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__OutletConfiguration__ProjectNameAssignment_51959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__OutletConfiguration__TargetFolderAssignment_81990 = new BitSet(new long[]{0x0000000000000002L});

}