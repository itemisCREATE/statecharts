/**
 */
package org.yakindu.base.expressions.expressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Assignment Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getAssignmentOperator()
 * @model
 * @generated
 */
public enum AssignmentOperator implements Enumerator
{
  /**
   * The '<em><b>Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ASSIGN_VALUE
   * @generated
   * @ordered
   */
  ASSIGN(0, "assign", "="),

  /**
   * The '<em><b>Mult Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MULT_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  MULT_ASSIGN(1, "multAssign", "*="),

  /**
   * The '<em><b>Div Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DIV_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  DIV_ASSIGN(2, "divAssign", "/="),

  /**
   * The '<em><b>Mod Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MOD_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  MOD_ASSIGN(3, "modAssign", "%="),

  /**
   * The '<em><b>Add Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ADD_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  ADD_ASSIGN(4, "addAssign", "+="),

  /**
   * The '<em><b>Sub Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SUB_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  SUB_ASSIGN(5, "subAssign", "-="),

  /**
   * The '<em><b>Left Shift Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LEFT_SHIFT_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  LEFT_SHIFT_ASSIGN(6, "leftShiftAssign", "<<="),

  /**
   * The '<em><b>Right Shift Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RIGHT_SHIFT_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  RIGHT_SHIFT_ASSIGN(7, "rightShiftAssign", ">>="),

  /**
   * The '<em><b>And Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #AND_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  AND_ASSIGN(8, "andAssign", "&="),

  /**
   * The '<em><b>Xor Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #XOR_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  XOR_ASSIGN(9, "xorAssign", "^="),

  /**
   * The '<em><b>Or Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OR_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  OR_ASSIGN(10, "orAssign", "|=");

  /**
   * The '<em><b>Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ASSIGN
   * @model name="assign" literal="="
   * @generated
   * @ordered
   */
  public static final int ASSIGN_VALUE = 0;

  /**
   * The '<em><b>Mult Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Mult Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MULT_ASSIGN
   * @model name="multAssign" literal="*="
   * @generated
   * @ordered
   */
  public static final int MULT_ASSIGN_VALUE = 1;

  /**
   * The '<em><b>Div Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Div Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DIV_ASSIGN
   * @model name="divAssign" literal="/="
   * @generated
   * @ordered
   */
  public static final int DIV_ASSIGN_VALUE = 2;

  /**
   * The '<em><b>Mod Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Mod Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MOD_ASSIGN
   * @model name="modAssign" literal="%="
   * @generated
   * @ordered
   */
  public static final int MOD_ASSIGN_VALUE = 3;

  /**
   * The '<em><b>Add Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Add Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ADD_ASSIGN
   * @model name="addAssign" literal="+="
   * @generated
   * @ordered
   */
  public static final int ADD_ASSIGN_VALUE = 4;

  /**
   * The '<em><b>Sub Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Sub Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SUB_ASSIGN
   * @model name="subAssign" literal="-="
   * @generated
   * @ordered
   */
  public static final int SUB_ASSIGN_VALUE = 5;

  /**
   * The '<em><b>Left Shift Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Left Shift Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LEFT_SHIFT_ASSIGN
   * @model name="leftShiftAssign" literal="<<="
   * @generated
   * @ordered
   */
  public static final int LEFT_SHIFT_ASSIGN_VALUE = 6;

  /**
   * The '<em><b>Right Shift Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Right Shift Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #RIGHT_SHIFT_ASSIGN
   * @model name="rightShiftAssign" literal=">>="
   * @generated
   * @ordered
   */
  public static final int RIGHT_SHIFT_ASSIGN_VALUE = 7;

  /**
   * The '<em><b>And Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>And Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #AND_ASSIGN
   * @model name="andAssign" literal="&="
   * @generated
   * @ordered
   */
  public static final int AND_ASSIGN_VALUE = 8;

  /**
   * The '<em><b>Xor Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Xor Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #XOR_ASSIGN
   * @model name="xorAssign" literal="^="
   * @generated
   * @ordered
   */
  public static final int XOR_ASSIGN_VALUE = 9;

  /**
   * The '<em><b>Or Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Or Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OR_ASSIGN
   * @model name="orAssign" literal="|="
   * @generated
   * @ordered
   */
  public static final int OR_ASSIGN_VALUE = 10;

  /**
   * An array of all the '<em><b>Assignment Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final AssignmentOperator[] VALUES_ARRAY =
    new AssignmentOperator[]
    {
      ASSIGN,
      MULT_ASSIGN,
      DIV_ASSIGN,
      MOD_ASSIGN,
      ADD_ASSIGN,
      SUB_ASSIGN,
      LEFT_SHIFT_ASSIGN,
      RIGHT_SHIFT_ASSIGN,
      AND_ASSIGN,
      XOR_ASSIGN,
      OR_ASSIGN,
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
      case ASSIGN_VALUE: return ASSIGN;
      case MULT_ASSIGN_VALUE: return MULT_ASSIGN;
      case DIV_ASSIGN_VALUE: return DIV_ASSIGN;
      case MOD_ASSIGN_VALUE: return MOD_ASSIGN;
      case ADD_ASSIGN_VALUE: return ADD_ASSIGN;
      case SUB_ASSIGN_VALUE: return SUB_ASSIGN;
      case LEFT_SHIFT_ASSIGN_VALUE: return LEFT_SHIFT_ASSIGN;
      case RIGHT_SHIFT_ASSIGN_VALUE: return RIGHT_SHIFT_ASSIGN;
      case AND_ASSIGN_VALUE: return AND_ASSIGN;
      case XOR_ASSIGN_VALUE: return XOR_ASSIGN;
      case OR_ASSIGN_VALUE: return OR_ASSIGN;
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
