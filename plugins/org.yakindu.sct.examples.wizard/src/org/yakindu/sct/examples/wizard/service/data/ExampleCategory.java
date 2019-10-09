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

	TUTORIAL("Getting Started", "basic.html"),

	CODE_GENERATORS("Code Generation", "codegen.html"),

	APPLICATIONS("Applications", "applications.html"),

	DEEP_C("Deep C Integration", "deep-c.html"),

	DEEP_JAVA("Deep Java Integration", "deep-java.html"),

	TESTING("Testing", "testing.html"),

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
		if (Arrays.asList(data.getCategory()).contains("tutorial")) {
			return TUTORIAL;
		}
		if (Arrays.asList(data.getCategory()).contains("code-generation")) {
			return CODE_GENERATORS;
		}
		if (Arrays.asList(data.getCategory()).contains("application")) {
			return APPLICATIONS;
		}
		if (Arrays.asList(data.getCategory()).contains("c-domain")) {
			return DEEP_C;
		}
		if (Arrays.asList(data.getCategory()).contains("java-domain")) {
			return DEEP_JAVA;
		}
		if (Arrays.asList(data.getCategory()).contains("testing")) {
			return TESTING;
		}
		if (Arrays.asList(data.getCategory()).contains("labs")) {
			return LABS;
		}
		return TUTORIAL;
	}
	
}
