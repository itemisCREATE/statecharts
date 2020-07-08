/** 
 * Copyright (c) 2016 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/

package org.yakindu.sct.simulation.core.sexec.container

import java.util.Stack
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.GenericElement
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypeParameter
import org.yakindu.base.types.inferrer.ITypeSystemInferrer.InferenceResult
import org.yakindu.sct.model.sruntime.ExecutionSlot
import org.yakindu.sct.model.sruntime.SRuntimeFactory
import org.yakindu.sct.model.stext.stext.VariableDefinition

import static org.yakindu.base.types.typesystem.ITypeSystem.ANY
import org.yakindu.sct.model.stext.stext.OperationDefinition

/**
 * Execution context initializer which recursively builds composite slots for variables with complex types.
 * 
 * @author Thomas Kutz - Initial contribution and API
 */

class ComplexTypeAwareContextInitializer extends DefaultExecutionContextInitializer {

	protected extension SRuntimeFactory factory = SRuntimeFactory.eINSTANCE
	
	/**
	 * Stores names of hierarchically complex typed variables for proper computation of full qualified names.
	 */
	protected Stack<String> nameStack = new Stack()

	override dispatch ExecutionSlot create createExecutionSlotFor(variable) transform(VariableDefinition variable) {
		it.writable = it.writable && !variable.const
	}
	
	override dispatch ExecutionSlot create createExecutionSlotFor(op) transform(OperationDefinition op) {}

	/**
	 * Do not use <code>create</code> here because properties within complex types are the same for multiple variables 
	 * of same complex type
	 */
	override dispatch ExecutionSlot transform(Property prop) {
		val slot = createExecutionSlotFor(prop)
		slot.writable = slot.writable && !prop.const
		slot
	}

	override dispatch ExecutionSlot transform(Operation op) {
		val slot = createExecutionSlotFor(op)
		slot
	}

	def ExecutionSlot createExecutionSlotFor(Declaration element) {
		val inferenceResult = element.infer
		val varType = inferenceResult.type

		transformByType(varType, element, inferenceResult)
	}

	def protected dispatch ExecutionSlot transformByType(ComplexType type, Declaration element,
		InferenceResult inferenceResult) {
		createCompositeSlot => [
			it.type = type
			it.init(element)
			nameStack.push(it.fqName)
			for (feature : type.features) {
				val featureType = feature.infer.type
				val featureSlot = transformByType(featureType, feature, inferenceResult)
				it.slots += featureSlot
				nameStack.push(featureSlot.name)
				featureSlot.fqName = nameStack.join(".")
				nameStack.pop
			}
			nameStack.pop
		]
	}

	def protected dispatch ExecutionSlot transformByType(TypeParameter type, Declaration element,
		InferenceResult inferenceResult) {
		val typeParameterInferenceResult = inferTypeParameter(type, inferenceResult)
		val inferred = typeParameterInferenceResult.type
		if (!(inferred instanceof TypeParameter)) {
			return transformByType(inferred, element, typeParameterInferenceResult)
		} else {
			return createExecutionVariable => [
				it.name = element.fullyQualifiedName.lastSegment
				it.fqName = element.fullyQualifiedName.toString
				it.type = inferred
				it.value = null
			]
		}
	}
	
	def protected dispatch ExecutionSlot transformByType(EnumerationType type, Declaration element,
		InferenceResult inferenceResult) {
		createExecutionVariable => [
			it.type = type
			it.init(element)
		]
	}

	def protected dispatch ExecutionSlot transformByType(Type type, Declaration element,
		InferenceResult inferenceResult) {
		createExecutionVariable => [
			it.type = type
			it.init(element)
		]
	}

	// copied from ExpressionsTypeInferrer
	def protected inferTypeParameter(TypeParameter typeParameter, InferenceResult ownerResult) {
		if (ownerResult.bindings.isEmpty() || !(ownerResult.type instanceof GenericElement)) {
			return InferenceResult.from(ANY.type)
		} else {
			val index = (ownerResult.type as GenericElement).typeParameters.indexOf(typeParameter)
			return InferenceResult.from(ownerResult.bindings.get(index).type, ownerResult.bindings.get(index).bindings)
		}
	}

	def protected init(ExecutionSlot it, Declaration variable) {
		name = variable.fullyQualifiedName.lastSegment
		fqName = variable.fullyQualifiedName.toString
		value = initialValue(type, variable)
	}

	def protected initialValue(Type slotType, Declaration variable) {
		val PropertyInitialValueAdapter adapter = EcoreUtil.getExistingAdapter(variable,
			PropertyInitialValueAdapter) as PropertyInitialValueAdapter
		return adapter?.initialValue?.value ?: slotType?.defaultValue
	}

	def value(Object it) {
		it
	}

}
