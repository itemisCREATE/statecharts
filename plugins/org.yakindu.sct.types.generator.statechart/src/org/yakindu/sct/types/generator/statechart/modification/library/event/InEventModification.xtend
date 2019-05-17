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
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sequencer.util.SequencerAnnotationLibrary
import org.yakindu.sct.types.generator.modification.library.ModificationHelper
import org.yakindu.sct.types.generator.statechart.annotation.SCTGeneratorAnnotationLibrary
import org.yakindu.sct.types.modification.util.ReferenceExtension

class InEventModification extends BaseEventModification {

	@Inject protected extension TypeBuilder
	@Inject protected extension ExpressionBuilder
	@Inject protected extension ContainmentExtensions
	@Inject protected extension ReferenceExtension
	@Inject protected extension ModificationHelper
	@Inject protected extension SequencerAnnotationLibrary
	@Inject protected extension SCTGeneratorAnnotationLibrary
	
	@Inject protected extension RaiseEventModification
	@Inject protected extension ClearEventModification
	@Inject protected extension ValueOfEventModification

	override modifyInEvent(Event e) {
		if (!e.hasPayload) {
			val prop = createEventFlag(e)
			e.eContainer.add(prop)
			
			val op = operation(nameEventRaiser(e.name), assign(_fc(e.ownerInstance._ref, prop), true))
			op._annotateWith(APIAnnotation)
			e.eContainer.add(op)
	
			modifyRaiseEvent(op, e)
			modifyClearEvent(prop, e)
	
			e.references.forEach[retargetTo(prop)]
			EcoreUtil.remove(e)
		}
		
		else {
			val prop = createEventFlag(e)
			e.eContainer.add(prop)
			
			val valueProp = createEventValueProp(e)
			e.eContainer.add(valueProp)

			val op = _op(nameEventRaiser(e.name), ITypeSystem.VOID)._param("value", e.type) => [
				body = _block(
					assign(_fc(e.ownerInstance._ref, prop), true),
					_assign(_fc(e.ownerInstance._ref, valueProp), it.parameters.last._ref)
				)
			]
			op._annotateWith(APIAnnotation)
			e.eContainer.add(op)
			
			modifyRaiseEvent(op, e)
			modifyClearEvent(prop, e)
			modifyValueOfEvent(valueProp, e)
	
			e.references.forEach[retargetTo(prop)]
			EcoreUtil.remove(e)
		}
		
	}

}
