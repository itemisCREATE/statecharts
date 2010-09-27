package org.yakindu.sct.statechart.diagram.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.statechart.diagram.providers.ProviderConstants;

public class StateViewFactory extends AbstractShapeViewFactory {

	@Override
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint,
			int index, boolean persisted) {
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		IAdaptable eObjectAdapter = null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			eObjectAdapter = new EObjectAdapter(eObject);
		}
		getViewService().createNode(eObjectAdapter, view, ProviderConstants.STATE_COMPARTMENT, ViewUtil.APPEND, true,
				getPreferencesHint());
	}
}
