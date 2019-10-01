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

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.yakindu.sct.examples.wizard.service.data.ExampleCategory;
import org.yakindu.sct.examples.wizard.service.data.ExampleData;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
/**
 * 
 * @author t00manysecretss
 * 
 */
public class ExampleContentProvider implements ITreeContentProvider {
	
	private ListMultimap<ExampleCategory, ExampleData> categories = ArrayListMultimap.create();

	@SuppressWarnings("unchecked")
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		categories.clear();
		if (newInput != null)
			groupCategories((List<ExampleData>) newInput);
	}

	protected void groupCategories(List<ExampleData> newInput) {
		for (ExampleData exampleData : newInput) {
			ExampleCategory cat = ExampleCategory.get(exampleData);
			addExampleToCategory(exampleData, cat);
		}
	}

	protected void addExampleToCategory(ExampleData exampleData, ExampleCategory category) {
		categories.put(category, exampleData);
	}

	@Override
	public Object[] getElements(Object inputElement) {
		List<ExampleCategory> values = Lists.newArrayList();
		values.addAll(categories.asMap().keySet());
		Collections.sort(values);
		return values.toArray();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		return categories.get((ExampleCategory) parentElement).toArray();
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof ExampleData) {
			return ExampleCategory.get((ExampleData) element);
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return element instanceof ExampleCategory;
	}

	@Override
	public void dispose() {
		categories.clear();
	}
}
