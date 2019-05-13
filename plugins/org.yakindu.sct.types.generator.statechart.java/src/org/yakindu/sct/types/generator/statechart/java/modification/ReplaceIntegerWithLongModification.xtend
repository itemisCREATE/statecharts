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
package org.yakindu.sct.types.generator.statechart.java.modification

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.types.modification.IModification

/**
 * To be compatible with old API, properties and operations inside of statemachine interfaces of type integer are converted to type long.
 * 
 * TODO: delete if we decide to use int type in interface properties
 * 
 */
class ReplaceIntegerWithLongModification implements IModification {
	
	protected TypesFactory factory = TypesFactory.eINSTANCE
	@Inject protected ITypeSystem ts
	
	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.eAllContents.filter(Property).filter[containedInInterface].filter[type == ts.getType(ITypeSystem.INTEGER)].forEach [
			it.typeSpecifier.type = factory.createPrimitiveType => [ name = "long" ]
		]
		p.eAllContents.filter(Operation).filter[containedInInterface].map[parameters].toList.flatten.filter[type == ts.getType(ITypeSystem.INTEGER)].forEach [
			it.typeSpecifier.type = factory.createPrimitiveType => [ name = "long" ]
		]
		p.eAllContents.filter(Operation).filter[containedInInterface].filter[type == ts.getType(ITypeSystem.INTEGER)].forEach [
			it.typeSpecifier.type = factory.createPrimitiveType => [ name = "long" ]
		]
		p
	}
	
	def containedInInterface(Declaration p) {
		EcoreUtil2.getContainerOfType(p, ComplexType).getAnnotationOfType("InterfaceGroup") !== null
	}
	
}
