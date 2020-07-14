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
		
		/*! A reference to generic, untyped object. */
		typedef void* sc_object_ref;
		
		/*! */
		typedef struct sc_observer sc_observer;
		typedef struct sc_subscription sc_subscription;
		typedef struct sc_observable sc_observable;
		typedef struct sc_single_subscription_observer sc_single_subscription_observer;
		
		
		/* -----------------------------------------------------------
		 * observers
		 */
		
		typedef void (*sc_observer_next_fp)(sc_object_ref);
		struct sc_observer {
			sc_object_ref object;
			sc_observer_next_fp next;
		};
		
		extern void sc_observer_init(sc_observer *self, sc_object_ref o, sc_observer_next_fp nf);
		extern void sc_observer_next(sc_observer *self);
		
		
		#define declare_sc_observer(T) \
			typedef void (*sc_observer_next_##T##_fp)(sc_object_ref, T); \
			typedef struct sc_observer_##T sc_observer_##T; \
			struct sc_observer_##T { \
				sc_object_ref object; \
				sc_observer_next_##T##_fp next; \
			}; \
			extern void sc_observer_##T##_init(sc_observer_##T *self, sc_object_ref o, sc_observer_next_##T##_fp nf); \
			extern void sc_observer_##T##_next(sc_observer_##T *self, T value);
		
		
		#define define_sc_observer(T) \
			void sc_observer_##T##_init(sc_observer_##T *self, sc_object_ref o, sc_observer_next_##T##_fp nf) \
			{ \
				self->object = o; \
				self->next = nf; \
			} \
			\
			void sc_observer_##T##_next(sc_observer_##T *self, T value) \
			{ \
				if (self != sc_null && self->next != sc_null) \
				{ \
					self->next(self->object, value); \
				} \
			} \
			\
		
		
		/* -----------------------------------------------------------
		 * subscriptions
		 */
		
		struct sc_subscription {
			sc_observer *observer;
			sc_subscription* next;
		};
		void sc_subscription_init(sc_subscription *self, sc_observer *o);
		
		#define declare_sc_subscription(T) \
			typedef struct sc_subscription_##T sc_subscription_##T; \
			struct sc_subscription_##T { \
				sc_observer_##T *observer; \
				sc_subscription_##T *next; \
			}; \
			extern void sc_subscription_##T##_init(sc_subscription_##T *self, sc_observer_##T *o); \
		
		
		#define define_sc_subscription(T) \
			void sc_subscription_##T##_init(sc_subscription_##T *self, sc_observer_##T *o) \
			{ \
				self->observer = o; \
				self->next = sc_null; \
			} \
		
		
		
		/* -----------------------------------------------------------
		 * observables
		 */
		
		struct sc_observable {
			sc_uinteger observer_count;
			sc_subscription *subscriptions;
		};
		
		extern void sc_observable_init(sc_observable *self);
		extern sc_boolean sc_observable_subscribe(sc_observable *self, sc_subscription *s);
		extern sc_boolean sc_observable_unsubscribe(sc_observable *self, sc_subscription *s);
		extern void sc_observable_next(sc_observable *self);
		
		#define sc_observable(T) sc_observable_##T
		
		#define declare_sc_observable(T) \
			typedef struct sc_observable_##T sc_observable_##T; \
			struct sc_observable_##T { \
				sc_uinteger observer_count; \
				sc_subscription_##T *subscriptions; \
			}; \
			extern void sc_observable_##T##_init(sc_observable_##T *self); \
			extern sc_boolean sc_observable_##T##_subscribe(sc_observable_##T *self, sc_subscription_##T *s); \
			extern sc_boolean sc_observable_##T##_unsubscribe(sc_observable_##T *self, sc_subscription_##T *s); \
			extern void sc_observable_##T##_next(sc_observable_##T *self, T value); \
		
		
		#define define_sc_observable(T) \
			void sc_observable_##T##_init(sc_observable_##T *self) \
			{ \
				self->subscriptions = sc_null; \
			} \
			\
			sc_boolean sc_observable_##T##_subscribe(sc_observable_##T *self, sc_subscription_##T *s) {\
				return sc_observable_subscribe((sc_observable*) self, (sc_subscription *) s); \
			} \
			\
			sc_boolean sc_observable_##T##_unsubscribe(sc_observable_##T *self, sc_subscription_##T *s) {\
				return sc_observable_unsubscribe((sc_observable*) self, (sc_subscription *) s); \
			} \
			\
			void sc_observable_##T##_next(sc_observable_##T *self, T value) \
			{ \
				sc_subscription_##T *sub = self->subscriptions; \
				while (sub != sc_null) \
				{ \
					if (sub->observer != sc_null) \
					{ \
						sc_observer_##T##_next(sub->observer, value); \
					} \
					sub = (sub->next != sub) ? sub->next : sc_null; \
				} \
			}\
		
		
		
		/* -----------------------------------------------------------
		 * single subscription observer
		 */
		
		struct sc_single_subscription_observer {
			sc_observer observer;
			sc_subscription subscription;
		};
		
		extern void sc_single_subscription_observer_init(sc_single_subscription_observer *self, sc_object_ref o, sc_observer_next_fp nf);
		extern sc_boolean sc_single_subscription_observer_subscribe(sc_single_subscription_observer *self, sc_observable *o);
		extern sc_boolean sc_single_subscription_observer_unsubscribe(sc_single_subscription_observer *self, sc_observable *o);
		
		
		#define declare_sc_single_subscription_observer(T) \
			typedef struct sc_single_subscription_observer_##T sc_single_subscription_observer_##T; \
			struct sc_single_subscription_observer_##T { \
				sc_observer_##T observer; \
				sc_subscription_##T subscription; \
			}; \
			extern void sc_single_subscription_observer_##T##_init(sc_single_subscription_observer_##T *self, sc_object_ref o, sc_observer_next_##T##_fp nf); \
			extern sc_boolean sc_single_subscription_observer_##T##_subscribe(sc_single_subscription_observer_##T *self, sc_observable_##T *o); \
			extern sc_boolean sc_single_subscription_observer_##T##_unsubscribe(sc_single_subscription_observer_##T *self, sc_observable_##T *o); \
		
		
		#define define_sc_single_subscription_observer(T) \
			void sc_single_subscription_observer_##T##_init(sc_single_subscription_observer_##T *self, sc_object_ref o, sc_observer_next_##T##_fp nf) \
			{ \
				sc_observer_##T##_init(&(self->observer), o, nf); \
				sc_subscription_##T##_init(&(self->subscription), &(self->observer)); \
			} \
			\
			sc_boolean sc_single_subscription_observer_##T##_subscribe(sc_single_subscription_observer_##T *self, sc_observable_##T *o) { \
				return sc_observable_subscribe((sc_observable *) o, (sc_subscription *) &(self->subscription)); \
			} \
			\
			sc_boolean sc_single_subscription_observer_##T##_unsubscribe(sc_single_subscription_observer_##T *self, sc_observable_##T *o) { \
				return sc_observable_unsubscribe((sc_observable *)o, (sc_subscription *) &(self->subscription)); \
			} \
		
		
		
		/* -----------------------------------------------------------
		 * macros to define reactive extensions for a specific type
		 */
		#define EMPTY
		
		#define declare_sc_reactive_extensions(T) \
			declare_sc_observer(T) \
			declare_sc_subscription(T) \
			declare_sc_observable(T) \
			declare_sc_single_subscription_observer(T)
		
		
		#define define_sc_reactive_extensions(T) \
			define_sc_observer(T) \
			define_sc_subscription(T) \
			define_sc_observable(T) \
			define_sc_single_subscription_observer(T)
		
		
		/* -----------------------------------------------------------
		 * declaration of reactive extensions for all Y-SCT default types
		 */
		
		declare_sc_reactive_extensions(sc_boolean)
		declare_sc_reactive_extensions(sc_integer)
		declare_sc_reactive_extensions(sc_real)
		declare_sc_reactive_extensions(sc_string)
		
		
		#ifdef __cplusplus
		}
		#endif
		
				
		#endif /* «rxcModule.define»_H_ */
	'''
	
}