/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.java.files

import com.google.inject.Inject
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper
import org.yakindu.sct.model.sgen.GeneratorEntry

import static org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess.*

class OutputConfigProvider {

	@Inject protected extension ICoreLibraryHelper

	def getLibraryOutputConfig(GeneratorEntry entry) {
		if (entry.libraryTargetFolderValue !== null) {
			return LIBRARY_TARGET_FOLDER_OUTPUT
		}
		return entry.apiOutputConfig
	}

	def getApiOutputConfig(GeneratorEntry entry) {
		if (entry.apiTargetFolderValue !== null) {
			return API_TARGET_FOLDER_OUTPUT
		}
		return entry.defaultOutputConfig
	}
	
	
	def getDefaultOutputConfig(GeneratorEntry entry) {
		DEFAULT_OUTPUT
	}
	
}
