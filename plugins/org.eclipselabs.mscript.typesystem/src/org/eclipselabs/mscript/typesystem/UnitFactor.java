/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Factor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.typesystem.UnitFactor#getSymbol <em>Symbol</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.UnitFactor#getExponent <em>Exponent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getUnitFactor()
 * @model
 * @generated
 */
public interface UnitFactor extends EObject {
	/**
	 * Returns the value of the '<em><b>Symbol</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipselabs.mscript.typesystem.UnitSymbol}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbol</em>' attribute.
	 * @see org.eclipselabs.mscript.typesystem.UnitSymbol
	 * @see #setSymbol(UnitSymbol)
	 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getUnitFactor_Symbol()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	UnitSymbol getSymbol();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.typesystem.UnitFactor#getSymbol <em>Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symbol</em>' attribute.
	 * @see org.eclipselabs.mscript.typesystem.UnitSymbol
	 * @see #getSymbol()
	 * @generated
	 */
	void setSymbol(UnitSymbol value);

	/**
	 * Returns the value of the '<em><b>Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exponent</em>' attribute.
	 * @see #setExponent(int)
	 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getUnitFactor_Exponent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getExponent();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.typesystem.UnitFactor#getExponent <em>Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exponent</em>' attribute.
	 * @see #getExponent()
	 * @generated
	 */
	void setExponent(int value);

} // UnitFactor
