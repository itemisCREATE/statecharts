/**
 */
package org.yakindu.base.expressions.expressions;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.FeatureCall#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.FeatureCall#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.FeatureCall#isOperationCall <em>Operation Call</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.FeatureCall#getArgs <em>Args</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getFeatureCall()
 * @model
 * @generated
 */
public interface FeatureCall extends Expression
{
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
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link org.yakindu.base.expressions.expressions.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getFeatureCall_Args()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getArgs();

} // FeatureCall
