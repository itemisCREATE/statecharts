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

class ModelSequencer {
	 
	@Inject extension IQualifiedNameProvider qfnProvider
	@Inject extension SexecElementMapping mapping
	@Inject extension StatechartExtensions sct
	@Inject extension SgraphExtensions sgraph
	@Inject extension StextExtensions stext
	@Inject extension SexecExtensions sexec
	@Inject extension StructureMapping structureMapping
	@Inject extension BehaviorMapping behaviorMapping
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
		
		// derive all additional information that is necessary for the execution
		sc.mapEntryActions(ef)
		sc.mapExitActions(ef)
		
		ef.defineStateEnterSequences(sc)
		ef.defineStateExitSequences(sc)
		ef.defineStatechartEnterSequence(sc)
		ef.defineStatechartExitSequence(sc)
		
		sc.mapTransitions(ef)
		sc.mapLocalReactions(ef)
		sc.mapChoiceTransitions(ef)
		
		ef.defineRegularStateReactions(sc)
		ef.definePseudoStateReactions(sc)
		
		// retarget declaration refs
		ef.retargetDeclRefs
		
		return ef
	}


	/* ==========================================================================
	 * STRUCTURAL MAPPING
	 */

	def ExecutionFlow mapChoiceTransitions(Statechart statechart, ExecutionFlow r) {
		statechart.allChoices.forEach( choice | choice.mapChoiceTransition);		
		return r
	}

	def ExecutionChoice mapChoiceTransition(Choice choice) {
		val _choice = choice.create
		_choice.reactions.addAll( choice.outgoingTransitions.map(t | t.mapTransition) )
		return _choice
	}

	def defineRegularStateReactions(ExecutionFlow flow, Statechart sc) {
		
		val states = sc.allRegularStates
		
		states.filter(typeof(State)).filter(s | s.simple).forEach(s | defineCycle(s))
		states.filter(typeof(FinalState)).forEach(s | defineCycle(s))
		
		return flow
	}
	

	def definePseudoStateReactions(ExecutionFlow flow, Statechart sc) {
		
		sc.allChoices().forEach( choice | choice.defineReaction() )
	}
	

	def Sequence defineReaction(Choice choice) {
	
		val execChoice = choice.create
		
		// move the default transition to the end of the reaction list
		val _default_ = execChoice.reactions.filter([ r | r.check.alwaysTrue ]).toList.head
		if ( _default_ != null ) execChoice.reactions.move(execChoice.reactions.size -1, _default_)
		// TODO: raise an error if no default exists 
		
		val stateReaction = execChoice.createReactionSequence(null)
		execChoice.reactSequence.steps.addAll(stateReaction.steps)

		execChoice.reactSequence.name = 'react'
		execChoice.reactSequence.comment = 'The reactions of state ' + choice.name + '.'
		
		if ( _addTraceSteps ) execChoice.reactSequence.steps.add(0,choice.create.newTraceNodeExecuted)
		
		return execChoice.reactSequence
	}	
	

	def alwaysTrue(Check check) {
		if (check != null && check.condition instanceof PrimitiveValueExpression) {
			val pve = (check.condition as PrimitiveValueExpression)
			return ( pve.value instanceof BoolLiteral && ( pve.value as BoolLiteral ).value )
		} 
		
		return false
	}



	def Sequence defineCycle(RegularState state) {
	
		val execState = state.create
		val stateReaction = execState.createReactionSequence(null)
		val parents = state.parentStates		
		execState.reactSequence = parents.fold(null, [r, s | {
			s.create.createReactionSequence(r)
		}])
		
		execState.reactSequence.name = 'react'
		execState.reactSequence.comment = 'The reactions of state ' + state.name + '.'
		
		return execState.reactSequence
	}	
	

	def Sequence createReactionSequence(ExecutionNode state, Step localStep) {	
		val cycle = sexec.factory.createSequence
				
		val localReactions = state.reactions.filter(r | ! r.transition).toList
		var localSteps = sexec.factory.createSequence
		localSteps.steps.addAll(localReactions.map(lr | {
				var ifStep = sexec.factory.createIf
				ifStep.check = lr.check.newRef		
				ifStep.thenStep = lr.effect.newCall
				ifStep
		}))
		if (localStep != null) localSteps.steps += localStep
		if (localSteps.steps.empty) localSteps = null
				
				
		val transitionReactions = state.reactions.filter(r | r.transition).toList
		val transitionStep = transitionReactions.reverseView.fold(localSteps as Step, [s, reaction | {
				var ifStep = sexec.factory.createIf
				ifStep.check = reaction.check.newRef		
				ifStep.thenStep = reaction.effect.newCall
				ifStep.elseStep = s
				ifStep as Step
			}])

	
		if (transitionStep != null) cycle.steps.add(transitionStep)		
		else if (localSteps != null) cycle.steps.add(localSteps)
		
		return cycle
	}
	
	/************** retarget declaration refs **************/
	
	def retargetDeclRefs(ExecutionFlow flow) {
		val allContent = EcoreUtil2::eAllContentsAsList(flow)
		val declared = allContent.filter(e | e instanceof EventDefinition || e instanceof VariableDefinition || e instanceof Operation).toSet
		
		allContent.filter(typeof(ElementReferenceExpression)).forEach( ere | ere.retarget(declared) )
		allContent.filter(typeof(Assignment)).forEach( ere | ere.retarget(declared) )
		allContent.filter(typeof(OperationCall)).forEach( call|call.retarget(declared))
	}
	
	
	def retarget(ElementReferenceExpression ere, Collection<EObject> declared) {
		if (! declared.contains(ere.value) ) ere.value = ere.value.replaced
	}
	
	def retarget(Assignment assign, Collection<EObject> declared) {
		if (! declared.contains(assign.varRef) ) assign.varRef = ((assign.varRef as VariableDefinition).replaced) as Variable
	}
	def retarget(OperationCall call, Collection<EObject> declared) {
		if (! declared.contains(call.operation) ) call.operation = (call.operation.replaced) as Operation
	}
	
	def dispatch replaced(VariableDefinition vd) {
		vd.create	
	}
	def dispatch replaced(Operation vd) {
		vd.create	
	}
	
	def dispatch replaced(EventDefinition ed) {
		ed.create	
	}

	def dispatch replaced(TimeEvent ed) {
		ed	
	}
	
		 	
}