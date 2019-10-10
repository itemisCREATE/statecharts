/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.examples.wizard.service.data;

import java.io.File;
import java.util.Arrays;

import org.yakindu.sct.examples.wizard.ExampleActivator;
import org.yakindu.sct.examples.wizard.preferences.ExamplesPreferenceConstants;

/**
 * 
 * @author robin herrmann, thomas kutz
 *
 */
public enum ExampleCategory implements IExampleData {

	MODELING("Getting Started - Modeling", "modeling.html"),

	CODE_GENERATORS("Getting Started - Code Generation", "codegen.html"),

	ADVANCED("Advanced Examples", "advanced.html"),

	EMBEDDED("Embedded Systems", "deep-c.html"),

	HMI("Human Machine Interfaces", "deep-java.html"),

	TESTING("Testing", "testing.html"),

	HEADLESS("Headless Code Generation", "headless.html"),

	LABS("Lab Projects", "lab-projects.html");

	private String title;
	private String desc;
	
	private static final String PREVIEW_PAGES = "org.yakindu.sct.examples.pages";

	ExampleCategory(String title, String desc) {
		this.title = title;
		this.desc = desc;
	}

	public String getTitle() {
		return this.title;
	}

	public String getDescriptionPath() {
		return getStorageLocation() + File.separator + PREVIEW_PAGES + File.separator + desc;
	}

	protected java.nio.file.Path getStorageLocation() {
		return java.nio.file.Paths.get(ExampleActivator.getDefault().getPreferenceStore()
				.getString(ExamplesPreferenceConstants.STORAGE_LOCATION));
	}

	public static ExampleCategory get(ExampleData data) {
		if (Arrays.asList(data.getCategory()).contains("modeling")) {
			return MODELING;
		}
		if (Arrays.asList(data.getCategory()).contains("code-generation")) {
			return CODE_GENERATORS;
		}
		if (Arrays.asList(data.getCategory()).contains("headless")) {
			return HEADLESS;
		}
		if (Arrays.asList(data.getCategory()).contains("advanced")) {
			return ADVANCED;
		}
		if (Arrays.asList(data.getCategory()).contains("embedded")) {
			return EMBEDDED;
		}
		if (Arrays.asList(data.getCategory()).contains("hmi")) {
			return HMI;
		}
		if (Arrays.asList(data.getCategory()).contains("testing")) {
			return TESTING;
		}
		if (Arrays.asList(data.getCategory()).contains("labs")) {
			return LABS;
		}
		return MODELING;
	}
	
}
