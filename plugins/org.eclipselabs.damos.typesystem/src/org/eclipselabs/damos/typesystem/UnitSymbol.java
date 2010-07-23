/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.typesystem;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Unit Symbol</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getUnitSymbol()
 * @model
 * @generated
 */
public enum UnitSymbol implements Enumerator {
	/**
	 * The '<em><b>Meter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #METER_VALUE
	 * @generated
	 * @ordered
	 */
	METER(0, "Meter", "m"),

	/**
	 * The '<em><b>Kilogram</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KILOGRAM_VALUE
	 * @generated
	 * @ordered
	 */
	KILOGRAM(1, "Kilogram", "kg"),

	/**
	 * The '<em><b>Second</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECOND_VALUE
	 * @generated
	 * @ordered
	 */
	SECOND(2, "Second", "s"),

	/**
	 * The '<em><b>Ampere</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AMPERE_VALUE
	 * @generated
	 * @ordered
	 */
	AMPERE(3, "Ampere", "A"),

	/**
	 * The '<em><b>Kelvin</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KELVIN_VALUE
	 * @generated
	 * @ordered
	 */
	KELVIN(4, "Kelvin", "K"),

	/**
	 * The '<em><b>Mole</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOLE_VALUE
	 * @generated
	 * @ordered
	 */
	MOLE(5, "Mole", "mol"), /**
	 * The '<em><b>Candela</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CANDELA_VALUE
	 * @generated
	 * @ordered
	 */
	CANDELA(6, "Candela", "cd");

	/**
	 * The '<em><b>Meter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Meter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #METER
	 * @model name="Meter" literal="m"
	 * @generated
	 * @ordered
	 */
	public static final int METER_VALUE = 0;

	/**
	 * The '<em><b>Kilogram</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Kilogram</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KILOGRAM
	 * @model name="Kilogram" literal="kg"
	 * @generated
	 * @ordered
	 */
	public static final int KILOGRAM_VALUE = 1;

	/**
	 * The '<em><b>Second</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Second</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SECOND
	 * @model name="Second" literal="s"
	 * @generated
	 * @ordered
	 */
	public static final int SECOND_VALUE = 2;

	/**
	 * The '<em><b>Ampere</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ampere</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AMPERE
	 * @model name="Ampere" literal="A"
	 * @generated
	 * @ordered
	 */
	public static final int AMPERE_VALUE = 3;

	/**
	 * The '<em><b>Kelvin</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Kelvin</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KELVIN
	 * @model name="Kelvin" literal="K"
	 * @generated
	 * @ordered
	 */
	public static final int KELVIN_VALUE = 4;

	/**
	 * The '<em><b>Mole</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mole</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOLE
	 * @model name="Mole" literal="mol"
	 * @generated
	 * @ordered
	 */
	public static final int MOLE_VALUE = 5;

	/**
	 * The '<em><b>Candela</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Candela</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CANDELA
	 * @model name="Candela" literal="cd"
	 * @generated
	 * @ordered
	 */
	public static final int CANDELA_VALUE = 6;

	/**
	 * An array of all the '<em><b>Unit Symbol</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final UnitSymbol[] VALUES_ARRAY =
		new UnitSymbol[] {
			METER,
			KILOGRAM,
			SECOND,
			AMPERE,
			KELVIN,
			MOLE,
			CANDELA,
		};

	/**
	 * A public read-only list of all the '<em><b>Unit Symbol</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<UnitSymbol> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Unit Symbol</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UnitSymbol get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UnitSymbol result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Unit Symbol</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UnitSymbol getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UnitSymbol result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Unit Symbol</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UnitSymbol get(int value) {
		switch (value) {
			case METER_VALUE: return METER;
			case KILOGRAM_VALUE: return KILOGRAM;
			case SECOND_VALUE: return SECOND;
			case AMPERE_VALUE: return AMPERE;
			case KELVIN_VALUE: return KELVIN;
			case MOLE_VALUE: return MOLE;
			case CANDELA_VALUE: return CANDELA;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private UnitSymbol(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //UnitSymbol
