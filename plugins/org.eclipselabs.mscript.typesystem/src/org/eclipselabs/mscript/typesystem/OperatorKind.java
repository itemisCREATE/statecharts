/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Operator Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getOperatorKind()
 * @model
 * @generated
 */
public enum OperatorKind implements Enumerator {
	/**
	 * The '<em><b>Addition</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDITION_VALUE
	 * @generated
	 * @ordered
	 */
	ADDITION(0, "Addition", "Addition"), /**
	 * The '<em><b>Subtraction</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBTRACTION_VALUE
	 * @generated
	 * @ordered
	 */
	SUBTRACTION(1, "Subtraction", "Subtraction"), /**
	 * The '<em><b>Multiplication</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MULTIPLICATION_VALUE
	 * @generated
	 * @ordered
	 */
	MULTIPLICATION(2, "Multiplication", "Multiplication"), /**
	 * The '<em><b>Division</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIVISION_VALUE
	 * @generated
	 * @ordered
	 */
	DIVISION(3, "Division", "Division"), /**
	 * The '<em><b>Element Wise Multiplication</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELEMENT_WISE_MULTIPLICATION_VALUE
	 * @generated
	 * @ordered
	 */
	ELEMENT_WISE_MULTIPLICATION(4, "ElementWiseMultiplication", "ElementWiseMultiplication"), /**
	 * The '<em><b>Element Wise Division</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELEMENT_WISE_DIVISION_VALUE
	 * @generated
	 * @ordered
	 */
	ELEMENT_WISE_DIVISION(5, "ElementWiseDivision", "ElementWiseDivision"), /**
	 * The '<em><b>Unary Minus</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNARY_MINUS_VALUE
	 * @generated
	 * @ordered
	 */
	UNARY_MINUS(6, "UnaryMinus", "UnaryMinus"), /**
	 * The '<em><b>Logical And</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOGICAL_AND_VALUE
	 * @generated
	 * @ordered
	 */
	LOGICAL_AND(7, "LogicalAnd", "LogicalAnd"), /**
	 * The '<em><b>Logical Or</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOGICAL_OR_VALUE
	 * @generated
	 * @ordered
	 */
	LOGICAL_OR(8, "LogicalOr", "LogicalOr"), /**
	 * The '<em><b>Logical Not</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOGICAL_NOT_VALUE
	 * @generated
	 * @ordered
	 */
	LOGICAL_NOT(9, "LogicalNot", "LogicalNot"), /**
	 * The '<em><b>Less Than</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LESS_THAN_VALUE
	 * @generated
	 * @ordered
	 */
	LESS_THAN(10, "LessThan", "LessThan"), /**
	 * The '<em><b>Less Than Or Equal To</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LESS_THAN_OR_EQUAL_TO_VALUE
	 * @generated
	 * @ordered
	 */
	LESS_THAN_OR_EQUAL_TO(11, "LessThanOrEqualTo", "LessThanOrEqualTo"), /**
	 * The '<em><b>Greater Than</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GREATER_THAN_VALUE
	 * @generated
	 * @ordered
	 */
	GREATER_THAN(12, "GreaterThan", "GreaterThan"), /**
	 * The '<em><b>Greater Than Or Equal To</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GREATER_THAN_OR_EQUAL_TO_VALUE
	 * @generated
	 * @ordered
	 */
	GREATER_THAN_OR_EQUAL_TO(13, "GreaterThanOrEqualTo", "GreaterThanOrEqualTo"), /**
	 * The '<em><b>Equal To</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQUAL_TO_VALUE
	 * @generated
	 * @ordered
	 */
	EQUAL_TO(14, "EqualTo", "EqualTo"), /**
	 * The '<em><b>Not Equal To</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_EQUAL_TO_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_EQUAL_TO(15, "NotEqualTo", "NotEqualTo");

	/**
	 * The '<em><b>Addition</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Addition</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADDITION
	 * @model name="Addition"
	 * @generated
	 * @ordered
	 */
	public static final int ADDITION_VALUE = 0;

	/**
	 * The '<em><b>Subtraction</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Subtraction</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUBTRACTION
	 * @model name="Subtraction"
	 * @generated
	 * @ordered
	 */
	public static final int SUBTRACTION_VALUE = 1;

	/**
	 * The '<em><b>Multiplication</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Multiplication</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MULTIPLICATION
	 * @model name="Multiplication"
	 * @generated
	 * @ordered
	 */
	public static final int MULTIPLICATION_VALUE = 2;

	/**
	 * The '<em><b>Division</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Division</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIVISION
	 * @model name="Division"
	 * @generated
	 * @ordered
	 */
	public static final int DIVISION_VALUE = 3;

	/**
	 * The '<em><b>Element Wise Multiplication</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Element Wise Multiplication</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELEMENT_WISE_MULTIPLICATION
	 * @model name="ElementWiseMultiplication"
	 * @generated
	 * @ordered
	 */
	public static final int ELEMENT_WISE_MULTIPLICATION_VALUE = 4;

	/**
	 * The '<em><b>Element Wise Division</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Element Wise Division</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELEMENT_WISE_DIVISION
	 * @model name="ElementWiseDivision"
	 * @generated
	 * @ordered
	 */
	public static final int ELEMENT_WISE_DIVISION_VALUE = 5;

	/**
	 * The '<em><b>Unary Minus</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unary Minus</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNARY_MINUS
	 * @model name="UnaryMinus"
	 * @generated
	 * @ordered
	 */
	public static final int UNARY_MINUS_VALUE = 6;

/**
	 * The '<em><b>Logical And</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Logical And</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOGICAL_AND
	 * @model name="LogicalAnd"
	 * @generated
	 * @ordered
	 */
	public static final int LOGICAL_AND_VALUE = 7;

/**
	 * The '<em><b>Logical Or</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Logical Or</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOGICAL_OR
	 * @model name="LogicalOr"
	 * @generated
	 * @ordered
	 */
	public static final int LOGICAL_OR_VALUE = 8;

/**
	 * The '<em><b>Logical Not</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Logical Not</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOGICAL_NOT
	 * @model name="LogicalNot"
	 * @generated
	 * @ordered
	 */
	public static final int LOGICAL_NOT_VALUE = 9;

/**
	 * The '<em><b>Less Than</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Less Than</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LESS_THAN
	 * @model name="LessThan"
	 * @generated
	 * @ordered
	 */
	public static final int LESS_THAN_VALUE = 10;

/**
	 * The '<em><b>Less Than Or Equal To</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Less Than Or Equal To</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LESS_THAN_OR_EQUAL_TO
	 * @model name="LessThanOrEqualTo"
	 * @generated
	 * @ordered
	 */
	public static final int LESS_THAN_OR_EQUAL_TO_VALUE = 11;

/**
	 * The '<em><b>Greater Than</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Greater Than</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GREATER_THAN
	 * @model name="GreaterThan"
	 * @generated
	 * @ordered
	 */
	public static final int GREATER_THAN_VALUE = 12;

/**
	 * The '<em><b>Greater Than Or Equal To</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Greater Than Or Equal To</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GREATER_THAN_OR_EQUAL_TO
	 * @model name="GreaterThanOrEqualTo"
	 * @generated
	 * @ordered
	 */
	public static final int GREATER_THAN_OR_EQUAL_TO_VALUE = 13;

/**
	 * The '<em><b>Equal To</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Equal To</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EQUAL_TO
	 * @model name="EqualTo"
	 * @generated
	 * @ordered
	 */
	public static final int EQUAL_TO_VALUE = 14;

/**
	 * The '<em><b>Not Equal To</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Not Equal To</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_EQUAL_TO
	 * @model name="NotEqualTo"
	 * @generated
	 * @ordered
	 */
	public static final int NOT_EQUAL_TO_VALUE = 15;

/**
	 * An array of all the '<em><b>Operator Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final OperatorKind[] VALUES_ARRAY =
		new OperatorKind[] {
			ADDITION,
			SUBTRACTION,
			MULTIPLICATION,
			DIVISION,
			ELEMENT_WISE_MULTIPLICATION,
			ELEMENT_WISE_DIVISION,
			UNARY_MINUS,
			LOGICAL_AND,
			LOGICAL_OR,
			LOGICAL_NOT,
			LESS_THAN,
			LESS_THAN_OR_EQUAL_TO,
			GREATER_THAN,
			GREATER_THAN_OR_EQUAL_TO,
			EQUAL_TO,
			NOT_EQUAL_TO,
		};

	/**
	 * A public read-only list of all the '<em><b>Operator Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<OperatorKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Operator Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OperatorKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OperatorKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Operator Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OperatorKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OperatorKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Operator Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OperatorKind get(int value) {
		switch (value) {
			case ADDITION_VALUE: return ADDITION;
			case SUBTRACTION_VALUE: return SUBTRACTION;
			case MULTIPLICATION_VALUE: return MULTIPLICATION;
			case DIVISION_VALUE: return DIVISION;
			case ELEMENT_WISE_MULTIPLICATION_VALUE: return ELEMENT_WISE_MULTIPLICATION;
			case ELEMENT_WISE_DIVISION_VALUE: return ELEMENT_WISE_DIVISION;
			case UNARY_MINUS_VALUE: return UNARY_MINUS;
			case LOGICAL_AND_VALUE: return LOGICAL_AND;
			case LOGICAL_OR_VALUE: return LOGICAL_OR;
			case LOGICAL_NOT_VALUE: return LOGICAL_NOT;
			case LESS_THAN_VALUE: return LESS_THAN;
			case LESS_THAN_OR_EQUAL_TO_VALUE: return LESS_THAN_OR_EQUAL_TO;
			case GREATER_THAN_VALUE: return GREATER_THAN;
			case GREATER_THAN_OR_EQUAL_TO_VALUE: return GREATER_THAN_OR_EQUAL_TO;
			case EQUAL_TO_VALUE: return EQUAL_TO;
			case NOT_EQUAL_TO_VALUE: return NOT_EQUAL_TO;
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
	private OperatorKind(int value, String name, String literal) {
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
	
} //OperatorKind
