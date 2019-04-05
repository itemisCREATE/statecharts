/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 *  axel terfloth - itemis AG
 */
package org.yakindu.sct.model.sexec.transformation.ng

import org.yakindu.sct.model.sgraph.Entry
import com.google.inject.Inject
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import com.google.inject.Singleton
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder

@Singleton class EntryNodeMethods {
	
	@Inject extension SgraphExtensions sgraph
	@Inject extension RegionType rType
	@Inject extension StateType
	@Inject extension TypeBuilder tBuilder
	@Inject extension ExpressionBuilder expBuilder
	@Inject extension EnterSequence

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
	
	def protected initalEntryReactions(Entry entry) {
		entry.enterTargets
	}
	
	def protected shallowHistoryReactions(Entry entry) {
		_block // TODO
	}
	
	def protected deepHistoryReactions(Entry entry) {
		_block // TODO
	}
	
	def protected enterTargets(Entry entry) {
		// TODO: this is very simplified, see also ReactionBuilder.createEntrySequence(Entry)
		val targetState = entry.target
		targetState.type.defaultEnterSequence._call
	}
	
}