/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.PackageAS#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.PackageAS#getPackagedElements <em>Packaged Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getPackageAS()
 * @model
 * @generated
 */
public interface PackageAS extends PackageableElementAS
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
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getPackageAS_Name()
   * @model containment="true"
   * @generated
   */
  Name getName();

  /**
   * Sets the value of the '{@link org.eclipselabs.damos.scripting.mscript.PackageAS#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(Name value);

  /**
   * Returns the value of the '<em><b>Packaged Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.damos.scripting.mscript.PackageableElementAS}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Packaged Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Packaged Elements</em>' containment reference list.
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getPackageAS_PackagedElements()
   * @model containment="true"
   * @generated
   */
  EList<PackageableElementAS> getPackagedElements();

} // PackageAS
