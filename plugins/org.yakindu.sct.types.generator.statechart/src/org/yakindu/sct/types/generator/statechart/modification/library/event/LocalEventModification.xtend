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

class LocalEventModification extends BaseEventModification{
	
	@Inject protected extension RaiseEventModification
	@Inject protected extension ClearEventModification
	@Inject protected extension ValueOfEventModification
	
	@Inject protected extension ContainmentExtensions
	@Inject protected extension ReferenceExtension
	
	override modifyLocalEvent(Event e) {
		val prop = createEventFlag(e)
		e.eContainer.add(prop)
		
		if (e.hasPayload) {
			val valueProp = createEventValueProp(e)
			e.eContainer.add(valueProp)
			modifyValueOfEvent(valueProp, e)
			
			modifyRaiseEvent(prop, valueProp, e)
		} else {
			modifyRaiseEvent(prop, e)
		}
		
		modifyClearEvent(prop, e)
		
		e.references.forEach[retargetTo(prop)]
		EcoreUtil.remove(e)
	}
	
}