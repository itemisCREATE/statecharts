/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.types.generator.statechart.java.artifacts

import com.google.inject.Inject
import java.util.Collection
import org.yakindu.base.expressions.util.PackageNavigationExtensions
import org.yakindu.base.types.Package
import org.yakindu.base.types.Type
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.types.generator.artifacts.GeneratorArtifactConfiguration
import org.yakindu.sct.types.generator.artifacts.IGeneratorArtifactConfigurator
import org.yakindu.sct.types.generator.statechart.java.GenmodelEntries
import org.yakindu.sct.types.generator.statechart.java.naming.Naming

import static org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess.*

class JavaGeneratorArtifactConfigurator implements IGeneratorArtifactConfigurator {
	
	@Inject protected extension PackageNavigationExtensions
	@Inject protected extension GenmodelEntries
	@Inject protected extension Naming
	@Inject protected extension ICoreLibraryHelper libraryHelper
	@Inject protected GeneratorEntry entry
	
	protected GeneratorArtifactConfiguration config
	
	override configure(Collection<Package> packages, ISCTFileSystemAccess fileSystemAccess) {
		config = new GeneratorArtifactConfiguration(fileSystemAccess)
		packages.forEach[ p |
			statemachineWorkUnits(p)
		]
		config
	}
	
	def protected statemachineWorkUnits(Package p) {
		p.name = entry.implementationPackageName
		
		val sc = entry.elementRef as Statechart
		
		// statemachine impl type
		val smImplType = getStatemachineType(p, sc)
		smImplType.name = sc.statemachineClassName
		val smImpl = config.configure(toFilePath(p, smImplType), entry.sourceOutput, smImplType, false)
		
		// statemachine interface
		val smIfaceType = getStatemachineInterface(p, sc)
		smIfaceType.name = sc.statemachineInterfaceName
		val smIface = config.configure(toFilePath(p, smIfaceType), entry.apiOutput, smIfaceType, false)
		
		// base interface
		val baseIfaceType = getIStatemachine(p, sc)
		val basePkg = baseIfaceType.containingPackage
		basePkg.name = entry.basePackageName
		baseIfaceType.name = baseStatemachineName
		val baseIface = config.configure(toFilePath(basePkg, baseIfaceType), entry.libraryOutput, baseIfaceType, false)
		
		smImpl.addDependencies(smIface)
		smIface.addDependencies(baseIface)
	}
	
	def protected toFilePath(Package p, Type t) {
		p.name.replace(".", "/") + "/" + t.name.java
	}
	
	def protected getStatemachineType(Package p, Statechart sc) {
		p.allTopLevelComplexTypes.findFirst[name.equalsIgnoreCase(sc.name)]
	}
	
	def protected getStatemachineInterface(Package p, Statechart sc) {
		p.allTopLevelComplexTypes.findFirst[name.equalsIgnoreCase("I" + sc.name)]
	}
	
	def protected getIStatemachine(Package p, Statechart sc) {
		p.allTopLevelComplexTypes.map[superTypes].flatten.map[type].findFirst[name == org.yakindu.sct.model.sequencer.types.IStatemachine.NAME]
	}
	 
	def protected getApiOutput(GeneratorEntry entry) {
		if (entry.apiTargetFolderValue !== null) {
			API_TARGET_FOLDER_OUTPUT
		} else {
			TARGET_FOLDER_OUTPUT
		}
	}

	def protected getLibraryOutput(GeneratorEntry entry) {
		if (entry.libraryTargetFolderValue !== null) {
			LIBRARY_TARGET_FOLDER_OUTPUT
		} else {
			entry.apiOutput
		}
	}

	def protected getSourceOutput(GeneratorEntry entry) {
		TARGET_FOLDER_OUTPUT
	}
	
}
