/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.typesystem.internal.operations;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.typesystem.TensorType;
import org.eclipselabs.damos.typesystem.Unit;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Tensor Type</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.typesystem.TensorType#getUnit(int) <em>Get Unit</em>}</li>
 *   <li>{@link org.eclipselabs.damos.typesystem.TensorType#getUnit(int, int) <em>Get Unit</em>}</li>
 *   <li>{@link org.eclipselabs.damos.typesystem.TensorType#getUnit(org.eclipse.emf.common.util.EList) <em>Get Unit</em>}</li>
 *   <li>{@link org.eclipselabs.damos.typesystem.TensorType#setUnit(int, org.eclipselabs.damos.typesystem.Unit) <em>Set Unit</em>}</li>
 *   <li>{@link org.eclipselabs.damos.typesystem.TensorType#setUnit(int, int, org.eclipselabs.damos.typesystem.Unit) <em>Set Unit</em>}</li>
 *   <li>{@link org.eclipselabs.damos.typesystem.TensorType#setUnit(org.eclipse.emf.common.util.EList, org.eclipselabs.damos.typesystem.Unit) <em>Set Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TensorTypeOperations extends DataTypeOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TensorTypeOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  Unit getUnit(TensorType tensorType, int index) {
		EList<Integer> indices = new BasicEList<Integer>(1);
		indices.add(index);
		return getUnit(tensorType, indices);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  Unit getUnit(TensorType tensorType, int row, int column) {
		EList<Integer> indices = new BasicEList<Integer>(2);
		indices.add(row);
		indices.add(column);
		return getUnit(tensorType, indices);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  Unit getUnit(TensorType tensorType, EList<Integer> indices) {
		return tensorType.getUnits().get(toLinearUnitIndex(tensorType, indices));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  void setUnit(TensorType tensorType, int index, Unit unit) {
		EList<Integer> indices = new BasicEList<Integer>(1);
		indices.add(index);
		setUnit(tensorType, indices, unit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  void setUnit(TensorType tensorType, int row, int column, Unit unit) {
		EList<Integer> indices = new BasicEList<Integer>(2);
		indices.add(row);
		indices.add(column);
		setUnit(tensorType, indices, unit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  void setUnit(TensorType tensorType, EList<Integer> indices, Unit unit) {
		tensorType.getUnits().set(toLinearUnitIndex(tensorType, indices), unit);
	}
	
	private static int toLinearUnitIndex(TensorType tensorType, EList<Integer> indices) {
		int index = indices.get(0);
		for (int i = 1; i < indices.size(); ++i) {
			index = index * tensorType.getDimensions().get(i).getSize() + indices.get(i);
		}
		return index;
	}

} // TensorTypeOperations