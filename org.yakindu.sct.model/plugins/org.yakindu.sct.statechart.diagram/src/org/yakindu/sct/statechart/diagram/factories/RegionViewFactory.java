package org.yakindu.sct.statechart.diagram.factories;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.statechart.diagram.providers.ProviderConstants;

/**
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class RegionViewFactory extends AbstractShapeViewFactory {

	@Override
	protected void decorateView(View containerView, View view,
			IAdaptable semanticAdapter, String semanticHint, int index,
			boolean persisted) {

		super.decorateView(containerView, view, semanticAdapter, semanticHint,
				index, persisted);

		IAdaptable eObjectAdapter = null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			eObjectAdapter = new EObjectAdapter(eObject);
		}
		FactoryUtils.createLabel(view, ProviderConstants.REGION_NAME);

		getViewService().createNode(eObjectAdapter, view,
				ProviderConstants.REGION_COMPARTMENT, ViewUtil.APPEND, true,
				getPreferencesHint());
	}

	@Override
	protected List<Style> createStyles(View view) {
		ShapeStyle style = NotationFactory.eINSTANCE.createShapeStyle();
		style.setLineColor(FigureUtilities.RGBToInteger(ColorConstants.darkGray
				.getRGB()));
		return Collections.singletonList((Style) style);
	}

}
