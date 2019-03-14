package org.yakindu.sct.model.sexec.transformation.ng

import org.yakindu.sct.model.sgraph.Entry
import com.google.inject.Inject
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import com.google.inject.Singleton

@Singleton class EntryNodeMethods {
	
	@Inject extension SgraphExtensions sgraph
	@Inject extension RegionType rType
	@Inject extension TypeBuilder tBuilder

	def create _op reaction(Entry entry) {
		it => [ 
			name = entry.reactionName
			entry.region.type.features += it
		]
	}
	
	def reactionName(Entry entry) {
		"entryreact_" + if (entry.name.isNullOrEmpty) "default"
					else entry.name
	}
}