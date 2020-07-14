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

import org.yakindu.sct.generator.c.IContentTemplate
import com.google.inject.Inject
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.types.CLiterals

class RxCSource implements IContentTemplate {

	@Inject extension Naming
	@Inject extension GenmodelEntries

	override content(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations locations) '''
		«entry.licenseText»
		
		#include "«(rxcModule.h).relativeTo(rxcModule.c)»"
		
		
		void sc_observer_init(sc_observer *self, sc_object_ref o, sc_observer_next_fp nf)
		{
			self->object = o;
			self->next = (sc_observer_next_fp) nf;
		}
		
		void sc_observer_next(sc_observer *self)
		{
			if (self != «NULL» && self->next != «NULL»)
			{
				self->next(self->object);
			}
		}
		
		
		void sc_subscription_init(sc_subscription *self, sc_observer *o)
		{
			self->observer = o;
			self->next = «NULL»;
		}
		
		
		void sc_observable_init(sc_observable *self)
		{
			self->subscriptions = «NULL»;
		}
		
		
		sc_boolean sc_observable_subscribe(sc_observable *self, sc_subscription *s)
		{
			sc_subscription *currentSub;
			if (s != «NULL» && s->observer != «NULL» && s->next == «NULL») {
				currentSub = self->subscriptions;
				s->next = (currentSub != «NULL») ? currentSub : s;
				self->subscriptions = s;
				return true;
			}
			return false;
		}
		
		sc_boolean sc_observable_unsubscribe(sc_observable *self, sc_subscription *s)
		{
			sc_subscription *sub;
			
			if (s != «NULL» && self->subscriptions != «NULL»)
			{
				if (self->subscriptions == s) {
					self->subscriptions = (s->next != s) ? s->next : «NULL»;
					s->next = «NULL»;
		
					return true;
				}
		
				sub = self->subscriptions;
				while ( sub != «NULL» )
				{
					if ( sub->next != sub && sub->next == s)
					{
						sub->next = (s->next != s) ? s->next : sub;
						return true;
					}
		
					sub = (sub->next != sub) ? sub->next : «NULL»;
				}
			}
			return false;
		}
		
		
		void sc_observable_next(sc_observable *self)
		{
			sc_subscription *sub = self->subscriptions;
			while (sub != «NULL»)
			{
				if (sub->observer != «NULL»)
				{
					sc_observer_next(sub->observer);
				}
				sub = (sub->next != sub) ? sub->next : «NULL»;
			}
		}
		
		
		void sc_single_subscription_observer_init(sc_single_subscription_observer *self, sc_object_ref o, sc_observer_next_fp nf)
		{
			sc_observer_init(&(self->observer), o, nf);
			sc_subscription_init(&(self->subscription), &(self->observer));
		}
		
		
		sc_boolean sc_single_subscription_observer_subscribe(sc_single_subscription_observer *self, sc_observable *o) {
			return sc_observable_subscribe(o, &(self->subscription));
		}
		
		sc_boolean sc_single_subscription_observer_unsubscribe(sc_single_subscription_observer *self, sc_observable *o) {
			return sc_observable_unsubscribe(o, &(self->subscription));
		}
		
		
		/* -----------------------------------------------------------
		 * declaration of reactive extensions for all Y-SCT default types
		 */
		
		define_sc_reactive_extensions(sc_boolean)
		define_sc_reactive_extensions(sc_integer)
		define_sc_reactive_extensions(sc_real)
		
		/* declaration of declare_sc_reactive_extensions(sc_string) */
		void sc_observer_sc_string_init(sc_observer_sc_string *self, sc_object_ref o, sc_observer_next_sc_string_fp nf)
		{
			self->object = o;
			self->next = nf;
		}
		
		void sc_observer_sc_string_next(sc_observer_sc_string *self, sc_string value)
		{
			if (self != «NULL» && self->next != «NULL»)
			{
				self->next(self->object, value);
			}
		}
		
		void sc_observable_sc_string_init(sc_observable_sc_string *self)
		{
			self->subscriptions = «NULL»;
		}
		
		sc_boolean sc_observable_sc_string_subscribe(sc_observable_sc_string *self, sc_subscription_sc_string *s) {
			return sc_observable_subscribe((sc_observable*) self, (sc_subscription *) s);
		}
		
		sc_boolean sc_observable_sc_string_unsubscribe(sc_observable_sc_string *self, sc_subscription_sc_string *s) {
			return sc_observable_unsubscribe((sc_observable*) self, (sc_subscription *) s);
		}
		
		void sc_observable_sc_string_next(sc_observable_sc_string *self, sc_string value)
		{
			sc_subscription_sc_string *sub = self->subscriptions;
			while (sub != «NULL»)
			{
				if (sub->observer != «NULL»)
				{
					sc_observer_sc_string_next(sub->observer, value);
				}
				sub = (sub->next != sub) ? sub->next : «NULL»;
			}
		}
		
		void sc_single_subscription_observer_sc_string_init(sc_single_subscription_observer_sc_string *self, sc_object_ref o, sc_observer_next_sc_string_fp nf)
		{
			sc_observer_sc_string_init(&(self->observer), o, nf);
			sc_subscription_sc_string_init(&(self->subscription), &(self->observer));
		}
		
		sc_boolean sc_single_subscription_observer_sc_string_subscribe(sc_single_subscription_observer_sc_string *self, sc_observable_sc_string *o) {
			return sc_observable_subscribe((sc_observable *) o, (sc_subscription *) &(self->subscription));
		}
		
		sc_boolean sc_single_subscription_observer_sc_string_unsubscribe(sc_single_subscription_observer_sc_string *self, sc_observable_sc_string *o) {
			return sc_observable_unsubscribe((sc_observable *)o, (sc_subscription *) &(self->subscription));
		}
		
		void sc_subscription_sc_string_init(sc_subscription_sc_string *self, sc_observer_sc_string *o)
		{
			self->observer = o;
			self->next = «NULL»;
		}
	'''
	
	
	def NULL() '''«CLiterals::NULL_LITERAL_NAME»'''
		
}