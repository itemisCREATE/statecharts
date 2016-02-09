/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.java;

import org.yakindu.sct.generator.core.features.ICoreFeatureConstants;
import org.yakindu.sct.generator.core.impl.GenericJavaBasedGenerator;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

abstract public class AbstractJavaCodeGenerator extends GenericJavaBasedGenerator {

	abstract public void generate(Statechart statechart, GeneratorEntry entry);

	@Override
	public final void runGenerator(Statechart statechart, GeneratorEntry entry) {
		generate(statechart, entry);
	}

	public String getTargetFolderString(GeneratorEntry entry) {
		FeatureConfiguration outletConfig = entry.getFeatureConfiguration(ICoreFeatureConstants.OUTLET_FEATURE);
		String projectName = outletConfig.getParameterValue(ICoreFeatureConstants.OUTLET_FEATURE_TARGET_FOLDER)
				.getStringValue();
		return projectName;
	}
}
