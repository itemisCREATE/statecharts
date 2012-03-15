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
 * Base class for generators that are executed inside the workspace
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public abstract class AbstractWorkspaceGenerator implements IGeneratorBridge {

	private IGeneratorBridge bridge;

	public final void setBridge(IGeneratorBridge bridge) {
		this.bridge = bridge;
	}

	public final void writeToConsole(String s) {
		bridge.writeToConsole(s);
	}

	public final void writeToConsole(Throwable t) {
		bridge.writeToConsole(t);
	}

	public final FeatureParameterValue getFeatureParameter(
			GeneratorEntry entry, String featureName, String paramName) {
		return bridge.getFeatureParameter(entry, featureName, paramName);
	}

	public final void refreshTargetProject(GeneratorEntry entry) {
		bridge.refreshTargetProject(entry);
	}

	public final File getTargetProject(GeneratorEntry entry) {
		return bridge.getTargetProject(entry);
	}

	public final File getTargetFolder(GeneratorEntry entry) {
		return bridge.getTargetFolder(entry);
	}

}
