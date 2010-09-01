/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.typesystem;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.typesystem.Unit#getFactors <em>Factors</em>}</li>
 *   <li>{@link org.eclipselabs.damos.typesystem.Unit#getScale <em>Scale</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getUnit()
 * @model
 * @generated
 */
public interface Unit extends EObject {
	/**
	 * Returns the value of the '<em><b>Factors</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.typesystem.UnitFactor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factors</em>' containment reference list.
	 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getUnit_Factors()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<UnitFactor> getFactors();

	/**
	 * Returns the value of the '<em><b>Scale</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale</em>' attribute.
	 * @see #setScale(int)
	 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getUnit_Scale()
	 * @model default="0" required="true" ordered="false"
	 * @generated
	 */
	int getScale();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.typesystem.Unit#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see #getScale()
	 * @generated
	 */
	void setScale(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" symbolRequired="true" symbolOrdered="false"
	 * @generated
	 */
	UnitFactor getFactor(UnitSymbol symbol);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" otherRequired="true" otherOrdered="false"
	 * @generated
	 */
	Unit multiply(Unit other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" otherRequired="true" otherOrdered="false"
	 * @generated
	 */
	Unit divide(Unit other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" exponentRequired="true" exponentOrdered="false"
	 * @generated
	 */
	Unit power(int exponent);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" otherRequired="true" otherOrdered="false" ignoreScaleRequired="true" ignoreScaleOrdered="false"
	 * @generated
	 */
	boolean isSameAs(Unit other, boolean ignoreScale);

} // Unit
