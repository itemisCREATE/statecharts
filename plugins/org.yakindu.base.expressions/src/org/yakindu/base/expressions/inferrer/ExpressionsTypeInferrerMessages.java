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
package org.yakindu.base.expressions.inferrer;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface ExpressionsTypeInferrerMessages {

	public static final String LOGICAL_OPERATOR = "Logical operator '%s' may only be applied on boolean types, not on %s.";
	public static final String LOGICAL_OPERATORS = "Logical operator '%s' may only be applied on boolean types, not on %s and %s.";
	public static final String COMPARSION_OPERATOR = "Comparison operator '%s' may only be applied on compatible types, not on %s and %s.";
	public static final String BITWISE_OPERATOR = "Bitwise operator '%s' may only be applied on integer types, not on %s.";
	public static final String BITWISE_OPERATORS = "Bitwise operator '%s' may only be applied on integer types, not on %s and %s.";
	public static final String ASSIGNMENT_OPERATOR = "Assignment operator '%s' may only be applied on compatible types, not on %s and %s.";
	public static final String ARITHMETIC_OPERATOR = "Arithmetic operator '%s' may only be applied on numeric types, not on %s.";
	public static final String ARITHMETIC_OPERATORS = "Arithmetic operator '%s' may only be applied on numeric types, not on %s and %s.";
	public static final String COMMON_TYPE = "Could not determine a common type for %s and %s.";
	public static final String CONDITIONAL_BOOLEAN = "conditional expression must be of type boolean.";
	public static final String CAST_OPERATORS = "Cannot cast from %s to %s.";
	public static final String INCOMPATIBLE_TYPES = "Incompatible types %s and %s.";
	public static final String VARIABLE_VOID_TYPE = "'void' is an invalid type for variables";

}
