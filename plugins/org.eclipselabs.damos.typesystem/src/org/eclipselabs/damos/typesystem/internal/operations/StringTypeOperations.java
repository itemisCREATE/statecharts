/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.typesystem.internal.operations;

import org.eclipselabs.damos.typesystem.DataType;
import org.eclipselabs.damos.typesystem.StringType;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>String Type</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.typesystem.StringType#isAssignableFrom(org.eclipselabs.damos.typesystem.DataType) <em>Is Assignable From</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StringTypeOperations extends DataTypeOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringTypeOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  boolean isAssignableFrom(StringType stringType, DataType other) {
		return other instanceof StringType;
	}

} // StringTypeOperations