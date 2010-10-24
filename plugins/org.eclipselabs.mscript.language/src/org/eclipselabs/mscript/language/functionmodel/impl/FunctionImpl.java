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
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.functionmodel.Equation;
import org.eclipselabs.mscript.language.functionmodel.EquationPart;
import org.eclipselabs.mscript.language.functionmodel.Function;
import org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage;
import org.eclipselabs.mscript.language.functionmodel.VariableReference;
import org.eclipselabs.mscript.language.functionmodel.VariableReferenceKind;
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
	public boolean hasNoDuplicateEquations(DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		Map<VariableReferenceDescriptor, EquationPart> descriptors = new HashMap<VariableReferenceDescriptor, EquationPart>();
		for (Equation equation : getEquations()) {
			if (!equation.getLeftHandSide().getParts().isEmpty()) {
				EquationPart equationPart = equation.getLeftHandSide().getParts().get(0);
				VariableReference variableReference = equationPart.getVariableReference();
				VariableReferenceDescriptor descriptor = new VariableReferenceDescriptor(variableReference.getName(), variableReference.getStep());
				EquationPart previousEquationPart = descriptors.put(descriptor, equationPart);
				if (previousEquationPart != null) {
					if (diagnostics != null) {
						StringBuilder message = new StringBuilder();
						message.append("Duplicate equation for ");
						message.append(variableReference.getName());
						message.append("(n");
						if (variableReference.getStep() >= 0) {
							message.append("+");
						}
						message.append(variableReference.getStep());
						message.append(")");
						
						if (result) {
							diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
									FunctionModelValidator.DIAGNOSTIC_SOURCE,
									FunctionModelValidator.FUNCTION__EQUATION_EXISTS_FOR_EACH_OUTPUT,
									message.toString(),
									new Object[] { previousEquationPart.getFeatureCall() }));
						}
						diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
								FunctionModelValidator.DIAGNOSTIC_SOURCE,
								FunctionModelValidator.FUNCTION__EQUATION_EXISTS_FOR_EACH_OUTPUT,
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
	 * @generated NOT
	 */
	public boolean equationExistsForEachOutput(DiagnosticChain diagnostics, Map<Object, Object> context) {
		Set<String> outputs = new HashSet<String>();
		for (Equation equation : getEquations()) {
			if (!equation.getLeftHandSide().getParts().isEmpty()) {
				VariableReference variableReference = equation.getLeftHandSide().getParts().get(0).getVariableReference();
				if (variableReference.getKind() == VariableReferenceKind.OUTPUT_PARAMETER
						&& variableReference.getStep() == 0
						&& !variableReference.isInitial()) {
					outputs.add(variableReference.getName());
				}
			}
		}
		boolean result = true;
		for (ParameterDeclaration parameterDeclaration : getDefinition().getOutputParameters()) {
			if (!outputs.contains(parameterDeclaration.getName())) {
				if (diagnostics != null) {
					diagnostics.add(new BasicDiagnostic(
							Diagnostic.ERROR,
							FunctionModelValidator.DIAGNOSTIC_SOURCE,
							FunctionModelValidator.FUNCTION__EQUATION_EXISTS_FOR_EACH_OUTPUT,
							"No step-n equation for output '" + parameterDeclaration.getName() + "' specified",
							new Object [] { parameterDeclaration }));
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
	public boolean equationExistsForEachStep(DiagnosticChain diagnostics, Map<Object, Object> context) {
		for (Equation equation : getEquations()) {
			for (EquationPart equationPart : equation.getRightHandSide().getParts()) {
				VariableReference variableReference = equationPart.getVariableReference();
				if (!variableReference.isInitial() && variableReference.getStep() <= 0) {
					for (int i = 0; i >= variableReference.getStep(); --i) {
						// check initials
					}
				}
			}
		}
//		if (false) {
//			if (diagnostics != null) {
//				diagnostics.add
//					(new BasicDiagnostic
//						(Diagnostic.ERROR,
//						 FunctionModelValidator.DIAGNOSTIC_SOURCE,
//						 FunctionModelValidator.FUNCTION__EQUATION_EXISTS_FOR_EACH_STEP,
//						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "equationExistsForEachStep", EObjectValidator.getObjectLabel(this, context) }),
//						 new Object [] { this }));
//			}
//			return false;
//		}
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
