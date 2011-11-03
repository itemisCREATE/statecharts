/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sgen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.yakindu.sct.model.sgraph.Statechart;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generator Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgen.GeneratorModel#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgen.GeneratorModel#getStatecharts <em>Statecharts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sgen.SGenPackage#getGeneratorModel()
 * @model
 * @generated
 */
public interface GeneratorModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.sgen.Configuration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configurations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurations</em>' containment reference list.
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getGeneratorModel_Configurations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Configuration> getConfigurations();

	/**
	 * Returns the value of the '<em><b>Statecharts</b></em>' reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.sgraph.Statechart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statecharts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statecharts</em>' reference list.
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getGeneratorModel_Statecharts()
	 * @model
	 * @generated
	 */
	EList<Statechart> getStatecharts();

} // GeneratorModel
