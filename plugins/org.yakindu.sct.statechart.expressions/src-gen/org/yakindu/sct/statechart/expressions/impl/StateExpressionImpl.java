/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.yakindu.sct.statechart.expressions.EntryExpression;
import org.yakindu.sct.statechart.expressions.ExitExpression;
import org.yakindu.sct.statechart.expressions.ExpressionsPackage;
import org.yakindu.sct.statechart.expressions.OnTickExpression;
import org.yakindu.sct.statechart.expressions.StateExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.StateExpressionImpl#getEntryExpression <em>Entry Expression</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.StateExpressionImpl#getExitExpression <em>Exit Expression</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.StateExpressionImpl#getOntickExpression <em>Ontick Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateExpressionImpl extends MinimalEObjectImpl.Container implements StateExpression
{
  /**
   * The cached value of the '{@link #getEntryExpression() <em>Entry Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEntryExpression()
   * @generated
   * @ordered
   */
  protected EList<EntryExpression> entryExpression;

  /**
   * The cached value of the '{@link #getExitExpression() <em>Exit Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExitExpression()
   * @generated
   * @ordered
   */
  protected EList<ExitExpression> exitExpression;

  /**
   * The cached value of the '{@link #getOntickExpression() <em>Ontick Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOntickExpression()
   * @generated
   * @ordered
   */
  protected EList<OnTickExpression> ontickExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StateExpressionImpl()
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
    return ExpressionsPackage.Literals.STATE_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EntryExpression> getEntryExpression()
  {
    if (entryExpression == null)
    {
      entryExpression = new EObjectContainmentEList<EntryExpression>(EntryExpression.class, this, ExpressionsPackage.STATE_EXPRESSION__ENTRY_EXPRESSION);
    }
    return entryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExitExpression> getExitExpression()
  {
    if (exitExpression == null)
    {
      exitExpression = new EObjectContainmentEList<ExitExpression>(ExitExpression.class, this, ExpressionsPackage.STATE_EXPRESSION__EXIT_EXPRESSION);
    }
    return exitExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<OnTickExpression> getOntickExpression()
  {
    if (ontickExpression == null)
    {
      ontickExpression = new EObjectContainmentEList<OnTickExpression>(OnTickExpression.class, this, ExpressionsPackage.STATE_EXPRESSION__ONTICK_EXPRESSION);
    }
    return ontickExpression;
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
      case ExpressionsPackage.STATE_EXPRESSION__ENTRY_EXPRESSION:
        return ((InternalEList<?>)getEntryExpression()).basicRemove(otherEnd, msgs);
      case ExpressionsPackage.STATE_EXPRESSION__EXIT_EXPRESSION:
        return ((InternalEList<?>)getExitExpression()).basicRemove(otherEnd, msgs);
      case ExpressionsPackage.STATE_EXPRESSION__ONTICK_EXPRESSION:
        return ((InternalEList<?>)getOntickExpression()).basicRemove(otherEnd, msgs);
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
      case ExpressionsPackage.STATE_EXPRESSION__ENTRY_EXPRESSION:
        return getEntryExpression();
      case ExpressionsPackage.STATE_EXPRESSION__EXIT_EXPRESSION:
        return getExitExpression();
      case ExpressionsPackage.STATE_EXPRESSION__ONTICK_EXPRESSION:
        return getOntickExpression();
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
      case ExpressionsPackage.STATE_EXPRESSION__ENTRY_EXPRESSION:
        getEntryExpression().clear();
        getEntryExpression().addAll((Collection<? extends EntryExpression>)newValue);
        return;
      case ExpressionsPackage.STATE_EXPRESSION__EXIT_EXPRESSION:
        getExitExpression().clear();
        getExitExpression().addAll((Collection<? extends ExitExpression>)newValue);
        return;
      case ExpressionsPackage.STATE_EXPRESSION__ONTICK_EXPRESSION:
        getOntickExpression().clear();
        getOntickExpression().addAll((Collection<? extends OnTickExpression>)newValue);
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
      case ExpressionsPackage.STATE_EXPRESSION__ENTRY_EXPRESSION:
        getEntryExpression().clear();
        return;
      case ExpressionsPackage.STATE_EXPRESSION__EXIT_EXPRESSION:
        getExitExpression().clear();
        return;
      case ExpressionsPackage.STATE_EXPRESSION__ONTICK_EXPRESSION:
        getOntickExpression().clear();
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
      case ExpressionsPackage.STATE_EXPRESSION__ENTRY_EXPRESSION:
        return entryExpression != null && !entryExpression.isEmpty();
      case ExpressionsPackage.STATE_EXPRESSION__EXIT_EXPRESSION:
        return exitExpression != null && !exitExpression.isEmpty();
      case ExpressionsPackage.STATE_EXPRESSION__ONTICK_EXPRESSION:
        return ontickExpression != null && !ontickExpression.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //StateExpressionImpl
