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

import com.google.inject.Inject
import com.google.inject.name.Named
import org.yakindu.sct.model.sexec.ExecutionNode
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Reaction
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sgraph.RegularState


class TraceExtensions {
	
	@Inject extension SexecExtensions sexec
	@Inject extension SexecElementMapping mapping

	@Inject
	@Named("ADD_TRACES") 
	boolean _addTraceSteps
	
	def isAddTraceSteps() {
		_addTraceSteps
	}
	
	def newTraceReactionFired(Reaction r) {
		val rf = sexec.factory.createReactionFired
		rf.reaction = r
		rf
	}

	def newTraceReactionWillFire(Reaction r) {
		val rf = sexec.factory.createTraceReactionWillFire
		rf.reaction = r
		rf
	}
	
	def newTraceNodeExecuted(ExecutionNode node) {
		val t = sexec.factory.createTraceNodeExecuted
		t.node = node
		t
	}
	
	
	def newTraceStateEntered(ExecutionState state) {
		val t = sexec.factory.createTraceStateEntered
		t.state = state
		t
	}
	
	def newTraceStateExited(ExecutionState state) {
		val t = sexec.factory.createTraceStateExited
		t.state = state
		t
	}

	def traceStateExited(Sequence seq, ExecutionState state) {
		if (addTraceSteps) {
			seq.steps.add(state.newTraceStateExited)
		}
	}

	def traceStateExited(Sequence seq, RegularState state) {
		if (addTraceSteps) {
			traceStateExited(seq, state.create)
		}
	}
	 
}