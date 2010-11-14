/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.mscript.language.ast.impl.ExpressionImpl;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage;
import org.eclipselabs.mscript.language.imperativemodel.VariableAccess;
import org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Access</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.VariableAccessImpl#getAccessedDeclaration <em>Accessed Declaration</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.VariableAccessImpl#getStepIndex <em>Step Index</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableAccessImpl extends ExpressionImpl implements VariableAccess {
	/**
	 * The cached value of the '{@link #getAccessedDeclaration() <em>Accessed Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessedDeclaration()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration accessedDeclaration;

	/**
	 * The default value of the '{@link #getStepIndex() <em>Step Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int STEP_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStepIndex() <em>Step Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepIndex()
	 * @generated
	 * @ordered
	 */
	protected int stepIndex = STEP_INDEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableAccessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeModelPackage.Literals.VARIABLE_ACCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration getAccessedDeclaration() {
		if (accessedDeclaration != null && accessedDeclaration.eIsProxy()) {
			InternalEObject oldAccessedDeclaration = (InternalEObject)accessedDeclaration;
			accessedDeclaration = (VariableDeclaration)eResolveProxy(oldAccessedDeclaration);
			if (accessedDeclaration != oldAccessedDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImperativeModelPackage.VARIABLE_ACCESS__ACCESSED_DECLARATION, oldAccessedDeclaration, accessedDeclaration));
			}
		}
		return accessedDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetAccessedDeclaration() {
		return accessedDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessedDeclaration(VariableDeclaration newAccessedDeclaration) {
		VariableDeclaration oldAccessedDeclaration = accessedDeclaration;
		accessedDeclaration = newAccessedDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeModelPackage.VARIABLE_ACCESS__ACCESSED_DECLARATION, oldAccessedDeclaration, accessedDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStepIndex() {
		return stepIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepIndex(int newStepIndex) {
		int oldStepIndex = stepIndex;
		stepIndex = newStepIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeModelPackage.VARIABLE_ACCESS__STEP_INDEX, oldStepIndex, stepIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImperativeModelPackage.VARIABLE_ACCESS__ACCESSED_DECLARATION:
				if (resolve) return getAccessedDeclaration();
				return basicGetAccessedDeclaration();
			case ImperativeModelPackage.VARIABLE_ACCESS__STEP_INDEX:
				return getStepIndex();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ImperativeModelPackage.VARIABLE_ACCESS__ACCESSED_DECLARATION:
				setAccessedDeclaration((VariableDeclaration)newValue);
				return;
			case ImperativeModelPackage.VARIABLE_ACCESS__STEP_INDEX:
				setStepIndex((Integer)newValue);
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
			case ImperativeModelPackage.VARIABLE_ACCESS__ACCESSED_DECLARATION:
				setAccessedDeclaration((VariableDeclaration)null);
				return;
			case ImperativeModelPackage.VARIABLE_ACCESS__STEP_INDEX:
				setStepIndex(STEP_INDEX_EDEFAULT);
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
			case ImperativeModelPackage.VARIABLE_ACCESS__ACCESSED_DECLARATION:
				return accessedDeclaration != null;
			case ImperativeModelPackage.VARIABLE_ACCESS__STEP_INDEX:
				return stepIndex != STEP_INDEX_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (stepIndex: ");
		result.append(stepIndex);
		result.append(')');
		return result.toString();
	}

} //VariableAccessImpl
