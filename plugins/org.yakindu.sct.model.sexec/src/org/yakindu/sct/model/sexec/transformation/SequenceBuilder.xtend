package org.yakindu.sct.model.sexec.transformation

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.State
import com.google.inject.Inject
import com.google.inject.name.Named
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.ExecutionRegion
import java.util.List
import org.yakindu.sct.model.sgraph.RegularState
import java.util.ArrayList
import org.yakindu.sct.model.sexec.StateSwitch

class SequenceBuilder {
	
	@Inject extension SgraphExtensions sgraph
	@Inject extension SexecExtensions sexec
	@Inject extension SexecElementMapping mapping
	@Inject extension TraceExtensions trace
	
	@Inject @Named("ADD_TRACES") 
	boolean _addTraceSteps 
	
	
		/**
	 * Defines the enter sequences of all states
	 */
	def void defineStateEnterSequences(ExecutionFlow flow, Statechart sc) {
		
		// iterate over all regions
		for ( r : sc.regions) defineStateEnterSequence(r)
	}
	

	def dispatch void defineStateEnterSequence(Region r) {
		
		// process all vertices of a region
		for ( s : r.vertices) defineStateEnterSequence(s)
	}
	

	def dispatch void defineStateEnterSequence(Vertex v) {
	}	
	
	
	def dispatch void defineStateEnterSequence(FinalState state) {
		val execState = state.create
		val seq = sexec.factory.createSequence
		seq.name = "enterSequence"
		seq.comment = "Default enter sequence for state " + state.name
		if (execState.entryAction != null) seq.steps.add(execState.entryAction.newCall)
		
		if ( _addTraceSteps ) seq.steps += execState.newTraceStateEntered
		
		seq.steps += execState.newEnterStateStep
		execState.enterSequence = seq
	}	
	
	
	
	def dispatch void defineStateEnterSequence(State state) {
		
		val execState = state.create
		val seq = sexec.factory.createSequence
		seq.name = "enterSequence"
		seq.comment = "Default enter sequence for state " + state.name
		if (execState.entryAction != null) seq.steps.add(execState.entryAction.newCall)
		
		if ( _addTraceSteps ) seq.steps += execState.newTraceStateEntered
		
		if ( execState.leaf ) {
			
			seq.steps += execState.newEnterStateStep
					
		} else {
	
			for ( r : state.regions ) {
				defineStateEnterSequence(r)
				
				seq.addEnterRegion(r)
			} 
		}

		execState.enterSequence = seq
	}
	
	
	def dispatch addEnterRegion(Sequence seq, Region r) {
		val entryState = r.entry?.target?.create
					
		if (entryState != null && entryState.enterSequence != null) 
				seq.steps.add(entryState.enterSequence.newCall);
	}
	
	// TODO: refactor - don't access source element...
	def dispatch addEnterRegion(Sequence seq, ExecutionRegion r) {
		val entryState = (r.sourceElement as Region).entry?.target?.create
					
		if (entryState != null && entryState.enterSequence != null) 
				seq.steps.add(entryState.enterSequence.newCall);
	}
	
	
	
		/**
	 * Defines the exit sequences of all states
	 */
	def void defineStateExitSequences(ExecutionFlow flow, Statechart sc) {
		
		// iterate over all regions
		for ( r : sc.regions) defineStateExitSequence(r)
	}
		

	def dispatch void defineStateExitSequence(Region r) {
		
		// process all states of a region
		for ( s : r.vertices ) defineStateExitSequence(s)
	}
	
	def dispatch void defineStateExitSequence(Vertex v) {}
	
	def dispatch void defineStateExitSequence(FinalState s) {
		val execState = s.create
		val seq = sexec.factory.createSequence
		seq.name = "exitSequence"
		seq.comment = "Default exit sequence for final state."
		seq.steps += execState.newExitStateStep
				
		if ( _addTraceSteps ) seq.steps += execState.newTraceStateExited
		
		execState.exitSequence = seq
	}
	
	// TODO : refactor
	def dispatch void defineStateExitSequence(State state) {
		
		val execState = state.create
		val seq = sexec.factory.createSequence
		seq.name = "exitSequence"
		seq.comment = "Default exit sequence for state " + state.name

		if ( execState.leaf ) {
			
			seq.steps += execState.newExitStateStep
					
		} else {

			// first enforce calculation of all child exit sequences
			state.regions.forEach( r | { r.defineStateExitSequence null })

			// collect leaf states
			val List<RegularState> leafStates = state.collectLeafStates(new ArrayList<RegularState>())
			val sVector = execState.stateVector
	
			for ( i: sVector.offset .. sVector.offset + sVector.size - 1 ) {
						
				// create a state switch for each state configuration vector position
				var StateSwitch sSwitch = state.defineExitSwitch(leafStates, i)
				seq.steps.add(sSwitch);

			}
			
			
		}

		if (execState.exitAction != null) seq.steps.add(execState.exitAction.newCall)
		
		if ( _addTraceSteps ) seq.steps += execState.newTraceStateExited
		
		execState.exitSequence = seq
	}
	
	
	
	def StateSwitch defineExitSwitch(State state, List<RegularState> states, int pos) {

		// create a state switch
		var StateSwitch sSwitch = sexec.factory.createStateSwitch
		sSwitch.stateConfigurationIdx = pos
		sSwitch.comment = "Handle exit of all possible states on position " + sSwitch.stateConfigurationIdx + "..."
						
		val List<RegularState> posStates = states.filter( rs | rs.create.stateVector.size == 1 && rs.create.stateVector.offset == pos).toList					
		
		// create a case for each leaf state				
		for ( s : posStates ) {

			val caseSeq = sexec.factory.createSequence
			caseSeq.steps += s.create.exitSequence.newCall
			val es = s.create


			val exitStates = s.parentStates
			exitStates.removeAll(state.parentStates)
			exitStates.remove(s)
			
			// include exitAction calls up to the direct child level.
			exitStates.fold(caseSeq , [ cs, exitState | {
				if (es.stateVector.last == exitState.create.stateVector.last) {
					if (exitState.create.exitAction != null) cs.steps.add(exitState.create.exitAction.newCall)
					if ( _addTraceSteps ) cs.steps.add(exitState.create.newTraceStateExited)				
				}
				cs
			}]) 
			
			if (s.create.exitSequence != null) sSwitch.cases.add(s.create.newCase(caseSeq))
			
		}
		
		return sSwitch
	}
	
	
	
	def defineStatechartEnterSequence(ExecutionFlow flow, Statechart sc) {

		val enterSequence = sexec.factory.createSequence
		enterSequence.name = "enter"
		enterSequence.comment = "Default enter sequence for statechart " + sc.name
		
		for ( r : sc.regions) {
			enterSequence.addEnterRegion(r)
			
		} 
		
		flow.enterSequence = enterSequence
		return enterSequence
	}
	
	
	
	
}