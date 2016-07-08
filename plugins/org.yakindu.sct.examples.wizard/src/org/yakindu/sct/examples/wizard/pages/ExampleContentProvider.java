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
package org.yakindu.sct.examples.wizard.pages;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.yakindu.sct.examples.wizard.service.ExampleData;

import com.google.common.collect.Lists;

/**
 * 
 * @author t00manysecretss
 * 
 */
public class ExampleContentProvider implements ITreeContentProvider {

	public static class Category {
		private String name;
		private List<ExampleData> children;;

		public Category(String name) {
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

	}

	private Map<String, Category> categories;

	public ExampleContentProvider() {
		categories = new LinkedHashMap<>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		categories.clear();
		if (newInput != null)
			groupCategories((List<ExampleData>) newInput);
	}

	protected void groupCategories(List<ExampleData> newInput) {
		for (ExampleData exampleData : newInput) {
			String[] category = exampleData.getCategory();
			for (String string : category) {
				if (!categories.containsKey(string)) {
					categories.put(string, new Category(string));
				}
				categories.get(string).getChildren().add(exampleData);
			}
		}
	}

	@Override
	public Object[] getElements(Object inputElement) {
		List<Category> values = Lists.newArrayList();
		values.addAll(categories.values());
		Collections.sort(values, new Comparator<Category>() {
			@Override
			public int compare(Category o1, Category o2) {
				return Collator.getInstance().compare(o1.getName(), o2.getName());
			}
		});
		return values.toArray();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		return ((Category) parentElement).getChildren().toArray();
	}

	@Override
	public Object getParent(Object element) {
		return categories.get((((ExampleData) element).getCategory()));
	}

	@Override
	public boolean hasChildren(Object element) {
		return element instanceof Category;
	}

	@Override
	public void dispose() {
		categories.clear();
	}
}
