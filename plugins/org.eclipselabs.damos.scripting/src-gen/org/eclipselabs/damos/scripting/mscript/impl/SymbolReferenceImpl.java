/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipselabs.damos.scripting.mscript.ComponentReference;
import org.eclipselabs.damos.scripting.mscript.FunctionArgumentList;
import org.eclipselabs.damos.scripting.mscript.MscriptPackage;
import org.eclipselabs.damos.scripting.mscript.Name;
import org.eclipselabs.damos.scripting.mscript.SymbolReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Symbol Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.impl.SymbolReferenceImpl#isGlobal <em>Global</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.impl.SymbolReferenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.impl.SymbolReferenceImpl#getComponentReferences <em>Component References</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.impl.SymbolReferenceImpl#isFunctionCall <em>Function Call</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.impl.SymbolReferenceImpl#getArgumentList <em>Argument List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SymbolReferenceImpl extends ExpressionImpl implements SymbolReference
{
  /**
   * The default value of the '{@link #isGlobal() <em>Global</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isGlobal()
   * @generated
   * @ordered
   */
  protected static final boolean GLOBAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isGlobal() <em>Global</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isGlobal()
   * @generated
   * @ordered
   */
  protected boolean global = GLOBAL_EDEFAULT;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected Name name;

  /**
   * The cached value of the '{@link #getComponentReferences() <em>Component References</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponentReferences()
   * @generated
   * @ordered
   */
  protected EList<ComponentReference> componentReferences;

  /**
   * The default value of the '{@link #isFunctionCall() <em>Function Call</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFunctionCall()
   * @generated
   * @ordered
   */
  protected static final boolean FUNCTION_CALL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFunctionCall() <em>Function Call</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFunctionCall()
   * @generated
   * @ordered
   */
  protected boolean functionCall = FUNCTION_CALL_EDEFAULT;

  /**
   * The cached value of the '{@link #getArgumentList() <em>Argument List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgumentList()
   * @generated
   * @ordered
   */
  protected FunctionArgumentList argumentList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SymbolReferenceImpl()
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
    return MscriptPackage.Literals.SYMBOL_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isGlobal()
  {
    return global;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGlobal(boolean newGlobal)
  {
    boolean oldGlobal = global;
    global = newGlobal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.SYMBOL_REFERENCE__GLOBAL, oldGlobal, global));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Name getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName(Name newName, NotificationChain msgs)
  {
    Name oldName = name;
    name = newName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MscriptPackage.SYMBOL_REFERENCE__NAME, oldName, newName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(Name newName)
  {
    if (newName != name)
    {
      NotificationChain msgs = null;
      if (name != null)
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.SYMBOL_REFERENCE__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.SYMBOL_REFERENCE__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.SYMBOL_REFERENCE__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ComponentReference> getComponentReferences()
  {
    if (componentReferences == null)
    {
      componentReferences = new EObjectContainmentEList<ComponentReference>(ComponentReference.class, this, MscriptPackage.SYMBOL_REFERENCE__COMPONENT_REFERENCES);
    }
    return componentReferences;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isFunctionCall()
  {
    return functionCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunctionCall(boolean newFunctionCall)
  {
    boolean oldFunctionCall = functionCall;
    functionCall = newFunctionCall;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.SYMBOL_REFERENCE__FUNCTION_CALL, oldFunctionCall, functionCall));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionArgumentList getArgumentList()
  {
    return argumentList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArgumentList(FunctionArgumentList newArgumentList, NotificationChain msgs)
  {
    FunctionArgumentList oldArgumentList = argumentList;
    argumentList = newArgumentList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MscriptPackage.SYMBOL_REFERENCE__ARGUMENT_LIST, oldArgumentList, newArgumentList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArgumentList(FunctionArgumentList newArgumentList)
  {
    if (newArgumentList != argumentList)
    {
      NotificationChain msgs = null;
      if (argumentList != null)
        msgs = ((InternalEObject)argumentList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.SYMBOL_REFERENCE__ARGUMENT_LIST, null, msgs);
      if (newArgumentList != null)
        msgs = ((InternalEObject)newArgumentList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.SYMBOL_REFERENCE__ARGUMENT_LIST, null, msgs);
      msgs = basicSetArgumentList(newArgumentList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.SYMBOL_REFERENCE__ARGUMENT_LIST, newArgumentList, newArgumentList));
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
      case MscriptPackage.SYMBOL_REFERENCE__NAME:
        return basicSetName(null, msgs);
      case MscriptPackage.SYMBOL_REFERENCE__COMPONENT_REFERENCES:
        return ((InternalEList<?>)getComponentReferences()).basicRemove(otherEnd, msgs);
      case MscriptPackage.SYMBOL_REFERENCE__ARGUMENT_LIST:
        return basicSetArgumentList(null, msgs);
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
      case MscriptPackage.SYMBOL_REFERENCE__GLOBAL:
        return isGlobal();
      case MscriptPackage.SYMBOL_REFERENCE__NAME:
        return getName();
      case MscriptPackage.SYMBOL_REFERENCE__COMPONENT_REFERENCES:
        return getComponentReferences();
      case MscriptPackage.SYMBOL_REFERENCE__FUNCTION_CALL:
        return isFunctionCall();
      case MscriptPackage.SYMBOL_REFERENCE__ARGUMENT_LIST:
        return getArgumentList();
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
      case MscriptPackage.SYMBOL_REFERENCE__GLOBAL:
        setGlobal((Boolean)newValue);
        return;
      case MscriptPackage.SYMBOL_REFERENCE__NAME:
        setName((Name)newValue);
        return;
      case MscriptPackage.SYMBOL_REFERENCE__COMPONENT_REFERENCES:
        getComponentReferences().clear();
        getComponentReferences().addAll((Collection<? extends ComponentReference>)newValue);
        return;
      case MscriptPackage.SYMBOL_REFERENCE__FUNCTION_CALL:
        setFunctionCall((Boolean)newValue);
        return;
      case MscriptPackage.SYMBOL_REFERENCE__ARGUMENT_LIST:
        setArgumentList((FunctionArgumentList)newValue);
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
      case MscriptPackage.SYMBOL_REFERENCE__GLOBAL:
        setGlobal(GLOBAL_EDEFAULT);
        return;
      case MscriptPackage.SYMBOL_REFERENCE__NAME:
        setName((Name)null);
        return;
      case MscriptPackage.SYMBOL_REFERENCE__COMPONENT_REFERENCES:
        getComponentReferences().clear();
        return;
      case MscriptPackage.SYMBOL_REFERENCE__FUNCTION_CALL:
        setFunctionCall(FUNCTION_CALL_EDEFAULT);
        return;
      case MscriptPackage.SYMBOL_REFERENCE__ARGUMENT_LIST:
        setArgumentList((FunctionArgumentList)null);
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
      case MscriptPackage.SYMBOL_REFERENCE__GLOBAL:
        return global != GLOBAL_EDEFAULT;
      case MscriptPackage.SYMBOL_REFERENCE__NAME:
        return name != null;
      case MscriptPackage.SYMBOL_REFERENCE__COMPONENT_REFERENCES:
        return componentReferences != null && !componentReferences.isEmpty();
      case MscriptPackage.SYMBOL_REFERENCE__FUNCTION_CALL:
        return functionCall != FUNCTION_CALL_EDEFAULT;
      case MscriptPackage.SYMBOL_REFERENCE__ARGUMENT_LIST:
        return argumentList != null;
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
    result.append(" (global: ");
    result.append(global);
    result.append(", functionCall: ");
    result.append(functionCall);
    result.append(')');
    return result.toString();
  }

} //SymbolReferenceImpl
