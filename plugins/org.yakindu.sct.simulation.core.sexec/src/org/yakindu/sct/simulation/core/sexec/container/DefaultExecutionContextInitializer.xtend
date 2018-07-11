/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.sexec.container

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Package
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.base.types.typesystem.ITypeValueProvider
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgraph.ImportDeclaration
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sruntime.CompositeSlot
import org.yakindu.sct.model.sruntime.ExecutionContext
import org.yakindu.sct.model.sruntime.ExecutionSlot
import org.yakindu.sct.model.sruntime.SRuntimeFactory
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.ImportScope
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class DefaultExecutionContextInitializer implements IExecutionContextInitializer {

	@Inject protected extension IQualifiedNameProvider
	@Inject protected extension ITypeSystem
	@Inject protected extension ITypeSystemInferrer
	@Inject protected extension ITypeValueProvider
	@Inject protected extension SExecExtensions

	extension SRuntimeFactory = SRuntimeFactory.eINSTANCE

	override initialize(ExecutionContext context, ExecutionFlow flow) {
		flow.scopes.forEach[context.slots += transform]
	}

	def create it : createCompositeSlot importSlot(ExecutionFlow flow) {
		it => [
			name = "imports"
		]
	}

	def dispatch ExecutionSlot transform(ImportScope scope) {

		val composite = importSlot(scope.flow)

		// retrieve namespaces from variable names and create corresponding composite slots
		for (Declaration decl : scope.declarations.filter(ImportDeclaration).map[declaration]) {
			val pkg = EcoreUtil2.getContainerOfType(decl, Package)
			if (pkg !== null) {
				val namespace = pkg.name
				val pkgHeader = pkg.fullyQualifiedName.lastSegment
				val declName = decl.name
				val slot = composite.slots.getSlotFor(pkgHeader)
				val declarationSlot = decl.transform
				declarationSlot.fqName = namespace + "." + declName
				declarationSlot.name = declName
				// only add imported variables/events when they have not yet been imported
				if (!slot.slots.exists[fqName == declarationSlot.fqName]) {
					slot.slots += declarationSlot
				}
			} else {
				composite.slots += decl.transform
			}
		}
		composite
	}

	def protected getSlotFor(List<ExecutionSlot> slots, String name) {
		val existingSlot = slots.findFirst[it.name == name]
		if (existingSlot instanceof CompositeSlot) {
			existingSlot
		} else
			createCompositeSlot => [ newSlot |
				newSlot.name = name
				slots += newSlot
			]
	}

	def dispatch ExecutionSlot transform(InternalScope scope) {
		createCompositeSlot => [
			name = "internal"
			scope.declarations.forEach[decl|it.slots += decl.transform]
		]
	}

	def dispatch ExecutionSlot transform(Scope scope) {
		createCompositeSlot => [
			name = "time events"
			scope.declarations.forEach[decl|slots += decl.transform]
		]
	}

	def dispatch ExecutionSlot transform(InterfaceScope scope) {
		val flow = EcoreUtil2.getContainerOfType(scope, ExecutionFlow)
		val namespace = (flow.sourceElement as Statechart).namespace
		createCompositeSlot => [
			if (scope.name !== null) {
				name = scope.name
				val scopeFqn = scope.fullyQualifiedName.toString
				fqName = if(namespace !== null) namespace + "." + scopeFqn else scopeFqn
			} else {
				name = "default"
			}
			scope.declarations.forEach[decl|slots += decl.transform]
		]
	}

	def dispatch ExecutionSlot transform(VariableDefinition variable) {
		createExecutionVariable => [
			name = variable.fullyQualifiedName.lastSegment
			fqName = variable.fullyQualifiedName.toString
			type = variable.infer.type
			value = it.type?.defaultValue
			writable = !variable.const
		]
	}

	def dispatch ExecutionSlot transform(EventDefinition event) {
		createExecutionEvent => [
			name = event.fullyQualifiedName.lastSegment
			fqName = event.fullyQualifiedName.toString
			type = event.type
			value = it.type?.defaultValue
			direction = Direction.get(event.direction.value)
		]
	}

	def dispatch ExecutionSlot transform(OperationDefinition op) {
		createExecutionOperation => [
			name = op.fullyQualifiedName.lastSegment
			fqName = op.fullyQualifiedName.toString
			type = if(op.type !== null) op.type else getType(ITypeSystem.VOID)
			value = it.type.defaultValue
		]
	}

	def dispatch ExecutionSlot transform(TimeEvent event) {
		createExecutionEvent => [
			name = event.fullyQualifiedName.lastSegment
			fqName = event.fullyQualifiedName.toString
			type = getType(ITypeSystem.INTEGER)
			value = type.defaultValue
		]
	}
}
