/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.core;

import java.io.File;

import org.yakindu.sct.generator.core.impl.AbstractSExecModelGenerator;
import org.yakindu.sct.model.sgen.GeneratorEntry;

/**
 * Base class for generators that are executed inside the workspace
 * 
 * @author holger willebrandt - Initial contribution and API
 */ 
//FIXME !!! used in generator runtime samples (Xtend2 & Java, see e.g. org.yakindu.sct.generator.genmodel.ui.wizard.GeneratorProjectTemplate)
public abstract class AbstractWorkspaceGenerator extends AbstractSExecModelGenerator {
	
	public final void refreshTargetProject(GeneratorEntry entry) {
		throw new UnsupportedOperationException("implement me!");
	}

	public final File getTargetProject(GeneratorEntry entry) {
		throw new UnsupportedOperationException("implement me!");
	}

	public final File getTargetFolder(GeneratorEntry entry) {
		throw new UnsupportedOperationException("implement me!");
	}
	
	public final File getLibraryTargetFolder(GeneratorEntry entry) {
		throw new UnsupportedOperationException("implement me!");
	}
}
