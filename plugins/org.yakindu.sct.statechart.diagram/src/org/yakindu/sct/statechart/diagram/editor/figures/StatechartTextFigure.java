package org.yakindu.sct.statechart.diagram.editor.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.yakindu.sct.statechart.diagram.editor.figures.utils.GridDataFactory;

public class StatechartTextFigure extends RoundedRectangle {

	private WrappingLabel title;
	private Figure compartment;

	public StatechartTextFigure(IMapMode mapMode) {
		GridLayout layout = new GridLayout(1, false);
		this.setLayoutManager(layout);
		this.setCornerDimensions(new Dimension(mapMode.DPtoLP(20), mapMode
				.DPtoLP(20)));
		this.setOutline(true);
		createContents();
	}

	private void createContents() {
		// Name Label
		title = new WrappingLabel();
		title.setAlignment(PositionConstants.CENTER);
		title.setText("Events and Variables");
		this.add(title, GridDataFactory.fillDefaults().grab(true, false)
				.getData());
		// Text compartment
		compartment = new Figure();
		this.add(compartment, GridDataFactory.fillDefaults().grab(true, true)
				.getData());
	}

	public Figure getCompartment() {
		return compartment;
	}

}
