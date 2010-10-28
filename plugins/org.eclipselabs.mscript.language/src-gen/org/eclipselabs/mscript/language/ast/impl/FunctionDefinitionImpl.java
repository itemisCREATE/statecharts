/**
 * <copyright>
 * </copyright>
 *
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
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipselabs.mscript.language.ast.AssertionDeclaration;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.EquationDefinition;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.FunctorDeclaration;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.ast.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#isStateful <em>Stateful</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getTemplateParameters <em>Template Parameters</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getInputParameters <em>Input Parameters</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getOutputParameters <em>Output Parameters</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getAssertions <em>Assertions</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getFunctors <em>Functors</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getStateVariables <em>State Variables</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getEquations <em>Equations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionDefinitionImpl extends TypeDefinitionImpl implements FunctionDefinition
{
  /**
   * The default value of the '{@link #isStateful() <em>Stateful</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStateful()
   * @generated
   * @ordered
   */
  protected static final boolean STATEFUL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStateful() <em>Stateful</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStateful()
   * @generated
   * @ordered
   */
  protected boolean stateful = STATEFUL_EDEFAULT;

  /**
   * The cached value of the '{@link #getTemplateParameters() <em>Template Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplateParameters()
   * @generated
   * @ordered
   */
  protected EList<ParameterDeclaration> templateParameters;

  /**
   * The cached value of the '{@link #getInputParameters() <em>Input Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputParameters()
   * @generated
   * @ordered
   */
  protected EList<ParameterDeclaration> inputParameters;

  /**
   * The cached value of the '{@link #getOutputParameters() <em>Output Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutputParameters()
   * @generated
   * @ordered
   */
  protected EList<ParameterDeclaration> outputParameters;

  /**
   * The cached value of the '{@link #getAssertions() <em>Assertions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssertions()
   * @generated
   * @ordered
   */
  protected EList<AssertionDeclaration> assertions;

  /**
   * The cached value of the '{@link #getFunctors() <em>Functors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctors()
   * @generated
   * @ordered
   */
  protected EList<FunctorDeclaration> functors;

  /**
   * The cached value of the '{@link #getStateVariables() <em>State Variables</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateVariables()
   * @generated
   * @ordered
   */
  protected EList<VariableDeclaration> stateVariables;

  /**
   * The cached value of the '{@link #getEquations() <em>Equations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEquations()
   * @generated
   * @ordered
   */
  protected EList<EquationDefinition> equations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FunctionDefinitionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return AstPackage.Literals.FUNCTION_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isStateful()
  {
    return stateful;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStateful(boolean newStateful)
  {
    boolean oldStateful = stateful;
    stateful = newStateful;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FUNCTION_DEFINITION__STATEFUL, oldStateful, stateful));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ParameterDeclaration> getTemplateParameters()
  {
    if (templateParameters == null)
    {
      templateParameters = new EObjectContainmentEList<ParameterDeclaration>(ParameterDeclaration.class, this, AstPackage.FUNCTION_DEFINITION__TEMPLATE_PARAMETERS);
    }
    return templateParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ParameterDeclaration> getInputParameters()
  {
    if (inputParameters == null)
    {
      inputParameters = new EObjectContainmentEList<ParameterDeclaration>(ParameterDeclaration.class, this, AstPackage.FUNCTION_DEFINITION__INPUT_PARAMETERS);
    }
    return inputParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ParameterDeclaration> getOutputParameters()
  {
    if (outputParameters == null)
    {
      outputParameters = new EObjectContainmentEList<ParameterDeclaration>(ParameterDeclaration.class, this, AstPackage.FUNCTION_DEFINITION__OUTPUT_PARAMETERS);
    }
    return outputParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AssertionDeclaration> getAssertions()
  {
    if (assertions == null)
    {
      assertions = new EObjectContainmentEList<AssertionDeclaration>(AssertionDeclaration.class, this, AstPackage.FUNCTION_DEFINITION__ASSERTIONS);
    }
    return assertions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FunctorDeclaration> getFunctors()
  {
    if (functors == null)
    {
      functors = new EObjectContainmentEList<FunctorDeclaration>(FunctorDeclaration.class, this, AstPackage.FUNCTION_DEFINITION__FUNCTORS);
    }
    return functors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VariableDeclaration> getStateVariables()
  {
    if (stateVariables == null)
    {
      stateVariables = new EObjectContainmentEList<VariableDeclaration>(VariableDeclaration.class, this, AstPackage.FUNCTION_DEFINITION__STATE_VARIABLES);
    }
    return stateVariables;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EquationDefinition> getEquations()
  {
    if (equations == null)
    {
      equations = new EObjectContainmentEList<EquationDefinition>(EquationDefinition.class, this, AstPackage.FUNCTION_DEFINITION__EQUATIONS);
    }
    return equations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AstPackage.FUNCTION_DEFINITION__TEMPLATE_PARAMETERS:
        return ((InternalEList<?>)getTemplateParameters()).basicRemove(otherEnd, msgs);
      case AstPackage.FUNCTION_DEFINITION__INPUT_PARAMETERS:
        return ((InternalEList<?>)getInputParameters()).basicRemove(otherEnd, msgs);
      case AstPackage.FUNCTION_DEFINITION__OUTPUT_PARAMETERS:
        return ((InternalEList<?>)getOutputParameters()).basicRemove(otherEnd, msgs);
      case AstPackage.FUNCTION_DEFINITION__ASSERTIONS:
        return ((InternalEList<?>)getAssertions()).basicRemove(otherEnd, msgs);
      case AstPackage.FUNCTION_DEFINITION__FUNCTORS:
        return ((InternalEList<?>)getFunctors()).basicRemove(otherEnd, msgs);
      case AstPackage.FUNCTION_DEFINITION__STATE_VARIABLES:
        return ((InternalEList<?>)getStateVariables()).basicRemove(otherEnd, msgs);
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
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case AstPackage.FUNCTION_DEFINITION__STATEFUL:
        return isStateful();
      case AstPackage.FUNCTION_DEFINITION__TEMPLATE_PARAMETERS:
        return getTemplateParameters();
      case AstPackage.FUNCTION_DEFINITION__INPUT_PARAMETERS:
        return getInputParameters();
      case AstPackage.FUNCTION_DEFINITION__OUTPUT_PARAMETERS:
        return getOutputParameters();
      case AstPackage.FUNCTION_DEFINITION__ASSERTIONS:
        return getAssertions();
      case AstPackage.FUNCTION_DEFINITION__FUNCTORS:
        return getFunctors();
      case AstPackage.FUNCTION_DEFINITION__STATE_VARIABLES:
        return getStateVariables();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AstPackage.FUNCTION_DEFINITION__STATEFUL:
        setStateful((Boolean)newValue);
        return;
      case AstPackage.FUNCTION_DEFINITION__TEMPLATE_PARAMETERS:
        getTemplateParameters().clear();
        getTemplateParameters().addAll((Collection<? extends ParameterDeclaration>)newValue);
        return;
      case AstPackage.FUNCTION_DEFINITION__INPUT_PARAMETERS:
        getInputParameters().clear();
        getInputParameters().addAll((Collection<? extends ParameterDeclaration>)newValue);
        return;
      case AstPackage.FUNCTION_DEFINITION__OUTPUT_PARAMETERS:
        getOutputParameters().clear();
        getOutputParameters().addAll((Collection<? extends ParameterDeclaration>)newValue);
        return;
      case AstPackage.FUNCTION_DEFINITION__ASSERTIONS:
        getAssertions().clear();
        getAssertions().addAll((Collection<? extends AssertionDeclaration>)newValue);
        return;
      case AstPackage.FUNCTION_DEFINITION__FUNCTORS:
        getFunctors().clear();
        getFunctors().addAll((Collection<? extends FunctorDeclaration>)newValue);
        return;
      case AstPackage.FUNCTION_DEFINITION__STATE_VARIABLES:
        getStateVariables().clear();
        getStateVariables().addAll((Collection<? extends VariableDeclaration>)newValue);
        return;
      case AstPackage.FUNCTION_DEFINITION__EQUATIONS:
        getEquations().clear();
        getEquations().addAll((Collection<? extends EquationDefinition>)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case AstPackage.FUNCTION_DEFINITION__STATEFUL:
        setStateful(STATEFUL_EDEFAULT);
        return;
      case AstPackage.FUNCTION_DEFINITION__TEMPLATE_PARAMETERS:
        getTemplateParameters().clear();
        return;
      case AstPackage.FUNCTION_DEFINITION__INPUT_PARAMETERS:
        getInputParameters().clear();
        return;
      case AstPackage.FUNCTION_DEFINITION__OUTPUT_PARAMETERS:
        getOutputParameters().clear();
        return;
      case AstPackage.FUNCTION_DEFINITION__ASSERTIONS:
        getAssertions().clear();
        return;
      case AstPackage.FUNCTION_DEFINITION__FUNCTORS:
        getFunctors().clear();
        return;
      case AstPackage.FUNCTION_DEFINITION__STATE_VARIABLES:
        getStateVariables().clear();
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case AstPackage.FUNCTION_DEFINITION__STATEFUL:
        return stateful != STATEFUL_EDEFAULT;
      case AstPackage.FUNCTION_DEFINITION__TEMPLATE_PARAMETERS:
        return templateParameters != null && !templateParameters.isEmpty();
      case AstPackage.FUNCTION_DEFINITION__INPUT_PARAMETERS:
        return inputParameters != null && !inputParameters.isEmpty();
      case AstPackage.FUNCTION_DEFINITION__OUTPUT_PARAMETERS:
        return outputParameters != null && !outputParameters.isEmpty();
      case AstPackage.FUNCTION_DEFINITION__ASSERTIONS:
        return assertions != null && !assertions.isEmpty();
      case AstPackage.FUNCTION_DEFINITION__FUNCTORS:
        return functors != null && !functors.isEmpty();
      case AstPackage.FUNCTION_DEFINITION__STATE_VARIABLES:
        return stateVariables != null && !stateVariables.isEmpty();
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
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (stateful: ");
    result.append(stateful);
    result.append(')');
    return result.toString();
  }

} //FunctionDefinitionImpl
