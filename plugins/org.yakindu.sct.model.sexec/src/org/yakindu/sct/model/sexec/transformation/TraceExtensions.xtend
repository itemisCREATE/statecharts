package org.yakindu.sct.model.sexec.transformation

import org.yakindu.sct.model.sexec.Reaction
import org.yakindu.sct.model.sexec.ExecutionNode
import org.yakindu.sct.model.sexec.ExecutionState
import com.google.inject.Inject
import com.google.inject.name.Named

class TraceExtensions {
	
	@Inject extension SexecExtensions sexec
	
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
	 
}