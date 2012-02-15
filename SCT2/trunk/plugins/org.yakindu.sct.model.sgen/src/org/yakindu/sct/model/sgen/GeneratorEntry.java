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
 * A representation of the model object '<em><b>Generator Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgen.GeneratorEntry#getStatechart <em>Statechart</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgen.GeneratorEntry#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sgen.SGenPackage#getGeneratorEntry()
 * @model
 * @generated
 */
public interface GeneratorEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Statechart</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statechart</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statechart</em>' reference.
	 * @see #setStatechart(Statechart)
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getGeneratorEntry_Statechart()
	 * @model
	 * @generated
	 */
	Statechart getStatechart();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sgen.GeneratorEntry#getStatechart <em>Statechart</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statechart</em>' reference.
	 * @see #getStatechart()
	 * @generated
	 */
	void setStatechart(Statechart value);

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.sgen.FeatureConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getGeneratorEntry_Features()
	 * @model containment="true"
	 * @generated
	 */
	EList<FeatureConfiguration> getFeatures();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	FeatureConfiguration getFeatureConfiguration(String featureName);

} // GeneratorEntry
