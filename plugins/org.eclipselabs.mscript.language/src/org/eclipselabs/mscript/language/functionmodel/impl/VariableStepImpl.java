/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.functionmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mscript.language.functionmodel.EquationPart;
import org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage;
import org.eclipselabs.mscript.language.functionmodel.VariableReference;
import org.eclipselabs.mscript.language.functionmodel.VariableStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.VariableStepImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.VariableStepImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.VariableStepImpl#isInitial <em>Initial</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.VariableStepImpl#getUsingEquationParts <em>Using Equation Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableStepImpl extends EObjectImpl implements VariableStep {
	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected VariableReference reference;

	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected int index = INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #isInitial() <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitial()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INITIAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInitial() <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitial()
	 * @generated
	 * @ordered
	 */
	protected boolean initial = INITIAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUsingEquationParts() <em>Using Equation Parts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsingEquationParts()
	 * @generated
	 * @ordered
	 */
	protected EList<EquationPart> usingEquationParts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionModelPackage.Literals.VARIABLE_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableReference getReference() {
		if (reference != null && reference.eIsProxy()) {
			InternalEObject oldReference = (InternalEObject)reference;
			reference = (VariableReference)eResolveProxy(oldReference);
			if (reference != oldReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FunctionModelPackage.VARIABLE_STEP__REFERENCE, oldReference, reference));
			}
		}
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableReference basicGetReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReference(VariableReference newReference, NotificationChain msgs) {
		VariableReference oldReference = reference;
		reference = newReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionModelPackage.VARIABLE_STEP__REFERENCE, oldReference, newReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(VariableReference newReference) {
		if (newReference != reference) {
			NotificationChain msgs = null;
			if (reference != null)
				msgs = ((InternalEObject)reference).eInverseRemove(this, FunctionModelPackage.VARIABLE_REFERENCE__STEPS, VariableReference.class, msgs);
			if (newReference != null)
				msgs = ((InternalEObject)newReference).eInverseAdd(this, FunctionModelPackage.VARIABLE_REFERENCE__STEPS, VariableReference.class, msgs);
			msgs = basicSetReference(newReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.VARIABLE_STEP__REFERENCE, newReference, newReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndex(int newIndex) {
		int oldIndex = index;
		index = newIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.VARIABLE_STEP__INDEX, oldIndex, index));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInitial() {
		return initial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitial(boolean newInitial) {
		boolean oldInitial = initial;
		initial = newInitial;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.VARIABLE_STEP__INITIAL, oldInitial, initial));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EquationPart> getUsingEquationParts() {
		if (usingEquationParts == null) {
			usingEquationParts = new EObjectWithInverseResolvingEList<EquationPart>(EquationPart.class, this, FunctionModelPackage.VARIABLE_STEP__USING_EQUATION_PARTS, FunctionModelPackage.EQUATION_PART__VARIABLE_STEP);
		}
		return usingEquationParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctionModelPackage.VARIABLE_STEP__REFERENCE:
				if (reference != null)
					msgs = ((InternalEObject)reference).eInverseRemove(this, FunctionModelPackage.VARIABLE_REFERENCE__STEPS, VariableReference.class, msgs);
				return basicSetReference((VariableReference)otherEnd, msgs);
			case FunctionModelPackage.VARIABLE_STEP__USING_EQUATION_PARTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUsingEquationParts()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctionModelPackage.VARIABLE_STEP__REFERENCE:
				return basicSetReference(null, msgs);
			case FunctionModelPackage.VARIABLE_STEP__USING_EQUATION_PARTS:
				return ((InternalEList<?>)getUsingEquationParts()).basicRemove(otherEnd, msgs);
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
			case FunctionModelPackage.VARIABLE_STEP__REFERENCE:
				if (resolve) return getReference();
				return basicGetReference();
			case FunctionModelPackage.VARIABLE_STEP__INDEX:
				return getIndex();
			case FunctionModelPackage.VARIABLE_STEP__INITIAL:
				return isInitial();
			case FunctionModelPackage.VARIABLE_STEP__USING_EQUATION_PARTS:
				return getUsingEquationParts();
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
			case FunctionModelPackage.VARIABLE_STEP__REFERENCE:
				setReference((VariableReference)newValue);
				return;
			case FunctionModelPackage.VARIABLE_STEP__INDEX:
				setIndex((Integer)newValue);
				return;
			case FunctionModelPackage.VARIABLE_STEP__INITIAL:
				setInitial((Boolean)newValue);
				return;
			case FunctionModelPackage.VARIABLE_STEP__USING_EQUATION_PARTS:
				getUsingEquationParts().clear();
				getUsingEquationParts().addAll((Collection<? extends EquationPart>)newValue);
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
			case FunctionModelPackage.VARIABLE_STEP__REFERENCE:
				setReference((VariableReference)null);
				return;
			case FunctionModelPackage.VARIABLE_STEP__INDEX:
				setIndex(INDEX_EDEFAULT);
				return;
			case FunctionModelPackage.VARIABLE_STEP__INITIAL:
				setInitial(INITIAL_EDEFAULT);
				return;
			case FunctionModelPackage.VARIABLE_STEP__USING_EQUATION_PARTS:
				getUsingEquationParts().clear();
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
			case FunctionModelPackage.VARIABLE_STEP__REFERENCE:
				return reference != null;
			case FunctionModelPackage.VARIABLE_STEP__INDEX:
				return index != INDEX_EDEFAULT;
			case FunctionModelPackage.VARIABLE_STEP__INITIAL:
				return initial != INITIAL_EDEFAULT;
			case FunctionModelPackage.VARIABLE_STEP__USING_EQUATION_PARTS:
				return usingEquationParts != null && !usingEquationParts.isEmpty();
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
		result.append(" (index: ");
		result.append(index);
		result.append(", initial: ");
		result.append(initial);
		result.append(')');
		return result.toString();
	}

} //VariableStepImpl
