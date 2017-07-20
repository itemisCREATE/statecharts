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

import static org.eclipse.draw2d.ColorConstants.darkGreen;
import static org.eclipse.draw2d.ColorConstants.gray;
import static org.eclipse.draw2d.ColorConstants.green;
import static org.yakindu.sct.simulation.ui.preferences.SimulationPreferenceConstants.STATE_BACKGROUND_HIGHLIGHTING_COLOR;
import static org.yakindu.sct.simulation.ui.preferences.SimulationPreferenceConstants.STATE_FOREGROUND_HIGHLIGHTING_COLOR;
import static org.yakindu.sct.simulation.ui.preferences.SimulationPreferenceConstants.TRANSITION_HIGHLIGHTING_COLOR;
import static org.yakindu.sct.simulation.ui.preferences.SimulationPreferenceConstants.VERTEX_BACKGROUND_TRANSIENT_COLOR;
import static org.yakindu.sct.simulation.ui.preferences.SimulationPreferenceConstants.VERTEX_FOREGROUND_TRANSIENT_COLOR;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.yakindu.base.gmf.runtime.highlighting.HighlightingParameters;
import org.yakindu.base.gmf.runtime.highlighting.IHighlightingSupport;
import org.yakindu.sct.simulation.ui.SimulationActivator;
import org.yakindu.sct.simulation.ui.preferences.SimulationPreferenceConstants;

/**
 * Color handling from the preference store
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractDynamicNotationHandler implements IDynamicNotationHandler, IPropertyChangeListener {

	public static HighlightingParameters TRANSITION_PARAMS = new HighlightingParameters(darkGreen, gray);
	public static HighlightingParameters STATE_HIGHLIGHT_PARAMS = HighlightingParameters.DEFAULT;
	public static HighlightingParameters VERTEX_TRANSIENT_PARAMS = new HighlightingParameters(darkGreen, green);
	public static HighlightingParameters SUSPENDED_PARAMS = new HighlightingParameters(green,
			HighlightingParameters.DEFAULT.backgroundFadingColor);

	protected static final IHighlightingSupport NULL_SUPPORT =  new IHighlightingSupport.HighlightingSupportNullImpl();
	
	public AbstractDynamicNotationHandler() {
		SimulationActivator.getDefault().getPreferenceStore().addPropertyChangeListener(this);
		updatePreferences();
	}

	private IHighlightingSupport support = new IHighlightingSupport.HighlightingSupportNullImpl();

	public void propertyChange(PropertyChangeEvent event) {
		if (SimulationPreferenceConstants.STATE_BACKGROUND_HIGHLIGHTING_COLOR.equals(event.getProperty())
				|| SimulationPreferenceConstants.TRANSITION_HIGHLIGHTING_COLOR.equals(event.getProperty())
				|| SimulationPreferenceConstants.STATE_FOREGROUND_HIGHLIGHTING_COLOR.equals(event.getProperty())) {
			updatePreferences();
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
		SUSPENDED_PARAMS.backgroundFadingColor = STATE_HIGHLIGHT_PARAMS.backgroundFadingColor;
		SUSPENDED_PARAMS.foregroundFadingColor = green;
		VERTEX_TRANSIENT_PARAMS.foregroundFadingColor = new Color(Display.getDefault(), vertexForegroundColor);
		VERTEX_TRANSIENT_PARAMS.backgroundFadingColor = new Color(Display.getDefault(), vertexBackgroundColor);
		TRANSITION_PARAMS.foregroundFadingColor = new Color(Display.getDefault(), transitionColor);
	}

	public IHighlightingSupport getHighlightingSupport() {
		return support;
	}

	public void setHighlightingSupport(IHighlightingSupport support) {
		this.support = support;
	}
}
