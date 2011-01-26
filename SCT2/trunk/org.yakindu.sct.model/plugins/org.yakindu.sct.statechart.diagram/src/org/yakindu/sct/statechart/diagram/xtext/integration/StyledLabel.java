package org.yakindu.sct.statechart.diagram.xtext.integration;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.widgets.Display;

/**
 * 
 * @author muelder
 * 
 */
public class StyledLabel extends LabelEx {

	private StyleRange[] ranges = new StyleRange[0];

	private Image image;

	public StyleRange[] getRanges() {
		return ranges;
	}

	public void setRanges(StyleRange[] ranges) {
		this.ranges = ranges;
	}

	protected void updateImage(Graphics graphics) {
		Rectangle bounds = getBounds(); 
		if (bounds.width <= 0 || bounds.height <= 0)
			return;
		TextLayout layout = new TextLayout(Display.getDefault());
		layout.setFont(getFont());
		layout.setText(getText());
		for (StyleRange styleRange : ranges) {
			styleRange.background = ColorConstants.white;
			layout.setStyle(styleRange, styleRange.start, styleRange.start
					+ styleRange.length);
		}
		if (image != null && !image.isDisposed()) {
			image.dispose();
		}
		image = new Image(Display.getDefault(), bounds.width,
				bounds.height);
		GC gc = new GC(image);
		gc.fillRectangle(image.getBounds());
		layout.draw(gc, 0, 0);
		layout.dispose();
		gc.dispose();
	}


	protected void paintFigure(Graphics graphics) {
		Rectangle bounds = getBounds();
		graphics.translate(bounds.x, bounds.y);
		updateImage(graphics);
		
		if (image == null || ranges == null || ranges.length == 0 || isOpaque()) {
			super.paintFigure(graphics);
			return;
		}
				
		if (getIcon() != null)
			graphics.drawImage(getIcon(), getIconLocation());
		if (!isEnabled()) {
			graphics.translate(1, 1);
			graphics.drawImage(image, getTextLocation());
			graphics.translate(-1, -1);
		}
		graphics.drawImage(image, getTextLocation());
		graphics.translate(-bounds.x, -bounds.y);
	}
}
