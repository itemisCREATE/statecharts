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
import org.yakindu.base.expressions.expressions.FeatureCall
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
import org.yakindu.sct.model.sgraph.util.StatechartUtil
import org.yakindu.sct.model.stext.naming.StextNameProvider
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition

import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import org.yakindu.sct.generator.c.GeneratorPredicate
import org.yakindu.base.types.Direction
import org.yakindu.base.types.TypedDeclaration
import org.yakindu.base.types.Type
import org.yakindu.base.types.adapter.OriginTracing
import org.yakindu.sct.model.sexec.extensions.EventBufferExtensions

class Naming {
	@Inject @Named("Separator") protected String sep;

	@Inject protected extension SExecExtensions
	
	@Inject protected extension SgraphExtensions

	@Inject protected extension ICodegenTypeSystemAccess

	@Inject protected StextNameProvider provider
	
	@Inject GeneratorEntry entry

	@Inject protected extension INamingService
	
	@Inject extension GenmodelEntries
	
	@Inject extension StatechartUtil
	@Inject extension GeneratorPredicate
	@Inject extension OriginTracing
	@Inject extension EventBufferExtensions
	
	
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
	
	def featuresEnumType(ExecutionFlow it) {
		containerType + 'Feature'
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

	def dispatch String type(Property it) {
		containerType + it.type.name
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
	
	
	def dispatch String cType(EObject it) {
		type
	}
	
	def dispatch String cType(ExecutionFlow it) {
		type
	}
	
	def dispatch String cType(Type it) {
		if (! it.name.isNullOrEmpty) return it.name
		if (! it.targetLanguageName.isNullOrEmpty) return targetLanguageName
		
		val typeSuffix = if (it.isEventBuffer) "EvBuf" else ""
		val typeOrigin = it.originTraces.filter(EObject).findFirst[true]
		
		if (typeOrigin !== null) typeOrigin.cType + typeSuffix 
		else typeSuffix
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
	
	def functionPrefix(Statechart it) {
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
	
	def dispatch String null_state(Statechart it) {
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
	
	/**
	 * TODO: move method it is for declaration not naming
	 */
	def scopeShadowEventMember(Event it) {
		'''
		«SINGLE_SUBSCRIPTION_OBSERVER_TYPE» «eventName»;
		'''
	}

	/**
	 * TODO: move method it is for declaration not naming
	 */
	def dispatch scopeTypeDeclMember(Event it) {
		'''
		«IF useOutEventObservables && direction == Direction.OUT»
			«OBSERVABLE_TYPE» «eventName»;
		«ENDIF»
		«IF (useOutEventGetters && direction == Direction.OUT) || direction == Direction.IN || direction == Direction.LOCAL»
			«BOOL_TYPE» «eventRaisedFlag»;
			«IF type !== null && type.name != 'void'»«typeSpecifier.targetLanguageName» «eventValueVariable»;«ENDIF»
		«ENDIF»
		'''
	}
	
	/**
	 * TODO: move method it is for declaration not naming
	 */
	def dispatch scopeTypeDeclMember(TimeEvent it) '''
		«BOOL_TYPE» «timeEventRaisedFlag»;
	'''

	/**
	 * TODO: move method it is for declaration not naming
	 */
	def dispatch scopeTypeDeclMember(Property it) '''
		«IF type.name != 'void' && !isConst»«typeSpecifier.targetLanguageName» «variable»;«ENDIF»
	'''
	
	/**
	 * TODO: move method it is for declaration not naming
	 */
	def dispatch scopeTypeDeclMember(Declaration it) ''''''

	def constantName(VariableDefinition it) {
		(containerType + separator + scope.type + separator + name.asEscapedIdentifier).toUpperCase
	}

	def raiseTimeEventFctID(ExecutionFlow it) {
		functionPrefix + RAISE_TIME_EVENT
	}
	
	def raiseTimeEventFctID(Statechart it) {
		functionPrefix + RAISE_TIME_EVENT
	}

	def isStateActiveFctID(ExecutionFlow it) {
		functionPrefix + IS_STATE_ACTIVE
	}
	
	def isStateActiveFctID(Statechart it) {
		functionPrefix + IS_STATE_ACTIVE
	}

	def isActiveFctID(ExecutionFlow it) {
		functionPrefix + IS_ACTIVE
	}
	
	def isActiveFctID(Statechart it) {
		functionPrefix + IS_ACTIVE
	}

	def isFinalFctID(ExecutionFlow it) {
		functionPrefix + IS_FINAL
	}
	
	def isFinalFctID(Statechart it) {
		functionPrefix + IS_FINAL
	}
	
	def initFctID(ExecutionFlow it) {
		functionPrefix + INIT
	}
	
	def initFctID(Statechart it) {
		functionPrefix + INIT
	}
	
	def enterFctID(ExecutionFlow it) {
		functionPrefix + ENTER
	}
	
	def enterFctID(Statechart it) {
		functionPrefix + ENTER
	}

	def exitFctID(ExecutionFlow it) {
		functionPrefix + EXIT
	}
	
	def exitFctID(Statechart it) {
		functionPrefix + EXIT
	}
	
	def runCycleFctID(ExecutionFlow it) {
		functionPrefix + RUN_CYCLE
	}
	
	def runCycleFctID(Statechart it) {
		functionPrefix + RUN_CYCLE
	}
	
	def eventValueVariable(Event it) {
		name.asIdentifier.value
	}
	
	def eventName(Event it) {
		name.asIdentifier
	}
	
	def timeEventRaisedFlag(TimeEvent it) {
		shortName.raised
	}
	
	def eventRaisedFlag(Event it) {
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
	
	def asObservableGetter(Event it) {
		accessFunction("get")
	}

	def dispatch asGetter(EventDefinition it) {
		accessFunction("get").value
	}

	def dispatch asGetter(VariableDefinition it) {
		accessFunction("get")
	}
	
	def dispatch asGetter(Declaration it) '''Cannot find getter for «it»'''

	def asSetter(Declaration it) {
		accessFunction("set")
	}

	def asFunction(OperationDefinition it) {
		scope.functionPrefix(it) + separator + name.asIdentifier.toFirstLower
	}
	
	def accessFunction(Declaration it, String funcName) {
		scope.functionPrefix(it) + separator + funcName + separator + name.asIdentifier.toFirstLower
	}
	
	def variable(Property it) {
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
	
	def dispatch accessObservable(Event it) '''«IF needsHandle»«scHandle»«ENDIF»->«scope.instance».«name.asIdentifier»'''
	
	def dispatch accessObservable(EObject it) ''''''
	
	def dispatch accessObserver(Event it) '''«IF needsHandle»«scHandle»«ENDIF»->«scope.instance».«name.asIdentifier»'''
	
	def dispatch accessObserver(EObject it) ''''''
	
	def dispatch observerCallbackFctID(Event it) '''on_«name.asIdentifier»'''
	
	def dispatch observerCallbackFctID(EObject it) ''''''

	def dispatch access(TimeEvent it) '''«scHandle»->«scope.instance».«shortName.raised»'''

	def dispatch access(EObject it) '''#error cannot access elements of type «getClass.name»'''

	def dispatch valueAccess(Declaration it)'''«IF needsHandle»«scHandle»->«ENDIF»«scope.instance».«name.asIdentifier.value»'''
	
	def dispatch valueAccess(EObject it) '''#error cannot value access elements of type «getClass.name»'''

	def dispatch valueDeclaration(TypedDeclaration it) '''«typeSpecifier.targetLanguageName» «valueName»'''
	
	def dispatch valueDeclaration(EObject it) ''''''
	
	def dispatch valueName(TypedDeclaration it) '''«scope.instance»_«name.asIdentifier.value»'''
	
	def dispatch valueName(EObject it) ''''''
	
	def maxOrthogonalStates(ExecutionFlow it) '''«type.toUpperCase»_MAX_ORTHOGONAL_STATES'''

	def maxHistoryStates(ExecutionFlow it) '''«type.toUpperCase»_MAX_HISTORY_STATES'''

	def maxParallelTimeEvents(ExecutionFlow it) '''«type.toUpperCase»_MAX_PARALLEL_TIME_EVENTS'''
	
	def numStates(ExecutionFlow it) '''«type.toUpperCase»_STATE_COUNT'''
	
	def stateEnumAccess(Enumerator it) {
		val statechart = eContainer.getOriginStatechart()
		val state = originState		
		return '''«IF state !== null»«state.stateName.asEscapedIdentifier»«ELSE»«statechart.null_state»«ENDIF»'''
	}
		
	def dispatch getHandle(Expression it) {
		'''/*Cannot find handle for Expression: '«it»' */'''
	}
	
	def dispatch CharSequence getHandle(FeatureCall it) {
		if(feature instanceof VariableDefinition) {
			val owner = owner
			if(owner instanceof FeatureCall) {
				val ownerOfOwner = owner.owner
				// named interface
				if(ownerOfOwner instanceof FeatureCall) {
					return '''«feature.asGetter»(«ownerOfOwner.getHandle»)'''	
				}
				// unnamed interface
				return '''«feature.asGetter»(«owner.getHandle»)'''
			}
			// statechart internal
			return '''«owner.getHandle»«feature.access»'''
			}
		return '''«owner.getHandle»'''
	}
	
	def dispatch getHandle(ElementReferenceExpression it) {
		val reference = reference
		if(reference instanceof VariableDefinition) {
			'''«scHandle»->«reference.scope.instance».«reference.name»'''
		}
	}
	
	def featureNamingPrefix(ExecutionFlow it){
		'''«it.name.toLowerCase»Iface_'''
	}
	
	def scTracingHandleDecl(EObject it) { TRACE_HANDLER_TYPE + '* ' + TRACE_HANDLER }//sc_trace_handler* trace_handler
	
	def initTracingFctID(ExecutionFlow it) {
		functionPrefix + INIT_TRACING
	}
	
	def setTraceHandlerFctID(ExecutionFlow it) {
		functionPrefix + SET_TRACING
	}

	def tracingModule(ExecutionFlow it) {
		TRACING_MODULE
	}
	
	def rxcModule(ExecutionFlow it) {
		RXC_MODULE
	}
	
	def metaModule(ExecutionFlow it) {
		it.module + META_MODULE
	}
	
	def metaPrefix(ExecutionFlow it) {
		META_MODULE + separator
	}
	
	def metaSuffix(ExecutionFlow it) {
		separator + META_MODULE
	}
	
	def tracingPrefix(ExecutionFlow it){
		TRACE_CALL + separator
	}
	
	def traceFctID(ExecutionFlow it) {
		TRACE_CALL
	}
	
	def runCycleGuard() {
		"is_running"
	}
	
}
