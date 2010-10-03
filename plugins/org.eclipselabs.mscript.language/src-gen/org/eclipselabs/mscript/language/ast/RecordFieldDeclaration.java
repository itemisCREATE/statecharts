/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record Field Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.RecordFieldDeclaration#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.RecordFieldDeclaration#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getRecordFieldDeclaration()
 * @model
 * @generated
 */
public interface RecordFieldDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(DataTypeSpecifier)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getRecordFieldDeclaration_Type()
   * @model containment="true"
   * @generated
   */
  DataTypeSpecifier getType();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.RecordFieldDeclaration#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(DataTypeSpecifier value);

  /**
   * Returns the value of the '<em><b>Items</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.RecordFieldDeclarationItem}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Items</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getRecordFieldDeclaration_Items()
   * @model containment="true"
   * @generated
   */
  EList<RecordFieldDeclarationItem> getItems();

} // RecordFieldDeclaration
