/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.functionmodel.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mscript.language.ast.EquationDefinition;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.FeatureCall;
import org.eclipselabs.mscript.language.functionmodel.Equation;
import org.eclipselabs.mscript.language.functionmodel.EquationPart;
import org.eclipselabs.mscript.language.functionmodel.EquationSide;
import org.eclipselabs.mscript.language.functionmodel.Function;
import org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage;
import org.eclipselabs.mscript.language.functionmodel.util.FunctionModelValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.EquationImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.EquationImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.EquationImpl#getSides <em>Sides</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.EquationImpl#getLeftHandSide <em>Left Hand Side</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.EquationImpl#getRightHandSide <em>Right Hand Side</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EquationImpl extends EObjectImpl implements Equation {
	/**
	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected EquationDefinition definition;

	/**
	 * The cached value of the '{@link #getSides() <em>Sides</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSides()
	 * @generated
	 * @ordered
	 */
	protected EList<EquationSide> sides;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionModelPackage.Literals.EQUATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunction() {
		if (eContainerFeatureID() != FunctionModelPackage.EQUATION__FUNCTION) return null;
		return (Function)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunction(Function newFunction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFunction, FunctionModelPackage.EQUATION__FUNCTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction(Function newFunction) {
		if (newFunction != eInternalContainer() || (eContainerFeatureID() != FunctionModelPackage.EQUATION__FUNCTION && newFunction != null)) {
			if (EcoreUtil.isAncestor(this, newFunction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFunction != null)
				msgs = ((InternalEObject)newFunction).eInverseAdd(this, FunctionModelPackage.FUNCTION__EQUATIONS, Function.class, msgs);
			msgs = basicSetFunction(newFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.EQUATION__FUNCTION, newFunction, newFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquationDefinition getDefinition() {
		if (definition != null && definition.eIsProxy()) {
			InternalEObject oldDefinition = (InternalEObject)definition;
			definition = (EquationDefinition)eResolveProxy(oldDefinition);
			if (definition != oldDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FunctionModelPackage.EQUATION__DEFINITION, oldDefinition, definition));
			}
		}
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquationDefinition basicGetDefinition() {
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinition(EquationDefinition newDefinition) {
		EquationDefinition oldDefinition = definition;
		definition = newDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.EQUATION__DEFINITION, oldDefinition, definition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EquationSide> getSides() {
		if (sides == null) {
			sides = new EObjectContainmentWithInverseEList<EquationSide>(EquationSide.class, this, FunctionModelPackage.EQUATION__SIDES, FunctionModelPackage.EQUATION_SIDE__EQUATION);
		}
		return sides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquationSide getLeftHandSide() {
		EquationSide leftHandSide = basicGetLeftHandSide();
		return leftHandSide != null && leftHandSide.eIsProxy() ? (EquationSide)eResolveProxy((InternalEObject)leftHandSide) : leftHandSide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EquationSide basicGetLeftHandSide() {
		List<EquationSide> sides = getSides();
		return sides.size() > 0 ? sides.get(0) : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquationSide getRightHandSide() {
		EquationSide rightHandSide = basicGetRightHandSide();
		return rightHandSide != null && rightHandSide.eIsProxy() ? (EquationSide)eResolveProxy((InternalEObject)rightHandSide) : rightHandSide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EquationSide basicGetRightHandSide() {
		List<EquationSide> sides = getSides();
		return sides.size() > 1 ? sides.get(1) : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean leftHandSideIsSingleVariableReference(DiagnosticChain diagnostics, Map<Object, Object> context) {
		Expression lhsExpression = getDefinition().getLeftHandSide();
		String message = null;
		if (getLeftHandSide().getParts().size() == 1 && lhsExpression instanceof FeatureCall) {
			EquationPart equationPart = getLeftHandSide().getParts().get(0);
			switch (equationPart.getVariableStep().getReference().getKind()) {
			case TEMPLATE_PARAMETER:
				message = "Left-hand side must not be template parameter reference";;
				break;
			case FUNCTOR:
				message = "Left-hand side must not be functor reference";
				break;
			case CONSTANT:
				message = "Left-hand side must not be constant reference";
				break;
			}
		} else {
			message = "Left-hand side must be single variable reference";
		}
		if (message != null && diagnostics != null) {
			diagnostics.add
				(new BasicDiagnostic
					(Diagnostic.ERROR,
					 FunctionModelValidator.DIAGNOSTIC_SOURCE,
					 FunctionModelValidator.EQUATION__LEFT_HAND_SIDE_IS_SINGLE_VARIABLE_REFERENCE,
					 message,
					 new Object [] { lhsExpression }));
			return false;
		}
		return true;
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
			case FunctionModelPackage.EQUATION__FUNCTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFunction((Function)otherEnd, msgs);
			case FunctionModelPackage.EQUATION__SIDES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSides()).basicAdd(otherEnd, msgs);
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
			case FunctionModelPackage.EQUATION__FUNCTION:
				return basicSetFunction(null, msgs);
			case FunctionModelPackage.EQUATION__SIDES:
				return ((InternalEList<?>)getSides()).basicRemove(otherEnd, msgs);
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
			case FunctionModelPackage.EQUATION__FUNCTION:
				return eInternalContainer().eInverseRemove(this, FunctionModelPackage.FUNCTION__EQUATIONS, Function.class, msgs);
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
			case FunctionModelPackage.EQUATION__FUNCTION:
				return getFunction();
			case FunctionModelPackage.EQUATION__DEFINITION:
				if (resolve) return getDefinition();
				return basicGetDefinition();
			case FunctionModelPackage.EQUATION__SIDES:
				return getSides();
			case FunctionModelPackage.EQUATION__LEFT_HAND_SIDE:
				if (resolve) return getLeftHandSide();
				return basicGetLeftHandSide();
			case FunctionModelPackage.EQUATION__RIGHT_HAND_SIDE:
				if (resolve) return getRightHandSide();
				return basicGetRightHandSide();
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
			case FunctionModelPackage.EQUATION__FUNCTION:
				setFunction((Function)newValue);
				return;
			case FunctionModelPackage.EQUATION__DEFINITION:
				setDefinition((EquationDefinition)newValue);
				return;
			case FunctionModelPackage.EQUATION__SIDES:
				getSides().clear();
				getSides().addAll((Collection<? extends EquationSide>)newValue);
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
			case FunctionModelPackage.EQUATION__FUNCTION:
				setFunction((Function)null);
				return;
			case FunctionModelPackage.EQUATION__DEFINITION:
				setDefinition((EquationDefinition)null);
				return;
			case FunctionModelPackage.EQUATION__SIDES:
				getSides().clear();
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
			case FunctionModelPackage.EQUATION__FUNCTION:
				return getFunction() != null;
			case FunctionModelPackage.EQUATION__DEFINITION:
				return definition != null;
			case FunctionModelPackage.EQUATION__SIDES:
				return sides != null && !sides.isEmpty();
			case FunctionModelPackage.EQUATION__LEFT_HAND_SIDE:
				return basicGetLeftHandSide() != null;
			case FunctionModelPackage.EQUATION__RIGHT_HAND_SIDE:
				return basicGetRightHandSide() != null;
		}
		return super.eIsSet(featureID);
	}

} //EquationImpl
