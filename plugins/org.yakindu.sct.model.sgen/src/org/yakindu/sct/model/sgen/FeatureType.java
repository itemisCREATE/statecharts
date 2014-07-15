/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sgen;

import org.eclipse.emf.common.util.EList;
import org.yakindu.base.base.NamedElement;

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
 *   <li>{@link org.yakindu.sct.model.sgen.FeatureType#isOptional <em>Optional</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sgen.SGenPackage#getFeatureType()
 * @model
 * @generated
 */
public interface FeatureType extends NamedElement, DeprecatableElement {
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
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getFeatureType_Optional()
	 * @model default="false"
	 * @generated
	 */
	boolean isOptional();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sgen.FeatureType#isOptional <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional</em>' attribute.
	 * @see #isOptional()
	 * @generated
	 */
	void setOptional(boolean value);

} // FeatureType
