package org.yakindu.sct.generator.java.features

import com.google.inject.Inject
import org.yakindu.base.types.Event
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.java.JavaNamingService
import org.yakindu.sct.generator.java.Naming
import org.yakindu.base.types.ComplexType

class OutEventObservables {
	
	@Inject extension ITypeSystem
	@Inject extension ICodegenTypeSystemAccess
	@Inject extension Naming
	@Inject extension JavaNamingService
	
	def getEventType(Event it) {
		if (hasValue) {
			val typeName = typeSpecifier.targetLanguageName
			return type instanceof ComplexType ? typeName : typeName.toFirstUpper
		}
		return "Void"
	}
	
	def hasValue(Event it) {
		type !== null && !type.isVoid
	}
	
	def getObservableGetterName(Event it) '''get«name.asName»Observable'''
	
	def getObservableName(Event it) '''«name.asIdentifier»Observable'''
	
	def getObserverName(Event shadowEvent) '''«shadowEvent.name»_observer'''
	
	def getObserverType(Event it) '''«observerClass»<«eventType»>'''
	
	def getObservableType(Event it) '''«observableClass»<«eventType»>'''
	
	def observableClass() {
		"Observable"
	}
	
	def observerClass() {
		"Observer"
	}
}