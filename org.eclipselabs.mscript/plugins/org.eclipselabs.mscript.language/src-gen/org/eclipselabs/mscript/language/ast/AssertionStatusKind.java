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
 * A representation of the literals of the enumeration '<em><b>Assertion Status Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getAssertionStatusKind()
 * @model
 * @generated
 */
public enum AssertionStatusKind implements Enumerator
{
  /**
   * The '<em><b>Info</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INFO_VALUE
   * @generated
   * @ordered
   */
  INFO(0, "Info", "info"),

  /**
   * The '<em><b>Warning</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #WARNING_VALUE
   * @generated
   * @ordered
   */
  WARNING(1, "Warning", "warning"),

  /**
   * The '<em><b>Error</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ERROR_VALUE
   * @generated
   * @ordered
   */
  ERROR(2, "Error", "error"),

  /**
   * The '<em><b>Fatal</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FATAL_VALUE
   * @generated
   * @ordered
   */
  FATAL(3, "Fatal", "fatal");

  /**
   * The '<em><b>Info</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Info</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INFO
   * @model name="Info" literal="info"
   * @generated
   * @ordered
   */
  public static final int INFO_VALUE = 0;

  /**
   * The '<em><b>Warning</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Warning</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #WARNING
   * @model name="Warning" literal="warning"
   * @generated
   * @ordered
   */
  public static final int WARNING_VALUE = 1;

  /**
   * The '<em><b>Error</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Error</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ERROR
   * @model name="Error" literal="error"
   * @generated
   * @ordered
   */
  public static final int ERROR_VALUE = 2;

  /**
   * The '<em><b>Fatal</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Fatal</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FATAL
   * @model name="Fatal" literal="fatal"
   * @generated
   * @ordered
   */
  public static final int FATAL_VALUE = 3;

  /**
   * An array of all the '<em><b>Assertion Status Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final AssertionStatusKind[] VALUES_ARRAY =
    new AssertionStatusKind[]
    {
      INFO,
      WARNING,
      ERROR,
      FATAL,
    };

  /**
   * A public read-only list of all the '<em><b>Assertion Status Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<AssertionStatusKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Assertion Status Kind</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AssertionStatusKind get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AssertionStatusKind result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Assertion Status Kind</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AssertionStatusKind getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AssertionStatusKind result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Assertion Status Kind</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AssertionStatusKind get(int value)
  {
    switch (value)
    {
      case INFO_VALUE: return INFO;
      case WARNING_VALUE: return WARNING;
      case ERROR_VALUE: return ERROR;
      case FATAL_VALUE: return FATAL;
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
  private AssertionStatusKind(int value, String name, String literal)
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
  
} //AssertionStatusKind
