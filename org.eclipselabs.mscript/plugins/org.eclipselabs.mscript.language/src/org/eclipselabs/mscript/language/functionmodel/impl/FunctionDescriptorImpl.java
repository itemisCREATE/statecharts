/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.functionmodel.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.functionmodel.EquationDescriptor;
import org.eclipselabs.mscript.language.functionmodel.EquationPart;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage;
import org.eclipselabs.mscript.language.functionmodel.VariableDescriptor;
import org.eclipselabs.mscript.language.functionmodel.VariableStep;
import org.eclipselabs.mscript.language.functionmodel.util.FunctionModelValidator;
import org.eclipselabs.mscript.language.internal.functionmodel.util.VariableDescriptorWrapper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.FunctionDescriptorImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.FunctionDescriptorImpl#getEquationDescriptors <em>Equation Descriptors</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.FunctionDescriptorImpl#getVariableDescriptors <em>Variable Descriptors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionDescriptorImpl extends EObjectImpl implements FunctionDescriptor {
	/**
	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected FunctionDefinition definition;

	/**
	 * The cached value of the '{@link #getEquationDescriptors() <em>Equation Descriptors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquationDescriptors()
	 * @generated
	 * @ordered
	 */
	protected EList<EquationDescriptor> equationDescriptors;

	/**
	 * The cached value of the '{@link #getVariableDescriptors() <em>Variable Descriptors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableDescriptors()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableDescriptor> variableDescriptors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionModelPackage.Literals.FUNCTION_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDefinition getDefinition() {
		if (definition != null && definition.eIsProxy()) {
			InternalEObject oldDefinition = (InternalEObject)definition;
			definition = (FunctionDefinition)eResolveProxy(oldDefinition);
			if (definition != oldDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FunctionModelPackage.FUNCTION_DESCRIPTOR__DEFINITION, oldDefinition, definition));
			}
		}
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDefinition basicGetDefinition() {
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinition(FunctionDefinition newDefinition) {
		FunctionDefinition oldDefinition = definition;
		definition = newDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.FUNCTION_DESCRIPTOR__DEFINITION, oldDefinition, definition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EquationDescriptor> getEquationDescriptors() {
		if (equationDescriptors == null) {
			equationDescriptors = new EObjectContainmentWithInverseEList<EquationDescriptor>(EquationDescriptor.class, this, FunctionModelPackage.FUNCTION_DESCRIPTOR__EQUATION_DESCRIPTORS, FunctionModelPackage.EQUATION_DESCRIPTOR__FUNCTION_DESCRIPTOR);
		}
		return equationDescriptors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableDescriptor> getVariableDescriptors() {
		if (variableDescriptors == null) {
			variableDescriptors = new EObjectContainmentWithInverseEList<VariableDescriptor>(VariableDescriptor.class, this, FunctionModelPackage.FUNCTION_DESCRIPTOR__VARIABLE_DESCRIPTORS, FunctionModelPackage.VARIABLE_DESCRIPTOR__FUNCTION_DESCRIPTOR);
		}
		return variableDescriptors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public VariableDescriptor getVariableDescriptor(String name) {
		for (VariableDescriptor variableDescriptor : getVariableDescriptors()) {
			if (name.equals(variableDescriptor.getName())) {
				return variableDescriptor;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasNoDuplicateEquations(DiagnosticChain diagnostics, Map<Object, Object> context) {
		Set<EquationPart> invalidEquationParts = new HashSet<EquationPart>();
		Map<VariableDescriptorWrapper, EquationPart> wrappers = new HashMap<VariableDescriptorWrapper, EquationPart>();
		
		for (EquationDescriptor equationDescriptor : getEquationDescriptors()) {
			if (!equationDescriptor.getLeftHandSide().getParts().isEmpty()) {
				EquationPart equationPart = equationDescriptor.getLeftHandSide().getParts().get(0);
				VariableStep variableStep = equationPart.getVariableStep();
				VariableDescriptorWrapper descriptor = new VariableDescriptorWrapper(variableStep.getDescriptor().getName(), variableStep.getIndex(), false, variableStep.isDerivative());
				EquationPart previousEquationPart = wrappers.put(descriptor, equationPart);
				if (previousEquationPart != null) {
					invalidEquationParts.add(equationPart);
					invalidEquationParts.add(previousEquationPart);
				}
			}
		}
		
		if (diagnostics != null) {
			for (EquationPart invalidEquationPart : invalidEquationParts) {
				VariableStep variableStep = invalidEquationPart.getVariableStep();

				StringBuilder message = new StringBuilder();
				message.append("Duplicate equation for ");
				message.append(variableStep.getDescriptor().getName());
				message.append("(n");
				if (variableStep.getIndex() >= 0) {
					message.append("+");
				}
				message.append(variableStep.getIndex());
				message.append(")");
				
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						FunctionModelValidator.DIAGNOSTIC_SOURCE,
						FunctionModelValidator.FUNCTION_DESCRIPTOR__HAS_NO_DUPLICATE_EQUATIONS,
						message.toString(),
						new Object[] { invalidEquationPart.getVariableAccess() }));
			}
		}
		
		return invalidEquationParts.isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasNoCyclicEquations(DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (VariableDescriptor variableDescriptor : getVariableDescriptors()) {
			for (VariableStep variableStep : variableDescriptor.getSteps()) {
				if (hasCyclicEquations(new HashSet<VariableStep>(), variableStep)) {
					for (EquationPart equationPart : variableStep.getUsingEquationParts()) {
						String message;
						if (equationPart.getSide() == equationPart.getSide().getDescriptor().getLeftHandSide()) {
							message = "Cyclic equation definition of '" + variableStep.getDescriptor().getName() + "'";
						} else {
							message = "'" + variableStep.getDescriptor().getName() + "' is part of a cyclic equation definition";
						}
						diagnostics.add(new BasicDiagnostic(
								Diagnostic.ERROR,
								FunctionModelValidator.DIAGNOSTIC_SOURCE,
								FunctionModelValidator.FUNCTION_DESCRIPTOR__HAS_NO_CYCLIC_EQUATIONS,
								message,
								new Object[] { equationPart.getVariableAccess() }));
					}
					result = false;
				}
			}
		}
		return result;
	}
	
	private boolean hasCyclicEquations(Set<VariableStep> dependents, VariableStep variableStep) {
		for (EquationPart usingEquationPart : variableStep.getUsingEquationParts()) {
			if (usingEquationPart.getSide() == usingEquationPart.getSide().getDescriptor().getLeftHandSide()) {
				if (!dependents.add(variableStep)) {
					return true;
				}
				for (EquationPart rhsEquationPart : usingEquationPart.getSide().getDescriptor().getRightHandSide().getParts()) {
					if (hasCyclicEquations(dependents, rhsEquationPart.getVariableStep())) {
						return true;
					}
				}
				break;
			}
		}
		return false;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasEquationsForEachOutput(DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (ParameterDeclaration parameterDeclaration : getDefinition().getOutputParameterDeclarations()) {
			VariableDescriptor variableDescriptor = getVariableDescriptor(parameterDeclaration.getName());
			if (variableDescriptor != null) {
				hasPrecedentEquationsFor(variableDescriptor, 0, diagnostics);
			} else {
				if (diagnostics != null) {
					diagnostics.add(new BasicDiagnostic(
							Diagnostic.ERROR,
							FunctionModelValidator.DIAGNOSTIC_SOURCE,
							FunctionModelValidator.FUNCTION_DESCRIPTOR__HAS_EQUATIONS_FOR_EACH_OUTPUT,
							"No equation specified for output '" + parameterDeclaration.getName() + "'",
							new Object[] { parameterDeclaration }));
				}
				result = false;
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasEquationsForEachVariableStep(DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (VariableDescriptor variableDescriptor : getVariableDescriptors()) {
			for (VariableStep variableStep : variableDescriptor.getSteps()) {
				for (EquationPart equationPart : variableStep.getUsingEquationParts()) {
					if (equationPart.getSide() == equationPart.getSide().getDescriptor().getRightHandSide()) {
						if (!hasEquationsFor(equationPart.getVariableStep(), diagnostics)) {
							result = false;
						}
						break;
					}
				}
			}
		}
		return result;
	}
	
	private boolean hasEquationsFor(VariableStep variableStep, DiagnosticChain diagnostics) {
		int index = variableStep.getIndex();
		switch (variableStep.getDescriptor().getKind()) {
		case INPUT_PARAMETER:
			// index == 0 => always ok
			// index > 0  => error: future input values cannot be referenced; checked by other validation
			if (index < 0) {
				return hasEquationForEachStep(variableStep.getDescriptor(), -1, variableStep.getIndex(), true, diagnostics);
			}
			break;
		case OUTPUT_PARAMETER:
		case STATE_VARIABLE:
			return hasPrecedentEquationsFor(variableStep.getDescriptor(), index, diagnostics);
		}
		return true;
	}
	
	private boolean hasPrecedentEquationsFor(VariableDescriptor variableDescriptor, int index, DiagnosticChain diagnostics) {
		boolean ok = false;
		for (VariableStep step : variableDescriptor.getSteps()) {
			if (!step.isInitial()) {
				for (EquationPart equationPart : step.getUsingEquationParts()) {
					if (equationPart.getSide() == equationPart.getSide().getDescriptor().getLeftHandSide()) {
						if (step.getIndex() >= index) {
							ok = hasEquationForEachStep(variableDescriptor, step.getIndex(), index, false, diagnostics);
							if (!ok) {
								return ok;
							}
							break;
						}
					}
				}
			}
		}
		if (!ok && diagnostics != null) {
			String message = String.format(
					"No '%s(n+i) = ...' equation with i >= %d specified",
					variableDescriptor.getName(),
					index);
			diagnostics.add(new BasicDiagnostic(
					Diagnostic.ERROR,
					FunctionModelValidator.DIAGNOSTIC_SOURCE,
					FunctionModelValidator.FUNCTION_DESCRIPTOR__HAS_EQUATIONS_FOR_EACH_VARIABLE_STEP,
					message,
					new Object[] { getDefinition(), AstPackage.FUNCTION_DEFINITION__NAME }));
		}
		return ok;
	}
	
	private boolean hasEquationForEachStep(VariableDescriptor variableDescriptor, int beginStepIndex, int endStepIndex, boolean initialOnly, DiagnosticChain diagnostics) {
		if (beginStepIndex > endStepIndex) {
			int temp = beginStepIndex;
			beginStepIndex = endStepIndex;
			endStepIndex = temp;
		}
		boolean result = true;
		for (int i = beginStepIndex; i <= endStepIndex; ++i) {
			if (!hasEquationForStep(variableDescriptor, i, initialOnly)) {
				if (diagnostics != null) {
					String message;
					if (initialOnly) {
						message = String.format(
								"No '%s(%d) = ...' equation specified",
								variableDescriptor.getName(),
								i);
					} else {
						message = String.format(
								"No '%s(%d) = ...' or '%s(n%s) = ...' equation specified",
								variableDescriptor.getName(),
								i,
								variableDescriptor.getName(),
								i == 0 ? "" : (i < 0 ? "" : "+") + Integer.toString(i));
					}
					diagnostics.add(new BasicDiagnostic(
							Diagnostic.ERROR,
							FunctionModelValidator.DIAGNOSTIC_SOURCE,
							FunctionModelValidator.FUNCTION_DESCRIPTOR__HAS_EQUATIONS_FOR_EACH_VARIABLE_STEP,
							message,
							new Object[] { getDefinition(), AstPackage.FUNCTION_DEFINITION__NAME }));
				}
				result = false;
			}
		}
		return result;
	}

	private boolean hasEquationForStep(VariableDescriptor variableDescriptor, int stepIndex, boolean initialOnly) {
		for (VariableStep variableStep : variableDescriptor.getSteps()) {
			if (variableStep.getIndex() == stepIndex && (!initialOnly || variableStep.isInitial())) {
				for (EquationPart equationPart : variableStep.getUsingEquationParts()) {
					if (equationPart.getSide() == equationPart.getSide().getDescriptor().getLeftHandSide()) {
						return true;
					}
				}
			}
		}
		return false;
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
			case FunctionModelPackage.FUNCTION_DESCRIPTOR__EQUATION_DESCRIPTORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEquationDescriptors()).basicAdd(otherEnd, msgs);
			case FunctionModelPackage.FUNCTION_DESCRIPTOR__VARIABLE_DESCRIPTORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getVariableDescriptors()).basicAdd(otherEnd, msgs);
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
			case FunctionModelPackage.FUNCTION_DESCRIPTOR__EQUATION_DESCRIPTORS:
				return ((InternalEList<?>)getEquationDescriptors()).basicRemove(otherEnd, msgs);
			case FunctionModelPackage.FUNCTION_DESCRIPTOR__VARIABLE_DESCRIPTORS:
				return ((InternalEList<?>)getVariableDescriptors()).basicRemove(otherEnd, msgs);
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
			case FunctionModelPackage.FUNCTION_DESCRIPTOR__DEFINITION:
				if (resolve) return getDefinition();
				return basicGetDefinition();
			case FunctionModelPackage.FUNCTION_DESCRIPTOR__EQUATION_DESCRIPTORS:
				return getEquationDescriptors();
			case FunctionModelPackage.FUNCTION_DESCRIPTOR__VARIABLE_DESCRIPTORS:
				return getVariableDescriptors();
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
			case FunctionModelPackage.FUNCTION_DESCRIPTOR__DEFINITION:
				setDefinition((FunctionDefinition)newValue);
				return;
			case FunctionModelPackage.FUNCTION_DESCRIPTOR__EQUATION_DESCRIPTORS:
				getEquationDescriptors().clear();
				getEquationDescriptors().addAll((Collection<? extends EquationDescriptor>)newValue);
				return;
			case FunctionModelPackage.FUNCTION_DESCRIPTOR__VARIABLE_DESCRIPTORS:
				getVariableDescriptors().clear();
				getVariableDescriptors().addAll((Collection<? extends VariableDescriptor>)newValue);
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
			case FunctionModelPackage.FUNCTION_DESCRIPTOR__DEFINITION:
				setDefinition((FunctionDefinition)null);
				return;
			case FunctionModelPackage.FUNCTION_DESCRIPTOR__EQUATION_DESCRIPTORS:
				getEquationDescriptors().clear();
				return;
			case FunctionModelPackage.FUNCTION_DESCRIPTOR__VARIABLE_DESCRIPTORS:
				getVariableDescriptors().clear();
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
			case FunctionModelPackage.FUNCTION_DESCRIPTOR__DEFINITION:
				return definition != null;
			case FunctionModelPackage.FUNCTION_DESCRIPTOR__EQUATION_DESCRIPTORS:
				return equationDescriptors != null && !equationDescriptors.isEmpty();
			case FunctionModelPackage.FUNCTION_DESCRIPTOR__VARIABLE_DESCRIPTORS:
				return variableDescriptors != null && !variableDescriptors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FunctionImpl
