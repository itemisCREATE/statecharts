package org.yakindu.sct.statechart.diagram.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;
import org.yakindu.sct.statechart.diagram.editparts.StateEditPart;

public class StatePrimaryDragEditPolicy extends ResizableEditPolicyEx {

	@Override
	protected Command getResizeCommand(ChangeBoundsRequest request) {
		ChangeBoundsRequest req = new ChangeBoundsRequest(REQ_RESIZE_CHILDREN);
		req.setEditParts(getHost());

		req.setMoveDelta(request.getMoveDelta());
		req.setSizeDelta(request.getSizeDelta());
		req.setLocation(request.getLocation());
		req.setExtendedData(request.getExtendedData());
		req.setResizeDirection(request.getResizeDirection());
		return getHost().getParent().getCommand(req);
		
//		List<Compartment> notationCompartmentChildren = getHost().getNotationCompartmentChildren();
//		for (Compartment compartment : notationCompartmentChildren) {
//			Double ratio = (Double) ViewUtil.getStructuralFeatureValue(
//					compartment,
//					NotationPackage.eINSTANCE.getRatio_Value());
//		}
	}
	
	@Override
	public StateEditPart getHost() {
		return (StateEditPart) super.getHost();
	}
}
