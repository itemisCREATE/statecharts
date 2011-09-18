/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mscript.language.ast.Assertion;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.Check;
import org.eclipselabs.mscript.language.ast.Equation;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.FunctionKind;
import org.eclipselabs.mscript.language.ast.FunctionObjectDeclaration;
import org.eclipselabs.mscript.language.ast.InputParameterDeclaration;
import org.eclipselabs.mscript.language.ast.OutputParameterDeclaration;
import org.eclipselabs.mscript.language.ast.StateVariableDeclaration;
import org.eclipselabs.mscript.language.ast.TemplateParameterDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getTemplateParameterDeclarations <em>Template Parameter Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getInputParameterDeclarations <em>Input Parameter Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getOutputParameterDeclarations <em>Output Parameter Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getChecks <em>Checks</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getAssertions <em>Assertions</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getFunctionObjectDeclarations <em>Function Object Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getStateVariableDeclarations <em>State Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getEquations <em>Equations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionDefinitionImpl extends DefinitionImpl implements FunctionDefinition {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final FunctionKind KIND_EDEFAULT = FunctionKind.STATELESS;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected FunctionKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTemplateParameterDeclarations() <em>Template Parameter Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateParameterDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<TemplateParameterDeclaration> templateParameterDeclarations;

	/**
	 * The cached value of the '{@link #getInputParameterDeclarations() <em>Input Parameter Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputParameterDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<InputParameterDeclaration> inputParameterDeclarations;

	/**
	 * The cached value of the '{@link #getOutputParameterDeclarations() <em>Output Parameter Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputParameterDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputParameterDeclaration> outputParameterDeclarations;

	/**
	 * The cached value of the '{@link #getChecks() <em>Checks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChecks()
	 * @generated
	 * @ordered
	 */
	protected EList<Check> checks;

	/**
	 * The cached value of the '{@link #getAssertions() <em>Assertions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssertions()
	 * @generated
	 * @ordered
	 */
	protected EList<Assertion> assertions;

	/**
	 * The cached value of the '{@link #getFunctionObjectDeclarations() <em>Function Object Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionObjectDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionObjectDeclaration> functionObjectDeclarations;

	/**
	 * The cached value of the '{@link #getStateVariableDeclarations() <em>State Variable Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateVariableDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<StateVariableDeclaration> stateVariableDeclarations;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.FUNCTION_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(FunctionKind newKind) {
		FunctionKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FUNCTION_DEFINITION__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TemplateParameterDeclaration> getTemplateParameterDeclarations() {
		if (templateParameterDeclarations == null) {
			templateParameterDeclarations = new EObjectContainmentEList<TemplateParameterDeclaration>(TemplateParameterDeclaration.class, this, AstPackage.FUNCTION_DEFINITION__TEMPLATE_PARAMETER_DECLARATIONS);
		}
		return templateParameterDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputParameterDeclaration> getInputParameterDeclarations() {
		if (inputParameterDeclarations == null) {
			inputParameterDeclarations = new EObjectContainmentEList<InputParameterDeclaration>(InputParameterDeclaration.class, this, AstPackage.FUNCTION_DEFINITION__INPUT_PARAMETER_DECLARATIONS);
		}
		return inputParameterDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputParameterDeclaration> getOutputParameterDeclarations() {
		if (outputParameterDeclarations == null) {
			outputParameterDeclarations = new EObjectContainmentEList<OutputParameterDeclaration>(OutputParameterDeclaration.class, this, AstPackage.FUNCTION_DEFINITION__OUTPUT_PARAMETER_DECLARATIONS);
		}
		return outputParameterDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Check> getChecks() {
		if (checks == null) {
			checks = new EObjectContainmentWithInverseEList<Check>(Check.class, this, AstPackage.FUNCTION_DEFINITION__CHECKS, AstPackage.CHECK__FUNCTION);
		}
		return checks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Assertion> getAssertions() {
		if (assertions == null) {
			assertions = new EObjectContainmentEList<Assertion>(Assertion.class, this, AstPackage.FUNCTION_DEFINITION__ASSERTIONS);
		}
		return assertions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionObjectDeclaration> getFunctionObjectDeclarations() {
		if (functionObjectDeclarations == null) {
			functionObjectDeclarations = new EObjectContainmentEList<FunctionObjectDeclaration>(FunctionObjectDeclaration.class, this, AstPackage.FUNCTION_DEFINITION__FUNCTION_OBJECT_DECLARATIONS);
		}
		return functionObjectDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StateVariableDeclaration> getStateVariableDeclarations() {
		if (stateVariableDeclarations == null) {
			stateVariableDeclarations = new EObjectContainmentEList<StateVariableDeclaration>(StateVariableDeclaration.class, this, AstPackage.FUNCTION_DEFINITION__STATE_VARIABLE_DECLARATIONS);
		}
		return stateVariableDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Equation> getEquations() {
		if (equations == null) {
			equations = new EObjectContainmentEList<Equation>(Equation.class, this, AstPackage.FUNCTION_DEFINITION__EQUATIONS);
		}
		return equations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getQualifiedName() {
		return getName();
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
			case AstPackage.FUNCTION_DEFINITION__CHECKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChecks()).basicAdd(otherEnd, msgs);
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
			case AstPackage.FUNCTION_DEFINITION__TEMPLATE_PARAMETER_DECLARATIONS:
				return ((InternalEList<?>)getTemplateParameterDeclarations()).basicRemove(otherEnd, msgs);
			case AstPackage.FUNCTION_DEFINITION__INPUT_PARAMETER_DECLARATIONS:
				return ((InternalEList<?>)getInputParameterDeclarations()).basicRemove(otherEnd, msgs);
			case AstPackage.FUNCTION_DEFINITION__OUTPUT_PARAMETER_DECLARATIONS:
				return ((InternalEList<?>)getOutputParameterDeclarations()).basicRemove(otherEnd, msgs);
			case AstPackage.FUNCTION_DEFINITION__CHECKS:
				return ((InternalEList<?>)getChecks()).basicRemove(otherEnd, msgs);
			case AstPackage.FUNCTION_DEFINITION__ASSERTIONS:
				return ((InternalEList<?>)getAssertions()).basicRemove(otherEnd, msgs);
			case AstPackage.FUNCTION_DEFINITION__FUNCTION_OBJECT_DECLARATIONS:
				return ((InternalEList<?>)getFunctionObjectDeclarations()).basicRemove(otherEnd, msgs);
			case AstPackage.FUNCTION_DEFINITION__STATE_VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getStateVariableDeclarations()).basicRemove(otherEnd, msgs);
			case AstPackage.FUNCTION_DEFINITION__EQUATIONS:
				return ((InternalEList<?>)getEquations()).basicRemove(otherEnd, msgs);
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
			case AstPackage.FUNCTION_DEFINITION__KIND:
				return getKind();
			case AstPackage.FUNCTION_DEFINITION__TEMPLATE_PARAMETER_DECLARATIONS:
				return getTemplateParameterDeclarations();
			case AstPackage.FUNCTION_DEFINITION__INPUT_PARAMETER_DECLARATIONS:
				return getInputParameterDeclarations();
			case AstPackage.FUNCTION_DEFINITION__OUTPUT_PARAMETER_DECLARATIONS:
				return getOutputParameterDeclarations();
			case AstPackage.FUNCTION_DEFINITION__CHECKS:
				return getChecks();
			case AstPackage.FUNCTION_DEFINITION__ASSERTIONS:
				return getAssertions();
			case AstPackage.FUNCTION_DEFINITION__FUNCTION_OBJECT_DECLARATIONS:
				return getFunctionObjectDeclarations();
			case AstPackage.FUNCTION_DEFINITION__STATE_VARIABLE_DECLARATIONS:
				return getStateVariableDeclarations();
			case AstPackage.FUNCTION_DEFINITION__EQUATIONS:
				return getEquations();
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
			case AstPackage.FUNCTION_DEFINITION__KIND:
				setKind((FunctionKind)newValue);
				return;
			case AstPackage.FUNCTION_DEFINITION__TEMPLATE_PARAMETER_DECLARATIONS:
				getTemplateParameterDeclarations().clear();
				getTemplateParameterDeclarations().addAll((Collection<? extends TemplateParameterDeclaration>)newValue);
				return;
			case AstPackage.FUNCTION_DEFINITION__INPUT_PARAMETER_DECLARATIONS:
				getInputParameterDeclarations().clear();
				getInputParameterDeclarations().addAll((Collection<? extends InputParameterDeclaration>)newValue);
				return;
			case AstPackage.FUNCTION_DEFINITION__OUTPUT_PARAMETER_DECLARATIONS:
				getOutputParameterDeclarations().clear();
				getOutputParameterDeclarations().addAll((Collection<? extends OutputParameterDeclaration>)newValue);
				return;
			case AstPackage.FUNCTION_DEFINITION__CHECKS:
				getChecks().clear();
				getChecks().addAll((Collection<? extends Check>)newValue);
				return;
			case AstPackage.FUNCTION_DEFINITION__ASSERTIONS:
				getAssertions().clear();
				getAssertions().addAll((Collection<? extends Assertion>)newValue);
				return;
			case AstPackage.FUNCTION_DEFINITION__FUNCTION_OBJECT_DECLARATIONS:
				getFunctionObjectDeclarations().clear();
				getFunctionObjectDeclarations().addAll((Collection<? extends FunctionObjectDeclaration>)newValue);
				return;
			case AstPackage.FUNCTION_DEFINITION__STATE_VARIABLE_DECLARATIONS:
				getStateVariableDeclarations().clear();
				getStateVariableDeclarations().addAll((Collection<? extends StateVariableDeclaration>)newValue);
				return;
			case AstPackage.FUNCTION_DEFINITION__EQUATIONS:
				getEquations().clear();
				getEquations().addAll((Collection<? extends Equation>)newValue);
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
			case AstPackage.FUNCTION_DEFINITION__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case AstPackage.FUNCTION_DEFINITION__TEMPLATE_PARAMETER_DECLARATIONS:
				getTemplateParameterDeclarations().clear();
				return;
			case AstPackage.FUNCTION_DEFINITION__INPUT_PARAMETER_DECLARATIONS:
				getInputParameterDeclarations().clear();
				return;
			case AstPackage.FUNCTION_DEFINITION__OUTPUT_PARAMETER_DECLARATIONS:
				getOutputParameterDeclarations().clear();
				return;
			case AstPackage.FUNCTION_DEFINITION__CHECKS:
				getChecks().clear();
				return;
			case AstPackage.FUNCTION_DEFINITION__ASSERTIONS:
				getAssertions().clear();
				return;
			case AstPackage.FUNCTION_DEFINITION__FUNCTION_OBJECT_DECLARATIONS:
				getFunctionObjectDeclarations().clear();
				return;
			case AstPackage.FUNCTION_DEFINITION__STATE_VARIABLE_DECLARATIONS:
				getStateVariableDeclarations().clear();
				return;
			case AstPackage.FUNCTION_DEFINITION__EQUATIONS:
				getEquations().clear();
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
			case AstPackage.FUNCTION_DEFINITION__KIND:
				return kind != KIND_EDEFAULT;
			case AstPackage.FUNCTION_DEFINITION__TEMPLATE_PARAMETER_DECLARATIONS:
				return templateParameterDeclarations != null && !templateParameterDeclarations.isEmpty();
			case AstPackage.FUNCTION_DEFINITION__INPUT_PARAMETER_DECLARATIONS:
				return inputParameterDeclarations != null && !inputParameterDeclarations.isEmpty();
			case AstPackage.FUNCTION_DEFINITION__OUTPUT_PARAMETER_DECLARATIONS:
				return outputParameterDeclarations != null && !outputParameterDeclarations.isEmpty();
			case AstPackage.FUNCTION_DEFINITION__CHECKS:
				return checks != null && !checks.isEmpty();
			case AstPackage.FUNCTION_DEFINITION__ASSERTIONS:
				return assertions != null && !assertions.isEmpty();
			case AstPackage.FUNCTION_DEFINITION__FUNCTION_OBJECT_DECLARATIONS:
				return functionObjectDeclarations != null && !functionObjectDeclarations.isEmpty();
			case AstPackage.FUNCTION_DEFINITION__STATE_VARIABLE_DECLARATIONS:
				return stateVariableDeclarations != null && !stateVariableDeclarations.isEmpty();
			case AstPackage.FUNCTION_DEFINITION__EQUATIONS:
				return equations != null && !equations.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //FunctionDefinitionImpl
