/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.inferrer;

import static org.yakindu.base.types.typesystem.ITypeSystem.BOOLEAN;
import static org.yakindu.base.types.typesystem.ITypeSystem.INTEGER;
import static org.yakindu.base.types.typesystem.ITypeSystem.VOID;

import org.yakindu.base.expressions.inferrer.ExpressionsTypeInferrer;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression;
import org.yakindu.sct.model.stext.stext.Guard;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class STextTypeInferrer extends ExpressionsTypeInferrer {

	public static final String GUARD = "The evaluation result of a guard expression must be of type boolean.";
	public static final String TIME_SPEC = "The evaluation result of a time expression must be of type integer.";

	public InferenceResult doInfer(Guard e) {
		InferenceResult result = inferTypeDispatch(e.getExpression());
		assertIsSubType(result, getResultFor(BOOLEAN), GUARD);
		return result;
	}

	public InferenceResult doInfer(TimeEventSpec e) {
		InferenceResult result = inferTypeDispatch(e.getValue());
		assertIsSubType(result, getResultFor(INTEGER), TIME_SPEC);
		return inferTypeDispatch(result.getType());
	}

	public InferenceResult doInfer(Scope scope) {
		return getResultFor(VOID);
	}

	public InferenceResult doInfer(ActiveStateReferenceExpression e) {
		return getResultFor(BOOLEAN);
	}
}
