/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.core.execution;

import org.yakindu.sct.generator.core.ISGraphGenerator;
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGraphGenModelExecutor extends AbstractGenModelExecutor implements IGenModelExecutor {

	@Inject
	private ISGraphGenerator generator;
	
	@Override
	protected void execute(ISCTFileSystemAccess access, GeneratorEntry generatorEntry) {
		generator.generate((Statechart)generatorEntry.getElementRef(), generatorEntry, access);
	}
}
