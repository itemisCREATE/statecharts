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
package org.yakindu.sct.types.generator.statechart.c.artifacts

import com.google.inject.Inject
import java.util.List
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Operation
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.types.generator.artifacts.IGeneratorArtifactConfigurator
import org.yakindu.sct.types.generator.c.artifacts.DefaultCGeneratorArtifactConfigurator
import org.yakindu.sct.types.generator.statechart.annotation.SCTGeneratorAnnotationLibrary

import static org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess.*

class CGeneratorArtifactConfigurator extends DefaultCGeneratorArtifactConfigurator implements IGeneratorArtifactConfigurator {
	
	@Inject protected extension SCTGeneratorAnnotationLibrary
	@Inject protected GeneratorEntry entry
	@Inject protected ICoreLibraryHelper libraryHelper
	
	override protected configureScTypes() {
		val filePath = "sc_types.h"
		if(libraryHelper.getSkipLibraryFiles(entry)) {
			return null
		}
		if (libraryHelper.getLibraryTargetFolderValue(entry) !== null) {
			// generate into library target folder in case one is specified, as the contents are static
			config.configure(filePath, LIBRARY_TARGET_FOLDER_OUTPUT, createScTypes, false)
		} else if (libraryHelper.getApiTargetFolderValue(entry) !== null) {
			// generate into API target folder in case one is specified, as it is an interface
			config.configure(filePath, API_TARGET_FOLDER_OUTPUT, createScTypes, false)
		} else {
			// use default target folder path in case no library or API target folder is specified (the file will be overwritten there)
			config.configure(filePath, null, createScTypes, false)
		}
	}
	
	protected override addOperationDeclarations(List<Declaration> headerContents, Operation opDecl, List<Declaration> sourceContents, Operation op) {
		if(opDecl.isAPI) {
			headerContents.add(opDecl)
		} else {
			sourceContents.add(0, opDecl)
		}
		return true // add(0, ..) returns void
	}
	
}
