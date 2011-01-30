/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iteration Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.IterationCall#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.IterationCall#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.IterationCall#getAccumulator <em>Accumulator</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.IterationCall#getBreakCondition <em>Break Condition</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.IterationCall#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getIterationCall()
 * @model
 * @generated
 */
public interface IterationCall extends FeatureCallPart
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getIterationCall_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.IterationCall#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.IterationVariable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variables</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getIterationCall_Variables()
   * @model containment="true"
   * @generated
   */
  EList<IterationVariable> getVariables();

  /**
   * Returns the value of the '<em><b>Accumulator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Accumulator</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Accumulator</em>' containment reference.
   * @see #setAccumulator(IterationAccumulator)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getIterationCall_Accumulator()
   * @model containment="true"
   * @generated
   */
  IterationAccumulator getAccumulator();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.IterationCall#getAccumulator <em>Accumulator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Accumulator</em>' containment reference.
   * @see #getAccumulator()
   * @generated
   */
  void setAccumulator(IterationAccumulator value);

  /**
   * Returns the value of the '<em><b>Break Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Break Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Break Condition</em>' containment reference.
   * @see #setBreakCondition(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getIterationCall_BreakCondition()
   * @model containment="true"
   * @generated
   */
  Expression getBreakCondition();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.IterationCall#getBreakCondition <em>Break Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Break Condition</em>' containment reference.
   * @see #getBreakCondition()
   * @generated
   */
  void setBreakCondition(Expression value);

  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getIterationCall_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.IterationCall#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

} // IterationCall
