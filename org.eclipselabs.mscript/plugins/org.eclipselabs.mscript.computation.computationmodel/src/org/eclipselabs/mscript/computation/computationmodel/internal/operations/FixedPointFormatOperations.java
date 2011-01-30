/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.computation.computationmodel.internal.operations;

import org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Fixed Point Format</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat#getOperation(org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind) <em>Get Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FixedPointFormatOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FixedPointFormatOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  FixedPointOperation getOperation(FixedPointFormat fixedPointFormat, FixedPointOperationKind kind) {
		for (FixedPointOperation operation : fixedPointFormat.getOperations()) {
			if (operation.getKind() == kind) {
				return operation;
			}
		}
		return null;
	}

} // FixedPointFormatOperations