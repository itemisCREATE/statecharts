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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>State</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.yakindu.sct.model.sgraph.impl.StateImpl#getSubRegions <em>Sub
 * Regions</em>}</li>
 * <li>{@link org.yakindu.sct.model.sgraph.impl.StateImpl#isOrthogonal <em>
 * Orthogonal</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class StateImpl extends AbstractStateImpl implements State {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";

	/**
	 * The cached value of the '{@link #getSubRegions() <em>Sub Regions</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<Region> subRegions;

	/**
	 * The default value of the '{@link #isOrthogonal() <em>Orthogonal</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isOrthogonal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ORTHOGONAL_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SGraphPackage.Literals.STATE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Region> getSubRegions() {
		if (subRegions == null) {
			subRegions = new EObjectContainmentEList<Region>(Region.class,
					this, SGraphPackage.STATE__SUB_REGIONS);
		}
		return subRegions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isOrthogonal() {
		return getSubRegions().size() > 1;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SGraphPackage.STATE__SUB_REGIONS:
			return ((InternalEList<?>) getSubRegions()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SGraphPackage.STATE__SUB_REGIONS:
			return getSubRegions();
		case SGraphPackage.STATE__ORTHOGONAL:
			return isOrthogonal();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SGraphPackage.STATE__SUB_REGIONS:
			getSubRegions().clear();
			getSubRegions().addAll((Collection<? extends Region>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case SGraphPackage.STATE__SUB_REGIONS:
			getSubRegions().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case SGraphPackage.STATE__SUB_REGIONS:
			return subRegions != null && !subRegions.isEmpty();
		case SGraphPackage.STATE__ORTHOGONAL:
			return isOrthogonal() != ORTHOGONAL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} // StateImpl
