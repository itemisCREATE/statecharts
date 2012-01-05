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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionScope;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.MappedElement;
import org.yakindu.sct.model.sexec.NamedElement;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sgraph.impl.ScopedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getSourceElement <em>Source Element</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getStateVector <em>State Vector</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getSubScopes <em>Sub Scopes</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getSuperScope <em>Super Scope</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getStates <em>States</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getEnterSequence <em>Enter Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getExitSequence <em>Exit Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getRegions <em>Regions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionFlowImpl extends ScopedElementImpl implements ExecutionFlow {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSourceElement() <em>Source Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceElement()
	 * @generated
	 * @ordered
	 */
	protected EObject sourceElement;

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
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<ExecutionState> states;

	/**
	 * The cached value of the '{@link #getEnterSequence() <em>Enter Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnterSequence()
	 * @generated
	 * @ordered
	 */
	protected Sequence enterSequence;

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
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<ExecutionNode> nodes;

	/**
	 * The cached value of the '{@link #getRegions() <em>Regions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<ExecutionRegion> regions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionFlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SexecPackage.Literals.EXECUTION_FLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getSourceElement() {
		if (sourceElement != null && sourceElement.eIsProxy()) {
			InternalEObject oldSourceElement = (InternalEObject)sourceElement;
			sourceElement = eResolveProxy(oldSourceElement);
			if (sourceElement != oldSourceElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SexecPackage.EXECUTION_FLOW__SOURCE_ELEMENT, oldSourceElement, sourceElement));
			}
		}
		return sourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSourceElement() {
		return sourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceElement(EObject newSourceElement) {
		EObject oldSourceElement = sourceElement;
		sourceElement = newSourceElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__SOURCE_ELEMENT, oldSourceElement, sourceElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutionState> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<ExecutionState>(ExecutionState.class, this, SexecPackage.EXECUTION_FLOW__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sequence getEnterSequence() {
		return enterSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnterSequence(Sequence newEnterSequence, NotificationChain msgs) {
		Sequence oldEnterSequence = enterSequence;
		enterSequence = newEnterSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__ENTER_SEQUENCE, oldEnterSequence, newEnterSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnterSequence(Sequence newEnterSequence) {
		if (newEnterSequence != enterSequence) {
			NotificationChain msgs = null;
			if (enterSequence != null)
				msgs = ((InternalEObject)enterSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__ENTER_SEQUENCE, null, msgs);
			if (newEnterSequence != null)
				msgs = ((InternalEObject)newEnterSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__ENTER_SEQUENCE, null, msgs);
			msgs = basicSetEnterSequence(newEnterSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__ENTER_SEQUENCE, newEnterSequence, newEnterSequence));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__STATE_VECTOR, oldStateVector, newStateVector);
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
				msgs = ((InternalEObject)stateVector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__STATE_VECTOR, null, msgs);
			if (newStateVector != null)
				msgs = ((InternalEObject)newStateVector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__STATE_VECTOR, null, msgs);
			msgs = basicSetStateVector(newStateVector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__STATE_VECTOR, newStateVector, newStateVector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutionScope> getSubScopes() {
		if (subScopes == null) {
			subScopes = new EObjectWithInverseResolvingEList<ExecutionScope>(ExecutionScope.class, this, SexecPackage.EXECUTION_FLOW__SUB_SCOPES, SexecPackage.EXECUTION_SCOPE__SUPER_SCOPE);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SexecPackage.EXECUTION_FLOW__SUPER_SCOPE, oldSuperScope, superScope));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__SUPER_SCOPE, oldSuperScope, newSuperScope);
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
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__SUPER_SCOPE, newSuperScope, newSuperScope));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__EXIT_SEQUENCE, oldExitSequence, newExitSequence);
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
				msgs = ((InternalEObject)exitSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__EXIT_SEQUENCE, null, msgs);
			if (newExitSequence != null)
				msgs = ((InternalEObject)newExitSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__EXIT_SEQUENCE, null, msgs);
			msgs = basicSetExitSequence(newExitSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__EXIT_SEQUENCE, newExitSequence, newExitSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutionNode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<ExecutionNode>(ExecutionNode.class, this, SexecPackage.EXECUTION_FLOW__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutionRegion> getRegions() {
		if (regions == null) {
			regions = new EObjectContainmentEList<ExecutionRegion>(ExecutionRegion.class, this, SexecPackage.EXECUTION_FLOW__REGIONS);
		}
		return regions;
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
			case SexecPackage.EXECUTION_FLOW__SUB_SCOPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubScopes()).basicAdd(otherEnd, msgs);
			case SexecPackage.EXECUTION_FLOW__SUPER_SCOPE:
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
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SexecPackage.EXECUTION_FLOW__STATE_VECTOR:
				return basicSetStateVector(null, msgs);
			case SexecPackage.EXECUTION_FLOW__SUB_SCOPES:
				return ((InternalEList<?>)getSubScopes()).basicRemove(otherEnd, msgs);
			case SexecPackage.EXECUTION_FLOW__SUPER_SCOPE:
				return basicSetSuperScope(null, msgs);
			case SexecPackage.EXECUTION_FLOW__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
			case SexecPackage.EXECUTION_FLOW__ENTER_SEQUENCE:
				return basicSetEnterSequence(null, msgs);
			case SexecPackage.EXECUTION_FLOW__EXIT_SEQUENCE:
				return basicSetExitSequence(null, msgs);
			case SexecPackage.EXECUTION_FLOW__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case SexecPackage.EXECUTION_FLOW__REGIONS:
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
			case SexecPackage.EXECUTION_FLOW__NAME:
				return getName();
			case SexecPackage.EXECUTION_FLOW__SOURCE_ELEMENT:
				if (resolve) return getSourceElement();
				return basicGetSourceElement();
			case SexecPackage.EXECUTION_FLOW__STATE_VECTOR:
				return getStateVector();
			case SexecPackage.EXECUTION_FLOW__SUB_SCOPES:
				return getSubScopes();
			case SexecPackage.EXECUTION_FLOW__SUPER_SCOPE:
				if (resolve) return getSuperScope();
				return basicGetSuperScope();
			case SexecPackage.EXECUTION_FLOW__STATES:
				return getStates();
			case SexecPackage.EXECUTION_FLOW__ENTER_SEQUENCE:
				return getEnterSequence();
			case SexecPackage.EXECUTION_FLOW__EXIT_SEQUENCE:
				return getExitSequence();
			case SexecPackage.EXECUTION_FLOW__NODES:
				return getNodes();
			case SexecPackage.EXECUTION_FLOW__REGIONS:
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
			case SexecPackage.EXECUTION_FLOW__NAME:
				setName((String)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__SOURCE_ELEMENT:
				setSourceElement((EObject)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__STATE_VECTOR:
				setStateVector((StateVector)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__SUB_SCOPES:
				getSubScopes().clear();
				getSubScopes().addAll((Collection<? extends ExecutionScope>)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__SUPER_SCOPE:
				setSuperScope((ExecutionScope)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends ExecutionState>)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__ENTER_SEQUENCE:
				setEnterSequence((Sequence)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__EXIT_SEQUENCE:
				setExitSequence((Sequence)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends ExecutionNode>)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__REGIONS:
				getRegions().clear();
				getRegions().addAll((Collection<? extends ExecutionRegion>)newValue);
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
			case SexecPackage.EXECUTION_FLOW__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SexecPackage.EXECUTION_FLOW__SOURCE_ELEMENT:
				setSourceElement((EObject)null);
				return;
			case SexecPackage.EXECUTION_FLOW__STATE_VECTOR:
				setStateVector((StateVector)null);
				return;
			case SexecPackage.EXECUTION_FLOW__SUB_SCOPES:
				getSubScopes().clear();
				return;
			case SexecPackage.EXECUTION_FLOW__SUPER_SCOPE:
				setSuperScope((ExecutionScope)null);
				return;
			case SexecPackage.EXECUTION_FLOW__STATES:
				getStates().clear();
				return;
			case SexecPackage.EXECUTION_FLOW__ENTER_SEQUENCE:
				setEnterSequence((Sequence)null);
				return;
			case SexecPackage.EXECUTION_FLOW__EXIT_SEQUENCE:
				setExitSequence((Sequence)null);
				return;
			case SexecPackage.EXECUTION_FLOW__NODES:
				getNodes().clear();
				return;
			case SexecPackage.EXECUTION_FLOW__REGIONS:
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
			case SexecPackage.EXECUTION_FLOW__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SexecPackage.EXECUTION_FLOW__SOURCE_ELEMENT:
				return sourceElement != null;
			case SexecPackage.EXECUTION_FLOW__STATE_VECTOR:
				return stateVector != null;
			case SexecPackage.EXECUTION_FLOW__SUB_SCOPES:
				return subScopes != null && !subScopes.isEmpty();
			case SexecPackage.EXECUTION_FLOW__SUPER_SCOPE:
				return superScope != null;
			case SexecPackage.EXECUTION_FLOW__STATES:
				return states != null && !states.isEmpty();
			case SexecPackage.EXECUTION_FLOW__ENTER_SEQUENCE:
				return enterSequence != null;
			case SexecPackage.EXECUTION_FLOW__EXIT_SEQUENCE:
				return exitSequence != null;
			case SexecPackage.EXECUTION_FLOW__NODES:
				return nodes != null && !nodes.isEmpty();
			case SexecPackage.EXECUTION_FLOW__REGIONS:
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
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				case SexecPackage.EXECUTION_FLOW__NAME: return SexecPackage.NAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == MappedElement.class) {
			switch (derivedFeatureID) {
				case SexecPackage.EXECUTION_FLOW__SOURCE_ELEMENT: return SexecPackage.MAPPED_ELEMENT__SOURCE_ELEMENT;
				default: return -1;
			}
		}
		if (baseClass == ExecutionScope.class) {
			switch (derivedFeatureID) {
				case SexecPackage.EXECUTION_FLOW__STATE_VECTOR: return SexecPackage.EXECUTION_SCOPE__STATE_VECTOR;
				case SexecPackage.EXECUTION_FLOW__SUB_SCOPES: return SexecPackage.EXECUTION_SCOPE__SUB_SCOPES;
				case SexecPackage.EXECUTION_FLOW__SUPER_SCOPE: return SexecPackage.EXECUTION_SCOPE__SUPER_SCOPE;
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
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				case SexecPackage.NAMED_ELEMENT__NAME: return SexecPackage.EXECUTION_FLOW__NAME;
				default: return -1;
			}
		}
		if (baseClass == MappedElement.class) {
			switch (baseFeatureID) {
				case SexecPackage.MAPPED_ELEMENT__SOURCE_ELEMENT: return SexecPackage.EXECUTION_FLOW__SOURCE_ELEMENT;
				default: return -1;
			}
		}
		if (baseClass == ExecutionScope.class) {
			switch (baseFeatureID) {
				case SexecPackage.EXECUTION_SCOPE__STATE_VECTOR: return SexecPackage.EXECUTION_FLOW__STATE_VECTOR;
				case SexecPackage.EXECUTION_SCOPE__SUB_SCOPES: return SexecPackage.EXECUTION_FLOW__SUB_SCOPES;
				case SexecPackage.EXECUTION_SCOPE__SUPER_SCOPE: return SexecPackage.EXECUTION_FLOW__SUPER_SCOPE;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ExecutionFlowImpl
