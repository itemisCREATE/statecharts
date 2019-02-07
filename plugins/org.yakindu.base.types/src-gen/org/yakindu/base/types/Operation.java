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
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.types.Operation#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.yakindu.base.types.Operation#isVariadic <em>Variadic</em>}</li>
 *   <li>{@link org.yakindu.base.types.Operation#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.types.TypesPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends TypedDeclaration, GenericElement {
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

	/**
	 * Returns the value of the '<em><b>Variadic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variadic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variadic</em>' attribute.
	 * @see org.yakindu.base.types.TypesPackage#getOperation_Variadic()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isVariadic();

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Expression)
	 * @see org.yakindu.base.types.TypesPackage#getOperation_Body()
	 * @model containment="true"
	 * @generated
	 */
	Expression getBody();

	/**
	 * Sets the value of the '{@link org.yakindu.base.types.Operation#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Expression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getVarArgIndex();

} // Operation
