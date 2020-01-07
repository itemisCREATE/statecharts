/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sruntime.impl;

import com.google.common.base.Objects;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

import java.util.function.Consumer;

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

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

import org.yakindu.base.base.impl.NamedElementImpl;

import org.yakindu.base.types.Type;

import org.yakindu.sct.model.sruntime.CompositeSlot;
import org.yakindu.sct.model.sruntime.ExecutionContext;
import org.yakindu.sct.model.sruntime.ExecutionEvent;
import org.yakindu.sct.model.sruntime.ExecutionSlot;
import org.yakindu.sct.model.sruntime.ExecutionVariable;
import org.yakindu.sct.model.sruntime.SRuntimePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sruntime.impl.ExecutionContextImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sruntime.impl.ExecutionContextImpl#getFqName <em>Fq Name</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sruntime.impl.ExecutionContextImpl#isWritable <em>Writable</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sruntime.impl.ExecutionContextImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sruntime.impl.ExecutionContextImpl#getSlots <em>Slots</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sruntime.impl.ExecutionContextImpl#getActiveStates <em>Active States</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sruntime.impl.ExecutionContextImpl#getExecutedElements <em>Executed Elements</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sruntime.impl.ExecutionContextImpl#getSuspendedElements <em>Suspended Elements</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sruntime.impl.ExecutionContextImpl#isSnapshot <em>Snapshot</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExecutionContextImpl extends NamedElementImpl implements ExecutionContext {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Object value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFqName() <em>Fq Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFqName()
	 * @generated
	 * @ordered
	 */
	protected static final String FQ_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFqName() <em>Fq Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFqName()
	 * @generated
	 * @ordered
	 */
	protected String fqName = FQ_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isWritable() <em>Writable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWritable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WRITABLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isWritable() <em>Writable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWritable()
	 * @generated
	 * @ordered
	 */
	protected boolean writable = WRITABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;

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
	 * The cached value of the '{@link #getActiveStates() <em>Active States</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveStates()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> activeStates;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SRuntimePackage.Literals.EXECUTION_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValue(Object newValue) {
		Object oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SRuntimePackage.EXECUTION_CONTEXT__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFqName() {
		return fqName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFqName(String newFqName) {
		String oldFqName = fqName;
		fqName = newFqName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SRuntimePackage.EXECUTION_CONTEXT__FQ_NAME, oldFqName, fqName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isWritable() {
		return writable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWritable(boolean newWritable) {
		boolean oldWritable = writable;
		writable = newWritable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SRuntimePackage.EXECUTION_CONTEXT__WRITABLE, oldWritable, writable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Type)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SRuntimePackage.EXECUTION_CONTEXT__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(Type newType) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SRuntimePackage.EXECUTION_CONTEXT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public List<EObject> getActiveStates() {
		if (activeStates == null) {
			activeStates = new EObjectResolvingEList<EObject>(EObject.class, this, SRuntimePackage.EXECUTION_CONTEXT__ACTIVE_STATES);
		}
		return activeStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
	public boolean isSnapshot() {
		return snapshot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSnapshot(boolean newSnapshot) {
		boolean oldSnapshot = snapshot;
		snapshot = newSnapshot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SRuntimePackage.EXECUTION_CONTEXT__SNAPSHOT, oldSnapshot, snapshot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<ExecutionEvent> getRaisedEvents() {
		final Function1<ExecutionEvent, Boolean> _function = new Function1<ExecutionEvent, Boolean>() {
			public Boolean apply(final ExecutionEvent it) {
				return Boolean.valueOf(it.isRaised());
			}
		};
		return IterableExtensions.<ExecutionEvent>toList(IterableExtensions.<ExecutionEvent>filter(this.getAllEvents(), _function));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExecutionVariable getVariable(final String qualifiedName) {
		ExecutionVariable _xblockexpression = null; {
			Assert.isNotNull(qualifiedName);
			final Function1<ExecutionVariable, Boolean> _function = new Function1<ExecutionVariable, Boolean>() {
				public Boolean apply(final ExecutionVariable it) {
					String _fqName = it.getFqName();
					return Boolean.valueOf(Objects.equal(qualifiedName, _fqName));
				}
			};
			_xblockexpression = IterableExtensions.<ExecutionVariable>findFirst(this.getAllVariables(), _function);
		}
		return _xblockexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExecutionEvent getEvent(final String qualifiedName) {
		ExecutionEvent _xblockexpression = null; {
			Assert.isNotNull(qualifiedName);
			final Function1<ExecutionEvent, Boolean> _function = new Function1<ExecutionEvent, Boolean>() {
				public Boolean apply(final ExecutionEvent it) {
					String _fqName = it.getFqName();
					return Boolean.valueOf(Objects.equal(qualifiedName, _fqName));
				}
			};
			_xblockexpression = IterableExtensions.<ExecutionEvent>findFirst(this.getAllEvents(), _function);
		}
		return _xblockexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExecutionSlot getSlot(final String qualifiedName) {
		ExecutionSlot _xblockexpression = null; {
			Assert.isNotNull(qualifiedName);
			final Function1<ExecutionSlot, Boolean> _function = new Function1<ExecutionSlot, Boolean>() {
				public Boolean apply(final ExecutionSlot it) {
					String _fqName = it.getFqName();
					return Boolean.valueOf(Objects.equal(qualifiedName, _fqName));
				}
			};
			_xblockexpression = IterableExtensions.<ExecutionSlot>findFirst(this.getAllSlots(), _function);
		}
		return _xblockexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<ExecutionEvent> getAllEvents() {
		return IterableExtensions.<ExecutionEvent>toList(Iterables.<ExecutionEvent>filter(this.getAllSlots(), ExecutionEvent.class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<ExecutionVariable> getAllVariables() {
		return IterableExtensions.<ExecutionVariable>toList(Iterables.<ExecutionVariable>filter(this.getAllSlots(), ExecutionVariable.class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<ExecutionSlot> getAllSlots() {
		BasicEList<ExecutionSlot> _xblockexpression = null; {
			BasicEList<ExecutionSlot> result = new BasicEList<ExecutionSlot>();
			this.addSlots(result, this.getSlots(), Lists.<ExecutionSlot>newArrayList());
			_xblockexpression = result;
		}
		return _xblockexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addSlots(final List<ExecutionSlot> result, final List<ExecutionSlot> slots, final List<ExecutionSlot> visited) {
		final Consumer<ExecutionSlot> _function = new Consumer<ExecutionSlot>() {
			public void accept(final ExecutionSlot it) {
				boolean _add = visited.add(it);
				if (_add) {
					result.add(it);
					if ((!(it instanceof ExecutionContext))) {
						if ((it instanceof CompositeSlot)) {
							ExecutionContextImpl.this.addSlots(result, ((CompositeSlot)it).getSlots(false), visited);
						}
					}
				}
			}
		};
		slots.forEach(_function);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<ExecutionSlot> getSlots(final boolean doResolve) {
		return this.getSlots();
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SRuntimePackage.EXECUTION_CONTEXT__VALUE:
				return getValue();
			case SRuntimePackage.EXECUTION_CONTEXT__FQ_NAME:
				return getFqName();
			case SRuntimePackage.EXECUTION_CONTEXT__WRITABLE:
				return isWritable();
			case SRuntimePackage.EXECUTION_CONTEXT__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case SRuntimePackage.EXECUTION_CONTEXT__SLOTS:
				return getSlots();
			case SRuntimePackage.EXECUTION_CONTEXT__ACTIVE_STATES:
				return getActiveStates();
			case SRuntimePackage.EXECUTION_CONTEXT__EXECUTED_ELEMENTS:
				return getExecutedElements();
			case SRuntimePackage.EXECUTION_CONTEXT__SUSPENDED_ELEMENTS:
				return getSuspendedElements();
			case SRuntimePackage.EXECUTION_CONTEXT__SNAPSHOT:
				return isSnapshot();
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
			case SRuntimePackage.EXECUTION_CONTEXT__VALUE:
				setValue(newValue);
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__FQ_NAME:
				setFqName((String)newValue);
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__WRITABLE:
				setWritable((Boolean)newValue);
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__TYPE:
				setType((Type)newValue);
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__SLOTS:
				getSlots().clear();
				getSlots().addAll((Collection<? extends ExecutionSlot>)newValue);
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__ACTIVE_STATES:
				getActiveStates().clear();
				getActiveStates().addAll((Collection<? extends EObject>)newValue);
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__EXECUTED_ELEMENTS:
				getExecutedElements().clear();
				getExecutedElements().addAll((Collection<? extends EObject>)newValue);
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SRuntimePackage.EXECUTION_CONTEXT__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__FQ_NAME:
				setFqName(FQ_NAME_EDEFAULT);
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__WRITABLE:
				setWritable(WRITABLE_EDEFAULT);
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__TYPE:
				setType((Type)null);
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__SLOTS:
				getSlots().clear();
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__ACTIVE_STATES:
				getActiveStates().clear();
				return;
			case SRuntimePackage.EXECUTION_CONTEXT__EXECUTED_ELEMENTS:
				getExecutedElements().clear();
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SRuntimePackage.EXECUTION_CONTEXT__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case SRuntimePackage.EXECUTION_CONTEXT__FQ_NAME:
				return FQ_NAME_EDEFAULT == null ? fqName != null : !FQ_NAME_EDEFAULT.equals(fqName);
			case SRuntimePackage.EXECUTION_CONTEXT__WRITABLE:
				return writable != WRITABLE_EDEFAULT;
			case SRuntimePackage.EXECUTION_CONTEXT__TYPE:
				return type != null;
			case SRuntimePackage.EXECUTION_CONTEXT__SLOTS:
				return slots != null && !slots.isEmpty();
			case SRuntimePackage.EXECUTION_CONTEXT__ACTIVE_STATES:
				return activeStates != null && !activeStates.isEmpty();
			case SRuntimePackage.EXECUTION_CONTEXT__EXECUTED_ELEMENTS:
				return executedElements != null && !executedElements.isEmpty();
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ExecutionSlot.class) {
			switch (derivedFeatureID) {
				case SRuntimePackage.EXECUTION_CONTEXT__VALUE: return SRuntimePackage.EXECUTION_SLOT__VALUE;
				case SRuntimePackage.EXECUTION_CONTEXT__FQ_NAME: return SRuntimePackage.EXECUTION_SLOT__FQ_NAME;
				case SRuntimePackage.EXECUTION_CONTEXT__WRITABLE: return SRuntimePackage.EXECUTION_SLOT__WRITABLE;
				case SRuntimePackage.EXECUTION_CONTEXT__TYPE: return SRuntimePackage.EXECUTION_SLOT__TYPE;
				default: return -1;
			}
		}
		if (baseClass == CompositeSlot.class) {
			switch (derivedFeatureID) {
				case SRuntimePackage.EXECUTION_CONTEXT__SLOTS: return SRuntimePackage.COMPOSITE_SLOT__SLOTS;
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
		if (baseClass == ExecutionSlot.class) {
			switch (baseFeatureID) {
				case SRuntimePackage.EXECUTION_SLOT__VALUE: return SRuntimePackage.EXECUTION_CONTEXT__VALUE;
				case SRuntimePackage.EXECUTION_SLOT__FQ_NAME: return SRuntimePackage.EXECUTION_CONTEXT__FQ_NAME;
				case SRuntimePackage.EXECUTION_SLOT__WRITABLE: return SRuntimePackage.EXECUTION_CONTEXT__WRITABLE;
				case SRuntimePackage.EXECUTION_SLOT__TYPE: return SRuntimePackage.EXECUTION_CONTEXT__TYPE;
				default: return -1;
			}
		}
		if (baseClass == CompositeSlot.class) {
			switch (baseFeatureID) {
				case SRuntimePackage.COMPOSITE_SLOT__SLOTS: return SRuntimePackage.EXECUTION_CONTEXT__SLOTS;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (value: ");
		result.append(value);
		result.append(", fqName: ");
		result.append(fqName);
		result.append(", writable: ");
		result.append(writable);
		result.append(", snapshot: ");
		result.append(snapshot);
		result.append(')');
		return result.toString();
	}

} //ExecutionContextImpl
