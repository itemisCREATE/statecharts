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
package org.yakindu.sct.simulation.ui.view.decorator;

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.contexts.DebugContextEvent;
import org.eclipse.debug.ui.contexts.IDebugContextListener;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;
import org.yakindu.sct.ui.editor.submachine.SubmachineDecorationProvider;

/**
 * Extends the SubmachineDecorationProvider with highlighting captabilities
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class HighlightingSubmachineDecorationProvider extends SubmachineDecorationProvider implements
		IDebugContextListener, IDebugEventSetListener {

	private static SimulationImageRenderer renderer = new SimulationImageRenderer();

	protected IDebugTarget debugTarget;

	public HighlightingSubmachineDecorationProvider() {
		DebugUITools.getDebugContextManager().addDebugContextListener(this);
		DebugPlugin.getDefault().addDebugEventListener(this);
	}

	public void createDecorators(IDecoratorTarget decoratorTarget) {
		Object adapter = decoratorTarget.getAdapter(EObject.class);
		if (adapter instanceof State)
			decoratorTarget.installDecorator(DECORATOR_KEY, new HighlightingSubmachineDecorator(decoratorTarget));
	}

	public void handleDebugEvents(DebugEvent[] events) {
		for (DebugEvent debugEvent : events) {
			handleDebugEvent(debugEvent);
		}
	}

	protected void handleDebugEvent(DebugEvent debugEvent) {
		switch (debugEvent.getKind()) {
		case DebugEvent.TERMINATE:
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					debugTarget = null;
				}
			});
			break;
		case DebugEvent.SUSPEND:
			break;
		case DebugEvent.RESUME:
			break;
		}
	}

	public void debugContextChanged(DebugContextEvent event) {
		if ((event.getFlags() & DebugContextEvent.ACTIVATED) > 0) {
			PlatformObject object = (PlatformObject) ((IStructuredSelection) event.getContext()).getFirstElement();
			if (object == null)
				return;
			IDebugTarget newTarget = (IDebugTarget) object.getAdapter(IDebugTarget.class);
			if (newTarget != debugTarget && newTarget != null && !newTarget.isTerminated()) {
				debugTarget = newTarget;
			}
		}
	}

	public final class HighlightingSubmachineDecorator extends SubmachineDecorator {

		public HighlightingSubmachineDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
		}

		@Override
		protected Diagram getTooltipDiagramToRender(State state) {
			Diagram diagram = super.getTooltipDiagramToRender(state);
			if (debugTarget != null) {
				// We have to to reload the diagram cause we change the styles
				diagram = renderer.getDiagramCopy(diagram);
				ExecutionContext context = (ExecutionContext) debugTarget.getAdapter(ExecutionContext.class);
				renderer.highlightActiveStates(context, diagram);
			}
			return diagram;
		}
	}
}
