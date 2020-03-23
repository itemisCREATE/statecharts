/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.sexec.interpreter

import com.google.common.collect.Maps
import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.Map
import java.util.Optional
import org.eclipse.debug.core.DebugException
import org.eclipse.debug.core.ILaunch
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.base.NamedElement
import org.yakindu.base.expressions.expressions.ArgumentExpression
import org.yakindu.base.expressions.util.ExpressionExtensions
import org.yakindu.sct.model.sruntime.ExecutionContext
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.simulation.core.engine.ISimulationEngine
import org.yakindu.sct.simulation.core.sexec.container.AbstractExecutionFlowSimulationEngine

/**
 * 
 * @author andreas muelder - Initial contribution and API 
 * @author thomas kutz - additions
 * 
 */
@Singleton
class SubchartInterpreterProvider {

	@Inject(optional=true) ILaunch launch
	@Inject extension ExpressionExtensions

	Map<VariableDefinition, IExecutionFlowInterpreter> submachineInterpreterMap = Maps::newHashMap()
	Map<ExecutionContext, IExecutionFlowInterpreter> contextInterpreterMap = Maps::newHashMap()

	def void setInterpreterMap(Map<VariableDefinition, IExecutionFlowInterpreter> map) {
		this.submachineInterpreterMap = map
	}

	def void setContextInterpreterMap(Map<ExecutionContext, IExecutionFlowInterpreter> map) {
		this.contextInterpreterMap = map
	}

	def Optional<IExecutionFlowInterpreter> findInterpreter(ExecutionContext context) {
		if (contextInterpreterMap.containsKey(context)) {
			return Optional::of(contextInterpreterMap.get(context))
		}

		val foundInterpreter = launch.debugTargets.map[it.getAdapter(typeof(ISimulationEngine))].filter(AbstractExecutionFlowSimulationEngine).
			map[it.interpreter].findFirst[it.executionContext == context]
			
		if (foundInterpreter !== null) {
			return Optional::of(foundInterpreter)
		}
		return Optional::empty()
	}

	def findInterpreter(ArgumentExpression expression, ExecutionContext context) {
		var EObject owner = findSubmachineMember(expression)
		if(owner === null) return Optional::empty()
		
		// first: check the provided map
		for (VariableDefinition variableDefinition : submachineInterpreterMap.keySet()) {
			if (EcoreUtil::equals(variableDefinition, owner)) {
				return Optional::of(submachineInterpreterMap.get(variableDefinition))
			}
		}
		// second: check the existing debug targets
		val target = findDebugTarget(expression, context)
		if (target !== null) {
			val engine = target.getAdapter(typeof(ISimulationEngine))
			if (engine instanceof AbstractExecutionFlowSimulationEngine) {
				return Optional::of(engine.getInterpreter())
			}
		}
		return Optional::empty()
	}

	def protected VariableDefinition findSubmachineMember(ArgumentExpression expression) {
		val callStack = expression.toCallStack
		callStack.remove(callStack.size() - 1)
		return callStack.reverse.map[featureOrReference].filter(VariableDefinition).head
	}

	def protected findDebugTarget(ArgumentExpression expression, ExecutionContext context) {
		val owner = findSubmachineMember(expression) as VariableDefinition
		val callStack = expression.toCallStack
		callStack.remove(callStack.size() - 1)
		
		val fqn = callStack.map[featureOrReference].filter(NamedElement).map[name].toList
		val prefix = if (context.contextFqn !== null) context.fqName else ""
		val name = '''«prefix»«fqn.join(".")» : «owner.type.name»'''
		
		return launch.debugTargets.filter[t | try t.name == name catch(DebugException e) false].head
	}
}
