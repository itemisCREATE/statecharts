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
package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import com.google.inject.name.Named
import org.yakindu.base.types.typesystem.ITypeValueProvider
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.transformation.IModelSequencer
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping
import org.yakindu.sct.model.sexec.transformation.SexecExtensions
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.TraceExtensions
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.State

class SequenceBuilder extends org.yakindu.sct.model.sexec.transformation.SequenceBuilder {

	@Inject extension SgraphExtensions sgraph
	@Inject extension SexecExtensions sexec
	@Inject extension SexecElementMapping mapping
	@Inject extension TraceExtensions trace

	@Inject extension ITypeValueProvider tvp
	@Inject extension TypeBuilder tBuilder
	@Inject extension ExpressionBuilder eBuilder
	@Inject extension StatemachineExpressionBuilder smeBuilder
	@Inject extension StatemachineProperties smProperties
	@Inject extension StateOperations stateOperations
	@Inject extension ScopeOperations scopeOperations
	@Inject extension StatemachinePublic smPublic
	@Inject extension StateType stateType

	
	

//	@Inject(optional=true)
//	@Named(IModelSequencer.ADD_TRACES)
//	boolean _addTraceSteps = false


	override dispatch void defineScopeEnterSequences(Region r) {
		val execRegion = r.create

		// process all vertices of a region
		for (s : r.vertices)
			defineScopeEnterSequences(s)

		// create an enter sequence for each contained entry
		for (e : r.collectEntries) {
			
			val seq = sexec.factory.createSequence
			seq.name = if (e.name.nullOrEmpty)
							DEFAULT_SEQUENCE_NAME
						else
							e.name
							
			seq.comment = "'" + seq.name + "' enter sequence for region " + r.name

			val entryNode = e.create
			if (entryNode !== null && entryNode.reactSequence !== null) {
				seq.steps.add(entryNode.reactSequence.newCall);
			}

			execRegion.enterSequences += seq
		}
	}

	override dispatch void defineScopeEnterSequences(FinalState state) {
		
		super._defineScopeEnterSequences(state) // TODO: remove
		
		
		val execState = state.create
		val op = _op => [
			name = DEFAULT_SEQUENCE_NAME	
			_comment("Default enter sequence for state " + state.name)
			body = _block(
				execState.entryActionOperation?._call,
//TODO				if(_addTraceSteps) execState.newTraceStateEntered else null,
				stateVector(state.statechart)._ref
					._get(state.create.stateVector.offset._int)
					._assign(stateVector(state.statechart)._ref._fc(state.enumerator))
			)
		] 
		state.type.features += op		
	}



	override dispatch void defineScopeEnterSequences(State state) {

		super._defineScopeEnterSequences(state) // TODO: remove
		
		val execState = state.create

		// first creates enter sequences for all contained regions
		state.regions.forEach(r|r.defineScopeEnterSequences)

		// get all entry point names used by incoming transitions
		val entryPointNames = state.incomingTransitions.map(t|t.entryPointName).toSet.toList

		// also include implicit entries by histories
		if (state.parentRegion.requireHistory) {
			if(!entryPointNames.contains('default')) entryPointNames.add('default')
		}

		// sort entry points by name ...
		entryPointNames.sortInplace

		// create an entry sequence for each entry point
		for (epName : entryPointNames) {
			val op = _op => [
				name = epName	
				_comment("Default enter sequence for state " + state.name)
				val block = _block(
					execState.entryActionOperation?._call
					//TODO if(_addTraceSteps) execState.newTraceStateEntered else null
				)
				
				if (execState.leaf) 
					block.expressions +=	state._enterState
				else 
					for (r : state.regions) {
						var regionEnter = r.create.resolveEnterSequenceOperation(epName)
	
						if (regionEnter !== null) {
							block.expressions += regionEnter._call
						}
					}

				// save the history on entering a state 
				val execRegion = state.parentRegion.create
				if (execRegion.historyVector !== null) {
					block.expressions += _saveHistory(state.parentRegion)
				}				
				
				body = block
			] 
			state.type.features += op		
		}

	}


	
	

}
