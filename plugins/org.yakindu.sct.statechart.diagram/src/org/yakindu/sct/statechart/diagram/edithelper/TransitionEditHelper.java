package org.yakindu.sct.statechart.diagram.edithelper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.yakindu.model.sct.statechart.StatechartPackage;

public class TransitionEditHelper extends AbstractEditHelper {
	@Override
	protected ICommand getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		switch (req.getDirection()) {
		case ReorientRelationshipRequest.REORIENT_SOURCE:
			return new SetValueCommand(new SetRequest(req.getRelationship(),
					StatechartPackage.Literals.TRANSITION__SOURCE,
					req.getNewRelationshipEnd()));
		case ReorientRelationshipRequest.REORIENT_TARGET:
			return new SetValueCommand(new SetRequest(req.getRelationship(),
					StatechartPackage.Literals.TRANSITION__TARGET,
					req.getNewRelationshipEnd()));
		}
		return super.getReorientRelationshipCommand(req);
	}
}
