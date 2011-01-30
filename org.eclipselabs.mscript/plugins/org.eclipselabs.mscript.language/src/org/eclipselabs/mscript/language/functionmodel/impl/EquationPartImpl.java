/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.functionmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.language.ast.FeatureCall;
import org.eclipselabs.mscript.language.functionmodel.EquationPart;
import org.eclipselabs.mscript.language.functionmodel.EquationSide;
import org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage;
import org.eclipselabs.mscript.language.functionmodel.VariableStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equation Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.EquationPartImpl#getSide <em>Side</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.EquationPartImpl#getFeatureCall <em>Feature Call</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.EquationPartImpl#getVariableStep <em>Variable Step</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EquationPartImpl extends EObjectImpl implements EquationPart {
	/**
	 * The cached value of the '{@link #getFeatureCall() <em>Feature Call</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureCall()
	 * @generated
	 * @ordered
	 */
	protected FeatureCall featureCall;

	/**
	 * The cached value of the '{@link #getVariableStep() <em>Variable Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableStep()
	 * @generated
	 * @ordered
	 */
	protected VariableStep variableStep;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquationPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionModelPackage.Literals.EQUATION_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquationSide getSide() {
		if (eContainerFeatureID() != FunctionModelPackage.EQUATION_PART__SIDE) return null;
		return (EquationSide)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSide(EquationSide newSide, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSide, FunctionModelPackage.EQUATION_PART__SIDE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSide(EquationSide newSide) {
		if (newSide != eInternalContainer() || (eContainerFeatureID() != FunctionModelPackage.EQUATION_PART__SIDE && newSide != null)) {
			if (EcoreUtil.isAncestor(this, newSide))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSide != null)
				msgs = ((InternalEObject)newSide).eInverseAdd(this, FunctionModelPackage.EQUATION_SIDE__PARTS, EquationSide.class, msgs);
			msgs = basicSetSide(newSide, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.EQUATION_PART__SIDE, newSide, newSide));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureCall getFeatureCall() {
		if (featureCall != null && featureCall.eIsProxy()) {
			InternalEObject oldFeatureCall = (InternalEObject)featureCall;
			featureCall = (FeatureCall)eResolveProxy(oldFeatureCall);
			if (featureCall != oldFeatureCall) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FunctionModelPackage.EQUATION_PART__FEATURE_CALL, oldFeatureCall, featureCall));
			}
		}
		return featureCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureCall basicGetFeatureCall() {
		return featureCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureCall(FeatureCall newFeatureCall) {
		FeatureCall oldFeatureCall = featureCall;
		featureCall = newFeatureCall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.EQUATION_PART__FEATURE_CALL, oldFeatureCall, featureCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableStep getVariableStep() {
		if (variableStep != null && variableStep.eIsProxy()) {
			InternalEObject oldVariableStep = (InternalEObject)variableStep;
			variableStep = (VariableStep)eResolveProxy(oldVariableStep);
			if (variableStep != oldVariableStep) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FunctionModelPackage.EQUATION_PART__VARIABLE_STEP, oldVariableStep, variableStep));
			}
		}
		return variableStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableStep basicGetVariableStep() {
		return variableStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariableStep(VariableStep newVariableStep, NotificationChain msgs) {
		VariableStep oldVariableStep = variableStep;
		variableStep = newVariableStep;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionModelPackage.EQUATION_PART__VARIABLE_STEP, oldVariableStep, newVariableStep);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableStep(VariableStep newVariableStep) {
		if (newVariableStep != variableStep) {
			NotificationChain msgs = null;
			if (variableStep != null)
				msgs = ((InternalEObject)variableStep).eInverseRemove(this, FunctionModelPackage.VARIABLE_STEP__USING_EQUATION_PARTS, VariableStep.class, msgs);
			if (newVariableStep != null)
				msgs = ((InternalEObject)newVariableStep).eInverseAdd(this, FunctionModelPackage.VARIABLE_STEP__USING_EQUATION_PARTS, VariableStep.class, msgs);
			msgs = basicSetVariableStep(newVariableStep, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.EQUATION_PART__VARIABLE_STEP, newVariableStep, newVariableStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctionModelPackage.EQUATION_PART__SIDE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSide((EquationSide)otherEnd, msgs);
			case FunctionModelPackage.EQUATION_PART__VARIABLE_STEP:
				if (variableStep != null)
					msgs = ((InternalEObject)variableStep).eInverseRemove(this, FunctionModelPackage.VARIABLE_STEP__USING_EQUATION_PARTS, VariableStep.class, msgs);
				return basicSetVariableStep((VariableStep)otherEnd, msgs);
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
			case FunctionModelPackage.EQUATION_PART__SIDE:
				return basicSetSide(null, msgs);
			case FunctionModelPackage.EQUATION_PART__VARIABLE_STEP:
				return basicSetVariableStep(null, msgs);
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
			case FunctionModelPackage.EQUATION_PART__SIDE:
				return eInternalContainer().eInverseRemove(this, FunctionModelPackage.EQUATION_SIDE__PARTS, EquationSide.class, msgs);
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
			case FunctionModelPackage.EQUATION_PART__SIDE:
				return getSide();
			case FunctionModelPackage.EQUATION_PART__FEATURE_CALL:
				if (resolve) return getFeatureCall();
				return basicGetFeatureCall();
			case FunctionModelPackage.EQUATION_PART__VARIABLE_STEP:
				if (resolve) return getVariableStep();
				return basicGetVariableStep();
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
			case FunctionModelPackage.EQUATION_PART__SIDE:
				setSide((EquationSide)newValue);
				return;
			case FunctionModelPackage.EQUATION_PART__FEATURE_CALL:
				setFeatureCall((FeatureCall)newValue);
				return;
			case FunctionModelPackage.EQUATION_PART__VARIABLE_STEP:
				setVariableStep((VariableStep)newValue);
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
			case FunctionModelPackage.EQUATION_PART__SIDE:
				setSide((EquationSide)null);
				return;
			case FunctionModelPackage.EQUATION_PART__FEATURE_CALL:
				setFeatureCall((FeatureCall)null);
				return;
			case FunctionModelPackage.EQUATION_PART__VARIABLE_STEP:
				setVariableStep((VariableStep)null);
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
			case FunctionModelPackage.EQUATION_PART__SIDE:
				return getSide() != null;
			case FunctionModelPackage.EQUATION_PART__FEATURE_CALL:
				return featureCall != null;
			case FunctionModelPackage.EQUATION_PART__VARIABLE_STEP:
				return variableStep != null;
		}
		return super.eIsSet(featureID);
	}

} //EquationPartImpl
