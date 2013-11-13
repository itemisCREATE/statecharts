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

import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Module;

/**
 * Instances provide meta information about statechart languages as well as implementation in form of (guice) modules.
 * 
 * Current usage is restricted to simulation modules.
 * 
 * @author terfloth
 *
 */
public interface ISCLanguageProvider {

	/** 
	 * @return  meta information about the language
	 */
	ISCLanguage getLanguage();
	
	/** 
	 * Determins if a statechart is instance of the statechart language.
	 * @param sc
	 * @return
	 */
	boolean isInstanceOfLanguage(Statechart sc);
	
	/**
	 * Provides the guice module that contains the implementation.
	 * @return a module
	 */
	Module getSimulationModule();
	
}
