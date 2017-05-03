/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */

package org.yakindu.base.types.annotations;

import org.yakindu.base.types.AnnotatableElement;
import org.yakindu.base.types.Annotation;
import org.yakindu.base.types.AnnotationType;
import org.yakindu.base.types.TypesFactory;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Thomas Kutz - Initial contribution and API
 * 
 */

public class TypeAnnotations {

	private static final String INDEX_OPERATION = "IndexOperation";
	private static final String BUILT_IN_TYPE = "Built-In-Type";

	public AnnotationType createBuiltInTypeAnnotationType() {
		AnnotationType builtInAnnotation = TypesFactory.eINSTANCE.createAnnotationType();
		builtInAnnotation.setName(BUILT_IN_TYPE);
		return builtInAnnotation;
	}

	public boolean hasBuiltInTypeAnnotation(AnnotatableElement element) {
		return hasAnnotation(element, BUILT_IN_TYPE);
	}

	public AnnotationType createIndexOperationAnnotationType() {
		AnnotationType indexAnnotation = TypesFactory.eINSTANCE.createAnnotationType();
		indexAnnotation.setName(INDEX_OPERATION);
		return indexAnnotation;
	}

	public boolean hasIndexOperationAnnotation(AnnotatableElement element) {
		return hasAnnotation(element, INDEX_OPERATION);
	}

	public boolean hasAnnotation(final AnnotatableElement element, final String name) {
		return Iterables.any(element.getAnnotations(), new Predicate<Annotation>() {
			@Override
			public boolean apply(Annotation input) {
				return input.getType().getName().equals(name);
			}
		});
	}

}
