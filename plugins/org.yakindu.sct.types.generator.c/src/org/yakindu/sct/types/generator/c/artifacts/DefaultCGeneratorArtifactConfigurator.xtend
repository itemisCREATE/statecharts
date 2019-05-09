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
package org.yakindu.sct.types.generator.c.artifacts

import com.google.inject.Inject
import java.util.Collection
import java.util.List
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.types.generator.artifacts.GeneratorArtifact
import org.yakindu.sct.types.generator.artifacts.GeneratorArtifactConfiguration
import org.yakindu.sct.types.generator.artifacts.GeneratorArtifactConfigurationExtensions
import org.yakindu.sct.types.generator.artifacts.IGeneratorArtifactConfigurator
import org.yakindu.sct.types.generator.c.CTargetPlatform
import org.yakindu.sct.types.generator.c.files.CTypes

import static org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess.*

class DefaultCGeneratorArtifactConfigurator implements IGeneratorArtifactConfigurator {
	
	@Inject protected extension CTypes
	@Inject protected extension GeneratorArtifactConfigurationExtensions
	protected GeneratorArtifactConfiguration config
	
	override configure(Collection<Package> packages, ISCTFileSystemAccess fileSystemAccess) {
		config = new GeneratorArtifactConfiguration(fileSystemAccess)
		val scTypes = configureScTypes
		configureSources(packages, scTypes)
		config
	}
	
	def protected configureSources(Collection<Package> packages, GeneratorArtifact<?> scTypes) {
		for(p : packages) {
			val List<Declaration> headerContents = newArrayList
			val List<Declaration> sourceContents = newArrayList
			val List<Declaration> reqHeaderContents = newArrayList
			// Separate list to hold the source file's operation declarations for later addition
			val List<Declaration> implOpDecls = newArrayList
			val header = config.configure(p.name + CTargetPlatform.HEADER_FILE_ENDING, null, headerContents, false)
			val source = config.configure(p.name + CTargetPlatform.SOURCE_FILE_ENDING, null, sourceContents, false)
			val reqHeader = config.configure(p.name + "Required" + CTargetPlatform.HEADER_FILE_ENDING, null, reqHeaderContents, false)
			
			p.member.filter(ComplexType).forEach [
				headerContents.add(it)
			]
			p.member.filter(Operation).forEach[ op |
				if(op instanceof OperationDefinition) {
					reqHeaderContents.add(op)
				} else if(op.public) {
					val opDecl = EcoreUtil.copy(op)
					opDecl.body = null
					headerContents.add(opDecl)
					sourceContents.add(op)
				} else {
					op.static = true
					val opDecl = EcoreUtil.copy(op)
					opDecl.body = null
					// remember declaration in source file for later
					implOpDecls.add(opDecl)
					sourceContents.add(op)
				}
			]
			// add all declarations to the beginning, in the order in which they were built.
			sourceContents.addAll(0, implOpDecls)
			
			reqHeader.addDependencies(header, scTypes)
			header.addDependency(scTypes)
			
			source.addDependencies(scTypes)
			if(reqHeader.content.empty) {
				source.addDependency(header)
			} else {
				source.addDependency(reqHeader)
			}
		}
			
	}
	
	def protected configureScTypes() {
		val filePath = "sc_types.h"
		config.configure(filePath, LIBRARY_TARGET_FOLDER_OUTPUT, createScTypes, false)
	}
}
