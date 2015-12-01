/**
 *   Copyright (c) 2012 committers of YAKINDU and others.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   Contributors:
 *   	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.java

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.generator.core.impl.IExecutionFlowGenerator
import org.yakindu.sct.generator.core.util.GeneratorUtils
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.OUTLET_FEATURE_LIBRARY_TARGET_FOLDER

class ITimerCallback {

	@Inject
	extension Naming

	@Inject
	extension GenmodelEntries

	def generateITimerCallback(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		if (GeneratorUtils.getOutletFeatureConfiguration(entry).getParameterValue(
			OUTLET_FEATURE_LIBRARY_TARGET_FOLDER) != null) {
			// generate into library target folder in case one is specified, as the contents are static
			fsa.generateFile(entry.basePackagePath + '/' + iTimerCallback.java,
				IExecutionFlowGenerator.LIBRARY_TARGET_FOLDER_OUTPUT, content(entry))
		} else {
			// use default target folder path in case no library target folder is specified (the file will be overwritten there)
			fsa.generateFile(entry.basePackagePath + '/' + iTimerCallback.java, content(entry))
		}
	}

	def private content(GeneratorEntry entry) {
		'''
			«entry.licenseText»
			package «entry.getBasePackageName()»;
			
			/**
			* Interface for state machines which use timed event triggers.
			*/
			public interface ITimerCallback {
				
				/**
				* Callback method if a time event occurred.
				* 
				* @param eventID
				* 			:The id of the occurred event.
				*/
				public void timeElapsed(int eventID);
			}
		'''
	}
}