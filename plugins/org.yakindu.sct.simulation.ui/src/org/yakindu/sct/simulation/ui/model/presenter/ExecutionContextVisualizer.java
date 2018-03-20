/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.ui.model.presenter;

import static org.eclipse.emf.common.notify.Notification.ADD;
import static org.eclipse.emf.common.notify.Notification.ADD_MANY;
import static org.eclipse.emf.common.notify.Notification.REMOVE;
import static org.eclipse.emf.common.notify.Notification.REMOVE_MANY;
import static org.yakindu.sct.model.sruntime.SRuntimePackage.Literals.EXECUTION_CONTEXT__ACTIVE_STATES;
import static org.yakindu.sct.model.sruntime.SRuntimePackage.Literals.EXECUTION_CONTEXT__EXECUTED_ELEMENTS;
import static org.yakindu.sct.model.sruntime.SRuntimePackage.Literals.EXECUTION_CONTEXT__SUSPENDED_ELEMENTS;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.base.gmf.runtime.highlighting.HighlightingParameters;
import org.yakindu.base.gmf.runtime.highlighting.IHighlightingSupport;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sruntime.ExecutionContext;
import org.yakindu.sct.model.sruntime.util.CrossDocumentContentAdapter;

import com.google.common.collect.Lists;

/**
 * Observes the {@link ExecutionContext} for semantic changes and visualizes
 * them using {@link IHighlightingSupport}
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExecutionContextVisualizer extends CrossDocumentContentAdapter {

	private IHighlightingSupport highlightingSupport;

	public ExecutionContextVisualizer(IHighlightingSupport support) {
		highlightingSupport = support;
	}

	@Override
	protected boolean shouldAdapt(EStructuralFeature feature) {
		return feature == EXECUTION_CONTEXT__ACTIVE_STATES || feature == EXECUTION_CONTEXT__EXECUTED_ELEMENTS
				|| feature == EXECUTION_CONTEXT__SUSPENDED_ELEMENTS;
	}

	@Override
	public void notifyChanged(final Notification notification) {
		super.notifyChanged(notification);
		if (notification.getFeature() == EXECUTION_CONTEXT__ACTIVE_STATES) {
			highlightActiveStates(notification, DefaultDynamicNotationHandler.STATE_HIGHLIGHT_PARAMS);
		} else if (notification.getFeature() == EXECUTION_CONTEXT__EXECUTED_ELEMENTS) {
			highlight(notification, DefaultDynamicNotationHandler.TRANSITION_PARAMS);
		} else if (notification.getFeature() == EXECUTION_CONTEXT__SUSPENDED_ELEMENTS) {
			highlightSuspendedElements(notification);
		}
	}

	protected void highlightSuspendedElements(final Notification notification) {
		highlight(notification, DefaultDynamicNotationHandler.SUSPENDED_PARAMS);
		List<IHighlightingSupport.Action> actions = new ArrayList<IHighlightingSupport.Action>();
		// This is required to set active state highlighting after resuming from
		// terminated local reaction breakpoint
		ExecutionContext context = getExecutionContext(notification);
		List<EObject> newValues = toList(notification.getNewValue());
		List<EObject> oldValues = toList(notification.getOldValue());
		oldValues.removeAll(newValues);
		for (EObject eObject : oldValues) {
			if (context.getActiveStates().contains(eObject)) {
				actions.add(new IHighlightingSupport.Highlight(eObject,
						DefaultDynamicNotationHandler.STATE_HIGHLIGHT_PARAMS));
			}
		}
		getHighlightingSupport().executeAsync(actions);
	}

	private ExecutionContext getExecutionContext(final Notification notification) {
		ExecutionContext context = (ExecutionContext) EcoreUtil.getRootContainer((EObject) notification.getNotifier());
		return context;
	}

	protected void highlightActiveStates(Notification notification, HighlightingParameters params) {
		int eventType = notification.getEventType();
		List<EObject> objects = null;
		if (eventType == ADD || eventType == ADD_MANY) {
			objects = toList(notification.getNewValue());
		} else if (eventType == REMOVE || eventType == REMOVE_MANY) {
			objects = toList(notification.getOldValue());
		}
		if (objects.size() == 0)
			return;

		List<IHighlightingSupport.Action> actions = new ArrayList<IHighlightingSupport.Action>();
		for (EObject eObject : objects) {
			if (eObject instanceof RegularState) {
				EObject container = eObject;
				while (container != null) {
					if (container instanceof RegularState) {
						if (eventType == ADD || eventType == ADD_MANY) {
							actions.add(new IHighlightingSupport.Highlight(container, params));
						} else if (eventType == REMOVE || eventType == REMOVE_MANY) {
							actions.add(new IHighlightingSupport.Highlight(container, null));
						}
					}
					container = container.eContainer();
				}
			}
		}
		getHighlightingSupport().executeAsync(actions);
	}

	protected void highlight(final Notification notification, HighlightingParameters params) {
		List<IHighlightingSupport.Action> actions = new ArrayList<IHighlightingSupport.Action>();
		int eventType = notification.getEventType();
		if (eventType == ADD || eventType == ADD_MANY) {
			List<EObject> objects = toList(notification.getNewValue());
			actions.add(new IHighlightingSupport.Highlight(objects, params));
		} else if (eventType == REMOVE || eventType == REMOVE_MANY) {
			List<EObject> objects = toList(notification.getOldValue());
			actions.add(new IHighlightingSupport.Highlight(objects, null));
		}
		getHighlightingSupport().executeAsync(actions);
	}

	@SuppressWarnings("unchecked")
	private List<EObject> toList(Object value) {
		List<EObject> objects = Lists.newArrayList();
		if (value instanceof EObject) {
			objects.add((EObject) value);
		} else if (value instanceof List) {
			objects.addAll((List<EObject>) value);
		}
		return objects;
	}

	public IHighlightingSupport getHighlightingSupport() {
		return highlightingSupport;
	}

	public void setHighlightingSupport(IHighlightingSupport highlightingSupport) {
		this.highlightingSupport = highlightingSupport;
	}

}