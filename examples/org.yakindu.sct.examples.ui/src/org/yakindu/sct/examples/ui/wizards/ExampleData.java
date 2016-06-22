/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.examples.ui.wizards;

import java.io.File;

/**
 * 
 * @author t00manysecretss
 * 
 */
public class ExampleData {

	private ExampleData parent;
	private ExampleData[] children;
	private String id;
	private String title;
	private String domain;
	private String description;
	private String[] images;
	private File projectDir;

	public ExampleData(String domain, String id, String title, String description, String[] images) {
		this.domain = domain;
		this.id = id;
		this.title = title;
		this.description = description;
		this.images = images;
	}

	public ExampleData(ExampleData parent, ExampleData[] children, String title) {
		this.parent = parent;
		this.children = children;
		this.title = title;
		this.domain = title;
	}

	public ExampleData getParent() {
		return parent;
	}

	public void setParent(ExampleData parent) {
		this.parent = parent;
	}

	public ExampleData[] getChildren() {
		return children;
	}

	public void setChildren(ExampleData[] children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getImages() {
		return images;
	}

	public String[] getFullImagePathes() {
		String[] result = new String[images.length];
		String[] imgs = getImages();
		for (int i = 0; i < imgs.length; i++) {
			result[i] = getProjectDir() + File.separator + imgs[i];
		}
		return result;
	}

	public void setImages(String[] images) {
		this.images = images;
	}

	public File getProjectDir() {
		return projectDir;
	}

	public void setProjectDir(File projectDir) {
		this.projectDir = projectDir;
	}

	public boolean hasChildren() {
		return children != null;
	}
}