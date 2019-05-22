/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator.cpp

import com.google.inject.Inject
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.base.types.Visibility
import org.yakindu.sct.types.generator.AbstractTypesGenerator
import org.yakindu.sct.types.generator.ITargetPlatform
import org.yakindu.sct.types.generator.ITypesGenerator
import org.yakindu.sct.types.generator.artifacts.Dependency.ArtifactDependency
import org.yakindu.sct.types.generator.artifacts.Dependency.StaticDependency
import org.yakindu.sct.types.generator.artifacts.GeneratorArtifact

import static org.eclipse.xtext.util.Strings.*
import org.yakindu.sct.types.generator.c.CTypesGeneratorExtensions
import org.yakindu.sct.types.generator.cpp.annotation.CoreCppGeneratorAnnotationLibrary

class CppTypesGenerator extends AbstractTypesGenerator implements ITypesGenerator {

	@Inject protected extension CppExpressions
	@Inject protected extension ITargetPlatform
	@Inject protected extension CppConstructorGenerator
	@Inject protected extension CppNamespaceGenerator
	@Inject protected extension CTypesGeneratorExtensions
	@Inject protected extension CoreCppGeneratorAnnotationLibrary

	override generate(GeneratorArtifact<?> artifact) {
		artifact.doGenerate
	}

	def dispatch String doGenerate(GeneratorArtifact<?> it) {
		'''
			«includeGuardStart(CppTargetPlatform.HEADER_FILE_ENDING)»
			
			«FOR dep : dependencies AFTER newLine»
				«dep.doGenerate»
			«ENDFOR»
			«content.namespaceStart»
			«content.doGenerate»
			«content.namespaceEnd»
			
			«includeGuardEnd(CppTargetPlatform.HEADER_FILE_ENDING)»
		'''
	}

	def dispatch String doGenerate(Iterable<Declaration> it) {
		'''
			«FOR decl : it»
				«decl.doGenerate»
				
			«ENDFOR»
		'''
	}

	def dispatch String doGenerate(CharSequence it) {
		toString
	}

	def dispatch String doGenerate(StaticDependency it) {
		'''#include <«dependency.toString»>'''
	}

	def dispatch String doGenerate(ArtifactDependency it) {
		val path = owner.generatorConfiguration.relativeTo(dependency, owner)
		'''#include "«path»"'''
	}

	def declaration(Declaration member) '''
		«member?.doGenerate»
	'''

	def dispatch String doGenerate(ComplexType it) '''
	class «name» «FOR i : superTypes BEFORE ': ' SEPARATOR ', '»public «i.code»«ENDFOR»
	{
		public:
			«FOR declaration : features.filter[visibility == Visibility.PUBLIC] SEPARATOR '\n'»
				«declaration?.declaration»
			«ENDFOR»
			
		private:
			«friendClass»
			«FOR declaration : features.filter[visibility == Visibility.PROTECTED] SEPARATOR '\n'»
				«declaration?.declaration»
			«ENDFOR»
	};'''

	def dispatch String doGenerate(EnumerationType it) '''
		typedef enum {
			«FOR literal : it.enumerator SEPARATOR ','»
				«literal.name»
			«ENDFOR»
		} «name»;
	'''

	def dispatch String doGenerate(Property it) '''
		«IF !invisible»«code.toString»«ENDIF»
	'''

	def dispatch String doGenerate(Operation it) '''
		«IF isConstructorOrDeconstructor»
			«generateConstructor»
		«ELSE»
			«IF isVirtual || isPure»virtual «ENDIF»«IF type === null»void«ELSE»«IF body !== null»«accessType»«ENDIF»«typeSpecifier.code»«ENDIF» «IF body !== null»«access»«ENDIF»«name»«generateParameters»«IF body !== null»«body.code»«ELSE»«IF isPure» = 0«ENDIF»;«ENDIF»
		«ENDIF»
	'''

	def String generateParameters(Operation it) {
		'''(«FOR p : parameters SEPARATOR ', '»«p.typeSpecifier.code» «p.name»«ENDFOR»)'''
	}

	def protected accessType(Operation it) {
		val typeArguments = typeSpecifier.typeArguments
		var namespaces = newArrayList
		for (typeSpecifier : typeArguments) {
			var cT = typeSpecifier.type.eContainer
			while (cT instanceof ComplexType) {
				namespaces.add(0, cT.name.toFirstUpper)
				cT = cT.eContainer
			}
		}
		return namespaces.join("", "::", "::", [it.toString])
	}

	def protected visibility(Declaration it) {
		visibility.getName().toLowerCase
	}

	def dispatch String doGenerate(Object o) {
		'''//Unknown object «o»'''
	}

	def access(Operation it) {
		var namespaces = newArrayList
		var cT = it.eContainer
		while (cT instanceof ComplexType) {
			namespaces.add(0, cT.name.toFirstUpper)
			cT = cT.eContainer
		}
		
		return namespaces.filterNull.join("", "::", "::", [it.toString])
	}

	def protected getFriendClass(ComplexType it) {
		if (eContainer instanceof ComplexType) {
			return '''friend class «(eContainer as ComplexType).name»;'''
		}
	}

}
