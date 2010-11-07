/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.statechart.statechart;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.model.statechart.statechart.StatechartFactory
 * @model kind="package"
 * @generated
 */
public interface StatechartPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "statechart";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.yakindu.org/sct/model/statechart/2.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "statechart";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StatechartPackage eINSTANCE = org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.statechart.statechart.impl.StatechartImpl <em>Statechart</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartImpl
	 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getStatechart()
	 * @generated
	 */
	int STATECHART = 0;

	/**
	 * The feature id for the '<em><b>Regions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATECHART__REGIONS = 0;

	/**
	 * The number of structural features of the '<em>Statechart</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATECHART_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.statechart.statechart.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.statechart.statechart.impl.NamedElementImpl
	 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.statechart.statechart.impl.RegionImpl <em>Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.statechart.statechart.impl.RegionImpl
	 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getRegion()
	 * @generated
	 */
	int REGION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Vertices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__VERTICES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__TRANSITIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Statechart</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__STATECHART = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.statechart.statechart.impl.VertexImpl <em>Vertex</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.statechart.statechart.impl.VertexImpl
	 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getVertex()
	 * @generated
	 */
	int VERTEX = 2;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__INCOMING_TRANSITIONS = 0;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__OUTGOING_TRANSITIONS = 1;

	/**
	 * The feature id for the '<em><b>Containing Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__CONTAINING_REGION = 2;

	/**
	 * The number of structural features of the '<em>Vertex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.statechart.statechart.impl.ExpressionElementImpl <em>Expression Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.statechart.statechart.impl.ExpressionElementImpl
	 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getExpressionElement()
	 * @generated
	 */
	int EXPRESSION_ELEMENT = 16;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_ELEMENT__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Expression Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.statechart.statechart.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.statechart.statechart.impl.TransitionImpl
	 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 3;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__EXPRESSION = EXPRESSION_ELEMENT__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__SOURCE = EXPRESSION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__REGION = EXPRESSION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TARGET = EXPRESSION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = EXPRESSION_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.statechart.statechart.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.statechart.statechart.impl.StateImpl
	 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getState()
	 * @generated
	 */
	int STATE = 4;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__INCOMING_TRANSITIONS = VERTEX__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OUTGOING_TRANSITIONS = VERTEX__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Containing Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__CONTAINING_REGION = VERTEX__CONTAINING_REGION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = VERTEX_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__EXPRESSION = VERTEX_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Regions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__REGIONS = VERTEX_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = VERTEX_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.statechart.statechart.impl.PseudostateImpl <em>Pseudostate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.statechart.statechart.impl.PseudostateImpl
	 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getPseudostate()
	 * @generated
	 */
	int PSEUDOSTATE = 5;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE__INCOMING_TRANSITIONS = VERTEX__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE__OUTGOING_TRANSITIONS = VERTEX__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Containing Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE__CONTAINING_REGION = VERTEX__CONTAINING_REGION;

	/**
	 * The number of structural features of the '<em>Pseudostate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE_FEATURE_COUNT = VERTEX_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.statechart.statechart.impl.FinalStateImpl <em>Final State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.statechart.statechart.impl.FinalStateImpl
	 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getFinalState()
	 * @generated
	 */
	int FINAL_STATE = 6;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__INCOMING_TRANSITIONS = STATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__OUTGOING_TRANSITIONS = STATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Containing Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__CONTAINING_REGION = STATE__CONTAINING_REGION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__NAME = STATE__NAME;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__EXPRESSION = STATE__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Regions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__REGIONS = STATE__REGIONS;

	/**
	 * The number of structural features of the '<em>Final State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.statechart.statechart.impl.InitialStateImpl <em>Initial State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.statechart.statechart.impl.InitialStateImpl
	 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getInitialState()
	 * @generated
	 */
	int INITIAL_STATE = 7;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__INCOMING_TRANSITIONS = PSEUDOSTATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__OUTGOING_TRANSITIONS = PSEUDOSTATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Containing Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__CONTAINING_REGION = PSEUDOSTATE__CONTAINING_REGION;

	/**
	 * The number of structural features of the '<em>Initial State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE_FEATURE_COUNT = PSEUDOSTATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.statechart.statechart.impl.HistoryStateImpl <em>History State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.statechart.statechart.impl.HistoryStateImpl
	 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getHistoryState()
	 * @generated
	 */
	int HISTORY_STATE = 8;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_STATE__INCOMING_TRANSITIONS = PSEUDOSTATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_STATE__OUTGOING_TRANSITIONS = PSEUDOSTATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Containing Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_STATE__CONTAINING_REGION = PSEUDOSTATE__CONTAINING_REGION;

	/**
	 * The number of structural features of the '<em>History State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_STATE_FEATURE_COUNT = PSEUDOSTATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.statechart.statechart.impl.DeepHistoryStateImpl <em>Deep History State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.statechart.statechart.impl.DeepHistoryStateImpl
	 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getDeepHistoryState()
	 * @generated
	 */
	int DEEP_HISTORY_STATE = 9;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEEP_HISTORY_STATE__INCOMING_TRANSITIONS = HISTORY_STATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEEP_HISTORY_STATE__OUTGOING_TRANSITIONS = HISTORY_STATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Containing Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEEP_HISTORY_STATE__CONTAINING_REGION = HISTORY_STATE__CONTAINING_REGION;

	/**
	 * The number of structural features of the '<em>Deep History State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEEP_HISTORY_STATE_FEATURE_COUNT = HISTORY_STATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.statechart.statechart.impl.ShallowHistoryStateImpl <em>Shallow History State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.statechart.statechart.impl.ShallowHistoryStateImpl
	 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getShallowHistoryState()
	 * @generated
	 */
	int SHALLOW_HISTORY_STATE = 10;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHALLOW_HISTORY_STATE__INCOMING_TRANSITIONS = HISTORY_STATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHALLOW_HISTORY_STATE__OUTGOING_TRANSITIONS = HISTORY_STATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Containing Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHALLOW_HISTORY_STATE__CONTAINING_REGION = HISTORY_STATE__CONTAINING_REGION;

	/**
	 * The number of structural features of the '<em>Shallow History State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHALLOW_HISTORY_STATE_FEATURE_COUNT = HISTORY_STATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.statechart.statechart.impl.ForkImpl <em>Fork</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.statechart.statechart.impl.ForkImpl
	 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getFork()
	 * @generated
	 */
	int FORK = 11;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__INCOMING_TRANSITIONS = PSEUDOSTATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__OUTGOING_TRANSITIONS = PSEUDOSTATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Containing Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__CONTAINING_REGION = PSEUDOSTATE__CONTAINING_REGION;

	/**
	 * The number of structural features of the '<em>Fork</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_FEATURE_COUNT = PSEUDOSTATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.statechart.statechart.impl.JoinImpl <em>Join</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.statechart.statechart.impl.JoinImpl
	 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getJoin()
	 * @generated
	 */
	int JOIN = 12;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__INCOMING_TRANSITIONS = PSEUDOSTATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__OUTGOING_TRANSITIONS = PSEUDOSTATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Containing Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__CONTAINING_REGION = PSEUDOSTATE__CONTAINING_REGION;

	/**
	 * The number of structural features of the '<em>Join</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_FEATURE_COUNT = PSEUDOSTATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.statechart.statechart.impl.JunctionImpl <em>Junction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.statechart.statechart.impl.JunctionImpl
	 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getJunction()
	 * @generated
	 */
	int JUNCTION = 13;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__INCOMING_TRANSITIONS = PSEUDOSTATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__OUTGOING_TRANSITIONS = PSEUDOSTATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Containing Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__CONTAINING_REGION = PSEUDOSTATE__CONTAINING_REGION;

	/**
	 * The number of structural features of the '<em>Junction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION_FEATURE_COUNT = PSEUDOSTATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.statechart.statechart.impl.ChoiceImpl <em>Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.statechart.statechart.impl.ChoiceImpl
	 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getChoice()
	 * @generated
	 */
	int CHOICE = 14;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__INCOMING_TRANSITIONS = PSEUDOSTATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__OUTGOING_TRANSITIONS = PSEUDOSTATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Containing Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__CONTAINING_REGION = PSEUDOSTATE__CONTAINING_REGION;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__EXPRESSION = PSEUDOSTATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_FEATURE_COUNT = PSEUDOSTATE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.statechart.statechart.Statechart <em>Statechart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statechart</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.Statechart
	 * @generated
	 */
	EClass getStatechart();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.statechart.statechart.Statechart#getRegions <em>Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Regions</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.Statechart#getRegions()
	 * @see #getStatechart()
	 * @generated
	 */
	EReference getStatechart_Regions();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.statechart.statechart.Region <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Region</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.Region
	 * @generated
	 */
	EClass getRegion();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.statechart.statechart.Region#getVertices <em>Vertices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vertices</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.Region#getVertices()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_Vertices();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.statechart.statechart.Region#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.Region#getTransitions()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_Transitions();

	/**
	 * Returns the meta object for the container reference '{@link org.yakindu.sct.model.statechart.statechart.Region#getStatechart <em>Statechart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Statechart</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.Region#getStatechart()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_Statechart();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.statechart.statechart.Vertex <em>Vertex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vertex</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.Vertex
	 * @generated
	 */
	EClass getVertex();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.sct.model.statechart.statechart.Vertex#getIncomingTransitions <em>Incoming Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Transitions</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.Vertex#getIncomingTransitions()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_IncomingTransitions();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.sct.model.statechart.statechart.Vertex#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Transitions</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.Vertex#getOutgoingTransitions()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_OutgoingTransitions();

	/**
	 * Returns the meta object for the container reference '{@link org.yakindu.sct.model.statechart.statechart.Vertex#getContainingRegion <em>Containing Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Region</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.Vertex#getContainingRegion()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_ContainingRegion();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.statechart.statechart.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.statechart.statechart.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.Transition#getSource()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Source();

	/**
	 * Returns the meta object for the container reference '{@link org.yakindu.sct.model.statechart.statechart.Transition#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Region</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.Transition#getRegion()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Region();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.statechart.statechart.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.Transition#getTarget()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Target();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.statechart.statechart.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.statechart.statechart.State#getRegions <em>Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Regions</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.State#getRegions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Regions();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.statechart.statechart.Pseudostate <em>Pseudostate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pseudostate</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.Pseudostate
	 * @generated
	 */
	EClass getPseudostate();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.statechart.statechart.FinalState <em>Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Final State</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.FinalState
	 * @generated
	 */
	EClass getFinalState();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.statechart.statechart.InitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initial State</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.InitialState
	 * @generated
	 */
	EClass getInitialState();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.statechart.statechart.HistoryState <em>History State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>History State</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.HistoryState
	 * @generated
	 */
	EClass getHistoryState();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.statechart.statechart.DeepHistoryState <em>Deep History State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deep History State</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.DeepHistoryState
	 * @generated
	 */
	EClass getDeepHistoryState();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.statechart.statechart.ShallowHistoryState <em>Shallow History State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shallow History State</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.ShallowHistoryState
	 * @generated
	 */
	EClass getShallowHistoryState();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.statechart.statechart.Fork <em>Fork</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fork</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.Fork
	 * @generated
	 */
	EClass getFork();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.statechart.statechart.Join <em>Join</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Join</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.Join
	 * @generated
	 */
	EClass getJoin();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.statechart.statechart.Junction <em>Junction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Junction</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.Junction
	 * @generated
	 */
	EClass getJunction();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.statechart.statechart.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.Choice
	 * @generated
	 */
	EClass getChoice();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.statechart.statechart.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.statechart.statechart.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.statechart.statechart.ExpressionElement <em>Expression Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Element</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.ExpressionElement
	 * @generated
	 */
	EClass getExpressionElement();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.statechart.statechart.ExpressionElement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see org.yakindu.sct.model.statechart.statechart.ExpressionElement#getExpression()
	 * @see #getExpressionElement()
	 * @generated
	 */
	EAttribute getExpressionElement_Expression();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StatechartFactory getStatechartFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.statechart.statechart.impl.StatechartImpl <em>Statechart</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartImpl
		 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getStatechart()
		 * @generated
		 */
		EClass STATECHART = eINSTANCE.getStatechart();

		/**
		 * The meta object literal for the '<em><b>Regions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATECHART__REGIONS = eINSTANCE.getStatechart_Regions();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.statechart.statechart.impl.RegionImpl <em>Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.statechart.statechart.impl.RegionImpl
		 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getRegion()
		 * @generated
		 */
		EClass REGION = eINSTANCE.getRegion();

		/**
		 * The meta object literal for the '<em><b>Vertices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__VERTICES = eINSTANCE.getRegion_Vertices();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__TRANSITIONS = eINSTANCE.getRegion_Transitions();

		/**
		 * The meta object literal for the '<em><b>Statechart</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__STATECHART = eINSTANCE.getRegion_Statechart();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.statechart.statechart.impl.VertexImpl <em>Vertex</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.statechart.statechart.impl.VertexImpl
		 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getVertex()
		 * @generated
		 */
		EClass VERTEX = eINSTANCE.getVertex();

		/**
		 * The meta object literal for the '<em><b>Incoming Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX__INCOMING_TRANSITIONS = eINSTANCE.getVertex_IncomingTransitions();

		/**
		 * The meta object literal for the '<em><b>Outgoing Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX__OUTGOING_TRANSITIONS = eINSTANCE.getVertex_OutgoingTransitions();

		/**
		 * The meta object literal for the '<em><b>Containing Region</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX__CONTAINING_REGION = eINSTANCE.getVertex_ContainingRegion();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.statechart.statechart.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.statechart.statechart.impl.TransitionImpl
		 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__SOURCE = eINSTANCE.getTransition_Source();

		/**
		 * The meta object literal for the '<em><b>Region</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__REGION = eINSTANCE.getTransition_Region();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TARGET = eINSTANCE.getTransition_Target();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.statechart.statechart.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.statechart.statechart.impl.StateImpl
		 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Regions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__REGIONS = eINSTANCE.getState_Regions();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.statechart.statechart.impl.PseudostateImpl <em>Pseudostate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.statechart.statechart.impl.PseudostateImpl
		 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getPseudostate()
		 * @generated
		 */
		EClass PSEUDOSTATE = eINSTANCE.getPseudostate();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.statechart.statechart.impl.FinalStateImpl <em>Final State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.statechart.statechart.impl.FinalStateImpl
		 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getFinalState()
		 * @generated
		 */
		EClass FINAL_STATE = eINSTANCE.getFinalState();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.statechart.statechart.impl.InitialStateImpl <em>Initial State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.statechart.statechart.impl.InitialStateImpl
		 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getInitialState()
		 * @generated
		 */
		EClass INITIAL_STATE = eINSTANCE.getInitialState();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.statechart.statechart.impl.HistoryStateImpl <em>History State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.statechart.statechart.impl.HistoryStateImpl
		 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getHistoryState()
		 * @generated
		 */
		EClass HISTORY_STATE = eINSTANCE.getHistoryState();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.statechart.statechart.impl.DeepHistoryStateImpl <em>Deep History State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.statechart.statechart.impl.DeepHistoryStateImpl
		 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getDeepHistoryState()
		 * @generated
		 */
		EClass DEEP_HISTORY_STATE = eINSTANCE.getDeepHistoryState();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.statechart.statechart.impl.ShallowHistoryStateImpl <em>Shallow History State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.statechart.statechart.impl.ShallowHistoryStateImpl
		 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getShallowHistoryState()
		 * @generated
		 */
		EClass SHALLOW_HISTORY_STATE = eINSTANCE.getShallowHistoryState();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.statechart.statechart.impl.ForkImpl <em>Fork</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.statechart.statechart.impl.ForkImpl
		 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getFork()
		 * @generated
		 */
		EClass FORK = eINSTANCE.getFork();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.statechart.statechart.impl.JoinImpl <em>Join</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.statechart.statechart.impl.JoinImpl
		 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getJoin()
		 * @generated
		 */
		EClass JOIN = eINSTANCE.getJoin();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.statechart.statechart.impl.JunctionImpl <em>Junction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.statechart.statechart.impl.JunctionImpl
		 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getJunction()
		 * @generated
		 */
		EClass JUNCTION = eINSTANCE.getJunction();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.statechart.statechart.impl.ChoiceImpl <em>Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.statechart.statechart.impl.ChoiceImpl
		 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getChoice()
		 * @generated
		 */
		EClass CHOICE = eINSTANCE.getChoice();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.statechart.statechart.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.statechart.statechart.impl.NamedElementImpl
		 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.statechart.statechart.impl.ExpressionElementImpl <em>Expression Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.statechart.statechart.impl.ExpressionElementImpl
		 * @see org.yakindu.sct.model.statechart.statechart.impl.StatechartPackageImpl#getExpressionElement()
		 * @generated
		 */
		EClass EXPRESSION_ELEMENT = eINSTANCE.getExpressionElement();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_ELEMENT__EXPRESSION = eINSTANCE.getExpressionElement_Expression();

	}

} //StatechartPackage
