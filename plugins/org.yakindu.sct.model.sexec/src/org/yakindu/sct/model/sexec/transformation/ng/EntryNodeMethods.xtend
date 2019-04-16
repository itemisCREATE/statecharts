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

@Singleton class EntryNodeMethods {
	
	@Inject extension SgraphExtensions sgraph
	@Inject extension RegionType rType
	@Inject extension TypeBuilder tBuilder
	@Inject extension ExpressionBuilder expBuilder
	
	@Inject extension EffectMapping

	def create _op reaction(Entry entry) {
		it => [ 
			name = entry.reactionName
			body = _block(entry.reactions)
			entry.region.type.features += it
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
		entry.createEntrySequence // TODO
	}
	
	def protected List<Expression> deepHistoryReactions(Entry entry) {
		entry.createEntrySequence // TODO
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