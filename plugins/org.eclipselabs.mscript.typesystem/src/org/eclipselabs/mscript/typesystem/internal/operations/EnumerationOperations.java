/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem.internal.operations;

import org.eclipselabs.mscript.typesystem.Enumeration;
import org.eclipselabs.mscript.typesystem.EnumerationLiteral;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Enumeration</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.typesystem.Enumeration#getLiteral(java.lang.String) <em>Get Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumerationOperations extends NamespaceOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumerationOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  EnumerationLiteral getLiteral(Enumeration enumeration, String name) {
		for (EnumerationLiteral l : enumeration.getLiterals()) {
			if (name.equals(l.getName())) {
				return l;
			}
		}
		return null;
	}

} // EnumerationOperations