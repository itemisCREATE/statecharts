/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipselabs.damos.scripting.mscript.ArraySubscriptList;
import org.eclipselabs.damos.scripting.mscript.ComponentReferenceSegment;
import org.eclipselabs.damos.scripting.mscript.MscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Reference Segment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.impl.ComponentReferenceSegmentImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.impl.ComponentReferenceSegmentImpl#getSubscriptList <em>Subscript List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentReferenceSegmentImpl extends MinimalEObjectImpl.Container implements ComponentReferenceSegment
{
  /**
   * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIdentifier()
   * @generated
   * @ordered
   */
  protected static final String IDENTIFIER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIdentifier()
   * @generated
   * @ordered
   */
  protected String identifier = IDENTIFIER_EDEFAULT;

  /**
   * The cached value of the '{@link #getSubscriptList() <em>Subscript List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubscriptList()
   * @generated
   * @ordered
   */
  protected ArraySubscriptList subscriptList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComponentReferenceSegmentImpl()
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
    return MscriptPackage.Literals.COMPONENT_REFERENCE_SEGMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getIdentifier()
  {
    return identifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIdentifier(String newIdentifier)
  {
    String oldIdentifier = identifier;
    identifier = newIdentifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.COMPONENT_REFERENCE_SEGMENT__IDENTIFIER, oldIdentifier, identifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArraySubscriptList getSubscriptList()
  {
    return subscriptList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSubscriptList(ArraySubscriptList newSubscriptList, NotificationChain msgs)
  {
    ArraySubscriptList oldSubscriptList = subscriptList;
    subscriptList = newSubscriptList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MscriptPackage.COMPONENT_REFERENCE_SEGMENT__SUBSCRIPT_LIST, oldSubscriptList, newSubscriptList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubscriptList(ArraySubscriptList newSubscriptList)
  {
    if (newSubscriptList != subscriptList)
    {
      NotificationChain msgs = null;
      if (subscriptList != null)
        msgs = ((InternalEObject)subscriptList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.COMPONENT_REFERENCE_SEGMENT__SUBSCRIPT_LIST, null, msgs);
      if (newSubscriptList != null)
        msgs = ((InternalEObject)newSubscriptList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.COMPONENT_REFERENCE_SEGMENT__SUBSCRIPT_LIST, null, msgs);
      msgs = basicSetSubscriptList(newSubscriptList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.COMPONENT_REFERENCE_SEGMENT__SUBSCRIPT_LIST, newSubscriptList, newSubscriptList));
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
      case MscriptPackage.COMPONENT_REFERENCE_SEGMENT__SUBSCRIPT_LIST:
        return basicSetSubscriptList(null, msgs);
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
      case MscriptPackage.COMPONENT_REFERENCE_SEGMENT__IDENTIFIER:
        return getIdentifier();
      case MscriptPackage.COMPONENT_REFERENCE_SEGMENT__SUBSCRIPT_LIST:
        return getSubscriptList();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MscriptPackage.COMPONENT_REFERENCE_SEGMENT__IDENTIFIER:
        setIdentifier((String)newValue);
        return;
      case MscriptPackage.COMPONENT_REFERENCE_SEGMENT__SUBSCRIPT_LIST:
        setSubscriptList((ArraySubscriptList)newValue);
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
      case MscriptPackage.COMPONENT_REFERENCE_SEGMENT__IDENTIFIER:
        setIdentifier(IDENTIFIER_EDEFAULT);
        return;
      case MscriptPackage.COMPONENT_REFERENCE_SEGMENT__SUBSCRIPT_LIST:
        setSubscriptList((ArraySubscriptList)null);
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
      case MscriptPackage.COMPONENT_REFERENCE_SEGMENT__IDENTIFIER:
        return IDENTIFIER_EDEFAULT == null ? identifier != null : !IDENTIFIER_EDEFAULT.equals(identifier);
      case MscriptPackage.COMPONENT_REFERENCE_SEGMENT__SUBSCRIPT_LIST:
        return subscriptList != null;
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
    result.append(" (identifier: ");
    result.append(identifier);
    result.append(')');
    return result.toString();
  }

} //ComponentReferenceSegmentImpl
