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
import java.util.List;
import java.util.Map;

import org.yakindu.sct.examples.wizard.ExampleActivator;
import org.yakindu.sct.examples.wizard.preferences.ExamplesPreferenceConstants;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

/**
 * 
 * @author robin herrmann
 *
 */
public class ExampleCategory implements Comparable<ExampleCategory>, IExampleData {
	
	private Map<String, Integer> priorities = ImmutableMap.of(//
			CATEGORY_PROFESSIONAL, 1, //
			CATEGORY_STANDARD, 2, //
			CATEGORY_LABS, 3 //
	);
	
	public static final String CATEGORY_PROFESSIONAL = "Professional Examples";
	public static final String CATEGORY_LABS = "Labs Examples";
	public static final String CATEGORY_STANDARD = "Standard Examples";
	
	private static final String PREVIEW_PAGES = "org.yakindu.sct.examples.pages";
	
	private static final String STANDARD_DESC = "standard.html";
	private static final String PROFESSIONAL_DESC = "professional.html";
	private static final String LABS_DESC = "labs.html";
	
	private String name;
	private List<ExampleData> children = Lists.newArrayList();
	
	public ExampleCategory(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ExampleData> getChildren() {
		return children;
	}

	@Override
	public int compareTo(ExampleCategory o) {
		if (this.getPriority() == o.getPriority()) {
			return 0;
		} else if (this.getPriority() < o.getPriority()) {
			return -1;
		}
		return 1;
	}

	public int getPriority() {
		Integer prio = priorities.get(name);
		return prio == null ? 4 : prio;
	}

	@Override
	public String getDescriptionPath() {
		if (isProfessional()) {
			return getStorageLocation() + File.separator + PREVIEW_PAGES + File.separator + PROFESSIONAL_DESC;
		} else if (isLabs()) {
			return getStorageLocation() + File.separator + PREVIEW_PAGES + File.separator + LABS_DESC;
		}
		return getStorageLocation() + File.separator + PREVIEW_PAGES + File.separator + STANDARD_DESC;
	}
	
	@Override
	public boolean isProfessional() {
		return CATEGORY_PROFESSIONAL.equals(getName());
	}
	
	@Override
	public boolean isLabs() {
		return CATEGORY_LABS.equals(getName());
	}
	
	protected java.nio.file.Path getStorageLocation() {
		return java.nio.file.Paths.get(ExampleActivator.getDefault().getPreferenceStore()
				.getString(ExamplesPreferenceConstants.STORAGE_LOCATION));
	}

}