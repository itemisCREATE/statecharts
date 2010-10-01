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

import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.ComponentReference;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.FeatureCall;
import org.eclipselabs.mscript.language.ast.QualifiedName;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FeatureCallImpl#isGlobal <em>Global</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FeatureCallImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FeatureCallImpl#getComponentReferences <em>Component References</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FeatureCallImpl#isOperationCall <em>Operation Call</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FeatureCallImpl#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureCallImpl extends ExpressionImpl implements FeatureCall
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
  protected QualifiedName name;

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
   * The default value of the '{@link #isOperationCall() <em>Operation Call</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOperationCall()
   * @generated
   * @ordered
   */
  protected static final boolean OPERATION_CALL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isOperationCall() <em>Operation Call</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOperationCall()
   * @generated
   * @ordered
   */
  protected boolean operationCall = OPERATION_CALL_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FeatureCallImpl()
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
    return AstPackage.Literals.FEATURE_CALL;
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
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FEATURE_CALL__GLOBAL, oldGlobal, global));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedName getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName(QualifiedName newName, NotificationChain msgs)
  {
    QualifiedName oldName = name;
    name = newName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.FEATURE_CALL__NAME, oldName, newName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(QualifiedName newName)
  {
    if (newName != name)
    {
      NotificationChain msgs = null;
      if (name != null)
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.FEATURE_CALL__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.FEATURE_CALL__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FEATURE_CALL__NAME, newName, newName));
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
      componentReferences = new EObjectContainmentEList<ComponentReference>(ComponentReference.class, this, AstPackage.FEATURE_CALL__COMPONENT_REFERENCES);
    }
    return componentReferences;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isOperationCall()
  {
    return operationCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperationCall(boolean newOperationCall)
  {
    boolean oldOperationCall = operationCall;
    operationCall = newOperationCall;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FEATURE_CALL__OPERATION_CALL, oldOperationCall, operationCall));
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
      arguments = new EObjectContainmentEList<Expression>(Expression.class, this, AstPackage.FEATURE_CALL__ARGUMENTS);
    }
    return arguments;
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
      case AstPackage.FEATURE_CALL__NAME:
        return basicSetName(null, msgs);
      case AstPackage.FEATURE_CALL__COMPONENT_REFERENCES:
        return ((InternalEList<?>)getComponentReferences()).basicRemove(otherEnd, msgs);
      case AstPackage.FEATURE_CALL__ARGUMENTS:
        return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
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
      case AstPackage.FEATURE_CALL__GLOBAL:
        return isGlobal();
      case AstPackage.FEATURE_CALL__NAME:
        return getName();
      case AstPackage.FEATURE_CALL__COMPONENT_REFERENCES:
        return getComponentReferences();
      case AstPackage.FEATURE_CALL__OPERATION_CALL:
        return isOperationCall();
      case AstPackage.FEATURE_CALL__ARGUMENTS:
        return getArguments();
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
      case AstPackage.FEATURE_CALL__GLOBAL:
        setGlobal((Boolean)newValue);
        return;
      case AstPackage.FEATURE_CALL__NAME:
        setName((QualifiedName)newValue);
        return;
      case AstPackage.FEATURE_CALL__COMPONENT_REFERENCES:
        getComponentReferences().clear();
        getComponentReferences().addAll((Collection<? extends ComponentReference>)newValue);
        return;
      case AstPackage.FEATURE_CALL__OPERATION_CALL:
        setOperationCall((Boolean)newValue);
        return;
      case AstPackage.FEATURE_CALL__ARGUMENTS:
        getArguments().clear();
        getArguments().addAll((Collection<? extends Expression>)newValue);
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
      case AstPackage.FEATURE_CALL__GLOBAL:
        setGlobal(GLOBAL_EDEFAULT);
        return;
      case AstPackage.FEATURE_CALL__NAME:
        setName((QualifiedName)null);
        return;
      case AstPackage.FEATURE_CALL__COMPONENT_REFERENCES:
        getComponentReferences().clear();
        return;
      case AstPackage.FEATURE_CALL__OPERATION_CALL:
        setOperationCall(OPERATION_CALL_EDEFAULT);
        return;
      case AstPackage.FEATURE_CALL__ARGUMENTS:
        getArguments().clear();
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
      case AstPackage.FEATURE_CALL__GLOBAL:
        return global != GLOBAL_EDEFAULT;
      case AstPackage.FEATURE_CALL__NAME:
        return name != null;
      case AstPackage.FEATURE_CALL__COMPONENT_REFERENCES:
        return componentReferences != null && !componentReferences.isEmpty();
      case AstPackage.FEATURE_CALL__OPERATION_CALL:
        return operationCall != OPERATION_CALL_EDEFAULT;
      case AstPackage.FEATURE_CALL__ARGUMENTS:
        return arguments != null && !arguments.isEmpty();
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
    result.append(", operationCall: ");
    result.append(operationCall);
    result.append(')');
    return result.toString();
  }

} //FeatureCallImpl
