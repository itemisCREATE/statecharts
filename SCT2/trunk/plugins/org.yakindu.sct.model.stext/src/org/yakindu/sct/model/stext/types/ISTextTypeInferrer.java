/**
 * Copyright (c) 2012 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.types;

import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.types.ITypeSystem.InferenceResult;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import com.google.inject.ImplementedBy;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author Alexander Nyßen - Adopted to changes in type system
 * 
 */
@ImplementedBy(STextDefaultTypeInferrer.class)
public interface ISTextTypeInferrer {
	
	/**
	 * Infers the type for a given {@link Expression}
	 * 
	 */
	InferenceResult inferType(Expression e);
	
	InferenceResult inferType(VariableDefinition d);
	
	InferenceResult inferType(EventDefinition d);
	
}
