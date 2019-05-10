package org.yakindu.sct.types.generator.modification.library

import java.util.Collection
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.types.Package
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.sct.model.stext.stext.TypeAliasDefinition
import org.yakindu.sct.types.modification.IModification

class AliasReplacementModification implements IModification {

		override modify(Collection<Package> packages) {
			packages.forEach[modify]
			packages
		}
	
		def modify(Package p) {
		p.eAllContents.filter(TypeSpecifier).filter[type instanceof TypeAliasDefinition].toList.forEach [ typeSpec |
			val alias = typeSpec.type as TypeAliasDefinition
			typeSpec.type = alias.originType
		]
		p.eAllContents.filter(TypeAliasDefinition).toList.forEach [ alias |
			EcoreUtil.remove(alias)
		]

		return p
	}

}
