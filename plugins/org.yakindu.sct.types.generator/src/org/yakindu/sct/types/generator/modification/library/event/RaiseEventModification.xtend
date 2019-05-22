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
import java.util.List
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.expressions.expressions.EventRaisingExpression
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.expressions.util.ExpressionExtensions
import org.yakindu.base.types.Event
import org.yakindu.base.types.Operation

/**
 * Transforms <code>raise e</code> into <code>raise_e()</code>.
 */
class RaiseEventModification {

	@Inject extension ExpressionBuilder
	@Inject extension ExpressionExtensions

	def modifyRaiseEvent(Operation op, Event e) {
		for (raise : e.raiseExpressions) {
			EcoreUtil.replace(raise, getRaiseCall(op, raise))
		}
	}

	protected def getRaiseCall(Operation op, EventRaisingExpression raise) {
		if (raise.value !== null) {
			op._ref._with(raise.value)
		} else {
			op._ref
		}
	}

	protected def List<EventRaisingExpression> getRaiseExpressions(Event e) {
		EcoreUtil2.getRootContainer(e).eAllContents.filter(EventRaisingExpression).filter [
			event.featureOrReference.equals(e)
		].toList
	}

}
