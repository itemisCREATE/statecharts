/**
 * Copyright (c) 2014 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.base.expressions.inferrer;

import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.types.InferenceResult;

import com.google.inject.ImplementedBy;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@ImplementedBy(DefaultExpressionsTypeInferrer.class)
public interface IExpressionsTypeInferrer {

	/**
	 * Infers the type for a given {@link Expression}
	 * 
	 */
	InferenceResult inferType(Expression e);

}
