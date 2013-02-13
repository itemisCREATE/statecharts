/**
 */
package org.yakindu.base.types;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.base.types.DataType#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.yakindu.base.types.DataType#getSuperTypes <em>Super Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.base.types.TypesPackage#getDataType()
 * @model
 * @generated
 */
public interface DataType extends Type {
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
	 * @see org.yakindu.base.types.TypesPackage#getDataType_Features()
	 * @see org.yakindu.base.types.Feature#getOwningType
	 * @model opposite="owningType" containment="true"
	 * @generated
	 */
	EList<Feature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Super Types</b></em>' reference list.
	 * The list contents are of type {@link org.yakindu.base.types.DataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Types</em>' reference list.
	 * @see org.yakindu.base.types.TypesPackage#getDataType_SuperTypes()
	 * @model
	 * @generated
	 */
	EList<DataType> getSuperTypes();

} // DataType
