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
package org.yakindu.sct.ui.simulation.editor;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.yakindu.sct.core.simulation.ISimulationSessionListener;
import org.yakindu.sct.core.simulation.ISimulationSessionListener.SimulationSessionListenerAdapter;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;

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

		IEditorPart activeEditor = ActiveEditorResolver.getActiveEditor();
		if (activeEditor != null) {
			// TODO The active editor should be adaptable to IHighlightSupport
			// via registered factory
			IHighlightingSupportAdapterFactory factory = new IHighlightingSupportAdapterFactory();
			highlightingSupport = (IHighlightingSupport) factory.getAdapter(
					activeEditor, IHighlightingSupport.class);

		}

		parameters = new HighlightingParameters();
	}

	public void stateEntered(final Vertex vertex) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				highlightingSupport.fadeIn(vertex, parameters);
			}
		});
	}

	public void stateLeft(final Vertex vertex) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				highlightingSupport.fadeOut(vertex, parameters);
			}
		});
	}

	public void transitionFired(final Transition transition) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				highlightingSupport.flash(transition, parameters);
			}
		});
	}

	public void simulationStateChanged(SimulationState oldState,
			final SimulationState newState) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				switch (newState) {
				case STARTED:
					highlightingSupport.lockEditor();
					break;
				case TERMINATED:
					highlightingSupport.releaseEditor();
					break;
				}
			}
		});
	}
}
