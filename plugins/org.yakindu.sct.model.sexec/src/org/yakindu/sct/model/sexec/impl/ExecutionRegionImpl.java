/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sexec.StateVector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionRegionImpl#getDeepEnterSequence <em>Deep Enter Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionRegionImpl#getShallowEnterSequence <em>Shallow Enter Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionRegionImpl#getHistoryVector <em>History Vector</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionRegionImpl#getNodes <em>Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionRegionImpl extends ExecutionScopeImpl implements ExecutionRegion {
	/**
	 * The cached value of the '{@link #getDeepEnterSequence() <em>Deep Enter Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeepEnterSequence()
	 * @generated
	 * @ordered
	 */
	protected Sequence deepEnterSequence;
	/**
	 * The cached value of the '{@link #getShallowEnterSequence() <em>Shallow Enter Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShallowEnterSequence()
	 * @generated
	 * @ordered
	 */
	protected Sequence shallowEnterSequence;
	/**
	 * The cached value of the '{@link #getHistoryVector() <em>History Vector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHistoryVector()
	 * @generated
	 * @ordered
	 */
	protected StateVector historyVector;
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<ExecutionNode> nodes;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SexecPackage.Literals.EXECUTION_REGION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sequence getDeepEnterSequence() {
		return deepEnterSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeepEnterSequence(Sequence newDeepEnterSequence, NotificationChain msgs) {
		Sequence oldDeepEnterSequence = deepEnterSequence;
		deepEnterSequence = newDeepEnterSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_REGION__DEEP_ENTER_SEQUENCE, oldDeepEnterSequence, newDeepEnterSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeepEnterSequence(Sequence newDeepEnterSequence) {
		if (newDeepEnterSequence != deepEnterSequence) {
			NotificationChain msgs = null;
			if (deepEnterSequence != null)
				msgs = ((InternalEObject)deepEnterSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_REGION__DEEP_ENTER_SEQUENCE, null, msgs);
			if (newDeepEnterSequence != null)
				msgs = ((InternalEObject)newDeepEnterSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_REGION__DEEP_ENTER_SEQUENCE, null, msgs);
			msgs = basicSetDeepEnterSequence(newDeepEnterSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_REGION__DEEP_ENTER_SEQUENCE, newDeepEnterSequence, newDeepEnterSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sequence getShallowEnterSequence() {
		return shallowEnterSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetShallowEnterSequence(Sequence newShallowEnterSequence, NotificationChain msgs) {
		Sequence oldShallowEnterSequence = shallowEnterSequence;
		shallowEnterSequence = newShallowEnterSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_REGION__SHALLOW_ENTER_SEQUENCE, oldShallowEnterSequence, newShallowEnterSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShallowEnterSequence(Sequence newShallowEnterSequence) {
		if (newShallowEnterSequence != shallowEnterSequence) {
			NotificationChain msgs = null;
			if (shallowEnterSequence != null)
				msgs = ((InternalEObject)shallowEnterSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_REGION__SHALLOW_ENTER_SEQUENCE, null, msgs);
			if (newShallowEnterSequence != null)
				msgs = ((InternalEObject)newShallowEnterSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_REGION__SHALLOW_ENTER_SEQUENCE, null, msgs);
			msgs = basicSetShallowEnterSequence(newShallowEnterSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_REGION__SHALLOW_ENTER_SEQUENCE, newShallowEnterSequence, newShallowEnterSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateVector getHistoryVector() {
		return historyVector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHistoryVector(StateVector newHistoryVector, NotificationChain msgs) {
		StateVector oldHistoryVector = historyVector;
		historyVector = newHistoryVector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_REGION__HISTORY_VECTOR, oldHistoryVector, newHistoryVector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHistoryVector(StateVector newHistoryVector) {
		if (newHistoryVector != historyVector) {
			NotificationChain msgs = null;
			if (historyVector != null)
				msgs = ((InternalEObject)historyVector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_REGION__HISTORY_VECTOR, null, msgs);
			if (newHistoryVector != null)
				msgs = ((InternalEObject)newHistoryVector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_REGION__HISTORY_VECTOR, null, msgs);
			msgs = basicSetHistoryVector(newHistoryVector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_REGION__HISTORY_VECTOR, newHistoryVector, newHistoryVector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutionNode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectResolvingEList<ExecutionNode>(ExecutionNode.class, this, SexecPackage.EXECUTION_REGION__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SexecPackage.EXECUTION_REGION__DEEP_ENTER_SEQUENCE:
				return basicSetDeepEnterSequence(null, msgs);
			case SexecPackage.EXECUTION_REGION__SHALLOW_ENTER_SEQUENCE:
				return basicSetShallowEnterSequence(null, msgs);
			case SexecPackage.EXECUTION_REGION__HISTORY_VECTOR:
				return basicSetHistoryVector(null, msgs);
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
			case SexecPackage.EXECUTION_REGION__DEEP_ENTER_SEQUENCE:
				return getDeepEnterSequence();
			case SexecPackage.EXECUTION_REGION__SHALLOW_ENTER_SEQUENCE:
				return getShallowEnterSequence();
			case SexecPackage.EXECUTION_REGION__HISTORY_VECTOR:
				return getHistoryVector();
			case SexecPackage.EXECUTION_REGION__NODES:
				return getNodes();
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
			case SexecPackage.EXECUTION_REGION__DEEP_ENTER_SEQUENCE:
				setDeepEnterSequence((Sequence)newValue);
				return;
			case SexecPackage.EXECUTION_REGION__SHALLOW_ENTER_SEQUENCE:
				setShallowEnterSequence((Sequence)newValue);
				return;
			case SexecPackage.EXECUTION_REGION__HISTORY_VECTOR:
				setHistoryVector((StateVector)newValue);
				return;
			case SexecPackage.EXECUTION_REGION__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends ExecutionNode>)newValue);
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
			case SexecPackage.EXECUTION_REGION__DEEP_ENTER_SEQUENCE:
				setDeepEnterSequence((Sequence)null);
				return;
			case SexecPackage.EXECUTION_REGION__SHALLOW_ENTER_SEQUENCE:
				setShallowEnterSequence((Sequence)null);
				return;
			case SexecPackage.EXECUTION_REGION__HISTORY_VECTOR:
				setHistoryVector((StateVector)null);
				return;
			case SexecPackage.EXECUTION_REGION__NODES:
				getNodes().clear();
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
			case SexecPackage.EXECUTION_REGION__DEEP_ENTER_SEQUENCE:
				return deepEnterSequence != null;
			case SexecPackage.EXECUTION_REGION__SHALLOW_ENTER_SEQUENCE:
				return shallowEnterSequence != null;
			case SexecPackage.EXECUTION_REGION__HISTORY_VECTOR:
				return historyVector != null;
			case SexecPackage.EXECUTION_REGION__NODES:
				return nodes != null && !nodes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExecutionRegionImpl
