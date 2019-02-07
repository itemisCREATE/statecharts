/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.genmodel.typesystem;

import org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression;
import org.yakindu.base.expressions.inferrer.ExpressionsTypeInferrer;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenTypeInferrer extends ExpressionsTypeInferrer {

	@Override
	public InferenceResult doInfer(NumericalAddSubtractExpression e) {
		InferenceResult result1 = inferTypeDispatch(e.getLeftOperand());
		InferenceResult result2 = inferTypeDispatch(e.getRightOperand());
		assertCompatible(result1, result2, String.format(ARITHMETIC_OPERATORS, e.getOperator(), result1, result2));
		return getCommonType(inferTypeDispatch(e.getLeftOperand()), inferTypeDispatch(e.getRightOperand()));
	}
}
