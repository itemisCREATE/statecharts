/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.computation.computationmodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Floating Point Format Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage#getFloatingPointFormatKind()
 * @model
 * @generated
 */
public enum FloatingPointFormatKind implements Enumerator {
	/**
	 * The '<em><b>Binary16</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BINARY16_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY16(0, "Binary16", "Binary16"),

	/**
	 * The '<em><b>Binary32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BINARY32_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY32(1, "Binary32", "Binary32"),

	/**
	 * The '<em><b>Binary64</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BINARY64_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY64(2, "Binary64", "Binary64"),

	/**
	 * The '<em><b>Binary128</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BINARY128_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY128(3, "Binary128", "Binary128"),

	/**
	 * The '<em><b>Decimal32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECIMAL32_VALUE
	 * @generated
	 * @ordered
	 */
	DECIMAL32(4, "Decimal32", "Decimal32"),

	/**
	 * The '<em><b>Decimal64</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECIMAL64_VALUE
	 * @generated
	 * @ordered
	 */
	DECIMAL64(5, "Decimal64", "Decimal64"),

	/**
	 * The '<em><b>Decimal128</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECIMAL128_VALUE
	 * @generated
	 * @ordered
	 */
	DECIMAL128(6, "Decimal128", "Decimal128");

	/**
	 * The '<em><b>Binary16</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Binary16</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BINARY16
	 * @model name="Binary16"
	 * @generated
	 * @ordered
	 */
	public static final int BINARY16_VALUE = 0;

	/**
	 * The '<em><b>Binary32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Binary32</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BINARY32
	 * @model name="Binary32"
	 * @generated
	 * @ordered
	 */
	public static final int BINARY32_VALUE = 1;

	/**
	 * The '<em><b>Binary64</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Binary64</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BINARY64
	 * @model name="Binary64"
	 * @generated
	 * @ordered
	 */
	public static final int BINARY64_VALUE = 2;

	/**
	 * The '<em><b>Binary128</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Binary128</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BINARY128
	 * @model name="Binary128"
	 * @generated
	 * @ordered
	 */
	public static final int BINARY128_VALUE = 3;

	/**
	 * The '<em><b>Decimal32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Decimal32</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DECIMAL32
	 * @model name="Decimal32"
	 * @generated
	 * @ordered
	 */
	public static final int DECIMAL32_VALUE = 4;

	/**
	 * The '<em><b>Decimal64</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Decimal64</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DECIMAL64
	 * @model name="Decimal64"
	 * @generated
	 * @ordered
	 */
	public static final int DECIMAL64_VALUE = 5;

	/**
	 * The '<em><b>Decimal128</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Decimal128</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DECIMAL128
	 * @model name="Decimal128"
	 * @generated
	 * @ordered
	 */
	public static final int DECIMAL128_VALUE = 6;

	/**
	 * An array of all the '<em><b>Floating Point Format Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FloatingPointFormatKind[] VALUES_ARRAY =
		new FloatingPointFormatKind[] {
			BINARY16,
			BINARY32,
			BINARY64,
			BINARY128,
			DECIMAL32,
			DECIMAL64,
			DECIMAL128,
		};

	/**
	 * A public read-only list of all the '<em><b>Floating Point Format Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FloatingPointFormatKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Floating Point Format Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FloatingPointFormatKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FloatingPointFormatKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Floating Point Format Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FloatingPointFormatKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FloatingPointFormatKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Floating Point Format Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FloatingPointFormatKind get(int value) {
		switch (value) {
			case BINARY16_VALUE: return BINARY16;
			case BINARY32_VALUE: return BINARY32;
			case BINARY64_VALUE: return BINARY64;
			case BINARY128_VALUE: return BINARY128;
			case DECIMAL32_VALUE: return DECIMAL32;
			case DECIMAL64_VALUE: return DECIMAL64;
			case DECIMAL128_VALUE: return DECIMAL128;
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
	private FloatingPointFormatKind(int value, String name, String literal) {
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
	
} //FloatingPointFormatKind
