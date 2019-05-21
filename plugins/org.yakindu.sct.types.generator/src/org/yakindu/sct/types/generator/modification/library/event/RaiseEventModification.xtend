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
import org.yakindu.sct.types.generator.modification.library.ModificationHelper

/**
 * Transforms <code>raise e</code> into <code>raise_e()</code>.
 */
class RaiseEventModification {

	@Inject extension ExpressionBuilder
	@Inject extension ExpressionExtensions
	@Inject extension ModificationHelper

	def modifyRaiseEvent(Operation op, Event e) {
		for (raise : e.raiseExpressions) {
			EcoreUtil.replace(raise, getRaiseCall(op, raise))
		}
	}

	protected def getRaiseCall(Operation op, EventRaisingExpression raise) {
		if (raise.value !== null) {
			op.ownerInstance._ref._fc(op, raise.value)
		} else {
			op.ownerInstance._ref._fc(op)
		}
	}

	protected def List<EventRaisingExpression> getRaiseExpressions(Event e) {
		EcoreUtil2.getRootContainer(e).eAllContents.filter(EventRaisingExpression).filter [
			event.featureOrReference.equals(e)
		].toList
	}

}
