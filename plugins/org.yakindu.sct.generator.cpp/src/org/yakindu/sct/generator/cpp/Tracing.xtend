package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

class Tracing implements IContentTemplate {

	@Inject extension GenmodelEntries
	@Inject extension CppNaming

	override content(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations locations) '''
		«entry.licenseText»
		
		#ifndef «traceObserverModule.define»_H_
		#define «traceObserverModule.define»_H_
		
		template<typename T>
		class «traceObserverModule»
		{
		public:
			virtual ~«traceObserverModule»(){}
		
			virtual void stateEntered(T state) = 0;
		
			virtual void stateExited(T state) = 0;
		};
		
		#endif /* «traceObserverModule.define» */
		
	'''

}
