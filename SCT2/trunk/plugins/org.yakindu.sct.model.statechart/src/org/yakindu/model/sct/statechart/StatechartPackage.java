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
package org.yakindu.model.sct.statechart;

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
 * <!-- begin-model-doc -->
 * Author:muelder.
 * Created:15.12.10 15:39.
 * Title:.
 * Comment:.
 * 
 * <!-- end-model-doc -->
 * @see org.yakindu.model.sct.statechart.StatechartFactory
 * @model kind="package"
 * @generated
 */
public interface StatechartPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";

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
	String eNS_URI = "http:///statechart.ecore";

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
	StatechartPackage eINSTANCE = org.yakindu.model.sct.statechart.impl.StatechartPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.NamedElementImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 2;

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
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.VertexImpl <em>Vertex</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.VertexImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getVertex()
	 * @generated
	 */
	int VERTEX = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__PARENT_REGION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__INCOMING_TRANSITIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__OUTGOING_TRANSITIONS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Vertex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.PseudostateImpl <em>Pseudostate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.PseudostateImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getPseudostate()
	 * @generated
	 */
	int PSEUDOSTATE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE__NAME = VERTEX__NAME;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE__PARENT_REGION = VERTEX__PARENT_REGION;

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
	 * The number of structural features of the '<em>Pseudostate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE_FEATURE_COUNT = VERTEX_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.RegionImpl <em>Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.RegionImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getRegion()
	 * @generated
	 */
	int REGION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__TRANSITIONS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Vertices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__VERTICES = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.ExpressionElementImpl <em>Expression Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.ExpressionElementImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getExpressionElement()
	 * @generated
	 */
	int EXPRESSION_ELEMENT = 27;

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
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.TransitionImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 4;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__EXPRESSION = EXPRESSION_ELEMENT__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TARGET = EXPRESSION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__SOURCE = EXPRESSION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__REGION = EXPRESSION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = EXPRESSION_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.StateImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getState()
	 * @generated
	 */
	int STATE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = VERTEX__NAME;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__PARENT_REGION = VERTEX__PARENT_REGION;

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
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__EXPRESSION = VERTEX_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Regions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__SUB_REGIONS = VERTEX_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = VERTEX_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.FinalStateImpl <em>Final State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.FinalStateImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getFinalState()
	 * @generated
	 */
	int FINAL_STATE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__NAME = STATE__NAME;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__PARENT_REGION = STATE__PARENT_REGION;

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
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__EXPRESSION = STATE__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Sub Regions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__SUB_REGIONS = STATE__SUB_REGIONS;

	/**
	 * The number of structural features of the '<em>Final State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.RealVariableValueImpl <em>Real Variable Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.RealVariableValueImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getRealVariableValue()
	 * @generated
	 */
	int REAL_VARIABLE_VALUE = 7;

	/**
	 * The feature id for the '<em><b></b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_VARIABLE_VALUE__ = 0;

	/**
	 * The number of structural features of the '<em>Real Variable Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_VARIABLE_VALUE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.VariableImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.RealVariableImpl <em>Real Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.RealVariableImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getRealVariable()
	 * @generated
	 */
	int REAL_VARIABLE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_VARIABLE__NAME = VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_VARIABLE__VALUE = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Real Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.HistoryStateImpl <em>History State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.HistoryStateImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getHistoryState()
	 * @generated
	 */
	int HISTORY_STATE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_STATE__NAME = PSEUDOSTATE__NAME;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_STATE__PARENT_REGION = PSEUDOSTATE__PARENT_REGION;

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
	 * The number of structural features of the '<em>History State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_STATE_FEATURE_COUNT = PSEUDOSTATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.ShallowHistoryStateImpl <em>Shallow History State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.ShallowHistoryStateImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getShallowHistoryState()
	 * @generated
	 */
	int SHALLOW_HISTORY_STATE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHALLOW_HISTORY_STATE__NAME = HISTORY_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHALLOW_HISTORY_STATE__PARENT_REGION = HISTORY_STATE__PARENT_REGION;

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
	 * The number of structural features of the '<em>Shallow History State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHALLOW_HISTORY_STATE_FEATURE_COUNT = HISTORY_STATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.JunctionImpl <em>Junction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.JunctionImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getJunction()
	 * @generated
	 */
	int JUNCTION = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__NAME = PSEUDOSTATE__NAME;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__PARENT_REGION = PSEUDOSTATE__PARENT_REGION;

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
	 * The number of structural features of the '<em>Junction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION_FEATURE_COUNT = PSEUDOSTATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.DeepHistoryStateImpl <em>Deep History State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.DeepHistoryStateImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getDeepHistoryState()
	 * @generated
	 */
	int DEEP_HISTORY_STATE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEEP_HISTORY_STATE__NAME = HISTORY_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEEP_HISTORY_STATE__PARENT_REGION = HISTORY_STATE__PARENT_REGION;

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
	 * The number of structural features of the '<em>Deep History State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEEP_HISTORY_STATE_FEATURE_COUNT = HISTORY_STATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.BooleanVariableImpl <em>Boolean Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.BooleanVariableImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getBooleanVariable()
	 * @generated
	 */
	int BOOLEAN_VARIABLE = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VARIABLE__NAME = VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VARIABLE__VALUE = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.BooleanVariableValueImpl <em>Boolean Variable Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.BooleanVariableValueImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getBooleanVariableValue()
	 * @generated
	 */
	int BOOLEAN_VARIABLE_VALUE = 15;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VARIABLE_VALUE__VALUE = 0;

	/**
	 * The feature id for the '<em><b></b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VARIABLE_VALUE__ = 1;

	/**
	 * The number of structural features of the '<em>Boolean Variable Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VARIABLE_VALUE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.JoinImpl <em>Join</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.JoinImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getJoin()
	 * @generated
	 */
	int JOIN = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__NAME = PSEUDOSTATE__NAME;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__PARENT_REGION = PSEUDOSTATE__PARENT_REGION;

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
	 * The number of structural features of the '<em>Join</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_FEATURE_COUNT = PSEUDOSTATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.IntegerVariableImpl <em>Integer Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.IntegerVariableImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getIntegerVariable()
	 * @generated
	 */
	int INTEGER_VARIABLE = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VARIABLE__NAME = VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VARIABLE__VALUE = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.IntegerVariableValueImpl <em>Integer Variable Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.IntegerVariableValueImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getIntegerVariableValue()
	 * @generated
	 */
	int INTEGER_VARIABLE_VALUE = 18;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VARIABLE_VALUE__VALUE = 0;

	/**
	 * The feature id for the '<em><b></b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VARIABLE_VALUE__ = 1;

	/**
	 * The number of structural features of the '<em>Integer Variable Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VARIABLE_VALUE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.EventImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.ChoiceImpl <em>Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.ChoiceImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getChoice()
	 * @generated
	 */
	int CHOICE = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__NAME = PSEUDOSTATE__NAME;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__PARENT_REGION = PSEUDOSTATE__PARENT_REGION;

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
	 * The number of structural features of the '<em>Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_FEATURE_COUNT = PSEUDOSTATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.StatechartImpl <em>Statechart</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.StatechartImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getStatechart()
	 * @generated
	 */
	int STATECHART = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATECHART__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATECHART__EXPRESSION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Regions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATECHART__REGIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATECHART__VARIABLES = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATECHART__EVENTS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Statechart</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATECHART_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.ForkImpl <em>Fork</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.ForkImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getFork()
	 * @generated
	 */
	int FORK = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__NAME = PSEUDOSTATE__NAME;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__PARENT_REGION = PSEUDOSTATE__PARENT_REGION;

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
	 * The number of structural features of the '<em>Fork</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_FEATURE_COUNT = PSEUDOSTATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.InitialStateImpl <em>Initial State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.InitialStateImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getInitialState()
	 * @generated
	 */
	int INITIAL_STATE = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__NAME = PSEUDOSTATE__NAME;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__PARENT_REGION = PSEUDOSTATE__PARENT_REGION;

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
	 * The number of structural features of the '<em>Initial State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE_FEATURE_COUNT = PSEUDOSTATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.TriggerImpl <em>Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.TriggerImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getTrigger()
	 * @generated
	 */
	int TRIGGER = 24;

	/**
	 * The number of structural features of the '<em>Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.EffectImpl <em>Effect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.EffectImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getEffect()
	 * @generated
	 */
	int EFFECT = 25;

	/**
	 * The number of structural features of the '<em>Effect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.yakindu.model.sct.statechart.impl.TimeEventImpl <em>Time Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.model.sct.statechart.impl.TimeEventImpl
	 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getTimeEvent()
	 * @generated
	 */
	int TIME_EVENT = 26;

	/**
	 * The number of structural features of the '<em>Time Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_EVENT_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.Pseudostate <em>Pseudostate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pseudostate</em>'.
	 * @see org.yakindu.model.sct.statechart.Pseudostate
	 * @generated
	 */
	EClass getPseudostate();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.Vertex <em>Vertex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vertex</em>'.
	 * @see org.yakindu.model.sct.statechart.Vertex
	 * @generated
	 */
	EClass getVertex();

	/**
	 * Returns the meta object for the container reference '{@link org.yakindu.model.sct.statechart.Vertex#getParentRegion <em>Parent Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Region</em>'.
	 * @see org.yakindu.model.sct.statechart.Vertex#getParentRegion()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_ParentRegion();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.model.sct.statechart.Vertex#getIncomingTransitions <em>Incoming Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Transitions</em>'.
	 * @see org.yakindu.model.sct.statechart.Vertex#getIncomingTransitions()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_IncomingTransitions();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.model.sct.statechart.Vertex#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Transitions</em>'.
	 * @see org.yakindu.model.sct.statechart.Vertex#getOutgoingTransitions()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_OutgoingTransitions();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.yakindu.model.sct.statechart.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.model.sct.statechart.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.yakindu.model.sct.statechart.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.Region <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Region</em>'.
	 * @see org.yakindu.model.sct.statechart.Region
	 * @generated
	 */
	EClass getRegion();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.model.sct.statechart.Region#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see org.yakindu.model.sct.statechart.Region#getTransitions()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_Transitions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.model.sct.statechart.Region#getVertices <em>Vertices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vertices</em>'.
	 * @see org.yakindu.model.sct.statechart.Region#getVertices()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_Vertices();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see org.yakindu.model.sct.statechart.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.model.sct.statechart.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.yakindu.model.sct.statechart.Transition#getTarget()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Target();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.model.sct.statechart.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.yakindu.model.sct.statechart.Transition#getSource()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Source();

	/**
	 * Returns the meta object for the container reference '{@link org.yakindu.model.sct.statechart.Transition#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Region</em>'.
	 * @see org.yakindu.model.sct.statechart.Transition#getRegion()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Region();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.FinalState <em>Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Final State</em>'.
	 * @see org.yakindu.model.sct.statechart.FinalState
	 * @generated
	 */
	EClass getFinalState();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see org.yakindu.model.sct.statechart.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.model.sct.statechart.State#getSubRegions <em>Sub Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Regions</em>'.
	 * @see org.yakindu.model.sct.statechart.State#getSubRegions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_SubRegions();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.RealVariableValue <em>Real Variable Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Variable Value</em>'.
	 * @see org.yakindu.model.sct.statechart.RealVariableValue
	 * @generated
	 */
	EClass getRealVariableValue();

	/**
	 * Returns the meta object for the container reference '{@link org.yakindu.model.sct.statechart.RealVariableValue#get_ <em></em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em></em>'.
	 * @see org.yakindu.model.sct.statechart.RealVariableValue#get_()
	 * @see #getRealVariableValue()
	 * @generated
	 */
	EReference getRealVariableValue__();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.RealVariable <em>Real Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Variable</em>'.
	 * @see org.yakindu.model.sct.statechart.RealVariable
	 * @generated
	 */
	EClass getRealVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.model.sct.statechart.RealVariable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.yakindu.model.sct.statechart.RealVariable#getValue()
	 * @see #getRealVariable()
	 * @generated
	 */
	EReference getRealVariable_Value();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.yakindu.model.sct.statechart.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.ShallowHistoryState <em>Shallow History State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shallow History State</em>'.
	 * @see org.yakindu.model.sct.statechart.ShallowHistoryState
	 * @generated
	 */
	EClass getShallowHistoryState();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.HistoryState <em>History State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>History State</em>'.
	 * @see org.yakindu.model.sct.statechart.HistoryState
	 * @generated
	 */
	EClass getHistoryState();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.Junction <em>Junction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Junction</em>'.
	 * @see org.yakindu.model.sct.statechart.Junction
	 * @generated
	 */
	EClass getJunction();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.DeepHistoryState <em>Deep History State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deep History State</em>'.
	 * @see org.yakindu.model.sct.statechart.DeepHistoryState
	 * @generated
	 */
	EClass getDeepHistoryState();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.BooleanVariable <em>Boolean Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Variable</em>'.
	 * @see org.yakindu.model.sct.statechart.BooleanVariable
	 * @generated
	 */
	EClass getBooleanVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.model.sct.statechart.BooleanVariable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.yakindu.model.sct.statechart.BooleanVariable#getValue()
	 * @see #getBooleanVariable()
	 * @generated
	 */
	EReference getBooleanVariable_Value();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.BooleanVariableValue <em>Boolean Variable Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Variable Value</em>'.
	 * @see org.yakindu.model.sct.statechart.BooleanVariableValue
	 * @generated
	 */
	EClass getBooleanVariableValue();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.model.sct.statechart.BooleanVariableValue#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.yakindu.model.sct.statechart.BooleanVariableValue#isValue()
	 * @see #getBooleanVariableValue()
	 * @generated
	 */
	EAttribute getBooleanVariableValue_Value();

	/**
	 * Returns the meta object for the container reference '{@link org.yakindu.model.sct.statechart.BooleanVariableValue#get_ <em></em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em></em>'.
	 * @see org.yakindu.model.sct.statechart.BooleanVariableValue#get_()
	 * @see #getBooleanVariableValue()
	 * @generated
	 */
	EReference getBooleanVariableValue__();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.Join <em>Join</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Join</em>'.
	 * @see org.yakindu.model.sct.statechart.Join
	 * @generated
	 */
	EClass getJoin();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.IntegerVariable <em>Integer Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Variable</em>'.
	 * @see org.yakindu.model.sct.statechart.IntegerVariable
	 * @generated
	 */
	EClass getIntegerVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.model.sct.statechart.IntegerVariable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.yakindu.model.sct.statechart.IntegerVariable#getValue()
	 * @see #getIntegerVariable()
	 * @generated
	 */
	EReference getIntegerVariable_Value();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.IntegerVariableValue <em>Integer Variable Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Variable Value</em>'.
	 * @see org.yakindu.model.sct.statechart.IntegerVariableValue
	 * @generated
	 */
	EClass getIntegerVariableValue();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.model.sct.statechart.IntegerVariableValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.yakindu.model.sct.statechart.IntegerVariableValue#getValue()
	 * @see #getIntegerVariableValue()
	 * @generated
	 */
	EAttribute getIntegerVariableValue_Value();

	/**
	 * Returns the meta object for the container reference '{@link org.yakindu.model.sct.statechart.IntegerVariableValue#get_ <em></em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em></em>'.
	 * @see org.yakindu.model.sct.statechart.IntegerVariableValue#get_()
	 * @see #getIntegerVariableValue()
	 * @generated
	 */
	EReference getIntegerVariableValue__();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see org.yakindu.model.sct.statechart.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice</em>'.
	 * @see org.yakindu.model.sct.statechart.Choice
	 * @generated
	 */
	EClass getChoice();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.Statechart <em>Statechart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statechart</em>'.
	 * @see org.yakindu.model.sct.statechart.Statechart
	 * @generated
	 */
	EClass getStatechart();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.model.sct.statechart.Statechart#getRegions <em>Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Regions</em>'.
	 * @see org.yakindu.model.sct.statechart.Statechart#getRegions()
	 * @see #getStatechart()
	 * @generated
	 */
	EReference getStatechart_Regions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.model.sct.statechart.Statechart#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see org.yakindu.model.sct.statechart.Statechart#getVariables()
	 * @see #getStatechart()
	 * @generated
	 */
	EReference getStatechart_Variables();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.model.sct.statechart.Statechart#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Events</em>'.
	 * @see org.yakindu.model.sct.statechart.Statechart#getEvents()
	 * @see #getStatechart()
	 * @generated
	 */
	EReference getStatechart_Events();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.Fork <em>Fork</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fork</em>'.
	 * @see org.yakindu.model.sct.statechart.Fork
	 * @generated
	 */
	EClass getFork();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.InitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initial State</em>'.
	 * @see org.yakindu.model.sct.statechart.InitialState
	 * @generated
	 */
	EClass getInitialState();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.Trigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trigger</em>'.
	 * @see org.yakindu.model.sct.statechart.Trigger
	 * @generated
	 */
	EClass getTrigger();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.Effect <em>Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Effect</em>'.
	 * @see org.yakindu.model.sct.statechart.Effect
	 * @generated
	 */
	EClass getEffect();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.TimeEvent <em>Time Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Event</em>'.
	 * @see org.yakindu.model.sct.statechart.TimeEvent
	 * @generated
	 */
	EClass getTimeEvent();

	/**
	 * Returns the meta object for class '{@link org.yakindu.model.sct.statechart.ExpressionElement <em>Expression Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Element</em>'.
	 * @see org.yakindu.model.sct.statechart.ExpressionElement
	 * @generated
	 */
	EClass getExpressionElement();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.model.sct.statechart.ExpressionElement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see org.yakindu.model.sct.statechart.ExpressionElement#getExpression()
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
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.PseudostateImpl <em>Pseudostate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.PseudostateImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getPseudostate()
		 * @generated
		 */
		EClass PSEUDOSTATE = eINSTANCE.getPseudostate();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.VertexImpl <em>Vertex</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.VertexImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getVertex()
		 * @generated
		 */
		EClass VERTEX = eINSTANCE.getVertex();

		/**
		 * The meta object literal for the '<em><b>Parent Region</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX__PARENT_REGION = eINSTANCE.getVertex_ParentRegion();

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
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.NamedElementImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getNamedElement()
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
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.RegionImpl <em>Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.RegionImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getRegion()
		 * @generated
		 */
		EClass REGION = eINSTANCE.getRegion();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__TRANSITIONS = eINSTANCE.getRegion_Transitions();

		/**
		 * The meta object literal for the '<em><b>Vertices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__VERTICES = eINSTANCE.getRegion_Vertices();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.TransitionImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TARGET = eINSTANCE.getTransition_Target();

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
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.FinalStateImpl <em>Final State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.FinalStateImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getFinalState()
		 * @generated
		 */
		EClass FINAL_STATE = eINSTANCE.getFinalState();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.StateImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Sub Regions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__SUB_REGIONS = eINSTANCE.getState_SubRegions();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.RealVariableValueImpl <em>Real Variable Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.RealVariableValueImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getRealVariableValue()
		 * @generated
		 */
		EClass REAL_VARIABLE_VALUE = eINSTANCE.getRealVariableValue();

		/**
		 * The meta object literal for the '<em><b></b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REAL_VARIABLE_VALUE__ = eINSTANCE.getRealVariableValue__();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.RealVariableImpl <em>Real Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.RealVariableImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getRealVariable()
		 * @generated
		 */
		EClass REAL_VARIABLE = eINSTANCE.getRealVariable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REAL_VARIABLE__VALUE = eINSTANCE.getRealVariable_Value();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.VariableImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.ShallowHistoryStateImpl <em>Shallow History State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.ShallowHistoryStateImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getShallowHistoryState()
		 * @generated
		 */
		EClass SHALLOW_HISTORY_STATE = eINSTANCE.getShallowHistoryState();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.HistoryStateImpl <em>History State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.HistoryStateImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getHistoryState()
		 * @generated
		 */
		EClass HISTORY_STATE = eINSTANCE.getHistoryState();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.JunctionImpl <em>Junction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.JunctionImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getJunction()
		 * @generated
		 */
		EClass JUNCTION = eINSTANCE.getJunction();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.DeepHistoryStateImpl <em>Deep History State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.DeepHistoryStateImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getDeepHistoryState()
		 * @generated
		 */
		EClass DEEP_HISTORY_STATE = eINSTANCE.getDeepHistoryState();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.BooleanVariableImpl <em>Boolean Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.BooleanVariableImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getBooleanVariable()
		 * @generated
		 */
		EClass BOOLEAN_VARIABLE = eINSTANCE.getBooleanVariable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_VARIABLE__VALUE = eINSTANCE.getBooleanVariable_Value();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.BooleanVariableValueImpl <em>Boolean Variable Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.BooleanVariableValueImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getBooleanVariableValue()
		 * @generated
		 */
		EClass BOOLEAN_VARIABLE_VALUE = eINSTANCE.getBooleanVariableValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_VARIABLE_VALUE__VALUE = eINSTANCE.getBooleanVariableValue_Value();

		/**
		 * The meta object literal for the '<em><b></b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_VARIABLE_VALUE__ = eINSTANCE.getBooleanVariableValue__();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.JoinImpl <em>Join</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.JoinImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getJoin()
		 * @generated
		 */
		EClass JOIN = eINSTANCE.getJoin();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.IntegerVariableImpl <em>Integer Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.IntegerVariableImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getIntegerVariable()
		 * @generated
		 */
		EClass INTEGER_VARIABLE = eINSTANCE.getIntegerVariable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTEGER_VARIABLE__VALUE = eINSTANCE.getIntegerVariable_Value();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.IntegerVariableValueImpl <em>Integer Variable Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.IntegerVariableValueImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getIntegerVariableValue()
		 * @generated
		 */
		EClass INTEGER_VARIABLE_VALUE = eINSTANCE.getIntegerVariableValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_VARIABLE_VALUE__VALUE = eINSTANCE.getIntegerVariableValue_Value();

		/**
		 * The meta object literal for the '<em><b></b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTEGER_VARIABLE_VALUE__ = eINSTANCE.getIntegerVariableValue__();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.EventImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.ChoiceImpl <em>Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.ChoiceImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getChoice()
		 * @generated
		 */
		EClass CHOICE = eINSTANCE.getChoice();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.StatechartImpl <em>Statechart</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.StatechartImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getStatechart()
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
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATECHART__VARIABLES = eINSTANCE.getStatechart_Variables();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATECHART__EVENTS = eINSTANCE.getStatechart_Events();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.ForkImpl <em>Fork</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.ForkImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getFork()
		 * @generated
		 */
		EClass FORK = eINSTANCE.getFork();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.InitialStateImpl <em>Initial State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.InitialStateImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getInitialState()
		 * @generated
		 */
		EClass INITIAL_STATE = eINSTANCE.getInitialState();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.TriggerImpl <em>Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.TriggerImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getTrigger()
		 * @generated
		 */
		EClass TRIGGER = eINSTANCE.getTrigger();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.EffectImpl <em>Effect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.EffectImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getEffect()
		 * @generated
		 */
		EClass EFFECT = eINSTANCE.getEffect();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.TimeEventImpl <em>Time Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.TimeEventImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getTimeEvent()
		 * @generated
		 */
		EClass TIME_EVENT = eINSTANCE.getTimeEvent();

		/**
		 * The meta object literal for the '{@link org.yakindu.model.sct.statechart.impl.ExpressionElementImpl <em>Expression Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.model.sct.statechart.impl.ExpressionElementImpl
		 * @see org.yakindu.model.sct.statechart.impl.StatechartPackageImpl#getExpressionElement()
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
