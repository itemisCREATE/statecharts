/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.base.types;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.base.types.Library#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.base.types.TypesPackage#getLibrary()
 * @model
 * @generated
 */
public interface Library extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.types.Type}.
	 * It is bidirectional and its opposite is '{@link org.yakindu.base.types.Type#getOwningLibrary <em>Owning Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see org.yakindu.base.types.TypesPackage#getLibrary_Types()
	 * @see org.yakindu.base.types.Type#getOwningLibrary
	 * @model opposite="owningLibrary" containment="true"
	 * @generated
	 */
	EList<Type> getTypes();

} // Library
