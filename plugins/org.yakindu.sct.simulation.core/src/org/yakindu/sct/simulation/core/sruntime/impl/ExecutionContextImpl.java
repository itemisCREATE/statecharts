/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.sruntime.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.base.base.impl.NamedElementImpl;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.util.DerivedSubsetEObjectEList;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;
import org.yakindu.sct.simulation.core.sruntime.ExecutionEvent;
import org.yakindu.sct.simulation.core.sruntime.ExecutionSlot;
import org.yakindu.sct.simulation.core.sruntime.ExecutionVariable;
import org.yakindu.sct.simulation.core.sruntime.SRuntimePackage;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Execution Context</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.impl.ExecutionContextImpl#getActiveStates <em>Active States</em>}</li>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.impl.ExecutionContextImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.impl.ExecutionContextImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.impl.ExecutionContextImpl#getExecutedElements <em>Executed Elements</em>}</li>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.impl.ExecutionContextImpl#getSlots <em>Slots</em>}</li>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.impl.ExecutionContextImpl#getSuspendedElements <em>Suspended Elements</em>}</li>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.impl.ExecutionContextImpl#isSnapshot <em>Snapshot</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionContextImpl extends NamedElementImpl implements ExecutionContext {
	/**
	 * The cached value of the '{@link #getActiveStates() <em>Active States</em>}' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getActiveStates()
	 * @generated
	 * @ordered
	 */
	protected EList<RegularState> activeStates;

	/**
	 * The cached value of the '{@link #getExecutedElements() <em>Executed Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutedElements()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> executedElements;

	/**
	 * The cached value of the '{@link #getSlots() <em>Slots</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlots()
	 * @generated
	 * @ordered
	 */
	protected EList<ExecutionSlot> slots;

	/**
	 * The cached value of the '{@link #getSuspendedElements() <em>Suspended Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspendedElements()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> suspendedElements;

	/**
	 * The default value of the '{@link #isSnapshot() <em>Snapshot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSnapshot()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SNAPSHOT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSnapshot() <em>Snapshot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSnapshot()
	 * @generated
	 * @ordered
	 */
	protected boolean snapshot = SNAPSHOT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SRuntimePackage.Literals.EXECUTION_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List<RegularState> getActiveStates() {
		if (activeStates == null) {
			activeStates = new EObjectResolvingEList<RegularState>(RegularState.class, this, SRuntimePackage.EXECUTION_CONTEXT__ACTIVE_STATES);
		}
		return activeStates;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<ExecutionEvent> getEvents() {
		return new DerivedSubsetEObjectEList<ExecutionEvent>(ExecutionEvent.class, this,
				SRuntimePackage.EXECUTION_CONTEXT__EVENTS, SRuntimePackage.EXECUTION_CONTEXT__SLOTS);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<ExecutionVariable> getVariables() {
		return new DerivedSubsetEObjectEList<ExecutionVariable>(ExecutionVariable.class, this,
				SRuntimePackage.EXECUTION_CONTEXT__VARIABLES, SRuntimePackage.EXECUTION_CONTEXT__SLOTS);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List<EObject> getExecutedElements() {
		if (executedElements == null) {
			executedElements = new EObjectResolvingEList<EObject>(EObject.class, this, SRuntimePackage.EXECUTION_CONTEXT__EXECUTED_ELEMENTS);
		}
		return executedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<ExecutionSlot> getSlots() {
		if (slots == null) {
			slots = new EObjectContainmentEList<ExecutionSlot>(ExecutionSlot.class, this, SRuntimePackage.EXECUTION_CONTEXT__SLOTS);
		}
		return slots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<EObject> getSuspendedElements() {
		if (suspendedElements == null) {
			suspendedElements = new EObjectResolvingEList<EObject>(EObject.class, this, SRuntimePackage.EXECUTION_CONTEXT__SUSPENDED_ELEMENTS);
		}
		return suspendedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSnapshot() {
		return snapshot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSnapshot(boolean newSnapshot) {
		boolean oldSnapshot = snapshot;
		snapshot = newSnapshot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SRuntimePackage.EXECUTION_CONTEXT__SNAPSHOT, oldSnapshot, snapshot));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<ExecutionEvent> getRaisedEvents() {
		Iterable<ExecutionEvent> raisedEvents = Iterables.filter(getEvents(), new Predicate<ExecutionEvent>() {
			public boolean apply(ExecutionEvent input) {
				return input.isRaised();
			}
		});
		BasicEList<ExecutionEvent> result = new BasicEList<ExecutionEvent>();
		Iterables.addAll(result, raisedEvents);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<ExecutionEvent> getScheduledEvents() {
		Iterable<ExecutionEvent> raisedEvents = Iterables.filter(getEvents(), new Predicate<ExecutionEvent>() {
			public boolean apply(ExecutionEvent input) {
				return input.isScheduled();
			}
		});
		BasicEList<ExecutionEvent> result = new BasicEList<ExecutionEvent>();
		Iterables.addAll(result, raisedEvents);
		return result;
	}

	/**
	 * Returns the variable by its qualified name
	 * 
	 * @generated NOT
	 */
	public ExecutionVariable getVariable(final String name) {
		Assert.isNotNull(name);
		for (ExecutionVariable var : getVariables()) {
			if (name.equals(var.getName()))
				return var;
		}
		return null;
	}

	/**
	 *Returns the event by its qualified name
	 * 
	 * @generated NOT
	 */
	public ExecutionEvent getEvent(final String name) {
		Assert.isNotNull(name);
		
		for (ExecutionEvent event : getEvents()) {
			if (name.equals(event.getName()))
				return event;
		}
		return null;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<RegularState> getAllActiveStates() {
		List<RegularState> result = Lists.newArrayList();
		List<RegularState> activeLeafStates = getActiveStates();
		for (RegularState regularState : activeLeafStates) {
			result.addAll(getActiveHierachy(regularState));
		}
		return result;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SRuntimePackage.EXECUTION_CONTEXT__SLOTS:
				return ((InternalEList<?>)getSlots()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	private Collection<? extends RegularState> getActiveHierachy(RegularState vertex) {
		List<RegularState> result = new ArrayList<RegularState>();
		result.add(vertex);
		EObject container = vertex.eContainer();
		while (container != null) {
			if (container instanceof RegularState) {
				result.add((State) container);
			}
			container = container.eContainer();
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SRuntimePackage.EXECUTION_CONTEXT__ACTIVE_STATES:
				return getActiveStates();
			case SRuntimePackage.EXECUTION_CONTEXT__EVENTS:
				return getEvents();
			case SRuntimePackage.EXECUTION_CONTEXT__VARIABLES:
				return getVariables();
			case SRuntimePackage.EXECUTION_CONTEXT__EXECUTED_ELEMENTS:
				return getExecutedElements();
			case SRuntimePackage.EXECUTION_CONTEXT__SLOTS:
				return getSlots();
			case SRuntimePackage.EXECUTION_CONTEXT__SUSPENDED_ELEMENTS:
				return getSuspendedElements();
			case SRuntimePackage.EXECUTION_CONTEXT__SNAPSHOT:
				return isSnapshot();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SRuntimePackage.EXECUTION_CONTEXT__ACTIVE_STATES:
				getActiveStates().clear();
				getActiveStates().addAll((Collection<? extends RegularState>)newValue);
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__EVENTS:
				getEvents().clear();
				getEvents().addAll((Collection<? extends ExecutionEvent>)newValue);
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends ExecutionVariable>)newValue);
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__EXECUTED_ELEMENTS:
				getExecutedElements().clear();
				getExecutedElements().addAll((Collection<? extends EObject>)newValue);
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__SLOTS:
				getSlots().clear();
				getSlots().addAll((Collection<? extends ExecutionSlot>)newValue);
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__SUSPENDED_ELEMENTS:
				getSuspendedElements().clear();
				getSuspendedElements().addAll((Collection<? extends EObject>)newValue);
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__SNAPSHOT:
				setSnapshot((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SRuntimePackage.EXECUTION_CONTEXT__ACTIVE_STATES:
				getActiveStates().clear();
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__EVENTS:
				getEvents().clear();
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__VARIABLES:
				getVariables().clear();
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__EXECUTED_ELEMENTS:
				getExecutedElements().clear();
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__SLOTS:
				getSlots().clear();
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__SUSPENDED_ELEMENTS:
				getSuspendedElements().clear();
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__SNAPSHOT:
				setSnapshot(SNAPSHOT_EDEFAULT);
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
			case SRuntimePackage.EXECUTION_CONTEXT__ACTIVE_STATES:
				return activeStates != null && !activeStates.isEmpty();
			case SRuntimePackage.EXECUTION_CONTEXT__EVENTS:
				return !getEvents().isEmpty();
			case SRuntimePackage.EXECUTION_CONTEXT__VARIABLES:
				return !getVariables().isEmpty();
			case SRuntimePackage.EXECUTION_CONTEXT__EXECUTED_ELEMENTS:
				return executedElements != null && !executedElements.isEmpty();
			case SRuntimePackage.EXECUTION_CONTEXT__SLOTS:
				return slots != null && !slots.isEmpty();
			case SRuntimePackage.EXECUTION_CONTEXT__SUSPENDED_ELEMENTS:
				return suspendedElements != null && !suspendedElements.isEmpty();
			case SRuntimePackage.EXECUTION_CONTEXT__SNAPSHOT:
				return snapshot != SNAPSHOT_EDEFAULT;
		}
		return super.eIsSet(featureID);
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
		result.append(" (snapshot: ");
		result.append(snapshot);
		result.append(')');
		return result.toString();
	}

} // ExecutionContextImpl
