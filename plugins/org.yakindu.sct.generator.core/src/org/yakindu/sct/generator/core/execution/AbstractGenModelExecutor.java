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

import org.eclipse.emf.common.util.EList;
import org.yakindu.sct.generator.core.filesystem.DefaultFileSystemAccessFactory;
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractGenModelExecutor implements IGenModelExecutor {

	@Inject
	protected IGeneratorLog log;
	@Inject
	protected DefaultFileSystemAccessFactory factory;

	protected abstract void execute(ISCTFileSystemAccess access, GeneratorEntry generatorEntry);

	@Override
	public void execute(GeneratorModel model) {
		EList<GeneratorEntry> entries = model.getEntries();
		for (GeneratorEntry generatorEntry : entries) {
			try {
				logStart(generatorEntry);
				ISCTFileSystemAccess access = factory.create(generatorEntry);
				execute(access, generatorEntry);
			} catch (Exception ex) {
				log.writeToConsole(ex);
			} finally {
				log.writeToConsole("done...");
			}
		}
	}

	protected void logStart(GeneratorEntry entry) {
		Statechart statechart = (Statechart) entry.getElementRef();
		log.writeToConsole(
				String.format("Generating %s %s ...", Statechart.class.getSimpleName(), statechart.getName()));
	}

}
