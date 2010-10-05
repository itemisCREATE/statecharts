/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Dimension Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification#isUnspecified <em>Unspecified</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification#getSize <em>Size</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification#getBeginIndex <em>Begin Index</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification#getEndIndex <em>End Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getArrayDimensionSpecification()
 * @model
 * @generated
 */
public interface ArrayDimensionSpecification extends EObject
{
  /**
   * Returns the value of the '<em><b>Unspecified</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unspecified</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unspecified</em>' attribute.
   * @see #setUnspecified(boolean)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getArrayDimensionSpecification_Unspecified()
   * @model
   * @generated
   */
  boolean isUnspecified();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification#isUnspecified <em>Unspecified</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unspecified</em>' attribute.
   * @see #isUnspecified()
   * @generated
   */
  void setUnspecified(boolean value);

  /**
   * Returns the value of the '<em><b>Size</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Size</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Size</em>' containment reference.
   * @see #setSize(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getArrayDimensionSpecification_Size()
   * @model containment="true"
   * @generated
   */
  Expression getSize();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification#getSize <em>Size</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Size</em>' containment reference.
   * @see #getSize()
   * @generated
   */
  void setSize(Expression value);

  /**
   * Returns the value of the '<em><b>Begin Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Begin Index</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Begin Index</em>' containment reference.
   * @see #setBeginIndex(ArrayDimensionSpecification)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getArrayDimensionSpecification_BeginIndex()
   * @model containment="true"
   * @generated
   */
  ArrayDimensionSpecification getBeginIndex();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification#getBeginIndex <em>Begin Index</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Begin Index</em>' containment reference.
   * @see #getBeginIndex()
   * @generated
   */
  void setBeginIndex(ArrayDimensionSpecification value);

  /**
   * Returns the value of the '<em><b>End Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End Index</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End Index</em>' containment reference.
   * @see #setEndIndex(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getArrayDimensionSpecification_EndIndex()
   * @model containment="true"
   * @generated
   */
  Expression getEndIndex();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification#getEndIndex <em>End Index</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End Index</em>' containment reference.
   * @see #getEndIndex()
   * @generated
   */
  void setEndIndex(Expression value);

} // ArrayDimensionSpecification
