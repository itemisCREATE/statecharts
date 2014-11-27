/**
 */
package org.yakindu.sct.model.stext.stext.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.yakindu.sct.model.sgraph.Effect;
import org.yakindu.sct.model.sgraph.Reaction;
import org.yakindu.sct.model.sgraph.ReactionProperty;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Trigger;

import org.yakindu.sct.model.sgraph.impl.DeclarationImpl;

import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Reaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.LocalReactionImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.LocalReactionImpl#getEffect <em>Effect</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.LocalReactionImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocalReactionImpl extends DeclarationImpl implements LocalReaction {
	/**
	 * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrigger()
	 * @generated
	 * @ordered
	 */
	protected Trigger trigger;

	/**
	 * The cached value of the '{@link #getEffect() <em>Effect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEffect()
	 * @generated
	 * @ordered
	 */
	protected Effect effect;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<ReactionProperty> properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalReactionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StextPackage.Literals.LOCAL_REACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trigger getTrigger() {
		if (trigger != null && trigger.eIsProxy()) {
			InternalEObject oldTrigger = (InternalEObject)trigger;
			trigger = (Trigger)eResolveProxy(oldTrigger);
			if (trigger != oldTrigger) {
				InternalEObject newTrigger = (InternalEObject)trigger;
				NotificationChain msgs = oldTrigger.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StextPackage.LOCAL_REACTION__TRIGGER, null, null);
				if (newTrigger.eInternalContainer() == null) {
					msgs = newTrigger.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StextPackage.LOCAL_REACTION__TRIGGER, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StextPackage.LOCAL_REACTION__TRIGGER, oldTrigger, trigger));
			}
		}
		return trigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trigger basicGetTrigger() {
		return trigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTrigger(Trigger newTrigger, NotificationChain msgs) {
		Trigger oldTrigger = trigger;
		trigger = newTrigger;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StextPackage.LOCAL_REACTION__TRIGGER, oldTrigger, newTrigger);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrigger(Trigger newTrigger) {
		if (newTrigger != trigger) {
			NotificationChain msgs = null;
			if (trigger != null)
				msgs = ((InternalEObject)trigger).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StextPackage.LOCAL_REACTION__TRIGGER, null, msgs);
			if (newTrigger != null)
				msgs = ((InternalEObject)newTrigger).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StextPackage.LOCAL_REACTION__TRIGGER, null, msgs);
			msgs = basicSetTrigger(newTrigger, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.LOCAL_REACTION__TRIGGER, newTrigger, newTrigger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Effect getEffect() {
		if (effect != null && effect.eIsProxy()) {
			InternalEObject oldEffect = (InternalEObject)effect;
			effect = (Effect)eResolveProxy(oldEffect);
			if (effect != oldEffect) {
				InternalEObject newEffect = (InternalEObject)effect;
				NotificationChain msgs = oldEffect.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StextPackage.LOCAL_REACTION__EFFECT, null, null);
				if (newEffect.eInternalContainer() == null) {
					msgs = newEffect.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StextPackage.LOCAL_REACTION__EFFECT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StextPackage.LOCAL_REACTION__EFFECT, oldEffect, effect));
			}
		}
		return effect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Effect basicGetEffect() {
		return effect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEffect(Effect newEffect, NotificationChain msgs) {
		Effect oldEffect = effect;
		effect = newEffect;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StextPackage.LOCAL_REACTION__EFFECT, oldEffect, newEffect);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEffect(Effect newEffect) {
		if (newEffect != effect) {
			NotificationChain msgs = null;
			if (effect != null)
				msgs = ((InternalEObject)effect).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StextPackage.LOCAL_REACTION__EFFECT, null, msgs);
			if (newEffect != null)
				msgs = ((InternalEObject)newEffect).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StextPackage.LOCAL_REACTION__EFFECT, null, msgs);
			msgs = basicSetEffect(newEffect, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.LOCAL_REACTION__EFFECT, newEffect, newEffect));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReactionProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList.Resolving<ReactionProperty>(ReactionProperty.class, this, StextPackage.LOCAL_REACTION__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StextPackage.LOCAL_REACTION__TRIGGER:
				return basicSetTrigger(null, msgs);
			case StextPackage.LOCAL_REACTION__EFFECT:
				return basicSetEffect(null, msgs);
			case StextPackage.LOCAL_REACTION__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StextPackage.LOCAL_REACTION__TRIGGER:
				if (resolve) return getTrigger();
				return basicGetTrigger();
			case StextPackage.LOCAL_REACTION__EFFECT:
				if (resolve) return getEffect();
				return basicGetEffect();
			case StextPackage.LOCAL_REACTION__PROPERTIES:
				return getProperties();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StextPackage.LOCAL_REACTION__TRIGGER:
				setTrigger((Trigger)newValue);
				return;
			case StextPackage.LOCAL_REACTION__EFFECT:
				setEffect((Effect)newValue);
				return;
			case StextPackage.LOCAL_REACTION__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends ReactionProperty>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case StextPackage.LOCAL_REACTION__TRIGGER:
				setTrigger((Trigger)null);
				return;
			case StextPackage.LOCAL_REACTION__EFFECT:
				setEffect((Effect)null);
				return;
			case StextPackage.LOCAL_REACTION__PROPERTIES:
				getProperties().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StextPackage.LOCAL_REACTION__TRIGGER:
				return trigger != null;
			case StextPackage.LOCAL_REACTION__EFFECT:
				return effect != null;
			case StextPackage.LOCAL_REACTION__PROPERTIES:
				return properties != null && !properties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Reaction.class) {
			switch (derivedFeatureID) {
				case StextPackage.LOCAL_REACTION__TRIGGER: return SGraphPackage.REACTION__TRIGGER;
				case StextPackage.LOCAL_REACTION__EFFECT: return SGraphPackage.REACTION__EFFECT;
				case StextPackage.LOCAL_REACTION__PROPERTIES: return SGraphPackage.REACTION__PROPERTIES;
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
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Reaction.class) {
			switch (baseFeatureID) {
				case SGraphPackage.REACTION__TRIGGER: return StextPackage.LOCAL_REACTION__TRIGGER;
				case SGraphPackage.REACTION__EFFECT: return StextPackage.LOCAL_REACTION__EFFECT;
				case SGraphPackage.REACTION__PROPERTIES: return StextPackage.LOCAL_REACTION__PROPERTIES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //LocalReactionImpl
