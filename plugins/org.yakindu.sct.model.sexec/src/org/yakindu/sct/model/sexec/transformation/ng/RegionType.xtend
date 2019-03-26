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
import org.yakindu.base.types.TypesFactory
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sgraph.CompositeElement
import org.yakindu.sct.model.sgraph.Region

@Singleton class RegionType {

	extension TypesFactory tFactory = TypesFactory.eINSTANCE
	@Inject extension StatemachinePublic smPublic
	@Inject extension SgraphExtensions sgraph
	@Inject extension StateType stateType

	def create createComplexType type(Region region) {
		it => [
			name = region.typeName
			if (region.parentState === null) region.statechart.statemachineType.features += it 
			else region.parentState.type.features += it
		]
	}

	def typeName(Region region) {
		if (region.name.nullOrEmpty) {
			val container = region.eContainer as CompositeElement
			val index = container.regions.indexOf(region)
			return "region" + index
		} else {
			return region.name
		}
	}
}