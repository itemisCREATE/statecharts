/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.PackageDefinition#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.PackageDefinition#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getPackageDefinition()
 * @model
 * @generated
 */
public interface PackageDefinition extends PackageDefinitionElement
{
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
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getPackageDefinition_Name()
   * @model containment="true"
   * @generated
   */
  Name getName();

  /**
   * Sets the value of the '{@link org.eclipselabs.damos.scripting.mscript.PackageDefinition#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(Name value);

  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.damos.scripting.mscript.PackageDefinitionElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getPackageDefinition_Elements()
   * @model containment="true"
   * @generated
   */
  EList<PackageDefinitionElement> getElements();

} // PackageDefinition
