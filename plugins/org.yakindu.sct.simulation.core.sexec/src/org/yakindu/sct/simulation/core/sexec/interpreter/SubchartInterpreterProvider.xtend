package org.yakindu.sct.simulation.core.sexec.interpreter

import com.google.common.collect.Maps
import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.Arrays
import java.util.List
import java.util.Map
import java.util.Optional
import org.eclipse.debug.core.DebugException
import org.eclipse.debug.core.ILaunch
import org.eclipse.debug.core.model.IDebugTarget
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.base.NamedElement
import org.yakindu.base.expressions.expressions.ArgumentExpression
import org.yakindu.base.expressions.util.ExpressionExtensions
import org.yakindu.base.types.TypedDeclaration
import org.yakindu.sct.model.sruntime.ExecutionContext
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugTarget
import org.yakindu.sct.simulation.core.engine.ISimulationEngine
import org.yakindu.sct.simulation.core.sexec.container.AbstractExecutionFlowSimulationEngine

@Singleton
class SubchartInterpreterProvider {

	@Inject(optional=true) ILaunch launch
	@Inject extension ExpressionExtensions

	package Map<VariableDefinition, IExecutionFlowInterpreter> submachineInterpreterMap = Maps::newHashMap()
	package Map<ExecutionContext, IExecutionFlowInterpreter> contextInterpreterMap = Maps::newHashMap()

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

	def protected Optional<IExecutionFlowInterpreter> findInterpreter(ArgumentExpression expression,
		ExecutionContext context) {
		var EObject owner = getSubmachineMember(expression)
		if(owner === null) return Optional::empty()
		
		// first: check the provided map
		for (VariableDefinition variableDefinition : submachineInterpreterMap.keySet()) {
			if (EcoreUtil::equals(variableDefinition, owner)) {
				return Optional::of(submachineInterpreterMap.get(variableDefinition))
			}
		}
		// second: check the existing debug targets
		var Optional<IDebugTarget> target = findDebugTarget(expression, context)
		if (target.isPresent()) {
			var SCTDebugTarget debugTarget = (target.get() as SCTDebugTarget)
			var AbstractExecutionFlowSimulationEngine engine = (debugTarget.getAdapter(
				typeof(ISimulationEngine)) as AbstractExecutionFlowSimulationEngine)
			return Optional::of(engine.getInterpreter())
		}
		return Optional::empty()
	}

	def protected VariableDefinition getSubmachineMember(ArgumentExpression expression) {
		var List<ArgumentExpression> callStack = expression.toCallStack
		callStack.remove(callStack.size() - 1)
		return callStack.reverse.map[featureOrReference].filter(VariableDefinition).head
	}

	def protected Optional<IDebugTarget> findDebugTarget(ArgumentExpression expression, ExecutionContext context) {
		var TypedDeclaration owner = (getSubmachineMember(expression) as TypedDeclaration)
		var List<ArgumentExpression> callStack = expression.toCallStack
		callStack.remove(callStack.size() - 1)
		
		var List<String> fqn = callStack.map[featureOrReference].filter(NamedElement).map[name].toList
		var String prefix = ""
		if (context.getContextFqn() !== null) {
			prefix = '''«context.getFqName()».'''.toString
		}
		val String name = '''«prefix»«String::join(".", fqn)» : «owner.getType().getName()»'''.toString
		return Arrays::stream(launch.getDebugTargets()).filter([ target |
			{
				try {
					return target.getName().equals(name)
				} catch (DebugException e) {
					return false
				}

			}
		]).findFirst()
	}
}
