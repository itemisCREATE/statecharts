package org.yakindu.sct.examples.java.trafficlight;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;

public class TrafficLightFigure extends Figure {

	private boolean red = false;
	private boolean yellow = false;
	private boolean green = false;

	public boolean isRed() {
		return red;
	}

	public void setRed(boolean red) {
		this.red = red;
	}

	public boolean isYellow() {
		return yellow;
	}

	public void setYellow(boolean yellow) {
		this.yellow = yellow;
	}

	public boolean isGreen() {
		return green;
	}

	public void setGreen(boolean green) {
		this.green = green;
	}

	@Override
	protected void paintFigure(Graphics graphics) {
		Rectangle bounds = getBounds().getShrinked(new Insets(10, 10, 10, 10));

		graphics.setBackgroundColor(ColorConstants.darkGray);
		graphics.fillRectangle(getBounds());

		graphics.setBackgroundColor(red ? ColorConstants.red
				: ColorConstants.black);
		graphics.fillOval(bounds.x, bounds.y, bounds.height / 5,
				bounds.height / 5);

		graphics.setBackgroundColor(yellow ? ColorConstants.yellow
				: ColorConstants.black);
		graphics.fillOval(bounds.x, bounds.y + 2 * bounds.height / 5,
				bounds.height / 5, bounds.height / 5);

		graphics.setBackgroundColor(green ? ColorConstants.green
				: ColorConstants.black);
		graphics.fillOval(bounds.x, bounds.y + 4 * bounds.height / 5,
				bounds.height / 5, bounds.height / 5);
	}
}
