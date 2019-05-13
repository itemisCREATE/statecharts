/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	itemis AG
*
*/
package org.yakindu.sct.types.generator.statechart.cpp.artifacts

import com.google.inject.Inject
import java.util.Collection
import java.util.List
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.types.generator.artifacts.GeneratorArtifact
import org.yakindu.sct.types.generator.artifacts.GeneratorArtifactConfiguration
import org.yakindu.sct.types.generator.artifacts.GeneratorArtifactConfigurationExtensions
import org.yakindu.sct.types.generator.cpp.CppConstructorGenerator
import org.yakindu.sct.types.generator.cpp.CppTargetPlatform
import org.yakindu.sct.types.generator.cpp.artifacts.DefaultCppGeneratorArtifactConfigurator
import org.yakindu.sct.types.generator.cpp.files.CppStatemachineInterface
import org.yakindu.sct.types.generator.cpp.files.CppTypes

import static org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess.*

class CppGeneratorArtifactConfigurator extends DefaultCppGeneratorArtifactConfigurator {

	@Inject protected ICoreLibraryHelper libraryHelper
	@Inject protected extension CppTypes
	@Inject protected extension CppStatemachineInterface
	@Inject protected extension GeneratorArtifactConfigurationExtensions
	@Inject protected extension CppConstructorGenerator
	protected GeneratorArtifactConfiguration config
	@Inject protected GeneratorEntry entry

	override configure(Collection<Package> packages, ISCTFileSystemAccess fileSystemAccess) {
		config = new GeneratorArtifactConfiguration(fileSystemAccess)
		this.entry = entry
		val scTypes = configureContent("sc_types.h", createScTypes)
		val statemachineInterface = configureContent("StatemachineInterface.h", createStatemachineInterface)
		configureSources(packages, scTypes, statemachineInterface)
		config
	}
	
	def protected configureSources(Collection<Package> packages, GeneratorArtifact<?> scTypes, GeneratorArtifact<?> statemachineInterface) {
		for(p:packages){
		val List<Declaration> sourceContents = newArrayList
		val List<Declaration> classContents = newArrayList
		
		val copyCT = p.eAllContents.filter(ComplexType).toList
		copyCT.forEach[ct | sourceContents.addAll(ct.features.filter(Property).filter[const].toList)]
		copyCT.forEach[ct | sourceContents.addAll(ct.features.filter(Operation).filter[!(it instanceof OperationDefinition)].filter[!(it.innerConstructor) && !(it.ocbDestructor)].toList)]
		classContents.addAll(EcoreUtil.copy(p).member)
		classContents.filter(ComplexType).forEach[ cT |
			cT.removeBodysFromOperations
			cT.removeInitialValueFromConsts
		]
		
		val class = config.configure(p.member.get(0).name + CppTargetPlatform.HEADER_FILE_ENDING, null, classContents, false)
		val source = config.configure(p.member.get(0).name + CppTargetPlatform.SOURCE_FILE_ENDING, null, sourceContents, false)
		
		source.addDependencies(class)
		class.addDependencies(scTypes, statemachineInterface)
		addExpressionDependendingHeaders(source)
		}
	}
	
	def protected configureContent(String filePath, CharSequence content){
		if (libraryHelper.getSkipLibraryFiles(entry)) {
			return null
		}
		if (libraryHelper.getLibraryTargetFolderValue(entry) !== null) {
			// generate into library target folder in case one is specified, as the contents are static
			config.configure(filePath, LIBRARY_TARGET_FOLDER_OUTPUT, content, false)
		} else if (libraryHelper.getApiTargetFolderValue(entry) !== null) {
			// generate into API target folder in case one is specified, as it is an interface
			config.configure(filePath, API_TARGET_FOLDER_OUTPUT, content, false)
		} else {
			// use default target folder path in case no library or API target folder is specified (the file will be overwritten there)
			config.configure(filePath, null, content, false)
		}
	}
}
