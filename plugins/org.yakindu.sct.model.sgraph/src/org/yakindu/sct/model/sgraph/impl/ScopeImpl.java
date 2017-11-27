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
package org.yakindu.sct.model.sgraph.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.base.types.Declaration;
import org.yakindu.base.types.Event;
import org.yakindu.base.types.Property;
import org.yakindu.sct.model.sgraph.Reaction;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.util.DerivedSubsetEObjectEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Scope</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.ScopeImpl#getDeclarations <em>Declarations</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.ScopeImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.ScopeImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.ScopeImpl#getReactions <em>Reactions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.ScopeImpl#getMembers <em>Members</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScopeImpl extends EObjectImpl implements Scope {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";

	/**
	 * The cached value of the '{@link #getMembers() <em>Members</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembers()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> members;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ScopeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SGraphPackage.Literals.SCOPE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Declaration> getDeclarations() {
		return new DerivedSubsetEObjectEList<Declaration>(Declaration.class, this,
				SGraphPackage.SCOPE__DECLARATIONS,
				SGraphPackage.SCOPE__MEMBERS);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Event> getEvents() {
		return new DerivedSubsetEObjectEList<Event>(Event.class, this,
				SGraphPackage.SCOPE__EVENTS,
				SGraphPackage.SCOPE__MEMBERS);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Property> getVariables() {
		return new DerivedSubsetEObjectEList<Property>(Property.class, this,
				SGraphPackage.SCOPE__VARIABLES,
				SGraphPackage.SCOPE__MEMBERS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Reaction> getReactions() {
		return new DerivedSubsetEObjectEList<Reaction>(Reaction.class, this,
				SGraphPackage.SCOPE__REACTIONS,
				SGraphPackage.SCOPE__MEMBERS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getMembers() {
		if (members == null) {
			members = new EObjectContainmentEList.Resolving<EObject>(EObject.class, this, SGraphPackage.SCOPE__MEMBERS);
		}
		return members;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SGraphPackage.SCOPE__MEMBERS:
				return ((InternalEList<?>)getMembers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SGraphPackage.SCOPE__DECLARATIONS:
				return getDeclarations();
			case SGraphPackage.SCOPE__EVENTS:
				return getEvents();
			case SGraphPackage.SCOPE__VARIABLES:
				return getVariables();
			case SGraphPackage.SCOPE__REACTIONS:
				return getReactions();
			case SGraphPackage.SCOPE__MEMBERS:
				return getMembers();
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
			case SGraphPackage.SCOPE__MEMBERS:
				getMembers().clear();
				getMembers().addAll((Collection<? extends EObject>)newValue);
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
			case SGraphPackage.SCOPE__MEMBERS:
				getMembers().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SGraphPackage.SCOPE__DECLARATIONS:
				return !getDeclarations().isEmpty();
			case SGraphPackage.SCOPE__EVENTS:
				return !getEvents().isEmpty();
			case SGraphPackage.SCOPE__VARIABLES:
				return !getVariables().isEmpty();
			case SGraphPackage.SCOPE__REACTIONS:
				return !getReactions().isEmpty();
			case SGraphPackage.SCOPE__MEMBERS:
				return members != null && !members.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ScopeImpl
