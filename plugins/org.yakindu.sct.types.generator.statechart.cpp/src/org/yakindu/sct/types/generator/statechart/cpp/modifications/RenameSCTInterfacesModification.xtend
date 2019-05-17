/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator.statechart.cpp.modifications

import com.google.inject.Inject
import java.util.Collection
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.base.types.Visibility
import org.yakindu.sct.types.generator.statechart.cpp.naming.CppInterfaceNaming
import org.yakindu.sct.types.modification.IModification

class RenameSCTInterfacesModification implements IModification {

	@Inject protected extension CppInterfaceNaming

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.member.head.eAllContents.filter(ComplexType).toList.forEach [ cT |
			if (cT.name == SCInterface) {
				p.eAllContents.filter(Property).filter[name == SCIInterfaceVariable].forEach [ prop |
					prop.name = ifaceVariable
					prop.visibility = Visibility.PROTECTED
				]
				cT.name = defaultSCI
			} else if (cT.name == SCInternal) {
				p.eAllContents.filter(Property).filter[name == SCIInternalVariable].forEach [ prop |
					prop.name = ifaceVariable + internalSCI
					prop.visibility = Visibility.PROTECTED
				]
				cT.name = internalSCI
			} else {
				p.eAllContents.filter(Property).filter[name == cT.name.toFirstLower].forEach [ prop |
					prop.name = ifaceVariable + cT.name
					prop.visibility = Visibility.PROTECTED
				]
				// TODO: Could be removed with 4.0. Used to keep API. For example: Interface named: .. and Interface Named: will currently not work, but could without 'toFirstUpper'
				cT.name = SCIPrefix + cT.name.toFirstUpper
			}
		]
		p.eAllContents.filter(ComplexType).filter[name == SCInterface].forEach [ cT |
			cT.name = defaultSCI
		]
		p
	}

}
