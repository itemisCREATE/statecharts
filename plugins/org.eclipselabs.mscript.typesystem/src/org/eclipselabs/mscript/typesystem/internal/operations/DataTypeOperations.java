/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem.internal.operations;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.OperatorKind;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Data Type</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.typesystem.DataType#evaluate(org.eclipselabs.mscript.typesystem.OperatorKind, org.eclipselabs.mscript.typesystem.DataType) <em>Evaluate</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.DataType#evaluatePower(int) <em>Evaluate Power</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.DataType#isAssignableFrom(org.eclipselabs.mscript.typesystem.DataType) <em>Is Assignable From</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.DataType#convertTo(org.eclipselabs.mscript.typesystem.DataType) <em>Convert To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataTypeOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  DataType evaluate(DataType dataType, OperatorKind operator, DataType other) {
		return TypeSystemFactory.eINSTANCE.createInvalidDataType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static  DataType evaluatePower(DataType dataType, int exponent) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  DataType evaluatePower(DataType dataType, OperatorKind operator, int exponent) {
		return TypeSystemFactory.eINSTANCE.createInvalidDataType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  boolean isAssignableFrom(DataType dataType, DataType other) {
		return EcoreUtil.equals(dataType, other);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static  DataType convertTo(DataType dataType, DataType other) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} // DataTypeOperations