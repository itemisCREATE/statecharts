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
package org.yakindu.sct.generator.cpp;

import org.eclipse.core.resources.IProject;
import org.yakindu.sct.generator.core.impl.AbstractXpandBasedCodeGenerator;
import org.yakindu.sct.model.sgen.GeneratorEntry;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class CppCodeGenerator extends AbstractXpandBasedCodeGenerator {

	@Override
	public String getTemplatePath() {
		return "org::yakindu::sct::generator::cpp::templates::Main::main";
	}

	@Override
	protected void createProject(IProject project, GeneratorEntry entry) {
		super.createProject(project, entry);
		// TODO: Set up right project description with C++ related stuff here...
	}

}
