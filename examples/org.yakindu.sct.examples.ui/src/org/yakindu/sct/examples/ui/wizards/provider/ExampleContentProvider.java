package org.yakindu.sct.examples.ui.wizards.provider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.yakindu.sct.examples.ui.service.IExampleService.ExampleData;

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
		while(iex.hasNext()) {
			ExampleData next = iex.next();
			if(next.getParent() == null) {
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
