package org.yakindu.sct.simulation.ui.view;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.IExecutionContextListener;
import org.yakindu.sct.simulation.core.runtime.impl.AbstractSlot;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionVariable;

import com.google.common.collect.Iterables;

public class ExecutionContextContentProvider implements ITreeContentProvider,
		IExecutionContextListener {

	private Viewer viewer;

	public void dispose() {

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = viewer;
		if (oldInput != null) {
			IExecutionContext oldContext = (IExecutionContext) oldInput;
			oldContext.removeExecutionContextListener(this);
		}
		if (newInput != null) {
			IExecutionContext newContext = (IExecutionContext) newInput;
			newContext.addExecutionContextListener(this);
		}
	}

	public Object[] getElements(Object inputElement) {
		if (inputElement == null) {
			return new Object[] {};
		}
		IExecutionContext context = (IExecutionContext) inputElement;
		Iterable<AbstractSlot> concat = Iterables.concat(
				context.getDeclaredEvents(), context.getVariables());
		return Iterables.toArray(concat, Object.class);
	}

	public Object[] getChildren(Object parentElement) {
		return null;
	}

	public Object getParent(Object element) {
		return null;
	}

	public boolean hasChildren(Object element) {
		return false;
	}

	public void variableDeclared(ExecutionVariable variable) {
	}

	public void eventDeclared(ExecutionEvent event) {
	}

	public void eventRaised(ExecutionEvent event) {
	}

	public void variableValueChanged(ExecutionVariable variable) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				viewer.refresh();
			}
		});
	}

}
