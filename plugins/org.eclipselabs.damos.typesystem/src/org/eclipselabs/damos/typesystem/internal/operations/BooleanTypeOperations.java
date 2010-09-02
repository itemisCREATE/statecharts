/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.typesystem.internal.operations;

import org.eclipselabs.damos.typesystem.BooleanType;
import org.eclipselabs.damos.typesystem.DataType;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Boolean Type</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.typesystem.BooleanType#isAssignableFrom(org.eclipselabs.damos.typesystem.DataType) <em>Is Assignable From</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BooleanTypeOperations extends DataTypeOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanTypeOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  boolean isAssignableFrom(BooleanType booleanType, DataType other) {
		return other instanceof BooleanType;
	}

} // BooleanTypeOperations