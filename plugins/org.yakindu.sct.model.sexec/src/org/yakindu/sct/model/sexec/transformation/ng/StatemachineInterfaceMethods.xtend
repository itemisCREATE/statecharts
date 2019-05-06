package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Event
import org.yakindu.base.types.Visibility
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import com.google.inject.Singleton

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
