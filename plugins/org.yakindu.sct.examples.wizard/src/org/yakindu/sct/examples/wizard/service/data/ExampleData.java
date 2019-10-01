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
package org.yakindu.sct.examples.wizard.service.data;

import java.io.File;
import java.text.Collator;
import java.util.Arrays;

/**
 * 
 * @author t00manysecretss
 * 
 */
public class ExampleData implements Comparable<ExampleData>, IExampleData {

	public static final String DESC_FILE = "index.html";

	private static final String PRO_CATEGORY = "professional";
	private static final String LABS_CATEGORY = "labs";
	private static final String STANDARD_CATEGORY = "standard";
	private static final String PLATFORM_CATEGORY = "platform";
	private static final String HEADLESS_CATEGORY = "headless";
	
	private String id;
	private String title;
	private String[] category;
	private String description;
	private String[] images;
	private File projectDir;
	private Dependency[] dependencies;
	private int rank;

	public static class Dependency {
		
		private String updateSite;
		private String[] features;

		public Dependency(String updateSite, String[] features) {
			this.updateSite = updateSite;
			this.features = features;
		}
		
		public String getUpdateSite() {
			return updateSite;
		}
		
		public String[] getFeatures() {
			return features;
		}
	}
	
	public ExampleData() {
		this.rank = 100;
	}
	
	public Dependency[] getDependencies() {
		return dependencies;
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

	public String[] getCategory() {
		return category;
	}

	public void setCategory(String[] category) {
		this.category = category;
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

	public boolean isProfessional() {
		return Arrays.asList(getCategory()).contains(PRO_CATEGORY);
	}
	
	public boolean isLabs() {
		return Arrays.asList(getCategory()).contains(LABS_CATEGORY);
	}
	
	public boolean isStandard() {
		return Arrays.asList(getCategory()).contains(STANDARD_CATEGORY);
	}
	
	public boolean isPlatform() {
		return Arrays.asList(getCategory()).contains(PLATFORM_CATEGORY);
	}

	public boolean isHeadless() {
		return Arrays.asList(getCategory()).contains(HEADLESS_CATEGORY);
	}
	
	@Override
	public String getDescriptionPath() {
		return getProjectDir().getAbsolutePath() + File.separator + DESC_FILE;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(images);
		result = prime * result + ((projectDir == null) ? 0 : projectDir.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExampleData other = (ExampleData) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(images, other.images))
			return false;
		if (projectDir == null) {
			if (other.projectDir != null)
				return false;
		} else if (!projectDir.equals(other.projectDir))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public int compareTo(ExampleData other) {
		int byRank = this.rank - other.rank;
		if (byRank == 0) {
			return Collator.getInstance().compare(this.title, other.title);
		}
		return byRank;
		
	}

}