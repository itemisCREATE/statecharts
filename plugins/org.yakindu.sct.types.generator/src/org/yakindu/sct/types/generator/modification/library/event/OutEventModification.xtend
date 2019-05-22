/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator.modification.library.event

import com.google.inject.Inject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.expressions.util.ContainmentExtensions
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.types.Event
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.Visibility
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sequencer.util.SequencerAnnotationLibrary
import org.yakindu.sct.types.generator.annotation.CoreGeneratorAnnotationLibrary
import org.yakindu.sct.types.generator.modification.library.ModificationHelper
import org.yakindu.sct.types.modification.util.ReferenceExtension

class OutEventModification extends BaseEventModification {

	@Inject protected extension RaiseEventModification
	@Inject protected extension ValueOfEventModification
	@Inject protected extension ClearEventModification
	@Inject protected extension ModificationHelper
	@Inject protected extension SequencerAnnotationLibrary
	@Inject protected extension CoreGeneratorAnnotationLibrary
	
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
			
			val op = _op(nameEventRaiser(e.name))._param("value", e.type) => [
				body = _block(
					assign(prop, true),
					assign(valueProp, it.parameters.head._ref)
				)
				visibility = Visibility.PROTECTED
			]
			
			val valueGetter = _op(nameEventValueGetter(e.name), e.type) => [
				body = _block(
					_return(valueProp._ref)
				)
			]
			e.eContainer.add(valueGetter)
			e.eContainer.add(op)

			modifyRaiseEvent(op, e)
		} else {
			val op = operation(nameEventRaiser(e.name), assign(prop, true)) => [
				visibility = Visibility.PROTECTED
			]
			e.eContainer.add(op)
			modifyRaiseEvent(op, e)
		}
		modifyClearEvent(prop, e)
		
		val op = operation(nameEventIsRaised(e.name), ts.getType(ITypeSystem.BOOLEAN), prop.returnExpression)
		op._annotateWith(APIAnnotation)
		e.eContainer.add(op)

		e.references.forEach[retargetTo(prop)]
		EcoreUtil.remove(e)
	}
}
