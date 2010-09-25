/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Symbol Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.SymbolReference#isGlobal <em>Global</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.SymbolReference#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.SymbolReference#getComponentReferences <em>Component References</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.SymbolReference#isFunctionCall <em>Function Call</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.SymbolReference#getArgumentList <em>Argument List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getSymbolReference()
 * @model
 * @generated
 */
public interface SymbolReference extends Expression
{
  /**
   * Returns the value of the '<em><b>Global</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Global</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Global</em>' attribute.
   * @see #setGlobal(boolean)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getSymbolReference_Global()
   * @model
   * @generated
   */
  boolean isGlobal();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.SymbolReference#isGlobal <em>Global</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Global</em>' attribute.
   * @see #isGlobal()
   * @generated
   */
  void setGlobal(boolean value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(Name)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getSymbolReference_Name()
   * @model containment="true"
   * @generated
   */
  Name getName();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.SymbolReference#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(Name value);

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
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getSymbolReference_ComponentReferences()
   * @model containment="true"
   * @generated
   */
  EList<ComponentReference> getComponentReferences();

  /**
   * Returns the value of the '<em><b>Function Call</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function Call</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function Call</em>' attribute.
   * @see #setFunctionCall(boolean)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getSymbolReference_FunctionCall()
   * @model
   * @generated
   */
  boolean isFunctionCall();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.SymbolReference#isFunctionCall <em>Function Call</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function Call</em>' attribute.
   * @see #isFunctionCall()
   * @generated
   */
  void setFunctionCall(boolean value);

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
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getSymbolReference_ArgumentList()
   * @model containment="true"
   * @generated
   */
  FunctionArgumentList getArgumentList();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.SymbolReference#getArgumentList <em>Argument List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Argument List</em>' containment reference.
   * @see #getArgumentList()
   * @generated
   */
  void setArgumentList(FunctionArgumentList value);

} // SymbolReference
