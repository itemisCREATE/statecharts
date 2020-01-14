/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c.extensions

import com.google.inject.Inject
import com.google.inject.name.Named
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Enumerator
import org.yakindu.base.types.Event
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.sgraph.ScopedElement
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.naming.StextNameProvider
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition

import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import org.yakindu.base.expressions.expressions.FeatureCall

class Naming {
	@Inject @Named("Separator") protected String sep;

	@Inject protected extension SExecExtensions
	
	@Inject protected extension SgraphExtensions

	@Inject protected extension ICodegenTypeSystemAccess

	@Inject protected StextNameProvider provider
	
	@Inject GeneratorEntry entry

	@Inject protected extension INamingService
	
	@Inject extension GenmodelEntries
	
	def getFullyQualifiedName(State state) {
		provider.getFullyQualifiedName(state).toString.asEscapedIdentifier
	}

	def module(ExecutionFlow it) {
		if (entry.moduleName.nullOrEmpty) {
			return name.asIdentifier.toFirstUpper
		}
		return entry.moduleName.toFirstUpper
	}
	
	def module(Statechart it) {
		if (entry.moduleName.nullOrEmpty) {
			return name.asIdentifier.toFirstUpper
		}
		return entry.moduleName.toFirstUpper
	}

	def client(String it) {
		it + "Required"
	}

	def timerModule(ExecutionFlow it) {
		'sc_timer'
	}

	def typesModule(ExecutionFlow it) {
		TYPES_MODULE
	}

	def timerType(ExecutionFlow it) {
		'SCTimer'
	}
	
	def statesEnumType(ExecutionFlow it) {
		containerType + 'States'
	}
	
	def protected String entryStatemachinePrefix() {
		entry.statemachinePrefix
	}

	def dispatch String type(InterfaceScope it) {
		containerType + 'Iface' + (if(name.nullOrEmpty) '' else name).asIdentifier.toFirstUpper
	}

	def dispatch String type(InternalScope it) {
		containerType + 'Internal'
	}

	def dispatch String type(Scope it) {
		containerType + 'TimeEvents'
	}

	def dispatch String type(ExecutionFlow it) {
		if (entryStatemachinePrefix.nullOrEmpty) {
			return name.asIdentifier.toFirstUpper
		}
		return entryStatemachinePrefix.toFirstUpper
	}
	
	def dispatch String type(Statechart it) {
		if(entryStatemachinePrefix.nullOrEmpty) {
			return name.asIdentifier.toFirstUpper
		}
		return entryStatemachinePrefix.toFirstUpper
	}
	
	def String getContainerType(EObject it) {
		if (flow !== null) {
			return flow.type
		}
		return statechart.type
	}

	def dispatch instance(InterfaceScope it) {
		'iface' + (if(name.nullOrEmpty) '' else name).asIdentifier.toFirstUpper
	}
	
	def dispatch instance(Void it) {
		"no scope!"
	}

	def dispatch instance(Scope it) {
		'timeEvents'
	}

	def dispatch instance(InternalScope it) {
		'internal'
	}

	def functionPrefix(Scope it, Declaration decl) {
		// only non-unique declarations in different scopes will be prefixed with the name of the scope
		if (!isUniqueName(it, decl) && !entryStatemachinePrefix.nullOrEmpty)
			return entryStatemachinePrefix + separator + it.instance.toFirstUpper
		if (!entryStatemachinePrefix.nullOrEmpty)
			return entryStatemachinePrefix
		return type.toFirstLower
	}

	protected def boolean isUniqueName(Scope scope, Declaration decl) {
		(scope.eContainer as ScopedElement).scopes.map[declarations].flatten.filter[it.name == decl.name].size == 1
	}

	def functionPrefix(ExecutionFlow it) {
		if (!entryStatemachinePrefix.nullOrEmpty) {
			return entryStatemachinePrefix + separator
		}
		type.toFirstLower + separator
	}

	def separator() {
		var sep = this.sep
		if (sep.nullOrEmpty) {
			sep = "_"
		}
		return sep
	}

	def clearInEventsFctID(ExecutionFlow it) {
		CLEAR_IN_EVENTS
	}

	def clearOutEventsFctID(ExecutionFlow it) {
		CLEAR_OUT_EVENTS
	}

	def dispatch String null_state(ExecutionFlow it) {
		type + lastStateID
	}

	def dispatch String null_state(Step it) {
		execution_flow.null_state
	}

	def lastStateID() {
		separator + "last" + separator + "state"
	}

	def stateVectorDefine(ExecutionState it) {
		'''SCVI_«shortName»'''.toString.toUpperCase
	}

	def ExecutionFlow execution_flow(EObject element) {
		var ret = element;

		while (ret !== null) {
			if (ret instanceof ExecutionFlow) {
				return ret
			} else {
				ret = ret.eContainer;
			}
		}
		return null;
	}
	
	def dispatch scopeTypeDeclMember(EventDefinition it) '''
		«BOOL_TYPE» «eventRaisedFlag»;
		«IF type !== null && type.name != 'void'»«typeSpecifier.targetLanguageName» «eventValueVariable»;«ENDIF»
	'''

	def dispatch scopeTypeDeclMember(TimeEvent it) '''
		«BOOL_TYPE» «timeEventRaisedFlag»;
	'''

	def dispatch scopeTypeDeclMember(VariableDefinition it) '''
		«IF type.name != 'void' && !isConst»«typeSpecifier.targetLanguageName» «variable»;«ENDIF»
	'''
	
	def dispatch scopeTypeDeclMember(Declaration it) ''''''

	def constantName(VariableDefinition it) {
		(containerType + separator + scope.type + separator + name.asEscapedIdentifier).toUpperCase
	}

	def raiseTimeEventFctID(ExecutionFlow it) {
		functionPrefix + RAISE_TIME_EVENT
	}

	def isStateActiveFctID(ExecutionFlow it) {
		functionPrefix + IS_STATE_ACTIVE
	}

	def isActiveFctID(ExecutionFlow it) {
		functionPrefix + IS_ACTIVE
	}

	def isFinalFctID(ExecutionFlow it) {
		functionPrefix + IS_FINAL
	}
	
	def initFctID(ExecutionFlow it) {
		functionPrefix + INIT
	}
	
	def enterFctID(ExecutionFlow it) {
		functionPrefix + ENTER
	}

	def exitFctID(ExecutionFlow it) {
		functionPrefix + EXIT
	}
	
	def runCycleFctID(ExecutionFlow it) {
		functionPrefix + RUN_CYCLE
	}
	
	def eventValueVariable(EventDefinition it) {
		name.asIdentifier.value
	}
	
	def timeEventRaisedFlag(TimeEvent it) {
		shortName.raised
	}
	
	def eventRaisedFlag(EventDefinition it) {
		 name.asIdentifier.raised
	}
	
	def setTimerFctID(ExecutionFlow it) {
		functionPrefix + SET_TIMER
	}
	
	def unsetTimerFctID(ExecutionFlow it) {
		functionPrefix + UNSET_TIMER
	}
	
	def enterStateTracingFctID(ExecutionFlow it) {
		functionPrefix + STATE_ENTERED
	}
	
	def exitStateTracingFctID(ExecutionFlow it) {
		functionPrefix + STATE_EXITED
	}
 
	def asRaiser(EventDefinition it) {
		accessFunction("raise")
	}

	def asRaised(EventDefinition it) {
		accessFunction("israised")
	}

	def asGetter(EventDefinition it) {
		accessFunction("get").value
	}

	def asGetter(VariableDefinition it) {
		accessFunction("get")
	}

	def asSetter(VariableDefinition it) {
		accessFunction("set")
	}

	def asFunction(OperationDefinition it) {
		scope.functionPrefix(it) + separator + name.asIdentifier.toFirstLower
	}
	
	def accessFunction(Declaration it, String funcName) {
		scope.functionPrefix(it) + separator + funcName + separator + name.asIdentifier.toFirstLower
	}
	
	def variable(VariableDefinition it) {
		name.asEscapedIdentifier
	}
	
	def stateName(ExecutionState it) {
		shortName
	}
	
	def stateName(State it) {
		shortName
	}

	def raised(CharSequence it) { it + separator + 'raised' }

	def value(CharSequence it) { it + separator + 'value' }

	def h(String it) { it + ".h" }

	def c(String it) { it + ".c" }

	def define(String it) { it.replaceAll('\\.', '_').toUpperCase }

	def dispatch scopeDescription(Scope it) '''scope'''

	def dispatch scopeDescription(InterfaceScope it) '''«IF name.nullOrEmpty»default interface scope«ELSE»interface scope '«name»'«ENDIF»'''

	def dispatch scopeDescription(InternalScope it) '''internal scope'''

	def scHandleDecl(EObject it) { containerType + '* ' + scHandle }

	def scHandle() { HANDLE }

	def valueParams(EventDefinition it) {
		if(hasValue) ', ' + typeSpecifier.targetLanguageName + ' value' else ''
	}

	def dispatch access(VariableDefinition it) {
		if (isConst) '''«it.constantName»''' else '''«IF needsHandle»«scHandle»«ENDIF»->«IF scope !== null»«scope.instance»«ENDIF».«name.asEscapedIdentifier»'''
	}
	
	def needsHandle(EObject it) {
		return !(eContainer instanceof ComplexType)
	}
	
	def dispatch access(Property it) {
		'''«name.asEscapedIdentifier»'''
	}

	def dispatch access(Operation it) {
		'''«name.asEscapedIdentifier»'''
	}

	def dispatch access(Method it) '''«shortName»'''
	
	def dispatch access(Enumerator it) {
		'''«name.asEscapedIdentifier»'''
	}

	def dispatch access(OperationDefinition it) '''«asFunction»'''

	def dispatch access(Event it) '''«IF needsHandle»«scHandle»«ENDIF»->«scope.instance».«name.asIdentifier.raised»'''

	def dispatch access(TimeEvent it) '''«scHandle»->«scope.instance».«shortName.raised»'''

	def dispatch access(EObject it) '''#error cannot access elements of type «getClass.name»'''

	def dispatch valueAccess(Declaration it)'''«IF needsHandle»«scHandle»->«ENDIF»«scope.instance».«name.asIdentifier.value»'''

	def dispatch valueAccess(EObject it) '''#error cannot value access elements of type «getClass.name»'''
	
	def maxOrthogonalStates(ExecutionFlow it) '''«type.toUpperCase»_MAX_ORTHOGONAL_STATES'''

	def maxHistoryStates(ExecutionFlow it) '''«type.toUpperCase»_MAX_HISTORY_STATES'''

	def maxParallelTimeEvents(ExecutionFlow it) '''«type.toUpperCase»_MAX_PARALLEL_TIME_EVENTS'''
	
	def numStates(ExecutionFlow it) '''«type.toUpperCase»_STATE_COUNT'''
	
		
	
	def dispatch getHandle(Expression it, String handle) {
		'''/*Cannot find handle for Expression: '«it»' */'''
	}
	
	def dispatch CharSequence getHandle(FeatureCall it, String handle) {
		'''«owner.getHandle(handle)»->«feature.access»'''
	}
	
	def dispatch getHandle(ElementReferenceExpression it, CharSequence handle) {
		val reference = reference
		if(reference instanceof VariableDefinition) {
			'''«handle»«reference.scope.instance».«reference.name»'''
		}
	}
	
}
