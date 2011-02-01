/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.functionmodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Variable Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getVariableKind()
 * @model
 * @generated
 */
public enum VariableKind implements Enumerator {
	/**
	 * The '<em><b>Unknown</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN_VALUE
	 * @generated
	 * @ordered
	 */
	UNKNOWN(-1, "Unknown", "Unknown"),

	/**
	 * The '<em><b>Template Parameter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEMPLATE_PARAMETER_VALUE
	 * @generated
	 * @ordered
	 */
	TEMPLATE_PARAMETER(0, "TemplateParameter", "TemplateParameter"),

	/**
	 * The '<em><b>Input Parameter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INPUT_PARAMETER_VALUE
	 * @generated
	 * @ordered
	 */
	INPUT_PARAMETER(1, "InputParameter", "InputParameter"),

	/**
	 * The '<em><b>Output Parameter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUTPUT_PARAMETER_VALUE
	 * @generated
	 * @ordered
	 */
	OUTPUT_PARAMETER(2, "OutputParameter", "OutputParameter"),

	/**
	 * The '<em><b>State Variable</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATE_VARIABLE_VALUE
	 * @generated
	 * @ordered
	 */
	STATE_VARIABLE(3, "StateVariable", "StateVariable"),

	/**
	 * The '<em><b>Constant</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSTANT_VALUE
	 * @generated
	 * @ordered
	 */
	CONSTANT(4, "Constant", "Constant"),

	/**
	 * The '<em><b>Function Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FUNCTION_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	FUNCTION_OBJECT(5, "FunctionObject", "FunctionObject");

	/**
	 * The '<em><b>Unknown</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unknown</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN
	 * @model name="Unknown"
	 * @generated
	 * @ordered
	 */
	public static final int UNKNOWN_VALUE = -1;

	/**
	 * The '<em><b>Template Parameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Template Parameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEMPLATE_PARAMETER
	 * @model name="TemplateParameter"
	 * @generated
	 * @ordered
	 */
	public static final int TEMPLATE_PARAMETER_VALUE = 0;

	/**
	 * The '<em><b>Input Parameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Input Parameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INPUT_PARAMETER
	 * @model name="InputParameter"
	 * @generated
	 * @ordered
	 */
	public static final int INPUT_PARAMETER_VALUE = 1;

	/**
	 * The '<em><b>Output Parameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Output Parameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OUTPUT_PARAMETER
	 * @model name="OutputParameter"
	 * @generated
	 * @ordered
	 */
	public static final int OUTPUT_PARAMETER_VALUE = 2;

	/**
	 * The '<em><b>State Variable</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>State Variable</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATE_VARIABLE
	 * @model name="StateVariable"
	 * @generated
	 * @ordered
	 */
	public static final int STATE_VARIABLE_VALUE = 3;

	/**
	 * The '<em><b>Constant</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Constant</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONSTANT
	 * @model name="Constant"
	 * @generated
	 * @ordered
	 */
	public static final int CONSTANT_VALUE = 4;

	/**
	 * The '<em><b>Function Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Function Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FUNCTION_OBJECT
	 * @model name="FunctionObject"
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_OBJECT_VALUE = 5;

	/**
	 * An array of all the '<em><b>Variable Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final VariableKind[] VALUES_ARRAY =
		new VariableKind[] {
			UNKNOWN,
			TEMPLATE_PARAMETER,
			INPUT_PARAMETER,
			OUTPUT_PARAMETER,
			STATE_VARIABLE,
			CONSTANT,
			FUNCTION_OBJECT,
		};

	/**
	 * A public read-only list of all the '<em><b>Variable Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<VariableKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Variable Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VariableKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VariableKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Variable Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VariableKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VariableKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Variable Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VariableKind get(int value) {
		switch (value) {
			case UNKNOWN_VALUE: return UNKNOWN;
			case TEMPLATE_PARAMETER_VALUE: return TEMPLATE_PARAMETER;
			case INPUT_PARAMETER_VALUE: return INPUT_PARAMETER;
			case OUTPUT_PARAMETER_VALUE: return OUTPUT_PARAMETER;
			case STATE_VARIABLE_VALUE: return STATE_VARIABLE;
			case CONSTANT_VALUE: return CONSTANT;
			case FUNCTION_OBJECT_VALUE: return FUNCTION_OBJECT;
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
	private VariableKind(int value, String name, String literal) {
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
	
} //VariableKind
