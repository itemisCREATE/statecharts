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
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Event
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.Visibility
import org.yakindu.base.types.typesystem.ITypeSystem

@Singleton
class StatemachineInterfaceMethods {

	@Inject extension TypeBuilder
	@Inject extension ExpressionBuilder

	def create _op clearOutEvents(ComplexType ct) {
		name = "clearOutEvents"
		_type(ITypeSystem.VOID)
		visibility = Visibility.PROTECTED
		body = _block(
			ct.outEvents.map[_clearEvent]
		)
	}
	
	def create _op clearEvents(ComplexType ct) {
		name = "clearEvents"
		_type(ITypeSystem.VOID)
		visibility = Visibility.PROTECTED
		body = _block(
			ct.inEvents.map[_clearEvent]
			// TODO: also clear time events?
		)
	}
	
	def outEvents(ComplexType ct) {
		ct.features.filter(Event).filter[direction == Direction.OUT]
	}
	
	def inEvents(ComplexType ct) {
		ct.features.filter(Event).filter[direction == Direction.IN]
	}
	
	
}
