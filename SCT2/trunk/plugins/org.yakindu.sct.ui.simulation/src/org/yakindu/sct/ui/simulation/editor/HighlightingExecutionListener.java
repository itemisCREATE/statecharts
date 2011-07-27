package org.yakindu.sct.ui.simulation.editor;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.yakindu.sct.core.simulation.ISimulationSessionListener;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;

import de.itemis.gmf.runtime.commons.highlighting.HighlightingParameters;
import de.itemis.gmf.runtime.commons.highlighting.IHighlightingSupport;
import de.itemis.xtext.utils.jface.viewers.util.ActiveEditorResolver;

/**
 * 
 * @author andreas muelder
 * 
 */
public class HighlightingExecutionListener implements
		ISimulationSessionListener {

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
				System.out.println("Fading in..." + vertex);
				highlightingSupport.fadeIn(vertex, parameters);
			}
		});
	}

	public void stateLeft(final Vertex vertex) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				System.out.println("Fading out..." + vertex);
				highlightingSupport.fadeOut(vertex, parameters);
			}
		});
	}

	public void transitionFired(final Transition transition) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				System.out.println("Flashing..." + transition);
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
