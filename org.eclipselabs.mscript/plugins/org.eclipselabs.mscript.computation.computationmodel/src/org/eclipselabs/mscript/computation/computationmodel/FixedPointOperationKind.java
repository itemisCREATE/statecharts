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
 * A representation of the literals of the enumeration '<em><b>Fixed Point Operation Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage#getFixedPointOperationKind()
 * @model
 * @generated
 */
public enum FixedPointOperationKind implements Enumerator {
	/**
	 * The '<em><b>Construct</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSTRUCT_VALUE
	 * @generated
	 * @ordered
	 */
	CONSTRUCT(0, "Construct", "Construct"), /**
	 * The '<em><b>Cast</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CAST_VALUE
	 * @generated
	 * @ordered
	 */
	CAST(1, "Cast", "Cast"), /**
	 * The '<em><b>Add</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADD_VALUE
	 * @generated
	 * @ordered
	 */
	ADD(2, "Add", "Add"), /**
	 * The '<em><b>Subtract</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBTRACT_VALUE
	 * @generated
	 * @ordered
	 */
	SUBTRACT(3, "Subtract", "Subtract"), /**
	 * The '<em><b>Multiply</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MULTIPLY_VALUE
	 * @generated
	 * @ordered
	 */
	MULTIPLY(4, "Multiply", "Multiply"), /**
	 * The '<em><b>Divide</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIVIDE_VALUE
	 * @generated
	 * @ordered
	 */
	DIVIDE(5, "Divide", "Divide");

	/**
	 * The '<em><b>Construct</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Construct</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONSTRUCT
	 * @model name="Construct"
	 * @generated
	 * @ordered
	 */
	public static final int CONSTRUCT_VALUE = 0;

	/**
	 * The '<em><b>Cast</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Cast</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CAST
	 * @model name="Cast"
	 * @generated
	 * @ordered
	 */
	public static final int CAST_VALUE = 1;

	/**
	 * The '<em><b>Add</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Add</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADD
	 * @model name="Add"
	 * @generated
	 * @ordered
	 */
	public static final int ADD_VALUE = 2;

	/**
	 * The '<em><b>Subtract</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Subtract</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUBTRACT
	 * @model name="Subtract"
	 * @generated
	 * @ordered
	 */
	public static final int SUBTRACT_VALUE = 3;

	/**
	 * The '<em><b>Multiply</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Multiply</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MULTIPLY
	 * @model name="Multiply"
	 * @generated
	 * @ordered
	 */
	public static final int MULTIPLY_VALUE = 4;

	/**
	 * The '<em><b>Divide</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Divide</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIVIDE
	 * @model name="Divide"
	 * @generated
	 * @ordered
	 */
	public static final int DIVIDE_VALUE = 5;

	/**
	 * An array of all the '<em><b>Fixed Point Operation Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FixedPointOperationKind[] VALUES_ARRAY =
		new FixedPointOperationKind[] {
			CONSTRUCT,
			CAST,
			ADD,
			SUBTRACT,
			MULTIPLY,
			DIVIDE,
		};

	/**
	 * A public read-only list of all the '<em><b>Fixed Point Operation Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FixedPointOperationKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Fixed Point Operation Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FixedPointOperationKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FixedPointOperationKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Fixed Point Operation Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FixedPointOperationKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FixedPointOperationKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Fixed Point Operation Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FixedPointOperationKind get(int value) {
		switch (value) {
			case CONSTRUCT_VALUE: return CONSTRUCT;
			case CAST_VALUE: return CAST;
			case ADD_VALUE: return ADD;
			case SUBTRACT_VALUE: return SUBTRACT;
			case MULTIPLY_VALUE: return MULTIPLY;
			case DIVIDE_VALUE: return DIVIDE;
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
	private FixedPointOperationKind(int value, String name, String literal) {
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
	
} //FixedPointOperationKind
