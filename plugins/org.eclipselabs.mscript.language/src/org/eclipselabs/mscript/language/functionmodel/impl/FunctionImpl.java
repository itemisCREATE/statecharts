/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.functionmodel.impl;

import java.util.Collection;
import java.util.HashMap;
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
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.functionmodel.Equation;
import org.eclipselabs.mscript.language.functionmodel.EquationPart;
import org.eclipselabs.mscript.language.functionmodel.Function;
import org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage;
import org.eclipselabs.mscript.language.functionmodel.VariableReference;
import org.eclipselabs.mscript.language.functionmodel.VariableStep;
import org.eclipselabs.mscript.language.functionmodel.util.FunctionModelValidator;
import org.eclipselabs.mscript.language.internal.util.VariableReferenceDescriptor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.FunctionImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.FunctionImpl#getEquations <em>Equations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.impl.FunctionImpl#getVariableReferences <em>Variable References</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionImpl extends EObjectImpl implements Function {
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
	 * The cached value of the '{@link #getEquations() <em>Equations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquations()
	 * @generated
	 * @ordered
	 */
	protected EList<Equation> equations;

	/**
	 * The cached value of the '{@link #getVariableReferences() <em>Variable References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableReference> variableReferences;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionModelPackage.Literals.FUNCTION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FunctionModelPackage.FUNCTION__DEFINITION, oldDefinition, definition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.FUNCTION__DEFINITION, oldDefinition, definition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Equation> getEquations() {
		if (equations == null) {
			equations = new EObjectContainmentWithInverseEList<Equation>(Equation.class, this, FunctionModelPackage.FUNCTION__EQUATIONS, FunctionModelPackage.EQUATION__FUNCTION);
		}
		return equations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableReference> getVariableReferences() {
		if (variableReferences == null) {
			variableReferences = new EObjectContainmentWithInverseEList<VariableReference>(VariableReference.class, this, FunctionModelPackage.FUNCTION__VARIABLE_REFERENCES, FunctionModelPackage.VARIABLE_REFERENCE__FUNCTION);
		}
		return variableReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public VariableReference getVariableReference(String name) {
		for (VariableReference variableReference : getVariableReferences()) {
			if (name.equals(variableReference.getName())) {
				return variableReference;
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
		boolean result = true;
		Map<VariableReferenceDescriptor, EquationPart> descriptors = new HashMap<VariableReferenceDescriptor, EquationPart>();
		for (Equation equation : getEquations()) {
			if (!equation.getLeftHandSide().getParts().isEmpty()) {
				EquationPart equationPart = equation.getLeftHandSide().getParts().get(0);
				VariableStep variableStep = equationPart.getVariableStep();
				VariableReferenceDescriptor descriptor = new VariableReferenceDescriptor(variableStep.getReference().getName(), variableStep.getIndex());
				EquationPart previousEquationPart = descriptors.put(descriptor, equationPart);
				if (previousEquationPart != null) {
					if (diagnostics != null) {
						StringBuilder message = new StringBuilder();
						message.append("Duplicate equation for ");
						message.append(variableStep.getReference().getName());
						message.append("(n");
						if (variableStep.getIndex() >= 0) {
							message.append("+");
						}
						message.append(variableStep.getIndex());
						message.append(")");
						
						if (result) {
							diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
									FunctionModelValidator.DIAGNOSTIC_SOURCE,
									FunctionModelValidator.FUNCTION__HAS_NO_DUPLICATE_EQUATIONS,
									message.toString(),
									new Object[] { previousEquationPart.getFeatureCall() }));
						}
						diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
								FunctionModelValidator.DIAGNOSTIC_SOURCE,
								FunctionModelValidator.FUNCTION__HAS_NO_DUPLICATE_EQUATIONS,
								message.toString(),
								new Object[] { equationPart.getFeatureCall() }));
					}
					result = false;
				}
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean hasNoCyclicEquations(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 FunctionModelValidator.DIAGNOSTIC_SOURCE,
						 FunctionModelValidator.FUNCTION__HAS_NO_CYCLIC_EQUATIONS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "hasNoCyclicEquations", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasEquationsForEachOutput(DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (ParameterDeclaration parameterDeclaration : getDefinition().getOutputParameters()) {
			VariableReference variableReference = getVariableReference(parameterDeclaration.getName());
			if (variableReference != null) {
				hasPrecedentEquationsFor(variableReference, 0, diagnostics);
			} else {
				if (diagnostics != null) {
					diagnostics.add(new BasicDiagnostic(
							Diagnostic.ERROR,
							FunctionModelValidator.DIAGNOSTIC_SOURCE,
							FunctionModelValidator.FUNCTION__HAS_EQUATIONS_FOR_EACH_OUTPUT,
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
	public boolean hasEquationsForEachVariableReference(DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (VariableReference variableReference : getVariableReferences()) {
			for (VariableStep variableStep : variableReference.getSteps()) {
				for (EquationPart equationPart : variableStep.getUsingEquationParts()) {
					if (equationPart.getSide() == equationPart.getSide().getEquation().getRightHandSide()) {
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
		switch (variableStep.getReference().getKind()) {
		case INPUT_PARAMETER:
			// index == 0 => always ok
			// index > 0  => error: future input values cannot be referenced; checked by other validation
			if (index < 0) {
				return hasEquationForEachStep(variableStep.getReference(), -1, variableStep.getIndex(), true, diagnostics);
			}
			break;
		case OUTPUT_PARAMETER:
		case STATE_VARIABLE:
			return hasPrecedentEquationsFor(variableStep.getReference(), index, diagnostics);
		}
		return true;
	}
	
	private boolean hasPrecedentEquationsFor(VariableReference variableReference, int index, DiagnosticChain diagnostics) {
		boolean ok = false;
		for (VariableStep step : variableReference.getSteps()) {
			if (!step.isInitial()) {
				for (EquationPart equationPart : step.getUsingEquationParts()) {
					if (equationPart.getSide() == equationPart.getSide().getEquation().getLeftHandSide()) {
						if (step.getIndex() >= index) {
							ok = hasEquationForEachStep(variableReference, step.getIndex(), index, false, diagnostics);
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
					variableReference.getName(),
					index);
			diagnostics.add(new BasicDiagnostic(
					Diagnostic.ERROR,
					FunctionModelValidator.DIAGNOSTIC_SOURCE,
					FunctionModelValidator.FUNCTION__HAS_EQUATIONS_FOR_EACH_VARIABLE_REFERENCE,
					message,
					new Object[] { getDefinition(), AstPackage.FUNCTION_DEFINITION__NAME }));
		}
		return ok;
	}
	
	private boolean hasEquationForEachStep(VariableReference variableReference, int beginStepIndex, int endStepIndex, boolean initialOnly, DiagnosticChain diagnostics) {
		if (beginStepIndex > endStepIndex) {
			int temp = beginStepIndex;
			beginStepIndex = endStepIndex;
			endStepIndex = temp;
		}
		boolean result = true;
		for (int i = beginStepIndex; i <= endStepIndex; ++i) {
			if (!hasEquationForStep(variableReference, i, initialOnly)) {
				if (diagnostics != null) {
					String message;
					if (initialOnly) {
						message = String.format(
								"No '%s(%d) = ...' equation specified",
								variableReference.getName(),
								i);
					} else {
						message = String.format(
								"No '%s(%d) = ...' or '%s(n%s) = ...' equation specified",
								variableReference.getName(),
								i,
								variableReference.getName(),
								i == 0 ? "" : (i < 0 ? "" : "+") + Integer.toString(i));
					}
					diagnostics.add(new BasicDiagnostic(
							Diagnostic.ERROR,
							FunctionModelValidator.DIAGNOSTIC_SOURCE,
							FunctionModelValidator.FUNCTION__HAS_EQUATIONS_FOR_EACH_VARIABLE_REFERENCE,
							message,
							new Object[] { getDefinition(), AstPackage.FUNCTION_DEFINITION__NAME }));
				}
				result = false;
			}
		}
		return result;
	}

	private boolean hasEquationForStep(VariableReference variableReference, int stepIndex, boolean initialOnly) {
		for (VariableStep variableStep : variableReference.getSteps()) {
			if (variableStep.getIndex() == stepIndex && (!initialOnly || variableStep.isInitial())) {
				for (EquationPart equationPart : variableStep.getUsingEquationParts()) {
					if (equationPart.getSide() == equationPart.getSide().getEquation().getLeftHandSide()) {
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
			case FunctionModelPackage.FUNCTION__EQUATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEquations()).basicAdd(otherEnd, msgs);
			case FunctionModelPackage.FUNCTION__VARIABLE_REFERENCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getVariableReferences()).basicAdd(otherEnd, msgs);
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
			case FunctionModelPackage.FUNCTION__EQUATIONS:
				return ((InternalEList<?>)getEquations()).basicRemove(otherEnd, msgs);
			case FunctionModelPackage.FUNCTION__VARIABLE_REFERENCES:
				return ((InternalEList<?>)getVariableReferences()).basicRemove(otherEnd, msgs);
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
			case FunctionModelPackage.FUNCTION__DEFINITION:
				if (resolve) return getDefinition();
				return basicGetDefinition();
			case FunctionModelPackage.FUNCTION__EQUATIONS:
				return getEquations();
			case FunctionModelPackage.FUNCTION__VARIABLE_REFERENCES:
				return getVariableReferences();
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
			case FunctionModelPackage.FUNCTION__DEFINITION:
				setDefinition((FunctionDefinition)newValue);
				return;
			case FunctionModelPackage.FUNCTION__EQUATIONS:
				getEquations().clear();
				getEquations().addAll((Collection<? extends Equation>)newValue);
				return;
			case FunctionModelPackage.FUNCTION__VARIABLE_REFERENCES:
				getVariableReferences().clear();
				getVariableReferences().addAll((Collection<? extends VariableReference>)newValue);
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
			case FunctionModelPackage.FUNCTION__DEFINITION:
				setDefinition((FunctionDefinition)null);
				return;
			case FunctionModelPackage.FUNCTION__EQUATIONS:
				getEquations().clear();
				return;
			case FunctionModelPackage.FUNCTION__VARIABLE_REFERENCES:
				getVariableReferences().clear();
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
			case FunctionModelPackage.FUNCTION__DEFINITION:
				return definition != null;
			case FunctionModelPackage.FUNCTION__EQUATIONS:
				return equations != null && !equations.isEmpty();
			case FunctionModelPackage.FUNCTION__VARIABLE_REFERENCES:
				return variableReferences != null && !variableReferences.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FunctionImpl
