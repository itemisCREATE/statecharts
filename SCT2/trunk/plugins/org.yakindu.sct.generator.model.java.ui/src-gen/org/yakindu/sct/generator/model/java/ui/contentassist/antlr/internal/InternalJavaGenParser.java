package org.yakindu.sct.generator.model.java.ui.contentassist.antlr.internal; 

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
import org.yakindu.sct.generator.model.java.services.JavaGenGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalJavaGenParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'cycleBased'", "'eventDriven'", "'JavaGenerator'", "'{'", "'}'", "'naming'", "'interfacePackage'", "'='", "'implementationPackage'", "'copyrightHeader'", "'executionType'", "'type'", "'statecharts '", "','", "'outlet'", "'projectName'", "'folder'"
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
    public String getGrammarFileName() { return "../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g"; }


     
     	private JavaGenGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(JavaGenGrammarAccess grammarAccess) {
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:61:1: entryRuleBaseGeneratorModel : ruleBaseGeneratorModel EOF ;
    public final void entryRuleBaseGeneratorModel() throws RecognitionException {
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:62:1: ( ruleBaseGeneratorModel EOF )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:63:1: ruleBaseGeneratorModel EOF
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:70:1: ruleBaseGeneratorModel : ( ( rule__BaseGeneratorModel__Group__0 ) ) ;
    public final void ruleBaseGeneratorModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:74:2: ( ( ( rule__BaseGeneratorModel__Group__0 ) ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:75:1: ( ( rule__BaseGeneratorModel__Group__0 ) )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:75:1: ( ( rule__BaseGeneratorModel__Group__0 ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:76:1: ( rule__BaseGeneratorModel__Group__0 )
            {
             before(grammarAccess.getBaseGeneratorModelAccess().getGroup()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:77:1: ( rule__BaseGeneratorModel__Group__0 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:77:2: rule__BaseGeneratorModel__Group__0
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


    // $ANTLR start "entryRuleConfigurations"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:89:1: entryRuleConfigurations : ruleConfigurations EOF ;
    public final void entryRuleConfigurations() throws RecognitionException {
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:90:1: ( ruleConfigurations EOF )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:91:1: ruleConfigurations EOF
            {
             before(grammarAccess.getConfigurationsRule()); 
            pushFollow(FOLLOW_ruleConfigurations_in_entryRuleConfigurations121);
            ruleConfigurations();

            state._fsp--;

             after(grammarAccess.getConfigurationsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConfigurations128); 

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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:98:1: ruleConfigurations : ( ( rule__Configurations__Alternatives ) ) ;
    public final void ruleConfigurations() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:102:2: ( ( ( rule__Configurations__Alternatives ) ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:103:1: ( ( rule__Configurations__Alternatives ) )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:103:1: ( ( rule__Configurations__Alternatives ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:104:1: ( rule__Configurations__Alternatives )
            {
             before(grammarAccess.getConfigurationsAccess().getAlternatives()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:105:1: ( rule__Configurations__Alternatives )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:105:2: rule__Configurations__Alternatives
            {
            pushFollow(FOLLOW_rule__Configurations__Alternatives_in_ruleConfigurations154);
            rule__Configurations__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConfigurationsAccess().getAlternatives()); 

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


    // $ANTLR start "entryRuleNamingConfiguration"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:117:1: entryRuleNamingConfiguration : ruleNamingConfiguration EOF ;
    public final void entryRuleNamingConfiguration() throws RecognitionException {
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:118:1: ( ruleNamingConfiguration EOF )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:119:1: ruleNamingConfiguration EOF
            {
             before(grammarAccess.getNamingConfigurationRule()); 
            pushFollow(FOLLOW_ruleNamingConfiguration_in_entryRuleNamingConfiguration181);
            ruleNamingConfiguration();

            state._fsp--;

             after(grammarAccess.getNamingConfigurationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamingConfiguration188); 

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
    // $ANTLR end "entryRuleNamingConfiguration"


    // $ANTLR start "ruleNamingConfiguration"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:126:1: ruleNamingConfiguration : ( ( rule__NamingConfiguration__Group__0 ) ) ;
    public final void ruleNamingConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:130:2: ( ( ( rule__NamingConfiguration__Group__0 ) ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:131:1: ( ( rule__NamingConfiguration__Group__0 ) )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:131:1: ( ( rule__NamingConfiguration__Group__0 ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:132:1: ( rule__NamingConfiguration__Group__0 )
            {
             before(grammarAccess.getNamingConfigurationAccess().getGroup()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:133:1: ( rule__NamingConfiguration__Group__0 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:133:2: rule__NamingConfiguration__Group__0
            {
            pushFollow(FOLLOW_rule__NamingConfiguration__Group__0_in_ruleNamingConfiguration214);
            rule__NamingConfiguration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNamingConfigurationAccess().getGroup()); 

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
    // $ANTLR end "ruleNamingConfiguration"


    // $ANTLR start "entryRuleExecutionTypeConfiguration"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:145:1: entryRuleExecutionTypeConfiguration : ruleExecutionTypeConfiguration EOF ;
    public final void entryRuleExecutionTypeConfiguration() throws RecognitionException {
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:146:1: ( ruleExecutionTypeConfiguration EOF )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:147:1: ruleExecutionTypeConfiguration EOF
            {
             before(grammarAccess.getExecutionTypeConfigurationRule()); 
            pushFollow(FOLLOW_ruleExecutionTypeConfiguration_in_entryRuleExecutionTypeConfiguration241);
            ruleExecutionTypeConfiguration();

            state._fsp--;

             after(grammarAccess.getExecutionTypeConfigurationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExecutionTypeConfiguration248); 

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
    // $ANTLR end "entryRuleExecutionTypeConfiguration"


    // $ANTLR start "ruleExecutionTypeConfiguration"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:154:1: ruleExecutionTypeConfiguration : ( ( rule__ExecutionTypeConfiguration__Group__0 ) ) ;
    public final void ruleExecutionTypeConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:158:2: ( ( ( rule__ExecutionTypeConfiguration__Group__0 ) ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:159:1: ( ( rule__ExecutionTypeConfiguration__Group__0 ) )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:159:1: ( ( rule__ExecutionTypeConfiguration__Group__0 ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:160:1: ( rule__ExecutionTypeConfiguration__Group__0 )
            {
             before(grammarAccess.getExecutionTypeConfigurationAccess().getGroup()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:161:1: ( rule__ExecutionTypeConfiguration__Group__0 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:161:2: rule__ExecutionTypeConfiguration__Group__0
            {
            pushFollow(FOLLOW_rule__ExecutionTypeConfiguration__Group__0_in_ruleExecutionTypeConfiguration274);
            rule__ExecutionTypeConfiguration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExecutionTypeConfigurationAccess().getGroup()); 

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
    // $ANTLR end "ruleExecutionTypeConfiguration"


    // $ANTLR start "entryRuleStatechartReferences"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:173:1: entryRuleStatechartReferences : ruleStatechartReferences EOF ;
    public final void entryRuleStatechartReferences() throws RecognitionException {
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:174:1: ( ruleStatechartReferences EOF )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:175:1: ruleStatechartReferences EOF
            {
             before(grammarAccess.getStatechartReferencesRule()); 
            pushFollow(FOLLOW_ruleStatechartReferences_in_entryRuleStatechartReferences301);
            ruleStatechartReferences();

            state._fsp--;

             after(grammarAccess.getStatechartReferencesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatechartReferences308); 

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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:182:1: ruleStatechartReferences : ( ( rule__StatechartReferences__Group__0 ) ) ;
    public final void ruleStatechartReferences() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:186:2: ( ( ( rule__StatechartReferences__Group__0 ) ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:187:1: ( ( rule__StatechartReferences__Group__0 ) )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:187:1: ( ( rule__StatechartReferences__Group__0 ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:188:1: ( rule__StatechartReferences__Group__0 )
            {
             before(grammarAccess.getStatechartReferencesAccess().getGroup()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:189:1: ( rule__StatechartReferences__Group__0 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:189:2: rule__StatechartReferences__Group__0
            {
            pushFollow(FOLLOW_rule__StatechartReferences__Group__0_in_ruleStatechartReferences334);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:201:1: entryRuleGeneratorConfiguration : ruleGeneratorConfiguration EOF ;
    public final void entryRuleGeneratorConfiguration() throws RecognitionException {
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:202:1: ( ruleGeneratorConfiguration EOF )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:203:1: ruleGeneratorConfiguration EOF
            {
             before(grammarAccess.getGeneratorConfigurationRule()); 
            pushFollow(FOLLOW_ruleGeneratorConfiguration_in_entryRuleGeneratorConfiguration361);
            ruleGeneratorConfiguration();

            state._fsp--;

             after(grammarAccess.getGeneratorConfigurationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneratorConfiguration368); 

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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:210:1: ruleGeneratorConfiguration : ( ( ( rule__GeneratorConfiguration__ConfigurationsAssignment ) ) ( ( rule__GeneratorConfiguration__ConfigurationsAssignment )* ) ) ;
    public final void ruleGeneratorConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:214:2: ( ( ( ( rule__GeneratorConfiguration__ConfigurationsAssignment ) ) ( ( rule__GeneratorConfiguration__ConfigurationsAssignment )* ) ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:215:1: ( ( ( rule__GeneratorConfiguration__ConfigurationsAssignment ) ) ( ( rule__GeneratorConfiguration__ConfigurationsAssignment )* ) )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:215:1: ( ( ( rule__GeneratorConfiguration__ConfigurationsAssignment ) ) ( ( rule__GeneratorConfiguration__ConfigurationsAssignment )* ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:216:1: ( ( rule__GeneratorConfiguration__ConfigurationsAssignment ) ) ( ( rule__GeneratorConfiguration__ConfigurationsAssignment )* )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:216:1: ( ( rule__GeneratorConfiguration__ConfigurationsAssignment ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:217:1: ( rule__GeneratorConfiguration__ConfigurationsAssignment )
            {
             before(grammarAccess.getGeneratorConfigurationAccess().getConfigurationsAssignment()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:218:1: ( rule__GeneratorConfiguration__ConfigurationsAssignment )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:218:2: rule__GeneratorConfiguration__ConfigurationsAssignment
            {
            pushFollow(FOLLOW_rule__GeneratorConfiguration__ConfigurationsAssignment_in_ruleGeneratorConfiguration396);
            rule__GeneratorConfiguration__ConfigurationsAssignment();

            state._fsp--;


            }

             after(grammarAccess.getGeneratorConfigurationAccess().getConfigurationsAssignment()); 

            }

            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:221:1: ( ( rule__GeneratorConfiguration__ConfigurationsAssignment )* )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:222:1: ( rule__GeneratorConfiguration__ConfigurationsAssignment )*
            {
             before(grammarAccess.getGeneratorConfigurationAccess().getConfigurationsAssignment()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:223:1: ( rule__GeneratorConfiguration__ConfigurationsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16||LA1_0==21||LA1_0==25) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:223:2: rule__GeneratorConfiguration__ConfigurationsAssignment
            	    {
            	    pushFollow(FOLLOW_rule__GeneratorConfiguration__ConfigurationsAssignment_in_ruleGeneratorConfiguration408);
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


    // $ANTLR start "entryRuleOutletConfiguration"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:236:1: entryRuleOutletConfiguration : ruleOutletConfiguration EOF ;
    public final void entryRuleOutletConfiguration() throws RecognitionException {
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:237:1: ( ruleOutletConfiguration EOF )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:238:1: ruleOutletConfiguration EOF
            {
             before(grammarAccess.getOutletConfigurationRule()); 
            pushFollow(FOLLOW_ruleOutletConfiguration_in_entryRuleOutletConfiguration438);
            ruleOutletConfiguration();

            state._fsp--;

             after(grammarAccess.getOutletConfigurationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOutletConfiguration445); 

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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:245:1: ruleOutletConfiguration : ( ( rule__OutletConfiguration__Group__0 ) ) ;
    public final void ruleOutletConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:249:2: ( ( ( rule__OutletConfiguration__Group__0 ) ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:250:1: ( ( rule__OutletConfiguration__Group__0 ) )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:250:1: ( ( rule__OutletConfiguration__Group__0 ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:251:1: ( rule__OutletConfiguration__Group__0 )
            {
             before(grammarAccess.getOutletConfigurationAccess().getGroup()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:252:1: ( rule__OutletConfiguration__Group__0 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:252:2: rule__OutletConfiguration__Group__0
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__0_in_ruleOutletConfiguration471);
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


    // $ANTLR start "ruleExecutionType"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:265:1: ruleExecutionType : ( ( rule__ExecutionType__Alternatives ) ) ;
    public final void ruleExecutionType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:269:1: ( ( ( rule__ExecutionType__Alternatives ) ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:270:1: ( ( rule__ExecutionType__Alternatives ) )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:270:1: ( ( rule__ExecutionType__Alternatives ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:271:1: ( rule__ExecutionType__Alternatives )
            {
             before(grammarAccess.getExecutionTypeAccess().getAlternatives()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:272:1: ( rule__ExecutionType__Alternatives )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:272:2: rule__ExecutionType__Alternatives
            {
            pushFollow(FOLLOW_rule__ExecutionType__Alternatives_in_ruleExecutionType508);
            rule__ExecutionType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExecutionTypeAccess().getAlternatives()); 

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
    // $ANTLR end "ruleExecutionType"


    // $ANTLR start "rule__Configurations__Alternatives"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:283:1: rule__Configurations__Alternatives : ( ( ruleOutletConfiguration ) | ( ruleNamingConfiguration ) | ( ruleExecutionTypeConfiguration ) );
    public final void rule__Configurations__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:287:1: ( ( ruleOutletConfiguration ) | ( ruleNamingConfiguration ) | ( ruleExecutionTypeConfiguration ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt2=1;
                }
                break;
            case 16:
                {
                alt2=2;
                }
                break;
            case 21:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:288:1: ( ruleOutletConfiguration )
                    {
                    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:288:1: ( ruleOutletConfiguration )
                    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:289:1: ruleOutletConfiguration
                    {
                     before(grammarAccess.getConfigurationsAccess().getOutletConfigurationParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleOutletConfiguration_in_rule__Configurations__Alternatives543);
                    ruleOutletConfiguration();

                    state._fsp--;

                     after(grammarAccess.getConfigurationsAccess().getOutletConfigurationParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:294:6: ( ruleNamingConfiguration )
                    {
                    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:294:6: ( ruleNamingConfiguration )
                    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:295:1: ruleNamingConfiguration
                    {
                     before(grammarAccess.getConfigurationsAccess().getNamingConfigurationParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleNamingConfiguration_in_rule__Configurations__Alternatives560);
                    ruleNamingConfiguration();

                    state._fsp--;

                     after(grammarAccess.getConfigurationsAccess().getNamingConfigurationParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:300:6: ( ruleExecutionTypeConfiguration )
                    {
                    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:300:6: ( ruleExecutionTypeConfiguration )
                    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:301:1: ruleExecutionTypeConfiguration
                    {
                     before(grammarAccess.getConfigurationsAccess().getExecutionTypeConfigurationParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleExecutionTypeConfiguration_in_rule__Configurations__Alternatives577);
                    ruleExecutionTypeConfiguration();

                    state._fsp--;

                     after(grammarAccess.getConfigurationsAccess().getExecutionTypeConfigurationParserRuleCall_2()); 

                    }


                    }
                    break;

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
    // $ANTLR end "rule__Configurations__Alternatives"


    // $ANTLR start "rule__ExecutionType__Alternatives"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:311:1: rule__ExecutionType__Alternatives : ( ( ( 'cycleBased' ) ) | ( ( 'eventDriven' ) ) );
    public final void rule__ExecutionType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:315:1: ( ( ( 'cycleBased' ) ) | ( ( 'eventDriven' ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:316:1: ( ( 'cycleBased' ) )
                    {
                    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:316:1: ( ( 'cycleBased' ) )
                    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:317:1: ( 'cycleBased' )
                    {
                     before(grammarAccess.getExecutionTypeAccess().getCYCLE_BASEDEnumLiteralDeclaration_0()); 
                    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:318:1: ( 'cycleBased' )
                    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:318:3: 'cycleBased'
                    {
                    match(input,11,FOLLOW_11_in_rule__ExecutionType__Alternatives610); 

                    }

                     after(grammarAccess.getExecutionTypeAccess().getCYCLE_BASEDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:323:6: ( ( 'eventDriven' ) )
                    {
                    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:323:6: ( ( 'eventDriven' ) )
                    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:324:1: ( 'eventDriven' )
                    {
                     before(grammarAccess.getExecutionTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_1()); 
                    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:325:1: ( 'eventDriven' )
                    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:325:3: 'eventDriven'
                    {
                    match(input,12,FOLLOW_12_in_rule__ExecutionType__Alternatives631); 

                    }

                     after(grammarAccess.getExecutionTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

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
    // $ANTLR end "rule__ExecutionType__Alternatives"


    // $ANTLR start "rule__BaseGeneratorModel__Group__0"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:337:1: rule__BaseGeneratorModel__Group__0 : rule__BaseGeneratorModel__Group__0__Impl rule__BaseGeneratorModel__Group__1 ;
    public final void rule__BaseGeneratorModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:341:1: ( rule__BaseGeneratorModel__Group__0__Impl rule__BaseGeneratorModel__Group__1 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:342:2: rule__BaseGeneratorModel__Group__0__Impl rule__BaseGeneratorModel__Group__1
            {
            pushFollow(FOLLOW_rule__BaseGeneratorModel__Group__0__Impl_in_rule__BaseGeneratorModel__Group__0664);
            rule__BaseGeneratorModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BaseGeneratorModel__Group__1_in_rule__BaseGeneratorModel__Group__0667);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:349:1: rule__BaseGeneratorModel__Group__0__Impl : ( 'JavaGenerator' ) ;
    public final void rule__BaseGeneratorModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:353:1: ( ( 'JavaGenerator' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:354:1: ( 'JavaGenerator' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:354:1: ( 'JavaGenerator' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:355:1: 'JavaGenerator'
            {
             before(grammarAccess.getBaseGeneratorModelAccess().getJavaGeneratorKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__BaseGeneratorModel__Group__0__Impl695); 
             after(grammarAccess.getBaseGeneratorModelAccess().getJavaGeneratorKeyword_0()); 

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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:368:1: rule__BaseGeneratorModel__Group__1 : rule__BaseGeneratorModel__Group__1__Impl rule__BaseGeneratorModel__Group__2 ;
    public final void rule__BaseGeneratorModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:372:1: ( rule__BaseGeneratorModel__Group__1__Impl rule__BaseGeneratorModel__Group__2 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:373:2: rule__BaseGeneratorModel__Group__1__Impl rule__BaseGeneratorModel__Group__2
            {
            pushFollow(FOLLOW_rule__BaseGeneratorModel__Group__1__Impl_in_rule__BaseGeneratorModel__Group__1726);
            rule__BaseGeneratorModel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BaseGeneratorModel__Group__2_in_rule__BaseGeneratorModel__Group__1729);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:380:1: rule__BaseGeneratorModel__Group__1__Impl : ( '{' ) ;
    public final void rule__BaseGeneratorModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:384:1: ( ( '{' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:385:1: ( '{' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:385:1: ( '{' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:386:1: '{'
            {
             before(grammarAccess.getBaseGeneratorModelAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,14,FOLLOW_14_in_rule__BaseGeneratorModel__Group__1__Impl757); 
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:399:1: rule__BaseGeneratorModel__Group__2 : rule__BaseGeneratorModel__Group__2__Impl rule__BaseGeneratorModel__Group__3 ;
    public final void rule__BaseGeneratorModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:403:1: ( rule__BaseGeneratorModel__Group__2__Impl rule__BaseGeneratorModel__Group__3 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:404:2: rule__BaseGeneratorModel__Group__2__Impl rule__BaseGeneratorModel__Group__3
            {
            pushFollow(FOLLOW_rule__BaseGeneratorModel__Group__2__Impl_in_rule__BaseGeneratorModel__Group__2788);
            rule__BaseGeneratorModel__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BaseGeneratorModel__Group__3_in_rule__BaseGeneratorModel__Group__2791);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:411:1: rule__BaseGeneratorModel__Group__2__Impl : ( ( rule__BaseGeneratorModel__StatechartReferencesAssignment_2 ) ) ;
    public final void rule__BaseGeneratorModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:415:1: ( ( ( rule__BaseGeneratorModel__StatechartReferencesAssignment_2 ) ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:416:1: ( ( rule__BaseGeneratorModel__StatechartReferencesAssignment_2 ) )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:416:1: ( ( rule__BaseGeneratorModel__StatechartReferencesAssignment_2 ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:417:1: ( rule__BaseGeneratorModel__StatechartReferencesAssignment_2 )
            {
             before(grammarAccess.getBaseGeneratorModelAccess().getStatechartReferencesAssignment_2()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:418:1: ( rule__BaseGeneratorModel__StatechartReferencesAssignment_2 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:418:2: rule__BaseGeneratorModel__StatechartReferencesAssignment_2
            {
            pushFollow(FOLLOW_rule__BaseGeneratorModel__StatechartReferencesAssignment_2_in_rule__BaseGeneratorModel__Group__2__Impl818);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:428:1: rule__BaseGeneratorModel__Group__3 : rule__BaseGeneratorModel__Group__3__Impl rule__BaseGeneratorModel__Group__4 ;
    public final void rule__BaseGeneratorModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:432:1: ( rule__BaseGeneratorModel__Group__3__Impl rule__BaseGeneratorModel__Group__4 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:433:2: rule__BaseGeneratorModel__Group__3__Impl rule__BaseGeneratorModel__Group__4
            {
            pushFollow(FOLLOW_rule__BaseGeneratorModel__Group__3__Impl_in_rule__BaseGeneratorModel__Group__3848);
            rule__BaseGeneratorModel__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BaseGeneratorModel__Group__4_in_rule__BaseGeneratorModel__Group__3851);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:440:1: rule__BaseGeneratorModel__Group__3__Impl : ( ( rule__BaseGeneratorModel__ConfigurationAssignment_3 ) ) ;
    public final void rule__BaseGeneratorModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:444:1: ( ( ( rule__BaseGeneratorModel__ConfigurationAssignment_3 ) ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:445:1: ( ( rule__BaseGeneratorModel__ConfigurationAssignment_3 ) )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:445:1: ( ( rule__BaseGeneratorModel__ConfigurationAssignment_3 ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:446:1: ( rule__BaseGeneratorModel__ConfigurationAssignment_3 )
            {
             before(grammarAccess.getBaseGeneratorModelAccess().getConfigurationAssignment_3()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:447:1: ( rule__BaseGeneratorModel__ConfigurationAssignment_3 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:447:2: rule__BaseGeneratorModel__ConfigurationAssignment_3
            {
            pushFollow(FOLLOW_rule__BaseGeneratorModel__ConfigurationAssignment_3_in_rule__BaseGeneratorModel__Group__3__Impl878);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:457:1: rule__BaseGeneratorModel__Group__4 : rule__BaseGeneratorModel__Group__4__Impl ;
    public final void rule__BaseGeneratorModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:461:1: ( rule__BaseGeneratorModel__Group__4__Impl )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:462:2: rule__BaseGeneratorModel__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__BaseGeneratorModel__Group__4__Impl_in_rule__BaseGeneratorModel__Group__4908);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:468:1: rule__BaseGeneratorModel__Group__4__Impl : ( '}' ) ;
    public final void rule__BaseGeneratorModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:472:1: ( ( '}' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:473:1: ( '}' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:473:1: ( '}' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:474:1: '}'
            {
             before(grammarAccess.getBaseGeneratorModelAccess().getRightCurlyBracketKeyword_4()); 
            match(input,15,FOLLOW_15_in_rule__BaseGeneratorModel__Group__4__Impl936); 
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


    // $ANTLR start "rule__NamingConfiguration__Group__0"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:497:1: rule__NamingConfiguration__Group__0 : rule__NamingConfiguration__Group__0__Impl rule__NamingConfiguration__Group__1 ;
    public final void rule__NamingConfiguration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:501:1: ( rule__NamingConfiguration__Group__0__Impl rule__NamingConfiguration__Group__1 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:502:2: rule__NamingConfiguration__Group__0__Impl rule__NamingConfiguration__Group__1
            {
            pushFollow(FOLLOW_rule__NamingConfiguration__Group__0__Impl_in_rule__NamingConfiguration__Group__0977);
            rule__NamingConfiguration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamingConfiguration__Group__1_in_rule__NamingConfiguration__Group__0980);
            rule__NamingConfiguration__Group__1();

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
    // $ANTLR end "rule__NamingConfiguration__Group__0"


    // $ANTLR start "rule__NamingConfiguration__Group__0__Impl"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:509:1: rule__NamingConfiguration__Group__0__Impl : ( () ) ;
    public final void rule__NamingConfiguration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:513:1: ( ( () ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:514:1: ( () )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:514:1: ( () )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:515:1: ()
            {
             before(grammarAccess.getNamingConfigurationAccess().getNamingConfigurationAction_0()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:516:1: ()
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:518:1: 
            {
            }

             after(grammarAccess.getNamingConfigurationAccess().getNamingConfigurationAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamingConfiguration__Group__0__Impl"


    // $ANTLR start "rule__NamingConfiguration__Group__1"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:528:1: rule__NamingConfiguration__Group__1 : rule__NamingConfiguration__Group__1__Impl rule__NamingConfiguration__Group__2 ;
    public final void rule__NamingConfiguration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:532:1: ( rule__NamingConfiguration__Group__1__Impl rule__NamingConfiguration__Group__2 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:533:2: rule__NamingConfiguration__Group__1__Impl rule__NamingConfiguration__Group__2
            {
            pushFollow(FOLLOW_rule__NamingConfiguration__Group__1__Impl_in_rule__NamingConfiguration__Group__11038);
            rule__NamingConfiguration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamingConfiguration__Group__2_in_rule__NamingConfiguration__Group__11041);
            rule__NamingConfiguration__Group__2();

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
    // $ANTLR end "rule__NamingConfiguration__Group__1"


    // $ANTLR start "rule__NamingConfiguration__Group__1__Impl"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:540:1: rule__NamingConfiguration__Group__1__Impl : ( 'naming' ) ;
    public final void rule__NamingConfiguration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:544:1: ( ( 'naming' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:545:1: ( 'naming' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:545:1: ( 'naming' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:546:1: 'naming'
            {
             before(grammarAccess.getNamingConfigurationAccess().getNamingKeyword_1()); 
            match(input,16,FOLLOW_16_in_rule__NamingConfiguration__Group__1__Impl1069); 
             after(grammarAccess.getNamingConfigurationAccess().getNamingKeyword_1()); 

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
    // $ANTLR end "rule__NamingConfiguration__Group__1__Impl"


    // $ANTLR start "rule__NamingConfiguration__Group__2"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:559:1: rule__NamingConfiguration__Group__2 : rule__NamingConfiguration__Group__2__Impl rule__NamingConfiguration__Group__3 ;
    public final void rule__NamingConfiguration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:563:1: ( rule__NamingConfiguration__Group__2__Impl rule__NamingConfiguration__Group__3 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:564:2: rule__NamingConfiguration__Group__2__Impl rule__NamingConfiguration__Group__3
            {
            pushFollow(FOLLOW_rule__NamingConfiguration__Group__2__Impl_in_rule__NamingConfiguration__Group__21100);
            rule__NamingConfiguration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamingConfiguration__Group__3_in_rule__NamingConfiguration__Group__21103);
            rule__NamingConfiguration__Group__3();

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
    // $ANTLR end "rule__NamingConfiguration__Group__2"


    // $ANTLR start "rule__NamingConfiguration__Group__2__Impl"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:571:1: rule__NamingConfiguration__Group__2__Impl : ( '{' ) ;
    public final void rule__NamingConfiguration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:575:1: ( ( '{' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:576:1: ( '{' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:576:1: ( '{' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:577:1: '{'
            {
             before(grammarAccess.getNamingConfigurationAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,14,FOLLOW_14_in_rule__NamingConfiguration__Group__2__Impl1131); 
             after(grammarAccess.getNamingConfigurationAccess().getLeftCurlyBracketKeyword_2()); 

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
    // $ANTLR end "rule__NamingConfiguration__Group__2__Impl"


    // $ANTLR start "rule__NamingConfiguration__Group__3"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:590:1: rule__NamingConfiguration__Group__3 : rule__NamingConfiguration__Group__3__Impl rule__NamingConfiguration__Group__4 ;
    public final void rule__NamingConfiguration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:594:1: ( rule__NamingConfiguration__Group__3__Impl rule__NamingConfiguration__Group__4 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:595:2: rule__NamingConfiguration__Group__3__Impl rule__NamingConfiguration__Group__4
            {
            pushFollow(FOLLOW_rule__NamingConfiguration__Group__3__Impl_in_rule__NamingConfiguration__Group__31162);
            rule__NamingConfiguration__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamingConfiguration__Group__4_in_rule__NamingConfiguration__Group__31165);
            rule__NamingConfiguration__Group__4();

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
    // $ANTLR end "rule__NamingConfiguration__Group__3"


    // $ANTLR start "rule__NamingConfiguration__Group__3__Impl"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:602:1: rule__NamingConfiguration__Group__3__Impl : ( 'interfacePackage' ) ;
    public final void rule__NamingConfiguration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:606:1: ( ( 'interfacePackage' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:607:1: ( 'interfacePackage' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:607:1: ( 'interfacePackage' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:608:1: 'interfacePackage'
            {
             before(grammarAccess.getNamingConfigurationAccess().getInterfacePackageKeyword_3()); 
            match(input,17,FOLLOW_17_in_rule__NamingConfiguration__Group__3__Impl1193); 
             after(grammarAccess.getNamingConfigurationAccess().getInterfacePackageKeyword_3()); 

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
    // $ANTLR end "rule__NamingConfiguration__Group__3__Impl"


    // $ANTLR start "rule__NamingConfiguration__Group__4"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:621:1: rule__NamingConfiguration__Group__4 : rule__NamingConfiguration__Group__4__Impl rule__NamingConfiguration__Group__5 ;
    public final void rule__NamingConfiguration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:625:1: ( rule__NamingConfiguration__Group__4__Impl rule__NamingConfiguration__Group__5 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:626:2: rule__NamingConfiguration__Group__4__Impl rule__NamingConfiguration__Group__5
            {
            pushFollow(FOLLOW_rule__NamingConfiguration__Group__4__Impl_in_rule__NamingConfiguration__Group__41224);
            rule__NamingConfiguration__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamingConfiguration__Group__5_in_rule__NamingConfiguration__Group__41227);
            rule__NamingConfiguration__Group__5();

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
    // $ANTLR end "rule__NamingConfiguration__Group__4"


    // $ANTLR start "rule__NamingConfiguration__Group__4__Impl"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:633:1: rule__NamingConfiguration__Group__4__Impl : ( '=' ) ;
    public final void rule__NamingConfiguration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:637:1: ( ( '=' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:638:1: ( '=' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:638:1: ( '=' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:639:1: '='
            {
             before(grammarAccess.getNamingConfigurationAccess().getEqualsSignKeyword_4()); 
            match(input,18,FOLLOW_18_in_rule__NamingConfiguration__Group__4__Impl1255); 
             after(grammarAccess.getNamingConfigurationAccess().getEqualsSignKeyword_4()); 

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
    // $ANTLR end "rule__NamingConfiguration__Group__4__Impl"


    // $ANTLR start "rule__NamingConfiguration__Group__5"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:652:1: rule__NamingConfiguration__Group__5 : rule__NamingConfiguration__Group__5__Impl rule__NamingConfiguration__Group__6 ;
    public final void rule__NamingConfiguration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:656:1: ( rule__NamingConfiguration__Group__5__Impl rule__NamingConfiguration__Group__6 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:657:2: rule__NamingConfiguration__Group__5__Impl rule__NamingConfiguration__Group__6
            {
            pushFollow(FOLLOW_rule__NamingConfiguration__Group__5__Impl_in_rule__NamingConfiguration__Group__51286);
            rule__NamingConfiguration__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamingConfiguration__Group__6_in_rule__NamingConfiguration__Group__51289);
            rule__NamingConfiguration__Group__6();

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
    // $ANTLR end "rule__NamingConfiguration__Group__5"


    // $ANTLR start "rule__NamingConfiguration__Group__5__Impl"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:664:1: rule__NamingConfiguration__Group__5__Impl : ( ( rule__NamingConfiguration__InterfacePackageNameAssignment_5 ) ) ;
    public final void rule__NamingConfiguration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:668:1: ( ( ( rule__NamingConfiguration__InterfacePackageNameAssignment_5 ) ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:669:1: ( ( rule__NamingConfiguration__InterfacePackageNameAssignment_5 ) )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:669:1: ( ( rule__NamingConfiguration__InterfacePackageNameAssignment_5 ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:670:1: ( rule__NamingConfiguration__InterfacePackageNameAssignment_5 )
            {
             before(grammarAccess.getNamingConfigurationAccess().getInterfacePackageNameAssignment_5()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:671:1: ( rule__NamingConfiguration__InterfacePackageNameAssignment_5 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:671:2: rule__NamingConfiguration__InterfacePackageNameAssignment_5
            {
            pushFollow(FOLLOW_rule__NamingConfiguration__InterfacePackageNameAssignment_5_in_rule__NamingConfiguration__Group__5__Impl1316);
            rule__NamingConfiguration__InterfacePackageNameAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getNamingConfigurationAccess().getInterfacePackageNameAssignment_5()); 

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
    // $ANTLR end "rule__NamingConfiguration__Group__5__Impl"


    // $ANTLR start "rule__NamingConfiguration__Group__6"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:681:1: rule__NamingConfiguration__Group__6 : rule__NamingConfiguration__Group__6__Impl rule__NamingConfiguration__Group__7 ;
    public final void rule__NamingConfiguration__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:685:1: ( rule__NamingConfiguration__Group__6__Impl rule__NamingConfiguration__Group__7 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:686:2: rule__NamingConfiguration__Group__6__Impl rule__NamingConfiguration__Group__7
            {
            pushFollow(FOLLOW_rule__NamingConfiguration__Group__6__Impl_in_rule__NamingConfiguration__Group__61346);
            rule__NamingConfiguration__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamingConfiguration__Group__7_in_rule__NamingConfiguration__Group__61349);
            rule__NamingConfiguration__Group__7();

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
    // $ANTLR end "rule__NamingConfiguration__Group__6"


    // $ANTLR start "rule__NamingConfiguration__Group__6__Impl"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:693:1: rule__NamingConfiguration__Group__6__Impl : ( 'implementationPackage' ) ;
    public final void rule__NamingConfiguration__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:697:1: ( ( 'implementationPackage' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:698:1: ( 'implementationPackage' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:698:1: ( 'implementationPackage' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:699:1: 'implementationPackage'
            {
             before(grammarAccess.getNamingConfigurationAccess().getImplementationPackageKeyword_6()); 
            match(input,19,FOLLOW_19_in_rule__NamingConfiguration__Group__6__Impl1377); 
             after(grammarAccess.getNamingConfigurationAccess().getImplementationPackageKeyword_6()); 

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
    // $ANTLR end "rule__NamingConfiguration__Group__6__Impl"


    // $ANTLR start "rule__NamingConfiguration__Group__7"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:712:1: rule__NamingConfiguration__Group__7 : rule__NamingConfiguration__Group__7__Impl rule__NamingConfiguration__Group__8 ;
    public final void rule__NamingConfiguration__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:716:1: ( rule__NamingConfiguration__Group__7__Impl rule__NamingConfiguration__Group__8 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:717:2: rule__NamingConfiguration__Group__7__Impl rule__NamingConfiguration__Group__8
            {
            pushFollow(FOLLOW_rule__NamingConfiguration__Group__7__Impl_in_rule__NamingConfiguration__Group__71408);
            rule__NamingConfiguration__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamingConfiguration__Group__8_in_rule__NamingConfiguration__Group__71411);
            rule__NamingConfiguration__Group__8();

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
    // $ANTLR end "rule__NamingConfiguration__Group__7"


    // $ANTLR start "rule__NamingConfiguration__Group__7__Impl"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:724:1: rule__NamingConfiguration__Group__7__Impl : ( '=' ) ;
    public final void rule__NamingConfiguration__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:728:1: ( ( '=' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:729:1: ( '=' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:729:1: ( '=' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:730:1: '='
            {
             before(grammarAccess.getNamingConfigurationAccess().getEqualsSignKeyword_7()); 
            match(input,18,FOLLOW_18_in_rule__NamingConfiguration__Group__7__Impl1439); 
             after(grammarAccess.getNamingConfigurationAccess().getEqualsSignKeyword_7()); 

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
    // $ANTLR end "rule__NamingConfiguration__Group__7__Impl"


    // $ANTLR start "rule__NamingConfiguration__Group__8"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:743:1: rule__NamingConfiguration__Group__8 : rule__NamingConfiguration__Group__8__Impl rule__NamingConfiguration__Group__9 ;
    public final void rule__NamingConfiguration__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:747:1: ( rule__NamingConfiguration__Group__8__Impl rule__NamingConfiguration__Group__9 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:748:2: rule__NamingConfiguration__Group__8__Impl rule__NamingConfiguration__Group__9
            {
            pushFollow(FOLLOW_rule__NamingConfiguration__Group__8__Impl_in_rule__NamingConfiguration__Group__81470);
            rule__NamingConfiguration__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamingConfiguration__Group__9_in_rule__NamingConfiguration__Group__81473);
            rule__NamingConfiguration__Group__9();

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
    // $ANTLR end "rule__NamingConfiguration__Group__8"


    // $ANTLR start "rule__NamingConfiguration__Group__8__Impl"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:755:1: rule__NamingConfiguration__Group__8__Impl : ( ( rule__NamingConfiguration__ImplementationPackageNameAssignment_8 ) ) ;
    public final void rule__NamingConfiguration__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:759:1: ( ( ( rule__NamingConfiguration__ImplementationPackageNameAssignment_8 ) ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:760:1: ( ( rule__NamingConfiguration__ImplementationPackageNameAssignment_8 ) )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:760:1: ( ( rule__NamingConfiguration__ImplementationPackageNameAssignment_8 ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:761:1: ( rule__NamingConfiguration__ImplementationPackageNameAssignment_8 )
            {
             before(grammarAccess.getNamingConfigurationAccess().getImplementationPackageNameAssignment_8()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:762:1: ( rule__NamingConfiguration__ImplementationPackageNameAssignment_8 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:762:2: rule__NamingConfiguration__ImplementationPackageNameAssignment_8
            {
            pushFollow(FOLLOW_rule__NamingConfiguration__ImplementationPackageNameAssignment_8_in_rule__NamingConfiguration__Group__8__Impl1500);
            rule__NamingConfiguration__ImplementationPackageNameAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getNamingConfigurationAccess().getImplementationPackageNameAssignment_8()); 

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
    // $ANTLR end "rule__NamingConfiguration__Group__8__Impl"


    // $ANTLR start "rule__NamingConfiguration__Group__9"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:772:1: rule__NamingConfiguration__Group__9 : rule__NamingConfiguration__Group__9__Impl rule__NamingConfiguration__Group__10 ;
    public final void rule__NamingConfiguration__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:776:1: ( rule__NamingConfiguration__Group__9__Impl rule__NamingConfiguration__Group__10 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:777:2: rule__NamingConfiguration__Group__9__Impl rule__NamingConfiguration__Group__10
            {
            pushFollow(FOLLOW_rule__NamingConfiguration__Group__9__Impl_in_rule__NamingConfiguration__Group__91530);
            rule__NamingConfiguration__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamingConfiguration__Group__10_in_rule__NamingConfiguration__Group__91533);
            rule__NamingConfiguration__Group__10();

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
    // $ANTLR end "rule__NamingConfiguration__Group__9"


    // $ANTLR start "rule__NamingConfiguration__Group__9__Impl"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:784:1: rule__NamingConfiguration__Group__9__Impl : ( 'copyrightHeader' ) ;
    public final void rule__NamingConfiguration__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:788:1: ( ( 'copyrightHeader' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:789:1: ( 'copyrightHeader' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:789:1: ( 'copyrightHeader' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:790:1: 'copyrightHeader'
            {
             before(grammarAccess.getNamingConfigurationAccess().getCopyrightHeaderKeyword_9()); 
            match(input,20,FOLLOW_20_in_rule__NamingConfiguration__Group__9__Impl1561); 
             after(grammarAccess.getNamingConfigurationAccess().getCopyrightHeaderKeyword_9()); 

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
    // $ANTLR end "rule__NamingConfiguration__Group__9__Impl"


    // $ANTLR start "rule__NamingConfiguration__Group__10"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:803:1: rule__NamingConfiguration__Group__10 : rule__NamingConfiguration__Group__10__Impl rule__NamingConfiguration__Group__11 ;
    public final void rule__NamingConfiguration__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:807:1: ( rule__NamingConfiguration__Group__10__Impl rule__NamingConfiguration__Group__11 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:808:2: rule__NamingConfiguration__Group__10__Impl rule__NamingConfiguration__Group__11
            {
            pushFollow(FOLLOW_rule__NamingConfiguration__Group__10__Impl_in_rule__NamingConfiguration__Group__101592);
            rule__NamingConfiguration__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamingConfiguration__Group__11_in_rule__NamingConfiguration__Group__101595);
            rule__NamingConfiguration__Group__11();

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
    // $ANTLR end "rule__NamingConfiguration__Group__10"


    // $ANTLR start "rule__NamingConfiguration__Group__10__Impl"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:815:1: rule__NamingConfiguration__Group__10__Impl : ( '=' ) ;
    public final void rule__NamingConfiguration__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:819:1: ( ( '=' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:820:1: ( '=' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:820:1: ( '=' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:821:1: '='
            {
             before(grammarAccess.getNamingConfigurationAccess().getEqualsSignKeyword_10()); 
            match(input,18,FOLLOW_18_in_rule__NamingConfiguration__Group__10__Impl1623); 
             after(grammarAccess.getNamingConfigurationAccess().getEqualsSignKeyword_10()); 

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
    // $ANTLR end "rule__NamingConfiguration__Group__10__Impl"


    // $ANTLR start "rule__NamingConfiguration__Group__11"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:834:1: rule__NamingConfiguration__Group__11 : rule__NamingConfiguration__Group__11__Impl rule__NamingConfiguration__Group__12 ;
    public final void rule__NamingConfiguration__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:838:1: ( rule__NamingConfiguration__Group__11__Impl rule__NamingConfiguration__Group__12 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:839:2: rule__NamingConfiguration__Group__11__Impl rule__NamingConfiguration__Group__12
            {
            pushFollow(FOLLOW_rule__NamingConfiguration__Group__11__Impl_in_rule__NamingConfiguration__Group__111654);
            rule__NamingConfiguration__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamingConfiguration__Group__12_in_rule__NamingConfiguration__Group__111657);
            rule__NamingConfiguration__Group__12();

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
    // $ANTLR end "rule__NamingConfiguration__Group__11"


    // $ANTLR start "rule__NamingConfiguration__Group__11__Impl"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:846:1: rule__NamingConfiguration__Group__11__Impl : ( ( rule__NamingConfiguration__CopyrightAssignment_11 ) ) ;
    public final void rule__NamingConfiguration__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:850:1: ( ( ( rule__NamingConfiguration__CopyrightAssignment_11 ) ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:851:1: ( ( rule__NamingConfiguration__CopyrightAssignment_11 ) )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:851:1: ( ( rule__NamingConfiguration__CopyrightAssignment_11 ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:852:1: ( rule__NamingConfiguration__CopyrightAssignment_11 )
            {
             before(grammarAccess.getNamingConfigurationAccess().getCopyrightAssignment_11()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:853:1: ( rule__NamingConfiguration__CopyrightAssignment_11 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:853:2: rule__NamingConfiguration__CopyrightAssignment_11
            {
            pushFollow(FOLLOW_rule__NamingConfiguration__CopyrightAssignment_11_in_rule__NamingConfiguration__Group__11__Impl1684);
            rule__NamingConfiguration__CopyrightAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getNamingConfigurationAccess().getCopyrightAssignment_11()); 

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
    // $ANTLR end "rule__NamingConfiguration__Group__11__Impl"


    // $ANTLR start "rule__NamingConfiguration__Group__12"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:863:1: rule__NamingConfiguration__Group__12 : rule__NamingConfiguration__Group__12__Impl ;
    public final void rule__NamingConfiguration__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:867:1: ( rule__NamingConfiguration__Group__12__Impl )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:868:2: rule__NamingConfiguration__Group__12__Impl
            {
            pushFollow(FOLLOW_rule__NamingConfiguration__Group__12__Impl_in_rule__NamingConfiguration__Group__121714);
            rule__NamingConfiguration__Group__12__Impl();

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
    // $ANTLR end "rule__NamingConfiguration__Group__12"


    // $ANTLR start "rule__NamingConfiguration__Group__12__Impl"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:874:1: rule__NamingConfiguration__Group__12__Impl : ( '}' ) ;
    public final void rule__NamingConfiguration__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:878:1: ( ( '}' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:879:1: ( '}' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:879:1: ( '}' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:880:1: '}'
            {
             before(grammarAccess.getNamingConfigurationAccess().getRightCurlyBracketKeyword_12()); 
            match(input,15,FOLLOW_15_in_rule__NamingConfiguration__Group__12__Impl1742); 
             after(grammarAccess.getNamingConfigurationAccess().getRightCurlyBracketKeyword_12()); 

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
    // $ANTLR end "rule__NamingConfiguration__Group__12__Impl"


    // $ANTLR start "rule__ExecutionTypeConfiguration__Group__0"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:919:1: rule__ExecutionTypeConfiguration__Group__0 : rule__ExecutionTypeConfiguration__Group__0__Impl rule__ExecutionTypeConfiguration__Group__1 ;
    public final void rule__ExecutionTypeConfiguration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:923:1: ( rule__ExecutionTypeConfiguration__Group__0__Impl rule__ExecutionTypeConfiguration__Group__1 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:924:2: rule__ExecutionTypeConfiguration__Group__0__Impl rule__ExecutionTypeConfiguration__Group__1
            {
            pushFollow(FOLLOW_rule__ExecutionTypeConfiguration__Group__0__Impl_in_rule__ExecutionTypeConfiguration__Group__01799);
            rule__ExecutionTypeConfiguration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExecutionTypeConfiguration__Group__1_in_rule__ExecutionTypeConfiguration__Group__01802);
            rule__ExecutionTypeConfiguration__Group__1();

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
    // $ANTLR end "rule__ExecutionTypeConfiguration__Group__0"


    // $ANTLR start "rule__ExecutionTypeConfiguration__Group__0__Impl"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:931:1: rule__ExecutionTypeConfiguration__Group__0__Impl : ( () ) ;
    public final void rule__ExecutionTypeConfiguration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:935:1: ( ( () ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:936:1: ( () )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:936:1: ( () )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:937:1: ()
            {
             before(grammarAccess.getExecutionTypeConfigurationAccess().getExecutionTypeConfigurationAction_0()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:938:1: ()
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:940:1: 
            {
            }

             after(grammarAccess.getExecutionTypeConfigurationAccess().getExecutionTypeConfigurationAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionTypeConfiguration__Group__0__Impl"


    // $ANTLR start "rule__ExecutionTypeConfiguration__Group__1"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:950:1: rule__ExecutionTypeConfiguration__Group__1 : rule__ExecutionTypeConfiguration__Group__1__Impl rule__ExecutionTypeConfiguration__Group__2 ;
    public final void rule__ExecutionTypeConfiguration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:954:1: ( rule__ExecutionTypeConfiguration__Group__1__Impl rule__ExecutionTypeConfiguration__Group__2 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:955:2: rule__ExecutionTypeConfiguration__Group__1__Impl rule__ExecutionTypeConfiguration__Group__2
            {
            pushFollow(FOLLOW_rule__ExecutionTypeConfiguration__Group__1__Impl_in_rule__ExecutionTypeConfiguration__Group__11860);
            rule__ExecutionTypeConfiguration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExecutionTypeConfiguration__Group__2_in_rule__ExecutionTypeConfiguration__Group__11863);
            rule__ExecutionTypeConfiguration__Group__2();

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
    // $ANTLR end "rule__ExecutionTypeConfiguration__Group__1"


    // $ANTLR start "rule__ExecutionTypeConfiguration__Group__1__Impl"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:962:1: rule__ExecutionTypeConfiguration__Group__1__Impl : ( 'executionType' ) ;
    public final void rule__ExecutionTypeConfiguration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:966:1: ( ( 'executionType' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:967:1: ( 'executionType' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:967:1: ( 'executionType' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:968:1: 'executionType'
            {
             before(grammarAccess.getExecutionTypeConfigurationAccess().getExecutionTypeKeyword_1()); 
            match(input,21,FOLLOW_21_in_rule__ExecutionTypeConfiguration__Group__1__Impl1891); 
             after(grammarAccess.getExecutionTypeConfigurationAccess().getExecutionTypeKeyword_1()); 

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
    // $ANTLR end "rule__ExecutionTypeConfiguration__Group__1__Impl"


    // $ANTLR start "rule__ExecutionTypeConfiguration__Group__2"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:981:1: rule__ExecutionTypeConfiguration__Group__2 : rule__ExecutionTypeConfiguration__Group__2__Impl rule__ExecutionTypeConfiguration__Group__3 ;
    public final void rule__ExecutionTypeConfiguration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:985:1: ( rule__ExecutionTypeConfiguration__Group__2__Impl rule__ExecutionTypeConfiguration__Group__3 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:986:2: rule__ExecutionTypeConfiguration__Group__2__Impl rule__ExecutionTypeConfiguration__Group__3
            {
            pushFollow(FOLLOW_rule__ExecutionTypeConfiguration__Group__2__Impl_in_rule__ExecutionTypeConfiguration__Group__21922);
            rule__ExecutionTypeConfiguration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExecutionTypeConfiguration__Group__3_in_rule__ExecutionTypeConfiguration__Group__21925);
            rule__ExecutionTypeConfiguration__Group__3();

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
    // $ANTLR end "rule__ExecutionTypeConfiguration__Group__2"


    // $ANTLR start "rule__ExecutionTypeConfiguration__Group__2__Impl"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:993:1: rule__ExecutionTypeConfiguration__Group__2__Impl : ( '{' ) ;
    public final void rule__ExecutionTypeConfiguration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:997:1: ( ( '{' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:998:1: ( '{' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:998:1: ( '{' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:999:1: '{'
            {
             before(grammarAccess.getExecutionTypeConfigurationAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,14,FOLLOW_14_in_rule__ExecutionTypeConfiguration__Group__2__Impl1953); 
             after(grammarAccess.getExecutionTypeConfigurationAccess().getLeftCurlyBracketKeyword_2()); 

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
    // $ANTLR end "rule__ExecutionTypeConfiguration__Group__2__Impl"


    // $ANTLR start "rule__ExecutionTypeConfiguration__Group__3"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1012:1: rule__ExecutionTypeConfiguration__Group__3 : rule__ExecutionTypeConfiguration__Group__3__Impl rule__ExecutionTypeConfiguration__Group__4 ;
    public final void rule__ExecutionTypeConfiguration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1016:1: ( rule__ExecutionTypeConfiguration__Group__3__Impl rule__ExecutionTypeConfiguration__Group__4 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1017:2: rule__ExecutionTypeConfiguration__Group__3__Impl rule__ExecutionTypeConfiguration__Group__4
            {
            pushFollow(FOLLOW_rule__ExecutionTypeConfiguration__Group__3__Impl_in_rule__ExecutionTypeConfiguration__Group__31984);
            rule__ExecutionTypeConfiguration__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExecutionTypeConfiguration__Group__4_in_rule__ExecutionTypeConfiguration__Group__31987);
            rule__ExecutionTypeConfiguration__Group__4();

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
    // $ANTLR end "rule__ExecutionTypeConfiguration__Group__3"


    // $ANTLR start "rule__ExecutionTypeConfiguration__Group__3__Impl"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1024:1: rule__ExecutionTypeConfiguration__Group__3__Impl : ( 'type' ) ;
    public final void rule__ExecutionTypeConfiguration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1028:1: ( ( 'type' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1029:1: ( 'type' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1029:1: ( 'type' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1030:1: 'type'
            {
             before(grammarAccess.getExecutionTypeConfigurationAccess().getTypeKeyword_3()); 
            match(input,22,FOLLOW_22_in_rule__ExecutionTypeConfiguration__Group__3__Impl2015); 
             after(grammarAccess.getExecutionTypeConfigurationAccess().getTypeKeyword_3()); 

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
    // $ANTLR end "rule__ExecutionTypeConfiguration__Group__3__Impl"


    // $ANTLR start "rule__ExecutionTypeConfiguration__Group__4"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1043:1: rule__ExecutionTypeConfiguration__Group__4 : rule__ExecutionTypeConfiguration__Group__4__Impl rule__ExecutionTypeConfiguration__Group__5 ;
    public final void rule__ExecutionTypeConfiguration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1047:1: ( rule__ExecutionTypeConfiguration__Group__4__Impl rule__ExecutionTypeConfiguration__Group__5 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1048:2: rule__ExecutionTypeConfiguration__Group__4__Impl rule__ExecutionTypeConfiguration__Group__5
            {
            pushFollow(FOLLOW_rule__ExecutionTypeConfiguration__Group__4__Impl_in_rule__ExecutionTypeConfiguration__Group__42046);
            rule__ExecutionTypeConfiguration__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExecutionTypeConfiguration__Group__5_in_rule__ExecutionTypeConfiguration__Group__42049);
            rule__ExecutionTypeConfiguration__Group__5();

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
    // $ANTLR end "rule__ExecutionTypeConfiguration__Group__4"


    // $ANTLR start "rule__ExecutionTypeConfiguration__Group__4__Impl"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1055:1: rule__ExecutionTypeConfiguration__Group__4__Impl : ( '=' ) ;
    public final void rule__ExecutionTypeConfiguration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1059:1: ( ( '=' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1060:1: ( '=' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1060:1: ( '=' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1061:1: '='
            {
             before(grammarAccess.getExecutionTypeConfigurationAccess().getEqualsSignKeyword_4()); 
            match(input,18,FOLLOW_18_in_rule__ExecutionTypeConfiguration__Group__4__Impl2077); 
             after(grammarAccess.getExecutionTypeConfigurationAccess().getEqualsSignKeyword_4()); 

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
    // $ANTLR end "rule__ExecutionTypeConfiguration__Group__4__Impl"


    // $ANTLR start "rule__ExecutionTypeConfiguration__Group__5"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1074:1: rule__ExecutionTypeConfiguration__Group__5 : rule__ExecutionTypeConfiguration__Group__5__Impl rule__ExecutionTypeConfiguration__Group__6 ;
    public final void rule__ExecutionTypeConfiguration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1078:1: ( rule__ExecutionTypeConfiguration__Group__5__Impl rule__ExecutionTypeConfiguration__Group__6 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1079:2: rule__ExecutionTypeConfiguration__Group__5__Impl rule__ExecutionTypeConfiguration__Group__6
            {
            pushFollow(FOLLOW_rule__ExecutionTypeConfiguration__Group__5__Impl_in_rule__ExecutionTypeConfiguration__Group__52108);
            rule__ExecutionTypeConfiguration__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExecutionTypeConfiguration__Group__6_in_rule__ExecutionTypeConfiguration__Group__52111);
            rule__ExecutionTypeConfiguration__Group__6();

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
    // $ANTLR end "rule__ExecutionTypeConfiguration__Group__5"


    // $ANTLR start "rule__ExecutionTypeConfiguration__Group__5__Impl"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1086:1: rule__ExecutionTypeConfiguration__Group__5__Impl : ( ( rule__ExecutionTypeConfiguration__TypeAssignment_5 ) ) ;
    public final void rule__ExecutionTypeConfiguration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1090:1: ( ( ( rule__ExecutionTypeConfiguration__TypeAssignment_5 ) ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1091:1: ( ( rule__ExecutionTypeConfiguration__TypeAssignment_5 ) )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1091:1: ( ( rule__ExecutionTypeConfiguration__TypeAssignment_5 ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1092:1: ( rule__ExecutionTypeConfiguration__TypeAssignment_5 )
            {
             before(grammarAccess.getExecutionTypeConfigurationAccess().getTypeAssignment_5()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1093:1: ( rule__ExecutionTypeConfiguration__TypeAssignment_5 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1093:2: rule__ExecutionTypeConfiguration__TypeAssignment_5
            {
            pushFollow(FOLLOW_rule__ExecutionTypeConfiguration__TypeAssignment_5_in_rule__ExecutionTypeConfiguration__Group__5__Impl2138);
            rule__ExecutionTypeConfiguration__TypeAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getExecutionTypeConfigurationAccess().getTypeAssignment_5()); 

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
    // $ANTLR end "rule__ExecutionTypeConfiguration__Group__5__Impl"


    // $ANTLR start "rule__ExecutionTypeConfiguration__Group__6"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1103:1: rule__ExecutionTypeConfiguration__Group__6 : rule__ExecutionTypeConfiguration__Group__6__Impl ;
    public final void rule__ExecutionTypeConfiguration__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1107:1: ( rule__ExecutionTypeConfiguration__Group__6__Impl )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1108:2: rule__ExecutionTypeConfiguration__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ExecutionTypeConfiguration__Group__6__Impl_in_rule__ExecutionTypeConfiguration__Group__62168);
            rule__ExecutionTypeConfiguration__Group__6__Impl();

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
    // $ANTLR end "rule__ExecutionTypeConfiguration__Group__6"


    // $ANTLR start "rule__ExecutionTypeConfiguration__Group__6__Impl"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1114:1: rule__ExecutionTypeConfiguration__Group__6__Impl : ( '}' ) ;
    public final void rule__ExecutionTypeConfiguration__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1118:1: ( ( '}' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1119:1: ( '}' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1119:1: ( '}' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1120:1: '}'
            {
             before(grammarAccess.getExecutionTypeConfigurationAccess().getRightCurlyBracketKeyword_6()); 
            match(input,15,FOLLOW_15_in_rule__ExecutionTypeConfiguration__Group__6__Impl2196); 
             after(grammarAccess.getExecutionTypeConfigurationAccess().getRightCurlyBracketKeyword_6()); 

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
    // $ANTLR end "rule__ExecutionTypeConfiguration__Group__6__Impl"


    // $ANTLR start "rule__StatechartReferences__Group__0"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1147:1: rule__StatechartReferences__Group__0 : rule__StatechartReferences__Group__0__Impl rule__StatechartReferences__Group__1 ;
    public final void rule__StatechartReferences__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1151:1: ( rule__StatechartReferences__Group__0__Impl rule__StatechartReferences__Group__1 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1152:2: rule__StatechartReferences__Group__0__Impl rule__StatechartReferences__Group__1
            {
            pushFollow(FOLLOW_rule__StatechartReferences__Group__0__Impl_in_rule__StatechartReferences__Group__02241);
            rule__StatechartReferences__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__StatechartReferences__Group__1_in_rule__StatechartReferences__Group__02244);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1159:1: rule__StatechartReferences__Group__0__Impl : ( 'statecharts ' ) ;
    public final void rule__StatechartReferences__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1163:1: ( ( 'statecharts ' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1164:1: ( 'statecharts ' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1164:1: ( 'statecharts ' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1165:1: 'statecharts '
            {
             before(grammarAccess.getStatechartReferencesAccess().getStatechartsKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__StatechartReferences__Group__0__Impl2272); 
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1178:1: rule__StatechartReferences__Group__1 : rule__StatechartReferences__Group__1__Impl rule__StatechartReferences__Group__2 ;
    public final void rule__StatechartReferences__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1182:1: ( rule__StatechartReferences__Group__1__Impl rule__StatechartReferences__Group__2 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1183:2: rule__StatechartReferences__Group__1__Impl rule__StatechartReferences__Group__2
            {
            pushFollow(FOLLOW_rule__StatechartReferences__Group__1__Impl_in_rule__StatechartReferences__Group__12303);
            rule__StatechartReferences__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__StatechartReferences__Group__2_in_rule__StatechartReferences__Group__12306);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1190:1: rule__StatechartReferences__Group__1__Impl : ( '{' ) ;
    public final void rule__StatechartReferences__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1194:1: ( ( '{' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1195:1: ( '{' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1195:1: ( '{' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1196:1: '{'
            {
             before(grammarAccess.getStatechartReferencesAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,14,FOLLOW_14_in_rule__StatechartReferences__Group__1__Impl2334); 
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1209:1: rule__StatechartReferences__Group__2 : rule__StatechartReferences__Group__2__Impl rule__StatechartReferences__Group__3 ;
    public final void rule__StatechartReferences__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1213:1: ( rule__StatechartReferences__Group__2__Impl rule__StatechartReferences__Group__3 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1214:2: rule__StatechartReferences__Group__2__Impl rule__StatechartReferences__Group__3
            {
            pushFollow(FOLLOW_rule__StatechartReferences__Group__2__Impl_in_rule__StatechartReferences__Group__22365);
            rule__StatechartReferences__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__StatechartReferences__Group__3_in_rule__StatechartReferences__Group__22368);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1221:1: rule__StatechartReferences__Group__2__Impl : ( ( ( rule__StatechartReferences__StatechartsAssignment_2 ) ) ( ( rule__StatechartReferences__StatechartsAssignment_2 )* ) ) ;
    public final void rule__StatechartReferences__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1225:1: ( ( ( ( rule__StatechartReferences__StatechartsAssignment_2 ) ) ( ( rule__StatechartReferences__StatechartsAssignment_2 )* ) ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1226:1: ( ( ( rule__StatechartReferences__StatechartsAssignment_2 ) ) ( ( rule__StatechartReferences__StatechartsAssignment_2 )* ) )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1226:1: ( ( ( rule__StatechartReferences__StatechartsAssignment_2 ) ) ( ( rule__StatechartReferences__StatechartsAssignment_2 )* ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1227:1: ( ( rule__StatechartReferences__StatechartsAssignment_2 ) ) ( ( rule__StatechartReferences__StatechartsAssignment_2 )* )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1227:1: ( ( rule__StatechartReferences__StatechartsAssignment_2 ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1228:1: ( rule__StatechartReferences__StatechartsAssignment_2 )
            {
             before(grammarAccess.getStatechartReferencesAccess().getStatechartsAssignment_2()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1229:1: ( rule__StatechartReferences__StatechartsAssignment_2 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1229:2: rule__StatechartReferences__StatechartsAssignment_2
            {
            pushFollow(FOLLOW_rule__StatechartReferences__StatechartsAssignment_2_in_rule__StatechartReferences__Group__2__Impl2397);
            rule__StatechartReferences__StatechartsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getStatechartReferencesAccess().getStatechartsAssignment_2()); 

            }

            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1232:1: ( ( rule__StatechartReferences__StatechartsAssignment_2 )* )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1233:1: ( rule__StatechartReferences__StatechartsAssignment_2 )*
            {
             before(grammarAccess.getStatechartReferencesAccess().getStatechartsAssignment_2()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1234:1: ( rule__StatechartReferences__StatechartsAssignment_2 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1234:2: rule__StatechartReferences__StatechartsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__StatechartReferences__StatechartsAssignment_2_in_rule__StatechartReferences__Group__2__Impl2409);
            	    rule__StatechartReferences__StatechartsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1245:1: rule__StatechartReferences__Group__3 : rule__StatechartReferences__Group__3__Impl rule__StatechartReferences__Group__4 ;
    public final void rule__StatechartReferences__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1249:1: ( rule__StatechartReferences__Group__3__Impl rule__StatechartReferences__Group__4 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1250:2: rule__StatechartReferences__Group__3__Impl rule__StatechartReferences__Group__4
            {
            pushFollow(FOLLOW_rule__StatechartReferences__Group__3__Impl_in_rule__StatechartReferences__Group__32442);
            rule__StatechartReferences__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__StatechartReferences__Group__4_in_rule__StatechartReferences__Group__32445);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1257:1: rule__StatechartReferences__Group__3__Impl : ( ( rule__StatechartReferences__Group_3__0 )* ) ;
    public final void rule__StatechartReferences__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1261:1: ( ( ( rule__StatechartReferences__Group_3__0 )* ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1262:1: ( ( rule__StatechartReferences__Group_3__0 )* )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1262:1: ( ( rule__StatechartReferences__Group_3__0 )* )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1263:1: ( rule__StatechartReferences__Group_3__0 )*
            {
             before(grammarAccess.getStatechartReferencesAccess().getGroup_3()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1264:1: ( rule__StatechartReferences__Group_3__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==24) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1264:2: rule__StatechartReferences__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__StatechartReferences__Group_3__0_in_rule__StatechartReferences__Group__3__Impl2472);
            	    rule__StatechartReferences__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1274:1: rule__StatechartReferences__Group__4 : rule__StatechartReferences__Group__4__Impl ;
    public final void rule__StatechartReferences__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1278:1: ( rule__StatechartReferences__Group__4__Impl )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1279:2: rule__StatechartReferences__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__StatechartReferences__Group__4__Impl_in_rule__StatechartReferences__Group__42503);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1285:1: rule__StatechartReferences__Group__4__Impl : ( '}' ) ;
    public final void rule__StatechartReferences__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1289:1: ( ( '}' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1290:1: ( '}' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1290:1: ( '}' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1291:1: '}'
            {
             before(grammarAccess.getStatechartReferencesAccess().getRightCurlyBracketKeyword_4()); 
            match(input,15,FOLLOW_15_in_rule__StatechartReferences__Group__4__Impl2531); 
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1314:1: rule__StatechartReferences__Group_3__0 : rule__StatechartReferences__Group_3__0__Impl rule__StatechartReferences__Group_3__1 ;
    public final void rule__StatechartReferences__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1318:1: ( rule__StatechartReferences__Group_3__0__Impl rule__StatechartReferences__Group_3__1 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1319:2: rule__StatechartReferences__Group_3__0__Impl rule__StatechartReferences__Group_3__1
            {
            pushFollow(FOLLOW_rule__StatechartReferences__Group_3__0__Impl_in_rule__StatechartReferences__Group_3__02572);
            rule__StatechartReferences__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__StatechartReferences__Group_3__1_in_rule__StatechartReferences__Group_3__02575);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1326:1: rule__StatechartReferences__Group_3__0__Impl : ( ',' ) ;
    public final void rule__StatechartReferences__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1330:1: ( ( ',' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1331:1: ( ',' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1331:1: ( ',' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1332:1: ','
            {
             before(grammarAccess.getStatechartReferencesAccess().getCommaKeyword_3_0()); 
            match(input,24,FOLLOW_24_in_rule__StatechartReferences__Group_3__0__Impl2603); 
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1345:1: rule__StatechartReferences__Group_3__1 : rule__StatechartReferences__Group_3__1__Impl ;
    public final void rule__StatechartReferences__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1349:1: ( rule__StatechartReferences__Group_3__1__Impl )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1350:2: rule__StatechartReferences__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__StatechartReferences__Group_3__1__Impl_in_rule__StatechartReferences__Group_3__12634);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1356:1: rule__StatechartReferences__Group_3__1__Impl : ( ( rule__StatechartReferences__StatechartsAssignment_3_1 ) ) ;
    public final void rule__StatechartReferences__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1360:1: ( ( ( rule__StatechartReferences__StatechartsAssignment_3_1 ) ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1361:1: ( ( rule__StatechartReferences__StatechartsAssignment_3_1 ) )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1361:1: ( ( rule__StatechartReferences__StatechartsAssignment_3_1 ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1362:1: ( rule__StatechartReferences__StatechartsAssignment_3_1 )
            {
             before(grammarAccess.getStatechartReferencesAccess().getStatechartsAssignment_3_1()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1363:1: ( rule__StatechartReferences__StatechartsAssignment_3_1 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1363:2: rule__StatechartReferences__StatechartsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__StatechartReferences__StatechartsAssignment_3_1_in_rule__StatechartReferences__Group_3__1__Impl2661);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1377:1: rule__OutletConfiguration__Group__0 : rule__OutletConfiguration__Group__0__Impl rule__OutletConfiguration__Group__1 ;
    public final void rule__OutletConfiguration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1381:1: ( rule__OutletConfiguration__Group__0__Impl rule__OutletConfiguration__Group__1 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1382:2: rule__OutletConfiguration__Group__0__Impl rule__OutletConfiguration__Group__1
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__0__Impl_in_rule__OutletConfiguration__Group__02695);
            rule__OutletConfiguration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OutletConfiguration__Group__1_in_rule__OutletConfiguration__Group__02698);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1389:1: rule__OutletConfiguration__Group__0__Impl : ( () ) ;
    public final void rule__OutletConfiguration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1393:1: ( ( () ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1394:1: ( () )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1394:1: ( () )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1395:1: ()
            {
             before(grammarAccess.getOutletConfigurationAccess().getOutletConfigurationCustomAction_0()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1396:1: ()
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1398:1: 
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1408:1: rule__OutletConfiguration__Group__1 : rule__OutletConfiguration__Group__1__Impl rule__OutletConfiguration__Group__2 ;
    public final void rule__OutletConfiguration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1412:1: ( rule__OutletConfiguration__Group__1__Impl rule__OutletConfiguration__Group__2 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1413:2: rule__OutletConfiguration__Group__1__Impl rule__OutletConfiguration__Group__2
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__1__Impl_in_rule__OutletConfiguration__Group__12756);
            rule__OutletConfiguration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OutletConfiguration__Group__2_in_rule__OutletConfiguration__Group__12759);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1420:1: rule__OutletConfiguration__Group__1__Impl : ( 'outlet' ) ;
    public final void rule__OutletConfiguration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1424:1: ( ( 'outlet' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1425:1: ( 'outlet' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1425:1: ( 'outlet' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1426:1: 'outlet'
            {
             before(grammarAccess.getOutletConfigurationAccess().getOutletKeyword_1()); 
            match(input,25,FOLLOW_25_in_rule__OutletConfiguration__Group__1__Impl2787); 
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1439:1: rule__OutletConfiguration__Group__2 : rule__OutletConfiguration__Group__2__Impl rule__OutletConfiguration__Group__3 ;
    public final void rule__OutletConfiguration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1443:1: ( rule__OutletConfiguration__Group__2__Impl rule__OutletConfiguration__Group__3 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1444:2: rule__OutletConfiguration__Group__2__Impl rule__OutletConfiguration__Group__3
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__2__Impl_in_rule__OutletConfiguration__Group__22818);
            rule__OutletConfiguration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OutletConfiguration__Group__3_in_rule__OutletConfiguration__Group__22821);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1451:1: rule__OutletConfiguration__Group__2__Impl : ( '{' ) ;
    public final void rule__OutletConfiguration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1455:1: ( ( '{' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1456:1: ( '{' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1456:1: ( '{' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1457:1: '{'
            {
             before(grammarAccess.getOutletConfigurationAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,14,FOLLOW_14_in_rule__OutletConfiguration__Group__2__Impl2849); 
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1470:1: rule__OutletConfiguration__Group__3 : rule__OutletConfiguration__Group__3__Impl rule__OutletConfiguration__Group__4 ;
    public final void rule__OutletConfiguration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1474:1: ( rule__OutletConfiguration__Group__3__Impl rule__OutletConfiguration__Group__4 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1475:2: rule__OutletConfiguration__Group__3__Impl rule__OutletConfiguration__Group__4
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__3__Impl_in_rule__OutletConfiguration__Group__32880);
            rule__OutletConfiguration__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OutletConfiguration__Group__4_in_rule__OutletConfiguration__Group__32883);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1482:1: rule__OutletConfiguration__Group__3__Impl : ( 'projectName' ) ;
    public final void rule__OutletConfiguration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1486:1: ( ( 'projectName' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1487:1: ( 'projectName' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1487:1: ( 'projectName' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1488:1: 'projectName'
            {
             before(grammarAccess.getOutletConfigurationAccess().getProjectNameKeyword_3()); 
            match(input,26,FOLLOW_26_in_rule__OutletConfiguration__Group__3__Impl2911); 
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1501:1: rule__OutletConfiguration__Group__4 : rule__OutletConfiguration__Group__4__Impl rule__OutletConfiguration__Group__5 ;
    public final void rule__OutletConfiguration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1505:1: ( rule__OutletConfiguration__Group__4__Impl rule__OutletConfiguration__Group__5 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1506:2: rule__OutletConfiguration__Group__4__Impl rule__OutletConfiguration__Group__5
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__4__Impl_in_rule__OutletConfiguration__Group__42942);
            rule__OutletConfiguration__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OutletConfiguration__Group__5_in_rule__OutletConfiguration__Group__42945);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1513:1: rule__OutletConfiguration__Group__4__Impl : ( '=' ) ;
    public final void rule__OutletConfiguration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1517:1: ( ( '=' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1518:1: ( '=' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1518:1: ( '=' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1519:1: '='
            {
             before(grammarAccess.getOutletConfigurationAccess().getEqualsSignKeyword_4()); 
            match(input,18,FOLLOW_18_in_rule__OutletConfiguration__Group__4__Impl2973); 
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1532:1: rule__OutletConfiguration__Group__5 : rule__OutletConfiguration__Group__5__Impl rule__OutletConfiguration__Group__6 ;
    public final void rule__OutletConfiguration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1536:1: ( rule__OutletConfiguration__Group__5__Impl rule__OutletConfiguration__Group__6 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1537:2: rule__OutletConfiguration__Group__5__Impl rule__OutletConfiguration__Group__6
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__5__Impl_in_rule__OutletConfiguration__Group__53004);
            rule__OutletConfiguration__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OutletConfiguration__Group__6_in_rule__OutletConfiguration__Group__53007);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1544:1: rule__OutletConfiguration__Group__5__Impl : ( ( rule__OutletConfiguration__ProjectNameAssignment_5 ) ) ;
    public final void rule__OutletConfiguration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1548:1: ( ( ( rule__OutletConfiguration__ProjectNameAssignment_5 ) ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1549:1: ( ( rule__OutletConfiguration__ProjectNameAssignment_5 ) )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1549:1: ( ( rule__OutletConfiguration__ProjectNameAssignment_5 ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1550:1: ( rule__OutletConfiguration__ProjectNameAssignment_5 )
            {
             before(grammarAccess.getOutletConfigurationAccess().getProjectNameAssignment_5()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1551:1: ( rule__OutletConfiguration__ProjectNameAssignment_5 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1551:2: rule__OutletConfiguration__ProjectNameAssignment_5
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__ProjectNameAssignment_5_in_rule__OutletConfiguration__Group__5__Impl3034);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1561:1: rule__OutletConfiguration__Group__6 : rule__OutletConfiguration__Group__6__Impl rule__OutletConfiguration__Group__7 ;
    public final void rule__OutletConfiguration__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1565:1: ( rule__OutletConfiguration__Group__6__Impl rule__OutletConfiguration__Group__7 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1566:2: rule__OutletConfiguration__Group__6__Impl rule__OutletConfiguration__Group__7
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__6__Impl_in_rule__OutletConfiguration__Group__63064);
            rule__OutletConfiguration__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OutletConfiguration__Group__7_in_rule__OutletConfiguration__Group__63067);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1573:1: rule__OutletConfiguration__Group__6__Impl : ( 'folder' ) ;
    public final void rule__OutletConfiguration__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1577:1: ( ( 'folder' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1578:1: ( 'folder' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1578:1: ( 'folder' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1579:1: 'folder'
            {
             before(grammarAccess.getOutletConfigurationAccess().getFolderKeyword_6()); 
            match(input,27,FOLLOW_27_in_rule__OutletConfiguration__Group__6__Impl3095); 
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1592:1: rule__OutletConfiguration__Group__7 : rule__OutletConfiguration__Group__7__Impl rule__OutletConfiguration__Group__8 ;
    public final void rule__OutletConfiguration__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1596:1: ( rule__OutletConfiguration__Group__7__Impl rule__OutletConfiguration__Group__8 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1597:2: rule__OutletConfiguration__Group__7__Impl rule__OutletConfiguration__Group__8
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__7__Impl_in_rule__OutletConfiguration__Group__73126);
            rule__OutletConfiguration__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OutletConfiguration__Group__8_in_rule__OutletConfiguration__Group__73129);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1604:1: rule__OutletConfiguration__Group__7__Impl : ( '=' ) ;
    public final void rule__OutletConfiguration__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1608:1: ( ( '=' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1609:1: ( '=' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1609:1: ( '=' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1610:1: '='
            {
             before(grammarAccess.getOutletConfigurationAccess().getEqualsSignKeyword_7()); 
            match(input,18,FOLLOW_18_in_rule__OutletConfiguration__Group__7__Impl3157); 
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1623:1: rule__OutletConfiguration__Group__8 : rule__OutletConfiguration__Group__8__Impl rule__OutletConfiguration__Group__9 ;
    public final void rule__OutletConfiguration__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1627:1: ( rule__OutletConfiguration__Group__8__Impl rule__OutletConfiguration__Group__9 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1628:2: rule__OutletConfiguration__Group__8__Impl rule__OutletConfiguration__Group__9
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__8__Impl_in_rule__OutletConfiguration__Group__83188);
            rule__OutletConfiguration__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OutletConfiguration__Group__9_in_rule__OutletConfiguration__Group__83191);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1635:1: rule__OutletConfiguration__Group__8__Impl : ( ( rule__OutletConfiguration__TargetFolderAssignment_8 ) ) ;
    public final void rule__OutletConfiguration__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1639:1: ( ( ( rule__OutletConfiguration__TargetFolderAssignment_8 ) ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1640:1: ( ( rule__OutletConfiguration__TargetFolderAssignment_8 ) )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1640:1: ( ( rule__OutletConfiguration__TargetFolderAssignment_8 ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1641:1: ( rule__OutletConfiguration__TargetFolderAssignment_8 )
            {
             before(grammarAccess.getOutletConfigurationAccess().getTargetFolderAssignment_8()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1642:1: ( rule__OutletConfiguration__TargetFolderAssignment_8 )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1642:2: rule__OutletConfiguration__TargetFolderAssignment_8
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__TargetFolderAssignment_8_in_rule__OutletConfiguration__Group__8__Impl3218);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1652:1: rule__OutletConfiguration__Group__9 : rule__OutletConfiguration__Group__9__Impl ;
    public final void rule__OutletConfiguration__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1656:1: ( rule__OutletConfiguration__Group__9__Impl )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1657:2: rule__OutletConfiguration__Group__9__Impl
            {
            pushFollow(FOLLOW_rule__OutletConfiguration__Group__9__Impl_in_rule__OutletConfiguration__Group__93248);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1663:1: rule__OutletConfiguration__Group__9__Impl : ( '}' ) ;
    public final void rule__OutletConfiguration__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1667:1: ( ( '}' ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1668:1: ( '}' )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1668:1: ( '}' )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1669:1: '}'
            {
             before(grammarAccess.getOutletConfigurationAccess().getRightCurlyBracketKeyword_9()); 
            match(input,15,FOLLOW_15_in_rule__OutletConfiguration__Group__9__Impl3276); 
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1703:1: rule__BaseGeneratorModel__StatechartReferencesAssignment_2 : ( ruleStatechartReferences ) ;
    public final void rule__BaseGeneratorModel__StatechartReferencesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1707:1: ( ( ruleStatechartReferences ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1708:1: ( ruleStatechartReferences )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1708:1: ( ruleStatechartReferences )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1709:1: ruleStatechartReferences
            {
             before(grammarAccess.getBaseGeneratorModelAccess().getStatechartReferencesStatechartReferencesParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleStatechartReferences_in_rule__BaseGeneratorModel__StatechartReferencesAssignment_23332);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1718:1: rule__BaseGeneratorModel__ConfigurationAssignment_3 : ( ruleGeneratorConfiguration ) ;
    public final void rule__BaseGeneratorModel__ConfigurationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1722:1: ( ( ruleGeneratorConfiguration ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1723:1: ( ruleGeneratorConfiguration )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1723:1: ( ruleGeneratorConfiguration )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1724:1: ruleGeneratorConfiguration
            {
             before(grammarAccess.getBaseGeneratorModelAccess().getConfigurationGeneratorConfigurationParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleGeneratorConfiguration_in_rule__BaseGeneratorModel__ConfigurationAssignment_33363);
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


    // $ANTLR start "rule__NamingConfiguration__InterfacePackageNameAssignment_5"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1733:1: rule__NamingConfiguration__InterfacePackageNameAssignment_5 : ( RULE_STRING ) ;
    public final void rule__NamingConfiguration__InterfacePackageNameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1737:1: ( ( RULE_STRING ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1738:1: ( RULE_STRING )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1738:1: ( RULE_STRING )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1739:1: RULE_STRING
            {
             before(grammarAccess.getNamingConfigurationAccess().getInterfacePackageNameSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__NamingConfiguration__InterfacePackageNameAssignment_53394); 
             after(grammarAccess.getNamingConfigurationAccess().getInterfacePackageNameSTRINGTerminalRuleCall_5_0()); 

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
    // $ANTLR end "rule__NamingConfiguration__InterfacePackageNameAssignment_5"


    // $ANTLR start "rule__NamingConfiguration__ImplementationPackageNameAssignment_8"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1748:1: rule__NamingConfiguration__ImplementationPackageNameAssignment_8 : ( RULE_STRING ) ;
    public final void rule__NamingConfiguration__ImplementationPackageNameAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1752:1: ( ( RULE_STRING ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1753:1: ( RULE_STRING )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1753:1: ( RULE_STRING )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1754:1: RULE_STRING
            {
             before(grammarAccess.getNamingConfigurationAccess().getImplementationPackageNameSTRINGTerminalRuleCall_8_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__NamingConfiguration__ImplementationPackageNameAssignment_83425); 
             after(grammarAccess.getNamingConfigurationAccess().getImplementationPackageNameSTRINGTerminalRuleCall_8_0()); 

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
    // $ANTLR end "rule__NamingConfiguration__ImplementationPackageNameAssignment_8"


    // $ANTLR start "rule__NamingConfiguration__CopyrightAssignment_11"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1763:1: rule__NamingConfiguration__CopyrightAssignment_11 : ( RULE_STRING ) ;
    public final void rule__NamingConfiguration__CopyrightAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1767:1: ( ( RULE_STRING ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1768:1: ( RULE_STRING )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1768:1: ( RULE_STRING )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1769:1: RULE_STRING
            {
             before(grammarAccess.getNamingConfigurationAccess().getCopyrightSTRINGTerminalRuleCall_11_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__NamingConfiguration__CopyrightAssignment_113456); 
             after(grammarAccess.getNamingConfigurationAccess().getCopyrightSTRINGTerminalRuleCall_11_0()); 

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
    // $ANTLR end "rule__NamingConfiguration__CopyrightAssignment_11"


    // $ANTLR start "rule__ExecutionTypeConfiguration__TypeAssignment_5"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1778:1: rule__ExecutionTypeConfiguration__TypeAssignment_5 : ( ruleExecutionType ) ;
    public final void rule__ExecutionTypeConfiguration__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1782:1: ( ( ruleExecutionType ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1783:1: ( ruleExecutionType )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1783:1: ( ruleExecutionType )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1784:1: ruleExecutionType
            {
             before(grammarAccess.getExecutionTypeConfigurationAccess().getTypeExecutionTypeEnumRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleExecutionType_in_rule__ExecutionTypeConfiguration__TypeAssignment_53487);
            ruleExecutionType();

            state._fsp--;

             after(grammarAccess.getExecutionTypeConfigurationAccess().getTypeExecutionTypeEnumRuleCall_5_0()); 

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
    // $ANTLR end "rule__ExecutionTypeConfiguration__TypeAssignment_5"


    // $ANTLR start "rule__StatechartReferences__StatechartsAssignment_2"
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1793:1: rule__StatechartReferences__StatechartsAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__StatechartReferences__StatechartsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1797:1: ( ( ( RULE_ID ) ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1798:1: ( ( RULE_ID ) )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1798:1: ( ( RULE_ID ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1799:1: ( RULE_ID )
            {
             before(grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartCrossReference_2_0()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1800:1: ( RULE_ID )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1801:1: RULE_ID
            {
             before(grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__StatechartReferences__StatechartsAssignment_23522); 
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1812:1: rule__StatechartReferences__StatechartsAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__StatechartReferences__StatechartsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1816:1: ( ( ( RULE_ID ) ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1817:1: ( ( RULE_ID ) )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1817:1: ( ( RULE_ID ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1818:1: ( RULE_ID )
            {
             before(grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartCrossReference_3_1_0()); 
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1819:1: ( RULE_ID )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1820:1: RULE_ID
            {
             before(grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__StatechartReferences__StatechartsAssignment_3_13561); 
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1831:1: rule__GeneratorConfiguration__ConfigurationsAssignment : ( ruleConfigurations ) ;
    public final void rule__GeneratorConfiguration__ConfigurationsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1835:1: ( ( ruleConfigurations ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1836:1: ( ruleConfigurations )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1836:1: ( ruleConfigurations )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1837:1: ruleConfigurations
            {
             before(grammarAccess.getGeneratorConfigurationAccess().getConfigurationsConfigurationsParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleConfigurations_in_rule__GeneratorConfiguration__ConfigurationsAssignment3596);
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1846:1: rule__OutletConfiguration__ProjectNameAssignment_5 : ( RULE_STRING ) ;
    public final void rule__OutletConfiguration__ProjectNameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1850:1: ( ( RULE_STRING ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1851:1: ( RULE_STRING )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1851:1: ( RULE_STRING )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1852:1: RULE_STRING
            {
             before(grammarAccess.getOutletConfigurationAccess().getProjectNameSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__OutletConfiguration__ProjectNameAssignment_53627); 
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
    // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1861:1: rule__OutletConfiguration__TargetFolderAssignment_8 : ( RULE_STRING ) ;
    public final void rule__OutletConfiguration__TargetFolderAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1865:1: ( ( RULE_STRING ) )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1866:1: ( RULE_STRING )
            {
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1866:1: ( RULE_STRING )
            // ../org.yakindu.sct.generator.model.java.ui/src-gen/org/yakindu/sct/generator/model/java/ui/contentassist/antlr/internal/InternalJavaGen.g:1867:1: RULE_STRING
            {
             before(grammarAccess.getOutletConfigurationAccess().getTargetFolderSTRINGTerminalRuleCall_8_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__OutletConfiguration__TargetFolderAssignment_83658); 
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
    public static final BitSet FOLLOW_ruleConfigurations_in_entryRuleConfigurations121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConfigurations128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Configurations__Alternatives_in_ruleConfigurations154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamingConfiguration_in_entryRuleNamingConfiguration181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamingConfiguration188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__0_in_ruleNamingConfiguration214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutionTypeConfiguration_in_entryRuleExecutionTypeConfiguration241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExecutionTypeConfiguration248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionTypeConfiguration__Group__0_in_ruleExecutionTypeConfiguration274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatechartReferences_in_entryRuleStatechartReferences301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatechartReferences308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group__0_in_ruleStatechartReferences334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratorConfiguration_in_entryRuleGeneratorConfiguration361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneratorConfiguration368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GeneratorConfiguration__ConfigurationsAssignment_in_ruleGeneratorConfiguration396 = new BitSet(new long[]{0x0000000002210002L});
    public static final BitSet FOLLOW_rule__GeneratorConfiguration__ConfigurationsAssignment_in_ruleGeneratorConfiguration408 = new BitSet(new long[]{0x0000000002210002L});
    public static final BitSet FOLLOW_ruleOutletConfiguration_in_entryRuleOutletConfiguration438 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOutletConfiguration445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__0_in_ruleOutletConfiguration471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionType__Alternatives_in_ruleExecutionType508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutletConfiguration_in_rule__Configurations__Alternatives543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamingConfiguration_in_rule__Configurations__Alternatives560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutionTypeConfiguration_in_rule__Configurations__Alternatives577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__ExecutionType__Alternatives610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ExecutionType__Alternatives631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__Group__0__Impl_in_rule__BaseGeneratorModel__Group__0664 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__Group__1_in_rule__BaseGeneratorModel__Group__0667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__BaseGeneratorModel__Group__0__Impl695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__Group__1__Impl_in_rule__BaseGeneratorModel__Group__1726 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__Group__2_in_rule__BaseGeneratorModel__Group__1729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__BaseGeneratorModel__Group__1__Impl757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__Group__2__Impl_in_rule__BaseGeneratorModel__Group__2788 = new BitSet(new long[]{0x0000000002210000L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__Group__3_in_rule__BaseGeneratorModel__Group__2791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__StatechartReferencesAssignment_2_in_rule__BaseGeneratorModel__Group__2__Impl818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__Group__3__Impl_in_rule__BaseGeneratorModel__Group__3848 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__Group__4_in_rule__BaseGeneratorModel__Group__3851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__ConfigurationAssignment_3_in_rule__BaseGeneratorModel__Group__3__Impl878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BaseGeneratorModel__Group__4__Impl_in_rule__BaseGeneratorModel__Group__4908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__BaseGeneratorModel__Group__4__Impl936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__0__Impl_in_rule__NamingConfiguration__Group__0977 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__1_in_rule__NamingConfiguration__Group__0980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__1__Impl_in_rule__NamingConfiguration__Group__11038 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__2_in_rule__NamingConfiguration__Group__11041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__NamingConfiguration__Group__1__Impl1069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__2__Impl_in_rule__NamingConfiguration__Group__21100 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__3_in_rule__NamingConfiguration__Group__21103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__NamingConfiguration__Group__2__Impl1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__3__Impl_in_rule__NamingConfiguration__Group__31162 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__4_in_rule__NamingConfiguration__Group__31165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__NamingConfiguration__Group__3__Impl1193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__4__Impl_in_rule__NamingConfiguration__Group__41224 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__5_in_rule__NamingConfiguration__Group__41227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__NamingConfiguration__Group__4__Impl1255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__5__Impl_in_rule__NamingConfiguration__Group__51286 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__6_in_rule__NamingConfiguration__Group__51289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__InterfacePackageNameAssignment_5_in_rule__NamingConfiguration__Group__5__Impl1316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__6__Impl_in_rule__NamingConfiguration__Group__61346 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__7_in_rule__NamingConfiguration__Group__61349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__NamingConfiguration__Group__6__Impl1377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__7__Impl_in_rule__NamingConfiguration__Group__71408 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__8_in_rule__NamingConfiguration__Group__71411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__NamingConfiguration__Group__7__Impl1439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__8__Impl_in_rule__NamingConfiguration__Group__81470 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__9_in_rule__NamingConfiguration__Group__81473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__ImplementationPackageNameAssignment_8_in_rule__NamingConfiguration__Group__8__Impl1500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__9__Impl_in_rule__NamingConfiguration__Group__91530 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__10_in_rule__NamingConfiguration__Group__91533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__NamingConfiguration__Group__9__Impl1561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__10__Impl_in_rule__NamingConfiguration__Group__101592 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__11_in_rule__NamingConfiguration__Group__101595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__NamingConfiguration__Group__10__Impl1623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__11__Impl_in_rule__NamingConfiguration__Group__111654 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__12_in_rule__NamingConfiguration__Group__111657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__CopyrightAssignment_11_in_rule__NamingConfiguration__Group__11__Impl1684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamingConfiguration__Group__12__Impl_in_rule__NamingConfiguration__Group__121714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__NamingConfiguration__Group__12__Impl1742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionTypeConfiguration__Group__0__Impl_in_rule__ExecutionTypeConfiguration__Group__01799 = new BitSet(new long[]{0x0000000002210000L});
    public static final BitSet FOLLOW_rule__ExecutionTypeConfiguration__Group__1_in_rule__ExecutionTypeConfiguration__Group__01802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionTypeConfiguration__Group__1__Impl_in_rule__ExecutionTypeConfiguration__Group__11860 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__ExecutionTypeConfiguration__Group__2_in_rule__ExecutionTypeConfiguration__Group__11863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ExecutionTypeConfiguration__Group__1__Impl1891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionTypeConfiguration__Group__2__Impl_in_rule__ExecutionTypeConfiguration__Group__21922 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__ExecutionTypeConfiguration__Group__3_in_rule__ExecutionTypeConfiguration__Group__21925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ExecutionTypeConfiguration__Group__2__Impl1953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionTypeConfiguration__Group__3__Impl_in_rule__ExecutionTypeConfiguration__Group__31984 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__ExecutionTypeConfiguration__Group__4_in_rule__ExecutionTypeConfiguration__Group__31987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ExecutionTypeConfiguration__Group__3__Impl2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionTypeConfiguration__Group__4__Impl_in_rule__ExecutionTypeConfiguration__Group__42046 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_rule__ExecutionTypeConfiguration__Group__5_in_rule__ExecutionTypeConfiguration__Group__42049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ExecutionTypeConfiguration__Group__4__Impl2077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionTypeConfiguration__Group__5__Impl_in_rule__ExecutionTypeConfiguration__Group__52108 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__ExecutionTypeConfiguration__Group__6_in_rule__ExecutionTypeConfiguration__Group__52111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionTypeConfiguration__TypeAssignment_5_in_rule__ExecutionTypeConfiguration__Group__5__Impl2138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionTypeConfiguration__Group__6__Impl_in_rule__ExecutionTypeConfiguration__Group__62168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ExecutionTypeConfiguration__Group__6__Impl2196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group__0__Impl_in_rule__StatechartReferences__Group__02241 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group__1_in_rule__StatechartReferences__Group__02244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__StatechartReferences__Group__0__Impl2272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group__1__Impl_in_rule__StatechartReferences__Group__12303 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group__2_in_rule__StatechartReferences__Group__12306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__StatechartReferences__Group__1__Impl2334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group__2__Impl_in_rule__StatechartReferences__Group__22365 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group__3_in_rule__StatechartReferences__Group__22368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StatechartReferences__StatechartsAssignment_2_in_rule__StatechartReferences__Group__2__Impl2397 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__StatechartReferences__StatechartsAssignment_2_in_rule__StatechartReferences__Group__2__Impl2409 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group__3__Impl_in_rule__StatechartReferences__Group__32442 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group__4_in_rule__StatechartReferences__Group__32445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group_3__0_in_rule__StatechartReferences__Group__3__Impl2472 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group__4__Impl_in_rule__StatechartReferences__Group__42503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__StatechartReferences__Group__4__Impl2531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group_3__0__Impl_in_rule__StatechartReferences__Group_3__02572 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group_3__1_in_rule__StatechartReferences__Group_3__02575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__StatechartReferences__Group_3__0__Impl2603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StatechartReferences__Group_3__1__Impl_in_rule__StatechartReferences__Group_3__12634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StatechartReferences__StatechartsAssignment_3_1_in_rule__StatechartReferences__Group_3__1__Impl2661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__0__Impl_in_rule__OutletConfiguration__Group__02695 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__1_in_rule__OutletConfiguration__Group__02698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__1__Impl_in_rule__OutletConfiguration__Group__12756 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__2_in_rule__OutletConfiguration__Group__12759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__OutletConfiguration__Group__1__Impl2787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__2__Impl_in_rule__OutletConfiguration__Group__22818 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__3_in_rule__OutletConfiguration__Group__22821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__OutletConfiguration__Group__2__Impl2849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__3__Impl_in_rule__OutletConfiguration__Group__32880 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__4_in_rule__OutletConfiguration__Group__32883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__OutletConfiguration__Group__3__Impl2911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__4__Impl_in_rule__OutletConfiguration__Group__42942 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__5_in_rule__OutletConfiguration__Group__42945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__OutletConfiguration__Group__4__Impl2973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__5__Impl_in_rule__OutletConfiguration__Group__53004 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__6_in_rule__OutletConfiguration__Group__53007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__ProjectNameAssignment_5_in_rule__OutletConfiguration__Group__5__Impl3034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__6__Impl_in_rule__OutletConfiguration__Group__63064 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__7_in_rule__OutletConfiguration__Group__63067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__OutletConfiguration__Group__6__Impl3095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__7__Impl_in_rule__OutletConfiguration__Group__73126 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__8_in_rule__OutletConfiguration__Group__73129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__OutletConfiguration__Group__7__Impl3157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__8__Impl_in_rule__OutletConfiguration__Group__83188 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__9_in_rule__OutletConfiguration__Group__83191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__TargetFolderAssignment_8_in_rule__OutletConfiguration__Group__8__Impl3218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutletConfiguration__Group__9__Impl_in_rule__OutletConfiguration__Group__93248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__OutletConfiguration__Group__9__Impl3276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatechartReferences_in_rule__BaseGeneratorModel__StatechartReferencesAssignment_23332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratorConfiguration_in_rule__BaseGeneratorModel__ConfigurationAssignment_33363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__NamingConfiguration__InterfacePackageNameAssignment_53394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__NamingConfiguration__ImplementationPackageNameAssignment_83425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__NamingConfiguration__CopyrightAssignment_113456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutionType_in_rule__ExecutionTypeConfiguration__TypeAssignment_53487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__StatechartReferences__StatechartsAssignment_23522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__StatechartReferences__StatechartsAssignment_3_13561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConfigurations_in_rule__GeneratorConfiguration__ConfigurationsAssignment3596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__OutletConfiguration__ProjectNameAssignment_53627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__OutletConfiguration__TargetFolderAssignment_83658 = new BitSet(new long[]{0x0000000000000002L});

}