/**
 * <copyright>
 * </copyright>
 *
 */
package org.yakindu.sct.model.stext.stext.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.yakindu.base.base.BasePackage;
import org.yakindu.base.base.NamedElement;

import org.yakindu.base.types.Feature;
import org.yakindu.base.types.Library;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypesPackage;

import org.yakindu.sct.model.sgraph.impl.ScopeImpl;

import org.yakindu.sct.model.stext.stext.StatechartScope;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statechart Scope</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.StatechartScopeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.StatechartScopeImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.StatechartScopeImpl#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.StatechartScopeImpl#getOwningLibrary <em>Owning Library</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatechartScopeImpl extends ScopeImpl implements StatechartScope
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
   * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatures()
   * @generated
   * @ordered
   */
  protected EList<Feature> features;

  /**
   * The cached value of the '{@link #getSuperTypes() <em>Super Types</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperTypes()
   * @generated
   * @ordered
   */
  protected EList<Type> superTypes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StatechartScopeImpl()
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
    return StextPackage.Literals.STATECHART_SCOPE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.STATECHART_SCOPE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Feature> getFeatures()
  {
    if (features == null)
    {
      features = new EObjectContainmentWithInverseEList<Feature>(Feature.class, this, StextPackage.STATECHART_SCOPE__FEATURES, TypesPackage.FEATURE__OWNING_TYPE);
    }
    return features;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Type> getSuperTypes()
  {
    if (superTypes == null)
    {
      superTypes = new EObjectResolvingEList<Type>(Type.class, this, StextPackage.STATECHART_SCOPE__SUPER_TYPES);
    }
    return superTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Library getOwningLibrary()
  {
    if (eContainerFeatureID() != StextPackage.STATECHART_SCOPE__OWNING_LIBRARY) return null;
    return (Library)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwningLibrary(Library newOwningLibrary, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newOwningLibrary, StextPackage.STATECHART_SCOPE__OWNING_LIBRARY, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOwningLibrary(Library newOwningLibrary)
  {
    if (newOwningLibrary != eInternalContainer() || (eContainerFeatureID() != StextPackage.STATECHART_SCOPE__OWNING_LIBRARY && newOwningLibrary != null))
    {
      if (EcoreUtil.isAncestor(this, newOwningLibrary))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newOwningLibrary != null)
        msgs = ((InternalEObject)newOwningLibrary).eInverseAdd(this, TypesPackage.LIBRARY__TYPES, Library.class, msgs);
      msgs = basicSetOwningLibrary(newOwningLibrary, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.STATECHART_SCOPE__OWNING_LIBRARY, newOwningLibrary, newOwningLibrary));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case StextPackage.STATECHART_SCOPE__FEATURES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeatures()).basicAdd(otherEnd, msgs);
      case StextPackage.STATECHART_SCOPE__OWNING_LIBRARY:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetOwningLibrary((Library)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
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
      case StextPackage.STATECHART_SCOPE__FEATURES:
        return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
      case StextPackage.STATECHART_SCOPE__OWNING_LIBRARY:
        return basicSetOwningLibrary(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID())
    {
      case StextPackage.STATECHART_SCOPE__OWNING_LIBRARY:
        return eInternalContainer().eInverseRemove(this, TypesPackage.LIBRARY__TYPES, Library.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
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
      case StextPackage.STATECHART_SCOPE__NAME:
        return getName();
      case StextPackage.STATECHART_SCOPE__FEATURES:
        return getFeatures();
      case StextPackage.STATECHART_SCOPE__SUPER_TYPES:
        return getSuperTypes();
      case StextPackage.STATECHART_SCOPE__OWNING_LIBRARY:
        return getOwningLibrary();
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
      case StextPackage.STATECHART_SCOPE__NAME:
        setName((String)newValue);
        return;
      case StextPackage.STATECHART_SCOPE__FEATURES:
        getFeatures().clear();
        getFeatures().addAll((Collection<? extends Feature>)newValue);
        return;
      case StextPackage.STATECHART_SCOPE__SUPER_TYPES:
        getSuperTypes().clear();
        getSuperTypes().addAll((Collection<? extends Type>)newValue);
        return;
      case StextPackage.STATECHART_SCOPE__OWNING_LIBRARY:
        setOwningLibrary((Library)newValue);
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
      case StextPackage.STATECHART_SCOPE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case StextPackage.STATECHART_SCOPE__FEATURES:
        getFeatures().clear();
        return;
      case StextPackage.STATECHART_SCOPE__SUPER_TYPES:
        getSuperTypes().clear();
        return;
      case StextPackage.STATECHART_SCOPE__OWNING_LIBRARY:
        setOwningLibrary((Library)null);
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
      case StextPackage.STATECHART_SCOPE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case StextPackage.STATECHART_SCOPE__FEATURES:
        return features != null && !features.isEmpty();
      case StextPackage.STATECHART_SCOPE__SUPER_TYPES:
        return superTypes != null && !superTypes.isEmpty();
      case StextPackage.STATECHART_SCOPE__OWNING_LIBRARY:
        return getOwningLibrary() != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == NamedElement.class)
    {
      switch (derivedFeatureID)
      {
        case StextPackage.STATECHART_SCOPE__NAME: return BasePackage.NAMED_ELEMENT__NAME;
        default: return -1;
      }
    }
    if (baseClass == Type.class)
    {
      switch (derivedFeatureID)
      {
        case StextPackage.STATECHART_SCOPE__FEATURES: return TypesPackage.TYPE__FEATURES;
        case StextPackage.STATECHART_SCOPE__SUPER_TYPES: return TypesPackage.TYPE__SUPER_TYPES;
        case StextPackage.STATECHART_SCOPE__OWNING_LIBRARY: return TypesPackage.TYPE__OWNING_LIBRARY;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == NamedElement.class)
    {
      switch (baseFeatureID)
      {
        case BasePackage.NAMED_ELEMENT__NAME: return StextPackage.STATECHART_SCOPE__NAME;
        default: return -1;
      }
    }
    if (baseClass == Type.class)
    {
      switch (baseFeatureID)
      {
        case TypesPackage.TYPE__FEATURES: return StextPackage.STATECHART_SCOPE__FEATURES;
        case TypesPackage.TYPE__SUPER_TYPES: return StextPackage.STATECHART_SCOPE__SUPER_TYPES;
        case TypesPackage.TYPE__OWNING_LIBRARY: return StextPackage.STATECHART_SCOPE__OWNING_LIBRARY;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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

} //StatechartScopeImpl
