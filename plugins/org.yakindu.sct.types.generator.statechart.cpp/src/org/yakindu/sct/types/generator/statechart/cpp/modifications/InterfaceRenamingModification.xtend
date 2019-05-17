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
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.sct.types.generator.statechart.cpp.naming.CppInterfaceNaming
import org.yakindu.sct.types.modification.IModification
import org.yakindu.sct.model.sequencer.types.IStatemachine
import org.yakindu.sct.model.sequencer.types.ICycleBasedMachine

class InterfaceRenamingModification implements IModification {

	@Inject protected extension CppInterfaceNaming

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.member.filter(ComplexType).map[superTypes].flatten.filter(TypeSpecifier).map[type].forEach[name = getName(name)]
		p
	}
	
	def getName(String name) {
		switch(name) {
			case IStatemachine.NAME: interfaceName
			case ICycleBasedMachine.NAME: cycleBasedInterfaceName
			default: name
		}
	}

}
