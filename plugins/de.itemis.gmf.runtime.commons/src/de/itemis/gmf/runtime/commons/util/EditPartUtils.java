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
package de.itemis.gmf.runtime.commons.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

public class EditPartUtils {

	@SuppressWarnings("unchecked")
	public static IGraphicalEditPart findEditPartForSemanticElement(
			EditPart editPart, EObject semanticElement) {
		if (semanticElement == null) {
			return null;
		}
		if (editPart instanceof IGraphicalEditPart) {
			EObject resolveSemanticElement = ((IGraphicalEditPart) editPart)
					.resolveSemanticElement();

			if (resolveSemanticElement != null
					&& EcoreUtil.getURI(resolveSemanticElement).equals(
							EcoreUtil.getURI(semanticElement))) {
				return (IGraphicalEditPart) editPart;
			}
		}

		for (Object child : editPart.getChildren()) {
			IGraphicalEditPart recursiveEditPart = findEditPartForSemanticElement(
					(EditPart) child, semanticElement);
			if (recursiveEditPart != null) {
				return recursiveEditPart;
			}
		}

		if (editPart instanceof NodeEditPart) {
			List<Connection> connections = new ArrayList<Connection>();
			connections
					.addAll(((NodeEditPart) editPart).getSourceConnections());
			connections
					.addAll(((NodeEditPart) editPart).getTargetConnections());
			for (Object connection : connections) {
				EObject resolveSemanticElement = ((IGraphicalEditPart) connection)
						.resolveSemanticElement();
				if (EcoreUtil.equals(resolveSemanticElement, semanticElement)) {
					return (IGraphicalEditPart) connection;
				}
			}
		}
		return null;
	}

}
