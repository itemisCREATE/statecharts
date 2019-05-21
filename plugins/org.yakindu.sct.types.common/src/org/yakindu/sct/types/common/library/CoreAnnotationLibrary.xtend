package org.yakindu.sct.types.common.library

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.AnnotatableElement
import org.yakindu.base.types.AnnotationType
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.expressions.util.ExpressionsHelper

@Singleton
class CoreAnnotationLibrary implements CoreAnnotationConstants {
	protected TypesFactory typesFactory = TypesFactory.eINSTANCE
	@Inject protected extension TypeBuilder 
	@Inject protected extension ExpressionsHelper 
	
	protected def isAnnotatedWith(AnnotatableElement it, String annotationName) {
		getAnnotationOfType(annotationName) !== null
	}
	
	protected def AnnotationType create typesFactory.createAnnotationType annotation(String name) {
		it.name = name
	}	
}
