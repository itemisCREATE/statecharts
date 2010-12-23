/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.il.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipselabs.mscript.language.il.ILPackage;
import org.eclipselabs.mscript.language.il.VariableAccess;
import org.eclipselabs.mscript.language.il.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Access</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.il.impl.VariableAccessImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.il.impl.VariableAccessImpl#getStepIndex <em>Step Index</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class VariableAccessImpl extends EObjectImpl implements VariableAccess {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration target;

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
		return ILPackage.Literals.VARIABLE_ACCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (VariableDeclaration)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ILPackage.VARIABLE_ACCESS__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(VariableDeclaration newTarget) {
		VariableDeclaration oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ILPackage.VARIABLE_ACCESS__TARGET, oldTarget, target));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ILPackage.VARIABLE_ACCESS__STEP_INDEX, oldStepIndex, stepIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ILPackage.VARIABLE_ACCESS__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case ILPackage.VARIABLE_ACCESS__STEP_INDEX:
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
			case ILPackage.VARIABLE_ACCESS__TARGET:
				setTarget((VariableDeclaration)newValue);
				return;
			case ILPackage.VARIABLE_ACCESS__STEP_INDEX:
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
			case ILPackage.VARIABLE_ACCESS__TARGET:
				setTarget((VariableDeclaration)null);
				return;
			case ILPackage.VARIABLE_ACCESS__STEP_INDEX:
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
			case ILPackage.VARIABLE_ACCESS__TARGET:
				return target != null;
			case ILPackage.VARIABLE_ACCESS__STEP_INDEX:
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
