/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.computation.computationmodel.internal.operations;

import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormat;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Computation Model</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.ComputationModel#getNumberFormat(org.eclipselabs.mscript.typesystem.DataType) <em>Get Number Format</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComputationModelOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputationModelOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  NumberFormat getNumberFormat(ComputationModel computationModel, DataType dataType) {
		NumberFormat numberFormat = null;
		DataType foundDataType = null;
		for (NumberFormatMapping mapping : computationModel.getNumberFormatMappings()) {
			DataType mappingDataType = mapping.getDataType();
			if (mappingDataType.isAssignableFrom(dataType)) {
				if (foundDataType != null) {
					if (foundDataType.isAssignableFrom(mappingDataType)) {
						numberFormat = mapping.getNumberFormat();
						foundDataType = mappingDataType;
					}
				} else {
					numberFormat = mapping.getNumberFormat();
					foundDataType = mappingDataType;
				}
			}
		}
		return numberFormat;
	}

} // ComputationModelOperations