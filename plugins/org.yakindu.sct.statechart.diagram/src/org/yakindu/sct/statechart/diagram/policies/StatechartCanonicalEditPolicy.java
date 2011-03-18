package org.yakindu.sct.statechart.diagram.policies;

import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.model.sct.statechart.Region;
import org.yakindu.model.sct.statechart.Statechart;
import org.yakindu.sct.statechart.diagram.providers.SemanticHints;

/**
 * 
 * @author muelder
 * 
 */
public class StatechartCanonicalEditPolicy extends CanonicalEditPolicy {

	@Override
	protected List<Region> getSemanticChildrenList() {
		return getSemanticHost().getRegions();
	}

	@Override
	public Statechart getSemanticHost() {
		return (Statechart) super.getSemanticHost();
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

	@Override
	protected boolean shouldDeleteView(View view) {
		// We do not want to delete the fixed Text compartment view
		if (SemanticHints.STATECHART_TEXT.equals(view.getType())) {
			return false;
		}
		return true;
	}

}
