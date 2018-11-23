package org.yakindu.sct.generator.java

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper
import static org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess.*

class ITracing {
	@Inject extension Naming
	@Inject extension GenmodelEntries
	
	@Inject ICoreLibraryHelper outletFeatureHelper

	def generateTracing(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		if(outletFeatureHelper.getSkipLibraryFiles(entry)) {
			return
		}
		if (outletFeatureHelper.getLibraryTargetFolderValue(entry) !== null) {
			// generate into library target folder in case one is specified, as the contents are static
			fsa.generateFile(entry.basePackagePath + '/' + traceInterface.java,
				LIBRARY_TARGET_FOLDER_OUTPUT, content(entry))
		} else if (outletFeatureHelper.getApiTargetFolderValue(entry) !== null) {
			// generate into API target folder in case one is specified, as it is an interface
			fsa.generateFile(entry.basePackagePath + '/' + traceInterface.java,
				API_TARGET_FOLDER_OUTPUT, content(entry))
		} else {
			// use default target folder path in case no library or API target folder is specified (the file will be overwritten there)
			fsa.generateFile(entry.basePackagePath + '/' + traceInterface.java, content(entry))
		}
//		fsa.generateFile(entry.basePackagePath + '/' + traceInterface.java, content(entry))
	}

	def private content(GeneratorEntry entry) '''
	package tracingjava;
	
	public interface «traceInterface»<T> {
		abstract void stateEntered(T state);
		abstract void stateExited(T state);
	}
	'''
}
