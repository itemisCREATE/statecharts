/**
 */
package org.yakindu.sct.model.stext.stext;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Shift Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getShiftOperator()
 * @model
 * @generated
 */
public enum ShiftOperator implements Enumerator
{
  /**
   * The '<em><b>Left</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LEFT_VALUE
   * @generated
   * @ordered
   */
  LEFT(0, "left", "<<"),

  /**
   * The '<em><b>Right</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RIGHT_VALUE
   * @generated
   * @ordered
   */
  RIGHT(1, "right", ">>");

  /**
   * The '<em><b>Left</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Left</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LEFT
   * @model name="left" literal="<<"
   * @generated
   * @ordered
   */
  public static final int LEFT_VALUE = 0;

  /**
   * The '<em><b>Right</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Right</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #RIGHT
   * @model name="right" literal=">>"
   * @generated
   * @ordered
   */
  public static final int RIGHT_VALUE = 1;

  /**
   * An array of all the '<em><b>Shift Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ShiftOperator[] VALUES_ARRAY =
    new ShiftOperator[]
    {
      LEFT,
      RIGHT,
    };

  /**
   * A public read-only list of all the '<em><b>Shift Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ShiftOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Shift Operator</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ShiftOperator get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ShiftOperator result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Shift Operator</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ShiftOperator getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ShiftOperator result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Shift Operator</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ShiftOperator get(int value)
  {
    switch (value)
    {
      case LEFT_VALUE: return LEFT;
      case RIGHT_VALUE: return RIGHT;
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
  private ShiftOperator(int value, String name, String literal)
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
  
} //ShiftOperator
