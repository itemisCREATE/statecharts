package org.yakindu.sct.statechart.diagram.editor.figures;

import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

public class TransitionFigure extends PolylineConnectionEx {

	private final IMapMode mapMode;

	public TransitionFigure(IMapMode mapMode) {
		this.mapMode = mapMode;
		setTargetDecoration(createTargetDecoration());
		setSmoothness(SMOOTH_NORMAL);
		setLineWidth(mapMode.DPtoLP(1));
	}

	private RotatableDecoration createTargetDecoration() {
		PolylineDecoration df = new PolylineDecoration();
		df.setLineWidth(mapMode.DPtoLP(1));
		int wMapped = mapMode.DPtoLP(1);
		df.setScale(8 * wMapped, 2.0 * wMapped);
		return df;

	}

}
