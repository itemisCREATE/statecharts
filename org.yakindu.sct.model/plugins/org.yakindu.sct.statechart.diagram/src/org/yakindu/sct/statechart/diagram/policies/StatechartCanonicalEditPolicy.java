package org.yakindu.sct.statechart.diagram.policies;

import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.yakindu.sct.model.statechart.statechart.Region;
import org.yakindu.sct.model.statechart.statechart.Statechart;

/**
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
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

}
