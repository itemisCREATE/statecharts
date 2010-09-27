package org.yakindu.sct.statechart.diagram.policies;

import static org.yakindu.sct.statechart.diagram.providers.ProviderConstants.REGION;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.yakindu.sct.model.statechart.statechart.State;

/**
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 */
public class StateCanonicalEditPolicy extends CanonicalEditPolicy {

	@Override
	protected List getSemanticChildrenList() {
		return getSemanticHost().getRegions();
	}

	@Override
	public State getSemanticHost() {
		return (State) super.getSemanticHost();
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

	@Override
	protected String getFactoryHint(IAdaptable elementAdapter) {
		return REGION;
	}
}
