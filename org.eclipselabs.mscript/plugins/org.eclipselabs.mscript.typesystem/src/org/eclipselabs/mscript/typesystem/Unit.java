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
 * A representation of the model object '<em><b>Unit Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.typesystem.Unit#getNumerator <em>Numerator</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.Unit#getDenominator <em>Denominator</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.Unit#getScale <em>Scale</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.Unit#isWildcard <em>Wildcard</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getUnit()
 * @model
 * @generated
 */
public interface Unit extends EObject {
	/**
	 * Returns the value of the '<em><b>Numerator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Numerator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numerator</em>' containment reference.
	 * @see #setNumerator(UnitNumerator)
	 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getUnit_Numerator()
	 * @model containment="true"
	 * @generated
	 */
	UnitNumerator getNumerator();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.typesystem.Unit#getNumerator <em>Numerator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Numerator</em>' containment reference.
	 * @see #getNumerator()
	 * @generated
	 */
	void setNumerator(UnitNumerator value);

	/**
	 * Returns the value of the '<em><b>Denominator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Denominator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Denominator</em>' containment reference.
	 * @see #setDenominator(UnitDenominator)
	 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getUnit_Denominator()
	 * @model containment="true"
	 * @generated
	 */
	UnitDenominator getDenominator();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.typesystem.Unit#getDenominator <em>Denominator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Denominator</em>' containment reference.
	 * @see #getDenominator()
	 * @generated
	 */
	void setDenominator(UnitDenominator value);

	/**
	 * Returns the value of the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale</em>' attribute.
	 * @see #setScale(int)
	 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getUnit_Scale()
	 * @model required="true"
	 * @generated
	 */
	int getScale();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.typesystem.Unit#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see #getScale()
	 * @generated
	 */
	void setScale(int value);

	/**
	 * Returns the value of the '<em><b>Wildcard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wildcard</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wildcard</em>' attribute.
	 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getUnit_Wildcard()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isWildcard();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Unit getNormalized();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model operatorRequired="true"
	 * @generated
	 */
	Unit evaluate(OperatorKind operator, Unit other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model operatorRequired="true" nRequired="true"
	 * @generated
	 */
	Unit evaluate(OperatorKind operator, int n);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" otherRequired="true" ignoreScaleRequired="true"
	 * @generated
	 */
	boolean isEquivalentTo(Unit other, boolean ignoreScale);

} // UnitExpression
