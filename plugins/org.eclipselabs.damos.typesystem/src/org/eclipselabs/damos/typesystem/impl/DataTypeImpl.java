/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.typesystem.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.typesystem.DataType;
import org.eclipselabs.damos.typesystem.OperatorKind;
import org.eclipselabs.damos.typesystem.TypeSystemPackage;
import org.eclipselabs.damos.typesystem.internal.operations.DataTypeOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class DataTypeImpl extends TypeImpl implements DataType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypeSystemPackage.Literals.DATA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType evaluate(OperatorKind operator, DataType other) {
		return DataTypeOperations.evaluate(this, operator, other);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAssignableFrom(DataType other) {
		return DataTypeOperations.isAssignableFrom(this, other);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType convertTo(DataType other) {
		return DataTypeOperations.convertTo(this, other);
	}

} //DataTypeImpl
