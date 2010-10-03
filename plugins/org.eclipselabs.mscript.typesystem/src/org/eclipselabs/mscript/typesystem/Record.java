/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.typesystem.Record#getFields <em>Fields</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getRecord()
 * @model
 * @generated
 */
public interface Record extends DataType {
	/**
	 * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.typesystem.RecordField}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fields</em>' containment reference list.
	 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getRecord_Fields()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<RecordField> getFields();

} // Record
