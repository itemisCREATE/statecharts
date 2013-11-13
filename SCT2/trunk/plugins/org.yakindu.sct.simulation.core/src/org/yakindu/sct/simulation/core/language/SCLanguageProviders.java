/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * Handles a set of language providers and provides language dependencies resolving features.
 * 
 * @author terfloth - Initial contribution
 *
 */
public class SCLanguageProviders {

	protected SCLanguages languages = new SCLanguages();
	protected Map<ISCLanguage, ISCLanguageProvider> providerMap = new HashMap<ISCLanguage, ISCLanguageProvider>();
	
	public void addLanguageProvider(ISCLanguageProvider provider) {
		if (! languages.contains(provider.getLanguage()) ) {
			languages.addLanguage(provider.getLanguage());
			providerMap.put(provider.getLanguage(), provider);
		}
	}
	
	public List<ISCLanguageProvider> getLanguageProviders() {
		return new ArrayList<ISCLanguageProvider>(providerMap.values());
	}
	
	
	public ISCLanguageProvider getProviderFor(Statechart sc) {
		for (Iterator<ISCLanguageProvider> iterator = providerMap.values().iterator(); iterator.hasNext();) {
			ISCLanguageProvider provider = (ISCLanguageProvider) iterator.next();
			if (provider.isInstanceOfLanguage(sc)) return provider;	
		}		
		return null;
	}
	
	
	public Module getSimulationModuleFor(Statechart sc){
		return getSimulationModuleForLanguage(getProviderFor(sc).getLanguage());
	}
	
	
	public Module getSimulationModuleForLanguage(ISCLanguage language) {
		ISCLanguageProvider provider = providerMap.get(language);
		Module module = provider.getSimulationModule();
		
		ISCLanguage baseLanguage = languages.getBaseLanguage(language);
		if (baseLanguage != null) {
			Module baseModule = getSimulationModuleForLanguage(baseLanguage);
			return Modules.override(baseModule).with(module);
		}
		return module;
	}
}
