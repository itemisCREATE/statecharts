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
import org.eclipselabs.damos.typesystem.RealType;
import org.eclipselabs.damos.typesystem.TypeSystemPackage;
import org.eclipselabs.damos.typesystem.internal.operations.RealTypeOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Real Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RealTypeImpl extends NumericalTypeImpl implements RealType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RealTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypeSystemPackage.Literals.REAL_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataType evaluate(OperatorKind operator, DataType other) {
		return RealTypeOperations.evaluate(this, operator, other);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAssignableFrom(DataType other) {
		return RealTypeOperations.isAssignableFrom(this, other);
	}

} //RealTypeImpl
