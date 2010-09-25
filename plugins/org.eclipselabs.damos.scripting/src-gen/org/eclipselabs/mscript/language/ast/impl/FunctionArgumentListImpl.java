/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.FunctionArgumentList;
import org.eclipselabs.mscript.language.ast.NamedArgument;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Argument List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionArgumentListImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionArgumentListImpl#getNamedArguments <em>Named Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionArgumentListImpl extends MinimalEObjectImpl.Container implements FunctionArgumentList
{
  /**
   * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArguments()
   * @generated
   * @ordered
   */
  protected EList<Expression> arguments;

  /**
   * The cached value of the '{@link #getNamedArguments() <em>Named Arguments</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamedArguments()
   * @generated
   * @ordered
   */
  protected EList<NamedArgument> namedArguments;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FunctionArgumentListImpl()
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
    return AstPackage.Literals.FUNCTION_ARGUMENT_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getArguments()
  {
    if (arguments == null)
    {
      arguments = new EObjectContainmentEList<Expression>(Expression.class, this, AstPackage.FUNCTION_ARGUMENT_LIST__ARGUMENTS);
    }
    return arguments;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NamedArgument> getNamedArguments()
  {
    if (namedArguments == null)
    {
      namedArguments = new EObjectContainmentEList<NamedArgument>(NamedArgument.class, this, AstPackage.FUNCTION_ARGUMENT_LIST__NAMED_ARGUMENTS);
    }
    return namedArguments;
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
      case AstPackage.FUNCTION_ARGUMENT_LIST__ARGUMENTS:
        return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
      case AstPackage.FUNCTION_ARGUMENT_LIST__NAMED_ARGUMENTS:
        return ((InternalEList<?>)getNamedArguments()).basicRemove(otherEnd, msgs);
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
      case AstPackage.FUNCTION_ARGUMENT_LIST__ARGUMENTS:
        return getArguments();
      case AstPackage.FUNCTION_ARGUMENT_LIST__NAMED_ARGUMENTS:
        return getNamedArguments();
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
      case AstPackage.FUNCTION_ARGUMENT_LIST__ARGUMENTS:
        getArguments().clear();
        getArguments().addAll((Collection<? extends Expression>)newValue);
        return;
      case AstPackage.FUNCTION_ARGUMENT_LIST__NAMED_ARGUMENTS:
        getNamedArguments().clear();
        getNamedArguments().addAll((Collection<? extends NamedArgument>)newValue);
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
      case AstPackage.FUNCTION_ARGUMENT_LIST__ARGUMENTS:
        getArguments().clear();
        return;
      case AstPackage.FUNCTION_ARGUMENT_LIST__NAMED_ARGUMENTS:
        getNamedArguments().clear();
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
      case AstPackage.FUNCTION_ARGUMENT_LIST__ARGUMENTS:
        return arguments != null && !arguments.isEmpty();
      case AstPackage.FUNCTION_ARGUMENT_LIST__NAMED_ARGUMENTS:
        return namedArguments != null && !namedArguments.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FunctionArgumentListImpl
