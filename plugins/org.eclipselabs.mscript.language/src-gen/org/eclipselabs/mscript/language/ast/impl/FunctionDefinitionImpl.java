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
import org.eclipselabs.mscript.language.ast.StateVariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#isStateful <em>Stateful</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getTemplateParameterDeclarations <em>Template Parameter Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getInputParameterDeclarations <em>Input Parameter Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getOutputParameterDeclarations <em>Output Parameter Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getAssertionDeclarations <em>Assertion Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getFunctorDeclarations <em>Functor Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getStateVariableDeclarations <em>State Variable Declarations</em>}</li>
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
   * The cached value of the '{@link #getTemplateParameterDeclarations() <em>Template Parameter Declarations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplateParameterDeclarations()
   * @generated
   * @ordered
   */
  protected EList<ParameterDeclaration> templateParameterDeclarations;

  /**
   * The cached value of the '{@link #getInputParameterDeclarations() <em>Input Parameter Declarations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputParameterDeclarations()
   * @generated
   * @ordered
   */
  protected EList<ParameterDeclaration> inputParameterDeclarations;

  /**
   * The cached value of the '{@link #getOutputParameterDeclarations() <em>Output Parameter Declarations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutputParameterDeclarations()
   * @generated
   * @ordered
   */
  protected EList<ParameterDeclaration> outputParameterDeclarations;

  /**
   * The cached value of the '{@link #getAssertionDeclarations() <em>Assertion Declarations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssertionDeclarations()
   * @generated
   * @ordered
   */
  protected EList<AssertionDeclaration> assertionDeclarations;

  /**
   * The cached value of the '{@link #getFunctorDeclarations() <em>Functor Declarations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctorDeclarations()
   * @generated
   * @ordered
   */
  protected EList<FunctorDeclaration> functorDeclarations;

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
  public EList<ParameterDeclaration> getTemplateParameterDeclarations()
  {
    if (templateParameterDeclarations == null)
    {
      templateParameterDeclarations = new EObjectContainmentEList<ParameterDeclaration>(ParameterDeclaration.class, this, AstPackage.FUNCTION_DEFINITION__TEMPLATE_PARAMETER_DECLARATIONS);
    }
    return templateParameterDeclarations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ParameterDeclaration> getInputParameterDeclarations()
  {
    if (inputParameterDeclarations == null)
    {
      inputParameterDeclarations = new EObjectContainmentEList<ParameterDeclaration>(ParameterDeclaration.class, this, AstPackage.FUNCTION_DEFINITION__INPUT_PARAMETER_DECLARATIONS);
    }
    return inputParameterDeclarations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ParameterDeclaration> getOutputParameterDeclarations()
  {
    if (outputParameterDeclarations == null)
    {
      outputParameterDeclarations = new EObjectContainmentEList<ParameterDeclaration>(ParameterDeclaration.class, this, AstPackage.FUNCTION_DEFINITION__OUTPUT_PARAMETER_DECLARATIONS);
    }
    return outputParameterDeclarations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AssertionDeclaration> getAssertionDeclarations()
  {
    if (assertionDeclarations == null)
    {
      assertionDeclarations = new EObjectContainmentEList<AssertionDeclaration>(AssertionDeclaration.class, this, AstPackage.FUNCTION_DEFINITION__ASSERTION_DECLARATIONS);
    }
    return assertionDeclarations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FunctorDeclaration> getFunctorDeclarations()
  {
    if (functorDeclarations == null)
    {
      functorDeclarations = new EObjectContainmentEList<FunctorDeclaration>(FunctorDeclaration.class, this, AstPackage.FUNCTION_DEFINITION__FUNCTOR_DECLARATIONS);
    }
    return functorDeclarations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StateVariableDeclaration> getStateVariableDeclarations()
  {
    if (stateVariableDeclarations == null)
    {
      stateVariableDeclarations = new EObjectContainmentEList<StateVariableDeclaration>(StateVariableDeclaration.class, this, AstPackage.FUNCTION_DEFINITION__STATE_VARIABLE_DECLARATIONS);
    }
    return stateVariableDeclarations;
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
      case AstPackage.FUNCTION_DEFINITION__TEMPLATE_PARAMETER_DECLARATIONS:
        return ((InternalEList<?>)getTemplateParameterDeclarations()).basicRemove(otherEnd, msgs);
      case AstPackage.FUNCTION_DEFINITION__INPUT_PARAMETER_DECLARATIONS:
        return ((InternalEList<?>)getInputParameterDeclarations()).basicRemove(otherEnd, msgs);
      case AstPackage.FUNCTION_DEFINITION__OUTPUT_PARAMETER_DECLARATIONS:
        return ((InternalEList<?>)getOutputParameterDeclarations()).basicRemove(otherEnd, msgs);
      case AstPackage.FUNCTION_DEFINITION__ASSERTION_DECLARATIONS:
        return ((InternalEList<?>)getAssertionDeclarations()).basicRemove(otherEnd, msgs);
      case AstPackage.FUNCTION_DEFINITION__FUNCTOR_DECLARATIONS:
        return ((InternalEList<?>)getFunctorDeclarations()).basicRemove(otherEnd, msgs);
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
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case AstPackage.FUNCTION_DEFINITION__STATEFUL:
        return isStateful();
      case AstPackage.FUNCTION_DEFINITION__TEMPLATE_PARAMETER_DECLARATIONS:
        return getTemplateParameterDeclarations();
      case AstPackage.FUNCTION_DEFINITION__INPUT_PARAMETER_DECLARATIONS:
        return getInputParameterDeclarations();
      case AstPackage.FUNCTION_DEFINITION__OUTPUT_PARAMETER_DECLARATIONS:
        return getOutputParameterDeclarations();
      case AstPackage.FUNCTION_DEFINITION__ASSERTION_DECLARATIONS:
        return getAssertionDeclarations();
      case AstPackage.FUNCTION_DEFINITION__FUNCTOR_DECLARATIONS:
        return getFunctorDeclarations();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AstPackage.FUNCTION_DEFINITION__STATEFUL:
        setStateful((Boolean)newValue);
        return;
      case AstPackage.FUNCTION_DEFINITION__TEMPLATE_PARAMETER_DECLARATIONS:
        getTemplateParameterDeclarations().clear();
        getTemplateParameterDeclarations().addAll((Collection<? extends ParameterDeclaration>)newValue);
        return;
      case AstPackage.FUNCTION_DEFINITION__INPUT_PARAMETER_DECLARATIONS:
        getInputParameterDeclarations().clear();
        getInputParameterDeclarations().addAll((Collection<? extends ParameterDeclaration>)newValue);
        return;
      case AstPackage.FUNCTION_DEFINITION__OUTPUT_PARAMETER_DECLARATIONS:
        getOutputParameterDeclarations().clear();
        getOutputParameterDeclarations().addAll((Collection<? extends ParameterDeclaration>)newValue);
        return;
      case AstPackage.FUNCTION_DEFINITION__ASSERTION_DECLARATIONS:
        getAssertionDeclarations().clear();
        getAssertionDeclarations().addAll((Collection<? extends AssertionDeclaration>)newValue);
        return;
      case AstPackage.FUNCTION_DEFINITION__FUNCTOR_DECLARATIONS:
        getFunctorDeclarations().clear();
        getFunctorDeclarations().addAll((Collection<? extends FunctorDeclaration>)newValue);
        return;
      case AstPackage.FUNCTION_DEFINITION__STATE_VARIABLE_DECLARATIONS:
        getStateVariableDeclarations().clear();
        getStateVariableDeclarations().addAll((Collection<? extends StateVariableDeclaration>)newValue);
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
      case AstPackage.FUNCTION_DEFINITION__TEMPLATE_PARAMETER_DECLARATIONS:
        getTemplateParameterDeclarations().clear();
        return;
      case AstPackage.FUNCTION_DEFINITION__INPUT_PARAMETER_DECLARATIONS:
        getInputParameterDeclarations().clear();
        return;
      case AstPackage.FUNCTION_DEFINITION__OUTPUT_PARAMETER_DECLARATIONS:
        getOutputParameterDeclarations().clear();
        return;
      case AstPackage.FUNCTION_DEFINITION__ASSERTION_DECLARATIONS:
        getAssertionDeclarations().clear();
        return;
      case AstPackage.FUNCTION_DEFINITION__FUNCTOR_DECLARATIONS:
        getFunctorDeclarations().clear();
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case AstPackage.FUNCTION_DEFINITION__STATEFUL:
        return stateful != STATEFUL_EDEFAULT;
      case AstPackage.FUNCTION_DEFINITION__TEMPLATE_PARAMETER_DECLARATIONS:
        return templateParameterDeclarations != null && !templateParameterDeclarations.isEmpty();
      case AstPackage.FUNCTION_DEFINITION__INPUT_PARAMETER_DECLARATIONS:
        return inputParameterDeclarations != null && !inputParameterDeclarations.isEmpty();
      case AstPackage.FUNCTION_DEFINITION__OUTPUT_PARAMETER_DECLARATIONS:
        return outputParameterDeclarations != null && !outputParameterDeclarations.isEmpty();
      case AstPackage.FUNCTION_DEFINITION__ASSERTION_DECLARATIONS:
        return assertionDeclarations != null && !assertionDeclarations.isEmpty();
      case AstPackage.FUNCTION_DEFINITION__FUNCTOR_DECLARATIONS:
        return functorDeclarations != null && !functorDeclarations.isEmpty();
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
