/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.computation.computationmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fixed Point Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.impl.FixedPointOperationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.impl.FixedPointOperationImpl#getIntermediateWordSize <em>Intermediate Word Size</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.impl.FixedPointOperationImpl#isSaturate <em>Saturate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FixedPointOperationImpl extends EObjectImpl implements FixedPointOperation {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final FixedPointOperationKind KIND_EDEFAULT = FixedPointOperationKind.CONSTRUCT;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected FixedPointOperationKind kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntermediateWordSize() <em>Intermediate Word Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateWordSize()
	 * @generated
	 * @ordered
	 */
	protected static final int INTERMEDIATE_WORD_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIntermediateWordSize() <em>Intermediate Word Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateWordSize()
	 * @generated
	 * @ordered
	 */
	protected int intermediateWordSize = INTERMEDIATE_WORD_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #isSaturate() <em>Saturate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSaturate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SATURATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSaturate() <em>Saturate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSaturate()
	 * @generated
	 * @ordered
	 */
	protected boolean saturate = SATURATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FixedPointOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComputationModelPackage.Literals.FIXED_POINT_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedPointOperationKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(FixedPointOperationKind newKind) {
		FixedPointOperationKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputationModelPackage.FIXED_POINT_OPERATION__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIntermediateWordSize() {
		return intermediateWordSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediateWordSize(int newIntermediateWordSize) {
		int oldIntermediateWordSize = intermediateWordSize;
		intermediateWordSize = newIntermediateWordSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputationModelPackage.FIXED_POINT_OPERATION__INTERMEDIATE_WORD_SIZE, oldIntermediateWordSize, intermediateWordSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSaturate() {
		return saturate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSaturate(boolean newSaturate) {
		boolean oldSaturate = saturate;
		saturate = newSaturate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputationModelPackage.FIXED_POINT_OPERATION__SATURATE, oldSaturate, saturate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComputationModelPackage.FIXED_POINT_OPERATION__KIND:
				return getKind();
			case ComputationModelPackage.FIXED_POINT_OPERATION__INTERMEDIATE_WORD_SIZE:
				return getIntermediateWordSize();
			case ComputationModelPackage.FIXED_POINT_OPERATION__SATURATE:
				return isSaturate();
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
			case ComputationModelPackage.FIXED_POINT_OPERATION__KIND:
				setKind((FixedPointOperationKind)newValue);
				return;
			case ComputationModelPackage.FIXED_POINT_OPERATION__INTERMEDIATE_WORD_SIZE:
				setIntermediateWordSize((Integer)newValue);
				return;
			case ComputationModelPackage.FIXED_POINT_OPERATION__SATURATE:
				setSaturate((Boolean)newValue);
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
			case ComputationModelPackage.FIXED_POINT_OPERATION__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case ComputationModelPackage.FIXED_POINT_OPERATION__INTERMEDIATE_WORD_SIZE:
				setIntermediateWordSize(INTERMEDIATE_WORD_SIZE_EDEFAULT);
				return;
			case ComputationModelPackage.FIXED_POINT_OPERATION__SATURATE:
				setSaturate(SATURATE_EDEFAULT);
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
			case ComputationModelPackage.FIXED_POINT_OPERATION__KIND:
				return kind != KIND_EDEFAULT;
			case ComputationModelPackage.FIXED_POINT_OPERATION__INTERMEDIATE_WORD_SIZE:
				return intermediateWordSize != INTERMEDIATE_WORD_SIZE_EDEFAULT;
			case ComputationModelPackage.FIXED_POINT_OPERATION__SATURATE:
				return saturate != SATURATE_EDEFAULT;
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(", intermediateWordSize: ");
		result.append(intermediateWordSize);
		result.append(", saturate: ");
		result.append(saturate);
		result.append(')');
		return result.toString();
	}

} //FixedPointOperationImpl
