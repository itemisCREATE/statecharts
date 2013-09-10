/**
 */
package org.yakindu.sct.model.stext.stext.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.yakindu.sct.model.stext.stext.StextPackage;
import org.yakindu.sct.model.stext.stext.TransitionRoot;
import org.yakindu.sct.model.stext.stext.TransitionSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.TransitionRootImpl#getDef <em>Def</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionRootImpl extends DefRootImpl implements TransitionRoot
{
  /**
	 * The cached value of the '{@link #getDef() <em>Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDef()
	 * @generated
	 * @ordered
	 */
  protected TransitionSpecification def;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected TransitionRootImpl()
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
		return StextPackage.Literals.TRANSITION_ROOT;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TransitionSpecification getDef()
  {
		return def;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetDef(TransitionSpecification newDef, NotificationChain msgs)
  {
		TransitionSpecification oldDef = def;
		def = newDef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StextPackage.TRANSITION_ROOT__DEF, oldDef, newDef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setDef(TransitionSpecification newDef)
  {
		if (newDef != def) {
			NotificationChain msgs = null;
			if (def != null)
				msgs = ((InternalEObject)def).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StextPackage.TRANSITION_ROOT__DEF, null, msgs);
			if (newDef != null)
				msgs = ((InternalEObject)newDef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StextPackage.TRANSITION_ROOT__DEF, null, msgs);
			msgs = basicSetDef(newDef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.TRANSITION_ROOT__DEF, newDef, newDef));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case StextPackage.TRANSITION_ROOT__DEF:
				return basicSetDef(null, msgs);
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
		switch (featureID) {
			case StextPackage.TRANSITION_ROOT__DEF:
				return getDef();
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
		switch (featureID) {
			case StextPackage.TRANSITION_ROOT__DEF:
				setDef((TransitionSpecification)newValue);
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
		switch (featureID) {
			case StextPackage.TRANSITION_ROOT__DEF:
				setDef((TransitionSpecification)null);
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
		switch (featureID) {
			case StextPackage.TRANSITION_ROOT__DEF:
				return def != null;
		}
		return super.eIsSet(featureID);
	}

} //TransitionRootImpl
