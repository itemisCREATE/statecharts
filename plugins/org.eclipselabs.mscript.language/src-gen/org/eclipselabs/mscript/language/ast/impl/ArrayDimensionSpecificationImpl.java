/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array Dimension Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ArrayDimensionSpecificationImpl#isUnspecified <em>Unspecified</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ArrayDimensionSpecificationImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ArrayDimensionSpecificationImpl#getFrom <em>From</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ArrayDimensionSpecificationImpl#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArrayDimensionSpecificationImpl extends MinimalEObjectImpl.Container implements ArrayDimensionSpecification
{
  /**
   * The default value of the '{@link #isUnspecified() <em>Unspecified</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnspecified()
   * @generated
   * @ordered
   */
  protected static final boolean UNSPECIFIED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUnspecified() <em>Unspecified</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnspecified()
   * @generated
   * @ordered
   */
  protected boolean unspecified = UNSPECIFIED_EDEFAULT;

  /**
   * The cached value of the '{@link #getSize() <em>Size</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSize()
   * @generated
   * @ordered
   */
  protected Expression size;

  /**
   * The cached value of the '{@link #getFrom() <em>From</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFrom()
   * @generated
   * @ordered
   */
  protected ArrayDimensionSpecification from;

  /**
   * The cached value of the '{@link #getTo() <em>To</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTo()
   * @generated
   * @ordered
   */
  protected Expression to;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ArrayDimensionSpecificationImpl()
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
    return AstPackage.Literals.ARRAY_DIMENSION_SPECIFICATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isUnspecified()
  {
    return unspecified;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnspecified(boolean newUnspecified)
  {
    boolean oldUnspecified = unspecified;
    unspecified = newUnspecified;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ARRAY_DIMENSION_SPECIFICATION__UNSPECIFIED, oldUnspecified, unspecified));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getSize()
  {
    return size;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSize(Expression newSize, NotificationChain msgs)
  {
    Expression oldSize = size;
    size = newSize;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.ARRAY_DIMENSION_SPECIFICATION__SIZE, oldSize, newSize);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSize(Expression newSize)
  {
    if (newSize != size)
    {
      NotificationChain msgs = null;
      if (size != null)
        msgs = ((InternalEObject)size).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.ARRAY_DIMENSION_SPECIFICATION__SIZE, null, msgs);
      if (newSize != null)
        msgs = ((InternalEObject)newSize).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.ARRAY_DIMENSION_SPECIFICATION__SIZE, null, msgs);
      msgs = basicSetSize(newSize, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ARRAY_DIMENSION_SPECIFICATION__SIZE, newSize, newSize));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayDimensionSpecification getFrom()
  {
    return from;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFrom(ArrayDimensionSpecification newFrom, NotificationChain msgs)
  {
    ArrayDimensionSpecification oldFrom = from;
    from = newFrom;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.ARRAY_DIMENSION_SPECIFICATION__FROM, oldFrom, newFrom);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFrom(ArrayDimensionSpecification newFrom)
  {
    if (newFrom != from)
    {
      NotificationChain msgs = null;
      if (from != null)
        msgs = ((InternalEObject)from).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.ARRAY_DIMENSION_SPECIFICATION__FROM, null, msgs);
      if (newFrom != null)
        msgs = ((InternalEObject)newFrom).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.ARRAY_DIMENSION_SPECIFICATION__FROM, null, msgs);
      msgs = basicSetFrom(newFrom, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ARRAY_DIMENSION_SPECIFICATION__FROM, newFrom, newFrom));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getTo()
  {
    return to;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTo(Expression newTo, NotificationChain msgs)
  {
    Expression oldTo = to;
    to = newTo;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.ARRAY_DIMENSION_SPECIFICATION__TO, oldTo, newTo);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTo(Expression newTo)
  {
    if (newTo != to)
    {
      NotificationChain msgs = null;
      if (to != null)
        msgs = ((InternalEObject)to).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.ARRAY_DIMENSION_SPECIFICATION__TO, null, msgs);
      if (newTo != null)
        msgs = ((InternalEObject)newTo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.ARRAY_DIMENSION_SPECIFICATION__TO, null, msgs);
      msgs = basicSetTo(newTo, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ARRAY_DIMENSION_SPECIFICATION__TO, newTo, newTo));
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
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__SIZE:
        return basicSetSize(null, msgs);
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__FROM:
        return basicSetFrom(null, msgs);
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__TO:
        return basicSetTo(null, msgs);
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
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__UNSPECIFIED:
        return isUnspecified();
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__SIZE:
        return getSize();
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__FROM:
        return getFrom();
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__TO:
        return getTo();
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
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__UNSPECIFIED:
        setUnspecified((Boolean)newValue);
        return;
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__SIZE:
        setSize((Expression)newValue);
        return;
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__FROM:
        setFrom((ArrayDimensionSpecification)newValue);
        return;
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__TO:
        setTo((Expression)newValue);
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
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__UNSPECIFIED:
        setUnspecified(UNSPECIFIED_EDEFAULT);
        return;
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__SIZE:
        setSize((Expression)null);
        return;
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__FROM:
        setFrom((ArrayDimensionSpecification)null);
        return;
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__TO:
        setTo((Expression)null);
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
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__UNSPECIFIED:
        return unspecified != UNSPECIFIED_EDEFAULT;
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__SIZE:
        return size != null;
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__FROM:
        return from != null;
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__TO:
        return to != null;
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
    result.append(" (unspecified: ");
    result.append(unspecified);
    result.append(')');
    return result.toString();
  }

} //ArrayDimensionSpecificationImpl
