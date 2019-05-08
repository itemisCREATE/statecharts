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
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.Visibility
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sequencer.util.ArrayTypeExtensions
import org.yakindu.sct.model.sequencer.util.SgraphExtensions
import org.yakindu.sct.model.sequencer.vectors.HistoryVector
import org.yakindu.sct.model.sequencer.vectors.StateVector
import org.yakindu.sct.model.sgraph.Statechart

@Singleton class StatemachineProperties {
	
	@Inject extension StatemachinePublic
	@Inject extension SgraphExtensions
	@Inject extension StateVector
	@Inject extension HistoryVector
	
	@Inject extension TypeBuilder
	@Inject extension ExpressionBuilder
	@Inject extension ArrayTypeExtensions
	
	extension TypesFactory typesFactory = TypesFactory.eINSTANCE
	
	def defineProperties(ComplexType it, Statechart sc) {
		it.features += stateVectorProperty(sc)
		if (sc.requireHistory) {
			it.features += historyVectorProperty(sc)
		}
		it.features += nextStateIndex(sc)
	}
	
	def create createProperty nextStateIndex(Statechart sc) {
		name = "nextStateIndex"
		_type(ITypeSystem.INTEGER)
		visibility = Visibility.PROTECTED
	}
	
	def create createProperty stateVectorProperty(Statechart sc) {
		name = "stateVector"
		typeSpecifier = _array._of(sc.statesEnumeration)
		visibility = Visibility.PROTECTED
		
		val size = sc.stateVector.size
		initialValue = _array._ref._fc(_array._new, size._int)
	}
	
	def create createProperty historyVectorProperty(Statechart sc) {
		name = "historyStateVector"
		typeSpecifier = _array._of(sc.statesEnumeration)
		visibility = Visibility.PROTECTED
		
		val size = sc.historyVector.size
		initialValue = _array._ref._fc(_array._new, size._int)
	}
	
}
