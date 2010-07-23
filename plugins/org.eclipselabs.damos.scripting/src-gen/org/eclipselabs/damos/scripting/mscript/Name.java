/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.Name#isGlobal <em>Global</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.Name#getIdentifiers <em>Identifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getName_()
 * @model
 * @generated
 */
public interface Name extends EObject
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
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getName_Global()
   * @model
   * @generated
   */
  boolean isGlobal();

  /**
   * Sets the value of the '{@link org.eclipselabs.damos.scripting.mscript.Name#isGlobal <em>Global</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Global</em>' attribute.
   * @see #isGlobal()
   * @generated
   */
  void setGlobal(boolean value);

  /**
   * Returns the value of the '<em><b>Identifiers</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Identifiers</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Identifiers</em>' attribute list.
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getName_Identifiers()
   * @model unique="false"
   * @generated
   */
  EList<String> getIdentifiers();

} // Name
