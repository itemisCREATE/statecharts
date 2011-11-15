/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sgen;

import org.eclipse.emf.common.util.EList;

import org.yakindu.sct.model.sgraph.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgen.FeatureType#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgen.FeatureType#getLibrary <em>Library</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sgen.SGenPackage#getFeatureType()
 * @model
 * @generated
 */
public interface FeatureType extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.sgen.FeatureParameter}.
	 * It is bidirectional and its opposite is '{@link org.yakindu.sct.model.sgen.FeatureParameter#getFeatureType <em>Feature Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getFeatureType_Parameters()
	 * @see org.yakindu.sct.model.sgen.FeatureParameter#getFeatureType
	 * @model opposite="featureType" containment="true"
	 * @generated
	 */
	EList<FeatureParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Library</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Library</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Library</em>' reference.
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getFeatureType_Library()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	FeatureTypeLibrary getLibrary();

} // FeatureType
