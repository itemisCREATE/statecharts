/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.DataTypeSpecifier;
import org.eclipselabs.mscript.language.ast.StaticTest;

import org.eclipselabs.mscript.typesystem.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Static Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.StaticTestImpl#getTemplateArguments <em>Template Arguments</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.StaticTestImpl#getInputParameterTypes <em>Input Parameter Types</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.StaticTestImpl#getOutputParameterTypes <em>Output Parameter Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StaticTestImpl extends TestImpl implements StaticTest {
	/**
	 * The cached value of the '{@link #getTemplateArguments() <em>Template Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> templateArguments;

	/**
	 * The cached value of the '{@link #getInputParameterTypes() <em>Input Parameter Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputParameterTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<DataTypeSpecifier> inputParameterTypes;

	/**
	 * The cached value of the '{@link #getOutputParameterTypes() <em>Output Parameter Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputParameterTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<DataTypeSpecifier> outputParameterTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StaticTestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.STATIC_TEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getTemplateArguments() {
		if (templateArguments == null) {
			templateArguments = new EObjectContainmentEList<Expression>(Expression.class, this, AstPackage.STATIC_TEST__TEMPLATE_ARGUMENTS);
		}
		return templateArguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataTypeSpecifier> getInputParameterTypes() {
		if (inputParameterTypes == null) {
			inputParameterTypes = new EObjectContainmentEList<DataTypeSpecifier>(DataTypeSpecifier.class, this, AstPackage.STATIC_TEST__INPUT_PARAMETER_TYPES);
		}
		return inputParameterTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataTypeSpecifier> getOutputParameterTypes() {
		if (outputParameterTypes == null) {
			outputParameterTypes = new EObjectContainmentEList<DataTypeSpecifier>(DataTypeSpecifier.class, this, AstPackage.STATIC_TEST__OUTPUT_PARAMETER_TYPES);
		}
		return outputParameterTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstPackage.STATIC_TEST__TEMPLATE_ARGUMENTS:
				return ((InternalEList<?>)getTemplateArguments()).basicRemove(otherEnd, msgs);
			case AstPackage.STATIC_TEST__INPUT_PARAMETER_TYPES:
				return ((InternalEList<?>)getInputParameterTypes()).basicRemove(otherEnd, msgs);
			case AstPackage.STATIC_TEST__OUTPUT_PARAMETER_TYPES:
				return ((InternalEList<?>)getOutputParameterTypes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AstPackage.STATIC_TEST__TEMPLATE_ARGUMENTS:
				return getTemplateArguments();
			case AstPackage.STATIC_TEST__INPUT_PARAMETER_TYPES:
				return getInputParameterTypes();
			case AstPackage.STATIC_TEST__OUTPUT_PARAMETER_TYPES:
				return getOutputParameterTypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AstPackage.STATIC_TEST__TEMPLATE_ARGUMENTS:
				getTemplateArguments().clear();
				getTemplateArguments().addAll((Collection<? extends Expression>)newValue);
				return;
			case AstPackage.STATIC_TEST__INPUT_PARAMETER_TYPES:
				getInputParameterTypes().clear();
				getInputParameterTypes().addAll((Collection<? extends DataTypeSpecifier>)newValue);
				return;
			case AstPackage.STATIC_TEST__OUTPUT_PARAMETER_TYPES:
				getOutputParameterTypes().clear();
				getOutputParameterTypes().addAll((Collection<? extends DataTypeSpecifier>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AstPackage.STATIC_TEST__TEMPLATE_ARGUMENTS:
				getTemplateArguments().clear();
				return;
			case AstPackage.STATIC_TEST__INPUT_PARAMETER_TYPES:
				getInputParameterTypes().clear();
				return;
			case AstPackage.STATIC_TEST__OUTPUT_PARAMETER_TYPES:
				getOutputParameterTypes().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AstPackage.STATIC_TEST__TEMPLATE_ARGUMENTS:
				return templateArguments != null && !templateArguments.isEmpty();
			case AstPackage.STATIC_TEST__INPUT_PARAMETER_TYPES:
				return inputParameterTypes != null && !inputParameterTypes.isEmpty();
			case AstPackage.STATIC_TEST__OUTPUT_PARAMETER_TYPES:
				return outputParameterTypes != null && !outputParameterTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StaticTestImpl
