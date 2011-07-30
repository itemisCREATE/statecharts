/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Function Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionKind()
 * @model
 * @generated
 */
public enum FunctionKind implements Enumerator {
	/**
	 * The '<em><b>Stateless</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATELESS_VALUE
	 * @generated
	 * @ordered
	 */
	STATELESS(0, "Stateless", "Stateless"),

	/**
	 * The '<em><b>Stateful</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATEFUL_VALUE
	 * @generated
	 * @ordered
	 */
	STATEFUL(1, "Stateful", "Stateful"),

	/**
	 * The '<em><b>Continuous</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTINUOUS_VALUE
	 * @generated
	 * @ordered
	 */
	CONTINUOUS(2, "Continuous", "Continuous");

	/**
	 * The '<em><b>Stateless</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Stateless</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATELESS
	 * @model name="Stateless"
	 * @generated
	 * @ordered
	 */
	public static final int STATELESS_VALUE = 0;

	/**
	 * The '<em><b>Stateful</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Stateful</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATEFUL
	 * @model name="Stateful"
	 * @generated
	 * @ordered
	 */
	public static final int STATEFUL_VALUE = 1;

	/**
	 * The '<em><b>Continuous</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Continuous</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTINUOUS
	 * @model name="Continuous"
	 * @generated
	 * @ordered
	 */
	public static final int CONTINUOUS_VALUE = 2;

	/**
	 * An array of all the '<em><b>Function Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FunctionKind[] VALUES_ARRAY =
		new FunctionKind[] {
			STATELESS,
			STATEFUL,
			CONTINUOUS,
		};

	/**
	 * A public read-only list of all the '<em><b>Function Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FunctionKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Function Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FunctionKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FunctionKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Function Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FunctionKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FunctionKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Function Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FunctionKind get(int value) {
		switch (value) {
			case STATELESS_VALUE: return STATELESS;
			case STATEFUL_VALUE: return STATEFUL;
			case CONTINUOUS_VALUE: return CONTINUOUS;
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
	private FunctionKind(int value, String name, String literal) {
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
	
} //FunctionKind
