/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.base.types;

import org.eclipse.emf.common.util.EList;
import org.yakindu.base.base.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.base.types.Type#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.yakindu.base.types.Type#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link org.yakindu.base.types.Type#getOwningLibrary <em>Owning Library</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.base.types.TypesPackage#getType()
 * @model
 * @generated
 */
public interface Type extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.types.Feature}.
	 * It is bidirectional and its opposite is '{@link org.yakindu.base.types.Feature#getOwningType <em>Owning Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see org.yakindu.base.types.TypesPackage#getType_Features()
	 * @see org.yakindu.base.types.Feature#getOwningType
	 * @model opposite="owningType" containment="true"
	 * @generated
	 */
	EList<Feature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Super Types</b></em>' reference list.
	 * The list contents are of type {@link org.yakindu.base.types.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Types</em>' reference list.
	 * @see org.yakindu.base.types.TypesPackage#getType_SuperTypes()
	 * @model
	 * @generated
	 */
	EList<Type> getSuperTypes();

	/**
	 * Returns the value of the '<em><b>Owning Library</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.base.types.Library#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Library</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Library</em>' container reference.
	 * @see #setOwningLibrary(Library)
	 * @see org.yakindu.base.types.TypesPackage#getType_OwningLibrary()
	 * @see org.yakindu.base.types.Library#getTypes
	 * @model opposite="types" transient="false"
	 * @generated
	 */
	Library getOwningLibrary();

	/**
	 * Sets the value of the '{@link org.yakindu.base.types.Type#getOwningLibrary <em>Owning Library</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Library</em>' container reference.
	 * @see #getOwningLibrary()
	 * @generated
	 */
	void setOwningLibrary(Library value);

} // Type
