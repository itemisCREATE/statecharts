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
import org.yakindu.base.types.typesystem.ITypeValueProvider
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping
import org.yakindu.sct.model.sexec.transformation.SexecExtensions
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.TraceExtensions
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.sct.model.sgraph.CompositeElement
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sexec.ExecutionFlow

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
	@Inject extension EnterSequence scopeOperations
	@Inject extension StatemachinePublic smPublic
	@Inject extension StateType stateType
	@Inject extension RegionType regionType
	@Inject extension EntryNodeMethods enMethods

//	@Inject(optional=true)
//	@Named(IModelSequencer.ADD_TRACES)
//	boolean _addTraceSteps = false


	override defineStatechartEnterSequence(ExecutionFlow flow, Statechart sc) {
		val res =super.defineStatechartEnterSequence(flow, sc)
		
		//if(flow.entryAction !== null) enterSequence.steps.add(flow.entryAction.newCall)
		val enterOperation = sc.statemachineType.enterSequence(DEFAULT_SEQUENCE_NAME)
		enterOperation.body = _block(
			sc.regions
				.map[type.defaultEnterSequence].filterNull
				.map[regionEnter | regionEnter._call]
		)
		res
	}

	override dispatch void defineScopeEnterSequences(Region r) {
		super._defineScopeEnterSequences(r)

//		// process all vertices of a region
//		for (s : r.vertices)
//			defineScopeEnterSequences(s)
		// create an enter sequence for each contained entry
		for (e : r.collectEntries) {
			val seqName = if(e.name.nullOrEmpty) DEFAULT_SEQUENCE_NAME else e.name

			r.type.enterSequence(seqName) => [
				_comment("'" + seqName + "' enter sequence for region " + r.type.name)
				body = _block(e.reaction._call)
			]
		}
	}

	override dispatch void defineScopeEnterSequences(FinalState state) {

		super._defineScopeEnterSequences(state) // TODO: remove
		state.defineEnterSequence(DEFAULT_SEQUENCE_NAME)
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
			state.defineEnterSequence(epName)
		}

	}

	def defineEnterSequence(RegularState state, String epName) {
		val op = state.type.enterSequence(epName) => [
			_comment("Default enter sequence for state " + state.name)
			val block = _block(
				state.entryAction?._call
			// TODO if(_addTraceSteps) execState.newTraceStateEntered else null
			)

			if (state.leaf)
				block.expressions += state._enterState
			else
				for (r : (state as CompositeElement).regions) {
					var regionEnter = r.type.resolveEnterSequence(epName)

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
