/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FeatureCall#getFeatureReference <em>Feature Reference</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FeatureCall#getComponentReferences <em>Component References</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FeatureCall#isOperationCall <em>Operation Call</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FeatureCall#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getFeatureCall()
 * @model
 * @generated
 */
public interface FeatureCall extends Expression
{
  /**
   * Returns the value of the '<em><b>Feature Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature Reference</em>' containment reference.
   * @see #setFeatureReference(SymbolReference)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFeatureCall_FeatureReference()
   * @model containment="true"
   * @generated
   */
  SymbolReference getFeatureReference();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.FeatureCall#getFeatureReference <em>Feature Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature Reference</em>' containment reference.
   * @see #getFeatureReference()
   * @generated
   */
  void setFeatureReference(SymbolReference value);

  /**
   * Returns the value of the '<em><b>Component References</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.ComponentReference}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Component References</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Component References</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFeatureCall_ComponentReferences()
   * @model containment="true"
   * @generated
   */
  EList<ComponentReference> getComponentReferences();

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
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFeatureCall_OperationCall()
   * @model
   * @generated
   */
  boolean isOperationCall();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.FeatureCall#isOperationCall <em>Operation Call</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation Call</em>' attribute.
   * @see #isOperationCall()
   * @generated
   */
  void setOperationCall(boolean value);

  /**
   * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arguments</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFeatureCall_Arguments()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getArguments();

} // FeatureCall
