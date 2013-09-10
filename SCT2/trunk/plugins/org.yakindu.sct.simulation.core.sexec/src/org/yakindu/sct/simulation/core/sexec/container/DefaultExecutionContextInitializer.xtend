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
import org.yakindu.sct.simulation.core.sruntime.impl.CompositeSlotImpl
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.sgraph.Scope

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
		flow.scopes.forEach[context.slots += transform]
		print("")
	}
	
	def dispatch create new CompositeSlotImpl() transform(InternalScope scope){
		it.name = "internal"
		scope.declarations.forEach[decl | it.slots += decl.transform]
	}
	
	def dispatch create new CompositeSlotImpl() transform(Scope scope){
		it.name = "time events"
		scope.declarations.forEach[decl | it.slots += decl.transform]
	}
	
	def dispatch create new CompositeSlotImpl() transform(InterfaceScope scope){
		if(scope.name != null) it.name = scope.name else it.name = "default" 
		scope.declarations.forEach[decl | it.slots += decl.transform]
	}
	
	def dispatch create new ExecutionVariableImpl() transform(VariableDefinition variable) {
		it.name = variable.fullyQualifiedName.lastSegment
		it.fqName = variable.fullyQualifiedName.toString
		it.type = variable.inferType.type
		it.value = it.type.defaultValue
	}

	def dispatch create new ExecutionEventImpl() transform(EventDefinition event) {
		it.name = event.fullyQualifiedName.lastSegment
		it.fqName = event.fullyQualifiedName.toString
		it.type = event.inferType.type
		it.value = it.type.defaultValue
		it.direction = EventDirection.get(event.direction.value)
	}

	def dispatch create new ExecutionVariableImpl() transform(OperationDefinition op) {
		it.name = op.fullyQualifiedName.lastSegment
		it.fqName = op.fullyQualifiedName.toString
		it.type = new InferredType(op.type)
		it.value = it.type.defaultValue
	}

	def dispatch create new ExecutionEventImpl() transform(TimeEvent event) {
		it.name = event.fullyQualifiedName.lastSegment
		it.name = event.fullyQualifiedName.toString
		it.type = new InferredType(integerType)
		it.value = defaultValue(it.type)
	}
}
