/** 
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.base.expressions.interpreter

import java.util.function.Supplier
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.Expression
import org.yakindu.base.base.NamedElement

/** 
 * @author Thomas Kutz - Initial API and contribution
 */
class SlotResolutionExceptionSupplier implements Supplier<IllegalStateException> {
	Expression exp

	new(Expression exp) {
		this.exp = exp
	}

	def static SlotResolutionExceptionSupplier forContext(Expression exp) {
		return new SlotResolutionExceptionSupplier(exp)
	}

	override IllegalStateException get() {
		return new IllegalSlotResolutionException('''Could not resolve execution slot for expression «exp.toText»''')
	}

	def dispatch String toText(FeatureCall call) {
		call.owner.toText + "." + (call.feature as NamedElement).name
	}

	def dispatch String toText(ElementReferenceExpression exp) {
		exp.reference.toText
	}

	def dispatch String toText(NamedElement exp) {
		exp.name
	}

	def dispatch String toText(Expression exp) {
		val node = NodeModelUtils.getNode(exp)
		return if(node !== null) node.text.trim else exp.toString
	}

	static class IllegalSlotResolutionException extends IllegalStateException {
		new(String msg) {
			super(msg)
		}
	}

}
