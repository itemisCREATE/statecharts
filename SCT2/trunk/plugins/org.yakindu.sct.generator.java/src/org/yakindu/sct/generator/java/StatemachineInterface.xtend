/**
  Copyright (c) 2012 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Muehlbrandt - Initial contribution and API
*/
package org.yakindu.sct.generator.java

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.Direction
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.base.types.Parameter
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.sgraph.Scope

class StatemachineInterface {
	
	@Inject extension Naming 
	@Inject extension GenmodelEntries
	@Inject extension Navigation
	@Inject extension TypeModel
	@Inject Beautifier beautifier
	
	def generateStatemachineInterface(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		var filename = flow.getImplementationPackagePath(entry) + '/' + flow.statemachineInterfaceName.java
		var content = beautifier.format(filename, content(flow, entry))
		fsa.generateFile(filename, content)
	}
	
	def private content(ExecutionFlow flow, GeneratorEntry entry) {
		'''
		«entry.licenseText»
		package «flow.getImplementationPackageName(entry)»;
		«IF entry.createInterfaceObserver && flow.hasOutgoingEvents»
		import java.util.List;
		«ENDIF»
		import «entry.basePackageName».IStatemachine;
		«IF flow.timed»
		import «entry.basePackageName».ITimedStatemachine;
		«ENDIF»
		
		public interface «flow.statemachineInterfaceName» extends «flow.statemachineInterfaceExtensions» {
			
			«FOR scope: flow.scopes»
				«scope.createScope(entry)»
			«ENDFOR»
		}
		'''
	}
	
	def private createScope(Scope scope, GeneratorEntry entry) {
		switch scope {
			InterfaceScope: scope.createScope(entry)
			InternalScope: scope.createScope
		}
	}
	
	def private createScope(InterfaceScope scope, GeneratorEntry entry) {
		'''
		«scope.createInterface(entry)»
		«scope.createListenerInterface(entry)»
		«scope.createOperationCallbackInterface»
		
		public «scope.interfaceName» get«scope.interfaceName»();
		
		'''
	}
	
	def private createScope(InternalScope scope) {
		'''
		«IF scope.hasOperations()»
			public interface «scope.internalOperationCallbackName» {
				«FOR operation : scope.operations»
					«operation.operationSignature»
				«ENDFOR»
			}
			
			public void set«scope.internalOperationCallbackName»(«scope.internalOperationCallbackName» operationCallback);
		«ENDIF»
		'''
	}
	
	def private createInterface(InterfaceScope scope, GeneratorEntry entry) {
		'''
		public interface «scope.interfaceName» {
			«scope.eventAccessors»
			«scope.variableAccessors»
			«IF entry.createInterfaceObserver && scope.hasOutgoingEvents»
				public List<«scope.getInterfaceListenerName()»> getListeners();
			«ENDIF»
	
			«IF scope.hasOperations()»
				public void set«scope.getInterfaceOperationCallbackName()»(«scope.getInterfaceOperationCallbackName()» operationCallback);
			«ENDIF»
		}
		'''
	}
	
	def private createListenerInterface(InterfaceScope scope, GeneratorEntry entry) {
		'''
		«IF entry.createInterfaceObserver && scope.hasOutgoingEvents»
			
			public interface «scope.getInterfaceListenerName()» {
				«FOR event : scope.eventDefinitions»
					«IF event.direction ==  Direction::OUT»
						«IF !event.type.isVoid()»
							public void on«event.name.toFirstUpper()»Raised(«event.type.getJavaType()» value);
						«ELSE»
							public void on«event.name.toFirstUpper()»Raised();
						«ENDIF»	
					«ENDIF»
				«ENDFOR»
				}
		«ENDIF»
		'''
	}
	
	def private createOperationCallbackInterface(InterfaceScope scope) {
		'''
		«IF scope.hasOperations»
			
			public interface «scope.getInterfaceOperationCallbackName()» {
			«FOR operation : scope.operations»
				«operation.operationSignature»
			«ENDFOR»
			}
		«ENDIF»
		'''
	}
	
	def private eventAccessors(InterfaceScope scope) {
		'''
		«FOR event : scope.eventDefinitions»
			«IF  event.direction ==  Direction::IN»
				«IF !event.type.void»
					public void raise«event.name.asName»(«event.type.getJavaType()» value);
				«ELSE»
					public void raise«event.name.asName»();
				«ENDIF»
			«ELSEIF event.direction ==  Direction::OUT»
				public boolean isRaised«event.name.asName»();
				«IF !event.type.void»
					public «event.type.getJavaType()» get«event.name.asName»Value();
				«ENDIF»	
			«ENDIF»
		«ENDFOR»
		'''
	}
	
	def private variableAccessors(InterfaceScope scope) '''
		«FOR variable : scope.variableDefinitions»
					public «variable.type.getJavaType()» «variable.getter»;
					«IF  !variable.readonly»
						public void «variable.setter»(«variable.type.getJavaType()» value);	
					«ENDIF»
		«ENDFOR»
	'''
	
	def private String getStatemachineInterfaceExtensions(ExecutionFlow flow) {

		var String interfaces = "";

		if (flow.timed) {
			interfaces = interfaces + "ITimedStatemachine,"
		}

		interfaces = interfaces + "IStatemachine"
		
		return interfaces;
	}
	
	def private operationSignature(OperationDefinition it) {
		'''
		public «type.javaType» «name.asEscapedIdentifier»(«FOR parameter : parameters SEPARATOR ', '»«parameter.type.javaType» «parameter.identifier»«ENDFOR»);
		'''
	}
	
	def private identifier(Parameter parameter) {
		if (parameter.name.isJavaKeyword()) {
			return parameter.name + "Arg"
		}
		else {
			parameter.name
		}
	}
}