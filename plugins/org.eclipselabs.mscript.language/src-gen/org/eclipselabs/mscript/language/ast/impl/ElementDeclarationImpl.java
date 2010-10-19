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

import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.ElementDeclaration;
import org.eclipselabs.mscript.language.ast.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ElementDeclarationImpl#getElementName <em>Element Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ElementDeclarationImpl#getAccumulatorName <em>Accumulator Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ElementDeclarationImpl#getInitialValue <em>Initial Value</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ElementDeclarationImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElementDeclarationImpl extends IteratorCallImpl implements ElementDeclaration
{
  /**
   * The default value of the '{@link #getElementName() <em>Element Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElementName()
   * @generated
   * @ordered
   */
  protected static final String ELEMENT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getElementName() <em>Element Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElementName()
   * @generated
   * @ordered
   */
  protected String elementName = ELEMENT_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getAccumulatorName() <em>Accumulator Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccumulatorName()
   * @generated
   * @ordered
   */
  protected static final String ACCUMULATOR_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAccumulatorName() <em>Accumulator Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccumulatorName()
   * @generated
   * @ordered
   */
  protected String accumulatorName = ACCUMULATOR_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getInitialValue() <em>Initial Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitialValue()
   * @generated
   * @ordered
   */
  protected Expression initialValue;

  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected Expression expression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ElementDeclarationImpl()
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
    return AstPackage.Literals.ELEMENT_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getElementName()
  {
    return elementName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElementName(String newElementName)
  {
    String oldElementName = elementName;
    elementName = newElementName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ELEMENT_DECLARATION__ELEMENT_NAME, oldElementName, elementName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAccumulatorName()
  {
    return accumulatorName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAccumulatorName(String newAccumulatorName)
  {
    String oldAccumulatorName = accumulatorName;
    accumulatorName = newAccumulatorName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ELEMENT_DECLARATION__ACCUMULATOR_NAME, oldAccumulatorName, accumulatorName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getInitialValue()
  {
    return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInitialValue(Expression newInitialValue, NotificationChain msgs)
  {
    Expression oldInitialValue = initialValue;
    initialValue = newInitialValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.ELEMENT_DECLARATION__INITIAL_VALUE, oldInitialValue, newInitialValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitialValue(Expression newInitialValue)
  {
    if (newInitialValue != initialValue)
    {
      NotificationChain msgs = null;
      if (initialValue != null)
        msgs = ((InternalEObject)initialValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.ELEMENT_DECLARATION__INITIAL_VALUE, null, msgs);
      if (newInitialValue != null)
        msgs = ((InternalEObject)newInitialValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.ELEMENT_DECLARATION__INITIAL_VALUE, null, msgs);
      msgs = basicSetInitialValue(newInitialValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ELEMENT_DECLARATION__INITIAL_VALUE, newInitialValue, newInitialValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs)
  {
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.ELEMENT_DECLARATION__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(Expression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.ELEMENT_DECLARATION__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.ELEMENT_DECLARATION__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ELEMENT_DECLARATION__EXPRESSION, newExpression, newExpression));
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
      case AstPackage.ELEMENT_DECLARATION__INITIAL_VALUE:
        return basicSetInitialValue(null, msgs);
      case AstPackage.ELEMENT_DECLARATION__EXPRESSION:
        return basicSetExpression(null, msgs);
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
      case AstPackage.ELEMENT_DECLARATION__ELEMENT_NAME:
        return getElementName();
      case AstPackage.ELEMENT_DECLARATION__ACCUMULATOR_NAME:
        return getAccumulatorName();
      case AstPackage.ELEMENT_DECLARATION__INITIAL_VALUE:
        return getInitialValue();
      case AstPackage.ELEMENT_DECLARATION__EXPRESSION:
        return getExpression();
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
      case AstPackage.ELEMENT_DECLARATION__ELEMENT_NAME:
        setElementName((String)newValue);
        return;
      case AstPackage.ELEMENT_DECLARATION__ACCUMULATOR_NAME:
        setAccumulatorName((String)newValue);
        return;
      case AstPackage.ELEMENT_DECLARATION__INITIAL_VALUE:
        setInitialValue((Expression)newValue);
        return;
      case AstPackage.ELEMENT_DECLARATION__EXPRESSION:
        setExpression((Expression)newValue);
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
      case AstPackage.ELEMENT_DECLARATION__ELEMENT_NAME:
        setElementName(ELEMENT_NAME_EDEFAULT);
        return;
      case AstPackage.ELEMENT_DECLARATION__ACCUMULATOR_NAME:
        setAccumulatorName(ACCUMULATOR_NAME_EDEFAULT);
        return;
      case AstPackage.ELEMENT_DECLARATION__INITIAL_VALUE:
        setInitialValue((Expression)null);
        return;
      case AstPackage.ELEMENT_DECLARATION__EXPRESSION:
        setExpression((Expression)null);
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
      case AstPackage.ELEMENT_DECLARATION__ELEMENT_NAME:
        return ELEMENT_NAME_EDEFAULT == null ? elementName != null : !ELEMENT_NAME_EDEFAULT.equals(elementName);
      case AstPackage.ELEMENT_DECLARATION__ACCUMULATOR_NAME:
        return ACCUMULATOR_NAME_EDEFAULT == null ? accumulatorName != null : !ACCUMULATOR_NAME_EDEFAULT.equals(accumulatorName);
      case AstPackage.ELEMENT_DECLARATION__INITIAL_VALUE:
        return initialValue != null;
      case AstPackage.ELEMENT_DECLARATION__EXPRESSION:
        return expression != null;
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
    result.append(" (elementName: ");
    result.append(elementName);
    result.append(", accumulatorName: ");
    result.append(accumulatorName);
    result.append(')');
    return result.toString();
  }

} //ElementDeclarationImpl
