package org.yakindu.sct.generator.java.templates

import java.util.Set
import java.util.TreeSet

class FileTemplate {
	protected CharSequence fileComment = ""
	protected CharSequence packageName = ""
	protected ClassTemplate classTemplate
	
	protected Set<CharSequence> imports = new TreeSet
	
	def public CharSequence generate() {
		'''
		«fileComment»
		«packageDeclaration»
		
		«generateImports»
		
		«classTemplate.generate()»
		'''
	}
	
	def public FileTemplate fileComment(CharSequence fileComment) {
		this.fileComment = fileComment
		this
	}
	
	def public FileTemplate packageName(CharSequence packageName) {
		this.packageName = packageName
		this
	}
	
	def public FileTemplate addImports(Iterable<CharSequence> imports) {
		this.imports += imports
		this
	}
	
	def public FileTemplate addImport(CharSequence imp) {
		this.imports += imp
		this
	}
	
	def public FileTemplate classTemplate(ClassTemplate template) {
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