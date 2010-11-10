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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipselabs.mscript.language.ast.ArgumentDeclaration;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.FunctorDeclaration;
import org.eclipselabs.mscript.language.ast.QualifiedName;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Functor Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctorDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctorDeclarationImpl#getFunctionName <em>Function Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctorDeclarationImpl#getTemplateArgumentDeclarations <em>Template Argument Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctorDeclarationImpl extends MinimalEObjectImpl.Container implements FunctorDeclaration
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getFunctionName() <em>Function Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctionName()
   * @generated
   * @ordered
   */
  protected QualifiedName functionName;

  /**
   * The cached value of the '{@link #getTemplateArgumentDeclarations() <em>Template Argument Declarations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplateArgumentDeclarations()
   * @generated
   * @ordered
   */
  protected EList<ArgumentDeclaration> templateArgumentDeclarations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FunctorDeclarationImpl()
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
    return AstPackage.Literals.FUNCTOR_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FUNCTOR_DECLARATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedName getFunctionName()
  {
    return functionName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFunctionName(QualifiedName newFunctionName, NotificationChain msgs)
  {
    QualifiedName oldFunctionName = functionName;
    functionName = newFunctionName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.FUNCTOR_DECLARATION__FUNCTION_NAME, oldFunctionName, newFunctionName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunctionName(QualifiedName newFunctionName)
  {
    if (newFunctionName != functionName)
    {
      NotificationChain msgs = null;
      if (functionName != null)
        msgs = ((InternalEObject)functionName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.FUNCTOR_DECLARATION__FUNCTION_NAME, null, msgs);
      if (newFunctionName != null)
        msgs = ((InternalEObject)newFunctionName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.FUNCTOR_DECLARATION__FUNCTION_NAME, null, msgs);
      msgs = basicSetFunctionName(newFunctionName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FUNCTOR_DECLARATION__FUNCTION_NAME, newFunctionName, newFunctionName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ArgumentDeclaration> getTemplateArgumentDeclarations()
  {
    if (templateArgumentDeclarations == null)
    {
      templateArgumentDeclarations = new EObjectContainmentEList<ArgumentDeclaration>(ArgumentDeclaration.class, this, AstPackage.FUNCTOR_DECLARATION__TEMPLATE_ARGUMENT_DECLARATIONS);
    }
    return templateArgumentDeclarations;
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
      case AstPackage.FUNCTOR_DECLARATION__FUNCTION_NAME:
        return basicSetFunctionName(null, msgs);
      case AstPackage.FUNCTOR_DECLARATION__TEMPLATE_ARGUMENT_DECLARATIONS:
        return ((InternalEList<?>)getTemplateArgumentDeclarations()).basicRemove(otherEnd, msgs);
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
      case AstPackage.FUNCTOR_DECLARATION__NAME:
        return getName();
      case AstPackage.FUNCTOR_DECLARATION__FUNCTION_NAME:
        return getFunctionName();
      case AstPackage.FUNCTOR_DECLARATION__TEMPLATE_ARGUMENT_DECLARATIONS:
        return getTemplateArgumentDeclarations();
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
      case AstPackage.FUNCTOR_DECLARATION__NAME:
        setName((String)newValue);
        return;
      case AstPackage.FUNCTOR_DECLARATION__FUNCTION_NAME:
        setFunctionName((QualifiedName)newValue);
        return;
      case AstPackage.FUNCTOR_DECLARATION__TEMPLATE_ARGUMENT_DECLARATIONS:
        getTemplateArgumentDeclarations().clear();
        getTemplateArgumentDeclarations().addAll((Collection<? extends ArgumentDeclaration>)newValue);
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
      case AstPackage.FUNCTOR_DECLARATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AstPackage.FUNCTOR_DECLARATION__FUNCTION_NAME:
        setFunctionName((QualifiedName)null);
        return;
      case AstPackage.FUNCTOR_DECLARATION__TEMPLATE_ARGUMENT_DECLARATIONS:
        getTemplateArgumentDeclarations().clear();
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
      case AstPackage.FUNCTOR_DECLARATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AstPackage.FUNCTOR_DECLARATION__FUNCTION_NAME:
        return functionName != null;
      case AstPackage.FUNCTOR_DECLARATION__TEMPLATE_ARGUMENT_DECLARATIONS:
        return templateArgumentDeclarations != null && !templateArgumentDeclarations.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //FunctorDeclarationImpl
