/**
 * Copyright (c) 2013 committers of YAKINDU and others.
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
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.ITypeSystem.InferredType
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.stext.types.ISTextTypeInferrer
import org.yakindu.sct.model.stext.types.ISTextTypeSystem
import org.yakindu.sct.simulation.core.sruntime.EventDirection
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext
import org.yakindu.sct.simulation.core.sruntime.impl.ExecutionEventImpl
import org.yakindu.sct.simulation.core.sruntime.impl.ExecutionVariableImpl

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class DefaultExecutionContextInitializer implements IExecutionContextInitializer {

	@Inject extension IQualifiedNameProvider
	@Inject extension ISTextTypeSystem
	@Inject extension ISTextTypeInferrer

	override initialize(ExecutionContext context, ExecutionFlow flow) {
		flow.scopes.forEach[declarations.forEach[context.slots += it.transform]]
	}

	def dispatch create new ExecutionVariableImpl() transform(VariableDefinition variable) {
		var qualifiedName = variable.fullyQualifiedName
		qualifiedName.segments
		it.name = variable.fullyQualifiedName.toString
		it.type = variable.inferType.type
		it.value = it.type.defaultValue
	}

	def dispatch create new ExecutionEventImpl() transform(EventDefinition event) {
		it.name = event.fullyQualifiedName.toString
		it.type = event.inferType.type
		it.value = it.type.defaultValue
		it.direction = EventDirection.get(event.direction.value)
	}

	def dispatch create new ExecutionVariableImpl() transform(OperationDefinition op) {
		it.name = op.fullyQualifiedName.toString
		it.type = new InferredType(op.type)
		it.value = it.type.defaultValue
	}

	def dispatch create new ExecutionEventImpl() transform(TimeEvent event) {
		it.name = event.fullyQualifiedName.toString
		it.type = new InferredType(integerType)
		it.value = defaultValue(it.type)
	}

	def Object defaultValue(InferredType type) {
		switch (type) {
			case isBooleanType(type): true
			case isIntegerType(type): 0
			case isRealType(type): 0.0
			case isVoidType(type): null
			case isStringType(type): ""
			case type instanceof EnumerationType: (type as EnumerationType).enumerator.head
			default: null
		}
	}

}
