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

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.yakindu.sct.simulation.core.sruntime.CompositeSlot;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;
import org.yakindu.sct.simulation.ui.SimulationActivator;
import org.yakindu.sct.simulation.ui.view.actions.HideTimeEventsAction;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExecutionContextContentProvider implements ITreeContentProvider, IPropertyChangeListener {

	protected class ViewerRefresher implements Runnable {

		private static final int UPDATE_INTERVAL = 500;

		private boolean cancel = false;

		@Override
		public void run() {
			while (!cancel && viewer.getInput() != null) {
				try {
					Thread.sleep(UPDATE_INTERVAL);
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							if (viewer != null && !viewer.getControl().isDisposed() && shouldUpdate)
								viewer.refresh();
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public boolean isCancel() {
			return cancel;
		}

		public void setCancel(boolean cancel) {
			this.cancel = cancel;
		}

	}

	private boolean shouldUpdate = true;
	private ViewerRefresher refresher;
	private Viewer viewer;

	public void dispose() {
		getStore().removePropertyChangeListener(this);
		if (refresher != null)
			refresher.cancel = true;
	}

	public ExecutionContextContentProvider() {
		getStore().addPropertyChangeListener(this);
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = viewer;
		if (refresher != null) {
			refresher.cancel = true;
		}
		refresher = new ViewerRefresher();
		if (newInput != null) {
			new Thread(refresher).start();
		} else {
			refresher.cancel = true;
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

	public boolean isShouldUpdate() {
		return shouldUpdate;
	}

	public void setShouldUpdate(boolean shouldUpdate) {
		this.shouldUpdate = shouldUpdate;
	}

}
