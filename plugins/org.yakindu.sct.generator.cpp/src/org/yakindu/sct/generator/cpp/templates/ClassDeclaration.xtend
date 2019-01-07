package org.yakindu.sct.generator.cpp.templates

import java.util.List

class ClassDeclaration {
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
			case "public": publicMembers
			case "protected": protectedMembers
			case "private": privateMembers
		}.add(member)
		this
	}
	
	def ClassDeclaration constructorDeclaration(boolean virtual, List<CharSequence> parameters) {
		publicMembers.add(
			'''«IF virtual»virtual «ENDIF»«name»(«FOR p : parameters»«p»«ENDFOR»);'''
		)
		this
	}
	
	def ClassDeclaration destructorDeclaration(boolean virtual) {
		publicMembers.add(
			'''«IF virtual»virtual «ENDIF»~«name»();'''
		)
		this
	}
	
	def generate() {
		'''
		«IF comment !== null && comment != ""»
		«comment»
		«ENDIF»
		class «name»«IF !superTypes.empty» : «FOR sT : superTypes SEPARATOR ", "»sT«ENDFOR»«ENDIF»
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