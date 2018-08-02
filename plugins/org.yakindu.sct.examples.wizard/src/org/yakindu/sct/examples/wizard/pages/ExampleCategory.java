package org.yakindu.sct.examples.wizard.pages;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.yakindu.sct.examples.wizard.ExampleActivator;
import org.yakindu.sct.examples.wizard.preferences.ExamplesPreferenceConstants;
import org.yakindu.sct.examples.wizard.service.ExampleData;

import com.google.common.collect.ImmutableMap;

public class ExampleCategory implements Comparable<ExampleCategory>{
	
	private Map<String, Integer> priorities = ImmutableMap.of(//
			CATEGORY_PROFESSIONAL, 1, //
			CATEGORY_STANDARD, 2, //
			CATEGORY_LABS, 3 //
	);
	
	public static final String CATEGORY_PROFESSIONAL = "Professional Examples";
	public static final String CATEGORY_LABS = "Labs Examples";
	public static final String CATEGORY_STANDARD = "Standard Examples";
	
	private String name;
	private List<ExampleData> children;
	private Path path;
	
	
	public ExampleCategory(String name) {
		this.name = name;
		this.setPath(getStorageLocation());
		children = new ArrayList<>();
	}
	
	protected java.nio.file.Path getStorageLocation() {
		return java.nio.file.Paths.get(ExampleActivator.getDefault().getPreferenceStore()
				.getString(ExamplesPreferenceConstants.STORAGE_LOCATION));
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

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

}