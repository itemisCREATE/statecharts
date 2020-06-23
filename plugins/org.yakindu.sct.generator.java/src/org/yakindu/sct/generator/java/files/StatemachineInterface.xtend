/**
 *   Copyright (c) 2012 committers of YAKINDU and others.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   Contributors:
 *   	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.java.files

import com.google.inject.Inject
import java.util.Set
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Parameter
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.java.GeneratorPredicate
import org.yakindu.sct.generator.java.GenmodelEntries
import org.yakindu.sct.generator.java.JavaExpressionsGenerator
import org.yakindu.sct.generator.java.JavaIncludeProvider
import org.yakindu.sct.generator.java.JavaNamingService
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.generator.java.features.OutEventObservables
import org.yakindu.sct.generator.java.templates.ClassTemplate
import org.yakindu.sct.generator.java.templates.FileTemplate
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition

class StatemachineInterface {
	@Inject protected Set<JavaIncludeProvider> includeProviders
	@Inject extension Naming
	@Inject extension JavaNamingService
	@Inject extension GenmodelEntries
	@Inject extension SExecExtensions
	@Inject extension ITypeSystem
	@Inject extension ICodegenTypeSystemAccess
	@Inject extension JavaExpressionsGenerator
	@Inject extension OutEventObservables
	@Inject extension OutputConfigProvider
	@Inject extension GeneratorPredicate
	
	protected ExecutionFlow flow
	protected GeneratorEntry entry

	def generateStatemachineInterface(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		this.entry = entry
		this.flow = flow
		val filename = flow.getImplementationPackagePath(entry) + '/' + flow.statemachineInterfaceName.java
		fsa.generateFile(filename, entry.apiOutputConfig, content)
	}

	def protected content() {
		FileTemplate
			.create
			.fileComment(entry.licenseText)
			.packageName(flow.getImplementationPackageName(entry))
			.addImport("java.util.List", entry.createInterfaceObserver && flow.hasOutgoingEvents)
			.addImport(entry.basePackageName.dot(iTimerCallback), flow.timed)
			.addImport(entry.basePackageName.dot(iStatemachine))
			.addImport(rxPackage.dot(observableClass), useOutEventObservables && flow.hasOutgoingEvents)
			.addImports(includeProviders.map[getImports(flow, entry)].flatten)
			.classTemplate(
				ClassTemplate
					.create
					.classType("interface")
					.className(flow.statemachineInterfaceName)
					.superClass(flow.statemachineInterfaceExtensions)
					.classContent(
						'''
						«IF flow.hasInternalScope»
							«FOR constant : flow.internalScope.declarations.filter(VariableDefinition).filter[const]»
								«constant.constantFieldDeclaration()»
							«ENDFOR»
						«ENDIF»
						«FOR scope : flow.scopes»
							«scope.createScope(entry)»
						«ENDFOR»
						'''
					) 
			).generate
	}

	def protected constantFieldDeclaration(VariableDefinition variable) {
		'''public static final «variable.typeSpecifier.targetLanguageName» «variable.identifier» = «variable.initialValue.code»;

		'''
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
		var constants = scope.declarations.filter(VariableDefinition).filter[const]
		'''

			public interface «scope.interfaceName» {
			
				«FOR constant : constants»
					«constant.constantFieldDeclaration()»
				«ENDFOR»
				«scope.eventAccessors(entry)»
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
							«IF event.type !== null && !isVoid(event.type)»
								public void on«event.name.toFirstUpper()»Raised(«event.typeSpecifier.targetLanguageName» value);
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
				
					«FOR operation : scope.operations »
						«operation.operationSignature»
					«ENDFOR»
				}
			«ENDIF»
		'''
	}

	def protected eventAccessors(InterfaceScope scope, GeneratorEntry entry) {
		'''
			«FOR event : scope.eventDefinitions»
				«IF event.direction == Direction::IN»
					«IF event.type !== null && !isVoid(event.type)»
						public void raise«event.name.asName»(«event.typeSpecifier.targetLanguageName» value);
						
					«ELSE»
						public void raise«event.name.asName»();
						
					«ENDIF»
				«ELSEIF event.direction == Direction::OUT»
					«IF useOutEventGetters»
						public boolean isRaised«event.name.asName»();
						««« IMPORTANT: An event not specifying a type is regarded to have a void type
						«IF event.hasValue»
							public «event.typeSpecifier.targetLanguageName» «event.getter»;
							
						«ENDIF»	
						
					«ENDIF»
					«IF useOutEventObservables»
						public Observable<«event.eventType»> «event.observableGetterName»();
						
					«ENDIF»
				«ENDIF»
			«ENDFOR»
		'''
	}

	def protected variableAccessors(InterfaceScope scope) '''
		«FOR variable : scope.variableDefinitions»
			public «variable.typeSpecifier.targetLanguageName» «variable.getter»;
			
			«IF !variable.readonly && !variable.const»
				public void «variable.setter »(«variable.typeSpecifier.targetLanguageName» value);
				
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
			public «typeSpecifier.targetLanguageName» «name.asEscapedIdentifier»(«FOR parameter : parameters SEPARATOR ', '»«parameter.
				typeSpecifier.targetLanguageName»«IF parameter.isVarArgs»...«ENDIF» «parameter.identifier»«ENDFOR»);
			
		'''
	}

	def protected identifier(Parameter parameter) {
		if (parameter.name.isKeyword) {
			return parameter.name + "Arg"
		} else {
			parameter.name
		}
	}
}
