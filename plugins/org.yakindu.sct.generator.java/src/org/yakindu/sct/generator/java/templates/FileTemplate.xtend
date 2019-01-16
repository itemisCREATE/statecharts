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

import java.util.Set
import java.util.TreeSet

class FileTemplate {
	protected CharSequence fileComment = ""
	protected CharSequence packageName = ""
	protected ClassTemplate classTemplate
	
	protected Set<CharSequence> imports = new TreeSet
	
	def static FileTemplate create() {
		return new FileTemplate()
	}
	
	def CharSequence generate() {
		'''
		«fileComment»
		«packageDeclaration»
		
		«generateImports»
		
		«classTemplate.generate()»
		'''
	}
	
	protected new() {}
	
	def FileTemplate fileComment(CharSequence fileComment) {
		this.fileComment = fileComment
		this
	}
	
	def FileTemplate packageName(CharSequence packageName) {
		this.packageName = packageName
		this
	}
	
	def FileTemplate addImports(Iterable<CharSequence> imports) {
		this.imports += imports
		this
	}
	
	def FileTemplate addImport(CharSequence imp) {
		this.imports += imp 
		this
	}
	
	def FileTemplate addImport(CharSequence imp, boolean condition) {
		if(condition) {
			addImport(imp)
		}
		this
	}
	
	def FileTemplate classTemplate(ClassTemplate template) {
		this.classTemplate = template
		this
	}

	def protected final CharSequence packageDeclaration() {
		if(packageName != "") {
			'''package «packageName»;'''
		} else {
			''''''
		}
	}
	
	def protected final CharSequence generateImports() {
		'''
		«FOR i : imports»
		import «i»;
		«ENDFOR»
		'''
	}
}
