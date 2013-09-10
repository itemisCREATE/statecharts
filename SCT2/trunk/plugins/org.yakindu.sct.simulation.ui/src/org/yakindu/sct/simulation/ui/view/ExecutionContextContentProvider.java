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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.yakindu.sct.simulation.core.sruntime.CompositeSlot;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;
import org.yakindu.sct.simulation.core.sruntime.SRuntimePackage;
import org.yakindu.sct.simulation.ui.SimulationActivator;
import org.yakindu.sct.simulation.ui.view.actions.HideTimeEventsAction;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExecutionContextContentProvider implements ITreeContentProvider, IPropertyChangeListener {

	private Viewer viewer;
	protected RefreshAdapter refreshAdapter = new RefreshAdapter();

	public void dispose() {
		getStore().removePropertyChangeListener(this);
	}

	public ExecutionContextContentProvider() {
		getStore().addPropertyChangeListener(this);
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = viewer;
		if (oldInput != null) {
			ExecutionContext oldContext = (ExecutionContext) oldInput;
			oldContext.eAdapters().remove(refreshAdapter);
		}
		if (newInput != null) {
			ExecutionContext newContext = (ExecutionContext) newInput;
			newContext.eAdapters().add(refreshAdapter);
		}
	}

	public Object[] getElements(Object inputElement) {
		if (inputElement == null) {
			return new Object[] {};
		}
		if (inputElement instanceof ExecutionContext) {
			return ((ExecutionContext) inputElement).getSlots().toArray();
		}
		return new Object[] {};

	}

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof CompositeSlot) {
			return ((CompositeSlot) parentElement).getSlots().toArray();
		}
		return new Object[] {};
	}

	public Object getParent(Object element) {
		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof CompositeSlot) {
			return ((CompositeSlot) element).getSlots().size() > 0;
		}
		return false;
	}

	private IPreferenceStore getStore() {
		return SimulationActivator.getDefault().getPreferenceStore();
	}

	public void propertyChange(PropertyChangeEvent event) {
		if (event.getProperty() == HideTimeEventsAction.HIDE_KEY) {
			if (viewer != null && !viewer.getControl().isDisposed())
				viewer.refresh();
		}
	}

	protected final class RefreshAdapter extends EContentAdapter {
		@Override
		public void notifyChanged(Notification notification) {
			if (notification.getFeature() == SRuntimePackage.Literals.EXECUTION_SLOT__VALUE
					|| notification.getFeature() == SRuntimePackage.Literals.EXECUTION_EVENT__RAISED
					|| notification.getFeature() == SRuntimePackage.Literals.EXECUTION_EVENT__SCHEDULED)
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						if (viewer != null && !viewer.getControl().isDisposed())
							viewer.refresh();
					}
				});

			super.notifyChanged(notification);
		}
	}
}
