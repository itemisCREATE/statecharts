/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	itemis AG
*
*/
package com.yakindu.sct.types.slang.generator.java

import com.google.inject.Inject
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.expressions.util.PackageNavigationExtensions
import org.yakindu.base.types.AnnotatableElement
import org.yakindu.base.types.AnnotationType
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.sct.types.generator.AbstractTypesGenerator
import org.yakindu.sct.types.generator.Expressions
import org.yakindu.sct.types.generator.ITypesGenerator
import org.yakindu.sct.types.generator.artifacts.Dependency.ArtifactDependency
import org.yakindu.sct.types.generator.artifacts.Dependency.StaticDependency
import org.yakindu.sct.types.generator.artifacts.GeneratorArtifact
import org.yakindu.sct.types.generator.artifacts.GeneratorArtifactConfiguration

import static org.eclipse.xtext.util.Strings.newLine

class JavaSlangGenerator extends AbstractTypesGenerator implements ITypesGenerator {

	@Inject extension Expressions
	@Inject protected extension PackageNavigationExtensions
	@Inject protected extension ConstructorBuilder
	
	override protected generate(GeneratorArtifact<?> artifact) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	def dispatch String doGenerate(GeneratorArtifact<?> it) {
		'''
		«content.doGenerateRoot(it)»
		'''
	}
	
	def dispatch String doGenerate(StaticDependency it) {
		'''import «dependency»;'''
	}
	
	def dispatch String doGenerate(ArtifactDependency it) {
		'''import «dependency.content.asImportString»;'''
	}
	
	def dispatch String asImportString(Object it) {
		'''Cannot convert to import string: «it»'''
	}
	
	def dispatch String asImportString(ComplexType it) {
		'''«containingPackage.name».«name»'''
	}

	def dispatch String doGenerateRoot(ComplexType it, GeneratorArtifact<?> artifact) '''
		«packageDefinition»
		
		«FOR i : (it.eContainer as Package).imports»
			import «i»;
		«ENDFOR»
		«artifact.imports»
		
		«doGenerate»
	'''
	
	def dispatch String doGenerateRoot(String it, GeneratorArtifact<?> artifact) '''
		«it»
	'''
	
	def packageDefinition(ComplexType it) '''package «containingPackage.name»;'''
	
	def imports(GeneratorArtifact<?> it) '''
		«FOR dep : dependencies»
			«dep.doGenerate»
		«ENDFOR»
	'''
	
	def dispatch String doGenerate(ComplexType it) '''
		«annotations(it)»
		«visibilityMod»«staticMod»«IF abstract»interface «ELSE»class «ENDIF»«name»«inheritance» {
			
			«FOR feature : features SEPARATOR newLine»
				«feature?.doGenerate»
			«ENDFOR»
			
		}
	'''
	
	def inheritance(ComplexType it)
		'''«FOR i : superTypes BEFORE (if (abstract) ' extends ' else ' implements ') SEPARATOR ', '»«i.code»«ENDFOR»'''
	
	def annotations(AnnotatableElement it) '''
		«IF annotationInfo !== null»«FOR annotation : it.annotationInfo.annotations SEPARATOR newLine»@«annotation.type.name»«ENDFOR»«ENDIF»
	'''

	def dispatch String doGenerate(EnumerationType it) '''
		«annotations(it)»
		«visibilityMod»enum «name» {
			«FOR literal : it.enumerator SEPARATOR ','»
				«literal.name»
			«ENDFOR»
		}
	'''

	def dispatch String doGenerate(Property it) '''
		«annotations(it)»
		«visibilityMod»«code»
	'''

	def dispatch String doGenerate(Operation it) '''
		«annotations(it)»
		«IF isConstructor && body !== null»
			«visibilityMod»«EcoreUtil2.getContainerOfType(it, ComplexType).name»(«FOR p : parameters SEPARATOR ', '»«annotations(p)» «p.typeSpecifier.code»«IF p.isVarArgs»...«ENDIF» «p.name»«ENDFOR»)«IF body !== null»«body.code»«ELSE»;«ENDIF» 
		«ELSEIF !isConstructor»
			«visibilityMod»«staticMod»«IF type === null»void«ELSE»«typeSpecifier.code»«ENDIF» «name»(«FOR p : parameters SEPARATOR ', '»«annotations(it)» «p.typeSpecifier.code»«IF p.isVarArgs»...«ENDIF» «p.name»«ENDFOR»)«IF body !== null»«body.code»«ELSE»;«ENDIF» 
		«ENDIF»
	'''

	def dispatch doGenerate(AnnotationType it) '''
		«visibilityMod»@interface «name» {}
	'''
	
	def dispatch String doGenerate(Object o) '''//Unknown object «o»'''

	def protected visibilityMod(Declaration it) '''«visibility.getName().toLowerCase» '''
	
	def protected staticMod(ComplexType it) '''«IF it.eContainer instanceof ComplexType»static «ENDIF»'''
	
	def protected staticMod(Declaration it) '''«IF it.isStatic»static «ENDIF»'''
	
}
