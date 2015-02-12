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

import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;

import com.google.inject.Module;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IDomainModuleProvider {

	/**
	 * Module used to create an instance of {@link AbstractSCTResource}
	 */
	public Module getResourceModule();

	/**
	 * Module used to create the embedded in-diagram Xtext Editor
	 * 
	 * @param elementKey
	 *            A key indicating for which element the in-diagram editor
	 *            should be created, i.e. State, Statechart or Transition
	 */
	public Module getEmbeddedEditorModule(String elementKey);

	/**
	 * Returns the module used during simulation
	 */
	public Module getSimulationModule();
}
