/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Construction Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.ArrayConstructionOperator#getArgumentList <em>Argument List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getArrayConstructionOperator()
 * @model
 * @generated
 */
public interface ArrayConstructionOperator extends Expression
{
  /**
   * Returns the value of the '<em><b>Argument List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Argument List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Argument List</em>' containment reference.
   * @see #setArgumentList(FunctionArgumentList)
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getArrayConstructionOperator_ArgumentList()
   * @model containment="true"
   * @generated
   */
  FunctionArgumentList getArgumentList();

  /**
   * Sets the value of the '{@link org.eclipselabs.damos.scripting.mscript.ArrayConstructionOperator#getArgumentList <em>Argument List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Argument List</em>' containment reference.
   * @see #getArgumentList()
   * @generated
   */
  void setArgumentList(FunctionArgumentList value);

} // ArrayConstructionOperator
