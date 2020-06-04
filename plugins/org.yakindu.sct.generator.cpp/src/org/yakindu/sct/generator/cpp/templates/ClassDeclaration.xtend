package org.yakindu.sct.generator.cpp.templates

import java.util.List

class ClassDeclaration {
	
	public static val PUBLIC = "public";
	public static val PROTECTED = "protected"
	public static val PRIVATE = "private";
	
	protected CharSequence name
	protected CharSequence comment
	
	protected List<CharSequence> superTypes = newArrayList
	
	protected List<CharSequence> publicMembers = newArrayList
	protected List<CharSequence> protectedMembers = newArrayList
	protected List<CharSequence> privateMembers = newArrayList
	
	def ClassDeclaration name(CharSequence name) {
		this.name = name
		this
	}
	
	def ClassDeclaration comment(CharSequence comment) {
		this.comment = comment
		this
	}
	
	def ClassDeclaration superType(CharSequence superType) {
		superTypes.add(superType)
		this
	}
	
	def ClassDeclaration publicMember(CharSequence member) {
		publicMembers.add(member)
		this
	}

	def ClassDeclaration protectedMember(CharSequence member) {
		protectedMembers.add(member)
		this
	}

	def ClassDeclaration privateMember(CharSequence member) {
		privateMembers.add(member)
		this
	}
	
	def ClassDeclaration member(CharSequence visibility, CharSequence member) {
		switch(visibility) {
			case PUBLIC: publicMembers
			case PROTECTED: protectedMembers
			case PRIVATE: privateMembers
		}.add(member)
		this
	}
	
	def ClassDeclaration constructorDeclaration(boolean virtual, boolean pure, List<CharSequence> parameters) {
		publicMembers.add(
			'''«IF virtual || pure»virtual «ENDIF»«name»(«FOR p : parameters»«p»«ENDFOR»)«IF pure» = 0«ENDIF»;'''
		)
		this
	}
	
	def ClassDeclaration constructorDeclaration(boolean virtual, List<CharSequence> parameters) {
		constructorDeclaration(virtual, false, parameters)
	}
	
	
	def ClassDeclaration constructorDeclaration(List<CharSequence> parameters) {
		constructorDeclaration(false, parameters)
	}
	
	def ClassDeclaration constructorDeclaration() {
		constructorDeclaration(false, emptyList)
	}
	
	def ClassDeclaration destructorDeclaration(boolean virtual, boolean pure) {
		publicMembers.add(
			'''«IF virtual || pure»virtual «ENDIF»~«name»()«IF pure» = 0«ENDIF»;'''
		)
		this
	}
	
	def ClassDeclaration destructorDeclaration(boolean virtual) {
		destructorDeclaration(virtual, false)
	}
	
	def ClassDeclaration destructorDeclaration() {
		destructorDeclaration(false, false)
	}
	
	def generate() {
		if(name === null || name == "") {
			return ""
		}
		'''
		«IF comment !== null && comment != ""»
		«comment»
		«ENDIF»
		class «name»«IF !superTypes.empty» : «FOR sT : superTypes SEPARATOR ", "»«sT»«ENDFOR»«ENDIF»
		{
			«IF !publicMembers.empty»
			public:
				«FOR member : publicMembers»
				«member»
				
				«ENDFOR»
				
			«ENDIF»
			«IF !protectedMembers.empty»
			protected:
				«FOR member : protectedMembers»
				«member»
				
				«ENDFOR»
				
			«ENDIF»
			«IF !privateMembers.empty»
			private:
				«FOR member : privateMembers»
				«member»
				
				«ENDFOR»
				
			«ENDIF»
		};
		'''
	}
	
}