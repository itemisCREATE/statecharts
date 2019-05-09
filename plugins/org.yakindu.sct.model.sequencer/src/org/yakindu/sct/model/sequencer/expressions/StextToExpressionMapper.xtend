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
package org.yakindu.sct.model.sequencer.expressions

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.types.Expression
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression

class StextToExpressionMapper {
	
	@Inject extension StatemachineExpressionBuilder
	
	def dispatch replaceStextExpressions(Expression exp, Statechart sc) { 
		exp.eAllContents.forEach[doReplace(sc)]
		exp
	}
	
	def dispatch replaceStextExpressions(ActiveStateReferenceExpression asr, Statechart sc) { 
		sc._isStateActive(asr.value)
	}
	
	protected def dispatch doReplace(EObject e, Statechart sc) { }
	
	protected def dispatch doReplace(ActiveStateReferenceExpression asr, Statechart sc) {
		EcoreUtil.replace(asr, sc._isStateActive(asr.value))
	}
}
