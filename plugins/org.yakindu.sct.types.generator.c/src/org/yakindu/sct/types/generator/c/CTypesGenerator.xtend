/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.types.generator.c

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.sct.types.generator.AbstractTypesGenerator
import org.yakindu.sct.types.generator.ITargetPlatform
import org.yakindu.sct.types.generator.ITypesGenerator
import org.yakindu.sct.types.generator.artifacts.Dependency.ArtifactDependency
import org.yakindu.sct.types.generator.artifacts.Dependency.StaticDependency
import org.yakindu.sct.types.generator.artifacts.GeneratorArtifact
import org.yakindu.sct.types.generator.c.files.CTypes

import static org.eclipse.xtext.util.Strings.*

class CTypesGenerator extends AbstractTypesGenerator implements ITypesGenerator {

	@Inject extension CExpressions
	@Inject protected ITargetPlatform platform
	@Inject protected extension CTypes

	override generate(GeneratorArtifact<?> artifact) {
		artifact.doGenerate
	}
	
	def dispatch String doGenerate(GeneratorArtifact<?> it) {
		'''
			«includeGuardStart(CTargetPlatform.HEADER_FILE_ENDING)»
			
			«FOR dep : dependencies AFTER newLine»
				«dep.doGenerate»
			«ENDFOR»
			«externCStart»
			«content.doGenerate»
			«externCEnd»
			
			«includeGuardEnd(CTargetPlatform.HEADER_FILE_ENDING)»
		'''
	}
	
	def protected externCStart(GeneratorArtifact<?> it) {
		if (name.endsWith(CTargetPlatform.HEADER_FILE_ENDING)) {
			return '''
				#ifdef __cplusplus
				extern "C" {
				#endif
			'''
		}
	}
	
	def protected externCEnd(GeneratorArtifact<?> it) {
		if (name.endsWith(CTargetPlatform.HEADER_FILE_ENDING)) {
			return '''
				#ifdef __cplusplus
				}
				#endif
			'''
		}
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
	

	def dispatch String doGenerate(Package it) {
		'''
			«FOR i : imports»
				#include <«i»>
			«ENDFOR»	
			«FOR member : member SEPARATOR '\n'»
				«member?.declaration»
			«ENDFOR»
		'''
	}

	def String declaration(Declaration member) '''
		«member?.doGenerate»
	'''

	def dispatch String doGenerate(ComplexType it) {
		'''
			typedef struct {
				«FOR declaration : features»
					«declaration?.doGenerate»
				«ENDFOR»
			} «name»;
		'''
	}

	def dispatch String doGenerate(EnumerationType it) '''
		typedef enum {
			«FOR literal : it.enumerator SEPARATOR ','»
				«literal.name»
			«ENDFOR»
		} «name»;
	'''

	def dispatch String doGenerate(Property it) {
		code.toString
	}

	def dispatch String doGenerate(Operation it) '''
		«IF isStatic»static «ENDIF»«IF type === null»void«ELSE»«typeSpecifier.code»«ENDIF» «name»(«FOR p : parameters SEPARATOR ', '»«p.typeSpecifier.code» «p.name»«ENDFOR»)«IF body !== null»«body.code»«ELSE»;«ENDIF» 
	'''

	def dispatch String doGenerate(Object o) {
		'''//Unknown object «o»'''

	}

	def protected isInterface(ComplexType it) {
		!features.filter(Operation).exists[body !== null]
	}
	
	def protected isTopLevel(EObject it) {
		return eContainer instanceof Package
	}
}
