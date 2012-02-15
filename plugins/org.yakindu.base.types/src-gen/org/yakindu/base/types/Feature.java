/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.base.types;

import org.yakindu.base.base.NamedElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.base.types.Feature#getOwningType <em>Owning Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.base.types.TypesPackage#getFeature()
 * @model abstract="true"
 * @generated
 */
public interface Feature extends TypedElement, NamedElement {
	/**
	 * Returns the value of the '<em><b>Owning Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.base.types.Type#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Type</em>' container reference.
	 * @see #setOwningType(Type)
	 * @see org.yakindu.base.types.TypesPackage#getFeature_OwningType()
	 * @see org.yakindu.base.types.Type#getFeatures
	 * @model opposite="features" transient="false"
	 * @generated
	 */
	Type getOwningType();

	/**
	 * Sets the value of the '{@link org.yakindu.base.types.Feature#getOwningType <em>Owning Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Type</em>' container reference.
	 * @see #getOwningType()
	 * @generated
	 */
	void setOwningType(Type value);

} // Feature
