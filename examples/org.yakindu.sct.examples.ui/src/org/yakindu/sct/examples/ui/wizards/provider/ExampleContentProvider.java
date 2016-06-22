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
package org.yakindu.sct.examples.ui.wizards.provider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.yakindu.sct.examples.ui.wizards.ExampleData;

/**
 * 
 * @author t00manysecretss
 * 
 */
public class ExampleContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	@Override
	@SuppressWarnings("unchecked")
	public Object[] getElements(Object inputElement) {
		ArrayList<ExampleData> nodes = new ArrayList<ExampleData>();
		List<ExampleData> exdata = (List<ExampleData>) inputElement;
		Iterator<ExampleData> iex = exdata.iterator();
		while (iex.hasNext()) {
			ExampleData next = iex.next();
			if (next.getParent() == null) {
				nodes.add(next);
			}
		}
		ExampleData[] result = nodes.toArray(new ExampleData[nodes.size()]);
		return result;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		return ((ExampleData) parentElement).getChildren();
	}

	@Override
	public Object getParent(Object element) {
		return ((ExampleData) element).getParent();
	}

	@Override
	public boolean hasChildren(Object element) {
		return ((ExampleData) element).hasChildren();
	}
}
