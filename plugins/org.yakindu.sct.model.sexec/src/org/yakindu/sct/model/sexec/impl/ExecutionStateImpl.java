/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sexec.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.base.types.AnnotatableElement;
import org.yakindu.base.types.Annotation;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.Declaration;
import org.yakindu.base.types.GenericElement;
import org.yakindu.base.types.PackageMember;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeConstraint;
import org.yakindu.base.types.TypeParameter;
import org.yakindu.base.types.TypeSpecifier;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.sct.model.sexec.ExecutionScope;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.Step;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionStateImpl#getStateVector <em>State Vector</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionStateImpl#getSubScopes <em>Sub Scopes</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionStateImpl#getSuperScope <em>Super Scope</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionStateImpl#getEnterSequences <em>Enter Sequences</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionStateImpl#getExitSequence <em>Exit Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionStateImpl#getInitSequence <em>Init Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionStateImpl#isLeaf <em>Leaf</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionStateImpl#getEntryAction <em>Entry Action</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionStateImpl#getExitAction <em>Exit Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExecutionStateImpl extends ExecutionNodeImpl implements ExecutionState {
	/**
	 * The cached value of the '{@link #getStateVector() <em>State Vector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateVector()
	 * @generated
	 * @ordered
	 */
	protected StateVector stateVector;

	/**
	 * The cached value of the '{@link #getSubScopes() <em>Sub Scopes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubScopes()
	 * @generated
	 * @ordered
	 */
	protected EList<ExecutionScope> subScopes;

	/**
	 * The cached value of the '{@link #getSuperScope() <em>Super Scope</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperScope()
	 * @generated
	 * @ordered
	 */
	protected ExecutionScope superScope;

	/**
	 * The cached value of the '{@link #getEnterSequences() <em>Enter Sequences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnterSequences()
	 * @generated
	 * @ordered
	 */
	protected EList<Sequence> enterSequences;

	/**
	 * The cached value of the '{@link #getExitSequence() <em>Exit Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExitSequence()
	 * @generated
	 * @ordered
	 */
	protected Sequence exitSequence;

	/**
	 * The cached value of the '{@link #getInitSequence() <em>Init Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitSequence()
	 * @generated
	 * @ordered
	 */
	protected Sequence initSequence;

	/**
	 * The default value of the '{@link #isLeaf() <em>Leaf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLeaf()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LEAF_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLeaf() <em>Leaf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLeaf()
	 * @generated
	 * @ordered
	 */
	protected boolean leaf = LEAF_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEntryAction() <em>Entry Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryAction()
	 * @generated
	 * @ordered
	 */
	protected Step entryAction;

	/**
	 * The cached value of the '{@link #getExitAction() <em>Exit Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExitAction()
	 * @generated
	 * @ordered
	 */
	protected Step exitAction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SexecPackage.Literals.EXECUTION_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateVector getStateVector() {
		return stateVector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStateVector(StateVector newStateVector, NotificationChain msgs) {
		StateVector oldStateVector = stateVector;
		stateVector = newStateVector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_STATE__STATE_VECTOR, oldStateVector, newStateVector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateVector(StateVector newStateVector) {
		if (newStateVector != stateVector) {
			NotificationChain msgs = null;
			if (stateVector != null)
				msgs = ((InternalEObject)stateVector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_STATE__STATE_VECTOR, null, msgs);
			if (newStateVector != null)
				msgs = ((InternalEObject)newStateVector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_STATE__STATE_VECTOR, null, msgs);
			msgs = basicSetStateVector(newStateVector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_STATE__STATE_VECTOR, newStateVector, newStateVector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutionScope> getSubScopes() {
		if (subScopes == null) {
			subScopes = new EObjectWithInverseResolvingEList<ExecutionScope>(ExecutionScope.class, this, SexecPackage.EXECUTION_STATE__SUB_SCOPES, SexecPackage.EXECUTION_SCOPE__SUPER_SCOPE);
		}
		return subScopes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionScope getSuperScope() {
		if (superScope != null && superScope.eIsProxy()) {
			InternalEObject oldSuperScope = (InternalEObject)superScope;
			superScope = (ExecutionScope)eResolveProxy(oldSuperScope);
			if (superScope != oldSuperScope) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SexecPackage.EXECUTION_STATE__SUPER_SCOPE, oldSuperScope, superScope));
			}
		}
		return superScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionScope basicGetSuperScope() {
		return superScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuperScope(ExecutionScope newSuperScope, NotificationChain msgs) {
		ExecutionScope oldSuperScope = superScope;
		superScope = newSuperScope;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_STATE__SUPER_SCOPE, oldSuperScope, newSuperScope);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperScope(ExecutionScope newSuperScope) {
		if (newSuperScope != superScope) {
			NotificationChain msgs = null;
			if (superScope != null)
				msgs = ((InternalEObject)superScope).eInverseRemove(this, SexecPackage.EXECUTION_SCOPE__SUB_SCOPES, ExecutionScope.class, msgs);
			if (newSuperScope != null)
				msgs = ((InternalEObject)newSuperScope).eInverseAdd(this, SexecPackage.EXECUTION_SCOPE__SUB_SCOPES, ExecutionScope.class, msgs);
			msgs = basicSetSuperScope(newSuperScope, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_STATE__SUPER_SCOPE, newSuperScope, newSuperScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Sequence> getEnterSequences() {
		if (enterSequences == null) {
			enterSequences = new EObjectContainmentEList<Sequence>(Sequence.class, this, SexecPackage.EXECUTION_STATE__ENTER_SEQUENCES);
		}
		return enterSequences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Step getEntryAction() {
		return entryAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEntryAction(Step newEntryAction, NotificationChain msgs) {
		Step oldEntryAction = entryAction;
		entryAction = newEntryAction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_STATE__ENTRY_ACTION, oldEntryAction, newEntryAction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryAction(Step newEntryAction) {
		if (newEntryAction != entryAction) {
			NotificationChain msgs = null;
			if (entryAction != null)
				msgs = ((InternalEObject)entryAction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_STATE__ENTRY_ACTION, null, msgs);
			if (newEntryAction != null)
				msgs = ((InternalEObject)newEntryAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_STATE__ENTRY_ACTION, null, msgs);
			msgs = basicSetEntryAction(newEntryAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_STATE__ENTRY_ACTION, newEntryAction, newEntryAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Step getExitAction() {
		return exitAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExitAction(Step newExitAction, NotificationChain msgs) {
		Step oldExitAction = exitAction;
		exitAction = newExitAction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_STATE__EXIT_ACTION, oldExitAction, newExitAction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExitAction(Step newExitAction) {
		if (newExitAction != exitAction) {
			NotificationChain msgs = null;
			if (exitAction != null)
				msgs = ((InternalEObject)exitAction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_STATE__EXIT_ACTION, null, msgs);
			if (newExitAction != null)
				msgs = ((InternalEObject)newExitAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_STATE__EXIT_ACTION, null, msgs);
			msgs = basicSetExitAction(newExitAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_STATE__EXIT_ACTION, newExitAction, newExitAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sequence getExitSequence() {
		return exitSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExitSequence(Sequence newExitSequence, NotificationChain msgs) {
		Sequence oldExitSequence = exitSequence;
		exitSequence = newExitSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_STATE__EXIT_SEQUENCE, oldExitSequence, newExitSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExitSequence(Sequence newExitSequence) {
		if (newExitSequence != exitSequence) {
			NotificationChain msgs = null;
			if (exitSequence != null)
				msgs = ((InternalEObject)exitSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_STATE__EXIT_SEQUENCE, null, msgs);
			if (newExitSequence != null)
				msgs = ((InternalEObject)newExitSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_STATE__EXIT_SEQUENCE, null, msgs);
			msgs = basicSetExitSequence(newExitSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_STATE__EXIT_SEQUENCE, newExitSequence, newExitSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sequence getInitSequence() {
		return initSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitSequence(Sequence newInitSequence, NotificationChain msgs) {
		Sequence oldInitSequence = initSequence;
		initSequence = newInitSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_STATE__INIT_SEQUENCE, oldInitSequence, newInitSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitSequence(Sequence newInitSequence) {
		if (newInitSequence != initSequence) {
			NotificationChain msgs = null;
			if (initSequence != null)
				msgs = ((InternalEObject)initSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_STATE__INIT_SEQUENCE, null, msgs);
			if (newInitSequence != null)
				msgs = ((InternalEObject)newInitSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_STATE__INIT_SEQUENCE, null, msgs);
			msgs = basicSetInitSequence(newInitSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_STATE__INIT_SEQUENCE, newInitSequence, newInitSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getId() {
		return getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SexecPackage.EXECUTION_STATE__SUB_SCOPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubScopes()).basicAdd(otherEnd, msgs);
			case SexecPackage.EXECUTION_STATE__SUPER_SCOPE:
				if (superScope != null)
					msgs = ((InternalEObject)superScope).eInverseRemove(this, SexecPackage.EXECUTION_SCOPE__SUB_SCOPES, ExecutionScope.class, msgs);
				return basicSetSuperScope((ExecutionScope)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLeaf() {
		return leaf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeaf(boolean newLeaf) {
		boolean oldLeaf = leaf;
		leaf = newLeaf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_STATE__LEAF, oldLeaf, leaf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SexecPackage.EXECUTION_STATE__STATE_VECTOR:
				return basicSetStateVector(null, msgs);
			case SexecPackage.EXECUTION_STATE__SUB_SCOPES:
				return ((InternalEList<?>)getSubScopes()).basicRemove(otherEnd, msgs);
			case SexecPackage.EXECUTION_STATE__SUPER_SCOPE:
				return basicSetSuperScope(null, msgs);
			case SexecPackage.EXECUTION_STATE__ENTER_SEQUENCES:
				return ((InternalEList<?>)getEnterSequences()).basicRemove(otherEnd, msgs);
			case SexecPackage.EXECUTION_STATE__EXIT_SEQUENCE:
				return basicSetExitSequence(null, msgs);
			case SexecPackage.EXECUTION_STATE__INIT_SEQUENCE:
				return basicSetInitSequence(null, msgs);
			case SexecPackage.EXECUTION_STATE__ENTRY_ACTION:
				return basicSetEntryAction(null, msgs);
			case SexecPackage.EXECUTION_STATE__EXIT_ACTION:
				return basicSetExitAction(null, msgs);
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
			case SexecPackage.EXECUTION_STATE__STATE_VECTOR:
				return getStateVector();
			case SexecPackage.EXECUTION_STATE__SUB_SCOPES:
				return getSubScopes();
			case SexecPackage.EXECUTION_STATE__SUPER_SCOPE:
				if (resolve) return getSuperScope();
				return basicGetSuperScope();
			case SexecPackage.EXECUTION_STATE__ENTER_SEQUENCES:
				return getEnterSequences();
			case SexecPackage.EXECUTION_STATE__EXIT_SEQUENCE:
				return getExitSequence();
			case SexecPackage.EXECUTION_STATE__INIT_SEQUENCE:
				return getInitSequence();
			case SexecPackage.EXECUTION_STATE__LEAF:
				return isLeaf();
			case SexecPackage.EXECUTION_STATE__ENTRY_ACTION:
				return getEntryAction();
			case SexecPackage.EXECUTION_STATE__EXIT_ACTION:
				return getExitAction();
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
			case SexecPackage.EXECUTION_STATE__STATE_VECTOR:
				setStateVector((StateVector)newValue);
				return;
			case SexecPackage.EXECUTION_STATE__SUB_SCOPES:
				getSubScopes().clear();
				getSubScopes().addAll((Collection<? extends ExecutionScope>)newValue);
				return;
			case SexecPackage.EXECUTION_STATE__SUPER_SCOPE:
				setSuperScope((ExecutionScope)newValue);
				return;
			case SexecPackage.EXECUTION_STATE__ENTER_SEQUENCES:
				getEnterSequences().clear();
				getEnterSequences().addAll((Collection<? extends Sequence>)newValue);
				return;
			case SexecPackage.EXECUTION_STATE__EXIT_SEQUENCE:
				setExitSequence((Sequence)newValue);
				return;
			case SexecPackage.EXECUTION_STATE__INIT_SEQUENCE:
				setInitSequence((Sequence)newValue);
				return;
			case SexecPackage.EXECUTION_STATE__LEAF:
				setLeaf((Boolean)newValue);
				return;
			case SexecPackage.EXECUTION_STATE__ENTRY_ACTION:
				setEntryAction((Step)newValue);
				return;
			case SexecPackage.EXECUTION_STATE__EXIT_ACTION:
				setExitAction((Step)newValue);
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
			case SexecPackage.EXECUTION_STATE__STATE_VECTOR:
				setStateVector((StateVector)null);
				return;
			case SexecPackage.EXECUTION_STATE__SUB_SCOPES:
				getSubScopes().clear();
				return;
			case SexecPackage.EXECUTION_STATE__SUPER_SCOPE:
				setSuperScope((ExecutionScope)null);
				return;
			case SexecPackage.EXECUTION_STATE__ENTER_SEQUENCES:
				getEnterSequences().clear();
				return;
			case SexecPackage.EXECUTION_STATE__EXIT_SEQUENCE:
				setExitSequence((Sequence)null);
				return;
			case SexecPackage.EXECUTION_STATE__INIT_SEQUENCE:
				setInitSequence((Sequence)null);
				return;
			case SexecPackage.EXECUTION_STATE__LEAF:
				setLeaf(LEAF_EDEFAULT);
				return;
			case SexecPackage.EXECUTION_STATE__ENTRY_ACTION:
				setEntryAction((Step)null);
				return;
			case SexecPackage.EXECUTION_STATE__EXIT_ACTION:
				setExitAction((Step)null);
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
			case SexecPackage.EXECUTION_STATE__STATE_VECTOR:
				return stateVector != null;
			case SexecPackage.EXECUTION_STATE__SUB_SCOPES:
				return subScopes != null && !subScopes.isEmpty();
			case SexecPackage.EXECUTION_STATE__SUPER_SCOPE:
				return superScope != null;
			case SexecPackage.EXECUTION_STATE__ENTER_SEQUENCES:
				return enterSequences != null && !enterSequences.isEmpty();
			case SexecPackage.EXECUTION_STATE__EXIT_SEQUENCE:
				return exitSequence != null;
			case SexecPackage.EXECUTION_STATE__INIT_SEQUENCE:
				return initSequence != null;
			case SexecPackage.EXECUTION_STATE__LEAF:
				return leaf != LEAF_EDEFAULT;
			case SexecPackage.EXECUTION_STATE__ENTRY_ACTION:
				return entryAction != null;
			case SexecPackage.EXECUTION_STATE__EXIT_ACTION:
				return exitAction != null;
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
		if (baseClass == ExecutionScope.class) {
			switch (derivedFeatureID) {
				case SexecPackage.EXECUTION_STATE__STATE_VECTOR: return SexecPackage.EXECUTION_SCOPE__STATE_VECTOR;
				case SexecPackage.EXECUTION_STATE__SUB_SCOPES: return SexecPackage.EXECUTION_SCOPE__SUB_SCOPES;
				case SexecPackage.EXECUTION_STATE__SUPER_SCOPE: return SexecPackage.EXECUTION_SCOPE__SUPER_SCOPE;
				case SexecPackage.EXECUTION_STATE__ENTER_SEQUENCES: return SexecPackage.EXECUTION_SCOPE__ENTER_SEQUENCES;
				case SexecPackage.EXECUTION_STATE__EXIT_SEQUENCE: return SexecPackage.EXECUTION_SCOPE__EXIT_SEQUENCE;
				case SexecPackage.EXECUTION_STATE__INIT_SEQUENCE: return SexecPackage.EXECUTION_SCOPE__INIT_SEQUENCE;
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
		if (baseClass == ExecutionScope.class) {
			switch (baseFeatureID) {
				case SexecPackage.EXECUTION_SCOPE__STATE_VECTOR: return SexecPackage.EXECUTION_STATE__STATE_VECTOR;
				case SexecPackage.EXECUTION_SCOPE__SUB_SCOPES: return SexecPackage.EXECUTION_STATE__SUB_SCOPES;
				case SexecPackage.EXECUTION_SCOPE__SUPER_SCOPE: return SexecPackage.EXECUTION_STATE__SUPER_SCOPE;
				case SexecPackage.EXECUTION_SCOPE__ENTER_SEQUENCES: return SexecPackage.EXECUTION_STATE__ENTER_SEQUENCES;
				case SexecPackage.EXECUTION_SCOPE__EXIT_SEQUENCE: return SexecPackage.EXECUTION_STATE__EXIT_SEQUENCE;
				case SexecPackage.EXECUTION_SCOPE__INIT_SEQUENCE: return SexecPackage.EXECUTION_STATE__INIT_SEQUENCE;
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
		result.append(" (leaf: ");
		result.append(leaf);
		result.append(')');
		return result.toString();
	}

} //ExecutionStateImpl
