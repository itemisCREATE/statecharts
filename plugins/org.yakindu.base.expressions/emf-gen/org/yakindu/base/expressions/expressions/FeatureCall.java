/**
 */
package org.yakindu.base.expressions.expressions;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.types.Declaration;
import org.yakindu.base.types.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.FeatureCall#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.FeatureCall#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.FeatureCall#isOperationCall <em>Operation Call</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.FeatureCall#getArraySelector <em>Array Selector</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.FeatureCall#isArrayAccess <em>Array Access</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getFeatureCall()
 * @model
 * @generated
 */
public interface FeatureCall extends ArgumentExpression {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' containment reference.
	 * @see #setOwner(Expression)
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getFeatureCall_Owner()
	 * @model containment="true"
	 * @generated
	 */
	Expression getOwner();

	/**
	 * Sets the value of the '{@link org.yakindu.base.expressions.expressions.FeatureCall#getOwner <em>Owner</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' containment reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Expression value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(EObject)
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getFeatureCall_Feature()
	 * @model
	 * @generated
	 */
	EObject getFeature();

	/**
	 * Sets the value of the '{@link org.yakindu.base.expressions.expressions.FeatureCall#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(EObject value);

	/**
	 * Returns the value of the '<em><b>Operation Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Call</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Call</em>' attribute.
	 * @see #setOperationCall(boolean)
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getFeatureCall_OperationCall()
	 * @model
	 * @generated
	 */
	boolean isOperationCall();

	/**
	 * Sets the value of the '{@link org.yakindu.base.expressions.expressions.FeatureCall#isOperationCall <em>Operation Call</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Call</em>' attribute.
	 * @see #isOperationCall()
	 * @generated
	 */
	void setOperationCall(boolean value);

	/**
	 * Returns the value of the '<em><b>Array Selector</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.types.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Selector</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Selector</em>' containment reference list.
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getFeatureCall_ArraySelector()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getArraySelector();

	/**
	 * Returns the value of the '<em><b>Array Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Access</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Access</em>' attribute.
	 * @see #setArrayAccess(boolean)
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getFeatureCall_ArrayAccess()
	 * @model
	 * @generated
	 */
	boolean isArrayAccess();

	/**
	 * Sets the value of the '{@link org.yakindu.base.expressions.expressions.FeatureCall#isArrayAccess <em>Array Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Array Access</em>' attribute.
	 * @see #isArrayAccess()
	 * @generated
	 */
	void setArrayAccess(boolean value);

} // FeatureCall
