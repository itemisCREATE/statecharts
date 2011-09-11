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

class ModelSequencer {
	
	@Inject extension IQualifiedNameProvider qfnProvider
	@Inject extension FactoryExtension factory


	def ExecutionFlow transform(Statechart sc) {
		val ef = sc.create
		
		sc.mapExecutionFlow(ef)
		sc.mapScopes(ef)
		
		ef
	}
	
	
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
	
	
	
	
	
	def ExecutionFlow mapExecutionFlow(Statechart statechart, ExecutionFlow r){
		var content = EcoreUtil2::eAllContentsAsList(statechart)
		val leafStates = content.filter(e | e instanceof State && (e as State).simple)
		r.states.addAll(leafStates.map( s | (s as State).transform));
		return r
	}

	
	
	def ExecutionState transform(State state) {
		val _state = state.create;
		_state.cycle = state.buildCycle
		_state
	}
	
	
	def Cycle create r : sexecFactory.createCycle buildCycle(State state) {	
		val folded = state.outgoingTransitions.reverseView.fold(null as If, [s, t | {
				var ifStep = t.buildTransitionSequence
				// TODO then ...
				ifStep.elseStep = s
				ifStep
			}])
			
		if (folded != null) r.steps.add(folded)
	}
	
	
	def If buildTransitionSequence(Transition t) {
		var ifStep = sexecFactory.createIf
		if (t.trigger != null) ifStep.condition = t.trigger.buildCondition 
		ifStep	
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
	
	
		//--------- UTILS ---------------
	def sexecFactory() { SexecFactory::eINSTANCE }
	def stextFactory() { StextFactory::eINSTANCE }
	
	
}