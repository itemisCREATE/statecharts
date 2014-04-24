package org.yakindu.sct.model.sexec.transformation

import com.google.inject.Inject
import java.util.Collection
import org.apache.commons.logging.LogConfigurationException
import org.apache.commons.logging.LogFactory
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.Feature
import org.yakindu.base.types.Package
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sgraph.Declaration
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.stext.stext.ImportScope
import org.yakindu.sct.model.sgraph.ImportDeclaration

class ModelSequencer implements IModelSequencer {
	 
	@Inject extension IQualifiedNameProvider qfnProvider
	@Inject extension SexecElementMapping mapping
	@Inject extension StructureMapping structureMapping
	@Inject extension BehaviorMapping behaviorMapping
	@Inject extension ReactionBuilder reactBuilder
	@Inject extension SequenceBuilder seqBuilder
	@Inject extension StateVectorBuilder svBuilder
	
	/* ==========================================================================
	 * TRANSFORMATION ROOT
	 */ 


	override ExecutionFlow transform(Statechart sc) {
		val ef = sc.create
		
		// during mapping the basic structural elements will be mapped from the source statechart to the execution flow
		sc.mapScopes(ef)
		sc.mapRegularStates(ef)
		sc.mapPseudoStates(ef)
		sc.mapRegions(ef)
		sc.mapTimeEvents(ef)

		// calculate state vectors
		ef.defineStateVector(sc)
		ef.defineHistoryVector(sc)
		
		// derive all additional information that is necessary for the execution
		sc.mapEntryActions(ef)
		sc.mapExitActions(ef)
		
		 
		ef.defineEnterSequences(sc)
		ef.defineStateExitSequences(sc)
		ef.defineDeepEnterSequences(sc)
		ef.defineShallowEnterSequences(sc)
		ef.defineStatechartEnterSequence(sc)
		ef.defineStatechartExitSequence(sc)

		ef.defineStatechartInitSequence(sc)
		
		sc.mapTransitions(ef)
		sc.mapEntries(ef)
		sc.mapLocalReactions(ef)
		sc.mapChoiceTransitions(ef)
		sc.mapSyncTransitions(ef)
		
		sc.defineEntryReactions(ef)
		ef.defineRegularStateReactions(sc)
		ef.definePseudoStateReactions(sc)
		ef.defineStatechartReaction(sc)
		
		// retarget declaration refs
		ef.retargetDeclRefs
		
		//clear create caches to avoid memory leak with repetetive generator cycles
		mapping.cleanup
		
		return ef
	}

	/************** retarget declaration refs **************/
	
	def retargetDeclRefs(ExecutionFlow flow) {
		val allContent = EcoreUtil2::eAllContentsAsList(flow)
		val declared = flow.scopes.map[
			if (it instanceof ImportScope) {
				declarations.filter(ImportDeclaration).map[declaration].toList
			} else { 
				declarations
			}
		].flatten.toSet
		
		allContent.filter(typeof(ElementReferenceExpression)).forEach( ere | ere.retarget(declared) )
		allContent.filter(typeof(FeatureCall)).forEach( call|call.retarget(declared))
	}
	
	
	def retarget(ElementReferenceExpression ere, Collection<Declaration> declared) {
		if (ere.reference != null && ! declared.contains(ere.reference) ) {
			// elements within externally declared packages should not be replaced but referenced
			if (EcoreUtil2.getContainerOfType(ere.reference, Package) == null) {
				val r = ere.reference.replaced 
				if (r != null) ere.reference = r
			}
		}
	}

	def retarget(FeatureCall call, Collection<Declaration> declared) {
		if (call.feature != null && ! declared.contains(call.feature) ) {
			// elements within externally declared packages should not be replaced but referenced
			if (EcoreUtil2.getContainerOfType(call.feature, Package) == null) {
				val r = call.feature.replaced 
				if ( r != null ) call.feature = r as Feature
			}
		}
	}
	
	
	def dispatch Declaration replaced(EObject ne) {
		try {
			println("Replace with unknown eObject called: "+if (ne ==null) "null" else ne.fullyQualifiedName)
			
			LogFactory::getLog(typeof(ModelSequencer)).error("Replace with unknown NamedElement called: "+if (ne ==null) "null" else ne.fullyQualifiedName)
		} catch (LogConfigurationException e) {
			e.printStackTrace
			println("Replace with unknown NamedElement called: "+if (ne ==null) "null" else ne.fullyQualifiedName)
		}
		null;
	}
	
	def dispatch replaced(VariableDefinition vd) {
		vd.create	
	}
	def dispatch replaced(OperationDefinition vd) {
		vd.create	
	}
	
	def dispatch replaced(EventDefinition ed) {
		ed.create
	}

	def dispatch replaced(TimeEvent ed) {
		ed
	}
	
		 	
}