/**
 * Copyright (c) 2014 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.base.types;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Abstract base implementation of an {@link ITypeSystem}. Delivers only utility
 * methods that are helpful to create a {@link ITypeSystem} implementation, and
 * does not implement any of the {@link ITypeSystem} methods itself.
 * 
 * @author Alexander Nyßen (alexander.nyssen@itemis.de) - Initial contribution
 *         and API
 * 
 */
public abstract class AbstractTypeSystem implements ITypeSystem {

	/**
	 * Computes the {@link PrimitiveType} that within the base type hierarchy of
	 * the two given {@link PrimitiveType}s is their closest ancestor. This may
	 * also be one of the two given {@link PrimitiveType}s in case they are
	 * equal or one is the ancestor of the other.
	 * 
	 * @param firstType
	 *            The first {@link PrimitiveType} to evaluate
	 * @param secondType
	 *            The second {@link PrimitiveType} to evaluate
	 * @return The first type if it is equal or an ancestor of the second one,
	 *         otherwise the nearest common ancestor if it exists or
	 *         <code>null</code> null otherwise.
	 */
	protected Type computeCommonType(PrimitiveType firstType,
			PrimitiveType secondType) {
		if (isEqualOrAncestor(firstType, secondType)) {
			return secondType;
		} else {
			// compute common ancestor, if exists
			PrimitiveType baseType = secondType;
			while (baseType != null) {
				if (isEqualOrAncestor(baseType, firstType)) {
					return baseType;
				}
				baseType = baseType.getBaseType();
			}
			return null;
		}
	}

	/**
	 * Checks whether the first given type is equal to or an ancestor of the
	 * second type within its base type hierarchy.
	 * 
	 * @param first
	 *            The first {@link PrimitiveType} to evaluate
	 * @param second
	 *            The second {@link PrimitiveType} to evaluate
	 * @return <code>true</code> if the first type is equal to or an ancestor of
	 *         the second type, <code>false</code> otherwise.
	 */
	private boolean isEqualOrAncestor(PrimitiveType firstType,
			PrimitiveType secondType) {
		PrimitiveType baseType = secondType;
		// iterate the base type hierarchy of the second type and see if the
		// first type can be found within
		while (baseType != null) {
			if (EcoreUtil.equals(firstType, baseType)) {
				return true;
			}
			baseType = secondType.getBaseType();
		}
		return false;
	}

	/**
	 * Returns the top-most type within the base type hierarchy of the given
	 * {@link PrimitiveType}.
	 * 
	 * @param primitiveType
	 *            The {@link PrimitiveType} whose base type is to be retrieved
	 * @return The top-most base type for the given {@link PrimitiveType}, or
	 *         the type itself if no base type is specified
	 */
	protected PrimitiveType getBaseType(PrimitiveType primitiveType) {
		PrimitiveType baseType = primitiveType;
		while (baseType.getBaseType() != null) {
			baseType = baseType.getBaseType();
		}
		return baseType;
	}

}