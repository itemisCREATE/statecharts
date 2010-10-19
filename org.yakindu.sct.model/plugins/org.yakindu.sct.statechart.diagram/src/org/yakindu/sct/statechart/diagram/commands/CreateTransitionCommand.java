package org.yakindu.sct.statechart.diagram.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.yakindu.sct.model.statechart.statechart.FinalState;
import org.yakindu.sct.model.statechart.statechart.HistoryState;
import org.yakindu.sct.model.statechart.statechart.InitialState;
import org.yakindu.sct.model.statechart.statechart.Region;
import org.yakindu.sct.model.statechart.statechart.StatechartFactory;
import org.yakindu.sct.model.statechart.statechart.Transition;
import org.yakindu.sct.model.statechart.statechart.Vertex;

/**
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
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
		if (source != null && !(source instanceof Vertex))
			return false;
		if (target != null && !(target instanceof Vertex))
			return false;
		return checkConstraints();
	}

	private boolean checkConstraints() {
		if (source instanceof FinalState)
			return false;
		if (target instanceof InitialState)
			return false;
		if (target instanceof HistoryState)
			return false;
		if (source instanceof InitialState && ((InitialState) source).getOutgoingTransitions().size() > 0)
			return false;
		if (target instanceof HistoryState && ((HistoryState) target).getOutgoingTransitions().size() > 0)
			return false;
		if (target instanceof FinalState && ((FinalState) target).getIncomingTransitions().size() > 0)
			return false;

		return true;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command");
		}
		if (getSource() != null && getTarget() != null) {
			Transition transition = StatechartFactory.eINSTANCE.createTransition();
			getContainer().getTransitions().add(transition);
			transition.setSource(source);
			transition.setTarget(target);
			source.getOutgoingTransitions().add(transition);
			target.getIncomingTransitions().add(transition);
			((CreateElementRequest) getRequest()).setNewElement(transition);
		}
		return CommandResult.newOKCommandResult();

	}

	private static Region setContainer(Vertex source, Vertex target) {
		if (source == null || target == null)
			return null;
		Assert.isTrue(source.getContainingRegion().equals(target.getContainingRegion()));
		return source.getContainingRegion();
	}

	public Region getContainer() {
		return container;
	}

	public Vertex getSource() {
		return source;
	}

	public Vertex getTarget() {
		return target;
	}

}
