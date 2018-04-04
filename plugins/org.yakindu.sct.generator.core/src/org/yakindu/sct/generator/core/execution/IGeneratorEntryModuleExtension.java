/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 *
 */
package org.yakindu.sct.generator.core.execution;

import org.yakindu.sct.model.sgen.GeneratorEntry;

/**
 * @author rbeckmann
 *
 */
public interface IGeneratorEntryModuleExtension {
	public void setGeneratorEntry(GeneratorEntry entry);
}
