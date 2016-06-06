package org.yakindu.sct.examples.ui.wizards;

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
	public Object[] getElements(Object inputElement) {
		return (ExampleData[]) inputElement;
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
