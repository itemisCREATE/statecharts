package org.yakindu.sct.model.sexec.transformation

import org.yakindu.sct.model.sgraph.Statechart
import org.eclipse.xtext.xtend2.lib.EObjectExtensions
import org.eclipse.xtext.xbase.lib.CollectionExtensions
import org.eclipse.emf.common.util.TreeIterator
import com.google.inject.Inject
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.yakindu.sct.model.sexec.Cycle
import org.yakindu.sct.model.sgraph.Transition
import org.yakindu.sct.model.sexec.If
import org.yakindu.sct.model.sgraph.Trigger
import org.yakindu.sct.model.stext.stext.ReactionTrigger
import org.yakindu.sct.model.sgraph.Statement
import org.yakindu.sct.model.stext.stext.Expression
import org.yakindu.sct.model.stext.stext.EventSpec
import org.yakindu.sct.model.stext.stext.RegularEventSpec
import org.yakindu.sct.model.sgraph.Declaration
import org.yakindu.sct.model.sexec.Step
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.Entry
import org.yakindu.sct.model.sgraph.SGraphPackage
import org.yakindu.sct.model.sexec.EnterState
import org.yakindu.sct.model.sexec.ExitState
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.Reaction
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.stext.stext.ReactionEffect
import org.yakindu.sct.model.sgraph.Effect
import org.yakindu.sct.model.sexec.Execution
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression
import org.yakindu.sct.model.stext.stext.StextPackage
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.yakindu.sct.model.stext.stext.Assignment
import org.yakindu.sct.model.sgraph.Variable
import org.yakindu.sct.model.stext.stext.LocalReaction
import org.yakindu.sct.model.stext.stext.EntryEvent
import org.yakindu.sct.model.stext.stext.ExitEvent
import org.eclipse.xtext.common.services.Ecore2XtextTerminalConverters
import org.eclipse.emf.ecore.util.EcoreUtil$AbstractFilteredSettingsIterator
import java.util.ArrayList
import org.yakindu.sct.model.stext.stext.TimeEventSpec
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.stext.stext.TimeEventType
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression
import org.yakindu.sct.model.stext.stext.TimeUnit
import org.yakindu.sct.model.stext.stext.MultiplicativeOperator
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.stext.stext.OnCycleEvent
import org.yakindu.sct.model.stext.stext.AlwaysEvent
import org.yakindu.sct.model.stext.stext.IntLiteral
import org.yakindu.sct.model.stext.stext.BoolLiteral
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.sgraph.Choice
import org.yakindu.sct.model.sexec.ExecutionChoice
import org.yakindu.sct.model.stext.stext.DefaultEvent
import org.yakindu.sct.model.sexec.ExecutionNode
import com.google.inject.name.Named
import org.yakindu.sct.model.sexec.ExecutionRegion
import org.yakindu.sct.model.sexec.ExecutionScope
import org.yakindu.sct.model.sexec.StateVector
import org.yakindu.sct.model.stext.stext.OperationCall
import org.yakindu.sct.model.stext.stext.Operation
import java.util.Set
import java.util.Collection
import org.yakindu.sct.model.stext.stext.TypedElementReferenceExpression
import org.yakindu.base.base.NamedElement
import org.apache.commons.logging.LogFactory
import org.yakindu.sct.model.stext.stext.FeatureCall
import org.apache.commons.logging.LogConfigurationException
import org.yakindu.base.types.Feature
import org.yakindu.sct.model.stext.stext.OperationDefinition

class ModelSequencer {
	 
	@Inject extension IQualifiedNameProvider qfnProvider
	@Inject extension SexecElementMapping mapping
	@Inject extension StatechartExtensions sct
	@Inject extension SgraphExtensions sgraph
	@Inject extension StextExtensions stext
	@Inject extension SexecExtensions sexec
	@Inject extension StructureMapping structureMapping
	@Inject extension BehaviorMapping behaviorMapping
	@Inject extension ReactionBuilder reactBuilder
	@Inject extension SequenceBuilder seqBuilder
	@Inject extension StateVectorBuilder svBuilder
	@Inject extension TraceExtensions trace
	
	@Inject
	@Named("ADD_TRACES") 
	boolean _addTraceSteps 
	
	
	/* ==========================================================================
	 * TRANSFORMATION ROOT
	 */ 

	def ExecutionFlow transform(Statechart sc) {
		val ef = sc.create
		
		// during mapping the basic structural elements will be mapped from the source statechart to the execution flow
		sc.mapScopes(ef)
		sc.mapRegularStates(ef)
		sc.mapRegions(ef)
		sc.mapPseudoStates(ef)
		sc.mapTimeEvents(ef)

		// calculate state vectors
		ef.defineStateVector(sc)
		ef.defineHistoryVector(sc)
		
		// derive all additional information that is necessary for the execution
		sc.mapEntryActions(ef)
		sc.mapExitActions(ef)
		
		
		ef.defineStateEnterSequences(sc)
		ef.defineStateExitSequences(sc)
		ef.defineDeepEnterSequences(sc)
		ef.defineShallowEnterSequences(sc)
		ef.defineStatechartEnterSequence(sc)
		ef.defineStatechartExitSequence(sc)
		
		sc.mapTransitions(ef)
		sc.mapLocalReactions(ef)
		sc.mapChoiceTransitions(ef)
		
		sc.defineEntryReactions(ef)
		ef.defineRegularStateReactions(sc)
		ef.definePseudoStateReactions(sc)
		
		// retarget declaration refs
		ef.retargetDeclRefs
		
		//TODO clear create caches to avoid memory leak with repetetive generator cycles
		//Not possible yet
		//Bug 358564 - [Xtend][Memory Leak] Create Extensions - Possibility to clear caches. 
		
		return ef
	}

	/************** retarget declaration refs **************/
	
	def retargetDeclRefs(ExecutionFlow flow) {
		val allContent = EcoreUtil2::eAllContentsAsList(flow)
		val declared = allContent.filter(e | e instanceof EventDefinition || e instanceof VariableDefinition || e instanceof OperationDefinition).toSet
		
		allContent.filter(typeof(TypedElementReferenceExpression)).forEach( ere | ere.retarget(declared) )
		allContent.filter(typeof(FeatureCall)).forEach( call|call.retarget(declared))
	}
	
	
	def retarget(TypedElementReferenceExpression ere, Collection<EObject> declared) {
		if (ere.reference != null && ! declared.contains(ere.reference) ) {
			val r = ere.reference.replaced 
			if (r != null) ere.reference = r
		}
	}

	def retarget(FeatureCall call, Collection<EObject> declared) {
		if (call.feature != null && ! declared.contains(call.feature) ) {
			val r = call.feature.replaced 
			if ( r != null ) call.feature = r as Feature	
		}
	}
	
	
	def dispatch Declaration replaced(NamedElement ne) {
		try {
			println("Replace with unknown NamedElement called: "+if (ne ==null) "null" else ne.name)
			
			LogFactory::getLog(typeof(ModelSequencer)).error("Replace with unknown NamedElement called: "+if (ne ==null) "null" else ne.name)
		} catch (LogConfigurationException e) {
			e.printStackTrace
			println("Replace with unknown NamedElement called: "+if (ne ==null) "null" else ne.name)
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