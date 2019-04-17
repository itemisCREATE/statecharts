/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 *  axel terfloth - itemis AG
 */
package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.yakindu.base.types.Expression
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.sct.model.sexec.transformation.ng.reactions.EffectMapping
import org.yakindu.sct.model.sgraph.Entry
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.Statechart

@Singleton class EntryReactOperation {
	
	@Inject extension SgraphExtensions sgraph
	@Inject extension RegionType rType
	@Inject extension TypeBuilder tBuilder
	@Inject extension ExpressionBuilder expBuilder
	@Inject extension StatemachineProperties props
	@Inject extension HistoryVector
	@Inject extension StatemachinePublic
	@Inject extension EffectMapping
	@Inject extension EnterShallowOperation
	@Inject extension EnterDeepOperation

	def declareEntryReactOperations(Statechart sc) {
		sc.eAllContents.filter(Region).forEach[ r |
			r.collectEntries.forEach[ e |
				e.entryReactOperation
			]
		]
	}
	
	def defineEntryReactOperations(Statechart sc) {
		sc.eAllContents.filter(Region).forEach[ r |
			r.collectEntries.forEach[ e |
				e.defineEntryReactOperation
			]
		]
	}

	def create _op entryReactOperation(Entry entry) {
		name = entry.reactionName
		entry.region.type.features += it
	}
	
	def protected defineEntryReactOperation(Entry entry) {
		entry.entryReactOperation => [
			body = _block(entry.reactions)
		]
	}
	
	def reactionName(Entry entry) {
		"entryreact_" + if(entry.name.isNullOrEmpty) "default" else entry.name
	}
	
	def protected reactions(Entry entry) {
		switch(entry.kind) {
			case INITIAL: return entry.initalEntryReactions
			case SHALLOW_HISTORY: return entry.shallowHistoryReactions
			case DEEP_HISTORY: return entry.deepHistoryReactions
		}
	}
	
	def protected List<Expression> initalEntryReactions(Entry entry) {
		entry.createEntrySequence
	}
	
	
	def protected List<Expression> shallowHistoryReactions(Entry entry) {
		val sc = entry.statechart
		
		val reaction = 
		_if(props.historyVectorProperty(sc)._ref._get(entry.region.historyVector.offset._int)._notEquals(sc.statesEnumeration._ref._fc(sc.noState)))._then(
			_block(entry.region.enterShallow._call)
		)._else(
			_block(entry.createEntrySequence)
		)
		
		#[reaction]
	}
	
	def protected List<Expression> deepHistoryReactions(Entry entry) {
		val sc = entry.statechart
		
		val reaction = 
		_if(props.historyVectorProperty(sc)._ref._get(entry.region.historyVector.offset._int)._notEquals(sc.statesEnumeration._ref._fc(sc.noState)))._then(
			_block(entry.region.enterDeep._call)
		)._else(
			_block(entry.createEntrySequence)
		)
		
		#[reaction]
	}
	
	def protected createEntrySequence(Entry e) {
		val List<Expression> seq = newArrayList
		// transition effects
		val entryTransitionEffect = e?.transition?.effect
		if (entryTransitionEffect !== null) {
			seq += entryTransitionEffect.toEffectExpressions
		}
		
		// target enter
		val target = e.target
		if (target !== null && !e.outgoingTransitions.empty) { 
			seq += e.outgoingTransitions.mapToStateConfigurationEnterSequence
		}
		
		seq
	}
	
}