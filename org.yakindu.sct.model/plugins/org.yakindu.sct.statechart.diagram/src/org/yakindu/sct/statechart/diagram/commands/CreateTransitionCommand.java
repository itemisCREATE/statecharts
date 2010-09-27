package org.yakindu.sct.statechart.diagram.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.yakindu.sct.model.statechart.statechart.Region;
import org.yakindu.sct.model.statechart.statechart.StatechartFactory;
import org.yakindu.sct.model.statechart.statechart.Transition;
import org.yakindu.sct.model.statechart.statechart.Vertex;

public class CreateTransitionCommand extends EditElementCommand {

	private final Vertex source;

	private final Vertex target;

	private final Region container;

	public CreateTransitionCommand(CreateRelationshipRequest request) {
		super(request.getLabel(), null, request);
		this.source = (Vertex) request.getSource();
		this.target = (Vertex) request.getTarget();
		container = setContainer(source, target);
	}

	@Override
	public boolean canExecute() {
		if (source == null && target == null) {
			return false;

		}
		if (!(source instanceof Vertex) || !(target instanceof Vertex)) {
			return false;
		}
		return true;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}

		Transition transition = StatechartFactory.eINSTANCE.createTransition();
		getContainer().getTransitions().add(transition);
		transition.setSource(source);
		transition.setTarget(target);
		((CreateElementRequest) getRequest()).setNewElement(transition);
		System.out.println("Created Transition with source " + source + " and target " + target);
		return CommandResult.newOKCommandResult(transition);

	}

	public Region getContainer() {
		return container;
	}

	private static Region setContainer(Vertex source, Vertex target) {
		if (source == null || target == null)
			return null;
		Assert.isTrue(source.getContainingRegion().equals(target.getContainingRegion()));
		return source.getContainingRegion();
	}
}
