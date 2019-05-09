package org.yakindu.sct.types.generator.statechart.c.artifacts

import com.google.inject.Inject
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.types.generator.artifacts.IGeneratorArtifactConfigurator
import org.yakindu.sct.types.generator.c.artifacts.DefaultCGeneratorArtifactConfigurator

import static org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess.*

class CGeneratorArtifactConfigurator extends DefaultCGeneratorArtifactConfigurator implements IGeneratorArtifactConfigurator {
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
	
}
