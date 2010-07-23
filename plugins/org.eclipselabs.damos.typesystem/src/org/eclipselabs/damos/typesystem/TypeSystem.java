/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.typesystem;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.typesystem.TypeSystem#getTopLevelElements <em>Top Level Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getTypeSystem()
 * @model
 * @generated
 */
public interface TypeSystem extends EObject {
	/**
	 * Returns the value of the '<em><b>Top Level Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.typesystem.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Level Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Level Elements</em>' containment reference list.
	 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getTypeSystem_TopLevelElements()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<NamedElement> getTopLevelElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" qualifiedNameRequired="true" qualifiedNameOrdered="false"
	 * @generated
	 */
	NamedElement getElement(String qualifiedName);

} // TypeSystem
