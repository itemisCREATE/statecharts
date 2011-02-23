package org.yakindu.sct.statechart.diagram.policies;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.yakindu.model.sct.statechart.State;
import org.yakindu.sct.statechart.diagram.utils.SemanticHintUtil;

/**
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 */
public class StateCompartmentCanonicalEditPolicy extends CanonicalEditPolicy {

	@SuppressWarnings("rawtypes")
	@Override
	protected List getSemanticChildrenList() {
		return getSemanticHost().getSubRegions();
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
		EObject modelElement = (EObject) elementAdapter.getAdapter(EObject.class);
		String factoryHint =  SemanticHintUtil.getSemanticHint(modelElement);
		return factoryHint;
	}
}
