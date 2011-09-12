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
package org.yakindu.sct.ui.editor.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;

/**
 * 
 * @author muelder
 * @author terfloth
 * @author muehlbrandt
 * 
 */
public class CreateTransitionCommand extends EditElementCommand {
	
	public CreateTransitionCommand(CreateRelationshipRequest request) {
		super(request.getLabel(), null, request);
	}
	
	@Override
	protected CreateRelationshipRequest getRequest() {
		return (CreateRelationshipRequest) super.getRequest();
	}

	@Override
	public boolean canExecute() {
		EObject source = getRequest().getSource();
		EObject target = getRequest().getTarget();
		
		if (source == null && target == null) {
			return false;
		}
		if (source != null && !(source instanceof Vertex))
			return false;
		if (target != null && !(target instanceof Vertex))
			return false;
		return true;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {

		// This class casts should be save because they are validated in
		// canExecute() method which is called by the framework before
		// execution.
		Vertex source = (Vertex) getRequest().getSource();
		Vertex target = (Vertex) getRequest().getTarget();
//		if (!canExecute()) {
//			throw new ExecutionException(
//					"Invalid arguments in create link command");
//		}
		if (source != null && target != null) {
			Transition transition = SGraphFactory.eINSTANCE.createTransition();
			source.getOutgoingTransitions().add(transition);
			transition.setSource(source);
			transition.setTarget(target);
			source.getOutgoingTransitions().add(transition);
			target.getIncomingTransitions().add(transition);
			((CreateElementRequest) getRequest()).setNewElement(transition);
		}
		return CommandResult.newOKCommandResult();
	}
}
