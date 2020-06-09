package org.yakindu.sct.generator.java.files

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper
import org.yakindu.sct.generator.java.GenmodelEntries
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

class Observable {
	
	@Inject extension GenmodelEntries
	@Inject extension Naming
	@Inject extension OutputConfigProvider
	@Inject extension ICoreLibraryHelper

	def generateObservable(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		if (entry.skipLibraryFiles) {
			return
		}
		val fileName = entry.basePackagePath + '/' + observableClass.java
		fsa.generateFile(fileName, entry.libraryOutputConfig, entry.content)
	}
	
	def private content(GeneratorEntry entry)
	'''
		«entry.licenseText»
		package «entry.getBasePackageName()»;
		
		import java.util.ArrayList;
		import java.util.List;
		
		public class Observable<T> {
		
			private List<Observer<T>> observers = new ArrayList<>();
		
			public void next(T value) {
				for (Observer<T> observer : observers) {
					observer.next(value);
				}
			}
		
			public boolean subscribe(Observer<T> observer) {
				return observer != null ? this.observers.add(observer) : false;
			}
		
			public boolean unsubscribe(Observer<T> observer) {
				return observer != null ? this.observers.remove(observer) : false;
			}
		}
	'''
	
}