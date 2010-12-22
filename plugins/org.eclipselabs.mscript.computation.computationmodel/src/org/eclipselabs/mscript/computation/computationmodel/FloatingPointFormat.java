/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.computation.computationmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Floating Point Format</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage#getFloatingPointFormat()
 * @model
 * @generated
 */
public interface FloatingPointFormat extends NumberFormat {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormatKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormatKind
	 * @see #setKind(FloatingPointFormatKind)
	 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage#getFloatingPointFormat_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FloatingPointFormatKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormatKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(FloatingPointFormatKind value);

} // FloatingPointFormat
