/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
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
