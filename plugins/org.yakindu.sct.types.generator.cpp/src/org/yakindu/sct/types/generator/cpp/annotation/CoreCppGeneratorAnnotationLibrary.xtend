package org.yakindu.sct.types.generator.cpp.annotation

import com.google.inject.Singleton
import org.yakindu.base.types.AnnotatableElement
import org.yakindu.sct.types.generator.annotation.CoreGeneratorAnnotationLibrary

@Singleton
class CoreCppGeneratorAnnotationLibrary extends CoreGeneratorAnnotationLibrary implements CoreCppGeneratorAnnotationConstants {
	
	def virtualAnnotation() {
		annotation(VIRTUAL)
	}
	
	def isVirtual(AnnotatableElement it) {
		isAnnotatedWith(VIRTUAL)
	}
	
	def defaultConstructorAnnotation() {
		annotation(DEFAULT_CONSTRUCTOR)
	}
	
	def isDefaultConstructor(AnnotatableElement it) {
		isAnnotatedWith(DEFAULT_CONSTRUCTOR)
	}
	
	
	def defaultDestructorAnnotation() {
		annotation(DEFAULT_DESTRUCTOR)
	}
	
	def isDefaultDestructor(AnnotatableElement it) {
		isAnnotatedWith(DEFAULT_DESTRUCTOR)
	}
	
	def innerConstructorAnnotation() {
		annotation(INNER_CONSTRUCTOR)
	}
	
	def isInnerConstructor(AnnotatableElement it) {
		isAnnotatedWith(INNER_CONSTRUCTOR)
	}
	
	def ocbDestructorAnnotation() {
		annotation(OCB_DESTRUCTOR)
	}
	
	def isOcbDestructor(AnnotatableElement it) {
		isAnnotatedWith(OCB_DESTRUCTOR)
	}
}