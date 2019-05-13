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
import com.google.inject.Singleton
import java.util.Collection
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.expressions.util.ComplexTypeNavigationExtensions
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.expressions.util.PackageNavigationExtensions
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.Visibility
import org.yakindu.sct.model.sequencer.ModelSequencerNaming
import org.yakindu.sct.model.sequencer.types.IStatemachine
import org.yakindu.sct.types.generator.modification.library.ModificationHelper
import org.yakindu.sct.types.generator.statechart.annotation.SCTGeneratorAnnotationLibrary
import org.yakindu.sct.types.modification.IModification

/**
 * Extract a statechart interface which contains inner interfaces for all types annotated with "InterfaceGroup" as well as getters for them.
 * 
 */
@Singleton
class InterfaceLiftingModification implements IModification {
	
	@Inject protected extension PackageNavigationExtensions
	@Inject protected extension ComplexTypeNavigationExtensions
	@Inject protected extension ExpressionBuilder
	@Inject protected extension ModelSequencerNaming
	@Inject protected extension ModificationHelper
	@Inject protected extension SCTGeneratorAnnotationLibrary
	
	extension TypesFactory factory = TypesFactory.eINSTANCE
	
	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.allTopLevelComplexTypes.forEach [ ct |
			
			val outerInterface = ct.statemachineInterfaceType
			p.member += outerInterface
			
			// switch supertype chain to be: statemachine -> statemachine interface -> base interface
			ct.superTypes += createTypeSpecifier => [type = outerInterface]
			val baseInterface = ct.superTypes.findFirst[type.name == IStatemachine.NAME]
			outerInterface.superTypes += createTypeSpecifier => [type = baseInterface.type]
			ct.superTypes -= baseInterface
			
			val typesToLift = ct.interfaceGroupTypes
			
			typesToLift.forEach [ t |
				val innerInterface = t.interfaceType
				outerInterface.features += innerInterface
				t.superTypes += createTypeSpecifier => [type = innerInterface]
				
				outerInterface.features += innerInterface.getter
				ct.features += ct.getInterfaceProperty(t)?.interfaceGetter
				
				t.name = innerInterface.name + "Impl"
			]
		]
		return p
	}
	
	def getInterfaceGroupTypes(ComplexType ct) {
		ct.allComplexTypes.filter[visibility == Visibility.PUBLIC].filter[isInterfaceGroup]
	}

	protected def getterName(ComplexType type) {
		return  "get" + type.name.toFirstUpper
	}
	protected def create createOperation getter(ComplexType type) {
		name = type.getterName
		typeSpecifier = createTypeSpecifier => [it.type = type]
	}
	
	def create createComplexType statemachineInterfaceType(ComplexType ct) {
		name = "I" + ct.name
		abstract = true
	}

	def create createComplexType interfaceType(ComplexType ct) {
		name = ct.statemachineInterfaceName
		abstract = true
		// copy public operations without body
		features += ct.features.filter[visibility == Visibility.PUBLIC].filter(Operation).filter[body !== null].map [
			val op = EcoreUtil.copy(it)
			op.body = null
			op
		]
	}

	protected def getInterfaceProperty(ComplexType ct, ComplexType iface) {
		ct.publicProperties.findFirst[type == iface]
	}
	
	protected def create createOperation interfaceGetter(Property ifaceProp) {
		val ifaceType = (ifaceProp.type as ComplexType).interfaceType
		name = interfaceGetterName(ifaceType)
		typeSpecifier = createTypeSpecifier => [it.type = ifaceType]
		body = _block(_return(ifaceProp._ref))
	}
	
	protected def String interfaceGetterName(ComplexType ifaceType) {
		return "get" + ifaceType.name
	}
	
}
