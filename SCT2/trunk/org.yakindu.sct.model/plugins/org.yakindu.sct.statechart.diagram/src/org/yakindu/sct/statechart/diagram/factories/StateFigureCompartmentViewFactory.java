package org.yakindu.sct.statechart.diagram.factories;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.optimal.CompartmentViewFactory;
import org.eclipse.gmf.runtime.notation.Compartment;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.Ratio;
import org.eclipse.gmf.runtime.notation.View;

public class StateFigureCompartmentViewFactory extends CompartmentViewFactory {

	@Override
	protected void decorateView(View containerView, View view,
			IAdaptable semanticAdapter, String semanticHint, int index,
			boolean persisted) {
		super.decorateView(containerView, view, semanticAdapter, semanticHint,
				index, persisted);

		Assert.isTrue(view instanceof Compartment);
	}

	@Override
	protected LayoutConstraint createLayoutConstraint() {
		Ratio ratio = NotationFactory.eINSTANCE.createRatio();
		ratio.setValue(0.5);
		return ratio;
	}
	
}
