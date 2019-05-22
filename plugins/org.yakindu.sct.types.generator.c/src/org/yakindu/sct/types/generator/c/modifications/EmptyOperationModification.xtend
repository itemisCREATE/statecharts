package org.yakindu.sct.types.generator.c.modifications

import com.google.inject.Inject
import java.util.Collection
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.sct.types.generator.c.annotation.CoreCGeneratorAnnotationLibrary
import org.yakindu.sct.types.modification.IModification
import org.yakindu.sct.model.sexec.transformation.TypeBuilder

class EmptyOperationModification implements IModification{
	@Inject protected extension CoreCGeneratorAnnotationLibrary
	@Inject protected extension TypeBuilder
	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}
	
	def protected modify(Package p){
		val x = p.eAllContents.filter(Operation).filter[body === null].map[parameters].toList.flatten.toList
		x.forEach[param | 
			param._annotateWith(immutableTypeAnnotation)
		]
//		p.eAllContents.filter(Operation).filter[body === null].map[parameters].toList.flatten.toList.forEach[
//			_annotateWith(immutableTypeAnnotation)
//		]
		return p
	}
	
} 