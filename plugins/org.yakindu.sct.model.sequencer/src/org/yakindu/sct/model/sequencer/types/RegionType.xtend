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
package org.yakindu.sct.model.sequencer.types

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.TypesFactory
import org.yakindu.sct.model.sequencer.util.SgraphExtensions
import org.yakindu.sct.model.sgraph.CompositeElement
import org.yakindu.sct.model.sgraph.Region

@Singleton class RegionType {

	extension TypesFactory tFactory = TypesFactory.eINSTANCE
	
	@Inject extension StatemachinePublic
	@Inject extension SgraphExtensions
	@Inject extension StateType

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
