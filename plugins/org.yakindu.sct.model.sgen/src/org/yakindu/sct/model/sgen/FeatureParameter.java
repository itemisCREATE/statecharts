/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sgen;

import org.yakindu.sct.model.sgraph.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgen.FeatureParameter#getFeatureType <em>Feature Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sgen.SGenPackage#getFeatureParameter()
 * @model
 * @generated
 */
public interface FeatureParameter extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Feature Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.sct.model.sgen.FeatureType#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Type</em>' container reference.
	 * @see #setFeatureType(FeatureType)
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getFeatureParameter_FeatureType()
	 * @see org.yakindu.sct.model.sgen.FeatureType#getParameters
	 * @model opposite="parameters" transient="false"
	 * @generated
	 */
	FeatureType getFeatureType();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sgen.FeatureParameter#getFeatureType <em>Feature Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Type</em>' container reference.
	 * @see #getFeatureType()
	 * @generated
	 */
	void setFeatureType(FeatureType value);

} // FeatureParameter
