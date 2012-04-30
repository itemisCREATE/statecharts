package org.yakindu.sct.model.sexec.transformation

import com.google.inject.Inject
import java.util.ArrayList
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionRegion
import org.yakindu.sct.model.sexec.ExecutionScope
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sgraph.Declaration
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition


class StructureMapping {
	 
	@Inject extension SexecElementMapping mapping
	@Inject extension StatechartExtensions sct
	
	
	//==========================================================================
	// DECLARATION SCOPE MAPPING
	//
	
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
	def dispatch Declaration map(OperationDefinition v) {
		val _v = v.create
		return _v
	}
	 
	
	//==========================================================================
	// REGULAR STATE MAPPING
	//

		
	def ExecutionFlow mapRegularStates(Statechart statechart, ExecutionFlow r){
		val allStates = statechart.allRegularStates
		r.states.addAll(allStates.map( s | s.mapState));
		return r
	}

	def dispatch ExecutionState mapState(FinalState state) {
		val _state = state.create
		_state.leaf = true
		_state.entryAction = null
		_state.exitAction = null
		return _state		
	}
	
	def dispatch ExecutionState mapState(State state) {
		val _state = state.create
		_state.leaf = state.simple
		return _state
	}
	 
	def dispatch ExecutionState mapState(RegularState state) {}

	
	//==========================================================================
	// REGION MAPPING
	//
	
	def ExecutionFlow mapRegions(Statechart statechart, ExecutionFlow flow){
		val allRegions = statechart.allRegions
		flow.regions.addAll( allRegions.map( r | r.mapRegion));
		return flow	
	}
	
	
	def ExecutionRegion mapRegion(Region region) {
		val _region = region.create
		
		if ( region.composite instanceof Statechart ) _region.superScope = (region.composite as Statechart).create
		else _region.superScope = (region.composite as State).create

		_region.subScopes.addAll( region.vertices.filter( typeof(RegularState) ).map( v | v.create as ExecutionScope ) )

		return _region
	}
	
	
	//==========================================================================
	// PSEUDO STATE MAPPING
	//

	def ExecutionFlow mapPseudoStates(Statechart statechart, ExecutionFlow r){
		r.nodes.addAll( statechart.allChoices.map( choice | choice.create ) );
		r.nodes.addAll( statechart.allEntries.map( entry | entry.create ) );
		return r
	}

	
	
	//==========================================================================
	// PSEUDO STATE MAPPING
	//
	
	/** Time trigger will be mapped to execution model time events for each real state. */
	def ExecutionFlow mapTimeEvents(Statechart statechart, ExecutionFlow r) {
		var content = EcoreUtil2::eAllContentsAsList(statechart)
		val allStates = content.filter(typeof(State))
		allStates.forEach( s | s.mapTimeEventSpecs)
		statechart.mapTimeEventSpecs
		return r
	}
	
	
	//==========================================================================
	// TIME EVENT MAPPING
	//
	
	def mapTimeEventSpecs(State state) {
		
		val timeEventSpecs = state.timeEventSpecs
		
		val result = new ArrayList<TimeEvent>();
		for (tes : timeEventSpecs ) {
			val timeEvent = tes.createDerivedEvent
			timeEvent.name = state.name + "_time_event_" + timeEventSpecs.indexOf(tes);
			state.statechart.create.timeEventScope.declarations.add(timeEvent);
			result.add(timeEvent);
			
		}	
		
		result
	}
	
	
	def mapTimeEventSpecs(Statechart statechart) {
		
		val timeEventSpecs = statechart.timeEventSpecs
		
		val result = new ArrayList<TimeEvent>();
		for (tes : timeEventSpecs ) {
			val timeEvent = tes.createDerivedEvent
			timeEvent.name = statechart.name + "_time_event_" + timeEventSpecs.indexOf(tes);
			statechart.create.timeEventScope.declarations.add(timeEvent);
			result.add(timeEvent);
			
		}	
		
		result
	}
	
}