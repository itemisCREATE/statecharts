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

import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;

/**
 * bridges common generator functionality between plugin and runtime workspace
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public interface IGeneratorBridge {

	void writeToConsole(String s);

	void writeToConsole(Throwable t);

	FeatureParameterValue getFeatureParameter(GeneratorEntry entry,
			String featureName, String paramName);

	void refreshTargetProject(GeneratorEntry entry);

	File getTargetProject(GeneratorEntry entry);

	File getTargetFolder(GeneratorEntry entry);
}
