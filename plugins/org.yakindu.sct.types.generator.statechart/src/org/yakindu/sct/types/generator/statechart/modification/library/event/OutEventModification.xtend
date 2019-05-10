/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package com.yakindu.sct.types.slang.generator.core.modifications.events

import com.google.inject.Inject
import com.yakindu.sct.types.slang.generator.core.modifications.ContainmentExtensions
import com.yakindu.sct.types.slang.generator.core.modifications.ReferenceExtension
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.types.Event
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.transformation.TypeBuilder

class OutEventModification extends BaseEventModification {

	@Inject protected extension RaiseEventModification
	@Inject protected extension ValueOfEventModification
	@Inject protected extension ClearEventModification
	
	@Inject protected extension ContainmentExtensions
	@Inject protected extension ReferenceExtension
	@Inject protected extension TypeBuilder
	@Inject protected extension ExpressionBuilder

	override modifyOutEvent(Event e) {
		val prop = createEventFlag(e)
		e.eContainer.add(prop)

		if (e.hasPayload) {
			val valueProp = createEventValueProp(e)
			e.eContainer.add(valueProp)
			modifyValueOfEvent(valueProp, e)
			
			val valueGetter = _op(nameEventValueGetter(e.name), e.type) => [
				body = _block(
					_return(valueProp._ref)
				)
			]
			e.eContainer.add(valueGetter)

			modifyRaiseEvent(prop, valueProp, e)
		} else {
			modifyRaiseEvent(prop, e)
		}
		modifyClearEvent(prop, e)

		val op = operation(nameEventIsRaised(e.name), ts.getType(ITypeSystem.BOOLEAN), prop.returnExpression)
		e.eContainer.add(op)

		e.references.forEach[retargetTo(prop)]
		EcoreUtil.remove(e)
	}
}
