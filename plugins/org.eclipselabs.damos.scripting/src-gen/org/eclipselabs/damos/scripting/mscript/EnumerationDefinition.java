/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.EnumerationDefinition#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.EnumerationDefinition#getLiterals <em>Literals</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getEnumerationDefinition()
 * @model
 * @generated
 */
public interface EnumerationDefinition extends PackageDefinitionElement
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
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getEnumerationDefinition_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipselabs.damos.scripting.mscript.EnumerationDefinition#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.damos.scripting.mscript.EnumerationLiteralDefinition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Literals</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literals</em>' containment reference list.
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getEnumerationDefinition_Literals()
   * @model containment="true"
   * @generated
   */
  EList<EnumerationLiteralDefinition> getLiterals();

} // EnumerationDefinition
