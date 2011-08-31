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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.SubmachineState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Submachine State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.SubmachineStateImpl#getSubstatechart <em>Substatechart</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubmachineStateImpl extends AbstractStateImpl implements SubmachineState {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";

	/**
	 * The cached value of the '{@link #getSubstatechart() <em>Substatechart</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubstatechart()
	 * @generated
	 * @ordered
	 */
	protected Statechart substatechart;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubmachineStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SGraphPackage.Literals.SUBMACHINE_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statechart getSubstatechart() {
		if (substatechart != null && substatechart.eIsProxy()) {
			InternalEObject oldSubstatechart = (InternalEObject)substatechart;
			substatechart = (Statechart)eResolveProxy(oldSubstatechart);
			if (substatechart != oldSubstatechart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SGraphPackage.SUBMACHINE_STATE__SUBSTATECHART, oldSubstatechart, substatechart));
			}
		}
		return substatechart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statechart basicGetSubstatechart() {
		return substatechart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubstatechart(Statechart newSubstatechart) {
		Statechart oldSubstatechart = substatechart;
		substatechart = newSubstatechart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGraphPackage.SUBMACHINE_STATE__SUBSTATECHART, oldSubstatechart, substatechart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SGraphPackage.SUBMACHINE_STATE__SUBSTATECHART:
				if (resolve) return getSubstatechart();
				return basicGetSubstatechart();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SGraphPackage.SUBMACHINE_STATE__SUBSTATECHART:
				setSubstatechart((Statechart)newValue);
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
			case SGraphPackage.SUBMACHINE_STATE__SUBSTATECHART:
				setSubstatechart((Statechart)null);
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
			case SGraphPackage.SUBMACHINE_STATE__SUBSTATECHART:
				return substatechart != null;
		}
		return super.eIsSet(featureID);
	}

} //SubmachineStateImpl
