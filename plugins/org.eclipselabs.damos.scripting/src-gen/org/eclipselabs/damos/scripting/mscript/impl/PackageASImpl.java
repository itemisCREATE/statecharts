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

import org.eclipselabs.damos.scripting.mscript.MscriptPackage;
import org.eclipselabs.damos.scripting.mscript.Name;
import org.eclipselabs.damos.scripting.mscript.PackageAS;
import org.eclipselabs.damos.scripting.mscript.PackageableElementAS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.impl.PackageASImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.impl.PackageASImpl#getPackagedElements <em>Packaged Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageASImpl extends PackageableElementASImpl implements PackageAS
{
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
   * The cached value of the '{@link #getPackagedElements() <em>Packaged Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackagedElements()
   * @generated
   * @ordered
   */
  protected EList<PackageableElementAS> packagedElements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PackageASImpl()
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
    return MscriptPackage.Literals.PACKAGE_AS;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MscriptPackage.PACKAGE_AS__NAME, oldName, newName);
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
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.PACKAGE_AS__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.PACKAGE_AS__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.PACKAGE_AS__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PackageableElementAS> getPackagedElements()
  {
    if (packagedElements == null)
    {
      packagedElements = new EObjectContainmentEList<PackageableElementAS>(PackageableElementAS.class, this, MscriptPackage.PACKAGE_AS__PACKAGED_ELEMENTS);
    }
    return packagedElements;
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
      case MscriptPackage.PACKAGE_AS__NAME:
        return basicSetName(null, msgs);
      case MscriptPackage.PACKAGE_AS__PACKAGED_ELEMENTS:
        return ((InternalEList<?>)getPackagedElements()).basicRemove(otherEnd, msgs);
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
      case MscriptPackage.PACKAGE_AS__NAME:
        return getName();
      case MscriptPackage.PACKAGE_AS__PACKAGED_ELEMENTS:
        return getPackagedElements();
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
      case MscriptPackage.PACKAGE_AS__NAME:
        setName((Name)newValue);
        return;
      case MscriptPackage.PACKAGE_AS__PACKAGED_ELEMENTS:
        getPackagedElements().clear();
        getPackagedElements().addAll((Collection<? extends PackageableElementAS>)newValue);
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
      case MscriptPackage.PACKAGE_AS__NAME:
        setName((Name)null);
        return;
      case MscriptPackage.PACKAGE_AS__PACKAGED_ELEMENTS:
        getPackagedElements().clear();
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
      case MscriptPackage.PACKAGE_AS__NAME:
        return name != null;
      case MscriptPackage.PACKAGE_AS__PACKAGED_ELEMENTS:
        return packagedElements != null && !packagedElements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //PackageASImpl
