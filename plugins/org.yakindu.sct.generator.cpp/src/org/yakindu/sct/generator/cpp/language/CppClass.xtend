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
package org.yakindu.sct.generator.cpp.language

import java.util.EnumMap
import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.sct.generator.core.language.CodePart
import org.yakindu.sct.generator.core.language.ICodePart
import org.yakindu.sct.generator.core.language.IDeclarable
import org.yakindu.sct.generator.core.language.IDocumentationOwner
import org.yakindu.sct.generator.core.language.IFunction
import org.yakindu.sct.generator.core.language.IModule
import org.yakindu.sct.generator.core.language.IModuleMember

/**
 * @author rbeckmann
 *
 */
class CppClass extends CodePart implements IModule, IDeclarable, IDocumentationOwner {
	@Accessors protected CharSequence name;
	@Accessors protected IModule parent;
	@Accessors(PROTECTED_SETTER, PUBLIC_GETTER) protected Map<Visibility, List<IModuleMember>> members = new EnumMap(Visibility);
	@Accessors protected CharSequence documentation = ""
	@Accessors protected List<CharSequence> extendedClasses
	
	def addMember(IModuleMember member, Visibility visibility) {
		this.members.get(visibility) += member
	}
	
	override toString() {
		var builder = new StringBuilder()
		for(member : members.values.flatten.filter(Function)) {
			member.parent = this
			builder.append(member)
			builder.append("\n")
		}
		return builder.toString
	}
	
	override getName() {
		if(parent === null) {
			name
		} else {
			parent.name + "::" + name
		}
	}
	
	override declare() {
		'''
		«documentation»
		class «getName»
		{
			«memberBlock(Visibility.PUBLIC)»
			«memberBlock(Visibility.PROTECTED)»
			«memberBlock(Visibility.PRIVATE)»
		};
		'''
	}
	
	def memberBlock(Visibility visibility) {
		'''
		«visibility»:
			«FOR member : members.get(visibility).filter(IDeclarable)»
			«member.declare»
			«ENDFOR»
		'''
	}
	
	def findFunction(CharSequence name) {
		members.values.flatten.filter(IFunction).filter[it.name == name]
	}
	
	
	
	
}