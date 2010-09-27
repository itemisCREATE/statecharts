package org.yakindu.sct.statechart.diagram.editor.figures;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

public class FinalStateFigure extends Ellipse {

	protected IMapMode mapMode;

	public FinalStateFigure() {
		BorderLayout myGenLayoutManager = new BorderLayout();
		this.setLayoutManager(myGenLayoutManager);
		this.setOutline(false);
		this.setLineWidth(0);
		this.setSize(new Dimension(20, 20));
		this.setBackgroundColor(org.eclipse.draw2d.ColorConstants.black);
		this.setForegroundColor(org.eclipse.draw2d.ColorConstants.black);
		this.setBorder(new org.eclipse.draw2d.MarginBorder(2, 2, 2, 2));
	}
}
