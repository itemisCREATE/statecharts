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
import static org.yakindu.sct.simulation.core.sruntime.SRuntimePackage.Literals.EXECUTION_CONTEXT__ACTIVE_STATES;
import static org.yakindu.sct.simulation.core.sruntime.SRuntimePackage.Literals.EXECUTION_CONTEXT__EXECUTED_ELEMENTS;
import static org.yakindu.sct.simulation.core.sruntime.SRuntimePackage.Literals.EXECUTION_CONTEXT__SUSPENDED_ELEMENTS;
import static org.yakindu.sct.simulation.ui.preferences.SimulationPreferenceConstants.STATE_BACKGROUND_HIGHLIGHTING_COLOR;
import static org.yakindu.sct.simulation.ui.preferences.SimulationPreferenceConstants.STATE_FOREGROUND_HIGHLIGHTING_COLOR;
import static org.yakindu.sct.simulation.ui.preferences.SimulationPreferenceConstants.TRANSITION_HIGHLIGHTING_COLOR;
import static org.yakindu.sct.simulation.ui.preferences.SimulationPreferenceConstants.VERTEX_BACKGROUND_TRANSIENT_COLOR;
import static org.yakindu.sct.simulation.ui.preferences.SimulationPreferenceConstants.VERTEX_FOREGROUND_TRANSIENT_COLOR;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.yakindu.gmf.runtime.highlighting.HighlightingParameters;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;
import org.yakindu.sct.simulation.core.sruntime.util.CrossDocumentContentAdapter;
import org.yakindu.sct.simulation.ui.SimulationActivator;

import com.google.common.collect.Lists;

/**
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - Additions
 * 
 */
public class DefaultDynamicNotationHandler extends AbstractDynamicNotationHandler {

	protected static HighlightingParameters TRANSITION_PARAMS = new HighlightingParameters(0, ColorConstants.darkGreen,
			ColorConstants.gray, false);

	protected static HighlightingParameters SUSPENDED_PARAMS = new HighlightingParameters(0, ColorConstants.green,
			HighlightingParameters.DEFAULT.backgroundFadingColor, false);

	ExecutionContextVisualizer visualizer = new ExecutionContextVisualizer();

	protected static HighlightingParameters STATE_HIGHLIGHT_PARAMS = HighlightingParameters.DEFAULT;

	protected static HighlightingParameters VERTEX_TRANSIENT_PARAMS = new HighlightingParameters(0,
			ColorConstants.darkGreen, ColorConstants.green, false);

	protected ExecutionContext context;

	public DefaultDynamicNotationHandler() {
		updatePreferences();
	}

	public void updateExecutionContext(ExecutionContext context) {
		if (this.context != null)
			this.context.eAdapters().remove(visualizer);
		this.context = context;
		restoreNotationState(this.context);
		this.context.eAdapters().add(visualizer);
	}

	protected void restoreNotationState(ExecutionContext context) {
		for (Vertex vertex : context.getAllActiveStates()) {
			getHighlightingSupport().fadeIn(vertex, HighlightingParameters.DEFAULT);
		}
		List<EObject> executedElements = context.getExecutedElements();
		for (EObject eObject : executedElements) {
			getHighlightingSupport().flash(eObject, HighlightingParameters.DEFAULT);
		}

		List<EObject> suspendedElements = context.getSuspendedElements();
		for (EObject eObject : suspendedElements) {
			getHighlightingSupport().fadeIn(eObject, SUSPENDED_PARAMS);
		}

	}

	protected class ExecutionContextVisualizer extends CrossDocumentContentAdapter {

		@Override
		protected boolean shouldAdapt(EStructuralFeature feature) {
			return feature == EXECUTION_CONTEXT__ACTIVE_STATES || feature == EXECUTION_CONTEXT__EXECUTED_ELEMENTS
					|| feature == EXECUTION_CONTEXT__SUSPENDED_ELEMENTS;
		}

		@Override
		public void notifyChanged(final Notification notification) {
			super.notifyChanged(notification);
			Display.getDefault().syncExec(new Runnable() {
				public void run() {
					if (notification.getFeature() == EXECUTION_CONTEXT__ACTIVE_STATES) {
						highlight(notification, HighlightingParameters.DEFAULT);
					} else if (notification.getFeature() == EXECUTION_CONTEXT__EXECUTED_ELEMENTS) {
						highlight(notification, TRANSITION_PARAMS);
					} else if (notification.getFeature() == EXECUTION_CONTEXT__SUSPENDED_ELEMENTS) {
						highlight(notification, SUSPENDED_PARAMS);
					}
				}
			});
		}

		protected void highlight(final Notification notification, HighlightingParameters params) {
			int eventType = notification.getEventType();
			if (eventType == ADD || eventType == ADD_MANY) {
				fadeIn(notification.getNewValue(), params);
			} else if (eventType == REMOVE || eventType == REMOVE_MANY) {
				fadeOut(notification.getOldValue(), params);
			}
		}

		protected void fadeOut(Object value, HighlightingParameters parameters) {
			List<EObject> objects = toList(value);
			for (EObject eObject : objects) {
				getHighlightingSupport().fadeOut(eObject, parameters);
			}
		}

		protected void fadeIn(Object value, HighlightingParameters parameters) {
			List<EObject> objects = toList(value);
			for (EObject eObject : objects) {
				getHighlightingSupport().fadeIn(eObject, parameters);
			}
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

	}

	protected void updatePreferences() {
		IPreferenceStore store = SimulationActivator.getDefault().getPreferenceStore();
		// read out the new colors
		RGB foregroundColor = PreferenceConverter.getColor(store, STATE_FOREGROUND_HIGHLIGHTING_COLOR);
		RGB backgroundColor = PreferenceConverter.getColor(store, STATE_BACKGROUND_HIGHLIGHTING_COLOR);
		RGB vertexForegroundColor = PreferenceConverter.getColor(store, VERTEX_FOREGROUND_TRANSIENT_COLOR);
		RGB vertexBackgroundColor = PreferenceConverter.getColor(store, VERTEX_BACKGROUND_TRANSIENT_COLOR);
		RGB transitionColor = PreferenceConverter.getColor(store, TRANSITION_HIGHLIGHTING_COLOR);

		// Set the new colors
		STATE_HIGHLIGHT_PARAMS.foregroundFadingColor = new Color(Display.getDefault(), foregroundColor);
		STATE_HIGHLIGHT_PARAMS.backgroundFadingColor = new Color(Display.getDefault(), backgroundColor);
		VERTEX_TRANSIENT_PARAMS.foregroundFadingColor = new Color(Display.getDefault(), vertexForegroundColor);
		VERTEX_TRANSIENT_PARAMS.backgroundFadingColor = new Color(Display.getDefault(), vertexBackgroundColor);
		TRANSITION_PARAMS.foregroundFadingColor = new Color(Display.getDefault(), transitionColor);
	}
}
