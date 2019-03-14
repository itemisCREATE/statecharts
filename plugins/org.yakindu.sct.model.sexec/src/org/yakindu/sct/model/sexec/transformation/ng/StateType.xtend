package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.TypesFactory
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.sct.model.sgraph.RegularState

@Singleton class StateType {
	
	extension TypesFactory tFactory = TypesFactory.eINSTANCE
	@Inject extension TypeBuilder tBuilder
	@Inject extension StatemachinePublic smPublic
	@Inject extension SgraphExtensions sgraph
	@Inject extension RegionType regionType
	
	def create createComplexType type(RegularState state) {
		it => [
			name = state.name
			state.parentRegion.type.features += it
		]
	}
}