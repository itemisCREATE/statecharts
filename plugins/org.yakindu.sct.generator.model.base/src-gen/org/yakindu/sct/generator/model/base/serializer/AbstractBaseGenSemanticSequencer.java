package org.yakindu.sct.generator.model.base.serializer;

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
import org.yakindu.sct.generator.model.base.services.BaseGenGrammarAccess;
import org.yakindu.sct.model.sgen.GeneratorConfiguration;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgen.SGenPackage;
import org.yakindu.sct.model.sgen.StatechartReferences;

@SuppressWarnings("restriction")
public class AbstractBaseGenSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected BaseGenGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == JavaGenModelPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
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
	 *     configurations+=Configurations+
	 *
	 * Features:
	 *    configurations[1, *]
	 */
	protected void sequence_GeneratorConfiguration_GeneratorConfiguration(EObject context, GeneratorConfiguration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
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
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (statecharts+=[Statechart|ID]+ statecharts+=[Statechart|ID]*)
	 *
	 * Features:
	 *    statecharts[1, *]
	 */
	protected void sequence_StatechartReferences_StatechartReferences(EObject context, StatechartReferences semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
