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
import org.yakindu.sct.generator.core.language.CharSequenceList
import org.yakindu.sct.generator.core.language.CodePart
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
	@Accessors protected boolean declareChildNested = true
	
	new() {
		this.members.put(Visibility.PUBLIC, newArrayList)
		this.members.put(Visibility.PROTECTED, newArrayList)
		this.members.put(Visibility.PRIVATE, newArrayList)
	}
	
	def addMember(IModuleMember member, Visibility visibility) {
		this.members.get(visibility) += member
		member.parent = this
	}
	
	override toString() {
		var builder = new StringBuilder()
		builder.memberBlock(Visibility.PUBLIC)
		builder.memberBlock(Visibility.PROTECTED)
		builder.memberBlock(Visibility.PRIVATE)
		return builder.toString
	}
	
	def memberBlock(StringBuilder builder, Visibility visibility) {
		for(member : members.get(visibility).filter(Function)) {
			builder.append(member)
			builder.append("\n")
		}
		
		for(member : members.get(visibility).filter(CppClass)) {
			builder.append(member)
			builder.append("\n")
		}
	}
	
	override getName() {
		if(parent === null) {
			name
		} else {
			parent.name + "::" + name
		}
	}
	
	def getDeclarationName() {
		if(declareChildNested) name
		else getName()
	}
	
	override declare() {
		'''
		«documentation»
		class «getDeclarationName»«extended»
		{
			«declareMemberBlock(Visibility.PUBLIC)»
			«declareMemberBlock(Visibility.PROTECTED)»
			«declareMemberBlock(Visibility.PRIVATE)»
		};
		'''
	}
	
	def extended() {
		if(extendedClasses !== null) {
			''': «new CharSequenceList(extendedClasses, ", ")»'''
		}
	}
	
	def declareMemberBlock(Visibility visibility) {
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