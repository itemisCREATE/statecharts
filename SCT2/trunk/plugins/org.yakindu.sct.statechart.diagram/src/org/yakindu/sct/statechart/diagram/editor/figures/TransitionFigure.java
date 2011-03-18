package org.yakindu.sct.statechart.diagram.editor.figures;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
/**
 * 
 * @author muelder
 *
 */
public class TransitionFigure extends PolylineConnectionEx {

	private final IMapMode mapMode;

	public TransitionFigure(IMapMode mapMode) {
		this.mapMode = mapMode;
		setLineWidth(mapMode.DPtoLP(1));
		setTargetDecoration(createTargetDecoration());
	}
	protected IMapMode getMapMode() {
		return mapMode;
	}

	private RotatableDecoration createTargetDecoration() {
		PolygonDecoration df = new PolygonDecoration();
		df.setFill(true);
		df.setLineWidth(getMapMode().DPtoLP(1));
		PointList pl = new PointList();
		pl.addPoint(getMapMode().DPtoLP(-2), getMapMode().DPtoLP(-1));
		pl.addPoint(getMapMode().DPtoLP(-2), getMapMode().DPtoLP(1));
		pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0));
		df.setTemplate(pl);
		return df;
	}
}
