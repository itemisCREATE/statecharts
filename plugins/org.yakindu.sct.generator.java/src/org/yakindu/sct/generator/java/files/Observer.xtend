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
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper
import org.yakindu.sct.generator.java.GenmodelEntries
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.generator.java.features.OutEventObservables
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

class Observer {

	@Inject extension GenmodelEntries
	@Inject extension OutEventObservables
	@Inject extension Naming
	@Inject extension OutputConfigProvider
	@Inject extension ICoreLibraryHelper

	def generateObserver(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		if (entry.skipLibraryFiles) {
			return
		}
		val fileName = rxPackagePath + '/' + observerClass.java
		fsa.generateFile(fileName, entry.libraryOutputConfig, entry.content)
	}
	
	def private content(GeneratorEntry entry)
	'''
		«entry.licenseText»
		package «rxPackage»;
		
		public interface Observer<T> {
		
			void next(T value);
		
		}
	'''
}