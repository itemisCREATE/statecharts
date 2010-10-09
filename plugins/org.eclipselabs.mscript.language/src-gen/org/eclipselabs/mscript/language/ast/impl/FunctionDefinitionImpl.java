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
import org.eclipselabs.mscript.language.ast.Block;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.ast.PreconditionChain;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getPreconditionChain <em>Precondition Chain</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionDefinitionImpl extends TypeDefinitionImpl implements FunctionDefinition
{
  /**
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<ParameterDeclaration> parameters;

  /**
   * The cached value of the '{@link #getPreconditionChain() <em>Precondition Chain</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreconditionChain()
   * @generated
   * @ordered
   */
  protected PreconditionChain preconditionChain;

  /**
   * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBody()
   * @generated
   * @ordered
   */
  protected Block body;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FunctionDefinitionImpl()
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
    return AstPackage.Literals.FUNCTION_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ParameterDeclaration> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<ParameterDeclaration>(ParameterDeclaration.class, this, AstPackage.FUNCTION_DEFINITION__PARAMETERS);
    }
    return parameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PreconditionChain getPreconditionChain()
  {
    return preconditionChain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPreconditionChain(PreconditionChain newPreconditionChain, NotificationChain msgs)
  {
    PreconditionChain oldPreconditionChain = preconditionChain;
    preconditionChain = newPreconditionChain;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.FUNCTION_DEFINITION__PRECONDITION_CHAIN, oldPreconditionChain, newPreconditionChain);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPreconditionChain(PreconditionChain newPreconditionChain)
  {
    if (newPreconditionChain != preconditionChain)
    {
      NotificationChain msgs = null;
      if (preconditionChain != null)
        msgs = ((InternalEObject)preconditionChain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.FUNCTION_DEFINITION__PRECONDITION_CHAIN, null, msgs);
      if (newPreconditionChain != null)
        msgs = ((InternalEObject)newPreconditionChain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.FUNCTION_DEFINITION__PRECONDITION_CHAIN, null, msgs);
      msgs = basicSetPreconditionChain(newPreconditionChain, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FUNCTION_DEFINITION__PRECONDITION_CHAIN, newPreconditionChain, newPreconditionChain));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block getBody()
  {
    return body;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBody(Block newBody, NotificationChain msgs)
  {
    Block oldBody = body;
    body = newBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.FUNCTION_DEFINITION__BODY, oldBody, newBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBody(Block newBody)
  {
    if (newBody != body)
    {
      NotificationChain msgs = null;
      if (body != null)
        msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.FUNCTION_DEFINITION__BODY, null, msgs);
      if (newBody != null)
        msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.FUNCTION_DEFINITION__BODY, null, msgs);
      msgs = basicSetBody(newBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FUNCTION_DEFINITION__BODY, newBody, newBody));
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
      case AstPackage.FUNCTION_DEFINITION__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
      case AstPackage.FUNCTION_DEFINITION__PRECONDITION_CHAIN:
        return basicSetPreconditionChain(null, msgs);
      case AstPackage.FUNCTION_DEFINITION__BODY:
        return basicSetBody(null, msgs);
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
      case AstPackage.FUNCTION_DEFINITION__PARAMETERS:
        return getParameters();
      case AstPackage.FUNCTION_DEFINITION__PRECONDITION_CHAIN:
        return getPreconditionChain();
      case AstPackage.FUNCTION_DEFINITION__BODY:
        return getBody();
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
      case AstPackage.FUNCTION_DEFINITION__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends ParameterDeclaration>)newValue);
        return;
      case AstPackage.FUNCTION_DEFINITION__PRECONDITION_CHAIN:
        setPreconditionChain((PreconditionChain)newValue);
        return;
      case AstPackage.FUNCTION_DEFINITION__BODY:
        setBody((Block)newValue);
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
      case AstPackage.FUNCTION_DEFINITION__PARAMETERS:
        getParameters().clear();
        return;
      case AstPackage.FUNCTION_DEFINITION__PRECONDITION_CHAIN:
        setPreconditionChain((PreconditionChain)null);
        return;
      case AstPackage.FUNCTION_DEFINITION__BODY:
        setBody((Block)null);
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
      case AstPackage.FUNCTION_DEFINITION__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
      case AstPackage.FUNCTION_DEFINITION__PRECONDITION_CHAIN:
        return preconditionChain != null;
      case AstPackage.FUNCTION_DEFINITION__BODY:
        return body != null;
    }
    return super.eIsSet(featureID);
  }

} //FunctionDefinitionImpl
