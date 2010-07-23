/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Add Subtract Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getAddSubtractOperator()
 * @model
 * @generated
 */
public enum AddSubtractOperator implements Enumerator
{
  /**
   * The '<em><b>Add</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ADD_VALUE
   * @generated
   * @ordered
   */
  ADD(0, "Add", "+"),

  /**
   * The '<em><b>Subtract</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SUBTRACT_VALUE
   * @generated
   * @ordered
   */
  SUBTRACT(1, "Subtract", "-"),

  /**
   * The '<em><b>Element Wise Add</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ELEMENT_WISE_ADD_VALUE
   * @generated
   * @ordered
   */
  ELEMENT_WISE_ADD(2, "ElementWiseAdd", ".+"),

  /**
   * The '<em><b>Element Wise Subtract</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ELEMENT_WISE_SUBTRACT_VALUE
   * @generated
   * @ordered
   */
  ELEMENT_WISE_SUBTRACT(3, "ElementWiseSubtract", ".-");

  /**
   * The '<em><b>Add</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Add</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ADD
   * @model name="Add" literal="+"
   * @generated
   * @ordered
   */
  public static final int ADD_VALUE = 0;

  /**
   * The '<em><b>Subtract</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Subtract</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SUBTRACT
   * @model name="Subtract" literal="-"
   * @generated
   * @ordered
   */
  public static final int SUBTRACT_VALUE = 1;

  /**
   * The '<em><b>Element Wise Add</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Element Wise Add</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ELEMENT_WISE_ADD
   * @model name="ElementWiseAdd" literal=".+"
   * @generated
   * @ordered
   */
  public static final int ELEMENT_WISE_ADD_VALUE = 2;

  /**
   * The '<em><b>Element Wise Subtract</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Element Wise Subtract</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ELEMENT_WISE_SUBTRACT
   * @model name="ElementWiseSubtract" literal=".-"
   * @generated
   * @ordered
   */
  public static final int ELEMENT_WISE_SUBTRACT_VALUE = 3;

  /**
   * An array of all the '<em><b>Add Subtract Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final AddSubtractOperator[] VALUES_ARRAY =
    new AddSubtractOperator[]
    {
      ADD,
      SUBTRACT,
      ELEMENT_WISE_ADD,
      ELEMENT_WISE_SUBTRACT,
    };

  /**
   * A public read-only list of all the '<em><b>Add Subtract Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<AddSubtractOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Add Subtract Operator</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AddSubtractOperator get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AddSubtractOperator result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Add Subtract Operator</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AddSubtractOperator getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AddSubtractOperator result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Add Subtract Operator</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AddSubtractOperator get(int value)
  {
    switch (value)
    {
      case ADD_VALUE: return ADD;
      case SUBTRACT_VALUE: return SUBTRACT;
      case ELEMENT_WISE_ADD_VALUE: return ELEMENT_WISE_ADD;
      case ELEMENT_WISE_SUBTRACT_VALUE: return ELEMENT_WISE_SUBTRACT;
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
  private AddSubtractOperator(int value, String name, String literal)
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
  
} //AddSubtractOperator
