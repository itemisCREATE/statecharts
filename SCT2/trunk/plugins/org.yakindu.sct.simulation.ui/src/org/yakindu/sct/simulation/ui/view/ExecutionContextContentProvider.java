/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.ui.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.IExecutionContextListener;
import org.yakindu.sct.simulation.core.runtime.impl.AbstractSlot;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionVariable;

import com.google.common.collect.Iterables;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExecutionContextContentProvider implements ITreeContentProvider,
		IExecutionContextListener {

	private Viewer viewer;

	public class Container {
		public String name = "Default";
		public List<AbstractSlot> slots = new ArrayList<AbstractSlot>();
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((name == null) ? 0 : name.hashCode());
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
			Container other = (Container) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		private ExecutionContextContentProvider getOuterType() {
			return ExecutionContextContentProvider.this;
		}
		
	}

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
		if (inputElement instanceof IExecutionContext) {
			List<Container> scopes = new ArrayList<ExecutionContextContentProvider.Container>();
			Container defaultContainer = new Container();
			scopes.add(defaultContainer);
			IExecutionContext context = (IExecutionContext) inputElement;
			Iterable<AbstractSlot> concat = Iterables.concat(
					context.getDeclaredEvents(), context.getVariables());
			for (AbstractSlot abstractSlot : concat) {
				String[] split = abstractSlot.getName().split("\\.");
				if (split.length == 1) {
					defaultContainer.slots.add(abstractSlot);
				} else if (split.length == 2) {
					boolean found = false;
					for (Container container : scopes) {
						if (split[0].equals(container.name)) {
							container.slots.add(abstractSlot);
							found = true;
							break;
						}
					}
					if (!found) {
						Container newScope = new Container();
						newScope.name = split[0];
						newScope.slots.add(abstractSlot);
						scopes.add(newScope);
					}
				}
			}
			return scopes.toArray();
		}
		return new Object[] {};

	}

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof Container) {
			return ((Container) parentElement).slots.toArray();
		}
		return new Object[] {};
	}

	public Object getParent(Object element) {
		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof Container)
			return true;
		return false;
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
