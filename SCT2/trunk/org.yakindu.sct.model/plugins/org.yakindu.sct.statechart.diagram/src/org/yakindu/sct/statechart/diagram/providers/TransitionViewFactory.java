package org.yakindu.sct.statechart.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

public class TransitionViewFactory extends ConnectionViewFactory {

	@Override
	protected Edge createEdge() {
		return super.createEdge();
	}
	
	@Override
	public View createView(IAdaptable semanticAdapter, View containerView,
			String semanticHint, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		System.out.println(semanticAdapter + " " + containerView + " " + semanticHint + " ");
		return super.createView(semanticAdapter, containerView, semanticHint, index,
				persisted, preferencesHint);
	}

}
