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

class ModelSequencer {
	
	@Inject extension IQualifiedNameProvider qfnProvider

	def ExecutionFlow create r : SexecFactory::eINSTANCE.createExecutionFlow transform(Statechart statechart){
		var content = EcoreUtil2::eAllContentsAsList(statechart)
		val leafStates = content.filter(e | e instanceof State && (e as State).simple)
		r.states.addAll(leafStates.map( s | (s as State).transform));
	}
	
	
	def ExecutionState create r : sexecFactory.createExecutionState transform(State state){
		r.simpleName = state.name
		r.name = state.fullyQualifiedName.toString.replaceAll(" ", "")
		r.cycle = state.buildCycle
	}
	
	
	def Cycle create r : sexecFactory.createCycle buildCycle(State state) {	
		r.steps.add( state.outgoingTransitions.reverseView.fold(null as If, [s, t | {
				var ifStep = t.buildTransitionSequence
				// TODO then ...
				ifStep.elseStep = s
				ifStep
			}]
		))
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
				if (s==null) _raised(e)  
				else _raised(e) || s
			]
		)
	}
	




	def Expression _operator_or(Expression left, Expression right) {
		val or = stextFactory.createLogicalOrExpression
		or.leftOperand = left
		or.rightOperand = right
		or
	}
	
	
//	def Expression _or(Expression left, Expression right) {
//		val or = stextFactory.createLogicalOrExpression
//		or.leftOperand = left
//		or.rightOperand = right
//		or
//	}
	
	
	def dispatch Expression _raised(EventSpec e) {
	}


	def dispatch Expression _raised(RegularEventSpec e) {
		val r = stextFactory.createElementReferenceExpression
		r.value = e.event as Declaration
		r
	}
	
	
	//--------- UTILS ---------------
	def sexecFactory() { SexecFactory::eINSTANCE }
	def stextFactory() { StextFactory::eINSTANCE }
}