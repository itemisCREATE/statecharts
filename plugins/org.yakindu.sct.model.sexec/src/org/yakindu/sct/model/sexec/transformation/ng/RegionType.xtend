package org.yakindu.sct.model.sexec.transformation.ng

import org.yakindu.base.types.TypesFactory
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import com.google.inject.Inject
import org.yakindu.sct.model.sgraph.Region
import com.google.inject.Singleton
import org.yakindu.sct.model.sgraph.CompositeElement

@Singleton class RegionType {

	extension TypesFactory tFactory = TypesFactory.eINSTANCE
	@Inject extension TypeBuilder tBuilder
	@Inject extension StatemachinePublic smPublic
	@Inject extension SgraphExtensions sgraph
	@Inject extension StateType stateType

	def create createComplexType type(Region region) {
		it => [
			name = region.typeName
			if (region.parentState === null) region.statechart.statemachineType.features += it
			else region.parentState.type
		]
	}

	def typeName(Region region) {
		if (region.name.nullOrEmpty) {
			val container = region.eContainer as CompositeElement
			val index = container.regions.indexOf(region)
			return "region"+index
		} else {
			return region.name
		}
	}
}