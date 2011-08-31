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
package org.yakindu.sct.ui.editor.edithelper;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.ui.editor.commands.CreateTransitionCommand;

/**
 * Base Edit Helper class for all Vertices
 * 
 * @author andreas muelder
 * 
 */
public class VertexEditHelper extends AbstractEditHelper {

	/**
	 * Returns a custom {@link CreateTransitionCommand} that sets the target
	 * transition
	 */
	@Override
	protected ICommand getCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		return new CreateTransitionCommand(req);
	}

	@Override
	protected ICommand getDestroyDependentsCommand(DestroyDependentsRequest req) {
		
		Vertex elementToDestroy = (Vertex) req.getElementToDestroy();
		EList<Transition> incomingTransitions = elementToDestroy
				.getIncomingTransitions();
		if (incomingTransitions.size() != 0) {
			CompositeCommand compoundCommand = new CompositeCommand(
					"Delete vertex");
			for (Transition transition : incomingTransitions) {
				DestroyElementCommand destroyCommand = new DestroyElementCommand(
						new DestroyElementRequest(transition, false));
				compoundCommand.add(destroyCommand);
			}
			return compoundCommand;
		}
		return super.getDestroyDependentsCommand(req);
	}
}
