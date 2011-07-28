package org.yakindu.sct.ui.simulation.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.PlatformUI;
import org.yakindu.sct.core.simulation.ISimulationSessionListener.SimulationSessionListenerAdapter;
import org.yakindu.sct.model.sgraph.Declaration;

import de.itemis.xtext.utils.jface.viewers.util.ActiveEditorResolver;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DeclarationsViewUpdater extends SimulationSessionListenerAdapter {


	public static List<Declaration> getViewerInput() {
		List<Declaration> declarations = new ArrayList<Declaration>();
		Resource activeEditorResource = ActiveEditorResolver
				.getActiveEditorResource();
		if (activeEditorResource == null)
			return Collections.emptyList();
		TreeIterator<EObject> allContents = activeEditorResource
				.getAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (next instanceof Declaration) {
				declarations.add((Declaration) next);
			}
		}
		return declarations;

	}

	public void simulationStateChanged(SimulationState oldState,
			SimulationState newState) {
		switch (newState) {
		case STARTED:
			updateDeclarationView();
			break;
		case TERMINATED:
			clearDeclarationView();
			break;
		}
	}

	@Override
	public void variableValueChanged(String variableName, Object value) {
		System.out.println("VARIABLE VALUE CHANGED!!!!! " + variableName
				+ " value is " + value);
		super.variableValueChanged(variableName, value);
	}

	protected DeclarationView getDeclarationView() {
		IViewReference[] viewReferences = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getViewReferences();
		for (IViewReference ref : viewReferences) {
			if (DeclarationView.ID.equals(ref.getId())) {
				return (DeclarationView) ref.getView(true);

			}
		}
		return null;
	}

	private void clearDeclarationView() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				DeclarationView eventView = getDeclarationView();
				if (eventView != null) {
					eventView.clearViewerInput();
				}
			}
		});
	}

	private void updateDeclarationView() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				DeclarationView eventView = getDeclarationView();
				if (eventView != null) {
					eventView.setEventViewerInput(getViewerInput());
				}
			}
		});
	}
}
