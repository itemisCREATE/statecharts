/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.java

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.base.NamedElement
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Enumerator
import org.yakindu.base.types.Event
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.base.types.Type
import org.yakindu.base.types.adapter.OriginTracing
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.concepts.ShadowMemberScope
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.naming.StextNameProvider
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope

import static extension org.eclipse.xtext.EcoreUtil2.*

class Naming {

	@Inject extension JavaNamingService
	@Inject extension SExecExtensions
	@Inject extension OriginTracing
	@Inject extension ShadowMemberScope
	@Inject extension GenmodelEntries
	@Inject extension StextNameProvider

	@Inject GeneratorEntry entry
	
	def iStatemachine() {
		"IStatemachine"
	}

	def iTimerCallback() {
		"ITimerCallback"
	}

	def iTimer() {
		"ITimer"
	}

	def timerServiceClass() {
		"TimerService"
	}

	def timeEventClass() {
		"TimeEvent"
	}

	def runtimeServiceClass() {
		"RuntimeService"
	}
	
	def java(String it) {
		it + ".java"
	}

	def asPrivate(String it) {
		"private " + it
	}

	def asPublic(String it) {
		"public " + it
	}

	def String getInternalOperationCallbackName(InternalScope it) {
		"InternalOperationCallback"
	}
	
	def traceInterface() {
		"ITracingListener"
	}
	
	def traceAccessorFunctionID() {
		"traceObserver"
	}
	
	def traceSingleInstance() {
		"ifaceTraceObserver"
	}
	
	def traceInstances() {
		"ifaceTraceObservers"
	}
	
	def stateEnteredTraceFunctionID() {
		"onStateEntered"
	}
	
	def stateExitedTraceFunctionID() {
		"onStateExited"
	}

	def String statemachineName(String name) {
		var String newName = name.replace(" ", "")
		if (name.isKeyword) {
			return newName + "SM"
		}
		return newName
	}

	def statemachineClassName(NamedElement it) {
		entry.typeName ?: name.statemachineName
	}

	def statemachineInterfaceName(NamedElement it) {
		"I" + statemachineClassName
	}

	def dispatch identifier(Property it) { escaped.asIdentifier }
	def dispatch identifier(Event it) { escaped.asIdentifier }
	def dispatch identifier(Method it) { shortName }
	def dispatch identifier(Operation it) { name }
	def dispatch identifier(Enumerator it) { name }
	def dispatch identifier(Declaration it){ shortName }

	def String getValueIdentifier(Event it) {
		name.asIdentifier + "Value"
	}
	
	def String getInterfaceImplName(InterfaceScope it) {
		interfaceName + "Impl"
	}

	def String getInterfaceListenerName(InterfaceScope it) {
		interfaceName + "Listener"
	}

	def String getInterfaceOperationCallbackName(InterfaceScope it) {
		interfaceName + "OperationCallback"
	}

	def dispatch String stateName(RegularState state) {
		val statechart = state.getContainerOfType(Statechart)
		val statechartFqn = statechart.fullyQualifiedName
		val stateFqn = state.fullyQualifiedName
		
		val trimmedFqn = stateFqn.skipFirst(statechartFqn.segmentCount)
		return trimmedFqn.segments.join("_").toUpperCase
	}

	def dispatch String stateName(ExecutionState it) {
		val state = sourceElement as RegularState
		state.stateName
	}
	
	def String getNullStateName() {
		"$NULLSTATE$"
	}

	def asName(String it) {
		asIdentifier.toFirstUpper
	}

	def asEscapedName(String it) {
		asEscapedIdentifier.toFirstUpper
	}

	def private escaped(Property it) {
		var varName = name
		if (isKeyword) {
			varName += "Variable"
		}
		return varName
	}

	def private escaped(Event it) {
		var varName = name
		if (isKeyword) {
			varName += "Event"
		}
		return varName
	}

	def String getter(Event it) {
		"get" + name.asName + "Value()"
	}

	def String getter(Property it) {
		methodName("get", "()")
	}

	def String setter(Property it) {
		methodName("set", "")
	}
	
	def String assign(Property it) {
		methodName("assign", "")
	}
	
	def private methodName(Property it, String prefix, String suffix) {
		var methodName = prefix + name.asName

		if (isStatemachineMethod(methodName) || isDerivedIdentifier(name)) {
			methodName = prefix + escaped.asName
		}

		return methodName + suffix
	}

	def functionName(Step it) { shortName }
	
	def eventBufferTypeName(Type it) {
		val typeOrigin = it.originTraces.filter(EObject).head
		typeOrigin.className + "EvBuf"
	}
	
	protected def dispatch String className(EObject it) {
		flow.statemachineClassName + "TimeEvents"
	}

	protected def dispatch String className(InterfaceScope it) {
		interfaceName
	}

	protected def dispatch String className(InternalScope it) {
		flow.statemachineClassName + if (isShadowMemberScope) "Shadow" else "Internal"
	}

	protected def dispatch String className(ExecutionFlow it) {
		statemachineClassName
	}
	
	def String getInterfaceName(InterfaceScope it) {
		if (name.nullOrEmpty)
			return "Interface"
		else
			return "Interface" + name.toFirstUpper()
	}
	
	def String getInterfaceVariableName(InterfaceScope it) {
		if (name.nullOrEmpty)
			"defaultInterface"
		else
			interfaceName.asEscapedIdentifier
	}
	
}
