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

import java.util.HashMap;
import java.util.Map;

/**
 * Handles a set of statechart meta information objects and allows resolving dependencies.
 * 
 * @author axel terfloth - Initial contribution
 *
 */
public class SCLanguages {

	protected Map< String, ISCLanguage> languageMap = new HashMap<String, ISCLanguage>();
	
	public void addLanguage(ISCLanguage language) {
		languageMap.put(language.getId(), language);
	}
	
	public boolean contains(ISCLanguage language) {
		return languageMap.containsKey(language.getId());
	}
	
	public ISCLanguage getLanguage(String id) {
		return languageMap.get(id);
	}
	
	ISCLanguage getBaseLanguage(ISCLanguage language) {
		return getLanguage(language.getBaseLanguageId());
	}
}
