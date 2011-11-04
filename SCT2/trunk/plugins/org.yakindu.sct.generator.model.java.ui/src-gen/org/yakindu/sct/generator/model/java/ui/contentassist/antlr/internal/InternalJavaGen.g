/*
* generated by Xtext
*/
grammar InternalJavaGen;

options {
	superClass=AbstractInternalContentAssistParser;
	
}

@lexer::header {
package org.yakindu.sct.generator.model.java.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
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

}

@parser::members {
 
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

}




// Entry rule entryRuleBaseGeneratorModel
entryRuleBaseGeneratorModel 
:
{ before(grammarAccess.getBaseGeneratorModelRule()); }
	 ruleBaseGeneratorModel
{ after(grammarAccess.getBaseGeneratorModelRule()); } 
	 EOF 
;

// Rule BaseGeneratorModel
ruleBaseGeneratorModel
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getBaseGeneratorModelAccess().getGroup()); }
(rule__BaseGeneratorModel__Group__0)
{ after(grammarAccess.getBaseGeneratorModelAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleConfigurations
entryRuleConfigurations 
:
{ before(grammarAccess.getConfigurationsRule()); }
	 ruleConfigurations
{ after(grammarAccess.getConfigurationsRule()); } 
	 EOF 
;

// Rule Configurations
ruleConfigurations
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getConfigurationsAccess().getAlternatives()); }
(rule__Configurations__Alternatives)
{ after(grammarAccess.getConfigurationsAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNamingConfiguration
entryRuleNamingConfiguration 
:
{ before(grammarAccess.getNamingConfigurationRule()); }
	 ruleNamingConfiguration
{ after(grammarAccess.getNamingConfigurationRule()); } 
	 EOF 
;

// Rule NamingConfiguration
ruleNamingConfiguration
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNamingConfigurationAccess().getGroup()); }
(rule__NamingConfiguration__Group__0)
{ after(grammarAccess.getNamingConfigurationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleExecutionTypeConfiguration
entryRuleExecutionTypeConfiguration 
:
{ before(grammarAccess.getExecutionTypeConfigurationRule()); }
	 ruleExecutionTypeConfiguration
{ after(grammarAccess.getExecutionTypeConfigurationRule()); } 
	 EOF 
;

// Rule ExecutionTypeConfiguration
ruleExecutionTypeConfiguration
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getExecutionTypeConfigurationAccess().getGroup()); }
(rule__ExecutionTypeConfiguration__Group__0)
{ after(grammarAccess.getExecutionTypeConfigurationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleStatechartReferences
entryRuleStatechartReferences 
:
{ before(grammarAccess.getStatechartReferencesRule()); }
	 ruleStatechartReferences
{ after(grammarAccess.getStatechartReferencesRule()); } 
	 EOF 
;

// Rule StatechartReferences
ruleStatechartReferences
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getStatechartReferencesAccess().getGroup()); }
(rule__StatechartReferences__Group__0)
{ after(grammarAccess.getStatechartReferencesAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleGeneratorConfiguration
entryRuleGeneratorConfiguration 
:
{ before(grammarAccess.getGeneratorConfigurationRule()); }
	 ruleGeneratorConfiguration
{ after(grammarAccess.getGeneratorConfigurationRule()); } 
	 EOF 
;

// Rule GeneratorConfiguration
ruleGeneratorConfiguration
    @init {
		int stackSize = keepStackSize();
    }
	:
(
(
{ before(grammarAccess.getGeneratorConfigurationAccess().getConfigurationsAssignment()); }
(rule__GeneratorConfiguration__ConfigurationsAssignment)
{ after(grammarAccess.getGeneratorConfigurationAccess().getConfigurationsAssignment()); }
)
(
{ before(grammarAccess.getGeneratorConfigurationAccess().getConfigurationsAssignment()); }
(rule__GeneratorConfiguration__ConfigurationsAssignment)*
{ after(grammarAccess.getGeneratorConfigurationAccess().getConfigurationsAssignment()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOutletConfiguration
entryRuleOutletConfiguration 
:
{ before(grammarAccess.getOutletConfigurationRule()); }
	 ruleOutletConfiguration
{ after(grammarAccess.getOutletConfigurationRule()); } 
	 EOF 
;

// Rule OutletConfiguration
ruleOutletConfiguration
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getOutletConfigurationAccess().getGroup()); }
(rule__OutletConfiguration__Group__0)
{ after(grammarAccess.getOutletConfigurationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}




// Rule ExecutionType
ruleExecutionType
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecutionTypeAccess().getAlternatives()); }
(rule__ExecutionType__Alternatives)
{ after(grammarAccess.getExecutionTypeAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__Configurations__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConfigurationsAccess().getOutletConfigurationParserRuleCall_0()); }
	ruleOutletConfiguration
{ after(grammarAccess.getConfigurationsAccess().getOutletConfigurationParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getConfigurationsAccess().getNamingConfigurationParserRuleCall_1()); }
	ruleNamingConfiguration
{ after(grammarAccess.getConfigurationsAccess().getNamingConfigurationParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getConfigurationsAccess().getExecutionTypeConfigurationParserRuleCall_2()); }
	ruleExecutionTypeConfiguration
{ after(grammarAccess.getConfigurationsAccess().getExecutionTypeConfigurationParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ExecutionType__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecutionTypeAccess().getCYCLE_BASEDEnumLiteralDeclaration_0()); }
(	'cycleBased' 
)
{ after(grammarAccess.getExecutionTypeAccess().getCYCLE_BASEDEnumLiteralDeclaration_0()); }
)

    |(
{ before(grammarAccess.getExecutionTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_1()); }
(	'eventDriven' 
)
{ after(grammarAccess.getExecutionTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__BaseGeneratorModel__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BaseGeneratorModel__Group__0__Impl
	rule__BaseGeneratorModel__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BaseGeneratorModel__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBaseGeneratorModelAccess().getJavaGeneratorKeyword_0()); }

	'JavaGenerator' 

{ after(grammarAccess.getBaseGeneratorModelAccess().getJavaGeneratorKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BaseGeneratorModel__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BaseGeneratorModel__Group__1__Impl
	rule__BaseGeneratorModel__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__BaseGeneratorModel__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBaseGeneratorModelAccess().getLeftCurlyBracketKeyword_1()); }

	'{' 

{ after(grammarAccess.getBaseGeneratorModelAccess().getLeftCurlyBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BaseGeneratorModel__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BaseGeneratorModel__Group__2__Impl
	rule__BaseGeneratorModel__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__BaseGeneratorModel__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBaseGeneratorModelAccess().getStatechartReferencesAssignment_2()); }
(rule__BaseGeneratorModel__StatechartReferencesAssignment_2)
{ after(grammarAccess.getBaseGeneratorModelAccess().getStatechartReferencesAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BaseGeneratorModel__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BaseGeneratorModel__Group__3__Impl
	rule__BaseGeneratorModel__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__BaseGeneratorModel__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBaseGeneratorModelAccess().getConfigurationAssignment_3()); }
(rule__BaseGeneratorModel__ConfigurationAssignment_3)
{ after(grammarAccess.getBaseGeneratorModelAccess().getConfigurationAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BaseGeneratorModel__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BaseGeneratorModel__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BaseGeneratorModel__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBaseGeneratorModelAccess().getRightCurlyBracketKeyword_4()); }

	'}' 

{ after(grammarAccess.getBaseGeneratorModelAccess().getRightCurlyBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__NamingConfiguration__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NamingConfiguration__Group__0__Impl
	rule__NamingConfiguration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NamingConfiguration__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamingConfigurationAccess().getNamingConfigurationAction_0()); }
(

)
{ after(grammarAccess.getNamingConfigurationAccess().getNamingConfigurationAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NamingConfiguration__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NamingConfiguration__Group__1__Impl
	rule__NamingConfiguration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NamingConfiguration__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamingConfigurationAccess().getNamingKeyword_1()); }

	'naming' 

{ after(grammarAccess.getNamingConfigurationAccess().getNamingKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NamingConfiguration__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NamingConfiguration__Group__2__Impl
	rule__NamingConfiguration__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__NamingConfiguration__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamingConfigurationAccess().getLeftCurlyBracketKeyword_2()); }

	'{' 

{ after(grammarAccess.getNamingConfigurationAccess().getLeftCurlyBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NamingConfiguration__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NamingConfiguration__Group__3__Impl
	rule__NamingConfiguration__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__NamingConfiguration__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamingConfigurationAccess().getInterfacePackageKeyword_3()); }

	'interfacePackage' 

{ after(grammarAccess.getNamingConfigurationAccess().getInterfacePackageKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NamingConfiguration__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NamingConfiguration__Group__4__Impl
	rule__NamingConfiguration__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__NamingConfiguration__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamingConfigurationAccess().getEqualsSignKeyword_4()); }

	'=' 

{ after(grammarAccess.getNamingConfigurationAccess().getEqualsSignKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NamingConfiguration__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NamingConfiguration__Group__5__Impl
	rule__NamingConfiguration__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__NamingConfiguration__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamingConfigurationAccess().getInterfacePackageNameAssignment_5()); }
(rule__NamingConfiguration__InterfacePackageNameAssignment_5)
{ after(grammarAccess.getNamingConfigurationAccess().getInterfacePackageNameAssignment_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NamingConfiguration__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NamingConfiguration__Group__6__Impl
	rule__NamingConfiguration__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__NamingConfiguration__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamingConfigurationAccess().getImplementationPackageKeyword_6()); }

	'implementationPackage' 

{ after(grammarAccess.getNamingConfigurationAccess().getImplementationPackageKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NamingConfiguration__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NamingConfiguration__Group__7__Impl
	rule__NamingConfiguration__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__NamingConfiguration__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamingConfigurationAccess().getEqualsSignKeyword_7()); }

	'=' 

{ after(grammarAccess.getNamingConfigurationAccess().getEqualsSignKeyword_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NamingConfiguration__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NamingConfiguration__Group__8__Impl
	rule__NamingConfiguration__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__NamingConfiguration__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamingConfigurationAccess().getImplementationPackageNameAssignment_8()); }
(rule__NamingConfiguration__ImplementationPackageNameAssignment_8)
{ after(grammarAccess.getNamingConfigurationAccess().getImplementationPackageNameAssignment_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NamingConfiguration__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NamingConfiguration__Group__9__Impl
	rule__NamingConfiguration__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__NamingConfiguration__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamingConfigurationAccess().getCopyrightHeaderKeyword_9()); }

	'copyrightHeader' 

{ after(grammarAccess.getNamingConfigurationAccess().getCopyrightHeaderKeyword_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NamingConfiguration__Group__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NamingConfiguration__Group__10__Impl
	rule__NamingConfiguration__Group__11
;
finally {
	restoreStackSize(stackSize);
}

rule__NamingConfiguration__Group__10__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamingConfigurationAccess().getEqualsSignKeyword_10()); }

	'=' 

{ after(grammarAccess.getNamingConfigurationAccess().getEqualsSignKeyword_10()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NamingConfiguration__Group__11
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NamingConfiguration__Group__11__Impl
	rule__NamingConfiguration__Group__12
;
finally {
	restoreStackSize(stackSize);
}

rule__NamingConfiguration__Group__11__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamingConfigurationAccess().getCopyrightAssignment_11()); }
(rule__NamingConfiguration__CopyrightAssignment_11)
{ after(grammarAccess.getNamingConfigurationAccess().getCopyrightAssignment_11()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NamingConfiguration__Group__12
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NamingConfiguration__Group__12__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NamingConfiguration__Group__12__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamingConfigurationAccess().getRightCurlyBracketKeyword_12()); }

	'}' 

{ after(grammarAccess.getNamingConfigurationAccess().getRightCurlyBracketKeyword_12()); }
)

;
finally {
	restoreStackSize(stackSize);
}




























rule__ExecutionTypeConfiguration__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExecutionTypeConfiguration__Group__0__Impl
	rule__ExecutionTypeConfiguration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecutionTypeConfiguration__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecutionTypeConfigurationAccess().getExecutionTypeConfigurationAction_0()); }
(

)
{ after(grammarAccess.getExecutionTypeConfigurationAccess().getExecutionTypeConfigurationAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ExecutionTypeConfiguration__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExecutionTypeConfiguration__Group__1__Impl
	rule__ExecutionTypeConfiguration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecutionTypeConfiguration__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecutionTypeConfigurationAccess().getExecutionTypeKeyword_1()); }

	'executionType' 

{ after(grammarAccess.getExecutionTypeConfigurationAccess().getExecutionTypeKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ExecutionTypeConfiguration__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExecutionTypeConfiguration__Group__2__Impl
	rule__ExecutionTypeConfiguration__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecutionTypeConfiguration__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecutionTypeConfigurationAccess().getLeftCurlyBracketKeyword_2()); }

	'{' 

{ after(grammarAccess.getExecutionTypeConfigurationAccess().getLeftCurlyBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ExecutionTypeConfiguration__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExecutionTypeConfiguration__Group__3__Impl
	rule__ExecutionTypeConfiguration__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecutionTypeConfiguration__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecutionTypeConfigurationAccess().getTypeKeyword_3()); }

	'type' 

{ after(grammarAccess.getExecutionTypeConfigurationAccess().getTypeKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ExecutionTypeConfiguration__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExecutionTypeConfiguration__Group__4__Impl
	rule__ExecutionTypeConfiguration__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecutionTypeConfiguration__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecutionTypeConfigurationAccess().getEqualsSignKeyword_4()); }

	'=' 

{ after(grammarAccess.getExecutionTypeConfigurationAccess().getEqualsSignKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ExecutionTypeConfiguration__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExecutionTypeConfiguration__Group__5__Impl
	rule__ExecutionTypeConfiguration__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecutionTypeConfiguration__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecutionTypeConfigurationAccess().getTypeAssignment_5()); }
(rule__ExecutionTypeConfiguration__TypeAssignment_5)
{ after(grammarAccess.getExecutionTypeConfigurationAccess().getTypeAssignment_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ExecutionTypeConfiguration__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExecutionTypeConfiguration__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecutionTypeConfiguration__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecutionTypeConfigurationAccess().getRightCurlyBracketKeyword_6()); }

	'}' 

{ after(grammarAccess.getExecutionTypeConfigurationAccess().getRightCurlyBracketKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__StatechartReferences__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StatechartReferences__Group__0__Impl
	rule__StatechartReferences__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StatechartReferences__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatechartReferencesAccess().getStatechartsKeyword_0()); }

	'statecharts ' 

{ after(grammarAccess.getStatechartReferencesAccess().getStatechartsKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StatechartReferences__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StatechartReferences__Group__1__Impl
	rule__StatechartReferences__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StatechartReferences__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatechartReferencesAccess().getLeftCurlyBracketKeyword_1()); }

	'{' 

{ after(grammarAccess.getStatechartReferencesAccess().getLeftCurlyBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StatechartReferences__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StatechartReferences__Group__2__Impl
	rule__StatechartReferences__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__StatechartReferences__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getStatechartReferencesAccess().getStatechartsAssignment_2()); }
(rule__StatechartReferences__StatechartsAssignment_2)
{ after(grammarAccess.getStatechartReferencesAccess().getStatechartsAssignment_2()); }
)
(
{ before(grammarAccess.getStatechartReferencesAccess().getStatechartsAssignment_2()); }
(rule__StatechartReferences__StatechartsAssignment_2)*
{ after(grammarAccess.getStatechartReferencesAccess().getStatechartsAssignment_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StatechartReferences__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StatechartReferences__Group__3__Impl
	rule__StatechartReferences__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__StatechartReferences__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatechartReferencesAccess().getGroup_3()); }
(rule__StatechartReferences__Group_3__0)*
{ after(grammarAccess.getStatechartReferencesAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StatechartReferences__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StatechartReferences__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StatechartReferences__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatechartReferencesAccess().getRightCurlyBracketKeyword_4()); }

	'}' 

{ after(grammarAccess.getStatechartReferencesAccess().getRightCurlyBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__StatechartReferences__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StatechartReferences__Group_3__0__Impl
	rule__StatechartReferences__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StatechartReferences__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatechartReferencesAccess().getCommaKeyword_3_0()); }

	',' 

{ after(grammarAccess.getStatechartReferencesAccess().getCommaKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StatechartReferences__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StatechartReferences__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StatechartReferences__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatechartReferencesAccess().getStatechartsAssignment_3_1()); }
(rule__StatechartReferences__StatechartsAssignment_3_1)
{ after(grammarAccess.getStatechartReferencesAccess().getStatechartsAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OutletConfiguration__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutletConfiguration__Group__0__Impl
	rule__OutletConfiguration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OutletConfiguration__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutletConfigurationAccess().getOutletConfigurationCustomAction_0()); }
(

)
{ after(grammarAccess.getOutletConfigurationAccess().getOutletConfigurationCustomAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OutletConfiguration__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutletConfiguration__Group__1__Impl
	rule__OutletConfiguration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OutletConfiguration__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutletConfigurationAccess().getOutletKeyword_1()); }

	'outlet' 

{ after(grammarAccess.getOutletConfigurationAccess().getOutletKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OutletConfiguration__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutletConfiguration__Group__2__Impl
	rule__OutletConfiguration__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__OutletConfiguration__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutletConfigurationAccess().getLeftCurlyBracketKeyword_2()); }

	'{' 

{ after(grammarAccess.getOutletConfigurationAccess().getLeftCurlyBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OutletConfiguration__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutletConfiguration__Group__3__Impl
	rule__OutletConfiguration__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__OutletConfiguration__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutletConfigurationAccess().getProjectNameKeyword_3()); }

	'projectName' 

{ after(grammarAccess.getOutletConfigurationAccess().getProjectNameKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OutletConfiguration__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutletConfiguration__Group__4__Impl
	rule__OutletConfiguration__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__OutletConfiguration__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutletConfigurationAccess().getEqualsSignKeyword_4()); }

	'=' 

{ after(grammarAccess.getOutletConfigurationAccess().getEqualsSignKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OutletConfiguration__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutletConfiguration__Group__5__Impl
	rule__OutletConfiguration__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__OutletConfiguration__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutletConfigurationAccess().getProjectNameAssignment_5()); }
(rule__OutletConfiguration__ProjectNameAssignment_5)
{ after(grammarAccess.getOutletConfigurationAccess().getProjectNameAssignment_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OutletConfiguration__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutletConfiguration__Group__6__Impl
	rule__OutletConfiguration__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__OutletConfiguration__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutletConfigurationAccess().getFolderKeyword_6()); }

	'folder' 

{ after(grammarAccess.getOutletConfigurationAccess().getFolderKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OutletConfiguration__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutletConfiguration__Group__7__Impl
	rule__OutletConfiguration__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__OutletConfiguration__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutletConfigurationAccess().getEqualsSignKeyword_7()); }

	'=' 

{ after(grammarAccess.getOutletConfigurationAccess().getEqualsSignKeyword_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OutletConfiguration__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutletConfiguration__Group__8__Impl
	rule__OutletConfiguration__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__OutletConfiguration__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutletConfigurationAccess().getTargetFolderAssignment_8()); }
(rule__OutletConfiguration__TargetFolderAssignment_8)
{ after(grammarAccess.getOutletConfigurationAccess().getTargetFolderAssignment_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OutletConfiguration__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutletConfiguration__Group__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OutletConfiguration__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutletConfigurationAccess().getRightCurlyBracketKeyword_9()); }

	'}' 

{ after(grammarAccess.getOutletConfigurationAccess().getRightCurlyBracketKeyword_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}























rule__BaseGeneratorModel__StatechartReferencesAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBaseGeneratorModelAccess().getStatechartReferencesStatechartReferencesParserRuleCall_2_0()); }
	ruleStatechartReferences{ after(grammarAccess.getBaseGeneratorModelAccess().getStatechartReferencesStatechartReferencesParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BaseGeneratorModel__ConfigurationAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBaseGeneratorModelAccess().getConfigurationGeneratorConfigurationParserRuleCall_3_0()); }
	ruleGeneratorConfiguration{ after(grammarAccess.getBaseGeneratorModelAccess().getConfigurationGeneratorConfigurationParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NamingConfiguration__InterfacePackageNameAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamingConfigurationAccess().getInterfacePackageNameSTRINGTerminalRuleCall_5_0()); }
	RULE_STRING{ after(grammarAccess.getNamingConfigurationAccess().getInterfacePackageNameSTRINGTerminalRuleCall_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NamingConfiguration__ImplementationPackageNameAssignment_8
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamingConfigurationAccess().getImplementationPackageNameSTRINGTerminalRuleCall_8_0()); }
	RULE_STRING{ after(grammarAccess.getNamingConfigurationAccess().getImplementationPackageNameSTRINGTerminalRuleCall_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NamingConfiguration__CopyrightAssignment_11
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamingConfigurationAccess().getCopyrightSTRINGTerminalRuleCall_11_0()); }
	RULE_STRING{ after(grammarAccess.getNamingConfigurationAccess().getCopyrightSTRINGTerminalRuleCall_11_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ExecutionTypeConfiguration__TypeAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecutionTypeConfigurationAccess().getTypeExecutionTypeEnumRuleCall_5_0()); }
	ruleExecutionType{ after(grammarAccess.getExecutionTypeConfigurationAccess().getTypeExecutionTypeEnumRuleCall_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StatechartReferences__StatechartsAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartCrossReference_2_0()); }
(
{ before(grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartIDTerminalRuleCall_2_0_1()); }
	RULE_ID{ after(grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartIDTerminalRuleCall_2_0_1()); }
)
{ after(grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartCrossReference_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StatechartReferences__StatechartsAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartCrossReference_3_1_0()); }
(
{ before(grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartIDTerminalRuleCall_3_1_0_1()); }
	RULE_ID{ after(grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartIDTerminalRuleCall_3_1_0_1()); }
)
{ after(grammarAccess.getStatechartReferencesAccess().getStatechartsStatechartCrossReference_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GeneratorConfiguration__ConfigurationsAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGeneratorConfigurationAccess().getConfigurationsConfigurationsParserRuleCall_0()); }
	ruleConfigurations{ after(grammarAccess.getGeneratorConfigurationAccess().getConfigurationsConfigurationsParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OutletConfiguration__ProjectNameAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutletConfigurationAccess().getProjectNameSTRINGTerminalRuleCall_5_0()); }
	RULE_STRING{ after(grammarAccess.getOutletConfigurationAccess().getProjectNameSTRINGTerminalRuleCall_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OutletConfiguration__TargetFolderAssignment_8
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutletConfigurationAccess().getTargetFolderSTRINGTerminalRuleCall_8_0()); }
	RULE_STRING{ after(grammarAccess.getOutletConfigurationAccess().getTargetFolderSTRINGTerminalRuleCall_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


