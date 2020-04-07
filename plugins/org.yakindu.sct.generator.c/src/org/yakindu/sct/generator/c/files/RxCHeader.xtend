/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c.files

import com.google.inject.Inject
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.c.types.CLiterals
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.generator.c.IGenArtifactConfigurations

/**
 * @author aterfloth
 */
class RxCHeader implements IContentTemplate {
	@Inject extension Naming
	@Inject extension GenmodelEntries

	override content(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations locations) '''
		/*
		 * sc_rxc.h
		 *
		 * Provided by YAKINDU Statechart Tools.
		 *
		 * Created on: 30.03.2020
		 *     Author: terfloth
		 */
		«entry.licenseText»
		
		#ifndef «rxcModule.define»_H_
		#define «rxcModule.define»_H_
		
		#include "«("sc_types".h).relativeTo(rxcModule.h)»"
		
		#include "sc_types.h"
		
		#ifdef __cplusplus
		extern "C" {
		#endif
		
		
		typedef void* sc_object_ref;
		
		typedef struct sc_observer sc_observer;
		
		typedef void (*sc_observer_next_fp)(sc_object_ref, void*);
		
		struct sc_observer {
			sc_object_ref observer;
			sc_observer_next_fp next;
		};
		
		
		typedef struct sc_observable sc_observable;
		
		struct sc_observable {
			int observer_count;
			sc_observer** observers;
		};
		
		
		#define SC_OBSERVER_INIT(OBSERVER, HANDLER, NEXTFUNC) \
			(OBSERVER)->observer  = (HANDLER);\
			(OBSERVER)->next = (sc_observer_next_fp)(NEXTFUNC);
		
		
		#define SC_OBSERVER_SUBSCRIBE(OBSERVABLE, OBSERVER) \
			if ((OBSERVER)->next != «CLiterals::NULL_LITERAL_NAME») { \
				int _OBS_IDX_; \
				for (_OBS_IDX_ = 0; _OBS_IDX_<(OBSERVABLE)->observer_count; _OBS_IDX_++) { \
					if (((OBSERVABLE)->observers[_OBS_IDX_]) == «CLiterals::NULL_LITERAL_NAME») { \
						((OBSERVABLE)->observers[_OBS_IDX_]) = (OBSERVER); \
						_OBS_IDX_ = (OBSERVABLE)->observer_count; \
					} \
				} \
			}
		
		
		#define SC_OBSERVER_UNSUBSCRIBE(OBSERVABLE, OBSERVER) \
			if ((OBSERVER)->next != «CLiterals::NULL_LITERAL_NAME») { \
				int _OBS_IDX_; \
				for (_OBS_IDX_ = 0; _OBS_IDX_<(OBSERVABLE)->observer_count; _OBS_IDX_++) { \
					if (((OBSERVABLE)->observers[_OBS_IDX_]) == (OBSERVER)) { \
						((OBSERVABLE)->observers[_OBS_IDX_]) = «CLiterals::NULL_LITERAL_NAME»; \
						_OBS_IDX_ = (OBSERVABLE)->observer_count; \
					} \
				} \
			}
		
		
		#define SC_OBSERVER_NEXT(OBSERVER, ITEM) \
			if ((OBSERVER) != «CLiterals::NULL_LITERAL_NAME» && (OBSERVER)->next != «CLiterals::NULL_LITERAL_NAME») {\
				(OBSERVER)->next((OBSERVER)->observer, ITEM);\
			}
		
		
		#define SC_OBSERVABLE_INIT(OBSERVABLE) \
			(OBSERVABLE)->observer_count = 0;\
			(OBSERVABLE)->observers = «CLiterals::NULL_LITERAL_NAME»;
		
		
		#define SC_OBSERVABLE_INIT_OBSERVERS(OBSERVABLE, OBSERVERS) \
			(OBSERVABLE)->observer_count = sizeof(OBSERVERS)/sizeof(sc_observer*);\
			(OBSERVABLE)->observers = (OBSERVERS); \
			int _OBS_IDX_; \
			for (_OBS_IDX_ = 0; _OBS_IDX_<(OBSERVABLE)->observer_count; _OBS_IDX_++) {\
				((OBSERVABLE)->observers[_OBS_IDX_]) = «CLiterals::NULL_LITERAL_NAME»;\
			}
		
		
		#define SC_OBSERVABLE_SUBSCRIBE(OBSERVABLE, OBSERVERS) \
			(OBSERVABLE)->observer_count = sizeof(OBSERVERS)/sizeof(sc_observer*);\
			(OBSERVABLE)->observers = (OBSERVERS);
		
		
		#define SC_OBSERVABLE_NEXT(OBSERVABLE, ITEM) \
			int _OBS_IDX_; \
			for (_OBS_IDX_ = 0; _OBS_IDX_<(OBSERVABLE)->observer_count; _OBS_IDX_++) {\
				SC_OBSERVER_NEXT(((OBSERVABLE)->observers[_OBS_IDX_]), (ITEM));\
			}
		
		
		#ifdef __cplusplus
		}
		#endif
		
				
		#endif /* «rxcModule.define»_H_ */
	'''
	
}