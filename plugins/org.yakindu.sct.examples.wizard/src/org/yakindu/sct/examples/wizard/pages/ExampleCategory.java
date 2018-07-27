package org.yakindu.sct.examples.wizard.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.yakindu.sct.examples.wizard.service.ExampleData;

public class ExampleCategory implements Comparable<ExampleCategory>{
	private String name;
	private List<ExampleData> children;
	
	public ExampleCategory(String name) {
		this.name = name;
		children = new ArrayList<>();
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
		// TODO Auto-generated method stub
		return 0;
	}

}