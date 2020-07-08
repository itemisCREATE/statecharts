/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.java.files

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper
import org.yakindu.sct.generator.java.GenmodelEntries
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

class ITracingListener {
	@Inject extension Naming
	@Inject extension GenmodelEntries
	
	@Inject extension ICoreLibraryHelper
	@Inject extension OutputConfigProvider

	def generateTracing(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		if (entry.skipLibraryFiles) {
			return
		}
		val fileName = entry.libraryPackage.toPath + '/' + traceInterface.java
		fsa.generateFile(fileName, entry.libraryOutputConfig, content(entry))
	}
	
	def private content(GeneratorEntry it) {
		'''
			«licenseText»
			package «libraryPackage»;
			
			/**
			 * Tracing interface for state machines.
			 * Must be implemented if tracing feature is used.
			 * Multiple listeners can be added to and removed from the state machine.
			 */
			public interface «traceInterface»<T> {
				
				/**
				 * «stateEnteredTraceFunctionID.toFirstUpper» will be called if any state has been entered.
				 */
				void «stateEnteredTraceFunctionID»(T state);
				
				/**
				* «stateExitedTraceFunctionID.toFirstUpper» will be called if any state has been exited.
				*/
				void «stateExitedTraceFunctionID»(T state);
			}
		'''
	}
}
