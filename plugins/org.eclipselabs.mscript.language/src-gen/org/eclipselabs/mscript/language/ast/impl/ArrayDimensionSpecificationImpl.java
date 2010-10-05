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
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ArrayDimensionSpecificationImpl#getBeginIndex <em>Begin Index</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ArrayDimensionSpecificationImpl#getEndIndex <em>End Index</em>}</li>
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
   * The cached value of the '{@link #getBeginIndex() <em>Begin Index</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBeginIndex()
   * @generated
   * @ordered
   */
  protected ArrayDimensionSpecification beginIndex;

  /**
   * The cached value of the '{@link #getEndIndex() <em>End Index</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEndIndex()
   * @generated
   * @ordered
   */
  protected Expression endIndex;

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
  public ArrayDimensionSpecification getBeginIndex()
  {
    return beginIndex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBeginIndex(ArrayDimensionSpecification newBeginIndex, NotificationChain msgs)
  {
    ArrayDimensionSpecification oldBeginIndex = beginIndex;
    beginIndex = newBeginIndex;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.ARRAY_DIMENSION_SPECIFICATION__BEGIN_INDEX, oldBeginIndex, newBeginIndex);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBeginIndex(ArrayDimensionSpecification newBeginIndex)
  {
    if (newBeginIndex != beginIndex)
    {
      NotificationChain msgs = null;
      if (beginIndex != null)
        msgs = ((InternalEObject)beginIndex).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.ARRAY_DIMENSION_SPECIFICATION__BEGIN_INDEX, null, msgs);
      if (newBeginIndex != null)
        msgs = ((InternalEObject)newBeginIndex).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.ARRAY_DIMENSION_SPECIFICATION__BEGIN_INDEX, null, msgs);
      msgs = basicSetBeginIndex(newBeginIndex, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ARRAY_DIMENSION_SPECIFICATION__BEGIN_INDEX, newBeginIndex, newBeginIndex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getEndIndex()
  {
    return endIndex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEndIndex(Expression newEndIndex, NotificationChain msgs)
  {
    Expression oldEndIndex = endIndex;
    endIndex = newEndIndex;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.ARRAY_DIMENSION_SPECIFICATION__END_INDEX, oldEndIndex, newEndIndex);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEndIndex(Expression newEndIndex)
  {
    if (newEndIndex != endIndex)
    {
      NotificationChain msgs = null;
      if (endIndex != null)
        msgs = ((InternalEObject)endIndex).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.ARRAY_DIMENSION_SPECIFICATION__END_INDEX, null, msgs);
      if (newEndIndex != null)
        msgs = ((InternalEObject)newEndIndex).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.ARRAY_DIMENSION_SPECIFICATION__END_INDEX, null, msgs);
      msgs = basicSetEndIndex(newEndIndex, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ARRAY_DIMENSION_SPECIFICATION__END_INDEX, newEndIndex, newEndIndex));
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
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__BEGIN_INDEX:
        return basicSetBeginIndex(null, msgs);
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__END_INDEX:
        return basicSetEndIndex(null, msgs);
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
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__BEGIN_INDEX:
        return getBeginIndex();
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__END_INDEX:
        return getEndIndex();
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
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__BEGIN_INDEX:
        setBeginIndex((ArrayDimensionSpecification)newValue);
        return;
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__END_INDEX:
        setEndIndex((Expression)newValue);
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
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__BEGIN_INDEX:
        setBeginIndex((ArrayDimensionSpecification)null);
        return;
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__END_INDEX:
        setEndIndex((Expression)null);
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
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__BEGIN_INDEX:
        return beginIndex != null;
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION__END_INDEX:
        return endIndex != null;
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
