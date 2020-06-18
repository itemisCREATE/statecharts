/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sexec.transformation

import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.sct.model.sexec.Call
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.CheckRef
import org.yakindu.sct.model.sexec.ExecutionChoice
import org.yakindu.sct.model.sexec.ExecutionEntry
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionRegion
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.HistoryEntry
import org.yakindu.sct.model.sexec.If
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.SexecFactory
import org.yakindu.sct.model.sexec.StateCase
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sgraph.SGraphFactory
import org.yakindu.sct.model.stext.stext.StextFactory
import com.google.inject.Inject
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.transformation.ng.StateMachineConcept

class FlowOptimizer {
	
	@Inject extension SExecExtensions sexec
	@Inject extension StateMachineConcept concept
	
	boolean _inlineReactions        def inlineReactions(boolean b)      {_inlineReactions = b}
	boolean _inlineEntryActions     def inlineEntryActions(boolean b)   {_inlineEntryActions = b}
	boolean _inlineExitActions      def inlineExitActions(boolean b)    {_inlineExitActions = b}
	boolean _inlineEnterSequences   def inlineEnterSequences(boolean b) {_inlineEnterSequences = b}
	boolean _inlineEnterRegion   	def inlineEnterRegion(boolean b) 	{_inlineEnterRegion = b}
	boolean _inlineExitRegion   	def inlineExitRegion(boolean b) 	{_inlineExitRegion = b}
	boolean _inlineExitSequences    def inlineExitSequences(boolean b)  {_inlineExitSequences = b}
	boolean _inlineChoices          def inlineChoices(boolean b)        {_inlineChoices = b}
	boolean _inlineEntries          def inlineEntries(boolean b)        {_inlineEntries = b}

	
	def ExecutionFlow transform(ExecutionFlow flow) {
		
		// first replace all 'if true' steps by then step.
		flow.replaceTrueIfs
		
		// we don't need empty functions and blocks
		flow.eliminateEmptySequences
		
		// perform inlining
		if (_inlineReactions) {
			flow.inlineReactionChecks	
			flow.inlineReactionEffects		
		}
		
		// always inline entry and exit actions defined on the statechart level.
		flow.entryAction.inline
		flow.exitAction.inline
		
		if (_inlineEntryActions)  flow.states.forEach( state | state.entryAction.inline )
		if (_inlineExitActions)   flow.states.forEach( state | state.exitAction.inline )
		if (_inlineEnterSequences) flow.states.forEach( state | state.enterSequences.forEach( s | s.inline ))
		if (_inlineExitSequences)  flow.states.forEach( state | state.exitSequence.inline )
		if (_inlineExitRegion) flow.eAllContents.filter(typeof(ExecutionRegion)).forEach( region | region.exitSequence.inline )
		if (_inlineEnterRegion) flow.eAllContents.filter(typeof(ExecutionRegion)).forEach( region | region.enterSequences.forEach( s | s.inline ))

				
		if (_inlineChoices) {
			flow.nodes.filter(typeof(ExecutionChoice)).forEach( node | { node.reactions.forEach( r | { r.check.inline r.effect.inline })  })
			// flow.nodes.filter(typeof(ExecutionChoice)).forEach( node | node.reactSequence.inline )
		}
		if (_inlineEntries) {
			flow.nodes.filter(typeof(ExecutionEntry)).forEach( node | { node.reactions.forEach( r | { r.check.inline r.effect.inline })  })
			flow.nodes.filter(typeof(ExecutionEntry)).forEach( node | node.reactSequence.inline )
		}

		// always inline checks and effects into react methods.
		flow.reactMethods.forEach[ inlineChecks ]
		flow.reactMethods.forEach[ inlineEffects ]
		
		return flow
	}
	
	
	/** Replaces all true if steps by then step. */
	def replaceTrueIfs(ExecutionFlow flow) {
		flow.eAllContents.filter(typeof(If)).filter( i | i.check.alwaysTrue ).forEach[ i |
			if (i.check instanceof CheckRef) (i.check as CheckRef).check = null
			i.check = null	
			i.substituteBy(i.thenStep)
		];
	}
	
	
	/** Determines and removes all empty sequences that are not part of a parent step from the model */
	def eliminateEmptySequences(ExecutionFlow flow) {

		var emptySeqences = flow.eAllContents.filter(typeof(Sequence)).filter( s | s.empty && !s.isStateMachineConcept).toList


		emptySeqences.removeAll(flow.states.map( state | state.reactSequence ))
		emptySeqences.removeAll(flow.nodes.map( node | node.reactSequence ))
		
		eliminateEmptySequencesInCompositeSteps(flow.allSequences)
		
		emptySeqences.forEach( s | { 
			val callList = s.caller.toList.clone 
			callList.forEach( c | { c.eContainer.substituteCall(c, null)
			
			callList.forEach[ call | call.step = null]
			})
		})
	}
	
	
	def eliminateEmptySequencesInCompositeSteps(List<Sequence> sequences) {
		
		var List<Sequence> garbage
		var long count
		
		do {
			
			garbage = sequences.filter[ seq | seq.empty && !seq.isStateMachineConcept && (seq.isInSequence || seq.isElseStep)].toList
			garbage.forEach[ seq | seq.eliminate]
			count += garbage.size
			
		} while (! garbage.empty)	
	}
	
	
	def isElseStep(Step it) {
		eContainer instanceof If && (eContainer as If).elseStep === it		
	}
	
	def isInSequence(Step it) {
		eContainer instanceof Sequence		
	}
	

	
	def allSequences(ExecutionFlow it) {
		eAllContents.filter(typeof(Sequence)).toList
	}
	
	
	def eliminate(Step it) {
		eContainer.eliminate(it)
	}
	
	
	def dispatch eliminate(Object parent, Step step) {}
	
	def dispatch eliminate(Sequence parent, Step step) {
		if (parent.steps.contains(step)) parent.steps.remove(step);		
	}
	
	def dispatch eliminate(If parent, Step step) {
		if (parent.elseStep === step) parent.elseStep = null;		
	}
	
	
	def substituteBy(Step orig, Step substitute) {
		orig.eContainer.substitute(orig, substitute)
	}
	
	
	def dispatch substitute(Object parent, Step orig, Step subst) {}

	def dispatch substitute(Sequence parent, Step orig, Step subst) {
		if (parent.steps.contains(orig)) parent.steps.set(parent.steps.indexOf(orig), subst);
	}
	
	def dispatch substitute(If parent, Step orig, Step subst) {
		if (parent.thenStep == orig) parent.thenStep = subst
		else if (parent.elseStep == orig) parent.elseStep = subst
		subst
	}
	
	
	def alwaysTrue(Check check) {
		if (check !== null && check.condition instanceof PrimitiveValueExpression) {
			val pve = (check.condition as PrimitiveValueExpression)
			return ( pve.value instanceof BoolLiteral && ( pve.value as BoolLiteral ).value )
		} 
		
		return false
	}
	
	def dispatch empty(Step step) { false }
	def dispatch empty(Sequence seq) { seq.steps.size == 0 }
	
	// INLINE REACTION CHECKS
	def void inlineReactionChecks(ExecutionFlow flow) {
		flow.states.forEach( state | state.inlineReactionChecks )
	}
	
	
	
	def inlineReactionChecks(ExecutionState state) {
		val checks = state.reactions.map(r | r.check).toList
		checks.forEach( c | c.inline )
		state
	}


	def inlineChecks(Method m) {
		if (m !== null) m.eAllContents.filter(CheckRef).toList.forEach( cr | cr.inline )
	}
	
	def inlineEffects(Method m) {
		if (m !== null) m.eAllContents.filter(Call).toList.forEach( call | call.inline )
	}
	
	
	def inline(Check c) {
		if ( c !== null ) {
			val List<CheckRef> cRefs = new ArrayList<CheckRef>()
			cRefs.addAll(c.refs)
			
			for ( ref : cRefs ) {
				val clone = EcoreUtil::copy(c)
				ref.eContainer.substitute(ref, clone)
				ref.check = null
			}
		}
		
		c
	}
	
	
	def inline(CheckRef it) {
		val clone = EcoreUtil::copy(check)
		eContainer.substitute(it, clone)
		it.check = null		
	}
	
	
	def dispatch substitute(EObject owner, Check pre, Check post) {}
	
	def dispatch substitute(If owner, Check pre, Check post) {
		if ( owner.check == pre ) owner.check = post
		post
	} 
	
	
	
	// INLINE REACTION EFFECTS

	def void inlineReactionEffects(ExecutionFlow flow) {
		flow.states.forEach( state | state.inlineReactionEffects )
	}
	
	
	def inlineReactionEffects(ExecutionState state) {
		val effects = state.reactions.map(r | r.effect).toList
		effects.forEach( e | e.inline )
		state
	}
	
	
	// INLINE ENTRY AND EXIT ACTIONS

	def inlineEntryAndExitActions(ExecutionFlow flow) {
		flow.states.forEach( state | state.entryAction.inline )
		flow.states.forEach( state | state.exitAction.inline )
	}
		
	


	// GENERIC STEP INLINING
	
	def inline(Step step) {
		if ( step !== null ) {
			val List<Call> calls = new ArrayList<Call>()
			calls.addAll( step.caller )
			
			for ( caller : calls ) {
				val clone = step.stepCopy
				if ( caller.eContainer.substituteCall(caller, clone) )
					caller.step = null
				else System::out.println("Did not substitute '" + step + "' call from '"+caller.eContainer+"'.");
			}		
		}
		step
	}
	

	def inline(Call it) {
		val clone = step.stepCopy
		if ( it.eContainer.substituteCall(it, clone) )
			step = null
		else System::out.println("Did not substitute '" + step + "' call from '"+ eContainer+"'.");
	}
	

	
	// CALL SUBSTITUTION
	def dispatch boolean substituteCall(EObject owner, Call pre, Step post) { false }

	def dispatch boolean substituteCall(StateCase owner, Call pre, Step post) {
		if (owner.step == pre) {
			owner.step = post
			return true
		}
		return false
	}

	def dispatch boolean substituteCall(HistoryEntry owner, Call pre, Step post) {
		if (owner.initialStep == pre) {
			owner.initialStep = post
			return true
		}
		if (owner.historyStep == pre) {
			owner.historyStep = post
			return true
		}
		return false
	}

	def dispatch boolean substituteCall(Sequence owner, Call call, Step step) {
		if ( owner.steps.contains(call) ) { 
			if ( step !== null )
				owner.steps.set(owner.steps.indexOf(call), step)
			else 
				owner.steps.remove(owner.steps.indexOf(call))
			return true
		}
		
		return false
	} 
	
	
	def dispatch boolean substituteCall(If owner, Call call, Step step) {
		if ( owner.thenStep == call ) {
			owner.thenStep = step 
			return true
		} else if ( owner.elseStep == call ) {
			owner.elseStep = step
			return true
		}
		
		return false
	} 
	
	
	// we need to implement our own deep copy that handles bidirectional relations of Call and CheckRef correctly
	 
	def dispatch Step stepCopy(Step step) { EcoreUtil::copy(step) }
	
	def dispatch Step stepCopy(Sequence seq) {
		val _copy = sexecFactory.createSequence 
		_copy.name = seq.name
		_copy.comment = seq.comment
		_copy.steps.addAll( seq.steps.map( s | s.stepCopy ) )

		_copy
	}

	def dispatch Step stepCopy(If _if) {
		val _copy = sexecFactory.createIf
		_copy.name = _if.name
		_copy.comment = _if.comment
		_copy.check =  _if.check.stepCopy as Check
		_copy.thenStep = if (_if.thenStep !== null ) _if.thenStep.stepCopy else null
		_copy.elseStep = if (_if.elseStep !== null ) _if.elseStep.stepCopy else null

		_copy
	}
	
	def dispatch Step stepCopy(Call call) {
		val _copy = sexecFactory.createCall
		_copy.name = call.name
		_copy.comment = call.comment
		_copy.step =  call.step

		_copy
	}
	
	
	def dispatch Step stepCopy(CheckRef cref) {
		val _copy = sexecFactory.createCheckRef
		_copy.name = cref.name
		_copy.comment = cref.comment
		_copy.check =  cref.check

		_copy
	}
	def dispatch Step stepCopy(HistoryEntry cref) {
		val _copy = sexecFactory.createHistoryEntry
		_copy.name = cref.name
		_copy.comment = cref.comment
		_copy.deep =  cref.deep
		_copy.region =  cref.region
		_copy.initialStep =  cref.initialStep?.stepCopy
		_copy.historyStep =  cref.historyStep.stepCopy

		_copy
	}
	
	def dispatch Step stepCopy(StateSwitch _switch) {
		val _copy = sexecFactory.createStateSwitch
		_copy.name = _switch.name
		_copy.comment = _switch.comment
		_copy.stateConfigurationIdx = _switch.stateConfigurationIdx
		_copy.cases.addAll( _switch.cases.map( c | c.caseCopy ))
		
		_copy
	}
	
	def StateCase caseCopy(StateCase _case) {
		val _copy = sexecFactory.createStateCase
		_copy.state = _case.state
		_copy.step = _case.step.stepCopy
		
		_copy
	}	
	

	//--------- UTILS ---------------
	def sexecFactory() { SexecFactory::eINSTANCE }
	def sgraphFactory() { SGraphFactory::eINSTANCE }
	def stextFactory() { StextFactory::eINSTANCE }

}