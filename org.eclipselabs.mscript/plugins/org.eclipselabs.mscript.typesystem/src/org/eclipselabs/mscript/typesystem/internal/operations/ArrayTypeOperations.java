/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem.internal.operations;

import java.util.Iterator;

import org.eclipselabs.mscript.typesystem.ArrayDimension;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Array Type</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.typesystem.ArrayType#isAssignableFrom(org.eclipselabs.mscript.typesystem.DataType) <em>Is Assignable From</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArrayTypeOperations extends DataTypeOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArrayTypeOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  boolean isAssignableFrom(ArrayType arrayType, DataType other) {
		if (other instanceof ArrayType) {
			ArrayType otherArrayType = (ArrayType) other;
			if (arrayType.getDimensionality() == otherArrayType.getDimensionality()) {
				Iterator<ArrayDimension> dimensionIterator = arrayType.getDimensions().iterator();
				Iterator<ArrayDimension> otherDimensionIterator = otherArrayType.getDimensions().iterator();
				while (dimensionIterator.hasNext() && otherDimensionIterator.hasNext()) {
					int size = dimensionIterator.next().getSize();
					int otherSize = otherDimensionIterator.next().getSize();
					if (size >= 0 && size != otherSize) {
						return false;
					}
				}
				return arrayType.getElementType().isAssignableFrom(otherArrayType.getElementType());
			}
		}
		return false;
	}

} // ArrayTypeOperations