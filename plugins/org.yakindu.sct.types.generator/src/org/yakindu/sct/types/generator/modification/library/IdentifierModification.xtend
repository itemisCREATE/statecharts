/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	itemis AG
*
*/
package org.yakindu.sct.types.generator.modification.library

import com.google.inject.Inject
import java.util.Collection
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Package
import org.yakindu.sct.types.generator.ITargetPlatform
import org.yakindu.sct.types.modification.IModification

class IdentifierModification implements IModification{
	
	@Inject extension ITargetPlatform
	
	var protected char separator = '_'
	
	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.eAllContents.filter(Declaration).forEach[ decl | 
			decl.name = decl.name.asIdentifier
			if(languageKeywords.contains(decl.name)) {
				decl.name = "_" + decl.name
			}
		]
		p
	}
	
	def protected asIdentifier(String string) {
		string?.replaceAll('[[^a-z]&&[^A-Z]&&[^0-9]]', separator.toString)
	}
}
