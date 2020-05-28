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
package org.yakindu.sct.generator.cpp.files

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

/**
 * @author aterfloth
 */
class RxCppHeader implements IContentTemplate {
	@Inject extension CppNaming
	@Inject extension GenmodelEntries

	override content(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations locations) '''
		«entry.licenseText»
		
		#ifndef «rxcModule.define»_H_
		#define «rxcModule.define»_H_
		
		#include "«(typesModule.h).relativeTo(rxcModule.h)»"
		
		namespace sc {
		namespace rx {
		
		template<class T> class Observer;
		template<> class Observer<void> ;
		template<class T> struct subscription;
		template<class T> class Observable;
		template<> class Observable<void> ;
		
		template<class T>
		class Observer {
		public:
			virtual ~Observer() {
			}
			virtual void next(T value) = 0;
		};
		
		template<>
		class Observer<void> {
		public:
			virtual ~Observer() {
			}
			virtual void next() = 0;
		};
		
		template<class T>
		class SingleSubscriptionObserver: public Observer<T> {
		public:
			SingleSubscriptionObserver() :
					subscription(this) {
			}
		
			bool subscribe(sc::rx::Observable<T> *o) {
				return o->subscribe(&subscription);
			}
		
			bool unsubscribe(sc::rx::Observable<T> *o) {
				return o->unsubscribe(&subscription);
			}
		
		protected:
			sc::rx::subscription<T> subscription;
		};
		
		template<class T>
		struct subscription {
		
			subscription(Observer<T> *o) :
					observer(o), next(sc_null) {
			}
		
			Observer<T> *observer;
			subscription<T> *next;
		};
		
		template<class T> class ObservableBase {
		public:
			ObservableBase() :
					subscriptions(sc_null) {
			}
		
			bool subscribe(subscription<T> *s) {
				if (s != sc_null && s->observer != sc_null && s->next == sc_null) {
					subscription<T> *currentSub = this->subscriptions;
					s->next = (currentSub != sc_null) ? currentSub : s;
					this->subscriptions = s;
					return true;
				}
				return false;
			}
		
			bool unsubscribe(subscription<T> *s) {
				if (s != sc_null && this->subscriptions != sc_null) {
					if (this->subscriptions == s) {
						this->subscriptions = (s->next != s) ? s->next : sc_null;
						s->next = sc_null;
		
						return true;
					}
		
					sc::rx::subscription<T> *sub = this->subscriptions;
					while (sub != sc_null) {
						if (sub->next != sub && sub->next == s) {
							sub->next = (s->next != s) ? s->next : sub;
							return true;
						}
		
						sub = (sub->next != sub) ? sub->next : sc_null;
					}
				}
				return false;
			}
		
		protected:
			subscription<T> *subscriptions;
		
		};
		
		template<class T>
		class Observable: public ObservableBase<T> {
		
		public:
		
			void next(T value) {
				subscription<T> *sub = this->subscriptions;
				while (sub != sc_null) {
					if (sub->observer != sc_null) {
						sub->observer->next(value);
					}
					sub = (sub->next != sub) ? sub->next : sc_null;
				}
			}
		
		};
		
		template<>
		class Observable<void> : public ObservableBase<void> {
		
		public:
			void next() {
				subscription<void> *sub = this->subscriptions;
				while (sub != sc_null) {
					if (sub->observer != sc_null) {
						sub->observer->next();
					}
					sub = (sub->next != sub) ? sub->next : sc_null;
				}
			}
		
		};
		
		} /* namespace sc::rx */
		} /* namespace sc */
		
		#endif /* «rxcModule.define»_H_ */
	'''
	
}
