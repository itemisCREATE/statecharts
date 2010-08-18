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
 * A representation of the model object '<em><b>Mscript</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.Mscript#getPackages <em>Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getMscript()
 * @model
 * @generated
 */
public interface Mscript extends EObject
{
  /**
   * Returns the value of the '<em><b>Packages</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.damos.scripting.mscript.PackageDefinition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Packages</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Packages</em>' containment reference list.
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getMscript_Packages()
   * @model containment="true"
   * @generated
   */
  EList<PackageDefinition> getPackages();

} // Mscript
