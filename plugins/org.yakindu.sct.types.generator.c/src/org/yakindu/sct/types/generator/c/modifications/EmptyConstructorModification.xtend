package org.yakindu.sct.types.generator.c.modifications

import org.yakindu.sct.types.modification.IModification
import java.util.Collection
import org.yakindu.base.types.Package
import org.yakindu.base.types.Constructor
import org.eclipse.emf.ecore.util.EcoreUtil

class EmptyConstructorModification implements IModification{
	
	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}
	
	def modify(Package p){
		p.eAllContents.filter(Constructor).filter[body === null].toList.forEach[
			EcoreUtil.remove(it)
		]
		return p
	}
	
}