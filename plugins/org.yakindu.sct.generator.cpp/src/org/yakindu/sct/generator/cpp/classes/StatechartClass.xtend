/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.cpp.classes

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.language.CEnum
import org.yakindu.sct.generator.c.language.CustomType
import org.yakindu.sct.generator.core.language.Comment
import org.yakindu.sct.generator.core.language.IFunction
import org.yakindu.sct.generator.core.language.IType
import org.yakindu.sct.generator.core.language.factory.FunctionFactory
import org.yakindu.sct.generator.core.language.factory.IStandardFunctionProvider
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.EventCode
import org.yakindu.sct.generator.cpp.ExpressionCode
import org.yakindu.sct.generator.cpp.FlowCode
import org.yakindu.sct.generator.cpp.Naming
import org.yakindu.sct.generator.cpp.Navigation
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.generator.cpp.language.Constructor
import org.yakindu.sct.generator.cpp.language.CppClass
import org.yakindu.sct.generator.cpp.language.Modifier
import org.yakindu.sct.generator.cpp.language.Typedef
import org.yakindu.sct.generator.cpp.language.Visibility
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.StatechartScope

/**
 * @author rbeckmann
 *
 */
class StatechartClass extends CppClass {
	@Inject protected extension Naming
	@Inject protected extension Navigation
	@Inject protected extension FlowCode
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	@Inject protected extension ExpressionCode
	@Inject protected extension StateVectorExtensions
	@Inject protected extension EventCode
	
	@Inject extension FunctionFactory
	@Inject extension IStandardFunctionProvider
	
	protected ExecutionFlow flow
	protected GeneratorEntry entry
	protected IGenArtifactConfigurations config
	protected IType classType
	protected Typedef statesEnumType
	
	new(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		this.flow = flow
		this.entry = entry
		this.config = artifactConfigs
		
		this.name = flow.module
		this.classType = new CustomType(this.name)
		this.statesEnumType = createStateEnum
		
		createPublicMembers()
		createProtectedMembers()
		createPrivateMembers()
	}
	
	def createPublicMembers() {
		createConstructors()
		createDestructors()
		addMember(statesEnumType, Visibility.PUBLIC)
		createStandardFunctions()
		if(flow.timed) {
			createTimedFunctions()
		}
		createInterfaces()
	}
	
	def createProtectedMembers() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	def createPrivateMembers() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	def createTimedFunctions() {
		#[setTimer, getTimer, raiseTimeEvent].forEach [
			modifiers += Modifier.VIRTUAL
			addMember(Visibility.PUBLIC)
		]
	}
	
	def createStateEnum() {
		val stateEnum = new CEnum()
		stateEnum.values += flow.null_state
		stateEnum.values += flow.states.map[shortName]
		val stateEnumType = new Typedef()
		stateEnumType.type = stateEnum
		stateEnumType.name = flow.statesEnumType
		stateEnumType
	}
	
	def createConstructors() {
		val constructor = new Constructor()
		constructor.parent = this
		constructor.name = this.name
		constructor.initializerList += initializerList
		if(flow.hasHistory) {
			constructor.content = '''
			for (int i = 0; i < «historyStatesConst»; ++i)
				historyVector[i] = «flow.null_state»;
			'''
		}
		
		addMember(constructor, Visibility.PUBLIC)
	}
	
	def protected getInitializerList() {
		val initializerList = newArrayList
		if(flow.timed) {
			initializerList.add(timerInstance + "(null)")
		}
		initializerList.add("stateConfVectorPosition(0)")
		for(iface : flow.getInterfaces) {
			initializerList.add(iface.instance)
			if(iface.hasOperations && !entry.useStaticOPC) {
				initializerList.add(iface.OCB_Instance + "(null)")
			}
		}
		initializerList
	}
	
	def createDestructors() {
		val destructor = new Constructor()
		destructor.parent = this
		destructor.name = this.name
		destructor.modifiers += Modifier.VIRTUAL
		addMember(destructor, Visibility.PUBLIC)
	}
	
	def createStandardFunctions() {
		val init = flow.init
		val enter = flow.enter
		val exit = flow.exit
		val runCycle = flow.runCycle
		val isActive = flow.isActive
		val isStateActive = flow.isStateActive(statesEnumType)
		val isFinal = flow.isFinal
		
		val standardFunctions = #[
			init,
			enter,
			exit,
			runCycle,
			isActive,
			isStateActive,
			isFinal
		]
		
		#[isActive, isStateActive, isFinal].forEach[modifiers += Modifier.CONST]
		
		standardFunctions.forEach[
			modifiers += Modifier.VIRTUAL
			addMember(Visibility.PUBLIC)
		]
	}
	
	def protected IFunction setTimer() {
		function("setTimer", '''this->«timerInstance» = timerInterface;''', #['''«timerInterface»* timerInterface'''])
	}
	
	def protected IFunction getTimer() {
		val getTimer = function("getTimer", '''this->«timerInstance» = timerInterface;''')
		getTimer.type = new CustomType(timerInterface + "*")
		getTimer
	}
	
	def protected IFunction raiseTimeEvent() {
		function(flow.raiseTimeEventFctID, '''
			if ((evid >= (sc_eventid)«timeEventsInstance») && (evid < (sc_eventid)(&«timeEventsInstance»[«timeEventsCountConst»])))
			{
				*(sc_boolean*)evid = true;
			}
			''',
			#["sc_eventid event"]
		)
	}
	
	def protected IFunction clearInEvents() {
		val it = flow
		function("clearInEvents", '''
			«FOR scope : scopes»
				«FOR event : scope.incomingEvents»
				«event.access» = false;
				«ENDFOR»
			«ENDFOR»
			«IF hasLocalScope»
				«FOR event : internalScope.events»
				«event.access» = false; 
				«ENDFOR»
			«ENDIF»
			«IF timed»
				«FOR event : timeEventScope.events»
				«event.access» = false; 
				«ENDFOR»
			«ENDIF»
		''')
	}
	
	def protected IFunction clearOutEvents() {
		val it = flow
		function("clearOutEvents", '''
		«FOR scope : it.scopes»
			«FOR event : scope.outgoingEvents»
			«event.access» = false;
			«ENDFOR»
		«ENDFOR»
		''')
	}
	
	def createInterfaces() {
		for(it : flow.scopes) {
			switch(it) {
				InterfaceScope: {
					createInterface
					if(hasOperations) {
						createOCBInterface
					}
				}
				InternalScope: {
					createInternalInterface
				}
			}
		}
	}
	
	def createOCBInterface(StatechartScope it) {
		if(hasOperations) {
			addMember(
				new StatechartOCBInterfaceClass(flow, entry, config, this, it),
				Visibility.PUBLIC
			)
		}
		
	}
	
	def createInternalInterface(InternalScope it) {
		createOCBInterface
	}
	
	def createInterface(InterfaceScope it) {
		addMember(
			switch(it) {
				case isDefaultInterface: new StatechartDefaultInterfaceClass(flow, entry, config, this, it)
				default: new StatechartInterfaceClass(flow, entry, config, this, it)
			}, Visibility.PUBLIC)
		createInterfaceGetter
	}
	
	def void createInterfaceGetter(StatechartScope it) {
		val getter = function("get" + interfaceName)
		getter.documentation = new Comment('''Returns an instance of the interface class '«interfaceName»'.''')
		getter.type = new CustomType(interfaceName + "*")
		getter.content = '''return &«instance»;'''
		addMember(getter, Visibility.PUBLIC)
	}
}