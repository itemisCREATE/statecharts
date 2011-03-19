package org.yakindu.sct.statechart.diagram.editor.figures.utils;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

public final class MapModeUtils {

	private MapModeUtils() {
	}

	
	private static final int DEFAULT_NODE_WIDTH = 40;
	private static final int DEFAULT_NODE_HEIGHT = 40;

	public static Dimension getDefaultSizeDimension(IMapMode mode) {
		return new Dimension(mode.DPtoLP(DEFAULT_NODE_WIDTH), mode.DPtoLP(DEFAULT_NODE_HEIGHT));
	}


	public static final Dimension DEFAULT_SMALL_NODE_DIMENSION = new Dimension(15, 15);

	public static Dimension getMappedDimensions(IMapMode mode, Dimension d) {
		return new Dimension(mode.DPtoLP(d.width), mode.DPtoLP(d.height));
	}
}

