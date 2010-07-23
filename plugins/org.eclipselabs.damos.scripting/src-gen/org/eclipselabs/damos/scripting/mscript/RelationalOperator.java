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
 * A representation of the literals of the enumeration '<em><b>Relational Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getRelationalOperator()
 * @model
 * @generated
 */
public enum RelationalOperator implements Enumerator
{
  /**
   * The '<em><b>Less Than</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LESS_THAN_VALUE
   * @generated
   * @ordered
   */
  LESS_THAN(0, "LessThan", "<"),

  /**
   * The '<em><b>Less Than Or Equal To</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LESS_THAN_OR_EQUAL_TO_VALUE
   * @generated
   * @ordered
   */
  LESS_THAN_OR_EQUAL_TO(1, "LessThanOrEqualTo", "<="),

  /**
   * The '<em><b>Greater Than</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #GREATER_THAN_VALUE
   * @generated
   * @ordered
   */
  GREATER_THAN(2, "GreaterThan", ">"),

  /**
   * The '<em><b>Greater Than Or Equal To</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #GREATER_THAN_OR_EQUAL_TO_VALUE
   * @generated
   * @ordered
   */
  GREATER_THAN_OR_EQUAL_TO(3, "GreaterThanOrEqualTo", ">="),

  /**
   * The '<em><b>Equal To</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EQUAL_TO_VALUE
   * @generated
   * @ordered
   */
  EQUAL_TO(4, "EqualTo", "=="),

  /**
   * The '<em><b>Not Equal To</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NOT_EQUAL_TO_VALUE
   * @generated
   * @ordered
   */
  NOT_EQUAL_TO(5, "NotEqualTo", "<>");

  /**
   * The '<em><b>Less Than</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Less Than</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LESS_THAN
   * @model name="LessThan" literal="<"
   * @generated
   * @ordered
   */
  public static final int LESS_THAN_VALUE = 0;

  /**
   * The '<em><b>Less Than Or Equal To</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Less Than Or Equal To</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LESS_THAN_OR_EQUAL_TO
   * @model name="LessThanOrEqualTo" literal="<="
   * @generated
   * @ordered
   */
  public static final int LESS_THAN_OR_EQUAL_TO_VALUE = 1;

  /**
   * The '<em><b>Greater Than</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Greater Than</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #GREATER_THAN
   * @model name="GreaterThan" literal=">"
   * @generated
   * @ordered
   */
  public static final int GREATER_THAN_VALUE = 2;

  /**
   * The '<em><b>Greater Than Or Equal To</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Greater Than Or Equal To</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #GREATER_THAN_OR_EQUAL_TO
   * @model name="GreaterThanOrEqualTo" literal=">="
   * @generated
   * @ordered
   */
  public static final int GREATER_THAN_OR_EQUAL_TO_VALUE = 3;

  /**
   * The '<em><b>Equal To</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Equal To</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EQUAL_TO
   * @model name="EqualTo" literal="=="
   * @generated
   * @ordered
   */
  public static final int EQUAL_TO_VALUE = 4;

  /**
   * The '<em><b>Not Equal To</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Not Equal To</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NOT_EQUAL_TO
   * @model name="NotEqualTo" literal="<>"
   * @generated
   * @ordered
   */
  public static final int NOT_EQUAL_TO_VALUE = 5;

  /**
   * An array of all the '<em><b>Relational Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final RelationalOperator[] VALUES_ARRAY =
    new RelationalOperator[]
    {
      LESS_THAN,
      LESS_THAN_OR_EQUAL_TO,
      GREATER_THAN,
      GREATER_THAN_OR_EQUAL_TO,
      EQUAL_TO,
      NOT_EQUAL_TO,
    };

  /**
   * A public read-only list of all the '<em><b>Relational Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<RelationalOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Relational Operator</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static RelationalOperator get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      RelationalOperator result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Relational Operator</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static RelationalOperator getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      RelationalOperator result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Relational Operator</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static RelationalOperator get(int value)
  {
    switch (value)
    {
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
  private RelationalOperator(int value, String name, String literal)
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
  
} //RelationalOperator
