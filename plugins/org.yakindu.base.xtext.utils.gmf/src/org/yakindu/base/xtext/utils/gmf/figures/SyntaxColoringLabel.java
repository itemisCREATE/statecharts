/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.xtext.utils.gmf.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SyntaxColoringLabel extends WrappingLabel implements MouseMotionListener {

	private static final MarginBorder NO_FOCUS_BORDER = new MarginBorder(new Insets(1, 1, 1, 1));
	private static final LineBorder FOCUS_BORDER = new LineBorder(ColorConstants.lightGray);
	private StyledTextFlow textFlow;

	public SyntaxColoringLabel() {
		setBorder(NO_FOCUS_BORDER);
		addMouseMotionListener(this);
		setTextFlow();
	}

	@SuppressWarnings("unchecked")
	protected void setTextFlow() {
		textFlow = new StyledTextFlow();
		textFlow.setParent(getTextFigure());
		getTextFigure().getChildren().set(0, textFlow);
		setLayoutManager(textFlow, false);
	}

	public void setRanges(StyleRange[] ranges) {
		textFlow.setRanges(ranges);
	}

	public void mouseEntered(MouseEvent me) {
		setBorder(FOCUS_BORDER);
	}

	public void mouseExited(MouseEvent me) {
		setBorder(NO_FOCUS_BORDER);
	}

	public void mouseDragged(MouseEvent me) {
		// Nothing to do
	}

	public void mouseHover(MouseEvent me) {
		// Nothing to do
	}

	public void mouseMoved(MouseEvent me) {
		// Nothing to do
	}

	protected static class StyledTextFlow extends TextFlowEx {

		private static final Image dummy = new Image(Display.getDefault(), 1, 1);
		private static final GC gc = new GC(dummy);

		private StyleRange[] ranges = new StyleRange[0];

		public StyleRange[] getRanges() {
			return ranges;
		}

		public void setRanges(StyleRange[] ranges) {
			this.ranges = ranges;
		}

		@Override
		protected void paintText(Graphics g, String draw, int x, int y, int bidiLevel) {
			// hack to avoid tab expansion to 8 spaces
			draw = draw.replaceAll("\t", "    ");
			if (ranges.length == 0) {
				super.paintText(g, draw, x, y, bidiLevel);
				return;
			}
			if (bidiLevel == -1) {
				int paintOffset = 0;
				int lineOffset = getText().indexOf(draw);
				try {
					g.pushState();
					g.setFont(getFont());
					for (StyleRange range : ranges) {
						int beginIndex = range.start - lineOffset;
						if (beginIndex > draw.length()) {
							continue;
						}
						if (range.fontStyle != SWT.NORMAL) {
							FontDescriptor boldDescriptor = FontDescriptor.createFrom(getFont())
									.setStyle(range.fontStyle);
							Font newfont = boldDescriptor.createFont(Display.getDefault());
							g.setFont(newfont);
						}
						g.setForegroundColor(range.foreground != null ? range.foreground : getForegroundColor());
						g.setBackgroundColor(range.background != null ? range.background : getBackgroundColor());
						int endIndex = beginIndex + range.length;
						String substring = draw.substring(beginIndex > 0 ? beginIndex : 0,
								Math.min(endIndex > 0 ? endIndex : 0, draw.length()));
						g.drawString(substring, x + paintOffset, y);
						int offset = getTextExtend(g.getFont(), substring);
						paintOffset += offset;
						if (range.fontStyle != SWT.NORMAL) {
							g.getFont().dispose();
							g.setFont(getFont());
						}
					}
				} finally {
					g.popState();
				}
			} else {
				super.paintText(g, draw, x, y, bidiLevel);
			}
		}

		protected int getTextExtend(Font font, String string) {
			gc.setFont(font);
			int offset = gc.textExtent(string).x;
			return offset;
		}
	}

}
