package org.yakindu.base.types.annotations;

import org.yakindu.base.types.AnnotatableElement;
import org.yakindu.base.types.Annotation;
import org.yakindu.base.types.TypesFactory;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class TypeAnnotations {
	
	private static final String INDEX_OPERATION = "IndexOperation";
	private static final String BUILT_IN_TYPE = "Built-In-Type";

	public static Annotation createBuiltInTypeAnnotation() {
		Annotation builtInAnnotation = TypesFactory.eINSTANCE.createAnnotation();
		builtInAnnotation.setName(BUILT_IN_TYPE);
		return builtInAnnotation;
	}
	
	public static boolean hasBuiltInTypeAnnotation(AnnotatableElement element) {
		return hasAnnotation(element, BUILT_IN_TYPE);
	}
	
	public static Annotation createIndexOperationAnnotation() {
		Annotation indexAnnotation = TypesFactory.eINSTANCE.createAnnotation();
		indexAnnotation.setName(INDEX_OPERATION);
		return indexAnnotation;
	}
	
	public static boolean hasIndexOperationAnnotation(AnnotatableElement element) {
		return hasAnnotation(element, INDEX_OPERATION);
	}

	public static boolean hasAnnotation(final AnnotatableElement element, final String name) {
		return Iterables.any(element.getAnnotations(), new Predicate<Annotation>() {
			@Override
			public boolean apply(Annotation input) {
				return input.getName().equals(name);
			}
		});
	}
	
}
