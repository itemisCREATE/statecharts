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
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Package
import org.yakindu.base.types.validation.IValidationIssueAcceptor
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ListBasedValidationIssueAcceptor
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sgraph.ImportDeclaration
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.ImportScope
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition

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
		transform(sc, new ListBasedValidationIssueAcceptor)
	}

	override ExecutionFlow transform(Statechart sc, IValidationIssueAcceptor acceptor) {
		
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
		ef.defineStatechartStaticInitSequence(sc)
		
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
	
	/** The execution model contains mapped elements for all variables and events from the original model. All references 
	 * to the original declarations in the expressions must be retargeted to those in the execution model
	 */
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
	
	/**
	 * TODO: handle use of interface scope elements explicitly. Since element reference expressions that refer to scopes 
	 * have no concrete functionality at runtime and could be removed from the expression tree. This should be reworked 
	 * as soon as the sequencer will be extended to cover the complete behavior.
	 */
	def retarget(ElementReferenceExpression ere, Collection<Declaration> declared) {
		if (ere.reference != null 
			&& ! declared.contains(ere.reference) 
			&& ! (ere.reference instanceof InterfaceScope)
		) {
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
				if ( r != null ) call.feature = r as Declaration
			}
		}
	}
	
	
	def dispatch Declaration replaced(EObject ne) {
		try {
			var name = if (ne == null) "null" else ne.fullyQualifiedName
			var type = if (ne == null) "unknown type" else ne.class.simpleName
			var resource = if (ne == null) "unknown resource" else ne.eResource.URI.toString
			
			println("Replace with unknown EObject ("+type+") called: " + name + " in " + resource)
			
			LogFactory::getLog(typeof(ModelSequencer)).error("Replace with unknown EObject ("+type+") called: " + name + " in " + resource)
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