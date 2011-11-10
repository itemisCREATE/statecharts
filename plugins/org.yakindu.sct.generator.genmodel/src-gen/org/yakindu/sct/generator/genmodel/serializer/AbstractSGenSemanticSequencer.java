package org.yakindu.sct.generator.genmodel.serializer;

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
import org.yakindu.sct.generator.genmodel.services.SGenGrammarAccess;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgen.SGenPackage;

@SuppressWarnings("restriction")
public class AbstractSGenSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected SGenGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == SGenPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case SGenPackage.FEATURE_CONFIGURATION:
				if(context == grammarAccess.getFeatureConfigurationRule()) {
					sequence_FeatureConfiguration_FeatureConfiguration(context, (FeatureConfiguration) semanticObject); 
					return; 
				}
				else break;
			case SGenPackage.FEATURE_PARAMETER_VALUE:
				if(context == grammarAccess.getFeatureParameterValueRule()) {
					sequence_FeatureParameterValue_FeatureParameterValue(context, (FeatureParameterValue) semanticObject); 
					return; 
				}
				else break;
			case SGenPackage.GENERATOR_ENTRY:
				if(context == grammarAccess.getGeneratorEntryRule()) {
					sequence_GeneratorEntry_GeneratorEntry(context, (GeneratorEntry) semanticObject); 
					return; 
				}
				else break;
			case SGenPackage.GENERATOR_MODEL:
				if(context == grammarAccess.getGeneratorModelRule()) {
					sequence_GeneratorModel_GeneratorModel(context, (GeneratorModel) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (type=[FeatureType|ID] parameterValues+=FeatureParameterValue+)
	 *
	 * Features:
	 *    type[1, 1]
	 *    parameterValues[1, *]
	 */
	protected void sequence_FeatureConfiguration_FeatureConfiguration(EObject context, FeatureConfiguration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (parameter=[FeatureParameter|ID] value=STRING)
	 *
	 * Features:
	 *    parameter[1, 1]
	 *    value[1, 1]
	 */
	protected void sequence_FeatureParameterValue_FeatureParameterValue(EObject context, FeatureParameterValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SGenPackage.Literals.FEATURE_PARAMETER_VALUE__PARAMETER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SGenPackage.Literals.FEATURE_PARAMETER_VALUE__PARAMETER));
			if(transientValues.isValueTransient(semanticObject, SGenPackage.Literals.FEATURE_PARAMETER_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SGenPackage.Literals.FEATURE_PARAMETER_VALUE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFeatureParameterValueAccess().getParameterFeatureParameterIDTerminalRuleCall_1_0_1(), semanticObject.getParameter());
		feeder.accept(grammarAccess.getFeatureParameterValueAccess().getValueSTRINGTerminalRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (statechart=[Statechart|ID] features+=FeatureConfiguration*)
	 *
	 * Features:
	 *    statechart[1, 1]
	 *    features[0, *]
	 */
	protected void sequence_GeneratorEntry_GeneratorEntry(EObject context, GeneratorEntry semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (generatorId=QID entries+=GeneratorEntry+)
	 *
	 * Features:
	 *    entries[1, *]
	 *    generatorId[1, 1]
	 */
	protected void sequence_GeneratorModel_GeneratorModel(EObject context, GeneratorModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
