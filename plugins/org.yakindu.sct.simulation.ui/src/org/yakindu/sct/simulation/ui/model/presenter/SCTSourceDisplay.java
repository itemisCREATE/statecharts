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
package org.yakindu.sct.simulation.ui.model.presenter;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.debug.ui.sourcelookup.ISourceDisplay;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugElement;
import org.yakindu.sct.simulation.core.debugmodel.SCTStackFrame;
import org.yakindu.sct.simulation.core.runtime.IExecutionContextListener;
import org.yakindu.sct.simulation.core.runtime.IExecutionFacade;
import org.yakindu.sct.simulation.core.runtime.IExecutionFacadeListener;
import org.yakindu.sct.simulation.core.session.ISimulationSessionListener;
import org.yakindu.sct.simulation.core.session.SimulationSession;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;

import de.itemis.gmf.runtime.commons.highlighting.HighlightingParameters;
import de.itemis.gmf.runtime.commons.highlighting.IHighlightingSupport;
import de.itemis.gmf.runtime.commons.util.EditPartUtils;

/**
 * The {@link SCTSourceDisplay} displays the active State of the running debug
 * session.
 * 
 * <pre>
 *  - highlights the initial active states
 *  - registers itself as a {@link ISimulationSessionListener} to paint state changes
 * </pre>
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTSourceDisplay implements ISimulationSessionListener,
		IExecutionFacadeListener, ISourceDisplay {

	private IHighlightingSupport support = new IHighlightingSupport.HighlightingSupportNullImpl();

	private SimulationSession lastActiveSession;

	private HighlightingParameters parameters = new HighlightingParameters();

	public SCTSourceDisplay() {
	}

	public void displaySource(Object element, IWorkbenchPage page,
			boolean forceSourceLookup) {

		SCTDebugElement debugElement = (SCTDebugElement) element;
		SimulationSession session = (SimulationSession) debugElement
				.getAdapter(SimulationSession.class);
		IExecutionFacade facade = (IExecutionFacade) debugElement
				.getAdapter(IExecutionFacade.class);
		
		//TODO CHECK FOR MULTI EDITOR SIM
		facade.addExecutionListener(this);

		StatechartDiagramEditor editor = openEditorAndSelectElements(
				debugElement, page);

		// Release the old editor
		if (support.isLocked())
			support.releaseEditor();

		support = (IHighlightingSupport) editor
				.getAdapter(IHighlightingSupport.class);

		// Release the new editor
		if (support.isLocked())
			support.releaseEditor();

		// Paint the active states if the session is not terminated
		if (session.getCurrentState() != SimulationState.TERMINATED) {
			support.lockEditor();
			Set<Vertex> stateConfiguration = facade.getExecutionContext()
					.getActiveStates();
			for (Vertex vertex : stateConfiguration) {
				support.highlight(vertex, new HighlightingParameters());
			}
		}

		// Register me as a Session Listener to control the highlighting
		if (lastActiveSession != null) {
			lastActiveSession.removeSimulationListener(this);
		}
		session.addSimulationListener(this);
		lastActiveSession = session;

	}

	public void stateEntered(final Vertex vertex) {
		System.out.println("enter state: " + vertex.getName());
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				getSupport().fadeIn(vertex, parameters);
			}
		});
	}

	public void stateLeft(final Vertex vertex) {
		System.out.println("leave state: " + vertex.getName());

		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				getSupport().fadeOut(vertex, parameters);
			}
		});
	}

	
	public void pseudoStateExecuted(final Vertex vertex) {
		System.out.println("execute: " + vertex.getName() );

		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				getSupport().flash(vertex, parameters);
			}
		});		
	}

	public void transitionFired(final Transition transition) {
		System.out.println("take: " + transition.getSource().getName() + " -> " + transition.getTarget().getName());

		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				getSupport().flash(transition, parameters);
			}
		});
	}

	public void simulationStateChanged(SimulationState oldState,
			SimulationState newState) {
		if (newState == SimulationState.TERMINATED) {
			if (support.isLocked())
				support.releaseEditor();
		}
	}

	/**
	 * Opens the editor for this resource and selects the selected Editparts
	 * 
	 * @param debugElement
	 * @param page
	 * @return
	 */
	private StatechartDiagramEditor openEditorAndSelectElements(
			SCTDebugElement debugElement, IWorkbenchPage page) {
		String platformString = debugElement.getResourceString();
		IResource resource = ResourcesPlugin.getWorkspace().getRoot()
				.findMember(platformString);
		StatechartDiagramEditor editor = null;
		try {
			editor = (StatechartDiagramEditor) page.openEditor(
					new FileEditorInput(((IFile) resource)),
					StatechartDiagramEditor.ID);

			if (debugElement instanceof SCTStackFrame) {
				IGraphicalEditPart editPart = EditPartUtils
						.findEditPartForSemanticElement(editor
								.getDiagramGraphicalViewer().getRootEditPart(),
								((SCTStackFrame) debugElement).getState());
				if (editPart != null) {
					editor.getDiagramGraphicalViewer().reveal(editPart);
					editor.getDiagramGraphicalViewer().select(editPart);
				}
			}
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return editor;
	}

	public IHighlightingSupport getSupport() {
		return support;
	}
}
