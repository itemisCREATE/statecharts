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
import org.eclipselabs.mscript.language.ast.Equation;
import org.eclipselabs.mscript.language.ast.FeatureCall;
import org.eclipselabs.mscript.language.functionmodel.EquationDescriptor;
import org.eclipselabs.mscript.language.functionmodel.EquationPart;
import org.eclipselabs.mscript.language.functionmodel.EquationSide;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage;
import org.eclipselabs.mscript.language.functionmodel.util.FunctionModelValidator;
import org.eclipselabs.mscript.typesystem.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.EquationDescriptorImpl#getFunctionDescriptor <em>Function Descriptor</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.EquationDescriptorImpl#getEquation <em>Equation</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.EquationDescriptorImpl#getSides <em>Sides</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.EquationDescriptorImpl#getLeftHandSide <em>Left Hand Side</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.EquationDescriptorImpl#getRightHandSide <em>Right Hand Side</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EquationDescriptorImpl extends EObjectImpl implements EquationDescriptor {
	/**
	 * The cached value of the '{@link #getEquation() <em>Equation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquation()
	 * @generated
	 * @ordered
	 */
	protected Equation equation;

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
	protected EquationDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionModelPackage.Literals.EQUATION_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDescriptor getFunctionDescriptor() {
		if (eContainerFeatureID() != FunctionModelPackage.EQUATION_DESCRIPTOR__FUNCTION_DESCRIPTOR) return null;
		return (FunctionDescriptor)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunctionDescriptor(FunctionDescriptor newFunctionDescriptor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFunctionDescriptor, FunctionModelPackage.EQUATION_DESCRIPTOR__FUNCTION_DESCRIPTOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionDescriptor(FunctionDescriptor newFunctionDescriptor) {
		if (newFunctionDescriptor != eInternalContainer() || (eContainerFeatureID() != FunctionModelPackage.EQUATION_DESCRIPTOR__FUNCTION_DESCRIPTOR && newFunctionDescriptor != null)) {
			if (EcoreUtil.isAncestor(this, newFunctionDescriptor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFunctionDescriptor != null)
				msgs = ((InternalEObject)newFunctionDescriptor).eInverseAdd(this, FunctionModelPackage.FUNCTION_DESCRIPTOR__EQUATION_DESCRIPTORS, FunctionDescriptor.class, msgs);
			msgs = basicSetFunctionDescriptor(newFunctionDescriptor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.EQUATION_DESCRIPTOR__FUNCTION_DESCRIPTOR, newFunctionDescriptor, newFunctionDescriptor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equation getEquation() {
		if (equation != null && equation.eIsProxy()) {
			InternalEObject oldEquation = (InternalEObject)equation;
			equation = (Equation)eResolveProxy(oldEquation);
			if (equation != oldEquation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FunctionModelPackage.EQUATION_DESCRIPTOR__EQUATION, oldEquation, equation));
			}
		}
		return equation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equation basicGetEquation() {
		return equation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEquation(Equation newEquation) {
		Equation oldEquation = equation;
		equation = newEquation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.EQUATION_DESCRIPTOR__EQUATION, oldEquation, equation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EquationSide> getSides() {
		if (sides == null) {
			sides = new EObjectContainmentWithInverseEList<EquationSide>(EquationSide.class, this, FunctionModelPackage.EQUATION_DESCRIPTOR__SIDES, FunctionModelPackage.EQUATION_SIDE__DESCRIPTOR);
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
	public boolean isLeftHandSideValid(DiagnosticChain diagnostics, Map<Object, Object> context) {
		Expression lhsExpression = getEquation().getLeftHandSide();
		String message = null;
		if (getLeftHandSide().getParts().size() == 1 && lhsExpression instanceof FeatureCall) {
			EquationPart part = getLeftHandSide().getParts().get(0);
			switch (part.getVariableStep().getDescriptor().getKind()) {
			case TEMPLATE_PARAMETER:
				message = "Left-hand side must not be template parameter reference";
				break;
			case INPUT_PARAMETER:
				if (!part.getVariableStep().isInitial() || part.getVariableStep().getIndex() >= 0) {
					message = "Left-hand side input reference must be negative initial step";
				}
				break;
			case FUNCTION_OBJECT:
				message = "Left-hand side must not be function object reference";
				break;
			case CONSTANT:
				message = "Left-hand side must not be constant reference";
				break;
			default:
				if (part.getVariableStep().getIndex() < 0 && !part.getVariableStep().isInitial()) {
					message = "Left-hand side must not reference a previous value";
				}
				break;
			}
		} else {
			message = "Left-hand side must be single variable reference";
		}
		if (message != null && diagnostics != null) {
			diagnostics.add(new BasicDiagnostic(
					Diagnostic.ERROR,
					FunctionModelValidator.DIAGNOSTIC_SOURCE,
					FunctionModelValidator.EQUATION_DESCRIPTOR__IS_LEFT_HAND_SIDE_VALID,
					message,
					new Object [] { lhsExpression }));
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isRightHandSideValid(DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (EquationPart part : getRightHandSide().getParts()) {
			if (part.getVariableStep().isInitial()) {
				if (diagnostics != null) {
					diagnostics.add(new BasicDiagnostic(
							Diagnostic.ERROR,
							FunctionModelValidator.DIAGNOSTIC_SOURCE,
							FunctionModelValidator.EQUATION_DESCRIPTOR__IS_RIGHT_HAND_SIDE_VALID,
							"Right-hand side must not reference initial value",
							new Object [] { part.getFeatureCall() }));
				}
				result = false;
			}
		}
		return result;
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
			case FunctionModelPackage.EQUATION_DESCRIPTOR__FUNCTION_DESCRIPTOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFunctionDescriptor((FunctionDescriptor)otherEnd, msgs);
			case FunctionModelPackage.EQUATION_DESCRIPTOR__SIDES:
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
			case FunctionModelPackage.EQUATION_DESCRIPTOR__FUNCTION_DESCRIPTOR:
				return basicSetFunctionDescriptor(null, msgs);
			case FunctionModelPackage.EQUATION_DESCRIPTOR__SIDES:
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
			case FunctionModelPackage.EQUATION_DESCRIPTOR__FUNCTION_DESCRIPTOR:
				return eInternalContainer().eInverseRemove(this, FunctionModelPackage.FUNCTION_DESCRIPTOR__EQUATION_DESCRIPTORS, FunctionDescriptor.class, msgs);
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
			case FunctionModelPackage.EQUATION_DESCRIPTOR__FUNCTION_DESCRIPTOR:
				return getFunctionDescriptor();
			case FunctionModelPackage.EQUATION_DESCRIPTOR__EQUATION:
				if (resolve) return getEquation();
				return basicGetEquation();
			case FunctionModelPackage.EQUATION_DESCRIPTOR__SIDES:
				return getSides();
			case FunctionModelPackage.EQUATION_DESCRIPTOR__LEFT_HAND_SIDE:
				if (resolve) return getLeftHandSide();
				return basicGetLeftHandSide();
			case FunctionModelPackage.EQUATION_DESCRIPTOR__RIGHT_HAND_SIDE:
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
			case FunctionModelPackage.EQUATION_DESCRIPTOR__FUNCTION_DESCRIPTOR:
				setFunctionDescriptor((FunctionDescriptor)newValue);
				return;
			case FunctionModelPackage.EQUATION_DESCRIPTOR__EQUATION:
				setEquation((Equation)newValue);
				return;
			case FunctionModelPackage.EQUATION_DESCRIPTOR__SIDES:
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
			case FunctionModelPackage.EQUATION_DESCRIPTOR__FUNCTION_DESCRIPTOR:
				setFunctionDescriptor((FunctionDescriptor)null);
				return;
			case FunctionModelPackage.EQUATION_DESCRIPTOR__EQUATION:
				setEquation((Equation)null);
				return;
			case FunctionModelPackage.EQUATION_DESCRIPTOR__SIDES:
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
			case FunctionModelPackage.EQUATION_DESCRIPTOR__FUNCTION_DESCRIPTOR:
				return getFunctionDescriptor() != null;
			case FunctionModelPackage.EQUATION_DESCRIPTOR__EQUATION:
				return equation != null;
			case FunctionModelPackage.EQUATION_DESCRIPTOR__SIDES:
				return sides != null && !sides.isEmpty();
			case FunctionModelPackage.EQUATION_DESCRIPTOR__LEFT_HAND_SIDE:
				return basicGetLeftHandSide() != null;
			case FunctionModelPackage.EQUATION_DESCRIPTOR__RIGHT_HAND_SIDE:
				return basicGetRightHandSide() != null;
		}
		return super.eIsSet(featureID);
	}

} //EquationImpl
