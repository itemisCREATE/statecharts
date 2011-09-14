package org.yakindu.sct.model.sexec.transformation

import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sexec.SexecFactory
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
import org.yakindu.sct.model.stext.stext.StextFactory
import org.yakindu.sct.model.stext.stext.Expression
import org.yakindu.sct.model.stext.stext.EventSpec
import org.yakindu.sct.model.stext.stext.RegularEventSpec
import org.yakindu.sct.model.sgraph.Declaration
import org.yakindu.sct.model.sexec.Step
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.sct.model.sgraph.SGraphFactory
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition
import apple.awt.CRenderer$Tracer
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

class ModelSequencer {
	
	@Inject extension IQualifiedNameProvider qfnProvider
	@Inject extension FactoryExtension factory
	@Inject extension StatechartExtensions sct


	/* ==========================================================================
	 * TRANSFORMATION ROOT
	 */

	def ExecutionFlow transform(Statechart sc) {
		val ef = sc.create
		
		// during mapping the basic structural elements will be mapped from the source statechart to the execution flow
		sc.mapScopes(ef)
		sc.mapStates(ef)
		
		// derive all additional information that is necessary for the execution
		ef.defineStateVector(sc)
		ef.defineEnterSequence(sc)
		ef.defineStateCycles(sc)
		
		// retarget declaration refs
		ef.retargetDeclRefs
		
		return ef
	}
	
	
	/* ==========================================================================
	 * INTERFACE MAPPING
	 */
	
	/**
	 * maps all required scope defined in the statechart to the execution flow.
	 * This includes creating the scopes and adding all relevant declarations. Empty scopes wont be mapped.
	 */
	def ExecutionFlow mapScopes(Statechart sc, ExecutionFlow flow) {
		flow.scopes.addAll(sc.scopes.map(scope | scope.map))
		flow
	}
	
	
	/**
	 * 
	 */
	def Scope map(Scope scope) {
		val _scope = scope.create
		_scope.declarations.addAll(scope.declarations.map(decl | decl.map).filter(e | e != null))
		return _scope
	}
	
	
	def dispatch Declaration map(Declaration decl) {
	}
	
	def dispatch Declaration map(EventDefinition e) {
		val _e = e.create
		return _e
	}
	
	def dispatch Declaration map(VariableDefinition v) {
		val _v = v.create
		return _v
	}
	
	
	/* ==========================================================================
	 * STRUCTURAL MAPPING
	 */

		
	def ExecutionFlow mapStates(Statechart statechart, ExecutionFlow r){
		var content = EcoreUtil2::eAllContentsAsList(statechart)
		val allStates = content.filter(e | e instanceof State)
		r.states.addAll(allStates.map( s | (s as State).mapState));
		return r
	}

	
	def ExecutionState mapState(State state) {
		val _state = state.create
		_state.reactions.addAll( state.outgoingTransitions.map(t | t.mapTransition))
		_state.leaf = state.simple 
		_state
	}
	 
	 
	def Reaction mapTransition(Transition t) {
		val r = t.create 
		if (t.trigger != null) r.check = mapToCheck(t.trigger)
		r.effect = mapToEffect(t)
		return r
	}


	def Sequence mapToEffect(Transition t) {
		val sequence = sexecFactory.createSequence 
		if (t.source != null) sequence.steps.add(newExitStateStep(t.source as State))
		if (t.effect != null) sequence.steps.add(t.effect.mapEffect)		
		if (t.target != null) sequence.steps.add(newEnterStateStep(t.target as State))
		
		return sequence
	}	
	
	def dispatch Sequence mapEffect(Effect effect) {}
	
	def dispatch Sequence mapEffect(ReactionEffect effect) {
		if ( ! effect.actions.empty) {
			val sequence = sexecFactory.createSequence
			sequence.name = "reaction_action"
			sequence.steps.addAll( effect.actions.map( stmnt | stmnt.mapToExecution))
			return sequence	
		}	
	}
	
	def Execution mapToExecution(Statement stmnt) {
		val exec = sexecFactory.createExecution
		exec.statement = EcoreUtil::copy(stmnt)
		exec	
	}
	
	/* ==========================================================================
	 * SEQUENCING
	 */
	
	def defineStateCycles(ExecutionFlow flow, Statechart sc) {
		flow.states.filter(s | s.leaf).forEach(s | defineCycle(s))	
		return flow
	}
	

	def Cycle defineCycle(ExecutionState state) {	
		val cycle = sexecFactory.createCycle
		state.cycle = cycle
		
		val step = state.reactions.reverseView.fold(null as If, [s, reaction | {
				var ifStep = sexecFactory.createIf
				ifStep.check = reaction.check.newRef		
				ifStep.thenStep = reaction.effect.newCall
				ifStep.elseStep = s
				ifStep
			}])
			
		if (step != null) cycle.steps.add(step)
		
		return cycle
	}
	
//	def Cycle create r : sexecFactory.createCycle buildCycle(State state) {	
//		val folded = state.outgoingTransitions.reverseView.fold(null as If, [s, t | {
//				var ifStep = t.buildTransitionSequence
//				// TODO then ...
//				ifStep.elseStep = s
//				ifStep
//			}])
//			
//		if (folded != null) r.steps.add(folded)
//	}
	
	
//	def If buildTransitionSequence(Transition t) {
//		var ifStep = sexecFactory.createIf
//		if (t.trigger != null) ifStep.check = t.trigger.mapToCheck 
//		val thenSequence = sexecFactory.createSequence 
//		ifStep.thenStep = thenSequence
//		if (t.source != null) thenSequence.steps.add(newExitStateStep(t.source as State))		
//		if (t.target != null) thenSequence.steps.add(newEnterStateStep(t.target as State))
//		
//		return ifStep	
//	}
	

	def dispatch Check mapToCheck(Trigger tr) { null }
	  
	def dispatch Check mapToCheck(ReactionTrigger tr) {
		val check = tr.createCheck
		check.condition = tr.buildCondition;
		return check
	}
	
	def dispatch Statement buildCondition (Trigger t) {
		null
	}
	
	
	def dispatch Statement buildCondition (ReactionTrigger t) {
		if (! t.triggers.empty) t.triggers.reverseView.fold(null as Expression,
			[s,e | 
				if (s==null) raised(e)  
				else raised(e).or(s)
			]
		)
	}
	
	

	def Expression or(Expression left, Expression right) {
		val or = stextFactory.createLogicalOrExpression
		or.leftOperand = left
		or.rightOperand = right
		or
	}
	
	
	 

	def dispatch Expression raised(EventSpec e) {
	}


	def dispatch Expression raised(RegularEventSpec e) {
		val r = stextFactory.createElementReferenceExpression
		r.value = (e.event as EventDefinition).create
		return r
	}
	
	
	/************** Calculating Structure information **************/

	def defineStateVector(ExecutionFlow flow, Statechart sc) {
		flow.stateVector = sexecFactory.createStateVector
		flow.stateVector.offset = 0;
		flow.stateVector.size = sc.maxOrthogonality		
	}


	/************** Calculating execution sequences **************/
	
	
	def defineEnterSequence(ExecutionFlow flow, Statechart sc) {
		val enterSteps = sc.regions.map(r | r.entry.target?.newEnterStateStep).filter(e | e != null)
		val enterSequence = sexecFactory.createSequence
		enterSequence.name = "enter"
		enterSteps.forEach(e | enterSequence.steps.add(e));
		flow.enterSequence = enterSequence
		return enterSequence
	}
	
	
	def newEnterStateStep(State s) {
		var ess  = null as EnterState
		if (s != null) {
			ess = sexecFactory.createEnterState
			ess.state = s.create	
		}
		return ess
	}
	
	def newExitStateStep(State s) {
		var ess  = null as ExitState
		if (s != null) {
			ess = sexecFactory.createExitState
			ess.state = s.create	
		}
		return ess
	}
	
	
	
	/************** retarget declaration refs **************/
	
	def retargetDeclRefs(ExecutionFlow flow) {
		val allContent = EcoreUtil2::eAllContentsAsList(flow)
		val declared = allContent.filter(e | e instanceof EventDefinition || e instanceof VariableDefinition).toList
		
		allContent.filter(e | e instanceof ElementReferenceExpression).map(s | s as ElementReferenceExpression).forEach( ere | ere.retarget(declared) )
		allContent.filter(e | e instanceof Assignment).map(s | s as Assignment).forEach( ere | ere.retarget(declared) )
	}
	
	
	def retarget(ElementReferenceExpression ere, List<EObject> declared) {
		if (! declared.contains(ere.value) ) ere.value = ere.value.replaced
	}
	
	def retarget(Assignment assign, List<EObject> declared) {
		if (! declared.contains(assign.varRef) ) assign.varRef = ((assign.varRef as VariableDefinition).replaced) as Variable
	}
	
	def dispatch replaced(VariableDefinition vd) {
		vd.create	
	}
	
	def dispatch replaced(EventDefinition ed) {
		ed.create	
	}
	
	
	//--------- UTILS ---------------
	def sexecFactory() { SexecFactory::eINSTANCE }
	def stextFactory() { StextFactory::eINSTANCE }
	
	
	
	def entry(Region r) {
		r.vertices.findFirst(v | v instanceof Entry && (v.name == null || "".equals(v.name) || v.name == 'default') ) as Entry
	}
	
	
	def target(Entry entry) {
		entry?.outgoingTransitions?.get(0)?.target as State
	}
}