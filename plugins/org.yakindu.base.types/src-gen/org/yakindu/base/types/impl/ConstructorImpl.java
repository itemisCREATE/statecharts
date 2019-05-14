/**
 */
package org.yakindu.base.types.impl;

import org.eclipse.emf.ecore.EClass;

import org.yakindu.base.types.Constructor;
import org.yakindu.base.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constructor</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ConstructorImpl extends OperationImpl implements Constructor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstructorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.CONSTRUCTOR;
	}
	
	@Override
	public String getName() {
		return "new";
	}

} //ConstructorImpl
