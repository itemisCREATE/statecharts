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
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Constructor
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper
import org.yakindu.sct.model.sequencer.util.SequencerAnnotationLibrary
import org.yakindu.sct.model.sgen.GeneratorEntry
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
	@Inject protected extension SequencerAnnotationLibrary
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
		configureSources(packages, scTypes)
		config
	}
	
	override protected configureSources(Collection<Package> packages, GeneratorArtifact<?> scTypes) {
		for(p:packages){
			p.member.filter(ComplexType).filter[isStatemachineType].forEach[
				statemachine |
				
				val statemachineHeader = config.configure(statemachine.name + CppTargetPlatform.HEADER_FILE_ENDING, null, newArrayList, false)
				val statemachineSource = config.configure(statemachine.name + CppTargetPlatform.SOURCE_FILE_ENDING, null, newArrayList, false)
				
				statemachineHeader.addDependency(scTypes)
				
				statemachineSource.content.addAll(
					statemachine.eAllContents.filter(Operation).filter[body !== null].filter[!constructorOrDeconstructor].toList
				)
				
				val pkgCopy = EcoreUtil.copy(p)
				val smCopy = pkgCopy.member.get(p.member.indexOf(statemachine)) as ComplexType
				smCopy.removeBodysFromOperations
				statemachineHeader.content.add(smCopy)
				
				statemachine.superTypes.map[type as ComplexType].forEach[ superType |
					superType.removeBodysFromOperations
					val superTypeHeader = config.configure(superType.name + CppTargetPlatform.HEADER_FILE_ENDING, null, newArrayList, false)
					superTypeHeader.content.add(superType)
					statemachineHeader.addDependency(superTypeHeader)
				]
				
				statemachineSource.addDependency(statemachineHeader)
				statemachineSource.addExpressionDependendingHeaders
			]

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
