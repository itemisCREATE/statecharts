/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.computation.computationmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind;
import org.eclipselabs.mscript.computation.computationmodel.internal.operations.FixedPointFormatOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fixed Point Format</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.impl.FixedPointFormatImpl#getIntegerLength <em>Integer Length</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.impl.FixedPointFormatImpl#getFractionLength <em>Fraction Length</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.impl.FixedPointFormatImpl#getWordSize <em>Word Size</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.impl.FixedPointFormatImpl#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FixedPointFormatImpl extends NumberFormatImpl implements FixedPointFormat {
	/**
	 * The default value of the '{@link #getIntegerLength() <em>Integer Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegerLength()
	 * @generated
	 * @ordered
	 */
	protected static final int INTEGER_LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIntegerLength() <em>Integer Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegerLength()
	 * @generated
	 * @ordered
	 */
	protected int integerLength = INTEGER_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getFractionLength() <em>Fraction Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFractionLength()
	 * @generated
	 * @ordered
	 */
	protected static final int FRACTION_LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFractionLength() <em>Fraction Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFractionLength()
	 * @generated
	 * @ordered
	 */
	protected int fractionLength = FRACTION_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getWordSize() <em>Word Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWordSize()
	 * @generated
	 * @ordered
	 */
	protected static final int WORD_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<FixedPointOperation> operations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FixedPointFormatImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComputationModelPackage.Literals.FIXED_POINT_FORMAT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIntegerLength() {
		return integerLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntegerLength(int newIntegerLength) {
		int oldIntegerLength = integerLength;
		integerLength = newIntegerLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputationModelPackage.FIXED_POINT_FORMAT__INTEGER_LENGTH, oldIntegerLength, integerLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFractionLength() {
		return fractionLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFractionLength(int newFractionLength) {
		int oldFractionLength = fractionLength;
		fractionLength = newFractionLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputationModelPackage.FIXED_POINT_FORMAT__FRACTION_LENGTH, oldFractionLength, fractionLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getWordSize() {
		return getIntegerLength() + getFractionLength() + 1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FixedPointOperation> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentEList<FixedPointOperation>(FixedPointOperation.class, this, ComputationModelPackage.FIXED_POINT_FORMAT__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedPointOperation getOperation(FixedPointOperationKind kind) {
		return FixedPointFormatOperations.getOperation(this, kind);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComputationModelPackage.FIXED_POINT_FORMAT__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
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
			case ComputationModelPackage.FIXED_POINT_FORMAT__INTEGER_LENGTH:
				return getIntegerLength();
			case ComputationModelPackage.FIXED_POINT_FORMAT__FRACTION_LENGTH:
				return getFractionLength();
			case ComputationModelPackage.FIXED_POINT_FORMAT__WORD_SIZE:
				return getWordSize();
			case ComputationModelPackage.FIXED_POINT_FORMAT__OPERATIONS:
				return getOperations();
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
			case ComputationModelPackage.FIXED_POINT_FORMAT__INTEGER_LENGTH:
				setIntegerLength((Integer)newValue);
				return;
			case ComputationModelPackage.FIXED_POINT_FORMAT__FRACTION_LENGTH:
				setFractionLength((Integer)newValue);
				return;
			case ComputationModelPackage.FIXED_POINT_FORMAT__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends FixedPointOperation>)newValue);
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
			case ComputationModelPackage.FIXED_POINT_FORMAT__INTEGER_LENGTH:
				setIntegerLength(INTEGER_LENGTH_EDEFAULT);
				return;
			case ComputationModelPackage.FIXED_POINT_FORMAT__FRACTION_LENGTH:
				setFractionLength(FRACTION_LENGTH_EDEFAULT);
				return;
			case ComputationModelPackage.FIXED_POINT_FORMAT__OPERATIONS:
				getOperations().clear();
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
			case ComputationModelPackage.FIXED_POINT_FORMAT__INTEGER_LENGTH:
				return integerLength != INTEGER_LENGTH_EDEFAULT;
			case ComputationModelPackage.FIXED_POINT_FORMAT__FRACTION_LENGTH:
				return fractionLength != FRACTION_LENGTH_EDEFAULT;
			case ComputationModelPackage.FIXED_POINT_FORMAT__WORD_SIZE:
				return getWordSize() != WORD_SIZE_EDEFAULT;
			case ComputationModelPackage.FIXED_POINT_FORMAT__OPERATIONS:
				return operations != null && !operations.isEmpty();
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
		result.append(" (integerLength: ");
		result.append(integerLength);
		result.append(", fractionLength: ");
		result.append(fractionLength);
		result.append(')');
		return result.toString();
	}

} //FixedPointFormatImpl
