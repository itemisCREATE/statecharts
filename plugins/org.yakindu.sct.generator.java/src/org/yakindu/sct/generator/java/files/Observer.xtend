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
		val fileName = entry.basePackagePath + '/' + observerClass.java
		fsa.generateFile(fileName, entry.libraryOutputConfig, entry.content)
	}
	
	def private content(GeneratorEntry entry)
	'''
		«entry.licenseText»
		package «entry.getBasePackageName()»;
		
		public interface Observer<T> {
		
			void next(T value);
		
		}
	'''
}