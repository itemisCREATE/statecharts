/** 
 * Copyright (c) 2016 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.domain.generic.resource;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;
import org.yakindu.sct.domain.extension.IDomain;
import org.yakindu.sct.domain.extension.IModuleProvider;
import org.yakindu.sct.model.stext.STextRuntimeModule;
import org.yakindu.sct.model.stext.ide.STextIdeModule;
import org.yakindu.sct.model.stext.resource.StextResource;
import org.yakindu.sct.model.stext.ui.STextUiModule;
import org.yakindu.sct.model.stext.ui.internal.StextActivator;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ResourceModuleProvider implements IModuleProvider {

	@Override
	public Module getModule(String... options) {
		if (isHeadless(options)) {
			return getLanguageRuntimeModule();
		}
		Module module = Modules.override(getLanguageRuntimeModule())
				.with(new STextUiModule(StextActivator.getInstance()));
		module = Modules.override(module).with(new Module() {
			@Override
			public void configure(Binder binder) {
				binder.bind(Resource.class).to(StextResource.class);
			}
		});
		return Modules.override(module).with(new SharedStateModule());
	}

	protected Module getLanguageRuntimeModule() {
		return new STextRuntimeModule();
	}

	protected boolean isHeadless(String[] options) {
		for (String option : options) {
			if (option.equals(IDomain.OPTION_HEADLESS)) {
				return true;
			}
		}
		return false;
	}

}
