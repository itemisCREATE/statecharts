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
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Parameter
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition

class StatemachineInterface {

	@Inject extension Naming
	@Inject extension GenmodelEntries
	@Inject extension Navigation
	@Inject extension ITypeSystem
	@Inject extension ICodegenTypeSystemAccess
	@Inject extension ExpressionCode
	@Inject Beautifier beautifier

	def generateStatemachineInterface(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		var filename = flow.getImplementationPackagePath(entry) + '/' + flow.statemachineInterfaceName.java
		var content = beautifier.format(filename, content(flow, entry))
		fsa.generateFile(filename, content)
	}

	def protected content(ExecutionFlow flow, GeneratorEntry entry) {
		'''
			«entry.licenseText»
			package «flow.getImplementationPackageName(entry)»;
			«IF entry.createInterfaceObserver && flow.hasOutgoingEvents»
				import java.util.List;
			«ENDIF»
			import «entry.basePackageName».«iStatemachine»;
			«IF flow.timed»
				import «entry.basePackageName».«iTimerCallback»;
			«ENDIF»
			
			public interface «flow.statemachineInterfaceName» extends «flow.statemachineInterfaceExtensions» {
				«IF flow.internalScope != null»
				
				«var constants = flow.internalScope.declarations.filter(VariableDefinition).filter[const]»
				«FOR constant : constants»
					«constant.constantFieldDeclaration()»
				«ENDFOR»
				«ENDIF»
				«FOR scope : flow.scopes»
					«scope.createScope(entry)»
				«ENDFOR»
			}
		'''
	}
	
	
	
	def protected constantFieldDeclaration(VariableDefinition variable){
		'''public static final «variable.type.targetLanguageName» «variable.symbol» = «variable.initialValue.code»;'''
	}

	def protected createScope(Scope scope, GeneratorEntry entry) {
		switch scope {
			InterfaceScope: scope.createScope(entry)
			InternalScope: scope.createScope
		}
	}

	def protected createScope(InterfaceScope scope, GeneratorEntry entry) {
		'''
			«scope.createInterface(entry)»
			«scope.createListenerInterface(entry)»
			«scope.createOperationCallbackInterface»
			
			public «scope.interfaceName» get«scope.interfaceName»();
			
		'''
	}

	def protected createScope(InternalScope scope) {
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

	def protected createInterface(InterfaceScope scope, GeneratorEntry entry) {
		'''
				public interface «scope.interfaceName» {
				«var constants = scope.declarations.filter(VariableDefinition).filter[const]»
				«FOR constant : constants»
					«constant.constantFieldDeclaration()»
				«ENDFOR»
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

	def protected createListenerInterface(InterfaceScope scope, GeneratorEntry entry) {
		'''
			«IF entry.createInterfaceObserver && scope.hasOutgoingEvents»
				
				public interface «scope.getInterfaceListenerName()» {
					«FOR event : scope.eventDefinitions»
						«IF event.direction == Direction::OUT»
							«IF event.type != null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
								public void on«event.name.toFirstUpper()»Raised(«event.type.targetLanguageName» value);
							«ELSE»
								public void on«event.name.toFirstUpper()»Raised();
							«ENDIF»	
						«ENDIF»
					«ENDFOR»
					}
			«ENDIF»
		'''
	}

	def protected createOperationCallbackInterface(InterfaceScope scope) {
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

	def protected eventAccessors(InterfaceScope scope) {
		'''
			«FOR event : scope.eventDefinitions»
				«IF event.direction == Direction::IN»
				«IF event.type != null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
						public void raise«event.name.asName»(«event.type.targetLanguageName» value);
					«ELSE»
						public void raise«event.name.asName»();
					«ENDIF»
				«ELSEIF event.direction == Direction::OUT»
					public boolean isRaised«event.name.asName»();
					««« IMPORTANT: An event not specifying a type is regarded to have a void type
				«IF event.type != null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
						public «event.type.targetLanguageName» «event.getter»;
					«ENDIF»	
				«ENDIF»
			«ENDFOR»
		'''
	}

	def protected variableAccessors(InterfaceScope scope) '''
		«FOR variable : scope.variableDefinitions»
			public «variable.type.targetLanguageName» «variable.getter»;
			«IF !variable.readonly && !variable.const»
				public void «variable.setter»(«variable.type.targetLanguageName» value);	
			«ENDIF»
		«ENDFOR»
	'''

	def protected getStatemachineInterfaceExtensions(ExecutionFlow flow) {

		var String interfaces = "";

		if (flow.timed) {
			interfaces = interfaces + iTimerCallback + ","
		}

		interfaces = interfaces + iStatemachine

		return interfaces;
	}

	def protected operationSignature(OperationDefinition it) {
		'''
			public «type.targetLanguageName» «name.asEscapedIdentifier»(«FOR parameter : parameters SEPARATOR ', '»«parameter.
				type.targetLanguageName» «parameter.identifier»«ENDFOR»);
		'''
	}

	def protected identifier(Parameter parameter) {
		if (parameter.name.isJavaKeyword()) {
			return parameter.name + "Arg"
		} else {
			parameter.name
		}
	}
}
