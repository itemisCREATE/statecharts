package org.yakindu.sct.statechart.diagram.policies;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.model.sct.statechart.TransitionExpression;
import org.yakindu.sct.statechart.diagram.editparts.TransitionExpressionEditPart;
import org.yakindu.sct.statechart.diagram.validation.GMFMarkerUtil;

import de.itemis.xtext.utils.gmf.directedit.XTextDirectEditPolicy;

/**
 * @author muelder
 * 
 */
public class TransitionExpressionEditPolicy extends
		XTextDirectEditPolicy<TransitionExpression> {


	@Override
	protected Command getDirectEditCommand(DirectEditRequest edit,
			TransitionExpression rootASTElement) {
		SetRequest request = new SetRequest(getHost().resolveSemanticElement(),
				StatechartPackage.Literals.TRANSITION__EXPRESSION,
				rootASTElement);
		return new ICommandProxy(new SetValueCommand(request));
	}

	@Override
	public TransitionExpressionEditPart getHost() {
		return (TransitionExpressionEditPart) super.getHost();
	}


}
