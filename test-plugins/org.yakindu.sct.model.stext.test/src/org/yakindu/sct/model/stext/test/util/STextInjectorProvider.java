/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.test.util;

import org.eclipse.xtext.junit4.IInjectorProvider;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.model.stext.inferrer.STextTypeInferrer;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.name.Names;
import com.google.inject.util.Modules;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class STextInjectorProvider implements IInjectorProvider {

	public Injector getInjector() {
		return Guice.createInjector(getModule());
	}
 
	protected Module getModule() {
		return Modules.combine(new STextRuntimeTestModule(), new AbstractModule() {
			@Override
			protected void configure() {
				bind(String.class).annotatedWith(Names.named(DomainRegistry.DOMAIN_ID))
						.toInstance(BasePackage.Literals.DOMAIN_ELEMENT__DOMAIN_ID.getDefaultValueLiteral());
				bind(ITypeSystemInferrer.class).to(STextTypeInferrer.class);
			}
		});
	}
}
