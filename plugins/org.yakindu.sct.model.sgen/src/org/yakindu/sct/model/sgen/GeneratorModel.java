/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sgen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generator Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgen.GeneratorModel#getEntries <em>Entries</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgen.GeneratorModel#getGeneratorId <em>Generator Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sgen.SGenPackage#getGeneratorModel()
 * @model
 * @generated
 */
public interface GeneratorModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.sgen.GeneratorEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' containment reference list.
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getGeneratorModel_Entries()
	 * @model containment="true"
	 * @generated
	 */
	EList<GeneratorEntry> getEntries();

	/**
	 * Returns the value of the '<em><b>Generator Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generator Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generator Id</em>' attribute.
	 * @see #setGeneratorId(String)
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getGeneratorModel_GeneratorId()
	 * @model
	 * @generated
	 */
	String getGeneratorId();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sgen.GeneratorModel#getGeneratorId <em>Generator Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generator Id</em>' attribute.
	 * @see #getGeneratorId()
	 * @generated
	 */
	void setGeneratorId(String value);

} // GeneratorModel
