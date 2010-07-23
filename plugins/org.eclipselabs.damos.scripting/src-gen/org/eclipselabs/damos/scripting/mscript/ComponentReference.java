/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.ComponentReference#isGlobal <em>Global</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.ComponentReference#getSegments <em>Segments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getComponentReference()
 * @model
 * @generated
 */
public interface ComponentReference extends Expression
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
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getComponentReference_Global()
   * @model
   * @generated
   */
  boolean isGlobal();

  /**
   * Sets the value of the '{@link org.eclipselabs.damos.scripting.mscript.ComponentReference#isGlobal <em>Global</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Global</em>' attribute.
   * @see #isGlobal()
   * @generated
   */
  void setGlobal(boolean value);

  /**
   * Returns the value of the '<em><b>Segments</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.damos.scripting.mscript.ComponentReferenceSegment}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Segments</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Segments</em>' containment reference list.
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getComponentReference_Segments()
   * @model containment="true"
   * @generated
   */
  EList<ComponentReferenceSegment> getSegments();

} // ComponentReference
