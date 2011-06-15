/**
 * Copyright (c) 2010-21011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.statechart.diagram.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.yakindu.model.sct.statechart.Entry;
import org.yakindu.model.sct.statechart.FinalState;
import org.yakindu.model.sct.statechart.StatechartFactory;
import org.yakindu.model.sct.statechart.Transition;
import org.yakindu.model.sct.statechart.Vertex;

/**
 * 
 * @author muelder
 * @author terfloth
 *
 */
public class CreateTransitionCommand extends EditElementCommand {

	private final Vertex source;

	private final Vertex target;

	public CreateTransitionCommand(CreateRelationshipRequest request) {
		super(request.getLabel(), null, request);
		this.source = (Vertex) request.getSource();
		this.target = (Vertex) request.getTarget();
	}

	@Override
	public boolean canExecute() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null && !(source instanceof Vertex))
			return false;
		if (target != null && !(target instanceof Vertex))
			return false;
		return checkConstraints();
	}

	private boolean checkConstraints() {
//		if (source instanceof FinalState)
//			return false;
//		if (target instanceof Entry)
//			return false;
//		if (source instanceof HistoryState)
//			return false;
//		if (source instanceof InitialState && ((InitialState) source).getOutgoingTransitions().size() > 0)
//			return false;

		return true;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command");
		}
		if (getSource() != null && getTarget() != null) {
			Transition transition = StatechartFactory.eINSTANCE.createTransition();
			source.getOutgoingTransitions().add(transition);
			transition.setSource(source);
			transition.setTarget(target);
			source.getOutgoingTransitions().add(transition);
			target.getIncomingTransitions().add(transition);
			((CreateElementRequest) getRequest()).setNewElement(transition);
		}
		return CommandResult.newOKCommandResult();

	}

	public Vertex getSource() {
		return source;
	}

	public Vertex getTarget() {
		return target;
	}

}
