/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	itemis AG
*
*/
package org.yakindu.sct.types.generator.statechart.modification.library.event

import com.google.inject.Inject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.expressions.util.ContainmentExtensions
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.types.Event
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.Visibility
import org.yakindu.sct.types.generator.modification.library.ModificationHelper
import org.yakindu.sct.types.modification.util.ReferenceExtension

class LocalEventModification extends BaseEventModification{
	
	@Inject protected extension RaiseEventModification
	@Inject protected extension ClearEventModification
	@Inject protected extension ValueOfEventModification
	
	@Inject protected extension ContainmentExtensions
	@Inject protected extension ReferenceExtension
	@Inject protected extension ExpressionBuilder
	@Inject protected extension ModificationHelper
	
	@Inject protected extension TypeBuilder
	
	override modifyLocalEvent(Event e) {
		val prop = createEventFlag(e)
		e.eContainer.add(prop)
		
		if (e.hasPayload) {
			val valueProp = createEventValueProp(e)
			val op = _op(nameEventRaiser(e.name))._param("value", e.type) => [
				body = _block(
					assign(_fc(e.ownerInstance._ref, prop), true),
					assign(_fc(e.ownerInstance._ref, valueProp), it.parameters.head._ref)
				)
				visibility = Visibility.PROTECTED
			]
			e.eContainer.add(valueProp)
			e.eContainer.add(op)
			modifyValueOfEvent(valueProp, e)
			
			modifyRaiseEvent(op, e)
		} else {
			val op = operation(nameEventRaiser(e.name), assign(_fc(e.ownerInstance._ref, prop), true)) => [
				visibility = Visibility.PROTECTED
			]
			e.eContainer.add(op)
			modifyRaiseEvent(op, e)
		}
		
		modifyClearEvent(prop, e)
		
		e.references.forEach[retargetTo(prop)]
		EcoreUtil.remove(e)
	}
	
}
