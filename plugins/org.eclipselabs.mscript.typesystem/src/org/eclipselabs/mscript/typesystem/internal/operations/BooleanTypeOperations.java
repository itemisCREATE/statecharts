/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem.internal.operations;

import org.eclipselabs.mscript.typesystem.BooleanType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.OperatorKind;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Boolean Type</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.typesystem.BooleanType#evaluate(org.eclipselabs.mscript.typesystem.OperatorKind, org.eclipselabs.mscript.typesystem.DataType) <em>Evaluate</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.BooleanType#isAssignableFrom(org.eclipselabs.mscript.typesystem.DataType) <em>Is Assignable From</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BooleanTypeOperations extends PrimitiveTypeOperations {
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
	public static  DataType evaluate(BooleanType booleanType, OperatorKind operator, DataType other) {
		if (operator == OperatorKind.LOGICAL_NOT) {
			return TypeSystemFactory.eINSTANCE.createBooleanType();
		}
		if (other instanceof BooleanType) {
			switch (operator) {
			case EQUAL_TO:
			case NOT_EQUAL_TO:
			case LOGICAL_AND:
			case LOGICAL_OR:
				return TypeSystemFactory.eINSTANCE.createBooleanType();
			}
		}
		return TypeSystemFactory.eINSTANCE.createInvalidDataType();
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