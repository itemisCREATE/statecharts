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
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.base.types.Operation#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.base.types.TypesPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends Declaration, PackageMember {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.types.Parameter}.
	 * It is bidirectional and its opposite is '{@link org.yakindu.base.types.Parameter#getOwningOperation <em>Owning Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.yakindu.base.types.TypesPackage#getOperation_Parameters()
	 * @see org.yakindu.base.types.Parameter#getOwningOperation
	 * @model opposite="owningOperation" containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

} // Operation
