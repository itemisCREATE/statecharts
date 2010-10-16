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
 * A representation of the literals of the enumeration '<em><b>Assignment Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getAssignmentOperator()
 * @model
 * @generated
 */
public enum AssignmentOperator implements Enumerator
{
  /**
   * The '<em><b>Assignment</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ASSIGNMENT_VALUE
   * @generated
   * @ordered
   */
  ASSIGNMENT(0, "Assignment", "="),

  /**
   * The '<em><b>Addition Assignment</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ADDITION_ASSIGNMENT_VALUE
   * @generated
   * @ordered
   */
  ADDITION_ASSIGNMENT(1, "AdditionAssignment", "+="),

  /**
   * The '<em><b>Subtraction Assignment</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SUBTRACTION_ASSIGNMENT_VALUE
   * @generated
   * @ordered
   */
  SUBTRACTION_ASSIGNMENT(2, "SubtractionAssignment", "-="),

  /**
   * The '<em><b>Multiplication Assignment</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MULTIPLICATION_ASSIGNMENT_VALUE
   * @generated
   * @ordered
   */
  MULTIPLICATION_ASSIGNMENT(3, "MultiplicationAssignment", "*="),

  /**
   * The '<em><b>Division Assignment</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DIVISION_ASSIGNMENT_VALUE
   * @generated
   * @ordered
   */
  DIVISION_ASSIGNMENT(4, "DivisionAssignment", "/=");

  /**
   * The '<em><b>Assignment</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Assignment</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ASSIGNMENT
   * @model name="Assignment" literal="="
   * @generated
   * @ordered
   */
  public static final int ASSIGNMENT_VALUE = 0;

  /**
   * The '<em><b>Addition Assignment</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Addition Assignment</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ADDITION_ASSIGNMENT
   * @model name="AdditionAssignment" literal="+="
   * @generated
   * @ordered
   */
  public static final int ADDITION_ASSIGNMENT_VALUE = 1;

  /**
   * The '<em><b>Subtraction Assignment</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Subtraction Assignment</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SUBTRACTION_ASSIGNMENT
   * @model name="SubtractionAssignment" literal="-="
   * @generated
   * @ordered
   */
  public static final int SUBTRACTION_ASSIGNMENT_VALUE = 2;

  /**
   * The '<em><b>Multiplication Assignment</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Multiplication Assignment</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MULTIPLICATION_ASSIGNMENT
   * @model name="MultiplicationAssignment" literal="*="
   * @generated
   * @ordered
   */
  public static final int MULTIPLICATION_ASSIGNMENT_VALUE = 3;

  /**
   * The '<em><b>Division Assignment</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Division Assignment</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DIVISION_ASSIGNMENT
   * @model name="DivisionAssignment" literal="/="
   * @generated
   * @ordered
   */
  public static final int DIVISION_ASSIGNMENT_VALUE = 4;

  /**
   * An array of all the '<em><b>Assignment Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final AssignmentOperator[] VALUES_ARRAY =
    new AssignmentOperator[]
    {
      ASSIGNMENT,
      ADDITION_ASSIGNMENT,
      SUBTRACTION_ASSIGNMENT,
      MULTIPLICATION_ASSIGNMENT,
      DIVISION_ASSIGNMENT,
    };

  /**
   * A public read-only list of all the '<em><b>Assignment Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<AssignmentOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Assignment Operator</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AssignmentOperator get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AssignmentOperator result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Assignment Operator</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AssignmentOperator getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AssignmentOperator result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Assignment Operator</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AssignmentOperator get(int value)
  {
    switch (value)
    {
      case ASSIGNMENT_VALUE: return ASSIGNMENT;
      case ADDITION_ASSIGNMENT_VALUE: return ADDITION_ASSIGNMENT;
      case SUBTRACTION_ASSIGNMENT_VALUE: return SUBTRACTION_ASSIGNMENT;
      case MULTIPLICATION_ASSIGNMENT_VALUE: return MULTIPLICATION_ASSIGNMENT;
      case DIVISION_ASSIGNMENT_VALUE: return DIVISION_ASSIGNMENT;
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
  private AssignmentOperator(int value, String name, String literal)
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
  
} //AssignmentOperator
