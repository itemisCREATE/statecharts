/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sgen;

import org.yakindu.base.base.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgen.FeatureParameter#getFeatureType <em>Feature Type</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgen.FeatureParameter#isOptional <em>Optional</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgen.FeatureParameter#getParameterType <em>Parameter Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sgen.SGenPackage#getFeatureParameter()
 * @model
 * @generated
 */
public interface FeatureParameter extends NamedElement, DeprecatableElement {
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

	/**
	 * Returns the value of the '<em><b>Optional</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional</em>' attribute.
	 * @see #setOptional(boolean)
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getFeatureParameter_Optional()
	 * @model default="false"
	 * @generated
	 */
	boolean isOptional();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sgen.FeatureParameter#isOptional <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional</em>' attribute.
	 * @see #isOptional()
	 * @generated
	 */
	void setOptional(boolean value);

	/**
	 * Returns the value of the '<em><b>Parameter Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.yakindu.sct.model.sgen.ParameterTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Type</em>' attribute.
	 * @see org.yakindu.sct.model.sgen.ParameterTypes
	 * @see #setParameterType(ParameterTypes)
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getFeatureParameter_ParameterType()
	 * @model
	 * @generated
	 */
	ParameterTypes getParameterType();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sgen.FeatureParameter#getParameterType <em>Parameter Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Type</em>' attribute.
	 * @see org.yakindu.sct.model.sgen.ParameterTypes
	 * @see #getParameterType()
	 * @generated
	 */
	void setParameterType(ParameterTypes value);

} // FeatureParameter
