/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sequencer.operations

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Operation
import org.yakindu.base.types.TypeBuilder
import org.yakindu.sct.model.sequencer.expressions.StatemachineExpressionBuilder
import org.yakindu.sct.model.sequencer.expressions.TargetEntrySpec
import org.yakindu.sct.model.sequencer.types.RegionType
import org.yakindu.sct.model.sequencer.types.StateType
import org.yakindu.sct.model.sequencer.types.StatemachinePublic
import org.yakindu.sct.model.sequencer.util.SgraphExtensions
import org.yakindu.sct.model.sgraph.CompositeElement
import org.yakindu.sct.model.sgraph.Entry
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart

@Singleton class EnterOperation {

	@Inject extension TypeBuilder
	@Inject extension ExpressionBuilder
	
	@Inject extension StateType
	@Inject extension RegionType
	@Inject extension StatemachinePublic
	
	@Inject extension SgraphExtensions
	@Inject extension EntryReactOperation
	@Inject extension EntryActionOperation
	@Inject extension StatemachineExpressionBuilder
	
	def declareEnterOperations(Statechart sc) {
		// regions
		sc.eAllContents.filter(Region).map[toEntries].forEach[
			value.forEach[e | it.key.enterOperation(e)]
		]
		
		// states
		sc.eAllContents.filter(State).map[toEntries].forEach[
			value.forEach[e | it.key.enterOperation(e)]
		]
		
		// final states
		sc.eAllContents.filter(FinalState).map[toEntries].forEach[
			value.forEach[e | it.key.enterOperation(e)]
		]
		
		// statechart
		sc.enterOperation
	}
	
	def defineEnterOperations(Statechart sc) {
		// regions
		sc.eAllContents.filter(Region).map[toEntries].forEach[
			value.forEach[e | it.key.defineEnterOperation(e)]
		]
		
		// states
		sc.eAllContents.filter(State).map[toEntries].forEach[
			value.forEach[e | it.key.defineEnterOperation(e)]
		]
		
		// final states
		sc.eAllContents.filter(FinalState).map[toEntries].forEach[
			value.forEach[e | it.key.defineEnterOperation(e)]
		]
		
		sc.defineEnterOperation
	}
	
	def enterOperation(Region region, Entry entry){
		val entryName = if(entry.name.nullOrEmpty) 'default' else entry.name
		enterOperation(region, entryName)
	}
	
	def create op : _op enterOperation(Region region, String entryName){
		op.name = enterSequenceOperationName(entryName)
		region.type.features += op
	}
	
	def create op : _op enterOperation(RegularState state, String entryName) {
		op.name = enterSequenceOperationName(entryName)
		state.type.features += op
	}
	
	def create op : _op enterOperation(Statechart sc) {
		op.name = enterSequenceOperationName('default')
		sc.statemachineType.features += op
	}
	
	def defineEnterOperation(Region region, Entry entry) {
		region.enterOperation(entry) => [
			body = _block(entry.entryReactOperation._call)
		]
	}
	
	def defineEnterOperation(RegularState state, String entryName) {
		state.enterOperation(entryName) => [
			_comment("Default enter sequence for state " + state.name)
			val block = _block(
				state.entryActionOperation?._call
				// TODO if(_addTraceSteps) execState.newTraceStateEntered else null
			)

			if (state.leaf)
				block.expressions += state._enterState
			else
				for (r : (state as CompositeElement).regions) {
					var regionEnter = r.type.resolveEnterSequence(entryName)
					if (regionEnter !== null) {
						block.expressions += regionEnter._call
					}
				}

			// save the history on entering a state 
			if (state.parentRegion.requireHistory) {
				block.expressions += _saveHistory(state.parentRegion)
			}

			body = block
		]
	}
	
	def defineEnterOperation(Statechart sc) {
		sc.enterOperation => [
			body = _block(
				sc.regions
				.map[type.defaultEnterSequence].filterNull
				.map[regionEnter | regionEnter._call]
			)
		]
	}
	
	def protected toEntries(Region r) {
		return r -> r.collectEntries.toList
	}
	
	def protected toEntries(State s) {
		// get all entry point names used by incoming transitions
		val entryPointNames = s.incomingTransitions.map(t|t.entryPointName).toSet.toList

		// also include implicit entries by histories
		if (s.parentRegion.requireHistory) {
			if(!entryPointNames.contains('default')) entryPointNames.add('default')
		}
		entryPointNames.sortInplace
		
		return s -> entryPointNames
	}
	
	def protected toEntries(FinalState fs) {
		return fs -> #['default']
	}
	
	def resolveEnterSequence(ComplexType it, String entryName) {
		val op = enterSequenceByName(entryName)
		
		return 
			if (op !== null) op 
			else defaultEnterSequence
	}
	
	def resolveEnterSequence(TargetEntrySpec it) {
		target.toType?.resolveEnterSequence(entryPointName)
	}
	
	def dispatch toType(EObject it) { null }
	def dispatch toType(RegularState it) { type }
	def dispatch toType(Region it) { type }
	
	def defaultEnterSequence(ComplexType it) {
		enterSequenceByName('default')
	}

	def enterSequenceByName(ComplexType it, String entryName) {
		features.filter(Operation).findFirst[name == enterSequenceOperationName(entryName)]
	}

	def enterSequenceOperationName(String entryName) {
		"enter_" + entryName
	}
}
