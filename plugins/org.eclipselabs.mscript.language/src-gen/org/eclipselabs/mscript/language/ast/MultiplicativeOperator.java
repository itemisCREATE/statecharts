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
 * A representation of the literals of the enumeration '<em><b>Multiplicative Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getMultiplicativeOperator()
 * @model
 * @generated
 */
public enum MultiplicativeOperator implements Enumerator
{
  /**
   * The '<em><b>Multiplication</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MULTIPLICATION_VALUE
   * @generated
   * @ordered
   */
  MULTIPLICATION(0, "Multiplication", "*"),

  /**
   * The '<em><b>Division</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DIVISION_VALUE
   * @generated
   * @ordered
   */
  DIVISION(1, "Division", "/"),

  /**
   * The '<em><b>Element Wise Multiplication</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ELEMENT_WISE_MULTIPLICATION_VALUE
   * @generated
   * @ordered
   */
  ELEMENT_WISE_MULTIPLICATION(2, "ElementWiseMultiplication", ".*"),

  /**
   * The '<em><b>Element Wise Division</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ELEMENT_WISE_DIVISION_VALUE
   * @generated
   * @ordered
   */
  ELEMENT_WISE_DIVISION(3, "ElementWiseDivision", "./");

  /**
   * The '<em><b>Multiplication</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Multiplication</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MULTIPLICATION
   * @model name="Multiplication" literal="*"
   * @generated
   * @ordered
   */
  public static final int MULTIPLICATION_VALUE = 0;

  /**
   * The '<em><b>Division</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Division</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DIVISION
   * @model name="Division" literal="/"
   * @generated
   * @ordered
   */
  public static final int DIVISION_VALUE = 1;

  /**
   * The '<em><b>Element Wise Multiplication</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Element Wise Multiplication</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ELEMENT_WISE_MULTIPLICATION
   * @model name="ElementWiseMultiplication" literal=".*"
   * @generated
   * @ordered
   */
  public static final int ELEMENT_WISE_MULTIPLICATION_VALUE = 2;

  /**
   * The '<em><b>Element Wise Division</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Element Wise Division</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ELEMENT_WISE_DIVISION
   * @model name="ElementWiseDivision" literal="./"
   * @generated
   * @ordered
   */
  public static final int ELEMENT_WISE_DIVISION_VALUE = 3;

  /**
   * An array of all the '<em><b>Multiplicative Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final MultiplicativeOperator[] VALUES_ARRAY =
    new MultiplicativeOperator[]
    {
      MULTIPLICATION,
      DIVISION,
      ELEMENT_WISE_MULTIPLICATION,
      ELEMENT_WISE_DIVISION,
    };

  /**
   * A public read-only list of all the '<em><b>Multiplicative Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<MultiplicativeOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Multiplicative Operator</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MultiplicativeOperator get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      MultiplicativeOperator result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Multiplicative Operator</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MultiplicativeOperator getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      MultiplicativeOperator result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Multiplicative Operator</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MultiplicativeOperator get(int value)
  {
    switch (value)
    {
      case MULTIPLICATION_VALUE: return MULTIPLICATION;
      case DIVISION_VALUE: return DIVISION;
      case ELEMENT_WISE_MULTIPLICATION_VALUE: return ELEMENT_WISE_MULTIPLICATION;
      case ELEMENT_WISE_DIVISION_VALUE: return ELEMENT_WISE_DIVISION;
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
  private MultiplicativeOperator(int value, String name, String literal)
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
  
} //MultiplicativeOperator
