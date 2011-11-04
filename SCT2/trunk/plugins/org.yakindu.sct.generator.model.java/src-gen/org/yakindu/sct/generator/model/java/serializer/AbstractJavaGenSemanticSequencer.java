package org.yakindu.sct.generator.model.java.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.yakindu.sct.generator.model.base.javaGenModel.JavaGenModelPackage;
import org.yakindu.sct.generator.model.base.javaGenModel.OutletConfigurationCustom;
import org.yakindu.sct.generator.model.base.serializer.BaseGenSemanticSequencer;
import org.yakindu.sct.generator.model.java.javaGen.ExecutionTypeConfiguration;
import org.yakindu.sct.generator.model.java.javaGen.JavaGenPackage;
import org.yakindu.sct.generator.model.java.javaGen.NamingConfiguration;
import org.yakindu.sct.generator.model.java.services.JavaGenGrammarAccess;
import org.yakindu.sct.model.sgen.GeneratorConfiguration;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgen.SGenPackage;
import org.yakindu.sct.model.sgen.StatechartReferences;

@SuppressWarnings("restriction")
public class AbstractJavaGenSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected JavaGenGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	@Inject
	protected Provider<BaseGenSemanticSequencer> superSequencerProvider;
	 
	protected BaseGenSemanticSequencer superSequencer; 
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.superSequencer = superSequencerProvider.get();
		this.superSequencer.init(sequencer, sequenceAcceptor, errorAcceptor); 
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == JavaGenPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case JavaGenPackage.EXECUTION_TYPE_CONFIGURATION:
				if(context == grammarAccess.getConfigurationsRule() ||
				   context == grammarAccess.getExecutionTypeConfigurationRule()) {
					sequence_ExecutionTypeConfiguration_ExecutionTypeConfiguration(context, (ExecutionTypeConfiguration) semanticObject); 
					return; 
				}
				else break;
			case JavaGenPackage.NAMING_CONFIGURATION:
				if(context == grammarAccess.getConfigurationsRule() ||
				   context == grammarAccess.getNamingConfigurationRule()) {
					sequence_NamingConfiguration_NamingConfiguration(context, (NamingConfiguration) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == JavaGenModelPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case JavaGenModelPackage.OUTLET_CONFIGURATION_CUSTOM:
				if(context == grammarAccess.getConfigurationsRule() ||
				   context == grammarAccess.getOutletConfigurationRule()) {
					sequence_OutletConfiguration_OutletConfigurationCustom(context, (OutletConfigurationCustom) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == SGenPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case SGenPackage.GENERATOR_CONFIGURATION:
				if(context == grammarAccess.getGeneratorConfigurationRule()) {
					sequence_GeneratorConfiguration_GeneratorConfiguration(context, (GeneratorConfiguration) semanticObject); 
					return; 
				}
				else break;
			case SGenPackage.GENERATOR_MODEL:
				if(context == grammarAccess.getBaseGeneratorModelRule()) {
					sequence_BaseGeneratorModel_GeneratorModel(context, (GeneratorModel) semanticObject); 
					return; 
				}
				else break;
			case SGenPackage.STATECHART_REFERENCES:
				if(context == grammarAccess.getStatechartReferencesRule()) {
					sequence_StatechartReferences_StatechartReferences(context, (StatechartReferences) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (statechartReferences=StatechartReferences configuration=GeneratorConfiguration)
	 *
	 * Features:
	 *    configuration[1, 1]
	 *    statechartReferences[1, 1]
	 */
	protected void sequence_BaseGeneratorModel_GeneratorModel(EObject context, GeneratorModel semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SGenPackage.Literals.GENERATOR_MODEL__CONFIGURATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SGenPackage.Literals.GENERATOR_MODEL__CONFIGURATION));
			if(transientValues.isValueTransient(semanticObject, SGenPackage.Literals.GENERATOR_MODEL__STATECHART_REFERENCES) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SGenPackage.Literals.GENERATOR_MODEL__STATECHART_REFERENCES));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBaseGeneratorModelAccess().getStatechartReferencesStatechartReferencesParserRuleCall_2_0(), semanticObject.getStatechartReferences());
		feeder.accept(grammarAccess.getBaseGeneratorModelAccess().getConfigurationGeneratorConfigurationParserRuleCall_3_0(), semanticObject.getConfiguration());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     type=ExecutionType
	 *
	 * Features:
	 *    type[1, 1]
	 */
	protected void sequence_ExecutionTypeConfiguration_ExecutionTypeConfiguration(EObject context, ExecutionTypeConfiguration semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, JavaGenPackage.Literals.EXECUTION_TYPE_CONFIGURATION__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, JavaGenPackage.Literals.EXECUTION_TYPE_CONFIGURATION__TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExecutionTypeConfigurationAccess().getTypeExecutionTypeEnumRuleCall_5_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     configurations+=Configurations+
	 *
	 * Features:
	 *    configurations[1, *]
	 */
	protected void sequence_GeneratorConfiguration_GeneratorConfiguration(EObject context, GeneratorConfiguration semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (interfacePackageName=STRING implementationPackageName=STRING copyright=STRING)
	 *
	 * Features:
	 *    interfacePackageName[1, 1]
	 *    implementationPackageName[1, 1]
	 *    copyright[1, 1]
	 */
	protected void sequence_NamingConfiguration_NamingConfiguration(EObject context, NamingConfiguration semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, JavaGenPackage.Literals.NAMING_CONFIGURATION__INTERFACE_PACKAGE_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, JavaGenPackage.Literals.NAMING_CONFIGURATION__INTERFACE_PACKAGE_NAME));
			if(transientValues.isValueTransient(semanticObject, JavaGenPackage.Literals.NAMING_CONFIGURATION__IMPLEMENTATION_PACKAGE_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, JavaGenPackage.Literals.NAMING_CONFIGURATION__IMPLEMENTATION_PACKAGE_NAME));
			if(transientValues.isValueTransient(semanticObject, JavaGenPackage.Literals.NAMING_CONFIGURATION__COPYRIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, JavaGenPackage.Literals.NAMING_CONFIGURATION__COPYRIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNamingConfigurationAccess().getInterfacePackageNameSTRINGTerminalRuleCall_5_0(), semanticObject.getInterfacePackageName());
		feeder.accept(grammarAccess.getNamingConfigurationAccess().getImplementationPackageNameSTRINGTerminalRuleCall_8_0(), semanticObject.getImplementationPackageName());
		feeder.accept(grammarAccess.getNamingConfigurationAccess().getCopyrightSTRINGTerminalRuleCall_11_0(), semanticObject.getCopyright());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (projectName=STRING targetFolder=STRING)
	 *
	 * Features:
	 *    projectName[1, 1]
	 *    targetFolder[1, 1]
	 */
	protected void sequence_OutletConfiguration_OutletConfigurationCustom(EObject context, OutletConfigurationCustom semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (statecharts+=[Statechart|ID]+ statecharts+=[Statechart|ID]*)
	 *
	 * Features:
	 *    statecharts[1, *]
	 */
	protected void sequence_StatechartReferences_StatechartReferences(EObject context, StatechartReferences semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
}
