/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.ui.breakpoints;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.yakindu.sct.simulation.core.breakpoints.SCTBreakpoint;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ToggleBreakpointCommand extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		IGraphicalEditPart selectedEditPart = unwrap(selection);
		EObject object = selectedEditPart.resolveSemanticElement();
		SCTBreakpoint existingBreakpoint = findExistingBreakpoint(object);
		if (existingBreakpoint != null) {
			try {
				existingBreakpoint.delete();
				return null;
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

		SCTBreakpoint breakpoint = new SCTBreakpoint(object);
		breakpoint.setNotationViewURI(EcoreUtil.getURI(selectedEditPart.getNotationView()).fragment().toString());
		try {
			DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(breakpoint);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected SCTBreakpoint findExistingBreakpoint(EObject object) {
		IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager()
				.getBreakpoints(SCTBreakpoint.BREAKPOINT_ID);
		for (IBreakpoint iBreakpoint : breakpoints) {
			if (iBreakpoint instanceof SCTBreakpoint) {
				EObject semanticObject = ((SCTBreakpoint) iBreakpoint).getSemanticObject();
				if (object.equals(semanticObject)) {
					return (SCTBreakpoint) iBreakpoint;
				}
			}
		}
		return null;

	}

	public IGraphicalEditPart unwrap(ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		Object firstElement = structuredSelection.getFirstElement();
		if (firstElement == null)
			return null;
		return ((IGraphicalEditPart) firstElement);
	}
}
