/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.domain.extension;

import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author andreas muelder - Initial contribution and API
 * @author terfloth
 * 
 */
public interface IDomainInjectorProvider {

	/**
	 * Returns the injector used for injection the {@link AbstractSCTResource}
	 * 
	 */
	public Injector getResourceInjector();

	/**
	 * Returns the injector for the Simulation engine
	 */
	public Injector getSimulationInjector();

	/**
	 * Returns the Injector for the model sequencing without overriding existing
	 * bindings.
	 */
	public Injector getSequencerInjector();

	/**
	 * Returns the Injector for the model sequencing, giving precedence to those
	 * bindings in the overrides module.
	 */
	public Injector getSequencerInjector(Module overrides);

	/**
	 * Injector used to create the embedded in-diagram Xtext Editor
	 * 
	 * @param elementKey
	 *            A key indicating for which element the in-diagram editor
	 *            should be created, i.e. State, Statechart or Transition
	 */
	public Injector getEmbeddedEditorInjector(String elementKey);

	/**
	 * Returns an injector for all editor and UI related stuff.
	 */
	public Injector getEditorInjector();

	/**
	 * @param generatorId
	 */
	public Injector getGeneratorInjector(String generatorId);
	
	public Injector getGeneratorInjector(String generatorId, Module overrides);
}
