package org.yakindu.sct.statechart.diagram.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.yakindu.sct.statechart.diagram.commands.CreateTransitionCommand;


public class HistorySemanticEditPolicy extends SemanticEditPolicy {

	protected Command getSemanticCommand(IEditCommandRequest request) {
		if (request instanceof CreateRelationshipRequest) {
			CreateRelationshipRequest relationshipRequest = (CreateRelationshipRequest) request;
			return new ICommandProxy(new CreateTransitionCommand(
					relationshipRequest));
		}
		return super.getSemanticCommand(request);
	}
}
