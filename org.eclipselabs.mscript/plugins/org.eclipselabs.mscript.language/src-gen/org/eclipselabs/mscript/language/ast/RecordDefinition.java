/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.RecordDefinition#getFieldDeclarations <em>Field Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getRecordDefinition()
 * @model
 * @generated
 */
public interface RecordDefinition extends DataTypeDefinition
{
  /**
   * Returns the value of the '<em><b>Field Declarations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.RecordFieldDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Field Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field Declarations</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getRecordDefinition_FieldDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<RecordFieldDeclaration> getFieldDeclarations();

} // RecordDefinition
