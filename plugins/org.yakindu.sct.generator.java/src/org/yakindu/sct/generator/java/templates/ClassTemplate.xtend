/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.sct.generator.java.templates

import java.util.ArrayList
import java.util.List

class ClassTemplate {
	protected CharSequence classComment = ""
	protected CharSequence visibility = "public"
	protected CharSequence classType = "class"
	protected CharSequence className = "ClassTemplate"
	protected CharSequence superClass = ""
	protected List<CharSequence> interfaces = new ArrayList()
	protected CharSequence classContent = ""
	protected boolean isStatic = false
	protected boolean isAbstract = false
	
	protected new() {
	}
	
	def static ClassTemplate create() {
		return new ClassTemplate
	}
	
	def CharSequence generate() {
		'''
		«classComment»
		«generateVisibility»«classType» «className» «extend»«implement»{
			«classContent»
		}
		'''
	}
	
	def ClassTemplate classComment(CharSequence comment) {
		this.classComment = comment
		this
	}
	
	def ClassTemplate visibility(CharSequence visibility) {
		this.visibility = visibility
		this
	}
	
	def ClassTemplate classType(CharSequence classType) {
		this.classType = classType
		this
	}

	def ClassTemplate className(CharSequence className) {
		this.className = className
		this
	}
	
	def ClassTemplate superClass(CharSequence superClass) {
		this.superClass = superClass
		this
	}
	
	def ClassTemplate classContent(CharSequence classContent) {
		this.classContent = classContent
		this
	}
	
	def ClassTemplate isStatic(boolean isStatic) {
		this.isStatic = isStatic
		this
	}
	
	def ClassTemplate isAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract
		this
	}
	
	def ClassTemplate addInterfaces(Iterable<CharSequence> interfaces) {
		this.interfaces += interfaces
		this
	}
	
	def ClassTemplate addInterface(CharSequence iFace) {
		this.interfaces += iFace
		this
	}
	
	def protected final CharSequence generateVisibility() {
		var vis = ""
		if(visibility != "") {
			vis += visibility + " "
		}
		if(isStatic) {
			vis += "static "
		}
		if(isAbstract) {
			vis += "abstract "
		}
		vis
	}
	
	def protected final CharSequence extend() {
		if(superClass != "") {
			'''extends «superClass» '''
		} else {
			""
		}
	}
	
	def protected final CharSequence implement() {
		if(!interfaces.nullOrEmpty) {
			'''implements «interfaces.join(", ")» '''
		} else {
			""
		}
	}
}
