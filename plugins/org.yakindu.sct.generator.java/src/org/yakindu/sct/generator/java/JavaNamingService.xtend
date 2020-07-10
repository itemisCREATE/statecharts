/*
 *   Copyright (c) 2014-2015 committers of YAKINDU Statechart Tools.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   
 *   Contributors:
 *   	Axel Terfloth - Initial contribution
 */
package org.yakindu.sct.generator.java

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.HashSet
import java.util.Set
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.DefaultNamingService
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.base.types.Declaration
import org.yakindu.sct.model.stext.stext.InternalScope

/** 
 * Specific adaption of the default naming service to the needs of the java code generator.
 * 
 * @author axel terfloth (terfloth@itemis.de)
 * @author Markus Mühlbrandt (muehlbrandt@itemis.de)
 */
@Singleton
class JavaNamingService extends DefaultNamingService {

	@Inject extension SExecExtensions
	@Inject extension Naming

	Set<String> derivedIdentifiers = new HashSet

	override protected prefix(Step it, char separator) {
		switch (it) {
			case isCheckFunction: "check"
			case isEntryAction: "entryAction"
			case isExitAction: "exitAction"
			case isEffect: "effect"
			case isEnterSequence: "enterSequence"
			case isDeepEnterSequence: "deepEnterSequence"
			case isShallowEnterSequence: "shallowEnterSequence"
			case isExitSequence: "exitSequence"
			case isReactSequence: "react"
			default: ""
		}
	}

	override asIdentifier(String string) {
		super.asIdentifier(string).toFirstLower
	}

	override asEscapedIdentifier(String it) {
		var s = it
		if (s.isKeyword) {
			s = s + separator + 'ID'
		}
		return s.asIdentifier
	}

	override boolean isKeyword(String name) {
		return Keywords.JAVA_KEYWORD_SET.isKeyword(name)
	}

	def isStatemachineIdentifier(String name) {
		return Keywords.STATEMACHICHNE_KEYWORD_SET.isKeyword(name);
	}

	def isStatemachineInterfaceIdentifier(String name) {
		return Keywords.STATEMACHINE_INTERFACE_KEYWORD_SET.isKeyword(name)
	}

	def isDerivedIdentifier(String name) {
		return getDerivedIdentifiers.isKeyword(name);
	}
	
	def isStatemachineMethod(String name) {
		return Keywords.STATEMACHINE_METHOD_SET.isKeyword(name);
	}

	private def isKeyword(Set<String> set, String name) {
		return !set.findFirst [
			it.equalsIgnoreCase(name)
		].nullOrEmpty
	}
	
	def isKeyword(Declaration it) {
		
		if (name.isKeyword)
			return true

		switch eContainer {
			InterfaceScope: {
				return name.isStatemachineInterfaceIdentifier;
			}
			InternalScope: {
				return name.isStatemachineIdentifier || name.isDerivedIdentifier
			}
		}

		return false;
	}

	protected def getDerivedIdentifiers() {
		if (derivedIdentifiers.isEmpty) {
			if (activeFlow !== null) {
				activeFlow.interfaceScopes.forEach[derivedIdentifiers.add(interfaceName.asEscapedIdentifier)]
			}
		}
		return derivedIdentifiers
	}

}