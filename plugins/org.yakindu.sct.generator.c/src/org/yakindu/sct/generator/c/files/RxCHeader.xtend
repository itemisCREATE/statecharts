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
		«entry.licenseText»
		
		#ifndef «rxcModule.define»_H_
		#define «rxcModule.define»_H_
		
		#include "«(typesModule.h).relativeTo(rxcModule.h)»"
		
		#ifdef __cplusplus
		extern "C" {
		#endif
		
		typedef void* sc_object_ref;

		typedef struct sc_observer sc_observer;
		typedef struct sc_subscription sc_subscription;
		typedef struct sc_observable sc_observable;
		typedef struct sc_single_subscription_observer sc_single_subscription_observer;
		
		typedef void (*sc_observer_next_fp)(sc_object_ref, void*);
		
		struct sc_observer {
			sc_object_ref observer;
			sc_observer_next_fp next;
		};
		
		extern void sc_observer_init(sc_observer *self, sc_object_ref o, sc_observer_next_fp nf);
		extern void sc_observer_next(sc_observer *self, void* value);
		
		
		struct sc_subscription {
			sc_observer* observer;
			sc_subscription* next;
		};
		void sc_subscription_init(sc_subscription *self, sc_observer *o);
		
		
		struct sc_observable {
			sc_uinteger observer_count;
			sc_subscription* subscriptions;
		};
		
		extern void sc_observable_init(sc_observable *self);
		extern sc_boolean sc_observable_subscribe(sc_observable *self, sc_subscription *s);
		extern sc_boolean sc_observable_unsubscribe(sc_observable *self, sc_subscription *s);
		extern void sc_observable_next(sc_observable *self, void* value);
		
		
		struct sc_single_subscription_observer {
			sc_observer observer;
			sc_subscription subscription;
		};
		
		extern void sc_single_subscription_observer_init(sc_single_subscription_observer *self, sc_object_ref o, sc_observer_next_fp nf);
		extern sc_boolean sc_single_subscription_observer_subscribe(sc_single_subscription_observer *self, sc_observable *o);
		extern sc_boolean sc_single_subscription_observer_unsubscribe(sc_single_subscription_observer *self, sc_observable *o);
		
		
		#ifdef __cplusplus
		}
		#endif
		
				
		#endif /* «rxcModule.define»_H_ */
	'''
	
}