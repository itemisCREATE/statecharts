/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sgen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generator Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgen.GeneratorModel#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgen.GeneratorModel#getStatechartReferences <em>Statechart References</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sgen.SGenPackage#getGeneratorModel()
 * @model
 * @generated
 */
public interface GeneratorModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' containment reference.
	 * @see #setConfiguration(GeneratorConfiguration)
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getGeneratorModel_Configuration()
	 * @model containment="true"
	 * @generated
	 */
	GeneratorConfiguration getConfiguration();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sgen.GeneratorModel#getConfiguration <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' containment reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(GeneratorConfiguration value);

	/**
	 * Returns the value of the '<em><b>Statechart References</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statechart References</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statechart References</em>' containment reference.
	 * @see #setStatechartReferences(StatechartReferences)
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getGeneratorModel_StatechartReferences()
	 * @model containment="true"
	 * @generated
	 */
	StatechartReferences getStatechartReferences();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sgen.GeneratorModel#getStatechartReferences <em>Statechart References</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statechart References</em>' containment reference.
	 * @see #getStatechartReferences()
	 * @generated
	 */
	void setStatechartReferences(StatechartReferences value);

} // GeneratorModel
