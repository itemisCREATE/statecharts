/**
 */
package org.yakindu.sct.model.stext.stext;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Time Unit</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getTimeUnit()
 * @model
 * @generated
 */
public enum TimeUnit implements Enumerator
{
  /**
	 * The '<em><b>Second</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SECOND_VALUE
	 * @generated
	 * @ordered
	 */
  SECOND(0, "second", "s"),

  /**
	 * The '<em><b>Millisecond</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #MILLISECOND_VALUE
	 * @generated
	 * @ordered
	 */
  MILLISECOND(1, "millisecond", "ms"),

  /**
	 * The '<em><b>Microsecond</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #MICROSECOND_VALUE
	 * @generated
	 * @ordered
	 */
  MICROSECOND(2, "microsecond", "us"),

  /**
	 * The '<em><b>Nanosecond</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #NANOSECOND_VALUE
	 * @generated
	 * @ordered
	 */
  NANOSECOND(3, "nanosecond", "ns");

  /**
	 * The '<em><b>Second</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Second</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SECOND
	 * @model name="second" literal="s"
	 * @generated
	 * @ordered
	 */
  public static final int SECOND_VALUE = 0;

  /**
	 * The '<em><b>Millisecond</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Millisecond</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #MILLISECOND
	 * @model name="millisecond" literal="ms"
	 * @generated
	 * @ordered
	 */
  public static final int MILLISECOND_VALUE = 1;

  /**
	 * The '<em><b>Microsecond</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Microsecond</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #MICROSECOND
	 * @model name="microsecond" literal="us"
	 * @generated
	 * @ordered
	 */
  public static final int MICROSECOND_VALUE = 2;

  /**
	 * The '<em><b>Nanosecond</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Nanosecond</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #NANOSECOND
	 * @model name="nanosecond" literal="ns"
	 * @generated
	 * @ordered
	 */
  public static final int NANOSECOND_VALUE = 3;

  /**
	 * An array of all the '<em><b>Time Unit</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final TimeUnit[] VALUES_ARRAY =
    new TimeUnit[] {
			SECOND,
			MILLISECOND,
			MICROSECOND,
			NANOSECOND,
		};

  /**
	 * A public read-only list of all the '<em><b>Time Unit</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<TimeUnit> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Time Unit</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TimeUnit get(String literal)
  {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TimeUnit result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Time Unit</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TimeUnit getByName(String name)
  {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TimeUnit result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Time Unit</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TimeUnit get(int value)
  {
		switch (value) {
			case SECOND_VALUE: return SECOND;
			case MILLISECOND_VALUE: return MILLISECOND;
			case MICROSECOND_VALUE: return MICROSECOND;
			case NANOSECOND_VALUE: return NANOSECOND;
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
  private TimeUnit(int value, String name, String literal)
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
  
} //TimeUnit
