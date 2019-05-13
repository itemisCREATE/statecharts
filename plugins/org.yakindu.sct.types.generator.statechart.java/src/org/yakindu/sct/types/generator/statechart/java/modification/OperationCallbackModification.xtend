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
import org.yakindu.base.expressions.util.ComplexTypeNavigationExtensions
import org.yakindu.base.expressions.util.ContainmentExtensions
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.expressions.util.PackageNavigationExtensions
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.Visibility
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sequencer.ModelSequencerNaming
import org.yakindu.sct.types.generator.java.modifications.ConstructorBuilder
import org.yakindu.sct.types.generator.modification.library.ReferenceExtension
import org.yakindu.sct.types.generator.statechart.annotation.SCTGeneratorAnnotationLibrary
import org.yakindu.sct.types.generator.statechart.java.naming.JavaOCBNaming
import org.yakindu.sct.types.modification.IModification

/**
 * Creates callback interfaces for operation declarations, corresponding setters, and qualifies operation calls.
 * 
 * Depends on {@link InterfaceLiftingModification} to be executed before.
 */
class OperationCallbackModification implements IModification {

	@Inject protected extension PackageNavigationExtensions
	@Inject protected extension ComplexTypeNavigationExtensions
	@Inject protected extension ExpressionBuilder
	@Inject protected extension TypeBuilder
	@Inject protected extension ModelSequencerNaming
	@Inject protected extension ContainmentExtensions
	@Inject protected extension ReferenceExtension
	@Inject protected extension ConstructorBuilder

	@Inject protected extension JavaOCBNaming
	
	@Inject protected extension InterfaceLiftingModification
	@Inject protected extension SCTGeneratorAnnotationLibrary
	
	
	
	extension TypesFactory factory = TypesFactory.eINSTANCE

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.allTopLevelComplexTypes.filter[!abstract].forEach [ ct |
			
			// interface OCB
			val interfaceTypes = ct.interfaceGroupTypes
			interfaceTypes.forEach[ iType |
				val ops = iType.operationDeclarations
				if (!ops.empty) {
					// create operation callback interface
					val ocbInterface = iType.createOCBInterface
					ct.statemachineInterfaceType.add(ocbInterface)
					// add OCB setter declaration
					iType.interfaceType.add(ocbInterface.createOCBSetter)
					// add OCB property
					val ocbProp = ocbInterface.createOCBProperty
					iType.add(ocbProp)
					// add OCB setter definition
					iType.add(createOCBSetterImpl(ocbInterface, ocbProp))

					// move operations to OCB interface and qualify calls
					ops.forEach[ op |
						ocbInterface.add(op)
						op.references.forEach[qualifyWith(ocbProp)]
					]
				}
			]
			
			// internal OCB
			val ops = ct.operationDeclarations
			if (!ops.empty) {
				// create operation callback interface
				val ocbInterface = ct.createInternalOCBInterface
				ct.statemachineInterfaceType.add(ocbInterface)
				// add OCB setter declaration
				ct.statemachineInterfaceType.add(ocbInterface.createOCBSetter)
				// add OCB property
				val ocbProp = ocbInterface.createOCBProperty
				ct.add(ocbProp)
				// add OCB setter definition
				ct.add(createOCBSetterImpl(ocbInterface, ocbProp))
				
				// move operations to OCB interface and qualify calls
				ops.forEach[ op |
					op.visibility = Visibility.PUBLIC
					ocbInterface.add(op)
					op.references.forEach[qualifyWith(ocbProp)]
				]
			}
			
		]
		p
	}
	
	protected def getOperationDeclarations(ComplexType ct) {
		ct.features.filter(Operation).filter[body === null].filter[!isConstructor].toList
	}
	
	protected def createOCBInterface(ComplexType ct) {
		createComplexType => [ 
			name = ct.interfaceType.nameOperationCallback
			abstract = true
		]
	}
	
	protected def createInternalOCBInterface(ComplexType ct) {
		createComplexType => [ 
			name = nameInternalOperationCallback
			abstract = true
		]
	}
	
	protected def createOCBSetter(ComplexType ocbInterface) {
		_op(ocbInterface.nameOperationCallbackSetter, ITypeSystem.VOID)._param("operationCallback", ocbInterface)
	}

	protected def createOCBProperty(ComplexType ocbInterface) {
		_variable(ocbInterface.nameOperationCallbackProperty, ocbInterface) => [visibility = Visibility.PROTECTED]
	}

	protected def createOCBSetterImpl(ComplexType ocbInterface, Property ocbProp) {
		_op(ocbInterface.nameOperationCallbackSetter, ITypeSystem.VOID)._param("operationCallback", ocbInterface) => [
			body = _block(
				ocbProp._ref._assign(parameters.head._ref)
			)
		]
	}
	
	protected def getInternalGroupType(ComplexType ct) {
		ct.allComplexTypes.filter[visibility == Visibility.PROTECTED].filter[isInterfaceGroup].head
	}

}
