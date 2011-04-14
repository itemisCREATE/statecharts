/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.model.sct.statechart.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.model.sct.statechart.Event;
import org.yakindu.model.sct.statechart.ExpressionElement;
import org.yakindu.model.sct.statechart.Reaction;
import org.yakindu.model.sct.statechart.ReactiveElement;
import org.yakindu.model.sct.statechart.Region;
import org.yakindu.model.sct.statechart.Scope;
import org.yakindu.model.sct.statechart.ScopedElement;
import org.yakindu.model.sct.statechart.Statechart;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.model.sct.statechart.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statechart</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.model.sct.statechart.impl.StatechartImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.yakindu.model.sct.statechart.impl.StatechartImpl#getReactions <em>Reactions</em>}</li>
 *   <li>{@link org.yakindu.model.sct.statechart.impl.StatechartImpl#getLocalReactions <em>Local Reactions</em>}</li>
 *   <li>{@link org.yakindu.model.sct.statechart.impl.StatechartImpl#getScopes <em>Scopes</em>}</li>
 *   <li>{@link org.yakindu.model.sct.statechart.impl.StatechartImpl#getRegions <em>Regions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatechartImpl extends NamedElementImpl implements Statechart {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";

	/**
	 * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected String expression = EXPRESSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReactions() <em>Reactions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReactions()
	 * @generated
	 * @ordered
	 */
	protected EList<Reaction> reactions;

	/**
	 * The cached value of the '{@link #getLocalReactions() <em>Local Reactions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalReactions()
	 * @generated
	 * @ordered
	 */
	protected EList<Reaction> localReactions;

	/**
	 * The cached value of the '{@link #getScopes() <em>Scopes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopes()
	 * @generated
	 * @ordered
	 */
	protected EList<Scope> scopes;

	/**
	 * The cached value of the '{@link #getRegions() <em>Regions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<Region> regions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatechartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatechartPackage.Literals.STATECHART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(String newExpression) {
		String oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatechartPackage.STATECHART__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Reaction> getReactions() {
		if (reactions == null) {
			reactions = new EObjectResolvingEList<Reaction>(Reaction.class, this, StatechartPackage.STATECHART__REACTIONS);
		}
		return reactions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Reaction> getLocalReactions() {
		if (localReactions == null) {
			localReactions = new EObjectContainmentEList<Reaction>(Reaction.class, this, StatechartPackage.STATECHART__LOCAL_REACTIONS);
		}
		return localReactions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Scope> getScopes() {
		if (scopes == null) {
			scopes = new EObjectContainmentEList<Scope>(Scope.class, this, StatechartPackage.STATECHART__SCOPES);
		}
		return scopes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Region> getRegions() {
		if (regions == null) {
			regions = new EObjectContainmentEList<Region>(Region.class, this, StatechartPackage.STATECHART__REGIONS);
		}
		return regions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatechartPackage.STATECHART__LOCAL_REACTIONS:
				return ((InternalEList<?>)getLocalReactions()).basicRemove(otherEnd, msgs);
			case StatechartPackage.STATECHART__SCOPES:
				return ((InternalEList<?>)getScopes()).basicRemove(otherEnd, msgs);
			case StatechartPackage.STATECHART__REGIONS:
				return ((InternalEList<?>)getRegions()).basicRemove(otherEnd, msgs);
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
			case StatechartPackage.STATECHART__EXPRESSION:
				return getExpression();
			case StatechartPackage.STATECHART__REACTIONS:
				return getReactions();
			case StatechartPackage.STATECHART__LOCAL_REACTIONS:
				return getLocalReactions();
			case StatechartPackage.STATECHART__SCOPES:
				return getScopes();
			case StatechartPackage.STATECHART__REGIONS:
				return getRegions();
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
			case StatechartPackage.STATECHART__EXPRESSION:
				setExpression((String)newValue);
				return;
			case StatechartPackage.STATECHART__LOCAL_REACTIONS:
				getLocalReactions().clear();
				getLocalReactions().addAll((Collection<? extends Reaction>)newValue);
				return;
			case StatechartPackage.STATECHART__SCOPES:
				getScopes().clear();
				getScopes().addAll((Collection<? extends Scope>)newValue);
				return;
			case StatechartPackage.STATECHART__REGIONS:
				getRegions().clear();
				getRegions().addAll((Collection<? extends Region>)newValue);
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
			case StatechartPackage.STATECHART__EXPRESSION:
				setExpression(EXPRESSION_EDEFAULT);
				return;
			case StatechartPackage.STATECHART__LOCAL_REACTIONS:
				getLocalReactions().clear();
				return;
			case StatechartPackage.STATECHART__SCOPES:
				getScopes().clear();
				return;
			case StatechartPackage.STATECHART__REGIONS:
				getRegions().clear();
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
			case StatechartPackage.STATECHART__EXPRESSION:
				return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
			case StatechartPackage.STATECHART__REACTIONS:
				return reactions != null && !reactions.isEmpty();
			case StatechartPackage.STATECHART__LOCAL_REACTIONS:
				return localReactions != null && !localReactions.isEmpty();
			case StatechartPackage.STATECHART__SCOPES:
				return scopes != null && !scopes.isEmpty();
			case StatechartPackage.STATECHART__REGIONS:
				return regions != null && !regions.isEmpty();
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
		if (baseClass == ExpressionElement.class) {
			switch (derivedFeatureID) {
				case StatechartPackage.STATECHART__EXPRESSION: return StatechartPackage.EXPRESSION_ELEMENT__EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == ReactiveElement.class) {
			switch (derivedFeatureID) {
				case StatechartPackage.STATECHART__REACTIONS: return StatechartPackage.REACTIVE_ELEMENT__REACTIONS;
				case StatechartPackage.STATECHART__LOCAL_REACTIONS: return StatechartPackage.REACTIVE_ELEMENT__LOCAL_REACTIONS;
				default: return -1;
			}
		}
		if (baseClass == ScopedElement.class) {
			switch (derivedFeatureID) {
				case StatechartPackage.STATECHART__SCOPES: return StatechartPackage.SCOPED_ELEMENT__SCOPES;
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
		if (baseClass == ExpressionElement.class) {
			switch (baseFeatureID) {
				case StatechartPackage.EXPRESSION_ELEMENT__EXPRESSION: return StatechartPackage.STATECHART__EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == ReactiveElement.class) {
			switch (baseFeatureID) {
				case StatechartPackage.REACTIVE_ELEMENT__REACTIONS: return StatechartPackage.STATECHART__REACTIONS;
				case StatechartPackage.REACTIVE_ELEMENT__LOCAL_REACTIONS: return StatechartPackage.STATECHART__LOCAL_REACTIONS;
				default: return -1;
			}
		}
		if (baseClass == ScopedElement.class) {
			switch (baseFeatureID) {
				case StatechartPackage.SCOPED_ELEMENT__SCOPES: return StatechartPackage.STATECHART__SCOPES;
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
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (expression: ");
		result.append(expression);
		result.append(')');
		return result.toString();
	}

} //StatechartImpl
