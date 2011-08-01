/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.ui.editor;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.simulation.core.ISimulationSessionListener;
import org.yakindu.sct.simulation.core.ISimulationSessionListener.SimulationSessionListenerAdapter;

import de.itemis.gmf.runtime.commons.highlighting.HighlightingParameters;
import de.itemis.gmf.runtime.commons.highlighting.IHighlightingSupport;
import de.itemis.xtext.utils.jface.viewers.util.ActiveEditorResolver;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class HighlightingExecutionListener extends
		SimulationSessionListenerAdapter implements ISimulationSessionListener {

	private IHighlightingSupport highlightingSupport;

	private HighlightingParameters parameters;

	public HighlightingExecutionListener() {
		parameters = new HighlightingParameters();
	}

	protected IHighlightingSupport getSupport() {
		if (highlightingSupport != null)
			return highlightingSupport;
		IEditorPart activeEditor = ActiveEditorResolver.getActiveEditor();
		if (activeEditor != null) {
			IHighlightingSupport support = (IHighlightingSupport) activeEditor
					.getAdapter(IHighlightingSupport.class);
			if (support != null)
				return highlightingSupport = support;
		}
		return new IHighlightingSupport.HighlightingSupportNullImpl();
	}

	public void stateEntered(final Vertex vertex) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				getSupport().fadeIn(vertex, parameters);
			}
		});
	}

	public void stateLeft(final Vertex vertex) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				getSupport().fadeOut(vertex, parameters);
			}
		});
	}

	public void transitionFired(final Transition transition) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				getSupport().flash(transition, parameters);
			}
		});
	}

	public void simulationStateChanged(SimulationState oldState,
			final SimulationState newState) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				switch (newState) {
				case STARTED:
					getSupport().lockEditor();
					break;
				case TERMINATED:
					getSupport().releaseEditor();
					break;
				}
			}
		});
	}
}
