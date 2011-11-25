/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.genmodel.ui.wizard;

/**
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public class ProjectData {
	boolean pluginExport;
	boolean typeLibrary;
	String projectName;
	String generatorId;
	String generatorDescription;
	String generatorName;
	String generatorClass;
	GeneratorType generatorType;

	public boolean isPluginExport() {
		return pluginExport;
	}

	public boolean isTypeLibrary() {
		return typeLibrary;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getGeneratorId() {
		return generatorId;
	}

	public String getGeneratorDescription() {
		return generatorDescription;
	}

	public String getGeneratorName() {
		return generatorName;
	}

	public String getGeneratorClass() {
		return generatorClass;
	}

	public GeneratorType getGeneratorType() {
		return generatorType;
	}

}