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
 *   <li>{@link org.yakindu.sct.model.sgen.GeneratorEntry#getElementRef <em>Element Ref</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgen.GeneratorEntry#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgen.GeneratorEntry#getContentType <em>Content Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sgen.SGenPackage#getGeneratorEntry()
 * @model
 * @generated
 */
public interface GeneratorEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Element Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Ref</em>' reference.
	 * @see #setElementRef(EObject)
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getGeneratorEntry_ElementRef()
	 * @model
	 * @generated
	 */
	EObject getElementRef();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sgen.GeneratorEntry#getElementRef <em>Element Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Ref</em>' reference.
	 * @see #getElementRef()
	 * @generated
	 */
	void setElementRef(EObject value);

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
	 * Returns the value of the '<em><b>Content Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content Type</em>' attribute.
	 * @see #setContentType(String)
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getGeneratorEntry_ContentType()
	 * @model
	 * @generated
	 */
	String getContentType();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sgen.GeneratorEntry#getContentType <em>Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Type</em>' attribute.
	 * @see #getContentType()
	 * @generated
	 */
	void setContentType(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	FeatureConfiguration getFeatureConfiguration(String featureName);

} // GeneratorEntry
