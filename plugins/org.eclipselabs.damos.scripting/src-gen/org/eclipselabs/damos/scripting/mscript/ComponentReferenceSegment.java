/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Reference Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.ComponentReferenceSegment#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.ComponentReferenceSegment#getSubscriptList <em>Subscript List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getComponentReferenceSegment()
 * @model
 * @generated
 */
public interface ComponentReferenceSegment extends EObject
{
  /**
   * Returns the value of the '<em><b>Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Identifier</em>' attribute.
   * @see #setIdentifier(String)
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getComponentReferenceSegment_Identifier()
   * @model
   * @generated
   */
  String getIdentifier();

  /**
   * Sets the value of the '{@link org.eclipselabs.damos.scripting.mscript.ComponentReferenceSegment#getIdentifier <em>Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Identifier</em>' attribute.
   * @see #getIdentifier()
   * @generated
   */
  void setIdentifier(String value);

  /**
   * Returns the value of the '<em><b>Subscript List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subscript List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subscript List</em>' containment reference.
   * @see #setSubscriptList(ArraySubscriptList)
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getComponentReferenceSegment_SubscriptList()
   * @model containment="true"
   * @generated
   */
  ArraySubscriptList getSubscriptList();

  /**
   * Sets the value of the '{@link org.eclipselabs.damos.scripting.mscript.ComponentReferenceSegment#getSubscriptList <em>Subscript List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Subscript List</em>' containment reference.
   * @see #getSubscriptList()
   * @generated
   */
  void setSubscriptList(ArraySubscriptList value);

} // ComponentReferenceSegment
