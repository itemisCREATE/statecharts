/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp.submodules

import com.google.inject.Inject
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.c.extensions.ExpressionsChecker
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.generator.cpp.templates.ClassDeclaration
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import org.yakindu.sct.generator.c.GeneratorPredicate
import org.yakindu.sct.model.sexec.extensions.ShadowEventExtensions
import org.yakindu.sct.generator.c.types.CLiterals
import org.yakindu.base.types.Event
import org.yakindu.sct.generator.cpp.CppObservables

class InterfaceFunctions {
	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension EventCode
	@Inject protected extension ExpressionsChecker
	@Inject protected extension GeneratorPredicate
	@Inject protected extension ShadowEventExtensions
	@Inject protected extension CLiterals
	@Inject protected extension CppObservables
	
	@Inject protected GeneratorEntry entry
	
	def interfaceFunctions(ExecutionFlow it) '''
		«FOR scope : statechartScopes»
			«IF scope instanceof InterfaceScope»
			«module»::«scope.interfaceName»* «module»::get«scope.interfaceName»()
			{
				return &«scope.instance»;
			}
			«ENDIF»
			«generateEvents(scope)»
			«generateVariables(scope)»
			«IF scope.hasOperations && !entry.useStaticOPC»
				«scope.OCB_InterfaceSetterDeclaration(true)»
				{
					«scope.OCB_Instance» = operationCallback;
				}
			«ENDIF»
		«ENDFOR»
		«IF entry.tracingUsed»
		
		void «module»::set«traceObserverModule»(«YSCNamespace»::«traceObserverModule»<«statesEnumType»>* tracingcallback) {
			«tracingInstance» = tracingcallback;
		}
		
		«YSCNamespace»::«traceObserverModule»<«module»::«statesEnumType»>* «module»::get«traceObserverModule»() {
			return «tracingInstance»;
		}
		«ENDIF»
	'''
	
	def generateVariables(ExecutionFlow it, StatechartScope scope)
		'''
			«FOR variable : scope.variableDefinitions»
				«IF variable.isConstString»const «ENDIF»«variable.typeSpecifier.targetLanguageName» «module»::«scope.interfaceName»::«variable.asGetter»() const
				{
					return «variable.localAccess»;
				}
				
				«IF scope.defaultInterface»
					«IF variable.isConstString»const «ENDIF»«variable.typeSpecifier.targetLanguageName» «module»::«variable.asGetter»() const
					{
						return «variable.access»;
					}
					
				«ENDIF»
				«IF !variable.readonly && !variable.const»
					void «module»::«scope.interfaceName»::«variable.asSetter»(«variable.typeSpecifier.targetLanguageName» value)
					{
						«observerHandler(variable, "unsubscribe")»
						this->«variable.localAccess» = value;
						«observerHandler(variable, "subscribe")»
					}
					
					«IF scope.defaultInterface»
						void «module»::«variable.asSetter»(«variable.typeSpecifier.targetLanguageName» value)
						{
							«scope.instance».«variable.asSetter»(value);
						}
						
					«ENDIF»
				«ENDIF»
			«ENDFOR»
		'''
		
	
	protected def CharSequence observerHandler(VariableDefinition variable, String subscription)
		'''«IF variable.needsShadowEventMapping»
		if(this->«variable.localAccess» != «NULL_LITERAL»)
		{
			«FOR e : variable.shadowEventsByScope.keySet.map[members].flatten.filter(Event)»
				«val outEvent = variable.getShadowEvent(e)»
				«IF outEvent !== null»parent->«outEvent.scope.instance».«variable.getShadowEvent(e).observer».«subscription»(value->«e.scope.getter»->«e.asObserverGetter»());«ENDIF»
			«ENDFOR»
		}
		«ENDIF»'''
	
		
	def createPublicScope(Scope scope) {
		switch scope {
			InterfaceScope: scope.createPublicScope
			InternalScope: scope.createPublicScope
		}
	}

	def createPublicScope(InterfaceScope scope) '''
		«scope.createInterface(new ClassDeclaration).generate»
		«scope.createOCBInterface»
		
		/*! Returns an instance of the interface class '«scope.interfaceName»'. */
		«scope.interfaceName»* get«scope.interfaceName»();
		
		«IF scope.defaultInterface»
			«FOR d : scope.declarations»
				«d.functionPrototypes»
			«ENDFOR»
		«ENDIF»
	'''

	def createPublicScope(InternalScope scope) {
		scope.createOCBInterface
	}

	def createInterface(StatechartScope scope, ClassDeclaration scopeDecl) {
		scopeDecl
			.name(scope.interfaceName)
			.comment('''//! Inner class for «scope.simpleName» interface scope.''')
		
		scope.declarations.map[functionPrototypes].forEach[scopeDecl.publicMember(it)]
		scopeDecl.member(entry.innerClassVisibility, protectedInnerClassMembers(scope))
		scopeDecl.member(ClassDeclaration::PRIVATE, scope.shadowEvents.map[createObserverClass(new ClassDeclaration, scope).generate ].join())
		scopeDecl.member(ClassDeclaration::PRIVATE, scope.shadowEvents.map[createObserver(scopeDecl)].join())
	}
	
	def CharSequence protectedInnerClassMembers(StatechartScope scope)
		'''
		friend class «scope.flow.module»;
		«FOR d : scope.declarations»
			«d.privateFunctionPrototypes»
			«d.scopeTypeDeclMember»
		«ENDFOR»
	'''
	

	def dispatch privateFunctionPrototypes(Declaration it) {
		''''''	
	}
	
	def dispatch privateFunctionPrototypes(EventDefinition it) {
		''''''	
	}
	
	def createOCBInterface(StatechartScope scope) {
		val scopeDecl = new ClassDeclaration
		if(!scope.hasOperations) {
			return ""
		}
		scopeDecl
			.name(scope.interfaceOCBName)
			.comment('''//! Inner class for «scope.simpleName» interface scope operation callbacks.''')
		if(!entry.useStaticOPC) {
			scopeDecl.destructorDeclaration(true, true)			
		}
		scope.operations.forEach[
			scopeDecl.publicMember('''«IF entry.useStaticOPC»static«ELSE»virtual«ENDIF» «signature»«IF !entry.useStaticOPC» = 0«ENDIF»;''')
		]
		
		'''
			«scopeDecl.generate»
			«IF !entry.useStaticOPC»
				
				/*! Set the working instance of the operation callback interface '«scope.interfaceOCBName»'. */
				«scope.OCB_InterfaceSetterDeclaration(false)»;
			«ENDIF»
		'''
	}
	
	def dispatch functionPrototypes(EventDefinition it) '''
		«IF direction == Direction::LOCAL»
			/*! Raises the in event '«name»' that is defined in the «scope.scopeDescription». */
			void «asRaiser»(«valueParams»);
			
			/*! Checks if the out event '«name»' that is defined in the «scope.scopeDescription» has been raised. */
			«BOOL_TYPE» «asRaised»() const;
			
			«IF hasValue»
				/*! Gets the value of the out event '«name»' that is defined in the «scope.scopeDescription». */
				«typeSpecifier.targetLanguageName» «asGetter»() const;
				
			«ENDIF»
		«ELSEIF direction == Direction::IN»
			/*! Raises the in event '«name»' that is defined in the «scope.scopeDescription». */
			void «asRaiser»(«valueParams»);
			
		«ELSE»
			/*! Checks if the out event '«name»' that is defined in the «scope.scopeDescription» has been raised. */
			«BOOL_TYPE» «asRaised»() const;
			
			«IF hasValue»
				/*! Gets the value of the out event '«name»' that is defined in the «scope.scopeDescription». */
				«typeSpecifier.targetLanguageName» «asGetter»() const;
				
			«ENDIF»
			«IF needsObservable»
				/*! Gets the observable of the out event '«name»' that is defined in the «scope.scopeDescription». */
				sc::rx::Observable<«typeSpecifier.targetLanguageName»>* «asObservableGetter»();
				
			«ENDIF»
		«ENDIF»
	'''

	def dispatch functionPrototypes(VariableDefinition it) '''
		/*! Gets the value of the variable '«name»' that is defined in the «scope.scopeDescription». */
		«IF isConstString»const «ENDIF»«typeSpecifier.targetLanguageName» «it.asGetter»() const;
		
		«IF !readonly && !const»
			/*! Sets the value of the variable '«name»' that is defined in the «scope.scopeDescription». */
			void «asSetter»(«typeSpecifier.targetLanguageName» value);
			
		«ENDIF»
	'''
	
	def dispatch functionPrototypes(Declaration it) ''''''
}