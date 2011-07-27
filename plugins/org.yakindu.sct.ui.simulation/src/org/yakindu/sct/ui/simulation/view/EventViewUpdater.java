package org.yakindu.sct.ui.simulation.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.PlatformUI;
import org.yakindu.sct.core.simulation.ISimulationSessionListener;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;

import de.itemis.xtext.utils.jface.viewers.util.ActiveEditorResolver;

public class EventViewUpdater implements ISimulationSessionListener {

	public List<Event> getViewerInput() {
		List<Event> events = new ArrayList<Event>();
		Resource activeEditorResource = ActiveEditorResolver
				.getActiveEditorResource();
		TreeIterator<EObject> allContents = activeEditorResource
				.getAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (next instanceof Event) {
				events.add((Event) next);
			}
		}
		return events;

	}

	public void simulationStateChanged(SimulationState oldState,
			SimulationState newState) {
		switch (newState) {
		case STARTED:
			updateEventView();
			break;
		case TERMINATED:
			clearEventView();
			break;
		}
	}

	protected EventView getEventView() {
		IViewReference[] viewReferences = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getViewReferences();
		for (IViewReference ref : viewReferences) {
			if (EventView.ID.equals(ref.getId())) {
				return (EventView) ref.getView(false);

			}
		}
		return null;
	}

	private void clearEventView() {
		Display.getDefault().asyncExec(new Runnable() {

			public void run() {
				EventView eventView = getEventView();
				if (eventView != null) {
					eventView.clearViewerInput();
				}
			}
		});
	}

	private void updateEventView() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				EventView eventView = getEventView();
				if (eventView != null) {
					eventView.setViewerInput(getViewerInput());
				}
			}
		});

	}

	public void stateEntered(Vertex vertex) {
		// Nothing to do
	}

	public void stateLeft(Vertex vertex) {
		// Nothing to do
	}

	public void transitionFired(Transition transition) {
		// Nothing to do
	}
}
