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
import org.yakindu.sct.model.sgraph.Vertex

@Singleton class StateType {
	
	extension TypesFactory tFactory = TypesFactory.eINSTANCE
	
	@Inject extension RegionType
	@Inject extension org.yakindu.sct.model.sequencer.ModelSequencerNaming
	
	def create createComplexType type(Vertex state) {
		it => [
			name = state.typeName
			state.parentRegion.type.features += it
		]
	}
}
