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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.IExecutionContextListener;
import org.yakindu.sct.simulation.core.runtime.impl.AbstractSlot;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionVariable;
import org.yakindu.sct.simulation.ui.SimulationActivator;
import org.yakindu.sct.simulation.ui.view.actions.HideTimeEventsAction;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExecutionContextContentProvider implements ITreeContentProvider,
		IExecutionContextListener, IPropertyChangeListener {

	private Viewer viewer;

	public void dispose() {
		getStore().removePropertyChangeListener(this);
	}

	public ExecutionContextContentProvider() {
		getStore().addPropertyChangeListener(this);
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
			Set<Container> scopes = new HashSet<Container>();
			Container defaultContainer = new Container();
			scopes.add(defaultContainer);
			Container timeEventContainer = new Container("Time Events");
			scopes.add(timeEventContainer);
			IExecutionContext context = (IExecutionContext) inputElement;
			Iterable<AbstractSlot> slotelements = Iterables.concat(
					context.getDeclaredEvents(), context.getVariables());
			for (AbstractSlot abstractSlot : slotelements) {
				if (abstractSlot.getScopeSegment() != null) {
					Container newScope = new Container();
					newScope.name = abstractSlot.getScopeSegment();
					newScope.slots.add(abstractSlot);
					scopes.add(newScope);
				}
			}
			for (AbstractSlot abstractSlot : slotelements) {
				if (abstractSlot.getScopeSegment() == null) {
					if (abstractSlot.getSimpleName().contains("time_event")) {
						if (!hideTimeEvents()) {
							timeEventContainer.slots.add(abstractSlot);
						}
					} else {
						defaultContainer.slots.add(abstractSlot);
					}
				} else {
					for (Container container : scopes) {
						if (abstractSlot.getScopeSegment().equals(
								container.name)) {
							container.slots.add(abstractSlot);
							break;
						}
					}
				}
			}
			return Iterables.toArray(
					Iterables.filter(scopes, new Predicate<Container>() {
						public boolean apply(Container input) {
							return input.slots.size() > 0;
						}
					}), Container.class);
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
				if (viewer != null && !viewer.getControl().isDisposed())
					viewer.refresh();
			}
		});
	}

	private IPreferenceStore getStore() {
		return SimulationActivator.getDefault().getPreferenceStore();
	}

	private boolean hideTimeEvents() {
		return getStore().getBoolean(HideTimeEventsAction.HIDE_KEY);
	}

	public void propertyChange(PropertyChangeEvent event) {
		if (event.getProperty() == HideTimeEventsAction.HIDE_KEY) {
			if (viewer != null && !viewer.getControl().isDisposed())
				viewer.refresh();
		}
	}

	/**
	 * Container for grouping variables and events
	 * 
	 */
	public static class Container {
		String name = "Default";
		Set<AbstractSlot> slots = new HashSet<AbstractSlot>();

		public Container() {
			super();
		}

		public Container(String name) {
			this.name = name;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
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
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

	}

}
