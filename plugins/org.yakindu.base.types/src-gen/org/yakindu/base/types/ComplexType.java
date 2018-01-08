/**
 */
package org.yakindu.base.types;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.types.ComplexType#getFeatures <em>Features</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.types.TypesPackage#getComplexType()
 * @model
 * @generated
 */
public interface ComplexType extends Type, GenericElement {
	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.types.Declaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see org.yakindu.base.types.TypesPackage#getComplexType_Features()
	 * @model containment="true"
	 * @generated
	 */
	EList<Declaration> getFeatures();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Declaration> getAllFeatures();

} // ComplexType
