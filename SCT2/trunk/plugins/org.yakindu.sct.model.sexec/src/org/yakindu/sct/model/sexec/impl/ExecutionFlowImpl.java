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
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionScope;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.MappedElement;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sgraph.impl.ScopedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getSourceElement <em>Source Element</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getStateVector <em>State Vector</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getSubScopes <em>Sub Scopes</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getSuperScope <em>Super Scope</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getEnterSequences <em>Enter Sequences</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getExitSequence <em>Exit Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getInitSequence <em>Init Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getReactions <em>Reactions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getSimpleName <em>Simple Name</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getReactSequence <em>React Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getStates <em>States</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getRegions <em>Regions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getHistoryVector <em>History Vector</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getEntryAction <em>Entry Action</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getExitAction <em>Exit Action</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getStaticInitSequence <em>Static Init Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionFlowImpl extends ScopedElementImpl implements ExecutionFlow {
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
	 * The cached value of the '{@link #getReactions() <em>Reactions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReactions()
	 * @generated
	 * @ordered
	 */
	protected EList<Reaction> reactions;

	/**
	 * The default value of the '{@link #getSimpleName() <em>Simple Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleName()
	 * @generated
	 * @ordered
	 */
	protected static final String SIMPLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSimpleName() <em>Simple Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleName()
	 * @generated
	 * @ordered
	 */
	protected String simpleName = SIMPLE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReactSequence() <em>React Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReactSequence()
	 * @generated
	 * @ordered
	 */
	protected Sequence reactSequence;

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
	 * The cached value of the '{@link #getHistoryVector() <em>History Vector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHistoryVector()
	 * @generated
	 * @ordered
	 */
	protected StateVector historyVector;

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
	 * The cached value of the '{@link #getStaticInitSequence() <em>Static Init Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStaticInitSequence()
	 * @generated
	 * @ordered
	 */
	protected Sequence staticInitSequence;

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
	public EList<Sequence> getEnterSequences() {
		if (enterSequences == null) {
			enterSequences = new EObjectContainmentEList<Sequence>(Sequence.class, this, SexecPackage.EXECUTION_FLOW__ENTER_SEQUENCES);
		}
		return enterSequences;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__INIT_SEQUENCE, oldInitSequence, newInitSequence);
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
				msgs = ((InternalEObject)initSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__INIT_SEQUENCE, null, msgs);
			if (newInitSequence != null)
				msgs = ((InternalEObject)newInitSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__INIT_SEQUENCE, null, msgs);
			msgs = basicSetInitSequence(newInitSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__INIT_SEQUENCE, newInitSequence, newInitSequence));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__HISTORY_VECTOR, oldHistoryVector, newHistoryVector);
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
				msgs = ((InternalEObject)historyVector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__HISTORY_VECTOR, null, msgs);
			if (newHistoryVector != null)
				msgs = ((InternalEObject)newHistoryVector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__HISTORY_VECTOR, null, msgs);
			msgs = basicSetHistoryVector(newHistoryVector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__HISTORY_VECTOR, newHistoryVector, newHistoryVector));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__ENTRY_ACTION, oldEntryAction, newEntryAction);
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
				msgs = ((InternalEObject)entryAction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__ENTRY_ACTION, null, msgs);
			if (newEntryAction != null)
				msgs = ((InternalEObject)newEntryAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__ENTRY_ACTION, null, msgs);
			msgs = basicSetEntryAction(newEntryAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__ENTRY_ACTION, newEntryAction, newEntryAction));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__EXIT_ACTION, oldExitAction, newExitAction);
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
				msgs = ((InternalEObject)exitAction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__EXIT_ACTION, null, msgs);
			if (newExitAction != null)
				msgs = ((InternalEObject)newExitAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__EXIT_ACTION, null, msgs);
			msgs = basicSetExitAction(newExitAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__EXIT_ACTION, newExitAction, newExitAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sequence getStaticInitSequence() {
		return staticInitSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStaticInitSequence(Sequence newStaticInitSequence, NotificationChain msgs) {
		Sequence oldStaticInitSequence = staticInitSequence;
		staticInitSequence = newStaticInitSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__STATIC_INIT_SEQUENCE, oldStaticInitSequence, newStaticInitSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStaticInitSequence(Sequence newStaticInitSequence) {
		if (newStaticInitSequence != staticInitSequence) {
			NotificationChain msgs = null;
			if (staticInitSequence != null)
				msgs = ((InternalEObject)staticInitSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__STATIC_INIT_SEQUENCE, null, msgs);
			if (newStaticInitSequence != null)
				msgs = ((InternalEObject)newStaticInitSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__STATIC_INIT_SEQUENCE, null, msgs);
			msgs = basicSetStaticInitSequence(newStaticInitSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__STATIC_INIT_SEQUENCE, newStaticInitSequence, newStaticInitSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Reaction> getReactions() {
		if (reactions == null) {
			reactions = new EObjectContainmentEList<Reaction>(Reaction.class, this, SexecPackage.EXECUTION_FLOW__REACTIONS);
		}
		return reactions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSimpleName() {
		return simpleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleName(String newSimpleName) {
		String oldSimpleName = simpleName;
		simpleName = newSimpleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__SIMPLE_NAME, oldSimpleName, simpleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sequence getReactSequence() {
		return reactSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReactSequence(Sequence newReactSequence, NotificationChain msgs) {
		Sequence oldReactSequence = reactSequence;
		reactSequence = newReactSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__REACT_SEQUENCE, oldReactSequence, newReactSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReactSequence(Sequence newReactSequence) {
		if (newReactSequence != reactSequence) {
			NotificationChain msgs = null;
			if (reactSequence != null)
				msgs = ((InternalEObject)reactSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__REACT_SEQUENCE, null, msgs);
			if (newReactSequence != null)
				msgs = ((InternalEObject)newReactSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__REACT_SEQUENCE, null, msgs);
			msgs = basicSetReactSequence(newReactSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__REACT_SEQUENCE, newReactSequence, newReactSequence));
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
			case SexecPackage.EXECUTION_FLOW__ENTER_SEQUENCES:
				return ((InternalEList<?>)getEnterSequences()).basicRemove(otherEnd, msgs);
			case SexecPackage.EXECUTION_FLOW__EXIT_SEQUENCE:
				return basicSetExitSequence(null, msgs);
			case SexecPackage.EXECUTION_FLOW__INIT_SEQUENCE:
				return basicSetInitSequence(null, msgs);
			case SexecPackage.EXECUTION_FLOW__REACTIONS:
				return ((InternalEList<?>)getReactions()).basicRemove(otherEnd, msgs);
			case SexecPackage.EXECUTION_FLOW__REACT_SEQUENCE:
				return basicSetReactSequence(null, msgs);
			case SexecPackage.EXECUTION_FLOW__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
			case SexecPackage.EXECUTION_FLOW__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case SexecPackage.EXECUTION_FLOW__REGIONS:
				return ((InternalEList<?>)getRegions()).basicRemove(otherEnd, msgs);
			case SexecPackage.EXECUTION_FLOW__HISTORY_VECTOR:
				return basicSetHistoryVector(null, msgs);
			case SexecPackage.EXECUTION_FLOW__ENTRY_ACTION:
				return basicSetEntryAction(null, msgs);
			case SexecPackage.EXECUTION_FLOW__EXIT_ACTION:
				return basicSetExitAction(null, msgs);
			case SexecPackage.EXECUTION_FLOW__STATIC_INIT_SEQUENCE:
				return basicSetStaticInitSequence(null, msgs);
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
			case SexecPackage.EXECUTION_FLOW__SOURCE_ELEMENT:
				if (resolve) return getSourceElement();
				return basicGetSourceElement();
			case SexecPackage.EXECUTION_FLOW__NAME:
				return getName();
			case SexecPackage.EXECUTION_FLOW__STATE_VECTOR:
				return getStateVector();
			case SexecPackage.EXECUTION_FLOW__SUB_SCOPES:
				return getSubScopes();
			case SexecPackage.EXECUTION_FLOW__SUPER_SCOPE:
				if (resolve) return getSuperScope();
				return basicGetSuperScope();
			case SexecPackage.EXECUTION_FLOW__ENTER_SEQUENCES:
				return getEnterSequences();
			case SexecPackage.EXECUTION_FLOW__EXIT_SEQUENCE:
				return getExitSequence();
			case SexecPackage.EXECUTION_FLOW__INIT_SEQUENCE:
				return getInitSequence();
			case SexecPackage.EXECUTION_FLOW__REACTIONS:
				return getReactions();
			case SexecPackage.EXECUTION_FLOW__SIMPLE_NAME:
				return getSimpleName();
			case SexecPackage.EXECUTION_FLOW__REACT_SEQUENCE:
				return getReactSequence();
			case SexecPackage.EXECUTION_FLOW__STATES:
				return getStates();
			case SexecPackage.EXECUTION_FLOW__NODES:
				return getNodes();
			case SexecPackage.EXECUTION_FLOW__REGIONS:
				return getRegions();
			case SexecPackage.EXECUTION_FLOW__HISTORY_VECTOR:
				return getHistoryVector();
			case SexecPackage.EXECUTION_FLOW__ENTRY_ACTION:
				return getEntryAction();
			case SexecPackage.EXECUTION_FLOW__EXIT_ACTION:
				return getExitAction();
			case SexecPackage.EXECUTION_FLOW__STATIC_INIT_SEQUENCE:
				return getStaticInitSequence();
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
			case SexecPackage.EXECUTION_FLOW__SOURCE_ELEMENT:
				setSourceElement((EObject)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__NAME:
				setName((String)newValue);
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
			case SexecPackage.EXECUTION_FLOW__ENTER_SEQUENCES:
				getEnterSequences().clear();
				getEnterSequences().addAll((Collection<? extends Sequence>)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__EXIT_SEQUENCE:
				setExitSequence((Sequence)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__INIT_SEQUENCE:
				setInitSequence((Sequence)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__REACTIONS:
				getReactions().clear();
				getReactions().addAll((Collection<? extends Reaction>)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__SIMPLE_NAME:
				setSimpleName((String)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__REACT_SEQUENCE:
				setReactSequence((Sequence)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends ExecutionState>)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends ExecutionNode>)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__REGIONS:
				getRegions().clear();
				getRegions().addAll((Collection<? extends ExecutionRegion>)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__HISTORY_VECTOR:
				setHistoryVector((StateVector)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__ENTRY_ACTION:
				setEntryAction((Step)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__EXIT_ACTION:
				setExitAction((Step)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__STATIC_INIT_SEQUENCE:
				setStaticInitSequence((Sequence)newValue);
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
			case SexecPackage.EXECUTION_FLOW__SOURCE_ELEMENT:
				setSourceElement((EObject)null);
				return;
			case SexecPackage.EXECUTION_FLOW__NAME:
				setName(NAME_EDEFAULT);
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
			case SexecPackage.EXECUTION_FLOW__ENTER_SEQUENCES:
				getEnterSequences().clear();
				return;
			case SexecPackage.EXECUTION_FLOW__EXIT_SEQUENCE:
				setExitSequence((Sequence)null);
				return;
			case SexecPackage.EXECUTION_FLOW__INIT_SEQUENCE:
				setInitSequence((Sequence)null);
				return;
			case SexecPackage.EXECUTION_FLOW__REACTIONS:
				getReactions().clear();
				return;
			case SexecPackage.EXECUTION_FLOW__SIMPLE_NAME:
				setSimpleName(SIMPLE_NAME_EDEFAULT);
				return;
			case SexecPackage.EXECUTION_FLOW__REACT_SEQUENCE:
				setReactSequence((Sequence)null);
				return;
			case SexecPackage.EXECUTION_FLOW__STATES:
				getStates().clear();
				return;
			case SexecPackage.EXECUTION_FLOW__NODES:
				getNodes().clear();
				return;
			case SexecPackage.EXECUTION_FLOW__REGIONS:
				getRegions().clear();
				return;
			case SexecPackage.EXECUTION_FLOW__HISTORY_VECTOR:
				setHistoryVector((StateVector)null);
				return;
			case SexecPackage.EXECUTION_FLOW__ENTRY_ACTION:
				setEntryAction((Step)null);
				return;
			case SexecPackage.EXECUTION_FLOW__EXIT_ACTION:
				setExitAction((Step)null);
				return;
			case SexecPackage.EXECUTION_FLOW__STATIC_INIT_SEQUENCE:
				setStaticInitSequence((Sequence)null);
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
			case SexecPackage.EXECUTION_FLOW__SOURCE_ELEMENT:
				return sourceElement != null;
			case SexecPackage.EXECUTION_FLOW__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SexecPackage.EXECUTION_FLOW__STATE_VECTOR:
				return stateVector != null;
			case SexecPackage.EXECUTION_FLOW__SUB_SCOPES:
				return subScopes != null && !subScopes.isEmpty();
			case SexecPackage.EXECUTION_FLOW__SUPER_SCOPE:
				return superScope != null;
			case SexecPackage.EXECUTION_FLOW__ENTER_SEQUENCES:
				return enterSequences != null && !enterSequences.isEmpty();
			case SexecPackage.EXECUTION_FLOW__EXIT_SEQUENCE:
				return exitSequence != null;
			case SexecPackage.EXECUTION_FLOW__INIT_SEQUENCE:
				return initSequence != null;
			case SexecPackage.EXECUTION_FLOW__REACTIONS:
				return reactions != null && !reactions.isEmpty();
			case SexecPackage.EXECUTION_FLOW__SIMPLE_NAME:
				return SIMPLE_NAME_EDEFAULT == null ? simpleName != null : !SIMPLE_NAME_EDEFAULT.equals(simpleName);
			case SexecPackage.EXECUTION_FLOW__REACT_SEQUENCE:
				return reactSequence != null;
			case SexecPackage.EXECUTION_FLOW__STATES:
				return states != null && !states.isEmpty();
			case SexecPackage.EXECUTION_FLOW__NODES:
				return nodes != null && !nodes.isEmpty();
			case SexecPackage.EXECUTION_FLOW__REGIONS:
				return regions != null && !regions.isEmpty();
			case SexecPackage.EXECUTION_FLOW__HISTORY_VECTOR:
				return historyVector != null;
			case SexecPackage.EXECUTION_FLOW__ENTRY_ACTION:
				return entryAction != null;
			case SexecPackage.EXECUTION_FLOW__EXIT_ACTION:
				return exitAction != null;
			case SexecPackage.EXECUTION_FLOW__STATIC_INIT_SEQUENCE:
				return staticInitSequence != null;
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
		if (baseClass == MappedElement.class) {
			switch (derivedFeatureID) {
				case SexecPackage.EXECUTION_FLOW__SOURCE_ELEMENT: return SexecPackage.MAPPED_ELEMENT__SOURCE_ELEMENT;
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				case SexecPackage.EXECUTION_FLOW__NAME: return BasePackage.NAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == ExecutionScope.class) {
			switch (derivedFeatureID) {
				case SexecPackage.EXECUTION_FLOW__STATE_VECTOR: return SexecPackage.EXECUTION_SCOPE__STATE_VECTOR;
				case SexecPackage.EXECUTION_FLOW__SUB_SCOPES: return SexecPackage.EXECUTION_SCOPE__SUB_SCOPES;
				case SexecPackage.EXECUTION_FLOW__SUPER_SCOPE: return SexecPackage.EXECUTION_SCOPE__SUPER_SCOPE;
				case SexecPackage.EXECUTION_FLOW__ENTER_SEQUENCES: return SexecPackage.EXECUTION_SCOPE__ENTER_SEQUENCES;
				case SexecPackage.EXECUTION_FLOW__EXIT_SEQUENCE: return SexecPackage.EXECUTION_SCOPE__EXIT_SEQUENCE;
				case SexecPackage.EXECUTION_FLOW__INIT_SEQUENCE: return SexecPackage.EXECUTION_SCOPE__INIT_SEQUENCE;
				default: return -1;
			}
		}
		if (baseClass == ExecutionNode.class) {
			switch (derivedFeatureID) {
				case SexecPackage.EXECUTION_FLOW__REACTIONS: return SexecPackage.EXECUTION_NODE__REACTIONS;
				case SexecPackage.EXECUTION_FLOW__SIMPLE_NAME: return SexecPackage.EXECUTION_NODE__SIMPLE_NAME;
				case SexecPackage.EXECUTION_FLOW__REACT_SEQUENCE: return SexecPackage.EXECUTION_NODE__REACT_SEQUENCE;
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
		if (baseClass == MappedElement.class) {
			switch (baseFeatureID) {
				case SexecPackage.MAPPED_ELEMENT__SOURCE_ELEMENT: return SexecPackage.EXECUTION_FLOW__SOURCE_ELEMENT;
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				case BasePackage.NAMED_ELEMENT__NAME: return SexecPackage.EXECUTION_FLOW__NAME;
				default: return -1;
			}
		}
		if (baseClass == ExecutionScope.class) {
			switch (baseFeatureID) {
				case SexecPackage.EXECUTION_SCOPE__STATE_VECTOR: return SexecPackage.EXECUTION_FLOW__STATE_VECTOR;
				case SexecPackage.EXECUTION_SCOPE__SUB_SCOPES: return SexecPackage.EXECUTION_FLOW__SUB_SCOPES;
				case SexecPackage.EXECUTION_SCOPE__SUPER_SCOPE: return SexecPackage.EXECUTION_FLOW__SUPER_SCOPE;
				case SexecPackage.EXECUTION_SCOPE__ENTER_SEQUENCES: return SexecPackage.EXECUTION_FLOW__ENTER_SEQUENCES;
				case SexecPackage.EXECUTION_SCOPE__EXIT_SEQUENCE: return SexecPackage.EXECUTION_FLOW__EXIT_SEQUENCE;
				case SexecPackage.EXECUTION_SCOPE__INIT_SEQUENCE: return SexecPackage.EXECUTION_FLOW__INIT_SEQUENCE;
				default: return -1;
			}
		}
		if (baseClass == ExecutionNode.class) {
			switch (baseFeatureID) {
				case SexecPackage.EXECUTION_NODE__REACTIONS: return SexecPackage.EXECUTION_FLOW__REACTIONS;
				case SexecPackage.EXECUTION_NODE__SIMPLE_NAME: return SexecPackage.EXECUTION_FLOW__SIMPLE_NAME;
				case SexecPackage.EXECUTION_NODE__REACT_SEQUENCE: return SexecPackage.EXECUTION_FLOW__REACT_SEQUENCE;
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
		result.append(", simpleName: ");
		result.append(simpleName);
		result.append(')');
		return result.toString();
	}

} //ExecutionFlowImpl
