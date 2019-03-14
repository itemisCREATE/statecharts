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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.base.NamedElement;
import org.yakindu.base.types.AnnotatableElement;
import org.yakindu.base.types.Annotation;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.Declaration;
import org.yakindu.base.types.GenericElement;
import org.yakindu.base.types.MetaComposite;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeParameter;
import org.yakindu.base.types.TypeSpecifier;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.base.types.Visibility;
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
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getSourceElement <em>Source Element</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getAnnotationInfo <em>Annotation Info</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getMetaFeatures <em>Meta Features</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#isVisible <em>Visible</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getStateVector <em>State Vector</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getSubScopes <em>Sub Scopes</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getSuperScope <em>Super Scope</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getEnterSequences <em>Enter Sequences</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getExitSequence <em>Exit Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getInitSequence <em>Init Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getReactions <em>Reactions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getSimpleName <em>Simple Name</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getReactSequence <em>React Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getLocalReactSequence <em>Local React Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getStates <em>States</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getRegions <em>Regions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getHistoryVector <em>History Vector</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getEntryAction <em>Entry Action</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getExitAction <em>Exit Action</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl#getStaticInitSequence <em>Static Init Sequence</em>}</li>
 * </ul>
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
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<Annotation> annotations;

	/**
	 * The cached value of the '{@link #getAnnotationInfo() <em>Annotation Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotationInfo()
	 * @generated
	 * @ordered
	 */
	protected AnnotatableElement annotationInfo;

	/**
	 * The cached value of the '{@link #getMetaFeatures() <em>Meta Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Declaration> metaFeatures;

	/**
	 * The default value of the '{@link #isStatic() <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STATIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStatic() <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatic()
	 * @generated
	 * @ordered
	 */
	protected boolean static_ = STATIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final Visibility VISIBILITY_EDEFAULT = Visibility.PUBLIC;

	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected Visibility visibility = VISIBILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

	/**
	 * The default value of the '{@link #isVisible() <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VISIBLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isVisible() <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisible()
	 * @generated
	 * @ordered
	 */
	protected boolean visible = VISIBLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSuperTypes() <em>Super Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeSpecifier> superTypes;

	/**
	 * The cached value of the '{@link #getTypeParameters() <em>Type Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeParameter> typeParameters;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Declaration> features;

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
	 * The cached value of the '{@link #getLocalReactSequence() <em>Local React Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalReactSequence()
	 * @generated
	 * @ordered
	 */
	protected Sequence localReactSequence;

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
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
	public EList<Annotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, SexecPackage.EXECUTION_FLOW__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnnotatableElement getAnnotationInfo() {
		return annotationInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnnotationInfo(AnnotatableElement newAnnotationInfo, NotificationChain msgs) {
		AnnotatableElement oldAnnotationInfo = annotationInfo;
		annotationInfo = newAnnotationInfo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__ANNOTATION_INFO, oldAnnotationInfo, newAnnotationInfo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAnnotationInfo(AnnotatableElement newAnnotationInfo) {
		if (newAnnotationInfo != annotationInfo) {
			NotificationChain msgs = null;
			if (annotationInfo != null)
				msgs = ((InternalEObject)annotationInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__ANNOTATION_INFO, null, msgs);
			if (newAnnotationInfo != null)
				msgs = ((InternalEObject)newAnnotationInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__ANNOTATION_INFO, null, msgs);
			msgs = basicSetAnnotationInfo(newAnnotationInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__ANNOTATION_INFO, newAnnotationInfo, newAnnotationInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Declaration> getMetaFeatures() {
		if (metaFeatures == null) {
			metaFeatures = new EObjectContainmentEList<Declaration>(Declaration.class, this, SexecPackage.EXECUTION_FLOW__META_FEATURES);
		}
		return metaFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * The id is the name of the execution flow.
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
	@Override
	public Visibility getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVisibility(Visibility newVisibility) {
		Visibility oldVisibility = visibility;
		visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isVisible() {
		return visible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVisible(boolean newVisible) {
		boolean oldVisible = visible;
		visible = newVisible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__VISIBLE, oldVisible, visible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TypeSpecifier> getSuperTypes() {
		if (superTypes == null) {
			superTypes = new EObjectContainmentEList<TypeSpecifier>(TypeSpecifier.class, this, SexecPackage.EXECUTION_FLOW__SUPER_TYPES);
		}
		return superTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TypeParameter> getTypeParameters() {
		if (typeParameters == null) {
			typeParameters = new EObjectContainmentEList<TypeParameter>(TypeParameter.class, this, SexecPackage.EXECUTION_FLOW__TYPE_PARAMETERS);
		}
		return typeParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isStatic() {
		return static_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatic(boolean newStatic) {
		boolean oldStatic = static_;
		static_ = newStatic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__STATIC, oldStatic, static_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Declaration> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentEList<Declaration>(Declaration.class, this, SexecPackage.EXECUTION_FLOW__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
	public EList<Declaration> getAllFeatures() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type getOriginType() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Annotation getAnnotationOfType(String typeName) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public String getSimpleName() {
		return simpleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
	public Sequence getLocalReactSequence() {
		return localReactSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocalReactSequence(Sequence newLocalReactSequence, NotificationChain msgs) {
		Sequence oldLocalReactSequence = localReactSequence;
		localReactSequence = newLocalReactSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__LOCAL_REACT_SEQUENCE, oldLocalReactSequence, newLocalReactSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLocalReactSequence(Sequence newLocalReactSequence) {
		if (newLocalReactSequence != localReactSequence) {
			NotificationChain msgs = null;
			if (localReactSequence != null)
				msgs = ((InternalEObject)localReactSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__LOCAL_REACT_SEQUENCE, null, msgs);
			if (newLocalReactSequence != null)
				msgs = ((InternalEObject)newLocalReactSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_FLOW__LOCAL_REACT_SEQUENCE, null, msgs);
			msgs = basicSetLocalReactSequence(newLocalReactSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_FLOW__LOCAL_REACT_SEQUENCE, newLocalReactSequence, newLocalReactSequence));
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
			case SexecPackage.EXECUTION_FLOW__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case SexecPackage.EXECUTION_FLOW__ANNOTATION_INFO:
				return basicSetAnnotationInfo(null, msgs);
			case SexecPackage.EXECUTION_FLOW__META_FEATURES:
				return ((InternalEList<?>)getMetaFeatures()).basicRemove(otherEnd, msgs);
			case SexecPackage.EXECUTION_FLOW__SUPER_TYPES:
				return ((InternalEList<?>)getSuperTypes()).basicRemove(otherEnd, msgs);
			case SexecPackage.EXECUTION_FLOW__TYPE_PARAMETERS:
				return ((InternalEList<?>)getTypeParameters()).basicRemove(otherEnd, msgs);
			case SexecPackage.EXECUTION_FLOW__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
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
			case SexecPackage.EXECUTION_FLOW__LOCAL_REACT_SEQUENCE:
				return basicSetLocalReactSequence(null, msgs);
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
			case SexecPackage.EXECUTION_FLOW__ANNOTATIONS:
				return getAnnotations();
			case SexecPackage.EXECUTION_FLOW__ANNOTATION_INFO:
				return getAnnotationInfo();
			case SexecPackage.EXECUTION_FLOW__META_FEATURES:
				return getMetaFeatures();
			case SexecPackage.EXECUTION_FLOW__STATIC:
				return isStatic();
			case SexecPackage.EXECUTION_FLOW__ID:
				return getId();
			case SexecPackage.EXECUTION_FLOW__VISIBILITY:
				return getVisibility();
			case SexecPackage.EXECUTION_FLOW__ABSTRACT:
				return isAbstract();
			case SexecPackage.EXECUTION_FLOW__VISIBLE:
				return isVisible();
			case SexecPackage.EXECUTION_FLOW__SUPER_TYPES:
				return getSuperTypes();
			case SexecPackage.EXECUTION_FLOW__TYPE_PARAMETERS:
				return getTypeParameters();
			case SexecPackage.EXECUTION_FLOW__FEATURES:
				return getFeatures();
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
			case SexecPackage.EXECUTION_FLOW__LOCAL_REACT_SEQUENCE:
				return getLocalReactSequence();
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
			case SexecPackage.EXECUTION_FLOW__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__ANNOTATION_INFO:
				setAnnotationInfo((AnnotatableElement)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__META_FEATURES:
				getMetaFeatures().clear();
				getMetaFeatures().addAll((Collection<? extends Declaration>)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__STATIC:
				setStatic((Boolean)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__VISIBILITY:
				setVisibility((Visibility)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__VISIBLE:
				setVisible((Boolean)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__SUPER_TYPES:
				getSuperTypes().clear();
				getSuperTypes().addAll((Collection<? extends TypeSpecifier>)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__TYPE_PARAMETERS:
				getTypeParameters().clear();
				getTypeParameters().addAll((Collection<? extends TypeParameter>)newValue);
				return;
			case SexecPackage.EXECUTION_FLOW__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends Declaration>)newValue);
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
			case SexecPackage.EXECUTION_FLOW__LOCAL_REACT_SEQUENCE:
				setLocalReactSequence((Sequence)newValue);
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
			case SexecPackage.EXECUTION_FLOW__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case SexecPackage.EXECUTION_FLOW__ANNOTATION_INFO:
				setAnnotationInfo((AnnotatableElement)null);
				return;
			case SexecPackage.EXECUTION_FLOW__META_FEATURES:
				getMetaFeatures().clear();
				return;
			case SexecPackage.EXECUTION_FLOW__STATIC:
				setStatic(STATIC_EDEFAULT);
				return;
			case SexecPackage.EXECUTION_FLOW__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case SexecPackage.EXECUTION_FLOW__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case SexecPackage.EXECUTION_FLOW__VISIBLE:
				setVisible(VISIBLE_EDEFAULT);
				return;
			case SexecPackage.EXECUTION_FLOW__SUPER_TYPES:
				getSuperTypes().clear();
				return;
			case SexecPackage.EXECUTION_FLOW__TYPE_PARAMETERS:
				getTypeParameters().clear();
				return;
			case SexecPackage.EXECUTION_FLOW__FEATURES:
				getFeatures().clear();
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
			case SexecPackage.EXECUTION_FLOW__LOCAL_REACT_SEQUENCE:
				setLocalReactSequence((Sequence)null);
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
			case SexecPackage.EXECUTION_FLOW__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case SexecPackage.EXECUTION_FLOW__ANNOTATION_INFO:
				return annotationInfo != null;
			case SexecPackage.EXECUTION_FLOW__META_FEATURES:
				return metaFeatures != null && !metaFeatures.isEmpty();
			case SexecPackage.EXECUTION_FLOW__STATIC:
				return static_ != STATIC_EDEFAULT;
			case SexecPackage.EXECUTION_FLOW__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case SexecPackage.EXECUTION_FLOW__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case SexecPackage.EXECUTION_FLOW__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case SexecPackage.EXECUTION_FLOW__VISIBLE:
				return visible != VISIBLE_EDEFAULT;
			case SexecPackage.EXECUTION_FLOW__SUPER_TYPES:
				return superTypes != null && !superTypes.isEmpty();
			case SexecPackage.EXECUTION_FLOW__TYPE_PARAMETERS:
				return typeParameters != null && !typeParameters.isEmpty();
			case SexecPackage.EXECUTION_FLOW__FEATURES:
				return features != null && !features.isEmpty();
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
			case SexecPackage.EXECUTION_FLOW__LOCAL_REACT_SEQUENCE:
				return localReactSequence != null;
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
		if (baseClass == AnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SexecPackage.EXECUTION_FLOW__ANNOTATIONS: return TypesPackage.ANNOTATABLE_ELEMENT__ANNOTATIONS;
				case SexecPackage.EXECUTION_FLOW__ANNOTATION_INFO: return TypesPackage.ANNOTATABLE_ELEMENT__ANNOTATION_INFO;
				default: return -1;
			}
		}
		if (baseClass == MetaComposite.class) {
			switch (derivedFeatureID) {
				case SexecPackage.EXECUTION_FLOW__META_FEATURES: return TypesPackage.META_COMPOSITE__META_FEATURES;
				default: return -1;
			}
		}
		if (baseClass == Declaration.class) {
			switch (derivedFeatureID) {
				case SexecPackage.EXECUTION_FLOW__STATIC: return TypesPackage.DECLARATION__STATIC;
				case SexecPackage.EXECUTION_FLOW__ID: return TypesPackage.DECLARATION__ID;
				case SexecPackage.EXECUTION_FLOW__VISIBILITY: return TypesPackage.DECLARATION__VISIBILITY;
				default: return -1;
			}
		}
		if (baseClass == Type.class) {
			switch (derivedFeatureID) {
				case SexecPackage.EXECUTION_FLOW__ABSTRACT: return TypesPackage.TYPE__ABSTRACT;
				case SexecPackage.EXECUTION_FLOW__VISIBLE: return TypesPackage.TYPE__VISIBLE;
				case SexecPackage.EXECUTION_FLOW__SUPER_TYPES: return TypesPackage.TYPE__SUPER_TYPES;
				default: return -1;
			}
		}
		if (baseClass == GenericElement.class) {
			switch (derivedFeatureID) {
				case SexecPackage.EXECUTION_FLOW__TYPE_PARAMETERS: return TypesPackage.GENERIC_ELEMENT__TYPE_PARAMETERS;
				default: return -1;
			}
		}
		if (baseClass == ComplexType.class) {
			switch (derivedFeatureID) {
				case SexecPackage.EXECUTION_FLOW__FEATURES: return TypesPackage.COMPLEX_TYPE__FEATURES;
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
				case SexecPackage.EXECUTION_FLOW__LOCAL_REACT_SEQUENCE: return SexecPackage.EXECUTION_NODE__LOCAL_REACT_SEQUENCE;
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
		if (baseClass == AnnotatableElement.class) {
			switch (baseFeatureID) {
				case TypesPackage.ANNOTATABLE_ELEMENT__ANNOTATIONS: return SexecPackage.EXECUTION_FLOW__ANNOTATIONS;
				case TypesPackage.ANNOTATABLE_ELEMENT__ANNOTATION_INFO: return SexecPackage.EXECUTION_FLOW__ANNOTATION_INFO;
				default: return -1;
			}
		}
		if (baseClass == MetaComposite.class) {
			switch (baseFeatureID) {
				case TypesPackage.META_COMPOSITE__META_FEATURES: return SexecPackage.EXECUTION_FLOW__META_FEATURES;
				default: return -1;
			}
		}
		if (baseClass == Declaration.class) {
			switch (baseFeatureID) {
				case TypesPackage.DECLARATION__STATIC: return SexecPackage.EXECUTION_FLOW__STATIC;
				case TypesPackage.DECLARATION__ID: return SexecPackage.EXECUTION_FLOW__ID;
				case TypesPackage.DECLARATION__VISIBILITY: return SexecPackage.EXECUTION_FLOW__VISIBILITY;
				default: return -1;
			}
		}
		if (baseClass == Type.class) {
			switch (baseFeatureID) {
				case TypesPackage.TYPE__ABSTRACT: return SexecPackage.EXECUTION_FLOW__ABSTRACT;
				case TypesPackage.TYPE__VISIBLE: return SexecPackage.EXECUTION_FLOW__VISIBLE;
				case TypesPackage.TYPE__SUPER_TYPES: return SexecPackage.EXECUTION_FLOW__SUPER_TYPES;
				default: return -1;
			}
		}
		if (baseClass == GenericElement.class) {
			switch (baseFeatureID) {
				case TypesPackage.GENERIC_ELEMENT__TYPE_PARAMETERS: return SexecPackage.EXECUTION_FLOW__TYPE_PARAMETERS;
				default: return -1;
			}
		}
		if (baseClass == ComplexType.class) {
			switch (baseFeatureID) {
				case TypesPackage.COMPLEX_TYPE__FEATURES: return SexecPackage.EXECUTION_FLOW__FEATURES;
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
				case SexecPackage.EXECUTION_NODE__LOCAL_REACT_SEQUENCE: return SexecPackage.EXECUTION_FLOW__LOCAL_REACT_SEQUENCE;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", static: ");
		result.append(static_);
		result.append(", visibility: ");
		result.append(visibility);
		result.append(", abstract: ");
		result.append(abstract_);
		result.append(", visible: ");
		result.append(visible);
		result.append(", simpleName: ");
		result.append(simpleName);
		result.append(')');
		return result.toString();
	}

} //ExecutionFlowImpl
