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
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.base.types.Type#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link org.yakindu.base.types.Type#getScheme <em>Scheme</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.base.types.TypesPackage#getType()
 * @model abstract="true"
 * @generated
 */
public interface Type extends PackageMember {

	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.types.TypeConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' containment reference list.
	 * @see org.yakindu.base.types.TypesPackage#getType_Constraint()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypeConstraint> getConstraint();

	/**
	 * Returns the value of the '<em><b>Scheme</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheme</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheme</em>' attribute.
	 * @see #setScheme(String)
	 * @see org.yakindu.base.types.TypesPackage#getType_Scheme()
	 * @model
	 * @generated
	 */
	String getScheme();

	/**
	 * Sets the value of the '{@link org.yakindu.base.types.Type#getScheme <em>Scheme</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scheme</em>' attribute.
	 * @see #getScheme()
	 * @generated
	 */
	void setScheme(String value);

} // Type
