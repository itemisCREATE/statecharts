/*
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: DerivedUnionEObjectEList.java,v 1.6 2007/04/04 03:15:12 khussey Exp $
 */
package org.eclipselabs.mscript.typesystem.internal.util;

import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * A derived list representing a union of all the elements from its source
 * features. This list is ideal for implementing derived union features.
 * 
 * @since 1.2
 */
public class DerivedUnionEObjectEList<E>
		extends DerivedEObjectEList<E> {

	public DerivedUnionEObjectEList(Class<?> dataClass, InternalEObject owner,
			int featureID, int[] sourceFeatureIDs) {
		super(dataClass, owner, featureID, sourceFeatureIDs);
	}

	@Override
	public List<E> basicList() {
		return new DerivedUnionEObjectEList<E>(dataClass, owner, featureID,
			sourceFeatureIDs) {

			@Override
			public ListIterator<E> listIterator(int index) {
				return basicListIterator(index);
			}
		};
	}

	@Override
	protected boolean isIncluded(EStructuralFeature feature) {
		return true;
	}

}
