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
import org.eclipselabs.mscript.language.ast.TypeSpecifier;
import org.eclipselabs.mscript.language.ast.VariableDeclaration;
import org.eclipselabs.mscript.language.ast.VariableDeclarationItem;
import org.eclipselabs.mscript.language.ast.VariableModifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.VariableDeclarationImpl#getModifier <em>Modifier</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.VariableDeclarationImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.VariableDeclarationImpl#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableDeclarationImpl extends PackageDefinitionElementImpl implements VariableDeclaration
{
  /**
   * The cached value of the '{@link #getModifier() <em>Modifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModifier()
   * @generated
   * @ordered
   */
  protected VariableModifier modifier;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected TypeSpecifier type;

  /**
   * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getItems()
   * @generated
   * @ordered
   */
  protected EList<VariableDeclarationItem> items;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VariableDeclarationImpl()
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
    return AstPackage.Literals.VARIABLE_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableModifier getModifier()
  {
    return modifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModifier(VariableModifier newModifier, NotificationChain msgs)
  {
    VariableModifier oldModifier = modifier;
    modifier = newModifier;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.VARIABLE_DECLARATION__MODIFIER, oldModifier, newModifier);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModifier(VariableModifier newModifier)
  {
    if (newModifier != modifier)
    {
      NotificationChain msgs = null;
      if (modifier != null)
        msgs = ((InternalEObject)modifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.VARIABLE_DECLARATION__MODIFIER, null, msgs);
      if (newModifier != null)
        msgs = ((InternalEObject)newModifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.VARIABLE_DECLARATION__MODIFIER, null, msgs);
      msgs = basicSetModifier(newModifier, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.VARIABLE_DECLARATION__MODIFIER, newModifier, newModifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSpecifier getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(TypeSpecifier newType, NotificationChain msgs)
  {
    TypeSpecifier oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.VARIABLE_DECLARATION__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(TypeSpecifier newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.VARIABLE_DECLARATION__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.VARIABLE_DECLARATION__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.VARIABLE_DECLARATION__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VariableDeclarationItem> getItems()
  {
    if (items == null)
    {
      items = new EObjectContainmentEList<VariableDeclarationItem>(VariableDeclarationItem.class, this, AstPackage.VARIABLE_DECLARATION__ITEMS);
    }
    return items;
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
      case AstPackage.VARIABLE_DECLARATION__MODIFIER:
        return basicSetModifier(null, msgs);
      case AstPackage.VARIABLE_DECLARATION__TYPE:
        return basicSetType(null, msgs);
      case AstPackage.VARIABLE_DECLARATION__ITEMS:
        return ((InternalEList<?>)getItems()).basicRemove(otherEnd, msgs);
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
      case AstPackage.VARIABLE_DECLARATION__MODIFIER:
        return getModifier();
      case AstPackage.VARIABLE_DECLARATION__TYPE:
        return getType();
      case AstPackage.VARIABLE_DECLARATION__ITEMS:
        return getItems();
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
      case AstPackage.VARIABLE_DECLARATION__MODIFIER:
        setModifier((VariableModifier)newValue);
        return;
      case AstPackage.VARIABLE_DECLARATION__TYPE:
        setType((TypeSpecifier)newValue);
        return;
      case AstPackage.VARIABLE_DECLARATION__ITEMS:
        getItems().clear();
        getItems().addAll((Collection<? extends VariableDeclarationItem>)newValue);
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
      case AstPackage.VARIABLE_DECLARATION__MODIFIER:
        setModifier((VariableModifier)null);
        return;
      case AstPackage.VARIABLE_DECLARATION__TYPE:
        setType((TypeSpecifier)null);
        return;
      case AstPackage.VARIABLE_DECLARATION__ITEMS:
        getItems().clear();
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
      case AstPackage.VARIABLE_DECLARATION__MODIFIER:
        return modifier != null;
      case AstPackage.VARIABLE_DECLARATION__TYPE:
        return type != null;
      case AstPackage.VARIABLE_DECLARATION__ITEMS:
        return items != null && !items.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //VariableDeclarationImpl
