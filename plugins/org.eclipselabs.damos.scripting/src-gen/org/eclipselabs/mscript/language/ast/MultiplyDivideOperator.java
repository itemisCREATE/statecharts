/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Multiply Divide Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getMultiplyDivideOperator()
 * @model
 * @generated
 */
public enum MultiplyDivideOperator implements Enumerator
{
  /**
   * The '<em><b>Multiply</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MULTIPLY_VALUE
   * @generated
   * @ordered
   */
  MULTIPLY(0, "Multiply", "*"),

  /**
   * The '<em><b>Divide</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DIVIDE_VALUE
   * @generated
   * @ordered
   */
  DIVIDE(1, "Divide", "/"),

  /**
   * The '<em><b>Element Wise Multiply</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ELEMENT_WISE_MULTIPLY_VALUE
   * @generated
   * @ordered
   */
  ELEMENT_WISE_MULTIPLY(2, "ElementWiseMultiply", ".*"),

  /**
   * The '<em><b>Element Wise Divide</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ELEMENT_WISE_DIVIDE_VALUE
   * @generated
   * @ordered
   */
  ELEMENT_WISE_DIVIDE(3, "ElementWiseDivide", "./");

  /**
   * The '<em><b>Multiply</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Multiply</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MULTIPLY
   * @model name="Multiply" literal="*"
   * @generated
   * @ordered
   */
  public static final int MULTIPLY_VALUE = 0;

  /**
   * The '<em><b>Divide</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Divide</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DIVIDE
   * @model name="Divide" literal="/"
   * @generated
   * @ordered
   */
  public static final int DIVIDE_VALUE = 1;

  /**
   * The '<em><b>Element Wise Multiply</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Element Wise Multiply</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ELEMENT_WISE_MULTIPLY
   * @model name="ElementWiseMultiply" literal=".*"
   * @generated
   * @ordered
   */
  public static final int ELEMENT_WISE_MULTIPLY_VALUE = 2;

  /**
   * The '<em><b>Element Wise Divide</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Element Wise Divide</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ELEMENT_WISE_DIVIDE
   * @model name="ElementWiseDivide" literal="./"
   * @generated
   * @ordered
   */
  public static final int ELEMENT_WISE_DIVIDE_VALUE = 3;

  /**
   * An array of all the '<em><b>Multiply Divide Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final MultiplyDivideOperator[] VALUES_ARRAY =
    new MultiplyDivideOperator[]
    {
      MULTIPLY,
      DIVIDE,
      ELEMENT_WISE_MULTIPLY,
      ELEMENT_WISE_DIVIDE,
    };

  /**
   * A public read-only list of all the '<em><b>Multiply Divide Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<MultiplyDivideOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Multiply Divide Operator</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MultiplyDivideOperator get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      MultiplyDivideOperator result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Multiply Divide Operator</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MultiplyDivideOperator getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      MultiplyDivideOperator result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Multiply Divide Operator</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MultiplyDivideOperator get(int value)
  {
    switch (value)
    {
      case MULTIPLY_VALUE: return MULTIPLY;
      case DIVIDE_VALUE: return DIVIDE;
      case ELEMENT_WISE_MULTIPLY_VALUE: return ELEMENT_WISE_MULTIPLY;
      case ELEMENT_WISE_DIVIDE_VALUE: return ELEMENT_WISE_DIVIDE;
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
  private MultiplyDivideOperator(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //MultiplyDivideOperator
