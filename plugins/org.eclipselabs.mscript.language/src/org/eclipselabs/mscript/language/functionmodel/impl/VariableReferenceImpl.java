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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mscript.language.functionmodel.EquationPart;
import org.eclipselabs.mscript.language.functionmodel.Function;
import org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage;
import org.eclipselabs.mscript.language.functionmodel.VariableReference;
import org.eclipselabs.mscript.language.functionmodel.VariableReferenceKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.VariableReferenceImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.VariableReferenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.VariableReferenceImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.VariableReferenceImpl#getStep <em>Step</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.VariableReferenceImpl#isInitial <em>Initial</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.VariableReferenceImpl#getUsingEquationParts <em>Using Equation Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableReferenceImpl extends EObjectImpl implements VariableReference {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final VariableReferenceKind KIND_EDEFAULT = VariableReferenceKind.UNKNOWN;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected VariableReferenceKind kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getStep() <em>Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStep()
	 * @generated
	 * @ordered
	 */
	protected static final int STEP_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStep() <em>Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStep()
	 * @generated
	 * @ordered
	 */
	protected int step = STEP_EDEFAULT;

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
	protected VariableReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionModelPackage.Literals.VARIABLE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunction() {
		if (eContainerFeatureID() != FunctionModelPackage.VARIABLE_REFERENCE__FUNCTION) return null;
		return (Function)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunction(Function newFunction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFunction, FunctionModelPackage.VARIABLE_REFERENCE__FUNCTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction(Function newFunction) {
		if (newFunction != eInternalContainer() || (eContainerFeatureID() != FunctionModelPackage.VARIABLE_REFERENCE__FUNCTION && newFunction != null)) {
			if (EcoreUtil.isAncestor(this, newFunction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFunction != null)
				msgs = ((InternalEObject)newFunction).eInverseAdd(this, FunctionModelPackage.FUNCTION__VARIABLE_REFERENCES, Function.class, msgs);
			msgs = basicSetFunction(newFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.VARIABLE_REFERENCE__FUNCTION, newFunction, newFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.VARIABLE_REFERENCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableReferenceKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(VariableReferenceKind newKind) {
		VariableReferenceKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.VARIABLE_REFERENCE__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStep() {
		return step;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStep(int newStep) {
		int oldStep = step;
		step = newStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.VARIABLE_REFERENCE__STEP, oldStep, step));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.VARIABLE_REFERENCE__INITIAL, oldInitial, initial));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EquationPart> getUsingEquationParts() {
		if (usingEquationParts == null) {
			usingEquationParts = new EObjectWithInverseResolvingEList<EquationPart>(EquationPart.class, this, FunctionModelPackage.VARIABLE_REFERENCE__USING_EQUATION_PARTS, FunctionModelPackage.EQUATION_PART__VARIABLE_REFERENCE);
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
			case FunctionModelPackage.VARIABLE_REFERENCE__FUNCTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFunction((Function)otherEnd, msgs);
			case FunctionModelPackage.VARIABLE_REFERENCE__USING_EQUATION_PARTS:
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
			case FunctionModelPackage.VARIABLE_REFERENCE__FUNCTION:
				return basicSetFunction(null, msgs);
			case FunctionModelPackage.VARIABLE_REFERENCE__USING_EQUATION_PARTS:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case FunctionModelPackage.VARIABLE_REFERENCE__FUNCTION:
				return eInternalContainer().eInverseRemove(this, FunctionModelPackage.FUNCTION__VARIABLE_REFERENCES, Function.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FunctionModelPackage.VARIABLE_REFERENCE__FUNCTION:
				return getFunction();
			case FunctionModelPackage.VARIABLE_REFERENCE__NAME:
				return getName();
			case FunctionModelPackage.VARIABLE_REFERENCE__KIND:
				return getKind();
			case FunctionModelPackage.VARIABLE_REFERENCE__STEP:
				return getStep();
			case FunctionModelPackage.VARIABLE_REFERENCE__INITIAL:
				return isInitial();
			case FunctionModelPackage.VARIABLE_REFERENCE__USING_EQUATION_PARTS:
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
			case FunctionModelPackage.VARIABLE_REFERENCE__FUNCTION:
				setFunction((Function)newValue);
				return;
			case FunctionModelPackage.VARIABLE_REFERENCE__NAME:
				setName((String)newValue);
				return;
			case FunctionModelPackage.VARIABLE_REFERENCE__KIND:
				setKind((VariableReferenceKind)newValue);
				return;
			case FunctionModelPackage.VARIABLE_REFERENCE__STEP:
				setStep((Integer)newValue);
				return;
			case FunctionModelPackage.VARIABLE_REFERENCE__INITIAL:
				setInitial((Boolean)newValue);
				return;
			case FunctionModelPackage.VARIABLE_REFERENCE__USING_EQUATION_PARTS:
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
			case FunctionModelPackage.VARIABLE_REFERENCE__FUNCTION:
				setFunction((Function)null);
				return;
			case FunctionModelPackage.VARIABLE_REFERENCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FunctionModelPackage.VARIABLE_REFERENCE__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case FunctionModelPackage.VARIABLE_REFERENCE__STEP:
				setStep(STEP_EDEFAULT);
				return;
			case FunctionModelPackage.VARIABLE_REFERENCE__INITIAL:
				setInitial(INITIAL_EDEFAULT);
				return;
			case FunctionModelPackage.VARIABLE_REFERENCE__USING_EQUATION_PARTS:
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
			case FunctionModelPackage.VARIABLE_REFERENCE__FUNCTION:
				return getFunction() != null;
			case FunctionModelPackage.VARIABLE_REFERENCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FunctionModelPackage.VARIABLE_REFERENCE__KIND:
				return kind != KIND_EDEFAULT;
			case FunctionModelPackage.VARIABLE_REFERENCE__STEP:
				return step != STEP_EDEFAULT;
			case FunctionModelPackage.VARIABLE_REFERENCE__INITIAL:
				return initial != INITIAL_EDEFAULT;
			case FunctionModelPackage.VARIABLE_REFERENCE__USING_EQUATION_PARTS:
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
		result.append(" (name: ");
		result.append(name);
		result.append(", kind: ");
		result.append(kind);
		result.append(", step: ");
		result.append(step);
		result.append(", initial: ");
		result.append(initial);
		result.append(')');
		return result.toString();
	}

} //VariableReferenceImpl
