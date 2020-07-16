/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp

import org.yakindu.base.types.Event
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.cpp.templates.ClassDeclaration
import org.yakindu.sct.model.stext.stext.StatechartScope
import com.google.inject.Inject
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.extensions.SExecExtensions

/**
 * @author Robin Herrmann
 */
class CppObservables {
	
	@Inject protected extension SExecExtensions
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension CppNaming

	def createObserverClass(Event shadowEvent, ClassDeclaration observerDecl, StatechartScope scope) {
		observerDecl.name(shadowEvent.observerClass)
		observerDecl.superType('''public sc::rx::SingleSubscriptionObserver<«shadowEvent.typeSpecifier.targetLanguageName»>''')
		observerDecl.member(ClassDeclaration::PUBLIC, shadowEvent.createObserverConstructor(scope))
		observerDecl.member(ClassDeclaration::PUBLIC, shadowEvent.createObserverNextImpl )
		observerDecl.member(ClassDeclaration::PUBLIC, scope.createInterfaceMember)
		return observerDecl
	}
	
	def CharSequence createObserver(Event it, ClassDeclaration scopeDecl){
		'''
		«observerClass» «observer»;«»
		'''
	}
	
	def CharSequence createObserverConstructor(Event it, StatechartScope scope){
		'''
			«observerClass»(«scope.interfaceName»* i) :
				SingleSubscriptionObserver(),
				«interfaceMember»(i)
			{}
		'''
	}
	
	def createInterfaceMember(StatechartScope scope) {
		'''«scope.getInterfaceName»* «interfaceMember»;'''
	}
	
	def CharSequence createObserverNextImpl(Event it) {
		'''
		virtual void next(«IF ITypeSystem.VOID !== typeSpecifier.targetLanguageName»«typeSpecifier.targetLanguageName» value«ENDIF») {
			this->«interfaceMember»->«event.asRaiser»(«IF hasValue»value«ENDIF»);
		}
		'''
	}
}