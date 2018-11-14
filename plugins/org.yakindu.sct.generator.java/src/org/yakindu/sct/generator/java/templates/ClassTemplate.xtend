package org.yakindu.sct.generator.java.templates

import java.util.ArrayList
import java.util.List

public class ClassTemplate {
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
	
	def public static ClassTemplate create() {
		return new ClassTemplate
	}
	
	def public CharSequence generate() {
		'''
		«classComment»
		«generateVisibility» «classType» «className» «extend»«implement»{
			«classContent»
		}
		'''
	}
	
	def public ClassTemplate classComment(CharSequence comment) {
		this.classComment = comment
		this
	}
	
	def public ClassTemplate visibility(CharSequence visibility) {
		this.visibility = visibility
		this
	}
	
	def public ClassTemplate classType(CharSequence classType) {
		this.classType = classType
		this
	}

	def public ClassTemplate className(CharSequence className) {
		this.className = className
		this
	}
	
	def public ClassTemplate superClass(CharSequence superClass) {
		this.superClass = superClass
		this
	}
	
	def public ClassTemplate classContent(CharSequence classContent) {
		this.classContent = classContent
		this
	}
	
	def public ClassTemplate isStatic(boolean isStatic) {
		this.isStatic = isStatic
		this
	}
	
	def public ClassTemplate isAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract
		this
	}
	
	def public ClassTemplate addInterfaces(Iterable<CharSequence> interfaces) {
		this.interfaces += interfaces
		this
	}
	
	def public ClassTemplate addInterface(CharSequence iFace) {
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