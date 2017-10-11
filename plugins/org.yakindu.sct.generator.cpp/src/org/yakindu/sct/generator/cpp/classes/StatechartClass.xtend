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
import org.yakindu.sct.generator.c.language.Parameter
import org.yakindu.sct.generator.c.language.TypeQualifier
import org.yakindu.sct.generator.core.language.Comment
import org.yakindu.sct.generator.core.language.IType
import org.yakindu.sct.generator.core.language.factory.FunctionFactory
import org.yakindu.sct.generator.core.language.factory.IStandardFunctionProvider
import org.yakindu.sct.generator.cpp.classes.members.StatechartClassMembers
import org.yakindu.sct.generator.cpp.language.Constructor
import org.yakindu.sct.generator.cpp.language.Modifier
import org.yakindu.sct.generator.cpp.language.Typedef
import org.yakindu.sct.generator.cpp.language.Visibility
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.StatechartScope

/**
 * @author rbeckmann
 *
 */
class StatechartClass extends AbstractStatechartClass {
	@Inject extension FunctionFactory
	@Inject extension IStandardFunctionProvider
	@Inject extension StatechartClassMembers
	@Inject extension StatechartClassFactory
	
	protected IType classType
	protected Typedef statesEnumType
	
	override build(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		super.build(flow, entry, artifactConfigs)
		
		this.name = flow.module
		this.classType = new CustomType(this.name)
		this.statesEnumType = createStateEnum

		defineExtendedClasses()
		
		createPublicMembers()
		createProtectedMembers()
		createPrivateMembers()
	}
	
	def defineExtendedClasses() {
		extendedClasses = newArrayList
		if(flow.timed) extendedClasses += "public " + timedStatemachineInterface
		extendedClasses += "public " + statemachineInterface
	}
	
	def createPublicMembers() {
		createConstructor()
		createDestructor()
		addMember(statesEnumType, Visibility.PUBLIC)
		createStandardFunctions()
		if(flow.timed) {
			addMember(timeEventsCountConstVar(flow), Visibility.PUBLIC)
			addMember(timeEventsCountparallelConstVar(flow), Visibility.PUBLIC)
			createTimedFunctions()
		}
		createInterfaces()
	}
	
	def createProtectedMembers() {
		if(flow.timed || flow.hasOperationCallbacks) {
			createCopyConstructor()
			createAssignmentOperator()
		}
		createInternalInterfaces()
		createStatemachineMemberVariables()
		createInternalFunctions()
	}
	
	def createPrivateMembers() {
	}
	
	def createCopyConstructor() {
		val copy = new Constructor()
		copy.name = this.name
		val p = new Parameter(classType, "&rhs")
		p.typeQualifier = TypeQualifier.CONST
		copy.parameters = #[p]
		copy.initializerList += copyInitializationList
		
	}
	
	def getCopyInitializationList() {
		val initializerList = newArrayList
		if(flow.timed) {
			initializerList.add(timerInstance + '''(rhs.«timerInstance»)''')
		}
		initializerList.add("rhs.stateConfVectorPosition(0)")
		for(iface : flow.getInterfaces) {
			initializerList.add(iface.instance + '''(rhs.«iface.instance»)''')
			if(iface.hasOperations && !entry.useStaticOPC) {
				initializerList.add(iface.OCB_Instance + '''(rhs.«iface.OCB_Instance»)''')
			}
		}
		initializerList
	}
	
	def createAssignmentOperator() {
		val func = function("operator=")
		func.type = classType.pointer
		val p = new Parameter(func.type, "rhs")
		p.setConst
		func.parameters = #[p]
	}
	
	def createInternalInterfaces() {
		for(s : flow.scopes.filter(InternalScope)) {
			addMember(createStatechartInterfaceClass(flow, entry, config, this, s), innerClassVisibility)
		}
	}
	
	def createStatemachineMemberVariables() {
		val visibility = innerClassVisibility
		val it = flow
		
		addMember(orthogonalStatesConstVar, visibility)
		
		if(flow.hasHistory) {
			addMember(historyStatesConstVar, visibility)
		}
		
		if(flow.timed) {
			addMember(timerInterfaceInstance, visibility)
			addMember(timeEventsArray, visibility)
		}
		
		addMember(stateConfVectorArray(statesEnumType), visibility)
		
		if(flow.hasHistory) {
			addMember(historyVectorArray(statesEnumType), visibility)
		}
		
		addMember(stateConfVectorPosition, visibility)
		
		for(iface : flow.getInterfaces) {
			addMember(iface.interfaceInstance, visibility)
			if(iface.hasOperations && !entry.useStaticOPC) {
				addMember(iface.ocbInterfaceInstance, visibility)
			}
		}
	}
	
	def createInternalFunctions() {
		val it = flow
		checkFunctions.internalFunctions
		effectFunctions.internalFunctions
		entryActionFunctions.internalFunctions
		exitActionFunctions.internalFunctions
		enterSequenceFunctions.internalFunctions
		exitSequenceFunctions.internalFunctions
		reactFunctions.internalFunctions
		addMember(clearInEvents, innerClassVisibility)
		addMember(clearOutEvents, innerClassVisibility)
	}
	
	def internalFunctions(Iterable<Step> steps) {
		steps.map[internalFunction].forEach[addMember(innerClassVisibility)]
	}
	
	def createTimedFunctions() {
		val it = flow
		#[setTimer, getTimer, raiseTimeEvent].forEach [
			setVirtual
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
	
	def createConstructor() {
		val constructor = new Constructor()
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
			initializerList.add(iface.instance + "()")
			if(iface.hasOperations && !entry.useStaticOPC) {
				initializerList.add(iface.OCB_Instance + "(null)")
			}
		}
		initializerList
	}
	
	def createDestructor() {
		val destructor = new Constructor()
		destructor.name = "~" + this.name
		destructor.setVirtual
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
					if(hasOperations) {
						createOCBInterface
					}
				}
			}
		}
	}
	
	def createOCBInterface(StatechartScope it) {
		addMember(
			createStatechartOCBInterfaceClass(flow, entry, config, this, it),
			Visibility.PUBLIC
		)
		if(!entry.useStaticOPC) {
			addMember(
				function("set" + interfaceOCBName,
					'''«OCB_Instance» = operationCallback;''',
					#[new Parameter(interfaceOCBName + "*", "operationCallBack")]
				),
				Visibility.PUBLIC
			)
		}
	}
	
	def createInterface(InterfaceScope it) {
		val iface = createStatechartInterfaceClass(flow, entry, config, this, it)
		addMember(iface, Visibility.PUBLIC)
		createInterfaceGetter(iface)

		if (isDefaultInterface) {
			createScopeDeclarationFunctions
		}
	}
	
	def void createInterfaceGetter(StatechartScope it, AbstractStatechartClass iface) {
		val getter = function("get" + interfaceName, '''return &«instance»;''')
		getter.documentation = new Comment('''Returns an instance of the interface class '«interfaceName»'.''')
		getter.type = new CustomType(iface.name + "*")
		addMember(getter, Visibility.PUBLIC)
	}
}